package com.tencent.d.d.a;

import android.text.TextUtils;
import com.tencent.d.f.h;
import java.io.File;

public final class e
{
  public static boolean cOJ()
  {
    label130:
    for (;;)
    {
      int i;
      try
      {
        Object localObject = System.getenv("PATH");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(":");
          int j = localObject.length;
          i = 0;
          if (i < j)
          {
            File localFile = new File(localObject[i], "su");
            if (!localFile.exists()) {
              break label130;
            }
            h.i("SuFile found : " + localFile.toString());
            return true;
          }
        }
        else
        {
          if (!new File("/system/bin/su").exists()) {
            break label108;
          }
          h.i("SuFile found : /system/bin/su");
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        h.l(localThrowable);
        h.i("SuFile not found");
        return false;
      }
      label108:
      if (new File("/system/xbin/su").exists())
      {
        h.i("SuFile found : /system/xbin/su");
        return true;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.d.d.a.e
 * JD-Core Version:    0.7.0.1
 */