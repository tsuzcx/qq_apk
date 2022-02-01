package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.storage.f;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/FinderBaseRequestFactory;", "", "()V", "create", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"})
public final class v
{
  public static final v rIR;
  
  static
  {
    AppMethodBeat.i(201093);
    rIR = new v();
    AppMethodBeat.o(201093);
  }
  
  public static alk a(aqy paramaqy)
  {
    AppMethodBeat.i(201092);
    alk localalk = new alk();
    Object localObject = f.sxF;
    f.a(localalk);
    localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localalk.Gli = ((e)localObject).ajl().getInt(al.a.IIe, 0);
    localalk.Gll = new za();
    if (paramaqy != null)
    {
      localalk.scene = paramaqy.rTD;
      localalk.Gll.qXu = paramaqy.qXu;
      localalk.Gll.qXj = paramaqy.qXj;
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("sessionId", paramaqy.sessionId);
      label110:
      localalk.Gll.FYF = ((JSONObject)localObject).toString();
      localalk.xcO = cf.aCL();
      AppMethodBeat.o(201092);
      return localalk;
    }
    catch (Exception paramaqy)
    {
      break label110;
    }
  }
  
  public static alk cxY()
  {
    AppMethodBeat.i(201091);
    alk localalk = new alk();
    Object localObject = f.sxF;
    f.a(localalk);
    localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localalk.Gli = ((e)localObject).ajl().getInt(al.a.IIe, 0);
    AppMethodBeat.o(201091);
    return localalk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.v
 * JD-Core Version:    0.7.0.1
 */