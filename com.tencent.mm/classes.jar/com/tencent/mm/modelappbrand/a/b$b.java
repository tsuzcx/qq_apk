package com.tencent.mm.modelappbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class b$b
  implements b.i
{
  public final OutputStream Lg(String paramString)
  {
    AppMethodBeat.i(131342);
    try
    {
      if ((!y.bDX(b.bFa())) && (!new u(b.bFa()).isDirectory()))
      {
        y.deleteFile(b.bFa());
        y.bDX(b.bFa());
      }
      localObject1 = b.bFa() + paramString;
      str = (String)localObject1 + ".wlock";
      y.deleteFile(str);
      y.ew(str, true);
      y.f(str, new byte[1], 1);
    }
    finally
    {
      for (;;)
      {
        try
        {
          final String str;
          y.deleteFile((String)localObject1);
          y.ew((String)localObject1, true);
          Object localObject1 = new BufferedOutputStream(y.ev((String)localObject1, false))
          {
            public final void flush()
            {
              try
              {
                AppMethodBeat.i(131341);
                super.flush();
                y.deleteFile(str);
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
          return localObject1;
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", localIOException, "openWrite fileName %s, parent exists[%b]", new Object[] { paramString, Boolean.valueOf(y.ZC(b.bFa())) });
          AppMethodBeat.o(131342);
        }
        localObject2 = finally;
        Log.e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", new Object[] { localObject2 });
      }
    }
    return null;
  }
  
  public final InputStream Lh(String paramString)
  {
    AppMethodBeat.i(131343);
    Object localObject = b.bFa() + paramString;
    if (y.ZC((String)localObject + ".wlock"))
    {
      AppMethodBeat.o(131343);
      return null;
    }
    try
    {
      localObject = y.Lh((String)localObject);
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
  
  public final boolean iP(String paramString)
  {
    AppMethodBeat.i(131344);
    if ((!Util.isNullOrNil(paramString)) && (y.deleteFile(b.bFa() + paramString)))
    {
      AppMethodBeat.o(131344);
      return true;
    }
    AppMethodBeat.o(131344);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.b
 * JD-Core Version:    0.7.0.1
 */