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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;)V", "basicScale", "", "clipPath", "Landroid/graphics/Path;", "drawingBounds", "Landroid/graphics/Rect;", "framePadding", "frameRect", "frameStroke", "isClipping", "", "isEditing", "maxScale", "minScale", "originPivot", "", "paint", "Landroid/graphics/Paint;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validBounds", "Landroid/graphics/RectF;", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "onTouch", "event", "Landroid/view/MotionEvent;", "resetMatrix", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "radius", "Companion", "plugin-emojicapture_release"})
public final class b
  implements c.a
{
  public static final b.a rrf;
  private float aXt;
  private float aXu;
  private final Paint paint;
  private final c rqT;
  private final RectF rqU;
  private final Path rqV;
  private final Rect rqW;
  private boolean rqX;
  private boolean rqY;
  private float rqZ;
  private final float rra;
  private final float rrb;
  private final float rrc;
  private final float[] rrd;
  private final c.b rre;
  
  static
  {
    AppMethodBeat.i(343);
    rrf = new b.a((byte)0);
    AppMethodBeat.o(343);
  }
  
  public b(c.b paramb)
  {
    AppMethodBeat.i(342);
    this.rre = paramb;
    this.rqT = new c();
    this.rqU = new RectF();
    this.rqV = new Path();
    this.rqW = new Rect();
    this.paint = new Paint();
    this.rqY = true;
    this.rqZ = 1.0F;
    this.aXt = 2.0F;
    this.aXu = 0.25F;
    this.rrd = new float[2];
    paramb = this.rre;
    if (paramb == null)
    {
      paramb = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(342);
      throw paramb;
    }
    paramb = ((View)paramb).getContext();
    p.g(paramb, "(view as View).context");
    paramb = paramb.getResources();
    this.rqT.aXt = this.aXt;
    this.rqT.aXu = this.aXu;
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(paramb.getDimension(2131166229));
    this.paint.setStyle(Paint.Style.FILL);
    this.rra = paramb.getDimension(2131166229);
    this.rrb = paramb.getDimension(2131166227);
    this.rrc = paramb.getDimension(2131166228);
    AppMethodBeat.o(342);
  }
  
  private final void resetMatrix()
  {
    AppMethodBeat.i(337);
    this.rqT.gT.reset();
    this.rqT.gT.postTranslate(-this.rqW.width() / 2.0F, -this.rqW.height() / 2.0F);
    if ((!this.rqU.isEmpty()) && (!this.rqW.isEmpty()))
    {
      int i = Math.max(this.rqW.width(), this.rqW.height());
      this.rqZ = (this.rqU.width() / i);
      float f = this.rqZ * 0.5F;
      this.aXt = (this.rqZ * 2.0F);
      this.aXu = (this.rqZ * 0.25F);
      this.rqT.aXt = this.aXt;
      this.rqT.aXu = this.aXu;
      this.rqT.gT.postScale(f, f);
    }
    this.rqT.gT.postTranslate((this.rqU.left + this.rqU.right) / 2.0F, (this.rqU.top + this.rqU.bottom) / 2.0F);
    AppMethodBeat.o(337);
  }
  
  public final boolean R(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(339);
    p.h(paramMotionEvent, "event");
    Object localObject = this.rre.getItemContainer();
    if (this.rqT.Y(paramMotionEvent))
    {
      if (localObject != null) {
        ((EditorItemContainer)localObject).a((com.tencent.mm.plugin.emojicapture.ui.editor.a)this.rre, paramMotionEvent);
      }
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        paramMotionEvent = this.rre;
        if (paramMotionEvent != null) {
          break;
        }
        paramMotionEvent = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(339);
        throw paramMotionEvent;
        this.rqY = true;
        paramMotionEvent = this.rre;
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(339);
          throw paramMotionEvent;
        }
        ((View)paramMotionEvent).bringToFront();
        this.rrd[0] = (this.rqT.width / 2.0F);
        this.rrd[1] = (this.rqT.height / 2.0F);
        this.rqT.gT.mapPoints(this.rrd);
        continue;
        this.rqY = false;
        continue;
        this.rqY = true;
        paramMotionEvent = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        paramMotionEvent.aXu = this.aXu;
        paramMotionEvent.aXt = this.aXt;
        paramMotionEvent.n(new float[] { this.rqW.width() / 2.0F, this.rqW.height() / 2.0F });
        paramMotionEvent.f(new RectF(this.rqU.left, this.rqU.top, this.rqU.right, this.rqU.bottom));
        localObject = new float[2];
        localObject[0] = (this.rqT.width / 2.0F);
        localObject[1] = (this.rqT.height / 2.0F);
        this.rqT.gT.mapPoints((float[])localObject);
        if (!paramMotionEvent.CgM.contains(localObject[0], localObject[1])) {
          paramMotionEvent.f(new RectF(this.rrd[0], this.rrd[1], this.rrd[0], this.rrd[1]));
        }
        paramMotionEvent.a(this.rqT.gT, (m)new b(this));
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
    p.h(paramRectF, "bounds");
    this.rqU.set(paramRectF);
    this.rqV.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    resetMatrix();
    AppMethodBeat.o(336);
  }
  
  public final void fF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335);
    this.rqT.width = paramInt1;
    this.rqT.height = paramInt2;
    this.rqW.right = paramInt1;
    this.rqW.bottom = paramInt2;
    resetMatrix();
    AppMethodBeat.o(335);
  }
  
  public final c getTouchTracker()
  {
    return this.rqT;
  }
  
  public final void q(Canvas paramCanvas)
  {
    AppMethodBeat.i(340);
    p.h(paramCanvas, "canvas");
    if (this.rqY) {
      paramCanvas.clipPath(this.rqV);
    }
    paramCanvas.setMatrix(this.rqT.gT);
    if (this.rqX)
    {
      float f1 = this.rqW.left - this.rrb / this.rqZ;
      float f2 = this.rqW.top - this.rrb / this.rqZ;
      float f3 = this.rqW.right + this.rrb / this.rqZ;
      float f4 = this.rqW.bottom + this.rrb / this.rqZ;
      float f5 = this.rrc / 2.0F / this.rqZ;
      this.paint.setStrokeWidth(this.rra / this.rqZ);
      paramCanvas.drawRect(f1 - f5, f2 - f5, f1 + f5, f2 + f5, this.paint);
      paramCanvas.drawRect(f3 - f5, f2 - f5, f3 + f5, f2 + f5, this.paint);
      paramCanvas.drawRect(f3 - f5, f4 - f5, f3 + f5, f4 + f5, this.paint);
      paramCanvas.drawRect(f1 - f5, f4 - f5, f1 + f5, f4 + f5, this.paint);
      Paint localPaint = this.paint;
      paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    }
    AppMethodBeat.o(340);
  }
  
  public final void r(Canvas paramCanvas)
  {
    AppMethodBeat.i(341);
    p.h(paramCanvas, "canvas");
    AppMethodBeat.o(341);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(338);
    this.rqX = paramBoolean;
    Object localObject = this.rre;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(338);
      throw ((Throwable)localObject);
    }
    ((View)localObject).postInvalidate();
    AppMethodBeat.o(338);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.b
 * JD-Core Version:    0.7.0.1
 */