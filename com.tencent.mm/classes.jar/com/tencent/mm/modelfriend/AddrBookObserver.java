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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.m.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.service.MMService;
import java.util.Random;

public final class AddrBookObserver
  extends ContentObserver
{
  private static boolean hEi;
  private static Intent hEj;
  private static com.tencent.mm.sdk.platformtools.ao handler;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(127661);
    hEi = false;
    handler = new com.tencent.mm.sdk.platformtools.ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(127655);
        super.handleMessage(paramAnonymousMessage);
        paramAnonymousMessage = (Context)paramAnonymousMessage.obj;
        if (AddrBookObserver.aEp() == null)
        {
          AddrBookObserver.v(new Intent());
          AddrBookObserver.aEp().setClass(paramAnonymousMessage, AddrBookObserver.AddrBookService.class);
        }
        float f = new Random(System.currentTimeMillis()).nextFloat();
        AddrBookObserver.aEp().putExtra(AddrBookObserver.AddrBookService.hEk, f);
        try
        {
          ac.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", new Object[] { Float.valueOf(f) });
          d.aZ(AddrBookObserver.aEp());
          AppMethodBeat.o(127655);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          ac.printErrStackTrace("MicroMsg.AddrBookObserver", paramAnonymousMessage, "startService failed", new Object[0]);
          AppMethodBeat.o(127655);
        }
      }
    };
    AppMethodBeat.o(127661);
  }
  
  public AddrBookObserver(Context paramContext)
  {
    super(com.tencent.mm.sdk.platformtools.ao.createFreeHandler(Looper.myLooper()));
    AppMethodBeat.i(127659);
    this.context = paramContext;
    AppMethodBeat.o(127659);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(127660);
    super.onChange(paramBoolean);
    ac.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
    if (!hEi)
    {
      l.aPG();
      handler.removeMessages(0);
      Message localMessage = handler.obtainMessage();
      localMessage.obj = this.context;
      localMessage.what = 0;
      handler.sendMessageDelayed(localMessage, 20000L);
      AppMethodBeat.o(127660);
      return;
    }
    ac.e("MicroMsg.AddrBookObserver", "isSyncing:" + hEi + ", is time to sync:" + l.aPG() + " , return");
    AppMethodBeat.o(127660);
  }
  
  public static class AddrBookService
    extends MMService
  {
    public static boolean hEi = false;
    public static String hEk = "key_sync_session";
    public static boolean isCanceled = false;
    private b hEl;
    
    public AddrBookService()
    {
      AppMethodBeat.i(127657);
      this.hEl = new b()
      {
        public final void eM(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(127656);
          if (!paramAnonymousBoolean)
          {
            ac.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
            AddrBookObserver.AddrBookService.this.stopSelf();
            AddrBookObserver.AddrBookService.hEi = false;
            AppMethodBeat.o(127656);
            return;
          }
          System.currentTimeMillis();
          l.aPH();
          com.tencent.mm.plugin.account.friend.a.ao localao = new com.tencent.mm.plugin.account.friend.a.ao(l.aPL(), l.aPK());
          com.tencent.mm.kernel.g.agi().a(localao, 0);
          AddrBookObserver.AddrBookService.this.stopSelf();
          AddrBookObserver.AddrBookService.hEi = false;
          AppMethodBeat.o(127656);
        }
      };
      AppMethodBeat.o(127657);
    }
    
    public final IBinder Uz()
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
        ac.i("MicroMsg.AddrBookObserver", "service start intent:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramIntent != null) {
          break;
        }
        ac.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      float f1 = paramIntent.getFloatExtra(hEk, -1.0F);
      if (f1 == -1.0F)
      {
        ac.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      paramIntent = ai.getContext().getSharedPreferences(ai.eUX(), 0);
      float f2 = paramIntent.getFloat(hEk, 0.0F);
      if (f2 == f1)
      {
        ac.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", new Object[] { Float.valueOf(f2) });
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      paramIntent.edit().putFloat(hEk, f1).commit();
      ac.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", new Object[] { Float.valueOf(f1) });
      if (isCanceled)
      {
        ac.i("MicroMsg.AddrBookObserver", "service canceled");
        isCanceled = false;
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      for (;;)
      {
        try
        {
          if (!com.tencent.mm.kernel.g.agM())
          {
            ac.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
            stopSelf();
            AppMethodBeat.o(127658);
            return 2;
          }
          if (com.tencent.mm.m.g.ZY().getInt("WCOEntranceSwitch", 0) > 0)
          {
            paramIntent = new ka();
            com.tencent.mm.sdk.b.a.GpY.l(paramIntent);
          }
          if ((!l.aPF()) || (l.aPB())) {
            continue;
          }
          ac.i("MicroMsg.AddrBookObserver", "start sync");
          if (t.da(ai.getContext())) {
            continue;
          }
          hEi = true;
          com.tencent.mm.platformtools.a.syncAddrBook(this.hEl);
        }
        catch (Exception paramIntent)
        {
          ac.printErrStackTrace("MicroMsg.AddrBookObserver", paramIntent, "", new Object[0]);
          ac.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", new Object[] { paramIntent.getMessage() });
          stopSelf();
          continue;
        }
        AppMethodBeat.o(127658);
        return 2;
        ac.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
        ac.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
        stopSelf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver
 * JD-Core Version:    0.7.0.1
 */