package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.f;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.dxo;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/FinderBaseRequestFactory;", "", "()V", "create", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"})
public final class am
{
  public static final am KJy;
  
  static
  {
    AppMethodBeat.i(197276);
    KJy = new am();
    AppMethodBeat.o(197276);
  }
  
  public static aht a(dzp paramdzp)
  {
    AppMethodBeat.i(197275);
    aht localaht = new aht();
    Object localObject = f.KWr;
    f.a(localaht);
    localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    localaht.Dko = ((e)localObject).afk().getInt(ae.a.Fxg, 0);
    localaht.Lxl = new dxo();
    if (paramdzp != null)
    {
      localaht.scene = paramdzp.qqE;
      localaht.Lxl.qwV = paramdzp.qwV;
      localaht.Lxl.KHW = paramdzp.KHW;
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("sessionId", paramdzp.sessionId);
      label110:
      localaht.Lxl.LwN = ((JSONObject)localObject).toString();
      AppMethodBeat.o(197275);
      return localaht;
    }
    catch (Exception paramdzp)
    {
      break label110;
    }
  }
  
  public static aht fRS()
  {
    AppMethodBeat.i(197274);
    aht localaht = new aht();
    Object localObject = f.KWr;
    f.a(localaht);
    localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    localaht.Dko = ((e)localObject).afk().getInt(ae.a.Fxg, 0);
    AppMethodBeat.o(197274);
    return localaht;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.am
 * JD-Core Version:    0.7.0.1
 */