package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static boolean aJ(String paramString)
  {
    AppMethodBeat.i(93140);
    boolean bool = "audio".equals(aQ(paramString));
    AppMethodBeat.o(93140);
    return bool;
  }
  
  public static boolean aK(String paramString)
  {
    AppMethodBeat.i(93141);
    boolean bool = "video".equals(aQ(paramString));
    AppMethodBeat.o(93141);
    return bool;
  }
  
  public static boolean aL(String paramString)
  {
    AppMethodBeat.i(93142);
    boolean bool = "text".equals(aQ(paramString));
    AppMethodBeat.o(93142);
    return bool;
  }
  
  public static String aM(String paramString)
  {
    AppMethodBeat.i(93143);
    if (paramString == null)
    {
      AppMethodBeat.o(93143);
      return null;
    }
    paramString = paramString.split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = aO(paramString[i]);
      if ((str != null) && (aK(str)))
      {
        AppMethodBeat.o(93143);
        return str;
      }
      i += 1;
    }
    AppMethodBeat.o(93143);
    return null;
  }
  
  public static String aN(String paramString)
  {
    AppMethodBeat.i(93144);
    if (paramString == null)
    {
      AppMethodBeat.o(93144);
      return null;
    }
    paramString = paramString.split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = aO(paramString[i]);
      if ((str != null) && (aJ(str)))
      {
        AppMethodBeat.o(93144);
        return str;
      }
      i += 1;
    }
    AppMethodBeat.o(93144);
    return null;
  }
  
  public static String aO(String paramString)
  {
    AppMethodBeat.i(93145);
    if (paramString == null)
    {
      AppMethodBeat.o(93145);
      return null;
    }
    paramString = paramString.trim();
    if ((paramString.startsWith("avc1")) || (paramString.startsWith("avc3")))
    {
      AppMethodBeat.o(93145);
      return "video/avc";
    }
    if ((paramString.startsWith("hev1")) || (paramString.startsWith("hvc1")))
    {
      AppMethodBeat.o(93145);
      return "video/hevc";
    }
    if ((paramString.startsWith("vp9")) || (paramString.startsWith("vp09")))
    {
      AppMethodBeat.o(93145);
      return "video/x-vnd.on2.vp9";
    }
    if ((paramString.startsWith("vp8")) || (paramString.startsWith("vp08")))
    {
      AppMethodBeat.o(93145);
      return "video/x-vnd.on2.vp8";
    }
    if (paramString.startsWith("mp4a"))
    {
      AppMethodBeat.o(93145);
      return "audio/mp4a-latm";
    }
    if ((paramString.startsWith("ac-3")) || (paramString.startsWith("dac3")))
    {
      AppMethodBeat.o(93145);
      return "audio/ac3";
    }
    if ((paramString.startsWith("ec-3")) || (paramString.startsWith("dec3")))
    {
      AppMethodBeat.o(93145);
      return "audio/eac3";
    }
    if ((paramString.startsWith("dtsc")) || (paramString.startsWith("dtse")))
    {
      AppMethodBeat.o(93145);
      return "audio/vnd.dts";
    }
    if ((paramString.startsWith("dtsh")) || (paramString.startsWith("dtsl")))
    {
      AppMethodBeat.o(93145);
      return "audio/vnd.dts.hd";
    }
    if (paramString.startsWith("opus"))
    {
      AppMethodBeat.o(93145);
      return "audio/opus";
    }
    if (paramString.startsWith("vorbis"))
    {
      AppMethodBeat.o(93145);
      return "audio/vorbis";
    }
    AppMethodBeat.o(93145);
    return null;
  }
  
  public static int aP(String paramString)
  {
    AppMethodBeat.i(93146);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(93146);
      return -1;
    }
    if (aJ(paramString))
    {
      AppMethodBeat.o(93146);
      return 1;
    }
    if (aK(paramString))
    {
      AppMethodBeat.o(93146);
      return 2;
    }
    if ((aL(paramString)) || ("application/cea-608".equals(paramString)) || ("application/cea-708".equals(paramString)) || ("application/x-mp4-cea-608".equals(paramString)) || ("application/x-subrip".equals(paramString)) || ("application/ttml+xml".equals(paramString)) || ("application/x-quicktime-tx3g".equals(paramString)) || ("application/x-mp4-vtt".equals(paramString)) || ("application/x-rawcc".equals(paramString)) || ("application/vobsub".equals(paramString)) || ("application/pgs".equals(paramString)) || ("application/dvbsubs".equals(paramString)))
    {
      AppMethodBeat.o(93146);
      return 3;
    }
    if (("application/id3".equals(paramString)) || ("application/x-emsg".equals(paramString)) || ("application/x-scte35".equals(paramString)) || ("application/x-camera-motion".equals(paramString)))
    {
      AppMethodBeat.o(93146);
      return 4;
    }
    AppMethodBeat.o(93146);
    return -1;
  }
  
  private static String aQ(String paramString)
  {
    AppMethodBeat.i(93147);
    if (paramString == null)
    {
      AppMethodBeat.o(93147);
      return null;
    }
    int i = paramString.indexOf('/');
    if (i == -1)
    {
      paramString = new IllegalArgumentException("Invalid mime type: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(93147);
      throw paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(93147);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.j
 * JD-Core Version:    0.7.0.1
 */