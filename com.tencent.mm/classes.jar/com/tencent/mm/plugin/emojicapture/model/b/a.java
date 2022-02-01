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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "preViewRect", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "currFrameTime", "", "drawer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "height", "", "paint", "Landroid/graphics/Paint;", "preViewMatrix", "Landroid/graphics/Matrix;", "width", "addItem", "", "item", "requestNextFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "start", "stop", "plugin-emojicapture_release"})
public final class a
  implements com.tencent.mm.plugin.recordvideo.ui.editor.b.b
{
  private final Canvas aTi;
  private final Bitmap bitmap;
  private int height;
  private final Paint paint;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.b rpA;
  List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> rpx;
  private long rpy;
  private final Matrix rpz;
  private int width;
  
  public a(RectF paramRectF)
  {
    AppMethodBeat.i(262);
    Object localObject = d.roA;
    this.width = d.cIG();
    localObject = d.roA;
    this.height = d.cIG();
    this.rpx = ((List)new ArrayList());
    this.rpz = new Matrix();
    this.paint = new Paint();
    this.rpA = new com.tencent.mm.plugin.recordvideo.ui.editor.b(this.rpx);
    localObject = this.rpz;
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
    this.aTi = new Canvas(this.bitmap);
    AppMethodBeat.o(262);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a parama)
  {
    AppMethodBeat.i(256431);
    if (parama != null) {
      this.rpx.add(parama);
    }
    AppMethodBeat.o(256431);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.b.a cJu()
  {
    AppMethodBeat.i(256430);
    if (this.rpx.size() <= 0)
    {
      AppMethodBeat.o(256430);
      return null;
    }
    int i = this.aTi.save();
    this.aTi.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.aTi.concat(this.rpz);
    this.rpy = this.rpA.a(this.aTi, this.paint);
    this.aTi.restoreToCount(i);
    com.tencent.mm.plugin.recordvideo.ui.editor.b.a locala = new com.tencent.mm.plugin.recordvideo.ui.editor.b.a(this.bitmap, this.rpy);
    AppMethodBeat.o(256430);
    return locala;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(260);
    Iterator localIterator = this.rpx.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).destroy();
    }
    AppMethodBeat.o(260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.a
 * JD-Core Version:    0.7.0.1
 */