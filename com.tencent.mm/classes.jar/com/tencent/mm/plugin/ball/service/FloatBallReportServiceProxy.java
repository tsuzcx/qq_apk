package com.tencent.mm.plugin.ball.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "markExitPage", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "Companion", "MarkExitPageTask", "MarkExitPageTaskData", "plugin-ball_release"})
public final class FloatBallReportServiceProxy
  implements com.tencent.mm.plugin.ball.c.b
{
  private static final f gkk;
  public static final a mDS;
  
  static
  {
    AppMethodBeat.i(190706);
    mDS = new a((byte)0);
    gkk = g.a(d.k.JfI, (a)b.mDT);
    AppMethodBeat.o(190706);
  }
  
  public final void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(190703);
    XIPCInvoker.a("com.tencent.mm", new MarkExitPageTaskData(paramInt, paramBoolean1, paramBoolean2), c.class, (d)d.mDU);
    AppMethodBeat.o(190703);
  }
  
  public final void id(boolean paramBoolean)
  {
    AppMethodBeat.i(190705);
    c.a locala = c.mDO;
    c.a.bzF().id(paramBoolean);
    AppMethodBeat.o(190705);
  }
  
  public final void m(long paramLong, int paramInt)
  {
    AppMethodBeat.i(190704);
    c.a locala = c.mDO;
    c.a.bzF().m(paramLong, paramInt);
    AppMethodBeat.o(190704);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "floatBallType", "", "hasFloatBall", "", "isSupportMessageBall", "(IZZ)V", "getFloatBallType", "()I", "setFloatBallType", "(I)V", "getHasFloatBall", "()Z", "setHasFloatBall", "(Z)V", "setSupportMessageBall", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-ball_release"})
  static final class MarkExitPageTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    int jpm;
    boolean mDQ;
    boolean mDR;
    
    static
    {
      AppMethodBeat.i(190701);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(190701);
    }
    
    public MarkExitPageTaskData(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.jpm = paramInt;
      this.mDQ = paramBoolean1;
      this.mDR = paramBoolean2;
    }
    
    public MarkExitPageTaskData(Parcel paramParcel)
    {
      this(0, false, false);
      AppMethodBeat.i(190700);
      this.jpm = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.mDQ = bool1;
        if (paramParcel.readByte() == 0) {
          break label67;
        }
      }
      label67:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.mDR = bool1;
        AppMethodBeat.o(190700);
        return;
        bool1 = false;
        break;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(190699);
      d.g.b.k.h(paramParcel, "parcel");
      paramParcel.writeInt(this.jpm);
      if (this.mDQ)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.mDR) {
          break label62;
        }
      }
      label62:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(190699);
        return;
        b1 = 0;
        break;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "plugin-ball_release"})
    public static final class a
      implements Parcelable.Creator<FloatBallReportServiceProxy.MarkExitPageTaskData>
    {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(190695);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(a.class), "instance", "getInstance()Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;")) };
      AppMethodBeat.o(190695);
    }
    
    public static FloatBallReportServiceProxy bzG()
    {
      AppMethodBeat.i(190696);
      Object localObject = FloatBallReportServiceProxy.ahu();
      a locala = FloatBallReportServiceProxy.mDS;
      localObject = (FloatBallReportServiceProxy)((f)localObject).getValue();
      AppMethodBeat.o(190696);
      return localObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<FloatBallReportServiceProxy>
  {
    public static final b mDT;
    
    static
    {
      AppMethodBeat.i(190694);
      mDT = new b();
      AppMethodBeat.o(190694);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-ball_release"})
  static final class c
    implements com.tencent.mm.ipcinvoker.b<FloatBallReportServiceProxy.MarkExitPageTaskData, IPCVoid>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements d<ResultType>
  {
    public static final d mDU;
    
    static
    {
      AppMethodBeat.i(190702);
      mDU = new d();
      AppMethodBeat.o(190702);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy
 * JD-Core Version:    0.7.0.1
 */