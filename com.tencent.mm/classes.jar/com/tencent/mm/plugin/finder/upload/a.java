package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.loader.f.c;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.eb;
import com.tencent.mm.plugin.finder.storage.at;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "action", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "curScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "call", "", "doAction", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "uniqueId", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
  implements com.tencent.mm.am.h
{
  public static final a Gbr;
  private final au Gbs;
  private eb Gbt;
  
  static
  {
    AppMethodBeat.i(167715);
    Gbr = new a((byte)0);
    AppMethodBeat.o(167715);
  }
  
  public a(au paramau)
  {
    AppMethodBeat.i(167714);
    this.Gbs = paramau;
    AppMethodBeat.o(167714);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(167712);
    Object localObject = this.Gbs;
    localObject = ((at)localObject).field_actionType + '_' + ((at)localObject).field_feedId + '_' + ((at)localObject).field_localCommentId;
    AppMethodBeat.o(167712);
    return localObject;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167711);
    Object localObject2 = this.Gbs;
    Object localObject1 = this.Gbs.field_actionInfo;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((atd)localObject1).Auc)
    {
      this.Gbt = new eb((au)localObject2, (bui)localObject1);
      long l1 = cn.bDu();
      long l2 = this.Gbs.eZI().createtime;
      long l3 = this.Gbs.field_tryCount;
      localObject1 = com.tencent.mm.plugin.finder.upload.action.a.GcD;
      if (l3 < com.tencent.mm.plugin.finder.upload.action.a.feb())
      {
        localObject1 = com.tencent.mm.plugin.finder.upload.action.a.GcD;
        if (l1 - l2 * 1000L < com.tencent.mm.plugin.finder.upload.action.a.fea()) {
          break;
        }
      }
      Log.i("Finder.ActionTask", "make fail tryNext " + this.Gbs.eZI().commentId + " tryCount " + this.Gbs.field_tryCount + " createTime: " + this.Gbs.eZI().createtime);
      this.Gbs.field_state = -1;
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderActionStorage().a(this.Gbs.field_localCommentId, this.Gbs, true);
      a(i.nrG);
      AppMethodBeat.o(167711);
      return;
    }
    localObject1 = this.Gbs;
    ((au)localObject1).field_tryCount += 1L;
    Log.i("Finder.ActionTask", "doAction " + this.Gbs + ' ' + this.Gbs + ".field_tryCount");
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderActionStorage().a(this.Gbs.field_localCommentId, this.Gbs, false);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.aZW();
    localObject2 = this.Gbt;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("curScene");
      localObject1 = null;
    }
    locals.a((p)localObject1, 0);
    com.tencent.mm.kernel.h.aZW().a(3906, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(167711);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(167713);
    eb localeb2 = this.Gbt;
    eb localeb1 = localeb2;
    if (localeb2 == null)
    {
      kotlin.g.b.s.bIx("curScene");
      localeb1 = null;
    }
    if (kotlin.g.b.s.p(paramp, localeb1))
    {
      com.tencent.mm.kernel.h.aZW().b(3906, (com.tencent.mm.am.h)this);
      paramp = new StringBuilder("onSceneEnd ").append(paramInt1).append(", ").append(paramInt2).append(", ").append(paramString).append(", ");
      paramString = this.Gbs;
      if (paramString == null) {}
      for (paramString = localObject;; paramString = Long.valueOf(paramString.field_localCommentId))
      {
        Log.i("Finder.ActionTask", paramString);
        paramString = this.Gbs;
        if (paramString == null) {
          break label241;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderActionStorage().pW(paramString.field_localCommentId);
        a(i.nrG);
        AppMethodBeat.o(167713);
        return;
      }
      paramp = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      if (com.tencent.mm.plugin.findersdk.d.a.iN(paramInt1, paramInt2)) {
        break label257;
      }
      if (paramInt1 < 4) {
        break label247;
      }
      paramString.field_state = -1;
      if (paramInt2 == -4010) {
        paramString.field_failedFlag = 1;
      }
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderActionStorage().a(paramString.field_localCommentId, paramString, false);
    }
    for (;;)
    {
      a(i.nrH);
      label241:
      AppMethodBeat.o(167713);
      return;
      label247:
      paramString.field_postTime = cn.bDu();
      break;
      label257:
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderActionStorage().pW(paramString.field_localCommentId);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/ActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.a
 * JD-Core Version:    0.7.0.1
 */