package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.arn;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "tryTask", "Ljava/lang/Runnable;", "doPost", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "localCommentId", "", "feedUsername", "", "objectId", "objectNonceId", "content", "replyUsername", "replyNickname", "replyCommentId", "replyContent", "username", "nickname", "scene", "", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reason", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "post", "", "action", "rePost", "unsentComment", "removeWhenNotDoingNetScene", "wantDeleteItem", "tryNext", "Companion", "plugin-finder_release"})
public final class b
{
  public static final String TAG = "Finder.FinderActionManager";
  private static final b sTO;
  public static final a sTP;
  public com.tencent.mm.loader.g.d<a> sTM;
  private final Runnable sTN;
  
  static
  {
    AppMethodBeat.i(167722);
    sTP = new a((byte)0);
    TAG = "Finder.FinderActionManager";
    sTO = new b();
    AppMethodBeat.o(167722);
  }
  
  public b()
  {
    AppMethodBeat.i(167721);
    this.sTM = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finder_action_post_quene"));
    this.sTN = ((Runnable)new c(this));
    AppMethodBeat.o(167721);
  }
  
  public final ab a(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, Long paramLong, String paramString6, String paramString7, String paramString8, int paramInt1, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, arn paramarn, int paramInt2)
  {
    AppMethodBeat.i(204937);
    p.h(paramString1, "feedUsername");
    p.h(paramString2, "objectNonceId");
    p.h(paramString4, "replyUsername");
    p.h(paramString5, "replyNickname");
    p.h(paramString7, "username");
    p.h(paramString8, "nickname");
    com.tencent.mm.plugin.finder.storage.logic.a locala = com.tencent.mm.plugin.finder.storage.logic.a.sLo;
    paramString1 = com.tencent.mm.plugin.finder.storage.logic.a.a(paramLong2, paramString2, paramString7, paramString1, paramLong, paramString6, paramString4, paramString5, paramString3, paramString8, paramInt1, paramLong1, paramBoolean, paramFinderCommentInfo, paramarn, paramInt2);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().a(paramString1);
    a(new a(paramString1));
    AppMethodBeat.o(204937);
    return paramString1;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(167719);
    p.h(parama, "action");
    this.sTM.a((com.tencent.mm.loader.g.c)parama, (com.tencent.mm.loader.g.f)new b(this));
    AppMethodBeat.o(167719);
  }
  
  public final void cNf()
  {
    AppMethodBeat.i(167720);
    ab localab = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().cGP();
    if (localab != null)
    {
      a(new a(localab));
      AppMethodBeat.o(167720);
      return;
    }
    AppMethodBeat.o(167720);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderActionManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/FinderActionManager$post$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<a>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(167717);
      this.sTQ.cNf();
      AppMethodBeat.o(167717);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.b
 * JD-Core Version:    0.7.0.1
 */