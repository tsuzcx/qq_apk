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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;)V", "basicScale", "", "clipPath", "Landroid/graphics/Path;", "drawingBounds", "Landroid/graphics/Rect;", "framePadding", "frameRect", "frameStroke", "isClipping", "", "isEditing", "maxScale", "minScale", "originPivot", "", "paint", "Landroid/graphics/Paint;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validBounds", "Landroid/graphics/RectF;", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "onTouch", "event", "Landroid/view/MotionEvent;", "resetMatrix", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "radius", "Companion", "plugin-emojicapture_release"})
public final class b
  implements c.a
{
  public static final b.a pTD;
  private float aXE;
  private float aXF;
  private final float pTA;
  private final float[] pTB;
  private final c.b pTC;
  private final c pTr;
  private final RectF pTs;
  private final Path pTt;
  private final Rect pTu;
  private boolean pTv;
  private boolean pTw;
  private float pTx;
  private final float pTy;
  private final float pTz;
  private final Paint paint;
  
  static
  {
    AppMethodBeat.i(343);
    pTD = new b.a((byte)0);
    AppMethodBeat.o(343);
  }
  
  public b(c.b paramb)
  {
    AppMethodBeat.i(342);
    this.pTC = paramb;
    this.pTr = new c();
    this.pTs = new RectF();
    this.pTt = new Path();
    this.pTu = new Rect();
    this.paint = new Paint();
    this.pTw = true;
    this.pTx = 1.0F;
    this.aXE = 2.0F;
    this.aXF = 0.25F;
    this.pTB = new float[2];
    paramb = this.pTC;
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(342);
      throw paramb;
    }
    paramb = ((View)paramb).getContext();
    p.g(paramb, "(view as View).context");
    paramb = paramb.getResources();
    this.pTr.aXE = this.aXE;
    this.pTr.aXF = this.aXF;
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(paramb.getDimension(2131166188));
    this.paint.setStyle(Paint.Style.FILL);
    this.pTy = paramb.getDimension(2131166188);
    this.pTz = paramb.getDimension(2131166186);
    this.pTA = paramb.getDimension(2131166187);
    AppMethodBeat.o(342);
  }
  
  private final void resetMatrix()
  {
    AppMethodBeat.i(337);
    this.pTr.gR.reset();
    this.pTr.gR.postTranslate(-this.pTu.width() / 2.0F, -this.pTu.height() / 2.0F);
    if ((!this.pTs.isEmpty()) && (!this.pTu.isEmpty()))
    {
      int i = Math.max(this.pTu.width(), this.pTu.height());
      this.pTx = (this.pTs.width() / i);
      float f = this.pTx * 0.5F;
      this.aXE = (this.pTx * 2.0F);
      this.aXF = (this.pTx * 0.25F);
      this.pTr.aXE = this.aXE;
      this.pTr.aXF = this.aXF;
      this.pTr.gR.postScale(f, f);
    }
    this.pTr.gR.postTranslate((this.pTs.left + this.pTs.right) / 2.0F, (this.pTs.top + this.pTs.bottom) / 2.0F);
    AppMethodBeat.o(337);
  }
  
  public final boolean P(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(339);
    p.h(paramMotionEvent, "event");
    Object localObject = this.pTC.getItemContainer();
    if (this.pTr.W(paramMotionEvent))
    {
      if (localObject != null) {
        ((EditorItemContainer)localObject).a((com.tencent.mm.plugin.emojicapture.ui.editor.a)this.pTC, paramMotionEvent);
      }
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        paramMotionEvent = this.pTC;
        if (paramMotionEvent != null) {
          break;
        }
        paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(339);
        throw paramMotionEvent;
        this.pTw = true;
        paramMotionEvent = this.pTC;
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(339);
          throw paramMotionEvent;
        }
        ((View)paramMotionEvent).bringToFront();
        this.pTB[0] = (this.pTr.width / 2.0F);
        this.pTB[1] = (this.pTr.height / 2.0F);
        this.pTr.gR.mapPoints(this.pTB);
        continue;
        this.pTw = false;
        continue;
        this.pTw = true;
        paramMotionEvent = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        paramMotionEvent.aXF = this.aXF;
        paramMotionEvent.aXE = this.aXE;
        paramMotionEvent.n(new float[] { this.pTu.width() / 2.0F, this.pTu.height() / 2.0F });
        paramMotionEvent.f(new RectF(this.pTs.left, this.pTs.top, this.pTs.right, this.pTs.bottom));
        localObject = new float[2];
        localObject[0] = (this.pTr.width / 2.0F);
        localObject[1] = (this.pTr.height / 2.0F);
        this.pTr.gR.mapPoints((float[])localObject);
        if (!paramMotionEvent.xPV.contains(localObject[0], localObject[1])) {
          paramMotionEvent.f(new RectF(this.pTB[0], this.pTB[1], this.pTB[0], this.pTB[1]));
        }
        paramMotionEvent.a(this.pTr.gR, (m)new b(this));
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
    this.pTs.set(paramRectF);
    this.pTt.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    resetMatrix();
    AppMethodBeat.o(336);
  }
  
  public final void fo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335);
    this.pTr.width = paramInt1;
    this.pTr.height = paramInt2;
    this.pTu.right = paramInt1;
    this.pTu.bottom = paramInt2;
    resetMatrix();
    AppMethodBeat.o(335);
  }
  
  public final c getTouchTracker()
  {
    return this.pTr;
  }
  
  public final void j(Canvas paramCanvas)
  {
    AppMethodBeat.i(340);
    p.h(paramCanvas, "canvas");
    if (this.pTw) {
      paramCanvas.clipPath(this.pTt);
    }
    paramCanvas.setMatrix(this.pTr.gR);
    if (this.pTv)
    {
      float f1 = this.pTu.left - this.pTz / this.pTx;
      float f2 = this.pTu.top - this.pTz / this.pTx;
      float f3 = this.pTu.right + this.pTz / this.pTx;
      float f4 = this.pTu.bottom + this.pTz / this.pTx;
      float f5 = this.pTA / 2.0F / this.pTx;
      this.paint.setStrokeWidth(this.pTy / this.pTx);
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
    this.pTv = paramBoolean;
    Object localObject = this.pTC;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(338);
      throw ((Throwable)localObject);
    }
    ((View)localObject).postInvalidate();
    AppMethodBeat.o(338);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
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