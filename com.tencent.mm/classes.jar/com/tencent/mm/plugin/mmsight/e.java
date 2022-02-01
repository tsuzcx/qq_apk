package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tm;
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
  private n tBk;
  private c tBl;
  private c tBm;
  
  public e()
  {
    AppMethodBeat.i(89317);
    this.tBk = new n();
    this.tBl = new c() {};
    this.tBm = new e.2(this);
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
    o.aCN().a(this.tBk);
    a.ESL.b(this.tBm);
    a.ESL.c(this.tBl);
    AppMethodBeat.o(89318);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89319);
    o.aCN().b(this.tBk);
    a.ESL.d(this.tBm);
    j.tEA.aoS();
    a.ESL.d(this.tBl);
    AppMethodBeat.o(89319);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.e
 * JD-Core Version:    0.7.0.1
 */