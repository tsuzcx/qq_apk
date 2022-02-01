package com.tencent.mm.modelvoice;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.d;
import com.tencent.mm.app.n.a;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.cn;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import junit.framework.Assert;

public class o
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private n.a appForegroundListener;
  private w ixf;
  private cn ixg;
  private i ixh;
  private t ixi;
  private c ixj;
  
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
        return cn.SQL_CREATE;
      }
    });
    AppMethodBeat.o(148445);
  }
  
  public o()
  {
    AppMethodBeat.i(148438);
    this.ixi = new t();
    this.ixj = new c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(148436);
        if ((g.ajx()) && (g.ajA().gAD))
        {
          g.ajA();
          com.tencent.mm.kernel.a.aiE();
        }
        AppMethodBeat.o(148436);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(148435);
        if ((g.ajx()) && (g.ajA().gAD))
        {
          g.ajA();
          if (!com.tencent.mm.kernel.a.aiE()) {
            com.tencent.mm.blink.b.Wi().w(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148434);
                o.aNA().run();
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
  
  public static i aNA()
  {
    AppMethodBeat.i(148442);
    g.ajA().aiF();
    if (aNx().ixh == null) {
      aNx().ixh = i.Qd();
    }
    ad.i("MicroMsg.SubCoreVoice", "getVoiceService %s", new Object[] { aNx().ixh.toString() });
    i locali = aNx().ixh;
    AppMethodBeat.o(148442);
    return locali;
  }
  
  private static o aNx()
  {
    AppMethodBeat.i(148439);
    o localo = (o)com.tencent.mm.model.t.ap(o.class);
    AppMethodBeat.o(148439);
    return localo;
  }
  
  public static w aNy()
  {
    AppMethodBeat.i(148440);
    g.ajA().aiF();
    if (aNx().ixf == null) {
      if (g.ajC().gBq == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      aNx().ixf = new w(g.ajC().gBq);
      w localw = aNx().ixf;
      AppMethodBeat.o(148440);
      return localw;
    }
  }
  
  public static cn aNz()
  {
    AppMethodBeat.i(148441);
    g.ajA().aiF();
    if (aNx().ixg == null) {
      if (g.ajC().gBq == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      aNx().ixg = new cn(g.ajC().gBq);
      cn localcn = aNx().ixg;
      AppMethodBeat.o(148441);
      return localcn;
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
    e.d.a(Integer.valueOf(34), this.ixi);
    com.tencent.mm.sdk.b.a.IbL.c(this.ixj);
    this.appForegroundListener.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[] { "//voicetrymore" });
    AppMethodBeat.o(148444);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(148443);
    if (aNx().ixh != null) {
      aNx().ixh.dis = 0;
    }
    this.appForegroundListener.dead();
    e.d.b(Integer.valueOf(34), this.ixi);
    com.tencent.mm.sdk.b.a.IbL.d(this.ixj);
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
      i = bt.getInt(paramArrayOfString[1], 1);
      if (i == 1) {}
      for (boolean bool = true;; bool = false)
      {
        i.div = bool;
        ad.i("MicroMsg.SubCoreVoice", "summervoicetrymore enable[%d]", new Object[] { Integer.valueOf(i) });
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