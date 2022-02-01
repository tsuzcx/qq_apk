package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public enum v
{
  private static Integer jPu;
  private static final long jPv;
  
  static
  {
    AppMethodBeat.i(44596);
    jPw = new v[0];
    jPu = null;
    jPv = TimeUnit.DAYS.toSeconds(1L);
    AppMethodBeat.o(44596);
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, String paramString, b paramb, Long paramLong)
  {
    AppMethodBeat.i(44595);
    if (paramb == null)
    {
      ad.e("MicroMsg.AppBrandStarListLogic[collection]", "onResp, NULL CommReqResp");
      AppMethodBeat.o(44595);
      return;
    }
    if ((((bmb)paramb.hNK.hNQ).condition & 0x2) == 0)
    {
      AppMethodBeat.o(44595);
      return;
    }
    paramb = (bmc)paramb.hNL.hNQ;
    ad.i("MicroMsg.AppBrandStarListLogic[collection]", "onResp, errType %d, errCode %d, errMsg %s, ticket %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramLong });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramb != null))
    {
      if (j.T(u.class) != null)
      {
        ((u)j.T(u.class)).a(ege.class, paramb.GGC, paramLong);
        w.a(paramInt1, paramb.GGC);
      }
      paramString = g.ajC().ajl();
      paramLong = al.a.Ivp;
      if ((paramb.status & 0x1) <= 0) {
        break label187;
      }
    }
    label187:
    for (boolean bool = true;; bool = false)
    {
      paramString.set(paramLong, Boolean.valueOf(bool));
      AppMethodBeat.o(44595);
      return;
    }
  }
  
  public static boolean bcs()
  {
    return true;
  }
  
  public static boolean bct()
  {
    return true;
  }
  
  public static int bcu()
  {
    AppMethodBeat.i(44594);
    if (jPu != null)
    {
      i = jPu.intValue();
      AppMethodBeat.o(44594);
      return i;
    }
    int i = AppBrandGlobalSystemConfig.bdT().jWC;
    AppMethodBeat.o(44594);
    return i;
  }
  
  public static void sa(int paramInt)
  {
    AppMethodBeat.i(44593);
    jPu = Integer.valueOf(paramInt);
    u localu = (u)j.T(u.class);
    Object localObject1 = localu.jPq;
    Object localObject2 = String.format(Locale.US, "%s desc limit %d offset %d", new Object[] { "orderSequence", Long.valueOf(9223372036854775807L), Integer.valueOf(bcu()) });
    localObject2 = ((h)localObject1).query("AppBrandStarApp", new String[] { "rowid" }, null, null, null, null, (String)localObject2);
    if (localObject2 == null)
    {
      AppMethodBeat.o(44593);
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
      if (!bt.hj((List)localObject1))
      {
        localObject2 = new String[1];
        long l = localu.jPq.xO(Thread.currentThread().getId());
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2[0] = ((String)((Iterator)localObject1).next());
          localu.jPq.delete("AppBrandStarApp", "rowid=?", (String[])localObject2);
        }
        localu.jPq.sJ(l);
        localu.doNotify("batch", 5, null);
      }
      AppMethodBeat.o(44593);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.v
 * JD-Core Version:    0.7.0.1
 */