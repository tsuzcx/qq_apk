package com.tencent.mm.media.f;

import a.f.b.j;
import a.l;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/mix/EditorFrameDrawer;", "", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "(Ljava/util/List;)V", "currFrameTime", "", "drawFrame", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "plugin-mediaeditor_release"})
public final class b
{
  private long eSz;
  private final List<com.tencent.mm.media.editor.a.b> eVw;
  
  public b(List<com.tencent.mm.media.editor.a.b> paramList)
  {
    AppMethodBeat.i(12991);
    this.eVw = paramList;
    AppMethodBeat.o(12991);
  }
  
  public final long a(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(12990);
    j.q(paramCanvas, "canvas");
    j.q(paramPaint, "paint");
    if (this.eVw.size() <= 0)
    {
      AppMethodBeat.o(12990);
      return 0L;
    }
    Iterator localIterator = this.eVw.iterator();
    long l1 = 9223372036854775807L;
    if (localIterator.hasNext())
    {
      com.tencent.mm.media.editor.a.b localb = (com.tencent.mm.media.editor.a.b)localIterator.next();
      long l2 = localb.gk(this.eSz);
      localb.draw(paramCanvas, paramPaint);
      if (l2 >= l1) {
        break label124;
      }
      l1 = l2;
    }
    label124:
    for (;;)
    {
      break;
      this.eSz = l1;
      l1 = this.eSz;
      AppMethodBeat.o(12990);
      return l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.f.b
 * JD-Core Version:    0.7.0.1
 */