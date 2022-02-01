package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.wb;
import com.tencent.mm.model.bd;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements bd
{
  private n zsS;
  private IListener zsT;
  private IListener zsU;
  
  public e()
  {
    AppMethodBeat.i(89317);
    this.zsS = new n();
    this.zsT = new IListener() {};
    this.zsU = new IListener() {};
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
    o.bho().a(this.zsS);
    EventCenter.instance.add(this.zsU);
    EventCenter.instance.addListener(this.zsT);
    AppMethodBeat.o(89318);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89319);
    o.bho().b(this.zsS);
    EventCenter.instance.removeListener(this.zsU);
    k.zwi.aRR();
    EventCenter.instance.removeListener(this.zsT);
    AppMethodBeat.o(89319);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.e
 * JD-Core Version:    0.7.0.1
 */