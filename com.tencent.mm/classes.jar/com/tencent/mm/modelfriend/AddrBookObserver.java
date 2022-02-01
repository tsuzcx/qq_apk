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
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.n.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.service.MMService;
import java.util.Random;

public final class AddrBookObserver
  extends ContentObserver
{
  private static boolean hWN;
  private static Intent hWO;
  private static ap handler;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(127661);
    hWN = false;
    handler = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(127655);
        super.handleMessage(paramAnonymousMessage);
        paramAnonymousMessage = (Context)paramAnonymousMessage.obj;
        if (AddrBookObserver.aHu() == null)
        {
          AddrBookObserver.v(new Intent());
          AddrBookObserver.aHu().setClass(paramAnonymousMessage, AddrBookObserver.AddrBookService.class);
        }
        float f = new Random(System.currentTimeMillis()).nextFloat();
        AddrBookObserver.aHu().putExtra(AddrBookObserver.AddrBookService.hWP, f);
        try
        {
          ad.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", new Object[] { Float.valueOf(f) });
          d.be(AddrBookObserver.aHu());
          AppMethodBeat.o(127655);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          ad.printErrStackTrace("MicroMsg.AddrBookObserver", paramAnonymousMessage, "startService failed", new Object[0]);
          AppMethodBeat.o(127655);
        }
      }
    };
    AppMethodBeat.o(127661);
  }
  
  public AddrBookObserver(Context paramContext)
  {
    super(ap.createFreeHandler(Looper.myLooper()));
    AppMethodBeat.i(127659);
    this.context = paramContext;
    AppMethodBeat.o(127659);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(127660);
    super.onChange(paramBoolean);
    ad.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
    if (!hWN)
    {
      l.aSS();
      handler.removeMessages(0);
      Message localMessage = handler.obtainMessage();
      localMessage.obj = this.context;
      localMessage.what = 0;
      handler.sendMessageDelayed(localMessage, 20000L);
      AppMethodBeat.o(127660);
      return;
    }
    ad.e("MicroMsg.AddrBookObserver", "isSyncing:" + hWN + ", is time to sync:" + l.aSS() + " , return");
    AppMethodBeat.o(127660);
  }
  
  public static class AddrBookService
    extends MMService
  {
    public static boolean hWN = false;
    public static String hWP = "key_sync_session";
    public static boolean isCanceled = false;
    private b hWQ;
    
    public AddrBookService()
    {
      AppMethodBeat.i(127657);
      this.hWQ = new b()
      {
        public final void eO(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(127656);
          if (!paramAnonymousBoolean)
          {
            ad.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
            AddrBookObserver.AddrBookService.this.stopSelf();
            AddrBookObserver.AddrBookService.hWN = false;
            AppMethodBeat.o(127656);
            return;
          }
          System.currentTimeMillis();
          l.aST();
          ao localao = new ao(l.aSX(), l.aSW());
          com.tencent.mm.kernel.g.aiU().a(localao, 0);
          AddrBookObserver.AddrBookService.this.stopSelf();
          AddrBookObserver.AddrBookService.hWN = false;
          AppMethodBeat.o(127656);
        }
      };
      AppMethodBeat.o(127657);
    }
    
    public final IBinder WQ()
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
        ad.i("MicroMsg.AddrBookObserver", "service start intent:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramIntent != null) {
          break;
        }
        ad.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      float f1 = paramIntent.getFloatExtra(hWP, -1.0F);
      if (f1 == -1.0F)
      {
        ad.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      paramIntent = aj.getContext().getSharedPreferences(aj.fkC(), 0);
      float f2 = paramIntent.getFloat(hWP, 0.0F);
      if (f2 == f1)
      {
        ad.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", new Object[] { Float.valueOf(f2) });
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      paramIntent.edit().putFloat(hWP, f1).commit();
      ad.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", new Object[] { Float.valueOf(f1) });
      if (isCanceled)
      {
        ad.i("MicroMsg.AddrBookObserver", "service canceled");
        isCanceled = false;
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      for (;;)
      {
        try
        {
          if (!com.tencent.mm.kernel.g.ajx())
          {
            ad.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
            stopSelf();
            AppMethodBeat.o(127658);
            return 2;
          }
          if (com.tencent.mm.n.g.acA().getInt("WCOEntranceSwitch", 0) > 0)
          {
            paramIntent = new ki();
            com.tencent.mm.sdk.b.a.IbL.l(paramIntent);
          }
          if ((!l.aSR()) || (l.aSN())) {
            continue;
          }
          ad.i("MicroMsg.AddrBookObserver", "start sync");
          if (t.cY(aj.getContext())) {
            continue;
          }
          hWN = true;
          com.tencent.mm.platformtools.a.syncAddrBook(this.hWQ);
        }
        catch (Exception paramIntent)
        {
          ad.printErrStackTrace("MicroMsg.AddrBookObserver", paramIntent, "", new Object[0]);
          ad.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", new Object[] { paramIntent.getMessage() });
          stopSelf();
          continue;
        }
        AppMethodBeat.o(127658);
        return 2;
        ad.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
        ad.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
        stopSelf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver
 * JD-Core Version:    0.7.0.1
 */