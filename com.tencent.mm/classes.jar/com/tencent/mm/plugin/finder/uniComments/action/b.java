package com.tencent.mm.plugin.finder.uniComments.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.a.f;
import com.tencent.mm.loader.f.a.g;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.uniComments.storge.c.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/action/UniActionManager;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniActionTask;", "tryTask", "Ljava/lang/Runnable;", "uniEntityItem", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "getUniEntityItem", "()Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "setUniEntityItem", "(Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;)V", "doPost", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "localCommentId", "", "feedUsername", "", "objectId", "objectNonceId", "content", "replyUsername", "replyNickname", "replyCommentId", "replyContent", "username", "nickname", "scene", "", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "reason", "mentionList", "", "Lcom/tencent/mm/plugin/finder/uniComments/MentionContact;", "commentPastedList", "Ljava/util/LinkedList;", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;ILjava/util/List;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;)Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "post", "", "action", "rePost", "unsentComment", "removeWhenNotDoingNetScene", "wantDeleteItem", "tryNext", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a Gaf;
  private static final b Gaj;
  private static final String TAG;
  private com.tencent.mm.loader.f.d<c> Gag;
  public com.tencent.mm.plugin.finder.uniComments.model.b Gah;
  private final Runnable Gai;
  
  static
  {
    AppMethodBeat.i(341641);
    Gaf = new b.a((byte)0);
    TAG = "MicroMsg.MusicUni.ActionManager";
    Gaj = new b();
    AppMethodBeat.o(341641);
  }
  
  public b()
  {
    AppMethodBeat.i(341608);
    this.Gag = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(100), new g(1, (byte)0), 1, "uni_action_post_quene"));
    this.Gai = new b..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(341608);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(341624);
    s.u(paramb, "this$0");
    Object localObject = com.tencent.mm.plugin.finder.uniComments.storge.c.Gbn;
    localObject = c.a.fdQ().fdP();
    if (localObject != null) {
      paramb.a(new c((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject, ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject).Gah));
    }
    AppMethodBeat.o(341624);
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(341617);
    s.u(paramc, "action");
    this.Gag.a((com.tencent.mm.loader.f.c)paramc, (e)new b.b(this));
    AppMethodBeat.o(341617);
  }
  
  public final com.tencent.mm.plugin.finder.uniComments.storge.b a(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, Long paramLong, String paramString6, String paramString7, String paramString8, int paramInt1, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, int paramInt2, List<com.tencent.mm.plugin.finder.uniComments.a> paramList, LinkedList<String> paramLinkedList, com.tencent.mm.plugin.finder.uniComments.model.b paramb)
  {
    AppMethodBeat.i(341652);
    s.u(paramString1, "feedUsername");
    s.u(paramString2, "objectNonceId");
    s.u(paramString4, "replyUsername");
    s.u(paramString5, "replyNickname");
    s.u(paramString7, "username");
    s.u(paramString8, "nickname");
    s.u(paramList, "mentionList");
    s.u(paramb, "uniEntityItem");
    this.Gah = paramb;
    com.tencent.mm.plugin.finder.uniComments.logic.a locala = com.tencent.mm.plugin.finder.uniComments.logic.a.GaM;
    paramString1 = com.tencent.mm.plugin.finder.uniComments.logic.a.a(paramLong2, paramString2, paramString7, paramString1, paramLong, paramString6, paramString4, paramString5, paramString3, paramString8, paramInt1, paramLong1, paramBoolean, paramFinderCommentInfo, paramInt2, paramList, paramLinkedList);
    paramString2 = com.tencent.mm.plugin.finder.uniComments.storge.c.Gbn;
    c.a.fdQ().d(paramString1);
    a(new c(paramString1, paramb));
    AppMethodBeat.o(341652);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.action.b
 * JD-Core Version:    0.7.0.1
 */