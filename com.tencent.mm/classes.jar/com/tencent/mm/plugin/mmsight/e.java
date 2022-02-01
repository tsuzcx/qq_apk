package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.wv;
import com.tencent.mm.f.a.xg;
import com.tencent.mm.model.be;
import com.tencent.mm.modelvideo.ac.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements be
{
  private m EYt;
  private IListener EYu;
  private IListener EYv;
  
  public e()
  {
    AppMethodBeat.i(89317);
    this.EYt = new m();
    this.EYu = new IListener() {};
    this.EYv = new IListener() {};
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
    s.bqG().a(this.EYt);
    EventCenter.instance.add(this.EYv);
    EventCenter.instance.addListener(this.EYu);
    AppMethodBeat.o(89318);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89319);
    s.bqG().b(this.EYt);
    EventCenter.instance.removeListener(this.EYv);
    j.FbH.baL();
    EventCenter.instance.removeListener(this.EYu);
    AppMethodBeat.o(89319);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.e
 * JD-Core Version:    0.7.0.1
 */