package com.tencent.mm.app;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.y;

final class WorkerProfile$1
  extends n.a
{
  WorkerProfile$1(WorkerProfile paramWorkerProfile) {}
  
  public final void et(int paramInt)
  {
    if ((paramInt != 4) && (paramInt != 6)) {}
    while ((!au.DK()) || (!g.DN().dJH) || (au.CW())) {
      return;
    }
    y.i("MicroMsg.WorkerProfile", "dkmsg Network connected , try send msg.");
    au.Dk().a(new h(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.1
 * JD-Core Version:    0.7.0.1
 */