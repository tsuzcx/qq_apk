package com.tencent.d.d.a;

import android.text.TextUtils;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class e
{
  public static boolean fme()
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
            h.fmy();
            AppMethodBeat.o(138350);
            return true;
          }
          i += 1;
        }
      }
      if (new File("/system/bin/su").exists())
      {
        h.fmy();
        AppMethodBeat.o(138350);
        return true;
      }
      if (new File("/system/xbin/su").exists())
      {
        h.fmy();
        AppMethodBeat.o(138350);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      h.w(localThrowable);
      h.fmy();
      AppMethodBeat.o(138350);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.d.a.e
 * JD-Core Version:    0.7.0.1
 */