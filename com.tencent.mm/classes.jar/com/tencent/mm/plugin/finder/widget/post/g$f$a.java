package com.tencent.mm.plugin.finder.widget.post;

import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.v.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$1$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$1"})
final class g$f$a
  implements Runnable
{
  g$f$a(Bitmap paramBitmap, v.a parama, g.f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(204885);
    g.a locala = g.siT;
    ac.i(g.access$getTAG$cp(), "set coverUrl");
    g.a(this.siZ.siV, this.siX);
    g.c(this.siZ.siV).setOnClickListener((View.OnClickListener)new g.f.a.1(this));
    AppMethodBeat.o(204885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.g.f.a
 * JD-Core Version:    0.7.0.1
 */