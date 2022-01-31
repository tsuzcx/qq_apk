package com.tencent.mm.plugin.emojicapture.e;

import a.f.b.j;
import a.l;
import a.v;
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

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;)V", "basicScale", "", "clipPath", "Landroid/graphics/Path;", "drawingBounds", "Landroid/graphics/Rect;", "framePadding", "frameRect", "frameStroke", "isClipping", "", "isEditing", "maxScale", "minScale", "paint", "Landroid/graphics/Paint;", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validBounds", "Landroid/graphics/RectF;", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "onTouch", "event", "Landroid/view/MotionEvent;", "resetMatrix", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "radius", "Companion", "plugin-emojicapture_release"})
public final class b
  implements c.a
{
  public static final b.a lwi;
  private float arJ;
  private float arK;
  private float eTS;
  private final float eTT;
  private final float eTU;
  private final float eTV;
  private final c lwb;
  private final RectF lwc;
  private final Path lwd;
  private final Rect lwe;
  private boolean lwf;
  private boolean lwg;
  private final c.b lwh;
  private final Paint paint;
  
  static
  {
    AppMethodBeat.i(2764);
    lwi = new b.a((byte)0);
    AppMethodBeat.o(2764);
  }
  
  public b(c.b paramb)
  {
    AppMethodBeat.i(2763);
    this.lwh = paramb;
    this.lwb = new c();
    this.lwc = new RectF();
    this.lwd = new Path();
    this.lwe = new Rect();
    this.paint = new Paint();
    this.eTS = 1.0F;
    this.arJ = 2.0F;
    this.arK = 0.25F;
    paramb = this.lwh;
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(2763);
      throw paramb;
    }
    paramb = ((View)paramb).getContext();
    j.p(paramb, "(view as View).context");
    paramb = paramb.getResources();
    this.lwb.arJ = this.arJ;
    this.lwb.arK = this.arK;
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(paramb.getDimension(2131428336));
    this.paint.setStyle(Paint.Style.FILL);
    this.eTU = paramb.getDimension(2131428336);
    this.eTV = paramb.getDimension(2131428334);
    this.eTT = paramb.getDimension(2131428335);
    AppMethodBeat.o(2763);
  }
  
  private final void boM()
  {
    AppMethodBeat.i(2758);
    this.lwb.asO.reset();
    this.lwb.asO.postTranslate(-this.lwe.width() / 2.0F, -this.lwe.height() / 2.0F);
    if ((!this.lwc.isEmpty()) && (!this.lwe.isEmpty()))
    {
      int i = Math.max(this.lwe.width(), this.lwe.height());
      this.eTS = (this.lwc.width() / i);
      float f = this.eTS * 0.5F;
      this.arJ = (this.eTS * 2.0F);
      this.arK = (this.eTS * 0.25F);
      this.lwb.arJ = this.arJ;
      this.lwb.arK = this.arK;
      this.lwb.asO.postScale(f, f);
    }
    this.lwb.asO.postTranslate((this.lwc.left + this.lwc.right) / 2.0F, (this.lwc.top + this.lwc.bottom) / 2.0F);
    AppMethodBeat.o(2758);
  }
  
  public final boolean K(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(2760);
    j.q(paramMotionEvent, "event");
    EditorItemContainer localEditorItemContainer = this.lwh.getItemContainer();
    if (this.lwb.u(paramMotionEvent))
    {
      if (localEditorItemContainer != null) {
        localEditorItemContainer.a((com.tencent.mm.plugin.emojicapture.ui.editor.a)this.lwh, paramMotionEvent);
      }
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        paramMotionEvent = this.lwh;
        if (paramMotionEvent != null) {
          break;
        }
        paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(2760);
        throw paramMotionEvent;
        this.lwg = true;
        paramMotionEvent = this.lwh;
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(2760);
          throw paramMotionEvent;
        }
        ((View)paramMotionEvent).bringToFront();
        continue;
        this.lwg = false;
        continue;
        this.lwg = true;
        paramMotionEvent = new com.tencent.mm.media.editor.c.a();
        paramMotionEvent.arK = this.arK;
        paramMotionEvent.arJ = this.arJ;
        paramMotionEvent.g(new float[] { this.lwe.width() / 2.0F, this.lwe.height() / 2.0F });
        paramMotionEvent.b(new RectF(this.lwc.left, this.lwc.top, this.lwc.right, this.lwc.bottom));
        paramMotionEvent.a(this.lwb.asO, (a.f.a.b)new b.b(this));
      }
      ((View)paramMotionEvent).invalidate();
      AppMethodBeat.o(2760);
      return true;
    }
    AppMethodBeat.o(2760);
    return false;
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(2757);
    j.q(paramRectF, "bounds");
    this.lwc.set(paramRectF);
    this.lwd.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    boM();
    AppMethodBeat.o(2757);
  }
  
  public final void ee(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2756);
    this.lwb.width = paramInt1;
    this.lwb.height = paramInt2;
    this.lwe.right = paramInt1;
    this.lwe.bottom = paramInt2;
    boM();
    AppMethodBeat.o(2756);
  }
  
  public final c getTouchTracker()
  {
    return this.lwb;
  }
  
  public final void h(Canvas paramCanvas)
  {
    AppMethodBeat.i(2761);
    j.q(paramCanvas, "canvas");
    if (this.lwg) {
      paramCanvas.clipPath(this.lwd);
    }
    paramCanvas.setMatrix(this.lwb.asO);
    if (this.lwf)
    {
      float f1 = this.lwe.left - this.eTV / this.eTS;
      float f2 = this.lwe.top - this.eTV / this.eTS;
      float f3 = this.lwe.right + this.eTV / this.eTS;
      float f4 = this.lwe.bottom + this.eTV / this.eTS;
      float f5 = this.eTT / 2.0F / this.eTS;
      this.paint.setStrokeWidth(this.eTU / this.eTS);
      paramCanvas.drawRect(f1 - f5, f2 - f5, f1 + f5, f2 + f5, this.paint);
      paramCanvas.drawRect(f3 - f5, f2 - f5, f3 + f5, f2 + f5, this.paint);
      paramCanvas.drawRect(f3 - f5, f4 - f5, f3 + f5, f4 + f5, this.paint);
      paramCanvas.drawRect(f1 - f5, f4 - f5, f1 + f5, f4 + f5, this.paint);
      Paint localPaint = this.paint;
      paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    }
    AppMethodBeat.o(2761);
  }
  
  public final void i(Canvas paramCanvas)
  {
    AppMethodBeat.i(2762);
    j.q(paramCanvas, "canvas");
    AppMethodBeat.o(2762);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(2759);
    this.lwf = paramBoolean;
    Object localObject = this.lwh;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(2759);
      throw ((Throwable)localObject);
    }
    ((View)localObject).postInvalidate();
    AppMethodBeat.o(2759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.b
 * JD-Core Version:    0.7.0.1
 */