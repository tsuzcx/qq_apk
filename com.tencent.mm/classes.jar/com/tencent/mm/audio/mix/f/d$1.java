package com.tencent.mm.audio.mix.f;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.a;
import com.tencent.mm.audio.mix.e.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(137168);
    Process.setThreadPriority(-19);
    if (this.chN.chn.get())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "stop and exit");
      AppMethodBeat.o(137168);
      return;
    }
    if (this.chN.ayN == null) {
      d.a(this.chN);
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "playback start");
    do
    {
      if (!this.chN.chn.get())
      {
        d locald1 = this.chN;
        synchronized (locald1.chp)
        {
          for (;;)
          {
            if ((locald1.chm.get()) && (!locald1.chn.get()))
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "waitPlay");
              try
              {
                locald1.chp.wait();
              }
              catch (Exception localException)
              {
                com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "waitPlay", new Object[0]);
              }
            }
          }
        }
        if (this.chN.chn.get()) {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "playback break");
        }
      }
      else
      {
        this.chN.Ej();
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "release AudioTrack and exit playback thread id:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        AppMethodBeat.o(137168);
        return;
      }
      ??? = this.chN.Eg();
    } while (??? == null);
    byte[] arrayOfByte = ((com.tencent.mm.audio.mix.a.b)???).cem;
    if (this.chN.ayN == null) {
      d.a(this.chN);
    }
    d locald2;
    label350:
    String str;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      if ((this.chN.ayN != null) && ((this.chN.ayN.getPlayState() == 1) || (this.chN.ayN.getPlayState() == 2))) {
        this.chN.ayN.play();
      }
      ??? = this.chN;
      ((d)???).chK += 1;
      locald2 = this.chN;
      Iterator localIterator = ((com.tencent.mm.audio.mix.a.b)???).cen.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label500;
        }
        str = (String)localIterator.next();
        synchronized (locald2.chq)
        {
          if (!TextUtils.isEmpty(str)) {
            if ((!locald2.cgu.containsKey(str)) || (!((Boolean)locald2.cgu.get(str)).booleanValue())) {
              break;
            }
          }
        }
      }
      if (!locald2.cgu.containsKey(str)) {
        break label719;
      }
      locald2.cgu.put(str, Boolean.TRUE);
    }
    label547:
    label719:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label350;
      }
      locald2.mHandler.post(new d.2(locald2, str));
      break label350;
      label500:
      long l = System.currentTimeMillis();
      if (this.chN.ayN != null) {
        if (this.chN.chs.DP())
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "isMute");
          this.chN.ayN.setStereoVolume(0.0F, 0.0F);
        }
      }
      for (i = this.chN.ayN.write(arrayOfByte, 0, arrayOfByte.length);; i = 0)
      {
        l = System.currentTimeMillis() - l;
        if (l > 100L) {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track after writeSize:%d, time:%d, writeCount:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(this.chN.chK) });
        }
        if (i < 0) {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track buffer failed, Size:%d", new Object[] { Integer.valueOf(i) });
        }
        if (this.chN.cho.size() == 0)
        {
          this.chN.chI[0] = arrayOfByte[(arrayOfByte.length - 2)];
          this.chN.chI[1] = arrayOfByte[(arrayOfByte.length - 1)];
        }
        a.CY().a(localb);
        break;
        this.chN.ayN.setStereoVolume(1.0F, 1.0F);
        break label547;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.d.1
 * JD-Core Version:    0.7.0.1
 */