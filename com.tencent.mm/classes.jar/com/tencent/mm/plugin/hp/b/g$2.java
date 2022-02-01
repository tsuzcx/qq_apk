package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

final class g$2
  implements Runnable
{
  g$2(g paramg, String[] paramArrayOfString) {}
  
  public final void run()
  {
    AppMethodBeat.i(117438);
    Object localObject2 = com.tencent.mm.loader.j.b.aih() + "/Download/2017-07-28_19-43-39.apk";
    Object localObject3 = com.tencent.mm.loader.j.b.aih() + "/Download/39-50-diff.apk";
    Object localObject4 = com.tencent.mm.loader.j.b.aih() + "/Download/new_50.apk";
    String str = "ab099f75f740be5d88e178d662a36779";
    Object localObject1 = localObject2;
    if (this.fHR.length >= 3)
    {
      localObject1 = localObject2;
      if (!bt.isNullOrNil(this.fHR[2])) {
        localObject1 = this.fHR[2];
      }
    }
    localObject2 = localObject3;
    if (this.fHR.length >= 4)
    {
      localObject2 = localObject3;
      if (!bt.isNullOrNil(this.fHR[3])) {
        localObject2 = this.fHR[3];
      }
    }
    localObject3 = localObject4;
    if (this.fHR.length >= 5)
    {
      localObject3 = localObject4;
      if (!bt.isNullOrNil(this.fHR[4])) {
        localObject3 = this.fHR[4];
      }
    }
    localObject4 = str;
    if (this.fHR.length >= 6)
    {
      localObject4 = str;
      if (!bt.isNullOrNil(this.fHR[5])) {
        localObject4 = this.fHR[5];
      }
    }
    int i;
    if (!i.eK((String)localObject3))
    {
      long l = System.currentTimeMillis();
      i = com.tencent.mm.plugin.hp.a.b.a((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4);
      ad.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk use :%d retCode：%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      if (i == 0)
      {
        ad.i("MicroMsg.Tinker.TinkerBootsCommand", "show dialog for install");
        ad.i("MicroMsg.Tinker.TinkerBootsCommand", "New Apk md5:%s", new Object[] { i.aEN((String)localObject3) });
        d.aG(aj.getContext(), (String)localObject3);
        ad.i("MicroMsg.Tinker.TinkerBootsCommand", "md5 is equal.");
        AppMethodBeat.o(117438);
        return;
      }
      ad.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk failed.");
      AppMethodBeat.o(117438);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.g.2
 * JD-Core Version:    0.7.0.1
 */