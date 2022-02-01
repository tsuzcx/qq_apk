package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.cxb;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.protocal.protobuf.dgp;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.sdk.platformtools.h;
import d.a.e;
import d.aa;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "opList", "", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "opReason", "", "(Ljava/util/List;I)V", "Companion", "UpdateReason", "plugin-appbrand-integration_release"})
public final class ab
  extends c<dgq>
{
  private static final int[] iVx;
  public static final a iVy;
  
  static
  {
    AppMethodBeat.i(50288);
    iVy = new a((byte)0);
    iVx = new int[] { 1, 2, 3, 4 };
    AppMethodBeat.o(50288);
  }
  
  public ab(List<? extends cxc> paramList, int paramInt)
  {
    AppMethodBeat.i(50287);
    if (a.aSe())
    {
      if ((!paramList.isEmpty()) && (e.contains(iVx, paramInt))) {}
      for (int i = 1; (aa.JfW) && (i == 0); i = 0)
      {
        paramList = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50287);
        throw paramList;
      }
    }
    b.a locala = new b.a();
    locala.d((a)new dgq());
    locala.wg("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord");
    locala.nB(1839);
    dgp localdgp = new dgp();
    localdgp.Exd.addAll((Collection)paramList);
    localdgp.bvJ = paramInt;
    locala.c((a)localdgp);
    c(locala.atI());
    AppMethodBeat.o(50287);
  }
  
  public static final cxc a(cxb paramcxb)
  {
    AppMethodBeat.i(50290);
    paramcxb = a.a(paramcxb);
    AppMethodBeat.o(50290);
    return paramcxb;
  }
  
  public static final cxc a(cxb paramcxb1, cxb paramcxb2)
  {
    AppMethodBeat.i(50289);
    paramcxb1 = a.a(paramcxb1, paramcxb2, null);
    AppMethodBeat.o(50289);
    return paramcxb1;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$Companion;", "", "()V", "UpdateWxaRecordReason_CloseStarList", "", "UpdateWxaRecordReason_CloseTask", "UpdateWxaRecordReason_FromHistory", "UpdateWxaRecordReason_Timeout", "legalReasons", "", "add", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "self", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "prev", "next", "checkParams", "", "delete", "move", "op", "plugin-appbrand-integration_release"})
  public static final class a
  {
    private static cxc a(int paramInt, cxb paramcxb1, cxb paramcxb2, cxb paramcxb3)
    {
      AppMethodBeat.i(50283);
      cxc localcxc = new cxc();
      localcxc.Epj = paramcxb1;
      localcxc.Epm = paramInt;
      localcxc.Epk = paramcxb2;
      localcxc.Epl = paramcxb3;
      AppMethodBeat.o(50283);
      return localcxc;
    }
    
    public static cxc a(cxb paramcxb)
    {
      AppMethodBeat.i(50282);
      k.h(paramcxb, "self");
      paramcxb = a(2, paramcxb, null, null);
      AppMethodBeat.o(50282);
      return paramcxb;
    }
    
    public static cxc a(cxb paramcxb1, cxb paramcxb2, cxb paramcxb3)
    {
      AppMethodBeat.i(50281);
      k.h(paramcxb1, "self");
      paramcxb1 = a(1, paramcxb1, paramcxb2, paramcxb3);
      AppMethodBeat.o(50281);
      return paramcxb1;
    }
    
    static boolean aSe()
    {
      return h.IS_FLAVOR_RED;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "None", "Timeout", "ClosePullDown", "CloseCollectionList", "History", "plugin-appbrand-integration_release"})
  public static enum b
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(50284);
      b localb1 = new b("None", 0, 0);
      iVz = localb1;
      b localb2 = new b("Timeout", 1, 1);
      iVA = localb2;
      b localb3 = new b("ClosePullDown", 2, 2);
      iVB = localb3;
      b localb4 = new b("CloseCollectionList", 3, 3);
      iVC = localb4;
      b localb5 = new b("History", 4, 4);
      iVD = localb5;
      iVE = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(50284);
    }
    
    private b(int paramInt)
    {
      this.intValue = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ab
 * JD-Core Version:    0.7.0.1
 */