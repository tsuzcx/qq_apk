package com.tencent.mm.am;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbase/AsyncMediaPlayerWrapper;", "", "()V", "TAG", "", "handlerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/modelbase/HandlerData;", "Lkotlin/collections/HashMap;", "createNewHandler", "tag", "dead", "", "play", "callback", "Lkotlin/Function0;", "plugin-audiologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a otm;
  private static final HashMap<String, d> otn;
  
  static
  {
    AppMethodBeat.i(236793);
    otm = new a();
    TAG = "MicroMsg.AsyncMediaPlayerWrapper";
    otn = new HashMap();
    AppMethodBeat.o(236793);
  }
  
  public static void LV(String paramString)
  {
    AppMethodBeat.i(236789);
    s.u(paramString, "tag");
    Log.i(TAG, s.X("dead, tag:", paramString));
    d locald = (d)otn.get(paramString);
    if (locald != null) {
      locald.thread.quitSafely();
    }
    otn.remove(paramString);
    AppMethodBeat.o(236789);
  }
  
  private static final void ad(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(236791);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(236791);
  }
  
  public static void k(String paramString, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(236786);
    s.u(paramString, "tag");
    s.u(parama, "callback");
    Log.i(TAG, s.X("play, tag:", paramString));
    Object localObject = (d)otn.get(paramString);
    if ((localObject != null) && (((d)localObject).thread.isAlive())) {}
    for (paramString = ((d)localObject).handler;; paramString = ((d)localObject).handler)
    {
      paramString.post(new a..ExternalSyntheticLambda0(parama));
      AppMethodBeat.o(236786);
      return;
      Log.i(TAG, s.X("createNewHandler, tag:", paramString));
      localObject = new HandlerThread(paramString);
      ((HandlerThread)localObject).start();
      localObject = new d((HandlerThread)localObject, new MMHandler(((HandlerThread)localObject).getLooper()));
      ((Map)otn).put(paramString, localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.a
 * JD-Core Version:    0.7.0.1
 */