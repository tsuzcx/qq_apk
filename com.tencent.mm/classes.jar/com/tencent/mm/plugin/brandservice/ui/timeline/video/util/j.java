package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler;", "", "()V", "END", "", "EVENT_CGI_SUCCESS", "", "EVENT_CLOSE_PAGE", "EVENT_ENTER_PAGE", "EVENT_FULLSCREEN", "EVENT_GETA8KEY", "EVENT_INSERT_VIDEO", "EVENT_MORE_VIDEO", "EVENT_ONREADY", "EVENT_PLAYER_ERROR", "EVENT_PLAYER_FIRST_DOWNLOAD", "EVENT_PLAYER_FIRST_PREPARE", "EVENT_PLAYER_LAG", "EVENT_PLAYER_PAUSE", "EVENT_PLAYER_PLAY", "EVENT_PLAYER_READY_PLAY", "EVENT_PLAYER_SEEK", "EVENT_PLAYER_SPEED", "EVENT_START_PLAYER", "EVENT_SWITCH_RESOLUTION", "START", "TAG", "initViewSelf", "insertVideoNativeView", "instanceMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "Lkotlin/collections/HashMap;", "getInstanceMap", "()Ljava/util/HashMap;", "nameToTime", "", "onAppMsgGet", "onAppMsgGetProcess", "onMediaPlayerPrepared", "onPageFinished", "onResetAfterCreateSelf", "onResetAfterCreateSuper", "onResetBeforeCreate", "onResumeSelf", "onStartSelf", "onSurfaceTextureAvailable", "postBindedSelf", "setDataSource", "startTime", "clearInstance", "", "key", "enterTime", "end", "getInstance", "resetTrace", "traceTime", "name", "addEvent", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "ins", "endTime", "addItem", "value", "toInfoString", "Instance", "plugin-brandservice_release"})
public final class j
{
  private static final HashMap<String, Long> nOC;
  private static final HashMap<String, a> nOD;
  public static final j nOE;
  
  static
  {
    AppMethodBeat.i(199181);
    nOE = new j();
    nOC = new HashMap();
    nOD = new HashMap();
    AppMethodBeat.o(199181);
  }
  
  public static a Um(String paramString)
  {
    AppMethodBeat.i(199179);
    k.h(paramString, "key");
    if (nOD.get(paramString) == null)
    {
      ((Map)nOD).put(paramString, new a());
      ac.i("MicroMsg.BizVideoProfiler", " getInstance null, create " + (a)nOD.get(paramString));
    }
    paramString = nOD.get(paramString);
    if (paramString == null) {
      k.fOy();
    }
    paramString = (a)paramString;
    AppMethodBeat.o(199179);
    return paramString;
  }
  
  public static void Un(String paramString)
  {
    AppMethodBeat.i(199180);
    k.h(paramString, "key");
    if (!nOD.containsKey(paramString))
    {
      AppMethodBeat.o(199180);
      return;
    }
    nOD.remove(paramString);
    AppMethodBeat.o(199180);
  }
  
