package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.a;

public class FixAspectRatioImageView
  extends AppCompatImageView
{
  private int height;
  private int radius;
  private float tEJ;
  private int width;
  private int xzL;
  private int xzM;
  private int xzN;
  private int xzO;
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40891);
    this.tEJ = 0.0F;
    this.radius = 0;
    this.xzL = 0;
    this.xzM = 0;
    this.xzN = 0;
    this.xzO = 0;
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(40891);
  }
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40892);
    this.tEJ = 0.0F;
    this.radius = 0;
    this.xzL = 0;
    this.xzM = 0;
    this.xzN = 0;
    this.xzO = 0;
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(40892);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(40893);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, g.a.FixAspectRatioImageView, paramInt, 0);
    this.tEJ = paramContext.getFloat(0, 0.0F);
    this.radius = paramContext.getDimensionPixelOffset(3, 0);
    this.xzL = paramContext.getDimensionPixelOffset(2, 0);
    this.xzM = paramContext.getDimensionPixelOffset(5, 0);
    this.xzN = paramContext.getDimensionPixelOffset(1, 0);
    this.xzO = paramContext.getDimensionPixelOffset(4, 0);
    if (this.xzL == 0)
    {
      paramInt = this.radius;
      this.xzL = paramInt;
      if (this.xzM != 0) {
        break label162;
      }
      paramInt = this.radius;
      label105:
      this.xzM = paramInt;
      if (this.xzN != 0) {
        break label170;
      }
      paramInt = this.radius;
      label122:
      this.xzN = paramInt;
      if (this.xzO != 0) {
        break label178;
      }
    }
    label162:
    label170:
    label178:
    for (paramInt = this.radius;; paramInt = this.xzO)
    {
      this.xzO = paramInt;
      paramContext.recycle();
      AppMethodBeat.o(40893);
      return;
      paramInt = this.xzL;
      break;
      paramInt = this.xzM;
      break label105;
      paramInt = this.xzN;
      break label122;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(204108);
    int i = Math.max(this.xzL, this.xzN);
    int j = Math.max(this.xzM, this.xzO);
    int k = Math.max(this.xzL, this.xzM);
    int m = Math.max(this.xzN, this.xzO);
    if ((this.width >= i + j) && (this.height >= k + m))
    {
      Path localPath = new Path();
      localPath.moveTo(this.xzL, 0.0F);
      localPath.lineTo(this.width - this.xzM, 0.0F);
      localPath.quadTo(this.width, 0.0F, this.width, this.xzM);
      localPath.lineTo(this.width, this.height - this.xzO);
      localPath.quadTo(this.width, this.height, this.width - this.xzO, this.height);
      localPath.lineTo(this.xzN, this.height);
      localPath.quadTo(0.0F, this.height, 0.0F, this.height - this.xzN);
      localPath.lineTo(0.0F, this.xzL);
      localPath.quadTo(0.0F, 0.0F, this.xzL, 0.0F);
      paramCanvas.clipPath(localPath);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(204108);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204107);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.width = getWidth();
    this.height = getHeight();
    AppMethodBeat.o(204107);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40894);
    if (this.tEJ != 0.0F)
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      paramInt2 = (int)(this.tEJ * paramInt1);
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      AppMethodBeat.o(40894);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(40894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.FixAspectRatioImageView
 * JD-Core Version:    0.7.0.1
 */