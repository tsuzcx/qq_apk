package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class e
  implements at
{
  private m oGb;
  private c oGc;
  private c oGd;
  
  public e()
  {
    AppMethodBeat.i(76431);
    this.oGb = new m();
    this.oGc = new e.1(this);
    this.oGd = new e.2(this);
    AppMethodBeat.o(76431);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(76432);
    o.alJ().a(this.oGb);
    a.ymk.b(this.oGd);
    a.ymk.c(this.oGc);
    AppMethodBeat.o(76432);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(76433);
    o.alJ().b(this.oGb);
    a.ymk.d(this.oGd);
    j.oJp.XJ();
    a.ymk.d(this.oGc);
    AppMethodBeat.o(76433);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.e
 * JD-Core Version:    0.7.0.1
 */