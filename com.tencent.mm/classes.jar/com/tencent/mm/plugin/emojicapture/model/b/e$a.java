package com.tencent.mm.plugin.emojicapture.model.b;

import a.d.a.a;
import a.d.b.g;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

final class e$a
  implements Runnable
{
  e$a(e parame) {}
  
  public final void run()
  {
    Object localObject1 = this.jlc;
    y.i(((e)localObject1).TAG, "startDecode");
    ((e)localObject1).eIP.seekTo(0L, 2);
    Object localObject2 = ((e)localObject1).eIT;
    if (localObject2 == null) {
      g.ahh("decoder");
    }
    int j = ((MediaCodec)localObject2).dequeueInputBuffer(((e)localObject1).jkW);
    int i = 0;
    while ((j < 0) && (i < ((e)localObject1).jkY))
    {
      if (!((e)localObject1).ST()) {
        break label176;
      }
      localObject2 = ((e)localObject1).eIT;
      if (localObject2 == null) {
        g.ahh("decoder");
      }
      j = ((MediaCodec)localObject2).dequeueInputBuffer(((e)localObject1).jkW);
      i += 1;
    }
    int m;
    if (j >= 0)
    {
      localObject2 = ((e)localObject1).eIT;
      if (localObject2 == null) {
        g.ahh("decoder");
      }
      localObject2 = localObject2.getInputBuffers()[j];
      ((ByteBuffer)localObject2).clear();
      m = ((e)localObject1).eIP.readSampleData((ByteBuffer)localObject2, 0);
      if (m < 0) {
        y.i(((e)localObject1).TAG, "read sample end");
      }
    }
    label176:
    label178:
    label569:
    for (;;)
    {
      i = 0;
      label324:
      int k;
      if (i == 0)
      {
        y.i(((e)localObject1).TAG, "input end");
        y.i(((e)localObject1).TAG, "sendDecoderEos");
        localObject2 = ((e)localObject1).eIT;
        if (localObject2 == null) {
          g.ahh("decoder");
        }
        j = ((MediaCodec)localObject2).dequeueInputBuffer(((e)localObject1).jkW);
        i = 0;
        for (;;)
        {
          if ((j < 0) && (i < ((e)localObject1).jkY))
          {
            if (!((e)localObject1).ST()) {
              break label481;
            }
            localObject2 = ((e)localObject1).eIT;
            if (localObject2 == null) {
              g.ahh("decoder");
            }
            j = ((MediaCodec)localObject2).dequeueInputBuffer(((e)localObject1).jkW);
            i += 1;
            continue;
            ((ByteBuffer)localObject2).position(0);
            long l = ((e)localObject1).eIP.getSampleTime();
            if (l >= 0L) {
              break label561;
            }
            y.i(((e)localObject1).TAG, "read sample end, saw eos");
            i = 1;
            localObject2 = ((e)localObject1).eIT;
            if (localObject2 == null) {
              g.ahh("decoder");
            }
            if (i != 0)
            {
              k = 4;
              label347:
              ((MediaCodec)localObject2).queueInputBuffer(j, 0, m, l, k);
            }
          }
        }
      }
      for (;;)
      {
        if ((((e)localObject1).ST()) || (i != 0)) {
          break label569;
        }
        i = 1;
        break label178;
        k = 0;
        break label347;
        ((e)localObject1).eIP.advance();
        break;
        if (j >= 0)
        {
          localObject2 = ((e)localObject1).eIT;
          if (localObject2 == null) {
            g.ahh("decoder");
          }
          localObject2 = localObject2.getInputBuffers()[j];
          ((ByteBuffer)localObject2).clear();
          ((e)localObject1).eIP.readSampleData((ByteBuffer)localObject2, 0);
          ((ByteBuffer)localObject2).position(0);
          localObject2 = ((e)localObject1).eIT;
          if (localObject2 == null) {
            g.ahh("decoder");
          }
          ((MediaCodec)localObject2).queueInputBuffer(j, 0, 0, 0L, 4);
        }
        ((e)localObject1).ST();
        label481:
        y.i(((e)localObject1).TAG, "release");
        try
        {
          localObject2 = ((e)localObject1).eIT;
          if (localObject2 == null) {
            g.ahh("decoder");
          }
          ((MediaCodec)localObject2).stop();
          localObject2 = ((e)localObject1).eIT;
          if (localObject2 == null) {
            g.ahh("decoder");
          }
          ((MediaCodec)localObject2).release();
        }
        catch (Exception localException)
        {
          break label535;
        }
        localObject1 = ((e)localObject1).jla;
        if (localObject1 != null) {
          ((a)localObject1).invoke();
        }
        return;
        i = 0;
        break label324;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.e.a
 * JD-Core Version:    0.7.0.1
 */