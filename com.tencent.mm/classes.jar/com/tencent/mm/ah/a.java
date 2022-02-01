package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.ys;
import java.util.LinkedList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/mmbizprotodef/WxaCgiLogUtils;", "", "()V", "print", "", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "data-model_release"})
public final class a
{
  public static final a iBk;
  
  static
  {
    AppMethodBeat.i(225247);
    iBk = new a();
    AppMethodBeat.o(225247);
  }
  
  public static final String a(acc paramacc)
  {
    AppMethodBeat.i(225245);
    if (paramacc == null)
    {
      AppMethodBeat.o(225245);
      return "CommRequestSource{NULL}";
    }
    paramacc = "CommRequestSource{open_scene=" + paramacc.dUS + ", is_pre_hot=" + paramacc.LmF + ", sync_type=" + paramacc.LmG + '}';
    AppMethodBeat.o(225245);
    return paramacc;
  }
  
  public static final String a(che paramche)
  {
    AppMethodBeat.i(225246);
    StringBuilder localStringBuilder = new StringBuilder("LaunchWxaAppResponse{");
    if (paramche == null)
    {
      paramche = "NULL";
      paramche = paramche + "}";
      AppMethodBeat.o(225246);
      return paramche;
    }
    Object localObject1;
    if (paramche.MmA == null)
    {
      localObject1 = "NULL_API_INFO";
      localObject1 = new StringBuilder().append((String)localObject1);
      if (paramche.Mmz != null) {
        break label287;
      }
    }
    label287:
    for (paramche = " || NULL_LAUNCH";; paramche = " || launch " + paramche.Mmz.KCD)
    {
      paramche = paramche;
      break;
      Object localObject2 = new StringBuilder("api_info~ fg:");
      if (paramche.MmA.LjS == null) {}
      for (localObject1 = "NULL";; localObject1 = Integer.valueOf(paramche.MmA.LjS.zy.length))
      {
        String str = localObject1;
        localObject2 = str;
        if (paramche.MmA.LjT != null)
        {
          localObject1 = str;
          if (paramche.MmA.LjT.size() > 0) {
            localObject1 = str + " | bg:" + ((b)paramche.MmA.LjT.get(0)).zy.length;
          }
          localObject2 = localObject1;
          if (paramche.MmA.LjT.size() > 1) {
            localObject2 = (String)localObject1 + " | suspend:" + ((b)paramche.MmA.LjT.get(1)).zy.length;
          }
        }
        localObject1 = (String)localObject2 + "~";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.a
 * JD-Core Version:    0.7.0.1
 */