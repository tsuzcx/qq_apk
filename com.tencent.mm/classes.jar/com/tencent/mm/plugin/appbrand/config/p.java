package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class p
{
  private static awq J(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44868);
    awq localawq = new awq();
    localawq.ikm = paramString;
    localawq.nJA = paramInt1;
    localawq.FOE = paramInt2;
    AppMethodBeat.o(44868);
    return localawq;
  }
  
  public static String a(final String paramString, int paramInt1, int paramInt2, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(44869);
    if (j.Em() == null)
    {
      AppMethodBeat.o(44869);
      return "";
    }
    int i = a.bw(paramString, paramInt1);
    int j = a.bx(paramString, paramInt1);
    String str = a.by(paramString, paramInt1);
    boolean bool;
    if ((j != 0) && ((bu.isNullOrNil(str)) || (j > i)))
    {
      bool = true;
      ae.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      ae.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", new Object[] { str, Boolean.valueOf(bool) });
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
              ae.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if (this.kcd != null) {
                this.kcd.Mf("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (aws)paramAnonymousb.hQE.hQJ;
            if ((paramAnonymousString.GOo == null) || (paramAnonymousString.GOo.size() == 0))
            {
              ae.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
              if (this.kcd != null) {
                this.kcd.Mf("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (ej)paramAnonymousString.GOo.get(0);
            ae.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousString.FOF, Integer.valueOf(paramAnonymousString.FOE) });
            if (!bu.isNullOrNil(paramAnonymousString.FOF))
            {
              p.a.K(paramString, paramAnonymousString.nJA, paramAnonymousString.FOE);
              p.a.L(paramString, paramAnonymousString.nJA, paramAnonymousString.FOE);
              p.a.p(paramString, paramAnonymousString.nJA, paramAnonymousString.FOF);
              if (this.kcd != null)
              {
                this.kcd.Mf(paramAnonymousString.FOF);
                AppMethodBeat.o(44855);
              }
            }
            else if (this.kcd != null)
            {
              this.kcd.Mf("");
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
      paramc.Mf(str);
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, b paramb)
  {
    AppMethodBeat.i(44870);
    LinkedList localLinkedList = new LinkedList();
    awq localawq = new awq();
    localawq.ikm = paramString;
    localawq.nJA = paramInt1;
    localawq.FOE = paramInt2;
    localawq.GOm = paramInt3;
    localLinkedList.add(localawq);
    a(localLinkedList, paramb);
    AppMethodBeat.o(44870);
  }
  
  public static void a(String paramString, LinkedList<dwh> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(44867);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
      AppMethodBeat.o(44867);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ae.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
      AppMethodBeat.o(44867);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      dwh localdwh = (dwh)localIterator.next();
      ae.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[] { Integer.valueOf(localdwh.version), Integer.valueOf(localdwh.type) });
      int i = a.bw(paramString, localdwh.type);
      int j = localdwh.version;
      a.L(paramString, localdwh.type, j);
      if (j != 0) {
        if (j > i)
        {
          localLinkedList.add(J(paramString, localdwh.type, localdwh.version));
        }
        else if (j == i)
        {
          if (bu.isNullOrNil(a.by(paramString, localdwh.type))) {
            localLinkedList.add(J(paramString, localdwh.type, localdwh.version));
          }
        }
        else
        {
          ae.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (bu.isNullOrNil(a.by(paramString, localdwh.type))) {
            localLinkedList.add(J(paramString, localdwh.type, localdwh.version));
          }
        }
      }
    }
    ae.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()), Integer.valueOf(localLinkedList.size()) });
    if (paramBoolean)
    {
      if (localLinkedList.size() == 0)
      {
        AppMethodBeat.o(44867);
        return;
      }
      ae.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", new Object[] { paramString });
      a(localLinkedList, new b()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(44854);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ae.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(44854);
            return;
          }
          paramAnonymousString = (aws)paramAnonymousb.hQE.hQJ;
          if ((paramAnonymousString.GOo == null) || (paramAnonymousString.GOo.size() == 0))
          {
            ae.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
            AppMethodBeat.o(44854);
            return;
          }
          ae.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[] { Integer.valueOf(paramAnonymousString.GOo.size()) });
          paramAnonymousString = paramAnonymousString.GOo.iterator();
          while (paramAnonymousString.hasNext())
          {
            paramAnonymousb = (ej)paramAnonymousString.next();
            ae.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousb.FOF, Integer.valueOf(paramAnonymousb.FOE) });
            if (!bu.isNullOrNil(paramAnonymousb.FOF))
            {
              p.a.K(this.kcc, paramAnonymousb.nJA, paramAnonymousb.FOE);
              p.a.L(this.kcc, paramAnonymousb.nJA, paramAnonymousb.FOE);
              p.a.p(this.kcc, paramAnonymousb.nJA, paramAnonymousb.FOF);
            }
          }
          AppMethodBeat.o(44854);
        }
      });
    }
    AppMethodBeat.o(44867);
  }
  
  private static void a(LinkedList<awq> paramLinkedList, b paramb)
  {
    AppMethodBeat.i(44871);
    b.a locala = new b.a();
    locala.funcId = 1138;
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
    locala.hQG = new aws();
    locala.hQH = 0;
    locala.respCmdId = 0;
    awr localawr = new awr();
    localawr.GOn = paramLinkedList;
    locala.hQF = localawr;
    x.a(locala.aDS(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(44856);
        if (this.kce != null) {
          this.kce.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb);
        }
        AppMethodBeat.o(44856);
        return 0;
      }
    }, true);
    AppMethodBeat.o(44871);
  }
  
  public static void b(String paramString, LinkedList<dwh> paramLinkedList)
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
      if (j.Em() == null)
      {
        AppMethodBeat.o(44860);
        return;
      }
      j.Em().cz(bt(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44860);
    }
    
    public static void L(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44861);
      if (j.Em() == null)
      {
        AppMethodBeat.o(44861);
        return;
      }
      j.Em().cz(bu(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44861);
    }
    
    public static String Oa(String paramString)
    {
      AppMethodBeat.i(222224);
      paramString = String.format("%s#NotifyMessageStatus", new Object[] { paramString });
      AppMethodBeat.o(222224);
      return paramString;
    }
    
    private static String bt(String paramString, int paramInt)
    {
      AppMethodBeat.i(44857);
      paramString = String.format("%s_%s_local_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44857);
      return paramString;
    }
    
    private static String bu(String paramString, int paramInt)
    {
      AppMethodBeat.i(44858);
      paramString = String.format("%s_%s_server_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44858);
      return paramString;
    }
    
    private static String bv(String paramString, int paramInt)
    {
      AppMethodBeat.i(44859);
      paramString = String.format("%s_%s_config", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44859);
      return paramString;
    }
    
    public static int bw(String paramString, int paramInt)
    {
      AppMethodBeat.i(44863);
      if (j.Em() == null)
      {
        AppMethodBeat.o(44863);
        return 0;
      }
      paramInt = bu.getInt(j.Em().get(bt(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44863);
      return paramInt;
    }
    
    public static int bx(String paramString, int paramInt)
    {
      AppMethodBeat.i(44864);
      if (j.Em() == null)
      {
        AppMethodBeat.o(44864);
        return 0;
      }
      paramInt = bu.getInt(j.Em().get(bu(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44864);
      return paramInt;
    }
    
    public static String by(String paramString, int paramInt)
    {
      AppMethodBeat.i(44865);
      if (j.Em() == null)
      {
        AppMethodBeat.o(44865);
        return "";
      }
      paramString = j.Em().get(bv(paramString, paramInt), "");
      AppMethodBeat.o(44865);
      return paramString;
    }
    
    public static void p(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(44862);
      if (j.Em() == null)
      {
        AppMethodBeat.o(44862);
        return;
      }
      j.Em().cz(bv(paramString1, paramInt), paramString2);
      AppMethodBeat.o(44862);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, b paramb);
  }
  
  public static abstract interface c
  {
    public abstract void Mf(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.p
 * JD-Core Version:    0.7.0.1
 */