package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_SystemSetting;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_TypeSpecificInfo;", "()V", "infoProviders", "", "", "Lkotlin/Function2;", "Landroid/content/Context;", "", "", "", "getInfoProviders", "()Ljava/util/Map;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ad
  extends af
{
  private static final j<Map<String, m<Context, Map<String, Object>, ah>>> sxo;
  public static final a sxy;
  private final Map<String, m<Context, Map<String, Object>, ah>> sxn;
  
  static
  {
    AppMethodBeat.i(326076);
    sxy = new a((byte)0);
    sxo = k.cm((a)b.sxz);
    AppMethodBeat.o(326076);
  }
  
  public ad()
  {
    AppMethodBeat.i(326069);
    this.sxn = ((Map)sxo.getValue());
    AppMethodBeat.o(326069);
  }
  
  public final Map<String, m<Context, Map<String, Object>, ah>> cuT()
  {
    return this.sxn;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_SystemSetting$Companion;", "", "()V", "INFO_KEY_BLUETOOTH_ENABLED", "", "INFO_KEY_DEVICE_ORIENTATION", "INFO_KEY_LOCATION_ENABLED", "INFO_KEY_WIFI_ENABLED", "INFO_PROVIDERS", "", "Lkotlin/Function2;", "Landroid/content/Context;", "", "", "getINFO_PROVIDERS", "()Ljava/util/Map;", "INFO_PROVIDERS$delegate", "Lkotlin/Lazy;", "ORIENTATION_LANDSCAPE", "ORIENTATION_PORTRAIT", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "Lkotlin/Function2;", "Landroid/content/Context;", "", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Map<String, ? extends m<? super Context, ? super Map<String, Object>, ? extends ah>>>
  {
    public static final b sxz;
    
    static
    {
      AppMethodBeat.i(326086);
      sxz = new b();
      AppMethodBeat.o(326086);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.ad
 * JD-Core Version:    0.7.0.1
 */