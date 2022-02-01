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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import d.g.b.k;
import d.g.b.v.c;
import d.g.b.v.f;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/vlog/ThumbLoadingPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "thumbView", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getThumbView", "()Landroid/widget/ImageView;", "setThumbView", "(Landroid/widget/ImageView;)V", "getScale", "", "width", "", "height", "getSourceHeight", "scale", "getSourceWidth", "hideLoading", "", "setTranslateY", "distance", "showLoading", "strRes", "showThumbLoading", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Companion", "plugin-finder_release"})
public final class g
  implements t
{
  public static final g.a shF;
  private final Context context;
  private p mcf;
  ImageView qQT;
  private d rTT;
  
  static
  {
    AppMethodBeat.i(204866);
    shF = new g.a((byte)0);
    AppMethodBeat.o(204866);
  }
  
  public g(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(204865);
    this.qQT = paramImageView;
    this.rTT = paramd;
    this.context = this.qQT.getContext();
    AppMethodBeat.o(204865);
  }
  
  public final void Fl(int paramInt)
  {
    AppMethodBeat.i(204863);
    ac.i("MicroMsg.ThumbLoadingPlugin", "showDialog");
    if (paramInt < 0) {}
    Context localContext;
    for (Object localObject = this.context.getString(2131760709);; localObject = this.context.getString(paramInt))
    {
      localContext = this.context;
      if (localContext != null) {
        break;
      }
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(204863);
      throw ((Throwable)localObject);
    }
    ((Activity)localContext).runOnUiThread((Runnable)new c(this, (String)localObject));
    AppMethodBeat.o(204863);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final void hideLoading()
  {
    AppMethodBeat.i(204864);
    ac.i("MicroMsg.ThumbLoadingPlugin", "hideLoading");
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(204864);
      throw ((Throwable)localObject);
    }
    ((Activity)localObject).runOnUiThread((Runnable)new b(this));
    AppMethodBeat.o(204864);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(204859);
      this.shG.qQT.setVisibility(8);
      p localp = g.a(this.shG);
      if (localp != null) {
        localp.dismiss();
      }
      g.a(this.shG, null);
      AppMethodBeat.o(204859);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(g paramg, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(204860);
      g.a(this.shG, h.b(g.b(this.shG), this.gBZ, false, null));
      AppMethodBeat.o(204860);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(g paramg, v.c paramc, v.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(204861);
      if ((this.shH.KUN < 0.999D) || (this.shH.KUN > 1.001D))
      {
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        Object localObject = this.shG;
        Bitmap localBitmap1 = (Bitmap)this.shI.KUQ;
        k.g(localBitmap1, "thumb");
        int i = g.a((g)localObject, localBitmap1.getWidth(), this.shH.KUN);
        localObject = this.shG;
        localBitmap1 = (Bitmap)this.shI.KUQ;
        k.g(localBitmap1, "thumb");
        int j = g.b((g)localObject, localBitmap1.getHeight(), this.shH.KUN);
        localObject = this.shI;
        localBitmap1 = (Bitmap)this.shI.KUQ;
        Bitmap localBitmap2 = (Bitmap)this.shI.KUQ;
        k.g(localBitmap2, "thumb");
        int k = (localBitmap2.getWidth() - i) / 2;
        localBitmap2 = (Bitmap)this.shI.KUQ;
        k.g(localBitmap2, "thumb");
        ((v.f)localObject).KUQ = Bitmap.createBitmap(localBitmap1, k, (localBitmap2.getHeight() - j) / 2, i, j, localMatrix, true);
      }
      this.shG.qQT.setImageBitmap((Bitmap)this.shI.KUQ);
      this.shG.qQT.setVisibility(0);
      AppMethodBeat.o(204861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.g
 * JD-Core Version:    0.7.0.1
 */