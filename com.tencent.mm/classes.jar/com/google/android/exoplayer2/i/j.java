package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static boolean aG(String paramString)
  {
    AppMethodBeat.i(95880);
    boolean bool = "audio".equals(aL(paramString));
    AppMethodBeat.o(95880);
    return bool;
  }
  
  public static boolean aH(String paramString)
  {
    AppMethodBeat.i(95881);
    boolean bool = "video".equals(aL(paramString));
    AppMethodBeat.o(95881);
    return bool;
  }
  
  public static boolean aI(String paramString)
  {
    AppMethodBeat.i(95882);
    boolean bool = "text".equals(aL(paramString));
    AppMethodBeat.o(95882);
    return bool;
  }
  
  public static String aJ(String paramString)
  {
    AppMethodBeat.i(95883);
    if (paramString == null)
    {
      AppMethodBeat.o(95883);
      return null;
    }
    paramString = paramString.trim();
    if ((paramString.startsWith("avc1")) || (paramString.startsWith("avc3")))
    {
      AppMethodBeat.o(95883);
      return "video/avc";
    }
    if ((paramString.startsWith("hev1")) || (paramString.startsWith("hvc1")))
    {
      AppMethodBeat.o(95883);
      return "video/hevc";
    }
    if ((paramString.startsWith("vp9")) || (paramString.startsWith("vp09")))
    {
      AppMethodBeat.o(95883);
      return "video/x-vnd.on2.vp9";
    }
    if ((paramString.startsWith("vp8")) || (paramString.startsWith("vp08")))
    {
      AppMethodBeat.o(95883);
      return "video/x-vnd.on2.vp8";
    }
    if (paramString.startsWith("mp4a"))
    {
      AppMethodBeat.o(95883);
      return "audio/mp4a-latm";
    }
    if ((paramString.startsWith("ac-3")) || (paramString.startsWith("dac3")))
    {
      AppMethodBeat.o(95883);
      return "audio/ac3";
    }
    if ((paramString.startsWith("ec-3")) || (paramString.startsWith("dec3")))
    {
      AppMethodBeat.o(95883);
      return "audio/eac3";
    }
    if ((paramString.startsWith("dtsc")) || (paramString.startsWith("dtse")))
    {
      AppMethodBeat.o(95883);
      return "audio/vnd.dts";
    }
    if ((paramString.startsWith("dtsh")) || (paramString.startsWith("dtsl")))
    {
      AppMethodBeat.o(95883);
      return "audio/vnd.dts.hd";
    }
    if (paramString.startsWith("opus"))
    {
      AppMethodBeat.o(95883);
      return "audio/opus";
    }
    if (paramString.startsWith("vorbis"))
    {
      AppMethodBeat.o(95883);
      return "audio/vorbis";
    }
    AppMethodBeat.o(95883);
    return null;
  }
  
  public static int aK(String paramString)
  {
    AppMethodBeat.i(95884);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95884);
      return -1;
    }
    if (aG(paramString))
    {
      AppMethodBeat.o(95884);
      return 1;
    }
    if (aH(paramString))
    {
      AppMethodBeat.o(95884);
      return 2;
    }
    if ((aI(paramString)) || ("application/cea-608".equals(paramString)) || ("application/cea-708".equals(paramString)) || ("application/x-mp4-cea-608".equals(paramString)) || ("application/x-subrip".equals(paramString)) || ("application/ttml+xml".equals(paramString)) || ("application/x-quicktime-tx3g".equals(paramString)) || ("application/x-mp4-vtt".equals(paramString)) || ("application/x-rawcc".equals(paramString)) || ("application/vobsub".equals(paramString)) || ("application/pgs".equals(paramString)) || ("application/dvbsubs".equals(paramString)))
    {
      AppMethodBeat.o(95884);
      return 3;
    }
    if (("application/id3".equals(paramString)) || ("application/x-emsg".equals(paramString)) || ("application/x-scte35".equals(paramString)) || ("application/x-camera-motion".equals(paramString)))
    {
      AppMethodBeat.o(95884);
      return 4;
    }
    AppMethodBeat.o(95884);
    return -1;
  }
  
  private static String aL(String paramString)
  {
    AppMethodBeat.i(95885);
    if (paramString == null)
    {
      AppMethodBeat.o(95885);
      return null;
    }
    int i = paramString.indexOf('/');
    if (i == -1)
    {
      paramString = new IllegalArgumentException("Invalid mime type: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(95885);
      throw paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(95885);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i.j
 * JD-Core Version:    0.7.0.1
 */