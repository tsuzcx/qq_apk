package com.tencent.mm.plugin.game.media;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.widget.ImageView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.SoftReference;

public class r
{
  private static final f<String, Bitmap> gnw;
  
  static
  {
    AppMethodBeat.i(41178);
    gnw = new b(100, r.class);
    AppMethodBeat.o(41178);
  }
  
  public static Bitmap aAa(String paramString)
  {
    AppMethodBeat.i(41176);
    Bitmap localBitmap = (Bitmap)gnw.aT(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      AppMethodBeat.o(41176);
      return localBitmap;
    }
    localBitmap = ThumbnailUtils.createVideoThumbnail(paramString, 2);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      localBitmap = ThumbnailUtils.extractThumbnail(localBitmap, 537, 402, 2);
      if ((Bitmap)gnw.put(paramString, localBitmap) == null) {}
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
  
  public static void i(final ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(41177);
    Bitmap localBitmap = (Bitmap)gnw.get(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      Log.i("MicroMsg.SimpleVideoAnalyzer", "attachVideoThumbBitmap, from cache");
      paramImageView.setImageBitmap(localBitmap);
      AppMethodBeat.o(41177);
      return;
    }
    Log.i("MicroMsg.SimpleVideoAnalyzer", "attachVideoThumbBitmap, not from cache, size = %d", new Object[] { Integer.valueOf(gnw.size()) });
    paramImageView = new SoftReference(paramImageView);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41175);
        final Bitmap localBitmap = r.aAa(this.cJK);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.r
 * JD-Core Version:    0.7.0.1
 */