package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.app.n.a;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import junit.framework.Assert;

public class o
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private n.a appForegroundListener;
  private w hDi;
  private ce hDj;
  private i hDk;
  private t hDl;
  private c hDm;
  
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
        return ce.SQL_CREATE;
      }
    });
    AppMethodBeat.o(148445);
  }
  
  public o()
  {
    AppMethodBeat.i(148438);
    this.hDl = new t();
    this.hDm = new c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(148436);
        if ((g.afw()) && (g.afz().gcn))
        {
          g.afz();
          com.tencent.mm.kernel.a.aeC();
        }
        AppMethodBeat.o(148436);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(148435);
        if ((g.afw()) && (g.afz().gcn))
        {
          g.afz();
          if (!com.tencent.mm.kernel.a.aeC()) {
            com.tencent.mm.blink.b.SX().v(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148434);
                o.aDA().run();
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
  
  public static i aDA()
  {
    AppMethodBeat.i(148442);
    g.afz().aeD();
    if (aDx().hDk == null) {
      aDx().hDk = new i();
    }
    i locali = aDx().hDk;
    AppMethodBeat.o(148442);
    return locali;
  }
  
  private static o aDx()
  {
    AppMethodBeat.i(148439);
    o localo = (o)com.tencent.mm.model.t.ap(o.class);
    AppMethodBeat.o(148439);
    return localo;
  }
  
  public static w aDy()
  {
    AppMethodBeat.i(148440);
    g.afz().aeD();
    if (aDx().hDi == null) {
      if (g.afB().gda == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      aDx().hDi = new w(g.afB().gda);
      w localw = aDx().hDi;
      AppMethodBeat.o(148440);
      return localw;
    }
  }
  
  public static ce aDz()
  {
    AppMethodBeat.i(148441);
    g.afz().aeD();
    if (aDx().hDj == null) {
      if (g.afB().gda == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      aDx().hDj = new ce(g.afB().gda);
      ce localce = aDx().hDj;
      AppMethodBeat.o(148441);
      return localce;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(148444);
    f.d.a(Integer.valueOf(34), this.hDl);
    com.tencent.mm.sdk.b.a.ESL.c(this.hDm);
    this.appForegroundListener.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new o.a(), new String[] { "//voicetrymore" });
    AppMethodBeat.o(148444);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(148443);
    if (aDx().hDk != null) {
      aDx().hDk.cZF = 0;
    }
    this.appForegroundListener.dead();
    f.d.b(Integer.valueOf(34), this.hDl);
    com.tencent.mm.sdk.b.a.ESL.d(this.hDm);
    com.tencent.mm.pluginsdk.cmd.b.Q(new String[] { "//voicetrymore" });
    AppMethodBeat.o(148443);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.o
 * JD-Core Version:    0.7.0.1
 */