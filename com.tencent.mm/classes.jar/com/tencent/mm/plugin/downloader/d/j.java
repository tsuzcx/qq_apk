package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.k;
import com.tencent.mm.c.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.RandomAccessFile;

public final class j
{
  private static final k bWF;
  
  static
  {
    AppMethodBeat.i(2333);
    bWF = new k(101010256L);
    AppMethodBeat.o(2333);
  }
  
  public static byte[] JC(String paramString)
  {
    AppMethodBeat.i(2332);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(2332);
      return null;
    }
    RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(paramString, "r");
    if (localRandomAccessFile1.length() == 0L)
    {
      localRandomAccessFile1.close();
      ab.i("MicroMsg.Channel.ZipEocdCommentTool", "apk file length is zero");
      AppMethodBeat.o(2332);
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = new File(paramString);
        localRandomAccessFile2 = new RandomAccessFile(paramString, "r");
        localRandomAccessFile2.seek(((Long)h.N(paramString).second).longValue() + 22L - 2L);
        paramString = new byte[2];
        localRandomAccessFile2.readFully(paramString);
        i = new l(paramString).value;
        if (i != 0) {
          continue;
        }
        localRandomAccessFile2.close();
        paramString = null;
      }
      catch (Exception paramString)
      {
        RandomAccessFile localRandomAccessFile2;
        int i;
        ab.e("MicroMsg.Channel.ZipEocdCommentTool", "readComment, error: %s", new Object[] { paramString.getMessage() });
        paramString = null;
        continue;
      }
      localRandomAccessFile1.close();
      AppMethodBeat.o(2332);
      return paramString;
      paramString = new byte[i];
      localRandomAccessFile2.read(paramString);
      localRandomAccessFile2.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.j
 * JD-Core Version:    0.7.0.1
 */