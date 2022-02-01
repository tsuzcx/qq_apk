package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.protocal.protobuf.cec;
import com.tencent.mm.protocal.protobuf.ced;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.protocal.protobuf.fxf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
{
  private static cec Q(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44868);
    cec localcec = new cec();
    localcec.oOI = paramString;
    localcec.vhJ = paramInt1;
    localcec.YGX = paramInt2;
    AppMethodBeat.o(44868);
    return localcec;
  }
  
  public static String a(final String paramString, int paramInt1, int paramInt2, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(44869);
    if (n.aqS() == null)
    {
      AppMethodBeat.o(44869);
      return "";
    }
    int i = a.cn(paramString, paramInt1);
    int j = a.co(paramString, paramInt1);
    String str = a.cp(paramString, paramInt1);
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
          public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc)
          {
            AppMethodBeat.i(44855);
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              Log.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if (s.this != null) {
                s.this.Vv("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (cee)c.c.b(paramAnonymousc.otC);
            if ((paramAnonymousString.aaoq == null) || (paramAnonymousString.aaoq.size() == 0))
            {
              Log.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
              if (s.this != null) {
                s.this.Vv("");
              }
              AppMethodBeat.o(44855);
              return;
            }
            paramAnonymousString = (fn)paramAnonymousString.aaoq.get(0);
            Log.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousString.YGY, Integer.valueOf(paramAnonymousString.YGX) });
            if (!Util.isNullOrNil(paramAnonymousString.YGY))
            {
              s.a.R(paramString, paramAnonymousString.vhJ, paramAnonymousString.YGX);
              s.a.S(paramString, paramAnonymousString.vhJ, paramAnonymousString.YGX);
              s.a.x(paramString, paramAnonymousString.vhJ, paramAnonymousString.YGY);
              if (s.this != null)
              {
                s.this.Vv(paramAnonymousString.YGY);
                AppMethodBeat.o(44855);
              }
            }
            else if (s.this != null)
            {
              s.this.Vv("");
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
      paramc.Vv(str);
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, b paramb)
  {
    AppMethodBeat.i(44870);
    LinkedList localLinkedList = new LinkedList();
    cec localcec = new cec();
    localcec.oOI = paramString;
    localcec.vhJ = paramInt1;
    localcec.YGX = paramInt2;
    localcec.aaoo = paramInt3;
    localLinkedList.add(localcec);
    a(localLinkedList, paramb);
    AppMethodBeat.o(44870);
  }
  
  public static void a(String paramString, LinkedList<fxf> paramLinkedList, boolean paramBoolean)
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
      fxf localfxf = (fxf)localIterator.next();
      Log.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[] { Integer.valueOf(localfxf.version), Integer.valueOf(localfxf.type) });
      int i = a.cn(paramString, localfxf.type);
      int j = localfxf.version;
      a.S(paramString, localfxf.type, j);
      if (j != 0) {
        if (j > i)
        {
          localLinkedList.add(Q(paramString, localfxf.type, localfxf.version));
        }
        else if (j == i)
        {
          if (Util.isNullOrNil(a.cp(paramString, localfxf.type))) {
            localLinkedList.add(Q(paramString, localfxf.type, localfxf.version));
          }
        }
        else
        {
          Log.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (Util.isNullOrNil(a.cp(paramString, localfxf.type))) {
            localLinkedList.add(Q(paramString, localfxf.type, localfxf.version));
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
        public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc)
        {
          AppMethodBeat.i(44854);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(44854);
            return;
          }
          paramAnonymousString = (cee)c.c.b(paramAnonymousc.otC);
          if ((paramAnonymousString.aaoq == null) || (paramAnonymousString.aaoq.size() == 0))
          {
            Log.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
            AppMethodBeat.o(44854);
            return;
          }
          Log.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[] { Integer.valueOf(paramAnonymousString.aaoq.size()) });
          paramAnonymousString = paramAnonymousString.aaoq.iterator();
          while (paramAnonymousString.hasNext())
          {
            paramAnonymousc = (fn)paramAnonymousString.next();
            Log.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramAnonymousc.YGY, Integer.valueOf(paramAnonymousc.YGX) });
            if (!Util.isNullOrNil(paramAnonymousc.YGY))
            {
              s.a.R(s.this, paramAnonymousc.vhJ, paramAnonymousc.YGX);
              s.a.S(s.this, paramAnonymousc.vhJ, paramAnonymousc.YGX);
              s.a.x(s.this, paramAnonymousc.vhJ, paramAnonymousc.YGY);
            }
          }
          AppMethodBeat.o(44854);
        }
      });
    }
    AppMethodBeat.o(44867);
  }
  
  private static void a(LinkedList<cec> paramLinkedList, b paramb)
  {
    AppMethodBeat.i(44871);
    c.a locala = new c.a();
    locala.funcId = 1138;
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
    locala.otF = new cee();
    locala.otG = 0;
    locala.respCmdId = 0;
    ced localced = new ced();
    localced.aaop = paramLinkedList;
    locala.otE = localced;
    z.a(locala.bEF(), new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
      {
        AppMethodBeat.i(44856);
        if (s.this != null) {
          s.this.callback(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousc);
        }
        AppMethodBeat.o(44856);
        return 0;
      }
    }, true);
    AppMethodBeat.o(44871);
  }
  
  public static void b(String paramString, LinkedList<fxf> paramLinkedList)
  {
    AppMethodBeat.i(44866);
    a(paramString, paramLinkedList, true);
    AppMethodBeat.o(44866);
  }
  
  public static final class a
  {
    public static void R(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44860);
      if (n.aqS() == null)
      {
        AppMethodBeat.o(44860);
        return;
      }
      n.aqS().dn(ck(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44860);
    }
    
    public static void S(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44861);
      if (n.aqS() == null)
      {
        AppMethodBeat.o(44861);
        return;
      }
      n.aqS().dn(cl(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(44861);
    }
    
    public static String Xx(String paramString)
    {
      AppMethodBeat.i(323445);
      paramString = String.format("%s#NotifyMessageStatus", new Object[] { paramString });
      AppMethodBeat.o(323445);
      return paramString;
    }
    
    private static String ck(String paramString, int paramInt)
    {
      AppMethodBeat.i(44857);
      paramString = String.format("%s_%s_local_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44857);
      return paramString;
    }
    
    private static String cl(String paramString, int paramInt)
    {
      AppMethodBeat.i(44858);
      paramString = String.format("%s_%s_server_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44858);
      return paramString;
    }
    
    private static String cm(String paramString, int paramInt)
    {
      AppMethodBeat.i(44859);
      paramString = String.format("%s_%s_config", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(44859);
      return paramString;
    }
    
    public static int cn(String paramString, int paramInt)
    {
      AppMethodBeat.i(44863);
      if (n.aqS() == null)
      {
        AppMethodBeat.o(44863);
        return 0;
      }
      paramInt = Util.getInt(n.aqS().O(ck(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44863);
      return paramInt;
    }
    
    public static int co(String paramString, int paramInt)
    {
      AppMethodBeat.i(44864);
      if (n.aqS() == null)
      {
        AppMethodBeat.o(44864);
        return 0;
      }
      paramInt = Util.getInt(n.aqS().O(cl(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(44864);
      return paramInt;
    }
    
    public static String cp(String paramString, int paramInt)
    {
      AppMethodBeat.i(44865);
      if (n.aqS() == null)
      {
        AppMethodBeat.o(44865);
        return "";
      }
      paramString = n.aqS().O(cm(paramString, paramInt), "");
      AppMethodBeat.o(44865);
      return paramString;
    }
    
    public static void x(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(44862);
      if (n.aqS() == null)
      {
        AppMethodBeat.o(44862);
        return;
      }
      n.aqS().dn(cm(paramString1, paramInt), paramString2);
      AppMethodBeat.o(44862);
    }
  }
  
  public static abstract interface b
  {
    public abstract void callback(int paramInt1, int paramInt2, String paramString, c paramc);
  }
  
  public static abstract interface c
  {
    public abstract void Vv(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.s
 * JD-Core Version:    0.7.0.1
 */