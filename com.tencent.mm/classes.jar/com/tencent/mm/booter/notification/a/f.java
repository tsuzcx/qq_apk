package com.tencent.mm.booter.notification.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import java.nio.charset.Charset;

public final class f
{
  Context context = ae.getContext();
  boolean djX = false;
  MediaPlayer djY = null;
  @SuppressLint({"HandlerLeak"})
  ah djZ = new f.1(this, Looper.getMainLooper());
  private ah dka;
  
  private f()
  {
    Object localObject1 = ac.dOP + "deviceconfig.cfg";
    y.i("MicroMsg.ServerConfigInfoStorage", "readConfigFromLocalFile, path: %s, isExist: %s", new Object[] { localObject1, Boolean.valueOf(com.tencent.mm.a.e.bK((String)localObject1)) });
    if (!com.tencent.mm.a.e.bK((String)localObject1)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      q.fa((String)localObject1);
      return;
      Object localObject3 = com.tencent.mm.a.e.d((String)localObject1, 0, -1);
      localObject1 = localObject2;
      if (!bk.bE((byte[])localObject3))
      {
        localObject3 = new String((byte[])localObject3, Charset.defaultCharset());
        localObject1 = localObject2;
        if (!bk.bl((String)localObject3)) {
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public final void eD(String paramString)
  {
    try
    {
      if (this.dka == null)
      {
        y.i("MicroMsg.Notification.Tool.Sound", "playSound playHandler == null");
        HandlerThread localHandlerThread = com.tencent.mm.sdk.f.e.ds("playSoundThread", 0);
        localHandlerThread.start();
        this.dka = new ah(localHandlerThread.getLooper());
      }
      this.dka.post(new f.2(this, paramString));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f
 * JD-Core Version:    0.7.0.1
 */