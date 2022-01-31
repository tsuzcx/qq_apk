package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.au.b.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
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
  private static SimpleDateFormat jCL;
  
  static
  {
    AppMethodBeat.i(20655);
    jCL = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    AppMethodBeat.o(20655);
  }
  
  public static String Ou(String paramString)
  {
    AppMethodBeat.i(20628);
    if (isEmpty(paramString))
    {
      AppMethodBeat.o(20628);
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
    AppMethodBeat.o(20628);
    return str;
  }
  
  public static String Ov(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String Ow(String paramString)
  {
    AppMethodBeat.i(20638);
    String str = at.gX(ah.getContext());
    ab.i(paramString, "getConnectedWifiSsid()=".concat(String.valueOf(str)));
    AppMethodBeat.o(20638);
    return str;
  }
  
  public static String Ox(String paramString)
  {
    AppMethodBeat.i(20639);
    String str = at.gY(ah.getContext());
    ab.i(paramString, "getConnectedWifiBssid()=".concat(String.valueOf(str)));
    AppMethodBeat.o(20639);
    return str;
  }
  
  public static String Oy(String paramString)
  {
    AppMethodBeat.i(20640);
    String str = at.gZ(ah.getContext());
    ab.i(paramString, "getConnectedWifiClientMac()=".concat(String.valueOf(str)));
    AppMethodBeat.o(20640);
    return str;
  }
  
  public static void Oz(String paramString)
  {
    AppMethodBeat.i(20654);
    ab.i("FreeWifi", paramString);
    AppMethodBeat.o(20654);
  }
  
  public static void T(Intent paramIntent)
  {
    AppMethodBeat.i(20630);
    if (isEmpty(paramIntent.getStringExtra("free_wifi_sessionkey"))) {
      d(paramIntent, bAg());
    }
    AppMethodBeat.o(20630);
  }
  
  public static String U(Intent paramIntent)
  {
    AppMethodBeat.i(20633);
    paramIntent = Ov(paramIntent.getStringExtra("free_wifi_sessionkey"));
    AppMethodBeat.o(20633);
    return paramIntent;
  }
  
  public static int V(Intent paramIntent)
  {
    AppMethodBeat.i(20634);
    int i = paramIntent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
    paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", i);
    AppMethodBeat.o(20634);
    return i;
  }
  
  public static int W(Intent paramIntent)
  {
    AppMethodBeat.i(20635);
    int i = paramIntent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    AppMethodBeat.o(20635);
    return i;
  }
  
  public static int X(Intent paramIntent)
  {
    AppMethodBeat.i(20636);
    int i = paramIntent.getIntExtra("free_wifi_channel_id", 0);
    AppMethodBeat.o(20636);
    return i;
  }
  
  public static String Y(Intent paramIntent)
  {
    AppMethodBeat.i(20637);
    paramIntent = paramIntent.getStringExtra("free_wifi_ap_key");
    AppMethodBeat.o(20637);
    return paramIntent;
  }
  
  public static String a(int paramInt1, k.b paramb, int paramInt2)
  {
    AppMethodBeat.i(20643);
    ab.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", new Object[] { Integer.valueOf(paramInt1), paramb.name, Long.valueOf(paramb.mJq), Integer.valueOf(paramInt2) });
    paramInt2 = Math.abs(paramInt2);
    StringBuilder localStringBuilder = new StringBuilder().append(String.format("%02d", new Object[] { Integer.valueOf(paramInt1) })).append(String.format("%03d", new Object[] { Long.valueOf(paramb.mJq) }));
    if (paramInt2 <= 999) {}
    for (paramb = String.format("%03d", new Object[] { Integer.valueOf(paramInt2) });; paramb = Integer.valueOf(paramInt2))
    {
      paramb = paramb;
      AppMethodBeat.o(20643);
      return paramb;
    }
  }
  
  public static String a(String paramString1, LinkedHashMap<String, Class> paramLinkedHashMap, com.tencent.mm.sdk.e.j paramj, String paramString2)
  {
    AppMethodBeat.i(20653);
    if (paramLinkedHashMap.size() == 0)
    {
      AppMethodBeat.o(20653);
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
          break label532;
        }
        localObject2 = (Class)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localObject2 != String.class) {
          continue;
        }
        localStringBuilder.append(paramj.getString(i));
      }
      catch (Exception paramLinkedHashMap)
      {
        ab.i(paramString2, "print " + paramString1 + "error." + paramLinkedHashMap.getMessage());
        return "";
        if (localObject2 != Long.TYPE) {
          break label440;
        }
        localStringBuilder.append(paramj.getLong(i));
        continue;
      }
      finally
      {
        paramj.close();
        AppMethodBeat.o(20653);
      }
      localStringBuilder.append("\t");
      i += 1;
      continue;
      label532:
      if (localObject2 == Integer.TYPE) {
        localStringBuilder.append(paramj.getInt(i));
      } else {
        label440:
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
          ab.e(paramString2, "unkonwn type " + ((Class)localObject2).toString());
          localStringBuilder.append(paramj.getString(i));
          continue;
          localStringBuilder.append("\r\n");
        }
      }
    }
    ab.i(paramString2, localStringBuilder.toString());
    paramLinkedHashMap = localStringBuilder.toString();
    paramj.close();
    AppMethodBeat.o(20653);
    return paramLinkedHashMap;
  }
  
  public static void a(Intent paramIntent, String paramString1, int paramInt1, int paramInt2, m.a parama, String paramString2)
  {
    AppMethodBeat.i(20645);
    com.tencent.mm.plugin.freewifi.model.j.bAN().bAw().post(new m.2(paramString2, paramString1, paramIntent, paramInt1, paramInt2, parama));
    AppMethodBeat.o(20645);
  }
  
  public static void a(Intent paramIntent, String paramString1, final int paramInt1, int paramInt2, final FreeWifiFrontPageUI paramFreeWifiFrontPageUI, String paramString2)
  {
    AppMethodBeat.i(20644);
    a(paramIntent, paramString1, paramInt1, paramInt2, new m.a()
    {
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.m paramAnonymousm)
      {
        AppMethodBeat.i(20624);
        Object localObject2;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (!(paramAnonymousm instanceof a))
          {
            AppMethodBeat.o(20624);
            return;
          }
          paramAnonymousString = ((a)paramAnonymousm).bAW();
          if (paramAnonymousString != null)
          {
            ab.i(this.mJt, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymousString.woB, paramAnonymousString.jKG, paramAnonymousString.jJA, Integer.valueOf(paramAnonymousString.wsQ), paramAnonymousString.wsR, paramAnonymousString.gwS, paramAnonymousString.wsS });
            paramAnonymousm = paramFreeWifiFrontPageUI;
            localObject1 = FreeWifiFrontPageUI.d.mNK;
            localObject2 = new FreeWifiFrontPageUI.b();
            ((FreeWifiFrontPageUI.b)localObject2).mNG = paramAnonymousString;
            paramAnonymousm.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
            AppMethodBeat.o(20624);
            return;
          }
          ab.i(this.mJt, "backPageInfo is null");
          paramAnonymousString = paramFreeWifiFrontPageUI;
          paramAnonymousm = FreeWifiFrontPageUI.d.mNJ;
          localObject1 = new FreeWifiFrontPageUI.a();
          ((FreeWifiFrontPageUI.a)localObject1).mNi = m.a(paramInt1, k.b.mIS, 21);
          paramAnonymousString.a(paramAnonymousm, localObject1);
          AppMethodBeat.o(20624);
          return;
        }
        if ((m.eq(paramAnonymousInt1, paramAnonymousInt2)) && (!m.isEmpty(paramAnonymousString)))
        {
          paramAnonymousm = paramFreeWifiFrontPageUI;
          localObject1 = FreeWifiFrontPageUI.d.mNJ;
          localObject2 = new FreeWifiFrontPageUI.a();
          ((FreeWifiFrontPageUI.a)localObject2).text = paramAnonymousString;
          ((FreeWifiFrontPageUI.a)localObject2).mNi = m.a(paramInt1, k.b.mIS, paramAnonymousInt2);
          paramAnonymousm.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
          AppMethodBeat.o(20624);
          return;
        }
        paramAnonymousString = paramFreeWifiFrontPageUI;
        paramAnonymousm = FreeWifiFrontPageUI.d.mNJ;
        Object localObject1 = new FreeWifiFrontPageUI.a();
        ((FreeWifiFrontPageUI.a)localObject1).mNi = m.a(paramInt1, k.b.mIS, paramAnonymousInt2);
        paramAnonymousString.a(paramAnonymousm, localObject1);
        AppMethodBeat.o(20624);
      }
    }, paramString2);
    AppMethodBeat.o(20644);
  }
  
  public static boolean bAf()
  {
    AppMethodBeat.i(20629);
    String str = bo.ch(ah.getContext());
    if ((str != null) && (str.toLowerCase().startsWith(ah.getPackageName())))
    {
      AppMethodBeat.o(20629);
      return true;
    }
    AppMethodBeat.o(20629);
    return false;
  }
  
  public static String bAg()
  {
    AppMethodBeat.i(20631);
    String str = UUID.randomUUID().toString().replace("-", "");
    AppMethodBeat.o(20631);
    return str;
  }
  
  public static int bAh()
  {
    AppMethodBeat.i(20646);
    Object localObject = l.aqq();
    if ((localObject == l.a.gxz) || (localObject == l.a.gxA))
    {
      AppMethodBeat.o(20646);
      return 1;
    }
    aw.aaz();
    localObject = (String)com.tencent.mm.model.c.Ru().get(6, null);
    if (isEmpty((String)localObject))
    {
      AppMethodBeat.o(20646);
      return 1;
    }
    if (((String)localObject).startsWith("+")) {}
    for (localObject = av.RC((String)localObject); "86".equals(localObject); localObject = "86")
    {
      AppMethodBeat.o(20646);
      return 2;
    }
    AppMethodBeat.o(20646);
    return 3;
  }
  
  public static boolean bAi()
  {
    AppMethodBeat.i(20651);
    if (((ConnectivityManager)ah.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected())
    {
      ab.i("TAG", "isWifiConnected()=true");
      AppMethodBeat.o(20651);
      return true;
    }
    ab.i("TAG", "isWifiConnected()=false");
    AppMethodBeat.o(20651);
    return false;
  }
  
  public static yi bAj()
  {
    AppMethodBeat.i(20652);
    yi localyi = new yi();
    localyi.deviceBrand = com.tencent.mm.protocal.d.whB;
    if ((d.mIk != null) && (!d.mIk.equals(""))) {}
    for (localyi.wPv = d.mIk;; localyi.wPv = Oy("MicroMsg.FreeWifi.Utils"))
    {
      localyi.deviceModel = com.tencent.mm.protocal.d.whC;
      localyi.osName = com.tencent.mm.protocal.d.whE;
      localyi.osVersion = com.tencent.mm.protocal.d.whF;
      AppMethodBeat.o(20652);
      return localyi;
    }
  }
  
  public static void d(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(20632);
    paramIntent.putExtra("free_wifi_sessionkey", paramString);
    paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
    AppMethodBeat.o(20632);
  }
  
  public static void dY(Context paramContext)
  {
    AppMethodBeat.i(20647);
    Intent localIntent = new Intent(paramContext, BindMContactUI.class);
    Object localObject = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
    if (!bo.isNullOrNil((String)localObject))
    {
      localObject = b.k(paramContext, (String)localObject, paramContext.getString(2131298871));
      if (localObject != null)
      {
        localIntent.putExtra("country_name", ((b.a)localObject).fHT);
        localIntent.putExtra("couttry_code", ((b.a)localObject).fHS);
      }
    }
    MMWizardActivity.J(paramContext, localIntent);
    AppMethodBeat.o(20647);
  }
  
  public static String e(Exception paramException)
  {
    AppMethodBeat.i(20641);
    Object localObject = new StringWriter();
    paramException.printStackTrace(new PrintWriter((Writer)localObject));
    localObject = Ov(((StringWriter)localObject).toString());
    paramException = (Exception)localObject;
    if (((String)localObject).length() > 1024) {
      paramException = ((String)localObject).substring(0, 1024);
    }
    AppMethodBeat.o(20641);
    return paramException;
  }
  
  public static boolean ep(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 0) && (paramInt2 == 0);
  }
  
  public static boolean eq(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 <= -30000) && (paramInt2 > -31000);
  }
  
  private static boolean es(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20650);
    int i = bo.getInt(paramString1, 0);
    int j = bo.getInt(paramString2, 0);
    if ((i == 0) && (j != 0) && (com.tencent.mm.protocal.d.whH <= j))
    {
      AppMethodBeat.o(20650);
      return true;
    }
    if ((i != 0) && (j == 0) && (com.tencent.mm.protocal.d.whH >= i))
    {
      AppMethodBeat.o(20650);
      return true;
    }
    if ((i != 0) && (j != 0) && (com.tencent.mm.protocal.d.whH >= i) && (com.tencent.mm.protocal.d.whH <= j))
    {
      AppMethodBeat.o(20650);
      return true;
    }
    AppMethodBeat.o(20650);
    return false;
  }
  
  public static String f(Exception paramException)
  {
    AppMethodBeat.i(20642);
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    paramException = Ov(localStringWriter.toString());
    AppMethodBeat.o(20642);
    return paramException;
  }
  
  public static int g(Exception paramException)
  {
    AppMethodBeat.i(20648);
    if ((paramException instanceof SocketTimeoutException))
    {
      paramException = f(paramException);
      if (paramException.indexOf(".read") != -1)
      {
        AppMethodBeat.o(20648);
        return 105;
      }
      if (paramException.indexOf(".connect") != -1)
      {
        AppMethodBeat.o(20648);
        return 104;
      }
      AppMethodBeat.o(20648);
      return 101;
    }
    if ((paramException instanceof ConnectException))
    {
      AppMethodBeat.o(20648);
      return 106;
    }
    if ((paramException instanceof UnknownHostException))
    {
      AppMethodBeat.o(20648);
      return 102;
    }
    AppMethodBeat.o(20648);
    return 101;
  }
  
  public static boolean isEmpty(String paramString)
  {
    AppMethodBeat.i(20627);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(20627);
      return true;
    }
    AppMethodBeat.o(20627);
    return false;
  }
  
  public static boolean k(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(20649);
    ab.i(paramString, "CLIENT_VERSION=" + com.tencent.mm.protocal.d.whH);
    String str1 = (String)paramMap.get(".sysmsg.apply_versions.version_desc.$minInclude");
    String str2 = (String)paramMap.get(".sysmsg.apply_versions.version_desc.$maxInclude");
    ab.i(paramString, "checkMsgPushedVersion. min0=%s,max0=%s", new Object[] { str1, str2 });
    if ((isEmpty(str1)) && (isEmpty(str2)))
    {
      AppMethodBeat.o(20649);
      return false;
    }
    if (es(str1, str2))
    {
      AppMethodBeat.o(20649);
      return true;
    }
    int i = 1;
    for (;;)
    {
      str1 = (String)paramMap.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
      str2 = (String)paramMap.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
      ab.i(paramString, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", new Object[] { str1, str2 });
      if ((isEmpty(str1)) && (isEmpty(str2))) {
        break;
      }
      if (es(str1, str2))
      {
        AppMethodBeat.o(20649);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(20649);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m
 * JD-Core Version:    0.7.0.1
 */