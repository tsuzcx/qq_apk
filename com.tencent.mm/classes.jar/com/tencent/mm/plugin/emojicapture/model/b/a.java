package com.tencent.mm.plugin.emojicapture.model.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "preViewRect", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "currFrameTime", "", "drawer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "height", "", "paint", "Landroid/graphics/Paint;", "preViewMatrix", "Landroid/graphics/Matrix;", "width", "addItem", "", "item", "requestNextFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "start", "stop", "plugin-emojicapture_release"})
public final class a
  implements com.tencent.mm.plugin.recordvideo.ui.editor.b.b
{
  private final Canvas aTq;
  private final Bitmap bitmap;
  private int height;
  private long pYA;
  private final Matrix pYB;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.b pYC;
  List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> pYz;
  private final Paint paint;
  private int width;
  
  public a(RectF paramRectF)
  {
    AppMethodBeat.i(262);
    Object localObject = d.pXB;
    this.width = d.ckE();
    localObject = d.pXB;
    this.height = d.ckE();
    this.pYz = ((List)new ArrayList());
    this.pYB = new Matrix();
    this.paint = new Paint();
    this.pYC = new com.tencent.mm.plugin.recordvideo.ui.editor.b(this.pYz);
    localObject = this.pYB;
    float f1 = paramRectF.left;
    float f2 = paramRectF.top;
    float f3 = paramRectF.right;
    float f4 = paramRectF.bottom;
    float f5 = this.width;
    float f6 = this.height;
    ((Matrix)localObject).setPolyToPoly(new float[] { f1, f2, f3, f4 }, 0, new float[] { 0.0F, 0.0F, f5, f6 }, 0, 2);
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    paramRectF = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
    p.g(paramRectF, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
    this.bitmap = paramRectF;
    this.aTq = new Canvas(this.bitmap);
    AppMethodBeat.o(262);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a parama)
  {
    AppMethodBeat.i(221762);
    if (parama != null) {
      this.pYz.add(parama);
    }
    AppMethodBeat.o(221762);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.b.a cls()
  {
    AppMethodBeat.i(221761);
    if (this.pYz.size() <= 0)
    {
      AppMethodBeat.o(221761);
      return null;
    }
    int i = this.aTq.save();
    this.aTq.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.aTq.concat(this.pYB);
    this.pYA = this.pYC.a(this.aTq, this.paint);
    this.aTq.restoreToCount(i);
    com.tencent.mm.plugin.recordvideo.ui.editor.b.a locala = new com.tencent.mm.plugin.recordvideo.ui.editor.b.a(this.bitmap, this.pYA);
    AppMethodBeat.o(221761);
    return locala;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(260);
    Iterator localIterator = this.pYz.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).destroy();
    }
    AppMethodBeat.o(260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.a
 * JD-Core Version:    0.7.0.1
 */