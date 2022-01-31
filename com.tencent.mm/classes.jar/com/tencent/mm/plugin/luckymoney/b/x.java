package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class x
  extends ab
{
  public int iHA;
  public String iHC;
  public String lLc;
  public String lLd;
  public String lLm;
  public ai lQj;
  public String lRm;
  public boolean lRn;
  public int lRo;
  public String lRp;
  public ai lRq;
  public ai lRr;
  public ai lRs;
  public int lRt = 0;
  public LinkedList<l> lRu;
  
  public x(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", "8");
    localHashMap.put("ver", paramString);
    g.DQ();
    localHashMap.put("walletType", String.valueOf(g.DP().Dz().get(339975, null)));
    D(localHashMap);
  }
  
  public x(String paramString, byte paramByte)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ver", paramString);
    g.DQ();
    localHashMap.put("walletType", String.valueOf(g.DP().Dz().get(339975, null)));
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramInt == 0)
    {
      this.lRo = paramJSONObject.optInt("randomAmount");
      this.lRm = paramJSONObject.optString("randomWishing");
      this.iHC = paramJSONObject.optString("notice");
      this.lRp = paramJSONObject.optString("notice_url");
      boolean bool;
      if (paramJSONObject.optInt("hasCanShareHongBao") == 1) {
        bool = true;
      }
      for (;;)
      {
        this.lRn = bool;
        this.iHA = paramJSONObject.optInt("currency");
        this.lLc = paramJSONObject.optString("currencyUint");
        this.lLd = paramJSONObject.optString("currencyWording");
        y.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.iHA + ";currencyUint=" + this.lLc + ";currencyWording=" + this.lLd);
        paramString = new d();
        paramString.lPM = paramJSONObject.optString("groupHint");
        paramString.lPN = paramJSONObject.optString("personalHint");
        paramString.lLa = (paramJSONObject.optLong("totalAmount", 200000L) / 100.0D);
        paramString.lKX = paramJSONObject.optInt("totalNum", 100);
        paramString.lKY = (paramJSONObject.optLong("perPersonMaxValue", 20000L) / 100.0D);
        paramString.lLb = (paramJSONObject.optLong("perGroupMaxValue", 20000L) / 100.0D);
        paramString.lKZ = (paramJSONObject.optLong("perMinValue", 1L) / 100.0D);
        paramString.lPO = paramJSONObject.optInt("payShowBGFlag");
        paramString.iHA = this.iHA;
        paramString.lLc = this.lLc;
        paramString.lLd = this.lLd;
        paramString.lPP = paramJSONObject.optString("foreignFaqUrl");
        paramString.lPQ = paramJSONObject.optString("foreignHongBaoName");
        y.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s", new Object[] { paramString.lPP, paramString.lPQ });
        a.bfg();
        Object localObject = a.bfh();
        ((e)localObject).lLB = paramString;
        y.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + ((e)localObject).lLB.lLa + " maxTotalNum:" + ((e)localObject).lLB.lKX + " perGroupMaxValue:" + ((e)localObject).lLB.lLb + " perMinValue:" + ((e)localObject).lLB.lKZ + " perPersonMaxValue:" + ((e)localObject).lLB.lKY);
        try
        {
          paramString = new String(((e)localObject).lLB.toByteArray(), "ISO-8859-1");
          g.DQ();
          g.DP().Dz().o(356355, paramString);
          g.DQ();
          g.DP().Dz().mC(true);
          this.lRq = m.V(paramJSONObject.optJSONObject("operationHeader"));
          this.lQj = m.V(paramJSONObject.optJSONObject("operationTail"));
          this.lRr = m.V(paramJSONObject.optJSONObject("operationNext"));
          this.lRs = m.V(paramJSONObject.optJSONObject("operationMiddle"));
          paramInt = paramJSONObject.optInt("sceneSwitch");
          g.DQ();
          g.DP().Dz().c(ac.a.uos, Integer.valueOf(paramInt));
          y.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:" + paramInt);
          this.lRt = paramJSONObject.optInt("scenePicSwitch");
          y.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.lRt);
          this.lLm = paramJSONObject.optString("wishing");
          y.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[] { this.lLm });
          paramString = paramJSONObject.optJSONArray("yearMess");
          if ((paramString != null) && (paramString.length() > 0))
          {
            y.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + paramString.length());
            this.lRu = new LinkedList();
            paramInt = 0;
            while (paramInt < paramString.length())
            {
              paramJSONObject = paramString.optJSONObject(paramInt);
              localObject = new l();
              ((l)localObject).lQJ = paramJSONObject.optInt("yearAmount", 0);
              ((l)localObject).lQK = paramJSONObject.optString("yearWish");
              this.lRu.add(localObject);
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
            y.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            y.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
          y.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
        }
      }
      return;
    }
    y.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/operationwxhb";
  }
  
  public final int getType()
  {
    return 1554;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.x
 * JD-Core Version:    0.7.0.1
 */