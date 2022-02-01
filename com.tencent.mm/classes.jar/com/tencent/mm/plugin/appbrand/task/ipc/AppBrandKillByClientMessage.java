package com.tencent.mm.plugin.appbrand.task.ipc;

import android.app.Activity;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.luggage.sdk.processes.b;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.threadpool.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ao;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandKillByClientMessage;", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "appId", "", "killTypeOrdinal", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "killType", "Lcom/tencent/luggage/sdk/processes/KillType;", "autoStartAccountExpiredUI", "", "describeContents", "runInLuggageProcess", "", "runtime", "silentKill", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandKillByClientMessage
  extends LuggageClientProcessMessage<w>
{
  public static final Parcelable.Creator<AppBrandKillByClientMessage> CREATOR;
  private static final AppBrandKillByClientMessage.a tWH;
  private final String appId;
  private final int tWI;
  private final b tWJ;
  
  static
  {
    AppMethodBeat.i(318697);
    tWH = new AppBrandKillByClientMessage.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(318697);
  }
  
  public AppBrandKillByClientMessage(String paramString, int paramInt)
  {
    super(paramString);
    AppMethodBeat.i(318673);
    this.appId = paramString;
    this.tWI = paramInt;
    this.tWJ = b.values()[this.tWI];
    AppMethodBeat.o(318673);
  }
  
  private void X(w paramw)
  {
    AppMethodBeat.i(318684);
    kotlin.g.b.s.u(paramw, "runtime");
    if (!kotlin.g.b.s.p(Looper.getMainLooper(), Looper.myLooper()))
    {
      com.tencent.threadpool.h.ahAA.bk(new AppBrandKillByClientMessage..ExternalSyntheticLambda0(this, paramw));
      AppMethodBeat.o(318684);
      return;
    }
    Log.i("MicroMsg.AppBrandKillByClientMessage", "runInLuggageProcess killType:" + this.tWJ + ", web-kernel:" + WebView.getCurWebType());
    Object localObject = this.tWJ;
    switch (c.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      Log.i("MicroMsg.AppBrandKillByClientMessage", kotlin.g.b.s.X("silentKill runtime:", paramw.mAppId));
      paramw.Y(AppBrandKillByClientMessage..ExternalSyntheticLambda1.INSTANCE);
    }
    do
    {
      AppMethodBeat.o(318684);
      return;
      ao.OU(true);
      break;
      ao.OU(true);
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztH, false)) {
        break;
      }
      localObject = AndroidContextUtil.castActivityOrNull(paramw.mContext);
      if (localObject == null) {}
      for (localObject = null; localObject != null; localObject = ah.aiuX)
      {
        AppMethodBeat.o(318684);
        return;
        com.tencent.mm.plugin.appbrand.ui.s locals = com.tencent.mm.plugin.appbrand.ui.s.ueP;
        com.tencent.mm.plugin.appbrand.ui.s.N((Activity)localObject);
      }
      paramw = AndroidContextUtil.castActivityOrNull(paramw.mContext);
    } while (paramw == null);
    paramw.finish();
    AppMethodBeat.o(318684);
  }
  
  private static final void a(AppBrandKillByClientMessage paramAppBrandKillByClientMessage, w paramw)
  {
    AppMethodBeat.i(318688);
    kotlin.g.b.s.u(paramAppBrandKillByClientMessage, "this$0");
    kotlin.g.b.s.u(paramw, "$runtime");
    paramAppBrandKillByClientMessage.X(paramw);
    AppMethodBeat.o(318688);
  }
  
  private static final void cKg()
  {
    AppMethodBeat.i(318694);
    com.tencent.mm.modelappbrand.c.bEE();
    AppBrandProcessSuicideLogic.ceE();
    Log.appenderFlushSync();
    Object localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/appbrand/task/ipc/AppBrandKillByClientMessage", "silentKill$lambda-2", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/task/ipc/AppBrandKillByClientMessage", "silentKill$lambda-2", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/appbrand/task/ipc/AppBrandKillByClientMessage", "silentKill$lambda-2", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/task/ipc/AppBrandKillByClientMessage", "silentKill$lambda-2", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    localObject1 = (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    AppMethodBeat.o(318694);
    throw ((Throwable)localObject1);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String getAppId()
  {
    return this.appId;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(318709);
    kotlin.g.b.s.u(paramParcel, "out");
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.tWI);
    AppMethodBeat.o(318709);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<AppBrandKillByClientMessage>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandKillByClientMessage
 * JD-Core Version:    0.7.0.1
 */