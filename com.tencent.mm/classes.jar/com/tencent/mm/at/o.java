package com.tencent.mm.at;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.app.j.a;
import com.tencent.mm.cache.f.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class o
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private j.a appForegroundListener;
  private g fGA;
  private i fGB;
  private c fGC;
  private j fGD;
  private d fGE;
  private h fGF;
  private b fGG;
  private p fGH;
  private com.tencent.mm.sdk.b.c fGI;
  private com.tencent.mm.at.a.a fGJ;
  private SFSContext fGK;
  private SFSContext fGL;
  
  static
  {
    AppMethodBeat.i(78394);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("IMGINFO_TABLE".hashCode()), new o.3());
    AppMethodBeat.o(78394);
  }
  
  public o()
  {
    AppMethodBeat.i(78383);
    this.fGD = new j();
    this.fGE = null;
    this.fGF = new h();
    this.fGG = null;
    this.fGH = null;
    this.fGI = new o.1(this);
    this.appForegroundListener = new o.2(this);
    this.fGJ = null;
    this.fGK = null;
    this.fGL = null;
    AppMethodBeat.o(78383);
  }
  
  public static i ahA()
  {
    AppMethodBeat.i(78385);
    if (ahz().fGB == null) {
      ahz().fGB = new i();
    }
    i locali = ahz().fGB;
    AppMethodBeat.o(78385);
    return locali;
  }
  
  public static c ahB()
  {
    AppMethodBeat.i(78386);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (ahz().fGC == null) {
      ahz().fGC = new c();
    }
    c localc = ahz().fGC;
    AppMethodBeat.o(78386);
    return localc;
  }
  
  public static g ahC()
  {
    AppMethodBeat.i(78387);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (ahz().fGA == null) {
      ahz().fGA = new g(com.tencent.mm.kernel.g.RL().eHS);
    }
    g localg = ahz().fGA;
    AppMethodBeat.o(78387);
    return localg;
  }
  
  public static d ahD()
  {
    AppMethodBeat.i(78388);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (ahz().fGE == null) {
      ahz().fGE = new d();
    }
    d locald = ahz().fGE;
    AppMethodBeat.o(78388);
    return locald;
  }
  
  public static b ahE()
  {
    AppMethodBeat.i(78389);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (ahz().fGG == null) {
      ahz().fGG = new b(Looper.getMainLooper());
    }
    b localb = ahz().fGG;
    AppMethodBeat.o(78389);
    return localb;
  }
  
  public static p ahF()
  {
    AppMethodBeat.i(78390);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (ahz().fGH == null) {
      ahz().fGH = new p();
    }
    p localp = ahz().fGH;
    AppMethodBeat.o(78390);
    return localp;
  }
  
  public static com.tencent.mm.at.a.a ahG()
  {
    AppMethodBeat.i(78391);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (ahz().fGJ == null) {
      ahz().fGJ = com.tencent.mm.at.a.a.ahM();
    }
    com.tencent.mm.at.a.a locala = ahz().fGJ;
    AppMethodBeat.o(78391);
    return locala;
  }
  
  public static SFSContext ahH()
  {
    return null;
  }
  
  private static o ahz()
  {
    try
    {
      AppMethodBeat.i(78384);
      o localo = (o)q.S(o.class);
      AppMethodBeat.o(78384);
      return localo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(78393);
    e.d.a(Integer.valueOf(3), this.fGF);
    e.d.a(Integer.valueOf(23), this.fGF);
    f.a.a("local_cdn_img_cache", this.fGD);
    com.tencent.mm.sdk.b.a.ymk.c(this.fGI);
    this.appForegroundListener.alive();
    AppMethodBeat.o(78393);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(78392);
    o localo = ahz();
    this.appForegroundListener.dead();
    if (localo.fGB != null)
    {
      ??? = localo.fGB;
      ((i)???).ckM = 0;
      com.tencent.mm.kernel.g.RK().eHt.b(110, (com.tencent.mm.ai.f)???);
    }
    b localb;
    if (localo.fGG != null) {
      localb = localo.fGG;
    }
    synchronized (localb.fDi)
    {
      localb.fDi.clear();
      localb.fDj = 0L;
      ahD().a(localb);
      com.tencent.mm.sdk.b.a.ymk.d(localb.fDu);
      com.tencent.mm.sdk.b.a.ymk.d(localb.fDv);
      if (localo.fGE == null) {
        break label210;
      }
      ??? = localo.fGE;
      ab.i("ModelImage.DownloadImgService", "on detach");
      ab.i("ModelImage.DownloadImgService", "cancel all net scene");
      ((d)???).fDE = true;
      ((d)???).b(((d)???).fDC);
      if (((d)???).fDA.size() > 0) {
        ((d)???).b((d.b)((d)???).fDA.get(0));
      }
    }
    ((d)???).ahe();
    com.tencent.mm.kernel.g.RK().eHt.b(109, (com.tencent.mm.ai.f)???);
    label210:
    if (localObject1.fGH != null)
    {
      ??? = localObject1.fGH;
      ab.i("MicroMsg.UrlImageCacheService", "detach");
      ((p)???).fGO.clear();
      ((p)???).fGQ = true;
    }
    ??? = ahz().fGA;
    if (??? != null)
    {
      ab.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[] { bo.dtY() });
      ((g)???).fEu.clear();
    }
    ??? = ahz().fGJ;
    if (??? != null) {
      ((com.tencent.mm.at.a.a)???).detach();
    }
    e.d.b(Integer.valueOf(3), this.fGF);
    e.d.b(Integer.valueOf(23), this.fGF);
    f.a.a("local_cdn_img_cache", null);
    com.tencent.mm.sdk.b.a.ymk.d(this.fGI);
    if (localObject1.fGJ != null)
    {
      localObject1.fGJ.detach();
      localObject1.fGJ = null;
    }
    if (localObject1.fGK != null)
    {
      localObject1.fGK.release();
      localObject1.fGK = null;
    }
    if (localObject1.fGL != null)
    {
      localObject1.fGL.release();
      localObject1.fGL = null;
    }
    AppMethodBeat.o(78392);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.o
 * JD-Core Version:    0.7.0.1
 */