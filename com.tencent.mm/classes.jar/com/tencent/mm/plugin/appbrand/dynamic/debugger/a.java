package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.c.e.a;
import com.tencent.mm.ipcinvoker.d.c;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.console.b;
import java.util.ArrayList;

public final class a
{
  private static e.a kgg;
  
  static
  {
    AppMethodBeat.i(121288);
    kgg = new a.1();
    AppMethodBeat.o(121288);
  }
  
  public static e.a bfY()
  {
    return kgg;
  }
  
  public static void c(String paramString, ArrayList<LogInfo> paramArrayList)
  {
    AppMethodBeat.i(121287);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putParcelableArrayList("logList", paramArrayList);
    paramString = b.nqi;
    c.ahF().m(paramString.getClass().getName(), localBundle);
    AppMethodBeat.o(121287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.a
 * JD-Core Version:    0.7.0.1
 */