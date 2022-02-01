package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.gk;
import com.tencent.mm.autogen.a.sn;
import com.tencent.mm.autogen.a.sn.a;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ci;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.by;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class SubCoreExtQLauncher
  implements be
{
  private MStorageEx.IOnStorageChange pqQ;
  private ExtCallEventListener zQJ;
  private GetScanCodeListener zQK;
  private boolean zQL;
  private boolean zQM;
  private long zQN;
  private final long zQO;
  private final long zQP;
  private final String zQQ;
  private int zQR;
  private MMHandler zQS;
  
  public SubCoreExtQLauncher()
  {
    AppMethodBeat.i(24556);
    this.zQL = false;
    this.pqQ = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(24549);
        Log.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
        if (SubCoreExtQLauncher.b(SubCoreExtQLauncher.this))
        {
          AppMethodBeat.o(24549);
          return;
        }
        bh.bCz();
        if (paramAnonymousMStorageEx != c.bzG())
        {
          AppMethodBeat.o(24549);
          return;
        }
        if ((paramAnonymousMStorageEx == null) || (paramAnonymousObject == null))
        {
          Log.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
          AppMethodBeat.o(24549);
          return;
        }
        if ((MMApplicationContext.getContext() == null) || (!bh.baz()))
        {
          Log.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
          AppMethodBeat.o(24549);
          return;
        }
        SubCoreExtQLauncher.this.dOw();
        AppMethodBeat.o(24549);
      }
    };
    this.zQM = false;
    this.zQN = 0L;
    this.zQO = 300000L;
    this.zQP = 4000L;
    this.zQQ = "fun1";
    this.zQR = 0;
    this.zQS = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24552);
        if ((MMApplicationContext.getContext() == null) || (!bh.baz()))
        {
          Log.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
          AppMethodBeat.o(24552);
          return;
        }
        if (SubCoreExtQLauncher.a(SubCoreExtQLauncher.this))
        {
          int i = SubCoreExtQLauncher.dOv();
          if ((i > 0) || (i < SubCoreExtQLauncher.d(SubCoreExtQLauncher.this)))
          {
            Log.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
            paramAnonymousMessage = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
            paramAnonymousMessage.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
            MMApplicationContext.getContext().sendBroadcast(paramAnonymousMessage);
            SubCoreExtQLauncher.a(SubCoreExtQLauncher.this, i);
          }
        }
        AppMethodBeat.o(24552);
      }
    };
    AppMethodBeat.o(24556);
  }
  
  public static SubCoreExtQLauncher dOu()
  {
    AppMethodBeat.i(24557);
    bh.bCt();
    SubCoreExtQLauncher localSubCoreExtQLauncher2 = (SubCoreExtQLauncher)ci.Ka("plugin.extqlauncher");
    SubCoreExtQLauncher localSubCoreExtQLauncher1 = localSubCoreExtQLauncher2;
    if (localSubCoreExtQLauncher2 == null)
    {
      localSubCoreExtQLauncher1 = new SubCoreExtQLauncher();
      bh.bCt().a("plugin.extqlauncher", localSubCoreExtQLauncher1);
    }
    AppMethodBeat.o(24557);
    return localSubCoreExtQLauncher1;
  }
  
  public static int dOv()
  {
    AppMethodBeat.i(24560);
    AppMethodBeat.o(24560);
    return 0;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final void dOw()
  {
    AppMethodBeat.i(24561);
    this.zQS.removeMessages(0);
    this.zQS.sendEmptyMessageDelayed(0, 4000L);
    AppMethodBeat.o(24561);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24558);
    bh.bCz();
    c.bzG().add(this.pqQ);
    if (this.zQJ == null) {
      this.zQJ = new ExtCallEventListener();
    }
    this.zQJ.alive();
    if (this.zQK == null) {
      this.zQK = new GetScanCodeListener();
    }
    this.zQK.alive();
    AppMethodBeat.o(24558);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24559);
    if (this.zQJ != null) {
      this.zQJ.dead();
    }
    if (this.zQK != null) {
      this.zQK.dead();
    }
    bh.bCz();
    c.bzG().remove(this.pqQ);
    this.zQS.removeMessages(0);
    AppMethodBeat.o(24559);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  public static class ExtCallEventListener
    extends IListener<gk>
  {
    public ExtCallEventListener()
    {
      super();
      AppMethodBeat.i(161364);
      this.__eventId = gk.class.getName().hashCode();
      AppMethodBeat.o(161364);
    }
  }
  
  class GetScanCodeListener
    extends IListener<sn>
  {
    public GetScanCodeListener()
    {
      super();
      AppMethodBeat.i(161365);
      this.__eventId = sn.class.getName().hashCode();
      AppMethodBeat.o(161365);
    }
    
    private boolean a(sn paramsn)
    {
      AppMethodBeat.i(24554);
      if (!SubCoreExtQLauncher.a(SubCoreExtQLauncher.this))
      {
        Log.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
        AppMethodBeat.o(24554);
        return false;
      }
      if (MMApplicationContext.getContext() == null)
      {
        Log.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
        AppMethodBeat.o(24554);
        return false;
      }
      Log.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[] { Integer.valueOf(paramsn.hVJ.eQp), paramsn.hVJ.scanResult });
      do
      {
        try
        {
          int i = paramsn.hVJ.eQp;
          switch (i)
          {
          }
        }
        catch (Exception paramsn)
        {
          for (;;)
          {
            Object localObject;
            Context localContext;
            Log.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[] { paramsn.getMessage() });
          }
        }
        AppMethodBeat.o(24554);
        return false;
      } while ((Util.isNullOrNil(paramsn.hVJ.scanResult)) || (!paramsn.hVJ.scanResult.startsWith("qlauncher://")));
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
      ((Intent)localObject).setData(Uri.parse(paramsn.hVJ.scanResult));
      ((Intent)localObject).setFlags(268435456);
      localContext = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramsn.hVK.ret = 1;
      AppMethodBeat.o(24554);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.SubCoreExtQLauncher
 * JD-Core Version:    0.7.0.1
 */