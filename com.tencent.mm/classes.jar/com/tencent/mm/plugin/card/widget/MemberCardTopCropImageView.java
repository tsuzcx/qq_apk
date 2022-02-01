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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MemberCardTopCropImageView
  extends ImageView
{
  public int itemPadding;
  public int kn;
  public int qmd;
  private float qme;
  private Path qmf;
  private RectF qmg;
  private float radius;
  
  public MemberCardTopCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113915);
    this.qmd = -1;
    this.kn = -1;
    this.itemPadding = -1;
    init();
    AppMethodBeat.o(113915);
  }
  
  public MemberCardTopCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113916);
    this.qmd = -1;
    this.kn = -1;
    this.itemPadding = -1;
    init();
    AppMethodBeat.o(113916);
  }
  
  private void init()
  {
    AppMethodBeat.i(113918);
    setScaleType(ImageView.ScaleType.MATRIX);
    this.kn = a.aG(MMApplicationContext.getContext(), 2131166003);
    this.itemPadding = (a.aG(MMApplicationContext.getContext(), 2131165518) * 2);
    AppMethodBeat.o(113918);
  }
  
  public float getShowScale()
  {
    return this.qme;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113920);
    if ((this.qmg != null) && (this.qmf != null))
    {
      this.qmg.right = getWidth();
      this.qmg.bottom = getHeight();
      this.qmf.addRoundRect(this.qmg, this.radius, this.radius, Path.Direction.CW);
      paramCanvas.clipPath(this.qmf);
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
    this.qmd = (getContext().getResources().getDisplayMetrics().widthPixels - this.itemPadding);
    int k = this.qmd;
    int m = this.kn;
    if (i * m > j * k) {}
    for (this.qme = (m / j);; this.qme = (k / i))
    {
      localMatrix.setScale(this.qme, this.qme);
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
      this.qmf = new Path();
      this.qmg = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    }
    AppMethodBeat.o(113917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView
 * JD-Core Version:    0.7.0.1
 */