package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "blinkDuration", "", "getBlinkDuration", "()J", "setBlinkDuration", "(J)V", "getCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setCommentObj", "contentCollapse", "getContentCollapse", "setContentCollapse", "hasBlink", "getHasBlink", "setHasBlink", "isAutoExpand", "setAutoExpand", "isFriendComment", "setFriendComment", "remainLevel2Comment", "", "getRemainLevel2Comment", "()I", "setRemainLevel2Comment", "(I)V", "replyContentCollapse", "getReplyContentCollapse", "setReplyContentCollapse", "replyText", "Landroid/text/SpannableString;", "getReplyText", "()Landroid/text/SpannableString;", "setReplyText", "(Landroid/text/SpannableString;)V", "compare", "obj", "getItemId", "getItemType", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class t
  implements k, a
{
  private static final int ECD;
  private static final int ECE;
  private static final int ECF;
  public static final a ECt;
  public long AUr;
  public boolean ECA;
  public int ECB;
  public boolean ECC;
  public au ECu;
  public boolean ECv;
  public SpannableString ECw;
  public boolean ECx;
  public boolean ECy;
  public boolean ECz;
  
  static
  {
    AppMethodBeat.i(178313);
    ECt = new a((byte)0);
    ECD = 1;
    ECE = 2;
    ECF = 3;
    AppMethodBeat.o(178313);
  }
  
  public t(au paramau)
  {
    AppMethodBeat.i(166383);
    this.ECu = paramau;
    if (!Util.isNullOrNil(this.ECu.getUsername()))
    {
      paramau = aw.Gjk;
      if ((!aw.aBI(this.ECu.getUsername())) && (!((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).isFriend(this.ECu.getUsername()))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.ECv = bool;
      this.ECx = true;
      this.ECy = true;
      this.AUr = 1000L;
      this.ECB = this.ECu.eZI().expandCommentCount;
      AppMethodBeat.o(166383);
      return;
    }
  }
  
  public int a(k paramk)
  {
    AppMethodBeat.i(166382);
    s.u(paramk, "obj");
    AppMethodBeat.o(166382);
    return 0;
  }
  
  public long bZA()
  {
    AppMethodBeat.i(332264);
    long l = this.ECu.eZI().commentId;
    AppMethodBeat.o(332264);
    return l;
  }
  
  public int bZB()
  {
    AppMethodBeat.i(166381);
    if (this.ECu.field_actionInfo.ABa == 0L)
    {
      i = ECD;
      AppMethodBeat.o(166381);
      return i;
    }
    int i = ECE;
    AppMethodBeat.o(166381);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment$Companion;", "", "()V", "ITEM_TYPE_HEADER_CONTENT", "", "getITEM_TYPE_HEADER_CONTENT", "()I", "ITEM_TYPE_LEVEL1", "getITEM_TYPE_LEVEL1", "ITEM_TYPE_LEVEL2", "getITEM_TYPE_LEVEL2", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.t
 * JD-Core Version:    0.7.0.1
 */