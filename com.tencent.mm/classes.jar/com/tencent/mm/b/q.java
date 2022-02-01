package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;

public final class q
{
  public static String k(String paramString, boolean paramBoolean)
  {
    try
    {
      String str2 = o.k(paramString, paramBoolean);
      String str1 = paramString;
      if (str2 != null)
      {
        ae.i("MicroMsg.VFSFileOpEx", "exportExternalPath:%s to realPath:%s", new Object[] { paramString, str2 });
        str1 = str2;
      }
      return str1;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.VFSFileOpEx", localThrowable, "exportExternalPath failed", new Object[0]);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.b.q
 * JD-Core Version:    0.7.0.1
 */