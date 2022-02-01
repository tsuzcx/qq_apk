package com.tencent.mm.cm.a;

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
  public static final float[] Qfk = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static final float[] agBU = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  protected List<a> agBO;
  private int[] agBP;
  private int[] agBQ;
  private final FloatBuffer agBR;
  private final FloatBuffer agBS;
  private final FloatBuffer agBT;
  protected List<a> bTi;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    AppMethodBeat.i(231133);
    this.bTi = null;
    if (this.bTi == null) {
      this.bTi = new ArrayList();
    }
    for (;;)
    {
      this.agBR = ByteBuffer.allocateDirect(agBU.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.agBR.put(agBU).position(0);
      this.agBS = ByteBuffer.allocateDirect(Qfk.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.agBS.put(Qfk).position(0);
      float[] arrayOfFloat = k.a(i.agCH, true);
      this.agBT = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.agBT.put(arrayOfFloat).position(0);
      AppMethodBeat.o(231133);
      return;
      jLJ();
    }
  }
  
  private void jLH()
  {
    AppMethodBeat.i(231138);
    if (this.agBQ != null)
    {
      GLES20.glDeleteTextures(this.agBQ.length, this.agBQ, 0);
      this.agBQ = null;
    }
    if (this.agBP != null)
    {
      GLES20.glDeleteFramebuffers(this.agBP.length, this.agBP, 0);
      this.agBP = null;
    }
    AppMethodBeat.o(231138);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(231166);
    jLF();
    if ((!isInitialized()) || (this.agBP == null) || (this.agBQ == null))
    {
      AppMethodBeat.o(231166);
      return;
    }
    if (this.agBO != null)
    {
      int j = this.agBO.size();
      paramInt2 = 0;
      paramInt3 = paramInt1;
      if (paramInt2 < j)
      {
        a locala = (a)this.agBO.get(paramInt2);
        int i;
        if (paramInt2 < j - 1)
        {
          i = 1;
          label90:
          if (i != 0)
          {
            GLES20.glBindFramebuffer(36160, this.agBP[paramInt2]);
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
            paramInt3 = this.agBQ[paramInt2];
          }
          paramInt2 += 1;
          break;
          i = 0;
          break label90;
          label160:
          if (paramInt2 == j - 1)
          {
            FloatBuffer localFloatBuffer2 = this.agBR;
            if (j % 2 == 0) {}
            for (FloatBuffer localFloatBuffer1 = this.agBT;; localFloatBuffer1 = this.agBS)
            {
              locala.a(paramInt3, paramInt1, paramInt1, localFloatBuffer2, localFloatBuffer1);
              break;
            }
          }
          locala.a(paramInt3, paramInt1, paramInt1, this.agBR, this.agBS);
        }
      }
    }
    AppMethodBeat.o(231166);
  }
  
  public final void apC()
  {
    AppMethodBeat.i(231145);
    super.apC();
    Iterator localIterator = this.bTi.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).init();
    }
    AppMethodBeat.o(231145);
  }
  
  public final List<a> jLI()
  {
    return this.agBO;
  }
  
  public final void jLJ()
  {
    AppMethodBeat.i(231172);
    if (this.bTi == null)
    {
      AppMethodBeat.o(231172);
      return;
    }
    Iterator localIterator;
    if (this.agBO == null)
    {
      this.agBO = new ArrayList();
      localIterator = this.bTi.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label140;
      }
      Object localObject = (a)localIterator.next();
      if ((localObject instanceof b))
      {
        ((b)localObject).jLJ();
        localObject = ((b)localObject).agBO;
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          continue;
        }
        this.agBO.addAll((Collection)localObject);
        continue;
        this.agBO.clear();
        break;
      }
      this.agBO.add(localObject);
    }
    label140:
    AppMethodBeat.o(231172);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(231153);
    jLH();
    Iterator localIterator = this.bTi.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).destroy();
    }
    super.onDestroy();
    AppMethodBeat.o(231153);
  }
  
  public final void pg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231160);
    super.pg(paramInt1, paramInt2);
    if (this.agBP != null) {
      jLH();
    }
    int j = this.bTi.size();
    int i = 0;
    while (i < j)
    {
      ((a)this.bTi.get(i)).pg(paramInt1, paramInt2);
      i += 1;
    }
    if ((this.agBO != null) && (this.agBO.size() > 0))
    {
      j = this.agBO.size();
      this.agBP = new int[j - 1];
      this.agBQ = new int[j - 1];
      i = 0;
      while (i < j - 1)
      {
        GLES20.glGenFramebuffers(1, this.agBP, i);
        GLES20.glGenTextures(1, this.agBQ, i);
        GLES20.glBindTexture(3553, this.agBQ[i]);
        GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.agBP[i]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.agBQ[i], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        i += 1;
      }
    }
    AppMethodBeat.o(231160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cm.a.b
 * JD-Core Version:    0.7.0.1
 */