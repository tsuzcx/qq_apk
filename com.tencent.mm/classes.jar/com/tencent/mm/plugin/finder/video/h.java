package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.picker.b.a;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCropTailor;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "onInput", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "resize", "Lkotlin/Pair;", "originWidth", "originHeight", "maxWidth", "Companion", "plugin-finder_release"})
public final class h
  implements a<String, b.f>
{
  public static final h.a rSh;
  private final b.b rSg;
  
  static
  {
    AppMethodBeat.i(203839);
    rSh = new h.a((byte)0);
    AppMethodBeat.o(203839);
  }
  
  public h(b.b paramb)
  {
    AppMethodBeat.i(203838);
    this.rSg = paramb;
    AppMethodBeat.o(203838);
  }
  
  private static Rect a(Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    AppMethodBeat.i(203837);
    float f = 1.0F * paramRect1.width() / paramRect2.width();
    int i = paramRect3.left - paramRect1.left;
    int j = paramRect3.top - paramRect1.top;
    int k = paramRect3.width();
    int m = paramRect3.height();
    paramRect1 = new Rect((int)(i / f), (int)((m + j) / f), (int)((k + i) / f), (int)(j / f));
    AppMethodBeat.o(203837);
    return paramRect1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.h
 * JD-Core Version:    0.7.0.1
 */