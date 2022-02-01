package com.tencent.mm.aj;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class p
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private j huY;
  private e huZ;
  private d hva;
  private h hvb;
  private au hvc;
  
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
    this.hvc = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150318);
        if ((!com.tencent.mm.kernel.g.agP().afY()) || (p.aBh() == null))
        {
          ac.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.agP().afY()), p.aBh() });
          AppMethodBeat.o(150318);
          return false;
        }
        if (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(90113, Boolean.FALSE)).booleanValue())
        {
          p.aBA();
          p.aBz();
        }
        com.tencent.mm.kernel.g.agR().agA().set(90113, Boolean.FALSE);
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
  
  public static e aBh()
  {
    AppMethodBeat.i(150323);
    com.tencent.mm.kernel.g.agP().afT();
    if (aBv().huZ == null) {
      aBv().huZ = new e();
    }
    e locale = aBv().huZ;
    AppMethodBeat.o(150323);
    return locale;
  }
  
  public static p aBv()
  {
    AppMethodBeat.i(150320);
    p localp = (p)t.ap(p.class);
    AppMethodBeat.o(150320);
    return localp;
  }
  
  public static j aBw()
  {
    AppMethodBeat.i(150322);
    com.tencent.mm.kernel.g.agP().afT();
    if (aBv().huY == null) {
      aBv().huY = new j(com.tencent.mm.kernel.g.agR().ghG);
    }
    j localj = aBv().huY;
    AppMethodBeat.o(150322);
    return localj;
  }
  
  public static h aBx()
  {
    AppMethodBeat.i(150324);
    com.tencent.mm.kernel.g.agP().afT();
    if (aBv().hvb == null) {
      aBv().hvb = new h(com.tencent.mm.kernel.g.agR().ghG);
    }
    h localh = aBv().hvb;
    AppMethodBeat.o(150324);
    return localh;
  }
  
  public static d aBy()
  {
    AppMethodBeat.i(150325);
    com.tencent.mm.kernel.g.agP().afT();
    if (aBv().hva == null) {
      aBv().hva = new d();
    }
    d locald = aBv().hva;
    AppMethodBeat.o(150325);
    return locald;
  }
  
  public static boolean aBz()
  {
    AppMethodBeat.i(150329);
    if (bs.a((Boolean)com.tencent.mm.kernel.g.agR().agA().get(59, null), false))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    aBh();
    if (e.Aa(u.axw()))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    String str = u.axw();
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    Bitmap localBitmap = e.b.Ah(com.tencent.mm.plugin.image.d.awL() + "user_" + com.tencent.mm.b.g.getMessageDigest(str.getBytes()) + ".png");
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    boolean bool = aBh().e(str, localBitmap);
    AppMethodBeat.o(150329);
    return bool;
  }
  
  static Context getContext()
  {
    AppMethodBeat.i(150328);
    Context localContext = ai.getContext();
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
      ac.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
      com.tencent.mm.kernel.g.agR().agA().set(90113, Boolean.TRUE);
    }
    try
    {
      String str = u.axw();
      e locale = aBh();
      e.L(str, false);
      e.L(str, true);
      locale.d(str, null);
      this.hvc.au(10000L, 10000L);
      b.a(new com.tencent.mm.plugin.avatar.a(), new String[] { "//avatar" });
      AppMethodBeat.o(150327);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.SubCoreAvatar", localException, "Failed to refresh avatar.", new Object[0]);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150326);
    this.hvc.stopTimer();
    if (aBv().huZ != null) {
      e.reset();
    }
    Object localObject = aBv().hva;
    if (localObject != null) {
      com.tencent.mm.kernel.g.agi().b(123, (com.tencent.mm.ak.g)localObject);
    }
    localObject = aBv().huY;
    if (localObject != null) {
      ((j)localObject).huI.clear();
    }
    b.Q(new String[] { "//avatar" });
    AppMethodBeat.o(150326);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aj.p
 * JD-Core Version:    0.7.0.1
 */