package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.app.q.a;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cz;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import junit.framework.Assert;

public class o
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private q.a appForegroundListener;
  private w peA;
  private cz peB;
  private i peC;
  private t peD;
  private IListener peE;
  
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
        return cz.SQL_CREATE;
      }
    });
    AppMethodBeat.o(148445);
  }
  
  public o()
  {
    AppMethodBeat.i(148438);
    this.peD = new t();
    this.peE = new SubCoreVoice.1(this, com.tencent.mm.app.f.hfK);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(148436);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          com.tencent.mm.kernel.b.aZG();
        }
        AppMethodBeat.o(148436);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(148435);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          if (!com.tencent.mm.kernel.b.aZG()) {
            com.tencent.mm.blink.b.aJY().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148434);
                o.bPh().run();
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
  
  private static o bPe()
  {
    AppMethodBeat.i(148439);
    o localo = (o)y.aL(o.class);
    AppMethodBeat.o(148439);
    return localo;
  }
  
  public static w bPf()
  {
    AppMethodBeat.i(148440);
    h.baC().aZJ();
    if (bPe().peA == null) {
      if (h.baE().mCN == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      bPe().peA = new w(h.baE().mCN);
      w localw = bPe().peA;
      AppMethodBeat.o(148440);
      return localw;
    }
  }
  
  public static cz bPg()
  {
    AppMethodBeat.i(148441);
    h.baC().aZJ();
    if (bPe().peB == null) {
      if (h.baE().mCN == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      bPe().peB = new cz(h.baE().mCN);
      cz localcz = bPe().peB;
      AppMethodBeat.o(148441);
      return localcz;
    }
  }
  
  public static i bPh()
  {
    AppMethodBeat.i(148442);
    h.baC().aZJ();
    if (bPe().peC == null) {
      bPe().peC = i.aHg();
    }
    Log.i("MicroMsg.SubCoreVoice", "getVoiceService %s", new Object[] { bPe().peC.toString() });
    i locali = bPe().peC;
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
    g.d.a(Integer.valueOf(34), this.peD);
    this.peE.alive();
    this.appForegroundListener.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new o.a(), new String[] { "//voicetrymore" });
    AppMethodBeat.o(148444);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(148443);
    if (bPe().peC != null) {
      bPe().peC.hxJ = 0;
    }
    this.appForegroundListener.dead();
    g.d.b(Integer.valueOf(34), this.peD);
    this.peE.dead();
    com.tencent.mm.pluginsdk.cmd.b.X(new String[] { "//voicetrymore" });
    AppMethodBeat.o(148443);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.o
 * JD-Core Version:    0.7.0.1
 */