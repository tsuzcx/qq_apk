package com.tencent.mm.ay;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.f.a.uy;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class q
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static byte[] lQN;
  private o.a appForegroundListener;
  private i lQB;
  private k lQC;
  private d lQD;
  private l lQE;
  private e lQF;
  private j lQG;
  private b lQH;
  private r lQI;
  private IListener lQJ;
  private a lQK;
  private SFSContext lQL;
  private SFSContext lQM;
  
  static
  {
    AppMethodBeat.i(150759);
    lQN = new byte[0];
    baseDBFactories = new HashMap();
    Iterator localIterator = i.d.lOO.iterator();
    while (localIterator.hasNext())
    {
      i.c localc = (i.c)localIterator.next();
      baseDBFactories.put(Integer.valueOf(localc.table.hashCode()), new h.b()
      {
        public final String[] getSQLs()
        {
          return this.lQQ.lOL;
        }
      });
    }
    AppMethodBeat.o(150759);
  }
  
  public q()
  {
    AppMethodBeat.i(150748);
    this.lQE = new l();
    this.lQF = null;
    this.lQG = new j();
    this.lQH = null;
    this.lQI = null;
    this.lQJ = new IListener() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(150747);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          if (!com.tencent.mm.kernel.b.aGE()) {
            q.bmj().setForeground(false);
          }
        }
        AppMethodBeat.o(150747);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(150746);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          if (!com.tencent.mm.kernel.b.aGE())
          {
            com.tencent.mm.blink.b.aqa().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150745);
                q.bmf().run();
                AppMethodBeat.o(150745);
              }
            });
            q.bmj().setForeground(true);
          }
        }
        AppMethodBeat.o(150746);
      }
    };
    this.lQK = null;
    this.lQL = null;
    this.lQM = null;
    AppMethodBeat.o(150748);
  }
  
  private static q bme()
  {
    AppMethodBeat.i(150749);
    synchronized (lQN)
    {
      q localq = (q)y.as(q.class);
      AppMethodBeat.o(150749);
      return localq;
    }
  }
  
  public static k bmf()
  {
    AppMethodBeat.i(150750);
    if (bme().lQC == null) {
      bme().lQC = new k();
    }
    k localk = bme().lQC;
    AppMethodBeat.o(150750);
    return localk;
  }
  
  public static d bmg()
  {
    AppMethodBeat.i(150751);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bme().lQD == null) {
      bme().lQD = new d();
    }
    d locald = bme().lQD;
    AppMethodBeat.o(150751);
    return locald;
  }
  
  public static i bmh()
  {
    AppMethodBeat.i(150752);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bme().lQB == null) {
      bme().lQB = new i(com.tencent.mm.kernel.h.aHG().kcF);
    }
    i locali = bme().lQB;
    AppMethodBeat.o(150752);
    return locali;
  }
  
  public static e bmi()
  {
    AppMethodBeat.i(150753);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bme().lQF == null) {
      bme().lQF = new e();
    }
    e locale = bme().lQF;
    AppMethodBeat.o(150753);
    return locale;
  }
  
  public static b bmj()
  {
    AppMethodBeat.i(150754);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bme().lQH == null) {
      bme().lQH = new b(Looper.getMainLooper());
    }
    b localb = bme().lQH;
    AppMethodBeat.o(150754);
    return localb;
  }
  
  public static r bmk()
  {
    AppMethodBeat.i(150755);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bme().lQI == null) {
      bme().lQI = new r();
    }
    r localr = bme().lQI;
    AppMethodBeat.o(150755);
    return localr;
  }
  
  public static a bml()
  {
    AppMethodBeat.i(150756);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bme().lQK == null) {
      bme().lQK = a.bms();
    }
    a locala = bme().lQK;
    AppMethodBeat.o(150756);
    return locala;
  }
  
  public static SFSContext bmm()
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
    h.d.a(Integer.valueOf(3), this.lQG);
    h.d.a(Integer.valueOf(23), this.lQG);
    g.a.a("local_cdn_img_cache", this.lQE);
    EventCenter.instance.addListener(this.lQJ);
    this.appForegroundListener.alive();
    AppMethodBeat.o(150758);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150757);
    q localq = bme();
    this.appForegroundListener.dead();
    if (localq.lQC != null)
    {
      ??? = localq.lQC;
      ((k)???).ftu = 0;
      com.tencent.mm.kernel.h.aHF().kcd.b(110, (com.tencent.mm.an.i)???);
    }
    b localb;
    if (localq.lQH != null) {
      localb = localq.lQH;
    }
    synchronized (localb.lNd)
    {
      localb.lNd.clear();
      localb.lNe = 0L;
      bmi().a(localb);
      EventCenter.instance.removeListener(localb.lNn);
      EventCenter.instance.removeListener(localb.lNo);
      if (localq.lQF != null)
      {
        ??? = localq.lQF;
        Log.i("ModelImage.DownloadImgService", "on detach");
        Log.i("ModelImage.DownloadImgService", "cancel all net scene");
        ((e)???).lNA = true;
        ((e)???).b(((e)???).lNy);
        if (((e)???).lNw.size() > 0) {
          ((e)???).b((e.b)((e)???).lNw.get(0));
        }
      }
    }
    if (localObject1.lQI != null)
    {
      ??? = localObject1.lQI;
      Log.i("MicroMsg.UrlImageCacheService", "detach");
      if (!MMHandlerThread.isMainThread()) {
        break label401;
      }
      ((r)???).bmn();
    }
    for (;;)
    {
      ??? = bme().lQB;
      if (??? != null)
      {
        Log.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[] { Util.getStack() });
        ((i)???).lOq.clear();
      }
      ??? = bme().lQK;
      if (??? != null) {
        ((a)???).detach();
      }
      h.d.b(Integer.valueOf(3), this.lQG);
      h.d.b(Integer.valueOf(23), this.lQG);
      g.a.a("local_cdn_img_cache", null);
      EventCenter.instance.removeListener(this.lQJ);
      if (localObject1.lQK != null)
      {
        localObject1.lQK.detach();
        localObject1.lQK = null;
      }
      if (localObject1.lQL != null)
      {
        localObject1.lQL.release();
        localObject1.lQL = null;
      }
      if (localObject1.lQM != null)
      {
        localObject1.lQM.release();
        localObject1.lQM = null;
      }
      AppMethodBeat.o(150757);
      return;
      label401:
      com.tencent.e.h.ZvG.bc(new r.3((r)???));
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.q
 * JD-Core Version:    0.7.0.1
 */