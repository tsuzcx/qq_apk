package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.recyclerview.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "getCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setCommentObj", "contentCollapse", "getContentCollapse", "setContentCollapse", "hasBlink", "getHasBlink", "setHasBlink", "isAutoExpand", "setAutoExpand", "isFriendComment", "setFriendComment", "remainLevel2Comment", "", "getRemainLevel2Comment", "()I", "setRemainLevel2Comment", "(I)V", "replyContentCollapse", "getReplyContentCollapse", "setReplyContentCollapse", "replyText", "Landroid/text/SpannableString;", "getReplyText", "()Landroid/text/SpannableString;", "setReplyText", "(Landroid/text/SpannableString;)V", "compare", "obj", "getItemId", "", "getItemType", "Companion", "plugin-finder_release"})
public final class h
  implements com.tencent.mm.plugin.finder.feed.model.internal.i, a
{
  private static final int qDB = 1;
  private static final int qDC = 2;
  public static final a qDD;
  public boolean KTp;
  public int KTq;
  public boolean KTr;
  public com.tencent.mm.plugin.finder.storage.k qDA;
  public SpannableString qDv;
  public boolean qDw;
  public boolean qDx;
  public boolean qDy;
  public boolean qDz;
  
  static
  {
    AppMethodBeat.i(178313);
    qDD = new a((byte)0);
    qDB = 1;
    qDC = 2;
    AppMethodBeat.o(178313);
  }
  
  public h(com.tencent.mm.plugin.finder.storage.k paramk)
  {
    AppMethodBeat.i(166383);
    this.qDA = paramk;
    if (!bt.isNullOrNil(this.qDA.getUsername()))
    {
      paramk = com.tencent.mm.plugin.finder.utils.i.qTa;
      if ((!com.tencent.mm.plugin.finder.utils.i.ZS(this.qDA.getUsername())) && (!((PluginFinder)g.ad(PluginFinder.class)).isFriend(this.qDA.getUsername()))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.KTp = bool;
      this.qDw = true;
      this.qDx = true;
      this.KTq = this.qDA.field_actionInfo.Dkk.expandCommentCount;
      AppMethodBeat.o(166383);
      return;
    }
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.i parami)
  {
    AppMethodBeat.i(166382);
    d.g.b.k.h(parami, "obj");
    AppMethodBeat.o(166382);
    return 0;
  }
  
  public final long bMs()
  {
    return this.qDA.field_actionInfo.Dkk.commentId;
  }
  
  public final int bMt()
  {
    AppMethodBeat.i(166381);
    if (this.qDA.field_actionInfo.qoB == 0L)
    {
      i = qDB;
      AppMethodBeat.o(166381);
      return i;
    }
    int i = qDC;
    AppMethodBeat.o(166381);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment$Companion;", "", "()V", "ITEM_TYPE_LEVEL1", "", "getITEM_TYPE_LEVEL1", "()I", "ITEM_TYPE_LEVEL2", "getITEM_TYPE_LEVEL2", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.h
 * JD-Core Version:    0.7.0.1
 */