package com.tencent.mm.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/LiveRoundImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "round", "getRound", "()I", "setRound", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-logic_release"})
public final class LiveRoundImageView
  extends ImageView
{
  private RectF ciS;
  private int hej;
  private final Path lP;
  
  public LiveRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(216627);
    AppMethodBeat.o(216627);
  }
  
  public LiveRoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216628);
    this.ciS = new RectF();
    this.lP = new Path();
    this.hej = a.fromDPToPix(getContext(), 8);
    AppMethodBeat.o(216628);
  }
  
  public final int getRound()
  {
    return this.hej;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(216626);
    this.ciS.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    this.lP.addRoundRect(this.ciS, this.hej, this.hej, Path.Direction.CW);
    if (paramCanvas != null) {
      paramCanvas.save();
    }
    if (paramCanvas != null) {
      paramCanvas.clipPath(this.lP);
    }
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      paramCanvas.restore();
      AppMethodBeat.o(216626);
      return;
    }
    AppMethodBeat.o(216626);
  }
  
  public final void setRound(int paramInt)
  {
    this.hej = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveRoundImageView
 * JD-Core Version:    0.7.0.1
 */