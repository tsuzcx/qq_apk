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
import com.tencent.mm.g.a.kj;
import com.tencent.mm.n.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.service.MMService;
import java.util.Random;

public final class AddrBookObserver
  extends ContentObserver
{
  private static boolean hZF;
  private static Intent hZG;
  private static aq handler;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(127661);
    hZF = false;
    handler = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(127655);
        super.handleMessage(paramAnonymousMessage);
        paramAnonymousMessage = (Context)paramAnonymousMessage.obj;
        if (AddrBookObserver.aHL() == null)
        {
          AddrBookObserver.v(new Intent());
          AddrBookObserver.aHL().setClass(paramAnonymousMessage, AddrBookObserver.AddrBookService.class);
        }
        float f = new Random(System.currentTimeMillis()).nextFloat();
        AddrBookObserver.aHL().putExtra(AddrBookObserver.AddrBookService.hZH, f);
        try
        {
          ae.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", new Object[] { Float.valueOf(f) });
          d.bf(AddrBookObserver.aHL());
          AppMethodBeat.o(127655);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          ae.printErrStackTrace("MicroMsg.AddrBookObserver", paramAnonymousMessage, "startService failed", new Object[0]);
          AppMethodBeat.o(127655);
        }
      }
    };
    AppMethodBeat.o(127661);
  }
  
  public AddrBookObserver(Context paramContext)
  {
    super(aq.createFreeHandler(Looper.myLooper()));
    AppMethodBeat.i(127659);
    this.context = paramContext;
    AppMethodBeat.o(127659);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(127660);
    super.onChange(paramBoolean);
    ae.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
    if (!hZF)
    {
      l.aTr();
      handler.removeMessages(0);
      Message localMessage = handler.obtainMessage();
      localMessage.obj = this.context;
      localMessage.what = 0;
      handler.sendMessageDelayed(localMessage, 20000L);
      AppMethodBeat.o(127660);
      return;
    }
    ae.e("MicroMsg.AddrBookObserver", "isSyncing:" + hZF + ", is time to sync:" + l.aTr() + " , return");
    AppMethodBeat.o(127660);
  }
  
  public static class AddrBookService
    extends MMService
  {
    public static boolean hZF = false;
    public static String hZH = "key_sync_session";
    public static boolean isCanceled = false;
    private b hZI;
    
    public AddrBookService()
    {
      AppMethodBeat.i(127657);
      this.hZI = new b()
      {
        public final void eQ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(127656);
          if (!paramAnonymousBoolean)
          {
            ae.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
            AddrBookObserver.AddrBookService.this.stopSelf();
            AddrBookObserver.AddrBookService.hZF = false;
            AppMethodBeat.o(127656);
            return;
          }
          System.currentTimeMillis();
          l.aTs();
          ao localao = new ao(l.aTw(), l.aTv());
          com.tencent.mm.kernel.g.ajj().a(localao, 0);
          AddrBookObserver.AddrBookService.this.stopSelf();
          AddrBookObserver.AddrBookService.hZF = false;
          AppMethodBeat.o(127656);
        }
      };
      AppMethodBeat.o(127657);
    }
    
    public final IBinder WY()
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
        ae.i("MicroMsg.AddrBookObserver", "service start intent:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramIntent != null) {
          break;
        }
        ae.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      float f1 = paramIntent.getFloatExtra(hZH, -1.0F);
      if (f1 == -1.0F)
      {
        ae.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      paramIntent = ak.getContext().getSharedPreferences(ak.fow(), 0);
      float f2 = paramIntent.getFloat(hZH, 0.0F);
      if (f2 == f1)
      {
        ae.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", new Object[] { Float.valueOf(f2) });
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      paramIntent.edit().putFloat(hZH, f1).commit();
      ae.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", new Object[] { Float.valueOf(f1) });
      if (isCanceled)
      {
        ae.i("MicroMsg.AddrBookObserver", "service canceled");
        isCanceled = false;
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
      }
      for (;;)
      {
        try
        {
          if (!com.tencent.mm.kernel.g.ajM())
          {
            ae.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
            stopSelf();
            AppMethodBeat.o(127658);
            return 2;
          }
          if (com.tencent.mm.n.g.acL().getInt("WCOEntranceSwitch", 0) > 0)
          {
            paramIntent = new kj();
            com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
          }
          if ((!l.aTq()) || (l.aTm())) {
            continue;
          }
          ae.i("MicroMsg.AddrBookObserver", "start sync");
          if (t.da(ak.getContext())) {
            continue;
          }
          hZF = true;
          com.tencent.mm.platformtools.a.syncAddrBook(this.hZI);
        }
        catch (Exception paramIntent)
        {
          ae.printErrStackTrace("MicroMsg.AddrBookObserver", paramIntent, "", new Object[0]);
          ae.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", new Object[] { paramIntent.getMessage() });
          stopSelf();
          continue;
        }
        AppMethodBeat.o(127658);
        return 2;
        ae.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
        stopSelf();
        AppMethodBeat.o(127658);
        return 2;
        ae.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
        stopSelf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver
 * JD-Core Version:    0.7.0.1
 */