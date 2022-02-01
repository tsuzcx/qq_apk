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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;)V", "basicScale", "", "clipPath", "Landroid/graphics/Path;", "drawingBounds", "Landroid/graphics/Rect;", "framePadding", "frameRect", "frameStroke", "isClipping", "", "isEditing", "maxScale", "minScale", "paint", "Landroid/graphics/Paint;", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validBounds", "Landroid/graphics/RectF;", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "onTouch", "event", "Landroid/view/MotionEvent;", "resetMatrix", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "radius", "Companion", "plugin-emojicapture_release"})
public final class b
  implements c.a
{
  public static final a oMD;
  private float aMu;
  private float aMv;
  private float gpW;
  private final float gpX;
  private final float gpY;
  private final float gpZ;
  private boolean oMA;
  private boolean oMB;
  private final c.b oMC;
  private final c oMw;
  private final RectF oMx;
  private final Path oMy;
  private final Rect oMz;
  private final Paint paint;
  
  static
  {
    AppMethodBeat.i(343);
    oMD = new a((byte)0);
    AppMethodBeat.o(343);
  }
  
  public b(c.b paramb)
  {
    AppMethodBeat.i(342);
    this.oMC = paramb;
    this.oMw = new c();
    this.oMx = new RectF();
    this.oMy = new Path();
    this.oMz = new Rect();
    this.paint = new Paint();
    this.oMB = true;
    this.gpW = 1.0F;
    this.aMu = 2.0F;
    this.aMv = 0.25F;
    paramb = this.oMC;
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(342);
      throw paramb;
    }
    paramb = ((View)paramb).getContext();
    k.g(paramb, "(view as View).context");
    paramb = paramb.getResources();
    this.oMw.aMu = this.aMu;
    this.oMw.aMv = this.aMv;
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(paramb.getDimension(2131166188));
    this.paint.setStyle(Paint.Style.FILL);
    this.gpY = paramb.getDimension(2131166188);
    this.gpZ = paramb.getDimension(2131166186);
    this.gpX = paramb.getDimension(2131166187);
    AppMethodBeat.o(342);
  }
  
  private final void bYq()
  {
    AppMethodBeat.i(337);
    this.oMw.dY.reset();
    this.oMw.dY.postTranslate(-this.oMz.width() / 2.0F, -this.oMz.height() / 2.0F);
    if ((!this.oMx.isEmpty()) && (!this.oMz.isEmpty()))
    {
      int i = Math.max(this.oMz.width(), this.oMz.height());
      this.gpW = (this.oMx.width() / i);
      float f = this.gpW * 0.5F;
      this.aMu = (this.gpW * 2.0F);
      this.aMv = (this.gpW * 0.25F);
      this.oMw.aMu = this.aMu;
      this.oMw.aMv = this.aMv;
      this.oMw.dY.postScale(f, f);
    }
    this.oMw.dY.postTranslate((this.oMx.left + this.oMx.right) / 2.0F, (this.oMx.top + this.oMx.bottom) / 2.0F);
    AppMethodBeat.o(337);
  }
  
  public final boolean T(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(339);
    k.h(paramMotionEvent, "event");
    EditorItemContainer localEditorItemContainer = this.oMC.getItemContainer();
    if (this.oMw.v(paramMotionEvent))
    {
      if (localEditorItemContainer != null) {
        localEditorItemContainer.a((com.tencent.mm.plugin.emojicapture.ui.editor.a)this.oMC, paramMotionEvent);
      }
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        paramMotionEvent = this.oMC;
        if (paramMotionEvent != null) {
          break;
        }
        paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(339);
        throw paramMotionEvent;
        this.oMB = true;
        paramMotionEvent = this.oMC;
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(339);
          throw paramMotionEvent;
        }
        ((View)paramMotionEvent).bringToFront();
        continue;
        this.oMB = false;
        continue;
        this.oMB = true;
        paramMotionEvent = new com.tencent.mm.media.editor.c.a();
        paramMotionEvent.aMv = this.aMv;
        paramMotionEvent.aMu = this.aMu;
        paramMotionEvent.k(new float[] { this.oMz.width() / 2.0F, this.oMz.height() / 2.0F });
        paramMotionEvent.e(new RectF(this.oMx.left, this.oMx.top, this.oMx.right, this.oMx.bottom));
        paramMotionEvent.a(this.oMw.dY, (d.g.a.b)new b(this));
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
    this.oMx.set(paramRectF);
    this.oMy.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    bYq();
    AppMethodBeat.o(336);
  }
  
  public final void fh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335);
    this.oMw.width = paramInt1;
    this.oMw.height = paramInt2;
    this.oMz.right = paramInt1;
    this.oMz.bottom = paramInt2;
    bYq();
    AppMethodBeat.o(335);
  }
  
  public final c getTouchTracker()
  {
    return this.oMw;
  }
  
  public final void j(Canvas paramCanvas)
  {
    AppMethodBeat.i(340);
    k.h(paramCanvas, "canvas");
    if (this.oMB) {
      paramCanvas.clipPath(this.oMy);
    }
    paramCanvas.setMatrix(this.oMw.dY);
    if (this.oMA)
    {
      float f1 = this.oMz.left - this.gpZ / this.gpW;
      float f2 = this.oMz.top - this.gpZ / this.gpW;
      float f3 = this.oMz.right + this.gpZ / this.gpW;
      float f4 = this.oMz.bottom + this.gpZ / this.gpW;
      float f5 = this.gpX / 2.0F / this.gpW;
      this.paint.setStrokeWidth(this.gpY / this.gpW);
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
    this.oMA = paramBoolean;
    Object localObject = this.oMC;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(338);
      throw ((Throwable)localObject);
    }
    ((View)localObject).postInvalidate();
    AppMethodBeat.o(338);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter$Companion;", "", "()V", "DEFAULT_SCALE_TO_BOUNDS", "", "MAX_SCALE_TO_BOUNDS", "MIN_SCALE_TO_BOUNDS", "plugin-emojicapture_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.b
 * JD-Core Version:    0.7.0.1
 */