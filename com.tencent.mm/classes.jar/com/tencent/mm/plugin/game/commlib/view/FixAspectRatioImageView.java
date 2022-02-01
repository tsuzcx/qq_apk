package com.tencent.mm.plugin.game.commlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.a.a.a;

public class FixAspectRatioImageView
  extends AppCompatImageView
{
  private int CzA;
  private int CzB;
  private int CzC;
  private int CzD;
  private int height;
  private int radius;
  private int width;
  private float xnl;
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(188496);
    this.xnl = 0.0F;
    this.radius = 0;
    this.CzA = 0;
    this.CzB = 0;
    this.CzC = 0;
    this.CzD = 0;
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(188496);
  }
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(188497);
    this.xnl = 0.0F;
    this.radius = 0;
    this.CzA = 0;
    this.CzB = 0;
    this.CzC = 0;
    this.CzD = 0;
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(188497);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(188498);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FixAspectRatioImageView, paramInt, 0);
    this.xnl = paramContext.getFloat(a.a.FixAspectRatioImageView_fix_ratio, 0.0F);
    this.radius = paramContext.getDimensionPixelOffset(a.a.FixAspectRatioImageView_radius, 0);
    this.CzA = paramContext.getDimensionPixelOffset(a.a.FixAspectRatioImageView_left_top_radius, 0);
    this.CzB = paramContext.getDimensionPixelOffset(a.a.FixAspectRatioImageView_right_top_radius, 0);
    this.CzC = paramContext.getDimensionPixelOffset(a.a.FixAspectRatioImageView_left_bottom_radius, 0);
    this.CzD = paramContext.getDimensionPixelOffset(a.a.FixAspectRatioImageView_right_bottom_radius, 0);
    if (this.CzA == 0)
    {
      paramInt = this.radius;
      this.CzA = paramInt;
      if (this.CzB != 0) {
        break label174;
      }
      paramInt = this.radius;
      label117:
      this.CzB = paramInt;
      if (this.CzC != 0) {
        break label182;
      }
      paramInt = this.radius;
      label134:
      this.CzC = paramInt;
      if (this.CzD != 0) {
        break label190;
      }
    }
    label174:
    label182:
    label190:
    for (paramInt = this.radius;; paramInt = this.CzD)
    {
      this.CzD = paramInt;
      paramContext.recycle();
      AppMethodBeat.o(188498);
      return;
      paramInt = this.CzA;
      break;
      paramInt = this.CzB;
      break label117;
      paramInt = this.CzC;
      break label134;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(188502);
    int i = Math.max(this.CzA, this.CzC);
    int j = Math.max(this.CzB, this.CzD);
    int k = Math.max(this.CzA, this.CzB);
    int m = Math.max(this.CzC, this.CzD);
    if ((this.width >= i + j) && (this.height >= k + m))
    {
      Path localPath = new Path();
      localPath.moveTo(this.CzA, 0.0F);
      localPath.lineTo(this.width - this.CzB, 0.0F);
      localPath.quadTo(this.width, 0.0F, this.width, this.CzB);
      localPath.lineTo(this.width, this.height - this.CzD);
      localPath.quadTo(this.width, this.height, this.width - this.CzD, this.height);
      localPath.lineTo(this.CzC, this.height);
      localPath.quadTo(0.0F, this.height, 0.0F, this.height - this.CzC);
      localPath.lineTo(0.0F, this.CzA);
      localPath.quadTo(0.0F, 0.0F, this.CzA, 0.0F);
      paramCanvas.clipPath(localPath);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(188502);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(188501);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.width = getWidth();
    this.height = getHeight();
    AppMethodBeat.o(188501);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188500);
    if (this.xnl != 0.0F)
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      paramInt2 = (int)(this.xnl * paramInt1);
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      AppMethodBeat.o(188500);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(188500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.view.FixAspectRatioImageView
 * JD-Core Version:    0.7.0.1
 */