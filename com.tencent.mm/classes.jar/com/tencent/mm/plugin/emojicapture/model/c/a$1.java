package com.tencent.mm.plugin.emojicapture.model.c;

import a.d.b.g;
import a.k;
import android.os.Message;
import com.tencent.mm.plugin.emojicapture.f.a.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements ah.a
{
  a$1(a parama) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    int j = 0;
    a locala;
    if (paramMessage.what == 1)
    {
      locala = this.jlM;
      paramMessage = paramMessage.obj;
      if (paramMessage == null) {
        throw new k("null cannot be cast to non-null type kotlin.IntArray");
      }
      paramMessage = (int[])paramMessage;
      if (paramMessage.length != 0) {
        break label241;
      }
    }
    label241:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        j = 1;
      }
      if (j != 0)
      {
        long l = bk.UZ();
        if ((g.e(locala.mjn.mkz, d.c.miA)) || (g.e(locala.mjn.mkz, d.c.miB)))
        {
          if (g.e(locala.mjn.mkz, d.c.miB))
          {
            locala.mjn.mkz = d.c.miC;
            y.v(locala.TAG, "forward one more frame");
          }
          locala.mkh.fj(1L);
          byte[] arrayOfByte = j.mji.f(Integer.valueOf(614400));
          SightVideoJNI.rgbaToNV21(paramMessage, arrayOfByte, 640, 640);
          locala.aC(arrayOfByte);
        }
        l = bk.cp(l);
        locala.jlK += l;
        if (l > 30L)
        {
          paramMessage = com.tencent.mm.plugin.emojicapture.f.a.jnW;
          a.a.cG(13, 1);
        }
        y.i(locala.TAG, "after convert data " + l);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c.a.1
 * JD-Core Version:    0.7.0.1
 */