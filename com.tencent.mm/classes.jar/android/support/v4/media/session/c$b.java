package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

final class c$b<T extends c.a>
  extends MediaController.Callback
{
  protected final T Df;
  
  public c$b(T paramT)
  {
    this.Df = paramT;
  }
  
  public final void onAudioInfoChanged(MediaController.PlaybackInfo paramPlaybackInfo)
  {
    c.a locala = this.Df;
    int j = paramPlaybackInfo.getPlaybackType();
    AudioAttributes localAudioAttributes = ((MediaController.PlaybackInfo)paramPlaybackInfo).getAudioAttributes();
    int i;
    if ((localAudioAttributes.getFlags() & 0x1) == 1) {
      i = 7;
    }
    for (;;)
    {
      locala.c(j, i, paramPlaybackInfo.getVolumeControl(), paramPlaybackInfo.getMaxVolume(), paramPlaybackInfo.getCurrentVolume());
      return;
      if ((localAudioAttributes.getFlags() & 0x4) == 4) {
        i = 6;
      } else {
        switch (localAudioAttributes.getUsage())
        {
        default: 
          i = 3;
          break;
        case 1: 
        case 11: 
        case 12: 
        case 14: 
          i = 3;
          break;
        case 13: 
          i = 1;
          break;
        case 2: 
          i = 0;
          break;
        case 3: 
          i = 8;
          break;
        case 4: 
          i = 4;
          break;
        case 6: 
          i = 2;
          break;
        case 5: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
          i = 5;
        }
      }
    }
  }
  
  public final void onExtrasChanged(Bundle paramBundle)
  {
    this.Df.dt();
  }
  
  public final void onMetadataChanged(MediaMetadata paramMediaMetadata)
  {
    this.Df.w(paramMediaMetadata);
  }
  
  public final void onPlaybackStateChanged(PlaybackState paramPlaybackState)
  {
    this.Df.v(paramPlaybackState);
  }
  
  public final void onQueueChanged(List<MediaSession.QueueItem> paramList)
  {
    this.Df.onQueueChanged(paramList);
  }
  
  public final void onQueueTitleChanged(CharSequence paramCharSequence)
  {
    this.Df.ds();
  }
  
  public final void onSessionDestroyed()
  {
    this.Df.onSessionDestroyed();
  }
  
  public final void onSessionEvent(String paramString, Bundle paramBundle)
  {
    this.Df.dr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.session.c.b
 * JD-Core Version:    0.7.0.1
 */