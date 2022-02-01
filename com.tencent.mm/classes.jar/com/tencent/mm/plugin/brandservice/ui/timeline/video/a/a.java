package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.protocal.protobuf.fy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler;", "", "()V", "END", "", "EVENT_CGI_SUCCESS", "", "EVENT_CLOSE_PAGE", "EVENT_ENTER_PAGE", "EVENT_FULLSCREEN", "EVENT_GETA8KEY", "EVENT_INSERT_VIDEO", "EVENT_MORE_VIDEO", "EVENT_ONREADY", "EVENT_PLAYER_ERROR", "EVENT_PLAYER_FIRST_DOWNLOAD", "EVENT_PLAYER_FIRST_PREPARE", "EVENT_PLAYER_LAG", "EVENT_PLAYER_PAUSE", "EVENT_PLAYER_PLAY", "EVENT_PLAYER_READY_PLAY", "EVENT_PLAYER_SEEK", "EVENT_PLAYER_SPEED", "EVENT_START_PLAYER", "EVENT_SWITCH_RESOLUTION", "START", "TAG", "initViewSelf", "insertVideoNativeView", "instanceMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "Lkotlin/collections/HashMap;", "getInstanceMap", "()Ljava/util/HashMap;", "nameToTime", "", "onAppMsgGet", "onAppMsgGetProcess", "onMediaPlayerPrepared", "onPageFinished", "onResetAfterCreateSelf", "onResetAfterCreateSuper", "onResetBeforeCreate", "onResumeSelf", "onStartSelf", "onSurfaceTextureAvailable", "postBindedSelf", "setDataSource", "startTime", "clearInstance", "", "key", "enterTime", "end", "getInstance", "resetTrace", "traceTime", "name", "addEvent", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "ins", "endTime", "addItem", "value", "toInfoString", "Instance", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a vYg;
  private static final HashMap<String, Long> vYh;
  private static final HashMap<String, a> vYi;
  
  static
  {
    AppMethodBeat.i(302069);
    vYg = new a();
    vYh = new HashMap();
    vYi = new HashMap();
    AppMethodBeat.o(302069);
  }
  
  public static void a(fv paramfv, String paramString1, String paramString2)
  {
    AppMethodBeat.i(302053);
    s.u(paramfv, "<this>");
    s.u(paramString1, "key");
    s.u(paramString2, "value");
    paramfv = paramfv.YCW;
    fy localfy = new fy();
    localfy.key = paramString1;
    localfy.onf = paramString2;
    paramString1 = ah.aiuX;
    paramfv.add(localfy);
    AppMethodBeat.o(302053);
  }
  
  public static a aka(String paramString)
  {
    AppMethodBeat.i(302062);
    s.u(paramString, "key");
    if (vYi.get(paramString) == null)
    {
      ((Map)vYi).put(paramString, new a());
      Log.i("MicroMsg.BizVideoProfiler", s.X(" getInstance null, create ", vYi.get(paramString)));
    }
    paramString = vYi.get(paramString);
    s.checkNotNull(paramString);
    s.s(paramString, "instanceMap[key]!!");
    paramString = (a)paramString;
    AppMethodBeat.o(302062);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "", "()V", "AppMsgUrl", "", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "(Ljava/lang/String;)V", "DeviceBrand", "getDeviceBrand", "setDeviceBrand", "DeviceModel", "getDeviceModel", "setDeviceModel", "EnterId", "getEnterId", "setEnterId", "EnterPageId", "getEnterPageId", "setEnterPageId", "LanguageVersion", "getLanguageVersion", "setLanguageVersion", "NetType", "getNetType", "setNetType", "OsName", "getOsName", "setOsName", "OsVersion", "getOsVersion", "setOsVersion", "Scene", "getScene", "setScene", "SubScene", "getSubScene", "setSubScene", "Vid", "getVid", "setVid", "eventItem", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "getEventItem", "()Ljava/util/LinkedList;", "eventMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEventMap", "()Ljava/util/HashMap;", "addPerformanceData", "", "performance", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "clearEvent", "getEvent", "event", "report", "tryToAddEvent", "toInfoString", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private String mut;
    private String muu;
    private String muv;
    private String muw;
    final HashMap<String, fv> rCp;
    private String vYj;
    private String vYk;
    private String vYl;
    private String vYm;
    private String vYn;
    private String vYo;
    private String vYp;
    private String vYq;
    final LinkedList<fv> vYr;
    
    public a()
    {
      AppMethodBeat.i(302044);
      this.mut = "";
      this.muu = "";
      this.muv = "";
      this.muw = "";
      this.vYj = "";
      this.vYk = "-1";
      this.vYl = "";
      this.vYm = "";
      this.vYn = "";
      this.vYo = "";
      this.vYp = "";
      this.vYq = "";
      this.vYr = new LinkedList();
      this.rCp = new HashMap();
      AppMethodBeat.o(302044);
    }
    
    public final fv akb(String paramString)
    {
      AppMethodBeat.i(302056);
      s.u(paramString, "event");
      fv localfv = (fv)this.rCp.get(paramString);
      if (localfv == null)
      {
        localfv = new fv();
        localfv.type = 5;
        LinkedList localLinkedList = localfv.YCW;
        fy localfy = new fy();
        localfy.key = "EventType";
        localfy.onf = paramString;
        ah localah = ah.aiuX;
        localLinkedList.add(localfy);
        localLinkedList = localfv.YCW;
        localfy = new fy();
        localfy.key = "StartTime";
        localfy.onf = String.valueOf(System.currentTimeMillis());
        localah = ah.aiuX;
        localLinkedList.add(localfy);
        ((Map)this.rCp).put(paramString, localfv);
        AppMethodBeat.o(302056);
        return localfv;
      }
      AppMethodBeat.o(302056);
      return localfv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a
 * JD-Core Version:    0.7.0.1
 */