package com.tencent.mm.modelappbrand.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class b$a
  implements b.g
{
  public final OutputStream jI(String paramString)
  {
    Object localObject = b.JE() + paramString;
    String str = (String)localObject + ".wlock";
    com.tencent.mm.vfs.e.b(str, new byte[1], 1);
    try
    {
      localObject = new b.a.1(this, new FileOutputStream((String)localObject), str);
      return localObject;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", localIOException, "openWrite fileName %s", new Object[] { paramString });
    }
    return null;
  }
  
  public final boolean jJ(String paramString)
  {
    return (!bk.bl(paramString)) && (com.tencent.mm.a.e.deleteFile(b.JE() + paramString));
  }
  
  public final InputStream openRead(String paramString)
  {
    Object localObject = b.JE() + paramString;
    if (com.tencent.mm.vfs.e.bK((String)localObject + ".wlock")) {
      return null;
    }
    try
    {
      localObject = new FileInputStream((String)localObject);
      return localObject;
    }
    catch (IOException localIOException)
    {
      y.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", new Object[] { paramString, localIOException });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.a
 * JD-Core Version:    0.7.0.1
 */