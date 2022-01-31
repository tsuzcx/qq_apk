package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.List;

public final class h
  extends com.tencent.mm.plugin.fts.ui.a
{
  public h(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(129980);
    i locali = new i();
    locali.query = this.query;
    locali.mST = com.tencent.mm.plugin.fts.a.c.d.mTv;
    locali.mSU = this;
    locali.handler = paramak;
    locali.mSS = paramHashSet;
    paramak = ((n)g.G(n.class)).search(7, locali);
    AppMethodBeat.o(129980);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(129982);
    int i = paramInt - parama.mTy - 1;
    l locall = null;
    Object localObject = locall;
    if (i < parama.mTC.size())
    {
      localObject = locall;
      if (i >= 0)
      {
        locall = (l)parama.mTC.get(i);
        localObject = new d(paramInt);
        ((d)localObject).hrL = locall;
        ((d)localObject).mRX = parama.mRX;
        ((d)localObject).es(locall.type, locall.mRU);
      }
    }
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTJ = (i + 1);
      if (i == parama.mTC.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTH = false;
      }
    }
    AppMethodBeat.o(129982);
    return localObject;
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(129981);
    List localList = paramj.mSW;
    if ((localList != null) && (!localList.isEmpty()))
    {
      com.tencent.mm.modelsns.d locald = new com.tencent.mm.modelsns.d();
      String str = this.query;
      paramHashSet = str;
      if (str != null) {
        paramHashSet = str.replaceAll(",", " ");
      }
      locald.k("20KeyWordId", paramHashSet + ",");
      locald.k("21ViewType", "1,");
      locald.k("22OpType", "1,");
      locald.k("23ResultCount", localList.size() + ",");
      locald.k("24ClickPos", ",");
      locald.k("25ClickAppUserName", ",");
      ab.i("MicroMsg.FTSWeAppUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { locald.Fg() });
      com.tencent.mm.plugin.report.service.h.qsU.e(13963, new Object[] { locald });
    }
    if (bU(paramj.mSW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.mTC = paramj.mSW;
      paramHashSet.mRX = paramj.mRX;
      if (paramHashSet.mTC.size() > 3)
      {
        paramHashSet.mTB = true;
        paramHashSet.mTC = paramHashSet.mTC.subList(0, 3);
      }
      this.mVO.add(paramHashSet);
    }
    AppMethodBeat.o(129981);
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