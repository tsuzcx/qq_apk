package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.view.recyclerview.i.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "()V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "count", "getCount", "setCount", "friendRecommendCount", "getFriendRecommendCount", "setFriendRecommendCount", "likeCount", "getLikeCount", "setLikeCount", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends i.b
  implements k
{
  public int ECm;
  public String avatar = "";
  public int commentCount;
  public int count;
  public int likeCount;
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(166372);
    s.u(paramk, "obj");
    AppMethodBeat.o(166372);
    return 0;
  }
  
  public final long bZA()
  {
    return 512L;
  }
  
  public final int bZB()
  {
    return -5;
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(166371);
    s.u(paramString, "<set-?>");
    this.avatar = paramString;
    AppMethodBeat.o(166371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.h
 * JD-Core Version:    0.7.0.1
 */