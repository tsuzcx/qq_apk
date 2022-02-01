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
import com.tencent.mm.plugin.emojicapture.a.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorOutsideView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipPath", "Landroid/graphics/Path;", "outsidePaint", "Landroid/graphics/Paint;", "outsidePath", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorOutsideView
  extends View
{
  private final Path yjb;
  private final Paint ymB;
  private final Path ymC;
  
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
    this.yjb = new Path();
    this.ymB = new Paint();
    this.ymC = new Path();
    this.ymB.setAntiAlias(true);
    this.ymB.setColor(getResources().getColor(a.c.BW_93));
    this.ymB.setAlpha(127);
    AppMethodBeat.o(766);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(764);
    s.u(paramRectF, "bounds");
    this.yjb.reset();
    this.yjb.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    postInvalidate();
    AppMethodBeat.o(764);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(765);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.ymC.reset();
    this.ymC.addPath(this.yjb);
    this.ymC.addRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), Path.Direction.CCW);
    paramCanvas.drawPath(this.ymC, this.ymB);
    AppMethodBeat.o(765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorOutsideView
 * JD-Core Version:    0.7.0.1
 */