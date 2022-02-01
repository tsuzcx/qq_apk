package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.cw;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "action", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "curScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "call", "", "doAction", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "uniqueId", "Companion", "plugin-finder_release"})
public final class a
  extends c
  implements i
{
  public static final a vRI;
  private cw vRG;
  private final an vRH;
  
  static
  {
    AppMethodBeat.i(167715);
    vRI = new a((byte)0);
    AppMethodBeat.o(167715);
  }
  
  public a(an paraman)
  {
    AppMethodBeat.i(167714);
    this.vRH = paraman;
    AppMethodBeat.o(167714);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(167712);
    Object localObject = this.vRH;
    localObject = ((am)localObject).field_actionType + '_' + ((am)localObject).field_feedId + '_' + ((am)localObject).field_localCommentId;
    AppMethodBeat.o(167712);
    return localObject;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167711);
    Object localObject2 = this.vRH;
    Object localObject1 = this.vRH.field_actionInfo;
    if (localObject1 != null) {}
    for (localObject1 = ((aoh)localObject1).ttO;; localObject1 = null)
    {
      this.vRG = new cw((an)localObject2, (bbn)localObject1);
      long l1 = cl.aWy();
      long l2 = this.vRH.dyb().createtime;
      long l3 = this.vRH.field_tryCount;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.a.vTR;
      if (l3 < com.tencent.mm.plugin.finder.upload.action.a.dBn())
      {
        localObject1 = com.tencent.mm.plugin.finder.upload.action.a.vTR;
        if (l1 - l2 * 1000L < com.tencent.mm.plugin.finder.upload.action.a.dBm()) {
          break;
        }
      }
      Log.i("Finder.ActionTask", "make fail tryNext " + this.vRH.dyb().commentId + " tryCount " + this.vRH.field_tryCount + " createTime: " + this.vRH.dyb().createtime);
      this.vRH.field_state = -1;
      ((PluginFinder)g.ah(PluginFinder.class)).getFinderActionStorage().a(this.vRH.field_localCommentId, this.vRH, true);
      a(j.ibw);
      AppMethodBeat.o(167711);
      return;
    }
    localObject1 = this.vRH;
    ((an)localObject1).field_tryCount += 1L;
    Log.i("Finder.ActionTask", "doAction " + this.vRH + ' ' + this.vRH + ".field_tryCount");
    ((PluginFinder)g.ah(PluginFinder.class)).getFinderActionStorage().a(this.vRH.field_localCommentId, this.vRH, false);
    localObject1 = g.azz();
    localObject2 = this.vRG;
    if (localObject2 == null) {
      p.btv("curScene");
    }
    ((t)localObject1).b((q)localObject2);
    g.azz().a(3906, (i)this);
    AppMethodBeat.o(167711);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(167713);
    cw localcw = this.vRG;
    if (localcw == null) {
      p.btv("curScene");
    }
    if (p.j(paramq, localcw))
    {
      g.azz().b(3906, (i)this);
      paramq = new StringBuilder("onSceneEnd ").append(paramInt1).append(", ").append(paramInt2).append(", ").append(paramString).append(", ");
      paramString = this.vRH;
      if (paramString != null) {}
      for (paramString = Long.valueOf(paramString.field_localCommentId);; paramString = null)
      {
        Log.i("Finder.ActionTask", paramString.longValue());
        paramString = this.vRH;
        if (paramString == null) {
          break label271;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        ((PluginFinder)g.ah(PluginFinder.class)).getFinderActionStorage().Fw(paramString.field_localCommentId);
        a(j.ibw);
        AppMethodBeat.o(167713);
        return;
      }
      paramq = com.tencent.mm.plugin.finder.spam.a.vwk;
      if (!com.tencent.mm.plugin.finder.spam.a.gi(paramInt1, paramInt2)) {
        if (paramInt1 >= 4)
        {
          paramString.field_state = -1;
          if (paramInt2 == -4010) {
            paramString.field_failedFlag = 1;
          }
          ((PluginFinder)g.ah(PluginFinder.class)).getFinderActionStorage().a(paramString.field_localCommentId, paramString, false);
        }
      }
      for (;;)
      {
        a(j.ibx);
        AppMethodBeat.o(167713);
        return;
        paramString.field_postTime = cl.aWy();
        break;
        ((PluginFinder)g.ah(PluginFinder.class)).getFinderActionStorage().Fw(paramString.field_localCommentId);
      }
    }
    label271:
    AppMethodBeat.o(167713);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/ActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.a
 * JD-Core Version:    0.7.0.1
 */