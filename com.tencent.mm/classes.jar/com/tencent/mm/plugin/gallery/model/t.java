package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

@TargetApi(16)
public final class t
  implements h
{
  public String path;
  public int position;
  public MediaFormat rCs;
  public MediaFormat rCt;
  public GalleryItem.VideoMediaItem rCu;
  public a rCv;
  
  public t(String paramString, int paramInt, GalleryItem.VideoMediaItem paramVideoMediaItem, a parama)
  {
    this.path = paramString;
    this.position = paramInt;
    this.rCu = paramVideoMediaItem;
    this.rCv = parama;
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
        localc.px(this.path);
        int j = localc.fGK.getTrackCount();
        i = 0;
        if (i < j)
        {
          localObject1 = localc.getTrackFormat(i);
          if (!((MediaFormat)localObject1).containsKey("mime"))
          {
            ad.d("VideoAnalysisTask", "find video mime : not found.");
            break label602;
          }
          localObject3 = ((MediaFormat)localObject1).getString("mime");
          ad.d("VideoAnalysisTask", "find video mime : %s", new Object[] { localObject3 });
          if (localObject3 == null) {
            break label602;
          }
          if (!((String)localObject3).startsWith("video/")) {
            continue;
          }
          if (this.rCs == null) {
            this.rCs = ((MediaFormat)localObject1);
          }
          if ((this.rCt == null) || (this.rCs == null)) {
            break label602;
          }
        }
        if (this.rCu == null) {
          continue;
        }
        if (this.rCs == null) {
          continue;
        }
        localObject1 = this.rCu;
        if (this.rCs.containsKey("durationUs")) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        ad.d("VideoAnalysisTask", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { this.path, localException.getMessage() });
        localc.fGK.release();
        continue;
        i = (int)(this.rCs.getLong("durationUs") / 1000L);
        continue;
        i = this.rCs.getInteger("height");
        continue;
        i = this.rCs.getInteger("width");
        continue;
        String str = this.rCs.getString("mime");
        continue;
        i = this.rCs.getInteger("bitrate");
        continue;
        i = this.rCs.getInteger("i-frame-interval");
        continue;
        i = this.rCs.getInteger("frame-rate");
        continue;
        str = this.rCt.getString("mime");
        continue;
      }
      finally
      {
        localc.fGK.release();
        AppMethodBeat.o(111378);
      }
      ((GalleryItem.VideoMediaItem)localObject1).hsU = i;
      localObject1 = this.rCu;
      if (!this.rCs.containsKey("height"))
      {
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
        localObject1 = this.rCu;
        if (this.rCs.containsKey("width")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
        localObject3 = this.rCu;
        if (this.rCs.containsKey("mime")) {
          continue;
        }
        localObject1 = "";
        ((GalleryItem.VideoMediaItem)localObject3).hsS = ((String)localObject1);
        localObject1 = this.rCu;
        if (this.rCs.containsKey("bitrate")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
        localObject1 = this.rCu;
        if (this.rCs.containsKey("i-frame-interval")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).hsV = i;
        localObject1 = this.rCu;
        if (this.rCs.containsKey("frame-rate")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
        if (this.rCt != null)
        {
          localObject3 = this.rCu;
          if (this.rCt.containsKey("mime")) {
            continue;
          }
          localObject1 = "";
          ((GalleryItem.VideoMediaItem)localObject3).hsT = ((String)localObject1);
        }
        localc.fGK.release();
        if (this.rCv != null) {
          break label585;
        }
        ad.d("VideoAnalysisTask", "video analysis end. observer == null, position = [%d], mediaItem = [%s]", new Object[] { Integer.valueOf(this.position), this.rCu });
        AppMethodBeat.o(111378);
        return;
        if ((!((String)localObject3).startsWith("audio/")) || (this.rCt != null)) {
          continue;
        }
        this.rCt = ((MediaFormat)localObject1);
      }
      label585:
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111377);
          if (t.this.rCv != null) {
            t.this.rCv.a(t.this);
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