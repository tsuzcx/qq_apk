package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public enum v
{
  private static Integer jSM;
  private static final long jSN;
  
  static
  {
    AppMethodBeat.i(44596);
    jSO = new v[0];
    jSM = null;
    jSN = TimeUnit.DAYS.toSeconds(1L);
    AppMethodBeat.o(44596);
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, String paramString, b paramb, Long paramLong)
  {
    AppMethodBeat.i(44595);
    if (paramb == null)
    {
      ae.e("MicroMsg.AppBrandStarListLogic[collection]", "onResp, NULL CommReqResp");
      AppMethodBeat.o(44595);
      return;
    }
    if ((((bmt)paramb.hQD.hQJ).condition & 0x2) == 0)
    {
      AppMethodBeat.o(44595);
      return;
    }
    paramb = (bmu)paramb.hQE.hQJ;
    ae.i("MicroMsg.AppBrandStarListLogic[collection]", "onResp, errType %d, errCode %d, errMsg %s, ticket %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramLong });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramb != null))
    {
      if (j.T(u.class) != null)
      {
        ((u)j.T(u.class)).a(ehv.class, paramb.Hae, paramLong);
        w.a(paramInt1, paramb.Hae);
      }
      paramString = g.ajR().ajA();
      paramLong = am.a.IPN;
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
  
  public static boolean bcX()
  {
    return true;
  }
  
  public static boolean bcY()
  {
    return true;
  }
  
  public static int bcZ()
  {
    AppMethodBeat.i(44594);
    if (jSM != null)
    {
      i = jSM.intValue();
      AppMethodBeat.o(44594);
      return i;
    }
    int i = AppBrandGlobalSystemConfig.bez().jZR;
    AppMethodBeat.o(44594);
    return i;
  }
  
  public static void sd(int paramInt)
  {
    AppMethodBeat.i(44593);
    jSM = Integer.valueOf(paramInt);
    u localu = (u)j.T(u.class);
    Object localObject1 = localu.jSI;
    Object localObject2 = String.format(Locale.US, "%s desc limit %d offset %d", new Object[] { "orderSequence", Long.valueOf(9223372036854775807L), Integer.valueOf(bcZ()) });
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
      if (!bu.ht((List)localObject1))
      {
        localObject2 = new String[1];
        long l = localu.jSI.yi(Thread.currentThread().getId());
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2[0] = ((String)((Iterator)localObject1).next());
          localu.jSI.delete("AppBrandStarApp", "rowid=?", (String[])localObject2);
        }
        localu.jSI.sW(l);
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