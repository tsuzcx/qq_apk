package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import java.util.LinkedList;

public final class f$1
  implements Runnable
{
  public f$1(long paramLong, LinkedList paramLinkedList1, LinkedList paramLinkedList2, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(44674);
    ze localze = new ze();
    localze.Grf = az.getNetTypeString(ak.getContext());
    localze.latitude = c.bdn();
    localze.longitude = c.bdm();
    new j(this.jUs, this.jUt, this.jUu, this.jUv, this.jUw, this.jUx, localze) {}.aET();
    AppMethodBeat.o(44674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.f.1
 * JD-Core Version:    0.7.0.1
 */