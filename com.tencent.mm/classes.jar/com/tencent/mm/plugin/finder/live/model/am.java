package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bke;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveTextMsg;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "setMsg", "getContent", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromUserName", "getFromUserNickName", "getLocalClientMsgId", "getMsgTime", "", "getPayLoadContent", "", "getSeq", "", "getToContact", "getToUserName", "getToUserNickName", "getType", "setSeq", "", "sq", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class am
  implements aq
{
  public bke CIc;
  
  public am(bke parambke)
  {
    AppMethodBeat.i(360076);
    this.CIc = parambke;
    AppMethodBeat.o(360076);
  }
  
  public final long dFp()
  {
    return this.CIc.seq;
  }
  
  public final String djQ()
  {
    Object localObject = this.CIc.EbJ;
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((bgh)localObject).contact;
    } while (localObject == null);
    return ((FinderContact)localObject).username;
  }
  
  public final Object ekF()
  {
    return null;
  }
  
  public final String ekt()
  {
    Object localObject = this.CIc.EbJ;
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((bgh)localObject).contact;
    } while (localObject == null);
    return ((FinderContact)localObject).nickname;
  }
  
  public final bgh eku()
  {
    return this.CIc.EbJ;
  }
  
  public final bgh ekv()
  {
    return this.CIc.ZTq;
  }
  
  public final String ekw()
  {
    return "";
  }
  
  public final String ekx()
  {
    return "";
  }
  
  public final String eky()
  {
    String str2 = this.CIc.ZTp;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int ekz()
  {
    return this.CIc.ZOd;
  }
  
  public final String getContent()
  {
    return this.CIc.content;
  }
  
  public final int getType()
  {
    return this.CIc.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.am
 * JD-Core Version:    0.7.0.1
 */