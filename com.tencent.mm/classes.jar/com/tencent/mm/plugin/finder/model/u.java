package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FinderLikeLogic;", "", "()V", "TAG", "", "likeComment", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "objectNonceId", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene1", "", "isPoster", "likeFeed", "likeAction", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "isShowRecWording", "plugin-finder_release"})
public final class u
{
  private static final String TAG = "Finder.FinderLikeLogic";
  public static final u ruV;
  
  static
  {
    AppMethodBeat.i(166395);
    ruV = new u();
    TAG = "Finder.FinderLikeLogic";
    AppMethodBeat.o(166395);
  }
  
  public static void a(anm paramanm, int paramInt, FinderItem paramFinderItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(202562);
    k.h(paramanm, "contextObj");
    k.h(paramFinderItem, "finderObject");
    Object localObject = a.rBD;
    if (a.aed("like"))
    {
      AppMethodBeat.o(202562);
      return;
    }
    localObject = e.wTc;
    long l;
    if (paramBoolean1)
    {
      l = 0L;
      ((e)localObject).idkeyStat(1278L, l, 1L, false);
      if (!paramBoolean1) {
        break label115;
      }
    }
    label115:
    for (int i = 2;; i = 1)
    {
      localObject = d.rxr;
      d.a(paramanm, paramFinderItem.getId(), 1, i, paramInt, "", 2, paramBoolean2);
      localObject = g.rOb;
      g.a(g.cCH(), paramFinderItem, paramBoolean1, paramanm);
      AppMethodBeat.o(202562);
      return;
      l = 1L;
      break;
    }
  }
  
  public static void a(anm paramanm, long paramLong, String paramString, t paramt, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(202563);
    k.h(paramanm, "contextObj");
    k.h(paramString, "objectNonceId");
    k.h(paramt, "comment");
    Object localObject = a.rBD;
    if (a.aed("like"))
    {
      AppMethodBeat.o(202563);
      return;
    }
    localObject = b.rCU;
    int i;
    long l;
    if (!b.czB())
    {
      localObject = b.rCU;
      if (b.czC() == 1)
      {
        i = 1;
        ac.i(TAG, "likeComment scene: " + i + ", scene1:" + paramInt);
        localObject = e.wTc;
        if (!paramBoolean1) {
          break label193;
        }
        l = 2L;
        label117:
        ((e)localObject).idkeyStat(1278L, l, 1L, false);
        if (!paramBoolean1) {
          break label201;
        }
      }
    }
    label193:
    label201:
    for (paramInt = 2;; paramInt = 1)
    {
      localObject = d.rxr;
      d.a(paramanm, paramLong, 4, paramInt, 1, paramt.getUsername(), i);
      localObject = g.rOb;
      g.a(g.cCH(), paramLong, paramString, paramt, paramBoolean1, i, paramanm, paramBoolean2);
      AppMethodBeat.o(202563);
      return;
      i = paramInt;
      break;
      l = 3L;
      break label117;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.u
 * JD-Core Version:    0.7.0.1
 */