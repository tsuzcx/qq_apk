package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.view.KeyEvent;
import java.util.List;

public abstract interface b
  extends IInterface
{
  public abstract void C(boolean paramBoolean);
  
  public abstract void D(boolean paramBoolean);
  
  public abstract void a(MediaDescriptionCompat paramMediaDescriptionCompat);
  
  public abstract void a(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt);
  
  public abstract void a(RatingCompat paramRatingCompat);
  
  public abstract void a(RatingCompat paramRatingCompat, Bundle paramBundle);
  
  public abstract void a(a parama);
  
  public abstract void a(String paramString, Bundle paramBundle, MediaSessionCompat.ResultReceiverWrapper paramResultReceiverWrapper);
  
  public abstract boolean a(KeyEvent paramKeyEvent);
  
  public abstract void ak(int paramInt);
  
  public abstract void al(int paramInt);
  
  public abstract void b(int paramInt1, int paramInt2, String paramString);
  
  public abstract void b(MediaDescriptionCompat paramMediaDescriptionCompat);
  
  public abstract void b(a parama);
  
  public abstract void c(int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean di();
  
  public abstract PendingIntent dj();
  
  public abstract ParcelableVolumeInfo dk();
  
  public abstract MediaMetadataCompat dl();
  
  public abstract PlaybackStateCompat dm();
  
  public abstract boolean dn();
  
  public abstract boolean jdMethod_do();
  
  public abstract int dp();
  
  public abstract void dq();
  
  public abstract void fastForward();
  
  public abstract Bundle getExtras();
  
  public abstract long getFlags();
  
  public abstract String getPackageName();
  
  public abstract List<MediaSessionCompat.QueueItem> getQueue();
  
  public abstract CharSequence getQueueTitle();
  
  public abstract int getRatingType();
  
  public abstract int getRepeatMode();
  
  public abstract String getTag();
  
  public abstract void next();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void playFromMediaId(String paramString, Bundle paramBundle);
  
  public abstract void playFromSearch(String paramString, Bundle paramBundle);
  
  public abstract void playFromUri(Uri paramUri, Bundle paramBundle);
  
  public abstract void prepare();
  
  public abstract void prepareFromMediaId(String paramString, Bundle paramBundle);
  
  public abstract void prepareFromSearch(String paramString, Bundle paramBundle);
  
  public abstract void prepareFromUri(Uri paramUri, Bundle paramBundle);
  
  public abstract void rewind();
  
  public abstract void seekTo(long paramLong);
  
  public abstract void sendCustomAction(String paramString, Bundle paramBundle);
  
  public abstract void setRepeatMode(int paramInt);
  
  public abstract void skipToQueueItem(long paramLong);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.session.b
 * JD-Core Version:    0.7.0.1
 */