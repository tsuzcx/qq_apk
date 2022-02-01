package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderTopicFollowData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
public final class bk
  implements a
{
  public final bds dMU;
  
  public bk(bds parambds)
  {
    AppMethodBeat.i(248850);
    this.dMU = parambds;
    AppMethodBeat.o(248850);
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248849);
    int i = bk.class.getName().hashCode();
    AppMethodBeat.o(248849);
    return i;
  }
  
  public final long lT()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bk
 * JD-Core Version:    0.7.0.1
 */