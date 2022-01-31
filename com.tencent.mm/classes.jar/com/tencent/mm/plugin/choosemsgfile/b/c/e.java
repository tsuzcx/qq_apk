package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends b
{
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> jfV;
  public LinearLayoutManager jvX;
  d kFw;
  
  public e(com.tencent.mm.plugin.choosemsgfile.ui.a parama)
  {
    super(parama);
    AppMethodBeat.i(54350);
    this.jfV = new ArrayList();
    AppMethodBeat.o(54350);
  }
  
  public final void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(54352);
    ab.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] isFirst:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kFr.gf(paramBoolean);
    if (paramBoolean) {
      this.jfV.clear();
    }
    g.RM();
    g.RO().ac(new e.2(this, paramString2, paramBoolean));
    AppMethodBeat.o(54352);
  }
  
  public final RecyclerView.a bgz()
  {
    AppMethodBeat.i(54351);
    this.kFw = new d(this.kFr, this.jfV);
    a.kFu = new e.4(this);
    this.kFw.kFt = new e.1(this);
    d locald = this.kFw;
    AppMethodBeat.o(54351);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.e
 * JD-Core Version:    0.7.0.1
 */