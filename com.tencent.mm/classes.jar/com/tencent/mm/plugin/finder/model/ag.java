package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.cgi.bb.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.upload.action.f;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderFollowLogic;", "", "()V", "follow", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "finderUser", "", "opType", "", "followAsync", "", "isPrivate", "", "plugin-finder_release"})
public final class ag
{
  public static final ag uOs;
  
  static
  {
    AppMethodBeat.i(166392);
    uOs = new ag();
    AppMethodBeat.o(166392);
  }
  
  public static bb a(bbn parambbn, String paramString, int paramInt)
  {
    AppMethodBeat.i(248755);
    p.h(parambbn, "contextObj");
    p.h(paramString, "finderUser");
    Log.i("Finder.FinderFollowLogic", "follow event commentScene:" + parambbn.tyh + " user:" + paramString + " opType: " + paramInt + " form " + Util.getStack());
    Object localObject = com.tencent.mm.plugin.report.e.Cxv;
    bb.a locala = bb.tve;
    long l;
    if (paramInt == bb.cYj())
    {
      l = 5L;
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(1278L, l, 1L, false);
      localObject = k.vfA;
      l = parambbn.wyW;
      localObject = bb.tve;
      if (paramInt != bb.cYj()) {
        break label167;
      }
    }
    label167:
    for (int i = 1;; i = 2)
    {
      k.a(parambbn, l, paramString, i);
      parambbn = new bb(paramString, paramInt, parambbn, parambbn.wyW);
      AppMethodBeat.o(248755);
      return parambbn;
      l = 4L;
      break;
    }
  }
  
  public static void a(bbn parambbn, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(248756);
    p.h(parambbn, "contextObj");
    p.h(paramString, "finderUser");
    Log.i("Finder.FinderFollowLogic", "follow event commentScene:" + parambbn.tyh + " user:" + paramString + " opType: " + paramInt + " form " + Util.getStack());
    Object localObject = com.tencent.mm.plugin.report.e.Cxv;
    bb.a locala = bb.tve;
    long l;
    if (paramInt == bb.cYj())
    {
      l = 5L;
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(1278L, l, 1L, false);
      localObject = k.vfA;
      l = parambbn.wyW;
      localObject = bb.tve;
      if (paramInt != bb.cYj()) {
        break label261;
      }
    }
    label261:
    for (int i = 1;; i = 2)
    {
      k.a(parambbn, l, paramString, i);
      localObject = g.vUn;
      localObject = g.dBr();
      l = parambbn.wyW;
      p.h(paramString, "finderUser");
      p.h(parambbn, "contextObj");
      Log.i(g.TAG, "doFollow " + paramString + ' ' + paramInt + ", feedId = " + l);
      parambbn = new f(paramString, paramInt, l, parambbn, paramBoolean);
      ((Map)((g)localObject).vTX).put(paramString, parambbn);
      ((g)localObject).a((com.tencent.mm.plugin.finder.upload.action.e)parambbn);
      AppMethodBeat.o(248756);
      return;
      l = 4L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ag
 * JD-Core Version:    0.7.0.1
 */