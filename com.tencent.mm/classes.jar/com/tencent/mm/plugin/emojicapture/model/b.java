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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/CheckStickerDownload;", "", "context", "Landroid/content/Context;", "url", "", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;)V", "TAG", "callback", "com/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1", "Lcom/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1;", "canRetry", "", "canceled", "getContext", "()Landroid/content/Context;", "loadHint", "kotlin.jvm.PlatformType", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getOnResult", "()Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "getUrl", "()Ljava/lang/String;", "destroy", "", "rescan", "download", "startPreview", "plugin-emojicapture_release"})
public final class b
{
  final String TAG;
  final Context context;
  boolean hls;
  private final String oJF;
  final p oJG;
  final a.b oJI;
  private boolean oJO;
  final a oJP;
  final String url;
  
  public b(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(153);
    this.context = paramContext;
    this.url = paramString;
    this.oJI = paramb;
    this.TAG = "MicroMsg.CheckStickerDownload";
    this.oJO = true;
    this.oJF = this.context.getResources().getString(2131755720);
    this.oJG = p.a(this.context, (CharSequence)this.oJF, true, 0, (DialogInterface.OnCancelListener)new b(this));
    this.oJP = new a(this);
    paramContext = e.Fds;
    e.a((f)this.oJP);
    bXv();
    AppMethodBeat.o(153);
  }
  
  final void bXv()
  {
    AppMethodBeat.i(151);
    e locale = e.Fds;
    e.aHc(this.url);
    AppMethodBeat.o(151);
  }
  
  public final void jQ(boolean paramBoolean)
  {
    AppMethodBeat.i(152);
    this.oJG.dismiss();
    e locale = e.Fds;
    e.b((f)this.oJP);
    this.oJI.df(paramBoolean);
    AppMethodBeat.o(152);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class a
    implements f<g>
  {
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class a
      implements f.c
    {
      a(b.a parama) {}
      
      public final void d(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(145);
        this.oJR.oJQ.bXv();
        AppMethodBeat.o(145);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class b
      implements f.c
    {
      b(b.a parama) {}
      
      public final void d(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(146);
        this.oJR.oJQ.jQ(true);
        AppMethodBeat.o(146);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class c
      implements f.c
    {
      c(b.a parama) {}
      
      public final void d(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(147);
        this.oJR.oJQ.jQ(false);
        AppMethodBeat.o(147);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class d
      implements f.c
    {
      d(b.a parama) {}
      
      public final void d(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(148);
        this.oJR.oJQ.jQ(false);
        AppMethodBeat.o(148);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(b paramb) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(150);
      ad.i(this.oJQ.TAG, "startStickerPreview: cancel loading");
      this.oJQ.hls = true;
      this.oJQ.jQ(false);
      AppMethodBeat.o(150);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b
 * JD-Core Version:    0.7.0.1
 */