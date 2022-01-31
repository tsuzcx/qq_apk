package com.tencent.e.d.a;

import android.text.TextUtils;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class e
{
  public static boolean dUy()
  {
    AppMethodBeat.i(114509);
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
            h.dUT();
            AppMethodBeat.o(114509);
            return true;
          }
          i += 1;
        }
      }
      if (new File("/system/bin/su").exists())
      {
        h.dUT();
        AppMethodBeat.o(114509);
        return true;
      }
      if (new File("/system/xbin/su").exists())
      {
        h.dUT();
        AppMethodBeat.o(114509);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      h.w(localThrowable);
      h.dUT();
      AppMethodBeat.o(114509);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.d.a.e
 * JD-Core Version:    0.7.0.1
 */