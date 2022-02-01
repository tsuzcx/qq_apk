package com.tencent.mm.plugin.crashfix;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.crashfix.d.a.d;
import com.tencent.mm.plugin.crashfix.d.b;
import com.tencent.mm.plugin.crashfix.d.c;
import com.tencent.mm.plugin.crashfix.d.c.1;
import com.tencent.mm.sdk.platformtools.ac;
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
    ac.i("MicroMsg.SystemCrashFixPatch", "api level : " + Build.VERSION.SDK_INT);
    paramg = new Handler(Looper.myLooper());
    if (c.oDb == null)
    {
      localObject = new ArrayList();
      c.oDb = (List)localObject;
      ((List)localObject).add(new d());
      c.oDb.add(new com.tencent.mm.plugin.crashfix.d.b.a());
    }
    Object localObject = c.oDb.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.AE(Build.VERSION.SDK_INT)) {
        if ((localb instanceof com.tencent.mm.plugin.crashfix.d.a))
        {
          paramg.postDelayed(new c.1((com.tencent.mm.plugin.crashfix.d.a)localb, localb), 0L);
        }
        else
        {
          boolean bool = localb.bXb();
          ac.i("MicroMsg.SystemCrashFixPatch", localb.getClass().getCanonicalName() + " : " + bool);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.PluginSystemCrashFix
 * JD-Core Version:    0.7.0.1
 */