package com.tencent.mm.plugin.car_license_plate.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.a;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class a$c
  implements Runnable
{
  a$c(a<ah> parama, p<? super ah> paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(277543);
    this.$block.invoke();
    d locald = (d)this.bPy;
    ah localah = ah.aiuX;
    Result.Companion localCompanion = Result.Companion;
    locald.resumeWith(Result.constructor-impl(localah));
    AppMethodBeat.o(277543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.b.a.c
 * JD-Core Version:    0.7.0.1
 */