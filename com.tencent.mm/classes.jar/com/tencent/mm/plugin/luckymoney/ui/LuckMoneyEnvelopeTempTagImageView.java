package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.wxpay.a.a;

public class LuckMoneyEnvelopeTempTagImageView
  extends ImageView
{
  private String mText;
  private Paint vuq;
  private Path xN;
  
  public LuckMoneyEnvelopeTempTagImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65417);
    this.vuq = new Paint();
    this.xN = new Path();
    this.mText = "";
    this.vuq.setAntiAlias(true);
    c(paramContext, paramAttributeSet, -1);
    AppMethodBeat.o(65417);
  }
  
  public LuckMoneyEnvelopeTempTagImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(65418);
    this.vuq = new Paint();
    this.xN = new Path();
    this.mText = "";
    this.vuq.setAntiAlias(true);
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(65418);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(65419);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.LuckMoneyEnvelopeTempTagImageView, paramInt, 0);
    this.mText = paramContext.getString(0);
    paramInt = paramContext.getColor(1, 0);
    this.vuq.setColor(paramInt);
    paramInt = paramContext.getDimensionPixelSize(2, 0);
    this.vuq.setTextSize(paramInt);
    paramContext.recycle();
    AppMethodBeat.o(65419);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(65420);
    super.onDraw(paramCanvas);
    this.xN.moveTo(0.0F, 0.0F);
    int i = a.fromDPToPix(getContext(), 98);
    this.xN.lineTo(i, i);
    i = (int)((a.fromDPToPix(getContext(), 139) - this.vuq.measureText(this.mText)) / 2.0F);
    paramCanvas.drawTextOnPath(this.mText, this.xN, i, -30.0F, this.vuq);
    AppMethodBeat.o(65420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckMoneyEnvelopeTempTagImageView
 * JD-Core Version:    0.7.0.1
 */