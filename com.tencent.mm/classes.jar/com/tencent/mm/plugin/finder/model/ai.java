package com.tencent.mm.plugin.finder.model;

import com.tencent.c.a.a.a.b;
import com.tencent.c.a.a.a.b.a.a;
import com.tencent.c.a.a.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.cgi.o;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.upload.action.i;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFollowLogic;", "", "()V", "follow", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "finderUser", "", "opType", "", "feedId", "", "isFromTimeline", "", "isFromShareUI", "enterType", "followAsync", "isPrivate", "plugin-finder_release"})
public final class ai
{
  public static final ai zAJ;
  
  static
  {
    AppMethodBeat.i(166392);
    zAJ = new ai();
    AppMethodBeat.o(166392);
  }
  
  public static void a(bid parambid, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(290785);
    p.k(parambid, "contextObj");
    p.k(paramString, "finderUser");
    Log.i("Finder.FinderFollowLogic", "follow event commentScene:" + parambid.fGo + " user:" + paramString + " opType: " + paramInt + " form " + Util.getStack());
    Object localObject = f.Iyx;
    an localan = an.xci;
    long l;
    if (paramInt == an.dnM())
    {
      l = 5L;
      ((f)localObject).idkeyStat(1278L, l, 1L, false);
      localObject = n.zWF;
      l = parambid.BmO;
      localObject = an.xci;
      if (paramInt != an.dnM()) {
        break label201;
      }
    }
    label201:
    for (int i = 1;; i = 2)
    {
      n.a(parambid, l, paramString, i);
      localObject = i.ACa;
      i.a(i.ecE(), paramString, paramInt, paramLong, parambid, paramBoolean);
      parambid = an.xci;
      if (paramInt == an.dnM()) {
        ((b)com.tencent.mm.kernel.h.ag(b.class)).getFinderLiveActionRecordStorage().a(paramString, a.a.ZlJ);
      }
      AppMethodBeat.o(290785);
      return;
      l = 4L;
      break;
    }
  }
  
  public static void a(bid parambid, String paramString, int paramInt1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    AppMethodBeat.i(290783);
    p.k(parambid, "contextObj");
    p.k(paramString, "finderUser");
    Log.i("Finder.FinderFollowLogic", "follow event commentScene:" + parambid.fGo + " user:" + paramString + " opType: " + paramInt1 + " form " + Util.getStack());
    Object localObject = f.Iyx;
    an localan = an.xci;
    long l;
    if (paramInt1 == an.dnM())
    {
      l = 5L;
      ((f)localObject).idkeyStat(1278L, l, 1L, false);
      localObject = n.zWF;
      l = parambid.BmO;
      localObject = an.xci;
      if (paramInt1 != an.dnM()) {
        break label182;
      }
    }
    label182:
    for (int i = 1;; i = 2)
    {
      n.a(parambid, l, paramString, i);
      new o(new com.tencent.mm.plugin.finder.upload.action.h(paramString, paramInt1, paramLong, parambid, false, paramInt2), paramBoolean1, paramBoolean2).bhW();
      AppMethodBeat.o(290783);
      return;
      l = 4L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ai
 * JD-Core Version:    0.7.0.1
 */