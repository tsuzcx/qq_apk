package com.tencent.mm.av;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class q
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private o.a appForegroundListener;
  private i jah;
  private k jai;
  private d jaj;
  private l jak;
  private e jal;
  private j jam;
  private b jan;
  private r jao;
  private IListener jap;
  private com.tencent.mm.av.a.a jaq;
  private SFSContext jar;
  private SFSContext jas;
  
  static
  {
    AppMethodBeat.i(150759);
    baseDBFactories = new HashMap();
    Iterator localIterator = i.d.iYu.iterator();
    while (localIterator.hasNext())
    {
      i.c localc = (i.c)localIterator.next();
      baseDBFactories.put(Integer.valueOf(localc.table.hashCode()), new h.b()
      {
        public final String[] getSQLs()
        {
          return this.jav.iYr;
        }
      });
    }
    AppMethodBeat.o(150759);
  }
  
  public q()
  {
    AppMethodBeat.i(150748);
    this.jak = new l();
    this.jal = null;
    this.jam = new j();
    this.jan = null;
    this.jao = null;
    this.jap = new IListener() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(150747);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          if (!com.tencent.mm.kernel.a.azj()) {
            q.bcT().setForeground(false);
          }
        }
        AppMethodBeat.o(150747);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(150746);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          if (!com.tencent.mm.kernel.a.azj())
          {
            com.tencent.mm.blink.b.ake().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150745);
                q.bcP().run();
                AppMethodBeat.o(150745);
              }
            });
            q.bcT().setForeground(true);
          }
        }
        AppMethodBeat.o(150746);
      }
    };
    this.jaq = null;
    this.jar = null;
    this.jas = null;
    AppMethodBeat.o(150748);
  }
  
  private static q bcO()
  {
    try
    {
      AppMethodBeat.i(150749);
      q localq = (q)y.at(q.class);
      AppMethodBeat.o(150749);
      return localq;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static k bcP()
  {
    AppMethodBeat.i(150750);
    if (bcO().jai == null) {
      bcO().jai = new k();
    }
    k localk = bcO().jai;
    AppMethodBeat.o(150750);
    return localk;
  }
  
  public static d bcQ()
  {
    AppMethodBeat.i(150751);
    g.aAf().azk();
    if (bcO().jaj == null) {
      bcO().jaj = new d();
    }
    d locald = bcO().jaj;
    AppMethodBeat.o(150751);
    return locald;
  }
  
  public static i bcR()
  {
    AppMethodBeat.i(150752);
    g.aAf().azk();
    if (bcO().jah == null) {
      bcO().jah = new i(g.aAh().hqK);
    }
    i locali = bcO().jah;
    AppMethodBeat.o(150752);
    return locali;
  }
  
  public static e bcS()
  {
    AppMethodBeat.i(150753);
    g.aAf().azk();
    if (bcO().jal == null) {
      bcO().jal = new e();
    }
    e locale = bcO().jal;
    AppMethodBeat.o(150753);
    return locale;
  }
  
  public static b bcT()
  {
    AppMethodBeat.i(150754);
    g.aAf().azk();
    if (bcO().jan == null) {
      bcO().jan = new b(Looper.getMainLooper());
    }
    b localb = bcO().jan;
    AppMethodBeat.o(150754);
    return localb;
  }
  
  public static r bcU()
  {
    AppMethodBeat.i(150755);
    g.aAf().azk();
    if (bcO().jao == null) {
      bcO().jao = new r();
    }
    r localr = bcO().jao;
    AppMethodBeat.o(150755);
    return localr;
  }
  
  public static com.tencent.mm.av.a.a bcV()
  {
    AppMethodBeat.i(150756);
    g.aAf().azk();
    if (bcO().jaq == null) {
      bcO().jaq = com.tencent.mm.av.a.a.bdb();
    }
    com.tencent.mm.av.a.a locala = bcO().jaq;
    AppMethodBeat.o(150756);
    return locala;
  }
  
  public static SFSContext bcW()
  {
    return null;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150758);
    h.d.a(Integer.valueOf(3), this.jam);
    h.d.a(Integer.valueOf(23), this.jam);
    g.a.a("local_cdn_img_cache", this.jak);
    EventCenter.instance.addListener(this.jap);
    this.appForegroundListener.alive();
    AppMethodBeat.o(150758);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150757);
    q localq = bcO();
    this.appForegroundListener.dead();
    if (localq.jai != null)
    {
      ??? = localq.jai;
      ((k)???).dAF = 0;
      g.aAg().hqi.b(110, (com.tencent.mm.ak.i)???);
    }
    b localb;
    if (localq.jan != null) {
      localb = localq.jan;
    }
    synchronized (localb.iWI)
    {
      localb.iWI.clear();
      localb.iWJ = 0L;
      bcS().a(localb);
      EventCenter.instance.removeListener(localb.iWS);
      EventCenter.instance.removeListener(localb.iWT);
      if (localq.jal == null) {
        break label212;
      }
      ??? = localq.jal;
      Log.i("ModelImage.DownloadImgService", "on detach");
      Log.i("ModelImage.DownloadImgService", "cancel all net scene");
      ((e)???).iXf = true;
      ((e)???).b(((e)???).iXd);
      if (((e)???).iXb.size() > 0) {
        ((e)???).b((e.b)((e)???).iXb.get(0));
      }
    }
    ((e)???).bco();
    g.aAg().hqi.b(109, (com.tencent.mm.ak.i)???);
    label212:
    if (localObject1.jao != null)
    {
      ??? = localObject1.jao;
      Log.i("MicroMsg.UrlImageCacheService", "detach");
      ((r)???).jaw.clear();
      ((r)???).jay = true;
    }
    ??? = bcO().jah;
    if (??? != null)
    {
      Log.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[] { Util.getStack() });
      ((i)???).iXW.clear();
    }
    ??? = bcO().jaq;
    if (??? != null) {
      ((com.tencent.mm.av.a.a)???).detach();
    }
    h.d.b(Integer.valueOf(3), this.jam);
    h.d.b(Integer.valueOf(23), this.jam);
    g.a.a("local_cdn_img_cache", null);
    EventCenter.instance.removeListener(this.jap);
    if (localObject1.jaq != null)
    {
      localObject1.jaq.detach();
      localObject1.jaq = null;
    }
    if (localObject1.jar != null)
    {
      localObject1.jar.release();
      localObject1.jar = null;
    }
    if (localObject1.jas != null)
    {
      localObject1.jas.release();
      localObject1.jas = null;
    }
    AppMethodBeat.o(150757);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.q
 * JD-Core Version:    0.7.0.1
 */