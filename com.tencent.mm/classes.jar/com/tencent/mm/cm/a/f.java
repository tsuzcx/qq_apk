package com.tencent.mm.cm.a;

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

public final class f
  extends a
{
  private static int RfI = -1;
  public ByteBuffer Hlu;
  private d RfC;
  private e RfD;
  private a RfE;
  private i RfF;
  private int[] RfG;
  private int RfH;
  c RfJ;
  public byte[] RfK;
  private boolean RfL;
  private boolean RfM;
  private FloatBuffer RfN;
  private FloatBuffer RfO;
  protected List<a> Rfm;
  private int[] Rfn;
  private int[] Rfo;
  private final FloatBuffer Rfr;
  protected List<a> aby;
  public int outputHeight;
  public int outputWidth;
  private int rod;
  public int surfaceHeight;
  public int surfaceWidth;
  
  public f()
  {
    AppMethodBeat.i(190240);
    this.RfH = -1;
    this.outputWidth = 0;
    this.outputHeight = 0;
    this.RfL = false;
    this.RfM = false;
    this.aby = new ArrayList();
    this.RfN = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.RfN.put(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
    this.RfN.position(0);
    this.RfO = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.RfO.put(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
    this.RfO.position(0);
    float[] arrayOfFloat = l.a(j.Rgj, false);
    this.Rfr = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.Rfr.put(arrayOfFloat).position(0);
    this.RfJ = new c();
    this.RfC = new d();
    this.RfD = new e();
    this.RfF = new i();
    this.RfL = false;
    this.aby.add(this.RfC);
    this.aby.add(this.RfD);
    hfd();
    AppMethodBeat.o(190240);
  }
  
  public static void e(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(190251);
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
    AppMethodBeat.o(190251);
  }
  
  private void hfb()
  {
    AppMethodBeat.i(190243);
    if (this.Rfo != null)
    {
      GLES20.glDeleteTextures(this.Rfo.length, this.Rfo, 0);
      this.Rfo = null;
    }
    if (this.Rfn != null)
    {
      GLES20.glDeleteFramebuffers(this.Rfn.length, this.Rfn, 0);
      this.Rfn = null;
    }
    if (this.RfG != null)
    {
      GLES20.glDeleteFramebuffers(this.RfG.length, this.RfG, 0);
      this.RfG = null;
    }
    AppMethodBeat.o(190243);
  }
  
  private void hfd()
  {
    AppMethodBeat.i(190252);
    if (this.aby == null)
    {
      AppMethodBeat.o(190252);
      return;
    }
    Iterator localIterator;
    if (this.Rfm == null)
    {
      this.Rfm = new ArrayList();
      localIterator = this.aby.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label140;
      }
      Object localObject = (a)localIterator.next();
      if ((localObject instanceof b))
      {
        ((b)localObject).hfd();
        localObject = ((b)localObject).hfc();
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          continue;
        }
        this.Rfm.addAll((Collection)localObject);
        continue;
        this.Rfm.clear();
        break;
      }
      this.Rfm.add(localObject);
    }
    label140:
    AppMethodBeat.o(190252);
  }
  
  private void hfe()
  {
    AppMethodBeat.i(190248);
    if (!this.RfL)
    {
      if (this.RfG == null)
      {
        this.RfG = new int[1];
        GLES20.glGenFramebuffers(1, this.RfG, 0);
      }
      GLES20.glBindFramebuffer(36160, this.RfG[0]);
      GLES20.glBindTexture(3553, this.rod);
      GLES20.glTexImage2D(3553, 0, 6408, this.outputWidth, this.outputHeight, 0, 6408, 5121, null);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.rod, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
    }
    AppMethodBeat.o(190248);
  }
  
  private static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = paramArrayOfFloat[paramInt1];
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
    paramArrayOfFloat[paramInt2] = f;
  }
  
  public final void DA(boolean paramBoolean)
  {
    AppMethodBeat.i(190250);
    this.RfL = paramBoolean;
    if (this.RfE == null)
    {
      this.RfE = new a();
      this.aby.add(this.RfE);
      this.RfM = true;
      hfd();
      this.RfE.init();
      lS(this.outputWidth, this.outputHeight);
    }
    this.RfM = false;
    AppMethodBeat.o(190250);
  }
  
  public final void MC()
  {
    AppMethodBeat.i(190241);
    super.MC();
    this.RfJ.lU(this.mOutputWidth, this.mOutputHeight);
    Object localObject = this.aby.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).init();
    }
    localObject = this.RfF;
    ((i)localObject).RfU = new int[1];
    GLES20.glGenFramebuffers(1, ((i)localObject).RfU, 0);
    AppMethodBeat.o(190241);
  }
  
  @SuppressLint({"WrongCall"})
  public final void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(190245);
    heZ();
    if ((!this.Rfh) || (this.Rfn == null) || (this.Rfo == null))
    {
      AppMethodBeat.o(190245);
      return;
    }
    if (this.Rfm != null) {}
    for (;;)
    {
      try
      {
        GLES20.glBindFramebuffer(36160, this.Rfn[0]);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        this.RfC.a(paramInt1, this.RfH, paramInt1, this.RfN, this.RfO);
        GLES20.glBindFramebuffer(36160, 0);
        int i;
        if (this.RfL)
        {
          GLES20.glBindFramebuffer(36160, this.Rfn[1]);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          this.RfD.a(paramInt1, this.RfH, this.Rfo[0], this.RfN, this.Rfr);
          if ((this.Hlu == null) || (this.Hlu.capacity() < this.outputHeight * this.outputWidth * 4)) {
            this.Hlu = ByteBuffer.allocateDirect(this.outputHeight * this.outputWidth * 4).order(ByteOrder.nativeOrder());
          }
          this.Hlu.position(0);
          GLES20.glReadPixels(0, 0, this.outputWidth, this.outputHeight, 6408, 5121, this.Hlu);
          this.Hlu.position(0);
          this.RfK = this.Hlu.array();
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindFramebuffer(36160, 0);
          this.RfE.a(this.Rfo[1], paramInt1, paramInt1, paramFloatBuffer1, paramFloatBuffer2);
          paramFloatBuffer1 = this.RfF;
          paramInt1 = this.mOutputWidth;
          paramInt2 = this.mOutputHeight;
          paramInt3 = this.rod;
          i = this.RfH;
          paramFloatBuffer2 = new int[1];
          if (paramInt3 == -1)
          {
            paramInt1 = -1;
            this.RfH = paramInt1;
            AppMethodBeat.o(190245);
          }
        }
        else
        {
          GLES20.glBindFramebuffer(36160, this.RfG[0]);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          this.RfD.a(paramInt1, this.RfH, this.Rfo[0], this.RfN, this.RfO);
          GLES20.glBindFramebuffer(36160, 0);
          continue;
        }
        AppMethodBeat.o(190245);
      }
      catch (IndexOutOfBoundsException paramFloatBuffer1)
      {
        AppMethodBeat.o(190245);
        return;
        if (i == -1)
        {
          GLES20.glGenTextures(1, paramFloatBuffer2, 0);
          GLES20.glBindTexture(3553, paramFloatBuffer2[0]);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
        }
        else
        {
          GLES20.glBindFramebuffer(36160, paramFloatBuffer1.RfU[0]);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
          GLES20.glCheckFramebufferStatus(36160);
          GLES20.glBindTexture(3553, i);
          GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, paramInt1, paramInt2);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          paramFloatBuffer2[0] = i;
        }
      }
      catch (Exception paramFloatBuffer1) {}
      return;
      paramInt1 = paramFloatBuffer2[0];
    }
  }
  
  public final void apH(int paramInt)
  {
    AppMethodBeat.i(190246);
    if (paramInt >= 5)
    {
      this.RfC.apI(1);
      this.RfD.apJ(1);
      AppMethodBeat.o(190246);
      return;
    }
    this.RfC.apI(0);
    this.RfD.apJ(0);
    AppMethodBeat.o(190246);
  }
  
  public final void apK(int paramInt)
  {
    AppMethodBeat.i(190249);
    if (!this.RfL)
    {
      this.rod = paramInt;
      hfe();
    }
    AppMethodBeat.o(190249);
  }
  
  public final void cH(float paramFloat)
  {
    AppMethodBeat.i(190247);
    this.RfC.cH(paramFloat);
    AppMethodBeat.o(190247);
  }
  
  public final void lS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190244);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(190244);
      return;
    }
    if ((this.outputWidth != paramInt1) || (this.outputHeight != paramInt2) || (this.RfM))
    {
      this.outputWidth = paramInt1;
      this.outputHeight = paramInt2;
      super.lS(this.outputWidth, this.outputHeight);
      if (this.Rfn != null) {
        hfb();
      }
      if (this.Rfo != null)
      {
        GLES20.glDeleteTextures(this.Rfo.length, this.Rfo, 0);
        this.Rfo = null;
      }
      c localc = this.RfJ;
      paramInt1 = this.outputWidth;
      paramInt2 = this.outputHeight;
      if (localc.Rfu != -1)
      {
        if (localc.Gxi != -1)
        {
          GLES20.glDeleteTextures(1, new int[] { localc.Gxi }, 0);
          localc.Gxi = -1;
        }
        if (localc.Rfu != -1)
        {
          GLES20.glDeleteFramebuffers(0, new int[] { localc.Rfu }, 0);
          localc.Rfu = -1;
        }
      }
      localc.lU(paramInt1, paramInt2);
      paramInt2 = this.aby.size();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        if ((paramInt1 >= paramInt2 - 1) && (this.RfL)) {
          ((a)this.aby.get(paramInt1)).lS(this.surfaceWidth, this.surfaceHeight);
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          ((a)this.aby.get(paramInt1)).lS(this.outputWidth, this.outputHeight);
        }
      }
      if ((this.Rfm != null) && (this.Rfm.size() > 0))
      {
        paramInt2 = this.Rfm.size();
        this.Rfn = new int[paramInt2 - 1];
        this.Rfo = new int[paramInt2 - 1];
        paramInt1 = 0;
        while (paramInt1 < paramInt2 - 1)
        {
          GLES20.glGenFramebuffers(1, this.Rfn, paramInt1);
          GLES20.glBindFramebuffer(36160, this.Rfn[paramInt1]);
          GLES20.glGenTextures(1, this.Rfo, paramInt1);
          GLES20.glBindTexture(3553, this.Rfo[paramInt1]);
          GLES20.glTexImage2D(3553, 0, 6408, this.outputWidth, this.outputHeight, 0, 6408, 5121, null);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.Rfo[paramInt1], 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindFramebuffer(36160, 0);
          paramInt1 += 1;
        }
        if (!this.RfL)
        {
          if (this.RfG == null) {
            this.RfG = new int[1];
          }
          GLES20.glGenFramebuffers(1, this.RfG, 0);
        }
        paramInt2 = this.outputWidth;
        int i = this.outputHeight;
        int j = this.Rfm.size();
        paramInt1 = 0;
        while (paramInt1 < j - 1)
        {
          if (this.Rfo[paramInt1] == RfI)
          {
            GLES20.glBindFramebuffer(36160, this.Rfn[paramInt1]);
            GLES20.glGenTextures(1, this.Rfo, paramInt1);
            GLES20.glBindTexture(3553, this.Rfo[paramInt1]);
            GLES20.glTexImage2D(3553, 0, 6408, paramInt2, i, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.Rfo[paramInt1], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
          }
          paramInt1 += 1;
        }
        if ((!this.RfL) && (this.RfG[0] == RfI)) {
          GLES20.glGenFramebuffers(1, this.RfG, 0);
        }
      }
    }
    AppMethodBeat.o(190244);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(190242);
    hfb();
    Object localObject = this.RfF;
    GLES20.glDeleteFramebuffers(((i)localObject).RfU.length, ((i)localObject).RfU, 0);
    localObject = this.aby.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).destroy();
    }
    super.onDestroy();
    this.outputHeight = 0;
    this.outputWidth = 0;
    AppMethodBeat.o(190242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cm.a.f
 * JD-Core Version:    0.7.0.1
 */