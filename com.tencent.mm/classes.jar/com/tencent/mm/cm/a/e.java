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

public final class e
  extends a
{
  private static int agCk = -1;
  public ByteBuffer UQj;
  protected List<a> agBO;
  private int[] agBP;
  private int[] agBQ;
  private final FloatBuffer agBT;
  private c agCe;
  private d agCf;
  private a agCg;
  private a agCh;
  private int[] agCi;
  private int agCj;
  public byte[] agCl;
  private boolean agCm;
  private boolean agCn;
  private FloatBuffer agCo;
  private FloatBuffer agCp;
  protected List<a> bTi;
  public int outputHeight;
  public int outputWidth;
  public int surfaceHeight;
  public int surfaceWidth;
  private int ygA;
  
  public e()
  {
    AppMethodBeat.i(231124);
    this.agCj = -1;
    this.outputWidth = 0;
    this.outputHeight = 0;
    this.agCm = false;
    this.agCn = false;
    this.bTi = new ArrayList();
    this.agCo = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.agCo.put(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
    this.agCo.position(0);
    this.agCp = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.agCp.put(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
    this.agCp.position(0);
    float[] arrayOfFloat = k.a(i.agCH, true);
    this.agBT = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.agBT.put(arrayOfFloat).position(0);
    this.agCe = new c();
    this.agCf = new d();
    this.agCg = new a();
    this.agCm = false;
    this.bTi.add(this.agCe);
    this.bTi.add(this.agCf);
    this.bTi.add(this.agCg);
    jLJ();
    AppMethodBeat.o(231124);
  }
  
  public static void i(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(231140);
    int i = 0;
    while (i < 8)
    {
      paramArrayOfFloat2[i] = paramArrayOfFloat1[i];
      i += 1;
    }
    swap(paramArrayOfFloat2, 0, 6);
    swap(paramArrayOfFloat2, 1, 7);
    swap(paramArrayOfFloat2, 2, 4);
    swap(paramArrayOfFloat2, 3, 5);
    AppMethodBeat.o(231140);
  }
  
  private void jLH()
  {
    AppMethodBeat.i(231127);
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
    if (this.agCi != null)
    {
      GLES20.glDeleteFramebuffers(this.agCi.length, this.agCi, 0);
      this.agCi = null;
    }
    AppMethodBeat.o(231127);
  }
  
  private void jLJ()
  {
    AppMethodBeat.i(231151);
    if (this.bTi == null)
    {
      AppMethodBeat.o(231151);
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
        localObject = ((b)localObject).jLI();
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
    AppMethodBeat.o(231151);
  }
  
  private void jLK()
  {
    AppMethodBeat.i(231134);
    if (!this.agCm)
    {
      if (this.agCi != null)
      {
        GLES20.glDeleteFramebuffers(this.agCi.length, this.agCi, 0);
        this.agCi = null;
      }
      if (this.agCi == null)
      {
        this.agCi = new int[1];
        GLES20.glGenFramebuffers(1, this.agCi, 0);
      }
      GLES20.glBindFramebuffer(36160, this.agCi[0]);
      GLES20.glBindTexture(3553, this.ygA);
      GLES20.glTexImage2D(3553, 0, 6408, this.outputWidth, this.outputHeight, 0, 6408, 5121, null);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.ygA, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
    }
    AppMethodBeat.o(231134);
  }
  
  private static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = paramArrayOfFloat[paramInt1];
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
    paramArrayOfFloat[paramInt2] = f;
  }
  
  public final void NV(boolean paramBoolean)
  {
    AppMethodBeat.i(231182);
    this.agCm = paramBoolean;
    if (this.agCh == null)
    {
      this.agCh = new a();
      this.bTi.add(this.agCh);
      this.agCn = true;
      jLJ();
      this.agCh.init();
      pg(this.outputWidth, this.outputHeight);
    }
    this.agCn = false;
    AppMethodBeat.o(231182);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(231175);
    jLF();
    if ((!isInitialized()) || (this.agBP == null) || (this.agBQ == null))
    {
      AppMethodBeat.o(231175);
      return;
    }
    if (this.agBO != null) {
      try
      {
        GLES20.glBindFramebuffer(36160, this.agBP[0]);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        this.agCe.a(paramInt1, this.agBQ[1], paramInt1, this.agCo, this.agCp);
        GLES20.glBindFramebuffer(36160, 0);
        if (this.agCm)
        {
          GLES20.glBindFramebuffer(36160, this.agBP[1]);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          this.agCf.a(paramInt1, this.agBQ[1], this.agBQ[0], this.agCo, this.agBT);
          if ((this.UQj == null) || (this.UQj.capacity() < this.outputHeight * this.outputWidth * 4)) {
            this.UQj = ByteBuffer.allocateDirect(this.outputHeight * this.outputWidth * 4).order(ByteOrder.nativeOrder());
          }
          this.UQj.position(0);
          GLES20.glReadPixels(0, 0, this.outputWidth, this.outputHeight, 6408, 5121, this.UQj);
          this.UQj.position(0);
          this.agCl = this.UQj.array();
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindFramebuffer(36160, 0);
          this.agCh.a(this.agBQ[1], paramInt1, paramInt1, paramFloatBuffer1, paramFloatBuffer2);
        }
        for (;;)
        {
          GLES20.glBindFramebuffer(36160, this.agBP[1]);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          this.agCg.a(this.ygA, this.ygA, this.ygA, this.agCo, this.agCp);
          GLES20.glBindFramebuffer(36160, 0);
          AppMethodBeat.o(231175);
          return;
          GLES20.glBindFramebuffer(36160, this.agCi[0]);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          this.agCf.a(paramInt1, this.agBQ[1], this.agBQ[0], this.agCo, this.agCp);
          GLES20.glBindFramebuffer(36160, 0);
        }
        AppMethodBeat.o(231175);
      }
      catch (IndexOutOfBoundsException paramFloatBuffer1)
      {
        AppMethodBeat.o(231175);
        return;
      }
      catch (Exception paramFloatBuffer1) {}
    }
  }
  
  public final void aFK(int paramInt)
  {
    AppMethodBeat.i(231177);
    if (paramInt >= 4)
    {
      this.agCe.aFL(1);
      this.agCf.aFM(1);
      AppMethodBeat.o(231177);
      return;
    }
    this.agCe.aFL(0);
    this.agCf.aFM(0);
    AppMethodBeat.o(231177);
  }
  
  public final void aFN(int paramInt)
  {
    AppMethodBeat.i(231180);
    if (!this.agCm)
    {
      this.ygA = paramInt;
      jLK();
    }
    AppMethodBeat.o(231180);
  }
  
  public final void apC()
  {
    AppMethodBeat.i(231159);
    super.apC();
    Iterator localIterator = this.bTi.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).init();
    }
    AppMethodBeat.o(231159);
  }
  
  public final void er(float paramFloat)
  {
    AppMethodBeat.i(231178);
    this.agCe.er(paramFloat);
    AppMethodBeat.o(231178);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(231162);
    jLH();
    Iterator localIterator = this.bTi.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).destroy();
    }
    super.onDestroy();
    this.outputHeight = 0;
    this.outputWidth = 0;
    AppMethodBeat.o(231162);
  }
  
  public final void pg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231170);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(231170);
      return;
    }
    if ((this.outputWidth != paramInt1) || (this.outputHeight != paramInt2) || (this.agCn))
    {
      this.outputWidth = paramInt1;
      this.outputHeight = paramInt2;
      this.agCe.pi(this.outputWidth, this.outputHeight);
      super.pg(this.outputWidth, this.outputHeight);
      if (this.agBP != null) {
        jLH();
      }
      if (this.agBQ != null)
      {
        GLES20.glDeleteTextures(this.agBQ.length, this.agBQ, 0);
        this.agBQ = null;
      }
      paramInt2 = this.bTi.size();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        if ((paramInt1 >= paramInt2 - 1) && (this.agCm)) {
          ((a)this.bTi.get(paramInt1)).pg(this.surfaceWidth, this.surfaceHeight);
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          ((a)this.bTi.get(paramInt1)).pg(this.outputWidth, this.outputHeight);
        }
      }
      if ((this.agBO != null) && (this.agBO.size() > 0))
      {
        paramInt2 = this.agBO.size();
        this.agBP = new int[paramInt2 - 1];
        this.agBQ = new int[paramInt2 - 1];
        paramInt1 = 0;
        while (paramInt1 < paramInt2 - 1)
        {
          GLES20.glGenFramebuffers(1, this.agBP, paramInt1);
          GLES20.glBindFramebuffer(36160, this.agBP[paramInt1]);
          GLES20.glGenTextures(1, this.agBQ, paramInt1);
          GLES20.glBindTexture(3553, this.agBQ[paramInt1]);
          GLES20.glTexImage2D(3553, 0, 6408, this.outputWidth, this.outputHeight, 0, 6408, 5121, null);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.agBQ[paramInt1], 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindFramebuffer(36160, 0);
          paramInt1 += 1;
        }
        if (!this.agCm) {
          jLK();
        }
        paramInt2 = this.outputWidth;
        int i = this.outputHeight;
        int j = this.agBO.size();
        paramInt1 = 0;
        while (paramInt1 < j - 1)
        {
          if (this.agBQ[paramInt1] == agCk)
          {
            GLES20.glBindFramebuffer(36160, this.agBP[paramInt1]);
            GLES20.glGenTextures(1, this.agBQ, paramInt1);
            GLES20.glBindTexture(3553, this.agBQ[paramInt1]);
            GLES20.glTexImage2D(3553, 0, 6408, paramInt2, i, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.agBQ[paramInt1], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
          }
          paramInt1 += 1;
        }
        if ((!this.agCm) && (this.agCi[0] == agCk)) {
          jLK();
        }
      }
    }
    AppMethodBeat.o(231170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cm.a.e
 * JD-Core Version:    0.7.0.1
 */