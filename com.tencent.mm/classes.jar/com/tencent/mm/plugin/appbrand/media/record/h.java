package com.tencent.mm.plugin.appbrand.media.record;

import android.text.TextUtils;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;

public final class h
{
  public static final String gOg = b.bkH;
  
  public static short[] B(byte[] paramArrayOfByte, int paramInt)
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
  
  public static String bT(String paramString1, String paramString2)
  {
    File localFile = new File(gOg, "AudioRecord");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString2 = new StringBuilder("audio").append(ad.bB(paramString2));
    if (!TextUtils.isEmpty(paramString1)) {
      if ("aac".equalsIgnoreCase(paramString1)) {
        paramString1 = ".m4a";
      }
    }
    for (;;)
    {
      paramString1 = paramString1;
      paramString2 = new File(localFile, paramString1);
      y.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", new Object[] { paramString1, paramString2.getAbsoluteFile() });
      return paramString2.getAbsolutePath();
      if ("mp3".equalsIgnoreCase(paramString1)) {
        paramString1 = ".mp3";
      } else if ("wav".equalsIgnoreCase(paramString1)) {
        paramString1 = ".wav";
      } else {
        paramString1 = "";
      }
    }
  }
  
  public static String vg(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ("aac".equalsIgnoreCase(paramString)) {
      return "m4a";
    }
    if ("mp3".equalsIgnoreCase(paramString)) {
      return "mp3";
    }
    if ("wav".equalsIgnoreCase(paramString)) {
      return "wav";
    }
    return "";
  }
  
  public static boolean vh(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ("aac".equalsIgnoreCase(paramString)) {
        return true;
      }
      if ("mp3".equalsIgnoreCase(paramString)) {
        return true;
      }
    } while (!"wav".equalsIgnoreCase(paramString));
    return false;
  }
  
  public static boolean vi(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (!paramString.exists()) {
      try
      {
        y.i("MicroMsg.Record.AudioRecordUtil", "new audio file");
        bool = paramString.createNewFile();
        return bool;
      }
      catch (IOException paramString)
      {
        y.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
        return false;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
        return false;
      }
    }
    y.i("MicroMsg.Record.AudioRecordUtil", "delete audio file");
    paramString.delete();
    try
    {
      bool = paramString.createNewFile();
      return bool;
    }
    catch (IOException paramString)
    {
      y.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
      return false;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
    }
    return false;
  }
  
  public static long vj(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      y.i("MicroMsg.Record.AudioRecordUtil", "exist audio file");
      return localFile.length();
    }
    y.i("MicroMsg.Record.AudioRecordUtil", "audio file not exit, path:%s", new Object[] { paramString });
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.h
 * JD-Core Version:    0.7.0.1
 */