package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "action", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "curScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "call", "", "doAction", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "uniqueId", "Companion", "plugin-finder_release"})
public final class a
  extends c
  implements f
{
  public static final a sTL;
  private bi sTJ;
  private final ab sTK;
  
  static
  {
    AppMethodBeat.i(167715);
    sTL = new a((byte)0);
    AppMethodBeat.o(167715);
  }
  
  public a(ab paramab)
  {
    AppMethodBeat.i(167714);
    this.sTK = paramab;
    AppMethodBeat.o(167714);
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(167712);
    Object localObject = this.sTK;
    localObject = ((aa)localObject).field_actionType + '_' + ((aa)localObject).field_feedId + '_' + ((aa)localObject).field_localCommentId;
    AppMethodBeat.o(167712);
    return localObject;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167711);
    Object localObject2 = this.sTK;
    Object localObject1 = this.sTK.field_actionInfo;
    if (localObject1 != null) {}
    for (localObject1 = ((alr)localObject1).rQw;; localObject1 = null)
    {
      this.sTJ = new bi((ab)localObject2, (arn)localObject1);
      long l1 = ch.aDa();
      long l2 = this.sTK.cLl().createtime;
      long l3 = this.sTK.field_tryCount;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.a.sUX;
      if (l3 < com.tencent.mm.plugin.finder.upload.action.a.cNu())
      {
        localObject1 = com.tencent.mm.plugin.finder.upload.action.a.sUX;
        if (l1 - l2 * 1000L < com.tencent.mm.plugin.finder.upload.action.a.cNt()) {
          break;
        }
      }
      ae.i("Finder.ActionTask", "make fail tryNext " + this.sTK.cLl().commentId + " tryCount " + this.sTK.field_tryCount + " createTime: " + this.sTK.cLl().createtime);
      this.sTK.field_state = -1;
      ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().a(this.sTK.field_localCommentId, this.sTK, true);
      a(j.hiy);
      AppMethodBeat.o(167711);
      return;
    }
    localObject1 = this.sTK;
    ((ab)localObject1).field_tryCount += 1L;
    ae.i("Finder.ActionTask", "doAction " + this.sTK + ' ' + this.sTK + ".field_tryCount");
    ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().a(this.sTK.field_localCommentId, this.sTK, false);
    localObject1 = g.ajj();
    localObject2 = this.sTJ;
    if (localObject2 == null) {
      p.bdF("curScene");
    }
    ((q)localObject1).b((n)localObject2);
    g.ajj().a(3906, (f)this);
    AppMethodBeat.o(167711);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167713);
    bi localbi = this.sTJ;
    if (localbi == null) {
      p.bdF("curScene");
    }
    if (p.i(paramn, localbi))
    {
      g.ajj().b(3906, (f)this);
      paramn = new StringBuilder("onSceneEnd ").append(paramInt1).append(", ").append(paramInt2).append(", ").append(paramString).append(", ");
      paramString = this.sTK;
      if (paramString != null) {}
      for (paramString = Long.valueOf(paramString.field_localCommentId);; paramString = null)
      {
        ae.i("Finder.ActionTask", paramString.longValue());
        paramString = this.sTK;
        if (paramString == null) {
          break label271;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().xf(paramString.field_localCommentId);
        a(j.hiy);
        AppMethodBeat.o(167713);
        return;
      }
      paramn = com.tencent.mm.plugin.finder.spam.a.sEK;
      if (!com.tencent.mm.plugin.finder.spam.a.fO(paramInt1, paramInt2)) {
        if (paramInt1 >= 4)
        {
          paramString.field_state = -1;
          if (paramInt2 == -4010) {
            paramString.field_failedFlag = 1;
          }
          ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().a(paramString.field_localCommentId, paramString, false);
        }
      }
      for (;;)
      {
        a(j.hiz);
        AppMethodBeat.o(167713);
        return;
        paramString.field_postTime = ch.aDa();
        break;
        ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().xf(paramString.field_localCommentId);
      }
    }
    label271:
    AppMethodBeat.o(167713);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/ActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.a
 * JD-Core Version:    0.7.0.1
 */