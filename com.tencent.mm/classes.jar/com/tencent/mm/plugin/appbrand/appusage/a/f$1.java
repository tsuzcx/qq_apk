package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.LinkedList;

public final class f$1
  implements Runnable
{
  public f$1(long paramLong, LinkedList paramLinkedList1, LinkedList paramLinkedList2, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(44674);
    zb localzb = new zb();
    localzb.FYG = ay.getNetTypeString(aj.getContext());
    localzb.latitude = c.bcI();
    localzb.longitude = c.bcH();
    new j(this.jRa, this.jRb, this.jRc, this.jRd, this.jRe, this.jRf, localzb) {}.aED();
    AppMethodBeat.o(44674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.f.1
 * JD-Core Version:    0.7.0.1
 */