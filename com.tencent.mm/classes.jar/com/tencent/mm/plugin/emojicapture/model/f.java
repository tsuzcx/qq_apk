package com.tencent.mm.plugin.emojicapture.model;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureUtil;", "", "()V", "TAG", "", "checkVideoValid", "", "videoPath", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final String TAG;
  public static final f ygU;
  
  static
  {
    AppMethodBeat.i(190);
    ygU = new f();
    TAG = "MicroMsg.EmojiCaptureUtil";
    AppMethodBeat.o(190);
  }
  
  public static boolean apk(String paramString)
  {
    AppMethodBeat.i(189);
    s.u(paramString, "videoPath");
    if (y.bEl(paramString) <= 0L)
    {
      AppMethodBeat.o(189);
      return false;
    }
    localc = new c();
    try
    {
      localc.setDataSource(paramString);
      i = localc.lZm.getTrackCount();
      if (i <= 0) {
        try
        {
          localc.lZm.release();
          AppMethodBeat.o(189);
          return false;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
          }
        }
      }
      k = localc.lZm.getTrackCount();
      if (k <= 0) {
        break label218;
      }
      i = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int k;
        boolean bool;
        label218:
        Log.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid error", new Object[0]);
        try
        {
          localc.lZm.release();
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
        }
      }
    }
    finally
    {
      for (;;)
      {
        int j;
        try
        {
          localc.lZm.release();
          AppMethodBeat.o(189);
          throw paramString;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "checkVideoValid, release extractor error", new Object[0]);
          continue;
        }
        int i = j;
      }
    }
    j = i + 1;
    paramString = localc.getTrackFormat(i);
    s.s(paramString, "extractor.getTrackFormat(i)");
    if (paramString.containsKey("mime"))
    {
      paramString = paramString.getString("mime");
      if (paramString != null)
      {
        bool = n.a((CharSequence)paramString, (CharSequence)"video", false);
        if (bool == true) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0) {
          try
          {
            localc.lZm.release();
            AppMethodBeat.o(189);
            return true;
            i = 0;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              Log.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
            }
          }
        }
      }
    }
    if (j >= k) {
      try
      {
        localc.lZm.release();
        AppMethodBeat.o(189);
        return false;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace(TAG, (Throwable)paramString, "checkVideoValid, release extractor error", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.f
 * JD-Core Version:    0.7.0.1
 */