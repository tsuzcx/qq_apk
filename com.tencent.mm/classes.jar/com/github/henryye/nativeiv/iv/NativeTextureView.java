package com.github.henryye.nativeiv.iv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.magicbrush.a.d.f;

public class NativeTextureView
  extends TextureView
{
  public NativeTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NativeTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public NativeTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void kq()
  {
    d.f.i("Ni.NativeTextureView", "hy: clearing native surface", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.github.henryye.nativeiv.iv.NativeTextureView
 * JD-Core Version:    0.7.0.1
 */