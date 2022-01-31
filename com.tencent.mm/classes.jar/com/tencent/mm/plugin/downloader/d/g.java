package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import org.xwalk.core.Log;

public final class g
{
  public static Map<Integer, ByteBuffer> M(File paramFile)
  {
    AppMethodBeat.i(2321);
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isFile()))
    {
      AppMethodBeat.o(2321);
      return null;
    }
    try
    {
      Map localMap = i.A(i.P(paramFile));
      AppMethodBeat.o(2321);
      return localMap;
    }
    catch (b.b localb)
    {
      Log.e("MicroMsg.Channel.IdValueReader", "APK : " + paramFile.getAbsolutePath() + " not have apk signature block");
      AppMethodBeat.o(2321);
      return null;
    }
    catch (IOException paramFile)
    {
      label78:
      break label78;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.g
 * JD-Core Version:    0.7.0.1
 */