package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.ph.a;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public final class b
  implements ax
{
  private a rfe;
  private b rff;
  boolean rfg;
  private n.b rfh;
  boolean rfi;
  long rfj;
  private final long rfk;
  private final long rfl;
  private final String rfm;
  int rfn;
  private ap rfo;
  
  public b()
  {
    AppMethodBeat.i(24556);
    this.rfg = false;
    this.rfh = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(24549);
        ad.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
        if (b.this.rfg)
        {
          AppMethodBeat.o(24549);
          return;
        }
        ba.aBQ();
        if (paramAnonymousn != com.tencent.mm.model.c.azv())
        {
          AppMethodBeat.o(24549);
          return;
        }
        if ((paramAnonymousn == null) || (paramAnonymousObject == null))
        {
          ad.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
          AppMethodBeat.o(24549);
          return;
        }
        if ((aj.getContext() == null) || (!ba.ajx()))
        {
          ad.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
          AppMethodBeat.o(24549);
          return;
        }
        b.this.csA();
        AppMethodBeat.o(24549);
      }
    };
    this.rfi = false;
    this.rfj = 0L;
    this.rfk = 300000L;
    this.rfl = 4000L;
    this.rfm = "fun1";
    this.rfn = 0;
    this.rfo = new ap(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24552);
        if ((aj.getContext() == null) || (!ba.ajx()))
        {
          ad.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
          AppMethodBeat.o(24552);
          return;
        }
        if ((b.a(b.this)) && (b.this.rfn > 0))
        {
          ad.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
          paramAnonymousMessage = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
          paramAnonymousMessage.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
          aj.getContext().sendBroadcast(paramAnonymousMessage);
          b.this.rfn = 0;
        }
        AppMethodBeat.o(24552);
      }
    };
    AppMethodBeat.o(24556);
  }
  
  public static b csy()
  {
    AppMethodBeat.i(24557);
    ba.aBK();
    b localb2 = (b)ca.By("plugin.extqlauncher");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      ba.aBK().a("plugin.extqlauncher", localb1);
    }
    AppMethodBeat.o(24557);
    return localb1;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final void csA()
  {
    AppMethodBeat.i(24561);
    this.rfo.removeMessages(0);
    this.rfo.sendEmptyMessageDelayed(0, 4000L);
    AppMethodBeat.o(24561);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24558);
    ba.aBQ();
    com.tencent.mm.model.c.azv().a(this.rfh);
    if (this.rfe == null) {
      this.rfe = new a();
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.rfe);
    if (this.rff == null) {
      this.rff = new b((byte)0);
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.rff);
    AppMethodBeat.o(24558);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24559);
    if (this.rfe != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.rfe);
    }
    if (this.rff != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.rff);
    }
    ba.aBQ();
    com.tencent.mm.model.c.azv().b(this.rfh);
    this.rfo.removeMessages(0);
    AppMethodBeat.o(24559);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<fo>
  {
    public a()
    {
      AppMethodBeat.i(161364);
      this.__eventId = fo.class.getName().hashCode();
      AppMethodBeat.o(161364);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<ph>
  {
    private b()
    {
      AppMethodBeat.i(161365);
      this.__eventId = ph.class.getName().hashCode();
      AppMethodBeat.o(161365);
    }
    
    private boolean a(ph paramph)
    {
      AppMethodBeat.i(24554);
      if (!b.a(b.this))
      {
        ad.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
        AppMethodBeat.o(24554);
        return false;
      }
      if (aj.getContext() == null)
      {
        ad.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
        AppMethodBeat.o(24554);
        return false;
      }
      ad.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[] { Integer.valueOf(paramph.dDr.dDp), paramph.dDr.scanResult });
      do
      {
        try
        {
          int i = paramph.dDr.dDp;
          switch (i)
          {
          }
        }
        catch (Exception paramph)
        {
          for (;;)
          {
            Object localObject;
            Context localContext;
            ad.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[] { paramph.getMessage() });
          }
        }
        AppMethodBeat.o(24554);
        return false;
      } while ((bt.isNullOrNil(paramph.dDr.scanResult)) || (!paramph.dDr.scanResult.startsWith("qlauncher://")));
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
      ((Intent)localObject).setData(Uri.parse(paramph.dDr.scanResult));
      ((Intent)localObject).setFlags(268435456);
      localContext = aj.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramph.dDs.ret = 1;
      AppMethodBeat.o(24554);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b
 * JD-Core Version:    0.7.0.1
 */