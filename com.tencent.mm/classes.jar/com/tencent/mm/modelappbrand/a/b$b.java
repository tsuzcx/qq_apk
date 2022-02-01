package com.tencent.mm.modelappbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class b$b
  implements b.i
{
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(131343);
    Object localObject = b.aud() + paramString;
    if (i.eK((String)localObject + ".wlock"))
    {
      AppMethodBeat.o(131343);
      return null;
    }
    try
    {
      localObject = i.openRead((String)localObject);
      AppMethodBeat.o(131343);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ad.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", new Object[] { paramString, localIOException });
      AppMethodBeat.o(131343);
    }
    return null;
  }
  
  public final OutputStream vu(String paramString)
  {
    AppMethodBeat.i(131342);
    try
    {
      if ((!i.aMF(b.aud())) && (!new e(b.aud()).isDirectory()))
      {
        i.deleteFile(b.aud());
        i.aMF(b.aud());
      }
      localObject = b.aud() + paramString;
      str = (String)localObject + ".wlock";
      i.deleteFile(str);
      i.cO(str, true);
      i.f(str, new byte[1], 1);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          final String str;
          i.deleteFile((String)localObject);
          i.cO((String)localObject, true);
          Object localObject = new BufferedOutputStream(i.cM((String)localObject, false))
          {
            public final void flush()
            {
              try
              {
                AppMethodBeat.i(131341);
                super.flush();
                i.deleteFile(str);
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
          ad.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", localIOException, "openWrite fileName %s, parent exists[%b]", new Object[] { paramString, Boolean.valueOf(i.eK(b.aud())) });
          AppMethodBeat.o(131342);
        }
        localThrowable = localThrowable;
        ad.e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", new Object[] { localThrowable });
      }
    }
    return null;
  }
  
  public final boolean vv(String paramString)
  {
    AppMethodBeat.i(131344);
    if ((!bt.isNullOrNil(paramString)) && (i.deleteFile(b.aud() + paramString)))
    {
      AppMethodBeat.o(131344);
      return true;
    }
    AppMethodBeat.o(131344);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.b
 * JD-Core Version:    0.7.0.1
 */