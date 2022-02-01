package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.aw.b;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
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
  private static SimpleDateFormat nCa;
  
  static
  {
    AppMethodBeat.i(24732);
    nCa = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    AppMethodBeat.o(24732);
  }
  
  public static String a(int paramInt1, k.b paramb, int paramInt2)
  {
    AppMethodBeat.i(24720);
    ae.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", new Object[] { Integer.valueOf(paramInt1), paramb.name, Long.valueOf(paramb.twK), Integer.valueOf(paramInt2) });
    paramInt2 = Math.abs(paramInt2);
    StringBuilder localStringBuilder = new StringBuilder().append(String.format("%02d", new Object[] { Integer.valueOf(paramInt1) })).append(String.format("%03d", new Object[] { Long.valueOf(paramb.twK) }));
    if (paramInt2 <= 999) {}
    for (paramb = String.format("%03d", new Object[] { Integer.valueOf(paramInt2) });; paramb = Integer.valueOf(paramInt2))
    {
      paramb = paramb;
      AppMethodBeat.o(24720);
      return paramb;
    }
  }
  
  public static String a(String paramString1, LinkedHashMap<String, Class> paramLinkedHashMap, com.tencent.mm.sdk.e.j paramj, String paramString2)
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
    paramj = paramj.rawQuery((String)localObject1, new String[0]);
    for (;;)
    {
      int i;
      try
      {
        if (!paramj.moveToNext()) {
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
        localStringBuilder.append(paramj.getString(i));
      }
      catch (Exception paramLinkedHashMap)
      {
        ae.i(paramString2, "print " + paramString1 + "error." + paramLinkedHashMap.getMessage());
        return "";
        if (localObject2 != Long.TYPE) {
          break label438;
        }
        localStringBuilder.append(paramj.getLong(i));
        continue;
      }
      finally
      {
        paramj.close();
        AppMethodBeat.o(24730);
      }
      localStringBuilder.append("\t");
      i += 1;
      continue;
      label529:
      if (localObject2 == Integer.TYPE) {
        localStringBuilder.append(paramj.getInt(i));
      } else {
        label438:
        if (localObject2 == Float.TYPE)
        {
          localStringBuilder.append(paramj.getFloat(i));
        }
        else if (localObject2 == Double.TYPE)
        {
          localStringBuilder.append(paramj.getDouble(i));
        }
        else
        {
          ae.e(paramString2, "unkonwn type " + ((Class)localObject2).toString());
          localStringBuilder.append(paramj.getString(i));
          continue;
          localStringBuilder.append("\r\n");
        }
      }
    }
    ae.i(paramString2, localStringBuilder.toString());
    paramLinkedHashMap = localStringBuilder.toString();
    paramj.close();
    AppMethodBeat.o(24730);
    return paramLinkedHashMap;
  }
  
  public static void a(Intent paramIntent, String paramString1, int paramInt1, int paramInt2, a parama, String paramString2)
  {
    AppMethodBeat.i(24722);
    com.tencent.mm.plugin.freewifi.model.j.cUh().cTQ().post(new m.2(paramString2, paramString1, paramIntent, paramInt1, paramInt2, parama));
    AppMethodBeat.o(24722);
  }
  
  public static void a(Intent paramIntent, String paramString1, int paramInt1, int paramInt2, FreeWifiFrontPageUI paramFreeWifiFrontPageUI, String paramString2)
  {
    AppMethodBeat.i(24721);
    a(paramIntent, paramString1, paramInt1, paramInt2, new m.1(paramString2, paramFreeWifiFrontPageUI, paramInt1), paramString2);
    AppMethodBeat.o(24721);
  }
  
  public static String akG(String paramString)
  {
    AppMethodBeat.i(24705);
    if (ef(paramString))
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
  
  public static String akH(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String akI(String paramString)
  {
    AppMethodBeat.i(24715);
    String str = az.ja(ak.getContext());
    ae.i(paramString, "getConnectedWifiSsid()=".concat(String.valueOf(str)));
    AppMethodBeat.o(24715);
    return str;
  }
  
  public static String akJ(String paramString)
  {
    AppMethodBeat.i(24716);
    String str = az.jb(ak.getContext());
    ae.i(paramString, "getConnectedWifiBssid()=".concat(String.valueOf(str)));
    AppMethodBeat.o(24716);
    return str;
  }
  
  public static String akK(String paramString)
  {
    AppMethodBeat.i(24717);
    String str = az.jc(ak.getContext());
    ae.i(paramString, "getConnectedWifiClientMac()=".concat(String.valueOf(str)));
    AppMethodBeat.o(24717);
    return str;
  }
  
  public static void akL(String paramString)
  {
    AppMethodBeat.i(24731);
    ae.i("FreeWifi", paramString);
    AppMethodBeat.o(24731);
  }
  
  public static void ao(Intent paramIntent)
  {
    AppMethodBeat.i(24707);
    if (ef(paramIntent.getStringExtra("free_wifi_sessionkey"))) {
      e(paramIntent, cTA());
    }
    AppMethodBeat.o(24707);
  }
  
  public static String ap(Intent paramIntent)
  {
    AppMethodBeat.i(24710);
    paramIntent = akH(paramIntent.getStringExtra("free_wifi_sessionkey"));
    AppMethodBeat.o(24710);
    return paramIntent;
  }
  
  public static int aq(Intent paramIntent)
  {
    AppMethodBeat.i(24711);
    int i = paramIntent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
    paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", i);
    AppMethodBeat.o(24711);
    return i;
  }
  
  public static int ar(Intent paramIntent)
  {
    AppMethodBeat.i(24712);
    int i = paramIntent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    AppMethodBeat.o(24712);
    return i;
  }
  
  public static int as(Intent paramIntent)
  {
    AppMethodBeat.i(24713);
    int i = paramIntent.getIntExtra("free_wifi_channel_id", 0);
    AppMethodBeat.o(24713);
    return i;
  }
  
  public static String at(Intent paramIntent)
  {
    AppMethodBeat.i(24714);
    paramIntent = paramIntent.getStringExtra("free_wifi_ap_key");
    AppMethodBeat.o(24714);
    return paramIntent;
  }
  
  public static String cTA()
  {
    AppMethodBeat.i(24708);
    String str = UUID.randomUUID().toString().replace("-", "");
    AppMethodBeat.o(24708);
    return str;
  }
  
  public static int cTB()
  {
    AppMethodBeat.i(24723);
    Object localObject = l.aTn();
    if ((localObject == l.a.jgF) || (localObject == l.a.jgG))
    {
      AppMethodBeat.o(24723);
      return 1;
    }
    bc.aCg();
    localObject = (String)com.tencent.mm.model.c.ajA().get(6, null);
    if (ef((String)localObject))
    {
      AppMethodBeat.o(24723);
      return 1;
    }
    if (((String)localObject).startsWith("+")) {}
    for (localObject = bb.apd((String)localObject); "86".equals(localObject); localObject = "86")
    {
      AppMethodBeat.o(24723);
      return 2;
    }
    AppMethodBeat.o(24723);
    return 3;
  }
  
  public static boolean cTC()
  {
    AppMethodBeat.i(24728);
    if (((ConnectivityManager)ak.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected())
    {
      ae.i("TAG", "isWifiConnected()=true");
      AppMethodBeat.o(24728);
      return true;
    }
    ae.i("TAG", "isWifiConnected()=false");
    AppMethodBeat.o(24728);
    return false;
  }
  
  public static aey cTD()
  {
    AppMethodBeat.i(24729);
    aey localaey = new aey();
    localaey.deviceBrand = com.tencent.mm.protocal.d.FFB;
    if ((d.tvF != null) && (!d.tvF.equals(""))) {}
    for (localaey.Gvh = d.tvF;; localaey.Gvh = akK("MicroMsg.FreeWifi.Utils"))
    {
      localaey.deviceModel = com.tencent.mm.protocal.d.FFC;
      localaey.osName = com.tencent.mm.protocal.d.FFE;
      localaey.osVersion = com.tencent.mm.protocal.d.FFF;
      AppMethodBeat.o(24729);
      return localaey;
    }
  }
  
  public static boolean cTz()
  {
    AppMethodBeat.i(24706);
    String str = bu.cK(ak.getContext());
    if ((str != null) && (str.toLowerCase().startsWith(ak.getPackageName())))
    {
      AppMethodBeat.o(24706);
      return true;
    }
    AppMethodBeat.o(24706);
    return false;
  }
  
  public static void e(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(24709);
    paramIntent.putExtra("free_wifi_sessionkey", paramString);
    paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
    AppMethodBeat.o(24709);
  }
  
  public static boolean ef(String paramString)
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
  
  public static void fn(Context paramContext)
  {
    AppMethodBeat.i(24724);
    Intent localIntent = new Intent(paramContext, BindMContactUI.class);
    Object localObject = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
    if (!bu.isNullOrNil((String)localObject))
    {
      localObject = b.bq((String)localObject, paramContext.getString(2131757950));
      if (localObject != null)
      {
        localIntent.putExtra("country_name", ((b.a)localObject).ihe);
        localIntent.putExtra("couttry_code", ((b.a)localObject).ihd);
      }
    }
    MMWizardActivity.al(paramContext, localIntent);
    AppMethodBeat.o(24724);
  }
  
  private static boolean gK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24727);
    int i = bu.getInt(paramString1, 0);
    int j = bu.getInt(paramString2, 0);
    if ((i == 0) && (j != 0) && (com.tencent.mm.protocal.d.FFH <= j))
    {
      AppMethodBeat.o(24727);
      return true;
    }
    if ((i != 0) && (j == 0) && (com.tencent.mm.protocal.d.FFH >= i))
    {
      AppMethodBeat.o(24727);
      return true;
    }
    if ((i != 0) && (j != 0) && (com.tencent.mm.protocal.d.FFH >= i) && (com.tencent.mm.protocal.d.FFH <= j))
    {
      AppMethodBeat.o(24727);
      return true;
    }
    AppMethodBeat.o(24727);
    return false;
  }
  
  public static boolean gc(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 0) && (paramInt2 == 0);
  }
  
  public static boolean gd(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 <= -30000) && (paramInt2 > -31000);
  }
  
  public static boolean k(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(24726);
    ae.i(paramString, "CLIENT_VERSION=" + com.tencent.mm.protocal.d.FFH);
    String str1 = (String)paramMap.get(".sysmsg.apply_versions.version_desc.$minInclude");
    String str2 = (String)paramMap.get(".sysmsg.apply_versions.version_desc.$maxInclude");
    ae.i(paramString, "checkMsgPushedVersion. min0=%s,max0=%s", new Object[] { str1, str2 });
    if ((ef(str1)) && (ef(str2)))
    {
      AppMethodBeat.o(24726);
      return false;
    }
    if (gK(str1, str2))
    {
      AppMethodBeat.o(24726);
      return true;
    }
    int i = 1;
    for (;;)
    {
      str1 = (String)paramMap.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
      str2 = (String)paramMap.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
      ae.i(paramString, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", new Object[] { str1, str2 });
      if ((ef(str1)) && (ef(str2))) {
        break;
      }
      if (gK(str1, str2))
      {
        AppMethodBeat.o(24726);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(24726);
    return false;
  }
  
  public static String l(Exception paramException)
  {
    AppMethodBeat.i(24718);
    Object localObject = new StringWriter();
    paramException.printStackTrace(new PrintWriter((Writer)localObject));
    localObject = akH(((StringWriter)localObject).toString());
    paramException = (Exception)localObject;
    if (((String)localObject).length() > 1024) {
      paramException = ((String)localObject).substring(0, 1024);
    }
    AppMethodBeat.o(24718);
    return paramException;
  }
  
  public static String m(Exception paramException)
  {
    AppMethodBeat.i(24719);
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    paramException = akH(localStringWriter.toString());
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
  
  public static abstract interface a
  {
    public abstract void g(int paramInt1, int paramInt2, String paramString, n paramn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m
 * JD-Core Version:    0.7.0.1
 */