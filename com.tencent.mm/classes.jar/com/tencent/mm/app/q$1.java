package com.tencent.mm.app;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.splash.d;

final class q$1
  implements d
{
  public final boolean dz(String paramString)
  {
    AppMethodBeat.i(138004);
    boolean bool = q.dA(paramString);
    AppMethodBeat.o(138004);
    return bool;
  }
  
  public final Activity l(Activity paramActivity)
  {
    AppMethodBeat.i(138005);
    paramActivity = q.k(paramActivity);
    AppMethodBeat.o(138005);
    return paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.q.1
 * JD-Core Version:    0.7.0.1
 */