package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "action", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "curScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "call", "", "doAction", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "uniqueId", "Companion", "plugin-finder_release"})
public final class a
  extends c
  implements com.tencent.mm.al.g
{
  public static final a qQz;
  private ag qQx;
  private final com.tencent.mm.plugin.finder.storage.k qQy;
  
  static
  {
    AppMethodBeat.i(167715);
    qQz = new a((byte)0);
    AppMethodBeat.o(167715);
  }
  
  public a(com.tencent.mm.plugin.finder.storage.k paramk)
  {
    AppMethodBeat.i(167714);
    this.qQy = paramk;
    AppMethodBeat.o(167714);
  }
  
  public final String abi()
  {
    AppMethodBeat.i(167712);
    Object localObject = this.qQy;
    localObject = ((j)localObject).field_actionType + '_' + ((j)localObject).field_feedId + '_' + ((j)localObject).field_localCommentId;
    AppMethodBeat.o(167712);
    return localObject;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167711);
    Object localObject2 = this.qQy;
    Object localObject1 = this.qQy.field_actionInfo;
    if (localObject1 != null) {}
    for (localObject1 = ((ahs)localObject1).contextObj;; localObject1 = null)
    {
      this.qQx = new ag((com.tencent.mm.plugin.finder.storage.k)localObject2, (dzp)localObject1);
      long l1 = ce.asQ();
      long l2 = this.qQy.cqt();
      long l3 = this.qQy.field_tryCount;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.a.qRF;
      if (l3 < com.tencent.mm.plugin.finder.upload.action.a.crI())
      {
        localObject1 = com.tencent.mm.plugin.finder.upload.action.a.qRF;
        if (l1 - l2 * 1000L < com.tencent.mm.plugin.finder.upload.action.a.crH()) {
          break;
        }
      }
      ad.i("Finder.ActionTask", "make fail tryNext " + this.qQy.cqr() + " tryCount " + this.qQy.field_tryCount + " createTime: " + this.qQy.cqt());
      this.qQy.field_state = -1;
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().a(this.qQy.field_localCommentId, this.qQy, true);
      a(h.gla);
      AppMethodBeat.o(167711);
      return;
    }
    localObject1 = this.qQy;
    ((com.tencent.mm.plugin.finder.storage.k)localObject1).field_tryCount += 1L;
    ad.i("Finder.ActionTask", "doAction " + this.qQy + ' ' + this.qQy + ".field_tryCount");
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().a(this.qQy.field_localCommentId, this.qQy, false);
    localObject1 = com.tencent.mm.kernel.g.aeS();
    localObject2 = this.qQx;
    if (localObject2 == null) {
      d.g.b.k.aPZ("curScene");
    }
    ((q)localObject1).b((n)localObject2);
    com.tencent.mm.kernel.g.aeS().a(3906, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(167711);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167713);
    ag localag = this.qQx;
    if (localag == null) {
      d.g.b.k.aPZ("curScene");
    }
    if (d.g.b.k.g(paramn, localag))
    {
      com.tencent.mm.kernel.g.aeS().b(3906, (com.tencent.mm.al.g)this);
      paramn = new StringBuilder("onSceneEnd ").append(paramInt1).append(", ").append(paramInt2).append(", ").append(paramString).append(", ");
      paramString = this.qQy;
      if (paramString != null) {}
      for (paramString = Long.valueOf(paramString.field_localCommentId);; paramString = null)
      {
        ad.i("Finder.ActionTask", paramString.longValue());
        paramString = this.qQy;
        if (paramString == null) {
          break label271;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().qx(paramString.field_localCommentId);
        a(h.gla);
        AppMethodBeat.o(167713);
        return;
      }
      paramn = com.tencent.mm.plugin.finder.spam.a.qIC;
      if (!com.tencent.mm.plugin.finder.spam.a.fx(paramInt1, paramInt2)) {
        if (paramInt1 >= 4)
        {
          paramString.field_state = -1;
          if (paramInt2 == -4010) {
            paramString.field_failedFlag = 1;
          }
          ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().a(paramString.field_localCommentId, paramString, false);
        }
      }
      for (;;)
      {
        a(h.glb);
        AppMethodBeat.o(167713);
        return;
        paramString.field_postTime = ce.asQ();
        break;
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().qx(paramString.field_localCommentId);
      }
    }
    label271:
    AppMethodBeat.o(167713);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/ActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.a
 * JD-Core Version:    0.7.0.1
 */