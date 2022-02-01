package com.tencent.mm.plugin.m.a.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import io.flutter.embedding.engine.a;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/WxaFlutterEngineProvider;", "Lcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;", "()V", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "ensureCallOnMain", "", "context", "Landroid/content/Context;", "luggage-native-view_release"})
public final class c
  implements b
{
  private static a slN;
  public static final c uzz;
  
  static
  {
    AppMethodBeat.i(123808);
    uzz = new c();
    AppMethodBeat.o(123808);
  }
  
  private static void daC()
  {
    AppMethodBeat.i(123807);
    Object localObject = Looper.getMainLooper();
    k.g(localObject, "Looper.getMainLooper()");
    if (!k.g(((Looper)localObject).getThread(), Thread.currentThread()))
    {
      localObject = (Throwable)new IllegalArgumentException("must be called on main thread".toString());
      AppMethodBeat.o(123807);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(123807);
  }
  
  public final a fE(Context paramContext)
  {
    AppMethodBeat.i(123806);
    if (slN == null)
    {
      daC();
      if (paramContext == null) {
        k.fOy();
      }
      slN = new a(paramContext);
    }
    paramContext = slN;
    if (paramContext == null) {
      k.fOy();
    }
    AppMethodBeat.o(123806);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.c
 * JD-Core Version:    0.7.0.1
 */