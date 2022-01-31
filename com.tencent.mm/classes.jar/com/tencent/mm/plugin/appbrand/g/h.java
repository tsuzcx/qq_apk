package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.List;

public final class h
  extends com.tencent.mm.plugin.fts.ui.a
{
  public h(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  protected final com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet)
  {
    i locali = new i();
    locali.bVk = this.bVk;
    locali.kxe = com.tencent.mm.plugin.fts.a.c.d.kxG;
    locali.kxf = this;
    locali.handler = paramah;
    locali.kxd = paramHashSet;
    return ((n)g.t(n.class)).search(7, locali);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    int i = paramInt - parama.kxK - 1;
    l locall = null;
    Object localObject = locall;
    if (i < parama.kxO.size())
    {
      localObject = locall;
      if (i >= 0)
      {
        locall = (l)parama.kxO.get(i);
        localObject = new d(paramInt);
        ((d)localObject).fYx = locall;
        ((d)localObject).kwi = parama.kwi;
        ((d)localObject).cU(locall.type, locall.kwf);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kxW = (i + 1);
    }
    return localObject;
  }
  
  protected final void a(j paramj, HashSet<String> paramHashSet)
  {
    List localList = paramj.kxh;
    if ((localList != null) && (!localList.isEmpty()))
    {
      com.tencent.mm.modelsns.d locald = new com.tencent.mm.modelsns.d();
      String str = this.bVk;
      paramHashSet = str;
      if (str != null) {
        paramHashSet = str.replaceAll(",", " ");
      }
      locald.j("20KeyWordId", paramHashSet + ",");
      locald.j("21ViewType", "1,");
      locald.j("22OpType", "1,");
      locald.j("23ResultCount", localList.size() + ",");
      locald.j("24ClickPos", ",");
      locald.j("25ClickAppUserName", ",");
      y.i("MicroMsg.FTSWeAppUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { locald.uJ() });
      com.tencent.mm.plugin.report.service.h.nFQ.f(13963, new Object[] { locald });
    }
    if (bA(paramj.kxh))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.kxO = paramj.kxh;
      paramHashSet.kwi = paramj.kwi;
      if (paramHashSet.kxO.size() > 3)
      {
        paramHashSet.kxN = true;
        paramHashSet.kxO = paramHashSet.kxO.subList(0, 3);
      }
      this.kzW.add(paramHashSet);
    }
  }
  
  public final int getType()
  {
    return 144;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.h
 * JD-Core Version:    0.7.0.1
 */