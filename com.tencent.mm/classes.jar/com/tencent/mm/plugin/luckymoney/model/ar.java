package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ar
  extends aw
{
  public int EBA;
  public LinkedList<ac> EBB;
  public String EBp;
  public boolean EBq;
  public int EBr;
  public String EBs;
  public bh EBt;
  public bh EBu;
  public bh EBv;
  public int EBw;
  public int EBx;
  public int EBy;
  public int EBz;
  public String EtA;
  public String EtJ;
  public String Etz;
  public bh Ezp;
  public String fND;
  public String mKL;
  public int tVx;
  
  public ar()
  {
    this.EBw = 0;
    this.EBx = 0;
    this.EBy = 0;
    this.EBz = 0;
    this.EBA = 0;
  }
  
  public ar(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(268357);
    this.EBw = 0;
    this.EBx = 0;
    this.EBy = 0;
    this.EBz = 0;
    this.EBA = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("ver", paramString);
    h.aHH();
    localHashMap.put("walletType", String.valueOf(h.aHG().aHp().b(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt2));
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "NetSceneLuckyMoneyGetConfig request");
    setRequestData(localHashMap);
    AppMethodBeat.o(268357);
  }
  
  public ar(String paramString, int paramInt)
  {
    this(0, paramString, paramInt);
    AppMethodBeat.i(65288);
    AppMethodBeat.o(65288);
  }
  
  public String cOd()
  {
    return "/cgi-bin/mmpay-bin/operationwxhb";
  }
  
  public final void eOI()
  {
    AppMethodBeat.i(268358);
    h.aHH();
    int i = ((Integer)h.aHG().aHp().get(ar.a.Vxa, Integer.valueOf(0))).intValue();
    int j = ((b)h.ae(b.class)).a(b.a.vDT, 0);
    if ((Util.isEqual(i, 1)) || (Util.isEqual(j, 1)))
    {
      this.EBz = 1;
      this.EBA = 1;
      this.EBx = 1;
      this.EBy = 1;
    }
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "localSwitch() enableNormalSelfie:%s enableNormalAllExpression:%s enableSelfie:%s enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.EBz), Integer.valueOf(this.EBA), Integer.valueOf(this.EBx), Integer.valueOf(this.EBy) });
    AppMethodBeat.o(268358);
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
      this.EBr = paramJSONObject.optInt("randomAmount");
      this.EBp = paramJSONObject.optString("randomWishing");
      this.mKL = paramJSONObject.optString("notice");
      this.EBs = paramJSONObject.optString("notice_url");
      boolean bool;
      if (paramJSONObject.optInt("hasCanShareHongBao") == 1) {
        bool = true;
      }
      for (;;)
      {
        this.EBq = bool;
        this.tVx = paramJSONObject.optInt("currency");
        this.Etz = paramJSONObject.optString("currencyUint");
        this.EtA = paramJSONObject.optString("currencyWording");
        this.fND = paramJSONObject.optString("unique_id");
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.tVx + ";currencyUint=" + this.Etz + ";currencyWording=" + this.EtA + ";uniqueId=" + this.fND);
        paramString = new o();
        paramString.EyO = paramJSONObject.optString("groupHint");
        paramString.EyP = paramJSONObject.optString("personalHint");
        paramString.Etx = (paramJSONObject.optLong("totalAmount", 200000L) / 100.0D);
        paramString.Etu = paramJSONObject.optInt("totalNum", 100);
        paramString.Etv = (paramJSONObject.optLong("perPersonMaxValue", 20000L) / 100.0D);
        paramString.Ety = (paramJSONObject.optLong("perGroupMaxValue", 20000L) / 100.0D);
        paramString.Etw = (paramJSONObject.optLong("perMinValue", 1L) / 100.0D);
        paramString.EyQ = paramJSONObject.optInt("payShowBGFlag");
        paramString.EyV = paramJSONObject.optBoolean("enableExclusiveHb");
        paramString.tVx = this.tVx;
        paramString.Etz = this.Etz;
        paramString.EtA = this.EtA;
        paramString.EyR = paramJSONObject.optString("foreignFaqUrl");
        paramString.EyS = paramJSONObject.optString("foreignHongBaoName");
        paramString.EyT = paramJSONObject.optString("showSourceAndMac");
        paramString.EyU = paramJSONObject.optString("coverinfo");
        Object localObject = paramJSONObject.optString("cover_jumpaction");
        if (!Util.isNullOrNil((String)localObject)) {
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "cover_jumpaction: %s", new Object[] { localObject });
        }
        try
        {
          localObject = new JSONObject((String)localObject);
          l locall = new l();
          locall.tpu = ((JSONObject)localObject).optBoolean("is_show");
          locall.wording = ((JSONObject)localObject).optString("wording");
          locall.ufC = ((JSONObject)localObject).optString("icon_url");
          locall.EyI = ((JSONObject)localObject).optString("action_app_username");
          locall.tpK = ((JSONObject)localObject).optInt("action_type", 0);
          locall.EyH = ((JSONObject)localObject).optString("action_url");
          paramString.EyW = locall;
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s, enableExclusiveHb: %s", new Object[] { paramString.EyR, paramString.EyS, Boolean.valueOf(paramString.EyV) });
          a.eNR();
          localObject = a.eNS();
          ((p)localObject).EtY = paramString;
          ((p)localObject).eOy();
          Log.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + ((p)localObject).EtY.Etx + " maxTotalNum:" + ((p)localObject).EtY.Etu + " perGroupMaxValue:" + ((p)localObject).EtY.Ety + " perMinValue:" + ((p)localObject).EtY.Etw + " perPersonMaxValue:" + ((p)localObject).EtY.Etv);
        }
        catch (JSONException localJSONException)
        {
          try
          {
            paramString = new String(((p)localObject).EtY.toByteArray(), "ISO-8859-1");
            h.aHH();
            h.aHG().aHp().i(356355, paramString);
            h.aHH();
            h.aHG().aHp().hxT();
            this.EBt = ad.bh(paramJSONObject.optJSONObject("operationHeader"));
            this.Ezp = ad.bh(paramJSONObject.optJSONObject("operationTail"));
            this.EBu = ad.bh(paramJSONObject.optJSONObject("operationNext"));
            this.EBv = ad.bh(paramJSONObject.optJSONObject("operationMiddle"));
            paramInt = paramJSONObject.optInt("sceneSwitch");
            h.aHH();
            h.aHG().aHp().set(ar.a.Vhe, Integer.valueOf(paramInt));
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(paramInt)));
            this.EBw = paramJSONObject.optInt("scenePicSwitch");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.EBw);
            this.EBy = paramJSONObject.optInt("enableYearHbExpression");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.EBy) });
            this.EBx = paramJSONObject.optInt("enableSelfie");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableSelfIe:" + this.EBx);
            this.EBz = paramJSONObject.optInt("enableNormalSelfie");
            this.EBA = paramJSONObject.optInt("enableNormalAllExpression");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.EBz), Integer.valueOf(this.EBA) });
            paramInt = paramJSONObject.optInt("enableWeishiHb");
            h.aHH();
            h.aHG().aHp().set(ar.a.Vhg, Integer.valueOf(paramInt));
            int i = paramJSONObject.optInt("enableLiveHb");
            h.aHH();
            h.aHG().aHp().set(ar.a.Vhh, Integer.valueOf(i));
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "weishiHbSwitch: %s, liveHbSwitch: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
            this.EtJ = paramJSONObject.optString("wishing");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[] { this.EtJ });
            paramString = paramJSONObject.optJSONArray("yearMess");
            if ((paramString != null) && (paramString.length() > 0))
            {
              Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + paramString.length());
              this.EBB = new LinkedList();
              paramInt = 0;
              for (;;)
              {
                if (paramInt < paramString.length())
                {
                  paramJSONObject = paramString.optJSONObject(paramInt);
                  localObject = new ac();
                  ((ac)localObject).EAE = paramJSONObject.optInt("yearAmount", 0);
                  ((ac)localObject).EAF = paramJSONObject.optString("yearWish");
                  this.EBB.add(localObject);
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
            eOI();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ar
 * JD-Core Version:    0.7.0.1
 */