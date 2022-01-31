package com.tencent.mm.plugin.appbrand.appusage;

import a.a.e;
import a.aa;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.protocal.protobuf.cno;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "opList", "", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "opReason", "", "(Ljava/util/List;I)V", "Companion", "UpdateReason", "plugin-appbrand-integration_release"})
public final class z
  extends com.tencent.mm.ai.a<cno>
{
  private static final int[] hcw;
  public static final z.a hcx;
  
  static
  {
    AppMethodBeat.i(134551);
    hcx = new z.a((byte)0);
    hcw = new int[] { 1, 2, 3, 4 };
    AppMethodBeat.o(134551);
  }
  
  public z(List<? extends cgc> paramList, int paramInt)
  {
    AppMethodBeat.i(134550);
    if (z.a.axE())
    {
      if ((!paramList.isEmpty()) && (e.contains(hcw, paramInt))) {}
      for (int i = 1; (aa.BMh) && (i == 0); i = 0)
      {
        paramList = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(134550);
        throw paramList;
      }
    }
    b.a locala = new b.a();
    locala.b((com.tencent.mm.bv.a)new cno());
    locala.rl("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord");
    locala.kT(1839);
    cnn localcnn = new cnn();
    localcnn.xWz.addAll((Collection)paramList);
    localcnn.aXG = paramInt;
    locala.a((com.tencent.mm.bv.a)localcnn);
    a(locala.ado());
    AppMethodBeat.o(134550);
  }
  
  public static final cgc a(cgb paramcgb)
  {
    AppMethodBeat.i(134552);
    paramcgb = z.a.a(paramcgb, null, null);
    AppMethodBeat.o(134552);
    return paramcgb;
  }
  
  public static final cgc b(cgb paramcgb)
  {
    AppMethodBeat.i(134553);
    paramcgb = z.a.b(paramcgb);
    AppMethodBeat.o(134553);
    return paramcgb;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "None", "Timeout", "ClosePullDown", "CloseCollectionList", "History", "plugin-appbrand-integration_release"})
  public static enum b
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(134547);
      b localb1 = new b("None", 0, 0);
      hcy = localb1;
      b localb2 = new b("Timeout", 1, 1);
      hcz = localb2;
      b localb3 = new b("ClosePullDown", 2, 2);
      hcA = localb3;
      b localb4 = new b("CloseCollectionList", 3, 3);
      hcB = localb4;
      b localb5 = new b("History", 4, 4);
      hcC = localb5;
      hcD = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(134547);
    }
    
    private b(int paramInt)
    {
      this.intValue = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.z
 * JD-Core Version:    0.7.0.1
 */