package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.app.j.a;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.cd;
import java.util.HashMap;
import junit.framework.Assert;

public class o
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private j.a appForegroundListener;
  private c gaA;
  private w gaw;
  private cd gax;
  private i gay;
  private t gaz;
  
  static
  {
    AppMethodBeat.i(116604);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("VOICE_TABLE".hashCode()), new o.3());
    baseDBFactories.put(Integer.valueOf("VOICETRANSTEXT_TABLE".hashCode()), new o.4());
    AppMethodBeat.o(116604);
  }
  
  public o()
  {
    AppMethodBeat.i(116597);
    this.gaz = new t();
    this.gaA = new o.1(this);
    this.appForegroundListener = new j.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(145812);
        if ((g.RG()) && (g.RJ().eHg))
        {
          g.RJ();
          com.tencent.mm.kernel.a.QP();
        }
        AppMethodBeat.o(145812);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(145811);
        if ((g.RG()) && (g.RJ().eHg))
        {
          g.RJ();
          if (!com.tencent.mm.kernel.a.QP()) {
            com.tencent.mm.blink.b.HP().o(new o.2.1(this));
          }
        }
        AppMethodBeat.o(145811);
      }
    };
    AppMethodBeat.o(116597);
  }
  
  private static o amr()
  {
    AppMethodBeat.i(116598);
    o localo = (o)q.S(o.class);
    AppMethodBeat.o(116598);
    return localo;
  }
  
  public static w ams()
  {
    AppMethodBeat.i(116599);
    g.RJ().QQ();
    if (amr().gaw == null) {
      if (g.RL().eHS == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      amr().gaw = new w(g.RL().eHS);
      w localw = amr().gaw;
      AppMethodBeat.o(116599);
      return localw;
    }
  }
  
  public static cd amt()
  {
    AppMethodBeat.i(116600);
    g.RJ().QQ();
    if (amr().gax == null) {
      if (g.RL().eHS == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      amr().gax = new cd(g.RL().eHS);
      cd localcd = amr().gax;
      AppMethodBeat.o(116600);
      return localcd;
    }
  }
  
  public static i amu()
  {
    AppMethodBeat.i(116601);
    g.RJ().QQ();
    if (amr().gay == null) {
      amr().gay = new i();
    }
    i locali = amr().gay;
    AppMethodBeat.o(116601);
    return locali;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(116603);
    e.d.a(Integer.valueOf(34), this.gaz);
    com.tencent.mm.sdk.b.a.ymk.c(this.gaA);
    this.appForegroundListener.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new o.a(), new String[] { "//voicetrymore" });
    AppMethodBeat.o(116603);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116602);
    if (amr().gay != null) {
      amr().gay.ckM = 0;
    }
    this.appForegroundListener.dead();
    e.d.b(Integer.valueOf(34), this.gaz);
    com.tencent.mm.sdk.b.a.ymk.d(this.gaA);
    com.tencent.mm.pluginsdk.cmd.b.N(new String[] { "//voicetrymore" });
    AppMethodBeat.o(116602);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.o
 * JD-Core Version:    0.7.0.1
 */