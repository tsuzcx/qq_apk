package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.protocal.protobuf.ech;
import com.tencent.mm.protocal.protobuf.emq;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "opList", "", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "opReason", "", "(Ljava/util/List;I)V", "Companion", "UpdateReason", "plugin-appbrand-integration_release"})
public final class aa
  extends c<emr>
{
  private static final int[] kVH;
  public static final a kVI;
  
  static
  {
    AppMethodBeat.i(50288);
    kVI = new a((byte)0);
    kVH = new int[] { 1, 2, 3, 4 };
    AppMethodBeat.o(50288);
  }
  
  public aa(List<? extends ech> paramList, int paramInt)
  {
    AppMethodBeat.i(50287);
    if (a.byt())
    {
      if ((!paramList.isEmpty()) && (e.contains(kVH, paramInt))) {}
      for (int i = 1; (kotlin.aa.SXc) && (i == 0); i = 0)
      {
        paramList = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50287);
        throw paramList;
      }
    }
    d.a locala = new d.a();
    locala.d((a)new emr());
    locala.MB("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord");
    locala.sG(1839);
    emq localemq = new emq();
    localemq.NkN.addAll((Collection)paramList);
    localemq.bDZ = paramInt;
    locala.c((a)localemq);
    c(locala.aXF());
    AppMethodBeat.o(50287);
  }
  
  public static final ech a(ecg paramecg)
  {
    AppMethodBeat.i(50290);
    paramecg = a.a(paramecg);
    AppMethodBeat.o(50290);
    return paramecg;
  }
  
  public static final ech a(ecg paramecg1, ecg paramecg2)
  {
    AppMethodBeat.i(50289);
    paramecg1 = a.a(paramecg1, paramecg2, null);
    AppMethodBeat.o(50289);
    return paramecg1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$Companion;", "", "()V", "UpdateWxaRecordReason_CloseStarList", "", "UpdateWxaRecordReason_CloseTask", "UpdateWxaRecordReason_FromHistory", "UpdateWxaRecordReason_Timeout", "legalReasons", "", "add", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "self", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "prev", "next", "checkParams", "", "delete", "move", "op", "plugin-appbrand-integration_release"})
  public static final class a
  {
    private static ech a(int paramInt, ecg paramecg1, ecg paramecg2, ecg paramecg3)
    {
      AppMethodBeat.i(50283);
      ech localech = new ech();
      localech.Ncw = paramecg1;
      localech.Ncz = paramInt;
      localech.Ncx = paramecg2;
      localech.Ncy = paramecg3;
      AppMethodBeat.o(50283);
      return localech;
    }
    
    public static ech a(ecg paramecg)
    {
      AppMethodBeat.i(50282);
      p.h(paramecg, "self");
      paramecg = a(2, paramecg, null, null);
      AppMethodBeat.o(50282);
      return paramecg;
    }
    
    public static ech a(ecg paramecg1, ecg paramecg2, ecg paramecg3)
    {
      AppMethodBeat.i(50281);
      p.h(paramecg1, "self");
      paramecg1 = a(1, paramecg1, paramecg2, paramecg3);
      AppMethodBeat.o(50281);
      return paramecg1;
    }
    
    static boolean byt()
    {
      return BuildInfo.IS_FLAVOR_RED;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "None", "Timeout", "ClosePullDown", "CloseCollectionList", "History", "plugin-appbrand-integration_release"})
  public static enum b
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(50284);
      b localb1 = new b("None", 0, 0);
      kVJ = localb1;
      b localb2 = new b("Timeout", 1, 1);
      kVK = localb2;
      b localb3 = new b("ClosePullDown", 2, 2);
      kVL = localb3;
      b localb4 = new b("CloseCollectionList", 3, 3);
      kVM = localb4;
      b localb5 = new b("History", 4, 4);
      kVN = localb5;
      kVO = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(50284);
    }
    
    private b(int paramInt)
    {
      this.intValue = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aa
 * JD-Core Version:    0.7.0.1
 */