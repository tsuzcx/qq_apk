package com.tencent.liteav;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.a.a.a;
import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.c;
import com.tencent.liteav.network.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

class d$1
  implements Runnable
{
  d$1(d paramd, String paramString) {}
  
  public void run()
  {
    boolean bool2 = false;
    AppMethodBeat.i(66802);
    try
    {
      Object localObject = a.c().a(new b(this.a, true), null);
      int j = localObject.length;
      int i = 0;
      boolean bool1 = bool2;
      HashMap localHashMap;
      String str;
      if (i < j)
      {
        localHashMap = localObject[i];
        if ((localHashMap.a()) && (d.c(localHashMap.a))) {
          bool1 = true;
        }
      }
      else
      {
        localHashMap = d.g();
        str = this.a;
        if (!bool1) {
          break label147;
        }
      }
      label147:
      for (localObject = d.a.b;; localObject = d.a.c)
      {
        localHashMap.put(str, localObject);
        TXCLog.d(d.h(), this.a + " isTencent " + bool1);
        AppMethodBeat.o(66802);
        return;
        i += 1;
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(66802);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.d.1
 * JD-Core Version:    0.7.0.1
 */