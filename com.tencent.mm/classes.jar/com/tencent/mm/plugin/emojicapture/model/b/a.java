package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "Lcom/tencent/mm/media/mix/FrameRetriever;", "preViewRect", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "currFrameTime", "", "drawer", "Lcom/tencent/mm/media/mix/EditorFrameDrawer;", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "height", "", "paint", "Landroid/graphics/Paint;", "preViewMatrix", "Landroid/graphics/Matrix;", "width", "addItem", "", "item", "requestNextFrame", "Lcom/tencent/mm/media/mix/FrameInfo;", "start", "stop", "plugin-emojicapture_release"})
public final class a
  implements d
{
  private final Canvas aVn;
  private final Bitmap bitmap;
  private long eSz;
  List<com.tencent.mm.media.editor.a.b> eVw;
  private int height;
  private final Matrix lui;
  private final com.tencent.mm.media.f.b luj;
  private final Paint paint;
  private int width;
  
  public a(RectF paramRectF)
  {
    AppMethodBeat.i(2662);
    Object localObject = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    this.width = com.tencent.mm.plugin.emojicapture.model.c.bnP();
    localObject = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    this.height = com.tencent.mm.plugin.emojicapture.model.c.bnP();
    this.eVw = ((List)new ArrayList());
    this.lui = new Matrix();
    this.paint = new Paint();
    this.luj = new com.tencent.mm.media.f.b(this.eVw);
    localObject = this.lui;
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
    j.p(paramRectF, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
    this.bitmap = paramRectF;
    this.aVn = new Canvas(this.bitmap);
    AppMethodBeat.o(2662);
  }
  
  public final com.tencent.mm.media.f.c UX()
  {
    AppMethodBeat.i(2659);
    if (this.eVw.size() <= 0)
    {
      AppMethodBeat.o(2659);
      return null;
    }
    int i = this.aVn.save();
    this.aVn.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.aVn.concat(this.lui);
    this.eSz = this.luj.a(this.aVn, this.paint);
    this.aVn.restoreToCount(i);
    com.tencent.mm.media.f.c localc = new com.tencent.mm.media.f.c(this.bitmap, this.eSz);
    AppMethodBeat.o(2659);
    return localc;
  }
  
  public final void a(com.tencent.mm.media.editor.a.b paramb)
  {
    AppMethodBeat.i(2661);
    if (paramb != null) {
      this.eVw.add(paramb);
    }
    AppMethodBeat.o(2661);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(2660);
    Iterator localIterator = this.eVw.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.media.editor.a.b)localIterator.next()).destroy();
    }
    AppMethodBeat.o(2660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.a
 * JD-Core Version:    0.7.0.1
 */