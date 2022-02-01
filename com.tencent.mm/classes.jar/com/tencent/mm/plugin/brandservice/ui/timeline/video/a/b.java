package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler;", "", "()V", "END", "", "EVENT_CGI_SUCCESS", "", "EVENT_CLOSE_PAGE", "EVENT_ENTER_PAGE", "EVENT_FULLSCREEN", "EVENT_GETA8KEY", "EVENT_INSERT_VIDEO", "EVENT_MORE_VIDEO", "EVENT_ONREADY", "EVENT_PLAYER_ERROR", "EVENT_PLAYER_FIRST_DOWNLOAD", "EVENT_PLAYER_FIRST_PREPARE", "EVENT_PLAYER_LAG", "EVENT_PLAYER_PAUSE", "EVENT_PLAYER_PLAY", "EVENT_PLAYER_READY_PLAY", "EVENT_PLAYER_SEEK", "EVENT_PLAYER_SPEED", "EVENT_START_PLAYER", "EVENT_SWITCH_RESOLUTION", "START", "TAG", "initViewSelf", "insertVideoNativeView", "instanceMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "Lkotlin/collections/HashMap;", "getInstanceMap", "()Ljava/util/HashMap;", "nameToTime", "", "onAppMsgGet", "onAppMsgGetProcess", "onMediaPlayerPrepared", "onPageFinished", "onResetAfterCreateSelf", "onResetAfterCreateSuper", "onResetBeforeCreate", "onResumeSelf", "onStartSelf", "onSurfaceTextureAvailable", "postBindedSelf", "setDataSource", "startTime", "clearInstance", "", "key", "enterTime", "end", "getInstance", "resetTrace", "traceTime", "name", "addEvent", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "ins", "endTime", "addItem", "value", "toInfoString", "Instance", "plugin-brandservice_release"})
public final class b
{
  private static final HashMap<String, Long> sSQ;
  private static final HashMap<String, a> sSR;
  public static final b sSS;
  
  static
  {
    AppMethodBeat.i(264010);
    sSS = new b();
    sSQ = new HashMap();
    sSR = new HashMap();
    AppMethodBeat.o(264010);
  }
  
  public static void a(fb paramfb, String paramString1, String paramString2)
  {
    AppMethodBeat.i(264008);
    p.k(paramfb, "$this$addItem");
    p.k(paramString1, "key");
    p.k(paramString2, "value");
    paramfb = paramfb.RGi;
    fe localfe = new fe();
    localfe.key = paramString1;
    localfe.lvH = paramString2;
    paramfb.add(localfe);
    AppMethodBeat.o(264008);
  }
  
  public static a aqB(String paramString)
  {
    AppMethodBeat.i(264009);
    p.k(paramString, "key");
    if (sSR.get(paramString) == null)
    {
      ((Map)sSR).put(paramString, new a());
      Log.i("MicroMsg.BizVideoProfiler", " getInstance null, create " + (a)sSR.get(paramString));
    }
    paramString = sSR.get(paramString);
    if (paramString == null) {
      p.iCn();
    }
    paramString = (a)paramString;
    AppMethodBeat.o(264009);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "", "()V", "AppMsgUrl", "", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "(Ljava/lang/String;)V", "DeviceBrand", "getDeviceBrand", "setDeviceBrand", "DeviceModel", "getDeviceModel", "setDeviceModel", "EnterId", "getEnterId", "setEnterId", "EnterPageId", "getEnterPageId", "setEnterPageId", "LanguageVersion", "getLanguageVersion", "setLanguageVersion", "NetType", "getNetType", "setNetType", "OsName", "getOsName", "setOsName", "OsVersion", "getOsVersion", "setOsVersion", "Scene", "getScene", "setScene", "SubScene", "getSubScene", "setSubScene", "Vid", "getVid", "setVid", "eventItem", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "getEventItem", "()Ljava/util/LinkedList;", "eventMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEventMap", "()Ljava/util/HashMap;", "addPerformanceData", "", "performance", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "clearEvent", "getEvent", "event", "report", "tryToAddEvent", "toInfoString", "plugin-brandservice_release"})
  public static final class a
  {
    private String jUb;
    private String jUc;
    private String jUd;
    private String jUe;
    final HashMap<String, fb> oyx;
    private String sST;
    private String sSU;
    private String sSV;
    private String sSW;
    private String sSX;
    private String sSY;
    private String sSZ;
    private String sTa;
    final LinkedList<fb> sTb;
    
    public a()
    {
      AppMethodBeat.i(266052);
      this.jUb = "";
      this.jUc = "";
      this.jUd = "";
      this.jUe = "";
      this.sST = "";
      this.sSU = "-1";
      this.sSV = "";
      this.sSW = "";
      this.sSX = "";
      this.sSY = "";
      this.sSZ = "";
      this.sTa = "";
      this.sTb = new LinkedList();
      this.oyx = new HashMap();
      AppMethodBeat.o(266052);
    }
    
    public final fb aqC(String paramString)
    {
      AppMethodBeat.i(266051);
      p.k(paramString, "event");
      Object localObject2 = (fb)this.oyx.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new fb();
        ((fb)localObject1).type = 5;
        localObject2 = ((fb)localObject1).RGi;
        fe localfe = new fe();
        localfe.key = "EventType";
        localfe.lvH = paramString;
        ((LinkedList)localObject2).add(localfe);
        localObject2 = ((fb)localObject1).RGi;
        localfe = new fe();
        localfe.key = "StartTime";
        localfe.lvH = String.valueOf(System.currentTimeMillis());
        ((LinkedList)localObject2).add(localfe);
        ((Map)this.oyx).put(paramString, localObject1);
      }
      AppMethodBeat.o(266051);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b
 * JD-Core Version:    0.7.0.1
 */