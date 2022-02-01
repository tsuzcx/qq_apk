package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderLikeLogic;", "", "()V", "TAG", "", "likeComment", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "objectNonceId", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene1", "", "isPoster", "likeFeed", "likeAction", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isPrivate", "scene", "isShowRecWording", "preIsPrivate", "fromPrivateAccount", "likeMegaVideo", "context", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class aj
{
  private static final String TAG = "Finder.FinderLikeLogic";
  public static final aj uOw;
  
  static
  {
    AppMethodBeat.i(166395);
    uOw = new aj();
    TAG = "Finder.FinderLikeLogic";
    AppMethodBeat.o(166395);
  }
  
  public static void a(bbn parambbn, int paramInt1, FinderItem paramFinderItem, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(248767);
    p.h(parambbn, "contextObj");
    p.h(paramFinderItem, "finderObject");
    Object localObject = a.vwk;
    if (a.avp("like"))
    {
      AppMethodBeat.o(248767);
      return;
    }
    localObject = e.Cxv;
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
      ((e)localObject).idkeyStat(1278L, l1, 1L, false);
      if (!paramBoolean1) {
        break label211;
      }
      i = 2;
      if ((!paramBoolean2) && (!paramBoolean4)) {
        break label217;
      }
      j = 6;
      localObject = g.vGW;
      localObject = g.Lj(paramFinderItem.getFeedObject().objectType);
      if ((paramBoolean5) || (paramBoolean2) || (paramBoolean4) || (localObject == null)) {
        break label223;
      }
      k = 1;
      localObject = k.vfA;
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
    for (long l1 = ((cng)localObject).id;; l1 = 0L)
    {
      k.a(parambbn, l2, j, i, paramInt1, "", paramInt2, paramBoolean3, paramBoolean5, k, l1);
      localObject = j.vUw;
      j.a(j.dBt(), paramFinderItem, paramBoolean1, paramBoolean2, paramInt2, parambbn);
      AppMethodBeat.o(248767);
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
  
  public static void a(bbn parambbn, long paramLong, String paramString, an paraman, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(248769);
    p.h(parambbn, "contextObj");
    p.h(paramString, "objectNonceId");
    p.h(paraman, "comment");
    Object localObject = a.vwk;
    if (a.avp("like"))
    {
      AppMethodBeat.o(248769);
      return;
    }
    localObject = c.vCb;
    int i;
    long l;
    if (((Number)c.dsP().value()).intValue() != 1)
    {
      localObject = c.vCb;
      if (c.drT() == 1)
      {
        i = 1;
        Log.i(TAG, "likeComment scene: " + i + ", scene1:" + paramInt);
        localObject = e.Cxv;
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
      localObject = k.vfA;
      k.a(parambbn, paramLong, 4, paramInt, 1, paraman.getUsername(), i);
      localObject = j.vUw;
      j.a(j.dBt(), paramLong, paramString, paraman, paramBoolean1, i, parambbn, paramBoolean2);
      AppMethodBeat.o(248769);
      return;
      i = paramInt;
      break;
      l = 3L;
      break label127;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.aj
 * JD-Core Version:    0.7.0.1
 */