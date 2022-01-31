package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.sdk.platformtools.ae;

public class MemberCardTopCropImageView
  extends ImageView
{
  protected int iAj = -1;
  private float iAk;
  protected int itemPadding = -1;
  protected int ixe = -1;
  
  public MemberCardTopCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MemberCardTopCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
    this.ixe = a.aa(ae.getContext(), a.b.card_item_height);
    this.itemPadding = (a.aa(ae.getContext(), a.b.MiddlePadding) * 2);
  }
  
  public float getShowScale()
  {
    return this.iAk;
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getDrawable() == null) {
      return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Matrix localMatrix = getImageMatrix();
    int i = getDrawable().getIntrinsicWidth();
    int j = getDrawable().getIntrinsicHeight();
    this.iAj = (getContext().getResources().getDisplayMetrics().widthPixels - this.itemPadding);
    int k = this.iAj;
    int m = this.ixe;
    if (i * m > j * k) {}
    for (this.iAk = (m / j);; this.iAk = (k / i))
    {
      localMatrix.setScale(this.iAk, this.iAk);
      setImageMatrix(localMatrix);
      return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView
 * JD-Core Version:    0.7.0.1
 */