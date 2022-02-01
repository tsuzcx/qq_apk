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

public final class e
  extends a
{
  private static int YGD = -1;
  public ByteBuffer Ocj;
  private a YGA;
  private int[] YGB;
  private int YGC;
  public byte[] YGE;
  private boolean YGF;
  private boolean YGG;
  private FloatBuffer YGH;
  private FloatBuffer YGI;
  protected List<a> YGg;
  private int[] YGh;
  private int[] YGi;
  private final FloatBuffer YGl;
  private c YGx;
  private d YGy;
  private a YGz;
  protected List<a> afd;
  public int outputHeight;
  public int outputWidth;
  public int surfaceHeight;
  public int surfaceWidth;
  private int uTK;
  
  public e()
  {
    AppMethodBeat.i(188051);
    this.YGC = -1;
    this.outputWidth = 0;
    this.outputHeight = 0;
    this.YGF = false;
    this.YGG = false;
    this.afd = new ArrayList();
    this.YGH = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.YGH.put(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
    this.YGH.position(0);
    this.YGI = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.YGI.put(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
    this.YGI.position(0);
    float[] arrayOfFloat = k.a(i.YHb, true);
    this.YGl = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.YGl.put(arrayOfFloat).position(0);
    this.YGx = new c();
    this.YGy = new d();
    this.YGz = new a();
    this.YGF = false;
    this.afd.add(this.YGx);
    this.afd.add(this.YGy);
    this.afd.add(this.YGz);
    igw();
    AppMethodBeat.o(188051);
  }
  
  public static void d(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(188087);
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
    AppMethodBeat.o(188087);
  }
  
  private void igu()
  {
    AppMethodBeat.i(188061);
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
    if (this.YGB != null)
    {
      GLES20.glDeleteFramebuffers(this.YGB.length, this.YGB, 0);
      this.YGB = null;
    }
    AppMethodBeat.o(188061);
  }
  
  private void igw()
  {
    AppMethodBeat.i(188092);
    if (this.afd == null)
    {
      AppMethodBeat.o(188092);
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
        localObject = ((b)localObject).igv();
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
    AppMethodBeat.o(188092);
  }
  
  private void igx()
  {
    AppMethodBeat.i(188076);
    if (!this.YGF)
    {
      if (this.YGB != null)
      {
        GLES20.glDeleteFramebuffers(this.YGB.length, this.YGB, 0);
        this.YGB = null;
      }
      if (this.YGB == null)
      {
        this.YGB = new int[1];
        GLES20.glGenFramebuffers(1, this.YGB, 0);
      }
      GLES20.glBindFramebuffer(36160, this.YGB[0]);
      GLES20.glBindTexture(3553, this.uTK);
      GLES20.glTexImage2D(3553, 0, 6408, this.outputWidth, this.outputHeight, 0, 6408, 5121, null);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.uTK, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
    }
    AppMethodBeat.o(188076);
  }
  
  private static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = paramArrayOfFloat[paramInt1];
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
    paramArrayOfFloat[paramInt2] = f;
  }
  
  public final void Ia(boolean paramBoolean)
  {
    AppMethodBeat.i(188080);
    this.YGF = paramBoolean;
    if (this.YGA == null)
    {
      this.YGA = new a();
      this.afd.add(this.YGA);
      this.YGG = true;
      igw();
      this.YGA.init();
      nj(this.outputWidth, this.outputHeight);
    }
    this.YGG = false;
    AppMethodBeat.o(188080);
  }
  
  public final void Pu()
  {
    AppMethodBeat.i(188053);
    super.Pu();
    Iterator localIterator = this.afd.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).init();
    }
    AppMethodBeat.o(188053);
  }
  
  @SuppressLint({"WrongCall"})
  public final void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(188070);
    igs();
    if ((!isInitialized()) || (this.YGh == null) || (this.YGi == null))
    {
      AppMethodBeat.o(188070);
      return;
    }
    if (this.YGg != null) {
      try
      {
        GLES20.glBindFramebuffer(36160, this.YGh[0]);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        this.YGx.a(paramInt1, this.YGi[1], paramInt1, this.YGH, this.YGI);
        GLES20.glBindFramebuffer(36160, 0);
        if (this.YGF)
        {
          GLES20.glBindFramebuffer(36160, this.YGh[1]);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          this.YGy.a(paramInt1, this.YGi[1], this.YGi[0], this.YGH, this.YGl);
          if ((this.Ocj == null) || (this.Ocj.capacity() < this.outputHeight * this.outputWidth * 4)) {
            this.Ocj = ByteBuffer.allocateDirect(this.outputHeight * this.outputWidth * 4).order(ByteOrder.nativeOrder());
          }
          this.Ocj.position(0);
          GLES20.glReadPixels(0, 0, this.outputWidth, this.outputHeight, 6408, 5121, this.Ocj);
          this.Ocj.position(0);
          this.YGE = this.Ocj.array();
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindFramebuffer(36160, 0);
          this.YGA.a(this.YGi[1], paramInt1, paramInt1, paramFloatBuffer1, paramFloatBuffer2);
        }
        for (;;)
        {
          GLES20.glBindFramebuffer(36160, this.YGh[1]);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          this.YGz.a(this.uTK, this.uTK, this.uTK, this.YGH, this.YGI);
          GLES20.glBindFramebuffer(36160, 0);
          AppMethodBeat.o(188070);
          return;
          GLES20.glBindFramebuffer(36160, this.YGB[0]);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          this.YGy.a(paramInt1, this.YGi[1], this.YGi[0], this.YGH, this.YGI);
          GLES20.glBindFramebuffer(36160, 0);
        }
        AppMethodBeat.o(188070);
      }
      catch (IndexOutOfBoundsException paramFloatBuffer1)
      {
        AppMethodBeat.o(188070);
        return;
      }
      catch (Exception paramFloatBuffer1) {}
    }
  }
  
  public final void azg(int paramInt)
  {
    AppMethodBeat.i(188071);
    if (paramInt >= 4)
    {
      this.YGx.azh(1);
      this.YGy.azi(1);
      AppMethodBeat.o(188071);
      return;
    }
    this.YGx.azh(0);
    this.YGy.azi(0);
    AppMethodBeat.o(188071);
  }
  
  public final void azj(int paramInt)
  {
    AppMethodBeat.i(188078);
    if (!this.YGF)
    {
      this.uTK = paramInt;
      igx();
    }
    AppMethodBeat.o(188078);
  }
  
  public final void dc(float paramFloat)
  {
    AppMethodBeat.i(188074);
    this.YGx.dc(paramFloat);
    AppMethodBeat.o(188074);
  }
  
  public final void nj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188065);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(188065);
      return;
    }
    if ((this.outputWidth != paramInt1) || (this.outputHeight != paramInt2) || (this.YGG))
    {
      this.outputWidth = paramInt1;
      this.outputHeight = paramInt2;
      this.YGx.nl(this.outputWidth, this.outputHeight);
      super.nj(this.outputWidth, this.outputHeight);
      if (this.YGh != null) {
        igu();
      }
      if (this.YGi != null)
      {
        GLES20.glDeleteTextures(this.YGi.length, this.YGi, 0);
        this.YGi = null;
      }
      paramInt2 = this.afd.size();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        if ((paramInt1 >= paramInt2 - 1) && (this.YGF)) {
          ((a)this.afd.get(paramInt1)).nj(this.surfaceWidth, this.surfaceHeight);
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          ((a)this.afd.get(paramInt1)).nj(this.outputWidth, this.outputHeight);
        }
      }
      if ((this.YGg != null) && (this.YGg.size() > 0))
      {
        paramInt2 = this.YGg.size();
        this.YGh = new int[paramInt2 - 1];
        this.YGi = new int[paramInt2 - 1];
        paramInt1 = 0;
        while (paramInt1 < paramInt2 - 1)
        {
          GLES20.glGenFramebuffers(1, this.YGh, paramInt1);
          GLES20.glBindFramebuffer(36160, this.YGh[paramInt1]);
          GLES20.glGenTextures(1, this.YGi, paramInt1);
          GLES20.glBindTexture(3553, this.YGi[paramInt1]);
          GLES20.glTexImage2D(3553, 0, 6408, this.outputWidth, this.outputHeight, 0, 6408, 5121, null);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.YGi[paramInt1], 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindFramebuffer(36160, 0);
          paramInt1 += 1;
        }
        if (!this.YGF) {
          igx();
        }
        paramInt2 = this.outputWidth;
        int i = this.outputHeight;
        int j = this.YGg.size();
        paramInt1 = 0;
        while (paramInt1 < j - 1)
        {
          if (this.YGi[paramInt1] == YGD)
          {
            GLES20.glBindFramebuffer(36160, this.YGh[paramInt1]);
            GLES20.glGenTextures(1, this.YGi, paramInt1);
            GLES20.glBindTexture(3553, this.YGi[paramInt1]);
            GLES20.glTexImage2D(3553, 0, 6408, paramInt2, i, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.YGi[paramInt1], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
          }
          paramInt1 += 1;
        }
        if ((!this.YGF) && (this.YGB[0] == YGD)) {
          igx();
        }
      }
    }
    AppMethodBeat.o(188065);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(188058);
    igu();
    Iterator localIterator = this.afd.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).destroy();
    }
    super.onDestroy();
    this.outputHeight = 0;
    this.outputWidth = 0;
    AppMethodBeat.o(188058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ct.a.e
 * JD-Core Version:    0.7.0.1
 */