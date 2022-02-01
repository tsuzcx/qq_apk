package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.gkl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public enum u
{
  private static Integer qPA;
  private static final long qPB;
  
  static
  {
    AppMethodBeat.i(44596);
    qPC = new u[0];
    qPA = null;
    qPB = TimeUnit.DAYS.toSeconds(1L);
    AppMethodBeat.o(44596);
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, String paramString, c paramc, Long paramLong)
  {
    AppMethodBeat.i(44595);
    if (paramc == null)
    {
      Log.e("MicroMsg.AppBrandStarListLogic[collection]", "onResp, NULL CommReqResp");
      AppMethodBeat.o(44595);
      return;
    }
    if ((((cxf)c.b.b(paramc.otB)).rXy & 0x2) == 0)
    {
      AppMethodBeat.o(44595);
      return;
    }
    paramc = (cxg)c.c.b(paramc.otC);
    Log.i("MicroMsg.AppBrandStarListLogic[collection]", "onResp, errType %d, errCode %d, errMsg %s, ticket %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramLong });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramc != null))
    {
      if (n.ag(t.class) != null)
      {
        ((t)n.ag(t.class)).a(gkl.class, paramc.aaCN, paramLong);
        v.a(paramInt1, paramc.aaCN);
      }
      paramString = com.tencent.mm.kernel.h.baE().ban();
      paramLong = at.a.acNj;
      if ((paramc.status & 0x1) <= 0) {
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
  
  public static boolean cjf()
  {
    return true;
  }
  
  public static boolean cjg()
  {
    return true;
  }
  
  public static int cjh()
  {
    AppMethodBeat.i(44594);
    if (qPA != null)
    {
      i = qPA.intValue();
      AppMethodBeat.o(44594);
      return i;
    }
    int i = AppBrandGlobalSystemConfig.ckD().qWT;
    AppMethodBeat.o(44594);
    return i;
  }
  
  public static void zw(int paramInt)
  {
    AppMethodBeat.i(44593);
    qPA = Integer.valueOf(paramInt);
    t localt = (t)n.ag(t.class);
    Object localObject1 = localt.qPw;
    Object localObject2 = String.format(Locale.US, "%s desc limit %d offset %d", new Object[] { "orderSequence", Long.valueOf(9223372036854775807L), Integer.valueOf(cjh()) });
    localObject2 = ((com.tencent.mm.storagebase.h)localObject1).query("AppBrandStarApp", new String[] { "rowid" }, null, null, null, null, (String)localObject2);
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
      if (!Util.isNullOrNil((List)localObject1))
      {
        localObject2 = new String[1];
        long l = localt.qPw.beginTransaction(Thread.currentThread().getId());
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2[0] = ((String)((Iterator)localObject1).next());
          localt.qPw.delete("AppBrandStarApp", "rowid=?", (String[])localObject2);
        }
        localt.qPw.endTransaction(l);
        localt.doNotify("batch", 5, null);
      }
      AppMethodBeat.o(44593);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.u
 * JD-Core Version:    0.7.0.1
 */