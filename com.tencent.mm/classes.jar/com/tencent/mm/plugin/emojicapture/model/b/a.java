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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "preViewRect", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "currFrameTime", "", "drawer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "height", "", "paint", "Landroid/graphics/Paint;", "preViewMatrix", "Landroid/graphics/Matrix;", "width", "addItem", "", "item", "requestNextFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "start", "stop", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.recordvideo.ui.editor.b.b
{
  private final Bitmap bitmap;
  private final Canvas cxr;
  private int height;
  private final Paint paint;
  private int width;
  List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> yhJ;
  private long yhK;
  private final Matrix yhL;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.b yhM;
  
  public a(RectF paramRectF)
  {
    AppMethodBeat.i(262);
    Object localObject = d.ygM;
    this.width = d.dDF();
    localObject = d.ygM;
    this.height = d.dDF();
    this.yhJ = ((List)new ArrayList());
    this.yhL = new Matrix();
    this.paint = new Paint();
    this.yhM = new com.tencent.mm.plugin.recordvideo.ui.editor.b(this.yhJ);
    localObject = this.yhL;
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
    s.s(paramRectF, "createBitmap(width, heig… Bitmap.Config.ARGB_8888)");
    this.bitmap = paramRectF;
    this.cxr = new Canvas(this.bitmap);
    AppMethodBeat.o(262);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a parama)
  {
    AppMethodBeat.i(269390);
    if (parama != null) {
      this.yhJ.add(parama);
    }
    AppMethodBeat.o(269390);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.b.a dEs()
  {
    AppMethodBeat.i(269386);
    if (this.yhJ.size() <= 0)
    {
      AppMethodBeat.o(269386);
      return null;
    }
    int i = this.cxr.save();
    this.cxr.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.cxr.concat(this.yhL);
    this.yhK = this.yhM.a(this.cxr, this.paint);
    this.cxr.restoreToCount(i);
    com.tencent.mm.plugin.recordvideo.ui.editor.b.a locala = new com.tencent.mm.plugin.recordvideo.ui.editor.b.a(this.bitmap, this.yhK);
    AppMethodBeat.o(269386);
    return locala;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(260);
    Iterator localIterator = this.yhJ.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).destroy();
    }
    AppMethodBeat.o(260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.a
 * JD-Core Version:    0.7.0.1
 */