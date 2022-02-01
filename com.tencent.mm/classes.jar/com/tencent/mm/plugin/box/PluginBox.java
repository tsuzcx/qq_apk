package com.tencent.mm.plugin.box;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;

public class PluginBox
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, d
{
  private boolean isLoading;
  private com.tencent.mm.sdk.b.c jkx;
  a oaL;
  private com.tencent.mm.sdk.b.c oaM;
  private boolean oaN;
  
  public PluginBox()
  {
    AppMethodBeat.i(76320);
    this.oaL = new a();
    this.jkx = new PluginBox.1(this);
    this.oaM = new PluginBox.2(this);
    this.oaN = false;
    this.isLoading = false;
    AppMethodBeat.o(76320);
  }
  
  public static String getBoxFlightResPath()
  {
    AppMethodBeat.i(76326);
    String str = w.B(new k(new k(ad.WJ(2).eQf()).fTg(), "flight.txt").fTh());
    AppMethodBeat.o(76326);
    return str;
  }
  
  private void loadFlightNumberAsync()
  {
    AppMethodBeat.i(76324);
    com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.qLo;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (localb.a(locala, com.tencent.mm.util.c.fSe()) == 0)
    {
      AppMethodBeat.o(76324);
      return;
    }
    h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208296);
        long l = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            int i;
            if (!PluginBox.this.isLoading)
            {
              ae.i("MicroMsg.Box.PluginBox", "start to load flight number");
              PluginBox.access$202(PluginBox.this, true);
              if (!o.fB(PluginBox.getBoxFlightResPath()))
              {
                ae.i("MicroMsg.Box.PluginBox", "flight number file not exist");
                return;
              }
              String[] arrayOfString = new String(o.bb(PluginBox.getBoxFlightResPath(), 0, -1)).split("\n");
              com.tencent.mm.pluginsdk.ui.span.b localb = com.tencent.mm.pluginsdk.ui.span.b.Fzy;
              localb.Fzx = null;
              localb.Fzv = 0;
              localb.Fzw = 0;
              i = 0;
              if (i < arrayOfString.length)
              {
                if (!bu.isNullOrNil(arrayOfString[i])) {
                  com.tencent.mm.pluginsdk.ui.span.b.Fzy.aOD(arrayOfString[i]);
                }
              }
              else
              {
                PluginBox.access$302(PluginBox.this, true);
                ae.i("MicroMsg.Box.PluginBox", "load flight number success NodeCount：%d CharacterCount：%d useTime: %d", new Object[] { Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.b.Fzy.Fzw), Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.b.Fzy.Fzv), Long.valueOf(System.currentTimeMillis() - l) });
              }
            }
            else
            {
              ae.i("MicroMsg.Box.PluginBox", "flight number is loading");
              continue;
            }
            i += 1;
          }
          catch (Exception localException)
          {
            com.tencent.mm.plugin.box.a.a.md(0);
            ae.printErrStackTrace("MicroMsg.Box.PluginBox", localException, localException.getMessage(), new Object[0]);
            return;
          }
          finally
          {
            PluginBox.access$202(PluginBox.this, false);
            AppMethodBeat.o(208296);
          }
        }
      }
    }, "Box.LoadFlightNumberAsync");
    AppMethodBeat.o(76324);
  }
  
  private void loadWordBankAsync()
  {
    AppMethodBeat.i(208298);
    h.MqF.f(c.oaG, "box.HotWordSearchModel");
    AppMethodBeat.o(208298);
  }
  
  private void updateWordBankRes(final String paramString)
  {
    AppMethodBeat.i(208297);
    int i = c.bNV();
    int j = c.Xv(paramString);
    if (j > i)
    {
      ae.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, start to update", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208295);
          try
          {
            if (c.Xw(paramString) == 0)
            {
              c.ji(true);
              c.Xs(c.jj(false));
            }
            AppMethodBeat.o(208295);
            return;
          }
          catch (Exception localException)
          {
            ae.printErrStackTrace("MicroMsg.Box.PluginBox", localException, "[updateWordBankRes]", new Object[0]);
            AppMethodBeat.o(208295);
          }
        }
      }, "box.HotWordSearchModel");
      AppMethodBeat.o(208297);
      return;
    }
    ae.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, pass", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    AppMethodBeat.o(208297);
  }
  
  public String checkAllHotWords(String paramString)
  {
    AppMethodBeat.i(208300);
    paramString = c.Xu(paramString);
    AppMethodBeat.o(208300);
    return paramString;
  }
  
  public boolean checkIfHasHotWord(String paramString)
  {
    AppMethodBeat.i(208299);
    boolean bool = c.Xt(paramString);
    AppMethodBeat.o(208299);
    return bool;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(76323);
    if (paramg.akL()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.box.a.b.class, new b());
    }
    AppMethodBeat.o(76323);
  }
  
  public int getSearchDuration()
  {
    AppMethodBeat.i(208302);
    int i = c.getSearchDuration();
    AppMethodBeat.o(208302);
    return i;
  }
  
  public String getWordBankVersionForStat()
  {
    AppMethodBeat.i(208301);
    String str = c.getWordBankVersionForStat();
    AppMethodBeat.o(208301);
    return str;
  }
  
  public boolean isInitBox()
  {
    AppMethodBeat.i(76325);
    if ((this.oaN) && (ad.WL(2) != 1))
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
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("functionmsg", this.oaL.oas);
    this.jkx.alive();
    this.oaM.alive();
    loadFlightNumberAsync();
    loadWordBankAsync();
    AppMethodBeat.o(76321);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(76322);
    this.jkx.dead();
    this.oaM.dead();
    AppMethodBeat.o(76322);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.box.PluginBox
 * JD-Core Version:    0.7.0.1
 */