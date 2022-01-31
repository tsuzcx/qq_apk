package com.tencent.mm.plugin.downloader.c;

import android.util.Pair;
import com.tencent.mm.c.k;
import com.tencent.mm.c.l;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.RandomAccessFile;

public final class j
{
  private static final k bvu = new k(101010256L);
  
  public static byte[] zG(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(paramString, "r");
    if (localRandomAccessFile1.length() == 0L)
    {
      localRandomAccessFile1.close();
      y.i("MicroMsg.Channel.ZipEocdCommentTool", "apk file length is zero");
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = new File(paramString);
        localRandomAccessFile2 = new RandomAccessFile(paramString, "rw");
        localRandomAccessFile2.seek(((Long)h.F(paramString).second).longValue() + 22L - 2L);
        paramString = new byte[2];
        localRandomAccessFile2.readFully(paramString);
        i = new l(paramString).value;
        if (i != 0) {
          continue;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        RandomAccessFile localRandomAccessFile2;
        int i;
        y.e("MicroMsg.Channel.ZipEocdCommentTool", "readComment, error: %s", new Object[] { paramString.getMessage() });
        paramString = null;
        continue;
      }
      localRandomAccessFile1.close();
      return paramString;
      paramString = new byte[i];
      localRandomAccessFile2.read(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.j
 * JD-Core Version:    0.7.0.1
 */