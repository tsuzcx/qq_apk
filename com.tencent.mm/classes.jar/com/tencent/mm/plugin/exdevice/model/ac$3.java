package com.tencent.mm.plugin.exdevice.model;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class ac$3
  extends ShapeDrawable.ShaderFactory
{
  ac$3(ac paramac, int[] paramArrayOfInt) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    float f = paramInt2;
    paramInt1 = this.jwz[0];
    Shader.TileMode localTileMode = Shader.TileMode.REPEAT;
    return new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, paramInt1 }, new float[] { 0.0F, 1.0F }, localTileMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac.3
 * JD-Core Version:    0.7.0.1
 */