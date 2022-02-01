package com.tencent.midas.comm.log.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Comparator;

final class APLogFileUtil$2
  implements Comparator<File>
{
  private int extractNumber(String paramString)
  {
    AppMethodBeat.i(254064);
    try
    {
      i = Integer.parseInt(paramString.substring(paramString.indexOf('_') + 1, paramString.lastIndexOf('.')));
      AppMethodBeat.o(254064);
      return i;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public final int compare(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(254062);
    int i = extractNumber(paramFile1.getName());
    int j = extractNumber(paramFile2.getName());
    AppMethodBeat.o(254062);
    return i - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.midas.comm.log.util.APLogFileUtil.2
 * JD-Core Version:    0.7.0.1
 */