package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class f$2
  implements Runnable
{
  f$2(f paramf, String paramString) {}
  
  public final void run()
  {
    f localf = this.dkb;
    String str = this.dkc;
    boolean bool1 = this.dkd;
    if (localf.context == null) {
      localf.context = ae.getContext();
    }
    if (localf.context == null) {
      y.w("MicroMsg.Notification.Tool.Sound", "playSound:context is null!!");
    }
    label768:
    label837:
    label874:
    boolean bool3;
    for (;;)
    {
      return;
      try
      {
        localAudioManager = (AudioManager)localf.context.getSystemService("audio");
        if (localAudioManager.getStreamVolume(5) != 0)
        {
          localf.djZ.removeMessages(305419896);
          localf.djZ.sendEmptyMessageDelayed(305419896, 8000L);
          y.i("MicroMsg.Notification.Tool.Sound", "doPlaySound playerIsInit: %s", new Object[] { Boolean.valueOf(localf.djX) });
          bool2 = localf.djX;
          if (!bool2) {}
        }
      }
      catch (Exception localIllegalStateException)
      {
        try
        {
          if (localf.djY != null)
          {
            if (localf.djY.isPlaying()) {
              localf.djY.stop();
            }
            localf.djY.release();
            y.i("MicroMsg.Notification.Tool.Sound", "try to release player before playSound playerIsInit: %s", new Object[] { Boolean.valueOf(localf.djX) });
          }
          localf.djX = false;
          localf.djY = new j();
          y.i("MicroMsg.Notification.Tool.Sound", "doPlaySound player: %s", new Object[] { localf.djY });
          localMediaPlayer = localf.djY;
          l = System.currentTimeMillis();
          if (bk.bl(str))
          {
            localUri1 = RingtoneManager.getDefaultUri(2);
            if (localUri1 == null) {}
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          try
          {
            for (;;)
            {
              for (;;)
              {
                long l;
                Uri localUri1;
                localMediaPlayer.setDataSource(localf.context, localUri1);
                y.i("MicroMsg.Notification.Tool.Sound", "summeranrt setPlayerDataSource tid[%d] [%d]ms", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l) });
                if (!localAudioManager.isWiredHeadsetOn()) {
                  break label874;
                }
                com.tencent.mm.compatible.b.f.yp();
                y.d("MicroMsg.Notification.Tool.Sound", "headset on, selected stream type: %s", new Object[] { Integer.valueOf(0) });
                float f1 = localAudioManager.getStreamVolume(0);
                float f5 = localAudioManager.getStreamVolume(3);
                float f2 = localAudioManager.getStreamMaxVolume(0);
                float f6 = localAudioManager.getStreamMaxVolume(3);
                float f3 = f1 / f2;
                float f4 = f5 / f6;
                y.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s, maxVolume: %s, toneScale: %s", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
                y.d("MicroMsg.Notification.Tool.Sound", "headset on, toneMUSICVolume: %s, maxMUSICVolume: %s, toneMusicScale: %s", new Object[] { Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f4) });
                if (f3 > f4)
                {
                  f1 = f2 * f4;
                  y.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s", new Object[] { Float.valueOf(f1) });
                }
                localAudioManager.setSpeakerphoneOn(false);
                y.i("MicroMsg.Notification.Tool.Sound", "notificationSetMode: %s", new Object[] { Integer.valueOf(q.dyn.dxI) });
                if (q.dyn.dxI != 1) {
                  break label837;
                }
                y.i("MicroMsg.Notification.Tool.Sound", "notification set mode enable, set mode now");
                if (localAudioManager.getMode() == 0) {
                  localAudioManager.setMode(3);
                }
                localf.djY.setOnCompletionListener(new f.3(localf, localAudioManager));
                localf.djY.setOnErrorListener(new f.4(localf, localAudioManager));
                localf.djY.setAudioStreamType(0);
                localf.djY.setLooping(true);
                localf.djY.prepare();
                localf.djY.setVolume(f1 / f2, f1 / f2);
                localf.djY.setLooping(false);
                localf.djY.start();
                localf.djX = true;
                return;
                localException1 = localException1;
                y.printErrStackTrace("MicroMsg.Notification.Tool.Sound", localException1, "PlaySound Exception:", new Object[0]);
                try
                {
                  if (localf.djY == null) {
                    break;
                  }
                  localf.djY.release();
                  return;
                }
                catch (Exception localException2)
                {
                  y.printErrStackTrace("MicroMsg.Notification.Tool.Sound", localException2, "try to release player in Exception:", new Object[0]);
                  return;
                }
              }
              localIllegalStateException = localIllegalStateException;
              y.w("MicroMsg.Notification.Tool.Sound", "try to release player before playSound error");
              if (localf.djY != null)
              {
                localf.djY.release();
                continue;
                if (!bool1) {
                  break label768;
                }
                localObject = localf.context.getAssets().openFd(str);
                localMediaPlayer.setDataSource(((AssetFileDescriptor)localObject).getFileDescriptor(), ((AssetFileDescriptor)localObject).getStartOffset(), ((AssetFileDescriptor)localObject).getLength());
                ((AssetFileDescriptor)localObject).close();
                localObject = null;
              }
            }
            Object localObject = Uri.parse(str);
          }
          catch (IOException localIOException)
          {
            AudioManager localAudioManager;
            for (;;)
            {
              MediaPlayer localMediaPlayer;
              if (!bk.bl(str))
              {
                Uri localUri2 = RingtoneManager.getDefaultUri(2);
                localMediaPlayer.setDataSource(localf.context, localUri2);
              }
              else
              {
                y.i("MicroMsg.Notification.Tool.Sound", "setPlayerDataSource IOException soundUri:%s, isAsset:%s", new Object[] { str, Boolean.valueOf(bool1) });
                continue;
                localf.djY.setOnCompletionListener(new f.5(localf));
                localf.djY.setOnErrorListener(new f.6(localf));
              }
            }
            y.d("MicroMsg.Notification.Tool.Sound", "getStreamVolume =  %d, soundUri = %s", new Object[] { Integer.valueOf(localAudioManager.getStreamVolume(5)), str });
            localf.djY.setOnCompletionListener(new f.7(localf));
            localf.djY.setOnErrorListener(new f.8(localf));
            localf.djY.setAudioStreamType(5);
            localf.djY.setLooping(true);
            localf.djY.prepare();
            localf.djY.setLooping(false);
            localf.djY.start();
            localf.djX = true;
            bool3 = localf.djX;
            if (Looper.myLooper() == null) {
              break label1048;
            }
          }
        }
      }
    }
    bool1 = true;
    if (Looper.getMainLooper() != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      y.i("MicroMsg.Notification.Tool.Sound", "doPlaySound start finish playerIsInit:%s, myLooper[%b] mainLooper[%b]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      return;
      label1048:
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.2
 * JD-Core Version:    0.7.0.1
 */