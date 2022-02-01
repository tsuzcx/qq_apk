package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;

public final class b
{
  public static String avy(String paramString)
  {
    AppMethodBeat.i(23501);
    if ((Util.isNullOrNil(paramString)) || ("#".equals(paramString)))
    {
      AppMethodBeat.o(23501);
      return "";
    }
    Object localObject = MD5Util.getMD5String(paramString);
    localObject = new q(d.cZL(), (String)localObject);
    if (((q)localObject).ifE())
    {
      paramString = ((q)localObject).bOF();
      AppMethodBeat.o(23501);
      return paramString;
    }
    try
    {
      ((q)localObject).ifM();
      bh.aHJ().postToWorker(new a(paramString, (q)localObject));
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
    private String url;
    private q vhO;
    
    a(String paramString, q paramq)
    {
      this.url = paramString;
      this.vhO = paramq;
    }
    
    public final void run()
    {
      AppMethodBeat.i(23499);
      byte[] arrayOfByte = Util.httpGet(this.url);
      if (arrayOfByte != null) {
        u.H(this.vhO.getPath(), arrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.b
 * JD-Core Version:    0.7.0.1
 */