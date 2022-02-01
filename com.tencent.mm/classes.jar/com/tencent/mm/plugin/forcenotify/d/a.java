package com.tencent.mm.plugin.forcenotify.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/storage/ForceNotifyPermissionStorage;", "", "()V", "getReqSysPermissionCnt", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "setReqSysPermissionCnt", "", "cnt", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Hoy;
  
  static
  {
    AppMethodBeat.i(274827);
    Hoy = new a();
    AppMethodBeat.o(274827);
  }
  
  public static void d(at.a parama, int paramInt)
  {
    AppMethodBeat.i(274824);
    s.u(parama, "key");
    h.baE().ban().set(parama, Integer.valueOf(paramInt));
    AppMethodBeat.o(274824);
  }
  
  public static int i(at.a parama)
  {
    AppMethodBeat.i(274821);
    s.u(parama, "key");
    int i = h.baE().ban().getInt(parama, 0);
    AppMethodBeat.o(274821);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.d.a
 * JD-Core Version:    0.7.0.1
 */