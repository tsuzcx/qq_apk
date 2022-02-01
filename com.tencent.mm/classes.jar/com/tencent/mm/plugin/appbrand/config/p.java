package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.dpt;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class p
{
  private static asc H(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44868);
    asc localasc = new asc();
    localasc.hOf = paramString;
    localasc.ndI = paramInt1;
    localasc.DQO = paramInt2;
    AppMethodBeat.o(44868);
    return localasc;
  }
  
  public static String a(final String paramString, int paramInt1, int paramInt2, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(44869);
    if (j.CK() == null)
    {
      AppMethodBeat.o(44869);
      return "";
    }
    int i = a.br(paramString, paramInt1);
    int j = a.bs(paramString, paramInt1);
    String str = a.bt(paramString, paramInt1);
    boolean bool;
    if ((j != 0) && ((bs.isNullOrNil(str)) || (j > i)))
    {
      bool = true;
      ac.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      ac.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", new Object[] { str, Boolean.valueOf(bool) });
      if (!bool) {
        break label155;
      }
      if (paramBoolean) {
        a(paramString, paramInt1, j, paramInt2, new b()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
          {
            AppMethodBeat.i(44855);
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              ac.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if (this.jEK != null) {
                this.jEK.Ik("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (ase)paramAnonymousb.hvs.hvw;
            if ((paramAnonymousString.ELL == null) || (paramAnonymousString.ELL.size() == 0))
            {
              ac.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
              if (this.jEK != null) {
                this.jEK.Ik("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (ef)paramAnonymousString.ELL.get(0);
            ac.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousString.DQP, Integer.valueOf(paramAnonymousString.DQO) });
            if (!bs.isNullOrNil(paramAnonymousString.DQP))
            {
              p.a.I(paramString, paramAnonymousString.ndI, paramAnonymousString.DQO);
              p.a.J(paramString, paramAnonymousString.ndI, paramAnonymousString.DQO);
              p.a.m(paramString, paramAnonymousString.ndI, paramAnonymousString.DQP);
              if (this.jEK != null)
              {
                this.jEK.Ik(paramAnonymousString.DQP);
                AppMethodBeat.o(44855);
              }
            }
            else if (this.jEK != null)
            {
              this.jEK.Ik("");
            }
            AppMethodBeat.o(44855);
          }
        });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(44869);
      return str;
      bool = false;
      break;
      label155:
      paramc.Ik(str);
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, b paramb)
  {
    AppMethodBeat.i(44870);
    LinkedList localLinkedList = new LinkedList();
    asc localasc = new asc();
    localasc.hOf = paramString;
    localasc.ndI = paramInt1;
    localasc.DQO = paramInt2;
    localasc.ELJ = paramInt3;
    localLinkedList.add(localasc);
    a(localLinkedList, paramb);
    AppMethodBeat.o(44870);
  }
  
  public static void a(String paramString, LinkedList<dpt> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(44867);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
      AppMethodBeat.o(44867);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ac.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
      AppMethodBeat.o(44867);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      dpt localdpt = (dpt)localIterator.next();
      ac.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[] { Integer.valueOf(localdpt.version), Integer.valueOf(localdpt.type) });
      int i = a.br(paramString, localdpt.type);
      int j = localdpt.version;
      a.J(paramString, localdpt.type, j);
      if (j != 0) {
        if (j > i)
        {
          localLinkedList.add(H(paramString, localdpt.type, localdpt.version));
        }
        else if (j == i)
        {
          if (bs.isNullOrNil(a.bt(paramString, localdpt.type))) {
            localLinkedList.add(H(paramString, localdpt.type, localdpt.version));
          }
        }
        else
        {
          ac.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (bs.isNullOrNil(a.bt(paramString, localdpt.type))) {
            localLinkedList.add(H(paramString, localdpt.type, localdpt.version));
          }
        }
      }
    }
    ac.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()), Integer.valueOf(localLinkedList.size()) });
    if (paramBoolean)
    {
      if (localLinkedList.size() == 0)
      {
        AppMethodBeat.o(44867);
        return;
      }
      ac.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", new Object[] { paramString });
      a(localLinkedList, new b()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(44854);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ac.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(44854);
            return;
          }
          paramAnonymousString = (ase)paramAnonymousb.hvs.hvw;
          if ((paramAnonymousString.ELL == null) || (paramAnonymousString.ELL.size() == 0))
          {
            ac.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
            AppMethodBeat.o(44854);
            return;
          }
          ac.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[] { Integer.valueOf(paramAnonymousString.ELL.size()) });
          paramAnonymousString = paramAnonymousString.ELL.iterator();
          while (paramAnonymousString.hasNext())
          {
            paramAnonymousb = (ef)paramAnonymousString.next();
            ac.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousb.DQP, Integer.valueOf(paramAnonymousb.DQO) });
            if (!bs.isNullOrNil(paramAnonymousb.DQP))
            {
              p.a.I(this.jEJ, paramAnonymousb.ndI, paramAnonymousb.DQO);
              p.a.J(this.jEJ, paramAnonymousb.ndI, paramAnonymousb.DQO);
              p.a.m(this.jEJ, paramAnonymousb.ndI, paramAnonymousb.DQP);
            }
          }
          AppMethodBeat.o(44854);
        }
      });
    }
    AppMethodBeat.o(44867);
  }
  
  private static void a(LinkedList<asc> paramLinkedList, b paramb)
  {
    AppMethodBeat.i(44871);
    b.a locala = new b.a();
    locala.funcId = 1138;
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
    locala.hvu = new ase();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    asd localasd = new asd();
    localasd.ELK = paramLinkedList;
    locala.hvt = localasd;
    x.a(locala.aAz(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(44856);
        if (this.jEL != null) {
          this.jEL.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb);
        }
        AppMethodBeat.o(44856);
        return 0;
      }
    }, true);
    AppMethodBeat.o(44871);
  }
  
  public static void b(String paramString, LinkedList<dpt> paramLinkedList)
  {
    AppMethodBeat.i(44866);
    a(paramString, paramLinkedList, true);
    AppMethodBeat.o(44866);
  }
  
  public static final class a
  {
    public static void I(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44860);
      if (j.CK() == null)
      {
        AppMethodBeat.o(44860);
        return;
      }
      j.CK().cv(bo(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44860);
    }
    
    public static void J(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44861);
      if (j.CK() == null)
      {
        AppMethodBeat.o(44861);
        return;
      }
      j.CK().cv(bp(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44861);
    }
    
    public static String JZ(String paramString)
    {
      AppMethodBeat.i(186407);
      paramString = String.format("%s#NotifyMessageStatus", new Object[] { paramString });
      AppMethodBeat.o(186407);
      return paramString;
    }
    
    private static String bo(String paramString, int paramInt)
    {
      AppMethodBeat.i(44857);
      paramString = String.format("%s_%s_local_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44857);
      return paramString;
    }
    
    private static String bp(String paramString, int paramInt)
    {
      AppMethodBeat.i(44858);
      paramString = String.format("%s_%s_server_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44858);
      return paramString;
    }
    
    private static String bq(String paramString, int paramInt)
    {
      AppMethodBeat.i(44859);
      paramString = String.format("%s_%s_config", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44859);
      return paramString;
    }
    
    public static int br(String paramString, int paramInt)
    {
      AppMethodBeat.i(44863);
      if (j.CK() == null)
      {
        AppMethodBeat.o(44863);
        return 0;
      }
      paramInt = bs.getInt(j.CK().get(bo(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44863);
      return paramInt;
    }
    
    public static int bs(String paramString, int paramInt)
    {
      AppMethodBeat.i(44864);
      if (j.CK() == null)
      {
        AppMethodBeat.o(44864);
        return 0;
      }
      paramInt = bs.getInt(j.CK().get(bp(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44864);
      return paramInt;
    }
    
    public static String bt(String paramString, int paramInt)
    {
      AppMethodBeat.i(44865);
      if (j.CK() == null)
      {
        AppMethodBeat.o(44865);
        return "";
      }
      paramString = j.CK().get(bq(paramString, paramInt), "");
      AppMethodBeat.o(44865);
      return paramString;
    }
    
    public static void m(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(44862);
      if (j.CK() == null)
      {
        AppMethodBeat.o(44862);
        return;
      }
      j.CK().cv(bq(paramString1, paramInt), paramString2);
      AppMethodBeat.o(44862);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, b paramb);
  }
  
  public static abstract interface c
  {
    public abstract void Ik(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.p
 * JD-Core Version:    0.7.0.1
 */