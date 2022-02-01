package com.tencent.mm.ak;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class p
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private j hNq;
  private e hNr;
  private d hNs;
  private h hNt;
  private av hNu;
  
  static
  {
    AppMethodBeat.i(150331);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return h.SQL_CREATE;
      }
    });
    AppMethodBeat.o(150331);
  }
  
  public p()
  {
    AppMethodBeat.i(150321);
    this.hNu = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new p.3(this), false);
    AppMethodBeat.o(150321);
  }
  
  public static boolean aEA()
  {
    AppMethodBeat.i(150329);
    if (bt.a((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(59, null), false))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    aEk();
    if (e.CZ(u.aAm()))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    String str = u.aAm();
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    Bitmap localBitmap = e.b.Dg(com.tencent.mm.plugin.image.d.azA() + "user_" + com.tencent.mm.b.g.getMessageDigest(str.getBytes()) + ".png");
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    boolean bool = aEk().e(str, localBitmap);
    AppMethodBeat.o(150329);
    return bool;
  }
  
  public static e aEk()
  {
    AppMethodBeat.i(150323);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aEw().hNr == null) {
      aEw().hNr = new e();
    }
    e locale = aEw().hNr;
    AppMethodBeat.o(150323);
    return locale;
  }
  
  public static p aEw()
  {
    AppMethodBeat.i(150320);
    p localp = (p)t.ap(p.class);
    AppMethodBeat.o(150320);
    return localp;
  }
  
  public static j aEx()
  {
    AppMethodBeat.i(150322);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aEw().hNq == null) {
      aEw().hNq = new j(com.tencent.mm.kernel.g.ajC().gBq);
    }
    j localj = aEw().hNq;
    AppMethodBeat.o(150322);
    return localj;
  }
  
  public static h aEy()
  {
    AppMethodBeat.i(150324);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aEw().hNt == null) {
      aEw().hNt = new h(com.tencent.mm.kernel.g.ajC().gBq);
    }
    h localh = aEw().hNt;
    AppMethodBeat.o(150324);
    return localh;
  }
  
  public static d aEz()
  {
    AppMethodBeat.i(150325);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aEw().hNs == null) {
      aEw().hNs = new d();
    }
    d locald = aEw().hNs;
    AppMethodBeat.o(150325);
    return locald;
  }
  
  static Context getContext()
  {
    AppMethodBeat.i(150328);
    Context localContext = aj.getContext();
    AppMethodBeat.o(150328);
    return localContext;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150327);
    if (paramBoolean)
    {
      ad.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
      com.tencent.mm.kernel.g.ajC().ajl().set(90113, Boolean.TRUE);
    }
    try
    {
      String str = u.aAm();
      e locale = aEk();
      e.L(str, false);
      e.L(str, true);
      locale.d(str, null);
      this.hNu.az(10000L, 10000L);
      b.a(new com.tencent.mm.plugin.avatar.a(), new String[] { "//avatar" });
      AppMethodBeat.o(150327);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.SubCoreAvatar", localException, "Failed to refresh avatar.", new Object[0]);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150326);
    this.hNu.stopTimer();
    if (aEw().hNr != null) {
      e.reset();
    }
    Object localObject = aEw().hNs;
    if (localObject != null) {
      com.tencent.mm.kernel.g.aiU().b(123, (com.tencent.mm.al.f)localObject);
    }
    localObject = aEw().hNq;
    if (localObject != null) {
      ((j)localObject).hNa.clear();
    }
    b.S(new String[] { "//avatar" });
    AppMethodBeat.o(150326);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.p
 * JD-Core Version:    0.7.0.1
 */