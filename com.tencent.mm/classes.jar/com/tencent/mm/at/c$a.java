package com.tencent.mm.at;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class c$a
  implements Runnable
{
  private HashMap<String, c.c> fDy;
  private Bitmap fDz;
  private String url;
  
  public c$a(String paramString, Bitmap paramBitmap, HashMap<String, c.c> paramHashMap)
  {
    this.url = paramString;
    this.fDz = paramBitmap;
    this.fDy = paramHashMap;
  }
  
  public final void run()
  {
    AppMethodBeat.i(78165);
    o.ahB();
    c.h(this.url, this.fDz);
    if (this.fDy != null)
    {
      localObject = (c.c)this.fDy.remove(this.url);
      if (localObject != null) {
        ((c.c)localObject).B(this.fDz);
      }
    }
    if (this.url == null) {}
    for (Object localObject = "null";; localObject = this.url)
    {
      ab.i("MicroMsg.CdnImageService", "finish download post job, url[%s]", new Object[] { localObject });
      AppMethodBeat.o(78165);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.c.a
 * JD-Core Version:    0.7.0.1
 */