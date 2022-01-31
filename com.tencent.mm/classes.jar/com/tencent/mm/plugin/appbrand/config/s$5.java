package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.ah.a.a;

final class s$5
  implements Runnable
{
  s$5(String paramString, boolean paramBoolean1, s.b paramb, boolean paramBoolean2) {}
  
  public final void run()
  {
    int i = 1;
    Object localObject = this.dol;
    boolean bool;
    if ((this.fQP) && (s.sA(this.dol)))
    {
      bool = true;
      localObject = s.a((String)localObject, bool, new s.5.1(this));
      if (this.fQQ != null) {
        if (((Pair)localObject).second != null) {
          break label94;
        }
      }
    }
    for (;;)
    {
      this.fQQ.e(i, ((Pair)localObject).first);
      if (this.fQR) {}
      label94:
      try
      {
        ((HandlerThread)Looper.myLooper().getThread()).quit();
        return;
      }
      catch (Exception localException) {}
      bool = false;
      break;
      if ((((a.a)((Pair)localObject).second).errType != 0) || (((a.a)((Pair)localObject).second).errCode != 0)) {
        i = 3;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.s.5
 * JD-Core Version:    0.7.0.1
 */