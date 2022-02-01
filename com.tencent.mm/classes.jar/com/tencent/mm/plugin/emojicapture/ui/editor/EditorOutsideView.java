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
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorOutsideView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipPath", "Landroid/graphics/Path;", "outsidePaint", "Landroid/graphics/Paint;", "outsidePath", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public final class EditorOutsideView
  extends View
{
  private final Path ppS;
  private final Paint ptT;
  private final Path ptU;
  
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
    this.ppS = new Path();
    this.ptT = new Paint();
    this.ptU = new Path();
    this.ptT.setAntiAlias(true);
    this.ptT.setColor(getResources().getColor(2131099679));
    this.ptT.setAlpha(127);
    AppMethodBeat.o(766);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(764);
    k.h(paramRectF, "bounds");
    this.ppS.reset();
    this.ppS.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    postInvalidate();
    AppMethodBeat.o(764);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(765);
    k.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.ptU.reset();
    this.ptU.addPath(this.ppS);
    this.ptU.addRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), Path.Direction.CCW);
    paramCanvas.drawPath(this.ptU, this.ptT);
    AppMethodBeat.o(765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorOutsideView
 * JD-Core Version:    0.7.0.1
 */