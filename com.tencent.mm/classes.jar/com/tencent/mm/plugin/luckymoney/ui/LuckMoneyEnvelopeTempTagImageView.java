package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.wxpay.a.k;

public class LuckMoneyEnvelopeTempTagImageView
  extends ImageView
{
  private Paint KyZ;
  private Path cja;
  private String mText;
  
  public LuckMoneyEnvelopeTempTagImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65417);
    this.KyZ = new Paint();
    this.cja = new Path();
    this.mText = "";
    this.KyZ.setAntiAlias(true);
    b(paramContext, paramAttributeSet, -1);
    AppMethodBeat.o(65417);
  }
  
  public LuckMoneyEnvelopeTempTagImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(65418);
    this.KyZ = new Paint();
    this.cja = new Path();
    this.mText = "";
    this.KyZ.setAntiAlias(true);
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(65418);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(65419);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.LuckMoneyEnvelopeTempTagImageView, paramInt, 0);
    this.mText = paramContext.getString(a.k.LuckMoneyEnvelopeTempTagImageView_tagText);
    paramInt = paramContext.getColor(a.k.LuckMoneyEnvelopeTempTagImageView_tagTextColor, 0);
    this.KyZ.setColor(paramInt);
    paramInt = paramContext.getDimensionPixelSize(a.k.LuckMoneyEnvelopeTempTagImageView_tagTextSize, 0);
    this.KyZ.setTextSize(paramInt);
    paramContext.recycle();
    AppMethodBeat.o(65419);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(65420);
    super.onDraw(paramCanvas);
    this.cja.moveTo(0.0F, 0.0F);
    int i = a.fromDPToPix(getContext(), 98);
    this.cja.lineTo(i, i);
    i = (int)((a.fromDPToPix(getContext(), 139) - this.KyZ.measureText(this.mText)) / 2.0F);
    paramCanvas.drawTextOnPath(this.mText, this.cja, i, -30.0F, this.KyZ);
    AppMethodBeat.o(65420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckMoneyEnvelopeTempTagImageView
 * JD-Core Version:    0.7.0.1
 */