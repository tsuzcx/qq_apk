package com.tencent.mm.plugin.ball.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "markExitPage", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "Companion", "MarkExitPageTask", "MarkExitPageTaskData", "plugin-ball_release"})
public final class FloatBallReportServiceProxy
  implements com.tencent.mm.plugin.ball.c.a
{
  private static final f iax;
  public static final a oWQ;
  
  static
  {
    AppMethodBeat.i(217171);
    oWQ = new a((byte)0);
    iax = g.a(k.SWP, (kotlin.g.a.a)b.oWR);
    AppMethodBeat.o(217171);
  }
  
  public final void d(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(217168);
    XIPCInvoker.a(MainProcessIPCService.dkO, new MarkExitPageTaskData(paramInt, paramBoolean1, paramBoolean2), c.class, (d)d.oWS);
    AppMethodBeat.o(217168);
  }
  
  public final void jK(boolean paramBoolean)
  {
    AppMethodBeat.i(217170);
    c.a locala = c.oWM;
    c.a.ciA().jK(paramBoolean);
    AppMethodBeat.o(217170);
  }
  
  public final void l(long paramLong, int paramInt)
  {
    AppMethodBeat.i(217169);
    c.a locala = c.oWM;
    c.a.ciA().l(paramLong, paramInt);
    AppMethodBeat.o(217169);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "floatBallType", "", "hasFloatBall", "", "isSupportMessageBall", "(IZZ)V", "getFloatBallType", "()I", "setFloatBallType", "(I)V", "getHasFloatBall", "()Z", "setHasFloatBall", "(Z)V", "setSupportMessageBall", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-ball_release"})
  static final class MarkExitPageTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    int lqH;
    boolean oWO;
    boolean oWP;
    
    static
    {
      AppMethodBeat.i(217166);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(217166);
    }
    
    public MarkExitPageTaskData(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.lqH = paramInt;
      this.oWO = paramBoolean1;
      this.oWP = paramBoolean2;
    }
    
    public MarkExitPageTaskData(Parcel paramParcel)
    {
      this(0, false, false);
      AppMethodBeat.i(217165);
      this.lqH = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.oWO = bool1;
        if (paramParcel.readByte() == 0) {
          break label67;
        }
      }
      label67:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.oWP = bool1;
        AppMethodBeat.o(217165);
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
      AppMethodBeat.i(217164);
      p.h(paramParcel, "parcel");
      paramParcel.writeInt(this.lqH);
      if (this.oWO)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.oWP) {
          break label62;
        }
      }
      label62:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(217164);
        return;
        b1 = 0;
        break;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "plugin-ball_release"})
    public static final class a
      implements Parcelable.Creator<FloatBallReportServiceProxy.MarkExitPageTaskData>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<FloatBallReportServiceProxy>
  {
    public static final b oWR;
    
    static
    {
      AppMethodBeat.i(217161);
      oWR = new b();
      AppMethodBeat.o(217161);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-ball_release"})
  static final class c
    implements b<FloatBallReportServiceProxy.MarkExitPageTaskData, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements d<ResultType>
  {
    public static final d oWS;
    
    static
    {
      AppMethodBeat.i(217167);
      oWS = new d();
      AppMethodBeat.o(217167);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy
 * JD-Core Version:    0.7.0.1
 */