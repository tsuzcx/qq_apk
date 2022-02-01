package com.tencent.mm.plugin.appbrand.media.record;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public class h
{
  private static a ndQ;
  
  static
  {
    AppMethodBeat.i(175889);
    ndQ = new a()
    {
      public final void ef(String paramAnonymousString)
      {
        AppMethodBeat.i(175888);
        System.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(175888);
      }
    };
    AppMethodBeat.o(175889);
  }
  
  public static short[] G(byte[] paramArrayOfByte, int paramInt)
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
  
  public static void a(a parama)
  {
    try
    {
      ndQ = parama;
      return;
    }
    finally {}
  }
  
  public static String acG(String paramString)
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
  
  public static boolean acH(String paramString)
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
  
  public static boolean acI(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(146327);
    paramString = new o(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      boolean bool2;
      try
      {
        Log.i("MicroMsg.Record.AudioRecordUtil", "new audio file");
        bool2 = paramString.createNewFile();
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
      paramString.delete();
      try
      {
        bool2 = paramString.createNewFile();
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
  
  public static long acJ(String paramString)
  {
    AppMethodBeat.i(146328);
    o localo = new o(paramString);
    long l = -1L;
    if (localo.exists())
    {
      Log.i("MicroMsg.Record.AudioRecordUtil", "exist audio file");
      l = localo.length();
    }
    for (;;)
    {
      AppMethodBeat.o(146328);
      return l;
      Log.i("MicroMsg.Record.AudioRecordUtil", "audio file not exit, path:%s", new Object[] { paramString });
    }
  }
  
  public static a bPg()
  {
    try
    {
      a locala = ndQ;
      return locala;
    }
    finally {}
  }
  
  public static String et(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146324);
    o localo = new o(b.aKJ(), "AudioRecord");
    if (!localo.exists()) {
      localo.mkdirs();
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
      paramString2 = new o(localo, paramString1);
      Log.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", new Object[] { paramString1, paramString2.hes() });
      paramString1 = aa.z(paramString2.her());
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
  
  public static abstract interface a
  {
    public abstract void ef(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.h
 * JD-Core Version:    0.7.0.1
 */