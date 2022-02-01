package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.dzp;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "tryTask", "Ljava/lang/Runnable;", "doPost", "", "localCommentId", "", "feedUsername", "", "objectId", "objectNonceId", "content", "replyUsername", "replyNickname", "replyCommentId", "replyContent", "username", "nickname", "scene", "", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "post", "action", "rePost", "unsentComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "removeWhenNotDoingNetScene", "wantDeleteItem", "tryNext", "Companion", "plugin-finder_release"})
public final class b
{
  public static final String TAG = "Finder.FinderActionManager";
  private static final b qQC;
  public static final a qQD;
  public com.tencent.mm.loader.g.d<a> qQA;
  private final Runnable qQB;
  
  static
  {
    AppMethodBeat.i(167722);
    qQD = new a((byte)0);
    TAG = "Finder.FinderActionManager";
    qQC = new b();
    AppMethodBeat.o(167722);
  }
  
  public b()
  {
    AppMethodBeat.i(167721);
    this.qQA = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finder_action_post_quene"));
    this.qQB = ((Runnable)new c(this));
    AppMethodBeat.o(167721);
  }
  
  public final void a(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, Long paramLong, String paramString6, String paramString7, String paramString8, int paramInt, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, dzp paramdzp)
  {
    AppMethodBeat.i(199517);
    d.g.b.k.h(paramString1, "feedUsername");
    d.g.b.k.h(paramString2, "objectNonceId");
    d.g.b.k.h(paramString4, "replyUsername");
    d.g.b.k.h(paramString5, "replyNickname");
    d.g.b.k.h(paramString7, "username");
    d.g.b.k.h(paramString8, "nickname");
    com.tencent.mm.plugin.finder.storage.logic.a locala = com.tencent.mm.plugin.finder.storage.logic.a.qKE;
    paramString1 = com.tencent.mm.plugin.finder.storage.logic.a.a(paramLong2, paramString2, paramString7, paramString1, paramLong, paramString6, paramString4, paramString5, paramString3, paramString8, paramInt, paramLong1, paramBoolean, paramFinderCommentInfo, paramdzp);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().a(paramString1);
    a(new a(paramString1));
    AppMethodBeat.o(199517);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(167719);
    d.g.b.k.h(parama, "action");
    this.qQA.a((com.tencent.mm.loader.g.c)parama, (com.tencent.mm.loader.g.f)new b(this));
    AppMethodBeat.o(167719);
  }
  
  public final void crw()
  {
    AppMethodBeat.i(167720);
    com.tencent.mm.plugin.finder.storage.k localk = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().cox();
    if (localk != null)
    {
      a(new a(localk));
      AppMethodBeat.o(167720);
      return;
    }
    AppMethodBeat.o(167720);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderActionManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/FinderActionManager$post$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<a>
  {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(167717);
      this.qQE.crw();
      AppMethodBeat.o(167717);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.b
 * JD-Core Version:    0.7.0.1
 */