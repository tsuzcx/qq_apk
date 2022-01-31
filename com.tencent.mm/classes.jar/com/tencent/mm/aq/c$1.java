package com.tencent.mm.aq;

import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedHashMap;
import java.util.Set;

final class c$1
  implements Runnable
{
  c$1(c paramc, String paramString) {}
  
  public final void run()
  {
    Object[] arrayOfObject = this.emx.emo.map.keySet().toArray();
    int i = 0;
    while (i < arrayOfObject.length)
    {
      String str = (String)arrayOfObject[i];
      if (str.startsWith(this.dol))
      {
        y.d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", new Object[] { str });
        this.emx.emo.remove(str);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aq.c.1
 * JD-Core Version:    0.7.0.1
 */