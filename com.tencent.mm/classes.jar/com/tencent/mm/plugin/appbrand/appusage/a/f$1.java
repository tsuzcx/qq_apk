package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.LinkedList;

public final class f$1
  implements Runnable
{
  public f$1(long paramLong, LinkedList paramLinkedList1, LinkedList paramLinkedList2, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(44674);
    aat localaat = new aat();
    localaat.Lmb = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    localaat.latitude = c.getLatitude();
    localaat.longitude = c.getLongitude();
    new j(this.kXo, this.kXp, this.kXq, this.kXr, this.kXs, this.kXt, localaat) {}.aYI();
    AppMethodBeat.o(44674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.f.1
 * JD-Core Version:    0.7.0.1
 */