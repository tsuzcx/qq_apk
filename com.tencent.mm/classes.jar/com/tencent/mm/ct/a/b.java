package com.tencent.mm.ct.a;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class b
  extends a
{
  static final float[] YGm = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] YGn = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  protected List<a> YGg;
  private int[] YGh;
  private int[] YGi;
  private final FloatBuffer YGj;
  private final FloatBuffer YGk;
  private final FloatBuffer YGl;
  protected List<a> afd;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    AppMethodBeat.i(187984);
    this.afd = null;
    if (this.afd == null) {
      this.afd = new ArrayList();
    }
    for (;;)
    {
      this.YGj = ByteBuffer.allocateDirect(YGm.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.YGj.put(YGm).position(0);
      this.YGk = ByteBuffer.allocateDirect(YGn.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.YGk.put(YGn).position(0);
      float[] arrayOfFloat = k.a(i.YHb, true);
      this.YGl = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.YGl.put(arrayOfFloat).position(0);
      AppMethodBeat.o(187984);
      return;
      igw();
    }
  }
  
  private void igu()
  {
    AppMethodBeat.i(187994);
    if (this.YGi != null)
    {
      GLES20.glDeleteTextures(this.YGi.length, this.YGi, 0);
      this.YGi = null;
    }
    if (this.YGh != null)
    {
      GLES20.glDeleteFramebuffers(this.YGh.length, this.YGh, 0);
      this.YGh = null;
    }
    AppMethodBeat.o(187994);
  }
  
  public final void Pu()
  {
    AppMethodBeat.i(187990);
    super.Pu();
    Iterator localIterator = this.afd.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).init();
    }
    AppMethodBeat.o(187990);
  }
  
  @SuppressLint({"WrongCall"})
  public final void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(187999);
    igs();
    if ((!isInitialized()) || (this.YGh == null) || (this.YGi == null))
    {
      AppMethodBeat.o(187999);
      return;
    }
    if (this.YGg != null)
    {
      int j = this.YGg.size();
      paramInt2 = 0;
      paramInt3 = paramInt1;
      if (paramInt2 < j)
      {
        a locala = (a)this.YGg.get(paramInt2);
        int i;
        if (paramInt2 < j - 1)
        {
          i = 1;
          label90:
          if (i != 0)
          {
            GLES20.glBindFramebuffer(36160, this.YGh[paramInt2]);
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          }
          if (paramInt2 != 0) {
            break label160;
          }
          locala.a(paramInt3, paramInt1, paramInt1, paramFloatBuffer1, paramFloatBuffer2);
        }
        for (;;)
        {
          if (i != 0)
          {
            GLES20.glBindFramebuffer(36160, 0);
            paramInt3 = this.YGi[paramInt2];
          }
          paramInt2 += 1;
          break;
          i = 0;
          break label90;
          label160:
          if (paramInt2 == j - 1)
          {
            FloatBuffer localFloatBuffer2 = this.YGj;
            if (j % 2 == 0) {}
            for (FloatBuffer localFloatBuffer1 = this.YGl;; localFloatBuffer1 = this.YGk)
            {
              locala.a(paramInt3, paramInt1, paramInt1, localFloatBuffer2, localFloatBuffer1);
              break;
            }
          }
          locala.a(paramInt3, paramInt1, paramInt1, this.YGj, this.YGk);
        }
      }
    }
    AppMethodBeat.o(187999);
  }
  
  public final List<a> igv()
  {
    return this.YGg;
  }
  
  public final void igw()
  {
    AppMethodBeat.i(188004);
    if (this.afd == null)
    {
      AppMethodBeat.o(188004);
      return;
    }
    Iterator localIterator;
    if (this.YGg == null)
    {
      this.YGg = new ArrayList();
      localIterator = this.afd.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label140;
      }
      Object localObject = (a)localIterator.next();
      if ((localObject instanceof b))
      {
        ((b)localObject).igw();
        localObject = ((b)localObject).YGg;
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          continue;
        }
        this.YGg.addAll((Collection)localObject);
        continue;
        this.YGg.clear();
        break;
      }
      this.YGg.add(localObject);
    }
    label140:
    AppMethodBeat.o(188004);
  }
  
  public final void nj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187995);
    super.nj(paramInt1, paramInt2);
    if (this.YGh != null) {
      igu();
    }
    int j = this.afd.size();
    int i = 0;
    while (i < j)
    {
      ((a)this.afd.get(i)).nj(paramInt1, paramInt2);
      i += 1;
    }
    if ((this.YGg != null) && (this.YGg.size() > 0))
    {
      j = this.YGg.size();
      this.YGh = new int[j - 1];
      this.YGi = new int[j - 1];
      i = 0;
      while (i < j - 1)
      {
        GLES20.glGenFramebuffers(1, this.YGh, i);
        GLES20.glGenTextures(1, this.YGi, i);
        GLES20.glBindTexture(3553, this.YGi[i]);
        GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.YGh[i]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.YGi[i], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        i += 1;
      }
    }
    AppMethodBeat.o(187995);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(187993);
    igu();
    Iterator localIterator = this.afd.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).destroy();
    }
    super.onDestroy();
    AppMethodBeat.o(187993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ct.a.b
 * JD-Core Version:    0.7.0.1
 */