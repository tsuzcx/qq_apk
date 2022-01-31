package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.util.d;

public final class m$m
  extends m.n
{
  int[] value;
  
  public m$m(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    super(paramString, 0, paramInt);
    this.value = paramArrayOfInt;
  }
  
  public final void clear()
  {
    GLES20.glActiveTexture(this.bfX);
    d.cRj().z(this.texture);
    super.clear();
  }
  
  public final void initialParams(int paramInt)
  {
    super.initialParams(paramInt);
    if (this.value == null) {
      return;
    }
    GLES20.glActiveTexture(this.bfX);
    d.cRj().y(this.texture);
    GLSLRender.nativeTextCure(this.value, this.texture[0]);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.m.m
 * JD-Core Version:    0.7.0.1
 */