package com.tencent.mm.plugin.box;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public class PluginBox
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, b
{
  private com.tencent.mm.sdk.b.c iop;
  private boolean isLoading;
  private boolean mRA;
  
  public PluginBox()
  {
    AppMethodBeat.i(76320);
    this.iop = new com.tencent.mm.sdk.b.c() {};
    this.mRA = false;
    this.isLoading = false;
    AppMethodBeat.o(76320);
  }
  
  public static String getBoxFlightResPath()
  {
    AppMethodBeat.i(76326);
    String str = q.B(new e(new e(aa.RZ(2).eil()).fhT(), "flight.txt").fhU());
    AppMethodBeat.o(76326);
    return str;
  }
  
  private void loadFlightNumberAsync()
  {
    AppMethodBeat.i(76324);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puk, com.tencent.mm.util.c.fgV()) == 0)
    {
      AppMethodBeat.o(76324);
      return;
    }
    h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(76319);
        long l = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            int i;
            if (!PluginBox.this.isLoading)
            {
              ad.i("MicroMsg.Box.PluginBox", "start to load flight number");
              PluginBox.access$102(PluginBox.this, true);
              if (!com.tencent.mm.vfs.i.eK(PluginBox.getBoxFlightResPath()))
              {
                ad.i("MicroMsg.Box.PluginBox", "flight number file not exist");
                return;
              }
              String[] arrayOfString = new String(com.tencent.mm.vfs.i.aR(PluginBox.getBoxFlightResPath(), 0, -1)).split("\n");
              com.tencent.mm.pluginsdk.ui.span.b localb = com.tencent.mm.pluginsdk.ui.span.b.CjC;
              localb.CjB = null;
              localb.Cjz = 0;
              localb.CjA = 0;
              i = 0;
              if (i < arrayOfString.length)
              {
                if (!bt.isNullOrNil(arrayOfString[i])) {
                  com.tencent.mm.pluginsdk.ui.span.b.CjC.aCl(arrayOfString[i]);
                }
              }
              else
              {
                PluginBox.access$202(PluginBox.this, true);
                ad.i("MicroMsg.Box.PluginBox", "load flight number success NodeCount：%d CharacterCount：%d useTime: %d", new Object[] { Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.b.CjC.CjA), Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.b.CjC.Cjz), Long.valueOf(System.currentTimeMillis() - l) });
              }
            }
            else
            {
              ad.i("MicroMsg.Box.PluginBox", "flight number is loading");
              continue;
            }
            i += 1;
          }
          catch (Exception localException)
          {
            com.tencent.mm.plugin.box.a.a.lI(0);
            ad.printErrStackTrace("MicroMsg.Box.PluginBox", localException, localException.getMessage(), new Object[0]);
            return;
          }
          finally
          {
            PluginBox.access$102(PluginBox.this, false);
            AppMethodBeat.o(76319);
          }
        }
      }
    }, "Box.LoadFlightNumberAsync");
    AppMethodBeat.o(76324);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(76323);
    if (paramg.agu()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.box.a.b.class, new a());
    }
    AppMethodBeat.o(76323);
  }
  
  public boolean isInitBox()
  {
    AppMethodBeat.i(76325);
    if ((this.mRA) && (aa.Sb(2) != 1))
    {
      AppMethodBeat.o(76325);
      return true;
    }
    AppMethodBeat.o(76325);
    return false;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(76321);
    this.iop.alive();
    loadFlightNumberAsync();
    AppMethodBeat.o(76321);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(76322);
    this.iop.dead();
    AppMethodBeat.o(76322);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.PluginBox
 * JD-Core Version:    0.7.0.1
 */