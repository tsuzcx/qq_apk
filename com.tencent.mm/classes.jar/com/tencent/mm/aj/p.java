package com.tencent.mm.aj;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.f;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class p
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private j iLp;
  private e iLq;
  private d iLr;
  private h iLs;
  private MTimerHandler iLt;
  
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
    this.iLt = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new p.3(this), false);
    AppMethodBeat.o(150321);
  }
  
  public static p aYA()
  {
    AppMethodBeat.i(150320);
    p localp = (p)y.at(p.class);
    AppMethodBeat.o(150320);
    return localp;
  }
  
  public static j aYB()
  {
    AppMethodBeat.i(150322);
    com.tencent.mm.kernel.g.aAf().azk();
    if (aYA().iLp == null) {
      aYA().iLp = new j(com.tencent.mm.kernel.g.aAh().hqK);
    }
    j localj = aYA().iLp;
    AppMethodBeat.o(150322);
    return localj;
  }
  
  public static h aYC()
  {
    AppMethodBeat.i(150324);
    com.tencent.mm.kernel.g.aAf().azk();
    if (aYA().iLs == null) {
      aYA().iLs = new h(com.tencent.mm.kernel.g.aAh().hqK);
    }
    h localh = aYA().iLs;
    AppMethodBeat.o(150324);
    return localh;
  }
  
  public static d aYD()
  {
    AppMethodBeat.i(150325);
    com.tencent.mm.kernel.g.aAf().azk();
    if (aYA().iLr == null) {
      aYA().iLr = new d();
    }
    d locald = aYA().iLr;
    AppMethodBeat.o(150325);
    return locald;
  }
  
  public static boolean aYE()
  {
    AppMethodBeat.i(150329);
    if (Util.nullAs((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(59, null), false))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    String str = z.aTY();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    aYn();
    if (e.Mm(str))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    Bitmap localBitmap = e.b.Mt(com.tencent.mm.plugin.image.d.aSY() + "user_" + com.tencent.mm.b.g.getMessageDigest(str.getBytes()) + ".png");
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    boolean bool = aYn().e(str, localBitmap);
    AppMethodBeat.o(150329);
    return bool;
  }
  
  public static e aYn()
  {
    AppMethodBeat.i(150323);
    com.tencent.mm.kernel.g.aAf().azk();
    if (aYA().iLq == null) {
      aYA().iLq = new e();
    }
    e locale = aYA().iLq;
    AppMethodBeat.o(150323);
    return locale;
  }
  
  static Context getContext()
  {
    AppMethodBeat.i(150328);
    Context localContext = MMApplicationContext.getContext();
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
      Log.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
      com.tencent.mm.kernel.g.aAh().azQ().set(90113, Boolean.TRUE);
    }
    this.iLt.startTimer(10000L);
    b.a(new com.tencent.mm.plugin.avatar.a(), new String[] { "//avatar" });
    AppMethodBeat.o(150327);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150326);
    this.iLt.stopTimer();
    if (aYA().iLq != null) {
      e.reset();
    }
    Object localObject = aYA().iLr;
    if (localObject != null) {
      com.tencent.mm.kernel.g.azz().b(123, (i)localObject);
    }
    localObject = aYA().iLp;
    if (localObject != null) {
      ((j)localObject).iLa.clear();
    }
    b.V(new String[] { "//avatar" });
    AppMethodBeat.o(150326);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.p
 * JD-Core Version:    0.7.0.1
 */