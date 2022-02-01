package com.tencent.mm.plugin.appbrand.media.record;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.q;
import java.io.IOException;

public class h
{
  private static a qeh;
  
  static
  {
    AppMethodBeat.i(175889);
    qeh = new a()
    {
      public final void eG(String paramAnonymousString)
      {
        AppMethodBeat.i(175888);
        System.loadLibrary(paramAnonymousString);
        AppMethodBeat.o(175888);
      }
    };
    AppMethodBeat.o(175889);
  }
  
  public static short[] F(byte[] paramArrayOfByte, int paramInt)
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
      qeh = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static String akA(String paramString)
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
  
  public static boolean akB(String paramString)
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
  
  public static boolean akC(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(146327);
    paramString = new q(paramString);
    if (!paramString.ifE()) {}
    for (;;)
    {
      boolean bool2;
      try
      {
        Log.i("MicroMsg.Record.AudioRecordUtil", "new audio file");
        bool2 = paramString.ifM();
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
      paramString.cFq();
      try
      {
        bool2 = paramString.ifM();
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
  
  public static long akD(String paramString)
  {
    AppMethodBeat.i(146328);
    q localq = new q(paramString);
    long l = -1L;
    if (localq.ifE())
    {
      Log.i("MicroMsg.Record.AudioRecordUtil", "exist audio file");
      l = localq.length();
    }
    for (;;)
    {
      AppMethodBeat.o(146328);
      return l;
      Log.i("MicroMsg.Record.AudioRecordUtil", "audio file not exit, path:%s", new Object[] { paramString });
    }
  }
  
  public static a cbw()
  {
    try
    {
      a locala = qeh;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String eH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146324);
    q localq = new q(b.aSL(), "AudioRecord");
    if (!localq.ifE()) {
      localq.ifL();
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
      paramString2 = new q(localq, paramString1);
      Log.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", new Object[] { paramString1, paramString2.ifG() });
      paramString1 = paramString2.bOF();
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
    public abstract void eG(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.h
 * JD-Core Version:    0.7.0.1
 */