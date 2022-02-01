package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.f.a.tp;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import junit.framework.Assert;

public class o
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.app.o.a appForegroundListener;
  private w mkP;
  private cw mkQ;
  private i mkR;
  private t mkS;
  private IListener mkT;
  
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
        return cw.SQL_CREATE;
      }
    });
    AppMethodBeat.o(148445);
  }
  
  public o()
  {
    AppMethodBeat.i(148438);
    this.mkS = new t();
    this.mkT = new IListener() {};
    this.appForegroundListener = new com.tencent.mm.app.o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(148436);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          com.tencent.mm.kernel.b.aGE();
        }
        AppMethodBeat.o(148436);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(148435);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          if (!com.tencent.mm.kernel.b.aGE()) {
            com.tencent.mm.blink.b.aqa().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148434);
                o.brB().run();
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
  
  public static cw brA()
  {
    AppMethodBeat.i(148441);
    h.aHE().aGH();
    if (bry().mkQ == null) {
      if (h.aHG().kcF == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      bry().mkQ = new cw(h.aHG().kcF);
      cw localcw = bry().mkQ;
      AppMethodBeat.o(148441);
      return localcw;
    }
  }
  
  public static i brB()
  {
    AppMethodBeat.i(148442);
    h.aHE().aGH();
    if (bry().mkR == null) {
      bry().mkR = i.afj();
    }
    Log.i("MicroMsg.SubCoreVoice", "getVoiceService %s", new Object[] { bry().mkR.toString() });
    i locali = bry().mkR;
    AppMethodBeat.o(148442);
    return locali;
  }
  
  private static o bry()
  {
    AppMethodBeat.i(148439);
    o localo = (o)y.as(o.class);
    AppMethodBeat.o(148439);
    return localo;
  }
  
  public static w brz()
  {
    AppMethodBeat.i(148440);
    h.aHE().aGH();
    if (bry().mkP == null) {
      if (h.aHG().kcF == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      bry().mkP = new w(h.aHG().kcF);
      w localw = bry().mkP;
      AppMethodBeat.o(148440);
      return localw;
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
    h.d.a(Integer.valueOf(34), this.mkS);
    EventCenter.instance.addListener(this.mkT);
    this.appForegroundListener.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new o.a(), new String[] { "//voicetrymore" });
    AppMethodBeat.o(148444);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(148443);
    if (bry().mkR != null) {
      bry().mkR.ftu = 0;
    }
    this.appForegroundListener.dead();
    h.d.b(Integer.valueOf(34), this.mkS);
    EventCenter.instance.removeListener(this.mkT);
    com.tencent.mm.pluginsdk.cmd.b.W(new String[] { "//voicetrymore" });
    AppMethodBeat.o(148443);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.o
 * JD-Core Version:    0.7.0.1
 */