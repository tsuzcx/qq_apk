package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;

public class EmojiStoreV2RewardBannerView
  extends MMAnimateView
{
  private float mScale = 0.75F;
  
  public EmojiStoreV2RewardBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmojiStoreV2RewardBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(53668);
    paramInt2 = getRight() - getLeft() - getPaddingRight() - getPaddingLeft();
    int i = (int)(paramInt2 * this.mScale);
    if (paramInt2 != 0)
    {
      paramInt1 = i;
      if (i != 0) {}
    }
    else
    {
      paramInt2 = getContext().getResources().getDisplayMetrics().widthPixels;
      paramInt1 = (int)(paramInt2 * this.mScale);
    }
    setMeasuredDimension(paramInt2, paramInt1);
    AppMethodBeat.o(53668);
  }
  
  public void setScale(float paramFloat)
  {
    this.mScale = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardBannerView
 * JD-Core Version:    0.7.0.1
 */