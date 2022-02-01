package com.tencent.mm.plugin.emojicapture.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.emojicapture.c.c.b;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.c.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;)V", "basicScale", "", "clipPath", "Landroid/graphics/Path;", "drawingBounds", "Landroid/graphics/Rect;", "framePadding", "frameRect", "frameStroke", "isClipping", "", "isEditing", "maxScale", "minScale", "originPivot", "", "paint", "Landroid/graphics/Paint;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validBounds", "Landroid/graphics/RectF;", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "onTouch", "event", "Landroid/view/MotionEvent;", "resetMatrix", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "radius", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements c.a
{
  public static final b.a yiX;
  private boolean aPk;
  private float maxScale;
  private float minScale;
  private final Paint paint;
  private final c.b yiY;
  private final c yiZ;
  private final RectF yja;
  private final Path yjb;
  private final Rect yjc;
  private boolean yjd;
  private float yje;
  private final float yjf;
  private final float yjg;
  private final float yjh;
  private final float[] yji;
  
  static
  {
    AppMethodBeat.i(343);
    yiX = new b.a((byte)0);
    AppMethodBeat.o(343);
  }
  
  public b(c.b paramb)
  {
    AppMethodBeat.i(342);
    this.yiY = paramb;
    this.yiZ = new c();
    this.yja = new RectF();
    this.yjb = new Path();
    this.yjc = new Rect();
    this.paint = new Paint();
    this.aPk = true;
    this.yje = 1.0F;
    this.maxScale = 2.0F;
    this.minScale = 0.25F;
    this.yji = new float[2];
    paramb = ((View)this.yiY).getContext().getResources();
    this.yiZ.maxScale = this.maxScale;
    this.yiZ.minScale = this.minScale;
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(paramb.getDimension(a.d.editor_item_frame_stroke));
    this.paint.setStyle(Paint.Style.FILL);
    this.yjf = paramb.getDimension(a.d.editor_item_frame_stroke);
    this.yjg = paramb.getDimension(a.d.editor_item_frame_padding);
    this.yjh = paramb.getDimension(a.d.editor_item_frame_rect);
    AppMethodBeat.o(342);
  }
  
  private final void resetMatrix()
  {
    AppMethodBeat.i(337);
    this.yiZ.matrix.reset();
    this.yiZ.matrix.postTranslate(-this.yjc.width() / 2.0F, -this.yjc.height() / 2.0F);
    if ((!this.yja.isEmpty()) && (!this.yjc.isEmpty()))
    {
      int i = Math.max(this.yjc.width(), this.yjc.height());
      this.yje = (this.yja.width() / i);
      float f = this.yje * 0.5F;
      this.maxScale = (this.yje * 2.0F);
      this.minScale = (this.yje * 0.25F);
      this.yiZ.maxScale = this.maxScale;
      this.yiZ.minScale = this.minScale;
      this.yiZ.matrix.postScale(f, f);
    }
    this.yiZ.matrix.postTranslate((this.yja.left + this.yja.right) / 2.0F, (this.yja.top + this.yja.bottom) / 2.0F);
    AppMethodBeat.o(337);
  }
  
  public final boolean Z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(339);
    s.u(paramMotionEvent, "event");
    Object localObject = this.yiY.getItemContainer();
    if (this.yiZ.ak(paramMotionEvent))
    {
      if (localObject != null) {
        ((EditorItemContainer)localObject).a((com.tencent.mm.plugin.emojicapture.ui.editor.a)this.yiY, paramMotionEvent);
      }
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        ((View)this.yiY).invalidate();
        AppMethodBeat.o(339);
        return true;
        this.aPk = true;
        ((View)this.yiY).bringToFront();
        this.yji[0] = (this.yiZ.width / 2.0F);
        this.yji[1] = (this.yiZ.height / 2.0F);
        this.yiZ.matrix.mapPoints(this.yji);
        continue;
        this.aPk = false;
        continue;
        this.aPk = true;
        paramMotionEvent = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        paramMotionEvent.minScale = this.minScale;
        paramMotionEvent.maxScale = this.maxScale;
        paramMotionEvent.w(new float[] { this.yjc.width() / 2.0F, this.yjc.height() / 2.0F });
        paramMotionEvent.g(new RectF(this.yja.left, this.yja.top, this.yja.right, this.yja.bottom));
        localObject = new float[2];
        localObject[0] = (this.yiZ.width / 2.0F);
        localObject[1] = (this.yiZ.height / 2.0F);
        this.yiZ.matrix.mapPoints((float[])localObject);
        if (!paramMotionEvent.NZY.contains(localObject[0], localObject[1])) {
          paramMotionEvent.g(new RectF(this.yji[0], this.yji[1], this.yji[0], this.yji[1]));
        }
        paramMotionEvent.a(this.yiZ.matrix, (m)new b(this));
      }
    }
    AppMethodBeat.o(339);
    return false;
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(336);
    s.u(paramRectF, "bounds");
    this.yja.set(paramRectF);
    this.yjb.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    resetMatrix();
    AppMethodBeat.o(336);
  }
  
  public final void gV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335);
    this.yiZ.width = paramInt1;
    this.yiZ.height = paramInt2;
    this.yjc.right = paramInt1;
    this.yjc.bottom = paramInt2;
    resetMatrix();
    AppMethodBeat.o(335);
  }
  
  public final c getTouchTracker()
  {
    return this.yiZ;
  }
  
  public final void n(Canvas paramCanvas)
  {
    AppMethodBeat.i(340);
    s.u(paramCanvas, "canvas");
    if (this.aPk) {
      paramCanvas.clipPath(this.yjb);
    }
    paramCanvas.setMatrix(this.yiZ.matrix);
    if (this.yjd)
    {
      float f1 = this.yjc.left - this.yjg / this.yje;
      float f2 = this.yjc.top - this.yjg / this.yje;
      float f3 = this.yjc.right + this.yjg / this.yje;
      float f4 = this.yjc.bottom + this.yjg / this.yje;
      float f5 = this.yjh / 2.0F / this.yje;
      this.paint.setStrokeWidth(this.yjf / this.yje);
      paramCanvas.drawRect(f1 - f5, f2 - f5, f1 + f5, f2 + f5, this.paint);
      paramCanvas.drawRect(f3 - f5, f2 - f5, f3 + f5, f2 + f5, this.paint);
      paramCanvas.drawRect(f3 - f5, f4 - f5, f3 + f5, f4 + f5, this.paint);
      paramCanvas.drawRect(f1 - f5, f4 - f5, f1 + f5, f4 + f5, this.paint);
      Paint localPaint = this.paint;
      paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    }
    AppMethodBeat.o(340);
  }
  
  public final void o(Canvas paramCanvas)
  {
    AppMethodBeat.i(341);
    s.u(paramCanvas, "canvas");
    AppMethodBeat.o(341);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(338);
    this.yjd = paramBoolean;
    ((View)this.yiY).postInvalidate();
    AppMethodBeat.o(338);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Matrix, Boolean, ah>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.b
 * JD-Core Version:    0.7.0.1
 */