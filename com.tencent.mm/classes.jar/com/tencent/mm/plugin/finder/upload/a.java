package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "action", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "curScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "call", "", "doAction", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "uniqueId", "Companion", "plugin-finder_release"})
public final class a
  extends c
  implements f
{
  public static final a sIz;
  private bh sIx;
  private final ab sIy;
  
  static
  {
    AppMethodBeat.i(167715);
    sIz = new a((byte)0);
    AppMethodBeat.o(167715);
  }
  
  public a(ab paramab)
  {
    AppMethodBeat.i(167714);
    this.sIy = paramab;
    AppMethodBeat.o(167714);
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(167712);
    Object localObject = this.sIy;
    localObject = ((aa)localObject).field_actionType + '_' + ((aa)localObject).field_feedId + '_' + ((aa)localObject).field_localCommentId;
    AppMethodBeat.o(167712);
    return localObject;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167711);
    Object localObject2 = this.sIy;
    Object localObject1 = this.sIy.field_actionInfo;
    if (localObject1 != null) {}
    for (localObject1 = ((alh)localObject1).rIl;; localObject1 = null)
    {
      this.sIx = new bh((ab)localObject2, (aqy)localObject1);
      long l1 = cf.aCK();
      long l2 = this.sIy.cII();
      long l3 = this.sIy.field_tryCount;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.a.sJK;
      if (l3 < com.tencent.mm.plugin.finder.upload.action.a.cKQ())
      {
        localObject1 = com.tencent.mm.plugin.finder.upload.action.a.sJK;
        if (l1 - l2 * 1000L < com.tencent.mm.plugin.finder.upload.action.a.cKP()) {
          break;
        }
      }
      ad.i("Finder.ActionTask", "make fail tryNext " + this.sIy.cIG() + " tryCount " + this.sIy.field_tryCount + " createTime: " + this.sIy.cII());
      this.sIy.field_state = -1;
      ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().a(this.sIy.field_localCommentId, this.sIy, true);
      a(j.hfK);
      AppMethodBeat.o(167711);
      return;
    }
    localObject1 = this.sIy;
    ((ab)localObject1).field_tryCount += 1L;
    ad.i("Finder.ActionTask", "doAction " + this.sIy + ' ' + this.sIy + ".field_tryCount");
    ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().a(this.sIy.field_localCommentId, this.sIy, false);
    localObject1 = g.aiU();
    localObject2 = this.sIx;
    if (localObject2 == null) {
      p.bcb("curScene");
    }
    ((q)localObject1).b((n)localObject2);
    g.aiU().a(3906, (f)this);
    AppMethodBeat.o(167711);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167713);
    bh localbh = this.sIx;
    if (localbh == null) {
      p.bcb("curScene");
    }
    if (p.i(paramn, localbh))
    {
      g.aiU().b(3906, (f)this);
      paramn = new StringBuilder("onSceneEnd ").append(paramInt1).append(", ").append(paramInt2).append(", ").append(paramString).append(", ");
      paramString = this.sIy;
      if (paramString != null) {}
      for (paramString = Long.valueOf(paramString.field_localCommentId);; paramString = null)
      {
        ad.i("Finder.ActionTask", paramString.longValue());
        paramString = this.sIy;
        if (paramString == null) {
          break label271;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().wO(paramString.field_localCommentId);
        a(j.hfK);
        AppMethodBeat.o(167713);
        return;
      }
      paramn = com.tencent.mm.plugin.finder.spam.a.suA;
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
        a(j.hfL);
        AppMethodBeat.o(167713);
        return;
        paramString.field_postTime = cf.aCK();
        break;
        ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().wO(paramString.field_localCommentId);
      }
    }
    label271:
    AppMethodBeat.o(167713);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/ActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.a
 * JD-Core Version:    0.7.0.1
 */