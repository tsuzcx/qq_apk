package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.model.be;
import com.tencent.mm.modelvideo.ag.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements be
{
  private m KUf;
  private IListener KUg;
  private IListener KUh;
  
  public e()
  {
    AppMethodBeat.i(89317);
    this.KUf = new m();
    this.KUg = new SubCoreMMSight.1(this, f.hfK);
    this.KUh = new SubCoreMMSight.2(this, f.hfK);
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
    v.bOm().a(this.KUf);
    this.KUh.alive();
    this.KUg.alive();
    AppMethodBeat.o(89318);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89319);
    v.bOm().b(this.KUf);
    this.KUh.dead();
    j.KXq.bvG();
    this.KUg.dead();
    AppMethodBeat.o(89319);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.e
 * JD-Core Version:    0.7.0.1
 */