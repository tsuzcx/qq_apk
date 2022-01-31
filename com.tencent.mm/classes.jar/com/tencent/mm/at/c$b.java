package com.tencent.mm.at;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.util.HashMap;

final class c$b
  implements Runnable
{
  private HashMap<String, c.c> fDy;
  private String url;
  
  c$b(String paramString, HashMap<String, c.c> paramHashMap)
  {
    this.url = paramString;
    this.fDy = paramHashMap;
  }
  
  public final void run()
  {
    AppMethodBeat.i(78166);
    Object localObject1 = bo.apZ(this.url);
    if (localObject1 == null)
    {
      ab.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", new Object[] { this.url });
      AppMethodBeat.o(78166);
      return;
    }
    try
    {
      localObject1 = d.bT((byte[])localObject1);
      ab.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", new Object[] { this.url });
      al.d(new c.a(this.url, (Bitmap)localObject1, this.fDy));
      AppMethodBeat.o(78166);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", new Object[] { this.url, localException.getLocalizedMessage() });
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.c.b
 * JD-Core Version:    0.7.0.1
 */