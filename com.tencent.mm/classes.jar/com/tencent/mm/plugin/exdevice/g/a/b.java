package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;

public final class b
{
  public static String adq(String paramString)
  {
    AppMethodBeat.i(23501);
    if ((bu.isNullOrNil(paramString)) || ("#".equals(paramString)))
    {
      AppMethodBeat.o(23501);
      return "";
    }
    Object localObject = aj.ej(paramString);
    localObject = new k(d.cmW(), (String)localObject);
    if (((k)localObject).exists())
    {
      paramString = w.B(((k)localObject).fTh());
      AppMethodBeat.o(23501);
      return paramString;
    }
    try
    {
      ((k)localObject).createNewFile();
      bc.ajU().aw(new a(paramString, (k)localObject));
      AppMethodBeat.o(23501);
      return "";
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", new Object[] { localIOException.toString() });
      }
    }
  }
  
  static final class a
    implements Runnable
  {
    private k qll;
    private String url;
    
    a(String paramString, k paramk)
    {
      this.url = paramString;
      this.qll = paramk;
    }
    
    public final void run()
    {
      AppMethodBeat.i(23499);
      byte[] arrayOfByte = bu.aSF(this.url);
      if (arrayOfByte != null) {
        o.f(w.B(this.qll.mUri), arrayOfByte, arrayOfByte.length);
      }
      AppMethodBeat.o(23499);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(23500);
      String str = super.toString() + "|DownloadRunnable";
      AppMethodBeat.o(23500);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.b
 * JD-Core Version:    0.7.0.1
 */