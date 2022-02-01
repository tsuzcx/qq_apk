package com.tencent.mm.plugin.finder.uniComments.storge;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "commentObj", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "(Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "getCommentObj", "()Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "setCommentObj", "contentCollapse", "getContentCollapse", "setContentCollapse", "hasBlink", "getHasBlink", "setHasBlink", "isAutoExpand", "setAutoExpand", "isFriendComment", "setFriendComment", "remainLevel2Comment", "", "getRemainLevel2Comment", "()I", "setRemainLevel2Comment", "(I)V", "replyContentCollapse", "getReplyContentCollapse", "setReplyContentCollapse", "replyText", "Landroid/text/SpannableString;", "getReplyText", "()Landroid/text/SpannableString;", "setReplyText", "(Landroid/text/SpannableString;)V", "compare", "obj", "getItemId", "", "getItemType", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements k, a
{
  private static final int ECD;
  private static final int ECE;
  private static final int ECF;
  public static final a Gbo;
  public boolean ECA;
  public int ECB;
  public boolean ECC;
  public boolean ECv;
  public SpannableString ECw;
  public boolean ECx;
  public boolean ECy;
  public boolean ECz;
  public b Gbp;
  
  static
  {
    AppMethodBeat.i(341742);
    Gbo = new a((byte)0);
    ECD = 1;
    ECE = 2;
    ECF = 3;
    AppMethodBeat.o(341742);
  }
  
  public d(b paramb)
  {
    AppMethodBeat.i(341704);
    this.Gbp = paramb;
    if (!Util.isNullOrNil(this.Gbp.getUsername()))
    {
      paramb = aw.Gjk;
      if ((!aw.aBI(this.Gbp.getUsername())) && (!((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).isFriend(this.Gbp.getUsername()))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.ECv = bool;
      this.ECx = true;
      this.ECy = true;
      this.ECB = this.Gbp.eZI().expandCommentCount;
      AppMethodBeat.o(341704);
      return;
    }
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(341777);
    s.u(paramk, "obj");
    AppMethodBeat.o(341777);
    return 0;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(370379);
    long l = this.Gbp.eZI().commentId;
    AppMethodBeat.o(370379);
    return l;
  }
  
  public final int bZB()
  {
    if (this.Gbp.field_actionInfo.ABa == 0L) {
      return ECD;
    }
    return ECE;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment$Companion;", "", "()V", "ITEM_TYPE_HEADER_CONTENT", "", "getITEM_TYPE_HEADER_CONTENT", "()I", "ITEM_TYPE_LEVEL1", "getITEM_TYPE_LEVEL1", "ITEM_TYPE_LEVEL2", "getITEM_TYPE_LEVEL2", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.storge.d
 * JD-Core Version:    0.7.0.1
 */