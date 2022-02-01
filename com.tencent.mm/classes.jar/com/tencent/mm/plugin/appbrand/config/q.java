package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.fay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class q
{
  private static bpl M(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44868);
    bpl localbpl = new bpl();
    localbpl.lVG = paramString;
    localbpl.rWu = paramInt1;
    localbpl.RJD = paramInt2;
    AppMethodBeat.o(44868);
    return localbpl;
  }
  
  public static String a(final String paramString, int paramInt1, int paramInt2, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(44869);
    if (m.QG() == null)
    {
      AppMethodBeat.o(44869);
      return "";
    }
    int i = a.bV(paramString, paramInt1);
    int j = a.bW(paramString, paramInt1);
    String str = a.bX(paramString, paramInt1);
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
              if (this.nZx != null) {
                this.nZx.acY("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (bpn)d.c.b(paramAnonymousd.lBS);
            if ((paramAnonymousString.Tbe == null) || (paramAnonymousString.Tbe.size() == 0))
            {
              Log.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
              if (this.nZx != null) {
                this.nZx.acY("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (et)paramAnonymousString.Tbe.get(0);
            Log.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousString.RJE, Integer.valueOf(paramAnonymousString.RJD) });
            if (!Util.isNullOrNil(paramAnonymousString.RJE))
            {
              q.a.N(paramString, paramAnonymousString.rWu, paramAnonymousString.RJD);
              q.a.O(paramString, paramAnonymousString.rWu, paramAnonymousString.RJD);
              q.a.u(paramString, paramAnonymousString.rWu, paramAnonymousString.RJE);
              if (this.nZx != null)
              {
                this.nZx.acY(paramAnonymousString.RJE);
                AppMethodBeat.o(44855);
              }
            }
            else if (this.nZx != null)
            {
              this.nZx.acY("");
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
      paramc.acY(str);
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, b paramb)
  {
    AppMethodBeat.i(44870);
    LinkedList localLinkedList = new LinkedList();
    bpl localbpl = new bpl();
    localbpl.lVG = paramString;
    localbpl.rWu = paramInt1;
    localbpl.RJD = paramInt2;
    localbpl.Tbc = paramInt3;
    localLinkedList.add(localbpl);
    a(localLinkedList, paramb);
    AppMethodBeat.o(44870);
  }
  
  public static void a(String paramString, LinkedList<fay> paramLinkedList, boolean paramBoolean)
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
      fay localfay = (fay)localIterator.next();
      Log.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[] { Integer.valueOf(localfay.version), Integer.valueOf(localfay.type) });
      int i = a.bV(paramString, localfay.type);
      int j = localfay.version;
      a.O(paramString, localfay.type, j);
      if (j != 0) {
        if (j > i)
        {
          localLinkedList.add(M(paramString, localfay.type, localfay.version));
        }
        else if (j == i)
        {
          if (Util.isNullOrNil(a.bX(paramString, localfay.type))) {
            localLinkedList.add(M(paramString, localfay.type, localfay.version));
          }
        }
        else
        {
          Log.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (Util.isNullOrNil(a.bX(paramString, localfay.type))) {
            localLinkedList.add(M(paramString, localfay.type, localfay.version));
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
          paramAnonymousString = (bpn)d.c.b(paramAnonymousd.lBS);
          if ((paramAnonymousString.Tbe == null) || (paramAnonymousString.Tbe.size() == 0))
          {
            Log.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
            AppMethodBeat.o(44854);
            return;
          }
          Log.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[] { Integer.valueOf(paramAnonymousString.Tbe.size()) });
          paramAnonymousString = paramAnonymousString.Tbe.iterator();
          while (paramAnonymousString.hasNext())
          {
            paramAnonymousd = (et)paramAnonymousString.next();
            Log.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousd.RJE, Integer.valueOf(paramAnonymousd.RJD) });
            if (!Util.isNullOrNil(paramAnonymousd.RJE))
            {
              q.a.N(this.nZw, paramAnonymousd.rWu, paramAnonymousd.RJD);
              q.a.O(this.nZw, paramAnonymousd.rWu, paramAnonymousd.RJD);
              q.a.u(this.nZw, paramAnonymousd.rWu, paramAnonymousd.RJE);
            }
          }
          AppMethodBeat.o(44854);
        }
      });
    }
    AppMethodBeat.o(44867);
  }
  
  private static void a(LinkedList<bpl> paramLinkedList, b paramb)
  {
    AppMethodBeat.i(44871);
    d.a locala = new d.a();
    locala.funcId = 1138;
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
    locala.lBV = new bpn();
    locala.lBW = 0;
    locala.respCmdId = 0;
    bpm localbpm = new bpm();
    localbpm.Tbd = paramLinkedList;
    locala.lBU = localbpm;
    aa.a(locala.bgN(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(44856);
        if (this.nZy != null) {
          this.nZy.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd);
        }
        AppMethodBeat.o(44856);
        return 0;
      }
    }, true);
    AppMethodBeat.o(44871);
  }
  
  public static void b(String paramString, LinkedList<fay> paramLinkedList)
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
      if (m.QG() == null)
      {
        AppMethodBeat.o(44860);
        return;
      }
      m.QG().cW(bS(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44860);
    }
    
    public static void O(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44861);
      if (m.QG() == null)
      {
        AppMethodBeat.o(44861);
        return;
      }
      m.QG().cW(bT(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44861);
    }
    
    public static String aeV(String paramString)
    {
      AppMethodBeat.i(280336);
      paramString = String.format("%s#NotifyMessageStatus", new Object[] { paramString });
      AppMethodBeat.o(280336);
      return paramString;
    }
    
    private static String bS(String paramString, int paramInt)
    {
      AppMethodBeat.i(44857);
      paramString = String.format("%s_%s_local_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44857);
      return paramString;
    }
    
    private static String bT(String paramString, int paramInt)
    {
      AppMethodBeat.i(44858);
      paramString = String.format("%s_%s_server_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44858);
      return paramString;
    }
    
    private static String bU(String paramString, int paramInt)
    {
      AppMethodBeat.i(44859);
      paramString = String.format("%s_%s_config", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44859);
      return paramString;
    }
    
    public static int bV(String paramString, int paramInt)
    {
      AppMethodBeat.i(44863);
      if (m.QG() == null)
      {
        AppMethodBeat.o(44863);
        return 0;
      }
      paramInt = Util.getInt(m.QG().L(bS(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44863);
      return paramInt;
    }
    
    public static int bW(String paramString, int paramInt)
    {
      AppMethodBeat.i(44864);
      if (m.QG() == null)
      {
        AppMethodBeat.o(44864);
        return 0;
      }
      paramInt = Util.getInt(m.QG().L(bT(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44864);
      return paramInt;
    }
    
    public static String bX(String paramString, int paramInt)
    {
      AppMethodBeat.i(44865);
      if (m.QG() == null)
      {
        AppMethodBeat.o(44865);
        return "";
      }
      paramString = m.QG().L(bU(paramString, paramInt), "");
      AppMethodBeat.o(44865);
      return paramString;
    }
    
    public static void u(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(44862);
      if (m.QG() == null)
      {
        AppMethodBeat.o(44862);
        return;
      }
      m.QG().cW(bU(paramString1, paramInt), paramString2);
      AppMethodBeat.o(44862);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, d paramd);
  }
  
  public static abstract interface c
  {
    public abstract void acY(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.q
 * JD-Core Version:    0.7.0.1
 */