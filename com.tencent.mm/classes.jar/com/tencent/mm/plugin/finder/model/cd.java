package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.protocal.protobuf.bpn;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/RVFeedUtil;", "", "()V", "genBaseLocalFeed", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "localType", "", "genLocalItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "wording", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cd
{
  public static final cd EDI;
  
  static
  {
    AppMethodBeat.i(331961);
    EDI = new cd();
    AppMethodBeat.o(331961);
  }
  
  public static b eDJ()
  {
    AppMethodBeat.i(331954);
    s.u("", "wording");
    Object localObject = new bpn();
    ((bpn)localObject).ZXW = 2016;
    ((bpn)localObject).wording = "";
    ah localah = ah.aiuX;
    localObject = new b(new z((bpn)localObject));
    AppMethodBeat.o(331954);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.cd
 * JD-Core Version:    0.7.0.1
 */