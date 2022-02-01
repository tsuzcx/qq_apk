package com.google.android.exoplayer2.f;

import android.graphics.Bitmap;
import android.text.Layout.Alignment;

public class a
{
  public final Layout.Alignment bAb;
  public final float bAc;
  public final int bAd;
  public final float bAe;
  public final int bAf;
  public final float bAg;
  public final boolean bAh;
  public final Bitmap bitmap;
  public final int lineType;
  public final float size;
  public final CharSequence text;
  public final int windowColor;
  
  public a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(null, null, paramBitmap, paramFloat2, 0, 0, paramFloat1, 0, paramFloat3, paramFloat4, false, -16777216);
  }
  
  public a(CharSequence paramCharSequence)
  {
    this(paramCharSequence, null, 1.4E-45F, -2147483648, -2147483648, 1.4E-45F, -2147483648, 1.4E-45F);
  }
  
  public a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
  {
    this(paramCharSequence, paramAlignment, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3, false, -16777216);
  }
  
  public a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, boolean paramBoolean, int paramInt4)
  {
    this(paramCharSequence, paramAlignment, null, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3, 1.4E-45F, paramBoolean, paramInt4);
  }
  
  private a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, Bitmap paramBitmap, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, float paramFloat4, boolean paramBoolean, int paramInt4)
  {
    this.text = paramCharSequence;
    this.bAb = paramAlignment;
    this.bitmap = paramBitmap;
    this.bAc = paramFloat1;
    this.lineType = paramInt1;
    this.bAd = paramInt2;
    this.bAe = paramFloat2;
    this.bAf = paramInt3;
    this.size = paramFloat3;
    this.bAg = paramFloat4;
    this.bAh = paramBoolean;
    this.windowColor = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a
 * JD-Core Version:    0.7.0.1
 */