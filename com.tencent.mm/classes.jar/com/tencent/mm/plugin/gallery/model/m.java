package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

@TargetApi(16)
public final class m
  implements Runnable
{
  public MediaFormat kHt;
  public MediaFormat kHu;
  public GalleryItem.VideoMediaItem kHv;
  public m.a kHw;
  public String path;
  public int position;
  
  public m(String paramString, int paramInt, GalleryItem.VideoMediaItem paramVideoMediaItem, m.a parama)
  {
    this.path = paramString;
    this.position = paramInt;
    this.kHv = paramVideoMediaItem;
    this.kHw = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof m)) && ((this == paramObject) || (this.position == ((m)paramObject).position) || ((this.path != null) && (this.path.equals(((m)paramObject).path))));
  }
  
  public final void run()
  {
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
            y.d("VideoAnalysisTask", "find video mime : not found.");
            break label570;
          }
          localObject3 = ((MediaFormat)localObject1).getString("mime");
          y.d("VideoAnalysisTask", "find video mime : %s", new Object[] { localObject3 });
          if (localObject3 == null) {
            break label570;
          }
          if (!((String)localObject3).startsWith("video/")) {
            continue;
          }
          if (this.kHt == null) {
            this.kHt = ((MediaFormat)localObject1);
          }
          if ((this.kHu == null) || (this.kHt == null)) {
            break label570;
          }
        }
        if (this.kHv == null) {
          continue;
        }
        if (this.kHt == null) {
          continue;
        }
        localObject1 = this.kHv;
        if (this.kHt.containsKey("durationUs")) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        y.d("VideoAnalysisTask", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { this.path, localException.getMessage() });
        localMediaExtractor.release();
        continue;
        i = (int)(this.kHt.getLong("durationUs") / 1000L);
        continue;
        i = this.kHt.getInteger("height");
        continue;
        i = this.kHt.getInteger("width");
        continue;
        String str = this.kHt.getString("mime");
        continue;
        i = this.kHt.getInteger("bitrate");
        continue;
        i = this.kHt.getInteger("i-frame-interval");
        continue;
        i = this.kHt.getInteger("frame-rate");
        continue;
        str = this.kHu.getString("mime");
        continue;
      }
      finally
      {
        localMediaExtractor.release();
      }
      ((GalleryItem.VideoMediaItem)localObject1).eAx = i;
      localObject1 = this.kHv;
      if (!this.kHt.containsKey("height"))
      {
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
        localObject1 = this.kHv;
        if (this.kHt.containsKey("width")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
        localObject3 = this.kHv;
        if (this.kHt.containsKey("mime")) {
          continue;
        }
        localObject1 = "";
        ((GalleryItem.VideoMediaItem)localObject3).eAv = ((String)localObject1);
        localObject1 = this.kHv;
        if (this.kHt.containsKey("bitrate")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
        localObject1 = this.kHv;
        if (this.kHt.containsKey("i-frame-interval")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).eAy = i;
        localObject1 = this.kHv;
        if (this.kHt.containsKey("frame-rate")) {
          continue;
        }
        i = 0;
        ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
        if (this.kHu != null)
        {
          localObject3 = this.kHv;
          if (this.kHu.containsKey("mime")) {
            continue;
          }
          localObject1 = "";
          ((GalleryItem.VideoMediaItem)localObject3).eAw = ((String)localObject1);
        }
        localMediaExtractor.release();
        if (this.kHw != null) {
          break label558;
        }
        y.d("VideoAnalysisTask", "video analysis end. observer == null, position = [%d], mediaItem = [%s]", new Object[] { Integer.valueOf(this.position), this.kHv });
        return;
        if ((!((String)localObject3).startsWith("audio/")) || (this.kHu != null)) {
          continue;
        }
        this.kHu = ((MediaFormat)localObject1);
      }
      label558:
      ai.d(new m.1(this));
      return;
      label570:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.m
 * JD-Core Version:    0.7.0.1
 */