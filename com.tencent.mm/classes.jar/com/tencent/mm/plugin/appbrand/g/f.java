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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.List;

public final class f
  extends com.tencent.mm.plugin.fts.ui.a
{
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(129976);
    i locali = new i();
    locali.query = this.query;
    locali.mST = com.tencent.mm.plugin.fts.a.c.d.mTv;
    locali.mSU = this;
    locali.handler = paramak;
    locali.mSS = paramHashSet;
    paramak = ((n)g.G(n.class)).search(7, locali);
    AppMethodBeat.o(129976);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(129978);
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
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTJ = (i + 1);
    }
    AppMethodBeat.o(129978);
    return localObject;
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(129977);
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
      locald.k("21ViewType", "2,");
      locald.k("22OpType", "1,");
      locald.k("23ResultCount", localList.size() + ",");
      locald.k("24ClickPos", ",");
      locald.k("25ClickAppUserName", ",");
      ab.i("MicroMsg.FTSWeAppDetailUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { locald.Fg() });
      h.qsU.e(13963, new Object[] { locald });
    }
    if (bU(paramj.mSW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.mRX = paramj.mRX;
      paramHashSet.mTC = paramj.mSW;
      this.mVO.add(paramHashSet);
    }
    AppMethodBeat.o(129977);
  }
  
  public final int getType()
  {
    return 4224;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.f
 * JD-Core Version:    0.7.0.1
 */