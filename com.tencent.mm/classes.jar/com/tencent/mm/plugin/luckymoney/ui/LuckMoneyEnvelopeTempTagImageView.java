package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wxpay.a.a;

public class LuckMoneyEnvelopeTempTagImageView
  extends ImageView
{
  private String mText;
  private Paint oqV;
  private Path ou;
  
  public LuckMoneyEnvelopeTempTagImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142029);
    this.oqV = new Paint();
    this.ou = new Path();
    this.mText = "";
    this.oqV.setAntiAlias(true);
    a(paramContext, paramAttributeSet, -1);
    AppMethodBeat.o(142029);
  }
  
  public LuckMoneyEnvelopeTempTagImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142030);
    this.oqV = new Paint();
    this.ou = new Path();
    this.mText = "";
    this.oqV.setAntiAlias(true);
    a(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(142030);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(142031);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.LuckMoneyEnvelopeTempTagImageView, paramInt, 0);
    this.mText = paramContext.getString(0);
    paramInt = paramContext.getColor(1, 0);
    this.oqV.setColor(paramInt);
    paramInt = paramContext.getDimensionPixelSize(2, 0);
    this.oqV.setTextSize(paramInt);
    paramContext.recycle();
    AppMethodBeat.o(142031);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142032);
    super.onDraw(paramCanvas);
    this.ou.moveTo(0.0F, 0.0F);
    int i = a.fromDPToPix(getContext(), 98);
    this.ou.lineTo(i, i);
    i = (int)((a.fromDPToPix(getContext(), 139) - this.oqV.measureText(this.mText)) / 2.0F);
    paramCanvas.drawTextOnPath(this.mText, this.ou, i, -30.0F, this.oqV);
    AppMethodBeat.o(142032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckMoneyEnvelopeTempTagImageView
 * JD-Core Version:    0.7.0.1
 */