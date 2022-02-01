package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.loader.g;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/CheckStickerDownload;", "", "context", "Landroid/content/Context;", "url", "", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;)V", "TAG", "callback", "com/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1", "Lcom/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1;", "canRetry", "", "canceled", "getContext", "()Landroid/content/Context;", "loadHint", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "kotlin.jvm.PlatformType", "getOnResult", "()Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "getUrl", "()Ljava/lang/String;", "destroy", "", "rescan", "download", "startPreview", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  final String TAG;
  final Context context;
  boolean oLU;
  final String url;
  final w xEL;
  final a.b ygE;
  private final String ygF;
  private boolean ygJ;
  final a ygK;
  
  public b(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(153);
    this.context = paramContext;
    this.url = paramString;
    this.ygE = paramb;
    this.TAG = "MicroMsg.CheckStickerDownload";
    this.ygJ = true;
    paramContext = this.context.getResources().getString(a.i.app_downloading);
    s.s(paramContext, "context.resources.getStr…R.string.app_downloading)");
    this.ygF = paramContext;
    this.xEL = w.a(this.context, (CharSequence)this.ygF, true, 0, new b..ExternalSyntheticLambda0(this));
    this.ygK = new a(this);
    paramContext = com.tencent.mm.sticker.loader.e.acCJ;
    com.tencent.mm.sticker.loader.e.a((com.tencent.mm.loader.f.e)this.ygK);
    blf();
    AppMethodBeat.o(153);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(269330);
    s.u(paramb, "this$0");
    Log.i(paramb.TAG, "startStickerPreview: cancel loading");
    paramb.oLU = true;
    paramb.oq(false);
    AppMethodBeat.o(269330);
  }
  
  final void blf()
  {
    AppMethodBeat.i(151);
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.acCJ;
    com.tencent.mm.sticker.loader.e.buT(this.url);
    AppMethodBeat.o(151);
  }
  
  public final void oq(boolean paramBoolean)
  {
    AppMethodBeat.i(152);
    this.xEL.dismiss();
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.acCJ;
    com.tencent.mm.sticker.loader.e.b((com.tencent.mm.loader.f.e)this.ygK);
    this.ygE.onResult(paramBoolean);
    AppMethodBeat.o(152);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.loader.f.e<g>
  {
    a(b paramb) {}
    
    private static final void a(b paramb, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(269335);
      s.u(paramb, "this$0");
      paramb.blf();
      AppMethodBeat.o(269335);
    }
    
    private static final void b(b paramb, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(269338);
      s.u(paramb, "this$0");
      paramb.oq(true);
      AppMethodBeat.o(269338);
    }
    
    private static final void c(b paramb, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(269341);
      s.u(paramb, "this$0");
      paramb.oq(false);
      AppMethodBeat.o(269341);
    }
    
    private static final void d(b paramb, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(269344);
      s.u(paramb, "this$0");
      paramb.oq(false);
      AppMethodBeat.o(269344);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b
 * JD-Core Version:    0.7.0.1
 */