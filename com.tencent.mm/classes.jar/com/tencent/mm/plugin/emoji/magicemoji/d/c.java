package com.tencent.mm.plugin.emoji.magicemoji.d;

import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.magicemoji.core.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/util/MagicEmojiProfiler;", "", "service", "Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService;", "(Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService;)V", "startProfile", "", "args", "", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a xKo;
  private final d xKp;
  
  static
  {
    AppMethodBeat.i(269993);
    xKo = new c.a((byte)0);
    AppMethodBeat.o(269993);
  }
  
  public c(d paramd)
  {
    AppMethodBeat.i(269966);
    this.xKp = paramd;
    AppMethodBeat.o(269966);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(269980);
    s.u(paramc, "this$0");
    Log.i("MicroMsg.MagicEmojiProfiler", "stevecai: stop profile");
    paramc.xKp.c("\n            ;console.log('stevecai: called cpu profiler');(function(profiler) {\n            return JSON.stringify(profiler.stopProfiling());})(__debug_v8_cpu_profiler);\n            ", new c..ExternalSyntheticLambda0(paramc));
    AppMethodBeat.o(269980);
  }
  
  private static final void a(c paramc, String paramString)
  {
    AppMethodBeat.i(269973);
    s.u(paramc, "this$0");
    paramc.xKp.dyM().dg(false);
    paramc = b.xKn;
    s.s(paramString, "str");
    b.anY(paramString);
    AppMethodBeat.o(269973);
  }
  
  public final void anZ(String paramString)
  {
    AppMethodBeat.i(270017);
    s.u(paramString, "args");
    try
    {
      int i = Integer.parseInt(paramString);
      Log.i("MicroMsg.MagicEmojiProfiler", "stevecai: start profile for " + i + " s");
      d.a(this.xKp, "\n            ;var __debug_v8_cpu_profiler = (function(profiler) {\n            if (typeof profiler === 'undefined') {\n                profiler = new NativeGlobal.CpuProfiler();\n            } profiler.startProfiling(); return profiler;})(__debug_v8_cpu_profiler);\n            ");
      this.xKp.dyM().dg(true);
      h.ahAA.q(new c..ExternalSyntheticLambda1(this), i * 1000L);
      AppMethodBeat.o(270017);
      return;
    }
    catch (NumberFormatException paramString)
    {
      Log.w("MicroMsg.MagicEmojiProfiler", "stevecai: start: ");
      AppMethodBeat.o(270017);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.d.c
 * JD-Core Version:    0.7.0.1
 */