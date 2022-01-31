package com.tencent.filter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.util.a;
import com.tencent.util.d;
import com.tencent.util.g;
import com.tencent.view.b;

public final class m$o
  extends m.n
{
  String bfY = null;
  double bfZ = 0.0D;
  int bga = 0;
  
  public m$o(String paramString1, String paramString2, double paramDouble)
  {
    super(paramString1, 0, 33986);
    this.bfY = paramString2;
    this.bfZ = paramDouble;
  }
  
  public m$o(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1, 0, paramInt);
    this.bfY = paramString2;
  }
  
  public m$o(String paramString1, String paramString2, int paramInt, byte paramByte)
  {
    super(paramString1, 0, 33986);
    this.bfY = paramString2;
    this.bga = paramInt;
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
    if (this.bfY == null) {
      return;
    }
    GLES20.glActiveTexture(this.bfX);
    d.cRj().y(this.texture);
    GLES20.glBindTexture(3553, this.texture[0]);
    Object localObject1 = b.pe(this.bfY);
    Object localObject2 = null;
    if (localObject1 != null) {
      if (this.bfZ > 0.0D) {
        if (this.bfZ < 1.0D)
        {
          localObject2 = a.e((Bitmap)localObject1, (int)(((Bitmap)localObject1).getHeight() * this.bfZ), ((Bitmap)localObject1).getHeight());
          ((Bitmap)localObject1).recycle();
          localObject1 = null;
          label100:
          if (this.bga != 1) {
            break label308;
          }
          localObject2 = new Matrix();
          ((Matrix)localObject2).setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, ((Bitmap)localObject1).getHeight(), 0.0F, 0.0F, 1.0F });
          localObject2 = a.a((Bitmap)localObject1, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject2);
          if (localObject2 != null) {
            break label304;
          }
          label186:
          if (localObject1 == null) {
            break label313;
          }
          GLUtils.texImage2D(3553, 0, (Bitmap)localObject1, 0);
          ((Bitmap)localObject1).recycle();
        }
      }
    }
    for (;;)
    {
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      return;
      localObject2 = a.e((Bitmap)localObject1, ((Bitmap)localObject1).getWidth(), (int)(((Bitmap)localObject1).getWidth() / this.bfZ));
      break;
      localObject2 = localObject1;
      break label100;
      g.i("Param", "lastBitmap is null " + this.bfY);
      break label100;
      label304:
      ((Bitmap)localObject1).recycle();
      label308:
      localObject1 = localObject2;
      break label186;
      label313:
      g.i("Param", "bitmap is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.m.o
 * JD-Core Version:    0.7.0.1
 */