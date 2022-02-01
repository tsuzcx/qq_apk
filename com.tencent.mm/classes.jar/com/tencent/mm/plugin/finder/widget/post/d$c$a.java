package com.tencent.mm.plugin.finder.widget.post;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$2$1$1$1", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$2$$special$$inlined$let$lambda$1"})
final class d$c$a
  implements Runnable
{
  d$c$a(Bitmap paramBitmap1, String paramString, int paramInt, boolean paramBoolean, Bitmap paramBitmap2, d.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(168592);
    d.c(this.siA.siv).add(this.six);
    Object localObject = d.siu;
    ac.i(d.access$getTAG$cp(), "add thumb file, index:" + this.rIN);
    if (this.siy)
    {
      localObject = n.rPN;
      localObject = n.fF(this.siz.getWidth(), this.siz.getHeight());
      ImageView localImageView = d.d(this.siA.siv);
      if (localImageView == null) {
        k.fOy();
      }
      localImageView.getLayoutParams().width = ((Bundle)localObject).getInt("media_layout_width", this.siz.getWidth());
      localImageView = d.d(this.siA.siv);
      if (localImageView == null) {
        k.fOy();
      }
      localImageView.getLayoutParams().height = ((Bundle)localObject).getInt("media_layout_height", this.siz.getHeight());
      localImageView = d.d(this.siA.siv);
      if (localImageView == null) {
        k.fOy();
      }
      localImageView.setScaleType(android.widget.ImageView.ScaleType.values()[localObject.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
      localObject = d.d(this.siA.siv);
      if (localObject == null) {
        k.fOy();
      }
      ((ImageView)localObject).requestLayout();
      localObject = d.d(this.siA.siv);
      if (localObject == null) {
        k.fOy();
      }
      ((ImageView)localObject).setImageBitmap(this.shr);
      localObject = d.d(this.siA.siv);
      if (localObject == null) {
        k.fOy();
      }
      ((ImageView)localObject).setVisibility(0);
      localObject = d.d(this.siA.siv);
      if (localObject == null) {
        k.fOy();
      }
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new d.c.a.1(this));
    }
    AppMethodBeat.o(168592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.d.c.a
 * JD-Core Version:    0.7.0.1
 */