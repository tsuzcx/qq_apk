package com.tencent.mm.plugin.m.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.m.a.a.a.a.a;
import com.tencent.mm.plugin.m.a.a.a.a.b;
import d.g.b.p;
import d.l;
import d.v;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/WxaChannelService;", "", "channelName", "", "(Ljava/lang/String;)V", "handler", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "getHandler", "()Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "handlers", "", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/IMethodCallHandler;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "dumpRenderTree", "", "dumpWidgetTree", "init", "renderViewManager", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;", "notifyKeyboardChanged", "shown", "", "height", "", "onBackground", "arguments", "onCreate", "onDestroy", "onForeground", "pickerSelectCallback", "registerHandler", "scheduleFrame", "scrollToTop", "", "sendFilesInfo", "luggage-native-view_release"})
public final class d
{
  public com.tencent.luggage.sdk.d.d lZl;
  public final String vOc;
  public final k.c vOo;
  final Map<String, a> vOz;
  
  public d(String paramString)
  {
    AppMethodBeat.i(123840);
    this.vOc = paramString;
    this.vOz = ((Map)new LinkedHashMap());
    this.vOo = ((k.c)new a(this));
    AppMethodBeat.o(123840);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(123835);
    Iterator localIterator = parama.dmR().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((a)this.vOz.get(str) != null)
      {
        parama = (Throwable)new RuntimeException(str + "'s handler exist");
        AppMethodBeat.o(123835);
        throw parama;
      }
      this.vOz.put(str, parama);
    }
    AppMethodBeat.o(123835);
  }
  
  public final void dq(Object paramObject)
  {
    AppMethodBeat.i(123837);
    a.b localb = com.tencent.mm.plugin.m.a.a.a.a.vOn;
    com.tencent.mm.plugin.m.a.a.a.a.dmP().g(this.vOc, "onBackground", paramObject);
    AppMethodBeat.o(123837);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onMethodCall"})
  static final class a
    implements k.c
  {
    a(d paramd) {}
    
    public final void a(j paramj, k.d paramd)
    {
      AppMethodBeat.i(123834);
      p.h(paramj, "methodCall");
      p.h(paramd, "result");
      Object localObject1 = (a)this.vOA.vOz.get(paramj.method);
      if (localObject1 != null) {
        ((a)localObject1).b(paramj, paramd);
      }
      localObject1 = paramj.method;
      if (localObject1 == null)
      {
        AppMethodBeat.o(123834);
        return;
      }
      switch (((String)localObject1).hashCode())
      {
      }
      label744:
      label1145:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          AppMethodBeat.o(123834);
                          return;
                        } while ((!((String)localObject1).equals("inputLocationChange")) || (!(paramj.gtF instanceof Map)));
                        paramj = paramj.gtF;
                        if (paramj != null) {
                          break;
                        }
                        paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                        AppMethodBeat.o(123834);
                        throw paramj;
                      } while ((!((String)localObject1).equals("hideKeyboard")) || (!(paramj.gtF instanceof Map)));
                      paramj = paramj.gtF;
                      if (paramj != null) {
                        break label1145;
                      }
                      paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                      AppMethodBeat.o(123834);
                      throw paramj;
                    } while ((!((String)localObject1).equals("publishEvent")) || (!(paramj.gtF instanceof Map)));
                    paramj = paramj.gtF;
                    if (paramj != null) {
                      break;
                    }
                    paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                    AppMethodBeat.o(123834);
                    throw paramj;
                  } while ((!((String)localObject1).equals("showPicker")) || (!(paramj.gtF instanceof Map)));
                  paramj = paramj.gtF;
                  if (paramj != null) {
                    break label1196;
                  }
                  paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                  AppMethodBeat.o(123834);
                  throw paramj;
                } while ((!((String)localObject1).equals("getLocalFileData")) || (!(paramj.gtF instanceof Map)));
                paramj = paramj.gtF;
                if (paramj != null) {
                  break label1281;
                }
                paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                AppMethodBeat.o(123834);
                throw paramj;
              } while ((!((String)localObject1).equals("inputOnKeyboardValueChange")) || (!(paramj.gtF instanceof Map)));
              paramj = paramj.gtF;
              if (paramj != null) {
                break label931;
              }
              paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
              AppMethodBeat.o(123834);
              throw paramj;
            } while ((!((String)localObject1).equals("setCanOverScroll")) || (!(paramj.gtF instanceof Map)));
            paramj = paramj.gtF;
            if (paramj != null) {
              break label744;
            }
            paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            AppMethodBeat.o(123834);
            throw paramj;
          } while ((!((String)localObject1).equals("onRenderCallback")) || (!(paramj.gtF instanceof Map)));
          paramj = paramj.gtF;
          if (paramj != null) {
            break label1462;
          }
          paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
          AppMethodBeat.o(123834);
          throw paramj;
        } while ((!((String)localObject1).equals("generateInputEventData")) || (!(paramj.gtF instanceof Map)));
        paramj = paramj.gtF;
        if (paramj == null)
        {
          paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
          AppMethodBeat.o(123834);
          throw paramj;
          paramj = (Map)paramj;
          paramd = com.tencent.mm.plugin.m.a.a.a.vOe;
          paramd = (a.a.a)com.tencent.mm.plugin.m.a.a.a.dmN().get(paramj.get("viewId"));
          if (paramd != null)
          {
            localObject1 = paramj.get("id");
            if (localObject1 == null)
            {
              paramj = new v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(123834);
              throw paramj;
            }
            int i = ((Integer)localObject1).intValue();
            localObject1 = paramj.get("eventName");
            if (localObject1 == null)
            {
              paramj = new v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(123834);
              throw paramj;
            }
            localObject1 = (String)localObject1;
            paramj = paramj.get("detail");
            if (paramj == null)
            {
              paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Float>");
              AppMethodBeat.o(123834);
              throw paramj;
            }
            paramd.c(i, (String)localObject1, (Map)paramj);
            AppMethodBeat.o(123834);
            return;
          }
          AppMethodBeat.o(123834);
          return;
          paramj = (Map)paramj;
          paramd = com.tencent.mm.plugin.m.a.a.a.vOe;
          paramd = (a.a.a)com.tencent.mm.plugin.m.a.a.a.dmN().get(paramj.get("viewId"));
          if (paramd != null)
          {
            paramj = paramj.get("enable");
            if (paramj == null)
            {
              paramj = new v("null cannot be cast to non-null type kotlin.Boolean");
              AppMethodBeat.o(123834);
              throw paramj;
            }
            paramd.om(((Boolean)paramj).booleanValue());
            AppMethodBeat.o(123834);
            return;
          }
          AppMethodBeat.o(123834);
          return;
        }
        paramj = (Map)paramj;
        localObject1 = com.tencent.mm.plugin.m.a.a.a.vOe;
        localObject1 = (a.a.a)com.tencent.mm.plugin.m.a.a.a.dmN().get(paramj.get("viewId"));
        if (localObject1 != null)
        {
          paramj = paramj.get("id");
          if (paramj == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(123834);
            throw paramj;
          }
        }
        for (paramj = ((a.a.a)localObject1).Ka(((Integer)paramj).intValue());; paramj = null)
        {
          paramd.df(paramj);
          AppMethodBeat.o(123834);
          return;
        }
        paramj = (Map)paramj;
        paramd = com.tencent.mm.plugin.m.a.a.a.vOe;
        paramd = (a.a.a)com.tencent.mm.plugin.m.a.a.a.dmN().get(paramj.get("viewId"));
        if (paramd != null)
        {
          localObject1 = paramj.get("id");
          if (localObject1 == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(123834);
            throw paramj;
          }
          ((Integer)localObject1).intValue();
          paramj = paramj.get("detail");
          if (paramj == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
            AppMethodBeat.o(123834);
            throw paramj;
          }
          paramd.ap((Map)paramj);
          AppMethodBeat.o(123834);
          return;
        }
        AppMethodBeat.o(123834);
        return;
        paramj = (Map)paramj;
        paramd = com.tencent.mm.plugin.m.a.a.a.vOe;
        paramd = (a.a.a)com.tencent.mm.plugin.m.a.a.a.dmN().get(paramj.get("viewId"));
        if (paramd != null)
        {
          paramj = paramj.get("offset");
          if (paramj == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(123834);
            throw paramj;
          }
          paramd.Jt(((Integer)paramj).intValue());
          AppMethodBeat.o(123834);
          return;
        }
        AppMethodBeat.o(123834);
        return;
        paramj = (Map)paramj;
        paramd = com.tencent.mm.plugin.m.a.a.a.vOe;
        paramj = (a.a.a)com.tencent.mm.plugin.m.a.a.a.dmN().get(paramj.get("viewId"));
        if (paramj != null)
        {
          paramj.diG();
          AppMethodBeat.o(123834);
          return;
        }
        AppMethodBeat.o(123834);
        return;
        paramj = (Map)paramj;
        paramd = com.tencent.mm.plugin.m.a.a.a.vOe;
        paramd = (a.a.a)com.tencent.mm.plugin.m.a.a.a.dmN().get(paramj.get("viewId"));
        if (paramd != null)
        {
          paramj = paramj.get("detail");
          if (paramj == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
            AppMethodBeat.o(123834);
            throw paramj;
          }
          paramd.aq((Map)paramj);
          AppMethodBeat.o(123834);
          return;
        }
        AppMethodBeat.o(123834);
        return;
        paramj = ((Map)paramj).get("filePath");
        if (paramj == null)
        {
          paramj = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(123834);
          throw paramj;
        }
        localObject1 = (String)paramj;
        if (!d.n.n.nF((String)localObject1, "wxfile"))
        {
          paramj = (Throwable)new d.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
          AppMethodBeat.o(123834);
          throw paramj;
        }
        paramj = new i();
        Object localObject2 = this.vOA.lZl;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.luggage.sdk.d.d)localObject2).Fd();
          if (localObject2 != null) {
            ((at)localObject2).b((String)localObject1, paramj);
          }
        }
        if (paramj.value != null)
        {
          localObject1 = new byte[((ByteBuffer)paramj.value).remaining()];
          ((ByteBuffer)paramj.value).get((byte[])localObject1);
          paramd.df(localObject1);
          AppMethodBeat.o(123834);
          return;
        }
        paramd.df(null);
        AppMethodBeat.o(123834);
        return;
        paramj = (Map)paramj;
        paramd = com.tencent.mm.plugin.m.a.a.a.vOe;
        paramj = (a.a.a)com.tencent.mm.plugin.m.a.a.a.dmN().get(paramj.get("viewId"));
      } while (paramj == null);
      label931:
      label1196:
      label1462:
      paramj.dmK();
      label1281:
      AppMethodBeat.o(123834);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */