package com.github.henryye.nativeiv;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.iv.NativeTextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NativeImageView
  extends FrameLayout
{
  private ImageView auD;
  private NativeTextureView auE;
  private b auF;
  
  public NativeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public NativeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(115753);
    this.auD = null;
    this.auE = null;
    this.auF = null;
    this.auD = new ImageView(getContext());
    this.auE = new NativeTextureView(getContext());
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.auD, paramContext);
    addView(this.auE, paramContext);
    if ((this.auF == null) || (this.auF.mu() == BitmapType.Undefined) || (this.auF.mu() == BitmapType.Legacy))
    {
      this.auD.setVisibility(0);
      this.auE.setVisibility(8);
    }
    for (;;)
    {
      this.auD.setImageBitmap(null);
      NativeTextureView.mw();
      AppMethodBeat.o(115753);
      return;
      this.auD.setVisibility(8);
      this.auE.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.github.henryye.nativeiv.NativeImageView
 * JD-Core Version:    0.7.0.1
 */