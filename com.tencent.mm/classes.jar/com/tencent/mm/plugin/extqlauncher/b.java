package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.g.a.qa.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
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
  implements bd
{
  private a sOM;
  private b sON;
  boolean sOO;
  private MStorageEx.IOnStorageChange sOP;
  boolean sOQ;
  long sOR;
  private final long sOS;
  private final long sOT;
  private final String sOU;
  int sOV;
  private MMHandler sOW;
  
  public b()
  {
    AppMethodBeat.i(24556);
    this.sOO = false;
    this.sOP = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(24549);
        Log.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
        if (b.this.sOO)
        {
          AppMethodBeat.o(24549);
          return;
        }
        bg.aVF();
        if (paramAnonymousMStorageEx != c.aST())
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
        if ((MMApplicationContext.getContext() == null) || (!bg.aAc()))
        {
          Log.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
          AppMethodBeat.o(24549);
          return;
        }
        b.this.cSJ();
        AppMethodBeat.o(24549);
      }
    };
    this.sOQ = false;
    this.sOR = 0L;
    this.sOS = 300000L;
    this.sOT = 4000L;
    this.sOU = "fun1";
    this.sOV = 0;
    this.sOW = new MMHandler(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24552);
        if ((MMApplicationContext.getContext() == null) || (!bg.aAc()))
        {
          Log.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
          AppMethodBeat.o(24552);
          return;
        }
        if ((b.a(b.this)) && (b.this.sOV > 0))
        {
          Log.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
          paramAnonymousMessage = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
          paramAnonymousMessage.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
          MMApplicationContext.getContext().sendBroadcast(paramAnonymousMessage);
          b.this.sOV = 0;
        }
        AppMethodBeat.o(24552);
      }
    };
    AppMethodBeat.o(24556);
  }
  
  public static b cSI()
  {
    AppMethodBeat.i(24557);
    bg.aVz();
    b localb2 = (b)cg.KG("plugin.extqlauncher");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      bg.aVz().a("plugin.extqlauncher", localb1);
    }
    AppMethodBeat.o(24557);
    return localb1;
  }
  
  public final void cSJ()
  {
    AppMethodBeat.i(24561);
    this.sOW.removeMessages(0);
    this.sOW.sendEmptyMessageDelayed(0, 4000L);
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
    bg.aVF();
    c.aST().add(this.sOP);
    if (this.sOM == null) {
      this.sOM = new a();
    }
    EventCenter.instance.addListener(this.sOM);
    if (this.sON == null) {
      this.sON = new b((byte)0);
    }
    EventCenter.instance.addListener(this.sON);
    AppMethodBeat.o(24558);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24559);
    if (this.sOM != null) {
      EventCenter.instance.removeListener(this.sOM);
    }
    if (this.sON != null) {
      EventCenter.instance.removeListener(this.sON);
    }
    bg.aVF();
    c.aST().remove(this.sOP);
    this.sOW.removeMessages(0);
    AppMethodBeat.o(24559);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  public static final class a
    extends IListener<fs>
  {
    public a()
    {
      AppMethodBeat.i(161364);
      this.__eventId = fs.class.getName().hashCode();
      AppMethodBeat.o(161364);
    }
  }
  
  final class b
    extends IListener<qa>
  {
    private b()
    {
      AppMethodBeat.i(161365);
      this.__eventId = qa.class.getName().hashCode();
      AppMethodBeat.o(161365);
    }
    
    private boolean a(qa paramqa)
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
      Log.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[] { Integer.valueOf(paramqa.dWj.cSx), paramqa.dWj.scanResult });
      do
      {
        try
        {
          int i = paramqa.dWj.cSx;
          switch (i)
          {
          }
        }
        catch (Exception paramqa)
        {
          for (;;)
          {
            Object localObject;
            Context localContext;
            Log.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[] { paramqa.getMessage() });
          }
        }
        AppMethodBeat.o(24554);
        return false;
      } while ((Util.isNullOrNil(paramqa.dWj.scanResult)) || (!paramqa.dWj.scanResult.startsWith("qlauncher://")));
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
      ((Intent)localObject).setData(Uri.parse(paramqa.dWj.scanResult));
      ((Intent)localObject).setFlags(268435456);
      localContext = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramqa.dWk.ret = 1;
      AppMethodBeat.o(24554);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b
 * JD-Core Version:    0.7.0.1
 */