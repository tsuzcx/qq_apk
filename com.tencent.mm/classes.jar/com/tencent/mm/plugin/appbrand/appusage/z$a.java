package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.sdk.platformtools.f;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$Companion;", "", "()V", "UpdateWxaRecordReason_CloseStarList", "", "UpdateWxaRecordReason_CloseTask", "UpdateWxaRecordReason_FromHistory", "UpdateWxaRecordReason_Timeout", "legalReasons", "", "add", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "self", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "prev", "next", "checkParams", "", "delete", "move", "op", "plugin-appbrand-integration_release"})
public final class z$a
{
  private static cgc a(int paramInt, cgb paramcgb1, cgb paramcgb2, cgb paramcgb3)
  {
    AppMethodBeat.i(134546);
    cgc localcgc = new cgc();
    localcgc.xQO = paramcgb1;
    localcgc.xQR = paramInt;
    localcgc.xQP = paramcgb2;
    localcgc.xQQ = paramcgb3;
    AppMethodBeat.o(134546);
    return localcgc;
  }
  
  public static cgc a(cgb paramcgb1, cgb paramcgb2, cgb paramcgb3)
  {
    AppMethodBeat.i(134544);
    j.q(paramcgb1, "self");
    paramcgb1 = a(1, paramcgb1, paramcgb2, paramcgb3);
    AppMethodBeat.o(134544);
    return paramcgb1;
  }
  
  static boolean axE()
  {
    return f.IS_FLAVOR_RED;
  }
  
  public static cgc b(cgb paramcgb)
  {
    AppMethodBeat.i(134545);
    j.q(paramcgb, "self");
    paramcgb = a(2, paramcgb, null, null);
    AppMethodBeat.o(134545);
    return paramcgb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.z.a
 * JD-Core Version:    0.7.0.1
 */