package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.LinkedList;

public final class f$1
  implements Runnable
{
  public f$1(long paramLong, LinkedList paramLinkedList1, LinkedList paramLinkedList2, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(44674);
    xc localxc = new xc();
    localxc.Erw = ax.getNetTypeString(ai.getContext());
    localxc.latitude = c.aZk();
    localxc.longitude = c.aZj();
    new j(this.jxe, this.jxf, this.jxg, this.jxh, this.jxi, this.jxj, localxc) {}.aBB();
    AppMethodBeat.o(44674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.f.1
 * JD-Core Version:    0.7.0.1
 */