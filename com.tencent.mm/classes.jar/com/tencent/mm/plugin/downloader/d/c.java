package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public final class c
{
  public static boolean JB(String paramString)
  {
    AppMethodBeat.i(2312);
    try
    {
      boolean bool = b.JA(paramString);
      AppMethodBeat.o(2312);
      return bool;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.Channel.ChannelReader", "isV2ChannelApk error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(2312);
    }
    return false;
  }
  
  public static String K(File paramFile)
  {
    AppMethodBeat.i(2310);
    try
    {
      ab.i("MicroMsg.Channel.ChannelReader", "get channel by v1");
      Object localObject = j.JC(paramFile.getAbsolutePath());
      if (localObject == null)
      {
        AppMethodBeat.o(2310);
        return null;
      }
      f localf = new f();
      localf.D((byte[])localObject);
      localObject = localf.kXE.getProperty("channelId");
      AppMethodBeat.o(2310);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Channel.ChannelReader", "APK : %s not have channel info from zip comment", new Object[] { paramFile.getAbsolutePath() });
      AppMethodBeat.o(2310);
    }
    return null;
  }
  
  public static String L(File paramFile)
  {
    AppMethodBeat.i(2311);
    ab.i("MicroMsg.Channel.ChannelReader", "get channel by v2");
    if ((!paramFile.exists()) || (!paramFile.isFile())) {
      paramFile = null;
    }
    while (paramFile == null)
    {
      AppMethodBeat.o(2311);
      return null;
      if ((!paramFile.exists()) || (!paramFile.isFile())) {
        paramFile = null;
      }
      for (;;)
      {
        if (paramFile == null) {
          break label132;
        }
        localObject = paramFile.array();
        int i = paramFile.arrayOffset();
        int j = paramFile.position();
        int k = paramFile.arrayOffset();
        paramFile = Arrays.copyOfRange((byte[])localObject, i + j, paramFile.limit() + k);
        break;
        paramFile = g.M(paramFile);
        if (paramFile != null) {
          paramFile = (ByteBuffer)paramFile.get(Integer.valueOf(1903261812));
        } else {
          paramFile = null;
        }
      }
      label132:
      paramFile = null;
    }
    Object localObject = new f();
    ((f)localObject).D(paramFile);
    paramFile = ((f)localObject).kXE.getProperty("channelId");
    AppMethodBeat.o(2311);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.c
 * JD-Core Version:    0.7.0.1
 */