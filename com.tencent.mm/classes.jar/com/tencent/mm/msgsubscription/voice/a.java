package com.tencent.mm.msgsubscription.voice;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/voice/MsgSubscriptionVoicePlayHelper;", "", "()V", "play", "", "url", "", "stop", "", "id", "wxbiz-msgsubscription-sdk_release"})
public final class a
{
  public static final a mtE;
  
  static
  {
    AppMethodBeat.i(263652);
    mtE = new a();
    AppMethodBeat.o(263652);
  }
  
  public static void GY(long paramLong)
  {
    AppMethodBeat.i(263651);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new PlayVoiceData(paramLong, "", 1), c.class, (f)b.mtG);
    AppMethodBeat.o(263651);
  }
  
  public static long Zk(String paramString)
  {
    AppMethodBeat.i(263650);
    p.k(paramString, "url");
    long l = System.nanoTime();
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new PlayVoiceData(l, paramString, 0), c.class, (f)a.mtF);
    AppMethodBeat.o(263650);
    return l;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements f<ResultType>
  {
    public static final a mtF;
    
    static
    {
      AppMethodBeat.i(263468);
      mtF = new a();
      AppMethodBeat.o(263468);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements f<ResultType>
  {
    public static final b mtG;
    
    static
    {
      AppMethodBeat.i(263489);
      mtG = new b();
      AppMethodBeat.o(263489);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.voice.a
 * JD-Core Version:    0.7.0.1
 */