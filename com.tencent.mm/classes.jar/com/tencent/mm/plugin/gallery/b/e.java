package com.tencent.mm.plugin.gallery.b;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.y;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/utils/HdrUtil;", "", "()V", "findVideoMediaFormat", "Landroid/media/MediaFormat;", "mediaExtractor", "Landroid/media/MediaExtractor;", "getVideoEncodingProfile", "Lkotlin/Pair;", "", "", "videoFilePath", "isHdrVideo", "", "path", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e HRe;
  
  static
  {
    AppMethodBeat.i(289304);
    HRe = new e();
    AppMethodBeat.o(289304);
  }
  
  private static MediaFormat a(MediaExtractor paramMediaExtractor)
  {
    AppMethodBeat.i(289297);
    int k = paramMediaExtractor.getTrackCount();
    if (k > 0) {}
    int j;
    label97:
    label107:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      s.s(localMediaFormat, "mediaExtractor.getTrackFormat(i)");
      if (localMediaFormat.containsKey("mime"))
      {
        String str = localMediaFormat.getString("mime");
        if ((str != null) && (n.a((CharSequence)str, (CharSequence)"video", true) == true))
        {
          i = 1;
          if (i == 0) {
            break label97;
          }
        }
      }
      for (paramMediaExtractor = localMediaFormat;; paramMediaExtractor = null)
      {
        AppMethodBeat.o(289297);
        return paramMediaExtractor;
        i = 0;
        break;
        if (j < k) {
          break label107;
        }
      }
    }
  }
  
  public static boolean aFe(String paramString)
  {
    AppMethodBeat.i(289274);
    s.u(paramString, "path");
    try
    {
      localObject = Result.Companion;
      paramString = Result.constructor-impl(aFf(paramString));
      r localr = new r(null, Integer.valueOf(-1));
      localObject = paramString;
      if (Result.isFailure-impl(paramString)) {
        localObject = localr;
      }
      paramString = (r)localObject;
      if (n.T("video/hevc", (String)paramString.bsC, true)) {
        if (((Number)paramString.bsD).intValue() == 1)
        {
          AppMethodBeat.o(289274);
          return true;
        }
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject = Result.Companion;
        paramString = Result.constructor-impl(ResultKt.createFailure(paramString));
      }
      AppMethodBeat.o(289274);
      return false;
    }
    if (n.T("video/avc", (String)paramString.bsC, true))
    {
      if (((Number)paramString.bsD).intValue() != 16)
      {
        AppMethodBeat.o(289274);
        return true;
      }
      AppMethodBeat.o(289274);
      return false;
    }
    AppMethodBeat.o(289274);
    return true;
  }
  
  private static r<String, Integer> aFf(String paramString)
  {
    AppMethodBeat.i(289285);
    Object localObject2 = null;
    Object localObject3 = y.n(paramString, false);
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    if (!new File((String)localObject1).canRead())
    {
      paramString = new RuntimeException(s.X("Unable to read ", paramString));
      AppMethodBeat.o(289285);
      throw paramString;
    }
    localObject1 = new MediaExtractor();
    for (;;)
    {
      try
      {
        ((MediaExtractor)localObject1).setDataSource(paramString);
        localObject3 = a((MediaExtractor)localObject1);
        if (localObject3 == null) {
          break label175;
        }
        if (((MediaFormat)localObject3).containsKey("profile"))
        {
          i = ((MediaFormat)localObject3).getInteger("profile");
          j = i;
          paramString = localObject2;
          if (((MediaFormat)localObject3).containsKey("mime"))
          {
            paramString = ((MediaFormat)localObject3).getString("mime");
            j = i;
          }
          ((MediaExtractor)localObject1).release();
          paramString = v.Y(paramString, Integer.valueOf(j));
          AppMethodBeat.o(289285);
          return paramString;
        }
      }
      catch (Exception localException)
      {
        paramString = new RuntimeException(s.X("Unable to set source ", paramString));
        AppMethodBeat.o(289285);
        throw paramString;
      }
      int i = -1;
      continue;
      label175:
      int j = -1;
      paramString = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.b.e
 * JD-Core Version:    0.7.0.1
 */