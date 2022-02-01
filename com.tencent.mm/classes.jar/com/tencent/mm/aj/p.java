package com.tencent.mm.aj;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class p
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private j hQj;
  private e hQk;
  private d hQl;
  private h hQm;
  private aw hQn;
  
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
    this.hQn = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new p.3(this), false);
    AppMethodBeat.o(150321);
  }
  
  public static e aEA()
  {
    AppMethodBeat.i(150323);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aEM().hQk == null) {
      aEM().hQk = new e();
    }
    e locale = aEM().hQk;
    AppMethodBeat.o(150323);
    return locale;
  }
  
  public static p aEM()
  {
    AppMethodBeat.i(150320);
    p localp = (p)u.ap(p.class);
    AppMethodBeat.o(150320);
    return localp;
  }
  
  public static j aEN()
  {
    AppMethodBeat.i(150322);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aEM().hQj == null) {
      aEM().hQj = new j(com.tencent.mm.kernel.g.ajR().gDX);
    }
    j localj = aEM().hQj;
    AppMethodBeat.o(150322);
    return localj;
  }
  
  public static h aEO()
  {
    AppMethodBeat.i(150324);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aEM().hQm == null) {
      aEM().hQm = new h(com.tencent.mm.kernel.g.ajR().gDX);
    }
    h localh = aEM().hQm;
    AppMethodBeat.o(150324);
    return localh;
  }
  
  public static d aEP()
  {
    AppMethodBeat.i(150325);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aEM().hQl == null) {
      aEM().hQl = new d();
    }
    d locald = aEM().hQl;
    AppMethodBeat.o(150325);
    return locald;
  }
  
  public static boolean aEQ()
  {
    AppMethodBeat.i(150329);
    if (bu.a((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(59, null), false))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    aEA();
    if (e.DB(v.aAC()))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    String str = v.aAC();
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    Bitmap localBitmap = e.b.DI(com.tencent.mm.plugin.image.d.azQ() + "user_" + com.tencent.mm.b.g.getMessageDigest(str.getBytes()) + ".png");
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    boolean bool = aEA().e(str, localBitmap);
    AppMethodBeat.o(150329);
    return bool;
  }
  
  static Context getContext()
  {
    AppMethodBeat.i(150328);
    Context localContext = ak.getContext();
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
      ae.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
      com.tencent.mm.kernel.g.ajR().ajA().set(90113, Boolean.TRUE);
    }
    try
    {
      String str = v.aAC();
      e locale = aEA();
      e.L(str, false);
      e.L(str, true);
      locale.d(str, null);
      this.hQn.ay(10000L, 10000L);
      b.a(new com.tencent.mm.plugin.avatar.a(), new String[] { "//avatar" });
      AppMethodBeat.o(150327);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.SubCoreAvatar", localException, "Failed to refresh avatar.", new Object[0]);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150326);
    this.hQn.stopTimer();
    if (aEM().hQk != null) {
      e.reset();
    }
    Object localObject = aEM().hQl;
    if (localObject != null) {
      com.tencent.mm.kernel.g.ajj().b(123, (com.tencent.mm.ak.f)localObject);
    }
    localObject = aEM().hQj;
    if (localObject != null) {
      ((j)localObject).hPT.clear();
    }
    b.S(new String[] { "//avatar" });
    AppMethodBeat.o(150326);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.p
 * JD-Core Version:    0.7.0.1
 */