package com.tencent.mm.plugin.downloader.c;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import org.xwalk.core.Log;

public final class g
{
  public static Map<Integer, ByteBuffer> E(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isFile())) {
      return null;
    }
    try
    {
      Map localMap = i.z(i.H(paramFile));
      return localMap;
    }
    catch (b.b localb)
    {
      Log.e("MicroMsg.Channel.IdValueReader", "APK : " + paramFile.getAbsolutePath() + " not have apk signature block");
      return null;
    }
    catch (IOException paramFile) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.g
 * JD-Core Version:    0.7.0.1
 */