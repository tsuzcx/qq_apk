package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.luckymoney.app.a;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class as
  extends ax
{
  public String Kmg;
  public String Kmh;
  public String Kmq;
  public bi Ksc;
  public String KuA;
  public String KuB;
  public String Kun;
  public boolean Kuo;
  public int Kup;
  public String Kuq;
  public bi Kur;
  public bi Kus;
  public bi Kut;
  public int Kuu;
  public int Kuv;
  public int Kuw;
  public int Kux;
  public int Kuy;
  public LinkedList<ad> Kuz;
  public String hTs;
  public dus pGr;
  public String pHt;
  public int wYR;
  
  public as()
  {
    this.Kuu = 0;
    this.Kuv = 0;
    this.Kuw = 0;
    this.Kux = 0;
    this.Kuy = 0;
  }
  
  public as(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(283960);
    this.Kuu = 0;
    this.Kuv = 0;
    this.Kuw = 0;
    this.Kux = 0;
    this.Kuy = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("ver", paramString);
    h.baF();
    localHashMap.put("walletType", String.valueOf(h.baE().ban().d(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt2));
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "NetSceneLuckyMoneyGetConfig request");
    setRequestData(localHashMap);
    AppMethodBeat.o(283960);
  }
  
  public as(String paramString, int paramInt)
  {
    this(0, paramString, paramInt);
    AppMethodBeat.i(65288);
    AppMethodBeat.o(65288);
  }
  
  public String drI()
  {
    return "/cgi-bin/mmpay-bin/operationwxhb";
  }
  
  public final void fXl()
  {
    AppMethodBeat.i(283980);
    h.baF();
    int i = ((Integer)h.baE().ban().get(at.a.acYL, Integer.valueOf(0))).intValue();
    int j = ((c)h.ax(c.class)).a(c.a.yTa, 0);
    if ((Util.isEqual(i, 1)) || (Util.isEqual(j, 1)))
    {
      this.Kux = 1;
      this.Kuy = 1;
      this.Kuv = 1;
      this.Kuw = 1;
    }
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "localSwitch() enableNormalSelfie:%s enableNormalAllExpression:%s enableSelfie:%s enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.Kux), Integer.valueOf(this.Kuy), Integer.valueOf(this.Kuv), Integer.valueOf(this.Kuw) });
    AppMethodBeat.o(283980);
  }
  
  public int getType()
  {
    return 1554;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65290);
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    if (paramInt == 0)
    {
      this.Kup = paramJSONObject.optInt("randomAmount");
      this.Kun = paramJSONObject.optString("randomWishing");
      this.pHt = paramJSONObject.optString("notice");
      this.Kuq = paramJSONObject.optString("notice_url");
      paramString = paramJSONObject.optJSONObject("notice_item");
      if (paramString != null)
      {
        this.pGr = new dus();
        this.pGr.abaE = paramString.optInt("is_show_notice", 0);
        this.pGr.wording = paramString.optString("wording");
        this.pGr.jump_url = paramString.optString("jump_url");
        this.pGr.left_icon = paramString.optString("left_icon");
        this.pGr.YSS = paramString.optString("notice_id");
      }
      boolean bool;
      if (paramJSONObject.optInt("hasCanShareHongBao") == 1) {
        bool = true;
      }
      for (;;)
      {
        this.Kuo = bool;
        this.wYR = paramJSONObject.optInt("currency");
        this.Kmg = paramJSONObject.optString("currencyUint");
        this.Kmh = paramJSONObject.optString("currencyWording");
        this.hTs = paramJSONObject.optString("unique_id");
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.wYR + ";currencyUint=" + this.Kmg + ";currencyWording=" + this.Kmh + ";uniqueId=" + this.hTs);
        paramString = new o();
        paramString.KrB = paramJSONObject.optString("groupHint");
        paramString.KrC = paramJSONObject.optString("personalHint");
        paramString.Kme = (paramJSONObject.optLong("totalAmount", 200000L) / 100.0D);
        paramString.Kmb = paramJSONObject.optInt("totalNum", 100);
        paramString.Kmc = (paramJSONObject.optLong("perPersonMaxValue", 20000L) / 100.0D);
        paramString.Kmf = (paramJSONObject.optLong("perGroupMaxValue", 20000L) / 100.0D);
        paramString.Kmd = (paramJSONObject.optLong("perMinValue", 1L) / 100.0D);
        paramString.KrD = paramJSONObject.optInt("payShowBGFlag");
        paramString.KrI = paramJSONObject.optBoolean("enableExclusiveHb");
        paramString.wYR = this.wYR;
        paramString.Kmg = this.Kmg;
        paramString.Kmh = this.Kmh;
        paramString.KrE = paramJSONObject.optString("foreignFaqUrl");
        paramString.KrF = paramJSONObject.optString("foreignHongBaoName");
        paramString.KrG = paramJSONObject.optString("showSourceAndMac");
        paramString.KrH = paramJSONObject.optString("coverinfo");
        Object localObject1 = paramJSONObject.optString("cover_jumpaction");
        if (!Util.isNullOrNil((String)localObject1)) {
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "cover_jumpaction: %s", new Object[] { localObject1 });
        }
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          localObject2 = new m();
          ((m)localObject2).wtT = ((JSONObject)localObject1).optBoolean("is_show");
          ((m)localObject2).wording = ((JSONObject)localObject1).optString("wording");
          ((m)localObject2).icon_url = ((JSONObject)localObject1).optString("icon_url");
          ((m)localObject2).Krv = ((JSONObject)localObject1).optString("action_app_username");
          ((m)localObject2).wuj = ((JSONObject)localObject1).optInt("action_type", 0);
          ((m)localObject2).Kru = ((JSONObject)localObject1).optString("action_url");
          paramString.KrJ = ((m)localObject2);
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s, enableExclusiveHb: %s", new Object[] { paramString.KrE, paramString.KrF, Boolean.valueOf(paramString.KrI) });
          a.fWk();
          localObject1 = a.fWl();
          ((p)localObject1).KmF = paramString;
          ((p)localObject1).fWV();
          Log.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + ((p)localObject1).KmF.Kme + " maxTotalNum:" + ((p)localObject1).KmF.Kmb + " perGroupMaxValue:" + ((p)localObject1).KmF.Kmf + " perMinValue:" + ((p)localObject1).KmF.Kmd + " perPersonMaxValue:" + ((p)localObject1).KmF.Kmc);
        }
        catch (JSONException localJSONException)
        {
          try
          {
            Object localObject2;
            paramString = new String(((p)localObject1).KmF.toByteArray(), "ISO-8859-1");
            h.baF();
            h.baE().ban().B(356355, paramString);
            h.baF();
            h.baE().ban().iZy();
            this.Kur = ae.bv(paramJSONObject.optJSONObject("operationHeader"));
            this.Ksc = ae.bv(paramJSONObject.optJSONObject("operationTail"));
            this.Kus = ae.bv(paramJSONObject.optJSONObject("operationNext"));
            this.Kut = ae.bv(paramJSONObject.optJSONObject("operationMiddle"));
            paramInt = paramJSONObject.optInt("sceneSwitch");
            h.baF();
            h.baE().ban().set(at.a.acIw, Integer.valueOf(paramInt));
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(paramInt)));
            this.Kuu = paramJSONObject.optInt("scenePicSwitch");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.Kuu);
            this.Kuw = paramJSONObject.optInt("enableYearHbExpression");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.Kuw) });
            this.Kuv = paramJSONObject.optInt("enableSelfie");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableSelfIe:" + this.Kuv);
            this.Kux = paramJSONObject.optInt("enableNormalSelfie");
            this.Kuy = paramJSONObject.optInt("enableNormalAllExpression");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.Kux), Integer.valueOf(this.Kuy) });
            paramInt = paramJSONObject.optInt("enableWeishiHb");
            h.baF();
            h.baE().ban().set(at.a.acIy, Integer.valueOf(paramInt));
            int i = paramJSONObject.optInt("enableLiveHb");
            h.baF();
            h.baE().ban().set(at.a.acIz, Integer.valueOf(i));
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "weishiHbSwitch: %s, liveHbSwitch: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
            this.Kmq = paramJSONObject.optString("wishing");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[] { this.Kmq });
            paramString = paramJSONObject.optJSONArray("yearMess");
            if ((paramString != null) && (paramString.length() > 0))
            {
              Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + paramString.length());
              this.Kuz = new LinkedList();
              paramInt = 0;
              for (;;)
              {
                if (paramInt < paramString.length())
                {
                  localObject1 = paramString.optJSONObject(paramInt);
                  localObject2 = new ad();
                  ((ad)localObject2).KtA = ((JSONObject)localObject1).optInt("yearAmount", 0);
                  ((ad)localObject2).KtB = ((JSONObject)localObject1).optString("yearWish");
                  ((ad)localObject2).Kts = ((JSONObject)localObject1).optString("wishKeyWord");
                  ((ad)localObject2).Ktt = ((JSONObject)localObject1).optString("pagName");
                  this.Kuz.add(localObject2);
                  paramInt += 1;
                  continue;
                  bool = false;
                  break;
                  localJSONException = localJSONException;
                  Log.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyGetConfig", localJSONException, "", new Object[0]);
                }
              }
            }
          }
          catch (UnsupportedEncodingException paramString)
          {
            for (;;)
            {
              Log.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
            }
          }
          catch (IOException paramString)
          {
            for (;;)
            {
              Log.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
            }
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
            this.KuA = paramJSONObject.optString("cdnFileId");
            this.KuB = paramJSONObject.optString("cdnAesKey");
            fXl();
            AppMethodBeat.o(65290);
            return;
          }
        }
      }
    }
    Log.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
    AppMethodBeat.o(65290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.as
 * JD-Core Version:    0.7.0.1
 */