  public static void a(eo parameo, a parama, String paramString)
  {
    AppMethodBeat.i(199176);
    k.h(parameo, "$this$addEvent");
    k.h(paramString, "endTime");
    String str = "";
    Object localObject1 = parameo.DNM;
    k.g(localObject1, "item");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (er)((Iterator)localObject1).next();
      if (!k.g(((er)localObject2).key, "EventType")) {
        break label213;
      }
      str = ((er)localObject2).hpH;
      k.g(str, "it.`val`");
    }
    label213:
    for (;;)
    {
      break;
      if ((k.g(str, "") ^ true))
      {
        localObject2 = parameo.DNM;
        er localer = new er();
        localer.key = "EndTime";
        localObject1 = paramString;
        if (k.g(paramString, "")) {
          localObject1 = String.valueOf(System.currentTimeMillis());
        }
        localer.hpH = ((String)localObject1);
        ((LinkedList)localObject2).add(localer);
        if (parama != null)
        {
          paramString = parama.nON;
          if (paramString != null) {
            paramString.add(parameo);
          }
        }
        if (parama != null)
        {
          parameo = parama.kaR;
          if (parameo != null)
          {
            parameo.remove(str);
            AppMethodBeat.o(199176);
            return;
          }
        }
      }
      AppMethodBeat.o(199176);
      return;
    }
  }
  
  public static void a(eo parameo, String paramString1, String paramString2)
  {
    AppMethodBeat.i(199178);
    k.h(parameo, "$this$addItem");
    k.h(paramString1, "key");
    k.h(paramString2, "value");
    parameo = parameo.DNM;
    er localer = new er();
    localer.key = paramString1;
    localer.hpH = paramString2;
    parameo.add(localer);
    AppMethodBeat.o(199178);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "", "()V", "AppMsgUrl", "", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "(Ljava/lang/String;)V", "DeviceBrand", "getDeviceBrand", "setDeviceBrand", "DeviceModel", "getDeviceModel", "setDeviceModel", "EnterId", "getEnterId", "setEnterId", "EnterPageId", "getEnterPageId", "setEnterPageId", "LanguageVersion", "getLanguageVersion", "setLanguageVersion", "NetType", "getNetType", "setNetType", "OsName", "getOsName", "setOsName", "OsVersion", "getOsVersion", "setOsVersion", "Scene", "getScene", "setScene", "SubScene", "getSubScene", "setSubScene", "Vid", "getVid", "setVid", "eventItem", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "getEventItem", "()Ljava/util/LinkedList;", "eventMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEventMap", "()Ljava/util/HashMap;", "addPerformanceData", "", "performance", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "clearEvent", "getEvent", "event", "report", "tryToAddEvent", "toInfoString", "plugin-brandservice_release"})
  public static final class a
  {
    String fZq;
    String fZr;
    String fZs;
    String fZt;
    final HashMap<String, eo> kaR;
    String nOF;
    String nOG;
    public String nOH;
    public String nOI;
    public String nOJ;
    public String nOK;
    public String nOL;
    public String nOM;
    public final LinkedList<eo> nON;
    
    public a()
    {
      AppMethodBeat.i(199175);
      this.fZq = "";
      this.fZr = "";
      this.fZs = "";
      this.fZt = "";
      this.nOF = "";
      this.nOG = "-1";
      this.nOH = "";
      this.nOI = "";
      this.nOJ = "";
      this.nOK = "";
      this.nOL = "";
      this.nOM = "";
      this.nON = new LinkedList();
      this.kaR = new HashMap();
      AppMethodBeat.o(199175);
    }
    
    public final eo Uo(String paramString)
    {
      AppMethodBeat.i(199172);
      k.h(paramString, "event");
      Object localObject2 = (eo)this.kaR.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new eo();
        ((eo)localObject1).type = 5;
        localObject2 = ((eo)localObject1).DNM;
        er localer = new er();
        localer.key = "EventType";
        localer.hpH = paramString;
        ((LinkedList)localObject2).add(localer);
        localObject2 = ((eo)localObject1).DNM;
        localer = new er();
        localer.key = "StartTime";
        localer.hpH = String.valueOf(System.currentTimeMillis());
        ((LinkedList)localObject2).add(localer);
        ((Map)this.kaR).put(paramString, localObject1);
      }
      AppMethodBeat.o(199172);
      return localObject1;
    }
    
    public final void Up(String paramString)
    {
      AppMethodBeat.i(199173);
      k.h(paramString, "event");
      paramString = (eo)this.kaR.get(paramString);
      if (paramString != null)
      {
        j localj = j.nOE;
        j.a(paramString, this);
        AppMethodBeat.o(199173);
        return;
      }
      AppMethodBeat.o(199173);
    }
    
    public final void bND()
    {
      AppMethodBeat.i(199171);
      this.nON.clear();
      this.kaR.clear();
      AppMethodBeat.o(199171);
    }
    
    public final void report()
    {
      AppMethodBeat.i(199174);
      ((d.g.a.a)new c(this)).invoke();
      ep localep = new ep();
      eo localeo = new eo();
      localeo.type = 5;
      LinkedList localLinkedList = localeo.DNM;
      er localer = new er();
      localer.key = "DeviceModel";
      Object localObject2 = this.fZq;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localer = new er();
      localer.key = "DeviceBrand";
      localObject2 = this.fZr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localer = new er();
      localer.key = "OsName";
      localObject2 = this.fZs;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localer = new er();
      localer.key = "OsVersion";
      localObject2 = this.fZt;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localer = new er();
      localer.key = "LanguageVersion";
      localObject2 = this.nOF;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localer = new er();
      localer.key = "NetType";
      localObject2 = this.nOG;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localer = new er();
      localer.key = "EnterId";
      localObject2 = this.nOH;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localer = new er();
      localer.key = "EnterPageId";
      localObject2 = this.nOI;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localer = new er();
      localer.key = "AppMsgUrl";
      localObject2 = this.nOJ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localer = new er();
      localer.key = "Vid";
      localObject2 = this.nOK;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localer = new er();
      localer.key = "Scene";
      localObject2 = this.nOL;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localer = new er();
      localer.key = "SubScene";
      localObject2 = this.nOM;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localer.hpH = ((String)localObject1);
      localLinkedList.add(localer);
      localep.DRj = localeo;
      localObject1 = ((Iterable)this.nON).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (eo)((Iterator)localObject1).next();
        localep.DRi.add(localObject2);
      }
      localObject1 = new b.a();
      ((b.a)localObject1).c((com.tencent.mm.bw.a)localep);
      ((b.a)localObject1).d((com.tencent.mm.bw.a)new eq());
      ((b.a)localObject1).Am("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
      ((b.a)localObject1).op(1870);
      ((b.a)localObject1).or(0);
      ((b.a)localObject1).os(0);
      IPCRunCgi.a(((b.a)localObject1).aAz(), (IPCRunCgi.a)b.nOP);
      ac.i("MicroMsg.BizVideoProfiler", " report instance = ".concat(String.valueOf(this)));
      bND();
      AppMethodBeat.o(199174);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class b
      implements IPCRunCgi.a
    {
      public static final b nOP;
      
      static
      {
        AppMethodBeat.i(199169);
        nOP = new b();
        AppMethodBeat.o(199169);
      }
      
      public final void a(int paramInt1, int paramInt2, String paramString, b paramb) {}
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(j.a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j
 * JD-Core Version:    0.7.0.1
 */