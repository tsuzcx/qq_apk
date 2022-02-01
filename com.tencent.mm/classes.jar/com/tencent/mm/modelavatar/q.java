package com.tencent.mm.modelavatar;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.b.g;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.avatar.a;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class q
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private k otg;
  private AvatarStorage oth;
  private e oti;
  private h otj;
  private MTimerHandler otk;
  
  static
  {
    AppMethodBeat.i(150331);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return k.SQL_CREATE;
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
  
  public q()
  {
    AppMethodBeat.i(150321);
    this.otk = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150318);
        if ((!com.tencent.mm.kernel.h.baC().aZN()) || (q.bFp() == null))
        {
          Log.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.h.baC().aZN()), q.bFp() });
          AppMethodBeat.o(150318);
          return false;
        }
        if (((Boolean)com.tencent.mm.kernel.h.baE().ban().d(90113, Boolean.FALSE)).booleanValue())
        {
          q.bFI();
          q.bFH();
        }
        com.tencent.mm.kernel.h.baE().ban().B(90113, Boolean.FALSE);
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
  
  public static q bFD()
  {
    AppMethodBeat.i(150320);
    q localq = (q)y.aL(q.class);
    AppMethodBeat.o(150320);
    return localq;
  }
  
  public static k bFE()
  {
    AppMethodBeat.i(150322);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bFD().otg == null) {
      bFD().otg = new k(com.tencent.mm.kernel.h.baE().mCN);
    }
    k localk = bFD().otg;
    AppMethodBeat.o(150322);
    return localk;
  }
  
  public static h bFF()
  {
    AppMethodBeat.i(150324);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bFD().otj == null) {
      bFD().otj = new h(com.tencent.mm.kernel.h.baE().mCN);
    }
    h localh = bFD().otj;
    AppMethodBeat.o(150324);
    return localh;
  }
  
  public static e bFG()
  {
    AppMethodBeat.i(150325);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bFD().oti == null) {
      bFD().oti = new e();
    }
    e locale = bFD().oti;
    AppMethodBeat.o(150325);
    return locale;
  }
  
  public static boolean bFH()
  {
    AppMethodBeat.i(150329);
    if (Util.nullAs((Boolean)com.tencent.mm.kernel.h.baE().ban().d(59, null), false))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    String str = z.bAM();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    bFp();
    if (AvatarStorage.S(str, false))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    Bitmap localBitmap = AvatarStorage.b.LO(d.bzL() + "user_" + g.getMessageDigest(str.getBytes()) + ".png");
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    boolean bool = bFp().e(str, localBitmap);
    AppMethodBeat.o(150329);
    return bool;
  }
  
  public static AvatarStorage bFp()
  {
    AppMethodBeat.i(150323);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bFD().oth == null) {
      bFD().oth = new AvatarStorage();
    }
    AvatarStorage localAvatarStorage = bFD().oth;
    AppMethodBeat.o(150323);
    return localAvatarStorage;
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
      com.tencent.mm.kernel.h.baE().ban().B(90113, Boolean.TRUE);
    }
    this.otk.startTimer(10000L);
    com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[] { "//avatar" });
    AppMethodBeat.o(150327);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150326);
    this.otk.stopTimer();
    if (bFD().oth != null) {
      AvatarStorage.reset();
    }
    Object localObject = bFD().oti;
    if (localObject != null) {
      com.tencent.mm.kernel.h.aZW().b(123, (com.tencent.mm.am.h)localObject);
    }
    localObject = bFD().otg;
    if (localObject != null) {
      ((k)localObject).osQ.clear();
    }
    com.tencent.mm.pluginsdk.cmd.b.X(new String[] { "//avatar" });
    AppMethodBeat.o(150326);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelavatar.q
 * JD-Core Version:    0.7.0.1
 */