package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.cml;
import com.tencent.mm.protocal.c.hl;
import com.tencent.mm.protocal.c.hm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends a<hm>
{
  l(List<String> paramList, l.a parama)
  {
    y.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(paramList.size()), parama.name(), Integer.valueOf(parama.fJL) });
    hl localhl = new hl();
    localhl.pyo = parama.fJL;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      parama = (String)paramList.next();
      if (!bk.bl(parama))
      {
        cml localcml = new cml();
        localcml.tMY = parama;
        localcml.sCF = s.sC(parama);
        localhl.sAw.add(localcml);
      }
    }
    paramList = new b.a();
    paramList.ecH = localhl;
    paramList.ecI = new hm();
    paramList.ecG = 1192;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    this.dmK = paramList.Kt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.l
 * JD-Core Version:    0.7.0.1
 */