package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.ipcall.model.IPCallSvrNotifyListener;
import com.tencent.mm.plugin.ipcall.model.IPCallSvrNotifyListener.a;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.protocal.protobuf.eib;

public final class e
  extends a
  implements IPCallSvrNotifyListener.a
{
  private IPCallSvrNotifyListener JJK = null;
  
  public final void a(eib parameib)
  {
    AppMethodBeat.i(25522);
    this.JGS.a(8, parameib, 0, 0);
    AppMethodBeat.o(25522);
  }
  
  public final void apC()
  {
    AppMethodBeat.i(25520);
    this.JJK = new IPCallSvrNotifyListener();
    this.JJK.JGs = this;
    this.JJK.alive();
    AppMethodBeat.o(25520);
  }
  
  public final void b(c paramc) {}
  
  public final int[] fRD()
  {
    return new int[0];
  }
  
  public final int getServiceType()
  {
    return 8;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(25521);
    this.JJK.dead();
    AppMethodBeat.o(25521);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.e
 * JD-Core Version:    0.7.0.1
 */