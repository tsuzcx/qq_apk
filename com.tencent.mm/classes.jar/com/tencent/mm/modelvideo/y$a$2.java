package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class y$a$2
  implements Runnable
{
  y$a$2(y.a parama, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(50868);
    y.a.ade();
    String str;
    int i;
    if (this.ckS.getType() == 150)
    {
      y.a.b(this.fYk);
      str = ((d)this.ckS).fileName;
      y.fYa = str;
      i = ((d)this.ckS).retCode;
      y.a.c(this.fYk);
    }
    for (;;)
    {
      long l2 = 0L;
      long l1 = l2;
      if (str != null)
      {
        l1 = l2;
        if (this.fYk.ckJ.get(str) != null)
        {
          l1 = ((g.a)this.fYk.ckJ.get(str)).Mm();
          this.fYk.ckJ.remove(str);
        }
      }
      ab.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + this.ckS.getType() + " errtype:" + this.val$errType + " errCode:" + this.val$errCode + " retCode:" + i + " file:" + str + " time:" + l1);
      if ((this.val$errType == 3) && (i != 0))
      {
        y.a.f(this.fYk);
        label232:
        ab.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + y.a.access$100() + " stop:" + y.a.g(this.fYk) + " running:" + y.a.h(this.fYk) + " recving:" + y.a.i(this.fYk) + " sending:" + y.a.j(this.fYk));
        if (y.a.g(this.fYk) <= 0) {
          break label490;
        }
        y.a.a(this.fYk);
      }
      for (;;)
      {
        y.a.amb();
        AppMethodBeat.o(50868);
        return;
        if (this.ckS.getType() == 149)
        {
          y.a.d(this.fYk);
          y.a.e(this.fYk);
          if ((this.ckS instanceof g))
          {
            str = ((g)this.ckS).fileName;
            i = ((g)this.ckS).retCode;
            break;
          }
          if (!(this.ckS instanceof h)) {
            break label520;
          }
          str = ((h)this.ckS).fileName;
          i = 0;
          break;
        }
        ab.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + this.ckS.getType());
        y.a.amb();
        AppMethodBeat.o(50868);
        return;
        if (this.val$errType == 0) {
          break label232;
        }
        y.a.a(this.fYk, 0);
        break label232;
        label490:
        if ((!y.a.j(this.fYk)) && (!y.a.i(this.fYk))) {
          y.a.k(this.fYk);
        }
      }
      label520:
      i = 0;
      str = null;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50869);
    String str = super.toString() + "|onSceneEnd";
    AppMethodBeat.o(50869);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y.a.2
 * JD-Core Version:    0.7.0.1
 */