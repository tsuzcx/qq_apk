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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/LiveRoundImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "round", "getRound", "()I", "setRound", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-logic_release"})
public final class LiveRoundImageView
  extends ImageView
{
  private RectF bYy;
  private int gHL;
  private final Path jZ;
  
  public LiveRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(190707);
    AppMethodBeat.o(190707);
  }
  
  public LiveRoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190708);
    this.bYy = new RectF();
    this.jZ = new Path();
    this.gHL = a.fromDPToPix(getContext(), 8);
    AppMethodBeat.o(190708);
  }
  
  public final int getRound()
  {
    return this.gHL;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(190706);
    this.bYy.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    this.jZ.addRoundRect(this.bYy, this.gHL, this.gHL, Path.Direction.CW);
    if (paramCanvas != null) {
      paramCanvas.save();
    }
    if (paramCanvas != null) {
      paramCanvas.clipPath(this.jZ);
    }
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      paramCanvas.restore();
      AppMethodBeat.o(190706);
      return;
    }
    AppMethodBeat.o(190706);
  }
  
  public final void setRound(int paramInt)
  {
    this.gHL = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveRoundImageView
 * JD-Core Version:    0.7.0.1
 */