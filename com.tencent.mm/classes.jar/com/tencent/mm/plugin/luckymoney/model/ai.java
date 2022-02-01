package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  public String dCl;
  public String iWA;
  public int phn;
  public au vAy;
  public String vCj;
  public boolean vCk;
  public int vCl;
  public String vCm;
  public au vCn;
  public au vCo;
  public au vCp;
  public int vCq;
  public int vCr;
  public int vCs;
  public int vCt;
  public int vCu;
  public LinkedList<w> vCv;
  public String vvm;
  public String vvn;
  public String vvw;
  
  public ai(String paramString, int paramInt)
  {
    AppMethodBeat.i(65288);
    this.vCq = 0;
    this.vCr = 0;
    this.vCs = 0;
    this.vCt = 0;
    this.vCu = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", "8");
    localHashMap.put("ver", paramString);
    g.ajS();
    localHashMap.put("walletType", String.valueOf(g.ajR().ajA().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(65288);
  }
  
  public ai(String paramString, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(65289);
    this.vCq = 0;
    this.vCr = 0;
    this.vCs = 0;
    this.vCt = 0;
    this.vCu = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ver", paramString);
    g.ajS();
    localHashMap.put("walletType", String.valueOf(g.ajR().ajA().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(65289);
  }
  
  public final String cbJ()
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
      this.vCl = paramJSONObject.optInt("randomAmount");
      this.vCj = paramJSONObject.optString("randomWishing");
      this.iWA = paramJSONObject.optString("notice");
      this.vCm = paramJSONObject.optString("notice_url");
      boolean bool;
      if (paramJSONObject.optInt("hasCanShareHongBao") == 1) {
        bool = true;
      }
      for (;;)
      {
        this.vCk = bool;
        this.phn = paramJSONObject.optInt("currency");
        this.vvm = paramJSONObject.optString("currencyUint");
        this.vvn = paramJSONObject.optString("currencyWording");
        this.dCl = paramJSONObject.optString("unique_id");
        ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.phn + ";currencyUint=" + this.vvm + ";currencyWording=" + this.vvn + ";uniqueId=" + this.dCl);
        paramString = new j();
        paramString.vzZ = paramJSONObject.optString("groupHint");
        paramString.vAa = paramJSONObject.optString("personalHint");
        paramString.vvk = (paramJSONObject.optLong("totalAmount", 200000L) / 100.0D);
        paramString.vvh = paramJSONObject.optInt("totalNum", 100);
        paramString.vvi = (paramJSONObject.optLong("perPersonMaxValue", 20000L) / 100.0D);
        paramString.vvl = (paramJSONObject.optLong("perGroupMaxValue", 20000L) / 100.0D);
        paramString.vvj = (paramJSONObject.optLong("perMinValue", 1L) / 100.0D);
        paramString.vAb = paramJSONObject.optInt("payShowBGFlag");
        paramString.phn = this.phn;
        paramString.vvm = this.vvm;
        paramString.vvn = this.vvn;
        paramString.vAc = paramJSONObject.optString("foreignFaqUrl");
        paramString.vAd = paramJSONObject.optString("foreignHongBaoName");
        paramString.vAe = paramJSONObject.optString("showSourceAndMac");
        paramString.vAf = paramJSONObject.optString("coverinfo");
        ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s", new Object[] { paramString.vAc, paramString.vAd });
        a.dkG();
        Object localObject = a.dkH();
        ((k)localObject).vvL = paramString;
        ((k)localObject).dlj();
        ae.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + ((k)localObject).vvL.vvk + " maxTotalNum:" + ((k)localObject).vvL.vvh + " perGroupMaxValue:" + ((k)localObject).vvL.vvl + " perMinValue:" + ((k)localObject).vvL.vvj + " perPersonMaxValue:" + ((k)localObject).vvL.vvi);
        try
        {
          paramString = new String(((k)localObject).vvL.toByteArray(), "ISO-8859-1");
          g.ajS();
          g.ajR().ajA().set(356355, paramString);
          g.ajS();
          g.ajR().ajA().fuc();
          this.vCn = x.aF(paramJSONObject.optJSONObject("operationHeader"));
          this.vAy = x.aF(paramJSONObject.optJSONObject("operationTail"));
          this.vCo = x.aF(paramJSONObject.optJSONObject("operationNext"));
          this.vCp = x.aF(paramJSONObject.optJSONObject("operationMiddle"));
          paramInt = paramJSONObject.optInt("sceneSwitch");
          g.ajS();
          g.ajR().ajA().set(am.a.ILi, Integer.valueOf(paramInt));
          ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(paramInt)));
          this.vCq = paramJSONObject.optInt("scenePicSwitch");
          ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.vCq);
          this.vCs = paramJSONObject.optInt("enableYearHbExpression");
          ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.vCs) });
          this.vCr = paramJSONObject.optInt("enableSelfie");
          ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableSelfIe:" + this.vCr);
          this.vCt = paramJSONObject.optInt("enableNormalSelfie");
          this.vCu = paramJSONObject.optInt("enableNormalAllExpression");
          ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.vCt), Integer.valueOf(this.vCu) });
          paramInt = paramJSONObject.optInt("enableWeishiHb");
          g.ajS();
          g.ajR().ajA().set(am.a.ILk, Integer.valueOf(paramInt));
          ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "weishiHbSwitch:".concat(String.valueOf(paramInt)));
          this.vvw = paramJSONObject.optString("wishing");
          ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[] { this.vvw });
          paramString = paramJSONObject.optJSONArray("yearMess");
          if ((paramString != null) && (paramString.length() > 0))
          {
            ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + paramString.length());
            this.vCv = new LinkedList();
            paramInt = 0;
            while (paramInt < paramString.length())
            {
              paramJSONObject = paramString.optJSONObject(paramInt);
              localObject = new w();
              ((w)localObject).vBD = paramJSONObject.optInt("yearAmount", 0);
              ((w)localObject).vBE = paramJSONObject.optString("yearWish");
              this.vCv.add(localObject);
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
            ae.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ae.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
          ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
          g.ajS();
          paramInt = ((Integer)g.ajR().ajA().get(am.a.Jae, Integer.valueOf(0))).intValue();
          int i = ((b)g.ab(b.class)).a(b.a.qDX, 0);
          if ((bu.jB(paramInt, 1)) || (bu.jB(i, 1)))
          {
            this.vCt = 1;
            this.vCu = 1;
            this.vCr = 1;
            this.vCs = 1;
          }
          ae.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "localSwitch() enableNormalSelfie:%s enableNormalAllExpression:%s enableSelfie:%s enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.vCt), Integer.valueOf(this.vCu), Integer.valueOf(this.vCr), Integer.valueOf(this.vCs) });
          AppMethodBeat.o(65290);
          return;
        }
      }
    }
    ae.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
    AppMethodBeat.o(65290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ai
 * JD-Core Version:    0.7.0.1
 */