package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AutoConnectGattRetryStrategy;", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IAutoConnectGattStrategy;", "deviceId", "", "gattConnectListener", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IGattConnectListener;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IGattConnectListener;)V", "gattConnectListenerWithRetry", "com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AutoConnectGattRetryStrategy$gattConnectListenerWithRetry$1", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AutoConnectGattRetryStrategy$gattConnectListenerWithRetry$1;", "myTag", "connect", "", "disconnect", "pauseConnect", "", "resumeConnect", "canReset", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements j
{
  public static final b.a rgy;
  private final String djQ;
  private final String hEl;
  private final b rgA;
  private final l rgz;
  
  static
  {
    AppMethodBeat.i(321654);
    rgy = new b.a((byte)0);
    AppMethodBeat.o(321654);
  }
  
  public b(String paramString, l paraml)
  {
    AppMethodBeat.i(321634);
    this.hEl = paramString;
    this.rgz = paraml;
    this.djQ = s.X("MicroMsg.AppBrand.AutoConnectGattRetryStrategy#", Integer.valueOf(hashCode()));
    this.rgA = new b(this);
    AppMethodBeat.o(321634);
  }
  
  public final boolean cmB()
  {
    AppMethodBeat.i(321662);
    Object localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i(this.djQ, "connect");
    localObject = e.rgJ;
    boolean bool = e.b(this.hEl, this.rgA.cmD());
    AppMethodBeat.o(321662);
    return bool;
  }
  
  public final void cmC()
  {
    AppMethodBeat.i(321676);
    Object localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i(this.djQ, "pauseConnect");
    localObject = this.rgA;
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i(((b)localObject).rgF.djQ, "pause#gattConnectListenerWithRetry");
    ((b)localObject).rgD = true;
    AppMethodBeat.o(321676);
  }
  
  public final boolean disconnect()
  {
    AppMethodBeat.i(321668);
    Object localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i(this.djQ, "disconnect");
    localObject = e.rgJ;
    boolean bool = e.YF(this.hEl);
    this.rgA.reset();
    AppMethodBeat.o(321668);
    return bool;
  }
  
  public final void iO(boolean paramBoolean)
  {
    AppMethodBeat.i(321684);
    Object localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i(this.djQ, s.X("resumeConnect, canReset: ", Boolean.valueOf(paramBoolean)));
    localObject = this.rgA;
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i(((b)localObject).rgF.djQ, s.X("resume#gattConnectListenerWithRetry, canReset: ", Boolean.valueOf(paramBoolean)));
    ((b)localObject).rgD = false;
    if (paramBoolean) {
      ((b)localObject).reset();
    }
    localObject = ((b)localObject).rgE;
    if (localObject != null) {
      ((kotlin.g.a.a)localObject).invoke();
    }
    AppMethodBeat.o(321684);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AutoConnectGattRetryStrategy$gattConnectListenerWithRetry$1", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IGattConnectListener;", "connectStartTimeMills", "", "isConnectPaused", "", "()Z", "setConnectPaused", "(Z)V", "pendingReConnectTask", "Lkotlin/Function0;", "", "retryDelayMillsResolver", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/RetryDelayMillsResolver;", "get", "onConnectStateChange", "deviceId", "", "isConnected", "pause", "reset", "resume", "canReset", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements l
  {
    private volatile long rgB;
    private final q rgC;
    volatile boolean rgD;
    volatile kotlin.g.a.a<ah> rgE;
    
    b(b paramb)
    {
      AppMethodBeat.i(321781);
      this.rgB = -1L;
      this.rgC = new q();
      AppMethodBeat.o(321781);
    }
    
    public final l cmD()
    {
      AppMethodBeat.i(321805);
      Object localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.i(b.a(this.rgF), "get#gattConnectListenerWithRetry");
      this.rgB = SystemClock.elapsedRealtime();
      localObject = (l)this;
      AppMethodBeat.o(321805);
      return localObject;
    }
    
    public final void onConnectStateChange(final String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(321827);
      s.u(paramString, "deviceId");
      b.b(this.rgF).onConnectStateChange(paramString, paramBoolean);
      if (!paramBoolean)
      {
        if (30000L < SystemClock.elapsedRealtime() - this.rgB) {
          this.rgC.reset();
        }
        paramString = (kotlin.g.a.a)new a(this, paramString);
        if (this.rgD)
        {
          this.rgE = paramString;
          AppMethodBeat.o(321827);
          return;
        }
        paramString.invoke();
      }
      AppMethodBeat.o(321827);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(321815);
      com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.i(b.a(this.rgF), "reset#gattConnectListenerWithRetry");
      this.rgB = -1L;
      this.rgC.reset();
      AppMethodBeat.o(321815);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(b.b paramb, String paramString)
      {
        super();
      }
      
      private static final void a(String paramString, b.b paramb)
      {
        AppMethodBeat.i(321705);
        s.u(paramString, "$deviceId");
        s.u(paramb, "this$0");
        e locale = e.rgJ;
        e.b(paramString, paramb.cmD());
        AppMethodBeat.o(321705);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.b
 * JD-Core Version:    0.7.0.1
 */