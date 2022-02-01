package com.tencent.mm.plugin;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.MMActivity;
import java.util.Set;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/IFinderCommonService2;", "Lcom/tencent/mm/kernel/service/IService;", "cgiGetFinderFeedComment", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "objectNonceId", "", "enterScene", "", "scene", "feedUsername", "needObject", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", "username", "down", "justUpdateObjectStatus", "encryptedObjectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "pullScene", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "findCenterFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "firstPosition", "lastPosition", "otherCareType", "", "plugin-finder-base_release"})
public abstract interface c
  extends a
{
  public abstract com.tencent.mm.plugin.finder.utils.b a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Set<Integer> paramSet);
  
  public abstract void a(MMActivity paramMMActivity, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, bid parambid, kotlin.g.a.b<? super com.tencent.mm.an.c.a<att>, x> paramb);
  
  @l(iBK={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.c
 * JD-Core Version:    0.7.0.1
 */