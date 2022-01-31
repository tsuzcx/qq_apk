package android.support.v4.media;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

final class MediaBrowserCompat$k
{
  final List<Bundle> BM = new ArrayList();
  final List<MediaBrowserCompat.l> fT = new ArrayList();
  
  public final MediaBrowserCompat.l d(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(paramContext.getClassLoader());
    }
    int i = 0;
    while (i < this.BM.size())
    {
      if (c.a((Bundle)this.BM.get(i), paramBundle)) {
        return (MediaBrowserCompat.l)this.fT.get(i);
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.k
 * JD-Core Version:    0.7.0.1
 */