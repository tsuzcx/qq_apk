package com.tencent.mm.cp;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.ISharedPreferenceProvider;
import com.tencent.xweb.af;
import com.tencent.xweb.util.IXWebLogClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.WebViewExtensionListener;

public final class b
{
  public static IXWebLogClient LYP;
  public static af LYQ;
  public static WebViewExtensionListener LYR;
  public static ISharedPreferenceProvider LYS;
  
  static
  {
    AppMethodBeat.i(152920);
    LYP = new IXWebLogClient()
    {
      final String TAG = "IXWebLogClient";
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152908);
        ae.d(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(152908);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152906);
        ae.e(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(152906);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152905);
        ae.i(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(152905);
      }
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152909);
        ae.v(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(152909);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152907);
        ae.w(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(152907);
      }
    };
    LYQ = new af()
    {
      final String TAG = "XWebIdkey";
      
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7)
      {
        AppMethodBeat.i(152913);
        ae.v("XWebIdkey", "callback: kvStat:15003, 200901," + paramAnonymousInt1 + ",0," + paramAnonymousString + "," + paramAnonymousInt3 + ",-1," + paramAnonymousInt4 + "," + paramAnonymousInt5 + "," + paramAnonymousInt6);
        com.tencent.mm.plugin.report.service.g.yxI.f(15003, new Object[] { Integer.valueOf(200901), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(az.getNetType(ak.getContext())), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(-1), Integer.valueOf(paramAnonymousInt4), Integer.valueOf(paramAnonymousInt5), Integer.valueOf(paramAnonymousInt6), Integer.valueOf(paramAnonymousInt7) });
        AppMethodBeat.o(152913);
      }
      
      public final void aV(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(152911);
        ae.v("XWebIdkey", "callback: idkeyForPair:577, " + paramAnonymousInt1 + ", 1, 577, " + paramAnonymousInt2 + ", " + paramAnonymousInt3);
        com.tencent.mm.plugin.report.service.g.yxI.a(577, 577, paramAnonymousInt1, paramAnonymousInt2, 1, paramAnonymousInt3, true);
        AppMethodBeat.o(152911);
      }
      
      public final void kvStat(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(152912);
        ae.v("XWebIdkey", "callback: kvStat:" + paramAnonymousInt + ", " + paramAnonymousString);
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(152912);
      }
      
      public final void n(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(152910);
        ae.v("XWebIdkey", "callback: idkeyStat:" + paramAnonymousLong1 + ", " + paramAnonymousLong2 + ", " + paramAnonymousLong3);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(paramAnonymousLong1, paramAnonymousLong2, paramAnonymousLong3, true);
        AppMethodBeat.o(152910);
      }
    };
    LYR = new WebViewExtensionListener()
    {
      public final int getHostByName(String paramAnonymousString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(152915);
        if (!com.tencent.mm.ipcinvoker.c.ahJ().xb("com.tencent.mm"))
        {
          AppMethodBeat.o(152915);
          return 0;
        }
        paramAnonymousString = (Bundle)XIPCInvoker.a("com.tencent.mm", new IPCString(paramAnonymousString), b.a.class);
        if ((paramAnonymousList != null) && (paramAnonymousString != null))
        {
          paramAnonymousList.clear();
          ArrayList localArrayList = paramAnonymousString.getStringArrayList("ipList");
          int i = paramAnonymousString.getInt("result");
          paramAnonymousList.addAll(localArrayList);
          AppMethodBeat.o(152915);
          return i;
        }
        AppMethodBeat.o(152915);
        return 0;
      }
      
      public final Object onMiscCallBack(String paramAnonymousString, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(152914);
        if ("AddFilterResources".equals(paramAnonymousString)) {
          com.tencent.mm.svg.a.e.a((Resources)paramAnonymousVarArgs[0], (Map)paramAnonymousVarArgs[1]);
        }
        AppMethodBeat.o(152914);
        return null;
      }
    };
    LYS = new ISharedPreferenceProvider()
    {
      public final SharedPreferences z(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(152916);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = ay.aRY(paramAnonymousString);
          if (paramAnonymousString == null)
          {
            AppMethodBeat.o(152916);
            return null;
          }
        }
        else
        {
          if (paramAnonymousInt == 4) {}
          for (paramAnonymousInt = 2;; paramAnonymousInt = 1)
          {
            paramAnonymousString = ay.gq(paramAnonymousString, paramAnonymousInt);
            break;
          }
        }
        paramAnonymousString = new c(paramAnonymousString);
        AppMethodBeat.o(152916);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(152920);
  }
  
  public static String getModuleName()
  {
    AppMethodBeat.i(152919);
    String str = ak.getProcessName();
    if (str == null)
    {
      AppMethodBeat.o(152919);
      return "";
    }
    if (str.contains(":"))
    {
      str = str.substring(str.lastIndexOf(":") + 1).toLowerCase();
      if (str.startsWith("appbrand"))
      {
        AppMethodBeat.o(152919);
        return "appbrand";
      }
      AppMethodBeat.o(152919);
      return str;
    }
    if (str.contains("."))
    {
      str = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
      AppMethodBeat.o(152919);
      return str;
    }
    AppMethodBeat.o(152919);
    return str;
  }
  
  static final class a
    implements k<IPCString, Bundle>
  {
    private static Bundle f(IPCString paramIPCString)
    {
      AppMethodBeat.i(152917);
      Bundle localBundle = new Bundle();
      for (;;)
      {
        try
        {
          ArrayList localArrayList = new ArrayList();
          if (!bu.isNullOrNil(paramIPCString.value))
          {
            i = com.tencent.mm.kernel.g.ajQ().gDv.hRo.getHostByName(paramIPCString.value, localArrayList);
            localBundle.putStringArrayList("ipList", localArrayList);
            localBundle.putInt("result", i);
            AppMethodBeat.o(152917);
            return localBundle;
          }
        }
        catch (Exception paramIPCString)
        {
          ae.printErrStackTrace("GetHostByNameTask", paramIPCString, "GetHostByNameTask", new Object[0]);
          AppMethodBeat.o(152917);
          return localBundle;
        }
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cp.b
 * JD-Core Version:    0.7.0.1
 */