package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwk;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FriendTabLikeTipsState;", "", "state", "", "position", "tipsShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTipsShowInfo;", "(IILcom/tencent/mm/protocal/protobuf/FinderStreamTipsShowInfo;)V", "getPosition", "()I", "setPosition", "(I)V", "getState", "setState", "getTipsShowInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamTipsShowInfo;", "setTipsShowInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamTipsShowInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bz
{
  public bwk Bjn = null;
  public int position = -1;
  public int state = 0;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(332013);
    if (this == paramObject)
    {
      AppMethodBeat.o(332013);
      return true;
    }
    if (!(paramObject instanceof bz))
    {
      AppMethodBeat.o(332013);
      return false;
    }
    paramObject = (bz)paramObject;
    if (this.state != paramObject.state)
    {
      AppMethodBeat.o(332013);
      return false;
    }
    if (this.position != paramObject.position)
    {
      AppMethodBeat.o(332013);
      return false;
    }
    if (!s.p(this.Bjn, paramObject.Bjn))
    {
      AppMethodBeat.o(332013);
      return false;
    }
    AppMethodBeat.o(332013);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(332004);
    int j = this.state;
    int k = this.position;
    if (this.Bjn == null) {}
    for (int i = 0;; i = this.Bjn.hashCode())
    {
      AppMethodBeat.o(332004);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(331994);
    String str = "FriendTabLikeTipsState(state=" + this.state + ", position=" + this.position + ", tipsShowInfo=" + this.Bjn + ')';
    AppMethodBeat.o(331994);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bz
 * JD-Core Version:    0.7.0.1
 */