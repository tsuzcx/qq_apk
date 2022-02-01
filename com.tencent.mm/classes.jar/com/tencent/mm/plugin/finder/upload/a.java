package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "action", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "curScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "call", "", "doAction", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "uniqueId", "Companion", "plugin-finder_release"})
public final class a
  extends c
  implements com.tencent.mm.ak.g
{
  public static final a.a rMx;
  private az rMv;
  private final t rMw;
  
  static
  {
    AppMethodBeat.i(167715);
    rMx = new a.a((byte)0);
    AppMethodBeat.o(167715);
  }
  
  public a(t paramt)
  {
    AppMethodBeat.i(167714);
    this.rMw = paramt;
    AppMethodBeat.o(167714);
  }
  
  public final String acg()
  {
    AppMethodBeat.i(167712);
    Object localObject = this.rMw;
    localObject = ((s)localObject).field_actionType + '_' + ((s)localObject).field_feedId + '_' + ((s)localObject).field_localCommentId;
    AppMethodBeat.o(167712);
    return localObject;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167711);
    Object localObject2 = this.rMw;
    Object localObject1 = this.rMw.field_actionInfo;
    if (localObject1 != null) {}
    for (localObject1 = ((air)localObject1).contextObj;; localObject1 = null)
    {
      this.rMv = new az((t)localObject2, (anm)localObject1);
      long l1 = ce.azH();
      long l2 = this.rMw.cAM();
      long l3 = this.rMw.field_tryCount;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.a.rNF;
      if (l3 < com.tencent.mm.plugin.finder.upload.action.a.cCD())
      {
        localObject1 = com.tencent.mm.plugin.finder.upload.action.a.rNF;
        if (l1 - l2 * 1000L < com.tencent.mm.plugin.finder.upload.action.a.cCC()) {
          break;
        }
      }
      ac.i("Finder.ActionTask", "make fail tryNext " + this.rMw.cAK() + " tryCount " + this.rMw.field_tryCount + " createTime: " + this.rMw.cAM());
      this.rMw.field_state = -1;
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().a(this.rMw.field_localCommentId, this.rMw, true);
      a(h.gLN);
      AppMethodBeat.o(167711);
      return;
    }
    localObject1 = this.rMw;
    ((t)localObject1).field_tryCount += 1L;
    ac.i("Finder.ActionTask", "doAction " + this.rMw + ' ' + this.rMw + ".field_tryCount");
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().a(this.rMw.field_localCommentId, this.rMw, false);
    localObject1 = com.tencent.mm.kernel.g.agi();
    localObject2 = this.rMv;
    if (localObject2 == null) {
      k.aVY("curScene");
    }
    ((q)localObject1).b((n)localObject2);
    com.tencent.mm.kernel.g.agi().a(3906, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(167711);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167713);
    az localaz = this.rMv;
    if (localaz == null) {
      k.aVY("curScene");
    }
    if (k.g(paramn, localaz))
    {
      com.tencent.mm.kernel.g.agi().b(3906, (com.tencent.mm.ak.g)this);
      paramn = new StringBuilder("onSceneEnd ").append(paramInt1).append(", ").append(paramInt2).append(", ").append(paramString).append(", ");
      paramString = this.rMw;
      if (paramString != null) {}
      for (paramString = Long.valueOf(paramString.field_localCommentId);; paramString = null)
      {
        ac.i("Finder.ActionTask", paramString.longValue());
        paramString = this.rMw;
        if (paramString == null) {
          break label271;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().uN(paramString.field_localCommentId);
        a(h.gLN);
        AppMethodBeat.o(167713);
        return;
      }
      paramn = com.tencent.mm.plugin.finder.spam.a.rBD;
      if (!com.tencent.mm.plugin.finder.spam.a.fB(paramInt1, paramInt2)) {
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
        a(h.gLO);
        AppMethodBeat.o(167713);
        return;
        paramString.field_postTime = ce.azH();
        break;
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().uN(paramString.field_localCommentId);
      }
    }
    label271:
    AppMethodBeat.o(167713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.a
 * JD-Core Version:    0.7.0.1
 */