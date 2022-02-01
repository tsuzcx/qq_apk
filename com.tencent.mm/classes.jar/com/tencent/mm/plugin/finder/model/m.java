package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.recyclerview.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "getCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setCommentObj", "contentCollapse", "getContentCollapse", "setContentCollapse", "hasBlink", "getHasBlink", "setHasBlink", "isAutoExpand", "setAutoExpand", "isFriendComment", "setFriendComment", "remainLevel2Comment", "", "getRemainLevel2Comment", "()I", "setRemainLevel2Comment", "(I)V", "replyContentCollapse", "getReplyContentCollapse", "setReplyContentCollapse", "replyText", "Landroid/text/SpannableString;", "getReplyText", "()Landroid/text/SpannableString;", "setReplyText", "(Landroid/text/SpannableString;)V", "compare", "obj", "getItemId", "", "getItemType", "Companion", "plugin-finder_release"})
public final class m
  implements i, a
{
  private static final int ski = 1;
  private static final int skj = 2;
  public static final a skk;
  public boolean sjZ;
  public SpannableString ska;
  public boolean skb;
  public boolean skc;
  public boolean skd;
  public boolean ske;
  public int skf;
  public boolean skg;
  public ab skh;
  
  static
  {
    AppMethodBeat.i(178313);
    skk = new a((byte)0);
    ski = 1;
    skj = 2;
    AppMethodBeat.o(178313);
  }
  
  public m(ab paramab)
  {
    AppMethodBeat.i(166383);
    this.skh = paramab;
    if (!bt.isNullOrNil(this.skh.getUsername()))
    {
      paramab = com.tencent.mm.plugin.finder.utils.p.sMo;
      if ((!com.tencent.mm.plugin.finder.utils.p.aiY(this.skh.getUsername())) && (!((PluginFinder)g.ad(PluginFinder.class)).isFriend(this.skh.getUsername()))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.sjZ = bool;
      this.skb = true;
      this.skc = true;
      this.skf = this.skh.field_actionInfo.Gla.expandCommentCount;
      AppMethodBeat.o(166383);
      return;
    }
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(166382);
    d.g.b.p.h(parami, "obj");
    AppMethodBeat.o(166382);
    return 0;
  }
  
  public final int bYk()
  {
    AppMethodBeat.i(166381);
    if (this.skh.field_actionInfo.rID == 0L)
    {
      i = ski;
      AppMethodBeat.o(166381);
      return i;
    }
    int i = skj;
    AppMethodBeat.o(166381);
    return i;
  }
  
  public final long lP()
  {
    return this.skh.field_actionInfo.Gla.commentId;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment$Companion;", "", "()V", "ITEM_TYPE_LEVEL1", "", "getITEM_TYPE_LEVEL1", "()I", "ITEM_TYPE_LEVEL2", "getITEM_TYPE_LEVEL2", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.m
 * JD-Core Version:    0.7.0.1
 */