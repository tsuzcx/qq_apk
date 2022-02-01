package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.findersdk.c.a;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderLikeLogic;", "", "()V", "TAG", "", "likeComment", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "objectNonceId", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene1", "", "isPoster", "likeFeed", "likeAction", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isPrivate", "scene", "isShowRecWording", "preIsPrivate", "fromPrivateAccount", "likeMegaVideo", "context", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class al
{
  private static final String TAG = "Finder.FinderLikeLogic";
  public static final al zAN;
  
  static
  {
    AppMethodBeat.i(166395);
    zAN = new al();
    TAG = "Finder.FinderLikeLogic";
    AppMethodBeat.o(166395);
  }
  
  public static void a(bid parambid, int paramInt1, FinderItem paramFinderItem, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(285488);
    p.k(parambid, "contextObj");
    p.k(paramFinderItem, "finderObject");
    Object localObject = a.Bwg;
    if (a.aGS("like"))
    {
      AppMethodBeat.o(285488);
      return;
    }
    localObject = f.Iyx;
    int i;
    label67:
    int j;
    label81:
    int k;
    label121:
    long l2;
    if (paramBoolean1)
    {
      l1 = 0L;
      ((f)localObject).idkeyStat(1278L, l1, 1L, false);
      if (!paramBoolean1) {
        break label211;
      }
      i = 2;
      if ((!paramBoolean2) && (!paramBoolean4)) {
        break label217;
      }
      j = 6;
      localObject = g.AnT;
      localObject = g.Qt(paramFinderItem.getFeedObject().objectType);
      if ((paramBoolean5) || (paramBoolean2) || (paramBoolean4) || (localObject == null)) {
        break label223;
      }
      k = 1;
      localObject = n.zWF;
      l2 = paramFinderItem.getId();
      if (k == 0) {
        break label229;
      }
      k = 1;
      label140:
      localObject = paramFinderItem.getMegaVideo();
      if (localObject == null) {
        break label235;
      }
    }
    label211:
    label217:
    label223:
    label229:
    label235:
    for (long l1 = ((cvy)localObject).id;; l1 = 0L)
    {
      n.a(parambid, l2, j, i, paramInt1, "", paramInt2, paramBoolean3, paramBoolean5, k, l1);
      localObject = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      com.tencent.mm.plugin.finder.upload.action.l.a(com.tencent.mm.plugin.finder.upload.action.l.ecG(), paramFinderItem, paramBoolean1, paramBoolean2, paramInt2, parambid);
      AppMethodBeat.o(285488);
      return;
      l1 = 1L;
      break;
      i = 1;
      break label67;
      j = 1;
      break label81;
      k = 0;
      break label121;
      k = 0;
      break label140;
    }
  }
  
  public static void a(bid parambid, long paramLong, String paramString, am paramam, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(285490);
    p.k(parambid, "contextObj");
    p.k(paramString, "objectNonceId");
    p.k(paramam, "comment");
    Object localObject = a.Bwg;
    if (a.aGS("like"))
    {
      AppMethodBeat.o(285490);
      return;
    }
    localObject = d.AjH;
    int i;
    long l;
    if (((Number)d.dUh().aSr()).intValue() != 1)
    {
      localObject = d.AjH;
      if (d.dTj() == 1)
      {
        i = 1;
        Log.i(TAG, "likeComment scene: " + i + ", scene1:" + paramInt);
        localObject = f.Iyx;
        if (!paramBoolean1) {
          break label203;
        }
        l = 2L;
        label127:
        ((f)localObject).idkeyStat(1278L, l, 1L, false);
        if (!paramBoolean1) {
          break label211;
        }
      }
    }
    label203:
    label211:
    for (paramInt = 2;; paramInt = 1)
    {
      localObject = n.zWF;
      n.a(parambid, paramLong, 4, paramInt, 1, paramam.getUsername(), i);
      localObject = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      com.tencent.mm.plugin.finder.upload.action.l.a(com.tencent.mm.plugin.finder.upload.action.l.ecG(), paramLong, paramString, paramam, paramBoolean1, i, parambid, paramBoolean2);
      AppMethodBeat.o(285490);
      return;
      i = paramInt;
      break;
      l = 3L;
      break label127;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.al
 * JD-Core Version:    0.7.0.1
 */