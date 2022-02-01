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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "markExitPage", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "Companion", "MarkExitPageTask", "MarkExitPageTaskData", "plugin-ball_release"})
public final class FloatBallReportServiceProxy
  implements com.tencent.mm.plugin.ball.c.b
{
  private static final f hhA;
  public static final a nLW;
  
  static
  {
    AppMethodBeat.i(209599);
    nLW = new a((byte)0);
    hhA = g.a(k.Nhd, (a)b.nLX);
    AppMethodBeat.o(209599);
  }
  
  public final void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209596);
    XIPCInvoker.a("com.tencent.mm", new MarkExitPageTaskData(paramInt, paramBoolean1, paramBoolean2), c.class, (d)d.nLY);
    AppMethodBeat.o(209596);
  }
  
  public final void iL(boolean paramBoolean)
  {
    AppMethodBeat.i(209598);
    c.a locala = c.nLS;
    c.a.bLJ().iL(paramBoolean);
    AppMethodBeat.o(209598);
  }
  
  public final void n(long paramLong, int paramInt)
  {
    AppMethodBeat.i(209597);
    c.a locala = c.nLS;
    c.a.bLJ().n(paramLong, paramInt);
    AppMethodBeat.o(209597);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "floatBallType", "", "hasFloatBall", "", "isSupportMessageBall", "(IZZ)V", "getFloatBallType", "()I", "setFloatBallType", "(I)V", "getHasFloatBall", "()Z", "setHasFloatBall", "(Z)V", "setSupportMessageBall", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-ball_release"})
  static final class MarkExitPageTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    int kmZ;
    boolean nLU;
    boolean nLV;
    
    static
    {
      AppMethodBeat.i(209594);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(209594);
    }
    
    public MarkExitPageTaskData(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.kmZ = paramInt;
      this.nLU = paramBoolean1;
      this.nLV = paramBoolean2;
    }
    
    public MarkExitPageTaskData(Parcel paramParcel)
    {
      this(0, false, false);
      AppMethodBeat.i(209593);
      this.kmZ = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.nLU = bool1;
        if (paramParcel.readByte() == 0) {
          break label67;
        }
      }
      label67:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.nLV = bool1;
        AppMethodBeat.o(209593);
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
      AppMethodBeat.i(209592);
      p.h(paramParcel, "parcel");
      paramParcel.writeInt(this.kmZ);
      if (this.nLU)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.nLV) {
          break label62;
        }
      }
      label62:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(209592);
        return;
        b1 = 0;
        break;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "plugin-ball_release"})
    public static final class a
      implements Parcelable.Creator<FloatBallReportServiceProxy.MarkExitPageTaskData>
    {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "invoke"})
  static final class b
    extends q
    implements a<FloatBallReportServiceProxy>
  {
    public static final b nLX;
    
    static
    {
      AppMethodBeat.i(209589);
      nLX = new b();
      AppMethodBeat.o(209589);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-ball_release"})
  static final class c
    implements com.tencent.mm.ipcinvoker.b<FloatBallReportServiceProxy.MarkExitPageTaskData, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements d<ResultType>
  {
    public static final d nLY;
    
    static
    {
      AppMethodBeat.i(209595);
      nLY = new d();
      AppMethodBeat.o(209595);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy
 * JD-Core Version:    0.7.0.1
 */