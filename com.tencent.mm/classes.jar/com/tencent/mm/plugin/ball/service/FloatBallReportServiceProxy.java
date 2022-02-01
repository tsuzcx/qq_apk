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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "markExitPage", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "Companion", "MarkExitPageTask", "MarkExitPageTaskData", "plugin-ball_release"})
public final class FloatBallReportServiceProxy
  implements com.tencent.mm.plugin.ball.c.b
{
  private static final f gKX;
  public static final a nfY;
  
  static
  {
    AppMethodBeat.i(208108);
    nfY = new a((byte)0);
    gKX = g.a(d.k.KTc, (a)b.nfZ);
    AppMethodBeat.o(208108);
  }
  
  public final void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208105);
    XIPCInvoker.a("com.tencent.mm", new MarkExitPageTaskData(paramInt, paramBoolean1, paramBoolean2), c.class, (d)d.nga);
    AppMethodBeat.o(208105);
  }
  
  public final void iD(boolean paramBoolean)
  {
    AppMethodBeat.i(208107);
    c.a locala = c.nfU;
    c.a.bGB().iD(paramBoolean);
    AppMethodBeat.o(208107);
  }
  
  public final void n(long paramLong, int paramInt)
  {
    AppMethodBeat.i(208106);
    c.a locala = c.nfU;
    c.a.bGB().n(paramLong, paramInt);
    AppMethodBeat.o(208106);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "floatBallType", "", "hasFloatBall", "", "isSupportMessageBall", "(IZZ)V", "getFloatBallType", "()I", "setFloatBallType", "(I)V", "getHasFloatBall", "()Z", "setHasFloatBall", "(Z)V", "setSupportMessageBall", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-ball_release"})
  static final class MarkExitPageTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    int jPz;
    boolean nfW;
    boolean nfX;
    
    static
    {
      AppMethodBeat.i(208103);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(208103);
    }
    
    public MarkExitPageTaskData(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.jPz = paramInt;
      this.nfW = paramBoolean1;
      this.nfX = paramBoolean2;
    }
    
    public MarkExitPageTaskData(Parcel paramParcel)
    {
      this(0, false, false);
      AppMethodBeat.i(208102);
      this.jPz = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.nfW = bool1;
        if (paramParcel.readByte() == 0) {
          break label67;
        }
      }
      label67:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.nfX = bool1;
        AppMethodBeat.o(208102);
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
      AppMethodBeat.i(208101);
      d.g.b.k.h(paramParcel, "parcel");
      paramParcel.writeInt(this.jPz);
      if (this.nfW)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.nfX) {
          break label62;
        }
      }
      label62:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(208101);
        return;
        b1 = 0;
        break;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "plugin-ball_release"})
    public static final class a
      implements Parcelable.Creator<FloatBallReportServiceProxy.MarkExitPageTaskData>
    {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(208097);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(a.class), "instance", "getInstance()Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;")) };
      AppMethodBeat.o(208097);
    }
    
    public static FloatBallReportServiceProxy bGC()
    {
      AppMethodBeat.i(208098);
      Object localObject = FloatBallReportServiceProxy.aow();
      a locala = FloatBallReportServiceProxy.nfY;
      localObject = (FloatBallReportServiceProxy)((f)localObject).getValue();
      AppMethodBeat.o(208098);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<FloatBallReportServiceProxy>
  {
    public static final b nfZ;
    
    static
    {
      AppMethodBeat.i(208096);
      nfZ = new b();
      AppMethodBeat.o(208096);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-ball_release"})
  static final class c
    implements com.tencent.mm.ipcinvoker.b<FloatBallReportServiceProxy.MarkExitPageTaskData, IPCVoid>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements d<ResultType>
  {
    public static final d nga;
    
    static
    {
      AppMethodBeat.i(208104);
      nga = new d();
      AppMethodBeat.o(208104);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy
 * JD-Core Version:    0.7.0.1
 */