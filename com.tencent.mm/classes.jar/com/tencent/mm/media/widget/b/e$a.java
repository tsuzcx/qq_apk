package com.tencent.mm.media.widget.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class e$a
  implements Runnable
{
  float bJg;
  Runnable callback;
  int duration;
  volatile int eUK;
  int fds;
  volatile boolean fdt;
  boolean fdu;
  boolean fdv;
  boolean fdw;
  boolean fdx;
  final Object fdy;
  
  public e$a(e parame)
  {
    AppMethodBeat.i(152054);
    this.eUK = 0;
    this.fdt = true;
    this.fdu = false;
    this.fdv = false;
    this.fdw = false;
    this.fdx = false;
    this.fdy = new Object();
    this.callback = null;
    synchronized (this.fdy)
    {
      try
      {
        String str2 = com.tencent.mm.vfs.e.avK(parame.fca);
        String str1 = str2;
        if (!str2.endsWith("/")) {
          str1 = str2 + "/";
        }
        parame.fco = (str1 + "tempRotate.mp4");
      }
      catch (Exception parame)
      {
        for (;;)
        {
          ab.e("MicroMsg.X264YUVMP4MuxRecorder", "retrieve file name error: %s", new Object[] { parame.getMessage() });
        }
      }
      AppMethodBeat.o(152054);
      return;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(152055);
    if (this.fdq.fdk == -1)
    {
      this.fdq.fdk = Process.myTid();
      Process.setThreadPriority(Process.myTid(), -2);
      ab.i("MicroMsg.X264YUVMP4MuxRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(this.fdq.fdk) });
    }
    int i;
    int j;
    for (;;)
    {
      synchronized (this.fdy)
      {
        if (this.fdv) {
          break label201;
        }
        l = bo.yB();
        i = SightVideoJNI.triggerEncode(this.fds, Math.max(0, this.eUK), false);
        ab.i("MicroMsg.X264YUVMP4MuxRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.eUK), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
        j = Math.abs(i - this.eUK);
        if (j > 5) {}
      }
      try
      {
        Thread.sleep(100L);
        this.eUK = i;
        continue;
        localObject2 = finally;
        AppMethodBeat.o(152055);
        throw localObject2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ab.e("MicroMsg.X264YUVMP4MuxRecorder", "thread sleep error");
        }
      }
    }
    label201:
    long l = bo.yB();
    if (!this.fdw) {
      this.eUK = SightVideoJNI.triggerEncode(this.fds, this.eUK, true);
    }
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.eUK), Boolean.valueOf(this.fdw), Long.valueOf(Thread.currentThread().getId()) });
    Object localObject3;
    if (!this.fdw)
    {
      i = Math.max(1000, this.duration);
      if (this.fdq.fcd > 0) {
        i = this.fdq.fcd;
      }
      float f = this.bJg;
      if (this.fdq.fce > 0.0F) {
        f = this.fdq.fce;
      }
      this.fdq.fdg = new m(this.fds, this.fdq.fca, f, this.fdq.fcj, i, this.fdq.fcu.audioSampleRate, false);
      l = bo.yB();
      boolean bool = this.fdq.fdg.bRm();
      ab.i("MicroMsg.X264YUVMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bo.av(l)), Boolean.valueOf(bool) });
      if (!bool)
      {
        ab.e("MicroMsg.X264YUVMP4MuxRecorder", "mux failed!");
        SightVideoJNI.releaseBigSightDataBufferLock(this.fds);
        al.d(new e.a.1(this));
        localObject3 = c.eZC;
        c.VD();
        AppMethodBeat.o(152055);
        return;
      }
      localObject3 = c.eZC;
      c.VE();
      if (((this.fdq.fcx) && (this.fdq.fdl)) || ((!this.fdq.fdl) && (!this.fdq.fcx)) || ((this.fdq.fcx) && (Math.abs(this.fdq.fcn - this.fdq.fcy) == 0)) || (this.fdq.fcy == 180))
      {
        l = bo.yB();
        if ((this.fdq.fdl) || (this.fdq.fcx)) {
          break label921;
        }
        i = this.fdq.fcn;
      }
    }
    for (;;)
    {
      j = i;
      if (this.fdq.fcy == 180)
      {
        j = i;
        if (!this.fdq.fdl)
        {
          i += 180;
          j = i;
          if (i > 360) {
            j = i - 360;
          }
        }
      }
      if (j > 0)
      {
        SightVideoJNI.tagRotateVideo(this.fdq.fca, this.fdq.fco, j);
        ab.i("MicroMsg.X264YUVMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.fdq.fcn), Boolean.valueOf(this.fdq.fcx), Integer.valueOf(this.fdq.fcy), Integer.valueOf(j) });
        localObject3 = this.fdq.fco;
      }
      try
      {
        com.tencent.mm.vfs.e.C(this.fdq.fco, this.fdq.fca);
        com.tencent.mm.sdk.g.d.post(new e.a.3(this, (String)localObject3), "BigSightFFMpegRecorder_tagRotate_after_process");
        ab.i("MicroMsg.X264YUVMP4MuxRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(bo.av(l)) });
      }
      catch (Exception localException2)
      {
        label851:
        ab.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, copy file error");
        SightVideoJNI.releaseBigSightDataBufferLock(this.fds);
        al.d(new e.a.2(this));
        AppMethodBeat.o(152055);
        return;
      }
      try
      {
        localObject3 = com.tencent.mm.plugin.sight.base.d.Zo(this.fdq.fca);
        if (localObject3 != null)
        {
          c localc = c.eZC;
          c.co(((a)localObject3).videoBitrate, ((a)localObject3).eRw);
        }
      }
      catch (Exception localException3)
      {
        break label851;
        i = 180;
      }
      SightVideoJNI.releaseBigSightDataBufferLock(this.fds);
      ab.i("MicroMsg.X264YUVMP4MuxRecorder", "all finish, callback: %s", new Object[] { this.callback });
      this.fdq.reset();
      al.d(this.callback);
      this.fdx = true;
      this.fdq.fdk = -1;
      this.fdq.fdj = -1;
      AppMethodBeat.o(152055);
      return;
      label921:
      if (this.fdq.fdl) {
        i = this.fdq.fcy;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e.a
 * JD-Core Version:    0.7.0.1
 */