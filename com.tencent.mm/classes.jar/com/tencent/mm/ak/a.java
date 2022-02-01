package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.dgp;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.protocal.protobuf.glb;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mmbizprotodef/WxaCgiLogUtils;", "", "()V", "print", "", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a oip;
  
  static
  {
    AppMethodBeat.i(231016);
    oip = new a();
    AppMethodBeat.o(231016);
  }
  
  public static String a(dgt paramdgt)
  {
    boolean bool = true;
    int i = 0;
    AppMethodBeat.i(231013);
    if (paramdgt == null)
    {
      paramdgt = "NULL";
      paramdgt = s.X("LaunchWxaAppRequest{", paramdgt);
      AppMethodBeat.o(231013);
      return paramdgt;
    }
    StringBuilder localStringBuilder = new StringBuilder("username[").append(paramdgt.aaLU).append("], appId[").append(paramdgt.oOI).append("], sync[");
    label72:
    glb localglb;
    if (paramdgt.aayr == 1)
    {
      localStringBuilder = localStringBuilder.append(bool).append("], instanceId[").append(paramdgt.aaLT).append("], libVersion[");
      localglb = paramdgt.aaLO;
      if (localglb != null) {
        break label138;
      }
    }
    for (;;)
    {
      paramdgt = i + "], " + b(paramdgt.YMR);
      break;
      bool = false;
      break label72;
      label138:
      i = localglb.aaQX;
    }
  }
  
  public static final String a(dgu paramdgu)
  {
    AppMethodBeat.i(231015);
    StringBuilder localStringBuilder = new StringBuilder("LaunchWxaAppResponse{");
    if (paramdgu == null)
    {
      paramdgu = "NULL";
      paramdgu = paramdgu + '}';
      AppMethodBeat.o(231015);
      return paramdgu;
    }
    Object localObject1;
    if (paramdgu.aaMa == null)
    {
      localObject1 = "NULL_API_INFO";
      if (paramdgu.aaLZ != null) {
        break label247;
      }
    }
    label247:
    for (paramdgu = " || NULL_LAUNCH";; paramdgu = s.X(" || launch ", Integer.valueOf(paramdgu.aaLZ.aamK)))
    {
      paramdgu = s.X((String)localObject1, paramdgu);
      break;
      if (paramdgu.aaMa.Zjj == null) {}
      for (localObject1 = "NULL";; localObject1 = Integer.valueOf(paramdgu.aaMa.Zjj.Op.length))
      {
        String str = s.X("api_info~ fg:", localObject1);
        Object localObject2 = str;
        if (paramdgu.aaMa.Zjk != null)
        {
          localObject1 = str;
          if (paramdgu.aaMa.Zjk.size() > 0) {
            localObject1 = str + " | bg:" + ((b)paramdgu.aaMa.Zjk.get(0)).Op.length;
          }
          localObject2 = localObject1;
          if (paramdgu.aaMa.Zjk.size() > 1) {
            localObject2 = (String)localObject1 + " | suspend:" + ((b)paramdgu.aaMa.Zjk.get(1)).Op.length;
          }
        }
        localObject1 = s.X((String)localObject2, "~");
        break;
      }
    }
  }
  
  public static final String b(aeo paramaeo)
  {
    AppMethodBeat.i(231012);
    if (paramaeo == null)
    {
      AppMethodBeat.o(231012);
      return "CommRequestSource{NULL}";
    }
    paramaeo = "CommRequestSource{open_scene=" + paramaeo.hUn + ", is_pre_hot=" + paramaeo.ZmA + ", sync_type=" + paramaeo.ZmB + '}';
    AppMethodBeat.o(231012);
    return paramaeo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ak.a
 * JD-Core Version:    0.7.0.1
 */