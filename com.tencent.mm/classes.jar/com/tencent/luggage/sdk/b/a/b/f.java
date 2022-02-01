package com.tencent.luggage.sdk.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.m;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/jsapi/component/network/WssNativeFixLeak;", "", "()V", "proxyForReportListener", "Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssReportListener;", "lifecycleOwner", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonDestroyListener;", "proxyForSocketListener", "Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssWebSocketListener;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f erK;
  
  static
  {
    AppMethodBeat.i(220288);
    erK = new f();
    AppMethodBeat.o(220288);
  }
  
  public static final WcwssNative.IWcWssReportListener a(WcwssNative.IWcWssReportListener paramIWcWssReportListener, m paramm)
  {
    AppMethodBeat.i(220274);
    s.u(paramIWcWssReportListener, "<this>");
    s.u(paramm, "lifecycleOwner");
    a locala = new a();
    locala.erL = paramIWcWssReportListener;
    paramm.a(new f..ExternalSyntheticLambda0(locala));
    paramIWcWssReportListener = (WcwssNative.IWcWssReportListener)locala;
    AppMethodBeat.o(220274);
    return paramIWcWssReportListener;
  }
  
  public static final WcwssNative.IWcWssWebSocketListener a(WcwssNative.IWcWssWebSocketListener paramIWcWssWebSocketListener, m paramm)
  {
    AppMethodBeat.i(220280);
    s.u(paramIWcWssWebSocketListener, "<this>");
    s.u(paramm, "lifecycleOwner");
    b localb = new b();
    localb.erM = paramIWcWssWebSocketListener;
    paramm.a(new f..ExternalSyntheticLambda1(localb));
    paramIWcWssWebSocketListener = (WcwssNative.IWcWssWebSocketListener)localb;
    AppMethodBeat.o(220280);
    return paramIWcWssWebSocketListener;
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(220283);
    s.u(parama, "$it");
    parama.erL = null;
    AppMethodBeat.o(220283);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(220286);
    s.u(paramb, "$it");
    paramb.erM = null;
    AppMethodBeat.o(220286);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/luggage/sdk/jsapi/component/network/WssNativeFixLeak$proxyForReportListener$1", "Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssReportListener;", "delegate", "getDelegate", "()Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssReportListener;", "setDelegate", "(Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssReportListener;)V", "getNetworkType", "", "onIdKeyStat", "", "idArray", "", "keyArray", "valueArray", "onKvStat", "logId", "kv", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements WcwssNative.IWcWssReportListener
  {
    WcwssNative.IWcWssReportListener erL;
    
    public final int getNetworkType()
    {
      AppMethodBeat.i(220292);
      WcwssNative.IWcWssReportListener localIWcWssReportListener = this.erL;
      if (localIWcWssReportListener == null)
      {
        AppMethodBeat.o(220292);
        return 0;
      }
      int i = localIWcWssReportListener.getNetworkType();
      AppMethodBeat.o(220292);
      return i;
    }
    
    public final void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
    {
      AppMethodBeat.i(220297);
      WcwssNative.IWcWssReportListener localIWcWssReportListener = this.erL;
      if (localIWcWssReportListener != null) {
        localIWcWssReportListener.onIdKeyStat(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
      }
      AppMethodBeat.o(220297);
    }
    
    public final void onKvStat(int paramInt, String paramString)
    {
      AppMethodBeat.i(220295);
      WcwssNative.IWcWssReportListener localIWcWssReportListener = this.erL;
      if (localIWcWssReportListener != null) {
        localIWcWssReportListener.onKvStat(paramInt, paramString);
      }
      AppMethodBeat.o(220295);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/luggage/sdk/jsapi/component/network/WssNativeFixLeak$proxyForSocketListener$1", "Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssWebSocketListener;", "delegate", "getDelegate", "()Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssWebSocketListener;", "setDelegate", "(Lcom/tencent/mm/websocket/libwcwss/WcwssNative$IWcWssWebSocketListener;)V", "doCertificateVerify", "", "contextId", "", "wcwssId", "", "hostname", "certchain", "", "", "(Ljava/lang/String;JLjava/lang/String;[[B)I", "onStateChange", "", "state", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements WcwssNative.IWcWssWebSocketListener
  {
    WcwssNative.IWcWssWebSocketListener erM;
    
    public final int doCertificateVerify(String paramString1, long paramLong, String paramString2, byte[][] paramArrayOfByte)
    {
      AppMethodBeat.i(220293);
      WcwssNative.IWcWssWebSocketListener localIWcWssWebSocketListener = this.erM;
      if (localIWcWssWebSocketListener == null)
      {
        AppMethodBeat.o(220293);
        return 0;
      }
      int i = localIWcWssWebSocketListener.doCertificateVerify(paramString1, paramLong, paramString2, paramArrayOfByte);
      AppMethodBeat.o(220293);
      return i;
    }
    
    public final void onStateChange(String paramString, long paramLong, int paramInt)
    {
      AppMethodBeat.i(220289);
      WcwssNative.IWcWssWebSocketListener localIWcWssWebSocketListener = this.erM;
      if (localIWcWssWebSocketListener != null) {
        localIWcWssWebSocketListener.onStateChange(paramString, paramLong, paramInt);
      }
      AppMethodBeat.o(220289);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.f
 * JD-Core Version:    0.7.0.1
 */