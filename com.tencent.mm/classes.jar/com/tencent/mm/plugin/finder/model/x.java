package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/FinderLikeLogic;", "", "()V", "TAG", "", "likeComment", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "objectNonceId", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene1", "", "isPoster", "likeFeed", "likeAction", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isPrivate", "scene", "isShowRecWording", "preIsPrivate", "fromPrivateAccount", "plugin-finder_release"})
public final class x
{
  private static final String TAG = "Finder.FinderLikeLogic";
  public static final x stn;
  
  static
  {
    AppMethodBeat.i(166395);
    stn = new x();
    TAG = "Finder.FinderLikeLogic";
    AppMethodBeat.o(166395);
  }
  
  public static void a(arn paramarn, int paramInt1, FinderItem paramFinderItem, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(203446);
    p.h(paramarn, "contextObj");
    p.h(paramFinderItem, "finderObject");
    Object localObject = a.sEK;
    if (a.ajm("like"))
    {
      AppMethodBeat.o(203446);
      return;
    }
    localObject = e.ywz;
    long l;
    int i;
    if (paramBoolean1)
    {
      l = 0L;
      ((e)localObject).idkeyStat(1278L, l, 1L, false);
      if (!paramBoolean1) {
        break label137;
      }
      i = 2;
      label67:
      if ((!paramBoolean2) && (!paramBoolean4)) {
        break label143;
      }
    }
    label137:
    label143:
    for (int j = 6;; j = 1)
    {
      localObject = i.syT;
      i.a(paramarn, paramFinderItem.getId(), j, i, paramInt1, "", paramInt2, paramBoolean3, paramBoolean5);
      localObject = g.sVv;
      g.a(g.cNz(), paramFinderItem, paramBoolean1, paramBoolean2, paramInt2, paramarn);
      AppMethodBeat.o(203446);
      return;
      l = 1L;
      break;
      i = 1;
      break label67;
    }
  }
  
  public static void a(arn paramarn, long paramLong, String paramString, ab paramab, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(203448);
    p.h(paramarn, "contextObj");
    p.h(paramString, "objectNonceId");
    p.h(paramab, "comment");
    Object localObject = a.sEK;
    if (a.ajm("like"))
    {
      AppMethodBeat.o(203448);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    int i;
    long l;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cJa().value()).intValue() != 1)
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cIj() == 1)
      {
        i = 1;
        ae.i(TAG, "likeComment scene: " + i + ", scene1:" + paramInt);
        localObject = e.ywz;
        if (!paramBoolean1) {
          break label203;
        }
        l = 2L;
        label127:
        ((e)localObject).idkeyStat(1278L, l, 1L, false);
        if (!paramBoolean1) {
          break label211;
        }
      }
    }
    label203:
    label211:
    for (paramInt = 2;; paramInt = 1)
    {
      localObject = i.syT;
      i.a(paramarn, paramLong, 4, paramInt, 1, paramab.getUsername(), i);
      localObject = g.sVv;
      g.a(g.cNz(), paramLong, paramString, paramab, paramBoolean1, i, paramarn, paramBoolean2);
      AppMethodBeat.o(203448);
      return;
      i = paramInt;
      break;
      l = 3L;
      break label127;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.x
 * JD-Core Version:    0.7.0.1
 */