package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class p
{
  private static aoy I(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44868);
    aoy localaoy = new aoy();
    localaoy.hnC = paramString;
    localaoy.mBH = paramInt1;
    localaoy.Cys = paramInt2;
    AppMethodBeat.o(44868);
    return localaoy;
  }
  
  public static String a(final String paramString, int paramInt1, int paramInt2, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(44869);
    if (j.Dh() == null)
    {
      AppMethodBeat.o(44869);
      return "";
    }
    int i = a.bn(paramString, paramInt1);
    int j = a.bo(paramString, paramInt1);
    String str = a.bp(paramString, paramInt1);
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
              if (this.jew != null) {
                this.jew.Eh("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (apa)paramAnonymousb.gUT.gUX;
            if ((paramAnonymousString.DqJ == null) || (paramAnonymousString.DqJ.size() == 0))
            {
              ad.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
              if (this.jew != null) {
                this.jew.Eh("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (ed)paramAnonymousString.DqJ.get(0);
            ad.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousString.Cyt, Integer.valueOf(paramAnonymousString.Cys) });
            if (!bt.isNullOrNil(paramAnonymousString.Cyt))
            {
              p.a.J(paramString, paramAnonymousString.mBH, paramAnonymousString.Cys);
              p.a.K(paramString, paramAnonymousString.mBH, paramAnonymousString.Cys);
              p.a.m(paramString, paramAnonymousString.mBH, paramAnonymousString.Cyt);
              if (this.jew != null)
              {
                this.jew.Eh(paramAnonymousString.Cyt);
                AppMethodBeat.o(44855);
              }
            }
            else if (this.jew != null)
            {
              this.jew.Eh("");
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
      paramc.Eh(str);
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, b paramb)
  {
    AppMethodBeat.i(44870);
    LinkedList localLinkedList = new LinkedList();
    aoy localaoy = new aoy();
    localaoy.hnC = paramString;
    localaoy.mBH = paramInt1;
    localaoy.Cys = paramInt2;
    localaoy.DqH = paramInt3;
    localLinkedList.add(localaoy);
    a(localLinkedList, paramb);
    AppMethodBeat.o(44870);
  }
  
  public static void a(String paramString, LinkedList<dke> paramLinkedList, boolean paramBoolean)
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
      dke localdke = (dke)localIterator.next();
      ad.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[] { Integer.valueOf(localdke.version), Integer.valueOf(localdke.type) });
      int i = a.bn(paramString, localdke.type);
      int j = localdke.version;
      a.K(paramString, localdke.type, j);
      if (j != 0) {
        if (j > i)
        {
          localLinkedList.add(I(paramString, localdke.type, localdke.version));
        }
        else if (j == i)
        {
          if (bt.isNullOrNil(a.bp(paramString, localdke.type))) {
            localLinkedList.add(I(paramString, localdke.type, localdke.version));
          }
        }
        else
        {
          ad.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (bt.isNullOrNil(a.bp(paramString, localdke.type))) {
            localLinkedList.add(I(paramString, localdke.type, localdke.version));
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
          paramAnonymousString = (apa)paramAnonymousb.gUT.gUX;
          if ((paramAnonymousString.DqJ == null) || (paramAnonymousString.DqJ.size() == 0))
          {
            ad.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
            AppMethodBeat.o(44854);
            return;
          }
          ad.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[] { Integer.valueOf(paramAnonymousString.DqJ.size()) });
          paramAnonymousString = paramAnonymousString.DqJ.iterator();
          while (paramAnonymousString.hasNext())
          {
            paramAnonymousb = (ed)paramAnonymousString.next();
            ad.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousb.Cyt, Integer.valueOf(paramAnonymousb.Cys) });
            if (!bt.isNullOrNil(paramAnonymousb.Cyt))
            {
              p.a.J(this.jev, paramAnonymousb.mBH, paramAnonymousb.Cys);
              p.a.K(this.jev, paramAnonymousb.mBH, paramAnonymousb.Cys);
              p.a.m(this.jev, paramAnonymousb.mBH, paramAnonymousb.Cyt);
            }
          }
          AppMethodBeat.o(44854);
        }
      });
    }
    AppMethodBeat.o(44867);
  }
  
  private static void a(LinkedList<aoy> paramLinkedList, b paramb)
  {
    AppMethodBeat.i(44871);
    b.a locala = new b.a();
    locala.funcId = 1138;
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
    locala.gUV = new apa();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    aoz localaoz = new aoz();
    localaoz.DqI = paramLinkedList;
    locala.gUU = localaoz;
    x.a(locala.atI(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(44856);
        if (this.jex != null) {
          this.jex.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb);
        }
        AppMethodBeat.o(44856);
        return 0;
      }
    }, true);
    AppMethodBeat.o(44871);
  }
  
  public static void b(String paramString, LinkedList<dke> paramLinkedList)
  {
    AppMethodBeat.i(44866);
    a(paramString, paramLinkedList, true);
    AppMethodBeat.o(44866);
  }
  
  public static final class a
  {
    public static String FV(String paramString)
    {
      AppMethodBeat.i(195687);
      paramString = String.format("%s#NotifyMessageStatus", new Object[] { paramString });
      AppMethodBeat.o(195687);
      return paramString;
    }
    
    public static void J(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44860);
      if (j.Dh() == null)
      {
        AppMethodBeat.o(44860);
        return;
      }
      j.Dh().cl(bk(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44860);
    }
    
    public static void K(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44861);
      if (j.Dh() == null)
      {
        AppMethodBeat.o(44861);
        return;
      }
      j.Dh().cl(bl(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44861);
    }
    
    private static String bk(String paramString, int paramInt)
    {
      AppMethodBeat.i(44857);
      paramString = String.format("%s_%s_local_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44857);
      return paramString;
    }
    
    private static String bl(String paramString, int paramInt)
    {
      AppMethodBeat.i(44858);
      paramString = String.format("%s_%s_server_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44858);
      return paramString;
    }
    
    private static String bm(String paramString, int paramInt)
    {
      AppMethodBeat.i(44859);
      paramString = String.format("%s_%s_config", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44859);
      return paramString;
    }
    
    public static int bn(String paramString, int paramInt)
    {
      AppMethodBeat.i(44863);
      if (j.Dh() == null)
      {
        AppMethodBeat.o(44863);
        return 0;
      }
      paramInt = bt.getInt(j.Dh().get(bk(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44863);
      return paramInt;
    }
    
    public static int bo(String paramString, int paramInt)
    {
      AppMethodBeat.i(44864);
      if (j.Dh() == null)
      {
        AppMethodBeat.o(44864);
        return 0;
      }
      paramInt = bt.getInt(j.Dh().get(bl(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44864);
      return paramInt;
    }
    
    public static String bp(String paramString, int paramInt)
    {
      AppMethodBeat.i(44865);
      if (j.Dh() == null)
      {
        AppMethodBeat.o(44865);
        return "";
      }
      paramString = j.Dh().get(bm(paramString, paramInt), "");
      AppMethodBeat.o(44865);
      return paramString;
    }
    
    public static void m(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(44862);
      if (j.Dh() == null)
      {
        AppMethodBeat.o(44862);
        return;
      }
      j.Dh().cl(bm(paramString1, paramInt), paramString2);
      AppMethodBeat.o(44862);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, b paramb);
  }
  
  public static abstract interface c
  {
    public abstract void Eh(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.p
 * JD-Core Version:    0.7.0.1
 */