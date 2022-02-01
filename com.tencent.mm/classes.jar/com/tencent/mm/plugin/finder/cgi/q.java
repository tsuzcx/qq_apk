package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/FinderBaseRequestFactory;", "", "()V", "create", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"})
public final class q
{
  public static final q qXH;
  
  static
  {
    AppMethodBeat.i(201153);
    qXH = new q();
    AppMethodBeat.o(201153);
  }
  
  public static aiu a(anm paramanm)
  {
    AppMethodBeat.i(201152);
    aiu localaiu = new aiu();
    Object localObject = d.rDa;
    d.a(localaiu);
    localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localaiu.EDy = ((e)localObject).agA().getInt(ah.a.GVw, 0);
    localaiu.EDB = new xb();
    if (paramanm != null)
    {
      localaiu.scene = paramanm.rfR;
      localaiu.EDB.qox = paramanm.qox;
      localaiu.EDB.qom = paramanm.qom;
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("sessionId", paramanm.sessionId);
      label110:
      localaiu.EDB.Erv = ((JSONObject)localObject).toString();
      AppMethodBeat.o(201152);
      return localaiu;
    }
    catch (Exception paramanm)
    {
      break label110;
    }
  }
  
  public static aiu csi()
  {
    AppMethodBeat.i(201151);
    aiu localaiu = new aiu();
    Object localObject = d.rDa;
    d.a(localaiu);
    localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localaiu.EDy = ((e)localObject).agA().getInt(ah.a.GVw, 0);
    AppMethodBeat.o(201151);
    return localaiu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.q
 * JD-Core Version:    0.7.0.1
 */