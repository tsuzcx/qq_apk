package com.tencent.mm.booter.notification.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.charset.Charset;

public final class f
{
  Context context;
  boolean ebs;
  MediaPlayer ebt;
  @SuppressLint({"HandlerLeak"})
  ak ebu;
  private ak ebv;
  
  private f()
  {
    AppMethodBeat.i(16033);
    this.ebs = false;
    this.ebt = null;
    this.ebu = new f.1(this, Looper.getMainLooper());
    this.context = ah.getContext();
    Object localObject1 = com.tencent.mm.storage.ac.eQv + "deviceconfig.cfg";
    ab.i("MicroMsg.ServerConfigInfoStorage", "readConfigFromLocalFile, path: %s, isExist: %s", new Object[] { localObject1, Boolean.valueOf(e.cN((String)localObject1)) });
    if (!e.cN((String)localObject1)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      com.tencent.mm.compatible.e.ac.ll((String)localObject1);
      AppMethodBeat.o(16033);
      return;
      Object localObject3 = e.j((String)localObject1, 0, -1);
      localObject1 = localObject2;
      if (!bo.ce((byte[])localObject3))
      {
        localObject3 = new String((byte[])localObject3, Charset.defaultCharset());
        localObject1 = localObject2;
        if (!bo.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public final void kI(String paramString)
  {
    try
    {
      AppMethodBeat.i(16034);
      if (this.ebv == null)
      {
        ab.i("MicroMsg.Notification.Tool.Sound", "playSound playHandler == null");
        HandlerThread localHandlerThread = d.ey("playSoundThread", 0);
        localHandlerThread.start();
        this.ebv = new ak(localHandlerThread.getLooper());
      }
      this.ebv.post(new f.2(this, paramString));
      AppMethodBeat.o(16034);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f
 * JD-Core Version:    0.7.0.1
 */