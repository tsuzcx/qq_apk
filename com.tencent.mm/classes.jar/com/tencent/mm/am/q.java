package com.tencent.mm.am;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class q
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private MTimerHandler lBA;
  private k lBw;
  private f lBx;
  private e lBy;
  private i lBz;
  
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
        return i.SQL_CREATE;
      }
    });
    AppMethodBeat.o(150331);
  }
  
  public q()
  {
    AppMethodBeat.i(150321);
    this.lBA = new MTimerHandler(h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150318);
        if ((!h.aHE().aGM()) || (q.bhz() == null))
        {
          Log.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", new Object[] { Boolean.valueOf(h.aHE().aGM()), q.bhz() });
          AppMethodBeat.o(150318);
          return false;
        }
        if (((Boolean)h.aHG().aHp().b(90113, Boolean.FALSE)).booleanValue())
        {
          q.bhT();
          q.bhS();
        }
        h.aHG().aHp().i(90113, Boolean.FALSE);
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
  
  public static q bhO()
  {
    AppMethodBeat.i(150320);
    q localq = (q)y.as(q.class);
    AppMethodBeat.o(150320);
    return localq;
  }
  
  public static k bhP()
  {
    AppMethodBeat.i(150322);
    h.aHE().aGH();
    if (bhO().lBw == null) {
      bhO().lBw = new k(h.aHG().kcF);
    }
    k localk = bhO().lBw;
    AppMethodBeat.o(150322);
    return localk;
  }
  
  public static i bhQ()
  {
    AppMethodBeat.i(150324);
    h.aHE().aGH();
    if (bhO().lBz == null) {
      bhO().lBz = new i(h.aHG().kcF);
    }
    i locali = bhO().lBz;
    AppMethodBeat.o(150324);
    return locali;
  }
  
  public static e bhR()
  {
    AppMethodBeat.i(150325);
    h.aHE().aGH();
    if (bhO().lBy == null) {
      bhO().lBy = new e();
    }
    e locale = bhO().lBy;
    AppMethodBeat.o(150325);
    return locale;
  }
  
  public static boolean bhS()
  {
    AppMethodBeat.i(150329);
    if (Util.nullAs((Boolean)h.aHG().aHp().b(59, null), false))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    String str = z.bcZ();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    bhz();
    if (f.TH(str))
    {
      AppMethodBeat.o(150329);
      return true;
    }
    Bitmap localBitmap = f.c.TO(d.bbW() + "user_" + g.getMessageDigest(str.getBytes()) + ".png");
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      AppMethodBeat.o(150329);
      return false;
    }
    boolean bool = bhz().e(str, localBitmap);
    AppMethodBeat.o(150329);
    return bool;
  }
  
  public static f bhz()
  {
    AppMethodBeat.i(150323);
    h.aHE().aGH();
    if (bhO().lBx == null) {
      bhO().lBx = new f();
    }
    f localf = bhO().lBx;
    AppMethodBeat.o(150323);
    return localf;
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
      h.aHG().aHp().i(90113, Boolean.TRUE);
    }
    this.lBA.startTimer(10000L);
    com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[] { "//avatar" });
    AppMethodBeat.o(150327);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150326);
    this.lBA.stopTimer();
    if (bhO().lBx != null) {
      f.reset();
    }
    Object localObject = bhO().lBy;
    if (localObject != null) {
      h.aGY().b(123, (com.tencent.mm.an.i)localObject);
    }
    localObject = bhO().lBw;
    if (localObject != null) {
      ((k)localObject).lBh.clear();
    }
    com.tencent.mm.pluginsdk.cmd.b.W(new String[] { "//avatar" });
    AppMethodBeat.o(150326);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.q
 * JD-Core Version:    0.7.0.1
 */