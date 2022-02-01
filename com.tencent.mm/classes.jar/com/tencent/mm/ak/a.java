package com.tencent.mm.ak;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelbase/AsyncMediaPlayerWrapper;", "", "()V", "TAG", "", "handlerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/modelbase/HandlerData;", "Lkotlin/collections/HashMap;", "createNewHandler", "tag", "dead", "", "play", "callback", "Lkotlin/Function0;", "plugin-audiologic_release"})
public final class a
{
  public static final String TAG = "MicroMsg.AsyncMediaPlayerWrapper";
  public static final HashMap<String, e> iLv;
  public static final a iLw;
  
  static
  {
    AppMethodBeat.i(187350);
    iLw = new a();
    TAG = "MicroMsg.AsyncMediaPlayerWrapper";
    iLv = new HashMap();
    AppMethodBeat.o(187350);
  }
  
  public static void MA(String paramString)
  {
    AppMethodBeat.i(187349);
    p.h(paramString, "tag");
    Log.i(TAG, "dead, tag:".concat(String.valueOf(paramString)));
    e locale = (e)iLv.get(paramString);
    if (locale != null) {
      locale.thread.quitSafely();
    }
    iLv.remove(paramString);
    AppMethodBeat.o(187349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.a
 * JD-Core Version:    0.7.0.1
 */