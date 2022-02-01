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
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.g.a.pi.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.br;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public final class b
  implements az
{
  private a rnh;
  private b rni;
  boolean rnj;
  private n.b rnk;
  boolean rnl;
  long rnm;
  private final long rnn;
  private final long rno;
  private final String rnp;
  int rnq;
  private aq rnr;
  
  public b()
  {
    AppMethodBeat.i(24556);
    this.rnj = false;
    this.rnk = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(24549);
        ae.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
        if (b.this.rnj)
        {
          AppMethodBeat.o(24549);
          return;
        }
        bc.aCg();
        if (paramAnonymousn != com.tencent.mm.model.c.azL())
        {
          AppMethodBeat.o(24549);
          return;
        }
        if ((paramAnonymousn == null) || (paramAnonymousObject == null))
        {
          ae.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
          AppMethodBeat.o(24549);
          return;
        }
        if ((ak.getContext() == null) || (!bc.ajM()))
        {
          ae.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
          AppMethodBeat.o(24549);
          return;
        }
        b.this.cub();
        AppMethodBeat.o(24549);
      }
    };
    this.rnl = false;
    this.rnm = 0L;
    this.rnn = 300000L;
    this.rno = 4000L;
    this.rnp = "fun1";
    this.rnq = 0;
    this.rnr = new aq(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24552);
        if ((ak.getContext() == null) || (!bc.ajM()))
        {
          ae.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
          AppMethodBeat.o(24552);
          return;
        }
        if ((b.a(b.this)) && (b.this.rnq > 0))
        {
          ae.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
          paramAnonymousMessage = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
          paramAnonymousMessage.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
          ak.getContext().sendBroadcast(paramAnonymousMessage);
          b.this.rnq = 0;
        }
        AppMethodBeat.o(24552);
      }
    };
    AppMethodBeat.o(24556);
  }
  
  public static b cua()
  {
    AppMethodBeat.i(24557);
    bc.aCa();
    b localb2 = (b)cc.Ca("plugin.extqlauncher");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      bc.aCa().a("plugin.extqlauncher", localb1);
    }
    AppMethodBeat.o(24557);
    return localb1;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final void cub()
  {
    AppMethodBeat.i(24561);
    this.rnr.removeMessages(0);
    this.rnr.sendEmptyMessageDelayed(0, 4000L);
    AppMethodBeat.o(24561);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24558);
    bc.aCg();
    com.tencent.mm.model.c.azL().a(this.rnk);
    if (this.rnh == null) {
      this.rnh = new a();
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.rnh);
    if (this.rni == null) {
      this.rni = new b((byte)0);
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.rni);
    AppMethodBeat.o(24558);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24559);
    if (this.rnh != null) {
      com.tencent.mm.sdk.b.a.IvT.d(this.rnh);
    }
    if (this.rni != null) {
      com.tencent.mm.sdk.b.a.IvT.d(this.rni);
    }
    bc.aCg();
    com.tencent.mm.model.c.azL().b(this.rnk);
    this.rnr.removeMessages(0);
    AppMethodBeat.o(24559);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<fp>
  {
    public a()
    {
      AppMethodBeat.i(161364);
      this.__eventId = fp.class.getName().hashCode();
      AppMethodBeat.o(161364);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<pi>
  {
    private b()
    {
      AppMethodBeat.i(161365);
      this.__eventId = pi.class.getName().hashCode();
      AppMethodBeat.o(161365);
    }
    
    private boolean a(pi parampi)
    {
      AppMethodBeat.i(24554);
      if (!b.a(b.this))
      {
        ae.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
        AppMethodBeat.o(24554);
        return false;
      }
      if (ak.getContext() == null)
      {
        ae.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
        AppMethodBeat.o(24554);
        return false;
      }
      ae.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[] { Integer.valueOf(parampi.dEw.dEu), parampi.dEw.scanResult });
      do
      {
        try
        {
          int i = parampi.dEw.dEu;
          switch (i)
          {
          }
        }
        catch (Exception parampi)
        {
          for (;;)
          {
            Object localObject;
            Context localContext;
            ae.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[] { parampi.getMessage() });
          }
        }
        AppMethodBeat.o(24554);
        return false;
      } while ((bu.isNullOrNil(parampi.dEw.scanResult)) || (!parampi.dEw.scanResult.startsWith("qlauncher://")));
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
      ((Intent)localObject).setData(Uri.parse(parampi.dEw.scanResult));
      ((Intent)localObject).setFlags(268435456);
      localContext = ak.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parampi.dEx.ret = 1;
      AppMethodBeat.o(24554);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b
 * JD-Core Version:    0.7.0.1
 */