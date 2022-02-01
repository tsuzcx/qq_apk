package com.tencent.liteapp.d;

import android.text.TextUtils;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c
{
  public static boolean ev(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(219062);
    if (TextUtils.isEmpty(paramString))
    {
      b.w("WxaLiteApp.FileUtil", "deleteFolder fail. path is null.", new Object[0]);
      AppMethodBeat.o(219062);
      return false;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      if (!paramString.isFile()) {
        break label67;
      }
      paramString.delete();
    }
    for (;;)
    {
      AppMethodBeat.o(219062);
      return true;
      label67:
      File[] arrayOfFile = paramString.listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        if (i < j)
        {
          File localFile = arrayOfFile[i];
          if (localFile.isDirectory()) {
            ev(localFile.getPath());
          }
          for (;;)
          {
            i += 1;
            break;
            localFile.delete();
          }
        }
      }
      paramString.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.d.c
 * JD-Core Version:    0.7.0.1
 */