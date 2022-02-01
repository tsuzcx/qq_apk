package com.tencent.mm.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/LiveRoundImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "round", "getRound", "()I", "setRound", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-logic_release"})
public final class LiveRoundImageView
  extends ImageView
{
  private RectF ciQ;
  private int hbv;
  private final Path lP;
  
  public LiveRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(212997);
    AppMethodBeat.o(212997);
  }
  
  public LiveRoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(212998);
    this.ciQ = new RectF();
    this.lP = new Path();
    this.hbv = a.fromDPToPix(getContext(), 8);
    AppMethodBeat.o(212998);
  }
  
  public final int getRound()
  {
    return this.hbv;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(212996);
    this.ciQ.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    this.lP.addRoundRect(this.ciQ, this.hbv, this.hbv, Path.Direction.CW);
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
      AppMethodBeat.o(212996);
      return;
    }
    AppMethodBeat.o(212996);
  }
  
  public final void setRound(int paramInt)
  {
    this.hbv = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveRoundImageView
 * JD-Core Version:    0.7.0.1
 */