package com.tencent.mm.plugin.box;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public class PluginBox
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, d
{
  private boolean isLoading;
  private com.tencent.mm.sdk.b.c jhE;
  a nVe;
  private com.tencent.mm.sdk.b.c nVf;
  private boolean nVg;
  
  public PluginBox()
  {
    AppMethodBeat.i(76320);
    this.nVe = new a();
    this.jhE = new com.tencent.mm.sdk.b.c() {};
    this.nVf = new PluginBox.2(this);
    this.nVg = false;
    this.isLoading = false;
    AppMethodBeat.o(76320);
  }
  
  public static String getBoxFlightResPath()
  {
    AppMethodBeat.i(76326);
    String str = q.B(new e(new e(com.tencent.mm.plugin.websearch.api.ad.Wc(2).eMw()).fOJ(), "flight.txt").fOK());
    AppMethodBeat.o(76326);
    return str;
  }
  
  private void loadFlightNumberAsync()
  {
    AppMethodBeat.i(76324);
    com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.qDJ;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (localb.a(locala, com.tencent.mm.util.c.fNJ()) == 0)
    {
      AppMethodBeat.o(76324);
      return;
    }
    h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219102);
        long l = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            int i;
            if (!PluginBox.this.isLoading)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Box.PluginBox", "start to load flight number");
              PluginBox.access$202(PluginBox.this, true);
              if (!com.tencent.mm.vfs.i.fv(PluginBox.getBoxFlightResPath()))
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Box.PluginBox", "flight number file not exist");
                return;
              }
              String[] arrayOfString = new String(com.tencent.mm.vfs.i.aY(PluginBox.getBoxFlightResPath(), 0, -1)).split("\n");
              com.tencent.mm.pluginsdk.ui.span.b localb = com.tencent.mm.pluginsdk.ui.span.b.Fha;
              localb.FgZ = null;
              localb.FgX = 0;
              localb.FgY = 0;
              i = 0;
              if (i < arrayOfString.length)
              {
                if (!bt.isNullOrNil(arrayOfString[i])) {
                  com.tencent.mm.pluginsdk.ui.span.b.Fha.aNg(arrayOfString[i]);
                }
              }
              else
              {
                PluginBox.access$302(PluginBox.this, true);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Box.PluginBox", "load flight number success NodeCount：%d CharacterCount：%d useTime: %d", new Object[] { Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.b.Fha.FgY), Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.b.Fha.FgX), Long.valueOf(System.currentTimeMillis() - l) });
              }
            }
            else
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Box.PluginBox", "flight number is loading");
              continue;
            }
            i += 1;
          }
          catch (Exception localException)
          {
            com.tencent.mm.plugin.box.a.a.ma(0);
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.Box.PluginBox", localException, localException.getMessage(), new Object[0]);
            return;
          }
          finally
          {
            PluginBox.access$202(PluginBox.this, false);
            AppMethodBeat.o(219102);
          }
        }
      }
    }, "Box.LoadFlightNumberAsync");
    AppMethodBeat.o(76324);
  }
  
  private void loadWordBankAsync()
  {
    AppMethodBeat.i(219105);
    h.LTJ.f(c.vJD, "box.HotWordSearchModel");
    AppMethodBeat.o(219105);
  }
  
  private void updateWordBankRes(final String paramString)
  {
    AppMethodBeat.i(219104);
    int i = c.bMY();
    int j = c.WJ(paramString);
    if (j > i)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, start to update", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219101);
          try
          {
            if (c.WK(paramString) == 0)
            {
              c.mv(true);
              c.WG(c.jk(false));
            }
            AppMethodBeat.o(219101);
            return;
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.Box.PluginBox", localException, "[updateWordBankRes]", new Object[0]);
            AppMethodBeat.o(219101);
          }
        }
      }, "box.HotWordSearchModel");
      AppMethodBeat.o(219104);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, pass", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    AppMethodBeat.o(219104);
  }
  
  public String checkAllHotWords(String paramString)
  {
    AppMethodBeat.i(219107);
    paramString = c.WI(paramString);
    AppMethodBeat.o(219107);
    return paramString;
  }
  
  public boolean checkIfHasHotWord(String paramString)
  {
    AppMethodBeat.i(219106);
    boolean bool = c.WH(paramString);
    AppMethodBeat.o(219106);
    return bool;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(76323);
    if (paramg.akw()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.box.a.b.class, new b());
    }
    AppMethodBeat.o(76323);
  }
  
  public int getSearchDuration()
  {
    AppMethodBeat.i(219109);
    int i = c.getSearchDuration();
    AppMethodBeat.o(219109);
    return i;
  }
  
  public String getWordBankVersionForStat()
  {
    AppMethodBeat.i(219108);
    String str = c.getWordBankVersionForStat();
    AppMethodBeat.o(219108);
    return str;
  }
  
  public boolean isInitBox()
  {
    AppMethodBeat.i(76325);
    if ((this.nVg) && (com.tencent.mm.plugin.websearch.api.ad.We(2) != 1))
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
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("functionmsg", this.nVe.nUM);
    this.jhE.alive();
    this.nVf.alive();
    loadFlightNumberAsync();
    loadWordBankAsync();
    AppMethodBeat.o(76321);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(76322);
    this.jhE.dead();
    this.nVf.dead();
    AppMethodBeat.o(76322);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.PluginBox
 * JD-Core Version:    0.7.0.1
 */