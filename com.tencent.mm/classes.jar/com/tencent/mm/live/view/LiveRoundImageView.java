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
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/LiveRoundImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "round", "getRound", "()I", "setRound", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-logic_release"})
public final class LiveRoundImageView
  extends ImageView
{
  private int cSo;
  private RectF cuN;
  private final Path lR;
  
  public LiveRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(208592);
    AppMethodBeat.o(208592);
  }
  
  public LiveRoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208593);
    this.cuN = new RectF();
    this.lR = new Path();
    this.cSo = a.fromDPToPix(getContext(), 8);
    AppMethodBeat.o(208593);
  }
  
  public final int getRound()
  {
    return this.cSo;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(208591);
    this.cuN.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    this.lR.addRoundRect(this.cuN, this.cSo, this.cSo, Path.Direction.CW);
    if (paramCanvas != null) {
      paramCanvas.save();
    }
    if (paramCanvas != null) {
      paramCanvas.clipPath(this.lR);
    }
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      paramCanvas.restore();
      AppMethodBeat.o(208591);
      return;
    }
    AppMethodBeat.o(208591);
  }
  
  public final void setRound(int paramInt)
  {
    this.cSo = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveRoundImageView
 * JD-Core Version:    0.7.0.1
 */