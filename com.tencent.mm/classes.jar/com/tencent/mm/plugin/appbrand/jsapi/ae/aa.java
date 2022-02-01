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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_AppAuthorize;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_TypeSpecificInfo;", "()V", "infoProviders", "", "", "Lkotlin/Function2;", "Landroid/content/Context;", "", "", "", "getInfoProviders", "()Ljava/util/Map;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
final class aa
  extends af
{
  public static final a sxm;
  private static final j<Map<String, m<Context, Map<String, Object>, ah>>> sxo;
  private final Map<String, m<Context, Map<String, Object>, ah>> sxn;
  
  static
  {
    AppMethodBeat.i(326081);
    sxm = new a((byte)0);
    sxo = k.cm((a)b.sxp);
    AppMethodBeat.o(326081);
  }
  
  public aa()
  {
    AppMethodBeat.i(326078);
    this.sxn = ((Map)sxo.getValue());
    AppMethodBeat.o(326078);
  }
  
  public final Map<String, m<Context, Map<String, Object>, ah>> cuT()
  {
    return this.sxn;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_AppAuthorize$Companion;", "", "()V", "INFO_KEY_CAMERA_AUTHORIZED", "", "INFO_KEY_LOCATION_AUTHORIZED", "INFO_KEY_MICROPHONE_AUTHORIZED", "INFO_KEY_NOTIFICATION_AUTHORIZED", "INFO_KEY_PHONE_CALENDAR_AUTHORIZED", "INFO_PROVIDERS", "", "Lkotlin/Function2;", "Landroid/content/Context;", "", "", "getINFO_PROVIDERS", "()Ljava/util/Map;", "INFO_PROVIDERS$delegate", "Lkotlin/Lazy;", "STATE_PERMISSION_ALLOWED", "STATE_PERMISSION_DENIED", "toAuthorizeState", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "Lkotlin/Function2;", "Landroid/content/Context;", "", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Map<String, ? extends m<? super Context, ? super Map<String, Object>, ? extends ah>>>
  {
    public static final b sxp;
    
    static
    {
      AppMethodBeat.i(326020);
      sxp = new b();
      AppMethodBeat.o(326020);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.aa
 * JD-Core Version:    0.7.0.1
 */