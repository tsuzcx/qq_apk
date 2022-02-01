package com.tencent.mm.plugin.crashfix;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.crashfix.patch.b;
import com.tencent.mm.plugin.crashfix.patch.b.d;
import com.tencent.mm.plugin.crashfix.patch.c;
import com.tencent.mm.plugin.crashfix.patch.c.1;
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
    if (c.xfm == null)
    {
      localObject = new ArrayList();
      c.xfm = (List)localObject;
      ((List)localObject).add(new d());
      c.xfm.add(new com.tencent.mm.plugin.crashfix.patch.c.a());
      c.xfm.add(new com.tencent.mm.plugin.crashfix.patch.a.a());
      c.xfm.add(new com.tencent.mm.plugin.crashfix.patch.killself.a());
      c.xfm.add(new com.tencent.mm.plugin.crashfix.patch.phonestateoverflow.a());
    }
    Object localObject = c.xfm.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.Js(Build.VERSION.SDK_INT)) {
        if ((localb instanceof com.tencent.mm.plugin.crashfix.patch.a))
        {
          com.tencent.mm.plugin.crashfix.patch.a locala = (com.tencent.mm.plugin.crashfix.patch.a)localb;
          paramg.postDelayed(new c.1(locala, localb), locala.dsZ());
        }
        else
        {
          boolean bool = localb.dtc();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.PluginSystemCrashFix
 * JD-Core Version:    0.7.0.1
 */