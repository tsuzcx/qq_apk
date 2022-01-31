package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public enum t
{
  private static Integer hci;
  private static final long hcj;
  
  static
  {
    AppMethodBeat.i(129662);
    hck = new t[0];
    hci = null;
    hcj = TimeUnit.DAYS.toSeconds(1L);
    AppMethodBeat.o(129662);
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, String paramString, b paramb, Long paramLong)
  {
    AppMethodBeat.i(129661);
    if (paramb == null)
    {
      ab.e("MicroMsg.AppBrandStarListLogic[collection]", "onResp, NULL CommReqResp");
      AppMethodBeat.o(129661);
      return;
    }
    if ((((ata)paramb.fsV.fta).condition & 0x2) == 0)
    {
      AppMethodBeat.o(129661);
      return;
    }
    paramb = (atb)paramb.fsW.fta;
    ab.i("MicroMsg.AppBrandStarListLogic[collection]", "onResp, errType %d, errCode %d, errMsg %s, ticket %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramLong });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramb != null))
    {
      if (com.tencent.mm.plugin.appbrand.app.g.w(s.class) != null)
      {
        ((s)com.tencent.mm.plugin.appbrand.app.g.w(s.class)).a(czt.class, paramb.xir, paramLong);
        u.a(paramInt1, paramb.xir);
      }
      paramString = com.tencent.mm.kernel.g.RL().Ru();
      paramLong = ac.a.yCM;
      if ((paramb.status & 0x1) <= 0) {
        break label187;
      }
    }
    label187:
    for (boolean bool = true;; bool = false)
    {
      paramString.set(paramLong, Boolean.valueOf(bool));
      AppMethodBeat.o(129661);
      return;
    }
  }
  
  public static int axA()
  {
    AppMethodBeat.i(129660);
    if (hci != null)
    {
      i = hci.intValue();
      AppMethodBeat.o(129660);
      return i;
    }
    int i = AppBrandGlobalSystemConfig.ayt().hhK;
    AppMethodBeat.o(129660);
    return i;
  }
  
  public static boolean axy()
  {
    return true;
  }
  
  public static boolean axz()
  {
    return true;
  }
  
  public static void nw(int paramInt)
  {
    AppMethodBeat.i(129659);
    hci = Integer.valueOf(paramInt);
    s locals = (s)com.tencent.mm.plugin.appbrand.app.g.w(s.class);
    Object localObject1 = locals.hce;
    Object localObject2 = String.format(Locale.US, "%s desc limit %d offset %d", new Object[] { "orderSequence", Long.valueOf(9223372036854775807L), Integer.valueOf(axA()) });
    localObject2 = ((h)localObject1).query("AppBrandStarApp", new String[] { "rowid" }, null, null, null, null, (String)localObject2);
    if (localObject2 == null)
    {
      AppMethodBeat.o(129659);
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
      if (!bo.es((List)localObject1))
      {
        localObject2 = new String[1];
        long l = locals.hce.kr(Thread.currentThread().getId());
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2[0] = ((String)((Iterator)localObject1).next());
          locals.hce.delete("AppBrandStarApp", "rowid=?", (String[])localObject2);
        }
        locals.hce.nY(l);
        locals.doNotify("batch", 5, null);
      }
      AppMethodBeat.o(129659);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.t
 * JD-Core Version:    0.7.0.1
 */