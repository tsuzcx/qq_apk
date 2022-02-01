package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.model.ax;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements ax
{
  private n vMN;
  private c vMO;
  private c vMP;
  
  public e()
  {
    AppMethodBeat.i(89317);
    this.vMN = new n();
    this.vMO = new c() {};
    this.vMP = new e.2(this);
    AppMethodBeat.o(89317);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(89318);
    o.aMO().a(this.vMN);
    a.IbL.b(this.vMP);
    a.IbL.c(this.vMO);
    AppMethodBeat.o(89318);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89319);
    o.aMO().b(this.vMN);
    a.IbL.d(this.vMP);
    k.vQc.ayw();
    a.IbL.d(this.vMO);
    AppMethodBeat.o(89319);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.e
 * JD-Core Version:    0.7.0.1
 */