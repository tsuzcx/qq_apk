package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class p
{
  private static awa J(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44868);
    awa localawa = new awa();
    localawa.iht = paramString;
    localawa.nEf = paramInt1;
    localawa.Fwg = paramInt2;
    AppMethodBeat.o(44868);
    return localawa;
  }
  
  public static String a(final String paramString, int paramInt1, int paramInt2, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(44869);
    if (j.Ej() == null)
    {
      AppMethodBeat.o(44869);
      return "";
    }
    int i = a.bt(paramString, paramInt1);
    int j = a.bu(paramString, paramInt1);
    String str = a.bv(paramString, paramInt1);
    boolean bool;
    if ((j != 0) && ((bt.isNullOrNil(str)) || (j > i)))
    {
      bool = true;
      ad.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      ad.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", new Object[] { str, Boolean.valueOf(bool) });
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
              ad.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if (this.jYM != null) {
                this.jYM.LC("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (awc)paramAnonymousb.hNL.hNQ;
            if ((paramAnonymousString.GuP == null) || (paramAnonymousString.GuP.size() == 0))
            {
              ad.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
              if (this.jYM != null) {
                this.jYM.LC("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (ej)paramAnonymousString.GuP.get(0);
            ad.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousString.Fwh, Integer.valueOf(paramAnonymousString.Fwg) });
            if (!bt.isNullOrNil(paramAnonymousString.Fwh))
            {
              p.a.K(paramString, paramAnonymousString.nEf, paramAnonymousString.Fwg);
              p.a.L(paramString, paramAnonymousString.nEf, paramAnonymousString.Fwg);
              p.a.n(paramString, paramAnonymousString.nEf, paramAnonymousString.Fwh);
              if (this.jYM != null)
              {
                this.jYM.LC(paramAnonymousString.Fwh);
                AppMethodBeat.o(44855);
              }
            }
            else if (this.jYM != null)
            {
              this.jYM.LC("");
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
      paramc.LC(str);
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, b paramb)
  {
    AppMethodBeat.i(44870);
    LinkedList localLinkedList = new LinkedList();
    awa localawa = new awa();
    localawa.iht = paramString;
    localawa.nEf = paramInt1;
    localawa.Fwg = paramInt2;
    localawa.GuN = paramInt3;
    localLinkedList.add(localawa);
    a(localLinkedList, paramb);
    AppMethodBeat.o(44870);
  }
  
  public static void a(String paramString, LinkedList<dvk> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(44867);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
      AppMethodBeat.o(44867);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ad.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
      AppMethodBeat.o(44867);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      dvk localdvk = (dvk)localIterator.next();
      ad.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[] { Integer.valueOf(localdvk.version), Integer.valueOf(localdvk.type) });
      int i = a.bt(paramString, localdvk.type);
      int j = localdvk.version;
      a.L(paramString, localdvk.type, j);
      if (j != 0) {
        if (j > i)
        {
          localLinkedList.add(J(paramString, localdvk.type, localdvk.version));
        }
        else if (j == i)
        {
          if (bt.isNullOrNil(a.bv(paramString, localdvk.type))) {
            localLinkedList.add(J(paramString, localdvk.type, localdvk.version));
          }
        }
        else
        {
          ad.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (bt.isNullOrNil(a.bv(paramString, localdvk.type))) {
            localLinkedList.add(J(paramString, localdvk.type, localdvk.version));
          }
        }
      }
    }
    ad.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()), Integer.valueOf(localLinkedList.size()) });
    if (paramBoolean)
    {
      if (localLinkedList.size() == 0)
      {
        AppMethodBeat.o(44867);
        return;
      }
      ad.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", new Object[] { paramString });
      a(localLinkedList, new b()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(44854);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(44854);
            return;
          }
          paramAnonymousString = (awc)paramAnonymousb.hNL.hNQ;
          if ((paramAnonymousString.GuP == null) || (paramAnonymousString.GuP.size() == 0))
          {
            ad.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
            AppMethodBeat.o(44854);
            return;
          }
          ad.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[] { Integer.valueOf(paramAnonymousString.GuP.size()) });
          paramAnonymousString = paramAnonymousString.GuP.iterator();
          while (paramAnonymousString.hasNext())
          {
            paramAnonymousb = (ej)paramAnonymousString.next();
            ad.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousb.Fwh, Integer.valueOf(paramAnonymousb.Fwg) });
            if (!bt.isNullOrNil(paramAnonymousb.Fwh))
            {
              p.a.K(this.jYL, paramAnonymousb.nEf, paramAnonymousb.Fwg);
              p.a.L(this.jYL, paramAnonymousb.nEf, paramAnonymousb.Fwg);
              p.a.n(this.jYL, paramAnonymousb.nEf, paramAnonymousb.Fwh);
            }
          }
          AppMethodBeat.o(44854);
        }
      });
    }
    AppMethodBeat.o(44867);
  }
  
  private static void a(LinkedList<awa> paramLinkedList, b paramb)
  {
    AppMethodBeat.i(44871);
    b.a locala = new b.a();
    locala.funcId = 1138;
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
    locala.hNN = new awc();
    locala.hNO = 0;
    locala.respCmdId = 0;
    awb localawb = new awb();
    localawb.GuO = paramLinkedList;
    locala.hNM = localawb;
    x.a(locala.aDC(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(44856);
        if (this.jYN != null) {
          this.jYN.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb);
        }
        AppMethodBeat.o(44856);
        return 0;
      }
    }, true);
    AppMethodBeat.o(44871);
  }
  
  public static void b(String paramString, LinkedList<dvk> paramLinkedList)
  {
    AppMethodBeat.i(44866);
    a(paramString, paramLinkedList, true);
    AppMethodBeat.o(44866);
  }
  
  public static final class a
  {
    public static void K(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44860);
      if (j.Ej() == null)
      {
        AppMethodBeat.o(44860);
        return;
      }
      j.Ej().cx(bq(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44860);
    }
    
    public static void L(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44861);
      if (j.Ej() == null)
      {
        AppMethodBeat.o(44861);
        return;
      }
      j.Ej().cx(br(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44861);
    }
    
    public static String Ns(String paramString)
    {
      AppMethodBeat.i(188100);
      paramString = String.format("%s#NotifyMessageStatus", new Object[] { paramString });
      AppMethodBeat.o(188100);
      return paramString;
    }
    
    private static String bq(String paramString, int paramInt)
    {
      AppMethodBeat.i(44857);
      paramString = String.format("%s_%s_local_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44857);
      return paramString;
    }
    
    private static String br(String paramString, int paramInt)
    {
      AppMethodBeat.i(44858);
      paramString = String.format("%s_%s_server_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44858);
      return paramString;
    }
    
    private static String bs(String paramString, int paramInt)
    {
      AppMethodBeat.i(44859);
      paramString = String.format("%s_%s_config", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44859);
      return paramString;
    }
    
    public static int bt(String paramString, int paramInt)
    {
      AppMethodBeat.i(44863);
      if (j.Ej() == null)
      {
        AppMethodBeat.o(44863);
        return 0;
      }
      paramInt = bt.getInt(j.Ej().get(bq(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44863);
      return paramInt;
    }
    
    public static int bu(String paramString, int paramInt)
    {
      AppMethodBeat.i(44864);
      if (j.Ej() == null)
      {
        AppMethodBeat.o(44864);
        return 0;
      }
      paramInt = bt.getInt(j.Ej().get(br(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44864);
      return paramInt;
    }
    
    public static String bv(String paramString, int paramInt)
    {
      AppMethodBeat.i(44865);
      if (j.Ej() == null)
      {
        AppMethodBeat.o(44865);
        return "";
      }
      paramString = j.Ej().get(bs(paramString, paramInt), "");
      AppMethodBeat.o(44865);
      return paramString;
    }
    
    public static void n(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(44862);
      if (j.Ej() == null)
      {
        AppMethodBeat.o(44862);
        return;
      }
      j.Ej().cx(bs(paramString1, paramInt), paramString2);
      AppMethodBeat.o(44862);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, b paramb);
  }
  
  public static abstract interface c
  {
    public abstract void LC(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.p
 * JD-Core Version:    0.7.0.1
 */