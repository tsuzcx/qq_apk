package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveDescMsg;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "setMsg", "getContent", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromUserName", "getFromUserNickName", "getLocalClientMsgId", "getPayLoadContent", "", "getSeq", "", "getToContact", "getToUserName", "getToUserNickName", "getType", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements aq
{
  public bdm CER;
  
  public m(bdm parambdm)
  {
    AppMethodBeat.i(359360);
    this.CER = parambdm;
    AppMethodBeat.o(359360);
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
    return null;
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
    Object localObject = this.CER.ZOb;
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
    AppMethodBeat.i(359432);
    s.u(this, "this");
    AppMethodBeat.o(359432);
    return 0;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(359388);
    Object localObject2 = this.CER.ZNY;
    if (localObject2 == null)
    {
      AppMethodBeat.o(359388);
      return "";
    }
    Object localObject1 = new bez();
    a locala = (a)localObject1;
    localObject2 = ((b)localObject2).toByteArray();
    try
    {
      locala.parseFrom((byte[])localObject2);
      localObject1 = ((bez)localObject1).description;
      if (localObject1 == null)
      {
        AppMethodBeat.o(359388);
        return "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
      }
      AppMethodBeat.o(359388);
    }
    return localObject1;
  }
  
  public final int getType()
  {
    return this.CER.msg_type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.m
 * JD-Core Version:    0.7.0.1
 */