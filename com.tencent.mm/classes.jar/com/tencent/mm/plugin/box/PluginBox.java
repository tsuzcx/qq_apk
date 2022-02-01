package com.tencent.mm.plugin.box;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginBox
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, d
{
  private boolean isLoading;
  private IListener kiA;
  a plH;
  private IListener plI;
  private boolean plJ;
  
  public PluginBox()
  {
    AppMethodBeat.i(76320);
    this.plH = new a();
    this.kiA = new IListener() {};
    this.plI = new IListener() {};
    this.plJ = false;
    this.isLoading = false;
    AppMethodBeat.o(76320);
  }
  
  public static String getBoxFlightResPath()
  {
    AppMethodBeat.i(76326);
    String str = aa.z(new o(new o(ai.afr(2).fYs()).heq(), "flight.txt").her());
    AppMethodBeat.o(76326);
    return str;
  }
  
  private void loadFlightNumberAsync()
  {
    AppMethodBeat.i(76324);
    com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.shF;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (localb.a(locala, com.tencent.mm.util.c.hdd()) == 0)
    {
      AppMethodBeat.o(76324);
      return;
    }
    h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196204);
        long l = System.currentTimeMillis();
        for (;;)
        {
          try
          {
            int i;
            if (!PluginBox.this.isLoading)
            {
              Log.i("MicroMsg.Box.PluginBox", "start to load flight number");
              PluginBox.access$202(PluginBox.this, true);
              if (!com.tencent.mm.vfs.s.YS(PluginBox.getBoxFlightResPath()))
              {
                Log.i("MicroMsg.Box.PluginBox", "flight number file not exist");
                return;
              }
              String[] arrayOfString = new String(com.tencent.mm.vfs.s.aW(PluginBox.getBoxFlightResPath(), 0, -1)).split("\n");
              com.tencent.mm.pluginsdk.ui.span.c localc = com.tencent.mm.pluginsdk.ui.span.c.KqA;
              localc.Kqz = null;
              localc.Kqx = 0;
              localc.Kqy = 0;
              i = 0;
              if (i < arrayOfString.length)
              {
                if (!Util.isNullOrNil(arrayOfString[i])) {
                  com.tencent.mm.pluginsdk.ui.span.c.KqA.bff(arrayOfString[i]);
                }
              }
              else
              {
                PluginBox.access$302(PluginBox.this, true);
                Log.i("MicroMsg.Box.PluginBox", "load flight number success NodeCount：%d CharacterCount：%d useTime: %d", new Object[] { Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.c.KqA.Kqy), Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.c.KqA.Kqx), Long.valueOf(System.currentTimeMillis() - l) });
              }
            }
            else
            {
              Log.i("MicroMsg.Box.PluginBox", "flight number is loading");
              continue;
            }
            i += 1;
          }
          catch (Exception localException)
          {
            com.tencent.mm.plugin.box.a.a.pl(0);
            Log.printErrStackTrace("MicroMsg.Box.PluginBox", localException, localException.getMessage(), new Object[0]);
            return;
          }
          finally
          {
            PluginBox.access$202(PluginBox.this, false);
            AppMethodBeat.o(196204);
          }
        }
      }
    }, "Box.LoadFlightNumberAsync");
    AppMethodBeat.o(76324);
  }
  
  private void loadWordBankAsync()
  {
    AppMethodBeat.i(196206);
    h.RTc.b(c.plC, "box.HotWordSearchModel");
    AppMethodBeat.o(196206);
  }
  
  private void updateWordBankRes(final String paramString)
  {
    AppMethodBeat.i(196205);
    int i = c.ckV();
    int j = c.ahs(paramString);
    if (j > i)
    {
      Log.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, start to update", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196203);
          try
          {
            if (c.aht(paramString) == 0)
            {
              c.kh(true);
              c.aho(c.ki(false));
            }
            AppMethodBeat.o(196203);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.Box.PluginBox", localException, "[updateWordBankRes]", new Object[0]);
            AppMethodBeat.o(196203);
          }
        }
      }, "box.HotWordSearchModel");
      AppMethodBeat.o(196205);
      return;
    }
    Log.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, pass", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    AppMethodBeat.o(196205);
  }
  
  public String checkAllHotWords(String paramString)
  {
    AppMethodBeat.i(196208);
    ArrayList localArrayList = new ArrayList();
    Object localObject = com.tencent.mm.plugin.box.a.b.plL.matcher(paramString);
    if (((Matcher)localObject).find())
    {
      localObject = ((Matcher)localObject).group();
      if ((((String)localObject).length() <= 15) && (((String)localObject).length() >= 13)) {
        localArrayList.add("$Express$");
      }
    }
    localArrayList.addAll(c.ahr(paramString));
    paramString = Util.listToString(localArrayList, "|");
    AppMethodBeat.o(196208);
    return paramString;
  }
  
  public String checkFirstHotWord(String paramString)
  {
    AppMethodBeat.i(196209);
    Object localObject = com.tencent.mm.plugin.box.a.b.plL.matcher(paramString);
    if (((Matcher)localObject).find())
    {
      localObject = ((Matcher)localObject).group();
      if ((((String)localObject).length() <= 15) && (((String)localObject).length() >= 13))
      {
        AppMethodBeat.o(196209);
        return "$Express$";
      }
    }
    paramString = c.ahq(paramString);
    AppMethodBeat.o(196209);
    return paramString;
  }
  
  public boolean checkIfHasHotWord(String paramString)
  {
    AppMethodBeat.i(196207);
    boolean bool = c.ahp(paramString);
    AppMethodBeat.o(196207);
    return bool;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(76323);
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.box.a.c.class, new b());
    }
    AppMethodBeat.o(76323);
  }
  
  public String getExposedFingerWord(String paramString)
  {
    AppMethodBeat.i(196211);
    if ("$Express$".equals(paramString))
    {
      paramString = ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getExposedWord("express");
      AppMethodBeat.o(196211);
      return paramString;
    }
    AppMethodBeat.o(196211);
    return paramString;
  }
  
  public String getMatchedFingerWord(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196210);
    if ("$Express$".equals(paramString1))
    {
      paramString2 = com.tencent.mm.plugin.box.a.b.plL.matcher(paramString2);
      if (paramString2.find())
      {
        paramString2 = paramString2.group();
        if ((paramString2.length() <= 15) && (paramString2.length() >= 13))
        {
          AppMethodBeat.o(196210);
          return paramString2;
        }
      }
    }
    AppMethodBeat.o(196210);
    return paramString1;
  }
  
  public int getSearchDuration()
  {
    AppMethodBeat.i(196213);
    int i = c.getSearchDuration();
    AppMethodBeat.o(196213);
    return i;
  }
  
  public String getWordBankVersionForStat()
  {
    AppMethodBeat.i(196212);
    String str = c.getWordBankVersionForStat();
    AppMethodBeat.o(196212);
    return str;
  }
  
  public boolean isInitBox()
  {
    AppMethodBeat.i(76325);
    if ((this.plJ) && (ai.aft(2) != 1))
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
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("functionmsg", this.plH.plo);
    this.kiA.alive();
    this.plI.alive();
    loadFlightNumberAsync();
    loadWordBankAsync();
    AppMethodBeat.o(76321);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(76322);
    this.kiA.dead();
    this.plI.dead();
    AppMethodBeat.o(76322);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.PluginBox
 * JD-Core Version:    0.7.0.1
 */