package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler;", "", "()V", "END", "", "EVENT_CGI_SUCCESS", "", "EVENT_CLOSE_PAGE", "EVENT_ENTER_PAGE", "EVENT_FULLSCREEN", "EVENT_GETA8KEY", "EVENT_INSERT_VIDEO", "EVENT_MORE_VIDEO", "EVENT_ONREADY", "EVENT_PLAYER_ERROR", "EVENT_PLAYER_FIRST_DOWNLOAD", "EVENT_PLAYER_FIRST_PREPARE", "EVENT_PLAYER_LAG", "EVENT_PLAYER_PAUSE", "EVENT_PLAYER_PLAY", "EVENT_PLAYER_READY_PLAY", "EVENT_PLAYER_SEEK", "EVENT_PLAYER_SPEED", "EVENT_START_PLAYER", "EVENT_SWITCH_RESOLUTION", "START", "TAG", "initViewSelf", "insertVideoNativeView", "instanceMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "Lkotlin/collections/HashMap;", "getInstanceMap", "()Ljava/util/HashMap;", "nameToTime", "", "onAppMsgGet", "onAppMsgGetProcess", "onMediaPlayerPrepared", "onPageFinished", "onResetAfterCreateSelf", "onResetAfterCreateSuper", "onResetBeforeCreate", "onResumeSelf", "onStartSelf", "onSurfaceTextureAvailable", "postBindedSelf", "setDataSource", "startTime", "clearInstance", "", "key", "enterTime", "end", "getInstance", "resetTrace", "traceTime", "name", "addEvent", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "ins", "endTime", "addItem", "value", "toInfoString", "Instance", "plugin-brandservice_release"})
public final class j
{
  private static final HashMap<String, Long> pLi;
  private static final HashMap<String, a> pLj;
  public static final j pLk;
  
  static
  {
    AppMethodBeat.i(195987);
    pLk = new j();
    pLi = new HashMap();
    pLj = new HashMap();
    AppMethodBeat.o(195987);
  }
  
