package com.tencent.mm.plugin.flutter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ah;
import kotlin.d.d;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class b$d
  implements Runnable
{
  b$d(long paramLong, d<? super ah> paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(263139);
    long l = Util.ticksToNow(this.nCR);
    Log.i("MicroMsg.CachedFlutterEngines", "init FlutterLoader cost:" + l + " ms");
    d locald = this.msc;
    ah localah = ah.aiuX;
    Result.Companion localCompanion = Result.Companion;
    locald.resumeWith(Result.constructor-impl(localah));
    AppMethodBeat.o(263139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b.b.d
 * JD-Core Version:    0.7.0.1
 */