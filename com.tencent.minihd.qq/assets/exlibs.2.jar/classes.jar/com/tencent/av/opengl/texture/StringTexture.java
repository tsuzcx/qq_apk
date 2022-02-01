package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.av.opengl.utils.CharacterUtil;

public class StringTexture
  extends UploadedTexture
{
  private static final String TAG = "StringTexture";
  protected Canvas mCanvas;
  private final Bitmap.Config mConfig;
  private int mMaxHeight = 2147483647;
  private int mMaxLength = 2147483647;
  private int mMaxWidth = 2147483647;
  private Paint.FontMetricsInt mMetrics;
  private TextPaint mPaint = new TextPaint();
  private String mText = "";
  private int mTextColor = -1;
  private float mTextSize = 15.0F;
  
  public StringTexture()
  {
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(this.mTextColor);
    this.mPaint.setTextSize(this.mTextSize);
    this.mPaint.setShadowLayer(2.0F, 0.0F, 0.0F, -16777216);
    this.mMetrics = this.mPaint.getFontMetricsInt();
    this.mConfig = Bitmap.Config.ARGB_8888;
    setOpaque(false);
  }
  
  public int getMaxHeight()
  {
    if (this.mMaxHeight == 2147483647) {
      return this.mMetrics.bottom - this.mMetrics.top;
    }
    return this.mMaxHeight;
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  protected void onFreeBitmap(Bitmap paramBitmap)
  {
    if (!inFinalizer()) {
      paramBitmap.recycle();
    }
  }
  
  protected Bitmap onGetBitmap()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, this.mConfig);
    this.mCanvas = new Canvas(localBitmap);
    this.mCanvas.translate(0.0F, -this.mMetrics.ascent);
    this.mCanvas.drawText(this.mText, 0.0F, 0.0F, this.mPaint);
    return localBitmap;
  }
  
  public void refreshText()
  {
    int k;
    int j;
    if (!TextUtils.isEmpty(this.mText))
    {
      int i = 0;
      k = CharacterUtil.length(this.mText);
      j = (int)Math.ceil(this.mPaint.measureText(this.mText));
      if ((k > this.mMaxLength) || (j > this.mMaxWidth)) {
        i = 1;
      }
      if (i != 0)
      {
        i = Math.min(Math.max((this.mMaxWidth - (int)Math.ceil(this.mPaint.measureText("..."))) / (int)Math.ceil(this.mPaint.measureText("M")), 1), this.mMaxLength);
        this.mText = (CharacterUtil.subString(this.mText, 0, i) + "...");
        j = (int)Math.ceil(this.mPaint.measureText(this.mText));
      }
      int m = this.mMetrics.bottom - this.mMetrics.top;
      i = j;
      if (j <= 0) {
        i = 1;
      }
      j = m;
      k = i;
      if (m <= 0)
      {
        j = 1;
        k = i;
      }
    }
    for (;;)
    {
      setSourceSize(k, j);
      setTextureSize(k, j);
      return;
      k = 1;
      j = 1;
    }
  }
  
  public void setBold(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mPaint.setTypeface(Typeface.defaultFromStyle(1));
      return;
    }
    this.mPaint.setTypeface(Typeface.defaultFromStyle(0));
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt > 0) {
      this.mMaxHeight = paramInt;
    }
  }
  
  public void setMaxLength(int paramInt)
  {
    this.mMaxLength = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt > 0) {
      this.mMaxWidth = paramInt;
    }
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    this.mPaint.setColor(this.mTextColor);
  }
  
  public void setTextSize(float paramFloat)
  {
    this.mTextSize = paramFloat;
    this.mPaint.setTextSize(this.mTextSize);
    this.mMetrics = this.mPaint.getFontMetricsInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.texture.StringTexture
 * JD-Core Version:    0.7.0.1
 */