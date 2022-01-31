package com.tencent.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.f;

public final class m$l
  extends m.n
{
  public Bitmap bwy;
  public boolean update;
  
  public m$l(String paramString)
  {
    super(paramString, 0, 33987);
    AppMethodBeat.i(86413);
    this.bwy = null;
    boolean bool1 = bool2;
    if (this.bwy != null)
    {
      bool1 = bool2;
      if (!this.bwy.isRecycled()) {
        bool1 = true;
      }
    }
    this.update = bool1;
    AppMethodBeat.o(86413);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(86414);
    GLES20.glActiveTexture(this.textureId);
    f.dWZ().J(this.texture);
    super.clear();
    AppMethodBeat.o(86414);
  }
  
  public final void initialParams(int paramInt)
  {
    AppMethodBeat.i(86415);
    super.initialParams(paramInt);
    GLES20.glActiveTexture(this.textureId);
    f.dWZ().I(this.texture);
    AppMethodBeat.o(86415);
  }
  
  public final void setParams(int paramInt)
  {
    AppMethodBeat.i(86416);
    if (this.update)
    {
      GLES20.glActiveTexture(this.textureId);
      GLES20.glBindTexture(3553, this.texture[0]);
    }
    try
    {
      GLUtils.texImage2D(3553, 0, this.bwy, 0);
      label43:
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      super.setParams(paramInt);
      this.update = false;
      AppMethodBeat.o(86416);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.m.l
 * JD-Core Version:    0.7.0.1
 */