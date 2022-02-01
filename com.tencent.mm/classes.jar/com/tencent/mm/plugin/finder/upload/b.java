package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.f.a.f;
import com.tencent.mm.loader.f.a.g;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.view.ah;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bui;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "tryTask", "Ljava/lang/Runnable;", "doPost", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "localCommentId", "", "feedUsername", "", "objectId", "objectNonceId", "content", "replyUsername", "replyNickname", "replyCommentId", "replyContent", "username", "nickname", "scene", "", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reason", "mentionList", "", "Lcom/tencent/mm/plugin/finder/view/MentionContact;", "commentPastedList", "Ljava/util/LinkedList;", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILjava/util/List;Ljava/util/LinkedList;)Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "post", "", "action", "rePost", "unsentComment", "removeWhenNotDoingNetScene", "wantDeleteItem", "tryNext", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a Gbu;
  private static final b Gbv;
  public static final String TAG;
  public com.tencent.mm.loader.f.d<a> Gag;
  private final Runnable Gai;
  
  static
  {
    AppMethodBeat.i(167722);
    Gbu = new a((byte)0);
    TAG = "Finder.FinderActionManager";
    Gbv = new b();
    AppMethodBeat.o(167722);
  }
  
  public b()
  {
    AppMethodBeat.i(167721);
    this.Gag = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(100), new g(1, (byte)0), 1, "finder_action_post_quene"));
    this.Gai = new b..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(167721);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(342960);
    s.u(paramb, "this$0");
    paramb.fdz();
    AppMethodBeat.o(342960);
  }
  
  public final au a(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, Long paramLong, String paramString6, String paramString7, String paramString8, int paramInt1, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, bui parambui, int paramInt2, List<ah> paramList, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(343002);
    s.u(paramString1, "feedUsername");
    s.u(paramString2, "objectNonceId");
    s.u(paramString4, "replyUsername");
    s.u(paramString5, "replyNickname");
    s.u(paramString7, "username");
    s.u(paramString8, "nickname");
    s.u(paramList, "mentionList");
    com.tencent.mm.plugin.finder.storage.logic.a locala = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
    paramString1 = com.tencent.mm.plugin.finder.storage.logic.a.a(paramLong2, paramString2, paramString7, paramString1, paramLong, paramString6, paramString4, paramString5, paramString3, paramString8, paramInt1, paramLong1, paramBoolean, paramFinderCommentInfo, parambui, paramInt2, paramList, paramLinkedList);
    ((PluginFinder)h.az(PluginFinder.class)).getFinderActionStorage().c(paramString1);
    a(new a(paramString1));
    AppMethodBeat.o(343002);
    return paramString1;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(167719);
    s.u(parama, "action");
    this.Gag.a((com.tencent.mm.loader.f.c)parama, (e)new b(this));
    AppMethodBeat.o(167719);
  }
  
  public final void fdz()
  {
    AppMethodBeat.i(167720);
    au localau = ((PluginFinder)h.az(PluginFinder.class)).getFinderActionStorage().ePF();
    if (localau != null) {
      a(new a(localau));
    }
    AppMethodBeat.o(167720);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderActionManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/FinderActionManager$post$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements e<a>
  {
    b(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.b
 * JD-Core Version:    0.7.0.1
 */