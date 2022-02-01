package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c.e.a;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;

final class a$1
  implements e.a
{
  public final void aj(String paramString, int paramInt)
  {
    AppMethodBeat.i(121285);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("status", paramInt);
    j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.a.class, null);
    AppMethodBeat.o(121285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.a.1
 * JD-Core Version:    0.7.0.1
 */