package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c.e.a;
import com.tencent.mm.ipcinvoker.h;

final class a$1
  implements e.a
{
  public final void Q(String paramString, int paramInt)
  {
    AppMethodBeat.i(121285);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("status", paramInt);
    h.a("com.tencent.mm", localBundle, a.a.class, null);
    AppMethodBeat.o(121285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.a.1
 * JD-Core Version:    0.7.0.1
 */