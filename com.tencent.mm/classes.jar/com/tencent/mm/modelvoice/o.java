package com.tencent.mm.modelvoice;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.co;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import junit.framework.Assert;

public class o
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.app.o.a appForegroundListener;
  private i iAa;
  private t iAb;
  private c iAc;
  private w izY;
  private co izZ;
  
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
        return co.SQL_CREATE;
      }
    });
    AppMethodBeat.o(148445);
  }
  
  public o()
  {
    AppMethodBeat.i(148438);
    this.iAb = new t();
    this.iAc = new c() {};
    this.appForegroundListener = new com.tencent.mm.app.o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(148436);
        if ((g.ajM()) && (g.ajP().gDk))
        {
          g.ajP();
          com.tencent.mm.kernel.a.aiT();
        }
        AppMethodBeat.o(148436);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(148435);
        if ((g.ajM()) && (g.ajP().gDk))
        {
          g.ajP();
          if (!com.tencent.mm.kernel.a.aiT()) {
            com.tencent.mm.blink.b.Wq().u(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148434);
                o.aNY().run();
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
  
  private static o aNV()
  {
    AppMethodBeat.i(148439);
    o localo = (o)u.ap(o.class);
    AppMethodBeat.o(148439);
    return localo;
  }
  
  public static w aNW()
  {
    AppMethodBeat.i(148440);
    g.ajP().aiU();
    if (aNV().izY == null) {
      if (g.ajR().gDX == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      aNV().izY = new w(g.ajR().gDX);
      w localw = aNV().izY;
      AppMethodBeat.o(148440);
      return localw;
    }
  }
  
  public static co aNX()
  {
    AppMethodBeat.i(148441);
    g.ajP().aiU();
    if (aNV().izZ == null) {
      if (g.ajR().gDX == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      aNV().izZ = new co(g.ajR().gDX);
      co localco = aNV().izZ;
      AppMethodBeat.o(148441);
      return localco;
    }
  }
  
  public static i aNY()
  {
    AppMethodBeat.i(148442);
    g.ajP().aiU();
    if (aNV().iAa == null) {
      aNV().iAa = i.Qc();
    }
    ae.i("MicroMsg.SubCoreVoice", "getVoiceService %s", new Object[] { aNV().iAa.toString() });
    i locali = aNV().iAa;
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
    e.d.a(Integer.valueOf(34), this.iAb);
    com.tencent.mm.sdk.b.a.IvT.c(this.iAc);
    this.appForegroundListener.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[] { "//voicetrymore" });
    AppMethodBeat.o(148444);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(148443);
    if (aNV().iAa != null) {
      aNV().iAa.dju = 0;
    }
    this.appForegroundListener.dead();
    e.d.b(Integer.valueOf(34), this.iAb);
    com.tencent.mm.sdk.b.a.IvT.d(this.iAc);
    com.tencent.mm.pluginsdk.cmd.b.S(new String[] { "//voicetrymore" });
    AppMethodBeat.o(148443);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  static final class a
    implements com.tencent.mm.pluginsdk.cmd.a
  {
    public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
    {
      AppMethodBeat.i(148437);
      paramContext = paramArrayOfString[0];
      int i = -1;
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      do
      {
        AppMethodBeat.o(148437);
        return false;
        if (!paramContext.equals("//voicetrymore")) {
          break;
        }
        i = 0;
        break;
      } while ((paramArrayOfString.length <= 1) || (paramArrayOfString[1] == null));
      i = bu.getInt(paramArrayOfString[1], 1);
      if (i == 1) {}
      for (boolean bool = true;; bool = false)
      {
        i.djx = bool;
        ae.i("MicroMsg.SubCoreVoice", "summervoicetrymore enable[%d]", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(148437);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.o
 * JD-Core Version:    0.7.0.1
 */