package com.facebook.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ImageDownloader$CacheReadWorkItem
  implements Runnable
{
  private boolean allowCachedRedirects;
  private Context context;
  private ImageDownloader.RequestKey key;
  
  ImageDownloader$CacheReadWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey, boolean paramBoolean)
  {
    this.context = paramContext;
    this.key = paramRequestKey;
    this.allowCachedRedirects = paramBoolean;
  }
  
  public void run()
  {
    AppMethodBeat.i(72370);
    ImageDownloader.access$100(this.key, this.context, this.allowCachedRedirects);
    AppMethodBeat.o(72370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.ImageDownloader.CacheReadWorkItem
 * JD-Core Version:    0.7.0.1
 */