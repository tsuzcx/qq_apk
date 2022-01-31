package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;

final class s$5
  implements Runnable
{
  s$5(String paramString, boolean paramBoolean1, s.b paramb, boolean paramBoolean2) {}
  
  public final void run()
  {
    int i = 1;
    AppMethodBeat.i(129917);
    Object localObject = this.efI;
    boolean bool;
    if ((this.hjB) && (s.Av(this.efI)))
    {
      bool = true;
      localObject = s.a((String)localObject, bool, new s.5.1(this));
      if (this.hjC != null) {
        if (((Pair)localObject).second != null) {
          break label104;
        }
      }
    }
    for (;;)
    {
      this.hjC.g(i, ((Pair)localObject).first);
      if (!this.hjD) {
        break label141;
      }
      label104:
      try
      {
        ((HandlerThread)Looper.myLooper().getThread()).quit();
        AppMethodBeat.o(129917);
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
    label141:
    AppMethodBeat.o(129917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.s.5
 * JD-Core Version:    0.7.0.1
 */