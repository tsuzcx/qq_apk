package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler;", "", "()V", "END", "", "EVENT_CGI_SUCCESS", "", "EVENT_CLOSE_PAGE", "EVENT_ENTER_PAGE", "EVENT_FULLSCREEN", "EVENT_GETA8KEY", "EVENT_INSERT_VIDEO", "EVENT_MORE_VIDEO", "EVENT_ONREADY", "EVENT_PLAYER_ERROR", "EVENT_PLAYER_FIRST_DOWNLOAD", "EVENT_PLAYER_FIRST_PREPARE", "EVENT_PLAYER_LAG", "EVENT_PLAYER_PAUSE", "EVENT_PLAYER_PLAY", "EVENT_PLAYER_READY_PLAY", "EVENT_PLAYER_SEEK", "EVENT_PLAYER_SPEED", "EVENT_START_PLAYER", "EVENT_SWITCH_RESOLUTION", "START", "TAG", "initViewSelf", "insertVideoNativeView", "instanceMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "Lkotlin/collections/HashMap;", "getInstanceMap", "()Ljava/util/HashMap;", "nameToTime", "", "onAppMsgGet", "onAppMsgGetProcess", "onMediaPlayerPrepared", "onPageFinished", "onResetAfterCreateSelf", "onResetAfterCreateSuper", "onResetBeforeCreate", "onResumeSelf", "onStartSelf", "onSurfaceTextureAvailable", "postBindedSelf", "setDataSource", "startTime", "clearInstance", "", "key", "enterTime", "end", "getInstance", "resetTrace", "traceTime", "name", "addEvent", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "ins", "endTime", "addItem", "value", "toInfoString", "Instance", "plugin-brandservice_release"})
public final class j
{
  private static final HashMap<String, Long> oxE;
  private static final HashMap<String, a> oxF;
  public static final j oxG;
  
  static
  {
    AppMethodBeat.i(209164);
    oxG = new j();
    oxE = new HashMap();
    oxF = new HashMap();
    AppMethodBeat.o(209164);
  }
  
  public static a YJ(String paramString)
  {
    AppMethodBeat.i(209162);
    p.h(paramString, "key");
    if (oxF.get(paramString) == null)
    {
      ((Map)oxF).put(paramString, new a());
      ae.i("MicroMsg.BizVideoProfiler", " getInstance null, create " + (a)oxF.get(paramString));
    }
    paramString = oxF.get(paramString);
    if (paramString == null) {
      p.gkB();
    }
    paramString = (a)paramString;
    AppMethodBeat.o(209162);
    return paramString;
  }
  
  public static void YK(String paramString)
  {
    AppMethodBeat.i(209163);
    p.h(paramString, "key");
    if (!oxF.containsKey(paramString))
    {
      AppMethodBeat.o(209163);
      return;
    }
    oxF.remove(paramString);
    AppMethodBeat.o(209163);
  }
  
