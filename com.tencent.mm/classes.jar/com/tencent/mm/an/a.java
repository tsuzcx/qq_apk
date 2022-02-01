package com.tencent.mm.an;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbase/AsyncMediaPlayerWrapper;", "", "()V", "TAG", "", "handlerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/modelbase/HandlerData;", "Lkotlin/collections/HashMap;", "createNewHandler", "tag", "dead", "", "play", "callback", "Lkotlin/Function0;", "plugin-audiologic_release"})
public final class a
{
  public static final String TAG = "MicroMsg.AsyncMediaPlayerWrapper";
  public static final HashMap<String, e> lBC;
  public static final a lBD;
  
  static
  {
    AppMethodBeat.i(229292);
    lBD = new a();
    TAG = "MicroMsg.AsyncMediaPlayerWrapper";
    lBC = new HashMap();
    AppMethodBeat.o(229292);
  }
  
  public static void TV(String paramString)
  {
    AppMethodBeat.i(229290);
    p.k(paramString, "tag");
    Log.i(TAG, "dead, tag:".concat(String.valueOf(paramString)));
    e locale = (e)lBC.get(paramString);
    if (locale != null) {
      locale.thread.quitSafely();
    }
    lBC.remove(paramString);
    AppMethodBeat.o(229290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.a
 * JD-Core Version:    0.7.0.1
 */