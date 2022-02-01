package com.tencent.mm.plugin.flutter.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.plugin.flutter.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MethodCallToFlutter;", "", "()V", "TAG", "", "dispatchMethod", "", "methodName", "parameter", "Companion", "plugin-flutter_release"})
public final class o
{
  private static o wKH;
  public static final a wKI;
  private final String TAG = "MethodCallToFlutter";
  
  static
  {
    AppMethodBeat.i(241116);
    wKI = new a((byte)0);
    AppMethodBeat.o(241116);
  }
  
  public final void t(final String paramString, Object paramObject)
  {
    AppMethodBeat.i(241115);
    p.h(paramString, "methodName");
    p.h(paramObject, "parameter");
    try
    {
      Object localObject = g.ah(PluginFlutter.class);
      p.g(localObject, "MMKernel.plugin(PluginFlutter::class.java)");
      localObject = ((PluginFlutter)localObject).getFlutterEngineMgr().wJm;
      if (localObject == null) {
        p.hyc();
      }
      ((k)localObject).a(paramString, paramObject, (k.d)new b(this, paramString));
      AppMethodBeat.o(241115);
      return;
    }
    catch (Exception paramObject)
    {
      Log.e(this.TAG, "invoke error " + paramString + " " + paramObject.getLocalizedMessage());
      AppMethodBeat.o(241115);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MethodCallToFlutter$Companion;", "", "()V", "mInstance", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/MethodCallToFlutter;", "getInstance", "plugin-flutter_release"})
  public static final class a
  {
    public static o dMh()
    {
      AppMethodBeat.i(241111);
      if (o.dMg() == null) {
        o.b(new o((byte)0));
      }
      o localo = o.dMg();
      if (localo == null) {
        p.hyc();
      }
      AppMethodBeat.o(241111);
      return localo;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/flutter/plugins/video/api/MethodCallToFlutter$dispatchMethod$1", "Lio/flutter/plugin/common/MethodChannel$Result;", "error", "", "p0", "", "p1", "p2", "", "notImplemented", "success", "plugin-flutter_release"})
  public static final class b
    implements k.d
  {
    b(String paramString) {}
    
    public final void b(String paramString1, String paramString2, Object paramObject)
    {
      AppMethodBeat.i(241113);
      Log.i(o.a(this.wKJ), "callback to flutter error " + paramString1 + ' ' + paramString2);
      AppMethodBeat.o(241113);
    }
    
    public final void ba(Object paramObject)
    {
      AppMethodBeat.i(241114);
      Log.i(o.a(this.wKJ), "callback to flutter success " + paramString);
      AppMethodBeat.o(241114);
    }
    
    public final void dLv()
    {
      AppMethodBeat.i(241112);
      Log.i(o.a(this.wKJ), "callback to flutter notImplemented");
      AppMethodBeat.o(241112);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a.a.o
 * JD-Core Version:    0.7.0.1
 */