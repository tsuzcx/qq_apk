package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.view.recyclerview.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "getCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setCommentObj", "contentCollapse", "getContentCollapse", "setContentCollapse", "hasBlink", "getHasBlink", "setHasBlink", "isAutoExpand", "setAutoExpand", "isFriendComment", "setFriendComment", "remainLevel2Comment", "", "getRemainLevel2Comment", "()I", "setRemainLevel2Comment", "(I)V", "replyContentCollapse", "getReplyContentCollapse", "setReplyContentCollapse", "replyText", "Landroid/text/SpannableString;", "getReplyText", "()Landroid/text/SpannableString;", "setReplyText", "(Landroid/text/SpannableString;)V", "compare", "obj", "getItemId", "", "getItemType", "Companion", "plugin-finder_release"})
public final class n
  implements i, a
{
  private static final int stf = 1;
  private static final int stg = 2;
  public static final n.a sth;
  public boolean ssW;
  public SpannableString ssX;
  public boolean ssY;
  public boolean ssZ;
  public boolean sta;
  public boolean stb;
  public int stc;
  public boolean std;
  public ab ste;
  
  static
  {
    AppMethodBeat.i(178313);
    sth = new n.a((byte)0);
    stf = 1;
    stg = 2;
    AppMethodBeat.o(178313);
  }
  
  public n(ab paramab)
  {
    AppMethodBeat.i(166383);
    this.ste = paramab;
    if (!bu.isNullOrNil(this.ste.getUsername()))
    {
      paramab = com.tencent.mm.plugin.finder.utils.p.sXz;
      if ((!com.tencent.mm.plugin.finder.utils.p.ajV(this.ste.getUsername())) && (!((PluginFinder)g.ad(PluginFinder.class)).isFriend(this.ste.getUsername()))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.ssW = bool;
      this.ssY = true;
      this.ssZ = true;
      this.stc = this.ste.cLl().expandCommentCount;
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
  
  public final int bZz()
  {
    AppMethodBeat.i(166381);
    if (this.ste.field_actionInfo.rQN == 0L)
    {
      i = stf;
      AppMethodBeat.o(166381);
      return i;
    }
    int i = stg;
    AppMethodBeat.o(166381);
    return i;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(224300);
    long l = this.ste.cLl().commentId;
    AppMethodBeat.o(224300);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.n
 * JD-Core Version:    0.7.0.1
 */