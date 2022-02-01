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
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;)V", "basicScale", "", "clipPath", "Landroid/graphics/Path;", "drawingBounds", "Landroid/graphics/Rect;", "framePadding", "frameRect", "frameStroke", "isClipping", "", "isEditing", "maxScale", "minScale", "originPivot", "", "paint", "Landroid/graphics/Paint;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validBounds", "Landroid/graphics/RectF;", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "onTouch", "event", "Landroid/view/MotionEvent;", "resetMatrix", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "radius", "Companion", "plugin-emojicapture_release"})
public final class b
  implements c.a
{
  public static final b.a qai;
  private float aXE;
  private float aXF;
  private final c pZW;
  private final RectF pZX;
  private final Path pZY;
  private final Rect pZZ;
  private final Paint paint;
  private boolean qaa;
  private boolean qab;
  private float qac;
  private final float qad;
  private final float qae;
  private final float qaf;
  private final float[] qag;
  private final c.b qah;
  
  static
  {
    AppMethodBeat.i(343);
    qai = new b.a((byte)0);
    AppMethodBeat.o(343);
  }
  
  public b(c.b paramb)
  {
    AppMethodBeat.i(342);
    this.qah = paramb;
    this.pZW = new c();
    this.pZX = new RectF();
    this.pZY = new Path();
    this.pZZ = new Rect();
    this.paint = new Paint();
    this.qab = true;
    this.qac = 1.0F;
    this.aXE = 2.0F;
    this.aXF = 0.25F;
    this.qag = new float[2];
    paramb = this.qah;
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(342);
      throw paramb;
    }
    paramb = ((View)paramb).getContext();
    p.g(paramb, "(view as View).context");
    paramb = paramb.getResources();
    this.pZW.aXE = this.aXE;
    this.pZW.aXF = this.aXF;
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(paramb.getDimension(2131166188));
    this.paint.setStyle(Paint.Style.FILL);
    this.qad = paramb.getDimension(2131166188);
    this.qae = paramb.getDimension(2131166186);
    this.qaf = paramb.getDimension(2131166187);
    AppMethodBeat.o(342);
  }
  
  private final void resetMatrix()
  {
    AppMethodBeat.i(337);
    this.pZW.gR.reset();
    this.pZW.gR.postTranslate(-this.pZZ.width() / 2.0F, -this.pZZ.height() / 2.0F);
    if ((!this.pZX.isEmpty()) && (!this.pZZ.isEmpty()))
    {
      int i = Math.max(this.pZZ.width(), this.pZZ.height());
      this.qac = (this.pZX.width() / i);
      float f = this.qac * 0.5F;
      this.aXE = (this.qac * 2.0F);
      this.aXF = (this.qac * 0.25F);
      this.pZW.aXE = this.aXE;
      this.pZW.aXF = this.aXF;
      this.pZW.gR.postScale(f, f);
    }
    this.pZW.gR.postTranslate((this.pZX.left + this.pZX.right) / 2.0F, (this.pZX.top + this.pZX.bottom) / 2.0F);
    AppMethodBeat.o(337);
  }
  
  public final boolean N(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(339);
    p.h(paramMotionEvent, "event");
    Object localObject = this.qah.getItemContainer();
    if (this.pZW.U(paramMotionEvent))
    {
      if (localObject != null) {
        ((EditorItemContainer)localObject).a((com.tencent.mm.plugin.emojicapture.ui.editor.a)this.qah, paramMotionEvent);
      }
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        paramMotionEvent = this.qah;
        if (paramMotionEvent != null) {
          break;
        }
        paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(339);
        throw paramMotionEvent;
        this.qab = true;
        paramMotionEvent = this.qah;
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(339);
          throw paramMotionEvent;
        }
        ((View)paramMotionEvent).bringToFront();
        this.qag[0] = (this.pZW.width / 2.0F);
        this.qag[1] = (this.pZW.height / 2.0F);
        this.pZW.gR.mapPoints(this.qag);
        continue;
        this.qab = false;
        continue;
        this.qab = true;
        paramMotionEvent = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        paramMotionEvent.aXF = this.aXF;
        paramMotionEvent.aXE = this.aXE;
        paramMotionEvent.n(new float[] { this.pZZ.width() / 2.0F, this.pZZ.height() / 2.0F });
        paramMotionEvent.f(new RectF(this.pZX.left, this.pZX.top, this.pZX.right, this.pZX.bottom));
        localObject = new float[2];
        localObject[0] = (this.pZW.width / 2.0F);
        localObject[1] = (this.pZW.height / 2.0F);
        this.pZW.gR.mapPoints((float[])localObject);
        if (!paramMotionEvent.yfO.contains(localObject[0], localObject[1])) {
          paramMotionEvent.f(new RectF(this.qag[0], this.qag[1], this.qag[0], this.qag[1]));
        }
        paramMotionEvent.a(this.pZW.gR, (m)new b(this));
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
    this.pZX.set(paramRectF);
    this.pZY.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    resetMatrix();
    AppMethodBeat.o(336);
  }
  
  public final void fp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335);
    this.pZW.width = paramInt1;
    this.pZW.height = paramInt2;
    this.pZZ.right = paramInt1;
    this.pZZ.bottom = paramInt2;
    resetMatrix();
    AppMethodBeat.o(335);
  }
  
  public final c getTouchTracker()
  {
    return this.pZW;
  }
  
  public final void j(Canvas paramCanvas)
  {
    AppMethodBeat.i(340);
    p.h(paramCanvas, "canvas");
    if (this.qab) {
      paramCanvas.clipPath(this.pZY);
    }
    paramCanvas.setMatrix(this.pZW.gR);
    if (this.qaa)
    {
      float f1 = this.pZZ.left - this.qae / this.qac;
      float f2 = this.pZZ.top - this.qae / this.qac;
      float f3 = this.pZZ.right + this.qae / this.qac;
      float f4 = this.pZZ.bottom + this.qae / this.qac;
      float f5 = this.qaf / 2.0F / this.qac;
      this.paint.setStrokeWidth(this.qad / this.qac);
      paramCanvas.drawRect(f1 - f5, f2 - f5, f1 + f5, f2 + f5, this.paint);
      paramCanvas.drawRect(f3 - f5, f2 - f5, f3 + f5, f2 + f5, this.paint);
      paramCanvas.drawRect(f3 - f5, f4 - f5, f3 + f5, f4 + f5, this.paint);
      paramCanvas.drawRect(f1 - f5, f4 - f5, f1 + f5, f4 + f5, this.paint);
      Paint localPaint = this.paint;
      paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    }
    AppMethodBeat.o(340);
  }
  
  public final void k(Canvas paramCanvas)
  {
    AppMethodBeat.i(341);
    p.h(paramCanvas, "canvas");
    AppMethodBeat.o(341);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(338);
    this.qaa = paramBoolean;
    Object localObject = this.qah;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(338);
      throw ((Throwable)localObject);
    }
    ((View)localObject).postInvalidate();
    AppMethodBeat.o(338);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
  static final class b
    extends q
    implements m<Matrix, Boolean, z>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.b
 * JD-Core Version:    0.7.0.1
 */