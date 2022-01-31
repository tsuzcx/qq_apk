package com.github.henryye.nativeiv.iv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
  
  public static void mw()
  {
    AppMethodBeat.i(115771);
    c.c.i("Ni.NativeTextureView", "hy: clearing native surface", new Object[0]);
    AppMethodBeat.o(115771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.github.henryye.nativeiv.iv.NativeTextureView
 * JD-Core Version:    0.7.0.1
 */