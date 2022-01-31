package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.protocal.c.anl;
import com.tencent.mm.protocal.c.anm;
import com.tencent.mm.protocal.c.cmc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public enum t
{
  private static Integer fJp = null;
  private static final long fJq = TimeUnit.DAYS.toSeconds(1L);
  
  static void a(int paramInt1, int paramInt2, int paramInt3, String paramString, b paramb, Long paramLong)
  {
    if (paramb == null) {
      y.e("MicroMsg.AppBrandStarListLogic[collection]", "onResp, NULL CommReqResp");
    }
    do
    {
      do
      {
        return;
      } while ((((anl)paramb.ecE.ecN).condition & 0x2) == 0);
      paramb = (anm)paramb.ecF.ecN;
      y.i("MicroMsg.AppBrandStarListLogic[collection]", "onResp, errType %d, errCode %d, errMsg %s, ticket %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramLong });
    } while ((paramInt2 != 0) || (paramInt3 != 0) || (paramb == null));
    if (com.tencent.mm.plugin.appbrand.app.e.G(s.class) != null)
    {
      ((s)com.tencent.mm.plugin.appbrand.app.e.G(s.class)).a(cmc.class, paramb.tjE, paramLong);
      u.a(paramInt1, paramb.tjE);
    }
    paramString = g.DP().Dz();
    paramLong = ac.a.usM;
    if ((paramb.status & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.c(paramLong, Boolean.valueOf(bool));
      return;
    }
  }
  
  public static boolean adq()
  {
    return true;
  }
  
  public static boolean adr()
  {
    return true;
  }
  
  public static int ads()
  {
    if (fJp != null) {
      return fJp.intValue();
    }
    return AppBrandGlobalSystemConfig.aec().fOK;
  }
  
  public static void kA(int paramInt)
  {
    fJp = Integer.valueOf(paramInt);
    s locals = (s)com.tencent.mm.plugin.appbrand.app.e.G(s.class);
    Object localObject1 = locals.fEC;
    Object localObject2 = String.format(Locale.US, "%s desc limit %d offset %d", new Object[] { "orderSequence", Long.valueOf(9223372036854775807L), Integer.valueOf(ads()) });
    localObject2 = ((h)localObject1).query("AppBrandStarApp", new String[] { "rowid" }, null, null, null, null, (String)localObject2);
    if (localObject2 == null) {
      return;
    }
    if (((Cursor)localObject2).moveToFirst())
    {
      localObject1 = new LinkedList();
      do
      {
        ((LinkedList)localObject1).add(String.valueOf(((Cursor)localObject2).getLong(0)));
      } while (((Cursor)localObject2).moveToNext());
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      if (bk.dk((List)localObject1)) {
        break;
      }
      localObject2 = new String[1];
      long l = locals.fEC.eV(Thread.currentThread().getId());
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2[0] = ((String)((Iterator)localObject1).next());
        locals.fEC.delete("AppBrandStarApp", "rowid=?", (String[])localObject2);
      }
      locals.fEC.hI(l);
      locals.b("batch", 5, null);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.t
 * JD-Core Version:    0.7.0.1
 */