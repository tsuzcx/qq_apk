package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.sdk.platformtools.j;
import d.a.e;
import d.ac;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "opList", "", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "opReason", "", "(Ljava/util/List;I)V", "Companion", "UpdateReason", "plugin-appbrand-integration_release"})
public final class ab
  extends com.tencent.mm.ak.a<dst>
{
  private static final int[] jSZ;
  public static final a jTa;
  
  static
  {
    AppMethodBeat.i(50288);
    jTa = new a((byte)0);
    jSZ = new int[] { 1, 2, 3, 4 };
    AppMethodBeat.o(50288);
  }
  
  public ab(List<? extends diw> paramList, int paramInt)
  {
    AppMethodBeat.i(50287);
    if (a.bde())
    {
      if ((!paramList.isEmpty()) && (e.contains(jSZ, paramInt))) {}
      for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
      {
        paramList = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50287);
        throw paramList;
      }
    }
    b.a locala = new b.a();
    locala.d((com.tencent.mm.bw.a)new dst());
    locala.DN("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord");
    locala.oS(1839);
    dss localdss = new dss();
    localdss.HYG.addAll((Collection)paramList);
    localdss.reason = paramInt;
    locala.c((com.tencent.mm.bw.a)localdss);
    c(locala.aDS());
    AppMethodBeat.o(50287);
  }
  
  public static final diw a(div paramdiv)
  {
    AppMethodBeat.i(50290);
    paramdiv = a.a(paramdiv);
    AppMethodBeat.o(50290);
    return paramdiv;
  }
  
  public static final diw a(div paramdiv1, div paramdiv2)
  {
    AppMethodBeat.i(50289);
    paramdiv1 = a.a(paramdiv1, paramdiv2, null);
    AppMethodBeat.o(50289);
    return paramdiv1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$Companion;", "", "()V", "UpdateWxaRecordReason_CloseStarList", "", "UpdateWxaRecordReason_CloseTask", "UpdateWxaRecordReason_FromHistory", "UpdateWxaRecordReason_Timeout", "legalReasons", "", "add", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "self", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "prev", "next", "checkParams", "", "delete", "move", "op", "plugin-appbrand-integration_release"})
  public static final class a
  {
    private static diw a(int paramInt, div paramdiv1, div paramdiv2, div paramdiv3)
    {
      AppMethodBeat.i(50283);
      diw localdiw = new diw();
      localdiw.HQz = paramdiv1;
      localdiw.HQC = paramInt;
      localdiw.HQA = paramdiv2;
      localdiw.HQB = paramdiv3;
      AppMethodBeat.o(50283);
      return localdiw;
    }
    
    public static diw a(div paramdiv)
    {
      AppMethodBeat.i(50282);
      p.h(paramdiv, "self");
      paramdiv = a(2, paramdiv, null, null);
      AppMethodBeat.o(50282);
      return paramdiv;
    }
    
    public static diw a(div paramdiv1, div paramdiv2, div paramdiv3)
    {
      AppMethodBeat.i(50281);
      p.h(paramdiv1, "self");
      paramdiv1 = a(1, paramdiv1, paramdiv2, paramdiv3);
      AppMethodBeat.o(50281);
      return paramdiv1;
    }
    
    static boolean bde()
    {
      return j.IS_FLAVOR_RED;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "None", "Timeout", "ClosePullDown", "CloseCollectionList", "History", "plugin-appbrand-integration_release"})
  public static enum b
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(50284);
      b localb1 = new b("None", 0, 0);
      jTb = localb1;
      b localb2 = new b("Timeout", 1, 1);
      jTc = localb2;
      b localb3 = new b("ClosePullDown", 2, 2);
      jTd = localb3;
      b localb4 = new b("CloseCollectionList", 3, 3);
      jTe = localb4;
      b localb5 = new b("History", 4, 4);
      jTf = localb5;
      jTg = new b[] { localb1, localb2, localb3, localb4, localb5 };
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