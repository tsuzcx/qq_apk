package com.tencent.mm.plugin.appbrand.media.record;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import java.io.File;
import java.io.IOException;

public final class h
{
  public static final String ipR = b.eQz;
  
  public static short[] C(byte[] paramArrayOfByte, int paramInt)
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
  
  public static String DC(String paramString)
  {
    AppMethodBeat.i(105636);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(105636);
      return "";
    }
    if ("aac".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105636);
      return "m4a";
    }
    if ("mp3".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105636);
      return "mp3";
    }
    if ("wav".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105636);
      return "wav";
    }
    AppMethodBeat.o(105636);
    return "";
  }
  
  public static boolean DD(String paramString)
  {
    AppMethodBeat.i(105637);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(105637);
      return false;
    }
    if ("aac".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105637);
      return true;
    }
    if ("mp3".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105637);
      return true;
    }
    if ("wav".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105637);
      return false;
    }
    if ("pcm".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105637);
      return false;
    }
    AppMethodBeat.o(105637);
    return false;
  }
  
  public static boolean DE(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(105638);
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      boolean bool2;
      try
      {
        ab.i("MicroMsg.Record.AudioRecordUtil", "new audio file");
        bool2 = paramString.createNewFile();
        bool1 = bool2;
      }
      catch (IOException paramString)
      {
        ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
        continue;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
        continue;
      }
      AppMethodBeat.o(105638);
      return bool1;
      ab.i("MicroMsg.Record.AudioRecordUtil", "delete audio file");
      paramString.delete();
      try
      {
        bool2 = paramString.createNewFile();
        bool1 = bool2;
      }
      catch (IOException paramString)
      {
        ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
      }
    }
  }
  
  public static long DF(String paramString)
  {
    AppMethodBeat.i(105639);
    File localFile = new File(paramString);
    long l = -1L;
    if (localFile.exists())
    {
      ab.i("MicroMsg.Record.AudioRecordUtil", "exist audio file");
      l = localFile.length();
    }
    for (;;)
    {
      AppMethodBeat.o(105639);
      return l;
      ab.i("MicroMsg.Record.AudioRecordUtil", "audio file not exit, path:%s", new Object[] { paramString });
    }
  }
  
  public static String cI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(105635);
    File localFile = new File(ipR, "AudioRecord");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString2 = new StringBuilder("audio").append(ag.cE(String.valueOf(paramString2)));
    if (!TextUtils.isEmpty(paramString1)) {
      if ("aac".equalsIgnoreCase(paramString1)) {
        paramString1 = ".m4a";
      }
    }
    for (;;)
    {
      paramString1 = paramString1;
      paramString2 = new File(localFile, paramString1);
      ab.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", new Object[] { paramString1, paramString2.getAbsoluteFile() });
      paramString1 = paramString2.getAbsolutePath();
      AppMethodBeat.o(105635);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.h
 * JD-Core Version:    0.7.0.1
 */