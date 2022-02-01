package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.aw.b;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMWizardActivity;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public final class m
{
  private static SimpleDateFormat oMZ;
  
  static
  {
    AppMethodBeat.i(24732);
    oMZ = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    AppMethodBeat.o(24732);
  }
  
  public static String a(int paramInt1, k.b paramb, int paramInt2)
  {
    AppMethodBeat.i(24720);
    Log.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", new Object[] { Integer.valueOf(paramInt1), paramb.name, Long.valueOf(paramb.wNO), Integer.valueOf(paramInt2) });
    paramInt2 = Math.abs(paramInt2);
    StringBuilder localStringBuilder = new StringBuilder().append(String.format("%02d", new Object[] { Integer.valueOf(paramInt1) })).append(String.format("%03d", new Object[] { Long.valueOf(paramb.wNO) }));
    if (paramInt2 <= 999) {}
    for (paramb = String.format("%03d", new Object[] { Integer.valueOf(paramInt2) });; paramb = Integer.valueOf(paramInt2))
    {
      paramb = paramb;
      AppMethodBeat.o(24720);
      return paramb;
    }
  }
  
  public static String a(String paramString1, LinkedHashMap<String, Class> paramLinkedHashMap, MAutoStorage paramMAutoStorage, String paramString2)
  {
    AppMethodBeat.i(24730);
    if (paramLinkedHashMap.size() == 0)
    {
      AppMethodBeat.o(24730);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("\r\n");
    Object localObject1 = new StringBuilder();
    Object localObject2 = paramLinkedHashMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuilder)localObject1).append((String)((Map.Entry)((Iterator)localObject2).next()).getKey()).append(",");
    }
    if (((StringBuilder)localObject1).length() > 0) {
      ((StringBuilder)localObject1).delete(((StringBuilder)localObject1).length() - 1, ((StringBuilder)localObject1).length());
    }
    localObject1 = "select " + ((StringBuilder)localObject1).toString() + " from " + paramString1;
    localObject2 = paramLinkedHashMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      localStringBuilder.append((String)((Map.Entry)((Iterator)localObject2).next()).getKey()).append("\t");
    }
    localStringBuilder.append("\r\n");
    paramMAutoStorage = paramMAutoStorage.rawQuery((String)localObject1, new String[0]);
    for (;;)
    {
      int i;
      try
      {
        if (!paramMAutoStorage.moveToNext()) {
          break;
        }
        localObject1 = paramLinkedHashMap.entrySet().iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label529;
        }
        localObject2 = (Class)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localObject2 != String.class) {
          continue;
        }
        localStringBuilder.append(paramMAutoStorage.getString(i));
      }
      catch (Exception paramLinkedHashMap)
      {
        Log.i(paramString2, "print " + paramString1 + "error." + paramLinkedHashMap.getMessage());
        return "";
        if (localObject2 != Long.TYPE) {
          break label438;
        }
        localStringBuilder.append(paramMAutoStorage.getLong(i));
        continue;
      }
      finally
      {
        paramMAutoStorage.close();
        AppMethodBeat.o(24730);
      }
      localStringBuilder.append("\t");
      i += 1;
      continue;
      label529:
      if (localObject2 == Integer.TYPE) {
        localStringBuilder.append(paramMAutoStorage.getInt(i));
      } else {
        label438:
        if (localObject2 == Float.TYPE)
        {
          localStringBuilder.append(paramMAutoStorage.getFloat(i));
        }
        else if (localObject2 == Double.TYPE)
        {
          localStringBuilder.append(paramMAutoStorage.getDouble(i));
        }
        else
        {
          Log.e(paramString2, "unkonwn type " + ((Class)localObject2).toString());
          localStringBuilder.append(paramMAutoStorage.getString(i));
          continue;
          localStringBuilder.append("\r\n");
        }
      }
    }
    Log.i(paramString2, localStringBuilder.toString());
    paramLinkedHashMap = localStringBuilder.toString();
    paramMAutoStorage.close();
    AppMethodBeat.o(24730);
    return paramLinkedHashMap;
  }
  
  public static void a(final Intent paramIntent, final String paramString1, final int paramInt1, final int paramInt2, final a parama, String paramString2)
  {
    AppMethodBeat.i(24722);
    j.dNq().dMZ().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24703);
        Object localObject = k.dMF();
        ((k.a)localObject).ssid = m.axM(this.ogS);
        ((k.a)localObject).bssid = m.axN(this.ogS);
        ((k.a)localObject).dFe = m.axO(this.ogS);
        ((k.a)localObject).dFd = paramString1;
        ((k.a)localObject).quX = m.aw(paramIntent);
        ((k.a)localObject).wNc = paramInt1;
        ((k.a)localObject).wNd = k.b.wNp.wNO;
        ((k.a)localObject).wNe = k.b.wNp.name;
        ((k.a)localObject).channel = m.az(paramIntent);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).dMH().dMG();
        localObject = m.axN(this.ogS);
        String str = m.axM(this.ogS);
        int i = com.tencent.mm.plugin.freewifi.model.d.dNc();
        Log.i(this.ogS, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + NetStatusUtil.getNetType(MMApplicationContext.getContext()));
        Log.i(this.ogS, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.aw(paramIntent), Integer.valueOf(m.ax(paramIntent)), paramString1, localObject, str, Integer.valueOf(i) });
        new a(paramString1, (String)localObject, str, i, paramInt2, m.aw(paramIntent)).c(new i()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
          {
            AppMethodBeat.i(24702);
            Log.i(m.2.this.ogS, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.aw(m.2.this.val$intent), Integer.valueOf(m.ax(m.2.this.val$intent)), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
            k.a locala = k.dMF();
            locala.ssid = m.axM(m.2.this.ogS);
            locala.bssid = m.axN(m.2.this.ogS);
            locala.dFe = m.axO(m.2.this.ogS);
            locala.dFd = m.2.this.wNS;
            locala.quX = m.aw(m.2.this.val$intent);
            locala.wNc = m.ay(m.2.this.val$intent);
            locala.wNd = k.b.wNs.wNO;
            locala.wNe = k.b.wNs.name;
            locala.channel = m.az(m.2.this.val$intent);
            locala.result = paramAnonymous2Int2;
            locala.resultMsg = paramAnonymous2String;
            locala.dMH().c(m.2.this.val$intent, true).dMG();
            m.2.this.wNU.f(paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2String, paramAnonymous2q);
            AppMethodBeat.o(24702);
          }
        });
        AppMethodBeat.o(24703);
      }
    });
    AppMethodBeat.o(24722);
  }
  
  public static void a(Intent paramIntent, String paramString1, final int paramInt1, int paramInt2, final FreeWifiFrontPageUI paramFreeWifiFrontPageUI, String paramString2)
  {
    AppMethodBeat.i(24721);
    a(paramIntent, paramString1, paramInt1, paramInt2, new a()
    {
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(24701);
        Object localObject2;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (!(paramAnonymousq instanceof a))
          {
            AppMethodBeat.o(24701);
            return;
          }
          paramAnonymousString = ((a)paramAnonymousq).dNz();
          if (paramAnonymousString != null)
          {
            Log.i(this.ogS, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymousString.KGX, paramAnonymousString.oUJ, paramAnonymousString.UserName, Integer.valueOf(paramAnonymousString.KMt), paramAnonymousString.KMu, paramAnonymousString.keb, paramAnonymousString.KMv });
            paramAnonymousq = paramFreeWifiFrontPageUI;
            localObject1 = FreeWifiFrontPageUI.d.wRP;
            localObject2 = new FreeWifiFrontPageUI.b();
            ((FreeWifiFrontPageUI.b)localObject2).wRL = paramAnonymousString;
            paramAnonymousq.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
            AppMethodBeat.o(24701);
            return;
          }
          Log.i(this.ogS, "backPageInfo is null");
          paramAnonymousString = paramFreeWifiFrontPageUI;
          paramAnonymousq = FreeWifiFrontPageUI.d.wRO;
          localObject1 = new FreeWifiFrontPageUI.a();
          ((FreeWifiFrontPageUI.a)localObject1).wRo = m.a(paramInt1, k.b.wNq, 21);
          paramAnonymousString.a(paramAnonymousq, localObject1);
          AppMethodBeat.o(24701);
          return;
        }
        if ((m.gC(paramAnonymousInt1, paramAnonymousInt2)) && (!m.eP(paramAnonymousString)))
        {
          paramAnonymousq = paramFreeWifiFrontPageUI;
          localObject1 = FreeWifiFrontPageUI.d.wRO;
          localObject2 = new FreeWifiFrontPageUI.a();
          ((FreeWifiFrontPageUI.a)localObject2).text = paramAnonymousString;
          ((FreeWifiFrontPageUI.a)localObject2).wRo = m.a(paramInt1, k.b.wNq, paramAnonymousInt2);
          paramAnonymousq.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
          AppMethodBeat.o(24701);
          return;
        }
        paramAnonymousString = paramFreeWifiFrontPageUI;
        paramAnonymousq = FreeWifiFrontPageUI.d.wRO;
        Object localObject1 = new FreeWifiFrontPageUI.a();
        ((FreeWifiFrontPageUI.a)localObject1).wRo = m.a(paramInt1, k.b.wNq, paramAnonymousInt2);
        paramAnonymousString.a(paramAnonymousq, localObject1);
        AppMethodBeat.o(24701);
      }
    }, paramString2);
    AppMethodBeat.o(24721);
  }
  
  public static String aA(Intent paramIntent)
  {
    AppMethodBeat.i(24714);
    paramIntent = paramIntent.getStringExtra("free_wifi_ap_key");
    AppMethodBeat.o(24714);
    return paramIntent;
  }
  
  public static void av(Intent paramIntent)
  {
    AppMethodBeat.i(24707);
    if (eP(paramIntent.getStringExtra("free_wifi_sessionkey"))) {
      f(paramIntent, dMJ());
    }
    AppMethodBeat.o(24707);
  }
  
  public static String aw(Intent paramIntent)
  {
    AppMethodBeat.i(24710);
    paramIntent = axL(paramIntent.getStringExtra("free_wifi_sessionkey"));
    AppMethodBeat.o(24710);
    return paramIntent;
  }
  
  public static int ax(Intent paramIntent)
  {
    AppMethodBeat.i(24711);
    int i = paramIntent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
    paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", i);
    AppMethodBeat.o(24711);
    return i;
  }
  
  public static String axL(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String axM(String paramString)
  {
    AppMethodBeat.i(24715);
    String str = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
    Log.i(paramString, "getConnectedWifiSsid()=".concat(String.valueOf(str)));
    AppMethodBeat.o(24715);
    return str;
  }
  
  public static String axN(String paramString)
  {
    AppMethodBeat.i(24716);
    String str = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
    Log.i(paramString, "getConnectedWifiBssid()=".concat(String.valueOf(str)));
    AppMethodBeat.o(24716);
    return str;
  }
  
  public static String axO(String paramString)
  {
    AppMethodBeat.i(24717);
    String str = NetStatusUtil.getConnectedWifiClientMac(MMApplicationContext.getContext());
    Log.i(paramString, "getConnectedWifiClientMac()=".concat(String.valueOf(str)));
    AppMethodBeat.o(24717);
    return str;
  }
  
  public static void axP(String paramString)
  {
    AppMethodBeat.i(24731);
    Log.i("FreeWifi", paramString);
    AppMethodBeat.o(24731);
  }
  
  public static int ay(Intent paramIntent)
  {
    AppMethodBeat.i(24712);
    int i = paramIntent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    AppMethodBeat.o(24712);
    return i;
  }
  
  public static int az(Intent paramIntent)
  {
    AppMethodBeat.i(24713);
    int i = paramIntent.getIntExtra("free_wifi_channel_id", 0);
    AppMethodBeat.o(24713);
    return i;
  }
  
  public static boolean dMI()
  {
    AppMethodBeat.i(24706);
    String str = Util.getTopActivityName(MMApplicationContext.getContext());
    if ((str != null) && (str.toLowerCase().startsWith(MMApplicationContext.getSourcePackageName())))
    {
      AppMethodBeat.o(24706);
      return true;
    }
    AppMethodBeat.o(24706);
    return false;
  }
  
  public static String dMJ()
  {
    AppMethodBeat.i(24708);
    String str = UUID.randomUUID().toString().replace("-", "");
    AppMethodBeat.o(24708);
    return str;
  }
  
  public static int dMK()
  {
    AppMethodBeat.i(24723);
    Object localObject = l.bnZ();
    if ((localObject == l.a.keJ) || (localObject == l.a.keK))
    {
      AppMethodBeat.o(24723);
      return 1;
    }
    bg.aVF();
    localObject = (String)com.tencent.mm.model.c.azQ().get(6, null);
    if (eP((String)localObject))
    {
      AppMethodBeat.o(24723);
      return 1;
    }
    if (((String)localObject).startsWith("+")) {}
    for (localObject = PhoneFormater.extractCountryCode((String)localObject); "86".equals(localObject); localObject = "86")
    {
      AppMethodBeat.o(24723);
      return 2;
    }
    AppMethodBeat.o(24723);
    return 3;
  }
  
  public static boolean dML()
  {
    AppMethodBeat.i(24728);
    if (((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected())
    {
      Log.i("TAG", "isWifiConnected()=true");
      AppMethodBeat.o(24728);
      return true;
    }
    Log.i("TAG", "isWifiConnected()=false");
    AppMethodBeat.o(24728);
    return false;
  }
  
  public static ahc dMM()
  {
    AppMethodBeat.i(24729);
    ahc localahc = new ahc();
    localahc.deviceBrand = com.tencent.mm.protocal.d.KyI;
    if ((d.wMJ != null) && (!d.wMJ.equals(""))) {}
    for (localahc.LqM = d.wMJ;; localahc.LqM = axO("MicroMsg.FreeWifi.Utils"))
    {
      localahc.deviceModel = com.tencent.mm.protocal.d.KyJ;
      localahc.osName = com.tencent.mm.protocal.d.KyL;
      localahc.osVersion = com.tencent.mm.protocal.d.KyM;
      AppMethodBeat.o(24729);
      return localahc;
    }
  }
  
  public static boolean eP(String paramString)
  {
    AppMethodBeat.i(24704);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(24704);
      return true;
    }
    AppMethodBeat.o(24704);
    return false;
  }
  
  public static void f(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(24709);
    paramIntent.putExtra("free_wifi_sessionkey", paramString);
    paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
    AppMethodBeat.o(24709);
  }
  
  public static void fT(Context paramContext)
  {
    AppMethodBeat.i(24724);
    Intent localIntent = new Intent(paramContext, BindMContactUI.class);
    Object localObject = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = b.bs((String)localObject, paramContext.getString(2131758198));
      if (localObject != null)
      {
        localIntent.putExtra("country_name", ((b.a)localObject).jbZ);
        localIntent.putExtra("couttry_code", ((b.a)localObject).jbY);
      }
    }
    MMWizardActivity.ay(paramContext, localIntent);
    AppMethodBeat.o(24724);
  }
  
  public static boolean gB(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 0) && (paramInt2 == 0);
  }
  
  public static boolean gC(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 <= -30000) && (paramInt2 > -31000);
  }
  
  private static boolean hq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24727);
    int i = Util.getInt(paramString1, 0);
    int j = Util.getInt(paramString2, 0);
    if ((i == 0) && (j != 0) && (com.tencent.mm.protocal.d.KyO <= j))
    {
      AppMethodBeat.o(24727);
      return true;
    }
    if ((i != 0) && (j == 0) && (com.tencent.mm.protocal.d.KyO >= i))
    {
      AppMethodBeat.o(24727);
      return true;
    }
    if ((i != 0) && (j != 0) && (com.tencent.mm.protocal.d.KyO >= i) && (com.tencent.mm.protocal.d.KyO <= j))
    {
      AppMethodBeat.o(24727);
      return true;
    }
    AppMethodBeat.o(24727);
    return false;
  }
  
  public static String l(Exception paramException)
  {
    AppMethodBeat.i(24718);
    Object localObject = new StringWriter();
    paramException.printStackTrace(new PrintWriter((Writer)localObject));
    localObject = axL(((StringWriter)localObject).toString());
    paramException = (Exception)localObject;
    if (((String)localObject).length() > 1024) {
      paramException = ((String)localObject).substring(0, 1024);
    }
    AppMethodBeat.o(24718);
    return paramException;
  }
  
  public static boolean l(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(24726);
    Log.i(paramString, "CLIENT_VERSION=" + com.tencent.mm.protocal.d.KyO);
    String str1 = (String)paramMap.get(".sysmsg.apply_versions.version_desc.$minInclude");
    String str2 = (String)paramMap.get(".sysmsg.apply_versions.version_desc.$maxInclude");
    Log.i(paramString, "checkMsgPushedVersion. min0=%s,max0=%s", new Object[] { str1, str2 });
    if ((eP(str1)) && (eP(str2)))
    {
      AppMethodBeat.o(24726);
      return false;
    }
    if (hq(str1, str2))
    {
      AppMethodBeat.o(24726);
      return true;
    }
    int i = 1;
    for (;;)
    {
      str1 = (String)paramMap.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
      str2 = (String)paramMap.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
      Log.i(paramString, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", new Object[] { str1, str2 });
      if ((eP(str1)) && (eP(str2))) {
        break;
      }
      if (hq(str1, str2))
      {
        AppMethodBeat.o(24726);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(24726);
    return false;
  }
  
  public static String m(Exception paramException)
  {
    AppMethodBeat.i(24719);
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    paramException = axL(localStringWriter.toString());
    AppMethodBeat.o(24719);
    return paramException;
  }
  
  public static int n(Exception paramException)
  {
    AppMethodBeat.i(24725);
    if ((paramException instanceof SocketTimeoutException))
    {
      paramException = m(paramException);
      if (paramException.indexOf(".read") != -1)
      {
        AppMethodBeat.o(24725);
        return 105;
      }
      if (paramException.indexOf(".connect") != -1)
      {
        AppMethodBeat.o(24725);
        return 104;
      }
      AppMethodBeat.o(24725);
      return 101;
    }
    if ((paramException instanceof ConnectException))
    {
      AppMethodBeat.o(24725);
      return 106;
    }
    if ((paramException instanceof UnknownHostException))
    {
      AppMethodBeat.o(24725);
      return 102;
    }
    AppMethodBeat.o(24725);
    return 101;
  }
  
  public static String removeSsidQuote(String paramString)
  {
    AppMethodBeat.i(24705);
    if (eP(paramString))
    {
      AppMethodBeat.o(24705);
      return "";
    }
    String str = paramString;
    if (paramString.startsWith("\""))
    {
      str = paramString;
      if (paramString.endsWith("\"")) {
        str = paramString.substring(1, paramString.length() - 1);
      }
    }
    AppMethodBeat.o(24705);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void f(int paramInt1, int paramInt2, String paramString, q paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m
 * JD-Core Version:    0.7.0.1
 */