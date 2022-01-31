package com.tencent.mm.az;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.a.g
{
  SparseArray<LinkedList<g.a>> fLD;
  
  public a()
  {
    AppMethodBeat.i(984);
    this.fLD = new SparseArray();
    AppMethodBeat.o(984);
  }
  
  public final void a(int paramInt, g.a parama)
  {
    AppMethodBeat.i(986);
    if (this.fLD.indexOfKey(paramInt) < 0) {
      this.fLD.put(paramInt, new LinkedList());
    }
    ((LinkedList)this.fLD.get(paramInt)).add(parama);
    AppMethodBeat.o(986);
  }
  
  public final void a(j.b paramb)
  {
    AppMethodBeat.i(985);
    if ((com.tencent.mm.kernel.g.RK().eHt == null) || (com.tencent.mm.kernel.g.RK().eHt.ftA == null))
    {
      AppMethodBeat.o(985);
      return;
    }
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramb);
    localObject = new b((List)localObject);
    com.tencent.mm.kernel.g.RM();
    ((b)localObject).doScene(com.tencent.mm.kernel.g.RK().eHt.ftA, new a.1(this, paramb));
    AppMethodBeat.o(985);
  }
  
  public final void b(int paramInt, g.a parama)
  {
    AppMethodBeat.i(987);
    if (this.fLD.indexOfKey(paramInt) >= 0) {
      ((LinkedList)this.fLD.get(paramInt)).remove(parama);
    }
    AppMethodBeat.o(987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.az.a
 * JD-Core Version:    0.7.0.1
 */