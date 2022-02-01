package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.yw;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/mmbizprotodef/WxaCgiLogUtils;", "", "()V", "print", "", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "data-model_release"})
public final class a
{
  public static final a lqO;
  
  static
  {
    AppMethodBeat.i(189304);
    lqO = new a();
    AppMethodBeat.o(189304);
  }
  
  public static final String a(ack paramack)
  {
    AppMethodBeat.i(189292);
    if (paramack == null)
    {
      AppMethodBeat.o(189292);
      return "CommRequestSource{NULL}";
    }
    paramack = "CommRequestSource{open_scene=" + paramack.fOu + ", is_pre_hot=" + paramack.SnY + ", sync_type=" + paramack.SnZ + '}';
    AppMethodBeat.o(189292);
    return paramack;
  }
  
  public static final String a(cqa paramcqa)
  {
    AppMethodBeat.i(189299);
    StringBuilder localStringBuilder = new StringBuilder("LaunchWxaAppResponse{");
    if (paramcqa == null)
    {
      paramcqa = "NULL";
      paramcqa = paramcqa + "}";
      AppMethodBeat.o(189299);
      return paramcqa;
    }
    Object localObject1;
    if (paramcqa.Txv == null)
    {
      localObject1 = "NULL_API_INFO";
      localObject1 = new StringBuilder().append((String)localObject1);
      if (paramcqa.Txu != null) {
        break label287;
      }
    }
    label287:
    for (paramcqa = " || NULL_LAUNCH";; paramcqa = " || launch " + paramcqa.Txu.SZN)
    {
      paramcqa = paramcqa;
      break;
      Object localObject2 = new StringBuilder("api_info~ fg:");
      if (paramcqa.Txv.SkZ == null) {}
      for (localObject1 = "NULL";; localObject1 = Integer.valueOf(paramcqa.Txv.SkZ.UH.length))
      {
        String str = localObject1;
        localObject2 = str;
        if (paramcqa.Txv.Sla != null)
        {
          localObject1 = str;
          if (paramcqa.Txv.Sla.size() > 0) {
            localObject1 = str + " | bg:" + ((b)paramcqa.Txv.Sla.get(0)).UH.length;
          }
          localObject2 = localObject1;
          if (paramcqa.Txv.Sla.size() > 1) {
            localObject2 = (String)localObject1 + " | suspend:" + ((b)paramcqa.Txv.Sla.get(1)).UH.length;
          }
        }
        localObject1 = (String)localObject2 + "~";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.a
 * JD-Core Version:    0.7.0.1
 */