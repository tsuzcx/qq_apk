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
  private float rXz;
  private int radius;
  private int uhr;
  private int uhs;
  private int uht;
  private int uhu;
  private int width;
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40891);
    this.rXz = 0.0F;
    this.radius = 0;
    this.uhr = 0;
    this.uhs = 0;
    this.uht = 0;
    this.uhu = 0;
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(40891);
  }
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40892);
    this.rXz = 0.0F;
    this.radius = 0;
    this.uhr = 0;
    this.uhs = 0;
    this.uht = 0;
    this.uhu = 0;
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(40892);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(40893);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, g.a.FixAspectRatioImageView, paramInt, 0);
    this.rXz = paramContext.getFloat(0, 0.0F);
    this.radius = paramContext.getDimensionPixelOffset(3, 0);
    this.uhr = paramContext.getDimensionPixelOffset(2, 0);
    this.uhs = paramContext.getDimensionPixelOffset(5, 0);
    this.uht = paramContext.getDimensionPixelOffset(1, 0);
    this.uhu = paramContext.getDimensionPixelOffset(4, 0);
    if (this.uhr == 0)
    {
      paramInt = this.radius;
      this.uhr = paramInt;
      if (this.uhs != 0) {
        break label162;
      }
      paramInt = this.radius;
      label105:
      this.uhs = paramInt;
      if (this.uht != 0) {
        break label170;
      }
      paramInt = this.radius;
      label122:
      this.uht = paramInt;
      if (this.uhu != 0) {
        break label178;
      }
    }
    label162:
    label170:
    label178:
    for (paramInt = this.radius;; paramInt = this.uhu)
    {
      this.uhu = paramInt;
      paramContext.recycle();
      AppMethodBeat.o(40893);
      return;
      paramInt = this.uhr;
      break;
      paramInt = this.uhs;
      break label105;
      paramInt = this.uht;
      break label122;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(195612);
    int i = Math.max(this.uhr, this.uht);
    int j = Math.max(this.uhs, this.uhu);
    int k = Math.max(this.uhr, this.uhs);
    int m = Math.max(this.uht, this.uhu);
    if ((this.width >= i + j) && (this.height >= k + m))
    {
      Path localPath = new Path();
      localPath.moveTo(this.uhr, 0.0F);
      localPath.lineTo(this.width - this.uhs, 0.0F);
      localPath.quadTo(this.width, 0.0F, this.width, this.uhs);
      localPath.lineTo(this.width, this.height - this.uhu);
      localPath.quadTo(this.width, this.height, this.width - this.uhu, this.height);
      localPath.lineTo(this.uht, this.height);
      localPath.quadTo(0.0F, this.height, 0.0F, this.height - this.uht);
      localPath.lineTo(0.0F, this.uhr);
      localPath.quadTo(0.0F, 0.0F, this.uhr, 0.0F);
      paramCanvas.clipPath(localPath);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(195612);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(195611);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.width = getWidth();
    this.height = getHeight();
    AppMethodBeat.o(195611);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40894);
    if (this.rXz != 0.0F)
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      paramInt2 = (int)(this.rXz * paramInt1);
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