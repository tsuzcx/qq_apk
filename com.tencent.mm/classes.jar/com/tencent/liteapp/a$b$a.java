package com.tencent.liteapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.a;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/liteapp/WxaLiteApp$Config$init$routerConfig$1", "Lcom/tencent/wxa/WxaPluginRegistryCallback;", "registerPlugins", "", "mEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "wxa_lite_app_release"})
public final class a$b$a
  implements com.tencent.wxa.b
{
  public final void a(a parama)
  {
    AppMethodBeat.i(197911);
    if ((parama != null) && (this.cqQ.cqP != null))
    {
      parama = parama.hwF();
      HashSet localHashSet = this.cqQ.cqP;
      if (localHashSet == null) {
        p.hyc();
      }
      parama.A((Set)localHashSet);
    }
    AppMethodBeat.o(197911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteapp.a.b.a
 * JD-Core Version:    0.7.0.1
 */