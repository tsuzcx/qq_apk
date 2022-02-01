package com.tencent.mm.plugin.lite;

import com.tencent.liteapp.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/lite/LiteAppProcessProfileInit$Companion$preloadEngine$1", "Lcom/tencent/liteapp/log/IWxaLiteAppLog;", "d", "", "TAG", "", "format", "objects", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "luggage-lite-app_release"})
public final class a$a$a
  implements a
{
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int j = 1;
    AppMethodBeat.i(198957);
    p.h(paramString2, "format");
    p.h(paramVarArgs, "objects");
    if (paramVarArgs.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
    }
    label68:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        break label74;
      }
      Log.d(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
      AppMethodBeat.o(198957);
      return;
      i = 0;
      break;
    }
    label74:
    Log.d(paramString1, paramString2);
    AppMethodBeat.o(198957);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int j = 1;
    AppMethodBeat.i(198956);
    p.h(paramString2, "format");
    p.h(paramVarArgs, "objects");
    if (paramVarArgs.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
    }
    label68:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        break label74;
      }
      Log.e(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
      AppMethodBeat.o(198956);
      return;
      i = 0;
      break;
    }
    label74:
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(198956);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int j = 1;
    AppMethodBeat.i(198953);
    p.h(paramString2, "format");
    p.h(paramVarArgs, "objects");
    if (paramVarArgs.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
    }
    label68:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        break label74;
      }
      Log.i(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
      AppMethodBeat.o(198953);
      return;
      i = 0;
      break;
    }
    label74:
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(198953);
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int j = 1;
    AppMethodBeat.i(198955);
    p.h(paramString2, "format");
    p.h(paramVarArgs, "objects");
    if (paramVarArgs.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
    }
    label68:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        break label74;
      }
      Log.v(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
      AppMethodBeat.o(198955);
      return;
      i = 0;
      break;
    }
    label74:
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(198955);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int j = 1;
    AppMethodBeat.i(198954);
    p.h(paramString2, "format");
    p.h(paramVarArgs, "objects");
    if (paramVarArgs.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
    }
    label68:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        break label74;
      }
      Log.w(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
      AppMethodBeat.o(198954);
      return;
      i = 0;
      break;
    }
    label74:
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(198954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.a.a
 * JD-Core Version:    0.7.0.1
 */