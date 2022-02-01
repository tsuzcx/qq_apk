package com.tencent.mm.plugin.luckymoney.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.luckymoney.model.ac;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.ui.g;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends ar
{
  public a(String paramString, int paramInt)
  {
    super(23, paramString, paramInt);
  }
  
  public final String cOd()
  {
    return "/cgi-bin/mmpay-bin/ftfhb/channelliveoperationwxhb";
  }
  
  public final int getType()
  {
    return 4878;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(275779);
    Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
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
        this.tVx = 1;
        this.Etz = paramJSONObject.optString("currencyUint");
        this.EtA = paramJSONObject.optString("currencyWording");
        this.fND = paramJSONObject.optString("unique_id");
        Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "currency=" + this.tVx + ";currencyUint=" + this.Etz + ";currencyWording=" + this.EtA + ";uniqueId=" + this.fND);
        paramString = new o();
        paramString.EyO = paramJSONObject.optString("groupHint");
        paramString.EyP = paramJSONObject.optString("personalHint");
        paramString.Etu = paramJSONObject.optInt("totalNum", 100);
        paramString.Etx = g.a(paramJSONObject.optString("totalAmount", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.Etv = g.a(paramJSONObject.optString("perPersonMaxValue", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.Ety = g.a(paramJSONObject.optString("perGroupMaxValue", "0"), "100", 2, RoundingMode.HALF_UP);
        paramString.Etw = g.a(paramJSONObject.optString("perMinValue", "0"), "100", 2, RoundingMode.HALF_UP);
        Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "config.maxTotalAmount: %s, config.perPersonMaxValue: %s，config.perGroupMaxValue：%s , config.perMinValue:%s", new Object[] { Double.valueOf(paramString.Etx), Double.valueOf(paramString.Etv), Double.valueOf(paramString.Ety), Double.valueOf(paramString.Etw) });
        paramString.EyQ = paramJSONObject.optInt("payShowBGFlag");
        paramString.tVx = this.tVx;
        paramString.Etz = this.Etz;
        paramString.EtA = this.EtA;
        paramString.EyR = paramJSONObject.optString("foreignFaqUrl");
        paramString.EyS = paramJSONObject.optString("foreignHongBaoName");
        paramString.EyT = paramJSONObject.optString("showSourceAndMac");
        paramString.EyU = paramJSONObject.optString("coverinfo");
        Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s", new Object[] { paramString.EyR, paramString.EyS });
        com.tencent.mm.plugin.luckymoney.b.a.eNR();
        Object localObject = com.tencent.mm.plugin.luckymoney.b.a.eNU();
        ((w)localObject).EtY = paramString;
        ((w)localObject).eOy();
        Log.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + ((w)localObject).EtY.Etx + " maxTotalNum:" + ((w)localObject).EtY.Etu + " perGroupMaxValue:" + ((w)localObject).EtY.Ety + " perMinValue:" + ((w)localObject).EtY.Etw + " perPersonMaxValue:" + ((w)localObject).EtY.Etv);
        try
        {
          paramString = new String(((w)localObject).EtY.toByteArray(), "ISO-8859-1");
          h.aHH();
          h.aHG().aHp().set(ar.a.Vhl, paramString);
          this.EBt = ad.bh(paramJSONObject.optJSONObject("operationHeader"));
          this.Ezp = ad.bh(paramJSONObject.optJSONObject("operationTail"));
          this.EBu = ad.bh(paramJSONObject.optJSONObject("operationNext"));
          this.EBv = ad.bh(paramJSONObject.optJSONObject("operationMiddle"));
          paramInt = paramJSONObject.optInt("sceneSwitch");
          h.aHH();
          h.aHG().aHp().set(ar.a.Vhe, Integer.valueOf(paramInt));
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(paramInt)));
          this.EBw = paramJSONObject.optInt("scenePicSwitch");
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "scenePicSwitch:" + this.EBw);
          this.EBy = paramJSONObject.optInt("enableYearHbExpression");
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.EBy) });
          this.EBx = paramJSONObject.optInt("enableSelfie");
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "enableSelfIe:" + this.EBx);
          this.EBz = paramJSONObject.optInt("enableNormalSelfie");
          this.EBA = paramJSONObject.optInt("enableNormalAllExpression");
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.EBz), Integer.valueOf(this.EBA) });
          paramInt = paramJSONObject.optInt("enableWeishiHb");
          h.aHH();
          h.aHG().aHp().set(ar.a.Vhg, Integer.valueOf(paramInt));
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "weishiHbSwitch:".concat(String.valueOf(paramInt)));
          this.EtJ = paramJSONObject.optString("wishing");
          Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "wishing: %s", new Object[] { this.EtJ });
          paramString = paramJSONObject.optJSONArray("yearMess");
          if ((paramString != null) && (paramString.length() > 0))
          {
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "yearMessJson length:" + paramString.length());
            this.EBB = new LinkedList();
            paramInt = 0;
            while (paramInt < paramString.length())
            {
              paramJSONObject = paramString.optJSONObject(paramInt);
              localObject = new ac();
              ((ac)localObject).EAE = paramJSONObject.optInt("yearAmount", 0);
              ((ac)localObject).EAF = paramJSONObject.optString("yearWish");
              this.EBB.add(localObject);
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
          eOI();
          AppMethodBeat.o(275779);
          return;
        }
      }
    }
    Log.e("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
    AppMethodBeat.o(275779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a.a
 * JD-Core Version:    0.7.0.1
 */