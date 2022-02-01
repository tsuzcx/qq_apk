package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.loader.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/CheckStickerDownload;", "", "context", "Landroid/content/Context;", "url", "", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;)V", "TAG", "callback", "com/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1", "Lcom/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1;", "canRetry", "", "canceled", "getContext", "()Landroid/content/Context;", "loadHint", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "kotlin.jvm.PlatformType", "getOnResult", "()Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "getUrl", "()Ljava/lang/String;", "destroy", "", "rescan", "download", "startPreview", "plugin-emojicapture_release"})
public final class b
{
  final String TAG;
  final Context context;
  boolean jcC;
  final q qVq;
  private final String roh;
  final a.b roj;
  private boolean rop;
  final a roq;
  final String url;
  
  public b(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(153);
    this.context = paramContext;
    this.url = paramString;
    this.roj = paramb;
    this.TAG = "MicroMsg.CheckStickerDownload";
    this.rop = true;
    paramContext = this.context.getResources().getString(2131755791);
    p.g(paramContext, "context.resources.getStr…R.string.app_downloading)");
    this.roh = paramContext;
    this.qVq = q.a(this.context, (CharSequence)this.roh, true, 0, (DialogInterface.OnCancelListener)new b(this));
    this.roq = new a(this);
    paramContext = e.NNN;
    e.a((f)this.roq);
    cID();
    AppMethodBeat.o(153);
  }
  
  final void cID()
  {
    AppMethodBeat.i(151);
    e locale = e.NNN;
    e.biv(this.url);
    AppMethodBeat.o(151);
  }
  
  public final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(152);
    this.qVq.dismiss();
    e locale = e.NNN;
    e.b((f)this.roq);
    this.roj.dQ(paramBoolean);
    AppMethodBeat.o(152);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class a
    implements f<g>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class a
      implements f.c
    {
      a(b.a parama) {}
      
      public final void e(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(145);
        this.ros.ror.cID();
        AppMethodBeat.o(145);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class b
      implements f.c
    {
      b(b.a parama) {}
      
      public final void e(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(146);
        this.ros.ror.lG(true);
        AppMethodBeat.o(146);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class c
      implements f.c
    {
      c(b.a parama) {}
      
      public final void e(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(147);
        this.ros.ror.lG(false);
        AppMethodBeat.o(147);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class d
      implements f.c
    {
      d(b.a parama) {}
      
      public final void e(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(148);
        this.ros.ror.lG(false);
        AppMethodBeat.o(148);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(b paramb) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(150);
      Log.i(this.ror.TAG, "startStickerPreview: cancel loading");
      this.ror.jcC = true;
      this.ror.lG(false);
      AppMethodBeat.o(150);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b
 * JD-Core Version:    0.7.0.1
 */