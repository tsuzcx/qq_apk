package com.tencent.mm.plugin.game.media;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.SoftReference;

public class t
{
  private static final f<String, Bitmap> ltC;
  
  static
  {
    AppMethodBeat.i(41178);
    ltC = new b(100, t.class);
    AppMethodBeat.o(41178);
  }
  
  public static Bitmap aGA(String paramString)
  {
    AppMethodBeat.i(41176);
    Bitmap localBitmap = (Bitmap)ltC.ct(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      AppMethodBeat.o(41176);
      return localBitmap;
    }
    localBitmap = ThumbnailUtils.createVideoThumbnail(paramString, 2);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      localBitmap = ThumbnailUtils.extractThumbnail(localBitmap, 537, 402, 2);
      if ((Bitmap)ltC.put(paramString, localBitmap) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.SimpleVideoAnalyzer", "createVideoThumbail, too big size = %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(41176);
        return localBitmap;
      }
    }
    AppMethodBeat.o(41176);
    return null;
  }
  
  public static void m(final ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(41177);
    Bitmap localBitmap = (Bitmap)ltC.get(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      Log.i("MicroMsg.SimpleVideoAnalyzer", "attachVideoThumbBitmap, from cache");
      paramImageView.setImageBitmap(localBitmap);
      AppMethodBeat.o(41177);
      return;
    }
    Log.i("MicroMsg.SimpleVideoAnalyzer", "attachVideoThumbBitmap, not from cache, size = %d", new Object[] { Integer.valueOf(ltC.size()) });
    paramImageView = new SoftReference(paramImageView);
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41175);
        final Bitmap localBitmap = t.aGA(t.this);
        if ((localBitmap != null) && (!localBitmap.isRecycled()) && (paramImageView != null))
        {
          final ImageView localImageView = (ImageView)paramImageView.get();
          if (localImageView != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(41174);
                localImageView.setImageBitmap(localBitmap);
                AppMethodBeat.o(41174);
              }
            });
          }
        }
        AppMethodBeat.o(41175);
      }
    });
    AppMethodBeat.o(41177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.t
 * JD-Core Version:    0.7.0.1
 */