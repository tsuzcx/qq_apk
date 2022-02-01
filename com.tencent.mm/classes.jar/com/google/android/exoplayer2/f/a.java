package com.google.android.exoplayer2.f;

import android.graphics.Bitmap;
import android.text.Layout.Alignment;

public class a
{
  public final float bAa;
  public final int bAb;
  public final float bAc;
  public final int bAd;
  public final float bAe;
  public final boolean bAf;
  public final Bitmap bitmap;
  public final Layout.Alignment bzZ;
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
    this.bzZ = paramAlignment;
    this.bitmap = paramBitmap;
    this.bAa = paramFloat1;
    this.lineType = paramInt1;
    this.bAb = paramInt2;
    this.bAc = paramFloat2;
    this.bAd = paramInt3;
    this.size = paramFloat3;
    this.bAe = paramFloat4;
    this.bAf = paramBoolean;
    this.windowColor = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a
 * JD-Core Version:    0.7.0.1
 */