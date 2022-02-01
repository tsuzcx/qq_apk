package com.tencent.mm.plugin.finder.nearby.service.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.je;
import com.tencent.mm.autogen.a.jf;
import com.tencent.mm.autogen.a.jg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/service/impl/NearbyRefreshServiceImpl;", "Lcom/tencent/plugin/finder/nearby/api/service/INearbyRefreshService;", "()V", "cancelJob", "Lkotlinx/coroutines/Job;", "isEventRegist", "", "isFromRed", "objectId", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "clearNewEntranceCache", "", "markEventRegister", "isRegister", "notifyDataChange", "requestRefresh", "requestRefreshNewEntrance", "checkEnterLoad", "resetCache", "saveResponse", "rsp", "", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.d.a.b.a.b.a
{
  public static final a.a ERp;
  private IResponse<?> BkO;
  private boolean ERq;
  private cb ERr;
  private boolean Ebc;
  private long hKN;
  
  static
  {
    AppMethodBeat.i(339947);
    ERp = new a.a((byte)0);
    AppMethodBeat.o(339947);
  }
  
  public final void A(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(339997);
    Log.i("NearbyRefreshServiceImp", "requestRefresh " + paramLong + " isFromRed: " + paramBoolean + " isEventRegist: " + this.ERq);
    this.hKN = paramLong;
    this.Ebc = paramBoolean;
    Object localObject;
    if (!this.ERq)
    {
      localObject = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
      localObject = new bnn();
      ((bnn)localObject).ZVZ = 88890;
      ah localah = ah.aiuX;
      localObject = com.tencent.mm.plugin.finder.nearby.preload.a.b((bnn)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject).pn(paramLong);
      }
    }
    for (;;)
    {
      if (((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isNewLiveEntranceEnable())
      {
        localObject = new jg();
        ((jg)localObject).hKR.hKN = paramLong;
        ((jg)localObject).publish();
      }
      AppMethodBeat.o(339997);
      return;
      localObject = new jf();
      ((jf)localObject).hKQ.hKN = paramLong;
      ((jf)localObject).publish();
    }
  }
  
  public final void deo()
  {
    AppMethodBeat.i(340025);
    Log.i("NearbyRefreshServiceImp", "notifyDataChange " + this.BkO + " objectId: " + this.hKN + ' ');
    Object localObject;
    if ((this.Ebc) && (this.BkO == null))
    {
      localObject = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
      localObject = new bnn();
      ((bnn)localObject).ZVZ = 88890;
      ah localah = ah.aiuX;
      localObject = com.tencent.mm.plugin.finder.nearby.preload.a.b((bnn)localObject);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject).eGD();
        AppMethodBeat.o(340025);
      }
    }
    else if (this.BkO != null)
    {
      localObject = new je();
      ((je)localObject).hKM.hKP = this.BkO;
      ((je)localObject).hKM.hKN = this.hKN;
      ((je)localObject).hKM.hKO = this.Ebc;
      ((je)localObject).publish();
      this.BkO = null;
    }
    AppMethodBeat.o(340025);
  }
  
  public final void eGP()
  {
    AppMethodBeat.i(339973);
    this.ERr = j.a(ar.d((f)bg.kCi()), null, null, (m)new a.b(this, null), 3);
    AppMethodBeat.o(339973);
  }
  
  public final void fx(Object paramObject)
  {
    AppMethodBeat.i(340014);
    if (!this.ERq)
    {
      AppMethodBeat.o(340014);
      return;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.internal.IResponse<*>");
      AppMethodBeat.o(340014);
      throw paramObject;
    }
    this.BkO = ((IResponse)paramObject);
    paramObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    boolean bool = com.tencent.mm.plugin.finder.nearby.abtest.a.eEk();
    Log.i("NearbyRefreshServiceImp", "saveResponse " + this.BkO + " isEnableAnimReplace: " + bool);
    if (!bool) {
      deo();
    }
    AppMethodBeat.o(340014);
  }
  
  public final void resetCache()
  {
    AppMethodBeat.i(340037);
    com.tencent.mm.plugin.finder.nearby.preload.firstpage.b.a locala = com.tencent.mm.plugin.finder.nearby.preload.firstpage.b.EQd;
    com.tencent.mm.plugin.finder.nearby.preload.firstpage.b.QZ(1);
    AppMethodBeat.o(340037);
  }
  
  public final void sU(boolean paramBoolean)
  {
    AppMethodBeat.i(339958);
    Log.i("NearbyRefreshServiceImp", s.X("markEventRegister isRegister: ", Boolean.valueOf(paramBoolean)));
    this.ERq = paramBoolean;
    AppMethodBeat.o(339958);
  }
  
  public final void sV(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(339981);
    Object localObject = com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.b.EOI;
    localObject = com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.b.a.eFY();
    com.tencent.mm.plugin.finder.nearby.newlivesquare.a locala = com.tencent.mm.plugin.finder.nearby.newlivesquare.a.EMv;
    boolean bool3 = com.tencent.mm.plugin.finder.nearby.newlivesquare.a.eFI();
    boolean bool1;
    boolean bool2;
    if ((paramBoolean) && ((localObject == null) || (!((com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.b)localObject).eFX())))
    {
      bool1 = true;
      localObject = com.tencent.mm.plugin.finder.nearby.newlivesquare.a.EMv;
      long l = com.tencent.mm.plugin.finder.nearby.newlivesquare.a.eFF();
      if ((paramBoolean) || (l <= 0L)) {
        break label235;
      }
      localObject = com.tencent.mm.plugin.finder.nearby.newlivesquare.a.EMv;
      if (com.tencent.mm.plugin.finder.nearby.newlivesquare.a.eFG() + l >= System.currentTimeMillis()) {
        break label235;
      }
      bool2 = true;
      label89:
      localObject = new StringBuilder("requestRefreshNewEntrance: checkEnterLoad=").append(paramBoolean).append(", needEnterLoad=").append(bool1).append(", enablePrefetch=").append(bool2).append(", isAutoRefresh=").append(bool3).append(", preFetchInterval=").append(l).append(", lastRespSetTime=");
      locala = com.tencent.mm.plugin.finder.nearby.newlivesquare.a.EMv;
      Log.i("NearbyRefreshServiceImp", com.tencent.mm.plugin.finder.nearby.newlivesquare.a.eFG());
      if ((!bool3) || ((!bool1) && (!bool2))) {
        break label293;
      }
      localObject = this.ERr;
      if ((localObject == null) || (((cb)localObject).isActive() != true)) {
        break label241;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label246;
      }
      Log.w("NearbyRefreshServiceImp", "requestRefreshNewEntrance: is canceling");
      AppMethodBeat.o(339981);
      return;
      bool1 = false;
      break;
      label235:
      bool2 = false;
      break label89;
      label241:
      i = 0;
    }
    label246:
    localObject = com.tencent.mm.plugin.finder.nearby.newlivesquare.a.EMv;
    com.tencent.mm.plugin.finder.nearby.newlivesquare.a.pl(System.currentTimeMillis());
    Log.i("NearbyRefreshServiceImp", "requestRefreshNewEntrance: start preload");
    j.a(ar.d((f)bg.kCi()), null, null, (m)new a.c(paramBoolean, null), 3);
    label293:
    AppMethodBeat.o(339981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.service.impl.a
 * JD-Core Version:    0.7.0.1
 */