package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.LinkedList;

public final class f$1
  implements Runnable
{
  public f$1(long paramLong, LinkedList paramLinkedList1, LinkedList paramLinkedList2, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(129743);
    ts localts = new ts();
    localts.wMo = at.getNetTypeString(ah.getContext());
    localts.latitude = c.getLatitude();
    localts.longitude = c.getLongitude();
    new f.1.1(this, this.hdy, this.hdz, this.hdA, this.hdB, this.hdC, this.hdD, localts).adl();
    AppMethodBeat.o(129743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.f.1
 * JD-Core Version:    0.7.0.1
 */