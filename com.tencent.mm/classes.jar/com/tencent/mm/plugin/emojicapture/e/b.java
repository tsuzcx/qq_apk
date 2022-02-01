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
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;)V", "basicScale", "", "clipPath", "Landroid/graphics/Path;", "drawingBounds", "Landroid/graphics/Rect;", "framePadding", "frameRect", "frameStroke", "isClipping", "", "isEditing", "maxScale", "minScale", "originPivot", "", "paint", "Landroid/graphics/Paint;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validBounds", "Landroid/graphics/RectF;", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "onTouch", "event", "Landroid/view/MotionEvent;", "resetMatrix", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "radius", "Companion", "plugin-emojicapture_release"})
public final class b
  implements c.a
{
  public static final a uWL;
  private float aGN;
  private float aGO;
  private final Paint paint;
  private final RectF uWA;
  private final Path uWB;
  private final Rect uWC;
  private boolean uWD;
  private boolean uWE;
  private float uWF;
  private final float uWG;
  private final float uWH;
  private final float uWI;
  private final float[] uWJ;
  private final c.b uWK;
  private final c uWz;
  
  static
  {
    AppMethodBeat.i(343);
    uWL = new a((byte)0);
    AppMethodBeat.o(343);
  }
  
  public b(c.b paramb)
  {
    AppMethodBeat.i(342);
    this.uWK = paramb;
    this.uWz = new c();
    this.uWA = new RectF();
    this.uWB = new Path();
    this.uWC = new Rect();
    this.paint = new Paint();
    this.uWE = true;
    this.uWF = 1.0F;
    this.aGN = 2.0F;
    this.aGO = 0.25F;
    this.uWJ = new float[2];
    paramb = this.uWK;
    if (paramb == null)
    {
      paramb = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(342);
      throw paramb;
    }
    paramb = ((View)paramb).getContext();
    p.j(paramb, "(view as View).context");
    paramb = paramb.getResources();
    this.uWz.aGN = this.aGN;
    this.uWz.aGO = this.aGO;
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(paramb.getDimension(a.d.editor_item_frame_stroke));
    this.paint.setStyle(Paint.Style.FILL);
    this.uWG = paramb.getDimension(a.d.editor_item_frame_stroke);
    this.uWH = paramb.getDimension(a.d.editor_item_frame_padding);
    this.uWI = paramb.getDimension(a.d.editor_item_frame_rect);
    AppMethodBeat.o(342);
  }
  
  private final void resetMatrix()
  {
    AppMethodBeat.i(337);
    this.uWz.aHZ.reset();
    this.uWz.aHZ.postTranslate(-this.uWC.width() / 2.0F, -this.uWC.height() / 2.0F);
    if ((!this.uWA.isEmpty()) && (!this.uWC.isEmpty()))
    {
      int i = Math.max(this.uWC.width(), this.uWC.height());
      this.uWF = (this.uWA.width() / i);
      float f = this.uWF * 0.5F;
      this.aGN = (this.uWF * 2.0F);
      this.aGO = (this.uWF * 0.25F);
      this.uWz.aGN = this.aGN;
      this.uWz.aGO = this.aGO;
      this.uWz.aHZ.postScale(f, f);
    }
    this.uWz.aHZ.postTranslate((this.uWA.left + this.uWA.right) / 2.0F, (this.uWA.top + this.uWA.bottom) / 2.0F);
    AppMethodBeat.o(337);
  }
  
  public final boolean X(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(339);
    p.k(paramMotionEvent, "event");
    Object localObject = this.uWK.getItemContainer();
    if (this.uWz.ah(paramMotionEvent))
    {
      if (localObject != null) {
        ((EditorItemContainer)localObject).a((com.tencent.mm.plugin.emojicapture.ui.editor.a)this.uWK, paramMotionEvent);
      }
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        paramMotionEvent = this.uWK;
        if (paramMotionEvent != null) {
          break;
        }
        paramMotionEvent = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(339);
        throw paramMotionEvent;
        this.uWE = true;
        paramMotionEvent = this.uWK;
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(339);
          throw paramMotionEvent;
        }
        ((View)paramMotionEvent).bringToFront();
        this.uWJ[0] = (this.uWz.width / 2.0F);
        this.uWJ[1] = (this.uWz.height / 2.0F);
        this.uWz.aHZ.mapPoints(this.uWJ);
        continue;
        this.uWE = false;
        continue;
        this.uWE = true;
        paramMotionEvent = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        paramMotionEvent.aGO = this.aGO;
        paramMotionEvent.aGN = this.aGN;
        paramMotionEvent.o(new float[] { this.uWC.width() / 2.0F, this.uWC.height() / 2.0F });
        paramMotionEvent.f(new RectF(this.uWA.left, this.uWA.top, this.uWA.right, this.uWA.bottom));
        localObject = new float[2];
        localObject[0] = (this.uWz.width / 2.0F);
        localObject[1] = (this.uWz.height / 2.0F);
        this.uWz.aHZ.mapPoints((float[])localObject);
        if (!paramMotionEvent.IdC.contains(localObject[0], localObject[1])) {
          paramMotionEvent.f(new RectF(this.uWJ[0], this.uWJ[1], this.uWJ[0], this.uWJ[1]));
        }
        paramMotionEvent.a(this.uWz.aHZ, (m)new b(this));
      }
      ((View)paramMotionEvent).invalidate();
      AppMethodBeat.o(339);
      return true;
    }
    AppMethodBeat.o(339);
    return false;
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(336);
    p.k(paramRectF, "bounds");
    this.uWA.set(paramRectF);
    this.uWB.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    resetMatrix();
    AppMethodBeat.o(336);
  }
  
  public final void gc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335);
    this.uWz.width = paramInt1;
    this.uWz.height = paramInt2;
    this.uWC.right = paramInt1;
    this.uWC.bottom = paramInt2;
    resetMatrix();
    AppMethodBeat.o(335);
  }
  
  public final c getTouchTracker()
  {
    return this.uWz;
  }
  
  public final void s(Canvas paramCanvas)
  {
    AppMethodBeat.i(340);
    p.k(paramCanvas, "canvas");
    if (this.uWE) {
      paramCanvas.clipPath(this.uWB);
    }
    paramCanvas.setMatrix(this.uWz.aHZ);
    if (this.uWD)
    {
      float f1 = this.uWC.left - this.uWH / this.uWF;
      float f2 = this.uWC.top - this.uWH / this.uWF;
      float f3 = this.uWC.right + this.uWH / this.uWF;
      float f4 = this.uWC.bottom + this.uWH / this.uWF;
      float f5 = this.uWI / 2.0F / this.uWF;
      this.paint.setStrokeWidth(this.uWG / this.uWF);
      paramCanvas.drawRect(f1 - f5, f2 - f5, f1 + f5, f2 + f5, this.paint);
      paramCanvas.drawRect(f3 - f5, f2 - f5, f3 + f5, f2 + f5, this.paint);
      paramCanvas.drawRect(f3 - f5, f4 - f5, f3 + f5, f4 + f5, this.paint);
      paramCanvas.drawRect(f1 - f5, f4 - f5, f1 + f5, f4 + f5, this.paint);
      Paint localPaint = this.paint;
      paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    }
    AppMethodBeat.o(340);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(338);
    this.uWD = paramBoolean;
    Object localObject = this.uWK;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(338);
      throw ((Throwable)localObject);
    }
    ((View)localObject).postInvalidate();
    AppMethodBeat.o(338);
  }
  
  public final void t(Canvas paramCanvas)
  {
    AppMethodBeat.i(341);
    p.k(paramCanvas, "canvas");
    AppMethodBeat.o(341);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter$Companion;", "", "()V", "DEFAULT_SCALE_TO_BOUNDS", "", "MAX_SCALE_TO_BOUNDS", "MIN_SCALE_TO_BOUNDS", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
  static final class b
    extends q
    implements m<Matrix, Boolean, x>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.b
 * JD-Core Version:    0.7.0.1
 */