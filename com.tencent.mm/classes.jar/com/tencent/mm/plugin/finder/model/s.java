package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.b;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "getCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setCommentObj", "contentCollapse", "getContentCollapse", "setContentCollapse", "hasBlink", "getHasBlink", "setHasBlink", "isAutoExpand", "setAutoExpand", "isFriendComment", "setFriendComment", "remainLevel2Comment", "", "getRemainLevel2Comment", "()I", "setRemainLevel2Comment", "(I)V", "replyContentCollapse", "getReplyContentCollapse", "setReplyContentCollapse", "replyText", "Landroid/text/SpannableString;", "getReplyText", "()Landroid/text/SpannableString;", "setReplyText", "(Landroid/text/SpannableString;)V", "compare", "obj", "getItemId", "", "getItemType", "Companion", "plugin-finder-base_release"})
public class s
  implements k, a
{
  private static final int zAu = 1;
  private static final int zAv = 2;
  private static final int zAw = 3;
  public static final a zAx;
  public boolean zAl;
  public SpannableString zAm;
  public boolean zAn;
  public boolean zAo;
  public boolean zAp;
  public boolean zAq;
  public int zAr;
  public boolean zAs;
  public am zAt;
  
  static
  {
    AppMethodBeat.i(178313);
    zAx = new a((byte)0);
    zAu = 1;
    zAv = 2;
    zAw = 3;
    AppMethodBeat.o(178313);
  }
  
  public s(am paramam)
  {
    AppMethodBeat.i(166383);
    this.zAt = paramam;
    if (!Util.isNullOrNil(this.zAt.getUsername()))
    {
      paramam = ak.AGL;
      if ((!ak.aFJ(this.zAt.getUsername())) && (!((b)h.ae(b.class)).isFriend(this.zAt.getUsername()))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.zAl = bool;
      this.zAn = true;
      this.zAo = true;
      this.zAr = this.zAt.dYY().expandCommentCount;
      AppMethodBeat.o(166383);
      return;
    }
  }
  
  public int a(k paramk)
  {
    AppMethodBeat.i(166382);
    p.k(paramk, "obj");
    AppMethodBeat.o(166382);
    return 0;
  }
  
  public int bAQ()
  {
    AppMethodBeat.i(166381);
    if (this.zAt.field_actionInfo.xbP == 0L)
    {
      i = zAu;
      AppMethodBeat.o(166381);
      return i;
    }
    int i = zAv;
    AppMethodBeat.o(166381);
    return i;
  }
  
  public long mf()
  {
    AppMethodBeat.i(259305);
    long l = this.zAt.dYY().commentId;
    AppMethodBeat.o(259305);
    return l;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment$Companion;", "", "()V", "ITEM_TYPE_HEADER_CONTENT", "", "getITEM_TYPE_HEADER_CONTENT", "()I", "ITEM_TYPE_LEVEL1", "getITEM_TYPE_LEVEL1", "ITEM_TYPE_LEVEL2", "getITEM_TYPE_LEVEL2", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.s
 * JD-Core Version:    0.7.0.1
 */