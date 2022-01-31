package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.d.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements Runnable
{
  f$1(f paramf) {}
  
  public final void run()
  {
    Object localObject1 = this.gKo;
    Object localObject2 = (b)e.G(b.class);
    String str = ((f)localObject1).gKm.field_username;
    localObject2 = ((b)localObject2).v(str, 1, ((f)localObject1).fPF);
    if (((Boolean)((Pair)localObject2).first).booleanValue())
    {
      y.i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "sync blocked with username(%s) scene(%d)", new Object[] { str, Integer.valueOf(((f)localObject1).fPF) });
      localObject1 = a.fFB;
      a.s(((Integer)((Pair)localObject2).second).intValue(), 164L);
      return;
    }
    y.i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "[appversion] start() username %s, scene %d", new Object[] { str, Integer.valueOf(((f)localObject1).fPF) });
    long l = bk.UY();
    s.a(((f)localObject1).gKm.field_username, true, new f.2((f)localObject1, str, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f.1
 * JD-Core Version:    0.7.0.1
 */