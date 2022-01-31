package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.nio.ByteBuffer;

final class h$3
  implements c.a
{
  h$3(h paramh) {}
  
  public final void bS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76576);
    ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(76576);
  }
  
  public final void s(byte[] arg1, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(76575);
    this.oJl.oJc.sendEmptyMessage(0);
    if (!this.oJl.oIW) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        this.oJl.ipz += 128;
      }
      boolean bool = this.oJl.oJd;
      h localh;
      if (paramInt == 0)
      {
        localh = this.oJl;
        if (!localh.oJb) {
          break label209;
        }
        if (!localh.eUA) {
          break label247;
        }
      }
      for (;;)
      {
        if ((bool) && (!this.oJl.oJh)) {}
        synchronized (this.oJl.oJf)
        {
          if (this.oJl.oJg != null)
          {
            ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
            this.oJl.oJg.XE();
            this.oJl.oJg = null;
            this.oJl.oJe = true;
            this.oJl.oJh = true;
            this.oJl.oJi.removeCallbacks(this.oJl.oJj);
            this.oJl.oJi.post(this.oJl.oJj);
            AppMethodBeat.o(76575);
            return;
            label209:
            synchronized (localh.eUB)
            {
              if (!localh.eUA) {}
            }
            label247:
            if (0L == localh.oIR) {
              localh.oIR = System.nanoTime();
            }
            if ((localh.oIZ != null) && (localh.oIZ.oJF <= 0L)) {
              localh.oIZ.oJF = System.nanoTime();
            }
            if (localh.eUg != null)
            {
              if (localh.eUg == null) {
                ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
              }
              label721:
              for (;;)
              {
                localh.drainEncoder(bool);
                break;
                try
                {
                  ??? = localh.eUg.getInputBuffers();
                  paramInt = localh.eUg.dequeueInputBuffer(10000L);
                  localh.oIS = paramInt;
                  if (paramInt < 0)
                  {
                    ab.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                    paramInt = i;
                    while (paramInt < 5)
                    {
                      localh.drainEncoder(false);
                      localh.oIS = localh.eUg.dequeueInputBuffer(10000L);
                      if (localh.oIS >= 0) {
                        break;
                      }
                      paramInt += 1;
                    }
                  }
                  if (localh.eUg != null) {
                    break label475;
                  }
                  ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
                }
                catch (Throwable ???)
                {
                  ab.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + ???.getMessage());
                }
                continue;
                label475:
                if (localh.oIS >= 0)
                {
                  ??? = ???[localh.oIS];
                  ((ByteBuffer)???).clear();
                  ((ByteBuffer)???).put(???);
                  ((ByteBuffer)???).position(0);
                  localh.oIT = ???.length;
                  localh.oIU = System.nanoTime();
                  localh.oIU -= localh.oIT / localh.audioSampleRate / 1000000000;
                  if (localh.oIT == -3) {
                    ab.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                  }
                  long l2 = localh.oIU;
                  if (localh.oIZ != null) {}
                  for (long l1 = localh.oIZ.oJF;; l1 = localh.oIR)
                  {
                    localh.oIV = ((l2 - l1) / 1000L);
                    ab.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + localh.oIT + " audio bytes with pts " + localh.oIV + ", end:" + bool + ", enqueue:" + localh.oIS);
                    if (!bool) {
                      break label721;
                    }
                    ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                    localh.eUg.queueInputBuffer(localh.oIS, 0, localh.oIT, localh.oIV, 4);
                    break;
                  }
                  localh.eUg.queueInputBuffer(localh.oIS, 0, localh.oIT, localh.oIV, 0);
                }
              }
            }
          }
          else
          {
            ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h.3
 * JD-Core Version:    0.7.0.1
 */