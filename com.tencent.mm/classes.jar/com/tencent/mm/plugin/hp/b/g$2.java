package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.plugin.hp.a.b;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class g$2
  implements Runnable
{
  g$2(g paramg, String[] paramArrayOfString) {}
  
  public final void run()
  {
    Object localObject2 = com.tencent.mm.compatible.util.e.bkH + "/Download/2017-07-28_19-43-39.apk";
    Object localObject3 = com.tencent.mm.compatible.util.e.bkH + "/Download/39-50-diff.apk";
    Object localObject4 = com.tencent.mm.compatible.util.e.bkH + "/Download/new_50.apk";
    String str = "ab099f75f740be5d88e178d662a36779";
    Object localObject1 = localObject2;
    if (this.dAS.length >= 3)
    {
      localObject1 = localObject2;
      if (!bk.bl(this.dAS[2])) {
        localObject1 = this.dAS[2];
      }
    }
    localObject2 = localObject3;
    if (this.dAS.length >= 4)
    {
      localObject2 = localObject3;
      if (!bk.bl(this.dAS[3])) {
        localObject2 = this.dAS[3];
      }
    }
    localObject3 = localObject4;
    if (this.dAS.length >= 5)
    {
      localObject3 = localObject4;
      if (!bk.bl(this.dAS[4])) {
        localObject3 = this.dAS[4];
      }
    }
    localObject4 = str;
    if (this.dAS.length >= 6)
    {
      localObject4 = str;
      if (!bk.bl(this.dAS[5])) {
        localObject4 = this.dAS[5];
      }
    }
    int i;
    if (!com.tencent.mm.a.e.bK((String)localObject3))
    {
      long l = System.currentTimeMillis();
      i = b.b((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4);
      y.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk use :%d retCode：%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      if (i == 0)
      {
        y.i("MicroMsg.Tinker.TinkerBootsCommand", "show dialog for install");
        y.i("MicroMsg.Tinker.TinkerBootsCommand", "New Apk md5:%s", new Object[] { com.tencent.mm.a.g.bQ((String)localObject3) });
        i.bl(ae.getContext(), (String)localObject3);
        y.i("MicroMsg.Tinker.TinkerBootsCommand", "md5 is equal.");
        return;
      }
      y.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk failed.");
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.g.2
 * JD-Core Version:    0.7.0.1
 */