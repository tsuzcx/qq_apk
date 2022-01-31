package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import java.lang.ref.WeakReference;
import java.util.List;

class MediaControllerCompat$a$c
  extends a.a
{
  private final WeakReference<MediaControllerCompat.a> CT;
  
  MediaControllerCompat$a$c(MediaControllerCompat.a parama)
  {
    this.CT = new WeakReference(parama);
  }
  
  public final void A(boolean paramBoolean) {}
  
  public final void B(boolean paramBoolean)
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      locala.a(11, Boolean.valueOf(paramBoolean), null);
    }
  }
  
  public void a(MediaMetadataCompat paramMediaMetadataCompat)
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      locala.a(3, paramMediaMetadataCompat, null);
    }
  }
  
  public void a(ParcelableVolumeInfo paramParcelableVolumeInfo)
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      if (paramParcelableVolumeInfo == null) {
        break label55;
      }
    }
    label55:
    for (paramParcelableVolumeInfo = new MediaControllerCompat.f(paramParcelableVolumeInfo.Dk, paramParcelableVolumeInfo.Dl, paramParcelableVolumeInfo.Dm, paramParcelableVolumeInfo.Dn, paramParcelableVolumeInfo.Do);; paramParcelableVolumeInfo = null)
    {
      locala.a(4, paramParcelableVolumeInfo, null);
      return;
    }
  }
  
  public final void a(PlaybackStateCompat paramPlaybackStateCompat)
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      locala.a(2, paramPlaybackStateCompat, null);
    }
  }
  
  public final void ai(int paramInt)
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      locala.a(9, Integer.valueOf(paramInt), null);
    }
  }
  
  public final void aj(int paramInt)
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      locala.a(12, Integer.valueOf(paramInt), null);
    }
  }
  
  public final void d(String paramString, Bundle paramBundle)
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      locala.a(1, paramString, paramBundle);
    }
  }
  
  public final void dh()
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      locala.a(13, null, null);
    }
  }
  
  public void onExtrasChanged(Bundle paramBundle)
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      locala.a(7, paramBundle, null);
    }
  }
  
  public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      locala.a(5, paramList, null);
    }
  }
  
  public void onQueueTitleChanged(CharSequence paramCharSequence)
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      locala.a(6, paramCharSequence, null);
    }
  }
  
  public void onSessionDestroyed()
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if (locala != null) {
      locala.a(8, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.a.c
 * JD-Core Version:    0.7.0.1
 */