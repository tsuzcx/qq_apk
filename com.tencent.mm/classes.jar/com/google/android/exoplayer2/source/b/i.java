package com.google.android.exoplayer2.source.b;

import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.b;
import com.google.android.exoplayer2.b.b.a;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.k.a;
import com.google.android.exoplayer2.h.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.a.a.5;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.g.a;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.h.a;
import java.nio.ByteBuffer;
import java.util.LinkedList;

final class i
  implements com.google.android.exoplayer2.source.i
{
  private final j aKp;
  public final int group;
  
  public i(j paramj, int paramInt)
  {
    this.aKp = paramj;
    this.group = paramInt;
  }
  
  public final void K(long paramLong)
  {
    j localj = this.aKp;
    int i = this.group;
    h localh = localj.aKx[i];
    if ((localj.aKL) && (paramLong > localh.aIE.mJ()))
    {
      localh.aIE.mK();
      return;
    }
    localh.e(paramLong, true);
  }
  
  public final int b(k paramk, e parame, boolean paramBoolean)
  {
    Object localObject1 = this.aKp;
    int k = this.group;
    if (((j)localObject1).nf()) {
      return -3;
    }
    int m;
    int i;
    label65:
    Object localObject2;
    int j;
    label130:
    label167:
    label182:
    Object localObject4;
    Object localObject5;
    if (!((j)localObject1).aKv.isEmpty())
    {
      if (((j)localObject1).aKv.size() > 1)
      {
        m = ((f)((j)localObject1).aKv.getFirst()).uid;
        i = 0;
        if (i < ((j)localObject1).aKx.length) {
          if (localObject1.aKF[i] != 0)
          {
            localObject2 = localObject1.aKx[i].aIE;
            j = ((g)localObject2).dj(((g)localObject2).aIv);
            if (((g)localObject2).mH())
            {
              j = localObject2.aIp[j];
              if (j != m) {
                break label167;
              }
            }
          }
        }
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label182;
          }
          ((j)localObject1).aKv.removeFirst();
          break;
          j = ((g)localObject2).aIB;
          break label130;
          i += 1;
          break label65;
        }
      }
      localObject2 = (f)((j)localObject1).aKv.getFirst();
      localObject3 = ((f)localObject2).aJb;
      if (!((Format)localObject3).equals(((j)localObject1).aKB))
      {
        localObject4 = ((j)localObject1).aKf;
        i = ((j)localObject1).asG;
        j = ((f)localObject2).aJc;
        localObject5 = ((f)localObject2).aJd;
        l1 = ((f)localObject2).aJe;
        if (((a.a)localObject4).aHM != null) {
          ((a.a)localObject4).handler.post(new a.a.5((a.a)localObject4, i, (Format)localObject3, j, localObject5, l1));
        }
      }
      ((j)localObject1).aKB = ((Format)localObject3);
    }
    Object localObject3 = localObject1.aKx[k];
    boolean bool = ((j)localObject1).aKL;
    long l1 = ((j)localObject1).aKH;
    switch (((h)localObject3).aIE.a(paramk, parame, paramBoolean, bool, ((h)localObject3).aIJ, ((h)localObject3).aIF))
    {
    default: 
      throw new IllegalStateException();
    case -5: 
      ((h)localObject3).aIJ = paramk.auL;
      return -5;
    case -4: 
      if (!parame.lz())
      {
        if (parame.ayE < l1) {
          parame.cG(-2147483648);
        }
        long l2;
        if (parame.lE())
        {
          localObject4 = ((h)localObject3).aIF;
          l1 = ((g.a)localObject4).pj;
          ((h)localObject3).azv.reset(1);
          ((h)localObject3).a(l1, ((h)localObject3).azv.data, 1);
          l1 = 1L + l1;
          i = localObject3.azv.data[0];
          if ((i & 0x80) != 0)
          {
            j = 1;
            i &= 0x7F;
            if (parame.ayC.iv == null) {
              parame.ayC.iv = new byte[16];
            }
            ((h)localObject3).a(l1, parame.ayC.iv, i);
            l1 += i;
            if (j == 0) {
              break label759;
            }
            ((h)localObject3).azv.reset(2);
            ((h)localObject3).a(l1, ((h)localObject3).azv.data, 2);
            l1 += 2L;
          }
          label759:
          for (i = ((h)localObject3).azv.readUnsignedShort();; i = 1)
          {
            localObject1 = parame.ayC.numBytesOfClearData;
            if (localObject1 != null)
            {
              paramk = (k)localObject1;
              if (localObject1.length >= i) {}
            }
            else
            {
              paramk = new int[i];
            }
            localObject2 = parame.ayC.numBytesOfEncryptedData;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (localObject2.length >= i) {}
            }
            else
            {
              localObject1 = new int[i];
            }
            if (j == 0) {
              break label765;
            }
            j = i * 6;
            ((h)localObject3).azv.reset(j);
            ((h)localObject3).a(l1, ((h)localObject3).azv.data, j);
            l2 = l1 + j;
            ((h)localObject3).azv.setPosition(0);
            j = 0;
            for (;;)
            {
              l1 = l2;
              if (j >= i) {
                break;
              }
              paramk[j] = ((h)localObject3).azv.readUnsignedShort();
              localObject1[j] = ((h)localObject3).azv.oh();
              j += 1;
            }
            j = 0;
            break;
          }
          label765:
          paramk[0] = 0;
          localObject1[0] = (((g.a)localObject4).size - (int)(l1 - ((g.a)localObject4).pj));
          localObject5 = ((g.a)localObject4).aCH;
          localObject2 = parame.ayC;
          byte[] arrayOfByte1 = ((k.a)localObject5).azp;
          byte[] arrayOfByte2 = parame.ayC.iv;
          j = ((k.a)localObject5).azo;
          k = ((k.a)localObject5).ayq;
          m = ((k.a)localObject5).ayr;
          ((b)localObject2).numSubSamples = i;
          ((b)localObject2).numBytesOfClearData = paramk;
          ((b)localObject2).numBytesOfEncryptedData = ((int[])localObject1);
          ((b)localObject2).key = arrayOfByte1;
          ((b)localObject2).iv = arrayOfByte2;
          ((b)localObject2).mode = j;
          ((b)localObject2).ayq = k;
          ((b)localObject2).ayr = m;
          if (t.SDK_INT >= 16)
          {
            ((b)localObject2).ays.numSubSamples = ((b)localObject2).numSubSamples;
            ((b)localObject2).ays.numBytesOfClearData = ((b)localObject2).numBytesOfClearData;
            ((b)localObject2).ays.numBytesOfEncryptedData = ((b)localObject2).numBytesOfEncryptedData;
            ((b)localObject2).ays.key = ((b)localObject2).key;
            ((b)localObject2).ays.iv = ((b)localObject2).iv;
            ((b)localObject2).ays.mode = ((b)localObject2).mode;
            if (t.SDK_INT >= 24)
            {
              paramk = ((b)localObject2).ayt;
              i = ((b)localObject2).ayq;
              j = ((b)localObject2).ayr;
              paramk.ayu.set(i, j);
              paramk.ays.setPattern(paramk.ayu);
            }
          }
          i = (int)(l1 - ((g.a)localObject4).pj);
          ((g.a)localObject4).pj += i;
          ((g.a)localObject4).size -= i;
        }
        parame.cI(((h)localObject3).aIF.size);
        l1 = ((h)localObject3).aIF.pj;
        paramk = parame.ayD;
        i = ((h)localObject3).aIF.size;
        ((h)localObject3).N(l1);
        while (i > 0)
        {
          k = Math.min(i, (int)(((h)localObject3).aIH.aBz - l1));
          paramk.put(((h)localObject3).aIH.aIR.data, ((h)localObject3).aIH.P(l1), k);
          j = i - k;
          l2 = l1 + k;
          l1 = l2;
          i = j;
          if (l2 == ((h)localObject3).aIH.aBz)
          {
            ((h)localObject3).aIH = ((h)localObject3).aIH.aIS;
            l1 = l2;
            i = j;
          }
        }
      }
      return -4;
    }
    return -3;
  }
  
  public final boolean isReady()
  {
    j localj = this.aKp;
    int i = this.group;
    return (localj.aKL) || ((!localj.nf()) && (localj.aKx[i].aIE.mH()));
  }
  
  public final void mD()
  {
    this.aKp.mD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.i
 * JD-Core Version:    0.7.0.1
 */