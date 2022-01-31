package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.protocal.protobuf.dac;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends a<jd>
{
  k(List<String> paramList, k.a parama)
  {
    AppMethodBeat.i(129850);
    ab.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(paramList.size()), parama.name(), Integer.valueOf(parama.intValue) });
    jc localjc = new jc();
    localjc.Scene = parama.intValue;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      parama = (String)paramList.next();
      if (!bo.isNullOrNil(parama))
      {
        dac localdac = new dac();
        localdac.xTl = parama;
        localdac.wxN = g.auF().Ai(parama);
        localjc.wuG.add(localdac);
      }
    }
    paramList = new b.a();
    paramList.fsX = localjc;
    paramList.fsY = new jd();
    paramList.funcId = 1192;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    this.rr = paramList.ado();
    AppMethodBeat.o(129850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.k
 * JD-Core Version:    0.7.0.1
 */