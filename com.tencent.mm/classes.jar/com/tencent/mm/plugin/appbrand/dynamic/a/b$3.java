package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(10735);
    if (!com.tencent.mm.ipcinvoker.b.PK().lX("com.tencent.mm:support"))
    {
      AppMethodBeat.o(10735);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("forceKillProcess", true);
    f.a("com.tencent.mm:support", localBundle, b.a.class, new b.3.1(this));
    AppMethodBeat.o(10735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b.3
 * JD-Core Version:    0.7.0.1
 */