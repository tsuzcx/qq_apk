package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.a;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.service.MMService;
import java.util.Random;

public final class AddrBookObserver
  extends ContentObserver
{
  private static MMHandler handler;
  private static boolean iUD;
  private static Intent iUE;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(127661);
    iUD = false;
    handler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(127655);
        super.handleMessage(paramAnonymousMessage);
        paramAnonymousMessage = (Context)paramAnonymousMessage.obj;
        if (AddrBookObserver.bbE() == null)
        {
          AddrBookObserver.v(new Intent());
          AddrBookObserver.bbE().setClass(paramAnonymousMessage, AddrBookObserver.AddrBookService.class);
        }
        float f = new Random(System.currentTimeMillis()).nextFloat();
        AddrBookObserver.bbE().putExtra(AddrBookObserver.AddrBookService.iUF, f);
        try
        {
          Log.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", new Object[] { Float.valueOf(f) });
          c.startService(AddrBookObserver.bbE());
          AppMethodBeat.o(127655);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          Log.printErrStackTrace("MicroMsg.AddrBookObserver", paramAnonymousMessage, "startService failed", new Object[0]);
          AppMethodBeat.o(127655);
        }
      }
    };
    AppMethodBeat.o(127661);
  }
  
  public AddrBookObserver(Context paramContext)
  {
    super(MMHandler.createFreeHandler(Looper.myLooper()));
    AppMethodBeat.i(127659);
    this.context = paramContext;
    AppMethodBeat.o(127659);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(127660);
    super.onChange(paramBoolean);
    Log.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
    if (!iUD)
    {
      l.bod();
      handler.removeMessages(0);
      Message localMessage = handler.obtainMessage();
      localMessage.obj = this.context;
      localMessage.what = 0;
      handler.sendMessageDelayed(localMessage, 20000L);
      AppMethodBeat.o(127660);
      return;
    }
    Log.e("MicroMsg.AddrBookObserver", "isSyncing:" + iUD + ", is time to sync:" + l.bod() + " , return");
    AppMethodBeat.o(127660);
  }
  
  public static class AddrBookService
    extends MMService
  {
    public static boolean iUD = false;
    public static String iUF = "key_sync_session";
    public static boolean isCanceled = false;
    private b iUG;
    
    public AddrBookService()
    {
      AppMethodBeat.i(127657);
      this.iUG = new b()
      {
        public final void fG(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(127656);
          if (!paramAnonymousBoolean)
          {
            Log.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
            AddrBookObserver.AddrBookService.this.stopSelf();
            AddrBookObserver.AddrBookService.iUD = false;
            AppMethodBeat.o(127656);
            return;
          }
          System.currentTimeMillis();
          l.boe();
          ao localao = new ao(l.boi(), l.boh());
          g.azz().a(localao, 0);
          AddrBookObserver.AddrBookService.this.stopSelf();
          AddrBookObserver.AddrBookService.iUD = false;
          AppMethodBeat.o(127656);
        }
      };
      AppMethodBeat.o(127657);
    }
    
    public final IBinder akL()
    {
      return null;
    }
    
    public final String getTag()
    {
      return "MicroMsg.AddrBookObserver";
    }
    
    public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(127658);
      super.onStartCommand(paramIntent, paramInt1, paramInt2);
      if (paramIntent == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AddrBookObserver", "service start intent:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramIntent != null) {
          break;
        }
        Log.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      float f1 = paramIntent.getFloatExtra(iUF, -1.0F);
      if (f1 == -1.0F)
      {
        Log.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      paramIntent = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      float f2 = paramIntent.getFloat(iUF, 0.0F);
      if (f2 == f1)
      {
        Log.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", new Object[] { Float.valueOf(f2) });
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      paramIntent.edit().putFloat(iUF, f1).commit();
      Log.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", new Object[] { Float.valueOf(f1) });
      if (isCanceled)
      {
        Log.i("MicroMsg.AddrBookObserver", "service canceled");
        isCanceled = false;
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      for (;;)
      {
        try
        {
          if (!g.aAc())
          {
            Log.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
            stopSelf();
            AppMethodBeat.o(127658);
            return 2;
          }
          if (h.aqJ().getInt("WCOEntranceSwitch", 0) > 0)
          {
            paramIntent = new ky();
            EventCenter.instance.publish(paramIntent);
          }
          if ((!l.boc()) || (l.bnY())) {
            continue;
          }
          Log.i("MicroMsg.AddrBookObserver", "start sync");
          if (com.tencent.mm.platformtools.t.dv(MMApplicationContext.getContext())) {
            continue;
          }
          iUD = true;
          a.syncAddrBook(this.iUG);
        }
        catch (Exception paramIntent)
        {
          Log.printErrStackTrace("MicroMsg.AddrBookObserver", paramIntent, "", new Object[0]);
          Log.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", new Object[] { paramIntent.getMessage() });
          stopSelf();
          continue;
        }
        AppMethodBeat.o(127658);
        return 2;
        Log.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
        Log.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
        stopSelf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver
 * JD-Core Version:    0.7.0.1
 */