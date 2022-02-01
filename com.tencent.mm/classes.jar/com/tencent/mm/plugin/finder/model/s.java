package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "getCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setCommentObj", "contentCollapse", "getContentCollapse", "setContentCollapse", "hasBlink", "getHasBlink", "setHasBlink", "isAutoExpand", "setAutoExpand", "isFriendComment", "setFriendComment", "remainLevel2Comment", "", "getRemainLevel2Comment", "()I", "setRemainLevel2Comment", "(I)V", "replyContentCollapse", "getReplyContentCollapse", "setReplyContentCollapse", "replyText", "Landroid/text/SpannableString;", "getReplyText", "()Landroid/text/SpannableString;", "setReplyText", "(Landroid/text/SpannableString;)V", "compare", "obj", "getItemId", "", "getItemType", "Companion", "plugin-finder_release"})
public class s
  implements i, a
{
  private static final int uOg = 1;
  private static final int uOh = 2;
  static final int uOi = 3;
  public static final a uOj;
  public boolean uNX;
  public SpannableString uNY;
  public boolean uNZ;
  public boolean uOa;
  public boolean uOb;
  public boolean uOc;
  public int uOd;
  public boolean uOe;
  public an uOf;
  
  static
  {
    AppMethodBeat.i(178313);
    uOj = new a((byte)0);
    uOg = 1;
    uOh = 2;
    uOi = 3;
    AppMethodBeat.o(178313);
  }
  
  public s(an paraman)
  {
    AppMethodBeat.i(166383);
    this.uOf = paraman;
    if (!Util.isNullOrNil(this.uOf.getUsername()))
    {
      paraman = y.vXH;
      if ((!y.awn(this.uOf.getUsername())) && (!((PluginFinder)g.ah(PluginFinder.class)).isFriend(this.uOf.getUsername()))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.uNX = bool;
      this.uNZ = true;
      this.uOa = true;
      this.uOd = this.uOf.dyb().expandCommentCount;
      AppMethodBeat.o(166383);
      return;
    }
  }
  
  public int a(i parami)
  {
    AppMethodBeat.i(166382);
    p.h(parami, "obj");
    AppMethodBeat.o(166382);
    return 0;
  }
  
  public int cxn()
  {
    AppMethodBeat.i(166381);
    if (this.uOf.field_actionInfo.tuf == 0L)
    {
      i = uOg;
      AppMethodBeat.o(166381);
      return i;
    }
    int i = uOh;
    AppMethodBeat.o(166381);
    return i;
  }
  
  public long lT()
  {
    AppMethodBeat.i(248732);
    long l = this.uOf.dyb().commentId;
    AppMethodBeat.o(248732);
    return l;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderFeedComment$Companion;", "", "()V", "ITEM_TYPE_HEADER_CONTENT", "", "getITEM_TYPE_HEADER_CONTENT", "()I", "ITEM_TYPE_LEVEL1", "getITEM_TYPE_LEVEL1", "ITEM_TYPE_LEVEL2", "getITEM_TYPE_LEVEL2", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.s
 * JD-Core Version:    0.7.0.1
 */