package com.tencent.mm.plugin.exdevice.g.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.g.a.j;
import com.tencent.mm.plugin.exdevice.g.a.l;
import com.tencent.mm.plugin.exdevice.g.a.m;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class c
  implements com.tencent.mm.ak.f
{
  public f qmb;
  public com.tencent.mm.plugin.exdevice.g.a.f qmc;
  
  public c()
  {
    AppMethodBeat.i(23546);
    ae.d("MicroMsg.ExdeviceRankInfoManager", "hy: constructing manager....");
    bc.ajj().a(1042, this);
    bc.ajj().a(1041, this);
    bc.ajj().a(1043, this);
    bc.ajj().a(1040, this);
    AppMethodBeat.o(23546);
  }
  
  public static ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> ads(String paramString)
  {
    com.tencent.mm.plugin.exdevice.g.b.a.d locald = null;
    AppMethodBeat.i(23548);
    ae.d("MicroMsg.ExdeviceRankInfoManager", "hy: getting like info...");
    if (!bu.isNullOrNil(paramString))
    {
      Object localObject = ad.cmK();
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.ExdeviceRankInfoStg", "hy: param error");
        AppMethodBeat.o(23548);
        return null;
      }
      String str = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[] { "HardDeviceRankInfo", "rankID", "score" });
      localObject = ((com.tencent.mm.plugin.exdevice.g.b.b.d)localObject).db.a(str, new String[] { bu.bI(paramString, "") }, 2);
      if (localObject == null)
      {
        ae.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        AppMethodBeat.o(23548);
        return null;
      }
      if (((Cursor)localObject).moveToFirst())
      {
        paramString = new ArrayList();
        do
        {
          locald = new com.tencent.mm.plugin.exdevice.g.b.a.d();
          locald.convertFrom((Cursor)localObject);
          paramString.add(locald);
        } while (((Cursor)localObject).moveToNext());
      }
      for (;;)
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(23548);
        return paramString;
        ae.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
        paramString = locald;
      }
    }
    ae.w("MicroMsg.ExdeviceRankInfoManager", "hy: param error");
    AppMethodBeat.o(23548);
    return null;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(23547);
    bc.ajj().a(new l(paramString3, paramString2, paramInt, paramString1), 0);
    AppMethodBeat.o(23547);
  }
  
  public static void e(String paramString, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList)
  {
    AppMethodBeat.i(23549);
    com.tencent.mm.plugin.exdevice.g.b.b.d locald = ad.cmK();
    if (!bu.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (paramArrayList == null) {
        break label216;
      }
      String str = String.format("select COUNT(*) from %s where %s = ?", new Object[] { "HardDeviceRankInfo", "rankID" });
      paramString = locald.db.a(str, new String[] { bu.bI(paramString, "") }, 2);
      if (paramString != null) {
        break;
      }
      ae.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
      i = 0;
      if (i != 0) {
        break label176;
      }
      paramString = paramArrayList.iterator();
      while (paramString.hasNext()) {
        locald.a((com.tencent.mm.plugin.exdevice.g.b.a.d)paramString.next(), false);
      }
    }
    if (paramString.moveToFirst()) {}
    for (int i = paramString.getInt(0);; i = 0)
    {
      paramString.close();
      break;
      ae.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
    }
    AppMethodBeat.o(23549);
    return;
    label176:
    paramString = paramArrayList.iterator();
    while (paramString.hasNext()) {
      locald.b((com.tencent.mm.plugin.exdevice.g.b.a.d)paramString.next(), false);
    }
    AppMethodBeat.o(23549);
    return;
    label216:
    ae.w("MicroMsg.ExdeviceRankInfoStg", "hy: data is null. abort insert");
    AppMethodBeat.o(23549);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23550);
    ae.d("MicroMsg.ExdeviceRankInfoManager", "hy: netscene back.err type: %d, err code: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof j))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error.");
        AppMethodBeat.o(23550);
      }
    }
    else if ((paramn instanceof l))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
        AppMethodBeat.o(23550);
      }
    }
    else if (((paramn instanceof m)) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(323L, 0L, 1L, false);
      ae.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
    }
    AppMethodBeat.o(23550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.c
 * JD-Core Version:    0.7.0.1
 */