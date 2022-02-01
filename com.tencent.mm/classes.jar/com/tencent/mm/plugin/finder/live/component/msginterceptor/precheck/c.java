package com.tencent.mm.plugin.finder.live.component.msginterceptor.precheck;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.i;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/precheck/LiveMsgRespLegalInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IPreCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "intercept", "", "cgiResp", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp;", "isInvalidLiveId", "uniqueId", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements i
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final String TAG;
  
  public c(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(353240);
    this.CBK = parama;
    this.TAG = "LiveMsgRespLegalInterceptor";
    AppMethodBeat.o(353240);
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.live.component.msginterceptor.a parama)
  {
    StringBuilder localStringBuilder1 = null;
    Object localObject3 = null;
    StringBuilder localStringBuilder2 = null;
    AppMethodBeat.i(353258);
    s.u(parama, "cgiResp");
    int i = parama.errCode;
    Object localObject1 = parama.CBl;
    String str1;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      str1 = parama.hTs;
      parama = parama.CBl;
      if (parama != null) {
        break label276;
      }
      localObject2 = null;
      label54:
      String str2 = this.TAG;
      StringBuilder localStringBuilder3 = new StringBuilder("handleLiveMsgResp errCode:").append(i).append(" curData:");
      parama = (f)this.CBK.business(f.class);
      if (parama != null) {
        break label288;
      }
      parama = null;
      label99:
      localStringBuilder3 = localStringBuilder3.append(parama).append(", resp.liveId:");
      if (localObject1 != null) {
        break label313;
      }
      parama = null;
      label118:
      Log.i(str2, parama + ",reqVisitorRoleType:" + localObject2);
      if (localObject1 != null) {
        break label324;
      }
      localObject2 = null;
      label149:
      parama = (f)this.CBK.business(f.class);
      if (parama != null) {
        break label336;
      }
      parama = null;
      label168:
      if (s.p(localObject2, parama)) {
        break label397;
      }
      localObject2 = this.TAG;
      localStringBuilder1 = new StringBuilder("handleLiveMsgResp invalid live resp, curData:");
      parama = (f)this.CBK.business(f.class);
      if (parama != null) {
        break label361;
      }
      parama = null;
      label213:
      localStringBuilder1 = localStringBuilder1.append(parama).append(", resp.liveId:");
      if (localObject1 != null) {
        break label386;
      }
    }
    label386:
    for (parama = localStringBuilder2;; parama = Long.valueOf(((bip)localObject1).liveId))
    {
      Log.i((String)localObject2, parama);
      AppMethodBeat.o(353258);
      return false;
      localObject1 = ((a.a)localObject1).CBm;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((azp)localObject1).liveInfo;
      break;
      label276:
      localObject2 = Integer.valueOf(parama.CuT);
      break label54;
      label288:
      parama = parama.liveInfo;
      if (parama == null)
      {
        parama = null;
        break label99;
      }
      parama = Long.valueOf(parama.liveId);
      break label99;
      label313:
      parama = Long.valueOf(((bip)localObject1).liveId);
      break label118;
      label324:
      localObject2 = Long.valueOf(((bip)localObject1).liveId);
      break label149;
      label336:
      parama = parama.liveInfo;
      if (parama == null)
      {
        parama = null;
        break label168;
      }
      parama = Long.valueOf(parama.liveId);
      break label168;
      label361:
      parama = parama.liveInfo;
      if (parama == null)
      {
        parama = null;
        break label213;
      }
      parama = Long.valueOf(parama.liveId);
      break label213;
    }
    label397:
    parama = aj.CGT;
    parama = (f)aj.business(f.class);
    if (parama == null)
    {
      parama = null;
      localObject2 = (CharSequence)str1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label584;
      }
      i = 1;
      label440:
      if ((i == 0) && (Util.isEqual(str1, parama))) {
        break label589;
      }
      i = 1;
      label455:
      if (i == 0) {
        break label638;
      }
      localObject2 = this.TAG;
      localStringBuilder2 = new StringBuilder("handleLiveMsgResp invalid live id, curData:");
      parama = (f)this.CBK.business(f.class);
      if (parama != null) {
        break label594;
      }
      parama = null;
      label495:
      localStringBuilder2 = localStringBuilder2.append(parama).append(", resp.liveId:");
      if (localObject1 != null) {
        break label619;
      }
      parama = null;
      label514:
      localObject1 = localStringBuilder2.append(parama).append(", curUniqueId:");
      parama = (f)this.CBK.business(f.class);
      if (parama != null) {
        break label630;
      }
    }
    label584:
    label589:
    label594:
    label619:
    label630:
    for (parama = localStringBuilder1;; parama = parama.hTs)
    {
      Log.i((String)localObject2, parama + ", cgi.uniqueId:" + str1);
      AppMethodBeat.o(353258);
      return false;
      parama = parama.hTs;
      break;
      i = 0;
      break label440;
      i = 0;
      break label455;
      parama = parama.liveInfo;
      if (parama == null)
      {
        parama = null;
        break label495;
      }
      parama = Long.valueOf(parama.liveId);
      break label495;
      parama = Long.valueOf(((bip)localObject1).liveId);
      break label514;
    }
    label638:
    parama = (e)this.CBK.business(e.class);
    if (parama == null) {}
    for (parama = localObject3; parama.booleanValue(); parama = Boolean.valueOf(parama.eyA()))
    {
      Log.i(this.TAG, "handleLiveMsgResp live has finished");
      AppMethodBeat.o(353258);
      return false;
    }
    AppMethodBeat.o(353258);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.precheck.c
 * JD-Core Version:    0.7.0.1
 */