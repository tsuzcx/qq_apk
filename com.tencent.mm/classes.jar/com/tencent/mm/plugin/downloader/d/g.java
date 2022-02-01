package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.RandomAccessFile;

public final class g
{
  private static final com.tencent.mm.d.k cSX;
  
  static
  {
    AppMethodBeat.i(88881);
    cSX = new com.tencent.mm.d.k(101010256L);
    AppMethodBeat.o(88881);
  }
  
  public static byte[] aaT(String paramString)
  {
    AppMethodBeat.i(88880);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(88880);
      return null;
    }
    RandomAccessFile localRandomAccessFile1 = o.dg(paramString, false);
    if (localRandomAccessFile1.length() == 0L)
    {
      localRandomAccessFile1.close();
      ae.i("MicroMsg.Channel.ZipEocdCommentTool", "apk file length is zero");
      AppMethodBeat.o(88880);
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = new com.tencent.mm.vfs.k(paramString);
        localRandomAccessFile2 = o.dg(w.B(paramString.mUri), false);
        localRandomAccessFile2.seek(((Long)e.H(paramString).second).longValue() + 22L - 2L);
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
        ae.e("MicroMsg.Channel.ZipEocdCommentTool", "readComment, error: %s", new Object[] { paramString.getMessage() });
        paramString = null;
        continue;
      }
      localRandomAccessFile1.close();
      AppMethodBeat.o(88880);
      return paramString;
      paramString = new byte[i];
      localRandomAccessFile2.read(paramString);
      localRandomAccessFile2.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.g
 * JD-Core Version:    0.7.0.1
 */