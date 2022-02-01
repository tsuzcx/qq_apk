package com.tencent.mm.plugin.finder.shell;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/shell/FinderShell;", "", "()V", "TAG", "", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/shell/FinderShell$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/shell/FinderShell$entryConfigChangeListener$1;", "listener", "com/tencent/mm/plugin/finder/shell/FinderShell$listener$1", "Lcom/tencent/mm/plugin/finder/shell/FinderShell$listener$1;", "exec", "", "intent", "Landroid/content/Intent;", "setup", "plugin-finder_release"})
public final class a
{
  private static final b sEH;
  private static final a sEI;
  public static final a sEJ;
  
  static
  {
    AppMethodBeat.i(204109);
    sEJ = new a();
    sEH = new b();
    sEI = new a();
    AppMethodBeat.o(204109);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(204108);
    if (bv.fpT()) {
      sEH.alive();
    }
    AppMethodBeat.o(204108);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/shell/FinderShell$entryConfigChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends c<fm>
  {
    private static boolean a(fm paramfm)
    {
      AppMethodBeat.i(204105);
      p.h(paramfm, "event");
      paramfm = ((b)g.ab(b.class)).a(b.a.qHj, "");
      Object localObject = (CharSequence)paramfm;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(204105);
        return true;
      }
      for (;;)
      {
        try
        {
          paramfm = new JSONObject(paramfm);
          i = paramfm.getInt("version");
          localObject = g.ajR();
          p.g(localObject, "MMKernel.storage()");
          int j = ((e)localObject).ajA().getInt(am.a.Jdx, 0);
          ae.i("Finder.Shell", "lastVersion=" + j + " version=" + i + " json=" + paramfm);
          if (j == i) {}
        }
        catch (Exception paramfm)
        {
          continue;
        }
        try
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("sql", paramfm.getString("sql"));
          ((Intent)localObject).putExtra("db", paramfm.getString("db"));
          paramfm = a.sEJ;
          a.al((Intent)localObject);
          paramfm = g.ajR();
          p.g(paramfm, "MMKernel.storage()");
          paramfm.ajA().set(am.a.Jdx, Integer.valueOf(i));
          AppMethodBeat.o(204105);
          return true;
        }
        finally
        {
          localObject = g.ajR();
          p.g(localObject, "MMKernel.storage()");
          ((e)localObject).ajA().set(am.a.Jdx, Integer.valueOf(i));
          AppMethodBeat.o(204105);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/shell/FinderShell$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ShellExecEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends c<ts>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.shell.a
 * JD-Core Version:    0.7.0.1
 */