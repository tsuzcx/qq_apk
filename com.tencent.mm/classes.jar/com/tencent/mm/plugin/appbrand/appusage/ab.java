package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.drw;
import com.tencent.mm.sdk.platformtools.i;
import d.a.e;
import d.ac;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "opList", "", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "opReason", "", "(Ljava/util/List;I)V", "Companion", "UpdateReason", "plugin-appbrand-integration_release"})
public final class ab
  extends com.tencent.mm.al.a<drw>
{
  private static final int[] jPH;
  public static final a jPI;
  
  static
  {
    AppMethodBeat.i(50288);
    jPI = new a((byte)0);
    jPH = new int[] { 1, 2, 3, 4 };
    AppMethodBeat.o(50288);
  }
  
  public ab(List<? extends dib> paramList, int paramInt)
  {
    AppMethodBeat.i(50287);
    if (a.bcz())
    {
      if ((!paramList.isEmpty()) && (e.contains(jPH, paramInt))) {}
      for (int i = 1; (ac.MKp) && (i == 0); i = 0)
      {
        paramList = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50287);
        throw paramList;
      }
    }
    b.a locala = new b.a();
    locala.d((com.tencent.mm.bx.a)new drw());
    locala.Dl("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord");
    locala.oP(1839);
    drv localdrv = new drv();
    localdrv.HET.addAll((Collection)paramList);
    localdrv.reason = paramInt;
    locala.c((com.tencent.mm.bx.a)localdrv);
    c(locala.aDC());
    AppMethodBeat.o(50287);
  }
  
  public static final dib a(dia paramdia)
  {
    AppMethodBeat.i(50290);
    paramdia = a.a(paramdia);
    AppMethodBeat.o(50290);
    return paramdia;
  }
  
  public static final dib a(dia paramdia1, dia paramdia2)
  {
    AppMethodBeat.i(50289);
    paramdia1 = a.a(paramdia1, paramdia2, null);
    AppMethodBeat.o(50289);
    return paramdia1;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$Companion;", "", "()V", "UpdateWxaRecordReason_CloseStarList", "", "UpdateWxaRecordReason_CloseTask", "UpdateWxaRecordReason_FromHistory", "UpdateWxaRecordReason_Timeout", "legalReasons", "", "add", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "self", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "prev", "next", "checkParams", "", "delete", "move", "op", "plugin-appbrand-integration_release"})
  public static final class a
  {
    private static dib a(int paramInt, dia paramdia1, dia paramdia2, dia paramdia3)
    {
      AppMethodBeat.i(50283);
      dib localdib = new dib();
      localdib.HwQ = paramdia1;
      localdib.HwT = paramInt;
      localdib.HwR = paramdia2;
      localdib.HwS = paramdia3;
      AppMethodBeat.o(50283);
      return localdib;
    }
    
    public static dib a(dia paramdia)
    {
      AppMethodBeat.i(50282);
      p.h(paramdia, "self");
      paramdia = a(2, paramdia, null, null);
      AppMethodBeat.o(50282);
      return paramdia;
    }
    
    public static dib a(dia paramdia1, dia paramdia2, dia paramdia3)
    {
      AppMethodBeat.i(50281);
      p.h(paramdia1, "self");
      paramdia1 = a(1, paramdia1, paramdia2, paramdia3);
      AppMethodBeat.o(50281);
      return paramdia1;
    }
    
    static boolean bcz()
    {
      return i.IS_FLAVOR_RED;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "None", "Timeout", "ClosePullDown", "CloseCollectionList", "History", "plugin-appbrand-integration_release"})
  public static enum b
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(50284);
      b localb1 = new b("None", 0, 0);
      jPJ = localb1;
      b localb2 = new b("Timeout", 1, 1);
      jPK = localb2;
      b localb3 = new b("ClosePullDown", 2, 2);
      jPL = localb3;
      b localb4 = new b("CloseCollectionList", 3, 3);
      jPM = localb4;
      b localb5 = new b("History", 4, 4);
      jPN = localb5;
      jPO = new b[] { localb1, localb2, localb3, localb4, localb5 };
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