package com.tencent.mm.plugin.crashfix;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.crashfix.d.a.d;
import com.tencent.mm.plugin.crashfix.d.b;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(151897);
    dependsOnRoot();
    AppMethodBeat.o(151897);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(151898);
    ab.i("MicroMsg.SystemCrashFixPatch", "api level : " + Build.VERSION.SDK_INT);
    if (b.kTc == null)
    {
      paramg = new ArrayList();
      b.kTc = paramg;
      paramg.add(new d());
    }
    paramg = b.kTc.iterator();
    while (paramg.hasNext())
    {
      com.tencent.mm.plugin.crashfix.d.a locala = (com.tencent.mm.plugin.crashfix.d.a)paramg.next();
      if (locala.tS(Build.VERSION.SDK_INT))
      {
        boolean bool = locala.biH();
        ab.i("MicroMsg.SystemCrashFixPatch", locala.getClass().getCanonicalName() + " : " + bool);
      }
    }
    AppMethodBeat.o(151898);
  }
  
  public void installed()
  {
    AppMethodBeat.i(151896);
    alias(com.tencent.mm.plugin.crashfix.a.a.class);
    AppMethodBeat.o(151896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.PluginSystemCrashFix
 * JD-Core Version:    0.7.0.1
 */