package com.tencent.mm.plugin.m.a.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import io.flutter.embedding.engine.a;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/luggage/natives/flutter/WxaFlutterEngineProvider;", "Lcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;", "()V", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "ensureCallOnMain", "", "context", "Landroid/content/Context;", "luggage-native-view_release"})
public final class c
  implements b
{
  private static a tti;
  public static final c vOg;
  
  static
  {
    AppMethodBeat.i(123808);
    vOg = new c();
    AppMethodBeat.o(123808);
  }
  
  private static void dmO()
  {
    AppMethodBeat.i(123807);
    Object localObject = Looper.getMainLooper();
    p.g(localObject, "Looper.getMainLooper()");
    if (!p.i(((Looper)localObject).getThread(), Thread.currentThread()))
    {
      localObject = (Throwable)new IllegalArgumentException("must be called on main thread".toString());
      AppMethodBeat.o(123807);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(123807);
  }
  
  public final a fP(Context paramContext)
  {
    AppMethodBeat.i(123806);
    if (tti == null)
    {
      dmO();
      if (paramContext == null) {
        p.gkB();
      }
      tti = new a(paramContext);
    }
    paramContext = tti;
    if (paramContext == null) {
      p.gkB();
    }
    AppMethodBeat.o(123806);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.c
 * JD-Core Version:    0.7.0.1
 */