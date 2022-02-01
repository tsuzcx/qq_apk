package com.tencent.mm.modelappbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class b$b
  implements b.i
{
  public final OutputStream LM(String paramString)
  {
    AppMethodBeat.i(131342);
    try
    {
      if ((!s.boN(b.aYa())) && (!new o(b.aYa()).isDirectory()))
      {
        s.deleteFile(b.aYa());
        s.boN(b.aYa());
      }
      localObject = b.aYa() + paramString;
      str = (String)localObject + ".wlock";
      s.deleteFile(str);
      s.dy(str, true);
      s.f(str, new byte[1], 1);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          final String str;
          s.deleteFile((String)localObject);
          s.dy((String)localObject, true);
          Object localObject = new BufferedOutputStream(s.dw((String)localObject, false))
          {
            public final void flush()
            {
              try
              {
                AppMethodBeat.i(131341);
                super.flush();
                s.deleteFile(str);
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
          Log.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", localIOException, "openWrite fileName %s, parent exists[%b]", new Object[] { paramString, Boolean.valueOf(s.YS(b.aYa())) });
          AppMethodBeat.o(131342);
        }
        localThrowable = localThrowable;
        Log.e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", new Object[] { localThrowable });
      }
    }
    return null;
  }
  
  public final boolean gC(String paramString)
  {
    AppMethodBeat.i(131344);
    if ((!Util.isNullOrNil(paramString)) && (s.deleteFile(b.aYa() + paramString)))
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
    Object localObject = b.aYa() + paramString;
    if (s.YS((String)localObject + ".wlock"))
    {
      AppMethodBeat.o(131343);
      return null;
    }
    try
    {
      localObject = s.openRead((String)localObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.b
 * JD-Core Version:    0.7.0.1
 */