  public static void a(es parames, a parama, String paramString)
  {
    AppMethodBeat.i(209159);
    p.h(parames, "$this$addEvent");
    p.h(paramString, "endTime");
    String str = "";
    Object localObject1 = parames.FLq;
    p.g(localObject1, "item");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ev)((Iterator)localObject1).next();
      if (p.i(((ev)localObject2).key, "EventType"))
      {
        str = ((ev)localObject2).hKR;
        p.g(str, "it.`val`");
      }
    }
    if ((p.i(str, "") ^ true))
    {
      localObject2 = parames.FLq;
      ev localev = new ev();
      localev.key = "EndTime";
      localObject1 = paramString;
      if (p.i(paramString, "")) {
        localObject1 = String.valueOf(System.currentTimeMillis());
      }
      localev.hKR = ((String)localObject1);
      ((LinkedList)localObject2).add(localev);
      if (parama != null)
      {
        paramString = parama.oxP;
        if (paramString != null) {
          paramString.add(parames);
        }
      }
      if (parama != null)
      {
        parames = parama.kyC;
        if (parames != null)
        {
          parames.remove(str);
          AppMethodBeat.o(209159);
          return;
        }
      }
    }
    AppMethodBeat.o(209159);
  }
  
  public static void a(es parames, String paramString1, String paramString2)
  {
    AppMethodBeat.i(209161);
    p.h(parames, "$this$addItem");
    p.h(paramString1, "key");
    p.h(paramString2, "value");
    parames = parames.FLq;
    ev localev = new ev();
    localev.key = paramString1;
    localev.hKR = paramString2;
    parames.add(localev);
    AppMethodBeat.o(209161);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "", "()V", "AppMsgUrl", "", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "(Ljava/lang/String;)V", "DeviceBrand", "getDeviceBrand", "setDeviceBrand", "DeviceModel", "getDeviceModel", "setDeviceModel", "EnterId", "getEnterId", "setEnterId", "EnterPageId", "getEnterPageId", "setEnterPageId", "LanguageVersion", "getLanguageVersion", "setLanguageVersion", "NetType", "getNetType", "setNetType", "OsName", "getOsName", "setOsName", "OsVersion", "getOsVersion", "setOsVersion", "Scene", "getScene", "setScene", "SubScene", "getSubScene", "setSubScene", "Vid", "getVid", "setVid", "eventItem", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "getEventItem", "()Ljava/util/LinkedList;", "eventMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEventMap", "()Ljava/util/HashMap;", "addPerformanceData", "", "performance", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "clearEvent", "getEvent", "event", "report", "tryToAddEvent", "toInfoString", "plugin-brandservice_release"})
  public static final class a
  {
    String gvo;
    String gvp;
    String gvq;
    String gvr;
    final HashMap<String, es> kyC;
    String oxH;
    String oxI;
    public String oxJ;
    public String oxK;
    public String oxL;
    public String oxM;
    public String oxN;
    public String oxO;
    public final LinkedList<es> oxP;
    
    public a()
    {
      AppMethodBeat.i(209158);
      this.gvo = "";
      this.gvp = "";
      this.gvq = "";
      this.gvr = "";
      this.oxH = "";
      this.oxI = "-1";
      this.oxJ = "";
      this.oxK = "";
      this.oxL = "";
      this.oxM = "";
      this.oxN = "";
      this.oxO = "";
      this.oxP = new LinkedList();
      this.kyC = new HashMap();
      AppMethodBeat.o(209158);
    }
    
    public final es YL(String paramString)
    {
      AppMethodBeat.i(209155);
      p.h(paramString, "event");
      Object localObject2 = (es)this.kyC.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new es();
        ((es)localObject1).type = 5;
        localObject2 = ((es)localObject1).FLq;
        ev localev = new ev();
        localev.key = "EventType";
        localev.hKR = paramString;
        ((LinkedList)localObject2).add(localev);
        localObject2 = ((es)localObject1).FLq;
        localev = new ev();
        localev.key = "StartTime";
        localev.hKR = String.valueOf(System.currentTimeMillis());
        ((LinkedList)localObject2).add(localev);
        ((Map)this.kyC).put(paramString, localObject1);
      }
      AppMethodBeat.o(209155);
      return localObject1;
    }
    
    public final void YM(String paramString)
    {
      AppMethodBeat.i(209156);
      p.h(paramString, "event");
      paramString = (es)this.kyC.get(paramString);
      if (paramString != null)
      {
        j localj = j.oxG;
        j.a(paramString, this);
        AppMethodBeat.o(209156);
        return;
      }
      AppMethodBeat.o(209156);
    }
    
    public final void bTp()
    {
      AppMethodBeat.i(209154);
      this.oxP.clear();
      this.kyC.clear();
      AppMethodBeat.o(209154);
    }
    
    public final void report()
    {
      AppMethodBeat.i(209157);
      ((d.g.a.a)new j.a.c(this)).invoke();
      et localet = new et();
      es locales = new es();
      locales.type = 5;
      LinkedList localLinkedList = locales.FLq;
      ev localev = new ev();
      localev.key = "DeviceModel";
      Object localObject2 = this.gvo;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "DeviceBrand";
      localObject2 = this.gvp;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "OsName";
      localObject2 = this.gvq;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "OsVersion";
      localObject2 = this.gvr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "LanguageVersion";
      localObject2 = this.oxH;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "NetType";
      localObject2 = this.oxI;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "EnterId";
      localObject2 = this.oxJ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "EnterPageId";
      localObject2 = this.oxK;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "AppMsgUrl";
      localObject2 = this.oxL;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "Vid";
      localObject2 = this.oxM;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "Scene";
      localObject2 = this.oxN;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "SubScene";
      localObject2 = this.oxO;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hKR = ((String)localObject1);
      localLinkedList.add(localev);
      localet.FOZ = locales;
      localObject1 = ((Iterable)this.oxP).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (es)((Iterator)localObject1).next();
        localet.FOY.add(localObject2);
      }
      localObject1 = new b.a();
      ((b.a)localObject1).c((com.tencent.mm.bw.a)localet);
      ((b.a)localObject1).d((com.tencent.mm.bw.a)new eu());
      ((b.a)localObject1).DN("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
      ((b.a)localObject1).oS(1870);
      ((b.a)localObject1).oU(0);
      ((b.a)localObject1).oV(0);
      IPCRunCgi.a(((b.a)localObject1).aDS(), (IPCRunCgi.a)j.a.b.oxR);
      ae.i("MicroMsg.BizVideoProfiler", " report instance = ".concat(String.valueOf(this)));
      bTp();
      AppMethodBeat.o(209157);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j
 * JD-Core Version:    0.7.0.1
 */