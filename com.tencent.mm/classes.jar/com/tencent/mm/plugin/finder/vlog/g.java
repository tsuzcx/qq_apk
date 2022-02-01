package com.tencent.mm.plugin.finder.vlog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import d.g.b.k;
import d.g.b.v.b;
import d.g.b.v.e;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/ThumbLoadingPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "thumbView", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getThumbView", "()Landroid/widget/ImageView;", "setThumbView", "(Landroid/widget/ImageView;)V", "getScale", "", "width", "", "height", "getSourceHeight", "scale", "getSourceWidth", "hideLoading", "", "setTranslateY", "distance", "showLoading", "strRes", "showThumbLoading", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Companion", "plugin-finder_release"})
public final class g
  implements t
{
  public static final a LlI;
  private final Context context;
  private p lAj;
  ImageView qir;
  private d vjo;
  
  static
  {
    AppMethodBeat.i(200738);
    LlI = new a((byte)0);
    AppMethodBeat.o(200738);
  }
  
  public g(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(200737);
    this.qir = paramImageView;
    this.vjo = paramd;
    this.context = this.qir.getContext();
    AppMethodBeat.o(200737);
  }
  
  public final void aib(int paramInt)
  {
    AppMethodBeat.i(200735);
    ad.i("MicroMsg.ThumbLoadingPlugin", "showDialog");
    if (paramInt < 0) {}
    Context localContext;
    for (Object localObject = this.context.getString(2131760709);; localObject = this.context.getString(paramInt))
    {
      localContext = this.context;
      if (localContext != null) {
        break;
      }
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(200735);
      throw ((Throwable)localObject);
    }
    ((Activity)localContext).runOnUiThread((Runnable)new c(this, (String)localObject));
    AppMethodBeat.o(200735);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(200736);
    ad.i("MicroMsg.ThumbLoadingPlugin", "hideLoading");
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(200736);
      throw ((Throwable)localObject);
    }
    ((Activity)localObject).runOnUiThread((Runnable)new b(this));
    AppMethodBeat.o(200736);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/ThumbLoadingPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(200731);
      this.LlJ.qir.setVisibility(8);
      p localp = g.a(this.LlJ);
      if (localp != null) {
        localp.dismiss();
      }
      g.a(this.LlJ, null);
      AppMethodBeat.o(200731);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(g paramg, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(200732);
      g.a(this.LlJ, h.b(g.b(this.LlJ), this.qpb, false, null));
      AppMethodBeat.o(200732);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(g paramg, v.b paramb, v.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(200733);
      if ((this.LlK.Jht < 0.999D) || (this.LlK.Jht > 1.001D))
      {
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        Object localObject = this.LlJ;
        Bitmap localBitmap1 = (Bitmap)this.LlL.Jhw;
        k.g(localBitmap1, "thumb");
        int i = g.a((g)localObject, localBitmap1.getWidth(), this.LlK.Jht);
        localObject = this.LlJ;
        localBitmap1 = (Bitmap)this.LlL.Jhw;
        k.g(localBitmap1, "thumb");
        int j = g.b((g)localObject, localBitmap1.getHeight(), this.LlK.Jht);
        localObject = this.LlL;
        localBitmap1 = (Bitmap)this.LlL.Jhw;
        Bitmap localBitmap2 = (Bitmap)this.LlL.Jhw;
        k.g(localBitmap2, "thumb");
        int k = (localBitmap2.getWidth() - i) / 2;
        localBitmap2 = (Bitmap)this.LlL.Jhw;
        k.g(localBitmap2, "thumb");
        ((v.e)localObject).Jhw = Bitmap.createBitmap(localBitmap1, k, (localBitmap2.getHeight() - j) / 2, i, j, localMatrix, true);
      }
      this.LlJ.qir.setImageBitmap((Bitmap)this.LlL.Jhw);
      this.LlJ.qir.setVisibility(0);
      AppMethodBeat.o(200733);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.g
 * JD-Core Version:    0.7.0.1
 */