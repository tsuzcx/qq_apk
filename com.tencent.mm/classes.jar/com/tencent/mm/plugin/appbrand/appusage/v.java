package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.fno;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public enum v
{
  private static Integer nPJ;
  private static final long nPK;
  
  static
  {
    AppMethodBeat.i(44596);
    nPL = new v[0];
    nPJ = null;
    nPK = TimeUnit.DAYS.toSeconds(1L);
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
    if ((((che)d.b.b(paramd.lBR)).oRY & 0x2) == 0)
    {
      AppMethodBeat.o(44595);
      return;
    }
    paramd = (chf)d.c.b(paramd.lBS);
    Log.i("MicroMsg.AppBrandStarListLogic[collection]", "onResp, errType %d, errCode %d, errMsg %s, ticket %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramLong });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramd != null))
    {
      if (m.W(u.class) != null)
      {
        ((u)m.W(u.class)).a(fno.class, paramd.ToG, paramLong);
        w.a(paramInt1, paramd.ToG);
      }
      paramString = com.tencent.mm.kernel.h.aHG().aHp();
      paramLong = ar.a.VlO;
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
  
  public static boolean bJA()
  {
    return true;
  }
  
  public static boolean bJB()
  {
    return true;
  }
  
  public static int bJC()
  {
    AppMethodBeat.i(44594);
    if (nPJ != null)
    {
      i = nPJ.intValue();
      AppMethodBeat.o(44594);
      return i;
    }
    int i = AppBrandGlobalSystemConfig.bLe().nXd;
    AppMethodBeat.o(44594);
    return i;
  }
  
  public static void zj(int paramInt)
  {
    AppMethodBeat.i(44593);
    nPJ = Integer.valueOf(paramInt);
    u localu = (u)m.W(u.class);
    Object localObject1 = localu.nPF;
    Object localObject2 = String.format(Locale.US, "%s desc limit %d offset %d", new Object[] { "orderSequence", Long.valueOf(9223372036854775807L), Integer.valueOf(bJC()) });
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
        long l = localu.nPF.beginTransaction(Thread.currentThread().getId());
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2[0] = ((String)((Iterator)localObject1).next());
          localu.nPF.delete("AppBrandStarApp", "rowid=?", (String[])localObject2);
        }
        localu.nPF.endTransaction(l);
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