package com.tencent.mm.plugin;

import com.tencent.c.e.a;
import com.tencent.c.e.b;
import com.tencent.c.e.c;
import com.tencent.c.e.d;
import com.tencent.c.e.e;
import com.tencent.c.e.f;
import com.tencent.c.e.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/FlutterMMKVPlugin;", "Lcom/tencent/pigeon/FlutterMMKVPigeon$FlutterMMKVHost;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "getBool", "Lcom/tencent/pigeon/FlutterMMKVPigeon$FlutterBoolResponse;", "request", "Lcom/tencent/pigeon/FlutterMMKVPigeon$FlutterBoolRequest;", "getInt", "Lcom/tencent/pigeon/FlutterMMKVPigeon$FlutterIntResponse;", "Lcom/tencent/pigeon/FlutterMMKVPigeon$FlutterIntRequest;", "getString", "Lcom/tencent/pigeon/FlutterMMKVPigeon$FlutterStringResponse;", "Lcom/tencent/pigeon/FlutterMMKVPigeon$FlutterStringRequest;", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "putBool", "putInt", "putString", "plugin-flutter-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends e.e
  implements FlutterPlugin
{
  public final e.b a(e.a parama)
  {
    AppMethodBeat.i(260309);
    if (parama != null)
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(parama.name);
      String str = parama.key;
      parama = parama.ahhE;
      s.s(parama, "value");
      boolean bool = localMultiProcessMMKV.getBoolean(str, parama.booleanValue());
      parama = new e.b();
      parama.ahhE = Boolean.valueOf(bool);
      AppMethodBeat.o(260309);
      return parama;
    }
    parama = new e.b();
    AppMethodBeat.o(260309);
    return parama;
  }
  
  public final e.d a(e.c paramc)
  {
    AppMethodBeat.i(260316);
    if (paramc != null)
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(paramc.name);
      String str = paramc.key;
      paramc = paramc.ahhF;
      s.s(paramc, "value");
      long l = localMultiProcessMMKV.getLong(str, ((Number)paramc).longValue());
      paramc = new e.d();
      paramc.ahhF = Long.valueOf(l);
      AppMethodBeat.o(260316);
      return paramc;
    }
    paramc = new e.d();
    AppMethodBeat.o(260316);
    return paramc;
  }
  
  public final e.g a(e.f paramf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(260303);
    Object localObject1;
    MultiProcessMMKV localMultiProcessMMKV;
    if (paramf == null)
    {
      localObject1 = null;
      localMultiProcessMMKV = MultiProcessMMKV.getMMKV((String)localObject1);
      if (paramf != null) {
        break label67;
      }
      localObject1 = null;
      label25:
      if (paramf != null) {
        break label75;
      }
    }
    label67:
    label75:
    for (paramf = localObject2;; paramf = paramf.value)
    {
      paramf = localMultiProcessMMKV.getString((String)localObject1, paramf);
      localObject1 = new e.g();
      ((e.g)localObject1).value = paramf;
      AppMethodBeat.o(260303);
      return localObject1;
      localObject1 = paramf.name;
      break;
      localObject1 = paramf.key;
      break label25;
    }
  }
  
  public final void b(e.a parama)
  {
    AppMethodBeat.i(260314);
    if (parama != null)
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(parama.name);
      String str = parama.key;
      parama = parama.ahhE;
      s.s(parama, "value");
      localMultiProcessMMKV.putBoolean(str, parama.booleanValue());
    }
    AppMethodBeat.o(260314);
  }
  
  public final void b(e.c paramc)
  {
    AppMethodBeat.i(260317);
    if (paramc != null)
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(paramc.name);
      String str = paramc.key;
      paramc = paramc.ahhF;
      s.s(paramc, "value");
      localMultiProcessMMKV.putLong(str, ((Number)paramc).longValue());
    }
    AppMethodBeat.o(260317);
  }
  
  public final void b(e.f paramf)
  {
    AppMethodBeat.i(260306);
    if (paramf != null) {
      MultiProcessMMKV.getMMKV(paramf.name).putString(paramf.key, paramf.value);
    }
    AppMethodBeat.o(260306);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(260318);
    s.u(paramFlutterPluginBinding, "binding");
    e.e.a(paramFlutterPluginBinding.getBinaryMessenger(), (e.e)this);
    AppMethodBeat.o(260318);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(260319);
    s.u(paramFlutterPluginBinding, "binding");
    e.e.a(paramFlutterPluginBinding.getBinaryMessenger(), null);
    AppMethodBeat.o(260319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.e
 * JD-Core Version:    0.7.0.1
 */