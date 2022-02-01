package com.tencent.mm.plugin.ball.service;

import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.c.c.a;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;

public final class FloatBallServiceProxy
  implements c
{
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(184594);
    XIPCInvoker.a("com.tencent.mm", new IPCKeyBoardChangedInfo(paramInt1, paramInt2, paramBoolean, paramLong), al.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(184594);
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(106220);
    ac.w("MicroMsg.FloatBallServiceProxy", "addFloatBallInfoEventListener not implemented in non-MM process");
    AppMethodBeat.o(106220);
  }
  
  public final void a(long paramLong, final c.a parama)
  {
    AppMethodBeat.i(208007);
    XIPCInvoker.a("com.tencent.mm", new IPCLong(paramLong), FloatBallServiceProxy.b.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(208007);
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(208009);
    XIPCInvoker.a("com.tencent.mm", paramResultReceiver, FloatBallServiceProxy.ai.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(208009);
  }
  
  public final void a(final h paramh)
  {
    AppMethodBeat.i(106203);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, j.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106203);
  }
  
  public final void a(BallInfo paramBallInfo, float paramFloat)
  {
    AppMethodBeat.i(106218);
    XIPCInvoker.a("com.tencent.mm", new SetFloatBallAlphaParcel(paramFloat, paramBallInfo), ah.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106218);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106214);
    XIPCInvoker.a("com.tencent.mm", new FloatBallInfoEventReceiverParcel(paramBallInfo, com.tencent.mm.plugin.ball.f.d.b(paramResultReceiver)), z.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106214);
  }
  
  public final void a(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106219);
    XIPCInvoker.a("com.tencent.mm", new UpdateBallVisibilityParcel(paramBoolean, paramBallInfo), ak.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106219);
  }
  
  public final void b(int paramInt, f paramf)
  {
    AppMethodBeat.i(106221);
    ac.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallInfoEventListener not implemented in non-MM process");
    AppMethodBeat.o(106221);
  }
  
  public final void bFL()
  {
    AppMethodBeat.i(106195);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, FloatBallServiceProxy.w.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106195);
  }
  
  public final boolean bFM()
  {
    AppMethodBeat.i(106198);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, FloatBallServiceProxy.r.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106198);
      return true;
    }
    AppMethodBeat.o(106198);
    return false;
  }
  
  public final boolean bFN()
  {
    AppMethodBeat.i(106199);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, FloatBallServiceProxy.s.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106199);
      return true;
    }
    AppMethodBeat.o(106199);
    return false;
  }
  
  public final long bFO()
  {
    AppMethodBeat.i(208005);
    ac.w("MicroMsg.FloatBallServiceProxy", "getEnterChattingUITimestamp not implemented in non-MM process");
    AppMethodBeat.o(208005);
    return 0L;
  }
  
  public final void bFP()
  {
    AppMethodBeat.i(106200);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, FloatBallServiceProxy.i.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106200);
  }
  
  public final void bFQ()
  {
    AppMethodBeat.i(106202);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, FloatBallServiceProxy.y.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106202);
  }
  
  public final List<BallInfo> bFR()
  {
    return null;
  }
  
  public final void bFS() {}
  
  public final boolean bFT()
  {
    AppMethodBeat.i(208003);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, FloatBallServiceProxy.q.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(208003);
      return true;
    }
    AppMethodBeat.o(208003);
    return false;
  }
  
  public final void bFU()
  {
    AppMethodBeat.i(184596);
    ac.w("MicroMsg.FloatBallServiceProxy", "addFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184596);
  }
  
  public final void bFV()
  {
    AppMethodBeat.i(184597);
    ac.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184597);
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184598);
    ac.w("MicroMsg.FloatBallServiceProxy", "updateBallVisibilityByPosition not implemented in non-MM process");
    AppMethodBeat.o(184598);
    return false;
  }
  
  public final void du(View paramView) {}
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106216);
    Point localPoint = (Point)XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, FloatBallServiceProxy.l.class);
    AppMethodBeat.o(106216);
    return localPoint;
  }
  
  public final BallInfo h(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106204);
    paramBallInfo = (BallInfo)XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.k.class);
    AppMethodBeat.o(106204);
    return paramBallInfo;
  }
  
  public final boolean i(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106205);
    paramBallInfo = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.c.class);
    if ((paramBallInfo != null) && (paramBallInfo.value))
    {
      AppMethodBeat.o(106205);
      return true;
    }
    AppMethodBeat.o(106205);
    return false;
  }
  
  public final void iE(boolean paramBoolean)
  {
    AppMethodBeat.i(106191);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.m.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106191);
  }
  
  public final void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(106192);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.ad.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106192);
  }
  
  public final void iG(boolean paramBoolean)
  {
    AppMethodBeat.i(106193);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.n.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106193);
  }
  
  public final void iH(boolean paramBoolean)
  {
    AppMethodBeat.i(106194);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.ae.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106194);
  }
  
  public final void iI(boolean paramBoolean)
  {
    AppMethodBeat.i(208002);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.o.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(208002);
  }
  
  public final void iJ(boolean paramBoolean)
  {
    AppMethodBeat.i(176964);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.v.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(176964);
  }
  
  public final void iK(boolean paramBoolean)
  {
    AppMethodBeat.i(106197);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.u.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106197);
  }
  
  public final void iL(boolean paramBoolean)
  {
    AppMethodBeat.i(184595);
    ac.w("MicroMsg.FloatBallServiceProxy", "markNeedProcessFloatViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184595);
  }
  
  public final void iM(boolean paramBoolean)
  {
    AppMethodBeat.i(208010);
    ac.w("MicroMsg.FloatBallServiceProxy", "markForceHideAllFloatBall not implemented in non-MM process");
    AppMethodBeat.o(208010);
  }
  
  public final void j(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106206);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.a.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106206);
  }
  
  public final void k(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106207);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.aj.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106207);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106208);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.aa.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106208);
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106209);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.d.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106209);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106210);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.h.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106210);
  }
  
  public final void o(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106211);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.e.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106211);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106196);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, FloatBallServiceProxy.x.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106196);
  }
  
  public final void p(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106212);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.f.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106212);
  }
  
  public final void q(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106213);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.g.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106213);
  }
  
  public final void r(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106215);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.ab.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106215);
  }
  
  public final void rf(long paramLong)
  {
    AppMethodBeat.i(208004);
    ac.w("MicroMsg.FloatBallServiceProxy", "markEnterChattingUI not implemented in non-MM process");
    AppMethodBeat.o(208004);
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(208006);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.t.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(208006);
  }
  
  public final void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(208011);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.ag.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(208011);
  }
  
  public final boolean xm(int paramInt)
  {
    AppMethodBeat.i(184593);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), FloatBallServiceProxy.p.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(184593);
      return true;
    }
    AppMethodBeat.o(184593);
    return false;
  }
  
  public final void xn(int paramInt)
  {
    AppMethodBeat.i(184599);
    XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), FloatBallServiceProxy.af.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(184599);
  }
  
  public final void xo(int paramInt)
  {
    AppMethodBeat.i(208008);
    XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), FloatBallServiceProxy.ac.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(208008);
  }
  
  static class BallInfoListParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<BallInfoListParcel> CREATOR;
    List<BallInfo> neE;
    
    static
    {
      AppMethodBeat.i(106149);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106149);
    }
    
    protected BallInfoListParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106147);
      this.neE = paramParcel.createTypedArrayList(BallInfo.CREATOR);
      AppMethodBeat.o(106147);
    }
    
    public BallInfoListParcel(List<BallInfo> paramList)
    {
      this.neE = paramList;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106148);
      paramParcel.writeTypedList(this.neE);
      AppMethodBeat.o(106148);
    }
  }
  
  static final class FloatBallInfoEventReceiverParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<FloatBallInfoEventReceiverParcel> CREATOR;
    ResultReceiver ceI;
    BallInfo nfN;
    
    static
    {
      AppMethodBeat.i(106160);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106160);
    }
    
    protected FloatBallInfoEventReceiverParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106158);
      this.nfN = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
      this.ceI = ((ResultReceiver)paramParcel.readParcelable(ResultReceiver.class.getClassLoader()));
      AppMethodBeat.o(106158);
    }
    
    public FloatBallInfoEventReceiverParcel(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
    {
      this.nfN = paramBallInfo;
      this.ceI = paramResultReceiver;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106159);
      paramParcel.writeParcelable(this.nfN, paramInt);
      paramParcel.writeParcelable(this.ceI, paramInt);
      AppMethodBeat.o(106159);
    }
  }
  
  static class IPCKeyBoardChangedInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCKeyBoardChangedInfo> CREATOR;
    long fe;
    boolean gmZ;
    int height;
    int ngp;
    
    static
    {
      AppMethodBeat.i(184587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(184587);
    }
    
    IPCKeyBoardChangedInfo(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
    {
      this.height = paramInt1;
      this.ngp = paramInt2;
      this.gmZ = paramBoolean;
      this.fe = paramLong;
    }
    
    IPCKeyBoardChangedInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(184585);
      this.height = paramParcel.readInt();
      this.ngp = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.gmZ = bool;
        this.fe = paramParcel.readLong();
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
      paramParcel.writeInt(this.ngp);
      if (this.gmZ) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeLong(this.fe);
        AppMethodBeat.o(184586);
        return;
      }
    }
  }
  
  static class SetFloatBallAlphaParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<SetFloatBallAlphaParcel> CREATOR;
    float alpha;
    BallInfo nfN;
    
    static
    {
      AppMethodBeat.i(106181);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106181);
    }
    
    public SetFloatBallAlphaParcel(float paramFloat, BallInfo paramBallInfo)
    {
      this.alpha = paramFloat;
      this.nfN = paramBallInfo;
    }
    
    protected SetFloatBallAlphaParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106179);
      this.alpha = paramParcel.readFloat();
      this.nfN = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
      AppMethodBeat.o(106179);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106180);
      paramParcel.writeFloat(this.alpha);
      paramParcel.writeParcelable(this.nfN, paramInt);
      AppMethodBeat.o(106180);
    }
  }
  
  static class UpdateBallVisibilityParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<UpdateBallVisibilityParcel> CREATOR;
    BallInfo nfN;
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
        this.nfN = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
        AppMethodBeat.o(106186);
        return;
      }
    }
    
    public UpdateBallVisibilityParcel(boolean paramBoolean, BallInfo paramBallInfo)
    {
      this.visible = paramBoolean;
      this.nfN = paramBallInfo;
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
        paramParcel.writeParcelable(this.nfN, paramInt);
        AppMethodBeat.o(106187);
        return;
      }
    }
  }
  
  static final class ah
    implements b<FloatBallServiceProxy.SetFloatBallAlphaParcel, IPCVoid>
  {}
  
  static final class ak
    implements b<FloatBallServiceProxy.UpdateBallVisibilityParcel, IPCVoid>
  {}
  
  static final class al
    implements b<FloatBallServiceProxy.IPCKeyBoardChangedInfo, IPCVoid>
  {}
  
  static final class j
    implements b<IPCVoid, FloatBallServiceProxy.BallInfoListParcel>
  {}
  
  static final class z
    implements b<FloatBallServiceProxy.FloatBallInfoEventReceiverParcel, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy
 * JD-Core Version:    0.7.0.1
 */