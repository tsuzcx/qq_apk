package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

@TargetApi(16)
public final class t
  implements h
{
  public String path;
  public int position;
  public MediaFormat sLm;
  public MediaFormat sLn;
  public GalleryItem.VideoMediaItem sLo;
  public a sLp;
  
  public t(String paramString, int paramInt, GalleryItem.VideoMediaItem paramVideoMediaItem, a parama)
  {
    this.path = paramString;
    this.position = paramInt;
    this.sLo = paramVideoMediaItem;
    this.sLp = parama;
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
        localc.sI(this.path);
        int j = localc.fKr.getTrackCount();
        i = 0;
        if (i < j)
        {
          localObject1 = localc.getTrackFormat(i);
          if (!((MediaFormat)localObject1).containsKey("mime"))
          {
            ac.d("VideoAnalysisTask", "find video mime : not found.");
            break label602;
          }
          localObject3 = ((MediaFormat)localObject1).getString("mime");
          ac.d("VideoAnalysisTask", "find video mime : %s", new Object[] { localObject3 });
          if (localObject3 == null) {
            break label602;
          }
          if (!((String)localObject3).startsWith("video/")) {
            continue;
          }
          if (this.sLm == null) {
            this.sLm = ((MediaFormat)localObject1);
          }
          if ((this.sLn == null) || (this.sLm == null)) {
            break label602;
          }
        }
        if (this.sLo == null) {
          continue;
        }
        if (this.sLm == null) {
          continue;
        }
        localObject1 = this.sLo;
        if (this.sLm.containsKey("durationUs")) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        ac.d("VideoAnalysisTask", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { this.path, localException.getMessage() });
        localc.fKr.release();
        continue;
        i = (int)(this.sLm.getLong("durationUs") / 1000L);
        continue;
        i = this.sLm.getInteger("height");
        continue;
        i = this.sLm.getInteger("width");
        continue;
        String str = this.sLm.getString("mime");
        continue;
        i = this.sLm.getInteger("bitrate");
        continue;
        i = this.sLm.getInteger("i-frame-interval");
        continue;
        i = this.sLm.getInteger("frame-rate");
        continue;
        str = this.sLn.getString("mime");
        continue;
      }
      finally
      {
        localc.fKr.release();
        AppMethodBeat.o(111378);
      }
      ((GalleryItem.VideoMediaItem)localObject1).hTw = i;
      localObject1 = this.sLo;
      if (!this.sLm.containsKey("height"))
      {
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
        localObject1 = this.sLo;
        if (this.sLm.containsKey("width")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
        localObject3 = this.sLo;
        if (this.sLm.containsKey("mime")) {
          continue;
        }
        localObject1 = "";
        ((GalleryItem.VideoMediaItem)localObject3).hTu = ((String)localObject1);
        localObject1 = this.sLo;
        if (this.sLm.containsKey("bitrate")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
        localObject1 = this.sLo;
        if (this.sLm.containsKey("i-frame-interval")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).hTx = i;
        localObject1 = this.sLo;
        if (this.sLm.containsKey("frame-rate")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
        if (this.sLn != null)
        {
          localObject3 = this.sLo;
          if (this.sLn.containsKey("mime")) {
            continue;
          }
          localObject1 = "";
          ((GalleryItem.VideoMediaItem)localObject3).hTv = ((String)localObject1);
        }
        localc.fKr.release();
        if (this.sLp != null) {
          break label585;
        }
        ac.d("VideoAnalysisTask", "video analysis end. observer == null, position = [%d], mediaItem = [%s]", new Object[] { Integer.valueOf(this.position), this.sLo });
        AppMethodBeat.o(111378);
        return;
        if ((!((String)localObject3).startsWith("audio/")) || (this.sLn != null)) {
          continue;
        }
        this.sLn = ((MediaFormat)localObject1);
      }
      label585:
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111377);
          if (t.this.sLp != null) {
            t.this.sLp.a(t.this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.t
 * JD-Core Version:    0.7.0.1
 */