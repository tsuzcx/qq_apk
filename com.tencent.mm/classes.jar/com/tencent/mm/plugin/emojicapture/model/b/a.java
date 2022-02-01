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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "preViewRect", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "currFrameTime", "", "drawer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "height", "", "paint", "Landroid/graphics/Paint;", "preViewMatrix", "Landroid/graphics/Matrix;", "width", "addItem", "", "item", "requestNextFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "start", "stop", "plugin-emojicapture_release"})
public final class a
  implements com.tencent.mm.plugin.recordvideo.ui.editor.b.b
{
  private final Canvas aTq;
  private final Bitmap bitmap;
  private int height;
  List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> pRU;
  private long pRV;
  private final Matrix pRW;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.b pRX;
  private final Paint paint;
  private int width;
  
  public a(RectF paramRectF)
  {
    AppMethodBeat.i(262);
    Object localObject = d.pQW;
    this.width = d.cjo();
    localObject = d.pQW;
    this.height = d.cjo();
    this.pRU = ((List)new ArrayList());
    this.pRW = new Matrix();
    this.paint = new Paint();
    this.pRX = new com.tencent.mm.plugin.recordvideo.ui.editor.b(this.pRU);
    localObject = this.pRW;
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
    AppMethodBeat.i(195130);
    if (parama != null) {
      this.pRU.add(parama);
    }
    AppMethodBeat.o(195130);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.b.a ckc()
  {
    AppMethodBeat.i(195129);
    if (this.pRU.size() <= 0)
    {
      AppMethodBeat.o(195129);
      return null;
    }
    int i = this.aTq.save();
    this.aTq.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.aTq.concat(this.pRW);
    this.pRV = this.pRX.a(this.aTq, this.paint);
    this.aTq.restoreToCount(i);
    com.tencent.mm.plugin.recordvideo.ui.editor.b.a locala = new com.tencent.mm.plugin.recordvideo.ui.editor.b.a(this.bitmap, this.pRV);
    AppMethodBeat.o(195129);
    return locala;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(260);
    Iterator localIterator = this.pRU.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).destroy();
    }
    AppMethodBeat.o(260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.a
 * JD-Core Version:    0.7.0.1
 */