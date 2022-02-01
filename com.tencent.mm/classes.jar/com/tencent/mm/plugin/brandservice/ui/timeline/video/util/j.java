package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler;", "", "()V", "END", "", "EVENT_CGI_SUCCESS", "", "EVENT_CLOSE_PAGE", "EVENT_ENTER_PAGE", "EVENT_FULLSCREEN", "EVENT_GETA8KEY", "EVENT_INSERT_VIDEO", "EVENT_MORE_VIDEO", "EVENT_ONREADY", "EVENT_PLAYER_ERROR", "EVENT_PLAYER_FIRST_DOWNLOAD", "EVENT_PLAYER_FIRST_PREPARE", "EVENT_PLAYER_LAG", "EVENT_PLAYER_PAUSE", "EVENT_PLAYER_PLAY", "EVENT_PLAYER_READY_PLAY", "EVENT_PLAYER_SEEK", "EVENT_PLAYER_SPEED", "EVENT_START_PLAYER", "EVENT_SWITCH_RESOLUTION", "START", "TAG", "initViewSelf", "insertVideoNativeView", "instanceMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "Lkotlin/collections/HashMap;", "getInstanceMap", "()Ljava/util/HashMap;", "nameToTime", "", "onAppMsgGet", "onAppMsgGetProcess", "onMediaPlayerPrepared", "onPageFinished", "onResetAfterCreateSelf", "onResetAfterCreateSuper", "onResetBeforeCreate", "onResumeSelf", "onStartSelf", "onSurfaceTextureAvailable", "postBindedSelf", "setDataSource", "startTime", "clearInstance", "", "key", "enterTime", "end", "getInstance", "resetTrace", "traceTime", "name", "addEvent", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "ins", "endTime", "addItem", "value", "toInfoString", "Instance", "plugin-brandservice_release"})
public final class j
{
  private static final HashMap<String, Long> ori;
  private static final HashMap<String, a> orj;
  public static final j ork;
  
  static
  {
    AppMethodBeat.i(210130);
    ork = new j();
    ori = new HashMap();
    orj = new HashMap();
    AppMethodBeat.o(210130);
  }
  
  public static a XV(String paramString)
  {
    AppMethodBeat.i(210128);
    p.h(paramString, "key");
    if (orj.get(paramString) == null)
    {
      ((Map)orj).put(paramString, new a());
      ad.i("MicroMsg.BizVideoProfiler", " getInstance null, create " + (a)orj.get(paramString));
    }
    paramString = orj.get(paramString);
    if (paramString == null) {
      p.gfZ();
    }
    paramString = (a)paramString;
    AppMethodBeat.o(210128);
    return paramString;
  }
  
  public static void XW(String paramString)
  {
    AppMethodBeat.i(210129);
    p.h(paramString, "key");
    if (!orj.containsKey(paramString))
    {
      AppMethodBeat.o(210129);
      return;
    }
    orj.remove(paramString);
    AppMethodBeat.o(210129);
  }
  
