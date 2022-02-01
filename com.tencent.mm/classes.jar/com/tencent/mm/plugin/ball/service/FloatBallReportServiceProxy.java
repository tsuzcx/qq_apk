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
import d.g.b.p;
import d.g.b.q;
import d.k;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "markExitPage", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "Companion", "MarkExitPageTask", "MarkExitPageTaskData", "plugin-ball_release"})
public final class FloatBallReportServiceProxy
  implements com.tencent.mm.plugin.ball.c.b
{
  private static final f heM;
  public static final a nGu;
  
  static
  {
    AppMethodBeat.i(217402);
    nGu = new a((byte)0);
    heM = g.a(k.MKa, (a)b.nGv);
    AppMethodBeat.o(217402);
  }
  
  public final void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(217399);
    XIPCInvoker.a("com.tencent.mm", new MarkExitPageTaskData(paramInt, paramBoolean1, paramBoolean2), c.class, (d)d.nGw);
    AppMethodBeat.o(217399);
  }
  
  public final void iM(boolean paramBoolean)
  {
    AppMethodBeat.i(217401);
    c.a locala = c.nGq;
    c.a.bKM().iM(paramBoolean);
    AppMethodBeat.o(217401);
  }
  
  public final void n(long paramLong, int paramInt)
  {
    AppMethodBeat.i(217400);
    c.a locala = c.nGq;
    c.a.bKM().n(paramLong, paramInt);
    AppMethodBeat.o(217400);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "floatBallType", "", "hasFloatBall", "", "isSupportMessageBall", "(IZZ)V", "getFloatBallType", "()I", "setFloatBallType", "(I)V", "getHasFloatBall", "()Z", "setHasFloatBall", "(Z)V", "setSupportMessageBall", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-ball_release"})
  static final class MarkExitPageTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    int kjJ;
    boolean nGs;
    boolean nGt;
    
    static
    {
      AppMethodBeat.i(217397);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(217397);
    }
    
    public MarkExitPageTaskData(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.kjJ = paramInt;
      this.nGs = paramBoolean1;
      this.nGt = paramBoolean2;
    }
    
    public MarkExitPageTaskData(Parcel paramParcel)
    {
      this(0, false, false);
      AppMethodBeat.i(217396);
      this.kjJ = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.nGs = bool1;
        if (paramParcel.readByte() == 0) {
          break label67;
        }
      }
      label67:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.nGt = bool1;
        AppMethodBeat.o(217396);
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
      AppMethodBeat.i(217395);
      p.h(paramParcel, "parcel");
      paramParcel.writeInt(this.kjJ);
      if (this.nGs)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.nGt) {
          break label62;
        }
      }
      label62:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(217395);
        return;
        b1 = 0;
        break;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "plugin-ball_release"})
    public static final class a
      implements Parcelable.Creator<FloatBallReportServiceProxy.MarkExitPageTaskData>
    {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "invoke"})
  static final class b
    extends q
    implements a<FloatBallReportServiceProxy>
  {
    public static final b nGv;
    
    static
    {
      AppMethodBeat.i(217392);
      nGv = new b();
      AppMethodBeat.o(217392);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-ball_release"})
  static final class c
    implements com.tencent.mm.ipcinvoker.b<FloatBallReportServiceProxy.MarkExitPageTaskData, IPCVoid>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements d<ResultType>
  {
    public static final d nGw;
    
    static
    {
      AppMethodBeat.i(217398);
      nGw = new d();
      AppMethodBeat.o(217398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy
 * JD-Core Version:    0.7.0.1
 */