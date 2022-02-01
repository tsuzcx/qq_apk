package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.live.b.o.l;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.avn;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveInteractiveMsg;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "setMsg", "getContent", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromUserName", "getFromUserNickName", "getPayLoadContent", "", "getSeq", "", "getType", "", "plugin-finder_release"})
public final class f
  implements t
{
  public aut uio;
  
  public f(aut paramaut)
  {
    AppMethodBeat.i(246104);
    this.uio = paramaut;
    AppMethodBeat.o(246104);
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
  
  public final Object dft()
  {
    return null;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(246103);
    int i = this.uio.ybm;
    Object localObject = o.l.hHy;
    if (i == o.l.aFP())
    {
      avb localavb = new avb();
      localObject = this.uio.LFB;
      if (localObject != null) {}
      for (localObject = ((b)localObject).toByteArray();; localObject = null)
      {
        localavb.parseFrom((byte[])localObject);
        localObject = localavb.content;
        AppMethodBeat.o(246103);
        return localObject;
      }
    }
    localObject = o.l.hHy;
    o.l.aFO();
    AppMethodBeat.o(246103);
    return "";
  }
  
  public final int getType()
  {
    return this.uio.ybm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.f
 * JD-Core Version:    0.7.0.1
 */