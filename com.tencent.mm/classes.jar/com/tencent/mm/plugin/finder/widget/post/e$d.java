package com.tencent.mm.plugin.finder.widget.post;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.view.PhotoView;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$1$1"})
final class e$d
  implements Runnable
{
  e$d(Bitmap paramBitmap1, e parame, String paramString, boolean paramBoolean, Bitmap paramBitmap2) {}
  
  public final void run()
  {
    AppMethodBeat.i(204873);
    this.siK.siq.add(this.six);
    Object localObject = e.siJ;
    ac.i(e.access$getTAG$cp(), "add thumb file");
    if (this.siy)
    {
      localObject = n.rPN;
      localObject = n.fF(this.siz.getWidth(), this.siz.getHeight());
      this.siK.cGE().getLayoutParams().width = ((Bundle)localObject).getInt("media_layout_width", this.siz.getWidth());
      this.siK.cGE().getLayoutParams().height = ((Bundle)localObject).getInt("media_layout_height", this.siz.getHeight());
      this.siK.cGE().setScaleType(android.widget.ImageView.ScaleType.values()[localObject.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
      this.siK.cGE().requestLayout();
      this.siK.cGE().post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204871);
          this.siM.siK.cGE().setImageBitmap(this.siM.shr);
          AppMethodBeat.o(204871);
        }
      });
      this.siK.cGE().setOnClickListener((View.OnClickListener)new e.d.2(this));
    }
    AppMethodBeat.o(204873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.e.d
 * JD-Core Version:    0.7.0.1
 */