package com.tencent.mm.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/LiveRoundImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "round", "getRound", "()I", "setRound", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-logic_release"})
public final class LiveRoundImageView
  extends ImageView
{
  private RectF cbB;
  private final Path ja;
  private int yxg;
  
  public LiveRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(203479);
    AppMethodBeat.o(203479);
  }
  
  public LiveRoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203480);
    this.cbB = new RectF();
    this.ja = new Path();
    this.yxg = a.fromDPToPix(getContext(), 8);
    AppMethodBeat.o(203480);
  }
  
  public final int getRound()
  {
    return this.yxg;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(203478);
    this.cbB.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    this.ja.addRoundRect(this.cbB, this.yxg, this.yxg, Path.Direction.CW);
    if (paramCanvas != null) {
      paramCanvas.save();
    }
    if (paramCanvas != null) {
      paramCanvas.clipPath(this.ja);
    }
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      paramCanvas.restore();
      AppMethodBeat.o(203478);
      return;
    }
    AppMethodBeat.o(203478);
  }
  
  public final void setRound(int paramInt)
  {
    this.yxg = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveRoundImageView
 * JD-Core Version:    0.7.0.1
 */