package com.tencent.mm.plugin.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.ui.d.n;
import java.util.Iterator;
import java.util.List;

final class j$a
  implements Runnable
{
  private e mXC;
  private String query;
  
  j$a(j paramj, e parame, String paramString)
  {
    this.query = paramString;
    this.mXC = parame;
  }
  
  public final void run()
  {
    AppMethodBeat.i(61851);
    if ((!j.a(this.mXB)) && (((e)j.b(this.mXB).get(j.b(this.mXB).size() - 1)).getType() == this.mXC.getType())) {
      j.c(this.mXB);
    }
    if ((!j.d(this.mXB)) && (this.mXC.getType() == 256)) {
      j.e(this.mXB);
    }
    j.f(this.mXB).nay = j.g(this.mXB);
    Object localObject = j.b(this.mXB).iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = ((e)((Iterator)localObject).next()).wt(i)) {}
    i = j.h(this.mXB).wt(i);
    this.mXB.setCount(i);
    this.mXB.notifyDataSetChanged();
    localObject = this.mXB;
    ((j)localObject).V(i, j.g((j)localObject));
    if (j.g(this.mXB)) {
      j.f(this.mXB).nae = System.currentTimeMillis();
    }
    AppMethodBeat.o(61851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j.a
 * JD-Core Version:    0.7.0.1
 */