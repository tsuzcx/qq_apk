package com.tencent.mm.plugin.finder.live.model;

import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bgh;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "setMsg", "getContent", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromUserName", "getFromUserNickName", "getLocalClientMsgId", "getSeq", "", "getToContact", "getToUserName", "getToUserNickName", "getType", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class h
  implements aq
{
  public bdm CER;
  
  public h(bdm parambdm)
  {
    this.CER = parambdm;
  }
  
  public final long dFp()
  {
    return this.CER.seq;
  }
  
  public final String djQ()
  {
    Object localObject = this.CER.ZOb;
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((bgh)localObject).contact;
    } while (localObject == null);
    return ((FinderContact)localObject).username;
  }
  
  public final String ekt()
  {
    Object localObject = this.CER.ZOb;
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
    return this.CER.ZOb;
  }
  
  public final bgh ekv()
  {
    return this.CER.ZNW;
  }
  
  public final String ekw()
  {
    Object localObject = this.CER.ZNW;
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((bgh)localObject).contact;
    } while (localObject == null);
    return ((FinderContact)localObject).username;
  }
  
  public final String ekx()
  {
    Object localObject = this.CER.ZNW;
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((bgh)localObject).contact;
    } while (localObject == null);
    return ((FinderContact)localObject).nickname;
  }
  
  public final String eky()
  {
    String str2 = this.CER.ZOc;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int ekz()
  {
    s.u(this, "this");
    return 0;
  }
  
  public String getContent()
  {
    return "";
  }
  
  public final int getType()
  {
    return this.CER.msg_type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.h
 * JD-Core Version:    0.7.0.1
 */