package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler;", "", "()V", "END", "", "EVENT_CGI_SUCCESS", "", "EVENT_CLOSE_PAGE", "EVENT_ENTER_PAGE", "EVENT_FULLSCREEN", "EVENT_GETA8KEY", "EVENT_INSERT_VIDEO", "EVENT_MORE_VIDEO", "EVENT_ONREADY", "EVENT_PLAYER_ERROR", "EVENT_PLAYER_FIRST_DOWNLOAD", "EVENT_PLAYER_FIRST_PREPARE", "EVENT_PLAYER_LAG", "EVENT_PLAYER_PAUSE", "EVENT_PLAYER_PLAY", "EVENT_PLAYER_READY_PLAY", "EVENT_PLAYER_SEEK", "EVENT_PLAYER_SPEED", "EVENT_START_PLAYER", "EVENT_SWITCH_RESOLUTION", "START", "TAG", "initViewSelf", "insertVideoNativeView", "instanceMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "Lkotlin/collections/HashMap;", "getInstanceMap", "()Ljava/util/HashMap;", "nameToTime", "", "onAppMsgGet", "onAppMsgGetProcess", "onMediaPlayerPrepared", "onPageFinished", "onResetAfterCreateSelf", "onResetAfterCreateSuper", "onResetBeforeCreate", "onResumeSelf", "onStartSelf", "onSurfaceTextureAvailable", "postBindedSelf", "setDataSource", "startTime", "clearInstance", "", "key", "enterTime", "end", "getInstance", "resetTrace", "traceTime", "name", "addEvent", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "ins", "endTime", "addItem", "value", "toInfoString", "Instance", "plugin-brandservice_release"})
public final class j
{
  private static final HashMap<String, Long> nlC;
  private static final HashMap<String, a> nlD;
  public static final j nlE;
  
  static
  {
    AppMethodBeat.i(193369);
    nlE = new j();
    nlC = new HashMap();
    nlD = new HashMap();
    AppMethodBeat.o(193369);
  }
  
  public static a Qa(String paramString)
  {
    AppMethodBeat.i(193367);
    k.h(paramString, "key");
    if (nlD.get(paramString) == null)
    {
      ((Map)nlD).put(paramString, new a());
      ad.i("MicroMsg.BizVideoProfiler", " getInstance null, create " + (a)nlD.get(paramString));
    }
    paramString = nlD.get(paramString);
    if (paramString == null) {
      k.fvU();
    }
    paramString = (a)paramString;
    AppMethodBeat.o(193367);
    return paramString;
  }
  
  public static void Qb(String paramString)
  {
    AppMethodBeat.i(193368);
    k.h(paramString, "key");
    if (!nlD.containsKey(paramString))
    {
      AppMethodBeat.o(193368);
      return;
    }
    nlD.remove(paramString);
    AppMethodBeat.o(193368);
  }
  
