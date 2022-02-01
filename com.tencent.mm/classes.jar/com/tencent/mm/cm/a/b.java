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

public final class b
  extends a
{
  static final float[] Rfs = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] Rft = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  protected List<a> Rfm;
  private int[] Rfn;
  private int[] Rfo;
  private final FloatBuffer Rfp;
  private final FloatBuffer Rfq;
  private final FloatBuffer Rfr;
  protected List<a> aby;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    AppMethodBeat.i(190227);
    this.aby = null;
    if (this.aby == null) {
      this.aby = new ArrayList();
    }
    for (;;)
    {
      this.Rfp = ByteBuffer.allocateDirect(Rfs.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.Rfp.put(Rfs).position(0);
      this.Rfq = ByteBuffer.allocateDirect(Rft.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.Rfq.put(Rft).position(0);
      float[] arrayOfFloat = l.a(j.Rgh, true);
      this.Rfr = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.Rfr.put(arrayOfFloat).position(0);
      AppMethodBeat.o(190227);
      return;
      hfd();
    }
  }
  
  private void hfb()
  {
    AppMethodBeat.i(190230);
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
    AppMethodBeat.o(190230);
  }
  
  public final void MC()
  {
    AppMethodBeat.i(190228);
    super.MC();
    Iterator localIterator = this.aby.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).init();
    }
    AppMethodBeat.o(190228);
  }
  
  @SuppressLint({"WrongCall"})
  public final void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(190232);
    heZ();
    if ((!this.Rfh) || (this.Rfn == null) || (this.Rfo == null))
    {
      AppMethodBeat.o(190232);
      return;
    }
    if (this.Rfm != null)
    {
      int j = this.Rfm.size();
      paramInt2 = 0;
      paramInt3 = paramInt1;
      if (paramInt2 < j)
      {
        a locala = (a)this.Rfm.get(paramInt2);
        int i;
        if (paramInt2 < j - 1)
        {
          i = 1;
          label90:
          if (i != 0)
          {
            GLES20.glBindFramebuffer(36160, this.Rfn[paramInt2]);
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
            paramInt3 = this.Rfo[paramInt2];
          }
          paramInt2 += 1;
          break;
          i = 0;
          break label90;
          label160:
          if (paramInt2 == j - 1)
          {
            FloatBuffer localFloatBuffer2 = this.Rfp;
            if (j % 2 == 0) {}
            for (FloatBuffer localFloatBuffer1 = this.Rfr;; localFloatBuffer1 = this.Rfq)
            {
              locala.a(paramInt3, paramInt1, paramInt1, localFloatBuffer2, localFloatBuffer1);
              break;
            }
          }
          locala.a(paramInt3, paramInt1, paramInt1, this.Rfp, this.Rfq);
        }
      }
    }
    AppMethodBeat.o(190232);
  }
  
  public final List<a> hfc()
  {
    return this.Rfm;
  }
  
  public final void hfd()
  {
    AppMethodBeat.i(190233);
    if (this.aby == null)
    {
      AppMethodBeat.o(190233);
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
        localObject = ((b)localObject).Rfm;
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
    AppMethodBeat.o(190233);
  }
  
  public final void lS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190231);
    super.lS(paramInt1, paramInt2);
    if (this.Rfn != null) {
      hfb();
    }
    int j = this.aby.size();
    int i = 0;
    while (i < j)
    {
      ((a)this.aby.get(i)).lS(paramInt1, paramInt2);
      i += 1;
    }
    if ((this.Rfm != null) && (this.Rfm.size() > 0))
    {
      j = this.Rfm.size();
      this.Rfn = new int[j - 1];
      this.Rfo = new int[j - 1];
      i = 0;
      while (i < j - 1)
      {
        GLES20.glGenFramebuffers(1, this.Rfn, i);
        GLES20.glGenTextures(1, this.Rfo, i);
        GLES20.glBindTexture(3553, this.Rfo[i]);
        GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.Rfn[i]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.Rfo[i], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        i += 1;
      }
    }
    AppMethodBeat.o(190231);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(190229);
    hfb();
    Iterator localIterator = this.aby.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).destroy();
    }
    super.onDestroy();
    AppMethodBeat.o(190229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cm.a.b
 * JD-Core Version:    0.7.0.1
 */