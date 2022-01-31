package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.f.b;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  public static Map<String, String> mIz;
  private String bssid;
  private int cCy;
  private String coX;
  private String coY;
  private String eev;
  private String kMp;
  private int mIA;
  private String mIB;
  private String mIC;
  private int mIE;
  private long mIF;
  private String mIG;
  private String mIH;
  private long mII;
  private int result;
  private String ssid;
  
  static
  {
    AppMethodBeat.i(20616);
    mIz = new k.1();
    AppMethodBeat.o(20616);
  }
  
  public static String Ot(String paramString)
  {
    AppMethodBeat.i(20612);
    paramString = m.Ov((String)mIz.get(paramString));
    AppMethodBeat.o(20612);
    return paramString;
  }
  
  public static k.a bAc()
  {
    AppMethodBeat.i(20613);
    k.a locala = new k.a((byte)0);
    AppMethodBeat.o(20613);
    return locala;
  }
  
  public final k bAd()
  {
    AppMethodBeat.i(20614);
    h.qsU.e(12804, new Object[] { m.Ov(this.ssid), m.Ov(this.bssid), m.Ov(this.coY), m.Ov(this.coX), Integer.valueOf(this.mIA), m.Ov(this.mIB), m.Ov(this.mIC), m.Ov(this.kMp), Integer.valueOf(this.mIE), Long.valueOf(this.mIF), m.Ov(this.mIG), Integer.valueOf(this.result), Integer.valueOf(this.cCy), m.Ov(this.mIH), Long.valueOf(this.mII), m.Ov(this.eev) });
    AppMethodBeat.o(20614);
    return this;
  }
  
  public final k c(final Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(20615);
    for (;;)
    {
      try
      {
        i = m.W(paramIntent);
        if (i != 31)
        {
          AppMethodBeat.o(20615);
          return this;
        }
        localObject = new JSONObject();
      }
      catch (Exception paramIntent)
      {
        final int i;
        Object localObject;
        String str;
        ab.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "reportWifiServer() write to local file exception. " + m.f(paramIntent));
        continue;
        paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", localJSONException + "," + (String)localObject);
        continue;
      }
      try
      {
        ((JSONObject)localObject).put("ssid", this.ssid);
        ((JSONObject)localObject).put("bssid", this.bssid);
        ((JSONObject)localObject).put("clientMac", this.coY);
        ((JSONObject)localObject).put("apKey", this.coX);
        ((JSONObject)localObject).put("qrtype", this.mIA);
        ((JSONObject)localObject).put("mpShopId", this.mIB);
        ((JSONObject)localObject).put("mpAppId", this.mIC);
        ((JSONObject)localObject).put("sessionKey", this.kMp);
        ((JSONObject)localObject).put("protocolType", this.mIE);
        ((JSONObject)localObject).put("stageCode", this.mIF);
        ((JSONObject)localObject).put("stageName", this.mIG);
        ((JSONObject)localObject).put("result", this.result);
        ((JSONObject)localObject).put("channel", this.cCy);
        ((JSONObject)localObject).put("mpUserName", this.mIH);
        ((JSONObject)localObject).put("timeCost", this.mII);
        ((JSONObject)localObject).put("resultMsg", this.eev);
        ((JSONObject)localObject).put("logCurrentTimeMillis", System.currentTimeMillis());
        localObject = ((JSONObject)localObject).toString();
        str = paramIntent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
        if (m.isEmpty(str))
        {
          paramIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", (String)localObject);
          final long l = System.currentTimeMillis();
          localObject = paramIntent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID");
          paramIntent = paramIntent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
          if (paramBoolean) {
            j.bAO().bAw().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(20606);
                j.bAM().a(this.val$id, i, paramIntent, l);
                if (m.bAi()) {
                  b.kS(1);
                }
                AppMethodBeat.o(20606);
              }
            });
          }
          AppMethodBeat.o(20615);
          return this;
        }
      }
      catch (JSONException localJSONException)
      {
        ab.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "JSONException e. " + m.f(localJSONException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.k
 * JD-Core Version:    0.7.0.1
 */