package com.tencent.mm.modelsimple;

import com.tencent.mm.h.a.aj;
import com.tencent.mm.h.a.aj.b;
import com.tencent.mm.h.a.je;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class k$1
  implements Runnable
{
  k$1(k paramk, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    int i;
    Object localObject1;
    String str;
    int j;
    if (this.ezi == null)
    {
      i = -1;
      y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.ezj) });
      localObject1 = new aj();
      ((aj)localObject1).bGr.type = 5;
      ((aj)localObject1).bGr.bGt = this.ezi;
      a.udP.m((b)localObject1);
      str = ((aj)localObject1).bGs.bGy;
      i = ((aj)localObject1).bGs.position;
      j = ((aj)localObject1).bGs.bGv;
      y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(k.a(this.ezk)), k.Qq() });
      if ((i != 1) || (j != 6)) {
        break label352;
      }
      if (this.ezj) {
        k.aD(str, this.ezi);
      }
      if (!k.a(this.ezk)) {
        break label299;
      }
      localObject2 = ((aj)localObject1).bGs.desc;
      localObject1 = ((aj)localObject1).bGs.url;
      y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", new Object[] { Boolean.valueOf(ae.cqO()) });
      if (k.b(this.ezk) == null) {
        k.a(this.ezk, new k.1.1(this, (String)localObject2, (String)localObject1));
      }
      a.udP.c(k.b(this.ezk));
      k.Qq().put(str, Long.valueOf(bk.UZ()));
    }
    label299:
    label352:
    while (j != 2) {
      for (;;)
      {
        return;
        i = this.ezi.length();
        break;
        Object localObject2 = new je();
        ((je)localObject2).bRB.content = ((aj)localObject1).bGs.desc;
        ((je)localObject2).bRB.url = ((aj)localObject1).bGs.url;
        a.udP.m((b)localObject2);
      }
    }
    if (this.ezj) {
      k.aD(str, this.ezi);
    }
    k.Qq().put(str, Long.valueOf(bk.UZ()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelsimple.k.1
 * JD-Core Version:    0.7.0.1
 */