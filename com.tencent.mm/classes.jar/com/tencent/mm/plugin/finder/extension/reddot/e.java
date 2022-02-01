package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashSet<Ljava.lang.String;>;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotConverter;", "", "()V", "convertFinderRedDotInfo", "Lcom/tencent/mm/json/JSONObject;", "redDotInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "convertFinderShowInfo", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "tipsID", "", "convertRedDotAtPaths", "paths", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "fakeShowInfoList", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e AQg;
  
  static
  {
    AppMethodBeat.i(366782);
    AQg = new e();
    AppMethodBeat.o(366782);
  }
  
  private static com.tencent.mm.ad.i a(bxq parambxq, String paramString)
  {
    AppMethodBeat.i(366761);
    com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
    locali.au("show_type", parambxq.show_type);
    locali.au("count", parambxq.count);
    locali.m("title", parambxq.title);
    locali.m("icon_url", parambxq.icon_url);
    locali.m("path", parambxq.path);
    locali.au("clear_type", parambxq.aagq);
    locali.m("parent", parambxq.Nnp);
    if (!Util.isNullOrNil(paramString)) {
      locali.m("tips_id", paramString);
    }
    AppMethodBeat.o(366761);
    return locali;
  }
  
  public static String b(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(366773);
    s.u(paramHashSet, "paths");
    Object localObject1 = d.FAy;
    if (((Number)d.eUZ().bmg()).intValue() == 1) {}
    com.tencent.mm.ad.i locali;
    for (int i = 1;; i = 0)
    {
      locali = new com.tencent.mm.ad.i();
      localObject1 = ((cn)h.az(cn.class)).getRedDotManager();
      if (localObject1 != null) {
        break;
      }
      paramHashSet = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.reddot.FinderRedDotManager");
      AppMethodBeat.o(366773);
      throw paramHashSet;
    }
    localObject1 = (i)localObject1;
    Object localObject2;
    bxq localbxq;
    if (i != 0)
    {
      paramHashSet = new ArrayList();
      localObject1 = new bxq();
      ((bxq)localObject1).path = "h5_creator_auth";
      ((bxq)localObject1).Nnp = "";
      ((bxq)localObject1).aagq = 1;
      ((bxq)localObject1).count = 0;
      ((bxq)localObject1).title = "";
      ((bxq)localObject1).icon_url = "";
      ((bxq)localObject1).show_type = 1;
      localObject2 = ah.aiuX;
      paramHashSet.add(localObject1);
      localObject1 = new bxq();
      ((bxq)localObject1).path = "h5_creator_guide";
      ((bxq)localObject1).Nnp = "";
      ((bxq)localObject1).aagq = 1;
      ((bxq)localObject1).count = 3;
      ((bxq)localObject1).title = "";
      ((bxq)localObject1).icon_url = "";
      ((bxq)localObject1).show_type = 2;
      localObject2 = ah.aiuX;
      paramHashSet.add(localObject1);
      localObject1 = new bxq();
      ((bxq)localObject1).path = "h5_creator_original";
      ((bxq)localObject1).Nnp = "";
      ((bxq)localObject1).aagq = 1;
      ((bxq)localObject1).count = 0;
      ((bxq)localObject1).title = "测试";
      ((bxq)localObject1).icon_url = "";
      ((bxq)localObject1).show_type = 3;
      localObject2 = ah.aiuX;
      paramHashSet.add(localObject1);
      localObject2 = ((Iterable)paramHashSet).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localbxq = (bxq)((Iterator)localObject2).next();
        localObject1 = localbxq.path;
        paramHashSet = (HashSet<String>)localObject1;
        if (localObject1 == null) {
          paramHashSet = "";
        }
        locali.m(paramHashSet, a(localbxq, ""));
      }
    }
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      localObject2 = (String)paramHashSet.next();
      s.s(localObject2, "path");
      localbxq = ((i)localObject1).avp((String)localObject2);
      if (localbxq != null) {
        locali.m((String)localObject2, a(localbxq, ""));
      }
    }
    paramHashSet = locali.toString();
    s.s(paramHashSet, "redDotInfoJson.toString()");
    AppMethodBeat.o(366773);
    return paramHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.e
 * JD-Core Version:    0.7.0.1
 */