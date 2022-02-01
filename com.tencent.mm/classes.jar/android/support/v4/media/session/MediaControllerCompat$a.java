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
  MediaControllerCompat.a.a MA;
  a MC;
  final Object Mz;
  
  public MediaControllerCompat$a()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.Mz = new c.b(new b(this));
      return;
    }
    c localc = new c(this);
    this.MC = localc;
    this.Mz = localc;
  }
  
  final void a(int paramInt, Object paramObject, Bundle paramBundle)
  {
    if (this.MA != null)
    {
      paramObject = this.MA.obtainMessage(paramInt, paramObject);
      paramObject.setData(paramBundle);
      paramObject.sendToTarget();
    }
  }
  
  static final class b
    implements c.a
  {
    private final WeakReference<MediaControllerCompat.a> MF;
    
    b(MediaControllerCompat.a parama)
    {
      this.MF = new WeakReference(parama);
    }
    
    public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      if ((MediaControllerCompat.a)this.MF.get() != null) {
        new MediaControllerCompat.f(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      }
    }
    
    public final void fb()
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if ((locala != null) && (locala.MC != null)) {
        int i = Build.VERSION.SDK_INT;
      }
    }
    
    public final void fe()
    {
      this.MF.get();
    }
    
    public final void ff()
    {
      this.MF.get();
    }
    
    public final void onQueueChanged(List<?> paramList)
    {
      if ((MediaControllerCompat.a)this.MF.get() != null) {
        MediaSessionCompat.QueueItem.l(paramList);
      }
    }
    
    public final void onSessionDestroyed()
    {
      this.MF.get();
    }
    
    public final void x(Object paramObject)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if ((locala != null) && (locala.MC == null)) {
        PlaybackStateCompat.B(paramObject);
      }
    }
    
    public final void y(Object paramObject)
    {
      if ((MediaControllerCompat.a)this.MF.get() != null) {
        MediaMetadataCompat.w(paramObject);
      }
    }
  }
  
  static class c
    extends a.a
  {
    private final WeakReference<MediaControllerCompat.a> MF;
    
    c(MediaControllerCompat.a parama)
    {
      this.MF = new WeakReference(parama);
    }
    
    public final void F(boolean paramBoolean) {}
    
    public final void G(boolean paramBoolean)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        locala.a(11, Boolean.valueOf(paramBoolean), null);
      }
    }
    
    public void a(MediaMetadataCompat paramMediaMetadataCompat)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        locala.a(3, paramMediaMetadataCompat, null);
      }
    }
    
    public void a(ParcelableVolumeInfo paramParcelableVolumeInfo)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        if (paramParcelableVolumeInfo == null) {
          break label55;
        }
      }
      label55:
      for (paramParcelableVolumeInfo = new MediaControllerCompat.f(paramParcelableVolumeInfo.MY, paramParcelableVolumeInfo.MZ, paramParcelableVolumeInfo.Na, paramParcelableVolumeInfo.Nb, paramParcelableVolumeInfo.Nc);; paramParcelableVolumeInfo = null)
      {
        locala.a(4, paramParcelableVolumeInfo, null);
        return;
      }
    }
    
    public final void a(PlaybackStateCompat paramPlaybackStateCompat)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        locala.a(2, paramPlaybackStateCompat, null);
      }
    }
    
    public final void aA(int paramInt)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        locala.a(9, Integer.valueOf(paramInt), null);
      }
    }
    
    public final void aB(int paramInt)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        locala.a(12, Integer.valueOf(paramInt), null);
      }
    }
    
    public final void d(String paramString, Bundle paramBundle)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        locala.a(1, paramString, paramBundle);
      }
    }
    
    public final void eR()
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        locala.a(13, null, null);
      }
    }
    
    public void onExtrasChanged(Bundle paramBundle)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        locala.a(7, paramBundle, null);
      }
    }
    
    public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        locala.a(5, paramList, null);
      }
    }
    
    public void onQueueTitleChanged(CharSequence paramCharSequence)
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        locala.a(6, paramCharSequence, null);
      }
    }
    
    public void onSessionDestroyed()
    {
      MediaControllerCompat.a locala = (MediaControllerCompat.a)this.MF.get();
      if (locala != null) {
        locala.a(8, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.a
 * JD-Core Version:    0.7.0.1
 */