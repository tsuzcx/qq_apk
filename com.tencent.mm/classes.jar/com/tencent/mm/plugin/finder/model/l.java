package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.view.recyclerview.a;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "getCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setCommentObj", "contentCollapse", "getContentCollapse", "setContentCollapse", "hasBlink", "getHasBlink", "setHasBlink", "isAutoExpand", "setAutoExpand", "isFriendComment", "setFriendComment", "remainLevel2Comment", "", "getRemainLevel2Comment", "()I", "setRemainLevel2Comment", "(I)V", "replyContentCollapse", "getReplyContentCollapse", "setReplyContentCollapse", "replyText", "Landroid/text/SpannableString;", "getReplyText", "()Landroid/text/SpannableString;", "setReplyText", "(Landroid/text/SpannableString;)V", "compare", "obj", "getItemId", "", "getItemType", "Companion", "plugin-finder_release"})
public final class l
  implements h, a
{
  private static final int ruP = 1;
  private static final int ruQ = 2;
  public static final l.a ruR;
  public boolean ruG;
  public SpannableString ruH;
  public boolean ruI;
  public boolean ruJ;
  public boolean ruK;
  public boolean ruL;
  public int ruM;
  public boolean ruN;
  public t ruO;
  
  static
  {
    AppMethodBeat.i(178313);
    ruR = new l.a((byte)0);
    ruP = 1;
    ruQ = 2;
    AppMethodBeat.o(178313);
  }
  
  public l(t paramt)
  {
    AppMethodBeat.i(166383);
    this.ruO = paramt;
    if (!bs.isNullOrNil(this.ruO.getUsername()))
    {
      paramt = n.rPN;
      if ((!n.aeE(this.ruO.getUsername())) && (!((PluginFinder)g.ad(PluginFinder.class)).isFriend(this.ruO.getUsername()))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.ruG = bool;
      this.ruI = true;
      this.ruJ = true;
      this.ruM = this.ruO.field_actionInfo.EDq.expandCommentCount;
      AppMethodBeat.o(166383);
      return;
    }
  }
  
  public final int a(h paramh)
  {
    AppMethodBeat.i(166382);
    k.h(paramh, "obj");
    AppMethodBeat.o(166382);
    return 0;
  }
  
  public final int bTF()
  {
    AppMethodBeat.i(166381);
    if (this.ruO.field_actionInfo.qXu == 0L)
    {
      i = ruP;
      AppMethodBeat.o(166381);
      return i;
    }
    int i = ruQ;
    AppMethodBeat.o(166381);
    return i;
  }
  
  public final long lx()
  {
    return this.ruO.field_actionInfo.EDq.commentId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.l
 * JD-Core Version:    0.7.0.1
 */