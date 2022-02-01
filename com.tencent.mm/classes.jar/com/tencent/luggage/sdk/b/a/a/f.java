package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.m.a;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/jsapi/component/network/WssNativeFixLeak;", "", "()V", "proxyForReportListener", "Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssReportListener;", "lifecycleOwner", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonDestroyListener;", "proxyForSocketListener", "Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssWebSocketListener;", "luggage-wechat-full-sdk_release"})
public final class f
{
  public static final f czk;
  
  static
  {
    AppMethodBeat.i(247513);
    czk = new f();
    AppMethodBeat.o(247513);
  }
  
  public static final WcwssNative.IWcWssReportListener a(WcwssNative.IWcWssReportListener paramIWcWssReportListener, m paramm)
  {
    AppMethodBeat.i(247508);
    p.k(paramIWcWssReportListener, "$this$proxyForReportListener");
    p.k(paramm, "lifecycleOwner");
    a locala = new a();
    locala.czl = paramIWcWssReportListener;
    paramm.a((m.a)new b(locala));
    paramIWcWssReportListener = (WcwssNative.IWcWssReportListener)locala;
    AppMethodBeat.o(247508);
    return paramIWcWssReportListener;
  }
  
  public static final WcwssNative.IWcWssWebSocketListener a(WcwssNative.IWcWssWebSocketListener paramIWcWssWebSocketListener, m paramm)
  {
    AppMethodBeat.i(247511);
    p.k(paramIWcWssWebSocketListener, "$this$proxyForSocketListener");
    p.k(paramm, "lifecycleOwner");
    c localc = new c();
    localc.czn = paramIWcWssWebSocketListener;
    paramm.a((m.a)new d(localc));
    paramIWcWssWebSocketListener = (WcwssNative.IWcWssWebSocketListener)localc;
    AppMethodBeat.o(247511);
    return paramIWcWssWebSocketListener;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/luggage/sdk/jsapi/component/network/WssNativeFixLeak$proxyForReportListener$1", "Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssReportListener;", "delegate", "getDelegate", "()Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssReportListener;", "setDelegate", "(Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssReportListener;)V", "getNetworkType", "", "onIdKeyStat", "", "idArray", "", "keyArray", "valueArray", "onKvStat", "logId", "kv", "", "luggage-wechat-full-sdk_release"})
  public static final class a
    implements WcwssNative.IWcWssReportListener
  {
    WcwssNative.IWcWssReportListener czl;
    
    public final int getNetworkType()
    {
      AppMethodBeat.i(242821);
      WcwssNative.IWcWssReportListener localIWcWssReportListener = this.czl;
      if (localIWcWssReportListener != null)
      {
        int i = localIWcWssReportListener.getNetworkType();
        AppMethodBeat.o(242821);
        return i;
      }
      AppMethodBeat.o(242821);
      return 0;
    }
    
    public final void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
    {
      AppMethodBeat.i(242824);
      WcwssNative.IWcWssReportListener localIWcWssReportListener = this.czl;
      if (localIWcWssReportListener != null)
      {
        localIWcWssReportListener.onIdKeyStat(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
        AppMethodBeat.o(242824);
        return;
      }
      AppMethodBeat.o(242824);
    }
    
    public final void onKvStat(int paramInt, String paramString)
    {
      AppMethodBeat.i(242823);
      WcwssNative.IWcWssReportListener localIWcWssReportListener = this.czl;
      if (localIWcWssReportListener != null)
      {
        localIWcWssReportListener.onKvStat(paramInt, paramString);
        AppMethodBeat.o(242823);
        return;
      }
      AppMethodBeat.o(242823);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDestroy"})
  static final class b
    implements m.a
  {
    b(f.a parama) {}
    
    public final void onDestroy()
    {
      this.czm.czl = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/luggage/sdk/jsapi/component/network/WssNativeFixLeak$proxyForSocketListener$1", "Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssWebSocketListener;", "delegate", "getDelegate", "()Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssWebSocketListener;", "setDelegate", "(Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssWebSocketListener;)V", "doCertificateVerify", "", "contextId", "", "wcwssId", "", "hostname", "certchain", "", "", "(Ljava/lang/String;JLjava/lang/String;[[B)I", "onStateChange", "", "state", "luggage-wechat-full-sdk_release"})
  public static final class c
    implements WcwssNative.IWcWssWebSocketListener
  {
    WcwssNative.IWcWssWebSocketListener czn;
    
    public final int doCertificateVerify(String paramString1, long paramLong, String paramString2, byte[][] paramArrayOfByte)
    {
      AppMethodBeat.i(250612);
      WcwssNative.IWcWssWebSocketListener localIWcWssWebSocketListener = this.czn;
      if (localIWcWssWebSocketListener != null)
      {
        int i = localIWcWssWebSocketListener.doCertificateVerify(paramString1, paramLong, paramString2, paramArrayOfByte);
        AppMethodBeat.o(250612);
        return i;
      }
      AppMethodBeat.o(250612);
      return 0;
    }
    
    public final void onStateChange(String paramString, long paramLong, int paramInt)
    {
      AppMethodBeat.i(250608);
      WcwssNative.IWcWssWebSocketListener localIWcWssWebSocketListener = this.czn;
      if (localIWcWssWebSocketListener != null)
      {
        localIWcWssWebSocketListener.onStateChange(paramString, paramLong, paramInt);
        AppMethodBeat.o(250608);
        return;
      }
      AppMethodBeat.o(250608);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDestroy"})
  static final class d
    implements m.a
  {
    d(f.c paramc) {}
    
    public final void onDestroy()
    {
      this.czo.czn = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.f
 * JD-Core Version:    0.7.0.1
 */