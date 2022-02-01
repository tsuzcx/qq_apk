package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.logic.h;
import com.tencent.mm.plugin.finder.upload.action.l;
import com.tencent.mm.plugin.findersdk.d.a;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderLikeLogic;", "", "()V", "TAG", "", "likeComment", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "objectNonceId", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene1", "", "isPoster", "likeFeed", "likeAction", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isPrivate", "scene", "isShowRecWording", "preIsPrivate", "fromPrivateAccount", "likeMegaVideo", "context", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
{
  public static final an ECX;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(166395);
    ECX = new an();
    TAG = "Finder.FinderLikeLogic";
    AppMethodBeat.o(166395);
  }
  
  public static void a(bui parambui, int paramInt1, FinderItem paramFinderItem, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(332153);
    s.u(parambui, "contextObj");
    s.u(paramFinderItem, "finderObject");
    Object localObject = a.Hdr;
    if (a.aDj("like"))
    {
      AppMethodBeat.o(332153);
      return;
    }
    localObject = f.Ozc;
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
        break label207;
      }
      i = 2;
      if ((!paramBoolean2) && (!paramBoolean4)) {
        break label213;
      }
      j = 6;
      localObject = h.FNM;
      localObject = h.TA(paramFinderItem.getFeedObject().objectType);
      if ((paramBoolean5) || (paramBoolean2) || (paramBoolean4) || (localObject == null)) {
        break label219;
      }
      k = 1;
      localObject = z.FrZ;
      l2 = paramFinderItem.getId();
      if (k == 0) {
        break label225;
      }
      k = 1;
      label140:
      localObject = paramFinderItem.getMegaVideo();
      if (localObject != null) {
        break label231;
      }
    }
    label207:
    label213:
    label219:
    label225:
    label231:
    for (long l1 = 0L;; l1 = ((dne)localObject).id)
    {
      z.a(parambui, l2, j, i, paramInt1, "", paramInt2, paramBoolean3, paramBoolean5, k, l1);
      localObject = l.Gdj;
      l.a(l.fek(), paramFinderItem, paramBoolean1, paramBoolean2, paramInt2, parambui);
      AppMethodBeat.o(332153);
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
  
  public static void a(bui parambui, long paramLong, String paramString, au paramau, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(332172);
    s.u(parambui, "contextObj");
    s.u(paramString, "objectNonceId");
    s.u(paramau, "comment");
    Object localObject = a.Hdr;
    if (a.aDj("like"))
    {
      AppMethodBeat.o(332172);
      return;
    }
    localObject = d.FAy;
    int i;
    long l;
    if (((Number)d.eSA().bmg()).intValue() != 1)
    {
      localObject = d.FAy;
      if (d.eRy() == 1)
      {
        i = 1;
        Log.i(TAG, "likeComment scene: " + i + ", scene1:" + paramInt);
        localObject = f.Ozc;
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
      localObject = z.FrZ;
      z.a(parambui, paramLong, 4, paramInt, 1, paramau.getUsername(), i);
      localObject = l.Gdj;
      l.a(l.fek(), paramLong, paramString, paramau, paramBoolean1, i, parambui, paramBoolean2);
      AppMethodBeat.o(332172);
      return;
      i = paramInt;
      break;
      l = 3L;
      break label127;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.an
 * JD-Core Version:    0.7.0.1
 */