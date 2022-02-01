package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorOutsideView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipPath", "Landroid/graphics/Path;", "outsidePaint", "Landroid/graphics/Paint;", "outsidePath", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public final class EditorOutsideView
  extends View
{
  private final Path pZY;
  private final Paint qec;
  private final Path qed;
  
  public EditorOutsideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(767);
    AppMethodBeat.o(767);
  }
  
  public EditorOutsideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(766);
    this.pZY = new Path();
    this.qec = new Paint();
    this.qed = new Path();
    this.qec.setAntiAlias(true);
    this.qec.setColor(getResources().getColor(2131099679));
    this.qec.setAlpha(127);
    AppMethodBeat.o(766);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(764);
    p.h(paramRectF, "bounds");
    this.pZY.reset();
    this.pZY.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    postInvalidate();
    AppMethodBeat.o(764);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(765);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.qed.reset();
    this.qed.addPath(this.pZY);
    this.qed.addRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), Path.Direction.CCW);
    paramCanvas.drawPath(this.qed, this.qec);
    AppMethodBeat.o(765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorOutsideView
 * JD-Core Version:    0.7.0.1
 */