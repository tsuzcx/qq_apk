package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.HorizontalScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BouncyHScrollView
  extends HorizontalScrollView
{
  private Context mContext;
  private int nEI;
  
  public BouncyHScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public BouncyHScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(112384);
    super.onFinishInflate();
    this.nEI = ((int)(this.mContext.getResources().getDisplayMetrics().density * 300.0F));
    setOverScrollMode(0);
    setSmoothScrollingEnabled(true);
    setHorizontalFadingEdgeEnabled(false);
    AppMethodBeat.o(112384);
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(112385);
    paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, this.nEI, paramInt8, paramBoolean);
    AppMethodBeat.o(112385);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.BouncyHScrollView
 * JD-Core Version:    0.7.0.1
 */