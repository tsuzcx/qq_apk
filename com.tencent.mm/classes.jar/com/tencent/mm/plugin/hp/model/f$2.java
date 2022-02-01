package com.tencent.mm.plugin.hp.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

final class f$2
  implements Runnable
{
  f$2(f paramf, String[] paramArrayOfString) {}
  
  public final void run()
  {
    AppMethodBeat.i(117438);
    Object localObject2 = com.tencent.mm.loader.i.b.bmz() + "/Download/2017-07-28_19-43-39.apk";
    Object localObject3 = com.tencent.mm.loader.i.b.bmz() + "/Download/39-50-diff.apk";
    Object localObject4 = com.tencent.mm.loader.i.b.bmz() + "/Download/new_50.apk";
    String str = "ab099f75f740be5d88e178d662a36779";
    Object localObject1 = localObject2;
    if (this.val$args.length >= 3)
    {
      localObject1 = localObject2;
      if (!Util.isNullOrNil(this.val$args[2])) {
        localObject1 = this.val$args[2];
      }
    }
    localObject2 = localObject3;
    if (this.val$args.length >= 4)
    {
      localObject2 = localObject3;
      if (!Util.isNullOrNil(this.val$args[3])) {
        localObject2 = this.val$args[3];
      }
    }
    localObject3 = localObject4;
    if (this.val$args.length >= 5)
    {
      localObject3 = localObject4;
      if (!Util.isNullOrNil(this.val$args[4])) {
        localObject3 = this.val$args[4];
      }
    }
    localObject4 = str;
    if (this.val$args.length >= 6)
    {
      localObject4 = str;
      if (!Util.isNullOrNil(this.val$args[5])) {
        localObject4 = this.val$args[5];
      }
    }
    int i;
    if (!y.ZC((String)localObject3))
    {
      long l = System.currentTimeMillis();
      i = com.tencent.mm.plugin.hp.a.b.A((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4);
      Log.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk use :%d retCode：%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.Tinker.TinkerBootsCommand", "show dialog for install");
        Log.i("MicroMsg.Tinker.TinkerBootsCommand", "New Apk md5:%s", new Object[] { y.bub((String)localObject3) });
        d.bn(MMApplicationContext.getContext(), (String)localObject3);
        Log.i("MicroMsg.Tinker.TinkerBootsCommand", "md5 is equal.");
        AppMethodBeat.o(117438);
        return;
      }
      Log.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk failed.");
      AppMethodBeat.o(117438);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.model.f.2
 * JD-Core Version:    0.7.0.1
 */