package com.tencent.mm.plugin.emojicapture.model;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureUtil;", "", "()V", "TAG", "", "checkVideoValid", "", "videoPath", "plugin-emojicapture_release"})
public final class f
{
  private static final String TAG = "MicroMsg.EmojiCaptureUtil";
  public static final f oKb;
  
  static
  {
    AppMethodBeat.i(190);
    oKb = new f();
    TAG = "MicroMsg.EmojiCaptureUtil";
    AppMethodBeat.o(190);
  }
  
  public static boolean Uu(String paramString)
  {
    AppMethodBeat.i(189);
    k.h(paramString, "videoPath");
    if (i.aMN(paramString) <= 0L)
    {
      AppMethodBeat.o(189);
      return false;
    }
    c localc = new c();
    for (;;)
    {
      try
      {
        localc.setDataSource(paramString);
        int i = localc.getTrackCount();
        if (i <= 0) {
          try
          {
            localc.release();
            AppMethodBeat.o(189);
            return false;
          }
          catch (Exception paramString)
          {
            ad.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
            continue;
          }
        }
        int j = localc.getTrackCount();
        i = 0;
        if (i < j)
        {
          paramString = localc.getTrackFormat(i);
          k.g(paramString, "extractor.getTrackFormat(i)");
          if ((paramString != null) && (paramString.containsKey("mime")))
          {
            paramString = paramString.getString("mime");
            if (paramString != null)
            {
              boolean bool = n.a((CharSequence)paramString, (CharSequence)"video", false);
              if (bool == true) {
                try
                {
                  localc.release();
                  AppMethodBeat.o(189);
                  return true;
                }
                catch (Exception paramString)
                {
                  ad.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
                  continue;
                }
              }
            }
          }
          i += 1;
          continue;
        }
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        ad.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid error", new Object[0]);
        try
        {
          localc.release();
        }
        catch (Exception paramString)
        {
          ad.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
        }
        continue;
      }
      finally {}
      try
      {
        localc.release();
        AppMethodBeat.o(189);
        return false;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
      }
    }
    try
    {
      localc.release();
      AppMethodBeat.o(189);
      throw paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace(TAG, (Throwable)localException, "checkVideoValid, release extractor error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.f
 * JD-Core Version:    0.7.0.1
 */