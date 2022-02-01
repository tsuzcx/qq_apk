package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  public String dpt;
  public String iAx;
  public int oxo;
  public String ugH;
  public String ugx;
  public String ugy;
  public au ulN;
  public int unA;
  public String unB;
  public au unC;
  public au unD;
  public au unE;
  public int unF;
  public int unG;
  public int unH;
  public int unI;
  public int unJ;
  public LinkedList<w> unK;
  public String uny;
  public boolean unz;
  
  public ai(String paramString, int paramInt)
  {
    AppMethodBeat.i(65288);
    this.unF = 0;
    this.unG = 0;
    this.unH = 0;
    this.unI = 0;
    this.unJ = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", "8");
    localHashMap.put("ver", paramString);
    g.agS();
    localHashMap.put("walletType", String.valueOf(g.agR().agA().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(65288);
  }
  
  public ai(String paramString, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(65289);
    this.unF = 0;
    this.unG = 0;
    this.unH = 0;
    this.unI = 0;
    this.unJ = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ver", paramString);
    g.agS();
    localHashMap.put("walletType", String.valueOf(g.agR().agA().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(65289);
  }
  
  public final String bVR()
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
      this.unA = paramJSONObject.optInt("randomAmount");
      this.uny = paramJSONObject.optString("randomWishing");
      this.iAx = paramJSONObject.optString("notice");
      this.unB = paramJSONObject.optString("notice_url");
      boolean bool;
      if (paramJSONObject.optInt("hasCanShareHongBao") == 1) {
        bool = true;
      }
      for (;;)
      {
        this.unz = bool;
        this.oxo = paramJSONObject.optInt("currency");
        this.ugx = paramJSONObject.optString("currencyUint");
        this.ugy = paramJSONObject.optString("currencyWording");
        this.dpt = paramJSONObject.optString("unique_id");
        ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.oxo + ";currencyUint=" + this.ugx + ";currencyWording=" + this.ugy + ";uniqueId=" + this.dpt);
        paramString = new j();
        paramString.ulo = paramJSONObject.optString("groupHint");
        paramString.ulp = paramJSONObject.optString("personalHint");
        paramString.ugv = (paramJSONObject.optLong("totalAmount", 200000L) / 100.0D);
        paramString.ugs = paramJSONObject.optInt("totalNum", 100);
        paramString.ugt = (paramJSONObject.optLong("perPersonMaxValue", 20000L) / 100.0D);
        paramString.ugw = (paramJSONObject.optLong("perGroupMaxValue", 20000L) / 100.0D);
        paramString.ugu = (paramJSONObject.optLong("perMinValue", 1L) / 100.0D);
        paramString.ulq = paramJSONObject.optInt("payShowBGFlag");
        paramString.oxo = this.oxo;
        paramString.ugx = this.ugx;
        paramString.ugy = this.ugy;
        paramString.ulr = paramJSONObject.optString("foreignFaqUrl");
        paramString.uls = paramJSONObject.optString("foreignHongBaoName");
        paramString.ult = paramJSONObject.optString("showSourceAndMac");
        paramString.ulu = paramJSONObject.optString("coverinfo");
        ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s", new Object[] { paramString.ulr, paramString.uls });
        a.cYv();
        Object localObject = a.cYw();
        ((k)localObject).ugW = paramString;
        ((k)localObject).cYY();
        ac.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + ((k)localObject).ugW.ugv + " maxTotalNum:" + ((k)localObject).ugW.ugs + " perGroupMaxValue:" + ((k)localObject).ugW.ugw + " perMinValue:" + ((k)localObject).ugW.ugu + " perPersonMaxValue:" + ((k)localObject).ugW.ugt);
        try
        {
          paramString = new String(((k)localObject).ugW.toByteArray(), "ISO-8859-1");
          g.agS();
          g.agR().agA().set(356355, paramString);
          g.agS();
          g.agR().agA().faa();
          this.unC = x.aw(paramJSONObject.optJSONObject("operationHeader"));
          this.ulN = x.aw(paramJSONObject.optJSONObject("operationTail"));
          this.unD = x.aw(paramJSONObject.optJSONObject("operationNext"));
          this.unE = x.aw(paramJSONObject.optJSONObject("operationMiddle"));
          paramInt = paramJSONObject.optInt("sceneSwitch");
          g.agS();
          g.agR().agA().set(ah.a.GEt, Integer.valueOf(paramInt));
          ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(paramInt)));
          this.unF = paramJSONObject.optInt("scenePicSwitch");
          ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.unF);
          this.unH = paramJSONObject.optInt("enableYearHbExpression");
          ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.unH) });
          this.unG = paramJSONObject.optInt("enableSelfie");
          ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableSelfIe:" + this.unG);
          this.unI = paramJSONObject.optInt("enableNormalSelfie");
          this.unJ = paramJSONObject.optInt("enableNormalAllExpression");
          ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.unI), Integer.valueOf(this.unJ) });
          paramInt = paramJSONObject.optInt("enableWeishiHb");
          g.agS();
          g.agR().agA().set(ah.a.GEv, Integer.valueOf(paramInt));
          ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "weishiHbSwitch:".concat(String.valueOf(paramInt)));
          this.ugH = paramJSONObject.optString("wishing");
          ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[] { this.ugH });
          paramString = paramJSONObject.optJSONArray("yearMess");
          if ((paramString != null) && (paramString.length() > 0))
          {
            ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + paramString.length());
            this.unK = new LinkedList();
            paramInt = 0;
            while (paramInt < paramString.length())
            {
              paramJSONObject = paramString.optJSONObject(paramInt);
              localObject = new w();
              ((w)localObject).umS = paramJSONObject.optInt("yearAmount", 0);
              ((w)localObject).umT = paramJSONObject.optString("yearWish");
              this.unK.add(localObject);
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
            ac.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ac.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
          ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
          g.agS();
          paramInt = ((Integer)g.agR().agA().get(ah.a.GSZ, Integer.valueOf(0))).intValue();
          int i = ((b)g.ab(b.class)).a(b.a.pSw, 0);
          if ((bs.jl(paramInt, 1)) || (bs.jl(i, 1)))
          {
            this.unI = 1;
            this.unJ = 1;
            this.unG = 1;
            this.unH = 1;
          }
          ac.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "localSwitch() enableNormalSelfie:%s enableNormalAllExpression:%s enableSelfie:%s enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.unI), Integer.valueOf(this.unJ), Integer.valueOf(this.unG), Integer.valueOf(this.unH) });
          AppMethodBeat.o(65290);
          return;
        }
      }
    }
    ac.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
    AppMethodBeat.o(65290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ai
 * JD-Core Version:    0.7.0.1
 */