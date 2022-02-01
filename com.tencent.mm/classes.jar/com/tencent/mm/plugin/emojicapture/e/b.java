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
import com.tencent.mm.media.editor.c.c;
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.emojicapture.c.c.b;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;)V", "basicScale", "", "clipPath", "Landroid/graphics/Path;", "drawingBounds", "Landroid/graphics/Rect;", "framePadding", "frameRect", "frameStroke", "isClipping", "", "isEditing", "maxScale", "minScale", "paint", "Landroid/graphics/Paint;", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validBounds", "Landroid/graphics/RectF;", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "onTouch", "event", "Landroid/view/MotionEvent;", "resetMatrix", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "radius", "Companion", "plugin-emojicapture_release"})
public final class b
  implements c.a
{
  public static final b.a ppX;
  private float aNk;
  private float aNl;
  private float gQE;
  private final float gQF;
  private final float gQG;
  private final float gQH;
  private final Paint paint;
  private final c ppQ;
  private final RectF ppR;
  private final Path ppS;
  private final Rect ppT;
  private boolean ppU;
  private boolean ppV;
  private final c.b ppW;
  
  static
  {
    AppMethodBeat.i(343);
    ppX = new b.a((byte)0);
    AppMethodBeat.o(343);
  }
  
  public b(c.b paramb)
  {
    AppMethodBeat.i(342);
    this.ppW = paramb;
    this.ppQ = new c();
    this.ppR = new RectF();
    this.ppS = new Path();
    this.ppT = new Rect();
    this.paint = new Paint();
    this.ppV = true;
    this.gQE = 1.0F;
    this.aNk = 2.0F;
    this.aNl = 0.25F;
    paramb = this.ppW;
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(342);
      throw paramb;
    }
    paramb = ((View)paramb).getContext();
    k.g(paramb, "(view as View).context");
    paramb = paramb.getResources();
    this.ppQ.aNk = this.aNk;
    this.ppQ.aNl = this.aNl;
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(paramb.getDimension(2131166188));
    this.paint.setStyle(Paint.Style.FILL);
    this.gQG = paramb.getDimension(2131166188);
    this.gQH = paramb.getDimension(2131166186);
    this.gQF = paramb.getDimension(2131166187);
    AppMethodBeat.o(342);
  }
  
  private final void cfD()
  {
    AppMethodBeat.i(337);
    this.ppQ.eY.reset();
    this.ppQ.eY.postTranslate(-this.ppT.width() / 2.0F, -this.ppT.height() / 2.0F);
    if ((!this.ppR.isEmpty()) && (!this.ppT.isEmpty()))
    {
      int i = Math.max(this.ppT.width(), this.ppT.height());
      this.gQE = (this.ppR.width() / i);
      float f = this.gQE * 0.5F;
      this.aNk = (this.gQE * 2.0F);
      this.aNl = (this.gQE * 0.25F);
      this.ppQ.aNk = this.aNk;
      this.ppQ.aNl = this.aNl;
      this.ppQ.eY.postScale(f, f);
    }
    this.ppQ.eY.postTranslate((this.ppR.left + this.ppR.right) / 2.0F, (this.ppR.top + this.ppR.bottom) / 2.0F);
    AppMethodBeat.o(337);
  }
  
  public final boolean R(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(339);
    k.h(paramMotionEvent, "event");
    EditorItemContainer localEditorItemContainer = this.ppW.getItemContainer();
    if (this.ppQ.t(paramMotionEvent))
    {
      if (localEditorItemContainer != null) {
        localEditorItemContainer.a((com.tencent.mm.plugin.emojicapture.ui.editor.a)this.ppW, paramMotionEvent);
      }
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        paramMotionEvent = this.ppW;
        if (paramMotionEvent != null) {
          break;
        }
        paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(339);
        throw paramMotionEvent;
        this.ppV = true;
        paramMotionEvent = this.ppW;
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(339);
          throw paramMotionEvent;
        }
        ((View)paramMotionEvent).bringToFront();
        continue;
        this.ppV = false;
        continue;
        this.ppV = true;
        paramMotionEvent = new com.tencent.mm.media.editor.c.a();
        paramMotionEvent.aNl = this.aNl;
        paramMotionEvent.aNk = this.aNk;
        paramMotionEvent.k(new float[] { this.ppT.width() / 2.0F, this.ppT.height() / 2.0F });
        paramMotionEvent.e(new RectF(this.ppR.left, this.ppR.top, this.ppR.right, this.ppR.bottom));
        paramMotionEvent.a(this.ppQ.eY, (d.g.a.b)new b(this));
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
    k.h(paramRectF, "bounds");
    this.ppR.set(paramRectF);
    this.ppS.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    cfD();
    AppMethodBeat.o(336);
  }
  
  public final void fk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335);
    this.ppQ.width = paramInt1;
    this.ppQ.height = paramInt2;
    this.ppT.right = paramInt1;
    this.ppT.bottom = paramInt2;
    cfD();
    AppMethodBeat.o(335);
  }
  
  public final c getTouchTracker()
  {
    return this.ppQ;
  }
  
  public final void j(Canvas paramCanvas)
  {
    AppMethodBeat.i(340);
    k.h(paramCanvas, "canvas");
    if (this.ppV) {
      paramCanvas.clipPath(this.ppS);
    }
    paramCanvas.setMatrix(this.ppQ.eY);
    if (this.ppU)
    {
      float f1 = this.ppT.left - this.gQH / this.gQE;
      float f2 = this.ppT.top - this.gQH / this.gQE;
      float f3 = this.ppT.right + this.gQH / this.gQE;
      float f4 = this.ppT.bottom + this.gQH / this.gQE;
      float f5 = this.gQF / 2.0F / this.gQE;
      this.paint.setStrokeWidth(this.gQG / this.gQE);
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
    k.h(paramCanvas, "canvas");
    AppMethodBeat.o(341);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(338);
    this.ppU = paramBoolean;
    Object localObject = this.ppW;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(338);
      throw ((Throwable)localObject);
    }
    ((View)localObject).postInvalidate();
    AppMethodBeat.o(338);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Matrix, y>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.b
 * JD-Core Version:    0.7.0.1
 */