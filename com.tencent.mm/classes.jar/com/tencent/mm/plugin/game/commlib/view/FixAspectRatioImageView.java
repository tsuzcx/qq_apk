package com.tencent.mm.plugin.game.commlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.a.a.b;

public class FixAspectRatioImageView
  extends AppCompatImageView
{
  private int Itr;
  private int Its;
  private int Itt;
  private int Itu;
  private int height;
  private float nwN;
  private int radius;
  private int width;
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(275354);
    this.nwN = 0.0F;
    this.radius = 0;
    this.Itr = 0;
    this.Its = 0;
    this.Itt = 0;
    this.Itu = 0;
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(275354);
  }
  
  public FixAspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(275360);
    this.nwN = 0.0F;
    this.radius = 0;
    this.Itr = 0;
    this.Its = 0;
    this.Itt = 0;
    this.Itu = 0;
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(275360);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(275366);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.b.FixAspectRatioImageView, paramInt, 0);
    this.nwN = paramContext.getFloat(a.b.FixAspectRatioImageView_fix_ratio, 0.0F);
    this.radius = paramContext.getDimensionPixelOffset(a.b.FixAspectRatioImageView_radius, 0);
    this.Itr = paramContext.getDimensionPixelOffset(a.b.FixAspectRatioImageView_left_top_radius, 0);
    this.Its = paramContext.getDimensionPixelOffset(a.b.FixAspectRatioImageView_right_top_radius, 0);
    this.Itt = paramContext.getDimensionPixelOffset(a.b.FixAspectRatioImageView_left_bottom_radius, 0);
    this.Itu = paramContext.getDimensionPixelOffset(a.b.FixAspectRatioImageView_right_bottom_radius, 0);
    if (this.Itr == 0)
    {
      paramInt = this.radius;
      this.Itr = paramInt;
      if (this.Its != 0) {
        break label174;
      }
      paramInt = this.radius;
      label117:
      this.Its = paramInt;
      if (this.Itt != 0) {
        break label182;
      }
      paramInt = this.radius;
      label134:
      this.Itt = paramInt;
      if (this.Itu != 0) {
        break label190;
      }
    }
    label174:
    label182:
    label190:
    for (paramInt = this.radius;; paramInt = this.Itu)
    {
      this.Itu = paramInt;
      paramContext.recycle();
      AppMethodBeat.o(275366);
      return;
      paramInt = this.Itr;
      break;
      paramInt = this.Its;
      break label117;
      paramInt = this.Itt;
      break label134;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(275381);
    int i = Math.max(this.Itr, this.Itt);
    int j = Math.max(this.Its, this.Itu);
    int k = Math.max(this.Itr, this.Its);
    int m = Math.max(this.Itt, this.Itu);
    if ((this.width >= i + j) && (this.height >= k + m))
    {
      Path localPath = new Path();
      localPath.moveTo(this.Itr, 0.0F);
      localPath.lineTo(this.width - this.Its, 0.0F);
      localPath.quadTo(this.width, 0.0F, this.width, this.Its);
      localPath.lineTo(this.width, this.height - this.Itu);
      localPath.quadTo(this.width, this.height, this.width - this.Itu, this.height);
      localPath.lineTo(this.Itt, this.height);
      localPath.quadTo(0.0F, this.height, 0.0F, this.height - this.Itt);
      localPath.lineTo(0.0F, this.Itr);
      localPath.quadTo(0.0F, 0.0F, this.Itr, 0.0F);
      paramCanvas.clipPath(localPath);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(275381);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(275377);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.width = getWidth();
    this.height = getHeight();
    AppMethodBeat.o(275377);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(275372);
    if (this.nwN != 0.0F)
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      paramInt2 = (int)(this.nwN * paramInt1);
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      AppMethodBeat.o(275372);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(275372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.view.FixAspectRatioImageView
 * JD-Core Version:    0.7.0.1
 */