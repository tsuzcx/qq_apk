package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.fhe;
import com.tencent.mm.protocal.protobuf.fhf;
import com.tencent.mm.protocal.protobuf.fsr;
import com.tencent.mm.protocal.protobuf.fss;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.ak;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "opList", "", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "opReason", "", "(Ljava/util/List;I)V", "Companion", "UpdateReason", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends b<fss>
{
  public static final a qPM;
  private static final int[] qPN;
  
  static
  {
    AppMethodBeat.i(50288);
    qPM = new a((byte)0);
    qPN = new int[] { 1, 2, 3, 4 };
    AppMethodBeat.o(50288);
  }
  
  public z(List<? extends fhf> paramList, int paramInt)
  {
    AppMethodBeat.i(50287);
    if (a.cjk())
    {
      if ((!paramList.isEmpty()) && (k.contains(qPN, paramInt))) {}
      for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
      {
        paramList = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50287);
        throw paramList;
      }
    }
    c.a locala = new c.a();
    locala.otF = ((a)new fss());
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord";
    locala.funcId = 1839;
    fsr localfsr = new fsr();
    localfsr.abRg.addAll((Collection)paramList);
    localfsr.reason = paramInt;
    paramList = ah.aiuX;
    locala.otE = ((a)localfsr);
    paramList = ah.aiuX;
    c(locala.bEF());
    AppMethodBeat.o(50287);
  }
  
  public static final fhf a(fhe paramfhe)
  {
    AppMethodBeat.i(50290);
    paramfhe = a.a(paramfhe);
    AppMethodBeat.o(50290);
    return paramfhe;
  }
  
  public static final fhf a(fhe paramfhe1, fhe paramfhe2)
  {
    AppMethodBeat.i(50289);
    s.u(paramfhe1, "self");
    paramfhe1 = a.a(paramfhe1, paramfhe2, null);
    AppMethodBeat.o(50289);
    return paramfhe1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$Companion;", "", "()V", "UpdateWxaRecordReason_CloseStarList", "", "UpdateWxaRecordReason_CloseTask", "UpdateWxaRecordReason_FromHistory", "UpdateWxaRecordReason_Timeout", "legalReasons", "", "add", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "self", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "prev", "next", "checkParams", "", "delete", "move", "op", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static fhf a(int paramInt, fhe paramfhe1, fhe paramfhe2, fhe paramfhe3)
    {
      AppMethodBeat.i(50283);
      fhf localfhf = new fhf();
      localfhf.abHR = paramfhe1;
      localfhf.abHU = paramInt;
      localfhf.abHS = paramfhe2;
      localfhf.abHT = paramfhe3;
      AppMethodBeat.o(50283);
      return localfhf;
    }
    
    public static fhf a(fhe paramfhe)
    {
      AppMethodBeat.i(50282);
      s.u(paramfhe, "self");
      paramfhe = a(2, paramfhe, null, null);
      AppMethodBeat.o(50282);
      return paramfhe;
    }
    
    public static fhf a(fhe paramfhe1, fhe paramfhe2, fhe paramfhe3)
    {
      AppMethodBeat.i(50281);
      s.u(paramfhe1, "self");
      paramfhe1 = a(1, paramfhe1, paramfhe2, paramfhe3);
      AppMethodBeat.o(50281);
      return paramfhe1;
    }
    
    static boolean cjk()
    {
      return BuildInfo.IS_FLAVOR_RED;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "None", "Timeout", "ClosePullDown", "CloseCollectionList", "History", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    final int qDL;
    
    static
    {
      AppMethodBeat.i(50284);
      qPO = new b("None", 0, 0);
      qPP = new b("Timeout", 1, 1);
      qPQ = new b("ClosePullDown", 2, 2);
      qPR = new b("CloseCollectionList", 3, 3);
      qPS = new b("History", 4, 4);
      qPT = new b[] { qPO, qPP, qPQ, qPR, qPS };
      AppMethodBeat.o(50284);
    }
    
    private b(int paramInt)
    {
      this.qDL = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.z
 * JD-Core Version:    0.7.0.1
 */