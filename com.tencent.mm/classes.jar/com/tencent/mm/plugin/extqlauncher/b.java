package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.oy.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.o;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.conversation.h;
import java.util.HashMap;

public final class b
  implements aw
{
  private a qvo;
  private b qvp;
  boolean qvq;
  private n.b qvr;
  boolean qvs;
  long qvt;
  private final long qvu;
  private final long qvv;
  private final String qvw;
  int qvx;
  private ao qvy;
  
  public b()
  {
    AppMethodBeat.i(24556);
    this.qvq = false;
    this.qvr = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(24549);
        ac.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
        if (b.this.qvq)
        {
          AppMethodBeat.o(24549);
          return;
        }
        az.ayM();
        if (paramAnonymousn != com.tencent.mm.model.c.awG())
        {
          AppMethodBeat.o(24549);
          return;
        }
        if ((paramAnonymousn == null) || (paramAnonymousObject == null))
        {
          ac.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
          AppMethodBeat.o(24549);
          return;
        }
        if ((ai.getContext() == null) || (!az.agM()))
        {
          ac.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
          AppMethodBeat.o(24549);
          return;
        }
        b.this.cmV();
        AppMethodBeat.o(24549);
      }
    };
    this.qvs = false;
    this.qvt = 0L;
    this.qvu = 300000L;
    this.qvv = 4000L;
    this.qvw = "fun1";
    this.qvx = 0;
    this.qvy = new ao(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24552);
        if ((ai.getContext() == null) || (!az.agM()))
        {
          ac.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
          AppMethodBeat.o(24552);
          return;
        }
        if (b.a(b.this))
        {
          int i = b.cmU();
          if ((i > 0) || (i < b.this.qvx))
          {
            ac.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
            paramAnonymousMessage = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
            paramAnonymousMessage.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
            ai.getContext().sendBroadcast(paramAnonymousMessage);
            b.this.qvx = i;
          }
        }
        AppMethodBeat.o(24552);
      }
    };
    AppMethodBeat.o(24556);
  }
  
  public static b cmT()
  {
    AppMethodBeat.i(24557);
    az.ayG();
    b localb2 = (b)bz.yz("plugin.extqlauncher");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      az.ayG().a("plugin.extqlauncher", localb1);
    }
    AppMethodBeat.o(24557);
    return localb1;
  }
  
  public static int cmU()
  {
    AppMethodBeat.i(24560);
    if (!az.agM())
    {
      ac.w("MicroMsg.SubCoreExtQLauncher", "getMMUnread account not ready");
      AppMethodBeat.o(24560);
      return 0;
    }
    int j = h.fsb();
    int k = o.axp();
    int i = j;
    if ((u.axA() & 0x8000) == 0) {
      i = j - k;
    }
    AppMethodBeat.o(24560);
    return i;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final void cmV()
  {
    AppMethodBeat.i(24561);
    this.qvy.removeMessages(0);
    this.qvy.sendEmptyMessageDelayed(0, 4000L);
    AppMethodBeat.o(24561);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24558);
    az.ayM();
    com.tencent.mm.model.c.awG().a(this.qvr);
    if (this.qvo == null) {
      this.qvo = new a();
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.qvo);
    if (this.qvp == null) {
      this.qvp = new b((byte)0);
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.qvp);
    AppMethodBeat.o(24558);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24559);
    if (this.qvo != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.qvo);
    }
    if (this.qvp != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.qvp);
    }
    az.ayM();
    com.tencent.mm.model.c.awG().b(this.qvr);
    this.qvy.removeMessages(0);
    AppMethodBeat.o(24559);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<fl>
  {
    public a()
    {
      AppMethodBeat.i(161364);
      this.__eventId = fl.class.getName().hashCode();
      AppMethodBeat.o(161364);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<oy>
  {
    private b()
    {
      AppMethodBeat.i(161365);
      this.__eventId = oy.class.getName().hashCode();
      AppMethodBeat.o(161365);
    }
    
    private boolean a(oy paramoy)
    {
      AppMethodBeat.i(24554);
      if (!b.a(b.this))
      {
        ac.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
        AppMethodBeat.o(24554);
        return false;
      }
      if (ai.getContext() == null)
      {
        ac.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
        AppMethodBeat.o(24554);
        return false;
      }
      ac.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[] { Integer.valueOf(paramoy.drz.drx), paramoy.drz.scanResult });
      do
      {
        try
        {
          int i = paramoy.drz.drx;
          switch (i)
          {
          }
        }
        catch (Exception paramoy)
        {
          for (;;)
          {
            Object localObject;
            Context localContext;
            ac.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[] { paramoy.getMessage() });
          }
        }
        AppMethodBeat.o(24554);
        return false;
      } while ((bs.isNullOrNil(paramoy.drz.scanResult)) || (!paramoy.drz.scanResult.startsWith("qlauncher://")));
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
      ((Intent)localObject).setData(Uri.parse(paramoy.drz.scanResult));
      ((Intent)localObject).setFlags(268435456);
      localContext = ai.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramoy.drA.ret = 1;
      AppMethodBeat.o(24554);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b
 * JD-Core Version:    0.7.0.1
 */