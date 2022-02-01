package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.emh;
import com.tencent.mm.protocal.protobuf.emi;
import com.tencent.mm.protocal.protobuf.ewy;
import com.tencent.mm.protocal.protobuf.ewz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "opList", "", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "opReason", "", "(Ljava/util/List;I)V", "Companion", "UpdateReason", "plugin-appbrand-integration_release"})
public final class aa
  extends c<ewz>
{
  private static final int[] nPU;
  public static final a nPV;
  
  static
  {
    AppMethodBeat.i(50288);
    nPV = new a((byte)0);
    nPU = new int[] { 1, 2, 3, 4 };
    AppMethodBeat.o(50288);
  }
  
  public aa(List<? extends emi> paramList, int paramInt)
  {
    AppMethodBeat.i(50287);
    if (a.bJH())
    {
      if ((!paramList.isEmpty()) && (e.contains(nPU, paramInt))) {}
      for (int i = 1; (z.aazO) && (i == 0); i = 0)
      {
        paramList = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50287);
        throw paramList;
      }
    }
    d.a locala = new d.a();
    locala.d((a)new ewz());
    locala.TW("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord");
    locala.vD(1839);
    ewy localewy = new ewy();
    localewy.Uxz.addAll((Collection)paramList);
    localewy.bnA = paramInt;
    locala.c((a)localewy);
    c(locala.bgN());
    AppMethodBeat.o(50287);
  }
  
  public static final emi a(emh paramemh)
  {
    AppMethodBeat.i(50290);
    paramemh = a.a(paramemh);
    AppMethodBeat.o(50290);
    return paramemh;
  }
  
  public static final emi a(emh paramemh1, emh paramemh2)
  {
    AppMethodBeat.i(278870);
    paramemh1 = a.a(paramemh1, null, paramemh2);
    AppMethodBeat.o(278870);
    return paramemh1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$Companion;", "", "()V", "UpdateWxaRecordReason_CloseStarList", "", "UpdateWxaRecordReason_CloseTask", "UpdateWxaRecordReason_FromHistory", "UpdateWxaRecordReason_Timeout", "legalReasons", "", "add", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "self", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "prev", "next", "checkParams", "", "delete", "move", "op", "plugin-appbrand-integration_release"})
  public static final class a
  {
    private static emi a(int paramInt, emh paramemh1, emh paramemh2, emh paramemh3)
    {
      AppMethodBeat.i(50283);
      emi localemi = new emi();
      localemi.UoT = paramemh1;
      localemi.UoW = paramInt;
      localemi.UoU = paramemh2;
      localemi.UoV = paramemh3;
      AppMethodBeat.o(50283);
      return localemi;
    }
    
    public static emi a(emh paramemh)
    {
      AppMethodBeat.i(50282);
      p.k(paramemh, "self");
      paramemh = a(2, paramemh, null, null);
      AppMethodBeat.o(50282);
      return paramemh;
    }
    
    public static emi a(emh paramemh1, emh paramemh2, emh paramemh3)
    {
      AppMethodBeat.i(50281);
      p.k(paramemh1, "self");
      paramemh1 = a(1, paramemh1, paramemh2, paramemh3);
      AppMethodBeat.o(50281);
      return paramemh1;
    }
    
    static boolean bJH()
    {
      return BuildInfo.IS_FLAVOR_RED;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "None", "Timeout", "ClosePullDown", "CloseCollectionList", "History", "plugin-appbrand-integration_release"})
  public static enum b
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(50284);
      b localb1 = new b("None", 0, 0);
      nPW = localb1;
      b localb2 = new b("Timeout", 1, 1);
      nPX = localb2;
      b localb3 = new b("ClosePullDown", 2, 2);
      nPY = localb3;
      b localb4 = new b("CloseCollectionList", 3, 3);
      nPZ = localb4;
      b localb5 = new b("History", 4, 4);
      nQa = localb5;
      nQb = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(50284);
    }
    
    private b(int paramInt)
    {
      this.intValue = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aa
 * JD-Core Version:    0.7.0.1
 */