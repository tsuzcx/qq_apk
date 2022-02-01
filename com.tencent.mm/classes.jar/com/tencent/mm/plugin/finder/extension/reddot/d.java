package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aq.c;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bwj;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotAssert;", "", "()V", "enterObjectId", "", "getEnterObjectId", "()J", "setEnterObjectId", "(J)V", "enterTabType", "", "getEnterTabType", "()I", "setEnterTabType", "(I)V", "enterTipsId", "", "getEnterTipsId", "()Ljava/lang/String;", "setEnterTipsId", "(Ljava/lang/String;)V", "assertBuildRedDotRequest", "", "request", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "assertCgiRedDotFeed", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "assertRefreshEndFeed", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "tabType", "saveEnterRedDotMsg", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d APW;
  private static int APX;
  private static long APY;
  private static String APZ;
  
  static
  {
    AppMethodBeat.i(366804);
    APW = new d();
    APX = -1;
    APZ = "";
    AppMethodBeat.o(366804);
  }
  
  public static void a(aq.d paramd, final List<? extends cc> paramList)
  {
    AppMethodBeat.i(366798);
    s.u(paramd, "resp");
    s.u(paramList, "feedList");
    Object localObject = paramd.dVm().aaeY;
    if ((localObject != null) && (((bwj)localObject).aafs != 0))
    {
      AppMethodBeat.o(366798);
      return;
    }
    localObject = ((Iterable)paramList).iterator();
    if (((Iterator)localObject).hasNext())
    {
      paramList = (cc)((Iterator)localObject).next();
      if ((paramList instanceof BaseFinderFeed))
      {
        paramList = (BaseFinderFeed)paramList;
        label83:
        if (paramList == null) {
          break label112;
        }
      }
    }
    for (;;)
    {
      if (paramList != null)
      {
        if (paramd.dVm().EWw == 0L)
        {
          AppMethodBeat.o(366798);
          return;
          paramList = null;
          break label83;
          label112:
          break;
          paramList = null;
          continue;
        }
        localObject = (e)b.HbT;
        if (paramd.dVm().EWw != paramList.feedObject.getFeedObject().id) {
          break label178;
        }
      }
    }
    label178:
    for (boolean bool = true;; bool = false)
    {
      e.a.a((e)localObject, "finderCgiBackWrongRedDotFeed", bool, null, false, (a)new b(paramd, paramList), 28);
      AppMethodBeat.o(366798);
      return;
    }
  }
  
  public static void c(aq.c paramc)
  {
    AppMethodBeat.i(366792);
    s.u(paramc, "request");
    final p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance");
    long l;
    final int i;
    e locale;
    if (localp != null)
    {
      l = localp.ASz.object_id;
      i = localp.ASz.tab_type;
      if ((i == paramc.hJx) && (l != 0L) && (paramc.EWw != 0L))
      {
        locale = (e)b.HbT;
        if (l != paramc.EWw) {
          break label129;
        }
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      e.a.a(locale, "finderEnterPreloadWrongRedDotRequest", bool, null, false, (a)new a(l, paramc, i, localp), 28);
      AppMethodBeat.o(366792);
      return;
    }
  }
  
  public static void c(p paramp)
  {
    AppMethodBeat.i(366775);
    if (paramp == null)
    {
      APX = -1;
      APY = 0L;
      s.u("", "<set-?>");
      APZ = "";
      AppMethodBeat.o(366775);
      return;
    }
    APX = paramp.ASz.tab_type;
    APY = paramp.ASz.object_id;
    paramp = paramp.field_tipsId;
    s.s(paramp, "ctrInfo.field_tipsId");
    APZ = paramp;
    AppMethodBeat.o(366775);
  }
  
  public static void c(FinderObject paramFinderObject, final int paramInt)
  {
    AppMethodBeat.i(366786);
    s.u(paramFinderObject, "finderObject");
    e locale;
    if ((APY != 0L) && (paramInt == APX))
    {
      locale = (e)b.HbT;
      if (paramFinderObject.id != APY) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      e.a.a(locale, "finderEnterRefreshWrongRedDotFeed", bool, null, false, (a)new c(paramFinderObject, paramInt), 28);
      APX = -1;
      APY = 0L;
      APZ = "";
      AppMethodBeat.o(366786);
      return;
    }
  }
  
  public static long dZe()
  {
    return APY;
  }
  
  public static String dZf()
  {
    return APZ;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<String>
  {
    a(long paramLong, aq.c paramc, int paramInt, p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<String>
  {
    b(aq.d paramd, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<String>
  {
    c(FinderObject paramFinderObject, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.d
 * JD-Core Version:    0.7.0.1
 */