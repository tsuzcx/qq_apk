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
import com.tencent.mm.sdk.platformtools.ai;

public class MemberCardTopCropImageView
  extends ImageView
{
  public int it;
  public int itemPadding;
  public int onm;
  private float onn;
  private Path ono;
  private RectF onp;
  private float radius;
  
  public MemberCardTopCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113915);
    this.onm = -1;
    this.it = -1;
    this.itemPadding = -1;
    init();
    AppMethodBeat.o(113915);
  }
  
  public MemberCardTopCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113916);
    this.onm = -1;
    this.it = -1;
    this.itemPadding = -1;
    init();
    AppMethodBeat.o(113916);
  }
  
  private void init()
  {
    AppMethodBeat.i(113918);
    setScaleType(ImageView.ScaleType.MATRIX);
    this.it = a.au(ai.getContext(), 2131165971);
    this.itemPadding = (a.au(ai.getContext(), 2131165500) * 2);
    AppMethodBeat.o(113918);
  }
  
  public float getShowScale()
  {
    return this.onn;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113920);
    if ((this.onp != null) && (this.ono != null))
    {
      this.onp.right = getWidth();
      this.onp.bottom = getHeight();
      this.ono.addRoundRect(this.onp, this.radius, this.radius, Path.Direction.CW);
      paramCanvas.clipPath(this.ono);
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
    this.onm = (getContext().getResources().getDisplayMetrics().widthPixels - this.itemPadding);
    int k = this.onm;
    int m = this.it;
    if (i * m > j * k) {}
    for (this.onn = (m / j);; this.onn = (k / i))
    {
      localMatrix.setScale(this.onn, this.onn);
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
      this.ono = new Path();
      this.onp = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    }
    AppMethodBeat.o(113917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView
 * JD-Core Version:    0.7.0.1
 */