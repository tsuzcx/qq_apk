package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.protocal.protobuf.eqm;
import com.tencent.mm.protocal.protobuf.ew;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class q
{
  private static bia M(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44868);
    bia localbia = new bia();
    localbia.jfi = paramString;
    localbia.oUv = paramInt1;
    localbia.KIm = paramInt2;
    AppMethodBeat.o(44868);
    return localbia;
  }
  
  public static String a(final String paramString, int paramInt1, int paramInt2, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(44869);
    if (n.NL() == null)
    {
      AppMethodBeat.o(44869);
      return "";
    }
    int i = a.bB(paramString, paramInt1);
    int j = a.bC(paramString, paramInt1);
    String str = a.bD(paramString, paramInt1);
    boolean bool;
    if ((j != 0) && ((Util.isNullOrNil(str)) || (j > i)))
    {
      bool = true;
      Log.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      Log.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", new Object[] { str, Boolean.valueOf(bool) });
      if (!bool) {
        break label155;
      }
      if (paramBoolean) {
        a(paramString, paramInt1, j, paramInt2, new b()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
          {
            AppMethodBeat.i(44855);
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              Log.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if (this.lfk != null) {
                this.lfk.Vo("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (bic)paramAnonymousd.iLL.iLR;
            if ((paramAnonymousString.LSs == null) || (paramAnonymousString.LSs.size() == 0))
            {
              Log.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
              if (this.lfk != null) {
                this.lfk.Vo("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (ew)paramAnonymousString.LSs.get(0);
            Log.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousString.KIn, Integer.valueOf(paramAnonymousString.KIm) });
            if (!Util.isNullOrNil(paramAnonymousString.KIn))
            {
              q.a.N(paramString, paramAnonymousString.oUv, paramAnonymousString.KIm);
              q.a.O(paramString, paramAnonymousString.oUv, paramAnonymousString.KIm);
              q.a.t(paramString, paramAnonymousString.oUv, paramAnonymousString.KIn);
              if (this.lfk != null)
              {
                this.lfk.Vo(paramAnonymousString.KIn);
                AppMethodBeat.o(44855);
              }
            }
            else if (this.lfk != null)
            {
              this.lfk.Vo("");
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
      paramc.Vo(str);
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, b paramb)
  {
    AppMethodBeat.i(44870);
    LinkedList localLinkedList = new LinkedList();
    bia localbia = new bia();
    localbia.jfi = paramString;
    localbia.oUv = paramInt1;
    localbia.KIm = paramInt2;
    localbia.LSq = paramInt3;
    localLinkedList.add(localbia);
    a(localLinkedList, paramb);
    AppMethodBeat.o(44870);
  }
  
  public static void a(String paramString, LinkedList<eqm> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(44867);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
      AppMethodBeat.o(44867);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      Log.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
      AppMethodBeat.o(44867);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      eqm localeqm = (eqm)localIterator.next();
      Log.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[] { Integer.valueOf(localeqm.version), Integer.valueOf(localeqm.type) });
      int i = a.bB(paramString, localeqm.type);
      int j = localeqm.version;
      a.O(paramString, localeqm.type, j);
      if (j != 0) {
        if (j > i)
        {
          localLinkedList.add(M(paramString, localeqm.type, localeqm.version));
        }
        else if (j == i)
        {
          if (Util.isNullOrNil(a.bD(paramString, localeqm.type))) {
            localLinkedList.add(M(paramString, localeqm.type, localeqm.version));
          }
        }
        else
        {
          Log.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (Util.isNullOrNil(a.bD(paramString, localeqm.type))) {
            localLinkedList.add(M(paramString, localeqm.type, localeqm.version));
          }
        }
      }
    }
    Log.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()), Integer.valueOf(localLinkedList.size()) });
    if (paramBoolean)
    {
      if (localLinkedList.size() == 0)
      {
        AppMethodBeat.o(44867);
        return;
      }
      Log.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", new Object[] { paramString });
      a(localLinkedList, new b()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
        {
          AppMethodBeat.i(44854);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(44854);
            return;
          }
          paramAnonymousString = (bic)paramAnonymousd.iLL.iLR;
          if ((paramAnonymousString.LSs == null) || (paramAnonymousString.LSs.size() == 0))
          {
            Log.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
            AppMethodBeat.o(44854);
            return;
          }
          Log.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[] { Integer.valueOf(paramAnonymousString.LSs.size()) });
          paramAnonymousString = paramAnonymousString.LSs.iterator();
          while (paramAnonymousString.hasNext())
          {
            paramAnonymousd = (ew)paramAnonymousString.next();
            Log.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousd.KIn, Integer.valueOf(paramAnonymousd.KIm) });
            if (!Util.isNullOrNil(paramAnonymousd.KIn))
            {
              q.a.N(this.lfj, paramAnonymousd.oUv, paramAnonymousd.KIm);
              q.a.O(this.lfj, paramAnonymousd.oUv, paramAnonymousd.KIm);
              q.a.t(this.lfj, paramAnonymousd.oUv, paramAnonymousd.KIn);
            }
          }
          AppMethodBeat.o(44854);
        }
      });
    }
    AppMethodBeat.o(44867);
  }
  
  private static void a(LinkedList<bia> paramLinkedList, b paramb)
  {
    AppMethodBeat.i(44871);
    d.a locala = new d.a();
    locala.funcId = 1138;
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
    locala.iLO = new bic();
    locala.iLP = 0;
    locala.respCmdId = 0;
    bib localbib = new bib();
    localbib.LSr = paramLinkedList;
    locala.iLN = localbib;
    aa.a(locala.aXF(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, com.tencent.mm.ak.q paramAnonymousq)
      {
        AppMethodBeat.i(44856);
        if (this.lfl != null) {
          this.lfl.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd);
        }
        AppMethodBeat.o(44856);
        return 0;
      }
    }, true);
    AppMethodBeat.o(44871);
  }
  
  public static void b(String paramString, LinkedList<eqm> paramLinkedList)
  {
    AppMethodBeat.i(44866);
    a(paramString, paramLinkedList, true);
    AppMethodBeat.o(44866);
  }
  
  public static final class a
  {
    public static void N(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44860);
      if (n.NL() == null)
      {
        AppMethodBeat.o(44860);
        return;
      }
      n.NL().cN(by(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44860);
    }
    
    public static void O(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44861);
      if (n.NL() == null)
      {
        AppMethodBeat.o(44861);
        return;
      }
      n.NL().cN(bz(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44861);
    }
    
    public static String Xj(String paramString)
    {
      AppMethodBeat.i(226466);
      paramString = String.format("%s#NotifyMessageStatus", new Object[] { paramString });
      AppMethodBeat.o(226466);
      return paramString;
    }
    
    private static String bA(String paramString, int paramInt)
    {
      AppMethodBeat.i(44859);
      paramString = String.format("%s_%s_config", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44859);
      return paramString;
    }
    
    public static int bB(String paramString, int paramInt)
    {
      AppMethodBeat.i(44863);
      if (n.NL() == null)
      {
        AppMethodBeat.o(44863);
        return 0;
      }
      paramInt = Util.getInt(n.NL().get(by(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44863);
      return paramInt;
    }
    
    public static int bC(String paramString, int paramInt)
    {
      AppMethodBeat.i(44864);
      if (n.NL() == null)
      {
        AppMethodBeat.o(44864);
        return 0;
      }
      paramInt = Util.getInt(n.NL().get(bz(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44864);
      return paramInt;
    }
    
    public static String bD(String paramString, int paramInt)
    {
      AppMethodBeat.i(44865);
      if (n.NL() == null)
      {
        AppMethodBeat.o(44865);
        return "";
      }
      paramString = n.NL().get(bA(paramString, paramInt), "");
      AppMethodBeat.o(44865);
      return paramString;
    }
    
    private static String by(String paramString, int paramInt)
    {
      AppMethodBeat.i(44857);
      paramString = String.format("%s_%s_local_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44857);
      return paramString;
    }
    
    private static String bz(String paramString, int paramInt)
    {
      AppMethodBeat.i(44858);
      paramString = String.format("%s_%s_server_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44858);
      return paramString;
    }
    
    public static void t(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(44862);
      if (n.NL() == null)
      {
        AppMethodBeat.o(44862);
        return;
      }
      n.NL().cN(bA(paramString1, paramInt), paramString2);
      AppMethodBeat.o(44862);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, d paramd);
  }
  
  public static abstract interface c
  {
    public abstract void Vo(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.q
 * JD-Core Version:    0.7.0.1
 */