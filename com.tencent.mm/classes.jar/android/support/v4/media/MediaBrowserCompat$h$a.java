package android.support.v4.media;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;

final class MediaBrowserCompat$h$a
  implements ServiceConnection
{
  MediaBrowserCompat$h$a(MediaBrowserCompat.h paramh) {}
  
  private void e(Runnable paramRunnable)
  {
    if (Thread.currentThread() == this.AV.AL.getLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    this.AV.AL.post(paramRunnable);
  }
  
  final boolean L(String paramString)
  {
    boolean bool = true;
    if ((this.AV.AT != this) || (this.AV.mState == 0) || (this.AV.mState == 1))
    {
      if ((this.AV.mState != 0) && (this.AV.mState != 1)) {
        new StringBuilder().append(paramString).append(" for ").append(this.AV.AR).append(" with mServiceConnection=").append(this.AV.AT).append(" this=").append(this);
      }
      bool = false;
    }
    return bool;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    e(new MediaBrowserCompat.h.a.1(this, paramComponentName, paramIBinder));
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    e(new MediaBrowserCompat.h.a.2(this, paramComponentName));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.h.a
 * JD-Core Version:    0.7.0.1
 */