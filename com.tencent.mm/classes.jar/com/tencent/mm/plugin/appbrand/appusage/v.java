package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public enum v
{
  private static Integer kVw;
  private static final long kVx;
  
  static
  {
    AppMethodBeat.i(44596);
    kVy = new v[0];
    kVw = null;
    kVx = TimeUnit.DAYS.toSeconds(1L);
    AppMethodBeat.o(44596);
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, String paramString, d paramd, Long paramLong)
  {
    AppMethodBeat.i(44595);
    if (paramd == null)
    {
      Log.e("MicroMsg.AppBrandStarListLogic[collection]", "onResp, NULL CommReqResp");
      AppMethodBeat.o(44595);
      return;
    }
    if ((((bzk)paramd.iLK.iLR).condition & 0x2) == 0)
    {
      AppMethodBeat.o(44595);
      return;
    }
    paramd = (bzl)paramd.iLL.iLR;
    Log.i("MicroMsg.AppBrandStarListLogic[collection]", "onResp, errType %d, errCode %d, errMsg %s, ticket %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramLong });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramd != null))
    {
      if (n.W(u.class) != null)
      {
        ((u)n.W(u.class)).a(fcn.class, paramd.Mfe, paramLong);
        w.a(paramInt1, paramd.Mfe);
      }
      paramString = g.aAh().azQ();
      paramLong = ar.a.NXO;
      if ((paramd.status & 0x1) <= 0) {
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
  
  public static boolean bym()
  {
    return true;
  }
  
  public static boolean byn()
  {
    return true;
  }
  
  public static int byo()
  {
    AppMethodBeat.i(44594);
    if (kVw != null)
    {
      i = kVw.intValue();
      AppMethodBeat.o(44594);
      return i;
    }
    int i = AppBrandGlobalSystemConfig.bzP().lcU;
    AppMethodBeat.o(44594);
    return i;
  }
  
  public static void vY(int paramInt)
  {
    AppMethodBeat.i(44593);
    kVw = Integer.valueOf(paramInt);
    u localu = (u)n.W(u.class);
    Object localObject1 = localu.kVs;
    Object localObject2 = String.format(Locale.US, "%s desc limit %d offset %d", new Object[] { "orderSequence", Long.valueOf(9223372036854775807L), Integer.valueOf(byo()) });
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
      if (!Util.isNullOrNil((List)localObject1))
      {
        localObject2 = new String[1];
        long l = localu.kVs.beginTransaction(Thread.currentThread().getId());
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2[0] = ((String)((Iterator)localObject1).next());
          localu.kVs.delete("AppBrandStarApp", "rowid=?", (String[])localObject2);
        }
        localu.kVs.endTransaction(l);
        localu.doNotify("batch", 5, null);
      }
      AppMethodBeat.o(44593);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.v
 * JD-Core Version:    0.7.0.1
 */