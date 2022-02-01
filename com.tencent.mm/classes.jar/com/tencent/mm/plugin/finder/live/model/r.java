package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awq;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveTextMsg;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "setMsg", "getContent", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromUserName", "getFromUserNickName", "getPayLoadContent", "", "getSeq", "", "getType", "", "plugin-finder_release"})
public final class r
  implements t
{
  public awq uke;
  
  public r(awq paramawq)
  {
    AppMethodBeat.i(246272);
    this.uke = paramawq;
    AppMethodBeat.o(246272);
  }
  
  public final long cKo()
  {
    return this.uke.seq;
  }
  
  public final String csW()
  {
    Object localObject = this.uke.LHp;
    if (localObject != null)
    {
      localObject = ((avn)localObject).contact;
      if (localObject != null) {
        return ((FinderContact)localObject).username;
      }
    }
    return null;
  }
  
  public final String dfr()
  {
    Object localObject = this.uke.LHp;
    if (localObject != null)
    {
      localObject = ((avn)localObject).contact;
      if (localObject != null) {
        return ((FinderContact)localObject).nickname;
      }
    }
    return null;
  }
  
  public final avn dfs()
  {
    return this.uke.LHp;
  }
  
  public final Object dft()
  {
    return null;
  }
  
  public final String getContent()
  {
    return this.uke.content;
  }
  
  public final int getType()
  {
    return this.uke.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.r
 * JD-Core Version:    0.7.0.1
 */