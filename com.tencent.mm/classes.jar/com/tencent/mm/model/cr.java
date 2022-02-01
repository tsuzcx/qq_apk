package com.tencent.mm.model;

import android.content.SharedPreferences.Editor;
import android.support.v4.e.k;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.aho;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.fbv;
import com.tencent.mm.protocal.protobuf.ffe;
import com.tencent.mm.protocal.protobuf.ffg;
import com.tencent.mm.protocal.protobuf.ffh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatBrands.IReplaceApply;
import com.tencent.mm.sdk.platformtools.WeChatBrands.UserInfo;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public final class cr
{
  private static Set<Runnable> iGh;
  private static volatile boolean sInstalled;
  
  static
  {
    AppMethodBeat.i(197057);
    iGh = Collections.emptySet();
    sInstalled = false;
    AppMethodBeat.o(197057);
  }
  
  private static int A(long paramLong1, long paramLong2)
  {
    if ((paramLong2 & paramLong1) == paramLong1) {
      return 0;
    }
    return 1;
  }
  
  public static void F(Runnable paramRunnable)
  {
    AppMethodBeat.i(197044);
    iGh.add(paramRunnable);
    AppMethodBeat.o(197044);
  }
  
  private static MultiProcessMMKV KM(String paramString)
  {
    AppMethodBeat.i(197027);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(197027);
      return null;
    }
    try
    {
      paramString = MultiProcessMMKV.getMMKV(paramString);
      AppMethodBeat.o(197027);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.printErrStackTrace("MicroMsg.XAgreementSettings", paramString, "try get mmkv fail!", new Object[0]);
      AppMethodBeat.o(197027);
    }
    return null;
  }
  
  public static String KN(String paramString)
  {
    AppMethodBeat.i(197046);
    paramString = a.aWM().apply(paramString, new PInt());
    AppMethodBeat.o(197046);
    return paramString;
  }
  
  public static String KO(String paramString)
  {
    AppMethodBeat.i(197047);
    if ((WeChatBrands.UserInfo.xagreementId == 0) || (WeChatBrands.UserInfo.xagreementId == 1))
    {
      AppMethodBeat.o(197047);
      return paramString;
    }
    int i = paramString.indexOf("://");
    Object localObject = "";
    if (i >= 0)
    {
      str1 = paramString.substring(0, i + 3);
      localObject = str1;
      if (!str1.startsWith("http"))
      {
        AppMethodBeat.o(197047);
        return paramString;
      }
    }
    if (i < 0)
    {
      i = paramString.indexOf("/");
      if (i < 0) {
        break label221;
      }
    }
    label91:
    label221:
    for (String str1 = paramString.substring(i);; str1 = "")
    {
      String str2;
      if (i < 0)
      {
        i = paramString.indexOf(":");
        if (i < 0) {
          break label214;
        }
        String str3 = paramString.substring(0, i);
        str2 = paramString.substring(i);
        paramString = str3;
      }
      for (;;)
      {
        if (b.iGt == null) {
          b.cP(MMApplicationContext.getContext());
        }
        paramString = (String)b.iGt.get(paramString);
        paramString = a.aWM().apply(paramString, new PInt());
        paramString = (String)localObject + paramString + str2 + str1;
        AppMethodBeat.o(197047);
        return paramString;
        paramString = paramString.substring(i + 3);
        break;
        paramString = paramString.substring(0, i);
        break label91;
        str2 = "";
      }
    }
  }
  
  public static void a(ffe paramffe)
  {
    AppMethodBeat.i(197031);
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.XAgreementSettings", "Save saveDomainSettingsImpl");
        if (paramffe == null)
        {
          Log.w("MicroMsg.XAgreementSettings", "xAgreementDmSetting is null.");
          a.clearCache();
          aQG();
          AppMethodBeat.o(197031);
          return;
        }
        if (paramffe.KKx == null)
        {
          Log.w("MicroMsg.XAgreementSettings", "xAgreementDmSetting.Items is null.");
          continue;
        }
        localSparseArray = new SparseArray();
      }
      catch (Throwable paramffe)
      {
        Log.printErrStackTrace("MicroMsg.XAgreementSettings", paramffe, "", new Object[0]);
        AppMethodBeat.o(197031);
        return;
      }
      SparseArray localSparseArray;
      Object localObject2 = paramffe.KKx.iterator();
      Object localObject1;
      while (((Iterator)localObject2).hasNext())
      {
        aho localaho = (aho)((Iterator)localObject2).next();
        if (localaho == null)
        {
          Log.w("MicroMsg.XAgreementSettings", "dmItem is null..");
        }
        else if (localaho.Lrq < 0)
        {
          Log.w("MicroMsg.XAgreementSettings", "[!] illegal id, XAgreementId = " + localaho.Lrq);
        }
        else if (TextUtils.isEmpty(localaho.xMX))
        {
          Log.w("MicroMsg.XAgreementSettings", "[!] key is empty, XAgreementId = " + localaho.Lrq);
        }
        else
        {
          localObject1 = (List)localSparseArray.get(localaho.Lrq);
          paramffe = (ffe)localObject1;
          if (localObject1 == null)
          {
            paramffe = new ArrayList();
            localSparseArray.put(localaho.Lrq, paramffe);
          }
          paramffe.add(new k(localaho.xMX, localaho.Cyk));
        }
      }
      int i;
      while (i < localSparseArray.size())
      {
        int j = localSparseArray.keyAt(i);
        localObject1 = (List)localSparseArray.get(j);
        if (localObject1 != null)
        {
          paramffe = sl(j);
          if (paramffe != null)
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (k)((Iterator)localObject1).next();
              Log.d("MicroMsg.XAgreementSettings", "xAgreementDmSetting: %s, %s, %s", new Object[] { Integer.valueOf(j), ((k)localObject2).first, ((k)localObject2).second });
              paramffe.putString((String)((k)localObject2).first, (String)((k)localObject2).second);
            }
          }
        }
        i += 1;
        continue;
        i = 0;
      }
    }
  }
  
  public static void a(ffh paramffh)
  {
    AppMethodBeat.i(197033);
    ffg localffg;
    label207:
    MultiProcessMMKV localMultiProcessMMKV;
    do
    {
      for (;;)
      {
        try
        {
          Log.i("MicroMsg.XAgreementSettings", "Save XAgreementWordSettings");
          if (paramffh == null)
          {
            Log.w("MicroMsg.XAgreementSettings", "xAgreementWordingSetting is null.");
            a.clearCache();
            aQG();
            AppMethodBeat.o(197033);
            return;
          }
          if (paramffh.NAC == null)
          {
            Log.w("MicroMsg.XAgreementSettings", "XAgreementWording is null.");
            continue;
          }
          paramffh = paramffh.NAC.iterator();
        }
        catch (Throwable paramffh)
        {
          Log.printErrStackTrace("MicroMsg.XAgreementSettings", paramffh, "", new Object[0]);
          AppMethodBeat.o(197033);
          return;
        }
        while (paramffh.hasNext())
        {
          localffg = (ffg)paramffh.next();
          if (localffg == null)
          {
            Log.w("MicroMsg.XAgreementSettings", "xAgreementWording is null..");
          }
          else if (localffg.Lrq < 0)
          {
            Log.w("MicroMsg.XAgreementSettings", "[!] illegal id, XAgreementId = " + localffg.Lrq);
          }
          else
          {
            Log.i("MicroMsg.XAgreementSettings", "XAgreementId = %s", new Object[] { Integer.valueOf(localffg.Lrq) });
            if (localffg.NAB != null) {
              break label207;
            }
            Log.w("MicroMsg.XAgreementSettings", "[!] LangWordings is null.", new Object[] { Integer.valueOf(localffg.Lrq) });
          }
        }
      }
      localMultiProcessMMKV = sm(localffg.Lrq);
    } while (localMultiProcessMMKV == null);
    Iterator localIterator1 = localffg.NAB.iterator();
    for (;;)
    {
      cgy localcgy;
      if (localIterator1.hasNext())
      {
        localcgy = (cgy)localIterator1.next();
        if (localcgy == null)
        {
          Log.w("MicroMsg.XAgreementSettings", "[!] LangWordings is null..", new Object[] { Integer.valueOf(localffg.Lrq) });
          continue;
        }
        if (TextUtils.isEmpty(localcgy.xLl))
        {
          Log.w("MicroMsg.XAgreementSettings", "[!] lang is empty, XAgreementId = " + localffg.Lrq);
          continue;
        }
        if (localcgy.KKx == null) {
          Log.w("MicroMsg.XAgreementSettings", "[!] LangWordings(lang = %s).Items is null.", new Object[] { Integer.valueOf(localffg.Lrq), localcgy.xLl });
        }
      }
      else
      {
        break;
      }
      Iterator localIterator2 = localcgy.KKx.iterator();
      while (localIterator2.hasNext())
      {
        fbv localfbv = (fbv)localIterator2.next();
        if (localfbv == null)
        {
          Log.w("MicroMsg.XAgreementSettings", "[!] LangWordings(lang = %s).Items is null..", new Object[] { Integer.valueOf(localffg.Lrq), localcgy.xLl });
        }
        else if (TextUtils.isEmpty(localfbv.xMX))
        {
          Log.w("MicroMsg.XAgreementSettings", "[!] wodring key is empty, XAgreementId = " + localffg.Lrq + ", lang = " + localcgy.xLl);
        }
        else
        {
          Log.d("MicroMsg.XAgreementSettings", "XAgreementWordings: %s, %s, %s", new Object[] { localcgy.xLl, localfbv.xMX, localfbv.Cyk });
          localMultiProcessMMKV.putString(aS(localfbv.xMX, localcgy.xLl), localfbv.Cyk);
        }
      }
    }
  }
  
  private static void aQG()
  {
    AppMethodBeat.i(197045);
    Iterator localIterator = iGh.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    AppMethodBeat.o(197045);
  }
  
  private static String aS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197035);
    paramString1 = paramString1 + "@" + paramString2;
    AppMethodBeat.o(197035);
    return paramString1;
  }
  
  private static String aWD()
  {
    AppMethodBeat.i(197029);
    int i = com.tencent.mm.kernel.a.azs();
    if (i == 0)
    {
      AppMethodBeat.o(197029);
      return null;
    }
    String str = new p(i).toString();
    AppMethodBeat.o(197029);
    return str;
  }
  
  private static int aWE()
  {
    AppMethodBeat.i(197030);
    String str = aWD();
    if (str != null)
    {
      MultiProcessMMKV localMultiProcessMMKV = KM("xagreement_id_store");
      if (localMultiProcessMMKV != null)
      {
        i = localMultiProcessMMKV.decodeInt(str);
        Log.i("MicroMsg.XAgreementSettings", "Decode xagreementId return %s for %s", new Object[] { Integer.valueOf(i), str });
        AppMethodBeat.o(197030);
        return i;
      }
    }
    int i = WeChatBrands.AppInfo.current().getDefaultXAgreementId();
    Log.i("MicroMsg.XAgreementSettings", "Decode xagreementId return %s by default", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(197030);
    return i;
  }
  
  public static String aWF()
  {
    AppMethodBeat.i(197038);
    String str = KN("funcs_title");
    if (str.equals("funcs_title"))
    {
      AppMethodBeat.o(197038);
      return null;
    }
    AppMethodBeat.o(197038);
    return str;
  }
  
  public static String aWG()
  {
    AppMethodBeat.i(197039);
    String str = KN("funcs_content");
    if (str.equals("funcs_content"))
    {
      AppMethodBeat.o(197039);
      return null;
    }
    AppMethodBeat.o(197039);
    return str;
  }
  
  public static String aWH()
  {
    AppMethodBeat.i(197040);
    String str = KN("funcs_url");
    if (str.equals("funcs_url"))
    {
      AppMethodBeat.o(197040);
      return null;
    }
    AppMethodBeat.o(197040);
    return str;
  }
  
  public static void aWI()
  {
    AppMethodBeat.i(197042);
    if (sInstalled)
    {
      Log.w("MicroMsg.XAgreementSettings", "[!] Already initialized.");
      AppMethodBeat.o(197042);
      return;
    }
    iGh = new HashSet();
    sp(aWE());
    WeChatBrands.updateBizRestrictHandler(new android.arch.a.c.a() {});
    WeChatBrands.updateBizRestrictAlertHandler(new android.arch.a.c.a() {});
    EventCenter.instance.add(new IListener() {});
    d.refresh();
    sInstalled = true;
    AppMethodBeat.o(197042);
  }
  
  public static void sk(int paramInt)
  {
    AppMethodBeat.i(197028);
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.XAgreementSettings", "Save XAgreementId %s", new Object[] { Integer.valueOf(paramInt) });
        if (WeChatBrands.UserInfo.xagreementId == paramInt)
        {
          Log.i("MicroMsg.XAgreementSettings", "no need to update current XAgreementId");
          a.clearCache();
          aQG();
          AppMethodBeat.o(197028);
          return;
        }
        String str = aWD();
        if (str != null)
        {
          MultiProcessMMKV localMultiProcessMMKV = KM("xagreement_id_store");
          if (localMultiProcessMMKV != null) {
            localMultiProcessMMKV.encode(str, paramInt);
          }
          if (!d.aWP()) {
            break label153;
          }
          Log.w("MicroMsg.XAgreementSettings", "skip and ust test XAgreementId, update = " + paramInt + ", test = " + d.iGv);
          continue;
        }
        Log.e("MicroMsg.XAgreementSettings", "[!] saving xagreementId, but uin is invalid");
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.XAgreementSettings", localThrowable, "", new Object[0]);
        AppMethodBeat.o(197028);
        return;
      }
      continue;
      label153:
      sp(paramInt);
    }
  }
  
  private static MultiProcessMMKV sl(int paramInt)
  {
    AppMethodBeat.i(197032);
    MultiProcessMMKV localMultiProcessMMKV = KM("xagreement_domains_by_id_".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(197032);
    return localMultiProcessMMKV;
  }
  
  private static MultiProcessMMKV sm(int paramInt)
  {
    AppMethodBeat.i(197034);
    MultiProcessMMKV localMultiProcessMMKV = KM("xagreement_wordings_by_id_".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(197034);
    return localMultiProcessMMKV;
  }
  
  private static MultiProcessMMKV sn(int paramInt)
  {
    AppMethodBeat.i(197037);
    MultiProcessMMKV localMultiProcessMMKV = KM("xagreement_biz_entry_by_id_".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(197037);
    return localMultiProcessMMKV;
  }
  
  public static void so(int paramInt)
  {
    AppMethodBeat.i(197041);
    String str = aWD();
    Log.i("MicroMsg.XAgreementSettings", "#saveWalletRegion, walletRegion = " + paramInt + ", uin = " + str);
    if ((paramInt != -1) && (!TextUtils.isEmpty(str)))
    {
      MultiProcessMMKV localMultiProcessMMKV = KM("xagreement_wallet_region");
      if (localMultiProcessMMKV != null) {
        localMultiProcessMMKV.encode(str, paramInt);
      }
    }
    AppMethodBeat.o(197041);
  }
  
  private static void sp(int paramInt)
  {
    AppMethodBeat.i(197043);
    WeChatBrands.update(paramInt);
    WeChatBrands.updateReplacer(a.aWL());
    WeChatBrands.updateReplacer(new WeChatBrands.IReplaceApply()
    {
      WeChatBrands.IReplaceApply<String, String> iGi;
      
      public final void reload()
      {
        AppMethodBeat.i(197004);
        this.iGi.reload();
        AppMethodBeat.o(197004);
      }
    });
    AppMethodBeat.o(197043);
  }
  
  public static void z(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(197036);
    Log.i("MicroMsg.XAgreementSettings", "#saveFuncsSwith, FuncsSwitch = " + Long.toBinaryString(paramLong1) + ", FuncsUserChoiceSwitch = " + Long.toBinaryString(paramLong2));
    try
    {
      MultiProcessMMKV localMultiProcessMMKV = sn(WeChatBrands.UserInfo.xagreementId);
      if (localMultiProcessMMKV == null)
      {
        AppMethodBeat.o(197036);
        return;
      }
      localMultiProcessMMKV.putInt("pay", A(1L, paramLong1));
      localMultiProcessMMKV.putInt("mp", A(2L, paramLong1));
      localMultiProcessMMKV.putInt("oa", A(4L, paramLong1));
      localMultiProcessMMKV.putInt("third_party", A(8L, paramLong1));
      localMultiProcessMMKV.putInt("cross_data", A(16L, paramLong1));
      localMultiProcessMMKV.putInt("wecom", A(32L, paramLong1));
      localMultiProcessMMKV.putInt("channels", A(64L, paramLong1));
      localMultiProcessMMKV.putInt("secondary", A(128L, paramLong1));
      localMultiProcessMMKV.putInt("search", A(256L, paramLong1));
      localMultiProcessMMKV.putInt("wechat_out", A(512L, paramLong1));
      localMultiProcessMMKV.putInt("open", A(1024L, paramLong1));
      localMultiProcessMMKV.putInt("live", A(2048L, paramLong1));
      localMultiProcessMMKV.putInt("ads", A(4096L, paramLong1));
      aQG();
      AppMethodBeat.o(197036);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.XAgreementSettings", localThrowable, "saveFuncsSwith fail", new Object[0]);
      AppMethodBeat.o(197036);
    }
  }
  
  static abstract class a
    implements WeChatBrands.IReplaceApply<String, String>
  {
    private static final a iGk = new a()
    {
      public final String apply(String paramAnonymousString, PInt paramAnonymousPInt)
      {
        AppMethodBeat.i(197007);
        if (TextUtils.isEmpty(paramAnonymousString))
        {
          AppMethodBeat.o(197007);
          return "";
        }
        String str = super.apply(paramAnonymousString, paramAnonymousPInt);
        if (str != null)
        {
          AppMethodBeat.o(197007);
          return str;
        }
        str = cr.a.b.KQ(paramAnonymousString);
        if (str != null)
        {
          paramAnonymousString = a(paramAnonymousString, str, Integer.valueOf(0));
          AppMethodBeat.o(197007);
          return paramAnonymousString;
        }
        str = cr.a.c.KQ(paramAnonymousString);
        if (str != null)
        {
          paramAnonymousPInt.value = 1;
          paramAnonymousString = a(paramAnonymousString, str, Integer.valueOf(1));
          AppMethodBeat.o(197007);
          return paramAnonymousString;
        }
        AppMethodBeat.o(197007);
        return paramAnonymousString;
      }
      
      public final void reload()
      {
        AppMethodBeat.i(197006);
        this.iGj = new ConcurrentHashMap();
        cr.a.c.cO(MMApplicationContext.getContext());
        cr.a.b.cN(MMApplicationContext.getContext());
        AppMethodBeat.o(197006);
      }
    };
    Map<String, k<String, Integer>> iGj = new ConcurrentHashMap();
    
    static a aWL()
    {
      iGk.reload();
      return iGk;
    }
    
    static void clearCache()
    {
      iGk.iGj.clear();
    }
    
    public final String a(String paramString1, String paramString2, Integer paramInteger)
    {
      this.iGj.put(paramString1, k.c(paramString2, paramInteger));
      return paramString2;
    }
    
    public String apply(String paramString, PInt paramPInt)
    {
      paramString = (k)this.iGj.get(paramString);
      if (paramString == null) {
        return null;
      }
      paramPInt.value = ((Integer)paramString.second).intValue();
      return (String)paramString.first;
    }
    
    static final class a
    {
      static Map<String, Integer> iGl;
      
      static
      {
        AppMethodBeat.i(197010);
        iGl = Collections.emptyMap();
        AppMethodBeat.o(197010);
      }
      
      public static int a(WeChatBrands.Business.Entries paramEntries)
      {
        AppMethodBeat.i(197009);
        if (iGl.containsKey(paramEntries.group))
        {
          i = ((Integer)iGl.get(paramEntries.group)).intValue();
          AppMethodBeat.o(197009);
          return i;
        }
        if (!WeChatSomeFeatureSwitch.blockBizEetnryRemoteConfigs())
        {
          MultiProcessMMKV localMultiProcessMMKV = cr.ss(WeChatBrands.UserInfo.xagreementId);
          if (localMultiProcessMMKV != null)
          {
            i = localMultiProcessMMKV.getInt(paramEntries.group, paramEntries.status);
            AppMethodBeat.o(197009);
            return i;
          }
        }
        int i = paramEntries.status;
        AppMethodBeat.o(197009);
        return i;
      }
    }
    
    static class b
    {
      private static JSONObject iGm;
      private static int iGn = -1;
      private static boolean iGo = false;
      
      public static String KQ(String paramString)
      {
        AppMethodBeat.i(197012);
        Object localObject1 = cr.aT(paramString, WeChatBrands.AppInfo.lang);
        Object localObject2 = cr.sr(WeChatBrands.UserInfo.xagreementId);
        if (localObject2 != null)
        {
          localObject2 = ((MultiProcessMMKV)localObject2).getString((String)localObject1, null);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            AppMethodBeat.o(197012);
            return localObject2;
          }
        }
        else
        {
          localObject1 = null;
        }
        if (iGm != null) {
          localObject1 = iGm.optString(paramString, null);
        }
        AppMethodBeat.o(197012);
        return localObject1;
      }
      
      /* Error */
      public static void cN(android.content.Context paramContext)
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_1
        //   2: ldc 74
        //   4: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: ldc 2
        //   9: monitorenter
        //   10: getstatic 24	com/tencent/mm/model/cr$a$b:iGo	Z
        //   13: ifeq +12 -> 25
        //   16: ldc 2
        //   18: monitorexit
        //   19: ldc 74
        //   21: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   24: return
        //   25: iconst_1
        //   26: putstatic 24	com/tencent/mm/model/cr$a$b:iGo	Z
        //   29: ldc 2
        //   31: monitorexit
        //   32: getstatic 43	com/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo:lang	Ljava/lang/String;
        //   35: astore 4
        //   37: aload 4
        //   39: invokevirtual 80	java/lang/String:hashCode	()I
        //   42: lookupswitch	default:+242->284, 2155:+84->126, 2217:+127->169, 2307:+97->139, 2691:+112->154
        //   85: nop
        //   86: lstore_3
        //   87: ifnull +128 -> 215
        //   90: getstatic 22	com/tencent/mm/model/cr$a$b:iGn	I
        //   93: istore_2
        //   94: iload_2
        //   95: iload_1
        //   96: if_icmpne +119 -> 215
        //   99: ldc 2
        //   101: monitorenter
        //   102: iconst_0
        //   103: putstatic 24	com/tencent/mm/model/cr$a$b:iGo	Z
        //   106: ldc 2
        //   108: monitorexit
        //   109: ldc 74
        //   111: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   114: return
        //   115: astore_0
        //   116: ldc 2
        //   118: monitorexit
        //   119: ldc 74
        //   121: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   124: aload_0
        //   125: athrow
        //   126: aload 4
        //   128: ldc 82
        //   130: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   133: ifeq +151 -> 284
        //   136: goto +150 -> 286
        //   139: aload 4
        //   141: ldc 88
        //   143: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   146: ifeq +138 -> 284
        //   149: iconst_1
        //   150: istore_1
        //   151: goto +135 -> 286
        //   154: aload 4
        //   156: ldc 90
        //   158: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   161: ifeq +123 -> 284
        //   164: iconst_2
        //   165: istore_1
        //   166: goto +120 -> 286
        //   169: aload 4
        //   171: ldc 92
        //   173: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   176: istore_3
        //   177: iload_3
        //   178: ifeq +106 -> 284
        //   181: iconst_3
        //   182: istore_1
        //   183: goto +103 -> 286
        //   186: ldc 93
        //   188: istore_1
        //   189: goto -105 -> 84
        //   192: ldc 94
        //   194: istore_1
        //   195: goto -111 -> 84
        //   198: ldc 95
        //   200: istore_1
        //   201: goto -117 -> 84
        //   204: astore_0
        //   205: ldc 2
        //   207: monitorexit
        //   208: ldc 74
        //   210: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   213: aload_0
        //   214: athrow
        //   215: aload_0
        //   216: iload_1
        //   217: new 12	com/tencent/mm/model/cr$a$b$1
        //   220: dup
        //   221: iload_1
        //   222: invokespecial 97	com/tencent/mm/model/cr$a$b$1:<init>	(I)V
        //   225: invokestatic 100	com/tencent/mm/model/cr$a:a	(Landroid/content/Context;ILcom/tencent/mm/model/cr$a$d;)V
        //   228: ldc 2
        //   230: monitorenter
        //   231: iconst_0
        //   232: putstatic 24	com/tencent/mm/model/cr$a$b:iGo	Z
        //   235: ldc 2
        //   237: monitorexit
        //   238: ldc 74
        //   240: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   243: return
        //   244: astore_0
        //   245: ldc 2
        //   247: monitorexit
        //   248: ldc 74
        //   250: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   253: aload_0
        //   254: athrow
        //   255: astore_0
        //   256: ldc 2
        //   258: monitorenter
        //   259: iconst_0
        //   260: putstatic 24	com/tencent/mm/model/cr$a$b:iGo	Z
        //   263: ldc 2
        //   265: monitorexit
        //   266: ldc 74
        //   268: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   271: aload_0
        //   272: athrow
        //   273: astore_0
        //   274: ldc 2
        //   276: monitorexit
        //   277: ldc 74
        //   279: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   282: aload_0
        //   283: athrow
        //   284: iconst_m1
        //   285: istore_1
        //   286: iload_1
        //   287: tableswitch	default:+25 -> 312, 0:+-101->186, 1:+-95->192, 2:+-89->198
        //   313: lsub
        //   314: istore_1
        //   315: goto -231 -> 84
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	318	0	paramContext	android.content.Context
        //   1	314	1	i	int
        //   93	4	2	j	int
        //   176	2	3	bool	boolean
        //   35	135	4	str	String
        // Exception table:
        //   from	to	target	type
        //   10	19	115	finally
        //   25	32	115	finally
        //   116	119	115	finally
        //   102	109	204	finally
        //   205	208	204	finally
        //   231	238	244	finally
        //   245	248	244	finally
        //   32	84	255	finally
        //   84	94	255	finally
        //   126	136	255	finally
        //   139	149	255	finally
        //   154	164	255	finally
        //   169	177	255	finally
        //   215	228	255	finally
        //   259	266	273	finally
        //   274	277	273	finally
      }
    }
    
    static class c
    {
      private static boolean iGo = false;
      private static JSONObject iGq;
      private static int iGr = -1;
      
      public static String KQ(String paramString)
      {
        AppMethodBeat.i(197016);
        Object localObject = cr.sq(WeChatBrands.UserInfo.xagreementId);
        if (localObject != null)
        {
          String str = ((MultiProcessMMKV)localObject).getString(paramString, null);
          localObject = str;
          if (str != null)
          {
            AppMethodBeat.o(197016);
            return str;
          }
        }
        else
        {
          localObject = null;
        }
        if (iGq != null) {
          localObject = iGq.optString(paramString, null);
        }
        AppMethodBeat.o(197016);
        return localObject;
      }
      
      /* Error */
      public static void cO(android.content.Context paramContext)
      {
        // Byte code:
        //   0: ldc 65
        //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 2
        //   7: monitorenter
        //   8: getstatic 24	com/tencent/mm/model/cr$a$c:iGo	Z
        //   11: ifeq +12 -> 23
        //   14: ldc 2
        //   16: monitorexit
        //   17: ldc 65
        //   19: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   22: return
        //   23: iconst_1
        //   24: putstatic 24	com/tencent/mm/model/cr$a$c:iGo	Z
        //   27: ldc 2
        //   29: monitorexit
        //   30: getstatic 57	com/tencent/mm/model/cr$a$c:iGq	Lorg/json/JSONObject;
        //   33: ifnull +51 -> 84
        //   36: getstatic 22	com/tencent/mm/model/cr$a$c:iGr	I
        //   39: istore_1
        //   40: iload_1
        //   41: ldc 66
        //   43: if_icmpne +41 -> 84
        //   46: ldc 2
        //   48: monitorenter
        //   49: iconst_0
        //   50: putstatic 24	com/tencent/mm/model/cr$a$c:iGo	Z
        //   53: ldc 2
        //   55: monitorexit
        //   56: ldc 65
        //   58: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   61: return
        //   62: astore_0
        //   63: ldc 2
        //   65: monitorexit
        //   66: ldc 65
        //   68: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   71: aload_0
        //   72: athrow
        //   73: astore_0
        //   74: ldc 2
        //   76: monitorexit
        //   77: ldc 65
        //   79: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   82: aload_0
        //   83: athrow
        //   84: aload_0
        //   85: ldc 66
        //   87: new 12	com/tencent/mm/model/cr$a$c$1
        //   90: dup
        //   91: invokespecial 67	com/tencent/mm/model/cr$a$c$1:<init>	()V
        //   94: invokestatic 70	com/tencent/mm/model/cr$a:a	(Landroid/content/Context;ILcom/tencent/mm/model/cr$a$d;)V
        //   97: ldc 2
        //   99: monitorenter
        //   100: iconst_0
        //   101: putstatic 24	com/tencent/mm/model/cr$a$c:iGo	Z
        //   104: ldc 2
        //   106: monitorexit
        //   107: ldc 65
        //   109: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   112: return
        //   113: astore_0
        //   114: ldc 2
        //   116: monitorexit
        //   117: ldc 65
        //   119: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   122: aload_0
        //   123: athrow
        //   124: astore_0
        //   125: ldc 2
        //   127: monitorenter
        //   128: iconst_0
        //   129: putstatic 24	com/tencent/mm/model/cr$a$c:iGo	Z
        //   132: ldc 2
        //   134: monitorexit
        //   135: ldc 65
        //   137: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   140: aload_0
        //   141: athrow
        //   142: astore_0
        //   143: ldc 2
        //   145: monitorexit
        //   146: ldc 65
        //   148: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   151: aload_0
        //   152: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	153	0	paramContext	android.content.Context
        //   39	5	1	i	int
        // Exception table:
        //   from	to	target	type
        //   8	17	62	finally
        //   23	30	62	finally
        //   63	66	62	finally
        //   49	56	73	finally
        //   74	77	73	finally
        //   100	107	113	finally
        //   114	117	113	finally
        //   30	40	124	finally
        //   84	97	124	finally
        //   128	135	142	finally
        //   143	146	142	finally
      }
    }
    
    static abstract interface d
    {
      public abstract void w(JSONObject paramJSONObject);
    }
  }
  
  static final class b
  {
    static HashMap<String, String> iGt;
    
    /* Error */
    static void cP(android.content.Context paramContext)
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 15
      //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 23	com/tencent/mm/model/cr$b:iGt	Ljava/util/HashMap;
      //   11: ifnull +12 -> 23
      //   14: ldc 15
      //   16: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: ldc 2
      //   21: monitorexit
      //   22: return
      //   23: aload_0
      //   24: ldc 27
      //   26: new 9	com/tencent/mm/model/cr$b$1
      //   29: dup
      //   30: invokespecial 31	com/tencent/mm/model/cr$b$1:<init>	()V
      //   33: invokestatic 37	com/tencent/mm/model/cr$a:a	(Landroid/content/Context;ILcom/tencent/mm/model/cr$a$d;)V
      //   36: ldc 15
      //   38: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   41: goto -22 -> 19
      //   44: astore_0
      //   45: ldc 2
      //   47: monitorexit
      //   48: aload_0
      //   49: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	50	0	paramContext	android.content.Context
      // Exception table:
      //   from	to	target	type
      //   3	19	44	finally
      //   23	41	44	finally
    }
  }
  
  public static final class c
  {
    private static String iGu;
    
    /* Error */
    public static String aWN()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 12
      //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 20	com/tencent/mm/model/cr$c:iGu	Ljava/lang/String;
      //   11: ifnonnull +18 -> 29
      //   14: invokestatic 26	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   17: pop
      //   18: aconst_null
      //   19: putstatic 20	com/tencent/mm/model/cr$c:iGu	Ljava/lang/String;
      //   22: ldc 28
      //   24: ldc 30
      //   26: invokestatic 36	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   29: getstatic 20	com/tencent/mm/model/cr$c:iGu	Ljava/lang/String;
      //   32: ifnull +20 -> 52
      //   35: getstatic 20	com/tencent/mm/model/cr$c:iGu	Ljava/lang/String;
      //   38: invokestatic 42	com/tencent/mm/sdk/platformtools/WeChatBrands$Wordings:translate	(Ljava/lang/String;)Ljava/lang/String;
      //   41: astore_0
      //   42: ldc 12
      //   44: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   47: ldc 2
      //   49: monitorexit
      //   50: aload_0
      //   51: areturn
      //   52: ldc 47
      //   54: astore_0
      //   55: ldc 12
      //   57: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   60: goto -13 -> 47
      //   63: astore_0
      //   64: ldc 2
      //   66: monitorexit
      //   67: aload_0
      //   68: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   41	14	0	str	String
      //   63	5	0	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   3	29	63	finally
      //   29	47	63	finally
      //   55	60	63	finally
    }
  }
  
  public static final class d
  {
    private static int iGv = -1;
    
    public static void aWO()
    {
      AppMethodBeat.i(197025);
      Log.i("MicroMsg.XAgreementSettings", ">>>>>>>>>> WeChat Brands Test Configs <<<<<<<<<<");
      Log.i("MicroMsg.XAgreementSettings", ">> test XagreementId = " + iGv);
      Log.i("MicroMsg.XAgreementSettings", ">> test BinEntry Dict:");
      Object localObject1 = cr.KP("xagreement_test_configs");
      Object localObject2;
      int j;
      int i;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = ((MultiProcessMMKV)localObject1).allKeys();
        if (localObject2 != null)
        {
          j = localObject2.length;
          i = 0;
          while (i < j)
          {
            localObject3 = localObject2[i];
            Log.i("MicroMsg.XAgreementSettings", (String)localObject3 + " = " + ((MultiProcessMMKV)localObject1).getInt((String)localObject3, -1));
            i += 1;
          }
        }
      }
      Log.i("MicroMsg.XAgreementSettings", "\n");
      localObject1 = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        j = ((Integer)((Iterator)localObject1).next()).intValue();
        Log.i("MicroMsg.XAgreementSettings", ">> cgi Wording Dict for xid " + j + ":");
        localObject2 = cr.sr(j);
        int k;
        String str;
        if (localObject2 != null)
        {
          localObject3 = ((MultiProcessMMKV)localObject2).allKeys();
          if (localObject3 != null)
          {
            k = localObject3.length;
            i = 0;
            while (i < k)
            {
              str = localObject3[i];
              Log.i("MicroMsg.XAgreementSettings", str + " = " + ((MultiProcessMMKV)localObject2).getString(str, null));
              i += 1;
            }
          }
        }
        Log.i("MicroMsg.XAgreementSettings", ">> cgi Domain Dict for xid " + j + ":");
        localObject2 = cr.sq(WeChatBrands.UserInfo.xagreementId);
        if (localObject2 != null)
        {
          localObject3 = ((MultiProcessMMKV)localObject2).allKeys();
          if (localObject3 != null)
          {
            k = localObject3.length;
            i = 0;
            while (i < k)
            {
              str = localObject3[i];
              Log.i("MicroMsg.XAgreementSettings", str + " = " + ((MultiProcessMMKV)localObject2).getString(str, null));
              i += 1;
            }
          }
        }
        Log.i("MicroMsg.XAgreementSettings", ">> cgi Business Dict for xid " + j + ":");
        localObject2 = cr.ss(WeChatBrands.UserInfo.xagreementId);
        if (localObject2 != null)
        {
          localObject3 = ((MultiProcessMMKV)localObject2).allKeys();
          if (localObject3 != null)
          {
            j = localObject3.length;
            i = 0;
            while (i < j)
            {
              str = localObject3[i];
              Log.i("MicroMsg.XAgreementSettings", str + " = " + ((MultiProcessMMKV)localObject2).getInt(str, -1));
              i += 1;
            }
          }
        }
        Log.i("MicroMsg.XAgreementSettings", "\n");
      }
      Log.i("MicroMsg.XAgreementSettings", ">>>>>>>>>> WECHAT BRANDS TEST CONFIGS <<<<<<<<<<");
      AppMethodBeat.o(197025);
    }
    
    static boolean aWP()
    {
      return iGv != -1;
    }
    
    public static void am(String paramString, int paramInt)
    {
      AppMethodBeat.i(197023);
      MultiProcessMMKV localMultiProcessMMKV = cr.KP("xagreement_test_configs");
      if (localMultiProcessMMKV != null) {
        localMultiProcessMMKV.putInt(paramString, paramInt).commit();
      }
      refresh();
      AppMethodBeat.o(197023);
    }
    
    public static void clearAll()
    {
      AppMethodBeat.i(197024);
      MultiProcessMMKV localMultiProcessMMKV = cr.KP("xagreement_test_configs");
      if (localMultiProcessMMKV != null) {
        localMultiProcessMMKV.clearAll();
      }
      iGv = -1;
      cr.st(cr.aWK());
      refresh();
      AppMethodBeat.o(197024);
    }
    
    static void refresh()
    {
      AppMethodBeat.i(197021);
      Executors.newSingleThreadExecutor().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197020);
          cr.d.aWQ();
          if (cr.d.aWP())
          {
            cr.st(cr.d.iGv);
            cr.aWJ();
          }
          AppMethodBeat.o(197020);
        }
      });
      AppMethodBeat.o(197021);
    }
    
    public static void sw(int paramInt)
    {
      AppMethodBeat.i(197022);
      MultiProcessMMKV localMultiProcessMMKV = cr.KP("xagreement_test_configs");
      if (localMultiProcessMMKV != null) {
        localMultiProcessMMKV.putInt("test_xagreement_id", paramInt).commit();
      }
      refresh();
      AppMethodBeat.o(197022);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cr
 * JD-Core Version:    0.7.0.1
 */