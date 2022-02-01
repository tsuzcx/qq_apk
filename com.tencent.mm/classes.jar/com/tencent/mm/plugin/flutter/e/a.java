package com.tencent.mm.plugin.flutter.e;

import android.os.Build.VERSION;
import com.tencent.d.b.as;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.i;
import com.tencent.mm.plugin.flutter.d.c;
import com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.d;
import com.tencent.mm.videocomposition.f;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.EffectManager.a;
import com.tencent.mm.xeffect.effect.IStickerDecoderFactory;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/VideoEditorCompositionUiPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "api", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$VideoEditorCompositionApi;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setupApi", "newApi", "Companion", "plugin-flutter_release"})
public final class a
  implements io.flutter.embedding.engine.plugins.a, k.c
{
  public static final a.a wJv;
  private k bbv;
  private b.as wJu;
  
  static
  {
    AppMethodBeat.i(240998);
    wJv = new a.a((byte)0);
    AppMethodBeat.o(240998);
  }
  
  public a()
  {
    AppMethodBeat.i(240997);
    this.wJu = ((b.as)new com.tencent.mm.plugin.flutter.e.a.a());
    AppMethodBeat.o(240997);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(240994);
    p.h(paramb, "flutterPluginBinding");
    Object localObject = EffectManager.RxS;
    EffectManager.a.b((IStickerDecoderFactory)new i());
    localObject = com.tencent.mm.videocomposition.b.RgQ;
    com.tencent.mm.videocomposition.b.a((f)new d());
    localObject = paramb.hwW();
    p.g(localObject, "flutterPluginBinding.flutterEngine");
    ((io.flutter.embedding.engine.a)localObject).hwF().a((io.flutter.embedding.engine.plugins.a)new c());
    this.bbv = new k(paramb.hwX(), "video_editor_composition_ui");
    localObject = new a();
    b.as localas = (b.as)new com.tencent.mm.plugin.flutter.e.a.a();
    k localk = this.bbv;
    if (localk == null) {
      p.btv("channel");
    }
    localk.a((k.c)localObject);
    b.as.a(paramb.hwX(), localas);
    AppMethodBeat.o(240994);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(240995);
    p.h(paramj, "call");
    p.h(paramd, "result");
    if (p.j(paramj.method, "getPlatformVersion"))
    {
      paramd.ba("Android " + Build.VERSION.RELEASE);
      AppMethodBeat.o(240995);
      return;
    }
    paramd.dLv();
    AppMethodBeat.o(240995);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(240996);
    p.h(paramb, "binding");
    paramb = this.bbv;
    if (paramb == null) {
      p.btv("channel");
    }
    if (paramb != null)
    {
      paramb.a(null);
      AppMethodBeat.o(240996);
      return;
    }
    AppMethodBeat.o(240996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a
 * JD-Core Version:    0.7.0.1
 */