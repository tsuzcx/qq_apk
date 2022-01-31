package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IInterface;
import android.support.v4.media.MediaMetadataCompat;
import java.util.List;

public abstract interface a
  extends IInterface
{
  public abstract void A(boolean paramBoolean);
  
  public abstract void B(boolean paramBoolean);
  
  public abstract void a(MediaMetadataCompat paramMediaMetadataCompat);
  
  public abstract void a(ParcelableVolumeInfo paramParcelableVolumeInfo);
  
  public abstract void a(PlaybackStateCompat paramPlaybackStateCompat);
  
  public abstract void ak(int paramInt);
  
  public abstract void al(int paramInt);
  
  public abstract void b(String paramString, Bundle paramBundle);
  
  public abstract void cE();
  
  public abstract void onExtrasChanged(Bundle paramBundle);
  
  public abstract void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList);
  
  public abstract void onQueueTitleChanged(CharSequence paramCharSequence);
  
  public abstract void onSessionDestroyed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.session.a
 * JD-Core Version:    0.7.0.1
 */