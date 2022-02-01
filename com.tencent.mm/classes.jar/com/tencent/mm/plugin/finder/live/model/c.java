package com.tencent.mm.plugin.finder.live.model;

import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avn;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "setMsg", "getContent", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromUserName", "getFromUserNickName", "getSeq", "", "getType", "", "plugin-finder_release"})
public abstract class c
  implements t
{
  aut uio;
  
  public c(aut paramaut)
  {
    this.uio = paramaut;
  }
  
  public final long cKo()
  {
    return this.uio.seq;
  }
  
  public final String csW()
  {
    Object localObject = this.uio.LFE;
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
    Object localObject = this.uio.LFE;
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
    return this.uio.LFE;
  }
  
  public final String getContent()
  {
    return "";
  }
  
  public final int getType()
  {
    return this.uio.ybm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.c
 * JD-Core Version:    0.7.0.1
 */