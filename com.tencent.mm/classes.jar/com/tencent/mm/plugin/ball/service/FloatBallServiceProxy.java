package com.tencent.mm.plugin.ball.service;

import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.b.a;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.c.i;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.Set;

public final class FloatBallServiceProxy
  implements b
{
  public final void Fd(int paramInt)
  {
    AppMethodBeat.i(184599);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCInteger(paramInt), ag.class, new f() {});
    AppMethodBeat.o(184599);
  }
  
  public final void Fe(int paramInt)
  {
    AppMethodBeat.i(187322);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCInteger(paramInt), ad.class, new f() {});
    AppMethodBeat.o(187322);
  }
  
  public final void HL(long paramLong)
  {
    AppMethodBeat.i(187303);
    Log.w("MicroMsg.FloatBallServiceProxy", "markEnterChattingUI not implemented in non-MM process");
    AppMethodBeat.o(187303);
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(184594);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCKeyBoardChangedInfo(paramInt1, paramInt2, paramBoolean, paramLong), al.class, new f() {});
    AppMethodBeat.o(184594);
  }
  
  public final void a(int paramInt, e parame)
  {
    AppMethodBeat.i(106220);
    Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallInfoEventListener not implemented in non-MM process");
    AppMethodBeat.o(106220);
  }
  
  public final void a(long paramLong, final b.a parama)
  {
    AppMethodBeat.i(187320);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCLong(paramLong), c.class, new f() {});
    AppMethodBeat.o(187320);
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(187331);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramResultReceiver, FloatBallServiceProxy.ai.class, new f() {});
    AppMethodBeat.o(187331);
  }
  
  public final void a(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(187337);
    Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallInfoChangedListener not implemented in non-MM process");
    AppMethodBeat.o(187337);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(187348);
    Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallViewListener not implemented in non-MM process");
    AppMethodBeat.o(187348);
  }
  
  public final void a(final i parami)
  {
    AppMethodBeat.i(106203);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, k.class, new f() {});
    AppMethodBeat.o(106203);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106214);
    paramResultReceiver = com.tencent.mm.plugin.ball.f.d.b(paramResultReceiver);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new FloatBallInfoEventReceiverParcel(paramBallInfo, paramResultReceiver), aa.class, new f() {});
    AppMethodBeat.o(106214);
  }
  
  public final void a(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106219);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new UpdateBallVisibilityParcel(paramBoolean, paramBallInfo), ak.class, new f() {});
    AppMethodBeat.o(106219);
  }
  
  public final void aGp()
  {
    AppMethodBeat.i(106195);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, FloatBallServiceProxy.x.class, new f() {});
    AppMethodBeat.o(106195);
  }
  
  public final void b(int paramInt, e parame)
  {
    AppMethodBeat.i(106221);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallInfoEventListener not implemented in non-MM process");
    AppMethodBeat.o(106221);
  }
  
  public final void b(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(187340);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallInfoChangedListener not implemented in non-MM process");
    AppMethodBeat.o(187340);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(187349);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallViewListener not implemented in non-MM process");
    AppMethodBeat.o(187349);
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184598);
    Log.w("MicroMsg.FloatBallServiceProxy", "updateBallVisibilityByPosition not implemented in non-MM process");
    AppMethodBeat.o(184598);
    return false;
  }
  
  public final boolean cuW()
  {
    AppMethodBeat.i(106198);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, FloatBallServiceProxy.r.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106198);
      return true;
    }
    AppMethodBeat.o(106198);
    return false;
  }
  
  public final boolean cuX()
  {
    AppMethodBeat.i(187300);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, FloatBallServiceProxy.w.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(187300);
      return true;
    }
    AppMethodBeat.o(187300);
    return false;
  }
  
  public final boolean cuY()
  {
    AppMethodBeat.i(106199);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, FloatBallServiceProxy.s.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106199);
      return true;
    }
    AppMethodBeat.o(106199);
    return false;
  }
  
  public final long cuZ()
  {
    AppMethodBeat.i(187304);
    Log.w("MicroMsg.FloatBallServiceProxy", "getEnterChattingUITimestamp not implemented in non-MM process");
    AppMethodBeat.o(187304);
    return 0L;
  }
  
  public final void cva()
  {
    AppMethodBeat.i(106200);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, FloatBallServiceProxy.j.class, new f() {});
    AppMethodBeat.o(106200);
  }
  
  public final void cvb()
  {
    AppMethodBeat.i(106202);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, FloatBallServiceProxy.z.class, new f() {});
    AppMethodBeat.o(106202);
  }
  
  public final List<BallInfo> cvc()
  {
    return null;
  }
  
  public final List<BallInfo> cvd()
  {
    return null;
  }
  
  public final Set<g> cve()
  {
    AppMethodBeat.i(187351);
    Log.w("MicroMsg.FloatBallServiceProxy", "getFloatBallViewListeners not implemented in non-MM process");
    AppMethodBeat.o(187351);
    return null;
  }
  
  public final boolean cvf()
  {
    AppMethodBeat.i(187352);
    Log.w("MicroMsg.FloatBallServiceProxy", "isFloatBallViewDockLeft not implemented in non-MM process");
    AppMethodBeat.o(187352);
    return false;
  }
  
  public final void cvg() {}
  
  public final boolean cvh()
  {
    AppMethodBeat.i(187298);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, FloatBallServiceProxy.q.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(187298);
      return true;
    }
    AppMethodBeat.o(187298);
    return false;
  }
  
  public final void cvi()
  {
    AppMethodBeat.i(184596);
    Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184596);
  }
  
  public final void cvj()
  {
    AppMethodBeat.i(184597);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184597);
  }
  
  public final void dK(View paramView) {}
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106216);
    Point localPoint = (Point)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, FloatBallServiceProxy.m.class);
    AppMethodBeat.o(106216);
    return localPoint;
  }
  
  public final BallInfo h(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106204);
    try
    {
      paramBallInfo = (BallInfo)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.l.class);
      AppMethodBeat.o(106204);
      return paramBallInfo;
    }
    catch (c paramBallInfo)
    {
      Log.e("MicroMsg.FloatBallServiceProxy", "getBallInfo:", new Object[] { paramBallInfo });
      AppMethodBeat.o(106204);
    }
    return null;
  }
  
  public final boolean i(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106205);
    try
    {
      paramBallInfo = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.d.class);
      if ((paramBallInfo != null) && (paramBallInfo.value))
      {
        AppMethodBeat.o(106205);
        return true;
      }
      AppMethodBeat.o(106205);
      return false;
    }
    catch (c paramBallInfo)
    {
      Log.e("MicroMsg.FloatBallServiceProxy", "canAddBallInfo:", new Object[] { paramBallInfo });
      AppMethodBeat.o(106205);
    }
    return false;
  }
  
  public final void j(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106206);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.a.class, new f() {});
    AppMethodBeat.o(106206);
  }
  
  public final void k(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106207);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.aj.class, new f() {});
    AppMethodBeat.o(106207);
  }
  
  public final void kV(boolean paramBoolean)
  {
    AppMethodBeat.i(106191);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), n.class, new f() {});
    AppMethodBeat.o(106191);
  }
  
  public final void kW(boolean paramBoolean)
  {
    AppMethodBeat.i(106192);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), ae.class, new f() {});
    AppMethodBeat.o(106192);
  }
  
  public final void kX(boolean paramBoolean)
  {
    AppMethodBeat.i(106193);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), FloatBallServiceProxy.o.class, new f() {});
    AppMethodBeat.o(106193);
  }
  
  public final void kY(boolean paramBoolean)
  {
    AppMethodBeat.i(106194);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), FloatBallServiceProxy.af.class, new f() {});
    AppMethodBeat.o(106194);
  }
  
  public final void kZ(boolean paramBoolean)
  {
    AppMethodBeat.i(187276);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), FloatBallServiceProxy.p.class, new f() {});
    AppMethodBeat.o(187276);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106208);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.ab.class, new f() {});
    AppMethodBeat.o(106208);
  }
  
  public final void la(boolean paramBoolean)
  {
    AppMethodBeat.i(176964);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), FloatBallServiceProxy.v.class, new f() {});
    AppMethodBeat.o(176964);
  }
  
  public final void lb(boolean paramBoolean)
  {
    AppMethodBeat.i(106197);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), FloatBallServiceProxy.u.class, new f() {});
    AppMethodBeat.o(106197);
  }
  
  public final void lc(boolean paramBoolean)
  {
    AppMethodBeat.i(184595);
    Log.w("MicroMsg.FloatBallServiceProxy", "markNeedProcessFloatViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184595);
  }
  
  public final void ld(boolean paramBoolean)
  {
    AppMethodBeat.i(187354);
    Log.w("MicroMsg.FloatBallServiceProxy", "markForceHideAllFloatBall not implemented in non-MM process");
    AppMethodBeat.o(187354);
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106209);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.e.class, new f() {});
    AppMethodBeat.o(106209);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106210);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.i.class, new f() {});
    AppMethodBeat.o(106210);
  }
  
  public final void o(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106211);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.f.class, new f() {});
    AppMethodBeat.o(106211);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106196);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, FloatBallServiceProxy.y.class, new f() {});
    AppMethodBeat.o(106196);
  }
  
  public final void p(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106212);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.g.class, new f() {});
    AppMethodBeat.o(106212);
  }
  
  public final void q(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106213);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.h.class, new f() {});
    AppMethodBeat.o(106213);
  }
  
  public final void r(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(187334);
    if (paramBallInfo == null)
    {
      AppMethodBeat.o(187334);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, b.class, new f() {});
    AppMethodBeat.o(187334);
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106215);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.ac.class, new f() {});
    AppMethodBeat.o(106215);
  }
  
  public final void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(187358);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), FloatBallServiceProxy.ah.class, new f() {});
    AppMethodBeat.o(187358);
  }
  
  public final void t(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(187319);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, FloatBallServiceProxy.t.class, new f() {});
    AppMethodBeat.o(187319);
  }
  
  public final void u(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(187363);
    Log.w("MicroMsg.FloatBallServiceProxy", "switchVoipVoice not implemented in non-MM process");
    AppMethodBeat.o(187363);
  }
  
  static class BallInfoListParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<BallInfoListParcel> CREATOR;
    List<BallInfo> rXp;
    
    static
    {
      AppMethodBeat.i(106149);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106149);
    }
    
    protected BallInfoListParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106147);
      this.rXp = paramParcel.createTypedArrayList(BallInfo.CREATOR);
      AppMethodBeat.o(106147);
    }
    
    public BallInfoListParcel(List<BallInfo> paramList)
    {
      this.rXp = paramList;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106148);
      paramParcel.writeTypedList(this.rXp);
      AppMethodBeat.o(106148);
    }
  }
  
  static final class FloatBallInfoEventReceiverParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<FloatBallInfoEventReceiverParcel> CREATOR;
    ResultReceiver cAX;
    BallInfo rYE;
    
    static
    {
      AppMethodBeat.i(106160);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106160);
    }
    
    protected FloatBallInfoEventReceiverParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106158);
      this.rYE = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
      this.cAX = ((ResultReceiver)paramParcel.readParcelable(ResultReceiver.class.getClassLoader()));
      AppMethodBeat.o(106158);
    }
    
    public FloatBallInfoEventReceiverParcel(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
    {
      this.rYE = paramBallInfo;
      this.cAX = paramResultReceiver;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106159);
      paramParcel.writeParcelable(this.rYE, paramInt);
      paramParcel.writeParcelable(this.cAX, paramInt);
      AppMethodBeat.o(106159);
    }
  }
  
  static class IPCKeyBoardChangedInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCKeyBoardChangedInfo> CREATOR;
    long delay;
    int height;
    boolean kiD;
    int rZj;
    
    static
    {
      AppMethodBeat.i(184587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(184587);
    }
    
    IPCKeyBoardChangedInfo(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
    {
      this.height = paramInt1;
      this.rZj = paramInt2;
      this.kiD = paramBoolean;
      this.delay = paramLong;
    }
    
    IPCKeyBoardChangedInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(184585);
      this.height = paramParcel.readInt();
      this.rZj = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.kiD = bool;
        this.delay = paramParcel.readLong();
        AppMethodBeat.o(184585);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(184586);
      paramParcel.writeInt(this.height);
      paramParcel.writeInt(this.rZj);
      if (this.kiD) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeLong(this.delay);
        AppMethodBeat.o(184586);
        return;
      }
    }
  }
  
  static class UpdateBallVisibilityParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<UpdateBallVisibilityParcel> CREATOR;
    BallInfo rYE;
    boolean visible;
    
    static
    {
      AppMethodBeat.i(106188);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106188);
    }
    
    protected UpdateBallVisibilityParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106186);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.visible = bool;
        this.rYE = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
        AppMethodBeat.o(106186);
        return;
      }
    }
    
    public UpdateBallVisibilityParcel(boolean paramBoolean, BallInfo paramBallInfo)
    {
      this.visible = paramBoolean;
      this.rYE = paramBallInfo;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106187);
      if (this.visible) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeParcelable(this.rYE, paramInt);
        AppMethodBeat.o(106187);
        return;
      }
    }
  }
  
  static final class aa
    implements com.tencent.mm.ipcinvoker.d<FloatBallServiceProxy.FloatBallInfoEventReceiverParcel, IPCVoid>
  {}
  
  static final class ad
    implements com.tencent.mm.ipcinvoker.d<IPCInteger, IPCVoid>
  {}
  
  static final class ae
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean, IPCVoid>
  {}
  
  static final class ag
    implements com.tencent.mm.ipcinvoker.d<IPCInteger, IPCVoid>
  {}
  
  static final class ak
    implements com.tencent.mm.ipcinvoker.d<FloatBallServiceProxy.UpdateBallVisibilityParcel, IPCVoid>
  {}
  
  static final class al
    implements com.tencent.mm.ipcinvoker.d<FloatBallServiceProxy.IPCKeyBoardChangedInfo, IPCVoid>
  {}
  
  static final class b
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class c
    implements com.tencent.mm.ipcinvoker.d<IPCLong, IPCInteger>
  {}
  
  static final class k
    implements com.tencent.mm.ipcinvoker.d<IPCVoid, FloatBallServiceProxy.BallInfoListParcel>
  {}
  
  static final class n
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy
 * JD-Core Version:    0.7.0.1
 */