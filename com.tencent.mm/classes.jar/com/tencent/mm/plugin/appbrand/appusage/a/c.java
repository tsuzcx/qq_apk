package com.tencent.mm.plugin.appbrand.appusage.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.TimeUnit;

public final class c
{
  private static float hcY = 0.0F;
  private static float hcZ = 0.0F;
  private static volatile long hda = 0L;
  private boolean hdb = false;
  private c.a hdc;
  
  public static boolean axK()
  {
    AppMethodBeat.i(129740);
    if ((hcZ == -85.0F) || (hcY == -1000.0F))
    {
      AppMethodBeat.o(129740);
      return false;
    }
    if (bo.aoy() - hda < 300000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(129740);
      return false;
    }
    AppMethodBeat.o(129740);
    return true;
  }
  
  public static float getLatitude()
  {
    return hcZ;
  }
  
  public static float getLongitude()
  {
    return hcY;
  }
  
  public final void a(c.a parama)
  {
    this.hdc = parama;
  }
  
  public final boolean axJ()
  {
    return this.hdc != null;
  }
  
  public final void axL()
  {
    AppMethodBeat.i(129741);
    if (this.hdb)
    {
      AppMethodBeat.o(129741);
      return;
    }
    ab.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "startLocation");
    this.hdb = true;
    Object localObject = new PBool();
    PBool localPBool = new PBool();
    ((PBool)localObject).value = false;
    localPBool.value = false;
    ap localap = new ap(Looper.getMainLooper(), new c.1(this, localPBool, (PBool)localObject), false);
    long l = TimeUnit.SECONDS.toMillis(20L);
    localap.ag(l, l);
    localObject = (b.a)e.bq(new c.2(this, (PBool)localObject, localPBool));
    d.agQ().b((b.a)localObject, false);
    AppMethodBeat.o(129741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.c
 * JD-Core Version:    0.7.0.1
 */