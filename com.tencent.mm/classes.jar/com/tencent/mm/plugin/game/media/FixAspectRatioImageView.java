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
  private float rOY;
  private int radius;
  private int tWt;
  private int tWu;
  private int tWv;
  private int tWw;
  private int width;
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40891);
    this.rOY = 0.0F;
    this.radius = 0;
    this.tWt = 0;
    this.tWu = 0;
    this.tWv = 0;
    this.tWw = 0;
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(40891);
  }
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40892);
    this.rOY = 0.0F;
    this.radius = 0;
    this.tWt = 0;
    this.tWu = 0;
    this.tWv = 0;
    this.tWw = 0;
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(40892);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(40893);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, g.a.FixAspectRatioImageView, paramInt, 0);
    this.rOY = paramContext.getFloat(0, 0.0F);
    this.radius = paramContext.getDimensionPixelOffset(3, 0);
    this.tWt = paramContext.getDimensionPixelOffset(2, 0);
    this.tWu = paramContext.getDimensionPixelOffset(5, 0);
    this.tWv = paramContext.getDimensionPixelOffset(1, 0);
    this.tWw = paramContext.getDimensionPixelOffset(4, 0);
    if (this.tWt == 0)
    {
      paramInt = this.radius;
      this.tWt = paramInt;
      if (this.tWu != 0) {
        break label162;
      }
      paramInt = this.radius;
      label105:
      this.tWu = paramInt;
      if (this.tWv != 0) {
        break label170;
      }
      paramInt = this.radius;
      label122:
      this.tWv = paramInt;
      if (this.tWw != 0) {
        break label178;
      }
    }
    label162:
    label170:
    label178:
    for (paramInt = this.radius;; paramInt = this.tWw)
    {
      this.tWw = paramInt;
      paramContext.recycle();
      AppMethodBeat.o(40893);
      return;
      paramInt = this.tWt;
      break;
      paramInt = this.tWu;
      break label105;
      paramInt = this.tWv;
      break label122;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(206804);
    int i = Math.max(this.tWt, this.tWv);
    int j = Math.max(this.tWu, this.tWw);
    int k = Math.max(this.tWt, this.tWu);
    int m = Math.max(this.tWv, this.tWw);
    if ((this.width >= i + j) && (this.height >= k + m))
    {
      Path localPath = new Path();
      localPath.moveTo(this.tWt, 0.0F);
      localPath.lineTo(this.width - this.tWu, 0.0F);
      localPath.quadTo(this.width, 0.0F, this.width, this.tWu);
      localPath.lineTo(this.width, this.height - this.tWw);
      localPath.quadTo(this.width, this.height, this.width - this.tWw, this.height);
      localPath.lineTo(this.tWv, this.height);
      localPath.quadTo(0.0F, this.height, 0.0F, this.height - this.tWv);
      localPath.lineTo(0.0F, this.tWt);
      localPath.quadTo(0.0F, 0.0F, this.tWt, 0.0F);
      paramCanvas.clipPath(localPath);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(206804);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(206803);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.width = getWidth();
    this.height = getHeight();
    AppMethodBeat.o(206803);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40894);
    if (this.rOY != 0.0F)
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      paramInt2 = (int)(this.rOY * paramInt1);
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      AppMethodBeat.o(40894);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(40894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.FixAspectRatioImageView
 * JD-Core Version:    0.7.0.1
 */