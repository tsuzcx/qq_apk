package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.IOException;

public final class b
{
  public static String Ly(String paramString)
  {
    AppMethodBeat.i(19434);
    if ((bo.isNullOrNil(paramString)) || ("#".equals(paramString)))
    {
      AppMethodBeat.o(19434);
      return "";
    }
    Object localObject = ag.cE(paramString);
    localObject = new com.tencent.mm.vfs.b(d.bql(), (String)localObject);
    if (((com.tencent.mm.vfs.b)localObject).exists())
    {
      paramString = j.p(((com.tencent.mm.vfs.b)localObject).dQJ());
      AppMethodBeat.o(19434);
      return paramString;
    }
    try
    {
      ((com.tencent.mm.vfs.b)localObject).createNewFile();
      aw.RO().ac(new a(paramString, (com.tencent.mm.vfs.b)localObject));
      AppMethodBeat.o(19434);
      return "";
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", new Object[] { localIOException.toString() });
      }
    }
  }
  
  static final class a
    implements Runnable
  {
    private com.tencent.mm.vfs.b lHf;
    private String url;
    
    a(String paramString, com.tencent.mm.vfs.b paramb)
    {
      this.url = paramString;
      this.lHf = paramb;
    }
    
    public final void run()
    {
      AppMethodBeat.i(19432);
      byte[] arrayOfByte = bo.apZ(this.url);
      if (arrayOfByte != null) {
        e.b(j.p(this.lHf.mUri), arrayOfByte, arrayOfByte.length);
      }
      AppMethodBeat.o(19432);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(19433);
      String str = super.toString() + "|DownloadRunnable";
      AppMethodBeat.o(19433);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.b
 * JD-Core Version:    0.7.0.1
 */