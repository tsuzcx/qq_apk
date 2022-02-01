package com.tencent.mm.plugin.finder.shell;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/shell/FinderShell;", "", "()V", "TAG", "", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/shell/FinderShell$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/shell/FinderShell$entryConfigChangeListener$1;", "listener", "com/tencent/mm/plugin/finder/shell/FinderShell$listener$1", "Lcom/tencent/mm/plugin/finder/shell/FinderShell$listener$1;", "exec", "", "intent", "Landroid/content/Intent;", "setup", "plugin-finder_release"})
public final class a
{
  private static final b sux;
  private static final a suy;
  public static final a suz;
  
  static
  {
    AppMethodBeat.i(203549);
    suz = new a();
    sux = new b();
    suy = new a();
    AppMethodBeat.o(203549);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(203548);
    if (bu.flY()) {
      sux.alive();
    }
    AppMethodBeat.o(203548);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/shell/FinderShell$entryConfigChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends c<fl>
  {
    private static boolean a(fl paramfl)
    {
      AppMethodBeat.i(203545);
      p.h(paramfl, "event");
      paramfl = ((b)g.ab(b.class)).a(b.a.qAa, "");
      Object localObject = (CharSequence)paramfl;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(203545);
        return true;
      }
      for (;;)
      {
        try
        {
          paramfl = new JSONObject(paramfl);
          i = paramfl.getInt("version");
          localObject = g.ajC();
          p.g(localObject, "MMKernel.storage()");
          int j = ((e)localObject).ajl().getInt(al.a.IIS, 0);
          ad.i("Finder.Shell", "lastVersion=" + j + " version=" + i + " json=" + paramfl);
          if (j == i) {}
        }
        catch (Exception paramfl)
        {
          continue;
        }
        try
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("sql", paramfl.getString("sql"));
          ((Intent)localObject).putExtra("db", paramfl.getString("db"));
          paramfl = a.suz;
          a.ak((Intent)localObject);
          paramfl = g.ajC();
          p.g(paramfl, "MMKernel.storage()");
          paramfl.ajl().set(al.a.IIS, Integer.valueOf(i));
          AppMethodBeat.o(203545);
          return true;
        }
        finally
        {
          localObject = g.ajC();
          p.g(localObject, "MMKernel.storage()");
          ((e)localObject).ajl().set(al.a.IIS, Integer.valueOf(i));
          AppMethodBeat.o(203545);
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/shell/FinderShell$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ShellExecEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends c<tr>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.shell.a
 * JD-Core Version:    0.7.0.1
 */