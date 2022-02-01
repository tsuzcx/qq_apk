package com.tencent.mm.ak;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.b.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class p
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private e gUA;
  private d gUB;
  private h gUC;
  private av gUD;
  private j gUz;
  
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
    this.gUD = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150318);
        if ((!com.tencent.mm.kernel.g.afz().aeI()) || (p.auq() == null))
        {
          ad.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.afz().aeI()), p.auq() });
          AppMethodBeat.o(150318);
          return false;
        }
        if (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(90113, Boolean.FALSE)).booleanValue())
        {
          p.auJ();
          p.auI();
        }
        com.tencent.mm.kernel.g.afB().afk().set(90113, Boolean.FALSE);
        AppMethodBeat.o(150318);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(150319);
        String str = super.toString() + "|upAssetsHandler";
        AppMethodBeat.o(150319);
        return str;
      }
    }, false);
    AppMethodBeat.o(150321);
  }
  
  public static p auE()
  {
    AppMethodBeat.i(150320);
    p localp = (p)t.ap(p.class);
    AppMethodBeat.o(150320);
    return localp;
  }
  
  public static j auF()
  {
    AppMethodBeat.i(150322);
    com.tencent.mm.kernel.g.afz().aeD();
    if (auE().gUz == null) {
      auE().gUz = new j(com.tencent.mm.kernel.g.afB().gda);
    }
    j localj = auE().gUz;
    AppMethodBeat.o(150322);
    return localj;
  }
  
  public static h auG()
  {
    AppMethodBeat.i(150324);
    com.tencent.mm.kernel.g.afz().aeD();
    if (auE().gUC == null) {
      auE().gUC = new h(com.tencent.mm.kernel.g.afB().gda);
    }
    h localh = auE().gUC;
    AppMethodBeat.o(150324);
    return localh;
  }
  
  public static d auH()
  {
    AppMethodBeat.i(150325);
    com.tencent.mm.kernel.g.afz().aeD();
    if (auE().gUB == null) {
      auE().gUB = new d();
    }
    d locald = auE().gUB;
    AppMethodBeat.o(150325);
    return locald;
  }
  
  public static boolean auI()
  {
    AppMethodBeat.i(150329);
    if (bt.a((Boolean)com.tencent.mm.kernel.g.afB().afk().get(59, null), false))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    auq();
    if (e.vU(u.aqG()))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    String str = u.aqG();
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    Bitmap localBitmap = e.b.wb(com.tencent.mm.plugin.image.d.apW() + "user_" + com.tencent.mm.b.g.getMessageDigest(str.getBytes()) + ".png");
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    boolean bool = auq().f(str, localBitmap);
    AppMethodBeat.o(150329);
    return bool;
  }
  
  public static e auq()
  {
    AppMethodBeat.i(150323);
    com.tencent.mm.kernel.g.afz().aeD();
    if (auE().gUA == null) {
      auE().gUA = new e();
    }
    e locale = auE().gUA;
    AppMethodBeat.o(150323);
    return locale;
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
      com.tencent.mm.kernel.g.afB().afk().set(90113, Boolean.TRUE);
    }
    try
    {
      String str = u.aqG();
      e locale = auq();
      e.K(str, false);
      e.K(str, true);
      locale.e(str, null);
      this.gUD.av(10000L, 10000L);
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
    this.gUD.stopTimer();
    if (auE().gUA != null) {
      e.reset();
    }
    Object localObject = auE().gUB;
    if (localObject != null) {
      com.tencent.mm.kernel.g.aeS().b(123, (com.tencent.mm.al.g)localObject);
    }
    localObject = auE().gUz;
    if (localObject != null) {
      ((j)localObject).gUj.clear();
    }
    b.Q(new String[] { "//avatar" });
    AppMethodBeat.o(150326);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.p
 * JD-Core Version:    0.7.0.1
 */