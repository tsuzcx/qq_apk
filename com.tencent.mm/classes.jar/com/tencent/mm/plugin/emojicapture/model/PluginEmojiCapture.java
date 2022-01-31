package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.emojicapture.a.c;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.f.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.ttpic.VideoModule;
import com.tencent.view.raw.FilterRawGet;
import com.tencent.view.raw.FilterRawGet.GetInputStream;
import com.tencent.ytcommon.util.YTCommonInterface;

public final class PluginEmojiCapture
  extends f
  implements com.tencent.mm.plugin.emojicapture.a.a
{
  private static final String TAG = "MicroMsg.PlguinEmojiCapture.Companion";
  public static final PluginEmojiCapture.a jkq = new PluginEmojiCapture.a((byte)0);
  private boolean dBn;
  private final String jkp = "MicroMsg.PlguinEmojiCapture";
  
  static
  {
    TAG = "MicroMsg.PlguinEmojiCapture.Companion";
    y.i(access$getTAG$cp(), "init load pt library");
    k.b("YTCommon", jkq.getClass().getClassLoader());
    k.b("nnpack", jkq.getClass().getClassLoader());
    com.tencent.mm.plugin.emojicapture.d.b.aJY();
  }
  
  private final boolean cameraCheck(Context paramContext)
  {
    if ((com.tencent.mm.plugin.voip.e.bj(paramContext)) || (com.tencent.mm.plugin.voip.e.bk(paramContext)) || (com.tencent.mm.bf.e.bi(paramContext)))
    {
      y.i(this.jkp, "camera check false");
      return false;
    }
    return true;
  }
  
  private final boolean firstOpenCheck(Context paramContext, Intent paramIntent)
  {
    Object localObject = com.tencent.mm.kernel.g.DP();
    a.d.b.g.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).Dz().i(ac.a.uzA);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      return true;
    }
    localObject = com.tencent.mm.an.b.NC();
    a.d.b.g.j(localObject, "FontResLogic.getInstance()");
    if (!((com.tencent.mm.an.b)localObject).ND()) {
      h.nFQ.fy(2L);
    }
    localObject = BitmapFactory.decodeResource(paramContext.getResources(), a.c.emoji_capture_first_open_notice);
    new c.a(paramContext).Ip(a.f.dialog_first_open_title).a((Bitmap)localObject, false, 0).Iq(a.f.dialog_first_open_msg).Is(a.f.dialog_first_open_confirm).a((DialogInterface.OnDismissListener)new PluginEmojiCapture.b(paramContext, paramIntent)).aoP().show();
    paramContext = com.tencent.mm.kernel.g.DP();
    a.d.b.g.j(paramContext, "MMKernel.storage()");
    paramContext.Dz().c(ac.a.uzA, Boolean.valueOf(true));
    y.i(this.jkp, "first open check false");
    return false;
  }
  
  private final void initCheck()
  {
    int j;
    int i;
    if (!this.dBn)
    {
      j = -1;
      i = j;
    }
    try
    {
      VideoModule.init(ae.getContext());
      i = j;
      j = YTCommonInterface.initAuth(ae.getContext(), "rel_wechat.lic", 0, false);
      i = j;
      y.i(this.jkp, "init VideoModule initAuth: %s", new Object[] { Integer.valueOf(j) });
      i = j;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        a.a locala;
        y.printErrStackTrace(this.jkp, (Throwable)localUnsatisfiedLinkError, "init error", new Object[0]);
      }
      FilterRawGet.setGetInputStream((FilterRawGet.GetInputStream)new PluginEmojiCapture.c(this));
      this.dBn = true;
    }
    if (i != 0)
    {
      locala = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      a.a.cG(17, 1);
      this.dBn = false;
      return;
    }
  }
  
  private final boolean overSizeCheck(Context paramContext)
  {
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class);
    a.d.b.g.j(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
    if (((com.tencent.mm.plugin.emoji.b.d)locala).getEmojiMgr().aHf())
    {
      new c.a(paramContext).Ip(a.f.dialog_over_size_title).Iq(a.f.dialog_over_size_msg).Is(a.f.dialog_over_size_confirm).a((DialogInterface.OnClickListener)new d(paramContext)).It(a.f.dialog_over_size_cancel).aoP().show();
      y.i(this.jkp, "over size check false");
      return false;
    }
    return true;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    y.i(this.jkp, "Plugin EmojiCapture Execute");
    if (paramg != null) {}
    for (paramg = Boolean.valueOf(paramg.gn(":tools"));; paramg = null)
    {
      if (paramg == null) {
        a.d.b.g.cUk();
      }
      if (paramg.booleanValue()) {
        initCheck();
      }
      return;
    }
  }
  
  public final boolean isInit()
  {
    return this.dBn;
  }
  
  public final String name()
  {
    return "plugin-emojicapture";
  }
  
  public final boolean preCheck(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    a.d.b.g.k(paramContext, "context");
    a.d.b.g.k(paramIntent, "intent");
    com.tencent.mm.an.b.NC();
    com.tencent.mm.an.b.NE();
    return ((paramBoolean) || (firstOpenCheck(paramContext, paramIntent))) && (overSizeCheck(paramContext)) && (cameraCheck(paramContext));
  }
  
  public final void setInit(boolean paramBoolean)
  {
    this.dBn = paramBoolean;
  }
  
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      com.tencent.mm.br.d.b(this.jkr, "emoji", ".ui.EmojiCustomUI", new Intent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture
 * JD-Core Version:    0.7.0.1
 */