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
import com.tencent.mm.plugin.ball.c.i;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;

public final class FloatBallServiceProxy
  implements c
{
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(184594);
    XIPCInvoker.a("com.tencent.mm", new IPCKeyBoardChangedInfo(paramInt1, paramInt2, paramBoolean, paramLong), am.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(184594);
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(106220);
    ae.w("MicroMsg.FloatBallServiceProxy", "addFloatBallInfoEventListener not implemented in non-MM process");
    AppMethodBeat.o(106220);
  }
  
  public final void a(long paramLong, final c.a parama)
  {
    AppMethodBeat.i(209479);
    XIPCInvoker.a("com.tencent.mm", new IPCLong(paramLong), c.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(209479);
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(209481);
    XIPCInvoker.a("com.tencent.mm", paramResultReceiver, aj.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(209481);
  }
  
  public final void a(final i parami)
  {
    AppMethodBeat.i(106203);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, k.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106203);
  }
  
  public final void a(BallInfo paramBallInfo, float paramFloat)
  {
    AppMethodBeat.i(106218);
    XIPCInvoker.a("com.tencent.mm", new SetFloatBallAlphaParcel(paramFloat, paramBallInfo), ai.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106218);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106214);
    XIPCInvoker.a("com.tencent.mm", new FloatBallInfoEventReceiverParcel(paramBallInfo, com.tencent.mm.plugin.ball.f.d.b(paramResultReceiver)), aa.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106214);
  }
  
  public final void a(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106219);
    XIPCInvoker.a("com.tencent.mm", new UpdateBallVisibilityParcel(paramBoolean, paramBallInfo), al.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106219);
  }
  
  public final void b(int paramInt, f paramf)
  {
    AppMethodBeat.i(106221);
    ae.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallInfoEventListener not implemented in non-MM process");
    AppMethodBeat.o(106221);
  }
  
  public final void bKT()
  {
    AppMethodBeat.i(106195);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, x.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106195);
  }
  
  public final boolean bKU()
  {
    AppMethodBeat.i(106198);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, s.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106198);
      return true;
    }
    AppMethodBeat.o(106198);
    return false;
  }
  
  public final boolean bKV()
  {
    AppMethodBeat.i(106199);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, t.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106199);
      return true;
    }
    AppMethodBeat.o(106199);
    return false;
  }
  
  public final long bKW()
  {
    AppMethodBeat.i(209477);
    ae.w("MicroMsg.FloatBallServiceProxy", "getEnterChattingUITimestamp not implemented in non-MM process");
    AppMethodBeat.o(209477);
    return 0L;
  }
  
  public final void bKX()
  {
    AppMethodBeat.i(106200);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, j.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106200);
  }
  
  public final void bKY()
  {
    AppMethodBeat.i(106202);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, z.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106202);
  }
  
  public final List<BallInfo> bKZ()
  {
    return null;
  }
  
  public final void bLa() {}
  
  public final boolean bLb()
  {
    AppMethodBeat.i(209475);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, r.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(209475);
      return true;
    }
    AppMethodBeat.o(209475);
    return false;
  }
  
  public final void bLc()
  {
    AppMethodBeat.i(184596);
    ae.w("MicroMsg.FloatBallServiceProxy", "addFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184596);
  }
  
  public final void bLd()
  {
    AppMethodBeat.i(184597);
    ae.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184597);
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184598);
    ae.w("MicroMsg.FloatBallServiceProxy", "updateBallVisibilityByPosition not implemented in non-MM process");
    AppMethodBeat.o(184598);
    return false;
  }
  
  public final void dw(View paramView) {}
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106216);
    Point localPoint = (Point)XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, m.class);
    AppMethodBeat.o(106216);
    return localPoint;
  }
  
  public final BallInfo i(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106204);
    paramBallInfo = (BallInfo)XIPCInvoker.a("com.tencent.mm", paramBallInfo, l.class);
    AppMethodBeat.o(106204);
    return paramBallInfo;
  }
  
  public final void iM(boolean paramBoolean)
  {
    AppMethodBeat.i(106191);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), n.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106191);
  }
  
  public final void iN(boolean paramBoolean)
  {
    AppMethodBeat.i(106192);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), ae.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106192);
  }
  
  public final void iO(boolean paramBoolean)
  {
    AppMethodBeat.i(106193);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), o.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106193);
  }
  
  public final void iP(boolean paramBoolean)
  {
    AppMethodBeat.i(106194);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), af.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106194);
  }
  
  public final void iQ(boolean paramBoolean)
  {
    AppMethodBeat.i(209474);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), p.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(209474);
  }
  
  public final void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(176964);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), w.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(176964);
  }
  
  public final void iS(boolean paramBoolean)
  {
    AppMethodBeat.i(106197);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), v.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106197);
  }
  
  public final void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(184595);
    ae.w("MicroMsg.FloatBallServiceProxy", "markNeedProcessFloatViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184595);
  }
  
  public final void iU(boolean paramBoolean)
  {
    AppMethodBeat.i(209483);
    ae.w("MicroMsg.FloatBallServiceProxy", "markForceHideAllFloatBall not implemented in non-MM process");
    AppMethodBeat.o(209483);
  }
  
  public final boolean j(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106205);
    paramBallInfo = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", paramBallInfo, d.class);
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
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, a.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106206);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106207);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, ak.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106207);
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106208);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, ab.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106208);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106209);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, e.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106209);
  }
  
  public final void o(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106210);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, i.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106210);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106196);
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, y.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106196);
  }
  
  public final void p(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106211);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, f.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106211);
  }
  
  public final void q(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106212);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, g.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106212);
  }
  
  public final void r(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106213);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, h.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106213);
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209482);
    if (paramBallInfo == null)
    {
      AppMethodBeat.o(209482);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, b.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(209482);
  }
  
  public final void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(209484);
    XIPCInvoker.a("com.tencent.mm", new IPCBoolean(paramBoolean), ah.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(209484);
  }
  
  public final void t(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106215);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, ac.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(106215);
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(209476);
    ae.w("MicroMsg.FloatBallServiceProxy", "markEnterChattingUI not implemented in non-MM process");
    AppMethodBeat.o(209476);
  }
  
  public final void u(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209478);
    XIPCInvoker.a("com.tencent.mm", paramBallInfo, u.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(209478);
  }
  
  public final void v(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209485);
    ae.w("MicroMsg.FloatBallServiceProxy", "switchVoipVoice not implemented in non-MM process");
    AppMethodBeat.o(209485);
  }
  
  public final boolean xW(int paramInt)
  {
    AppMethodBeat.i(184593);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), q.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(184593);
      return true;
    }
    AppMethodBeat.o(184593);
    return false;
  }
  
  public final void xX(int paramInt)
  {
    AppMethodBeat.i(184599);
    XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), ag.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(184599);
  }
  
  public final void xY(int paramInt)
  {
    AppMethodBeat.i(209480);
    XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), ad.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(209480);
  }
  
  static class BallInfoListParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<BallInfoListParcel> CREATOR;
    List<BallInfo> nKv;
    
    static
    {
      AppMethodBeat.i(106149);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106149);
    }
    
    protected BallInfoListParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106147);
      this.nKv = paramParcel.createTypedArrayList(BallInfo.CREATOR);
      AppMethodBeat.o(106147);
    }
    
    public BallInfoListParcel(List<BallInfo> paramList)
    {
      this.nKv = paramList;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106148);
      paramParcel.writeTypedList(this.nKv);
      AppMethodBeat.o(106148);
    }
  }
  
  static final class FloatBallInfoEventReceiverParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<FloatBallInfoEventReceiverParcel> CREATOR;
    ResultReceiver cpd;
    BallInfo nLK;
    
    static
    {
      AppMethodBeat.i(106160);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106160);
    }
    
    protected FloatBallInfoEventReceiverParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106158);
      this.nLK = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
      this.cpd = ((ResultReceiver)paramParcel.readParcelable(ResultReceiver.class.getClassLoader()));
      AppMethodBeat.o(106158);
    }
    
    public FloatBallInfoEventReceiverParcel(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
    {
      this.nLK = paramBallInfo;
      this.cpd = paramResultReceiver;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106159);
      paramParcel.writeParcelable(this.nLK, paramInt);
      paramParcel.writeParcelable(this.cpd, paramInt);
      AppMethodBeat.o(106159);
    }
  }
  
  static class IPCKeyBoardChangedInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCKeyBoardChangedInfo> CREATOR;
    boolean gJr;
    long gW;
    int height;
    int nMn;
    
    static
    {
      AppMethodBeat.i(184587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(184587);
    }
    
    IPCKeyBoardChangedInfo(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
    {
      this.height = paramInt1;
      this.nMn = paramInt2;
      this.gJr = paramBoolean;
      this.gW = paramLong;
    }
    
    IPCKeyBoardChangedInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(184585);
      this.height = paramParcel.readInt();
      this.nMn = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.gJr = bool;
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
      paramParcel.writeInt(this.nMn);
      if (this.gJr) {}
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
    BallInfo nLK;
    
    static
    {
      AppMethodBeat.i(106181);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106181);
    }
    
    public SetFloatBallAlphaParcel(float paramFloat, BallInfo paramBallInfo)
    {
      this.alpha = paramFloat;
      this.nLK = paramBallInfo;
    }
    
    protected SetFloatBallAlphaParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106179);
      this.alpha = paramParcel.readFloat();
      this.nLK = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
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
      paramParcel.writeParcelable(this.nLK, paramInt);
      AppMethodBeat.o(106180);
    }
  }
  
  static class UpdateBallVisibilityParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<UpdateBallVisibilityParcel> CREATOR;
    BallInfo nLK;
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
        this.nLK = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
        AppMethodBeat.o(106186);
        return;
      }
    }
    
    public UpdateBallVisibilityParcel(boolean paramBoolean, BallInfo paramBallInfo)
    {
      this.visible = paramBoolean;
      this.nLK = paramBallInfo;
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
        paramParcel.writeParcelable(this.nLK, paramInt);
        AppMethodBeat.o(106187);
        return;
      }
    }
  }
  
  static final class a
    implements b<BallInfo, IPCVoid>
  {}
  
  static final class aa
    implements b<FloatBallServiceProxy.FloatBallInfoEventReceiverParcel, IPCVoid>
  {}
  
  static final class ab
    implements b<BallInfo, IPCVoid>
  {}
  
  static final class ac
    implements b<BallInfo, IPCVoid>
  {}
  
  static final class ad
    implements b<IPCInteger, IPCVoid>
  {}
  
  static final class ae
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static final class af
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static final class ag
    implements b<IPCInteger, IPCVoid>
  {}
  
  static final class ah
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static final class ai
    implements b<FloatBallServiceProxy.SetFloatBallAlphaParcel, IPCVoid>
  {}
  
  static final class aj
    implements b<ResultReceiver, IPCVoid>
  {}
  
  static final class ak
    implements b<BallInfo, IPCVoid>
  {}
  
  static final class al
    implements b<FloatBallServiceProxy.UpdateBallVisibilityParcel, IPCVoid>
  {}
  
  static final class am
    implements b<FloatBallServiceProxy.IPCKeyBoardChangedInfo, IPCVoid>
  {}
  
  static final class b
    implements b<BallInfo, IPCVoid>
  {}
  
  static final class c
    implements b<IPCLong, IPCInteger>
  {}
  
  static final class d
    implements k<BallInfo, IPCBoolean>
  {}
  
  static final class e
    implements b<BallInfo, IPCVoid>
  {}
  
  static final class f
    implements b<BallInfo, IPCVoid>
  {}
  
  static final class g
    implements b<BallInfo, IPCVoid>
  {}
  
  static final class h
    implements b<BallInfo, IPCVoid>
  {}
  
  static final class i
    implements b<BallInfo, IPCVoid>
  {}
  
  static final class j
    implements b<IPCVoid, IPCVoid>
  {}
  
  static final class k
    implements b<IPCVoid, FloatBallServiceProxy.BallInfoListParcel>
  {}
  
  static final class l
    implements k<BallInfo, BallInfo>
  {}
  
  static final class m
    implements k<IPCVoid, Point>
  {}
  
  static final class n
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static final class o
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static final class p
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static final class q
    implements k<IPCInteger, IPCBoolean>
  {}
  
  static final class r
    implements k<IPCVoid, IPCBoolean>
  {}
  
  static final class s
    implements k<IPCVoid, IPCBoolean>
  {}
  
  static final class t
    implements k<IPCVoid, IPCBoolean>
  {}
  
  static final class u
    implements b<BallInfo, IPCVoid>
  {}
  
  static final class v
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static final class w
    implements b<IPCBoolean, IPCVoid>
  {}
  
  static final class x
    implements b<IPCVoid, IPCVoid>
  {}
  
  static final class y
    implements b<IPCVoid, IPCVoid>
  {}
  
  static final class z
    implements b<IPCVoid, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy
 * JD-Core Version:    0.7.0.1
 */