  public static void a(em paramem, a parama, String paramString)
  {
    AppMethodBeat.i(193364);
    k.h(paramem, "$this$addEvent");
    k.h(paramString, "endTime");
    String str = "";
    Object localObject1 = paramem.Cvr;
    k.g(localObject1, "item");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ep)((Iterator)localObject1).next();
      if (!k.g(((ep)localObject2).key, "EventType")) {
        break label213;
      }
      str = ((ep)localObject2).gPh;
      k.g(str, "it.`val`");
    }
    label213:
    for (;;)
    {
      break;
      if ((k.g(str, "") ^ true))
      {
        localObject2 = paramem.Cvr;
        ep localep = new ep();
        localep.key = "EndTime";
        localObject1 = paramString;
        if (k.g(paramString, "")) {
          localObject1 = String.valueOf(System.currentTimeMillis());
        }
        localep.gPh = ((String)localObject1);
        ((LinkedList)localObject2).add(localep);
        if (parama != null)
        {
          paramString = parama.nlN;
          if (paramString != null) {
            paramString.add(paramem);
          }
        }
        if (parama != null)
        {
          paramem = parama.jAv;
          if (paramem != null)
          {
            paramem.remove(str);
            AppMethodBeat.o(193364);
            return;
          }
        }
      }
      AppMethodBeat.o(193364);
      return;
    }
  }
  
  public static void a(em paramem, String paramString1, String paramString2)
  {
    AppMethodBeat.i(193366);
    k.h(paramem, "$this$addItem");
    k.h(paramString1, "key");
    k.h(paramString2, "value");
    paramem = paramem.Cvr;
    ep localep = new ep();
    localep.key = paramString1;
    localep.gPh = paramString2;
    paramem.add(localep);
    AppMethodBeat.o(193366);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "", "()V", "AppMsgUrl", "", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "(Ljava/lang/String;)V", "DeviceBrand", "getDeviceBrand", "setDeviceBrand", "DeviceModel", "getDeviceModel", "setDeviceModel", "EnterId", "getEnterId", "setEnterId", "EnterPageId", "getEnterPageId", "setEnterPageId", "LanguageVersion", "getLanguageVersion", "setLanguageVersion", "NetType", "getNetType", "setNetType", "OsName", "getOsName", "setOsName", "OsVersion", "getOsVersion", "setOsVersion", "Scene", "getScene", "setScene", "SubScene", "getSubScene", "setSubScene", "Vid", "getVid", "setVid", "eventItem", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "getEventItem", "()Ljava/util/LinkedList;", "eventMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEventMap", "()Ljava/util/HashMap;", "addPerformanceData", "", "performance", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "clearEvent", "getEvent", "event", "report", "tryToAddEvent", "toInfoString", "plugin-brandservice_release"})
  public static final class a
  {
    String fVv;
    String fVw;
    String fVx;
    String fVy;
    final HashMap<String, em> jAv;
    String nlF;
    String nlG;
    public String nlH;
    public String nlI;
    public String nlJ;
    public String nlK;
    public String nlL;
    public String nlM;
    public final LinkedList<em> nlN;
    
    public a()
    {
      AppMethodBeat.i(193363);
      this.fVv = "";
      this.fVw = "";
      this.fVx = "";
      this.fVy = "";
      this.nlF = "";
      this.nlG = "-1";
      this.nlH = "";
      this.nlI = "";
      this.nlJ = "";
      this.nlK = "";
      this.nlL = "";
      this.nlM = "";
      this.nlN = new LinkedList();
      this.jAv = new HashMap();
      AppMethodBeat.o(193363);
    }
    
    public final em Qc(String paramString)
    {
      AppMethodBeat.i(193360);
      k.h(paramString, "event");
      Object localObject2 = (em)this.jAv.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new em();
        ((em)localObject1).type = 5;
        localObject2 = ((em)localObject1).Cvr;
        ep localep = new ep();
        localep.key = "EventType";
        localep.gPh = paramString;
        ((LinkedList)localObject2).add(localep);
        localObject2 = ((em)localObject1).Cvr;
        localep = new ep();
        localep.key = "StartTime";
        localep.gPh = String.valueOf(System.currentTimeMillis());
        ((LinkedList)localObject2).add(localep);
        ((Map)this.jAv).put(paramString, localObject1);
      }
      AppMethodBeat.o(193360);
      return localObject1;
    }
    
    public final void Qd(String paramString)
    {
      AppMethodBeat.i(193361);
      k.h(paramString, "event");
      paramString = (em)this.jAv.get(paramString);
      if (paramString != null)
      {
        j localj = j.nlE;
        j.a(paramString, this);
        AppMethodBeat.o(193361);
        return;
      }
      AppMethodBeat.o(193361);
    }
    
    public final void bGq()
    {
      AppMethodBeat.i(193359);
      this.nlN.clear();
      this.jAv.clear();
      AppMethodBeat.o(193359);
    }
    
    public final void report()
    {
      AppMethodBeat.i(193362);
      ((d.g.a.a)new c(this)).invoke();
      en localen = new en();
      em localem = new em();
      localem.type = 5;
      LinkedList localLinkedList = localem.Cvr;
      ep localep = new ep();
      localep.key = "DeviceModel";
      Object localObject2 = this.fVv;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localep = new ep();
      localep.key = "DeviceBrand";
      localObject2 = this.fVw;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localep = new ep();
      localep.key = "OsName";
      localObject2 = this.fVx;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localep = new ep();
      localep.key = "OsVersion";
      localObject2 = this.fVy;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localep = new ep();
      localep.key = "LanguageVersion";
      localObject2 = this.nlF;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localep = new ep();
      localep.key = "NetType";
      localObject2 = this.nlG;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localep = new ep();
      localep.key = "EnterId";
      localObject2 = this.nlH;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localep = new ep();
      localep.key = "EnterPageId";
      localObject2 = this.nlI;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localep = new ep();
      localep.key = "AppMsgUrl";
      localObject2 = this.nlJ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localep = new ep();
      localep.key = "Vid";
      localObject2 = this.nlK;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localep = new ep();
      localep.key = "Scene";
      localObject2 = this.nlL;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localep = new ep();
      localep.key = "SubScene";
      localObject2 = this.nlM;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localep.gPh = ((String)localObject1);
      localLinkedList.add(localep);
      localen.CyN = localem;
      localObject1 = ((Iterable)this.nlN).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (em)((Iterator)localObject1).next();
        localen.CyM.add(localObject2);
      }
      localObject1 = new b.a();
      ((b.a)localObject1).c((com.tencent.mm.bx.a)localen);
      ((b.a)localObject1).d((com.tencent.mm.bx.a)new eo());
      ((b.a)localObject1).wg("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
      ((b.a)localObject1).nB(1870);
      ((b.a)localObject1).nD(0);
      ((b.a)localObject1).nE(0);
      IPCRunCgi.a(((b.a)localObject1).atI(), (IPCRunCgi.a)j.a.b.nlP);
      ad.i("MicroMsg.BizVideoProfiler", " report instance = ".concat(String.valueOf(this)));
      bGq();
      AppMethodBeat.o(193362);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j
 * JD-Core Version:    0.7.0.1
 */