  public static void a(es parames, a parama, String paramString)
  {
    AppMethodBeat.i(210125);
    p.h(parames, "$this$addEvent");
    p.h(paramString, "endTime");
    String str = "";
    Object localObject1 = parames.FsS;
    p.g(localObject1, "item");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ev)((Iterator)localObject1).next();
      if (p.i(((ev)localObject2).key, "EventType"))
      {
        str = ((ev)localObject2).hHZ;
        p.g(str, "it.`val`");
      }
    }
    if ((p.i(str, "") ^ true))
    {
      localObject2 = parames.FsS;
      ev localev = new ev();
      localev.key = "EndTime";
      localObject1 = paramString;
      if (p.i(paramString, "")) {
        localObject1 = String.valueOf(System.currentTimeMillis());
      }
      localev.hHZ = ((String)localObject1);
      ((LinkedList)localObject2).add(localev);
      if (parama != null)
      {
        paramString = parama.ort;
        if (paramString != null) {
          paramString.add(parames);
        }
      }
      if (parama != null)
      {
        parames = parama.kvn;
        if (parames != null)
        {
          parames.remove(str);
          AppMethodBeat.o(210125);
          return;
        }
      }
    }
    AppMethodBeat.o(210125);
  }
  
  public static void a(es parames, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210127);
    p.h(parames, "$this$addItem");
    p.h(paramString1, "key");
    p.h(paramString2, "value");
    parames = parames.FsS;
    ev localev = new ev();
    localev.key = paramString1;
    localev.hHZ = paramString2;
    parames.add(localev);
    AppMethodBeat.o(210127);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "", "()V", "AppMsgUrl", "", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "(Ljava/lang/String;)V", "DeviceBrand", "getDeviceBrand", "setDeviceBrand", "DeviceModel", "getDeviceModel", "setDeviceModel", "EnterId", "getEnterId", "setEnterId", "EnterPageId", "getEnterPageId", "setEnterPageId", "LanguageVersion", "getLanguageVersion", "setLanguageVersion", "NetType", "getNetType", "setNetType", "OsName", "getOsName", "setOsName", "OsVersion", "getOsVersion", "setOsVersion", "Scene", "getScene", "setScene", "SubScene", "getSubScene", "setSubScene", "Vid", "getVid", "setVid", "eventItem", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "getEventItem", "()Ljava/util/LinkedList;", "eventMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEventMap", "()Ljava/util/HashMap;", "addPerformanceData", "", "performance", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "clearEvent", "getEvent", "event", "report", "tryToAddEvent", "toInfoString", "plugin-brandservice_release"})
  public static final class a
  {
    String gsM;
    String gsN;
    String gsO;
    String gsP;
    final HashMap<String, es> kvn;
    String orl;
    String orm;
    public String orn;
    public String oro;
    public String orp;
    public String orq;
    public String orr;
    public String ors;
    public final LinkedList<es> ort;
    
    public a()
    {
      AppMethodBeat.i(210124);
      this.gsM = "";
      this.gsN = "";
      this.gsO = "";
      this.gsP = "";
      this.orl = "";
      this.orm = "-1";
      this.orn = "";
      this.oro = "";
      this.orp = "";
      this.orq = "";
      this.orr = "";
      this.ors = "";
      this.ort = new LinkedList();
      this.kvn = new HashMap();
      AppMethodBeat.o(210124);
    }
    
    public final es XX(String paramString)
    {
      AppMethodBeat.i(210121);
      p.h(paramString, "event");
      Object localObject2 = (es)this.kvn.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new es();
        ((es)localObject1).type = 5;
        localObject2 = ((es)localObject1).FsS;
        ev localev = new ev();
        localev.key = "EventType";
        localev.hHZ = paramString;
        ((LinkedList)localObject2).add(localev);
        localObject2 = ((es)localObject1).FsS;
        localev = new ev();
        localev.key = "StartTime";
        localev.hHZ = String.valueOf(System.currentTimeMillis());
        ((LinkedList)localObject2).add(localev);
        ((Map)this.kvn).put(paramString, localObject1);
      }
      AppMethodBeat.o(210121);
      return localObject1;
    }
    
    public final void XY(String paramString)
    {
      AppMethodBeat.i(210122);
      p.h(paramString, "event");
      paramString = (es)this.kvn.get(paramString);
      if (paramString != null)
      {
        j localj = j.ork;
        j.a(paramString, this);
        AppMethodBeat.o(210122);
        return;
      }
      AppMethodBeat.o(210122);
    }
    
    public final void bSd()
    {
      AppMethodBeat.i(210120);
      this.ort.clear();
      this.kvn.clear();
      AppMethodBeat.o(210120);
    }
    
    public final void report()
    {
      AppMethodBeat.i(210123);
      ((d.g.a.a)new c(this)).invoke();
      et localet = new et();
      es locales = new es();
      locales.type = 5;
      LinkedList localLinkedList = locales.FsS;
      ev localev = new ev();
      localev.key = "DeviceModel";
      Object localObject2 = this.gsM;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "DeviceBrand";
      localObject2 = this.gsN;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "OsName";
      localObject2 = this.gsO;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "OsVersion";
      localObject2 = this.gsP;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "LanguageVersion";
      localObject2 = this.orl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "NetType";
      localObject2 = this.orm;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "EnterId";
      localObject2 = this.orn;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "EnterPageId";
      localObject2 = this.oro;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "AppMsgUrl";
      localObject2 = this.orp;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "Vid";
      localObject2 = this.orq;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "Scene";
      localObject2 = this.orr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localev = new ev();
      localev.key = "SubScene";
      localObject2 = this.ors;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localev.hHZ = ((String)localObject1);
      localLinkedList.add(localev);
      localet.FwB = locales;
      localObject1 = ((Iterable)this.ort).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (es)((Iterator)localObject1).next();
        localet.FwA.add(localObject2);
      }
      localObject1 = new b.a();
      ((b.a)localObject1).c((com.tencent.mm.bx.a)localet);
      ((b.a)localObject1).d((com.tencent.mm.bx.a)new eu());
      ((b.a)localObject1).Dl("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
      ((b.a)localObject1).oP(1870);
      ((b.a)localObject1).oR(0);
      ((b.a)localObject1).oS(0);
      IPCRunCgi.a(((b.a)localObject1).aDC(), (IPCRunCgi.a)j.a.b.orv);
      ad.i("MicroMsg.BizVideoProfiler", " report instance = ".concat(String.valueOf(this)));
      bSd();
      AppMethodBeat.o(210123);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<no name provided>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
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