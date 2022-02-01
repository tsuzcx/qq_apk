package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.db;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "action", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "curScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "call", "", "doAction", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "uniqueId", "Companion", "plugin-finder_release"})
public final class a
  extends c
  implements i
{
  public static final a Azl;
  private db Azj;
  private final am Azk;
  
  static
  {
    AppMethodBeat.i(167715);
    Azl = new a((byte)0);
    AppMethodBeat.o(167715);
  }
  
  public a(am paramam)
  {
    AppMethodBeat.i(167714);
    this.Azk = paramam;
    AppMethodBeat.o(167714);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(167712);
    Object localObject = this.Azk;
    localObject = ((al)localObject).field_actionType + '_' + ((al)localObject).field_feedId + '_' + ((al)localObject).field_localCommentId;
    AppMethodBeat.o(167712);
    return localObject;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167711);
    Object localObject2 = this.Azk;
    Object localObject1 = this.Azk.field_actionInfo;
    if (localObject1 != null) {}
    for (localObject1 = ((apk)localObject1).xbu;; localObject1 = null)
    {
      this.Azj = new db((am)localObject2, (bid)localObject1);
      long l1 = cm.bfC();
      long l2 = this.Azk.dYY().createtime;
      long l3 = this.Azk.field_tryCount;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.a.ABu;
      if (l3 < com.tencent.mm.plugin.finder.upload.action.a.ecv())
      {
        localObject1 = com.tencent.mm.plugin.finder.upload.action.a.ABu;
        if (l1 - l2 * 1000L < com.tencent.mm.plugin.finder.upload.action.a.ecu()) {
          break;
        }
      }
      Log.i("Finder.ActionTask", "make fail tryNext " + this.Azk.dYY().commentId + " tryCount " + this.Azk.field_tryCount + " createTime: " + this.Azk.dYY().createtime);
      this.Azk.field_state = -1;
      ((PluginFinder)h.ag(PluginFinder.class)).getFinderActionStorage().a(this.Azk.field_localCommentId, this.Azk, true);
      a(j.kQd);
      AppMethodBeat.o(167711);
      return;
    }
    localObject1 = this.Azk;
    ((am)localObject1).field_tryCount += 1L;
    Log.i("Finder.ActionTask", "doAction " + this.Azk + ' ' + this.Azk + ".field_tryCount");
    ((PluginFinder)h.ag(PluginFinder.class)).getFinderActionStorage().a(this.Azk.field_localCommentId, this.Azk, false);
    localObject1 = h.aGY();
    localObject2 = this.Azj;
    if (localObject2 == null) {
      p.bGy("curScene");
    }
    ((t)localObject1).b((q)localObject2);
    h.aGY().a(3906, (i)this);
    AppMethodBeat.o(167711);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(167713);
    db localdb = this.Azj;
    if (localdb == null) {
      p.bGy("curScene");
    }
    if (p.h(paramq, localdb))
    {
      h.aGY().b(3906, (i)this);
      paramq = new StringBuilder("onSceneEnd ").append(paramInt1).append(", ").append(paramInt2).append(", ").append(paramString).append(", ");
      paramString = this.Azk;
      if (paramString != null) {}
      for (paramString = Long.valueOf(paramString.field_localCommentId);; paramString = null)
      {
        Log.i("Finder.ActionTask", paramString.longValue());
        paramString = this.Azk;
        if (paramString == null) {
          break label271;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        ((PluginFinder)h.ag(PluginFinder.class)).getFinderActionStorage().MF(paramString.field_localCommentId);
        a(j.kQd);
        AppMethodBeat.o(167713);
        return;
      }
      paramq = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      if (!com.tencent.mm.plugin.findersdk.c.a.hs(paramInt1, paramInt2)) {
        if (paramInt1 >= 4)
        {
          paramString.field_state = -1;
          if (paramInt2 == -4010) {
            paramString.field_failedFlag = 1;
          }
          ((PluginFinder)h.ag(PluginFinder.class)).getFinderActionStorage().a(paramString.field_localCommentId, paramString, false);
        }
      }
      for (;;)
      {
        a(j.kQe);
        AppMethodBeat.o(167713);
        return;
        paramString.field_postTime = cm.bfC();
        break;
        ((PluginFinder)h.ag(PluginFinder.class)).getFinderActionStorage().MF(paramString.field_localCommentId);
      }
    }
    label271:
    AppMethodBeat.o(167713);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/ActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.a
 * JD-Core Version:    0.7.0.1
 */