package com.tencent.mm.modelappbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class b$a
  implements b.g
{
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(77322);
    Object localObject = b.acE() + paramString;
    if (com.tencent.mm.vfs.e.cN((String)localObject + ".wlock"))
    {
      AppMethodBeat.o(77322);
      return null;
    }
    try
    {
      localObject = com.tencent.mm.vfs.e.openRead((String)localObject);
      AppMethodBeat.o(77322);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ab.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", new Object[] { paramString, localIOException });
      AppMethodBeat.o(77322);
    }
    return null;
  }
  
  public final OutputStream qC(String paramString)
  {
    AppMethodBeat.i(77321);
    try
    {
      if ((!com.tencent.mm.vfs.e.um(b.acE())) && (!new com.tencent.mm.vfs.b(b.acE()).isDirectory()))
      {
        com.tencent.mm.vfs.e.deleteFile(b.acE());
        com.tencent.mm.vfs.e.um(b.acE());
      }
      localObject = b.acE() + paramString;
      str = (String)localObject + ".wlock";
      com.tencent.mm.vfs.e.deleteFile(str);
      com.tencent.mm.vfs.e.O(str, true);
      com.tencent.mm.vfs.e.b(str, new byte[1], 1);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          String str;
          com.tencent.mm.vfs.e.deleteFile((String)localObject);
          com.tencent.mm.vfs.e.O((String)localObject, true);
          Object localObject = new b.a.1(this, com.tencent.mm.vfs.e.M((String)localObject, false), str);
          AppMethodBeat.o(77321);
          return localObject;
        }
        catch (IOException localIOException)
        {
          ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", localIOException, "openWrite fileName %s, parent exists[%b]", new Object[] { paramString, Boolean.valueOf(com.tencent.mm.vfs.e.cN(b.acE())) });
          AppMethodBeat.o(77321);
        }
        localThrowable = localThrowable;
        ab.e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", new Object[] { localThrowable });
      }
    }
    return null;
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(77323);
    if ((!bo.isNullOrNil(paramString)) && (com.tencent.mm.a.e.deleteFile(b.acE() + paramString)))
    {
      AppMethodBeat.o(77323);
      return true;
    }
    AppMethodBeat.o(77323);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.a
 * JD-Core Version:    0.7.0.1
 */