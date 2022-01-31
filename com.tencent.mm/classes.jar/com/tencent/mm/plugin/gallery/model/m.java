package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

@TargetApi(16)
public final class m
  implements Runnable
{
  public MediaFormat ndD;
  public MediaFormat ndE;
  public GalleryItem.VideoMediaItem ndF;
  public m.a ndG;
  public String path;
  public int position;
  
  public m(String paramString, int paramInt, GalleryItem.VideoMediaItem paramVideoMediaItem, m.a parama)
  {
    this.path = paramString;
    this.position = paramInt;
    this.ndF = paramVideoMediaItem;
    this.ndG = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(21332);
    if (((paramObject instanceof m)) && ((this == paramObject) || (this.position == ((m)paramObject).position) || ((this.path != null) && (this.path.equals(((m)paramObject).path)))))
    {
      AppMethodBeat.o(21332);
      return true;
    }
    AppMethodBeat.o(21332);
    return false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(21331);
    MediaExtractor localMediaExtractor = new MediaExtractor();
    for (;;)
    {
      int i;
      try
      {
        localMediaExtractor.setDataSource(this.path);
        int j = localMediaExtractor.getTrackCount();
        i = 0;
        if (i < j)
        {
          localObject1 = localMediaExtractor.getTrackFormat(i);
          if (!((MediaFormat)localObject1).containsKey("mime"))
          {
            ab.d("VideoAnalysisTask", "find video mime : not found.");
            break label594;
          }
          localObject3 = ((MediaFormat)localObject1).getString("mime");
          ab.d("VideoAnalysisTask", "find video mime : %s", new Object[] { localObject3 });
          if (localObject3 == null) {
            break label594;
          }
          if (!((String)localObject3).startsWith("video/")) {
            continue;
          }
          if (this.ndD == null) {
            this.ndD = ((MediaFormat)localObject1);
          }
          if ((this.ndE == null) || (this.ndD == null)) {
            break label594;
          }
        }
        if (this.ndF == null) {
          continue;
        }
        if (this.ndD == null) {
          continue;
        }
        localObject1 = this.ndF;
        if (this.ndD.containsKey("durationUs")) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        ab.d("VideoAnalysisTask", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { this.path, localException.getMessage() });
        localMediaExtractor.release();
        continue;
        i = (int)(this.ndD.getLong("durationUs") / 1000L);
        continue;
        i = this.ndD.getInteger("height");
        continue;
        i = this.ndD.getInteger("width");
        continue;
        String str = this.ndD.getString("mime");
        continue;
        i = this.ndD.getInteger("bitrate");
        continue;
        i = this.ndD.getInteger("i-frame-interval");
        continue;
        i = this.ndD.getInteger("frame-rate");
        continue;
        str = this.ndE.getString("mime");
        continue;
      }
      finally
      {
        localMediaExtractor.release();
        AppMethodBeat.o(21331);
      }
      ((GalleryItem.VideoMediaItem)localObject1).fQq = i;
      localObject1 = this.ndF;
      if (!this.ndD.containsKey("height"))
      {
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
        localObject1 = this.ndF;
        if (this.ndD.containsKey("width")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
        localObject3 = this.ndF;
        if (this.ndD.containsKey("mime")) {
          continue;
        }
        localObject1 = "";
        ((GalleryItem.VideoMediaItem)localObject3).fQo = ((String)localObject1);
        localObject1 = this.ndF;
        if (this.ndD.containsKey("bitrate")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
        localObject1 = this.ndF;
        if (this.ndD.containsKey("i-frame-interval")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).fQr = i;
        localObject1 = this.ndF;
        if (this.ndD.containsKey("frame-rate")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
        if (this.ndE != null)
        {
          localObject3 = this.ndF;
          if (this.ndE.containsKey("mime")) {
            continue;
          }
          localObject1 = "";
          ((GalleryItem.VideoMediaItem)localObject3).fQp = ((String)localObject1);
        }
        localMediaExtractor.release();
        if (this.ndG != null) {
          break label576;
        }
        ab.d("VideoAnalysisTask", "video analysis end. observer == null, position = [%d], mediaItem = [%s]", new Object[] { Integer.valueOf(this.position), this.ndF });
        AppMethodBeat.o(21331);
        return;
        if ((!((String)localObject3).startsWith("audio/")) || (this.ndE != null)) {
          continue;
        }
        this.ndE = ((MediaFormat)localObject1);
      }
      label576:
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21330);
          if (m.this.ndG != null) {
            m.this.ndG.a(m.this);
          }
          AppMethodBeat.o(21330);
        }
      });
      AppMethodBeat.o(21331);
      return;
      label594:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.m
 * JD-Core Version:    0.7.0.1
 */