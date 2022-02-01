package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

@TargetApi(16)
public final class t
  implements h
{
  public GalleryItem.VideoMediaItem BWt;
  public a BWu;
  public MediaFormat audioFormat;
  public String path;
  public int position;
  public MediaFormat videoFormat;
  
  public t(String paramString, int paramInt, GalleryItem.VideoMediaItem paramVideoMediaItem, a parama)
  {
    this.path = paramString;
    this.position = paramInt;
    this.BWt = paramVideoMediaItem;
    this.BWu = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(111379);
    if (((paramObject instanceof t)) && ((this == paramObject) || (this.position == ((t)paramObject).position) || ((this.path != null) && (this.path.equals(((t)paramObject).path)))))
    {
      AppMethodBeat.o(111379);
      return true;
    }
    AppMethodBeat.o(111379);
    return false;
  }
  
  public final String getKey()
  {
    return "video_analysis";
  }
  
  public final void run()
  {
    AppMethodBeat.i(111378);
    c localc = new c();
    for (;;)
    {
      int i;
      try
      {
        localc.setDataSource(this.path);
        int j = localc.jvU.getTrackCount();
        i = 0;
        if (i < j)
        {
          localObject1 = localc.getTrackFormat(i);
          if (!((MediaFormat)localObject1).containsKey("mime"))
          {
            Log.d("VideoAnalysisTask", "find video mime : not found.");
            break label602;
          }
          localObject3 = ((MediaFormat)localObject1).getString("mime");
          Log.d("VideoAnalysisTask", "find video mime : %s", new Object[] { localObject3 });
          if (localObject3 == null) {
            break label602;
          }
          if (!((String)localObject3).startsWith("video/")) {
            continue;
          }
          if (this.videoFormat == null) {
            this.videoFormat = ((MediaFormat)localObject1);
          }
          if ((this.audioFormat == null) || (this.videoFormat == null)) {
            break label602;
          }
        }
        if (this.BWt == null) {
          continue;
        }
        if (this.videoFormat == null) {
          continue;
        }
        localObject1 = this.BWt;
        if (this.videoFormat.containsKey("durationUs")) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        Log.d("VideoAnalysisTask", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { this.path, localException.getMessage() });
        localc.jvU.release();
        continue;
        i = (int)(this.videoFormat.getLong("durationUs") / 1000L);
        continue;
        i = this.videoFormat.getInteger("height");
        continue;
        i = this.videoFormat.getInteger("width");
        continue;
        String str = this.videoFormat.getString("mime");
        continue;
        i = this.videoFormat.getInteger("bitrate");
        continue;
        i = this.videoFormat.getInteger("i-frame-interval");
        continue;
        i = this.videoFormat.getInteger("frame-rate");
        continue;
        str = this.audioFormat.getString("mime");
        continue;
      }
      finally
      {
        localc.jvU.release();
        AppMethodBeat.o(111378);
      }
      ((GalleryItem.VideoMediaItem)localObject1).maT = i;
      localObject1 = this.BWt;
      if (!this.videoFormat.containsKey("height"))
      {
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
        localObject1 = this.BWt;
        if (this.videoFormat.containsKey("width")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
        localObject3 = this.BWt;
        if (this.videoFormat.containsKey("mime")) {
          continue;
        }
        localObject1 = "";
        ((GalleryItem.VideoMediaItem)localObject3).maR = ((String)localObject1);
        localObject1 = this.BWt;
        if (this.videoFormat.containsKey("bitrate")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
        localObject1 = this.BWt;
        if (this.videoFormat.containsKey("i-frame-interval")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoIFrameInterval = i;
        localObject1 = this.BWt;
        if (this.videoFormat.containsKey("frame-rate")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
        if (this.audioFormat != null)
        {
          localObject3 = this.BWt;
          if (this.audioFormat.containsKey("mime")) {
            continue;
          }
          localObject1 = "";
          ((GalleryItem.VideoMediaItem)localObject3).maS = ((String)localObject1);
        }
        localc.jvU.release();
        if (this.BWu != null) {
          break label585;
        }
        Log.d("VideoAnalysisTask", "video analysis end. observer == null, position = [%d], mediaItem = [%s]", new Object[] { Integer.valueOf(this.position), this.BWt });
        AppMethodBeat.o(111378);
        return;
        if ((!((String)localObject3).startsWith("audio/")) || (this.audioFormat != null)) {
          continue;
        }
        this.audioFormat = ((MediaFormat)localObject1);
      }
      label585:
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111377);
          if (t.this.BWu != null) {
            t.this.BWu.a(t.this);
          }
          AppMethodBeat.o(111377);
        }
      });
      AppMethodBeat.o(111378);
      return;
      label602:
      i += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(t paramt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.t
 * JD-Core Version:    0.7.0.1
 */