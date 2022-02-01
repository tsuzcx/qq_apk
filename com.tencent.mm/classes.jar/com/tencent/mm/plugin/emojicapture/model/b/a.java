package com.tencent.mm.plugin.emojicapture.model.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "Lcom/tencent/mm/media/mix/FrameRetriever;", "preViewRect", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "currFrameTime", "", "drawer", "Lcom/tencent/mm/media/mix/EditorFrameDrawer;", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "height", "", "paint", "Landroid/graphics/Paint;", "preViewMatrix", "Landroid/graphics/Matrix;", "width", "addItem", "", "item", "requestNextFrame", "Lcom/tencent/mm/media/mix/FrameInfo;", "start", "stop", "plugin-emojicapture_release"})
public final class a
  implements com.tencent.mm.media.g.d
{
  private final Bitmap bitmap;
  private final Canvas btq;
  private long goC;
  List<com.tencent.mm.media.editor.a.b> grO;
  private int height;
  private final Matrix oLb;
  private final com.tencent.mm.media.g.b oLc;
  private final Paint paint;
  private int width;
  
  public a(RectF paramRectF)
  {
    AppMethodBeat.i(262);
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    this.width = com.tencent.mm.plugin.emojicapture.model.d.bXy();
    localObject = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    this.height = com.tencent.mm.plugin.emojicapture.model.d.bXy();
    this.grO = ((List)new ArrayList());
    this.oLb = new Matrix();
    this.paint = new Paint();
    this.oLc = new com.tencent.mm.media.g.b(this.grO);
    localObject = this.oLb;
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
    k.g(paramRectF, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
    this.bitmap = paramRectF;
    this.btq = new Canvas(this.bitmap);
    AppMethodBeat.o(262);
  }
  
  public final void a(com.tencent.mm.media.editor.a.b paramb)
  {
    AppMethodBeat.i(261);
    if (paramb != null) {
      this.grO.add(paramb);
    }
    AppMethodBeat.o(261);
  }
  
  public final c aka()
  {
    AppMethodBeat.i(259);
    if (this.grO.size() <= 0)
    {
      AppMethodBeat.o(259);
      return null;
    }
    int i = this.btq.save();
    this.btq.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.btq.concat(this.oLb);
    this.goC = this.oLc.a(this.btq, this.paint);
    this.btq.restoreToCount(i);
    c localc = new c(this.bitmap, this.goC);
    AppMethodBeat.o(259);
    return localc;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(260);
    Iterator localIterator = this.grO.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.media.editor.a.b)localIterator.next()).destroy();
    }
    AppMethodBeat.o(260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.a
 * JD-Core Version:    0.7.0.1
 */