package com.tencent.mm.plugin.gallery.ui;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

final class a$c
  implements Runnable
{
  private static HashMap<TextView, c> ndZ;
  private WeakReference<TextView> mlc;
  private GalleryItem.VideoMediaItem ndX;
  private a.c.a ndY;
  
  static
  {
    AppMethodBeat.i(21371);
    ndZ = new HashMap();
    AppMethodBeat.o(21371);
  }
  
  private a$c(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem, a.c.a parama)
  {
    AppMethodBeat.i(21363);
    this.mlc = new WeakReference(paramTextView);
    this.ndX = paramVideoMediaItem;
    this.ndY = parama;
    AppMethodBeat.o(21363);
  }
  
  static void a(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    Object localObject = null;
    AppMethodBeat.i(21365);
    if ((paramTextView == null) || (paramVideoMediaItem == null))
    {
      ab.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
      AppMethodBeat.o(21365);
      return;
    }
    if (ndZ.containsKey(paramTextView))
    {
      localc = (c)ndZ.get(paramTextView);
      if (localc.ndX.equals(paramVideoMediaItem))
      {
        AppMethodBeat.o(21365);
        return;
      }
      if (paramTextView.equals(localc.mlc.get())) {
        localc.h(null);
      }
    }
    if (paramVideoMediaItem.fQq >= 0)
    {
      ab.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(paramVideoMediaItem.fQq), paramVideoMediaItem });
      g(paramTextView, paramVideoMediaItem.fQq);
      ndZ.remove(paramTextView);
      AppMethodBeat.o(21365);
      return;
    }
    paramTextView.setText("");
    c localc = new c(paramTextView, paramVideoMediaItem, new a.c.2());
    if (d.ysm.an(localc))
    {
      ab.i("MicroMsg.AlbumAdapter", "task has post to thread pool");
      Iterator localIterator = ndZ.entrySet().iterator();
      do
      {
        paramVideoMediaItem = localObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramVideoMediaItem = (Map.Entry)localIterator.next();
      } while (!localc.equals(paramVideoMediaItem.getValue()));
      if ((paramVideoMediaItem == null) || (paramVideoMediaItem.getValue() == null))
      {
        ab.e("MicroMsg.AlbumAdapter", "no entry found");
        AppMethodBeat.o(21365);
        return;
      }
      ((c)paramVideoMediaItem.getValue()).h(paramTextView);
      ndZ.remove(paramVideoMediaItem.getKey());
      ndZ.put(paramTextView, paramVideoMediaItem.getValue());
      AppMethodBeat.o(21365);
      return;
    }
    d.post(localc, "load_duration_for_" + paramVideoMediaItem.fQn);
    ndZ.put(paramTextView, localc);
    AppMethodBeat.o(21365);
  }
  
  private static void g(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(21366);
    if (paramTextView == null)
    {
      AppMethodBeat.o(21366);
      return;
    }
    if (paramInt < 0)
    {
      paramTextView.setText("--:--");
      AppMethodBeat.o(21366);
      return;
    }
    paramInt = Math.round(paramInt / 1000.0F);
    paramTextView.setText(String.format(Locale.CHINA, "%d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) }));
    AppMethodBeat.o(21366);
  }
  
  private void h(TextView paramTextView)
  {
    AppMethodBeat.i(21364);
    this.mlc = new WeakReference(paramTextView);
    AppMethodBeat.o(21364);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(21367);
    if ((paramObject == null) || (!(paramObject instanceof c)))
    {
      AppMethodBeat.o(21367);
      return false;
    }
    boolean bool = this.ndX.equals(((c)paramObject).ndX);
    AppMethodBeat.o(21367);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(21368);
    int i = this.ndX.hashCode();
    AppMethodBeat.o(21368);
    return i;
  }
  
  public final void run()
  {
    AppMethodBeat.i(21369);
    MediaExtractor localMediaExtractor = new MediaExtractor();
    String str1 = this.ndX.Xi();
    for (;;)
    {
      int i;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      try
      {
        localMediaExtractor.setDataSource(str1);
        int j = localMediaExtractor.getTrackCount();
        i = 0;
        localObject4 = null;
        localObject1 = null;
        localObject5 = localObject4;
        localObject6 = localObject1;
        if (i < j)
        {
          localMediaFormat = localMediaExtractor.getTrackFormat(i);
          if (!localMediaFormat.containsKey("mime"))
          {
            ab.d("MicroMsg.AlbumAdapter", "find video mime : not found.");
            localObject7 = localObject4;
            localObject8 = localObject1;
            break label650;
          }
          str2 = localMediaFormat.getString("mime");
          ab.d("MicroMsg.AlbumAdapter", "find video mime : %s", new Object[] { str2 });
          localObject7 = localObject4;
          localObject8 = localObject1;
          if (str2 == null) {
            break label650;
          }
          if (!str2.startsWith("video/")) {
            continue;
          }
          localObject5 = localObject4;
          localObject6 = localObject1;
          if (localObject1 != null) {
            break label664;
          }
          localObject6 = localMediaFormat;
          localObject5 = localObject4;
          break label664;
        }
        if (this.ndX != null)
        {
          if (localObject6 != null)
          {
            localObject1 = this.ndX;
            if (localObject6.containsKey("durationUs")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).fQq = i;
            localObject1 = this.ndX;
            if (localObject6.containsKey("height")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
            localObject1 = this.ndX;
            if (localObject6.containsKey("width")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
            localObject4 = this.ndX;
            if (localObject6.containsKey("mime")) {
              continue;
            }
            localObject1 = "";
            ((GalleryItem.VideoMediaItem)localObject4).fQo = ((String)localObject1);
            localObject1 = this.ndX;
            if (localObject6.containsKey("bitrate")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
            localObject1 = this.ndX;
            if (localObject6.containsKey("i-frame-interval")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).fQr = i;
            localObject1 = this.ndX;
            if (localObject6.containsKey("frame-rate")) {
              continue;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
            this.ndX.eWL = SightVideoJNI.getMp4Rotate(str1);
          }
          if (localObject5 != null)
          {
            localObject4 = this.ndX;
            if (localObject5.containsKey("mime")) {
              continue;
            }
            localObject1 = "";
            ((GalleryItem.VideoMediaItem)localObject4).fQp = ((String)localObject1);
          }
        }
        ab.d("MicroMsg.AlbumAdapter", "mediaItem format:%s, videoPath:%s", new Object[] { localObject6, str1 });
        localMediaExtractor.release();
      }
      catch (Exception localException)
      {
        Object localObject1;
        MediaFormat localMediaFormat;
        String str2;
        ab.d("MicroMsg.AlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { str1, localException.getMessage() });
        localMediaExtractor.release();
        continue;
      }
      finally
      {
        localMediaExtractor.release();
        AppMethodBeat.o(21369);
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        if (this.ndY != null) {
          this.ndY.a(this, this.ndX.fQq);
        }
        AppMethodBeat.o(21369);
        return;
        localObject5 = localObject4;
        localObject6 = localObject1;
        if (str2.startsWith("audio/"))
        {
          localObject5 = localObject4;
          localObject6 = localObject1;
          if (localObject4 == null)
          {
            localObject5 = localMediaFormat;
            localObject6 = localObject1;
            break label664;
            i = (int)(localObject6.getLong("durationUs") / 1000L);
            continue;
            i = localObject6.getInteger("height");
            continue;
            i = localObject6.getInteger("width");
            continue;
            localObject1 = localObject6.getString("mime");
            continue;
            i = localObject6.getInteger("bitrate");
            continue;
            i = localObject6.getInteger("i-frame-interval");
            continue;
            i = localObject6.getInteger("frame-rate");
            continue;
            localObject1 = localObject5.getString("mime");
            continue;
          }
        }
      }
      else
      {
        al.d(new a.c.1(this));
        AppMethodBeat.o(21369);
        return;
      }
      label650:
      label664:
      do
      {
        do
        {
          i += 1;
          localObject4 = localObject7;
          Object localObject3 = localObject8;
          break;
          localObject7 = localObject5;
          localObject8 = localObject6;
        } while (localObject5 == null);
        localObject7 = localObject5;
        localObject8 = localObject6;
      } while (localObject6 == null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.c
 * JD-Core Version:    0.7.0.1
 */