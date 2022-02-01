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
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.c.c.a;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;
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
    ad.w("MicroMsg.FloatBallServiceProxy", "addFloatBallInfoEventListener not implemented in non-MM process");
    AppMethodBeat.o(106220);
  }
  
  public final void a(long paramLong, final c.a parama)
  {
    AppMethodBeat.i(217290);
    XIPCInvoker.a("com.tencent.mm", new IPCLong(paramLong), b.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217290);
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(217292);
    XIPCInvoker.a("com.tencent.mm", paramResultReceiver, FloatBallServiceProxy.ai.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217292);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(106203);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gyi, FloatBallServiceProxy.j.class, new FloatBallServiceProxy.5(this, paramh));
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
    ad.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallInfoEventListener not implemented in non-MM process");
    AppMethodBeat.o(106221);
  }
  
  public final void bJV()
  {
    AppMethodBeat.i(106195);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gyi, FloatBallServiceProxy.w.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106195);
  }
  
  public final boolean bJW()
  {
    AppMethodBeat.i(106198);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.gyi, r.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106198);
      return true;
    }
    AppMethodBeat.o(106198);
    return false;
  }
  
  public final boolean bJX()
  {
    AppMethodBeat.i(106199);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.gyi, s.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106199);
      return true;
    }
    AppMethodBeat.o(106199);
    return false;
  }
  
  public final long bJY()
  {
    AppMethodBeat.i(217288);
    ad.w("MicroMsg.FloatBallServiceProxy", "getEnterChattingUITimestamp not implemented in non-MM process");
    AppMethodBeat.o(217288);
    return 0L;
  }
  
  public final void bJZ()
  {
    AppMethodBeat.i(106200);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gyi, FloatBallServiceProxy.i.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106200);
  }
  
  public final void bKa()
  {
    AppMethodBeat.i(106202);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gyi, FloatBallServiceProxy.y.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106202);
  }
  
  public final List<BallInfo> bKb()
  {
    return null;
  }
  
  public final void bKc() {}
  
  public final boolean bKd()
  {
    AppMethodBeat.i(217286);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.gyi, q.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(217286);
      return true;
    }
    AppMethodBeat.o(217286);
    return false;
  }
  
  public final void bKe()
  {
    AppMethodBeat.i(184596);
    ad.w("MicroMsg.FloatBallServiceProxy", "addFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184596);
  }
  
  public final void bKf()
  {
    AppMethodBeat.i(184597);
    ad.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184597);
  }
  
  public final void bKg()
  {
    AppMethodBeat.i(217295);
    ad.w("MicroMsg.FloatBallServiceProxy", "switchVoipVoice not implemented in non-MM process");
    AppMethodBeat.o(217295);
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184598);
    ad.w("MicroMsg.FloatBallServiceProxy", "updateBallVisibilityByPosition not implemented in non-MM process");
    AppMethodBeat.o(184598);
    return false;
  }
  
  public final void dw(View paramView) {}
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106216);
    Point localPoint = (Point)XIPCInvoker.a("com.tencent.mm", IPCVoid.gyi, FloatBallServiceProxy.l.class);
    AppMethodBeat.o(106216);
    return localPoint;
  }
  
  public final BallInfo i(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106204);
    paramBallInfo = (BallInfo)XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.k.class);
    AppMethodBeat.o(106204);
    return paramBallInfo;
  }
  
  public final void iN(boolean paramBoolean)
  {
    AppMethodBeat.i(106191);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.m.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106191);
  }
  
  public final void iO(boolean paramBoolean)
  {
    AppMethodBeat.i(106192);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.ad.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106192);
  }
  
  public final void iP(boolean paramBoolean)
  {
    AppMethodBeat.i(106193);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.n.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106193);
  }
  
  public final void iQ(boolean paramBoolean)
  {
    AppMethodBeat.i(106194);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.ae.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106194);
  }
  
  public final void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(217285);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.o.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217285);
  }
  
  public final void iS(boolean paramBoolean)
  {
    AppMethodBeat.i(176964);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.v.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(176964);
  }
  
  public final void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(106197);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.u.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106197);
  }
  
  public final void iU(boolean paramBoolean)
  {
    AppMethodBeat.i(184595);
    ad.w("MicroMsg.FloatBallServiceProxy", "markNeedProcessFloatViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184595);
  }
  
  public final void iV(boolean paramBoolean)
  {
    AppMethodBeat.i(217293);
    ad.w("MicroMsg.FloatBallServiceProxy", "markForceHideAllFloatBall not implemented in non-MM process");
    AppMethodBeat.o(217293);
  }
  
  public final boolean j(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106205);
    paramBallInfo = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", paramBallInfo, c.class);
    if ((paramBallInfo != null) && (paramBallInfo.value))
    {
      AppMethodBeat.o(106205);
      return true;
    }
    AppMethodBeat.o(106205);
    return false;
  }
  
  public final void k(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106206);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.a.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106206);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106207);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.aj.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106207);
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106208);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.aa.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106208);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106209);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.d.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106209);
  }
  
  public final void o(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106210);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.h.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106210);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106196);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gyi, FloatBallServiceProxy.x.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106196);
  }
  
  public final void p(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106211);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.e.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106211);
  }
  
  public final void q(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106212);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.f.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106212);
  }
  
  public final void r(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106213);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.g.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106213);
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106215);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.ab.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106215);
  }
  
  public final void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(217294);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), FloatBallServiceProxy.ag.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217294);
  }
  
  public final void t(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217289);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, FloatBallServiceProxy.t.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217289);
  }
  
  public final void te(long paramLong)
  {
    AppMethodBeat.i(217287);
    ad.w("MicroMsg.FloatBallServiceProxy", "markEnterChattingUI not implemented in non-MM process");
    AppMethodBeat.o(217287);
  }
  
  public final boolean xS(int paramInt)
  {
    AppMethodBeat.i(184593);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), p.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(184593);
      return true;
    }
    AppMethodBeat.o(184593);
    return false;
  }
  
  public final void xT(int paramInt)
  {
    AppMethodBeat.i(184599);
    XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), FloatBallServiceProxy.af.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(184599);
  }
  
  public final void xU(int paramInt)
  {
    AppMethodBeat.i(217291);
    XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), FloatBallServiceProxy.ac.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(217291);
  }
  
  static final class FloatBallInfoEventReceiverParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<FloatBallInfoEventReceiverParcel> CREATOR;
    ResultReceiver coZ;
    BallInfo nGj;
    
    static
    {
      AppMethodBeat.i(106160);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106160);
    }
    
    protected FloatBallInfoEventReceiverParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106158);
      this.nGj = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
      this.coZ = ((ResultReceiver)paramParcel.readParcelable(ResultReceiver.class.getClassLoader()));
      AppMethodBeat.o(106158);
    }
    
    public FloatBallInfoEventReceiverParcel(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
    {
      this.nGj = paramBallInfo;
      this.coZ = paramResultReceiver;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106159);
      paramParcel.writeParcelable(this.nGj, paramInt);
      paramParcel.writeParcelable(this.coZ, paramInt);
      AppMethodBeat.o(106159);
    }
  }
  
  static class IPCKeyBoardChangedInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCKeyBoardChangedInfo> CREATOR;
    boolean gGI;
    long gW;
    int height;
    int nGL;
    
    static
    {
      AppMethodBeat.i(184587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(184587);
    }
    
    IPCKeyBoardChangedInfo(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
    {
      this.height = paramInt1;
      this.nGL = paramInt2;
      this.gGI = paramBoolean;
      this.gW = paramLong;
    }
    
    IPCKeyBoardChangedInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(184585);
      this.height = paramParcel.readInt();
      this.nGL = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.gGI = bool;
        this.gW = paramParcel.readLong();
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
      paramParcel.writeInt(this.nGL);
      if (this.gGI) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeLong(this.gW);
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
    BallInfo nGj;
    
    static
    {
      AppMethodBeat.i(106181);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106181);
    }
    
    public SetFloatBallAlphaParcel(float paramFloat, BallInfo paramBallInfo)
    {
      this.alpha = paramFloat;
      this.nGj = paramBallInfo;
    }
    
    protected SetFloatBallAlphaParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106179);
      this.alpha = paramParcel.readFloat();
      this.nGj = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
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
      paramParcel.writeParcelable(this.nGj, paramInt);
      AppMethodBeat.o(106180);
    }
  }
  
  static class UpdateBallVisibilityParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<UpdateBallVisibilityParcel> CREATOR;
    BallInfo nGj;
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
        this.nGj = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
        AppMethodBeat.o(106186);
        return;
      }
    }
    
    public UpdateBallVisibilityParcel(boolean paramBoolean, BallInfo paramBallInfo)
    {
      this.visible = paramBoolean;
      this.nGj = paramBallInfo;
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
        paramParcel.writeParcelable(this.nGj, paramInt);
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
  
  static final class b
    implements b<IPCLong, IPCInteger>
  {}
  
  static final class c
    implements k<BallInfo, IPCBoolean>
  {}
  
  static final class p
    implements k<IPCInteger, IPCBoolean>
  {}
  
  static final class q
    implements k<IPCVoid, IPCBoolean>
  {}
  
  static final class r
    implements k<IPCVoid, IPCBoolean>
  {}
  
  static final class s
    implements k<IPCVoid, IPCBoolean>
  {}
  
  static final class z
    implements b<FloatBallServiceProxy.FloatBallInfoEventReceiverParcel, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy
 * JD-Core Version:    0.7.0.1
 */