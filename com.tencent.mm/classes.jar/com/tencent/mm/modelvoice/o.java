package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.app.n.a;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ch;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import junit.framework.Assert;

public class o
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private n.a appForegroundListener;
  private w idK;
  private ch idL;
  private i idM;
  private t idN;
  private c idO;
  
  static
  {
    AppMethodBeat.i(148445);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("VOICE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return w.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("VOICETRANSTEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ch.SQL_CREATE;
      }
    });
    AppMethodBeat.o(148445);
  }
  
  public o()
  {
    AppMethodBeat.i(148438);
    this.idN = new t();
    this.idO = new c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(148436);
        if ((g.agM()) && (g.agP().ggT))
        {
          g.agP();
          com.tencent.mm.kernel.a.afS();
        }
        AppMethodBeat.o(148436);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(148435);
        if ((g.agM()) && (g.agP().ggT))
        {
          g.agP();
          if (!com.tencent.mm.kernel.a.afS()) {
            com.tencent.mm.blink.b.TR().w(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148434);
                o.aKr().run();
                AppMethodBeat.o(148434);
              }
            });
          }
        }
        AppMethodBeat.o(148435);
      }
    };
    AppMethodBeat.o(148438);
  }
  
  private static o aKo()
  {
    AppMethodBeat.i(148439);
    o localo = (o)com.tencent.mm.model.t.ap(o.class);
    AppMethodBeat.o(148439);
    return localo;
  }
  
  public static w aKp()
  {
    AppMethodBeat.i(148440);
    g.agP().afT();
    if (aKo().idK == null) {
      if (g.agR().ghG == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      aKo().idK = new w(g.agR().ghG);
      w localw = aKo().idK;
      AppMethodBeat.o(148440);
      return localw;
    }
  }
  
  public static ch aKq()
  {
    AppMethodBeat.i(148441);
    g.agP().afT();
    if (aKo().idL == null) {
      if (g.agR().ghG == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      aKo().idL = new ch(g.agR().ghG);
      ch localch = aKo().idL;
      AppMethodBeat.o(148441);
      return localch;
    }
  }
  
  public static i aKr()
  {
    AppMethodBeat.i(148442);
    g.agP().afT();
    if (aKo().idM == null) {
      aKo().idM = i.EF();
    }
    ac.i("MicroMsg.SubCoreVoice", "getVoiceService %s", new Object[] { aKo().idM.toString() });
    i locali = aKo().idM;
    AppMethodBeat.o(148442);
    return locali;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(148444);
    f.d.a(Integer.valueOf(34), this.idN);
    com.tencent.mm.sdk.b.a.GpY.c(this.idO);
    this.appForegroundListener.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new o.a(), new String[] { "//voicetrymore" });
    AppMethodBeat.o(148444);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(148443);
    if (aKo().idM != null) {
      aKo().idM.cXb = 0;
    }
    this.appForegroundListener.dead();
    f.d.b(Integer.valueOf(34), this.idN);
    com.tencent.mm.sdk.b.a.GpY.d(this.idO);
    com.tencent.mm.pluginsdk.cmd.b.Q(new String[] { "//voicetrymore" });
    AppMethodBeat.o(148443);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.o
 * JD-Core Version:    0.7.0.1
 */