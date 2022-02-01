package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FinderLikeLogic;", "", "()V", "TAG", "", "likeComment", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "objectNonceId", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene1", "", "isPoster", "likeFeed", "likeAction", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "isShowRecWording", "plugin-finder_release"})
public final class p
{
  private static final String TAG = "Finder.FinderLikeLogic";
  public static final p qDG;
  
  static
  {
    AppMethodBeat.i(166395);
    qDG = new p();
    TAG = "Finder.FinderLikeLogic";
    AppMethodBeat.o(166395);
  }
  
  public static void a(dzp paramdzp, int paramInt, FinderItem paramFinderItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(198635);
    d.g.b.k.h(paramdzp, "contextObj");
    d.g.b.k.h(paramFinderItem, "finderObject");
    Object localObject = a.qIC;
    if (a.Zv("like"))
    {
      AppMethodBeat.o(198635);
      return;
    }
    localObject = e.vIY;
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
      localObject = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(paramdzp, paramFinderItem.getId(), 1, i, paramInt, "", 2, paramBoolean2);
      localObject = d.qRR;
      d.a(d.crL(), paramFinderItem, paramBoolean1, paramdzp);
      AppMethodBeat.o(198635);
      return;
      l = 1L;
      break;
    }
  }
  
  public static void a(dzp paramdzp, long paramLong, String paramString, com.tencent.mm.plugin.finder.storage.k paramk, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(198636);
    d.g.b.k.h(paramdzp, "contextObj");
    d.g.b.k.h(paramString, "objectNonceId");
    d.g.b.k.h(paramk, "comment");
    Object localObject = a.qIC;
    if (a.Zv("like"))
    {
      AppMethodBeat.o(198636);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    int i;
    long l;
    if (!com.tencent.mm.plugin.finder.storage.b.cqa())
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUn() == 1)
      {
        i = 1;
        ad.i(TAG, "likeComment scene: " + i + ", scene1:" + paramInt);
        localObject = e.vIY;
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
      localObject = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(paramdzp, paramLong, 4, paramInt, 1, paramk.getUsername(), i);
      localObject = d.qRR;
      d.a(d.crL(), paramLong, paramString, paramk, paramBoolean1, i, paramdzp, paramBoolean2);
      AppMethodBeat.o(198636);
      return;
      i = paramInt;
      break;
      l = 3L;
      break label117;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.p
 * JD-Core Version:    0.7.0.1
 */