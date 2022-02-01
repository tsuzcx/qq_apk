package com.tencent.mm.plugin.ball.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "markExitPage", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", "timestamp", "", "addMessageBallResult", "Companion", "MarkExitPageTask", "MarkExitPageTaskData", "plugin-ball_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FloatBallReportServiceProxy
  implements com.tencent.mm.plugin.ball.c.a
{
  private static final j<FloatBallReportServiceProxy> nqI;
  public static final a vki;
  
  static
  {
    AppMethodBeat.i(288367);
    vki = new a((byte)0);
    nqI = k.a(o.aiuF, (kotlin.g.a.a)b.vkj);
    AppMethodBeat.o(288367);
  }
  
  private static final void g(IPCVoid paramIPCVoid) {}
  
  public final void f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(288372);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new MarkExitPageTaskData(paramInt, paramBoolean1, paramBoolean2), c.class, FloatBallReportServiceProxy..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(288372);
  }
  
  public final void mh(boolean paramBoolean)
  {
    AppMethodBeat.i(288376);
    b.a locala = b.vkc;
    b.a.cYB().mh(paramBoolean);
    AppMethodBeat.o(288376);
  }
  
  public final void x(long paramLong, int paramInt)
  {
    AppMethodBeat.i(288373);
    b.a locala = b.vkc;
    b.a.cYB().x(paramLong, paramInt);
    AppMethodBeat.o(288373);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "floatBallType", "", "hasFloatBall", "", "isSupportMessageBall", "(IZZ)V", "getFloatBallType", "()I", "setFloatBallType", "(I)V", "getHasFloatBall", "()Z", "setHasFloatBall", "(Z)V", "setSupportMessageBall", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-ball_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class MarkExitPageTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    int rpa;
    boolean vkg;
    boolean vkh;
    
    static
    {
      AppMethodBeat.i(288439);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(288439);
    }
    
    public MarkExitPageTaskData(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.rpa = paramInt;
      this.vkg = paramBoolean1;
      this.vkh = paramBoolean2;
    }
    
    public MarkExitPageTaskData(Parcel paramParcel)
    {
      this(0, false, false);
      AppMethodBeat.i(288438);
      this.rpa = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.vkg = bool1;
        if (paramParcel.readByte() == 0) {
          break label67;
        }
      }
      label67:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.vkh = bool1;
        AppMethodBeat.o(288438);
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
      AppMethodBeat.i(288440);
      s.u(paramParcel, "parcel");
      paramParcel.writeInt(this.rpa);
      if (this.vkg)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.vkh) {
          break label62;
        }
      }
      label62:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(288440);
        return;
        b1 = 0;
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "plugin-ball_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<FloatBallReportServiceProxy.MarkExitPageTaskData>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<FloatBallReportServiceProxy>
  {
    public static final b vkj;
    
    static
    {
      AppMethodBeat.i(288350);
      vkj = new b();
      AppMethodBeat.o(288350);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-ball_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    implements d<FloatBallReportServiceProxy.MarkExitPageTaskData, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy
 * JD-Core Version:    0.7.0.1
 */