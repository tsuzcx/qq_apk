package com.tencent.mm.flutter.plugin.data_sources.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
final class a$f$b
  implements a
{
  a$f$b(p<? super String> paramp) {}
  
  public final void onImageDownload(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(233302);
    Log.w("MicroMsg.FinderDataSource", s.X("onImageDownload: success=", Boolean.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      paramArrayOfObject = (d)this.bPy;
      Result.Companion localCompanion = Result.Companion;
      paramArrayOfObject.resumeWith(Result.constructor-impl(null));
    }
    AppMethodBeat.o(233302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.b.a.f.b
 * JD-Core Version:    0.7.0.1
 */