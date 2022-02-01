package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.us;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements az
{
  private n vYQ;
  private c vYR;
  private c vYS;
  
  public e()
  {
    AppMethodBeat.i(89317);
    this.vYQ = new n();
    this.vYR = new c() {};
    this.vYS = new e.2(this);
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
    o.aNm().a(this.vYQ);
    a.IvT.b(this.vYS);
    a.IvT.c(this.vYR);
    AppMethodBeat.o(89318);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89319);
    o.aNm().b(this.vYQ);
    a.IvT.d(this.vYS);
    k.wcg.ayL();
    a.IvT.d(this.vYR);
    AppMethodBeat.o(89319);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.e
 * JD-Core Version:    0.7.0.1
 */