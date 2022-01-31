package com.tencent.mm.as;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class c$b
  implements Runnable
{
  private HashMap<String, c.c> enb;
  private String url;
  
  c$b(String paramString, HashMap<String, c.c> paramHashMap)
  {
    this.url = paramString;
    this.enb = paramHashMap;
  }
  
  public final void run()
  {
    Object localObject1 = bk.ZV(this.url);
    if (localObject1 == null)
    {
      y.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", new Object[] { this.url });
      return;
    }
    try
    {
      localObject1 = c.bu((byte[])localObject1);
      y.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", new Object[] { this.url });
      ai.d(new c.a(this.url, (Bitmap)localObject1, this.enb));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", new Object[] { this.url, localException.getLocalizedMessage() });
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.as.c.b
 * JD-Core Version:    0.7.0.1
 */