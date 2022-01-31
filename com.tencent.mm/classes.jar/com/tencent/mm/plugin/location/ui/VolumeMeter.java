package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;

public class VolumeMeter
  extends ImageView
  implements Runnable
{
  public boolean eku = false;
  private Paint gaZ;
  private float lHA;
  private float lHB;
  private float lHC;
  private float lHD;
  private int lHE = -6751336;
  private int lHF = 70;
  private float lHG = 0.5F;
  private float lHH = 0.001F;
  private int lHI = 20;
  private float lHJ;
  private float lHK;
  private float lHL = 40.0F;
  private float lHM = 30.0F;
  public boolean lHv = false;
  private View lHw;
  private int lHx = -1;
  private int lHy = -1;
  public ah lHz = null;
  private Context mContext;
  private float radius = 0.0F;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    this.gaZ = new Paint();
  }
  
  public final void beF()
  {
    if (this.lHz == null)
    {
      new ah().postDelayed(new VolumeMeter.2(this), 100L);
      return;
    }
    this.lHz.post(this);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    getWidth();
    getHeight();
    int[] arrayOfInt;
    if (this.lHw != null)
    {
      arrayOfInt = new int[2];
      this.lHw.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0)) {
        break label65;
      }
    }
    while ((this.lHx < 0) || (this.lHy < 0))
    {
      return;
      label65:
      int i = this.lHw.getWidth();
      int j = this.lHw.getHeight();
      if ((i != 0) && (j != 0))
      {
        int k = BackwardSupportUtil.b.b(this.mContext, 50.0F);
        this.lHx = (arrayOfInt[0] + i / 2);
        this.lHy = (arrayOfInt[1] + j / 2 - k / 2);
        this.lHK = (i / 2);
        this.lHJ = (i / 2 * 2.0F);
      }
    }
    this.gaZ.setColor(this.lHE);
    this.gaZ.setAlpha(this.lHF);
    float f2 = BackwardSupportUtil.b.b(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.lHJ) {
      f1 = this.lHJ;
    }
    f2 = f1;
    if (f1 < this.lHK) {
      f2 = this.lHK;
    }
    paramCanvas.drawCircle(this.lHx, this.lHy, f2, this.gaZ);
  }
  
  public final void reset()
  {
    this.radius = 0.0F;
    this.lHA = 0.0F;
    this.lHB = 0.0F;
    this.lHC = 0.0F;
    this.lHD = 0.0F;
    postInvalidate();
  }
  
  public void run()
  {
    float f2;
    float f3;
    float f1;
    if (this.eku)
    {
      f2 = this.lHC;
      if (this.lHB <= this.lHA) {
        break label137;
      }
      f3 = (this.lHB - this.lHA) / this.lHM;
      if (f3 <= this.lHG) {
        break label118;
      }
      f1 = this.lHG;
      f1 += f2;
    }
    for (;;)
    {
      this.lHC = f1;
      this.lHD = this.lHC;
      this.radius = ((float)(260.0D * Math.sqrt(this.lHC) - 130.0F * this.lHC) / 1.5F);
      postInvalidate();
      this.lHz.postDelayed(this, this.lHI);
      return;
      label118:
      f1 = f3;
      if (f3 >= this.lHH) {
        break;
      }
      f1 = this.lHH;
      break;
      label137:
      if (this.lHB <= this.lHA)
      {
        f3 = (this.lHA - this.lHB) / this.lHL;
        if (f3 > this.lHG) {
          f1 = this.lHG;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.lHH) {
            f1 = this.lHH;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.lHw = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.lHA = this.lHB;
    this.lHB = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */