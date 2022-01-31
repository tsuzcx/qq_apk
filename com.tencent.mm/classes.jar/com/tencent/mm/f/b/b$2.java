package com.tencent.mm.f.b;

import android.os.Looper;
import com.tencent.mm.be.d;
import com.tencent.mm.be.d.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.BlockingQueue;

final class b$2
  implements c.a
{
  b$2(b paramb) {}
  
  private static byte[] s(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramInt % 4;
    int i = paramInt;
    if (j != 0) {
      i = paramInt - j;
    }
    if (i <= 0) {
      return null;
    }
    byte[] arrayOfByte = new byte[i / 2];
    paramInt = 0;
    while (paramInt < i / 2)
    {
      arrayOfByte[paramInt] = paramArrayOfByte[(paramInt * 2)];
      arrayOfByte[(paramInt + 1)] = paramArrayOfByte[(paramInt * 2 + 1)];
      paramInt += 2;
    }
    return arrayOfByte;
  }
  
  private void t(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    while (i < paramInt / 2)
    {
      int j = (short)(paramArrayOfByte[(i * 2)] & 0xFF | paramArrayOfByte[(i * 2 + 1)] << 8);
      if (j > b.u(this.bCl)) {
        b.b(this.bCl, j);
      }
      i += 1;
    }
  }
  
  public final void aU(int paramInt1, int paramInt2) {}
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    int j = -1;
    boolean bool1 = false;
    boolean bool2 = false;
    y.i("MicroMsg.MMAudioRecorder", "onRecPcmDataReady, markStop: %s", new Object[] { Boolean.valueOf(b.c(this.bCl)) });
    if ((b.d(this.bCl) == b.b.bCr) && (!b.c(this.bCl)))
    {
      y.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
      return;
    }
    synchronized (b.uo())
    {
      if (b.c(this.bCl))
      {
        if (b.e(this.bCl) != null)
        {
          y.i("MicroMsg.MMAudioRecorder", "do stop pcm recorder, last frame data: %s, read: %s", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt) });
          b.e(this.bCl).uh();
          b.e(this.bCl).bCP = null;
          b.f(this.bCl);
          bool1 = true;
          b.g(this.bCl);
        }
      }
      else
      {
        long l = bk.co(b.h(this.bCl));
        if ((b.i(this.bCl) <= 0L) || (l <= b.i(this.bCl))) {
          break label260;
        }
        y.w("MicroMsg.MMAudioRecorder", "Stop now ! expire duration ms:" + l);
        new ah(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            b.2.this.bCl.un();
            if (b.a(b.2.this.bCl) != null) {
              b.a(b.2.this.bCl).onError();
            }
          }
        });
        return;
      }
      y.i("MicroMsg.MMAudioRecorder", "stop now, but recorder is null");
      bool1 = bool2;
    }
    label260:
    y.d("MicroMsg.MMAudioRecorder", "read :" + paramInt + " time: " + b.j(this.bCl).zJ() + " dataReadedCnt: " + b.k(this.bCl));
    if (paramInt < 0)
    {
      if (b.d(this.bCl) == b.b.bCr)
      {
        y.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
        return;
      }
      new ah(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          b.2.this.bCl.un();
          if (b.a(b.2.this.bCl) != null) {
            b.a(b.2.this.bCl).onError();
          }
        }
      });
      return;
    }
    b.a(this.bCl, b.k(this.bCl) + paramInt);
    for (;;)
    {
      Object localObject2;
      synchronized (b.l(this.bCl))
      {
        if ((b.m(this.bCl) == null) && ((b.n(this.bCl) == com.tencent.mm.compatible.b.b.a.dua) || (b.n(this.bCl) == com.tencent.mm.compatible.b.b.a.duc)) && (b.o(this.bCl) != null) && (b.p(this.bCl)))
        {
          b.a(this.bCl, new com.tencent.mm.be.c());
          localObject2 = b.m(this.bCl);
          i = b.q(this.bCl);
          y.i("MicroMsg.SpeexEncoderWorker", "init ");
          ((com.tencent.mm.be.c)localObject2).eBd.clear();
          d.b localb = new d.b();
          localb.eyz = d.getPrefix();
          localb.sampleRate = i;
          localb.eAY = 1;
          localb.eAZ = 16;
          ((com.tencent.mm.be.c)localObject2).mFileName = String.format("%s%d_%d_%d_%d", new Object[] { localb.eyz, Integer.valueOf(localb.sampleRate), Integer.valueOf(localb.eAY), Integer.valueOf(localb.eAZ), Long.valueOf(System.currentTimeMillis()) });
        }
        if (b.m(this.bCl) != null)
        {
          localObject2 = b.m(this.bCl);
          y.d("MicroMsg.SpeexEncoderWorker", "push into queue queueLen:" + ((com.tencent.mm.be.c)localObject2).eBd.size());
          if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
            ((com.tencent.mm.be.c)localObject2).eBd.add(new g.a(paramArrayOfByte, paramArrayOfByte.length));
          }
        }
        if (b.n(this.bCl) != com.tencent.mm.compatible.b.b.a.duc) {
          break;
        }
        if (b.r(this.bCl) == null)
        {
          b.a(this.bCl, new com.tencent.mm.f.c.c(b.q(this.bCl), b.s(this.bCl)));
          b.r(this.bCl).cG(b.t(this.bCl));
        }
        t(paramArrayOfByte, paramInt);
        localObject2 = b.r(this.bCl);
        if (((com.tencent.mm.f.c.c)localObject2).bEq == null)
        {
          i = -1;
          if (paramArrayOfByte != null) {
            break label870;
          }
          label776:
          y.d("MicroMsg.SilkWriter", "pushBuf queueLen:%d bufLen:%d len:%d, lastFrame: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Boolean.valueOf(bool1) });
          if (paramInt <= 0) {}
        }
      }
      try
      {
        if (((com.tencent.mm.f.c.c)localObject2).bEr) {
          y.e("MicroMsg.SilkWriter", "already stop");
        }
        for (;;)
        {
          return;
          paramArrayOfByte = finally;
          throw paramArrayOfByte;
          i = ((com.tencent.mm.f.c.c)localObject2).bEq.size();
          break;
          label870:
          j = paramArrayOfByte.length;
          break label776;
          if (((com.tencent.mm.f.c.c)localObject2).bEx == null)
          {
            ((com.tencent.mm.f.c.c)localObject2).bEx = new com.tencent.mm.f.c.c.a((com.tencent.mm.f.c.c)localObject2, (byte)0);
            e.post(((com.tencent.mm.f.c.c)localObject2).bEx, "SilkWriter_run");
          }
          if (((com.tencent.mm.f.c.c)localObject2).bEq != null) {
            ((com.tencent.mm.f.c.c)localObject2).bEq.add(new g.a(paramArrayOfByte, paramInt, bool1));
          }
        }
      }
      finally {}
    }
    ??? = paramArrayOfByte;
    int i = paramInt;
    if (b.q(this.bCl) == 16000)
    {
      ??? = s(paramArrayOfByte, paramInt);
      i = ???.length;
    }
    t((byte[])???, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.b.2
 * JD-Core Version:    0.7.0.1
 */