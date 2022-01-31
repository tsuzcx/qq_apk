package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.ui.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;

public final class f
  extends b
{
  int Fb;
  public c kFG;
  private com.tencent.mm.sdk.b.c kFH;
  private GridLayoutManager kFI;
  int kFJ;
  
  public f(a parama)
  {
    super(parama);
    AppMethodBeat.i(54368);
    this.Fb = 0;
    this.kFJ = 0;
    this.kFH = new f.1(this);
    AppMethodBeat.o(54368);
  }
  
  public final void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(54375);
    if (paramBoolean)
    {
      this.iVH.clear();
      this.Fb = 0;
    }
    this.kFG.kFv = true;
    this.kFr.gf(paramBoolean);
    g.RM();
    g.RO().ac(new f.5(this, paramString1, paramString2, paramBoolean));
    AppMethodBeat.o(54375);
  }
  
  public final <T extends RecyclerView.i> T bgA()
  {
    AppMethodBeat.i(54374);
    if (this.kFI == null)
    {
      this.kFI = new GridLayoutManager(4);
      this.kFI.afL = new f.3(this);
    }
    GridLayoutManager localGridLayoutManager = this.kFI;
    AppMethodBeat.o(54374);
    return localGridLayoutManager;
  }
  
  public final RecyclerView.a bgz()
  {
    AppMethodBeat.i(54373);
    this.kFG = new c(this.kFr, this.iVH);
    this.kFG.kFt = new f.2(this);
    c localc = this.kFG;
    AppMethodBeat.o(54373);
    return localc;
  }
  
  public final void dA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54369);
    ab.i("MicroMsg.ChooseMsgFileUIController", "onCreate");
    this.kFH.alive();
    b(true, paramString1, paramString2);
    AppMethodBeat.o(54369);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(54372);
    ab.i("MicroMsg.ChooseMsgFileUIController", "onDestroy");
    this.kFH.dead();
    AppMethodBeat.o(54372);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(54371);
    ab.i("MicroMsg.ChooseMsgFileUIController", "onPause");
    AppMethodBeat.o(54371);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(54370);
    ab.i("MicroMsg.ChooseMsgFileUIController", "onResume");
    this.kFG.ajb.notifyChanged();
    AppMethodBeat.o(54370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.f
 * JD-Core Version:    0.7.0.1
 */