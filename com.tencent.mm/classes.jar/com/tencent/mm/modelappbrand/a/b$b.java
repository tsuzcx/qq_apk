package com.tencent.mm.modelappbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class b$b
  implements b.i
{
  public final OutputStream Db(String paramString)
  {
    AppMethodBeat.i(131342);
    try
    {
      if ((!o.aZI(b.aEn())) && (!new k(b.aEn()).isDirectory()))
      {
        o.deleteFile(b.aEn());
        o.aZI(b.aEn());
      }
      localObject = b.aEn() + paramString;
      str = (String)localObject + ".wlock";
      o.deleteFile(str);
      o.dd(str, true);
      o.f(str, new byte[1], 1);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          final String str;
          o.deleteFile((String)localObject);
          o.dd((String)localObject, true);
          Object localObject = new BufferedOutputStream(o.db((String)localObject, false))
          {
            public final void flush()
            {
              try
              {
                AppMethodBeat.i(131341);
                super.flush();
                o.deleteFile(str);
                AppMethodBeat.o(131341);
                return;
              }
              finally
              {
                localObject = finally;
                throw localObject;
              }
            }
          };
          AppMethodBeat.o(131342);
          return localObject;
        }
        catch (IOException localIOException)
        {
          ae.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", localIOException, "openWrite fileName %s, parent exists[%b]", new Object[] { paramString, Boolean.valueOf(o.fB(b.aEn())) });
          AppMethodBeat.o(131342);
        }
        localThrowable = localThrowable;
        ae.e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", new Object[] { localThrowable });
      }
    }
    return null;
  }
  
  public final boolean Dc(String paramString)
  {
    AppMethodBeat.i(131344);
    if ((!bu.isNullOrNil(paramString)) && (o.deleteFile(b.aEn() + paramString)))
    {
      AppMethodBeat.o(131344);
      return true;
    }
    AppMethodBeat.o(131344);
    return false;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(131343);
    Object localObject = b.aEn() + paramString;
    if (o.fB((String)localObject + ".wlock"))
    {
      AppMethodBeat.o(131343);
      return null;
    }
    try
    {
      localObject = o.openRead((String)localObject);
      AppMethodBeat.o(131343);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ae.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", new Object[] { paramString, localIOException });
      AppMethodBeat.o(131343);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.b
 * JD-Core Version:    0.7.0.1
 */