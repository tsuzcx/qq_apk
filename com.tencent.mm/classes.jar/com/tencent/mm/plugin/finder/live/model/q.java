package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.protocal.protobuf.aza;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveInteractiveMsg;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "setMsg", "getContent", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromUserName", "getFromUserNickName", "getLocalClientMsgId", "getPayLoadContent", "", "getSeq", "", "getToContact", "getToUserName", "getToUserNickName", "getType", "", "plugin-finder_release"})
public final class q
  implements ao
{
  public axe yet;
  
  public q(axe paramaxe)
  {
    AppMethodBeat.i(271937);
    this.yet = paramaxe;
    AppMethodBeat.o(271937);
  }
  
  public final String cGy()
  {
    Object localObject = this.yet.SJH;
    if (localObject != null)
    {
      localObject = ((aza)localObject).contact;
      if (localObject != null) {
        return ((FinderContact)localObject).username;
      }
    }
    return null;
  }
  
  public final long cYY()
  {
    return this.yet.seq;
  }
  
  public final String dyd()
  {
    Object localObject = this.yet.SJH;
    if (localObject != null)
    {
      localObject = ((aza)localObject).contact;
      if (localObject != null) {
        return ((FinderContact)localObject).nickname;
      }
    }
    return null;
  }
  
  public final aza dye()
  {
    return this.yet.SJH;
  }
  
  public final aza dyf()
  {
    return this.yet.SJC;
  }
  
  public final String dyg()
  {
    Object localObject = this.yet.SJC;
    if (localObject != null)
    {
      localObject = ((aza)localObject).contact;
      if (localObject != null) {
        return ((FinderContact)localObject).username;
      }
    }
    return null;
  }
  
  public final String dyh()
  {
    Object localObject = this.yet.SJC;
    if (localObject != null)
    {
      localObject = ((aza)localObject).contact;
      if (localObject != null) {
        return ((FinderContact)localObject).nickname;
      }
    }
    return null;
  }
  
  public final String dyi()
  {
    String str2 = this.yet.SJI;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final Object dyn()
  {
    return null;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(271934);
    switch (this.yet.msg_type)
    {
    default: 
      AppMethodBeat.o(271934);
      return "";
    case 20002: 
      aya localaya = new aya();
      Object localObject = this.yet.SJE;
      if (localObject != null) {}
      for (localObject = ((b)localObject).toByteArray();; localObject = null)
      {
        localaya.parseFrom((byte[])localObject);
        localObject = localaya.content;
        AppMethodBeat.o(271934);
        return localObject;
      }
    }
    AppMethodBeat.o(271934);
    return "";
  }
  
  public final int getType()
  {
    return this.yet.msg_type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.q
 * JD-Core Version:    0.7.0.1
 */