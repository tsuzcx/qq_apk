package com.tencent.mm.plugin.forcenotify.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/storage/ForceNotifyPermissionStorage;", "", "()V", "getReqSysPermissionCnt", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "setReqSysPermissionCnt", "", "cnt", "plugin-force-notify_release"})
public final class a
{
  public static final a BDY;
  
  static
  {
    AppMethodBeat.i(253321);
    BDY = new a();
    AppMethodBeat.o(253321);
  }
  
  public static void d(ar.a parama, int paramInt)
  {
    AppMethodBeat.i(253318);
    p.k(parama, "key");
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(parama, Integer.valueOf(paramInt));
    AppMethodBeat.o(253318);
  }
  
  public static int h(ar.a parama)
  {
    AppMethodBeat.i(253317);
    p.k(parama, "key");
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(parama, 0);
    AppMethodBeat.o(253317);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.e.a
 * JD-Core Version:    0.7.0.1
 */