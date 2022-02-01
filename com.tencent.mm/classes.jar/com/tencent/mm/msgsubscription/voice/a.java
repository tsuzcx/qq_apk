package com.tencent.mm.msgsubscription.voice;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/voice/MsgSubscriptionVoicePlayHelper;", "", "()V", "play", "", "url", "", "stop", "", "id", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a pmY;
  
  static
  {
    AppMethodBeat.i(236484);
    pmY = new a();
    AppMethodBeat.o(236484);
  }
  
  public static long Ro(String paramString)
  {
    AppMethodBeat.i(236459);
    s.u(paramString, "url");
    long l = System.nanoTime();
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new PlayVoiceData(l, paramString, 0), c.class, a..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(236459);
    return l;
  }
  
  private static final void d(IPCVoid paramIPCVoid) {}
  
  private static final void e(IPCVoid paramIPCVoid) {}
  
  public static void jj(long paramLong)
  {
    AppMethodBeat.i(236469);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new PlayVoiceData(paramLong, "", 1), c.class, a..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(236469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.voice.a
 * JD-Core Version:    0.7.0.1
 */