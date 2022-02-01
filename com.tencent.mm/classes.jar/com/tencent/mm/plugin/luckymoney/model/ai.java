package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ai
  extends am
{
  public String drI;
  public String iau;
  public int nTT;
  public String sYj;
  public String sYk;
  public String sYt;
  public au tdy;
  public String tfj;
  public boolean tfk;
  public int tfl;
  public String tfm;
  public au tfn;
  public au tfo;
  public au tfp;
  public int tfq;
  public int tfr;
  public int tfs;
  public int tft;
  public int tfu;
  public LinkedList<w> tfv;
  
  public ai(String paramString, int paramInt)
  {
    AppMethodBeat.i(65288);
    this.tfq = 0;
    this.tfr = 0;
    this.tfs = 0;
    this.tft = 0;
    this.tfu = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", "8");
    localHashMap.put("ver", paramString);
    g.afC();
    localHashMap.put("walletType", String.valueOf(g.afB().afk().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(65288);
  }
  
  public ai(String paramString, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(65289);
    this.tfq = 0;
    this.tfr = 0;
    this.tfs = 0;
    this.tft = 0;
    this.tfu = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ver", paramString);
    g.afC();
    localHashMap.put("walletType", String.valueOf(g.afB().afk().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(65289);
  }
  
  public final String bOB()
  {
    return "/cgi-bin/mmpay-bin/operationwxhb";
  }
  
  public final int getType()
  {
    return 1554;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65290);
    if (paramInt == 0)
    {
      this.tfl = paramJSONObject.optInt("randomAmount");
      this.tfj = paramJSONObject.optString("randomWishing");
      this.iau = paramJSONObject.optString("notice");
      this.tfm = paramJSONObject.optString("notice_url");
      boolean bool;
      if (paramJSONObject.optInt("hasCanShareHongBao") == 1) {
        bool = true;
      }
      for (;;)
      {
        this.tfk = bool;
        this.nTT = paramJSONObject.optInt("currency");
        this.sYj = paramJSONObject.optString("currencyUint");
        this.sYk = paramJSONObject.optString("currencyWording");
        this.drI = paramJSONObject.optString("unique_id");
        ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.nTT + ";currencyUint=" + this.sYj + ";currencyWording=" + this.sYk + ";uniqueId=" + this.drI);
        paramString = new j();
        paramString.tcZ = paramJSONObject.optString("groupHint");
        paramString.tda = paramJSONObject.optString("personalHint");
        paramString.sYh = (paramJSONObject.optLong("totalAmount", 200000L) / 100.0D);
        paramString.sYe = paramJSONObject.optInt("totalNum", 100);
        paramString.sYf = (paramJSONObject.optLong("perPersonMaxValue", 20000L) / 100.0D);
        paramString.sYi = (paramJSONObject.optLong("perGroupMaxValue", 20000L) / 100.0D);
        paramString.sYg = (paramJSONObject.optLong("perMinValue", 1L) / 100.0D);
        paramString.tdb = paramJSONObject.optInt("payShowBGFlag");
        paramString.nTT = this.nTT;
        paramString.sYj = this.sYj;
        paramString.sYk = this.sYk;
        paramString.tdc = paramJSONObject.optString("foreignFaqUrl");
        paramString.tdd = paramJSONObject.optString("foreignHongBaoName");
        paramString.tde = paramJSONObject.optString("showSourceAndMac");
        paramString.tdf = paramJSONObject.optString("coverinfo");
        ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s", new Object[] { paramString.tdc, paramString.tdd });
        a.cKP();
        Object localObject = a.cKQ();
        ((k)localObject).sYI = paramString;
        ((k)localObject).cLs();
        ad.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + ((k)localObject).sYI.sYh + " maxTotalNum:" + ((k)localObject).sYI.sYe + " perGroupMaxValue:" + ((k)localObject).sYI.sYi + " perMinValue:" + ((k)localObject).sYI.sYg + " perPersonMaxValue:" + ((k)localObject).sYI.sYf);
        try
        {
          paramString = new String(((k)localObject).sYI.toByteArray(), "ISO-8859-1");
          g.afC();
          g.afB().afk().set(356355, paramString);
          g.afC();
          g.afB().afk().eKy();
          this.tfn = x.av(paramJSONObject.optJSONObject("operationHeader"));
          this.tdy = x.av(paramJSONObject.optJSONObject("operationTail"));
          this.tfo = x.av(paramJSONObject.optJSONObject("operationNext"));
          this.tfp = x.av(paramJSONObject.optJSONObject("operationMiddle"));
          paramInt = paramJSONObject.optInt("sceneSwitch");
          g.afC();
          g.afB().afk().set(ae.a.FgF, Integer.valueOf(paramInt));
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(paramInt)));
          this.tfq = paramJSONObject.optInt("scenePicSwitch");
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.tfq);
          this.tfs = paramJSONObject.optInt("enableYearHbExpression");
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.tfs) });
          this.tfr = paramJSONObject.optInt("enableSelfie");
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableSelfIe:" + this.tfr);
          this.tft = paramJSONObject.optInt("enableNormalSelfie");
          this.tfu = paramJSONObject.optInt("enableNormalAllExpression");
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.tft), Integer.valueOf(this.tfu) });
          paramInt = paramJSONObject.optInt("enableWeishiHb");
          g.afC();
          g.afB().afk().set(ae.a.FgH, Integer.valueOf(paramInt));
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "weishiHbSwitch:".concat(String.valueOf(paramInt)));
          this.sYt = paramJSONObject.optString("wishing");
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[] { this.sYt });
          paramString = paramJSONObject.optJSONArray("yearMess");
          if ((paramString != null) && (paramString.length() > 0))
          {
            ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + paramString.length());
            this.tfv = new LinkedList();
            paramInt = 0;
            while (paramInt < paramString.length())
            {
              paramJSONObject = paramString.optJSONObject(paramInt);
              localObject = new w();
              ((w)localObject).teD = paramJSONObject.optInt("yearAmount", 0);
              ((w)localObject).teE = paramJSONObject.optString("yearWish");
              this.tfv.add(localObject);
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
            ad.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ad.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
          g.afC();
          paramInt = ((Integer)g.afB().afk().get(ae.a.Fvf, Integer.valueOf(0))).intValue();
          int i = ((b)g.ab(b.class)).a(b.a.poL, 0);
          if ((bt.iY(paramInt, 1)) || (bt.iY(i, 1)))
          {
            this.tft = 1;
            this.tfu = 1;
            this.tfr = 1;
            this.tfs = 1;
          }
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "localSwitch() enableNormalSelfie:%s enableNormalAllExpression:%s enableSelfie:%s enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.tft), Integer.valueOf(this.tfu), Integer.valueOf(this.tfr), Integer.valueOf(this.tfs) });
          AppMethodBeat.o(65290);
          return;
        }
      }
    }
    ad.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
    AppMethodBeat.o(65290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ai
 * JD-Core Version:    0.7.0.1
 */