package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a.b;
import com.tencent.mm.af.a.c;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
  implements k
{
  private static Map<String, Object> irC;
  private static Map<String, List<e.a>> irD;
  
  static
  {
    AppMethodBeat.i(132299);
    irC = new HashMap();
    irD = new HashMap();
    AppMethodBeat.o(132299);
  }
  
  public final boolean T(String paramString, int paramInt)
  {
    AppMethodBeat.i(132293);
    c localc = g.auJ();
    if (localc == null)
    {
      ab.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
      AppMethodBeat.o(132293);
      return false;
    }
    boolean bool;
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      ab.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, btnState:%d isOk:%b", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (bool) {
        irC.get(paramString);
      }
      AppMethodBeat.o(132293);
      return bool;
      b localb = new b();
      localb.field_shareKeyHash = paramString.hashCode();
      bool = localc.get(localb, new String[0]);
      localb.field_btnState = paramInt;
      if (bool) {
        bool = localc.update(localb, new String[0]);
      } else {
        bool = localc.insert(localb);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, k.a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(132295);
        if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString3)))
        {
          ab.e("MicroMsg.WxaUpdateableMsgService", "token appId or shareKey is null, return");
          AppMethodBeat.o(132295);
          return;
        }
        List localList = (List)irD.get(paramString1);
        Object localObject = localList;
        if (localList == null)
        {
          ab.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString1 });
          localObject = new ArrayList();
          irD.put(paramString1, localObject);
        }
        ab.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", new Object[] { Integer.valueOf(paramString3.hashCode()) });
        ab.d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", new Object[] { paramString3 });
        paramString1 = new e.a((byte)0);
        paramString1.appId = paramString2;
        paramString1.bCZ = paramString3;
        paramString1.irE = paramInt;
        paramString1.irF = parama;
        if ((bo.isNullOrNil(paramString1.appId)) || (bo.isNullOrNil(paramString1.bCZ)))
        {
          ab.w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
          ((List)localObject).add(paramString1);
          AppMethodBeat.o(132295);
          continue;
        }
        paramString2 = e.b.irG;
      }
      finally {}
      ab.d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(paramString2.irH.size()) });
      paramString2.irH.put(Integer.valueOf(paramString1.bCZ.hashCode()), paramString1);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132294);
    c localc = g.auJ();
    if (localc == null)
    {
      ab.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
      AppMethodBeat.o(132294);
      return false;
    }
    boolean bool;
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      ab.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, content:%s contentColor:%s isOk:%b", new Object[] { paramString1, Integer.valueOf(paramString1.hashCode()), paramString2, paramString3, Boolean.valueOf(bool) });
      AppMethodBeat.o(132294);
      return bool;
      b localb = new b();
      localb.field_shareKeyHash = paramString1.hashCode();
      bool = localc.get(localb, new String[0]);
      localb.field_updatePeroid = paramInt1;
      localb.field_msgState = paramInt2;
      localb.field_content = paramString2;
      localb.field_contentColor = paramString3;
      if (bool) {
        bool = localc.update(localb, new String[0]);
      } else {
        bool = localc.insert(localb);
      }
    }
  }
  
  public final void aco()
  {
    AppMethodBeat.i(132297);
    ab.i("MicroMsg.WxaUpdateableMsgService", "startUpdatbleMsgInfoChange");
    e.b.irG.start();
    AppMethodBeat.o(132297);
  }
  
  public final void acp()
  {
    AppMethodBeat.i(132298);
    ab.i("MicroMsg.WxaUpdateableMsgService", "stopOnUpdatbleMsgInfoChange");
    e.b.irG.stop();
    AppMethodBeat.o(132298);
  }
  
  public final b qj(String paramString)
  {
    AppMethodBeat.i(132292);
    c localc = g.auJ();
    if (localc == null)
    {
      ab.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null");
      AppMethodBeat.o(132292);
      return null;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WxaUpdateableMsgService", "shareKey is null, return");
      AppMethodBeat.o(132292);
      return null;
    }
    int i = paramString.hashCode();
    b localb2 = new b();
    localb2.field_shareKeyHash = i;
    b localb1 = localb2;
    if (!localc.get(localb2, new String[] { "shareKeyHash" }))
    {
      ab.e("MicroMsg.WxaUpdateableMsgStorage", "WxaUpdateableMsg is null");
      localb1 = null;
    }
    if (localb1 == null)
    {
      ab.e("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, wxaUpdateableMsg is null", new Object[] { paramString, Integer.valueOf(paramString.hashCode()) });
      AppMethodBeat.o(132292);
      return null;
    }
    ab.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d status:%s", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(localb1.field_btnState) });
    AppMethodBeat.o(132292);
    return localb1;
  }
  
  public final void qk(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(132296);
        ab.i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString });
        Object localObject = (List)irD.get(paramString);
        if (localObject == null)
        {
          ab.w("MicroMsg.WxaUpdateableMsgService", "[removeOnUpdatbleMsgInfoChange]getUpdatableMsgWorkers is null, err");
          AppMethodBeat.o(132296);
          return;
        }
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          e.a locala = (e.a)((Iterator)localObject).next();
          e.b localb = e.b.irG;
          ab.d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(localb.irH.size()) });
          localb.irH.remove(Integer.valueOf(locala.bCZ.hashCode()));
          continue;
        }
        irD.remove(paramString);
      }
      finally {}
      AppMethodBeat.o(132296);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.e
 * JD-Core Version:    0.7.0.1
 */