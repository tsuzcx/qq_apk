package com.tencent.mm.plugin.appbrand.media.record;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.IOException;

public class h
{
  private static a lsE;
  
  static
  {
    AppMethodBeat.i(175889);
    lsE = new a()
    {
      public final void cE(String paramAnonymousString)
      {
        AppMethodBeat.i(175888);
        System.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(175888);
      }
    };
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
  
  public static String OQ(String paramString)
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
  
  public static boolean OR(String paramString)
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
  
  public static boolean OS(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(146327);
    paramString = new e(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      boolean bool2;
      try
      {
        ac.i("MicroMsg.Record.AudioRecordUtil", "new audio file");
        bool2 = paramString.createNewFile();
        bool1 = bool2;
      }
      catch (IOException paramString)
      {
        ac.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
        continue;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
        continue;
      }
      AppMethodBeat.o(146327);
      return bool1;
      ac.i("MicroMsg.Record.AudioRecordUtil", "delete audio file");
      paramString.delete();
      try
      {
        bool2 = paramString.createNewFile();
        bool1 = bool2;
      }
      catch (IOException paramString)
      {
        ac.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
      }
    }
  }
  
  public static long OT(String paramString)
  {
    AppMethodBeat.i(146328);
    e locale = new e(paramString);
    long l = -1L;
    if (locale.exists())
    {
      ac.i("MicroMsg.Record.AudioRecordUtil", "exist audio file");
      l = locale.length();
    }
    for (;;)
    {
      AppMethodBeat.o(146328);
      return l;
      ac.i("MicroMsg.Record.AudioRecordUtil", "audio file not exit, path:%s", new Object[] { paramString });
    }
  }
  
  public static void a(a parama)
  {
    try
    {
      lsE = parama;
      return;
    }
    finally {}
  }
  
  public static a boT()
  {
    try
    {
      a locala = lsE;
      return locala;
    }
    finally {}
  }
  
  public static String dR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146324);
    e locale = new e(b.aph(), "AudioRecord");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    paramString2 = new StringBuilder("audio").append(ah.dg(String.valueOf(paramString2)));
    if (!TextUtils.isEmpty(paramString1)) {
      if ("aac".equalsIgnoreCase(paramString1)) {
        paramString1 = ".m4a";
      }
    }
    for (;;)
    {
      paramString1 = paramString1;
      paramString2 = new e(locale, paramString1);
      ac.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", new Object[] { paramString1, paramString2.fxW() });
      paramString1 = q.B(paramString2.fxV());
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
    public abstract void cE(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.h
 * JD-Core Version:    0.7.0.1
 */