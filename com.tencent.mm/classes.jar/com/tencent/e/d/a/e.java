package com.tencent.e.d.a;

import android.text.TextUtils;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class e
{
  public static boolean jXg()
  {
    AppMethodBeat.i(138350);
    try
    {
      Object localObject = System.getenv("PATH");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(":");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          File localFile = new File(localObject[i], "su");
          if (localFile.exists())
          {
            new StringBuilder("SuFile found : ").append(localFile.toString());
            h.jXC();
            AppMethodBeat.o(138350);
            return true;
          }
          i += 1;
        }
      }
      if (new File("/system/bin/su").exists())
      {
        h.jXC();
        AppMethodBeat.o(138350);
        return true;
      }
      if (new File("/system/xbin/su").exists())
      {
        h.jXC();
        AppMethodBeat.o(138350);
        return true;
      }
    }
    finally
    {
      h.w(localThrowable);
      h.jXC();
      AppMethodBeat.o(138350);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.d.a.e
 * JD-Core Version:    0.7.0.1
 */