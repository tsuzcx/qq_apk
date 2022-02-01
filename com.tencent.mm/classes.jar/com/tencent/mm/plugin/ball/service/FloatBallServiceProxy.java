package com.tencent.mm.plugin.ball.service;

import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.os.ResultReceiver;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.ball.c.b.a;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.c.i;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.Set;

public final class FloatBallServiceProxy
  implements com.tencent.mm.plugin.ball.c.b
{
  public final void BC(int paramInt)
  {
    AppMethodBeat.i(184599);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCInteger(paramInt), FloatBallServiceProxy.ae.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(184599);
  }
  
  public final void BD(int paramInt)
  {
    AppMethodBeat.i(217028);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCInteger(paramInt), FloatBallServiceProxy.ab.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217028);
  }
  
  public final void By(long paramLong)
  {
    AppMethodBeat.i(217025);
    Log.w("MicroMsg.FloatBallServiceProxy", "markEnterChattingUI not implemented in non-MM process");
    AppMethodBeat.o(217025);
  }
  
  public final void Dw(boolean paramBoolean)
  {
    AppMethodBeat.i(106197);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(paramBoolean), al.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106197);
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(184594);
    XIPCInvoker.a(MainProcessIPCService.dkO, new FloatBallServiceProxy.IPCKeyBoardChangedInfo(paramInt1, paramInt2, paramBoolean, paramLong), FloatBallServiceProxy.ak.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(184594);
  }
  
  public final void a(int paramInt, e parame)
  {
    AppMethodBeat.i(106220);
    Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallInfoEventListener not implemented in non-MM process");
    AppMethodBeat.o(106220);
  }
  
  public final void a(long paramLong, b.a parama)
  {
    AppMethodBeat.i(217027);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCLong(paramLong), FloatBallServiceProxy.c.class, new FloatBallServiceProxy.9(this, parama));
    AppMethodBeat.o(217027);
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(217029);
    XIPCInvoker.a(MainProcessIPCService.dkO, paramResultReceiver, FloatBallServiceProxy.ah.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217029);
  }
  
  public final void a(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(258074);
    Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallInfoChangedListener not implemented in non-MM process");
    AppMethodBeat.o(258074);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(217031);
    Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallViewListener not implemented in non-MM process");
    AppMethodBeat.o(217031);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(106203);
    XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, FloatBallServiceProxy.k.class, new FloatBallServiceProxy.4(this, parami));
    AppMethodBeat.o(106203);
  }
  
  public final void a(BallInfo paramBallInfo, float paramFloat)
  {
    AppMethodBeat.i(106218);
    XIPCInvoker.a(MainProcessIPCService.dkO, new FloatBallServiceProxy.SetFloatBallAlphaParcel(paramFloat, paramBallInfo), FloatBallServiceProxy.ag.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106218);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106214);
    paramResultReceiver = com.tencent.mm.plugin.ball.f.d.b(paramResultReceiver);
    XIPCInvoker.a(MainProcessIPCService.dkO, new FloatBallServiceProxy.FloatBallInfoEventReceiverParcel(paramBallInfo, paramResultReceiver), FloatBallServiceProxy.y.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106214);
  }
  
  public final void a(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106219);
    XIPCInvoker.a(MainProcessIPCService.dkO, new FloatBallServiceProxy.UpdateBallVisibilityParcel(paramBoolean, paramBallInfo), FloatBallServiceProxy.aj.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106219);
  }
  
  public final void b(int paramInt, e parame)
  {
    AppMethodBeat.i(106221);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallInfoEventListener not implemented in non-MM process");
    AppMethodBeat.o(106221);
  }
  
  public final void b(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(258075);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallInfoChangedListener not implemented in non-MM process");
    AppMethodBeat.o(258075);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(217032);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallViewListener not implemented in non-MM process");
    AppMethodBeat.o(217032);
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184598);
    Log.w("MicroMsg.FloatBallServiceProxy", "updateBallVisibilityByPosition not implemented in non-MM process");
    AppMethodBeat.o(184598);
    return false;
  }
  
  public final void chL()
  {
    AppMethodBeat.i(106195);
    XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, FloatBallServiceProxy.w.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106195);
  }
  
  public final boolean chM()
  {
    AppMethodBeat.i(106198);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, FloatBallServiceProxy.r.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106198);
      return true;
    }
    AppMethodBeat.o(106198);
    return false;
  }
  
  public final boolean chN()
  {
    AppMethodBeat.i(217024);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, FloatBallServiceProxy.v.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(217024);
      return true;
    }
    AppMethodBeat.o(217024);
    return false;
  }
  
  public final boolean chO()
  {
    AppMethodBeat.i(106199);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, FloatBallServiceProxy.s.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106199);
      return true;
    }
    AppMethodBeat.o(106199);
    return false;
  }
  
  public final void chP()
  {
    AppMethodBeat.i(106200);
    XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, FloatBallServiceProxy.j.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106200);
  }
  
  public final List<BallInfo> chQ()
  {
    return null;
  }
  
  public final List<BallInfo> chR()
  {
    return null;
  }
  
  public final Set<g> chS()
  {
    AppMethodBeat.i(217033);
    Log.w("MicroMsg.FloatBallServiceProxy", "getFloatBallViewListeners not implemented in non-MM process");
    AppMethodBeat.o(217033);
    return null;
  }
  
  public final boolean chT()
  {
    AppMethodBeat.i(217034);
    Log.w("MicroMsg.FloatBallServiceProxy", "isFloatBallViewDockLeft not implemented in non-MM process");
    AppMethodBeat.o(217034);
    return false;
  }
  
  public final void chU() {}
  
  public final boolean chV()
  {
    AppMethodBeat.i(217023);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, FloatBallServiceProxy.q.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(217023);
      return true;
    }
    AppMethodBeat.o(217023);
    return false;
  }
  
  public final void chW()
  {
    AppMethodBeat.i(184596);
    Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184596);
  }
  
  public final void chX()
  {
    AppMethodBeat.i(184597);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184597);
  }
  
  public final void dn(View paramView) {}
  
  public final long fvY()
  {
    AppMethodBeat.i(258576);
    Log.w("MicroMsg.FloatBallServiceProxy", "getEnterChattingUITimestamp not implemented in non-MM process");
    AppMethodBeat.o(258576);
    return 0L;
  }
  
  public final void fwa()
  {
    AppMethodBeat.i(106202);
    XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, am.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106202);
  }
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106216);
    Point localPoint = (Point)XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, FloatBallServiceProxy.m.class);
    AppMethodBeat.o(106216);
    return localPoint;
  }
  
  public final BallInfo h(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106204);
    paramBallInfo = (BallInfo)XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.l.class);
    AppMethodBeat.o(106204);
    return paramBallInfo;
  }
  
  public final boolean i(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106205);
    paramBallInfo = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.d.class);
    if ((paramBallInfo != null) && (paramBallInfo.value))
    {
      AppMethodBeat.o(106205);
      return true;
    }
    AppMethodBeat.o(106205);
    return false;
  }
  
  public final void j(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106206);
    XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.a.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106206);
  }
  
  public final void jL(boolean paramBoolean)
  {
    AppMethodBeat.i(106191);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(paramBoolean), FloatBallServiceProxy.n.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106191);
  }
  
  public final void jM(boolean paramBoolean)
  {
    AppMethodBeat.i(106192);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(paramBoolean), FloatBallServiceProxy.ac.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106192);
  }
  
  public final void jN(boolean paramBoolean)
  {
    AppMethodBeat.i(106193);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(paramBoolean), FloatBallServiceProxy.o.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106193);
  }
  
  public final void jO(boolean paramBoolean)
  {
    AppMethodBeat.i(106194);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(paramBoolean), FloatBallServiceProxy.ad.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106194);
  }
  
  public final void jP(boolean paramBoolean)
  {
    AppMethodBeat.i(217022);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(paramBoolean), FloatBallServiceProxy.p.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217022);
  }
  
  public final void jQ(boolean paramBoolean)
  {
    AppMethodBeat.i(176964);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(paramBoolean), FloatBallServiceProxy.u.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(176964);
  }
  
  public final void jR(boolean paramBoolean)
  {
    AppMethodBeat.i(184595);
    Log.w("MicroMsg.FloatBallServiceProxy", "markNeedProcessFloatViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184595);
  }
  
  public final void jS(boolean paramBoolean)
  {
    AppMethodBeat.i(217035);
    Log.w("MicroMsg.FloatBallServiceProxy", "markForceHideAllFloatBall not implemented in non-MM process");
    AppMethodBeat.o(217035);
  }
  
  public final void k(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106207);
    XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.ai.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106207);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106208);
    XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.z.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106208);
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106209);
    XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.e.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106209);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106210);
    XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.i.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106210);
  }
  
  public final void o(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106211);
    XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.f.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106211);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106196);
    XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, FloatBallServiceProxy.x.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106196);
  }
  
  public final void p(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106212);
    XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.g.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106212);
  }
  
  public final void q(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106213);
    XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.h.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106213);
  }
  
  public final void r(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217030);
    if (paramBallInfo == null)
    {
      AppMethodBeat.o(217030);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.b.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217030);
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106215);
    XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.aa.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106215);
  }
  
  public final void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(217036);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(paramBoolean), FloatBallServiceProxy.af.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217036);
  }
  
  public final void t(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217026);
    XIPCInvoker.a(MainProcessIPCService.dkO, paramBallInfo, FloatBallServiceProxy.t.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217026);
  }
  
  public final void u(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217037);
    Log.w("MicroMsg.FloatBallServiceProxy", "switchVoipVoice not implemented in non-MM process");
    AppMethodBeat.o(217037);
  }
  
  static final class al
    implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid>
  {}
  
  static final class am
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy
 * JD-Core Version:    0.7.0.1
 */