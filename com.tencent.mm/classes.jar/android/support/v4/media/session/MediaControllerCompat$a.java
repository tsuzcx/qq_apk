package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class MediaControllerCompat$a
  implements IBinder.DeathRecipient
{
  final Object ds;
  MediaControllerCompat.a.a dt;
  a du;
  
  public MediaControllerCompat$a()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.ds = new c.b(new b(this));
      return;
    }
    c localc = new c(this);
    this.du = localc;
    this.ds = localc;
  }
  
  final void a(int paramInt, Object paramObject, Bundle paramBundle)
  {
    if (this.dt != null)
    {
      paramObject = this.dt.obtainMessage(paramInt, paramObject);
      paramObject.setData(paramBundle);
      paramObject.sendToTarget();
    }
  }
  
  static final class b
    implements c.a
  {
    private final WeakReference<MediaControllerCompat.a> dv;
    
    b(MediaControllerCompat.a parama)
    {
      this.dv = new WeakReference(parama);
    }
    
    public final void aA()
    {
      this.dv.get();
    }
    
    public final void ay()
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if ((locala != null) && (locala.du != null)) {
        int i = Build.VERSION.SDK_INT;
      }
    }
    
    public final void az()
    {
      this.dv.get();
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      if ((MediaControllerCompat.a)this.dv.get() != null) {
        new MediaControllerCompat.f(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      }
    }
    
    public final void f(Object paramObject)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if ((locala != null) && (locala.du == null)) {
        PlaybackStateCompat.j(paramObject);
      }
    }
    
    public final void g(Object paramObject)
    {
      if ((MediaControllerCompat.a)this.dv.get() != null) {
        MediaMetadataCompat.e(paramObject);
      }
    }
    
    public final void onQueueChanged(List<?> paramList)
    {
      if ((MediaControllerCompat.a)this.dv.get() != null) {
        MediaSessionCompat.QueueItem.f(paramList);
      }
    }
    
    public final void onSessionDestroyed()
    {
      this.dv.get();
    }
  }
  
  static class c
    extends a.a
  {
    private final WeakReference<MediaControllerCompat.a> dv;
    
    c(MediaControllerCompat.a parama)
    {
      this.dv = new WeakReference(parama);
    }
    
    public final void I(int paramInt)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        locala.a(9, Integer.valueOf(paramInt), null);
      }
    }
    
    public final void J(int paramInt)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        locala.a(12, Integer.valueOf(paramInt), null);
      }
    }
    
    public final void Z()
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        locala.a(13, null, null);
      }
    }
    
    public void a(MediaMetadataCompat paramMediaMetadataCompat)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        locala.a(3, paramMediaMetadataCompat, null);
      }
    }
    
    public void a(ParcelableVolumeInfo paramParcelableVolumeInfo)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        if (paramParcelableVolumeInfo == null) {
          break label55;
        }
      }
      label55:
      for (paramParcelableVolumeInfo = new MediaControllerCompat.f(paramParcelableVolumeInfo.dO, paramParcelableVolumeInfo.dP, paramParcelableVolumeInfo.dQ, paramParcelableVolumeInfo.dR, paramParcelableVolumeInfo.dS);; paramParcelableVolumeInfo = null)
      {
        locala.a(4, paramParcelableVolumeInfo, null);
        return;
      }
    }
    
    public final void a(PlaybackStateCompat paramPlaybackStateCompat)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        locala.a(2, paramPlaybackStateCompat, null);
      }
    }
    
    public final void d(String paramString, Bundle paramBundle)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        locala.a(1, paramString, paramBundle);
      }
    }
    
    public final void n(boolean paramBoolean) {}
    
    public final void o(boolean paramBoolean)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        locala.a(11, Boolean.valueOf(paramBoolean), null);
      }
    }
    
    public void onExtrasChanged(Bundle paramBundle)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        locala.a(7, paramBundle, null);
      }
    }
    
    public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        locala.a(5, paramList, null);
      }
    }
    
    public void onQueueTitleChanged(CharSequence paramCharSequence)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        locala.a(6, paramCharSequence, null);
      }
    }
    
    public void onSessionDestroyed()
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
      if (locala != null) {
        locala.a(8, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.a
 * JD-Core Version:    0.7.0.1
 */