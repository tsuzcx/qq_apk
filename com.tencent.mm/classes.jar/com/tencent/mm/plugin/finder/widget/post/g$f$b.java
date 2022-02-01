package com.tencent.mm.plugin.finder.widget.post;

import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.v.a;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$1$2$1", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initNormalVideoLogic$2$$special$$inlined$let$lambda$2"})
final class g$f$b
  implements Runnable
{
  g$f$b(String paramString, int paramInt, v.a parama, Bitmap paramBitmap, g.f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(204887);
    this.siZ.siV.siq.add(this.six);
    g.a locala = g.siT;
    ac.i(g.access$getTAG$cp(), "add thumb file, index:" + this.rIN);
    if (this.siY.KUL)
    {
      g.a(this.siZ.siV, this.siz);
      g.c(this.siZ.siV).setOnClickListener((View.OnClickListener)new g.f.b.1(this));
    }
    AppMethodBeat.o(204887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.g.f.b
 * JD-Core Version:    0.7.0.1
 */