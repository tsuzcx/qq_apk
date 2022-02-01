package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.aj;

public class MemberCardTopCropImageView
  extends ImageView
{
  public int itemPadding;
  public int kl;
  public int oQH;
  private float oQI;
  private Path oQJ;
  private RectF oQK;
  private float radius;
  
  public MemberCardTopCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113915);
    this.oQH = -1;
    this.kl = -1;
    this.itemPadding = -1;
    init();
    AppMethodBeat.o(113915);
  }
  
  public MemberCardTopCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113916);
    this.oQH = -1;
    this.kl = -1;
    this.itemPadding = -1;
    init();
    AppMethodBeat.o(113916);
  }
  
  private void init()
  {
    AppMethodBeat.i(113918);
    setScaleType(ImageView.ScaleType.MATRIX);
    this.kl = a.ax(aj.getContext(), 2131165971);
    this.itemPadding = (a.ax(aj.getContext(), 2131165500) * 2);
    AppMethodBeat.o(113918);
  }
  
  public float getShowScale()
  {
    return this.oQI;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113920);
    if ((this.oQK != null) && (this.oQJ != null))
    {
      this.oQK.right = getWidth();
      this.oQK.bottom = getHeight();
      this.oQJ.addRoundRect(this.oQK, this.radius, this.radius, Path.Direction.CW);
      paramCanvas.clipPath(this.oQJ);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(113920);
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(113919);
    boolean bool;
    if (getDrawable() == null)
    {
      bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(113919);
      return bool;
    }
    Matrix localMatrix = getImageMatrix();
    int i = getDrawable().getIntrinsicWidth();
    int j = getDrawable().getIntrinsicHeight();
    this.oQH = (getContext().getResources().getDisplayMetrics().widthPixels - this.itemPadding);
    int k = this.oQH;
    int m = this.kl;
    if (i * m > j * k) {}
    for (this.oQI = (m / j);; this.oQI = (k / i))
    {
      localMatrix.setScale(this.oQI, this.oQI);
      setImageMatrix(localMatrix);
      bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(113919);
      return bool;
    }
  }
  
  public void setRadius(float paramFloat)
  {
    AppMethodBeat.i(113917);
    this.radius = paramFloat;
    if (paramFloat > 0.0F)
    {
      this.oQJ = new Path();
      this.oQK = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    }
    AppMethodBeat.o(113917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView
 * JD-Core Version:    0.7.0.1
 */