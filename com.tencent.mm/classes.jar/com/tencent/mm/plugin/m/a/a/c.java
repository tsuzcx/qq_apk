package com.tencent.mm.plugin.m.a.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import io.flutter.embedding.engine.a;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/luggage/natives/flutter/WxaFlutterEngineProvider;", "Lcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;", "()V", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "ensureCallOnMain", "", "context", "Landroid/content/Context;", "luggage-native-view_release"})
public final class c
  implements b
{
  private static a tiq;
  public static final c vCc;
  
  static
  {
    AppMethodBeat.i(123808);
    vCc = new c();
    AppMethodBeat.o(123808);
  }
  
  private static void djP()
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
  
  public final a fJ(Context paramContext)
  {
    AppMethodBeat.i(123806);
    if (tiq == null)
    {
      djP();
      if (paramContext == null) {
        p.gfZ();
      }
      tiq = new a(paramContext);
    }
    paramContext = tiq;
    if (paramContext == null) {
      p.gfZ();
    }
    AppMethodBeat.o(123806);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.c
 * JD-Core Version:    0.7.0.1
 */