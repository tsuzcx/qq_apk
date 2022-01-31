package com.tencent.mm.media.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransEncoder$writeRGBData$1$1"})
public final class g$c
  implements Runnable
{
  public g$c(g paramg, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(12965);
    if ((g.c(this.eUN)) || (g.d(this.eUN)))
    {
      ab.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
      AppMethodBeat.o(12965);
      return;
    }
    long l = bo.yB();
    Object localObject = j.oJp.f(Integer.valueOf(this.eUO * this.eUP * 3 / 2));
    SightVideoJNI.rgbaToNV21(this.eUQ, (byte[])localObject, this.eUO, this.eUP);
    ab.i("MicroMsg.X264TransEncoder", "rgbaToNV21 cost " + bo.av(l) + "ms");
    l = bo.yB();
    SightVideoJNI.writeYuvDataForMMSight(g.e(this.eUN), (byte[])localObject, localObject.length, this.eUO, this.eUP, false, false, this.eUO, this.eUP);
    StringBuilder localStringBuilder = new StringBuilder("writeRGBData ").append(this.eUO).append(", ").append(this.eUP).append(" cost ").append(bo.av(l)).append("ms, ");
    g localg = this.eUN;
    int i = g.f(localg);
    g.a(localg, i + 1);
    ab.i("MicroMsg.X264TransEncoder", i);
    j.oJp.O((byte[])localObject);
    if (!g.g(this.eUN))
    {
      localObject = g.i(this.eUN);
      if (localObject != null) {
        ((Thread)localObject).start();
      }
      g.h(this.eUN);
    }
    AppMethodBeat.o(12965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.d.g.c
 * JD-Core Version:    0.7.0.1
 */