package com.tencent.mm.plugin.crashfix;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.crashfix.d.b;
import com.tencent.mm.plugin.crashfix.d.c;
import com.tencent.mm.plugin.crashfix.d.c.1;
import com.tencent.mm.plugin.crashfix.d.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PluginSystemCrashFix
  extends f
  implements com.tencent.mm.plugin.crashfix.a.a
{
  public void configure(g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(145615);
    dependsOnRoot();
    AppMethodBeat.o(145615);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(145616);
    Log.i("MicroMsg.SystemCrashFixPatch", "api level : " + Build.VERSION.SDK_INT);
    paramg = new Handler(Looper.myLooper());
    if (c.qCA == null)
    {
      localObject = new ArrayList();
      c.qCA = (List)localObject;
      ((List)localObject).add(new d());
      c.qCA.add(new com.tencent.mm.plugin.crashfix.d.e.a());
      c.qCA.add(new com.tencent.mm.plugin.crashfix.d.a.a());
      c.qCA.add(new com.tencent.mm.plugin.crashfix.d.b.a());
      c.qCA.add(new com.tencent.mm.plugin.crashfix.d.c.a());
    }
    Object localObject = c.qCA.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.Fh(Build.VERSION.SDK_INT)) {
        if ((localb instanceof com.tencent.mm.plugin.crashfix.d.a))
        {
          paramg.postDelayed(new c.1((com.tencent.mm.plugin.crashfix.d.a)localb, localb), 0L);
        }
        else
        {
          boolean bool = localb.cAO();
          Log.i("MicroMsg.SystemCrashFixPatch", localb.getClass().getCanonicalName() + " : " + bool);
        }
      }
    }
    AppMethodBeat.o(145616);
  }
  
  public void installed()
  {
    AppMethodBeat.i(145614);
    alias(com.tencent.mm.plugin.crashfix.a.a.class);
    AppMethodBeat.o(145614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.PluginSystemCrashFix
 * JD-Core Version:    0.7.0.1
 */