package com.tencent.mm.plugin.finder.live.component.msginterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.protocal.protobuf.azp;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp;", "", "()V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "errType", "getErrType", "setErrType", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "getRespWrapper", "()Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "setRespWrapper", "(Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;)V", "uniqueId", "", "getUniqueId", "()Ljava/lang/String;", "setUniqueId", "(Ljava/lang/String;)V", "toString", "FinderGetLiveMsgRespWrapper", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public a CBl;
  public int errCode;
  public int errType;
  public String hTs = "";
  
  public final String toString()
  {
    AppMethodBeat.i(353163);
    StringBuilder localStringBuilder = new StringBuilder("FinderGetLiveMsgRespWrapper: errCode:").append(this.errCode).append(",errType:").append(this.errType).append(",resp:");
    Object localObject1 = this.CBl;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject2 = localStringBuilder.append(localObject2).append(",reqVisitorRoleType:");
      localObject1 = this.CBl;
      if (localObject1 != null) {
        break label136;
      }
    }
    label136:
    for (localObject1 = null;; localObject1 = Integer.valueOf(((a)localObject1).CuT))
    {
      localObject1 = localObject1 + ",uniqueId:" + this.hTs + ',';
      AppMethodBeat.o(353163);
      return localObject1;
      localObject1 = ((a)localObject1).CBm;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = f.dg(localObject1);
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "reqVisitorRoleType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;I)V", "getReqVisitorRoleType", "()I", "setReqVisitorRoleType", "(I)V", "getResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "setResp", "(Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public azp CBm;
    public int CuT;
    
    public a(azp paramazp, int paramInt)
    {
      this.CBm = paramazp;
      this.CuT = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(353118);
      if (this == paramObject)
      {
        AppMethodBeat.o(353118);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(353118);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.CBm, paramObject.CBm))
      {
        AppMethodBeat.o(353118);
        return false;
      }
      if (this.CuT != paramObject.CuT)
      {
        AppMethodBeat.o(353118);
        return false;
      }
      AppMethodBeat.o(353118);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(353107);
      if (this.CBm == null) {}
      for (int i = 0;; i = this.CBm.hashCode())
      {
        int j = this.CuT;
        AppMethodBeat.o(353107);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(353098);
      String str = "FinderGetLiveMsgRespWrapper(resp=" + this.CBm + ", reqVisitorRoleType=" + this.CuT + ')';
      AppMethodBeat.o(353098);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.a
 * JD-Core Version:    0.7.0.1
 */