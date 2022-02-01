package com.tencent.mm.plugin.luckymoney.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.ui.i;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends as
{
  public a(String paramString, int paramInt)
  {
    super(23, paramString, paramInt);
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/ftfhb/channelliveoperationwxhb";
  }
  
  public final int getType()
  {
    return 4878;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(283911);
    Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
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
        Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "currency=" + this.wYR + ";currencyUint=" + this.Kmg + ";currencyWording=" + this.Kmh + ";uniqueId=" + this.hTs);
        paramString = new o();
        paramString.KrB = paramJSONObject.optString("groupHint");
        paramString.KrC = paramJSONObject.optString("personalHint");
        paramString.Kmb = paramJSONObject.optInt("totalNum", 100);
        paramString.Kme = i.a(paramJSONObject.optString("totalAmount", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.Kmc = i.a(paramJSONObject.optString("perPersonMaxValue", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.Kmf = i.a(paramJSONObject.optString("perGroupMaxValue", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.Kmd = i.a(paramJSONObject.optString("perMinValue", "0"), "100", 2, RoundingMode.HALF_UP);
        Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "config.maxTotalAmount: %s, config.perPersonMaxValue: %s，config.perGroupMaxValue：%s , config.perMinValue:%s", new Object[] { Double.valueOf(paramString.Kme), Double.valueOf(paramString.Kmc), Double.valueOf(paramString.Kmf), Double.valueOf(paramString.Kmd) });
        paramString.KrD = paramJSONObject.optInt("payShowBGFlag");
        paramString.wYR = this.wYR;
        paramString.Kmg = this.Kmg;
        paramString.Kmh = this.Kmh;
        paramString.KrE = paramJSONObject.optString("foreignFaqUrl");
        paramString.KrF = paramJSONObject.optString("foreignHongBaoName");
        paramString.KrG = paramJSONObject.optString("showSourceAndMac");
        paramString.KrH = paramJSONObject.optString("coverinfo");
        Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s", new Object[] { paramString.KrE, paramString.KrF });
        com.tencent.mm.plugin.luckymoney.app.a.fWk();
        Object localObject = com.tencent.mm.plugin.luckymoney.app.a.fWn();
        ((v)localObject).KmF = paramString;
        ((v)localObject).fWV();
        Log.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + ((v)localObject).KmF.Kme + " maxTotalNum:" + ((v)localObject).KmF.Kmb + " perGroupMaxValue:" + ((v)localObject).KmF.Kmf + " perMinValue:" + ((v)localObject).KmF.Kmd + " perPersonMaxValue:" + ((v)localObject).KmF.Kmc);
        try
        {
          paramString = new String(((v)localObject).KmF.toByteArray(), "ISO-8859-1");
          h.baF();
          h.baE().ban().set(at.a.acIF, paramString);
          this.Kur = ae.bv(paramJSONObject.optJSONObject("operationHeader"));
          this.Ksc = ae.bv(paramJSONObject.optJSONObject("operationTail"));
          this.Kus = ae.bv(paramJSONObject.optJSONObject("operationNext"));
          this.Kut = ae.bv(paramJSONObject.optJSONObject("operationMiddle"));
          paramInt = paramJSONObject.optInt("sceneSwitch");
          h.baF();
          h.baE().ban().set(at.a.acIw, Integer.valueOf(paramInt));
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(paramInt)));
          this.Kuu = paramJSONObject.optInt("scenePicSwitch");
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "scenePicSwitch:" + this.Kuu);
          this.Kuw = paramJSONObject.optInt("enableYearHbExpression");
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.Kuw) });
          this.Kuv = paramJSONObject.optInt("enableSelfie");
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "enableSelfIe:" + this.Kuv);
          this.Kux = paramJSONObject.optInt("enableNormalSelfie");
          this.Kuy = paramJSONObject.optInt("enableNormalAllExpression");
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.Kux), Integer.valueOf(this.Kuy) });
          paramInt = paramJSONObject.optInt("enableWeishiHb");
          h.baF();
          h.baE().ban().set(at.a.acIy, Integer.valueOf(paramInt));
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "weishiHbSwitch:".concat(String.valueOf(paramInt)));
          this.Kmq = paramJSONObject.optString("wishing");
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "wishing: %s", new Object[] { this.Kmq });
          paramString = paramJSONObject.optJSONArray("yearMess");
          if ((paramString != null) && (paramString.length() > 0))
          {
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "yearMessJson length:" + paramString.length());
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
            Log.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            Log.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "yearMessJson is empty!");
          fXl();
          AppMethodBeat.o(283911);
          return;
        }
      }
    }
    Log.e("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
    AppMethodBeat.o(283911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a.a
 * JD-Core Version:    0.7.0.1
 */