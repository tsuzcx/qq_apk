package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.op.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.o;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements aw
{
  private a pMG;
  private b pMH;
  boolean pMI;
  private n.b pMJ;
  boolean pMK;
  long pML;
  private final long pMM;
  private final long pMN;
  private final String pMO;
  int pMP;
  private ap pMQ;
  
  public b()
  {
    AppMethodBeat.i(24556);
    this.pMI = false;
    this.pMJ = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(24549);
        ad.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
        if (b.this.pMI)
        {
          AppMethodBeat.o(24549);
          return;
        }
        az.arV();
        if (paramAnonymousn != com.tencent.mm.model.c.apR())
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
        if ((aj.getContext() == null) || (!az.afw()))
        {
          ad.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
          AppMethodBeat.o(24549);
          return;
        }
        b.this.cfo();
        AppMethodBeat.o(24549);
      }
    };
    this.pMK = false;
    this.pML = 0L;
    this.pMM = 300000L;
    this.pMN = 4000L;
    this.pMO = "fun1";
    this.pMP = 0;
    this.pMQ = new ap(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24552);
        if ((aj.getContext() == null) || (!az.afw()))
        {
          ad.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
          AppMethodBeat.o(24552);
          return;
        }
        if (b.a(b.this))
        {
          int i = b.cfn();
          if ((i > 0) || (i < b.this.pMP))
          {
            ad.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
            paramAnonymousMessage = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
            paramAnonymousMessage.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
            aj.getContext().sendBroadcast(paramAnonymousMessage);
            b.this.pMP = i;
          }
        }
        AppMethodBeat.o(24552);
      }
    };
    AppMethodBeat.o(24556);
  }
  
  public static b cfm()
  {
    AppMethodBeat.i(24557);
    az.arP();
    b localb2 = (b)bz.ut("plugin.extqlauncher");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      az.arP().a("plugin.extqlauncher", localb1);
    }
    AppMethodBeat.o(24557);
    return localb1;
  }
  
  public static int cfn()
  {
    AppMethodBeat.i(24560);
    if (!az.afw())
    {
      ad.w("MicroMsg.SubCoreExtQLauncher", "getMMUnread account not ready");
      AppMethodBeat.o(24560);
      return 0;
    }
    int j = x.tz(w.gMn);
    int k = o.aqz();
    int i = j;
    if ((u.aqK() & 0x8000) == 0) {
      i = j - k;
    }
    AppMethodBeat.o(24560);
    return i;
  }
  
  public final void cfo()
  {
    AppMethodBeat.i(24561);
    this.pMQ.removeMessages(0);
    this.pMQ.sendEmptyMessageDelayed(0, 4000L);
    AppMethodBeat.o(24561);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24558);
    az.arV();
    com.tencent.mm.model.c.apR().a(this.pMJ);
    if (this.pMG == null) {
      this.pMG = new a();
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.pMG);
    if (this.pMH == null) {
      this.pMH = new b((byte)0);
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.pMH);
    AppMethodBeat.o(24558);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24559);
    if (this.pMG != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.pMG);
    }
    if (this.pMH != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.pMH);
    }
    az.arV();
    com.tencent.mm.model.c.apR().b(this.pMJ);
    this.pMQ.removeMessages(0);
    AppMethodBeat.o(24559);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<fk>
  {
    public a()
    {
      AppMethodBeat.i(161364);
      this.__eventId = fk.class.getName().hashCode();
      AppMethodBeat.o(161364);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<op>
  {
    private b()
    {
      AppMethodBeat.i(161365);
      this.__eventId = op.class.getName().hashCode();
      AppMethodBeat.o(161365);
    }
    
    private boolean a(op paramop)
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
      ad.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[] { Integer.valueOf(paramop.dtO.dtM), paramop.dtO.scanResult });
      do
      {
        try
        {
          int i = paramop.dtO.dtM;
          switch (i)
          {
          }
        }
        catch (Exception paramop)
        {
          for (;;)
          {
            Object localObject;
            Context localContext;
            ad.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[] { paramop.getMessage() });
          }
        }
        AppMethodBeat.o(24554);
        return false;
      } while ((bt.isNullOrNil(paramop.dtO.scanResult)) || (!paramop.dtO.scanResult.startsWith("qlauncher://")));
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
      ((Intent)localObject).setData(Uri.parse(paramop.dtO.scanResult));
      ((Intent)localObject).setFlags(268435456);
      localContext = aj.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramop.dtP.ret = 1;
      AppMethodBeat.o(24554);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b
 * JD-Core Version:    0.7.0.1
 */