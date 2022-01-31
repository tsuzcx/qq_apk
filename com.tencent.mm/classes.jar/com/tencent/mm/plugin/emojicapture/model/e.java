package com.tencent.mm.plugin.emojicapture.model;

import a.f.b.j;
import a.l;
import a.l.m;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureUtil;", "", "()V", "TAG", "", "checkVideoValid", "", "videoPath", "plugin-emojicapture_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiCaptureUtil";
  public static final e lty;
  
  static
  {
    AppMethodBeat.i(2616);
    lty = new e();
    TAG = "MicroMsg.EmojiCaptureUtil";
    AppMethodBeat.o(2616);
  }
  
  public static boolean Lo(String paramString)
  {
    AppMethodBeat.i(2615);
    j.q(paramString, "videoPath");
    if (com.tencent.mm.vfs.e.avI(paramString) <= 0L)
    {
      AppMethodBeat.o(2615);
      return false;
    }
    MediaExtractor localMediaExtractor = new MediaExtractor();
    for (;;)
    {
      try
      {
        localMediaExtractor.setDataSource(paramString);
        int i = localMediaExtractor.getTrackCount();
        if (i <= 0) {
          try
          {
            localMediaExtractor.release();
            AppMethodBeat.o(2615);
            return false;
          }
          catch (Exception paramString)
          {
            ab.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
            continue;
          }
        }
        int j = localMediaExtractor.getTrackCount();
        i = 0;
        if (i < j)
        {
          paramString = localMediaExtractor.getTrackFormat(i);
          if ((paramString != null) && (paramString.containsKey("mime")))
          {
            paramString = paramString.getString("mime");
            if (paramString != null)
            {
              boolean bool = m.d((CharSequence)paramString, (CharSequence)"video");
              if (bool == true) {
                try
                {
                  localMediaExtractor.release();
                  AppMethodBeat.o(2615);
                  return true;
                }
                catch (Exception paramString)
                {
                  ab.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
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
        ab.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid error", new Object[0]);
        try
        {
          localMediaExtractor.release();
        }
        catch (Exception paramString)
        {
          ab.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
        }
        continue;
      }
      finally {}
      try
      {
        localMediaExtractor.release();
        AppMethodBeat.o(2615);
        return false;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
      }
    }
    try
    {
      localMediaExtractor.release();
      AppMethodBeat.o(2615);
      throw paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace(TAG, (Throwable)localException, "checkVideoValid, release extractor error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.e
 * JD-Core Version:    0.7.0.1
 */