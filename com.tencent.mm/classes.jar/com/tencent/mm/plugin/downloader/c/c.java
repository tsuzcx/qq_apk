package com.tencent.mm.plugin.downloader.c;

import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public final class c
{
  public static String C(File paramFile)
  {
    try
    {
      y.i("MicroMsg.Channel.ChannelReader", "get channel by v1");
      Object localObject = j.zG(paramFile.getAbsolutePath());
      if (localObject == null) {
        return null;
      }
      f localf = new f();
      localf.u((byte[])localObject);
      localObject = localf.iON.getProperty("channelId");
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Channel.ChannelReader", "APK : %s not have channel info from zip comment", new Object[] { paramFile.getAbsolutePath() });
    }
    return null;
  }
  
  public static String D(File paramFile)
  {
    y.i("MicroMsg.Channel.ChannelReader", "get channel by v2");
    if ((!paramFile.exists()) || (!paramFile.isFile())) {
      paramFile = null;
    }
    while (paramFile == null)
    {
      return null;
      if ((!paramFile.exists()) || (!paramFile.isFile())) {
        paramFile = null;
      }
      for (;;)
      {
        if (paramFile == null) {
          break label120;
        }
        localObject = paramFile.array();
        int i = paramFile.arrayOffset();
        int j = paramFile.position();
        int k = paramFile.arrayOffset();
        paramFile = Arrays.copyOfRange((byte[])localObject, i + j, paramFile.limit() + k);
        break;
        paramFile = g.E(paramFile);
        if (paramFile != null) {
          paramFile = (ByteBuffer)paramFile.get(Integer.valueOf(1903261812));
        } else {
          paramFile = null;
        }
      }
      label120:
      paramFile = null;
    }
    Object localObject = new f();
    ((f)localObject).u(paramFile);
    return ((f)localObject).iON.getProperty("channelId");
  }
  
  public static boolean zF(String paramString)
  {
    try
    {
      boolean bool = b.zE(paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.Channel.ChannelReader", "isV2ChannelApk error: %s", new Object[] { paramString.getMessage() });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.c
 * JD-Core Version:    0.7.0.1
 */