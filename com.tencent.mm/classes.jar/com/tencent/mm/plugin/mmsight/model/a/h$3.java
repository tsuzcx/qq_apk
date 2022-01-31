package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaCodec;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

final class h$3
  implements c.a
{
  h$3(h paramh) {}
  
  public final void aU(int paramInt1, int paramInt2)
  {
    y.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final void r(byte[] arg1, int paramInt)
  {
    paramInt = 0;
    this.mje.miV.sendEmptyMessage(0);
    if (!this.mje.miR) {
      paramInt = 1;
    }
    if (paramInt == 0) {
      this.mje.gNN += 128;
    }
    boolean bool = this.mje.miW;
    h localh;
    if (paramInt == 0)
    {
      localh = this.mje;
      if (0L == localh.miM) {
        localh.miM = System.nanoTime();
      }
      if ((localh.miU != null) && (localh.miU.mkp <= 0L)) {
        localh.miU.mkp = System.nanoTime();
      }
      if (localh.eIF != null)
      {
        if (localh.eIF != null) {
          break label274;
        }
        y.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + bool);
      }
    }
    for (;;)
    {
      localh.drainEncoder(bool);
      if ((bool) && (!this.mje.mja)) {}
      synchronized (this.mje.miY)
      {
        if (this.mje.miZ != null)
        {
          y.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
          this.mje.miZ.bjk();
          this.mje.miZ = null;
          this.mje.miX = true;
          this.mje.mja = true;
          this.mje.mjb.removeCallbacks(this.mje.mjc);
          this.mje.mjb.post(this.mje.mjc);
          return;
          try
          {
            label274:
            localObject2 = localh.eIF.getInputBuffers();
            paramInt = localh.eIF.dequeueInputBuffer(100L);
            localh.miN = paramInt;
            if (paramInt < 0)
            {
              y.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
              localh.drainEncoder(false);
            }
            if (localh.eIF != null) {
              break label379;
            }
            y.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + bool);
          }
          catch (Throwable ???)
          {
            y.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + ???.getMessage());
          }
          continue;
          label379:
          if (localh.miN < 0) {
            continue;
          }
          Object localObject2 = localObject2[localh.miN];
          ((ByteBuffer)localObject2).clear();
          ((ByteBuffer)localObject2).put(???);
          ((ByteBuffer)localObject2).position(0);
          localh.miO = ???.length;
          localh.miP = System.nanoTime();
          localh.miP -= localh.miO / localh.audioSampleRate / 1000000000;
          if (localh.miO == -3) {
            y.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
          }
          long l2 = localh.miP;
          if (localh.miU != null) {}
          for (long l1 = localh.miU.mkp;; l1 = localh.miM)
          {
            localh.miQ = ((l2 - l1) / 1000L);
            y.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + localh.miO + " audio bytes with pts " + localh.miQ + ", end:" + bool + ", enqueue:" + localh.miN);
            if (!bool) {
              break label623;
            }
            y.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
            localh.eIF.queueInputBuffer(localh.miN, 0, localh.miO, localh.miQ, 4);
            break;
          }
          label623:
          localh.eIF.queueInputBuffer(localh.miN, 0, localh.miO, localh.miQ, 0);
          continue;
        }
        y.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h.3
 * JD-Core Version:    0.7.0.1
 */