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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MemberCardTopCropImageView
  extends ImageView
{
  public int bwU;
  public int itemPadding;
  private float radius;
  public int tHY;
  private float tHZ;
  private Path tIa;
  private RectF tIb;
  
  public MemberCardTopCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113915);
    this.tHY = -1;
    this.bwU = -1;
    this.itemPadding = -1;
    init();
    AppMethodBeat.o(113915);
  }
  
  public MemberCardTopCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113916);
    this.tHY = -1;
    this.bwU = -1;
    this.itemPadding = -1;
    init();
    AppMethodBeat.o(113916);
  }
  
  private void init()
  {
    AppMethodBeat.i(113918);
    setScaleType(ImageView.ScaleType.MATRIX);
    this.bwU = a.aY(MMApplicationContext.getContext(), a.b.sZK);
    this.itemPadding = (a.aY(MMApplicationContext.getContext(), a.b.MiddlePadding) * 2);
    AppMethodBeat.o(113918);
  }
  
  public float getShowScale()
  {
    return this.tHZ;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113920);
    if ((this.tIb != null) && (this.tIa != null))
    {
      this.tIb.right = getWidth();
      this.tIb.bottom = getHeight();
      this.tIa.addRoundRect(this.tIb, this.radius, this.radius, Path.Direction.CW);
      paramCanvas.clipPath(this.tIa);
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
    this.tHY = (getContext().getResources().getDisplayMetrics().widthPixels - this.itemPadding);
    int k = this.tHY;
    int m = this.bwU;
    if (i * m > j * k) {}
    for (this.tHZ = (m / j);; this.tHZ = (k / i))
    {
      localMatrix.setScale(this.tHZ, this.tHZ);
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
      this.tIa = new Path();
      this.tIb = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    }
    AppMethodBeat.o(113917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView
 * JD-Core Version:    0.7.0.1
 */