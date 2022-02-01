package com.tencent.mm.plugin.appbrand.media.record;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.IOException;

public class h
{
  private static h.a tiW;
  
  static
  {
    AppMethodBeat.i(175889);
    tiW = new h.1();
    AppMethodBeat.o(175889);
  }
  
  public static short[] E(byte[] paramArrayOfByte, int paramInt)
  {
    short[] arrayOfShort = new short[paramInt / 2];
    paramInt = 0;
    while (paramInt < arrayOfShort.length)
    {
      arrayOfShort[paramInt] = ((short)(paramArrayOfByte[(paramInt * 2)] & 0xFF | (paramArrayOfByte[(paramInt * 2 + 1)] & 0xFF) << 8));
      paramInt += 1;
    }
    return arrayOfShort;
  }
  
  public static void a(h.a parama)
  {
    try
    {
      tiW = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static String adG(String paramString)
  {
    AppMethodBeat.i(146325);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(146325);
      return "";
    }
    if ("aac".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(146325);
      return "m4a";
    }
    if ("mp3".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(146325);
      return "mp3";
    }
    if ("wav".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(146325);
      return "wav";
    }
    if ("pcm".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(146325);
      return "pcm";
    }
    AppMethodBeat.o(146325);
    return "";
  }
  
  public static boolean adH(String paramString)
  {
    AppMethodBeat.i(146326);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(146326);
      return false;
    }
    if ("aac".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(146326);
      return true;
    }
    if ("mp3".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(146326);
      return true;
    }
    if ("wav".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(146326);
      return true;
    }
    if ("pcm".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(146326);
      return true;
    }
    AppMethodBeat.o(146326);
    return false;
  }
  
  public static boolean adI(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(146327);
    paramString = new u(paramString);
    if (!paramString.jKS()) {}
    for (;;)
    {
      boolean bool2;
      try
      {
        Log.i("MicroMsg.Record.AudioRecordUtil", "new audio file");
        bool2 = paramString.jKZ();
        bool1 = bool2;
      }
      catch (IOException paramString)
      {
        Log.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
        continue;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
        continue;
      }
      AppMethodBeat.o(146327);
      return bool1;
      Log.i("MicroMsg.Record.AudioRecordUtil", "delete audio file");
      paramString.diJ();
      try
      {
        bool2 = paramString.jKZ();
        bool1 = bool2;
      }
      catch (IOException paramString)
      {
        Log.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
      }
    }
  }
  
  public static long adJ(String paramString)
  {
    AppMethodBeat.i(146328);
    u localu = new u(paramString);
    long l = -1L;
    if (localu.jKS())
    {
      Log.i("MicroMsg.Record.AudioRecordUtil", "exist audio file");
      l = localu.length();
    }
    for (;;)
    {
      AppMethodBeat.o(146328);
      return l;
      Log.i("MicroMsg.Record.AudioRecordUtil", "audio file not exit, path:%s", new Object[] { paramString });
    }
  }
  
  public static h.a cBQ()
  {
    try
    {
      h.a locala = tiW;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String eY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146324);
    u localu = new u(b.bmz(), "AudioRecord");
    if (!localu.jKS()) {
      localu.jKY();
    }
    paramString2 = new StringBuilder("audio").append(MD5Util.getMD5String(String.valueOf(paramString2)));
    if (!TextUtils.isEmpty(paramString1)) {
      if ("aac".equalsIgnoreCase(paramString1)) {
        paramString1 = ".m4a";
      }
    }
    for (;;)
    {
      paramString1 = paramString1;
      paramString2 = new u(localu, paramString1);
      Log.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", new Object[] { paramString1, paramString2.jKU() });
      paramString1 = ah.v(paramString2.jKT());
      AppMethodBeat.o(146324);
      return paramString1;
      if ("mp3".equalsIgnoreCase(paramString1)) {
        paramString1 = ".mp3";
      } else if ("wav".equalsIgnoreCase(paramString1)) {
        paramString1 = ".wav";
      } else {
        paramString1 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.h
 * JD-Core Version:    0.7.0.1
 */