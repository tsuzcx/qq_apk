package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgl;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveInteractiveMsg;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "setMsg", "getContent", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromUserName", "getFromUserNickName", "getLocalClientMsgId", "getPayLoadContent", "", "getSeq", "", "getToContact", "getToUserName", "getToUserNickName", "getType", "", "setSeq", "", "sq", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  implements aq
{
  public bdm CER;
  
  public t(bdm parambdm)
  {
    AppMethodBeat.i(359398);
    this.CER = parambdm;
    AppMethodBeat.o(359398);
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
  
  public final Object ekF()
  {
    bed localbed = null;
    Object localObject1 = null;
    AppMethodBeat.i(359445);
    switch (this.CER.msg_type)
    {
    default: 
      AppMethodBeat.o(359445);
      return null;
    case 20034: 
      localbed = new bed();
      localObject2 = this.CER.ZNY;
      if (localObject2 == null) {}
      for (;;)
      {
        localbed.parseFrom((byte[])localObject1);
        localObject1 = localbed.ZOH;
        AppMethodBeat.o(359445);
        return localObject1;
        localObject1 = ((b)localObject2).toByteArray();
      }
    }
    Object localObject2 = new bdx();
    localObject1 = this.CER.ZNY;
    if (localObject1 == null) {}
    for (localObject1 = localbed;; localObject1 = ((b)localObject1).toByteArray())
    {
      ((bdx)localObject2).parseFrom((byte[])localObject1);
      AppMethodBeat.o(359445);
      return localObject2;
    }
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
    AppMethodBeat.i(359540);
    s.u(this, "this");
    AppMethodBeat.o(359540);
    return 0;
  }
  
  public final String getContent()
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    AppMethodBeat.i(359430);
    switch (this.CER.msg_type)
    {
    default: 
      AppMethodBeat.o(359430);
      return "";
    case 20002: 
      localObject2 = new bes();
      localObject3 = this.CER.ZNY;
      if (localObject3 == null) {}
      for (;;)
      {
        ((bes)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((bes)localObject2).content;
        AppMethodBeat.o(359430);
        return localObject1;
        localObject1 = ((b)localObject3).toByteArray();
      }
    case 20001: 
      AppMethodBeat.o(359430);
      return "";
    case 20032: 
    case 20034: 
      localObject3 = new bed();
      localObject1 = this.CER.ZNY;
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((b)localObject1).toByteArray())
      {
        ((bed)localObject3).parseFrom((byte[])localObject1);
        localObject1 = ((bed)localObject3).content;
        AppMethodBeat.o(359430);
        return localObject1;
      }
    }
    localObject2 = new bgl();
    localObject1 = this.CER.ZNY;
    if (localObject1 == null) {}
    for (localObject1 = localObject3;; localObject1 = ((b)localObject1).toByteArray())
    {
      ((bgl)localObject2).parseFrom((byte[])localObject1);
      localObject1 = ((bgl)localObject2).content;
      AppMethodBeat.o(359430);
      return localObject1;
    }
  }
  
  public final int getType()
  {
    return this.CER.msg_type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.t
 * JD-Core Version:    0.7.0.1
 */