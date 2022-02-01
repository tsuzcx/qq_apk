package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.fz;
import com.tencent.mm.f.a.qy;
import com.tencent.mm.f.a.qy.a;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements be
{
  private a wuH;
  private b wuI;
  private boolean wuJ;
  private MStorageEx.IOnStorageChange wuK;
  private boolean wuL;
  private long wuM;
  private final long wuN;
  private final long wuO;
  private final String wuP;
  private int wuQ;
  private MMHandler wuR;
  
  public b()
  {
    AppMethodBeat.i(24556);
    this.wuJ = false;
    this.wuK = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(24549);
        Log.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
        if (b.b(b.this))
        {
          AppMethodBeat.o(24549);
          return;
        }
        bh.beI();
        if (paramAnonymousMStorageEx != c.bbR())
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
        if ((MMApplicationContext.getContext() == null) || (!bh.aHB()))
        {
          Log.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
          AppMethodBeat.o(24549);
          return;
        }
        b.this.dhL();
        AppMethodBeat.o(24549);
      }
    };
    this.wuL = false;
    this.wuM = 0L;
    this.wuN = 300000L;
    this.wuO = 4000L;
    this.wuP = "fun1";
    this.wuQ = 0;
    this.wuR = new MMHandler(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24552);
        if ((MMApplicationContext.getContext() == null) || (!bh.aHB()))
        {
          Log.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
          AppMethodBeat.o(24552);
          return;
        }
        if ((b.a(b.this)) && (b.d(b.this) > 0))
        {
          Log.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
          paramAnonymousMessage = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
          paramAnonymousMessage.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
          MMApplicationContext.getContext().sendBroadcast(paramAnonymousMessage);
          b.e(b.this);
        }
        AppMethodBeat.o(24552);
      }
    };
    AppMethodBeat.o(24556);
  }
  
  public static b dhK()
  {
    AppMethodBeat.i(24557);
    bh.beC();
    b localb2 = (b)ch.RZ("plugin.extqlauncher");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      bh.beC().a("plugin.extqlauncher", localb1);
    }
    AppMethodBeat.o(24557);
    return localb1;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final void dhL()
  {
    AppMethodBeat.i(24561);
    this.wuR.removeMessages(0);
    this.wuR.sendEmptyMessageDelayed(0, 4000L);
    AppMethodBeat.o(24561);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24558);
    bh.beI();
    c.bbR().add(this.wuK);
    if (this.wuH == null) {
      this.wuH = new a();
    }
    EventCenter.instance.addListener(this.wuH);
    if (this.wuI == null) {
      this.wuI = new b((byte)0);
    }
    EventCenter.instance.addListener(this.wuI);
    AppMethodBeat.o(24558);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24559);
    if (this.wuH != null) {
      EventCenter.instance.removeListener(this.wuH);
    }
    if (this.wuI != null) {
      EventCenter.instance.removeListener(this.wuI);
    }
    bh.beI();
    c.bbR().remove(this.wuK);
    this.wuR.removeMessages(0);
    AppMethodBeat.o(24559);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  public static final class a
    extends IListener<fz>
  {
    public a()
    {
      AppMethodBeat.i(161364);
      this.__eventId = fz.class.getName().hashCode();
      AppMethodBeat.o(161364);
    }
  }
  
  final class b
    extends IListener<qy>
  {
    private b()
    {
      AppMethodBeat.i(161365);
      this.__eventId = qy.class.getName().hashCode();
      AppMethodBeat.o(161365);
    }
    
    private boolean a(qy paramqy)
    {
      AppMethodBeat.i(24554);
      if (!b.a(b.this))
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
      Log.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[] { Integer.valueOf(paramqy.fPO.cUP), paramqy.fPO.scanResult });
      do
      {
        try
        {
          int i = paramqy.fPO.cUP;
          switch (i)
          {
          }
        }
        catch (Exception paramqy)
        {
          for (;;)
          {
            Object localObject;
            Context localContext;
            Log.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[] { paramqy.getMessage() });
          }
        }
        AppMethodBeat.o(24554);
        return false;
      } while ((Util.isNullOrNil(paramqy.fPO.scanResult)) || (!paramqy.fPO.scanResult.startsWith("qlauncher://")));
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
      ((Intent)localObject).setData(Uri.parse(paramqy.fPO.scanResult));
      ((Intent)localObject).setFlags(268435456);
      localContext = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramqy.fPP.ret = 1;
      AppMethodBeat.o(24554);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b
 * JD-Core Version:    0.7.0.1
 */