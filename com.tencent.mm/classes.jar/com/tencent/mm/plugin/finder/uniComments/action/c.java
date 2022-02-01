package com.tencent.mm.plugin.finder.uniComments.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.uniComments.cgi.e;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/action/UniActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "action", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "uniEntityItem", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "(Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "curScene", "Lcom/tencent/mm/plugin/finder/uniComments/cgi/NetSceneUniToComment;", "getUniEntityItem", "()Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "call", "", "doAction", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "uniqueId", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.loader.f.c
  implements com.tencent.mm.am.h
{
  public static final a Gal;
  private final com.tencent.mm.plugin.finder.uniComments.model.b Gah;
  private final com.tencent.mm.plugin.finder.uniComments.storge.b Gam;
  private e Gan;
  
  static
  {
    AppMethodBeat.i(341615);
    Gal = new a((byte)0);
    AppMethodBeat.o(341615);
  }
  
  public c(com.tencent.mm.plugin.finder.uniComments.storge.b paramb, com.tencent.mm.plugin.finder.uniComments.model.b paramb1)
  {
    AppMethodBeat.i(341611);
    this.Gam = paramb;
    this.Gah = paramb1;
    AppMethodBeat.o(341611);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(341630);
    Object localObject = this.Gam;
    localObject = ((com.tencent.mm.plugin.finder.uniComments.storge.a)localObject).field_actionType + '_' + ((com.tencent.mm.plugin.finder.uniComments.storge.a)localObject).field_feedId + '_' + ((com.tencent.mm.plugin.finder.uniComments.storge.a)localObject).field_localCommentId;
    AppMethodBeat.o(341630);
    return localObject;
  }
  
  public final void call()
  {
    AppMethodBeat.i(341627);
    if (this.Gah == null)
    {
      AppMethodBeat.o(341627);
      return;
    }
    this.Gan = new e(this.Gam, this.Gah);
    long l1 = cn.bDu();
    long l2 = this.Gam.eZI().createtime;
    long l3 = this.Gam.field_tryCount;
    Object localObject = com.tencent.mm.plugin.finder.upload.action.a.GcD;
    if (l3 < com.tencent.mm.plugin.finder.upload.action.a.feb())
    {
      localObject = com.tencent.mm.plugin.finder.upload.action.a.GcD;
      if (l1 - l2 * 1000L < com.tencent.mm.plugin.finder.upload.action.a.fea()) {}
    }
    else
    {
      Log.i("MicroMsg.MusicUni.ActionTask", "make fail tryNext " + this.Gam.eZI().commentId + " tryCount " + this.Gam.field_tryCount + " createTime: " + this.Gam.eZI().createtime);
      this.Gam.field_state = -1;
      localObject = com.tencent.mm.plugin.finder.uniComments.storge.c.Gbn;
      com.tencent.mm.plugin.finder.uniComments.storge.c.a.fdQ().a(this.Gam.field_localCommentId, this.Gam, true);
      a(i.nrG);
      AppMethodBeat.o(341627);
      return;
    }
    localObject = this.Gam;
    ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject).field_tryCount += 1L;
    Log.i("MicroMsg.MusicUni.ActionTask", "doAction " + this.Gam + ' ' + this.Gam + ".field_tryCount");
    localObject = com.tencent.mm.plugin.finder.uniComments.storge.c.Gbn;
    com.tencent.mm.plugin.finder.uniComments.storge.c.a.fdQ().a(this.Gam.field_localCommentId, this.Gam, false);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.aZW();
    e locale = this.Gan;
    localObject = locale;
    if (locale == null)
    {
      kotlin.g.b.s.bIx("curScene");
      localObject = null;
    }
    locals.a((p)localObject, 0);
    com.tencent.mm.kernel.h.aZW().a(6964, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(341627);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(341640);
    e locale2 = this.Gan;
    e locale1 = locale2;
    if (locale2 == null)
    {
      kotlin.g.b.s.bIx("curScene");
      locale1 = null;
    }
    if (kotlin.g.b.s.p(paramp, locale1))
    {
      com.tencent.mm.kernel.h.aZW().b(6964, (com.tencent.mm.am.h)this);
      paramp = new StringBuilder("onSceneEnd ").append(paramInt1).append(", ").append(paramInt2).append(", ").append(paramString).append(", ");
      paramString = this.Gam;
      if (paramString == null) {}
      for (paramString = localObject;; paramString = Long.valueOf(paramString.field_localCommentId))
      {
        Log.i("MicroMsg.MusicUni.ActionTask", paramString);
        paramString = this.Gam;
        if (paramString == null) {
          break label235;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        paramp = com.tencent.mm.plugin.finder.uniComments.storge.c.Gbn;
        com.tencent.mm.plugin.finder.uniComments.storge.c.a.fdQ().pW(paramString.field_localCommentId);
        a(i.nrG);
        AppMethodBeat.o(341640);
        return;
      }
      paramp = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      if (com.tencent.mm.plugin.findersdk.d.a.iN(paramInt1, paramInt2)) {
        break label251;
      }
      if (paramInt1 < 4) {
        break label241;
      }
      paramString.field_state = -1;
      if (paramInt2 == -4010) {
        paramString.field_failedFlag = 1;
      }
      paramp = com.tencent.mm.plugin.finder.uniComments.storge.c.Gbn;
      com.tencent.mm.plugin.finder.uniComments.storge.c.a.fdQ().a(paramString.field_localCommentId, paramString, false);
    }
    for (;;)
    {
      a(i.nrH);
      label235:
      AppMethodBeat.o(341640);
      return;
      label241:
      paramString.field_postTime = cn.bDu();
      break;
      label251:
      paramp = com.tencent.mm.plugin.finder.uniComments.storge.c.Gbn;
      com.tencent.mm.plugin.finder.uniComments.storge.c.a.fdQ().pW(paramString.field_localCommentId);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/action/UniActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.action.c
 * JD-Core Version:    0.7.0.1
 */