package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.bbd;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveTextMsg;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "setMsg", "getContent", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromUserName", "getFromUserNickName", "getLocalClientMsgId", "getPayLoadContent", "", "getSeq", "", "getToContact", "getToUserName", "getToUserNickName", "getType", "", "plugin-finder-base_release"})
public class ak
  implements ao
{
  public bbd yig;
  
  public ak(bbd parambbd)
  {
    AppMethodBeat.i(259868);
    this.yig = parambbd;
    AppMethodBeat.o(259868);
  }
  
  public final String cGy()
  {
    Object localObject = this.yig.zeL;
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
    return this.yig.seq;
  }
  
  public final String dyd()
  {
    Object localObject = this.yig.zeL;
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
    return this.yig.zeL;
  }
  
  public final aza dyf()
  {
    return this.yig.SMO;
  }
  
  public final String dyg()
  {
    return "";
  }
  
  public final String dyh()
  {
    return "";
  }
  
  public final String dyi()
  {
    String str2 = this.yig.SMN;
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
  
  public final bbd dzS()
  {
    return this.yig;
  }
  
  public final String getContent()
  {
    return this.yig.content;
  }
  
  public final int getType()
  {
    return this.yig.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ak
 * JD-Core Version:    0.7.0.1
 */