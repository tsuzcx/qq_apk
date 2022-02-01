package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bid;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "tryTask", "Ljava/lang/Runnable;", "doPost", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "localCommentId", "", "feedUsername", "", "objectId", "objectNonceId", "content", "replyUsername", "replyNickname", "replyCommentId", "replyContent", "username", "nickname", "scene", "", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reason", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "post", "", "action", "rePost", "unsentComment", "removeWhenNotDoingNetScene", "wantDeleteItem", "tryNext", "Companion", "plugin-finder_release"})
public final class b
{
  private static final b Azo;
  public static final a Azp;
  public static final String TAG = "Finder.FinderActionManager";
  public com.tencent.mm.loader.g.d<a> Azm;
  private final Runnable Azn;
  
  static
  {
    AppMethodBeat.i(167722);
    Azp = new a((byte)0);
    TAG = "Finder.FinderActionManager";
    Azo = new b();
    AppMethodBeat.o(167722);
  }
  
  public b()
  {
    AppMethodBeat.i(167721);
    this.Azm = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new g(1, (byte)0), 1, "finder_action_post_quene"));
    this.Azn = ((Runnable)new c(this));
    AppMethodBeat.o(167721);
  }
  
  public final am a(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, Long paramLong, String paramString6, String paramString7, String paramString8, int paramInt1, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, bid parambid, int paramInt2)
  {
    AppMethodBeat.i(273988);
    p.k(paramString1, "feedUsername");
    p.k(paramString2, "objectNonceId");
    p.k(paramString4, "replyUsername");
    p.k(paramString5, "replyNickname");
    p.k(paramString7, "username");
    p.k(paramString8, "nickname");
    com.tencent.mm.plugin.finder.storage.logic.a locala = com.tencent.mm.plugin.finder.storage.logic.a.AnH;
    paramString1 = com.tencent.mm.plugin.finder.storage.logic.a.a(paramLong2, paramString2, paramString7, paramString1, paramLong, paramString6, paramString4, paramString5, paramString3, paramString8, paramInt1, paramLong1, paramBoolean, paramFinderCommentInfo, parambid, paramInt2);
    ((PluginFinder)h.ag(PluginFinder.class)).getFinderActionStorage().a(paramString1);
    a(new a(paramString1));
    AppMethodBeat.o(273988);
    return paramString1;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(167719);
    p.k(parama, "action");
    this.Azm.a((com.tencent.mm.loader.g.c)parama, (com.tencent.mm.loader.g.f)new b(this));
    AppMethodBeat.o(167719);
  }
  
  public final void ebY()
  {
    AppMethodBeat.i(167720);
    am localam = ((PluginFinder)h.ag(PluginFinder.class)).getFinderActionStorage().dRs();
    if (localam != null)
    {
      a(new a(localam));
      AppMethodBeat.o(167720);
      return;
    }
    AppMethodBeat.o(167720);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderActionManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderActionManager$post$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<a>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(167717);
      this.Azq.ebY();
      AppMethodBeat.o(167717);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.b
 * JD-Core Version:    0.7.0.1
 */