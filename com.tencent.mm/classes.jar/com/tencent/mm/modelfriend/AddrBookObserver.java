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
import com.tencent.mm.am.s;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.a;
import com.tencent.mm.plugin.account.friend.model.al;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.account.sdk.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.service.MMService;
import java.util.Random;

public final class AddrBookObserver
  extends ContentObserver
{
  private static MMHandler handler;
  private static boolean mpH;
  private static Intent oDy;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(127661);
    mpH = false;
    handler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(127655);
        super.handleMessage(paramAnonymousMessage);
        paramAnonymousMessage = (Context)paramAnonymousMessage.obj;
        if (AddrBookObserver.bIN() == null)
        {
          AddrBookObserver.x(new Intent());
          AddrBookObserver.bIN().setClass(paramAnonymousMessage, AddrBookObserver.AddrBookService.class);
        }
        float f = new Random(System.currentTimeMillis()).nextFloat();
        AddrBookObserver.bIN().putExtra(AddrBookObserver.AddrBookService.oDz, f);
        try
        {
          Log.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", new Object[] { Float.valueOf(f) });
          c.startService(AddrBookObserver.bIN());
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
    if ((mpH) || (!i.bWZ()))
    {
      Log.e("MicroMsg.AddrBookObserver", "isSyncing:" + mpH + ", is time to sync:" + i.bWZ() + " , return");
      AppMethodBeat.o(127660);
      return;
    }
    handler.removeMessages(0);
    Message localMessage = handler.obtainMessage();
    localMessage.obj = this.context;
    localMessage.what = 0;
    handler.sendMessageDelayed(localMessage, 10000L);
    AppMethodBeat.o(127660);
  }
  
  public static class AddrBookService
    extends MMService
  {
    public static boolean isCanceled = false;
    public static boolean mpH = false;
    public static String oDz = "key_sync_session";
    private b oDA;
    
    public AddrBookService()
    {
      AppMethodBeat.i(127657);
      this.oDA = new b()
      {
        public final void hi(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(127656);
          if (!paramAnonymousBoolean)
          {
            Log.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
            AddrBookObserver.AddrBookService.this.stopSelf();
            AddrBookObserver.AddrBookService.mpH = false;
            AppMethodBeat.o(127656);
            return;
          }
          System.currentTimeMillis();
          i.bXa();
          al localal = new al(i.bXe(), i.bXd());
          h.aZW().a(localal, 0);
          AddrBookObserver.AddrBookService.this.stopSelf();
          AddrBookObserver.AddrBookService.mpH = false;
          AppMethodBeat.o(127656);
        }
      };
      AppMethodBeat.o(127657);
    }
    
    public final IBinder aKF()
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
      float f1 = paramIntent.getFloatExtra(oDz, -1.0F);
      if (f1 == -1.0F)
      {
        Log.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      paramIntent = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      float f2 = paramIntent.getFloat(oDz, 0.0F);
      if (f2 == f1)
      {
        Log.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", new Object[] { Float.valueOf(f2) });
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      paramIntent.edit().putFloat(oDz, f1).commit();
      Log.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", new Object[] { Float.valueOf(f1) });
      if (isCanceled)
      {
        Log.i("MicroMsg.AddrBookObserver", "service canceled");
        isCanceled = false;
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      try
      {
        if (!h.baz())
        {
          Log.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
          stopSelf();
          AppMethodBeat.o(127658);
          return 2;
        }
        if ((i.bWY()) && (!i.bWV()))
        {
          Log.i("MicroMsg.AddrBookObserver", "mark addr book had update.");
          a.bTm();
          stopSelf();
          AppMethodBeat.o(127658);
          return 2;
        }
        Log.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
        stopSelf();
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AddrBookObserver", paramIntent, "", new Object[0]);
          Log.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", new Object[] { paramIntent.getMessage() });
          stopSelf();
        }
      }
      AppMethodBeat.o(127658);
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver
 * JD-Core Version:    0.7.0.1
 */