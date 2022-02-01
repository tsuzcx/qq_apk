package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.luckymoney.app.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.ui.i;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class at
  extends as
{
  public at(String paramString, int paramInt)
  {
    AppMethodBeat.i(283956);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ver", paramString);
    h.baF();
    localHashMap.put("walletType", String.valueOf(h.baE().ban().d(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    localHashMap.put("scene", "20");
    localHashMap.put("union_source", "0");
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "NetSceneLuckyMoneyGetConfigUnion request");
    setRequestData(localHashMap);
    AppMethodBeat.o(283956);
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/unionhb/operationunionhb";
  }
  
  public final int getType()
  {
    return 4605;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(283968);
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    if (paramInt == 0)
    {
      this.Kup = paramJSONObject.optInt("randomAmount");
      this.Kun = paramJSONObject.optString("randomWishing");
      this.pHt = paramJSONObject.optString("notice");
      this.Kuq = paramJSONObject.optString("notice_url");
      boolean bool;
      if (paramJSONObject.optInt("hasCanShareHongBao") == 1) {
        bool = true;
      }
      for (;;)
      {
        this.Kuo = bool;
        this.wYR = paramJSONObject.optInt("currency");
        this.wYR = 1;
        this.Kmg = paramJSONObject.optString("currencyUint");
        this.Kmh = paramJSONObject.optString("currencyWording");
        this.hTs = paramJSONObject.optString("unique_id");
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "currency=" + this.wYR + ";currencyUint=" + this.Kmg + ";currencyWording=" + this.Kmh + ";uniqueId=" + this.hTs);
        paramString = new o();
        paramString.KrB = paramJSONObject.optString("groupHint");
        paramString.KrC = paramJSONObject.optString("personalHint");
        paramString.Kmb = paramJSONObject.optInt("totalNum", 100);
        paramString.Kme = i.a(paramJSONObject.optString("totalAmount", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.Kmc = i.a(paramJSONObject.optString("perPersonMaxValue", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.Kmf = i.a(paramJSONObject.optString("perGroupMaxValue", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.Kmd = i.a(paramJSONObject.optString("perMinValue", "0"), "100", 2, RoundingMode.HALF_UP);
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "config.maxTotalAmount: %s, config.perPersonMaxValue: %s，config.perGroupMaxValue：%s , config.perMinValue:%s", new Object[] { Double.valueOf(paramString.Kme), Double.valueOf(paramString.Kmc), Double.valueOf(paramString.Kmf), Double.valueOf(paramString.Kmd) });
        paramString.KrD = paramJSONObject.optInt("payShowBGFlag");
        paramString.wYR = this.wYR;
        paramString.Kmg = this.Kmg;
        paramString.Kmh = this.Kmh;
        paramString.KrE = paramJSONObject.optString("foreignFaqUrl");
        paramString.KrF = paramJSONObject.optString("foreignHongBaoName");
        paramString.KrG = paramJSONObject.optString("showSourceAndMac");
        paramString.KrH = paramJSONObject.optString("coverinfo");
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "foreignFaqUrl: %s, foreignHongBaoName: %s", new Object[] { paramString.KrE, paramString.KrF });
        a.fWk();
        Object localObject = a.fWm();
        ((ag)localObject).KmF = paramString;
        ((ag)localObject).fWV();
        Log.i("MicroMsg.LuckyMoneyUnionConfigManager", "setConfig maxTotalAmount:" + ((ag)localObject).KmF.Kme + " maxTotalNum:" + ((ag)localObject).KmF.Kmb + " perGroupMaxValue:" + ((ag)localObject).KmF.Kmf + " perMinValue:" + ((ag)localObject).KmF.Kmd + " perPersonMaxValue:" + ((ag)localObject).KmF.Kmc);
        try
        {
          paramString = new String(((ag)localObject).KmF.toByteArray(), "ISO-8859-1");
          h.baF();
          h.baE().ban().set(at.a.acIE, paramString);
          h.baF();
          h.baE().ban().iZy();
          this.Kur = ae.bv(paramJSONObject.optJSONObject("operationHeader"));
          this.Ksc = ae.bv(paramJSONObject.optJSONObject("operationTail"));
          this.Kus = ae.bv(paramJSONObject.optJSONObject("operationNext"));
          this.Kut = ae.bv(paramJSONObject.optJSONObject("operationMiddle"));
          paramInt = paramJSONObject.optInt("sceneSwitch");
          h.baF();
          h.baE().ban().set(at.a.acIC, Integer.valueOf(paramInt));
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "sceneSwitch:".concat(String.valueOf(paramInt)));
          this.Kuu = paramJSONObject.optInt("scenePicSwitch");
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "scenePicSwitch:" + this.Kuu);
          this.Kuw = paramJSONObject.optInt("enableYearHbExpression");
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.Kuw) });
          this.Kuv = paramJSONObject.optInt("enableSelfie");
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "enableSelfIe:" + this.Kuv);
          this.Kux = paramJSONObject.optInt("enableNormalSelfie");
          this.Kuy = paramJSONObject.optInt("enableNormalAllExpression");
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.Kux), Integer.valueOf(this.Kuy) });
          paramInt = paramJSONObject.optInt("enableWeishiHb");
          h.baF();
          h.baE().ban().set(at.a.acID, Integer.valueOf(paramInt));
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "weishiHbSwitch:".concat(String.valueOf(paramInt)));
          this.Kmq = paramJSONObject.optString("wishing");
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "wishing: %s", new Object[] { this.Kmq });
          paramString = paramJSONObject.optJSONArray("yearMess");
          if ((paramString != null) && (paramString.length() > 0))
          {
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "yearMessJson length:" + paramString.length());
            this.Kuz = new LinkedList();
            paramInt = 0;
            while (paramInt < paramString.length())
            {
              paramJSONObject = paramString.optJSONObject(paramInt);
              localObject = new ad();
              ((ad)localObject).KtA = paramJSONObject.optInt("yearAmount", 0);
              ((ad)localObject).KtB = paramJSONObject.optString("yearWish");
              this.Kuz.add(localObject);
              paramInt += 1;
              continue;
              bool = false;
            }
          }
        }
        catch (UnsupportedEncodingException paramString)
        {
          for (;;)
          {
            Log.w("MicroMsg.LuckyMoneyUnionConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            Log.w("MicroMsg.LuckyMoneyUnionConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "yearMessJson is empty!");
          fXl();
          AppMethodBeat.o(283968);
          return;
        }
      }
    }
    Log.e("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
    AppMethodBeat.o(283968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.at
 * JD-Core Version:    0.7.0.1
 */