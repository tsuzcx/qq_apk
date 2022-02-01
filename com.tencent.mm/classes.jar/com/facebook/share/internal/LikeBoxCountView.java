package com.facebook.share.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class LikeBoxCountView
  extends FrameLayout
{
  private int additionalTextPadding;
  private Paint borderPaint;
  private float borderRadius;
  private float caretHeight;
  private LikeBoxCountViewCaretPosition caretPosition;
  private float caretWidth;
  private TextView likeCountLabel;
  private int textPadding;
  
  @Deprecated
  public LikeBoxCountView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(8100);
    this.caretPosition = LikeBoxCountViewCaretPosition.LEFT;
    initialize(paramContext);
    AppMethodBeat.o(8100);
  }
  
  private void drawBorder(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(8107);
    Path localPath = new Path();
    float f = this.borderRadius * 2.0F;
    localPath.addArc(new RectF(paramFloat1, paramFloat2, paramFloat1 + f, paramFloat2 + f), -180.0F, 90.0F);
    if (this.caretPosition == LikeBoxCountViewCaretPosition.TOP)
    {
      localPath.lineTo((paramFloat3 - paramFloat1 - this.caretWidth) / 2.0F + paramFloat1, paramFloat2);
      localPath.lineTo((paramFloat3 - paramFloat1) / 2.0F + paramFloat1, paramFloat2 - this.caretHeight);
      localPath.lineTo((paramFloat3 - paramFloat1 + this.caretWidth) / 2.0F + paramFloat1, paramFloat2);
    }
    localPath.lineTo(paramFloat3 - this.borderRadius, paramFloat2);
    localPath.addArc(new RectF(paramFloat3 - f, paramFloat2, paramFloat3, paramFloat2 + f), -90.0F, 90.0F);
    if (this.caretPosition == LikeBoxCountViewCaretPosition.RIGHT)
    {
      localPath.lineTo(paramFloat3, (paramFloat4 - paramFloat2 - this.caretWidth) / 2.0F + paramFloat2);
      localPath.lineTo(this.caretHeight + paramFloat3, (paramFloat4 - paramFloat2) / 2.0F + paramFloat2);
      localPath.lineTo(paramFloat3, (paramFloat4 - paramFloat2 + this.caretWidth) / 2.0F + paramFloat2);
    }
    localPath.lineTo(paramFloat3, paramFloat4 - this.borderRadius);
    localPath.addArc(new RectF(paramFloat3 - f, paramFloat4 - f, paramFloat3, paramFloat4), 0.0F, 90.0F);
    if (this.caretPosition == LikeBoxCountViewCaretPosition.BOTTOM)
    {
      localPath.lineTo((paramFloat3 - paramFloat1 + this.caretWidth) / 2.0F + paramFloat1, paramFloat4);
      localPath.lineTo((paramFloat3 - paramFloat1) / 2.0F + paramFloat1, this.caretHeight + paramFloat4);
      localPath.lineTo((paramFloat3 - paramFloat1 - this.caretWidth) / 2.0F + paramFloat1, paramFloat4);
    }
    localPath.lineTo(this.borderRadius + paramFloat1, paramFloat4);
    localPath.addArc(new RectF(paramFloat1, paramFloat4 - f, f + paramFloat1, paramFloat4), 90.0F, 90.0F);
    if (this.caretPosition == LikeBoxCountViewCaretPosition.LEFT)
    {
      localPath.lineTo(paramFloat1, (paramFloat4 - paramFloat2 + this.caretWidth) / 2.0F + paramFloat2);
      localPath.lineTo(paramFloat1 - this.caretHeight, (paramFloat4 - paramFloat2) / 2.0F + paramFloat2);
      localPath.lineTo(paramFloat1, (paramFloat4 - paramFloat2 - this.caretWidth) / 2.0F + paramFloat2);
    }
    localPath.lineTo(paramFloat1, this.borderRadius + paramFloat2);
    paramCanvas.drawPath(localPath, this.borderPaint);
    AppMethodBeat.o(8107);
  }
  
  private void initialize(Context paramContext)
  {
    AppMethodBeat.i(8104);
    setWillNotDraw(false);
    this.caretHeight = getResources().getDimension(2131166055);
    this.caretWidth = getResources().getDimension(2131166056);
    this.borderRadius = getResources().getDimension(2131166053);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(getResources().getColor(2131100175));
    this.borderPaint.setStrokeWidth(getResources().getDimension(2131166054));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    initializeLikeCountLabel(paramContext);
    addView(this.likeCountLabel);
    setCaretPosition(this.caretPosition);
    AppMethodBeat.o(8104);
  }
  
  private void initializeLikeCountLabel(Context paramContext)
  {
    AppMethodBeat.i(8105);
    this.likeCountLabel = new TextView(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.likeCountLabel.setLayoutParams(paramContext);
    this.likeCountLabel.setGravity(17);
    this.likeCountLabel.setTextSize(0, getResources().getDimension(2131166058));
    this.likeCountLabel.setTextColor(getResources().getColor(2131100176));
    this.textPadding = getResources().getDimensionPixelSize(2131166057);
    this.additionalTextPadding = getResources().getDimensionPixelSize(2131166055);
    AppMethodBeat.o(8105);
  }
  
  private void setAdditionalTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(8106);
    this.likeCountLabel.setPadding(this.textPadding + paramInt1, this.textPadding + paramInt2, this.textPadding + paramInt3, this.textPadding + paramInt4);
    AppMethodBeat.o(8106);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(8103);
    super.onDraw(paramCanvas);
    int m = getPaddingTop();
    int k = getPaddingLeft();
    int j = getWidth() - getPaddingRight();
    int i = getHeight() - getPaddingBottom();
    switch (1.$SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[this.caretPosition.ordinal()])
    {
    }
    for (;;)
    {
      drawBorder(paramCanvas, k, m, j, i);
      AppMethodBeat.o(8103);
      return;
      i = (int)(i - this.caretHeight);
      continue;
      k = (int)(k + this.caretHeight);
      continue;
      m = (int)(m + this.caretHeight);
      continue;
      j = (int)(j - this.caretHeight);
    }
  }
  
  @Deprecated
  public void setCaretPosition(LikeBoxCountViewCaretPosition paramLikeBoxCountViewCaretPosition)
  {
    AppMethodBeat.i(8102);
    this.caretPosition = paramLikeBoxCountViewCaretPosition;
    switch (1.$SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[paramLikeBoxCountViewCaretPosition.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(8102);
      return;
      setAdditionalTextPadding(this.additionalTextPadding, 0, 0, 0);
      AppMethodBeat.o(8102);
      return;
      setAdditionalTextPadding(0, this.additionalTextPadding, 0, 0);
      AppMethodBeat.o(8102);
      return;
      setAdditionalTextPadding(0, 0, this.additionalTextPadding, 0);
      AppMethodBeat.o(8102);
      return;
      setAdditionalTextPadding(0, 0, 0, this.additionalTextPadding);
    }
  }
  
  @Deprecated
  public void setText(String paramString)
  {
    AppMethodBeat.i(8101);
    this.likeCountLabel.setText(paramString);
    AppMethodBeat.o(8101);
  }
  
  public static enum LikeBoxCountViewCaretPosition
  {
    static
    {
      AppMethodBeat.i(8099);
      LEFT = new LikeBoxCountViewCaretPosition("LEFT", 0);
      TOP = new LikeBoxCountViewCaretPosition("TOP", 1);
      RIGHT = new LikeBoxCountViewCaretPosition("RIGHT", 2);
      BOTTOM = new LikeBoxCountViewCaretPosition("BOTTOM", 3);
      $VALUES = new LikeBoxCountViewCaretPosition[] { LEFT, TOP, RIGHT, BOTTOM };
      AppMethodBeat.o(8099);
    }
    
    private LikeBoxCountViewCaretPosition() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.LikeBoxCountView
 * JD-Core Version:    0.7.0.1
 */