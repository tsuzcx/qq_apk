package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ar
  extends aq
{
  public ar(String paramString, int paramInt)
  {
    AppMethodBeat.i(213321);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ver", paramString);
    g.aAi();
    localHashMap.put("walletType", String.valueOf(g.aAh().azQ().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    localHashMap.put("scene", "20");
    localHashMap.put("union_source", "0");
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "NetSceneLuckyMoneyGetConfigUnion request");
    setRequestData(localHashMap);
    AppMethodBeat.o(213321);
  }
  
  public final String czD()
  {
    return "/cgi-bin/mmpay-bin/unionhb/operationunionhb";
  }
  
  public final int getType()
  {
    return 4605;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(213322);
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    if (paramInt == 0)
    {
      this.yXm = paramJSONObject.optInt("randomAmount");
      this.yXk = paramJSONObject.optString("randomWishing");
      this.jTx = paramJSONObject.optString("notice");
      this.yXn = paramJSONObject.optString("notice_url");
      boolean bool;
      if (paramJSONObject.optInt("hasCanShareHongBao") == 1) {
        bool = true;
      }
      for (;;)
      {
        this.yXl = bool;
        this.qww = paramJSONObject.optInt("currency");
        this.qww = 1;
        this.yPA = paramJSONObject.optString("currencyUint");
        this.yPB = paramJSONObject.optString("currencyWording");
        this.dUb = paramJSONObject.optString("unique_id");
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "currency=" + this.qww + ";currencyUint=" + this.yPA + ";currencyWording=" + this.yPB + ";uniqueId=" + this.dUb);
        paramString = new o();
        paramString.yUR = paramJSONObject.optString("groupHint");
        paramString.yUS = paramJSONObject.optString("personalHint");
        paramString.yPv = paramJSONObject.optInt("totalNum", 100);
        paramString.yPy = f.a(paramJSONObject.optString("totalAmount", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.yPw = f.a(paramJSONObject.optString("perPersonMaxValue", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.yPz = f.a(paramJSONObject.optString("perGroupMaxValue", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.yPx = f.a(paramJSONObject.optString("perMinValue", "0"), "100", 2, RoundingMode.HALF_UP);
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "config.maxTotalAmount: %s, config.perPersonMaxValue: %s，config.perGroupMaxValue：%s , config.perMinValue:%s", new Object[] { Double.valueOf(paramString.yPy), Double.valueOf(paramString.yPw), Double.valueOf(paramString.yPz), Double.valueOf(paramString.yPx) });
        paramString.yUT = paramJSONObject.optInt("payShowBGFlag");
        paramString.qww = this.qww;
        paramString.yPA = this.yPA;
        paramString.yPB = this.yPB;
        paramString.yUU = paramJSONObject.optString("foreignFaqUrl");
        paramString.yUV = paramJSONObject.optString("foreignHongBaoName");
        paramString.yUW = paramJSONObject.optString("showSourceAndMac");
        paramString.yUX = paramJSONObject.optString("coverinfo");
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "foreignFaqUrl: %s, foreignHongBaoName: %s", new Object[] { paramString.yUU, paramString.yUV });
        a.eex();
        Object localObject = a.eez();
        ((ae)localObject).yPZ = paramString;
        ((ae)localObject).efd();
        Log.i("MicroMsg.LuckyMoneyUnionConfigManager", "setConfig maxTotalAmount:" + ((ae)localObject).yPZ.yPy + " maxTotalNum:" + ((ae)localObject).yPZ.yPv + " perGroupMaxValue:" + ((ae)localObject).yPZ.yPz + " perMinValue:" + ((ae)localObject).yPZ.yPx + " perPersonMaxValue:" + ((ae)localObject).yPZ.yPw);
        try
        {
          paramString = new String(((ae)localObject).yPZ.toByteArray(), "ISO-8859-1");
          g.aAi();
          g.aAh().azQ().set(ar.a.NTl, paramString);
          g.aAi();
          g.aAh().azQ().gBI();
          this.yXo = ac.ba(paramJSONObject.optJSONObject("operationHeader"));
          this.yVs = ac.ba(paramJSONObject.optJSONObject("operationTail"));
          this.yXp = ac.ba(paramJSONObject.optJSONObject("operationNext"));
          this.yXq = ac.ba(paramJSONObject.optJSONObject("operationMiddle"));
          paramInt = paramJSONObject.optInt("sceneSwitch");
          g.aAi();
          g.aAh().azQ().set(ar.a.NTj, Integer.valueOf(paramInt));
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "sceneSwitch:".concat(String.valueOf(paramInt)));
          this.yXr = paramJSONObject.optInt("scenePicSwitch");
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "scenePicSwitch:" + this.yXr);
          this.yXt = paramJSONObject.optInt("enableYearHbExpression");
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.yXt) });
          this.yXs = paramJSONObject.optInt("enableSelfie");
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "enableSelfIe:" + this.yXs);
          this.yXu = paramJSONObject.optInt("enableNormalSelfie");
          this.yXv = paramJSONObject.optInt("enableNormalAllExpression");
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.yXu), Integer.valueOf(this.yXv) });
          paramInt = paramJSONObject.optInt("enableWeishiHb");
          g.aAi();
          g.aAh().azQ().set(ar.a.NTk, Integer.valueOf(paramInt));
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "weishiHbSwitch:".concat(String.valueOf(paramInt)));
          this.yPK = paramJSONObject.optString("wishing");
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "wishing: %s", new Object[] { this.yPK });
          paramString = paramJSONObject.optJSONArray("yearMess");
          if ((paramString != null) && (paramString.length() > 0))
          {
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "yearMessJson length:" + paramString.length());
            this.yXw = new LinkedList();
            paramInt = 0;
            while (paramInt < paramString.length())
            {
              paramJSONObject = paramString.optJSONObject(paramInt);
              localObject = new ab();
              ((ab)localObject).yWB = paramJSONObject.optInt("yearAmount", 0);
              ((ab)localObject).yWC = paramJSONObject.optString("yearWish");
              this.yXw.add(localObject);
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
          efk();
          AppMethodBeat.o(213322);
          return;
        }
      }
    }
    Log.e("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
    AppMethodBeat.o(213322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ar
 * JD-Core Version:    0.7.0.1
 */