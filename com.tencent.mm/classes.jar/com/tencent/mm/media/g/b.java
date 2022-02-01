package com.tencent.mm.media.g;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/mix/EditorFrameDrawer;", "", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "(Ljava/util/List;)V", "currFrameTime", "", "drawFrame", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "plugin-mediaeditor_release"})
public final class b
{
  private long goC;
  private final List<com.tencent.mm.media.editor.a.b> grO;
  
  public b(List<com.tencent.mm.media.editor.a.b> paramList)
  {
    AppMethodBeat.i(93718);
    this.grO = paramList;
    AppMethodBeat.o(93718);
  }
  
  public final long a(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(93717);
    k.h(paramCanvas, "canvas");
    k.h(paramPaint, "paint");
    if (this.grO.size() <= 0)
    {
      AppMethodBeat.o(93717);
      return 0L;
    }
    Iterator localIterator = this.grO.iterator();
    long l1 = 9223372036854775807L;
    if (localIterator.hasNext())
    {
      com.tencent.mm.media.editor.a.b localb = (com.tencent.mm.media.editor.a.b)localIterator.next();
      long l2 = localb.lz(this.goC);
      localb.draw(paramCanvas, paramPaint);
      if (l2 >= l1) {
        break label121;
      }
      l1 = l2;
    }
    label121:
    for (;;)
    {
      break;
      this.goC = l1;
      l1 = this.goC;
      AppMethodBeat.o(93717);
      return l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.g.b
 * JD-Core Version:    0.7.0.1
 */