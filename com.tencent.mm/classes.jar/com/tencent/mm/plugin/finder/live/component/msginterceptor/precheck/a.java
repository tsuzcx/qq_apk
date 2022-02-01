package com.tencent.mm.plugin.finder.live.component.msginterceptor.precheck;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.i;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bip;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/precheck/LiveMsgRespAssetInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IPreCheckInterceptor;", "()V", "intercept", "", "cgiResp", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements i
{
  public final boolean b(final com.tencent.mm.plugin.finder.live.component.msginterceptor.a parama)
  {
    AppMethodBeat.i(353244);
    s.u(parama, "cgiResp");
    int i = parama.errCode;
    final int j = parama.errType;
    parama = parama.CBl;
    e locale;
    long l;
    label47:
    label57:
    Object localObject;
    if (parama == null)
    {
      parama = null;
      locale = (e)b.HbT;
      if (parama != null) {
        break label178;
      }
      l = 0L;
      if (l == 0L) {
        break label187;
      }
      bool = true;
      e.a.a(locale, "liveHeartBeatSvrErr", bool, null, false, (kotlin.g.a.a)new a(i, j), 28);
      locale = (e)b.HbT;
      localObject = aj.CGT;
      localObject = (f)aj.business(f.class);
      if (localObject != null) {
        break label193;
      }
      l = 0L;
      label113:
      if (l == 0L) {
        break label221;
      }
    }
    label178:
    label187:
    label193:
    label221:
    for (boolean bool = true;; bool = false)
    {
      e.a.a(locale, "liveHeartBeatLocalErr", bool, null, false, (kotlin.g.a.a)new b(i, j, parama), 28);
      AppMethodBeat.o(353244);
      return true;
      parama = parama.CBm;
      if (parama == null)
      {
        parama = null;
        break;
      }
      parama = parama.liveInfo;
      break;
      l = parama.liveId;
      break label47;
      bool = false;
      break label57;
      localObject = ((f)localObject).liveInfo;
      if (localObject == null)
      {
        l = 0L;
        break label113;
      }
      l = ((bip)localObject).liveId;
      break label113;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<String>
  {
    a(int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<String>
  {
    b(int paramInt1, int paramInt2, bip parambip)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.precheck.a
 * JD-Core Version:    0.7.0.1
 */