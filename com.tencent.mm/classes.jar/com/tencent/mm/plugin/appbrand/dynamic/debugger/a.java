package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c.e.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.d.c;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.console.b;
import java.util.ArrayList;

public final class a
{
  private static e.a rls;
  
  static
  {
    AppMethodBeat.i(121288);
    rls = new e.a()
    {
      public final void as(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(121285);
        Bundle localBundle = new Bundle();
        localBundle.putString("id", paramAnonymousString);
        localBundle.putInt("status", paramAnonymousInt);
        j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.a.class, null);
        AppMethodBeat.o(121285);
      }
    };
    AppMethodBeat.o(121288);
  }
  
  public static e.a cnK()
  {
    return rls;
  }
  
  public static void d(String paramString, ArrayList<LogInfo> paramArrayList)
  {
    AppMethodBeat.i(121287);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putParcelableArrayList("logList", paramArrayList);
    paramString = b.uSH;
    c.aYB().r(paramString.getClass().getName(), localBundle);
    AppMethodBeat.o(121287);
  }
  
  static class a
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.a
 * JD-Core Version:    0.7.0.1
 */