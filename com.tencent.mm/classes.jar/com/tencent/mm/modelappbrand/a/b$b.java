package com.tencent.mm.modelappbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class b$b
  implements b.i
{
  public final OutputStream Te(String paramString)
  {
    AppMethodBeat.i(131342);
    try
    {
      if ((!u.bBD(b.bhj())) && (!new q(b.bhj()).isDirectory()))
      {
        u.deleteFile(b.bhj());
        u.bBD(b.bhj());
      }
      localObject = b.bhj() + paramString;
      str = (String)localObject + ".wlock";
      u.deleteFile(str);
      u.dK(str, true);
      u.H(str, new byte[1]);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          final String str;
          u.deleteFile((String)localObject);
          u.dK((String)localObject, true);
          Object localObject = new BufferedOutputStream(u.Te((String)localObject))
          {
            public final void flush()
            {
              try
              {
                AppMethodBeat.i(131341);
                super.flush();
                u.deleteFile(str);
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
          Log.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", localIOException, "openWrite fileName %s, parent exists[%b]", new Object[] { paramString, Boolean.valueOf(u.agG(b.bhj())) });
          AppMethodBeat.o(131342);
        }
        localThrowable = localThrowable;
        Log.e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", new Object[] { localThrowable });
      }
    }
    return null;
  }
  
  public final InputStream Tf(String paramString)
  {
    AppMethodBeat.i(131343);
    Object localObject = b.bhj() + paramString;
    if (u.agG((String)localObject + ".wlock"))
    {
      AppMethodBeat.o(131343);
      return null;
    }
    try
    {
      localObject = u.Tf((String)localObject);
      AppMethodBeat.o(131343);
      return localObject;
    }
    catch (IOException localIOException)
    {
      Log.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", new Object[] { paramString, localIOException });
      AppMethodBeat.o(131343);
    }
    return null;
  }
  
  public final boolean ho(String paramString)
  {
    AppMethodBeat.i(131344);
    if ((!Util.isNullOrNil(paramString)) && (u.deleteFile(b.bhj() + paramString)))
    {
      AppMethodBeat.o(131344);
      return true;
    }
    AppMethodBeat.o(131344);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.b
 * JD-Core Version:    0.7.0.1
 */