  public static void a(ff paramff, a parama, String paramString)
  {
    AppMethodBeat.i(195982);
    p.h(paramff, "$this$addEvent");
    p.h(paramString, "endTime");
    String str = "";
    Object localObject1 = paramff.KEQ;
    p.g(localObject1, "item");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (fi)((Iterator)localObject1).next();
      if (p.j(((fi)localObject2).key, "EventType"))
      {
        str = ((fi)localObject2).iFF;
        p.g(str, "it.`val`");
      }
    }
    if ((p.j(str, "") ^ true))
    {
      localObject2 = paramff.KEQ;
      fi localfi = new fi();
      localfi.key = "EndTime";
      localObject1 = paramString;
      if (p.j(paramString, "")) {
        localObject1 = String.valueOf(System.currentTimeMillis());
      }
      localfi.iFF = ((String)localObject1);
      ((LinkedList)localObject2).add(localfi);
      if (parama != null)
      {
        paramString = parama.pLt;
        if (paramString != null) {
          paramString.add(paramff);
        }
      }
      if (parama != null)
      {
        paramff = parama.lCV;
        if (paramff != null)
        {
          paramff.remove(str);
          AppMethodBeat.o(195982);
          return;
        }
      }
    }
    AppMethodBeat.o(195982);
  }
  
  public static void a(ff paramff, String paramString1, String paramString2)
  {
    AppMethodBeat.i(195984);
    p.h(paramff, "$this$addItem");
    p.h(paramString1, "key");
    p.h(paramString2, "value");
    paramff = paramff.KEQ;
    fi localfi = new fi();
    localfi.key = paramString1;
    localfi.iFF = paramString2;
    paramff.add(localfi);
    AppMethodBeat.o(195984);
  }
  
  public static a aiP(String paramString)
  {
    AppMethodBeat.i(195985);
    p.h(paramString, "key");
    if (pLj.get(paramString) == null)
    {
      ((Map)pLj).put(paramString, new a());
      Log.i("MicroMsg.BizVideoProfiler", " getInstance null, create " + (a)pLj.get(paramString));
    }
    paramString = pLj.get(paramString);
    if (paramString == null) {
      p.hyc();
    }
    paramString = (a)paramString;
    AppMethodBeat.o(195985);
    return paramString;
  }
  
  public static void aiQ(String paramString)
  {
    AppMethodBeat.i(195986);
    p.h(paramString, "key");
    if (!pLj.containsKey(paramString))
    {
      AppMethodBeat.o(195986);
      return;
    }
    pLj.remove(paramString);
    AppMethodBeat.o(195986);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "", "()V", "AppMsgUrl", "", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "(Ljava/lang/String;)V", "DeviceBrand", "getDeviceBrand", "setDeviceBrand", "DeviceModel", "getDeviceModel", "setDeviceModel", "EnterId", "getEnterId", "setEnterId", "EnterPageId", "getEnterPageId", "setEnterPageId", "LanguageVersion", "getLanguageVersion", "setLanguageVersion", "NetType", "getNetType", "setNetType", "OsName", "getOsName", "setOsName", "OsVersion", "getOsVersion", "setOsVersion", "Scene", "getScene", "setScene", "SubScene", "getSubScene", "setSubScene", "Vid", "getVid", "setVid", "eventItem", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "getEventItem", "()Ljava/util/LinkedList;", "eventMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEventMap", "()Ljava/util/HashMap;", "addPerformanceData", "", "performance", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "clearEvent", "getEvent", "event", "report", "tryToAddEvent", "toInfoString", "plugin-brandservice_release"})
  public static final class a
  {
    String hid;
    String hie;
    String hif;
    String hig;
    final HashMap<String, ff> lCV;
    String pLl;
    String pLm;
    public String pLn;
    public String pLo;
    public String pLp;
    public String pLq;
    public String pLr;
    public String pLs;
    public final LinkedList<ff> pLt;
    
    public a()
    {
      AppMethodBeat.i(195981);
      this.hid = "";
      this.hie = "";
      this.hif = "";
      this.hig = "";
      this.pLl = "";
      this.pLm = "-1";
      this.pLn = "";
      this.pLo = "";
      this.pLp = "";
      this.pLq = "";
      this.pLr = "";
      this.pLs = "";
      this.pLt = new LinkedList();
      this.lCV = new HashMap();
      AppMethodBeat.o(195981);
    }
    
    public final ff aiR(String paramString)
    {
      AppMethodBeat.i(195978);
      p.h(paramString, "event");
      Object localObject2 = (ff)this.lCV.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ff();
        ((ff)localObject1).type = 5;
        localObject2 = ((ff)localObject1).KEQ;
        fi localfi = new fi();
        localfi.key = "EventType";
        localfi.iFF = paramString;
        ((LinkedList)localObject2).add(localfi);
        localObject2 = ((ff)localObject1).KEQ;
        localfi = new fi();
        localfi.key = "StartTime";
        localfi.iFF = String.valueOf(System.currentTimeMillis());
        ((LinkedList)localObject2).add(localfi);
        ((Map)this.lCV).put(paramString, localObject1);
      }
      AppMethodBeat.o(195978);
      return localObject1;
    }
    
    public final void aiS(String paramString)
    {
      AppMethodBeat.i(195979);
      p.h(paramString, "event");
      paramString = (ff)this.lCV.get(paramString);
      if (paramString != null)
      {
        j localj = j.pLk;
        j.a(paramString, this);
        AppMethodBeat.o(195979);
        return;
      }
      AppMethodBeat.o(195979);
    }
    
    public final void cra()
    {
      AppMethodBeat.i(195977);
      this.pLt.clear();
      this.lCV.clear();
      AppMethodBeat.o(195977);
    }
    
    public final void report()
    {
      AppMethodBeat.i(195980);
      ((kotlin.g.a.a)new c(this)).invoke();
      fg localfg = new fg();
      ff localff = new ff();
      localff.type = 5;
      LinkedList localLinkedList = localff.KEQ;
      fi localfi = new fi();
      localfi.key = "DeviceModel";
      Object localObject2 = this.hid;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfi = new fi();
      localfi.key = "DeviceBrand";
      localObject2 = this.hie;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfi = new fi();
      localfi.key = "OsName";
      localObject2 = this.hif;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfi = new fi();
      localfi.key = "OsVersion";
      localObject2 = this.hig;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfi = new fi();
      localfi.key = "LanguageVersion";
      localObject2 = this.pLl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfi = new fi();
      localfi.key = "NetType";
      localObject2 = this.pLm;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfi = new fi();
      localfi.key = "EnterId";
      localObject2 = this.pLn;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfi = new fi();
      localfi.key = "EnterPageId";
      localObject2 = this.pLo;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfi = new fi();
      localfi.key = "AppMsgUrl";
      localObject2 = this.pLp;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfi = new fi();
      localfi.key = "Vid";
      localObject2 = this.pLq;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfi = new fi();
      localfi.key = "Scene";
      localObject2 = this.pLr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfi = new fi();
      localfi.key = "SubScene";
      localObject2 = this.pLs;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localfi.iFF = ((String)localObject1);
      localLinkedList.add(localfi);
      localfg.KIH = localff;
      localObject1 = ((Iterable)this.pLt).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ff)((Iterator)localObject1).next();
        localfg.KIG.add(localObject2);
      }
      localObject1 = new d.a();
      ((d.a)localObject1).c((com.tencent.mm.bw.a)localfg);
      ((d.a)localObject1).d((com.tencent.mm.bw.a)new fh());
      ((d.a)localObject1).MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
      ((d.a)localObject1).sG(1870);
      ((d.a)localObject1).sI(0);
      ((d.a)localObject1).sJ(0);
      IPCRunCgi.a(((d.a)localObject1).aXF(), (IPCRunCgi.a)j.a.b.pLv);
      Log.i("MicroMsg.BizVideoProfiler", " report instance = ".concat(String.valueOf(this)));
      cra();
      AppMethodBeat.o(195980);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(j.a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j
 * JD-Core Version:    0.7.0.1
 */