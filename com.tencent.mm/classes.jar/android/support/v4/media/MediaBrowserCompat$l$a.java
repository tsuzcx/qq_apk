package android.support.v4.media;

import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

class MediaBrowserCompat$l$a
  implements a.c
{
  MediaBrowserCompat$l$a(MediaBrowserCompat.l paraml) {}
  
  public final void k(List<?> paramList)
  {
    if (this.BP.BO == null) {}
    for (Object localObject1 = null; localObject1 == null; localObject1 = (MediaBrowserCompat.k)this.BP.BO.get())
    {
      MediaBrowserCompat.MediaItem.j(paramList);
      return;
    }
    paramList = MediaBrowserCompat.MediaItem.j(paramList);
    List localList = ((MediaBrowserCompat.k)localObject1).fT;
    localObject1 = ((MediaBrowserCompat.k)localObject1).BM;
    int i = 0;
    label63:
    int j;
    int m;
    int k;
    if (i < localList.size())
    {
      Object localObject2 = (Bundle)((List)localObject1).get(i);
      if ((localObject2 != null) && (paramList != null))
      {
        j = ((Bundle)localObject2).getInt("android.media.browse.extra.PAGE", -1);
        int n = ((Bundle)localObject2).getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if ((j != -1) || (n != -1))
        {
          m = n * j;
          k = m + n;
          if ((j >= 0) && (n > 0) && (m < paramList.size())) {
            break label171;
          }
          localObject2 = Collections.EMPTY_LIST;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label63;
      break;
      label171:
      j = k;
      if (k > paramList.size()) {
        j = paramList.size();
      }
      paramList.subList(m, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.l.a
 * JD-Core Version:    0.7.0.1
 */