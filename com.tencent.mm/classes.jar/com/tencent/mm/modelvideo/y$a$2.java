package com.tencent.mm.modelvideo;

import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class y$a$2
  implements Runnable
{
  y$a$2(y.a parama, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    y.a.Kf();
    String str;
    int i;
    if (this.bEe.getType() == 150)
    {
      y.a.b(this.eIu);
      str = ((d)this.bEe).fileName;
      y.eIk = str;
      i = ((d)this.bEe).retCode;
      y.a.c(this.eIu);
    }
    for (;;)
    {
      long l2 = 0L;
      long l1 = l2;
      if (str != null)
      {
        l1 = l2;
        if (this.eIu.bDU.get(str) != null)
        {
          l1 = ((g.a)this.eIu.bDU.get(str)).zJ();
          this.eIu.bDU.remove(str);
        }
      }
      y.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + this.bEe.getType() + " errtype:" + this.bEf + " errCode:" + this.bEg + " retCode:" + i + " file:" + str + " time:" + l1);
      if ((this.bEf == 3) && (i != 0))
      {
        y.a.f(this.eIu);
        label227:
        y.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + y.a.access$100() + " stop:" + y.a.g(this.eIu) + " running:" + y.a.h(this.eIu) + " recving:" + y.a.i(this.eIu) + " sending:" + y.a.j(this.eIu));
        if (y.a.g(this.eIu) <= 0) {
          break label475;
        }
        y.a.a(this.eIu);
      }
      for (;;)
      {
        y.a.SO();
        return;
        if (this.bEe.getType() == 149)
        {
          y.a.d(this.eIu);
          y.a.e(this.eIu);
          if ((this.bEe instanceof g))
          {
            str = ((g)this.bEe).fileName;
            i = ((g)this.bEe).retCode;
            break;
          }
          if (!(this.bEe instanceof h)) {
            break label505;
          }
          str = ((h)this.bEe).fileName;
          i = 0;
          break;
        }
        y.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + this.bEe.getType());
        y.a.SO();
        return;
        if (this.bEf == 0) {
          break label227;
        }
        y.a.a(this.eIu, 0);
        break label227;
        label475:
        if ((!y.a.j(this.eIu)) && (!y.a.i(this.eIu))) {
          y.a.k(this.eIu);
        }
      }
      label505:
      i = 0;
      str = null;
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|onSceneEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y.a.2
 * JD-Core Version:    0.7.0.1
 */