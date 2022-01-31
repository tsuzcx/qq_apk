package com.tencent.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.f;
import com.tencent.view.g;

public abstract class m
{
  public int handle;
  public String name;
  
  public m(String paramString)
  {
    this.name = paramString;
    this.handle = -1;
  }
  
  public void clear()
  {
    this.handle = -1;
  }
  
  public void initialParams(int paramInt)
  {
    this.handle = GLES20.glGetUniformLocation(paramInt, this.name);
  }
  
  public abstract void setParams(int paramInt);
  
  public String toString()
  {
    return this.name;
  }
  
  public static final class j
    extends m
  {
    private final float[] bwx;
    
    public j(String paramString, float[] paramArrayOfFloat)
    {
      super();
      this.bwx = paramArrayOfFloat;
    }
    
    public final void setParams(int paramInt)
    {
      AppMethodBeat.i(86409);
      GLES20.glUniformMatrix4fv(this.handle, 1, false, this.bwx, 0);
      AppMethodBeat.o(86409);
    }
  }
  
  public static final class k
    extends m.n
  {
    Bitmap bwy;
    boolean bwz = false;
    
    public k(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean)
    {
      super(0, paramInt);
      this.bwz = paramBoolean;
      this.bwy = paramBitmap;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(86410);
      GLES20.glActiveTexture(this.textureId);
      f.dWZ().J(this.texture);
      super.clear();
      if ((this.bwz) && (this.bwy != null))
      {
        this.bwy.recycle();
        this.bwy = null;
      }
      AppMethodBeat.o(86410);
    }
    
    public final void h(Bitmap paramBitmap)
    {
      AppMethodBeat.i(86412);
      if ((this.bwz) && (this.bwy != null) && (!this.bwy.isRecycled())) {
        this.bwy.recycle();
      }
      this.bwy = paramBitmap;
      if ((this.bwy == null) || (this.bwy.isRecycled()))
      {
        AppMethodBeat.o(86412);
        return;
      }
      GLES20.glActiveTexture(this.textureId);
      GLES20.glBindTexture(3553, this.texture[0]);
      GLUtils.texImage2D(3553, 0, this.bwy, 0);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      AppMethodBeat.o(86412);
    }
    
    public final void initialParams(int paramInt)
    {
      AppMethodBeat.i(86411);
      super.initialParams(paramInt);
      if ((this.bwy == null) || (this.bwy.isRecycled()))
      {
        AppMethodBeat.o(86411);
        return;
      }
      GLES20.glActiveTexture(this.textureId);
      f.dWZ().I(this.texture);
      GLES20.glBindTexture(3553, this.texture[0]);
      GLUtils.texImage2D(3553, 0, this.bwy, 0);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      AppMethodBeat.o(86411);
    }
  }
  
  public static class n
    extends m
  {
    int[] texture;
    int textureId;
    
    public n(String paramString, int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(86419);
      this.texture = new int[] { 0 };
      this.textureId = paramInt2;
      this.texture[0] = paramInt1;
      AppMethodBeat.o(86419);
    }
    
    public void clear()
    {
      AppMethodBeat.i(86420);
      super.clear();
      this.texture[0] = 0;
      AppMethodBeat.o(86420);
    }
    
    public void setParams(int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(86421);
      if ((this.handle < 0) || (this.texture[0] == 0))
      {
        AppMethodBeat.o(86421);
        return;
      }
      GLES20.glActiveTexture(this.textureId);
      GLES20.glBindTexture(3553, this.texture[0]);
      paramInt = i;
      switch (this.textureId)
      {
      default: 
        paramInt = i;
      }
      for (;;)
      {
        GLES20.glUniform1i(this.handle, paramInt);
        g.checkGlError("TextureParam setParams");
        AppMethodBeat.o(86421);
        return;
        paramInt = 1;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
        continue;
        paramInt = 4;
        continue;
        paramInt = 5;
        continue;
        paramInt = 6;
        continue;
        paramInt = 7;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.m
 * JD-Core Version:    0.7.0.1
 */