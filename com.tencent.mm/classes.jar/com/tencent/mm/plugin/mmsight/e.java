package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uf;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements aw
{
  private n uJH;
  private c uJI;
  private c uJJ;
  
  public e()
  {
    AppMethodBeat.i(89317);
    this.uJH = new n();
    this.uJI = new e.1(this);
    this.uJJ = new c() {};
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
    o.aJD().a(this.uJH);
    a.GpY.b(this.uJJ);
    a.GpY.c(this.uJI);
    AppMethodBeat.o(89318);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89319);
    o.aJD().b(this.uJH);
    a.GpY.d(this.uJJ);
    j.uMV.avJ();
    a.GpY.d(this.uJI);
    AppMethodBeat.o(89319);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.e
 * JD-Core Version:    0.7.0.1
 */