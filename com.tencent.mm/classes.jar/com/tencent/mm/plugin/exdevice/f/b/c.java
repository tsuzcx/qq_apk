package com.tencent.mm.plugin.exdevice.f.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.l;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class c
  implements com.tencent.mm.ai.f
{
  public f lHW;
  public com.tencent.mm.plugin.exdevice.f.a.f lHX;
  
  public c()
  {
    AppMethodBeat.i(19478);
    ab.d("MicroMsg.ExdeviceRankInfoManager", "hy: constructing manager....");
    aw.Rc().a(1042, this);
    aw.Rc().a(1041, this);
    aw.Rc().a(1043, this);
    aw.Rc().a(1040, this);
    AppMethodBeat.o(19478);
  }
  
  public static ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> LA(String paramString)
  {
    com.tencent.mm.plugin.exdevice.f.b.a.d locald = null;
    AppMethodBeat.i(19480);
    ab.d("MicroMsg.ExdeviceRankInfoManager", "hy: getting like info...");
    if (!bo.isNullOrNil(paramString))
    {
      Object localObject = ad.bpZ();
      if (bo.isNullOrNil(paramString))
      {
        ab.e("MicroMsg.ExdeviceRankInfoStg", "hy: param error");
        AppMethodBeat.o(19480);
        return null;
      }
      String str = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[] { "HardDeviceRankInfo", "rankID", "score" });
      localObject = ((com.tencent.mm.plugin.exdevice.f.b.b.d)localObject).db.a(str, new String[] { bo.bf(paramString, "") }, 2);
      if (localObject == null)
      {
        ab.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        AppMethodBeat.o(19480);
        return null;
      }
      if (((Cursor)localObject).moveToFirst())
      {
        paramString = new ArrayList();
        do
        {
          locald = new com.tencent.mm.plugin.exdevice.f.b.a.d();
          locald.convertFrom((Cursor)localObject);
          paramString.add(locald);
        } while (((Cursor)localObject).moveToNext());
      }
      for (;;)
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(19480);
        return paramString;
        ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
        paramString = locald;
      }
    }
    ab.w("MicroMsg.ExdeviceRankInfoManager", "hy: param error");
    AppMethodBeat.o(19480);
    return null;
  }
  
  public static void d(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(19479);
    aw.Rc().a(new l(paramString3, paramString2, paramInt, paramString1), 0);
    AppMethodBeat.o(19479);
  }
  
  public static void f(String paramString, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> paramArrayList)
  {
    AppMethodBeat.i(19481);
    com.tencent.mm.plugin.exdevice.f.b.b.d locald = ad.bpZ();
    if (!bo.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (paramArrayList == null) {
        break label216;
      }
      String str = String.format("select COUNT(*) from %s where %s = ?", new Object[] { "HardDeviceRankInfo", "rankID" });
      paramString = locald.db.a(str, new String[] { bo.bf(paramString, "") }, 2);
      if (paramString != null) {
        break;
      }
      ab.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
      i = 0;
      if (i != 0) {
        break label176;
      }
      paramString = paramArrayList.iterator();
      while (paramString.hasNext()) {
        locald.a((com.tencent.mm.plugin.exdevice.f.b.a.d)paramString.next(), false);
      }
    }
    if (paramString.moveToFirst()) {}
    for (int i = paramString.getInt(0);; i = 0)
    {
      paramString.close();
      break;
      ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
    }
    AppMethodBeat.o(19481);
    return;
    label176:
    paramString = paramArrayList.iterator();
    while (paramString.hasNext()) {
      locald.b((com.tencent.mm.plugin.exdevice.f.b.a.d)paramString.next(), false);
    }
    AppMethodBeat.o(19481);
    return;
    label216:
    ab.w("MicroMsg.ExdeviceRankInfoStg", "hy: data is null. abort insert");
    AppMethodBeat.o(19481);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(19482);
    ab.d("MicroMsg.ExdeviceRankInfoManager", "hy: netscene back.err type: %d, err code: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramm instanceof j))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error.");
        AppMethodBeat.o(19482);
      }
    }
    else if ((paramm instanceof l))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
        AppMethodBeat.o(19482);
      }
    }
    else if (((paramm instanceof com.tencent.mm.plugin.exdevice.f.a.m)) && ((paramInt1 != 0) || (paramInt2 != 0))) {
      ab.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
    }
    AppMethodBeat.o(19482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.c
 * JD-Core Version:    0.7.0.1
 */