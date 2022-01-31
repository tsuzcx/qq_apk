package com.tencent.mm.plugin.brandservice;

import a.l;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.p;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "()V", "TAG", "", "bizNativeImgOpen", "", "getBizNativeImgOpen", "()Ljava/lang/Boolean;", "setBizNativeImgOpen", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "bizNativeVideoOpen", "getBizNativeVideoOpen", "setBizNativeVideoOpen", "chatSessions", "Ljava/util/concurrent/ConcurrentHashMap;", "", "addToPreload", "", "url", "itemShowType", "", "openScene", "vals", "", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "canPreloadIn", "getChatSession", "chatName", "getHardCodeUrl", "isBizNativeImgOpen", "isBizNativePageOpen", "isBizNativeVideoOpen", "isBizNativeVoiceOpen", "isBizTimeLineOpen", "isMpUrl", "preCreateWebView", "preloadByIdAndUrls", "items", "", "preloadByInfoIdAndBuffer", "setChatSession", "startPreloadWebView", "context", "Landroid/content/Context;", "isNative", "subScene", "intent", "Landroid/content/Intent;", "openType", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "tryPreloadTmplWebview", "plugin-brandservice_release"})
public final class c
  implements com.tencent.mm.plugin.brandservice.a.b
{
  private final String TAG;
  private Boolean jSt;
  private Boolean jSu;
  private final ConcurrentHashMap<String, Long> jSv;
  
  public c()
  {
    AppMethodBeat.i(14777);
    this.TAG = "MicroMsg.BrandServiceImpl";
    this.jSv = new ConcurrentHashMap();
    AppMethodBeat.o(14777);
  }
  
  public final boolean GI(String paramString)
  {
    AppMethodBeat.i(14765);
    if (paramString != null)
    {
      boolean bool = p.GI(paramString);
      AppMethodBeat.o(14765);
      return bool;
    }
    AppMethodBeat.o(14765);
    return false;
  }
  
  public final void GJ(String paramString)
  {
    AppMethodBeat.i(152674);
    a.f.b.j.q(paramString, "chatName");
    ((Map)this.jSv).put(paramString, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(152674);
  }
  
  public final long GK(String paramString)
  {
    AppMethodBeat.i(152675);
    a.f.b.j.q(paramString, "chatName");
    paramString = (Long)this.jSv.get(paramString);
    if (paramString != null)
    {
      long l = paramString.longValue();
      AppMethodBeat.o(152675);
      return l;
    }
    AppMethodBeat.o(152675);
    return -1L;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(14768);
    a.f.b.j.q(paramString, "url");
    a.f.b.j.q(paramVarArgs, "vals");
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.GQ(paramString);
    PreloadLogic localPreloadLogic = PreloadLogic.kbJ;
    if (PreloadLogic.aXE().GY(str))
    {
      AppMethodBeat.o(14768);
      return;
    }
    localPreloadLogic = PreloadLogic.kbJ;
    PreloadLogic.aXE().xB(str);
    ab.v(this.TAG, "preloadData: addToPreload:".concat(String.valueOf(str)));
    d.ysm.b((Runnable)new c.a(paramString, paramInt1, paramInt2, paramVarArgs), "tmplPreload");
    AppMethodBeat.o(14768);
  }
  
  public final boolean a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(152672);
    a.f.b.j.q(paramContext, "context");
    a.f.b.j.q(paramString, "url");
    a.f.b.j.q(paramIntent, "intent");
    paramBoolean = PreloadLogic.a(paramContext, paramString, paramInt1, paramBoolean, paramInt2, paramInt3, paramIntent, 0, null, false, 896);
    AppMethodBeat.o(152672);
    return paramBoolean;
  }
  
  public final boolean a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean, int paramInt2, Intent paramIntent, int paramInt3, b.a parama)
  {
    AppMethodBeat.i(152673);
    a.f.b.j.q(paramContext, "context");
    a.f.b.j.q(paramString, "url");
    a.f.b.j.q(paramIntent, "intent");
    a.f.b.j.q(parama, "result");
    paramBoolean = PreloadLogic.a(paramContext, paramString, paramInt1, paramBoolean, paramInt2, 0, paramIntent, paramInt3, parama, false, 512);
    AppMethodBeat.o(152673);
    return paramBoolean;
  }
  
  public final boolean aWl()
  {
    AppMethodBeat.i(14766);
    boolean bool = s.aWl();
    AppMethodBeat.o(14766);
    return bool;
  }
  
  public final boolean aWm()
  {
    AppMethodBeat.i(14767);
    if (this.jSu == null) {
      if (((a)g.E(a.class)).a(a.a.lUw, 1) != 1) {
        break label95;
      }
    }
    label95:
    for (boolean bool = true;; bool = false)
    {
      this.jSu = Boolean.valueOf(bool);
      ab.i(this.TAG, "bizNativeVideoOpen: " + this.jSu);
      Boolean localBoolean = this.jSu;
      if (localBoolean == null) {
        a.f.b.j.ebi();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(14767);
      return bool;
    }
  }
  
  public final String aWn()
  {
    AppMethodBeat.i(14775);
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.aXS();
    AppMethodBeat.o(14775);
    return str;
  }
  
  public final void aWo()
  {
    AppMethodBeat.i(14776);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c.aYG();
    AppMethodBeat.o(14776);
  }
  
  public final void i(List<? extends List<String>> paramList, final int paramInt)
  {
    AppMethodBeat.i(14769);
    a.f.b.j.q(paramList, "items");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int i;
    label127:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.GQ((String)((List)localObject2).get(0));
      localObject4 = PreloadLogic.kbJ;
      if (PreloadLogic.aXE().GY((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label127;
        }
        paramList.add(localObject2);
        break;
        localObject4 = PreloadLogic.kbJ;
        PreloadLogic.aXE().xB((String)localObject3);
      }
    }
    paramList = (List)paramList;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      if (ab.getLogLevel() == 0)
      {
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("preloadData: preloadByIdAndUrls:");
        localObject4 = (Iterable)paramList;
        localObject3 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject4));
        localObject4 = ((Iterable)localObject4).iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            ((Collection)localObject3).add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.GQ((String)((List)((Iterator)localObject4).next()).get(0)));
            continue;
            i = 0;
            break;
          }
        }
        ab.v((String)localObject1, (List)localObject3);
      }
      d.ysm.b((Runnable)new b(paramList, this, paramInt), "tmplPreload");
    }
    AppMethodBeat.o(14769);
  }
  
  public final void j(List<String[]> paramList, int paramInt)
  {
    AppMethodBeat.i(152671);
    a.f.b.j.q(paramList, "items");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int i;
    label120:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.GQ(((String[])localObject2)[0]);
      localObject4 = PreloadLogic.kbJ;
      if (PreloadLogic.aXE().GY((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label120;
        }
        paramList.add(localObject2);
        break;
        localObject4 = PreloadLogic.kbJ;
        PreloadLogic.aXE().xB((String)localObject3);
      }
    }
    paramList = (List)paramList;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      if (ab.getLogLevel() == 0)
      {
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("preloadData: preloadByInfoIdAndBuffer:");
        localObject4 = (Iterable)paramList;
        localObject3 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject4));
        localObject4 = ((Iterable)localObject4).iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            ((Collection)localObject3).add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.GQ(((String[])localObject4.next())[0]));
            continue;
            i = 0;
            break;
          }
        }
        ab.v((String)localObject1, (List)localObject3);
      }
      d.ysm.b((Runnable)new c.c(paramList, this, paramInt), "tmplPreload");
    }
    AppMethodBeat.o(152671);
  }
  
  public final boolean rT(int paramInt)
  {
    AppMethodBeat.i(152670);
    if ((paramInt == 5) && (aWm()))
    {
      AppMethodBeat.o(152670);
      return true;
    }
    if (paramInt == 8)
    {
      if (this.jSt == null) {
        if (((a)g.E(a.class)).a(a.a.lUx, 0) != 1) {
          break label124;
        }
      }
      label124:
      for (boolean bool = true;; bool = false)
      {
        this.jSt = Boolean.valueOf(bool);
        ab.i(this.TAG, "bizNativeImgOpen: " + this.jSt);
        Boolean localBoolean = this.jSt;
        if (localBoolean == null) {
          a.f.b.j.ebi();
        }
        if (!localBoolean.booleanValue()) {
          break;
        }
        AppMethodBeat.o(152670);
        return true;
      }
    }
    AppMethodBeat.o(152670);
    return false;
  }
  
  public final boolean rU(int paramInt)
  {
    AppMethodBeat.i(14771);
    boolean bool = PreloadLogic.rU(paramInt);
    AppMethodBeat.o(14771);
    return bool;
  }
  
  public final void rV(int paramInt)
  {
    AppMethodBeat.i(14774);
    PreloadLogic.run(paramInt);
    AppMethodBeat.o(14774);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/brandservice/BrandServiceImpl$preloadByIdAndUrls$2$2"})
  static final class b
    implements Runnable
  {
    b(List paramList, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(152668);
      PreloadLogic.i(this.iRB, paramInt);
      AppMethodBeat.o(152668);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.c
 * JD-Core Version:    0.7.0.1
 */