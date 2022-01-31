package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.mm.protocal.c.qm;
import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.LinkedList;

final class d$1
  implements Runnable
{
  d$1(long paramLong, LinkedList paramLinkedList, qm paramqm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    qn localqn = new qn();
    localqn.longitude = a.adA().fKo;
    localqn.latitude = a.adA().fKp;
    localqn.sOp = aq.getNetTypeString(ae.getContext());
    new d.1.1(this, this.fKv, this.fKA, this.fKB, this.fKC, this.fKD, localqn).Km();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.d.1
 * JD-Core Version:    0.7.0.1
 */