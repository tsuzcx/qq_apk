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
import com.tencent.mm.ipcinvoker.m;
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
  public final void FE(int paramInt)
  {
    AppMethodBeat.i(184599);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCInteger(paramInt), ah.class, new f() {});
    AppMethodBeat.o(184599);
  }
  
  public final void FF(int paramInt)
  {
    AppMethodBeat.i(288506);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCInteger(paramInt), ae.class, new f() {});
    AppMethodBeat.o(288506);
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(184594);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCKeyBoardChangedInfo(paramInt1, paramInt2, paramBoolean, paramLong), am.class, new f() {});
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
    AppMethodBeat.i(288502);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCLong(paramLong), c.class, new f() {});
    AppMethodBeat.o(288502);
  }
  
  public final void a(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(288549);
    Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallInfoChangedListener not implemented in non-MM process");
    AppMethodBeat.o(288549);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(288559);
    Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallViewListener not implemented in non-MM process");
    AppMethodBeat.o(288559);
  }
  
  public final void a(final i parami)
  {
    AppMethodBeat.i(106203);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, l.class, new f() {});
    AppMethodBeat.o(106203);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106214);
    paramResultReceiver = com.tencent.mm.plugin.ball.f.d.c(paramResultReceiver);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new FloatBallInfoEventReceiverParcel(paramBallInfo, paramResultReceiver), ab.class, new f() {});
    AppMethodBeat.o(106214);
  }
  
  public final void a(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106219);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new UpdateBallVisibilityParcel(paramBoolean, paramBallInfo), al.class, new f() {});
    AppMethodBeat.o(106219);
  }
  
  public final void aZq()
  {
    AppMethodBeat.i(106195);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, y.class, new f() {});
    AppMethodBeat.o(106195);
  }
  
  public final void b(int paramInt, e parame)
  {
    AppMethodBeat.i(106221);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallInfoEventListener not implemented in non-MM process");
    AppMethodBeat.o(106221);
  }
  
  public final void b(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(288527);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramResultReceiver, aj.class, new f() {});
    AppMethodBeat.o(288527);
  }
  
  public final void b(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(288554);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallInfoChangedListener not implemented in non-MM process");
    AppMethodBeat.o(288554);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(288565);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallViewListener not implemented in non-MM process");
    AppMethodBeat.o(288565);
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184598);
    Log.w("MicroMsg.FloatBallServiceProxy", "updateBallVisibilityByPosition not implemented in non-MM process");
    AppMethodBeat.o(184598);
    return false;
  }
  
  public final boolean cXG()
  {
    AppMethodBeat.i(106198);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, s.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106198);
      return true;
    }
    AppMethodBeat.o(106198);
    return false;
  }
  
  public final boolean cXH()
  {
    AppMethodBeat.i(288422);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, x.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(288422);
      return true;
    }
    AppMethodBeat.o(288422);
    return false;
  }
  
  public final boolean cXI()
  {
    AppMethodBeat.i(106199);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, t.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(106199);
      return true;
    }
    AppMethodBeat.o(106199);
    return false;
  }
  
  public final long cXJ()
  {
    AppMethodBeat.i(288433);
    Log.w("MicroMsg.FloatBallServiceProxy", "getEnterChattingUITimestamp not implemented in non-MM process");
    AppMethodBeat.o(288433);
    return 0L;
  }
  
  public final void cXK()
  {
    AppMethodBeat.i(106200);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, k.class, new f() {});
    AppMethodBeat.o(106200);
  }
  
  public final void cXL()
  {
    AppMethodBeat.i(106202);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, aa.class, new f() {});
    AppMethodBeat.o(106202);
  }
  
  public final List<BallInfo> cXM()
  {
    return null;
  }
  
  public final List<BallInfo> cXN()
  {
    return null;
  }
  
  public final Set<g> cXO()
  {
    AppMethodBeat.i(288575);
    Log.w("MicroMsg.FloatBallServiceProxy", "getFloatBallViewListeners not implemented in non-MM process");
    AppMethodBeat.o(288575);
    return null;
  }
  
  public final boolean cXP()
  {
    AppMethodBeat.i(288580);
    Log.w("MicroMsg.FloatBallServiceProxy", "isFloatBallViewDockLeft not implemented in non-MM process");
    AppMethodBeat.o(288580);
    return false;
  }
  
  public final void cXQ() {}
  
  public final boolean cXR()
  {
    AppMethodBeat.i(288419);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, r.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(288419);
      return true;
    }
    AppMethodBeat.o(288419);
    return false;
  }
  
  public final void cXS()
  {
    AppMethodBeat.i(184596);
    Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184596);
  }
  
  public final void cXT()
  {
    AppMethodBeat.i(184597);
    Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184597);
  }
  
  public final void cXU()
  {
    AppMethodBeat.i(288495);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, e.class, new f() {});
    AppMethodBeat.o(288495);
  }
  
  public final void ex(View paramView) {}
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106216);
    Point localPoint = (Point)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, n.class);
    AppMethodBeat.o(106216);
    return localPoint;
  }
  
  public final BallInfo h(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106204);
    try
    {
      paramBallInfo = (BallInfo)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, m.class);
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
      paramBallInfo = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, d.class);
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
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, a.class, new f() {});
    AppMethodBeat.o(106206);
  }
  
  public final void k(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106207);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, ak.class, new f() {});
    AppMethodBeat.o(106207);
  }
  
  public final void kc(long paramLong)
  {
    AppMethodBeat.i(288429);
    Log.w("MicroMsg.FloatBallServiceProxy", "markEnterChattingUI not implemented in non-MM process");
    AppMethodBeat.o(288429);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106208);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, ac.class, new f() {});
    AppMethodBeat.o(106208);
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106209);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, f.class, new f() {});
    AppMethodBeat.o(106209);
  }
  
  public final void mi(boolean paramBoolean)
  {
    AppMethodBeat.i(106191);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), o.class, new f() {});
    AppMethodBeat.o(106191);
  }
  
  public final void mj(boolean paramBoolean)
  {
    AppMethodBeat.i(106192);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), af.class, new f() {});
    AppMethodBeat.o(106192);
  }
  
  public final void mk(boolean paramBoolean)
  {
    AppMethodBeat.i(106193);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), p.class, new f() {});
    AppMethodBeat.o(106193);
  }
  
  public final void ml(boolean paramBoolean)
  {
    AppMethodBeat.i(106194);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), ag.class, new f() {});
    AppMethodBeat.o(106194);
  }
  
  public final void mm(boolean paramBoolean)
  {
    AppMethodBeat.i(288409);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), q.class, new f() {});
    AppMethodBeat.o(288409);
  }
  
  public final void mn(boolean paramBoolean)
  {
    AppMethodBeat.i(176964);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), w.class, new f() {});
    AppMethodBeat.o(176964);
  }
  
  public final void mo(boolean paramBoolean)
  {
    AppMethodBeat.i(106197);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), v.class, new f() {});
    AppMethodBeat.o(106197);
  }
  
  public final void mp(boolean paramBoolean)
  {
    AppMethodBeat.i(184595);
    Log.w("MicroMsg.FloatBallServiceProxy", "markNeedProcessFloatViewLayoutParamsFlag not implemented in non-MM process");
    AppMethodBeat.o(184595);
  }
  
  public final void mq(boolean paramBoolean)
  {
    AppMethodBeat.i(288596);
    Log.w("MicroMsg.FloatBallServiceProxy", "markForceHideAllFloatBall not implemented in non-MM process");
    AppMethodBeat.o(288596);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106210);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, j.class, new f() {});
    AppMethodBeat.o(106210);
  }
  
  public final void o(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106211);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, g.class, new f() {});
    AppMethodBeat.o(106211);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106196);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, z.class, new f() {});
    AppMethodBeat.o(106196);
  }
  
  public final void p(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106212);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, h.class, new f() {});
    AppMethodBeat.o(106212);
  }
  
  public final void q(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106213);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, i.class, new f() {});
    AppMethodBeat.o(106213);
  }
  
  public final void r(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288532);
    if (paramBallInfo == null)
    {
      AppMethodBeat.o(288532);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, b.class, new f() {});
    AppMethodBeat.o(288532);
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106215);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, ad.class, new f() {});
    AppMethodBeat.o(106215);
  }
  
  public final void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(288607);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCBoolean(paramBoolean), ai.class, new f() {});
    AppMethodBeat.o(288607);
  }
  
  public final void t(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288485);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBallInfo, u.class, new f() {});
    AppMethodBeat.o(288485);
  }
  
  public final void u(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288623);
    Log.w("MicroMsg.FloatBallServiceProxy", "switchVoipVoice not implemented in non-MM process");
    AppMethodBeat.o(288623);
  }
  
  static class BallInfoListParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<BallInfoListParcel> CREATOR;
    List<BallInfo> viG;
    
    static
    {
      AppMethodBeat.i(106149);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106149);
    }
    
    protected BallInfoListParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106147);
      this.viG = paramParcel.createTypedArrayList(BallInfo.CREATOR);
      AppMethodBeat.o(106147);
    }
    
    public BallInfoListParcel(List<BallInfo> paramList)
    {
      this.viG = paramList;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106148);
      paramParcel.writeTypedList(this.viG);
      AppMethodBeat.o(106148);
    }
  }
  
  static final class FloatBallInfoEventReceiverParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<FloatBallInfoEventReceiverParcel> CREATOR;
    ResultReceiver ett;
    BallInfo vjV;
    
    static
    {
      AppMethodBeat.i(106160);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106160);
    }
    
    protected FloatBallInfoEventReceiverParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(106158);
      this.vjV = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
      this.ett = ((ResultReceiver)paramParcel.readParcelable(ResultReceiver.class.getClassLoader()));
      AppMethodBeat.o(106158);
    }
    
    public FloatBallInfoEventReceiverParcel(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
    {
      this.vjV = paramBallInfo;
      this.ett = paramResultReceiver;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106159);
      paramParcel.writeParcelable(this.vjV, paramInt);
      paramParcel.writeParcelable(this.ett, paramInt);
      AppMethodBeat.o(106159);
    }
  }
  
  static class IPCKeyBoardChangedInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCKeyBoardChangedInfo> CREATOR;
    long delay;
    int height;
    boolean mJk;
    int vkz;
    
    static
    {
      AppMethodBeat.i(184587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(184587);
    }
    
    IPCKeyBoardChangedInfo(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
    {
      this.height = paramInt1;
      this.vkz = paramInt2;
      this.mJk = paramBoolean;
      this.delay = paramLong;
    }
    
    IPCKeyBoardChangedInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(184585);
      this.height = paramParcel.readInt();
      this.vkz = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.mJk = bool;
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
      paramParcel.writeInt(this.vkz);
      if (this.mJk) {}
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
    boolean visible;
    BallInfo vjV;
    
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
        this.vjV = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
        AppMethodBeat.o(106186);
        return;
      }
    }
    
    public UpdateBallVisibilityParcel(boolean paramBoolean, BallInfo paramBallInfo)
    {
      this.visible = paramBoolean;
      this.vjV = paramBallInfo;
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
        paramParcel.writeParcelable(this.vjV, paramInt);
        AppMethodBeat.o(106187);
        return;
      }
    }
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class aa
    implements com.tencent.mm.ipcinvoker.d<IPCVoid, IPCVoid>
  {}
  
  static final class ab
    implements com.tencent.mm.ipcinvoker.d<FloatBallServiceProxy.FloatBallInfoEventReceiverParcel, IPCVoid>
  {}
  
  static final class ac
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class ad
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class ae
    implements com.tencent.mm.ipcinvoker.d<IPCInteger, IPCVoid>
  {}
  
  static final class af
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean, IPCVoid>
  {}
  
  static final class ag
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean, IPCVoid>
  {}
  
  static final class ah
    implements com.tencent.mm.ipcinvoker.d<IPCInteger, IPCVoid>
  {}
  
  static final class ai
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean, IPCVoid>
  {}
  
  static final class aj
    implements com.tencent.mm.ipcinvoker.d<ResultReceiver, IPCVoid>
  {}
  
  static final class ak
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class al
    implements com.tencent.mm.ipcinvoker.d<FloatBallServiceProxy.UpdateBallVisibilityParcel, IPCVoid>
  {}
  
  static final class am
    implements com.tencent.mm.ipcinvoker.d<FloatBallServiceProxy.IPCKeyBoardChangedInfo, IPCVoid>
  {}
  
  static final class b
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class c
    implements com.tencent.mm.ipcinvoker.d<IPCLong, IPCInteger>
  {}
  
  static final class d
    implements m<BallInfo, IPCBoolean>
  {}
  
  static final class e
    implements com.tencent.mm.ipcinvoker.d<IPCVoid, IPCVoid>
  {}
  
  static final class f
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class g
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class h
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class i
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class j
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class k
    implements com.tencent.mm.ipcinvoker.d<IPCVoid, IPCVoid>
  {}
  
  static final class l
    implements com.tencent.mm.ipcinvoker.d<IPCVoid, FloatBallServiceProxy.BallInfoListParcel>
  {}
  
  static final class m
    implements m<BallInfo, BallInfo>
  {}
  
  static final class n
    implements m<IPCVoid, Point>
  {}
  
  static final class o
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean, IPCVoid>
  {}
  
  static final class p
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean, IPCVoid>
  {}
  
  static final class q
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean, IPCVoid>
  {}
  
  static final class r
    implements m<IPCVoid, IPCBoolean>
  {}
  
  static final class s
    implements m<IPCVoid, IPCBoolean>
  {}
  
  static final class t
    implements m<IPCVoid, IPCBoolean>
  {}
  
  static final class u
    implements com.tencent.mm.ipcinvoker.d<BallInfo, IPCVoid>
  {}
  
  static final class v
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean, IPCVoid>
  {}
  
  static final class w
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean, IPCVoid>
  {}
  
  static final class x
    implements m<IPCVoid, IPCBoolean>
  {}
  
  static final class y
    implements com.tencent.mm.ipcinvoker.d<IPCVoid, IPCVoid>
  {}
  
  static final class z
    implements com.tencent.mm.ipcinvoker.d<IPCVoid, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy
 * JD-Core Version:    0.7.0.1
 */