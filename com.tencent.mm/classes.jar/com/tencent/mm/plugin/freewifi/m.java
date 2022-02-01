package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.ax.b;
import com.tencent.mm.ax.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
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
  private static SimpleDateFormat mug;
  
  static
  {
    AppMethodBeat.i(24732);
    mug = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    AppMethodBeat.o(24732);
  }
  
  public static String a(int paramInt1, k.b paramb, int paramInt2)
  {
    AppMethodBeat.i(24720);
    ad.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", new Object[] { Integer.valueOf(paramInt1), paramb.name, Long.valueOf(paramb.rgx), Integer.valueOf(paramInt2) });
    paramInt2 = Math.abs(paramInt2);
    StringBuilder localStringBuilder = new StringBuilder().append(String.format("%02d", new Object[] { Integer.valueOf(paramInt1) })).append(String.format("%03d", new Object[] { Long.valueOf(paramb.rgx) }));
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
        ad.i(paramString2, "print " + paramString1 + "error." + paramLinkedHashMap.getMessage());
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
          ad.e(paramString2, "unkonwn type " + ((Class)localObject2).toString());
          localStringBuilder.append(paramj.getString(i));
          continue;
          localStringBuilder.append("\r\n");
        }
      }
    }
    ad.i(paramString2, localStringBuilder.toString());
    paramLinkedHashMap = localStringBuilder.toString();
    paramj.close();
    AppMethodBeat.o(24730);
    return paramLinkedHashMap;
  }
  
  public static void a(final Intent paramIntent, final String paramString1, final int paramInt1, final int paramInt2, final a parama, String paramString2)
  {
    AppMethodBeat.i(24722);
    com.tencent.mm.plugin.freewifi.model.j.cwb().cvK().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24703);
        Object localObject = k.cvq();
        ((k.a)localObject).ssid = m.aau(this.lMn);
        ((k.a)localObject).bssid = m.aav(this.lMn);
        ((k.a)localObject).ddV = m.aaw(this.lMn);
        ((k.a)localObject).ddU = paramString1;
        ((k.a)localObject).nSA = m.ai(paramIntent);
        ((k.a)localObject).rfL = paramInt1;
        ((k.a)localObject).rfM = k.b.rfY.rgx;
        ((k.a)localObject).rfN = k.b.rfY.name;
        ((k.a)localObject).channel = m.al(paramIntent);
        ((k.a)localObject).result = 0;
        ((k.a)localObject).cvs().cvr();
        localObject = m.aav(this.lMn);
        String str = m.aau(this.lMn);
        int i = com.tencent.mm.plugin.freewifi.model.d.cvN();
        ad.i(this.lMn, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + ay.getNetType(aj.getContext()));
        ad.i(this.lMn, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[] { m.ai(paramIntent), Integer.valueOf(m.aj(paramIntent)), paramString1, localObject, str, Integer.valueOf(i) });
        new a(paramString1, (String)localObject, str, i, paramInt2, m.ai(paramIntent)).c(new g()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(24702);
            ad.i(m.2.this.lMn, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.ai(m.2.this.val$intent), Integer.valueOf(m.aj(m.2.this.val$intent)), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
            k.a locala = k.cvq();
            locala.ssid = m.aau(m.2.this.lMn);
            locala.bssid = m.aav(m.2.this.lMn);
            locala.ddV = m.aaw(m.2.this.lMn);
            locala.ddU = m.2.this.rgB;
            locala.nSA = m.ai(m.2.this.val$intent);
            locala.rfL = m.ak(m.2.this.val$intent);
            locala.rfM = k.b.rgb.rgx;
            locala.rfN = k.b.rgb.name;
            locala.channel = m.al(m.2.this.val$intent);
            locala.result = paramAnonymous2Int2;
            locala.foR = paramAnonymous2String;
            locala.cvs().c(m.2.this.val$intent, true).cvr();
            m.2.this.rgD.g(paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2String, paramAnonymous2n);
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
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(24701);
        Object localObject2;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (!(paramAnonymousn instanceof a))
          {
            AppMethodBeat.o(24701);
            return;
          }
          paramAnonymousString = ((a)paramAnonymousn).cwk();
          if (paramAnonymousString != null)
          {
            ad.i(this.lMn, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymousString.Cxj, paramAnonymousString.mBV, paramAnonymousString.mAQ, Integer.valueOf(paramAnonymousString.CCv), paramAnonymousString.CCw, paramAnonymousString.ijP, paramAnonymousString.CCx });
            paramAnonymousn = paramFreeWifiFrontPageUI;
            localObject1 = FreeWifiFrontPageUI.d.rkC;
            localObject2 = new FreeWifiFrontPageUI.b();
            ((FreeWifiFrontPageUI.b)localObject2).rky = paramAnonymousString;
            paramAnonymousn.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
            AppMethodBeat.o(24701);
            return;
          }
          ad.i(this.lMn, "backPageInfo is null");
          paramAnonymousString = paramFreeWifiFrontPageUI;
          paramAnonymousn = FreeWifiFrontPageUI.d.rkB;
          localObject1 = new FreeWifiFrontPageUI.a();
          ((FreeWifiFrontPageUI.a)localObject1).rka = m.a(paramInt1, k.b.rfZ, 21);
          paramAnonymousString.a(paramAnonymousn, localObject1);
          AppMethodBeat.o(24701);
          return;
        }
        if ((m.fG(paramAnonymousInt1, paramAnonymousInt2)) && (!m.dq(paramAnonymousString)))
        {
          paramAnonymousn = paramFreeWifiFrontPageUI;
          localObject1 = FreeWifiFrontPageUI.d.rkB;
          localObject2 = new FreeWifiFrontPageUI.a();
          ((FreeWifiFrontPageUI.a)localObject2).text = paramAnonymousString;
          ((FreeWifiFrontPageUI.a)localObject2).rka = m.a(paramInt1, k.b.rfZ, paramAnonymousInt2);
          paramAnonymousn.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
          AppMethodBeat.o(24701);
          return;
        }
        paramAnonymousString = paramFreeWifiFrontPageUI;
        paramAnonymousn = FreeWifiFrontPageUI.d.rkB;
        Object localObject1 = new FreeWifiFrontPageUI.a();
        ((FreeWifiFrontPageUI.a)localObject1).rka = m.a(paramInt1, k.b.rfZ, paramAnonymousInt2);
        paramAnonymousString.a(paramAnonymousn, localObject1);
        AppMethodBeat.o(24701);
      }
    }, paramString2);
    AppMethodBeat.o(24721);
  }
  
  public static String aas(String paramString)
  {
    AppMethodBeat.i(24705);
    if (dq(paramString))
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
  
  public static String aat(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String aau(String paramString)
  {
    AppMethodBeat.i(24715);
    String str = ay.iA(aj.getContext());
    ad.i(paramString, "getConnectedWifiSsid()=".concat(String.valueOf(str)));
    AppMethodBeat.o(24715);
    return str;
  }
  
  public static String aav(String paramString)
  {
    AppMethodBeat.i(24716);
    String str = ay.iB(aj.getContext());
    ad.i(paramString, "getConnectedWifiBssid()=".concat(String.valueOf(str)));
    AppMethodBeat.o(24716);
    return str;
  }
  
  public static String aaw(String paramString)
  {
    AppMethodBeat.i(24717);
    String str = ay.iC(aj.getContext());
    ad.i(paramString, "getConnectedWifiClientMac()=".concat(String.valueOf(str)));
    AppMethodBeat.o(24717);
    return str;
  }
  
  public static void aax(String paramString)
  {
    AppMethodBeat.i(24731);
    ad.i("FreeWifi", paramString);
    AppMethodBeat.o(24731);
  }
  
  public static void ah(Intent paramIntent)
  {
    AppMethodBeat.i(24707);
    if (dq(paramIntent.getStringExtra("free_wifi_sessionkey"))) {
      e(paramIntent, cvu());
    }
    AppMethodBeat.o(24707);
  }
  
  public static String ai(Intent paramIntent)
  {
    AppMethodBeat.i(24710);
    paramIntent = aat(paramIntent.getStringExtra("free_wifi_sessionkey"));
    AppMethodBeat.o(24710);
    return paramIntent;
  }
  
  public static int aj(Intent paramIntent)
  {
    AppMethodBeat.i(24711);
    int i = paramIntent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
    paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", i);
    AppMethodBeat.o(24711);
    return i;
  }
  
  public static int ak(Intent paramIntent)
  {
    AppMethodBeat.i(24712);
    int i = paramIntent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    AppMethodBeat.o(24712);
    return i;
  }
  
  public static int al(Intent paramIntent)
  {
    AppMethodBeat.i(24713);
    int i = paramIntent.getIntExtra("free_wifi_channel_id", 0);
    AppMethodBeat.o(24713);
    return i;
  }
  
  public static String am(Intent paramIntent)
  {
    AppMethodBeat.i(24714);
    paramIntent = paramIntent.getStringExtra("free_wifi_ap_key");
    AppMethodBeat.o(24714);
    return paramIntent;
  }
  
  public static boolean cvt()
  {
    AppMethodBeat.i(24706);
    String str = bt.cC(aj.getContext());
    if ((str != null) && (str.toLowerCase().startsWith(aj.getPackageName())))
    {
      AppMethodBeat.o(24706);
      return true;
    }
    AppMethodBeat.o(24706);
    return false;
  }
  
  public static String cvu()
  {
    AppMethodBeat.i(24708);
    String str = UUID.randomUUID().toString().replace("-", "");
    AppMethodBeat.o(24708);
    return str;
  }
  
  public static int cvv()
  {
    AppMethodBeat.i(24723);
    Object localObject = l.aIL();
    if ((localObject == l.a.ikw) || (localObject == l.a.ikx))
    {
      AppMethodBeat.o(24723);
      return 1;
    }
    az.arV();
    localObject = (String)com.tencent.mm.model.c.afk().get(6, null);
    if (dq((String)localObject))
    {
      AppMethodBeat.o(24723);
      return 1;
    }
    if (((String)localObject).startsWith("+")) {}
    for (localObject = ba.aew((String)localObject); "86".equals(localObject); localObject = "86")
    {
      AppMethodBeat.o(24723);
      return 2;
    }
    AppMethodBeat.o(24723);
    return 3;
  }
  
  public static boolean cvw()
  {
    AppMethodBeat.i(24728);
    if (((ConnectivityManager)aj.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected())
    {
      ad.i("TAG", "isWifiConnected()=true");
      AppMethodBeat.o(24728);
      return true;
    }
    ad.i("TAG", "isWifiConnected()=false");
    AppMethodBeat.o(24728);
    return false;
  }
  
  public static abq cvx()
  {
    AppMethodBeat.i(24729);
    abq localabq = new abq();
    localabq.deviceBrand = com.tencent.mm.protocal.d.CpE;
    if ((d.rfs != null) && (!d.rfs.equals(""))) {}
    for (localabq.DbZ = d.rfs;; localabq.DbZ = aaw("MicroMsg.FreeWifi.Utils"))
    {
      localabq.deviceModel = com.tencent.mm.protocal.d.CpF;
      localabq.osName = com.tencent.mm.protocal.d.CpH;
      localabq.osVersion = com.tencent.mm.protocal.d.CpI;
      AppMethodBeat.o(24729);
      return localabq;
    }
  }
  
  public static boolean dq(String paramString)
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
  
  public static void e(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(24709);
    paramIntent.putExtra("free_wifi_sessionkey", paramString);
    paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
    AppMethodBeat.o(24709);
  }
  
  public static void eT(Context paramContext)
  {
    AppMethodBeat.i(24724);
    Intent localIntent = new Intent(paramContext, BindMContactUI.class);
    Object localObject = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = b.bh((String)localObject, paramContext.getString(2131757950));
      if (localObject != null)
      {
        localIntent.putExtra("country_name", ((b.a)localObject).hkO);
        localIntent.putExtra("couttry_code", ((b.a)localObject).hkN);
      }
    }
    MMWizardActivity.V(paramContext, localIntent);
    AppMethodBeat.o(24724);
  }
  
  public static boolean fF(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 0) && (paramInt2 == 0);
  }
  
  public static boolean fG(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 <= -30000) && (paramInt2 > -31000);
  }
  
  private static boolean gd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24727);
    int i = bt.getInt(paramString1, 0);
    int j = bt.getInt(paramString2, 0);
    if ((i == 0) && (j != 0) && (com.tencent.mm.protocal.d.CpK <= j))
    {
      AppMethodBeat.o(24727);
      return true;
    }
    if ((i != 0) && (j == 0) && (com.tencent.mm.protocal.d.CpK >= i))
    {
      AppMethodBeat.o(24727);
      return true;
    }
    if ((i != 0) && (j != 0) && (com.tencent.mm.protocal.d.CpK >= i) && (com.tencent.mm.protocal.d.CpK <= j))
    {
      AppMethodBeat.o(24727);
      return true;
    }
    AppMethodBeat.o(24727);
    return false;
  }
  
  public static boolean j(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(24726);
    ad.i(paramString, "CLIENT_VERSION=" + com.tencent.mm.protocal.d.CpK);
    String str1 = (String)paramMap.get(".sysmsg.apply_versions.version_desc.$minInclude");
    String str2 = (String)paramMap.get(".sysmsg.apply_versions.version_desc.$maxInclude");
    ad.i(paramString, "checkMsgPushedVersion. min0=%s,max0=%s", new Object[] { str1, str2 });
    if ((dq(str1)) && (dq(str2)))
    {
      AppMethodBeat.o(24726);
      return false;
    }
    if (gd(str1, str2))
    {
      AppMethodBeat.o(24726);
      return true;
    }
    int i = 1;
    for (;;)
    {
      str1 = (String)paramMap.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
      str2 = (String)paramMap.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
      ad.i(paramString, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", new Object[] { str1, str2 });
      if ((dq(str1)) && (dq(str2))) {
        break;
      }
      if (gd(str1, str2))
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
    localObject = aat(((StringWriter)localObject).toString());
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
    paramException = aat(localStringWriter.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m
 * JD-Core Version:    0.7.0.1
 */