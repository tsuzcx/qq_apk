package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.a.b;
import com.tencent.mm.plugin.hp.d.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class g$2
  implements Runnable
{
  g$2(g paramg, String[] paramArrayOfString) {}
  
  public final void run()
  {
    AppMethodBeat.i(90610);
    Object localObject2 = com.tencent.mm.compatible.util.e.eQz + "/Download/2017-07-28_19-43-39.apk";
    Object localObject3 = com.tencent.mm.compatible.util.e.eQz + "/Download/39-50-diff.apk";
    Object localObject4 = com.tencent.mm.compatible.util.e.eQz + "/Download/new_50.apk";
    String str = "ab099f75f740be5d88e178d662a36779";
    Object localObject1 = localObject2;
    if (this.eut.length >= 3)
    {
      localObject1 = localObject2;
      if (!bo.isNullOrNil(this.eut[2])) {
        localObject1 = this.eut[2];
      }
    }
    localObject2 = localObject3;
    if (this.eut.length >= 4)
    {
      localObject2 = localObject3;
      if (!bo.isNullOrNil(this.eut[3])) {
        localObject2 = this.eut[3];
      }
    }
    localObject3 = localObject4;
    if (this.eut.length >= 5)
    {
      localObject3 = localObject4;
      if (!bo.isNullOrNil(this.eut[4])) {
        localObject3 = this.eut[4];
      }
    }
    localObject4 = str;
    if (this.eut.length >= 6)
    {
      localObject4 = str;
      if (!bo.isNullOrNil(this.eut[5])) {
        localObject4 = this.eut[5];
      }
    }
    int i;
    if (!com.tencent.mm.a.e.cN((String)localObject3))
    {
      long l = System.currentTimeMillis();
      i = b.b((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4);
      ab.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk use :%d retCode：%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      if (i == 0)
      {
        ab.i("MicroMsg.Tinker.TinkerBootsCommand", "show dialog for install");
        ab.i("MicroMsg.Tinker.TinkerBootsCommand", "New Apk md5:%s", new Object[] { com.tencent.mm.a.g.getMD5((String)localObject3) });
        d.aC(ah.getContext(), (String)localObject3);
        ab.i("MicroMsg.Tinker.TinkerBootsCommand", "md5 is equal.");
        AppMethodBeat.o(90610);
        return;
      }
      ab.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk failed.");
      AppMethodBeat.o(90610);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.g.2
 * JD-Core Version:    0.7.0.1
 */