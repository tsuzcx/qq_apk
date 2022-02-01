package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.loader.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.f.c;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/CheckStickerDownload;", "", "context", "Landroid/content/Context;", "url", "", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;)V", "TAG", "callback", "com/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1", "Lcom/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1;", "canRetry", "", "canceled", "getContext", "()Landroid/content/Context;", "loadHint", "kotlin.jvm.PlatformType", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getOnResult", "()Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "getUrl", "()Ljava/lang/String;", "destroy", "", "rescan", "download", "startPreview", "plugin-emojicapture_release"})
public final class b
{
  final String TAG;
  final Context context;
  boolean ieP;
  private final String pQD;
  final p pQE;
  final a.b pQG;
  private boolean pQM;
  final a pQN;
  final String url;
  
  public b(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(153);
    this.context = paramContext;
    this.url = paramString;
    this.pQG = paramb;
    this.TAG = "MicroMsg.CheckStickerDownload";
    this.pQM = true;
    this.pQD = this.context.getResources().getString(2131755720);
    this.pQE = p.a(this.context, (CharSequence)this.pQD, true, 0, (DialogInterface.OnCancelListener)new b(this));
    this.pQN = new a(this);
    paramContext = e.ImJ;
    e.a((f)this.pQN);
    cjl();
    AppMethodBeat.o(153);
  }
  
  final void cjl()
  {
    AppMethodBeat.i(151);
    e locale = e.ImJ;
    e.aSd(this.url);
    AppMethodBeat.o(151);
  }
  
  public final void kE(boolean paramBoolean)
  {
    AppMethodBeat.i(152);
    this.pQE.dismiss();
    e locale = e.ImJ;
    e.b((f)this.pQN);
    this.pQG.dg(paramBoolean);
    AppMethodBeat.o(152);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class a
    implements f<g>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class a
      implements f.c
    {
      a(b.a parama) {}
      
      public final void d(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(145);
        this.pQP.pQO.cjl();
        AppMethodBeat.o(145);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class b
      implements f.c
    {
      b(b.a parama) {}
      
      public final void d(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(146);
        this.pQP.pQO.kE(true);
        AppMethodBeat.o(146);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class c
      implements f.c
    {
      c(b.a parama) {}
      
      public final void d(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(147);
        this.pQP.pQO.kE(false);
        AppMethodBeat.o(147);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class d
      implements f.c
    {
      d(b.a parama) {}
      
      public final void d(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(148);
        this.pQP.pQO.kE(false);
        AppMethodBeat.o(148);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(b paramb) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(150);
      ad.i(this.pQO.TAG, "startStickerPreview: cancel loading");
      this.pQO.ieP = true;
      this.pQO.kE(false);
      AppMethodBeat.o(150);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b
 * JD-Core Version:    0.7.0.1
 */