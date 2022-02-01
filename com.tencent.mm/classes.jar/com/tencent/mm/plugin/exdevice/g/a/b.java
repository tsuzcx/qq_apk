package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.IOException;

public final class b
{
  public static String YT(String paramString)
  {
    AppMethodBeat.i(23501);
    if ((bs.isNullOrNil(paramString)) || ("#".equals(paramString)))
    {
      AppMethodBeat.o(23501);
      return "";
    }
    Object localObject = ah.dg(paramString);
    localObject = new e(d.chc(), (String)localObject);
    if (((e)localObject).exists())
    {
      paramString = q.B(((e)localObject).fxV());
      AppMethodBeat.o(23501);
      return paramString;
    }
    try
    {
      ((e)localObject).createNewFile();
      az.agU().az(new a(paramString, (e)localObject));
      AppMethodBeat.o(23501);
      return "";
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", new Object[] { localIOException.toString() });
      }
    }
  }
  
  static final class a
    implements Runnable
  {
    private e pBb;
    private String url;
    
    a(String paramString, e parame)
    {
      this.url = paramString;
      this.pBb = parame;
    }
    
    public final void run()
    {
      AppMethodBeat.i(23499);
      byte[] arrayOfByte = bs.aLC(this.url);
      if (arrayOfByte != null) {
        i.f(q.B(this.pBb.mUri), arrayOfByte, arrayOfByte.length);
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