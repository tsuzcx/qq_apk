package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.protocal.protobuf.dmf;
import com.tencent.mm.sdk.platformtools.h;
import d.a.e;
import d.aa;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "opList", "", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "opReason", "", "(Ljava/util/List;I)V", "Companion", "UpdateReason", "plugin-appbrand-integration_release"})
public final class ab
  extends c<dmf>
{
  private static final int[] jvN;
  public static final a jvO;
  
  static
  {
    AppMethodBeat.i(50288);
    jvO = new a((byte)0);
    jvN = new int[] { 1, 2, 3, 4 };
    AppMethodBeat.o(50288);
  }
  
  public ab(List<? extends dco> paramList, int paramInt)
  {
    AppMethodBeat.i(50287);
    if (a.aZb())
    {
      if ((!paramList.isEmpty()) && (e.contains(jvN, paramInt))) {}
      for (int i = 1; (aa.KTq) && (i == 0); i = 0)
      {
        paramList = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50287);
        throw paramList;
      }
    }
    b.a locala = new b.a();
    locala.d((a)new dmf());
    locala.Am("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord");
    locala.op(1839);
    dme localdme = new dme();
    localdme.FUf.addAll((Collection)paramList);
    localdme.reason = paramInt;
    locala.c((a)localdme);
    c(locala.aAz());
    AppMethodBeat.o(50287);
  }
  
  public static final dco a(dcn paramdcn)
  {
    AppMethodBeat.i(50290);
    paramdcn = a.a(paramdcn);
    AppMethodBeat.o(50290);
    return paramdcn;
  }
  
  public static final dco a(dcn paramdcn1, dcn paramdcn2)
  {
    AppMethodBeat.i(50289);
    paramdcn1 = a.a(paramdcn1, paramdcn2, null);
    AppMethodBeat.o(50289);
    return paramdcn1;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$Companion;", "", "()V", "UpdateWxaRecordReason_CloseStarList", "", "UpdateWxaRecordReason_CloseTask", "UpdateWxaRecordReason_FromHistory", "UpdateWxaRecordReason_Timeout", "legalReasons", "", "add", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "self", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "prev", "next", "checkParams", "", "delete", "move", "op", "plugin-appbrand-integration_release"})
  public static final class a
  {
    private static dco a(int paramInt, dcn paramdcn1, dcn paramdcn2, dcn paramdcn3)
    {
      AppMethodBeat.i(50283);
      dco localdco = new dco();
      localdco.FMi = paramdcn1;
      localdco.FMl = paramInt;
      localdco.FMj = paramdcn2;
      localdco.FMk = paramdcn3;
      AppMethodBeat.o(50283);
      return localdco;
    }
    
    public static dco a(dcn paramdcn)
    {
      AppMethodBeat.i(50282);
      k.h(paramdcn, "self");
      paramdcn = a(2, paramdcn, null, null);
      AppMethodBeat.o(50282);
      return paramdcn;
    }
    
    public static dco a(dcn paramdcn1, dcn paramdcn2, dcn paramdcn3)
    {
      AppMethodBeat.i(50281);
      k.h(paramdcn1, "self");
      paramdcn1 = a(1, paramdcn1, paramdcn2, paramdcn3);
      AppMethodBeat.o(50281);
      return paramdcn1;
    }
    
    static boolean aZb()
    {
      return h.IS_FLAVOR_RED;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "None", "Timeout", "ClosePullDown", "CloseCollectionList", "History", "plugin-appbrand-integration_release"})
  public static enum b
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(50284);
      b localb1 = new b("None", 0, 0);
      jvP = localb1;
      b localb2 = new b("Timeout", 1, 1);
      jvQ = localb2;
      b localb3 = new b("ClosePullDown", 2, 2);
      jvR = localb3;
      b localb4 = new b("CloseCollectionList", 3, 3);
      jvS = localb4;
      b localb5 = new b("History", 4, 4);
      jvT = localb5;
      jvU = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(50284);
    }
    
    private b(int paramInt)
    {
      this.intValue = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ab
 * JD-Core Version:    0.7.0.1
 */