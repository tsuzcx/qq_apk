package com.tencent.mm.plugin.finder.utils;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/AsyncIntentCallbackUtil;", "Lcom/tencent/mm/plugin/finder/utils/AsyncCallbackStore;", "", "()V", "ASYNC_CALLBACK_PARAM", "", "getAndRemoveCallback", "intent", "Landroid/content/Intent;", "removeIdentity", "", "identity", "setIntentCallback", "callback", "setIntentIdentity", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b<Object>
{
  public static final c GfS;
  
  static
  {
    AppMethodBeat.i(333786);
    GfS = new c();
    AppMethodBeat.o(333786);
  }
  
  public static Object aO(Intent paramIntent)
  {
    AppMethodBeat.i(333775);
    s.u(paramIntent, "intent");
    paramIntent = paramIntent.getStringExtra("async_callback_param");
    if (paramIntent == null)
    {
      AppMethodBeat.o(333775);
      return null;
    }
    c localc = GfS;
    s.u(paramIntent, "identity");
    paramIntent = localc.GfR.remove(paramIntent);
    AppMethodBeat.o(333775);
    return paramIntent;
  }
  
  public final void f(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(333795);
    s.u(paramIntent, "intent");
    HashMap localHashMap = this.GfR;
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      if (localHashMap.containsKey(str)) {
        paramIntent.putExtra("async_callback_param", paramString);
      }
      AppMethodBeat.o(333795);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.c
 * JD-Core Version:    0.7.0.1
 */