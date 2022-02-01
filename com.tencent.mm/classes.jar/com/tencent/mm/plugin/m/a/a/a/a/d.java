package com.tencent.mm.plugin.m.a.a.a.a;

import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.m.a.a.a.a.a;
import com.tencent.mm.plugin.m.a.a.a.a.b;
import d.g.b.k;
import d.l;
import d.v;
import io.flutter.a.a.j;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/WxaChannelService;", "", "channelName", "", "(Ljava/lang/String;)V", "handler", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "getHandler", "()Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "handlers", "", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/IMethodCallHandler;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "dumpRenderTree", "", "dumpWidgetTree", "init", "renderViewManager", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;", "notifyKeyboardChanged", "shown", "", "height", "", "onBackground", "arguments", "onCreate", "onDestroy", "onForeground", "pickerSelectCallback", "registerHandler", "scheduleFrame", "scrollToTop", "", "sendFilesInfo", "luggage-native-view_release"})
public final class d
{
  public c kTU;
  public final String trd;
  public final k.c trp;
  final Map<String, a> jdField_try;
  
  public d(String paramString)
  {
    AppMethodBeat.i(123840);
    this.trd = paramString;
    this.jdField_try = ((Map)new LinkedHashMap());
    this.trp = ((k.c)new a(this));
    AppMethodBeat.o(123840);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(123835);
    Iterator localIterator = parama.cMX().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((a)this.jdField_try.get(str) != null)
      {
        parama = (Throwable)new RuntimeException(str + "'s handler exist");
        AppMethodBeat.o(123835);
        throw parama;
      }
      this.jdField_try.put(str, parama);
    }
    AppMethodBeat.o(123835);
  }
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(123839);
    a.b localb = com.tencent.mm.plugin.m.a.a.a.a.tro;
    com.tencent.mm.plugin.m.a.a.a.a.cMW().f(this.trd, "onCreate", paramObject);
    AppMethodBeat.o(123839);
  }
  
  public final void bc(Object paramObject)
  {
    AppMethodBeat.i(123838);
    a.b localb = com.tencent.mm.plugin.m.a.a.a.a.tro;
    com.tencent.mm.plugin.m.a.a.a.a.cMW().f(this.trd, "onDestroy", paramObject);
    AppMethodBeat.o(123838);
  }
  
  public final void dk(Object paramObject)
  {
    AppMethodBeat.i(123836);
    a.b localb = com.tencent.mm.plugin.m.a.a.a.a.tro;
    com.tencent.mm.plugin.m.a.a.a.a.cMW().f(this.trd, "onForeground", paramObject);
    AppMethodBeat.o(123836);
  }
  
  public final void dl(Object paramObject)
  {
    AppMethodBeat.i(123837);
    a.b localb = com.tencent.mm.plugin.m.a.a.a.a.tro;
    com.tencent.mm.plugin.m.a.a.a.a.cMW().f(this.trd, "onBackground", paramObject);
    AppMethodBeat.o(123837);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onMethodCall"})
  static final class a
    implements k.c
  {
    a(d paramd) {}
    
    public final void a(j paramj, k.d paramd)
    {
      AppMethodBeat.i(123834);
      k.h(paramj, "methodCall");
      k.h(paramd, "result");
      Object localObject1 = (a)this.trz.jdField_try.get(paramj.method);
      if (localObject1 != null) {
        ((a)localObject1).d(paramj, paramd);
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
                        } while ((!((String)localObject1).equals("inputLocationChange")) || (!(paramj.fTP instanceof Map)));
                        paramj = paramj.fTP;
                        if (paramj != null) {
                          break;
                        }
                        paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                        AppMethodBeat.o(123834);
                        throw paramj;
                      } while ((!((String)localObject1).equals("hideKeyboard")) || (!(paramj.fTP instanceof Map)));
                      paramj = paramj.fTP;
                      if (paramj != null) {
                        break label1145;
                      }
                      paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                      AppMethodBeat.o(123834);
                      throw paramj;
                    } while ((!((String)localObject1).equals("publishEvent")) || (!(paramj.fTP instanceof Map)));
                    paramj = paramj.fTP;
                    if (paramj != null) {
                      break;
                    }
                    paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                    AppMethodBeat.o(123834);
                    throw paramj;
                  } while ((!((String)localObject1).equals("showPicker")) || (!(paramj.fTP instanceof Map)));
                  paramj = paramj.fTP;
                  if (paramj != null) {
                    break label1196;
                  }
                  paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                  AppMethodBeat.o(123834);
                  throw paramj;
                } while ((!((String)localObject1).equals("getLocalFileData")) || (!(paramj.fTP instanceof Map)));
                paramj = paramj.fTP;
                if (paramj != null) {
                  break label1281;
                }
                paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                AppMethodBeat.o(123834);
                throw paramj;
              } while ((!((String)localObject1).equals("inputOnKeyboardValueChange")) || (!(paramj.fTP instanceof Map)));
              paramj = paramj.fTP;
              if (paramj != null) {
                break label931;
              }
              paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
              AppMethodBeat.o(123834);
              throw paramj;
            } while ((!((String)localObject1).equals("setCanOverScroll")) || (!(paramj.fTP instanceof Map)));
            paramj = paramj.fTP;
            if (paramj != null) {
              break label744;
            }
            paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            AppMethodBeat.o(123834);
            throw paramj;
          } while ((!((String)localObject1).equals("onRenderCallback")) || (!(paramj.fTP instanceof Map)));
          paramj = paramj.fTP;
          if (paramj != null) {
            break label1462;
          }
          paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
          AppMethodBeat.o(123834);
          throw paramj;
        } while ((!((String)localObject1).equals("generateInputEventData")) || (!(paramj.fTP instanceof Map)));
        paramj = paramj.fTP;
        if (paramj == null)
        {
          paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
          AppMethodBeat.o(123834);
          throw paramj;
          paramj = (Map)paramj;
          paramd = com.tencent.mm.plugin.m.a.a.a.trf;
          paramd = (a.a.a)com.tencent.mm.plugin.m.a.a.a.cMU().get(paramj.get("viewId"));
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
            paramd.b(i, (String)localObject1, (Map)paramj);
            AppMethodBeat.o(123834);
            return;
          }
          AppMethodBeat.o(123834);
          return;
          paramj = (Map)paramj;
          paramd = com.tencent.mm.plugin.m.a.a.a.trf;
          paramd = (a.a.a)com.tencent.mm.plugin.m.a.a.a.cMU().get(paramj.get("viewId"));
          if (paramd != null)
          {
            paramj = paramj.get("enable");
            if (paramj == null)
            {
              paramj = new v("null cannot be cast to non-null type kotlin.Boolean");
              AppMethodBeat.o(123834);
              throw paramj;
            }
            paramd.mG(((Boolean)paramj).booleanValue());
            AppMethodBeat.o(123834);
            return;
          }
          AppMethodBeat.o(123834);
          return;
        }
        paramj = (Map)paramj;
        localObject1 = com.tencent.mm.plugin.m.a.a.a.trf;
        localObject1 = (a.a.a)com.tencent.mm.plugin.m.a.a.a.cMU().get(paramj.get("viewId"));
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
        for (paramj = ((a.a.a)localObject1).FD(((Integer)paramj).intValue());; paramj = null)
        {
          paramd.ay(paramj);
          AppMethodBeat.o(123834);
          return;
        }
        paramj = (Map)paramj;
        paramd = com.tencent.mm.plugin.m.a.a.a.trf;
        paramd = (a.a.a)com.tencent.mm.plugin.m.a.a.a.cMU().get(paramj.get("viewId"));
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
          paramd.ac((Map)paramj);
          AppMethodBeat.o(123834);
          return;
        }
        AppMethodBeat.o(123834);
        return;
        paramj = (Map)paramj;
        paramd = com.tencent.mm.plugin.m.a.a.a.trf;
        paramd = (a.a.a)com.tencent.mm.plugin.m.a.a.a.cMU().get(paramj.get("viewId"));
        if (paramd != null)
        {
          paramj = paramj.get("offset");
          if (paramj == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(123834);
            throw paramj;
          }
          paramd.FE(((Integer)paramj).intValue());
          AppMethodBeat.o(123834);
          return;
        }
        AppMethodBeat.o(123834);
        return;
        paramj = (Map)paramj;
        paramd = com.tencent.mm.plugin.m.a.a.a.trf;
        paramj = (a.a.a)com.tencent.mm.plugin.m.a.a.a.cMU().get(paramj.get("viewId"));
        if (paramj != null)
        {
          paramj.cJe();
          AppMethodBeat.o(123834);
          return;
        }
        AppMethodBeat.o(123834);
        return;
        paramj = (Map)paramj;
        paramd = com.tencent.mm.plugin.m.a.a.a.trf;
        paramd = (a.a.a)com.tencent.mm.plugin.m.a.a.a.cMU().get(paramj.get("viewId"));
        if (paramd != null)
        {
          paramj = paramj.get("detail");
          if (paramj == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
            AppMethodBeat.o(123834);
            throw paramj;
          }
          paramd.ad((Map)paramj);
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
        if (!d.n.n.mA((String)localObject1, "wxfile"))
        {
          paramj = (Throwable)new d.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
          AppMethodBeat.o(123834);
          throw paramj;
        }
        paramj = new i();
        Object localObject2 = this.trz.kTU;
        if (localObject2 != null)
        {
          localObject2 = ((c)localObject2).DW();
          if (localObject2 != null) {
            ((ar)localObject2).b((String)localObject1, paramj);
          }
        }
        if (paramj.value != null)
        {
          localObject1 = new byte[((ByteBuffer)paramj.value).remaining()];
          ((ByteBuffer)paramj.value).get((byte[])localObject1);
          paramd.ay(localObject1);
          AppMethodBeat.o(123834);
          return;
        }
        paramd.ay(null);
        AppMethodBeat.o(123834);
        return;
        paramj = (Map)paramj;
        paramd = com.tencent.mm.plugin.m.a.a.a.trf;
        paramj = (a.a.a)com.tencent.mm.plugin.m.a.a.a.cMU().get(paramj.get("viewId"));
      } while (paramj == null);
      label931:
      label1196:
      label1462:
      paramj.cJf();
      label1281:
      AppMethodBeat.o(123834);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */