package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;

public final class b
{
  public static String anz(String paramString)
  {
    AppMethodBeat.i(23501);
    if ((Util.isNullOrNil(paramString)) || ("#".equals(paramString)))
    {
      AppMethodBeat.o(23501);
      return "";
    }
    Object localObject = MD5Util.getMD5String(paramString);
    localObject = new o(d.cKY(), (String)localObject);
    if (((o)localObject).exists())
    {
      paramString = aa.z(((o)localObject).her());
      AppMethodBeat.o(23501);
      return paramString;
    }
    try
    {
      ((o)localObject).createNewFile();
      bg.aAk().postToWorker(new a(paramString, (o)localObject));
      AppMethodBeat.o(23501);
      return "";
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", new Object[] { localIOException.toString() });
      }
    }
  }
  
  static final class a
    implements Runnable
  {
    private o rCg;
    private String url;
    
    a(String paramString, o paramo)
    {
      this.url = paramString;
      this.rCg = paramo;
    }
    
    public final void run()
    {
      AppMethodBeat.i(23499);
      byte[] arrayOfByte = Util.httpGet(this.url);
      if (arrayOfByte != null) {
        s.f(aa.z(this.rCg.mUri), arrayOfByte, arrayOfByte.length);
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