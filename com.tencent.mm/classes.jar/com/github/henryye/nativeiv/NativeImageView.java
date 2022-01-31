package com.github.henryye.nativeiv;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.iv.NativeTextureView;

public class NativeImageView
  extends FrameLayout
{
  private ImageView asq = null;
  private NativeTextureView asr = null;
  private b ass = null;
  
  public NativeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public NativeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.asq, paramContext);
    addView(this.asr, paramContext);
    if ((this.ass == null) || (this.ass.kn() == BitmapType.Undefined) || (this.ass.kn() == BitmapType.Legacy))
    {
      this.asq.setVisibility(0);
      this.asr.setVisibility(8);
    }
    for (;;)
    {
      this.asq.setImageBitmap(null);
      NativeTextureView.kq();
      return;
      this.asq.setVisibility(8);
      this.asr.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.NativeImageView
 * JD-Core Version:    0.7.0.1
 */