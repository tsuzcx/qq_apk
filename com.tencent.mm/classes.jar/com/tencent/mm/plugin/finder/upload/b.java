package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.anm;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderActionManager;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "tryTask", "Ljava/lang/Runnable;", "doPost", "", "localCommentId", "", "feedUsername", "", "objectId", "objectNonceId", "content", "replyUsername", "replyNickname", "replyCommentId", "replyContent", "username", "nickname", "scene", "", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "post", "action", "rePost", "unsentComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "removeWhenNotDoingNetScene", "wantDeleteItem", "tryNext", "Companion", "plugin-finder_release"})
public final class b
{
  public static final String TAG = "Finder.FinderActionManager";
  private static final b rMA;
  public static final b.a rMB;
  public com.tencent.mm.loader.g.d<a> rMy;
  private final Runnable rMz;
  
  static
  {
    AppMethodBeat.i(167722);
    rMB = new b.a((byte)0);
    TAG = "Finder.FinderActionManager";
    rMA = new b();
    AppMethodBeat.o(167722);
  }
  
  public b()
  {
    AppMethodBeat.i(167721);
    this.rMy = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finder_action_post_quene"));
    this.rMz = ((Runnable)new b.c(this));
    AppMethodBeat.o(167721);
  }
  
  public final void a(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, Long paramLong, String paramString6, String paramString7, String paramString8, int paramInt, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, anm paramanm)
  {
    AppMethodBeat.i(203493);
    k.h(paramString1, "feedUsername");
    k.h(paramString2, "objectNonceId");
    k.h(paramString4, "replyUsername");
    k.h(paramString5, "replyNickname");
    k.h(paramString7, "username");
    k.h(paramString8, "nickname");
    com.tencent.mm.plugin.finder.storage.logic.a locala = com.tencent.mm.plugin.finder.storage.logic.a.rFj;
    paramString1 = com.tencent.mm.plugin.finder.storage.logic.a.a(paramLong2, paramString2, paramString7, paramString1, paramLong, paramString6, paramString4, paramString5, paramString3, paramString8, paramInt, paramLong1, paramBoolean, paramFinderCommentInfo, paramanm);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().a(paramString1);
    a(new a(paramString1));
    AppMethodBeat.o(203493);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(167719);
    k.h(parama, "action");
    this.rMy.a((com.tencent.mm.loader.g.c)parama, (com.tencent.mm.loader.g.f)new b.b(this));
    AppMethodBeat.o(167719);
  }
  
  public final void cCq()
  {
    AppMethodBeat.i(167720);
    t localt = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().cxU();
    if (localt != null)
    {
      a(new a(localt));
      AppMethodBeat.o(167720);
      return;
    }
    AppMethodBeat.o(167720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.b
 * JD-Core Version:    0.7.0.1
 */