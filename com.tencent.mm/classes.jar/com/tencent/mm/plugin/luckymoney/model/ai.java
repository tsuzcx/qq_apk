package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
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
  public String dBg;
  public String iTH;
  public int paJ;
  public String vjh;
  public String vji;
  public String vjr;
  public au vot;
  public String vqe;
  public boolean vqf;
  public int vqg;
  public String vqh;
  public au vqi;
  public au vqj;
  public au vqk;
  public int vql;
  public int vqm;
  public int vqn;
  public int vqo;
  public int vqp;
  public LinkedList<w> vqq;
  
  public ai(String paramString, int paramInt)
  {
    AppMethodBeat.i(65288);
    this.vql = 0;
    this.vqm = 0;
    this.vqn = 0;
    this.vqo = 0;
    this.vqp = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", "8");
    localHashMap.put("ver", paramString);
    g.ajD();
    localHashMap.put("walletType", String.valueOf(g.ajC().ajl().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(65288);
  }
  
  public ai(String paramString, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(65289);
    this.vql = 0;
    this.vqm = 0;
    this.vqn = 0;
    this.vqo = 0;
    this.vqp = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ver", paramString);
    g.ajD();
    localHashMap.put("walletType", String.valueOf(g.ajC().ajl().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(65289);
  }
  
  public final String cau()
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
      this.vqg = paramJSONObject.optInt("randomAmount");
      this.vqe = paramJSONObject.optString("randomWishing");
      this.iTH = paramJSONObject.optString("notice");
      this.vqh = paramJSONObject.optString("notice_url");
      boolean bool;
      if (paramJSONObject.optInt("hasCanShareHongBao") == 1) {
        bool = true;
      }
      for (;;)
      {
        this.vqf = bool;
        this.paJ = paramJSONObject.optInt("currency");
        this.vjh = paramJSONObject.optString("currencyUint");
        this.vji = paramJSONObject.optString("currencyWording");
        this.dBg = paramJSONObject.optString("unique_id");
        ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.paJ + ";currencyUint=" + this.vjh + ";currencyWording=" + this.vji + ";uniqueId=" + this.dBg);
        paramString = new j();
        paramString.vnU = paramJSONObject.optString("groupHint");
        paramString.vnV = paramJSONObject.optString("personalHint");
        paramString.vjf = (paramJSONObject.optLong("totalAmount", 200000L) / 100.0D);
        paramString.vjc = paramJSONObject.optInt("totalNum", 100);
        paramString.vjd = (paramJSONObject.optLong("perPersonMaxValue", 20000L) / 100.0D);
        paramString.vjg = (paramJSONObject.optLong("perGroupMaxValue", 20000L) / 100.0D);
        paramString.vje = (paramJSONObject.optLong("perMinValue", 1L) / 100.0D);
        paramString.vnW = paramJSONObject.optInt("payShowBGFlag");
        paramString.paJ = this.paJ;
        paramString.vjh = this.vjh;
        paramString.vji = this.vji;
        paramString.vnX = paramJSONObject.optString("foreignFaqUrl");
        paramString.vnY = paramJSONObject.optString("foreignHongBaoName");
        paramString.vnZ = paramJSONObject.optString("showSourceAndMac");
        paramString.voa = paramJSONObject.optString("coverinfo");
        ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s", new Object[] { paramString.vnX, paramString.vnY });
        a.dhH();
        Object localObject = a.dhI();
        ((k)localObject).vjG = paramString;
        ((k)localObject).dik();
        ad.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + ((k)localObject).vjG.vjf + " maxTotalNum:" + ((k)localObject).vjG.vjc + " perGroupMaxValue:" + ((k)localObject).vjG.vjg + " perMinValue:" + ((k)localObject).vjG.vje + " perPersonMaxValue:" + ((k)localObject).vjG.vjd);
        try
        {
          paramString = new String(((k)localObject).vjG.toByteArray(), "ISO-8859-1");
          g.ajD();
          g.ajC().ajl().set(356355, paramString);
          g.ajD();
          g.ajC().ajl().fqc();
          this.vqi = x.aF(paramJSONObject.optJSONObject("operationHeader"));
          this.vot = x.aF(paramJSONObject.optJSONObject("operationTail"));
          this.vqj = x.aF(paramJSONObject.optJSONObject("operationNext"));
          this.vqk = x.aF(paramJSONObject.optJSONObject("operationMiddle"));
          paramInt = paramJSONObject.optInt("sceneSwitch");
          g.ajD();
          g.ajC().ajl().set(al.a.IqM, Integer.valueOf(paramInt));
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(paramInt)));
          this.vql = paramJSONObject.optInt("scenePicSwitch");
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.vql);
          this.vqn = paramJSONObject.optInt("enableYearHbExpression");
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.vqn) });
          this.vqm = paramJSONObject.optInt("enableSelfie");
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableSelfIe:" + this.vqm);
          this.vqo = paramJSONObject.optInt("enableNormalSelfie");
          this.vqp = paramJSONObject.optInt("enableNormalAllExpression");
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.vqo), Integer.valueOf(this.vqp) });
          paramInt = paramJSONObject.optInt("enableWeishiHb");
          g.ajD();
          g.ajC().ajl().set(al.a.IqO, Integer.valueOf(paramInt));
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "weishiHbSwitch:".concat(String.valueOf(paramInt)));
          this.vjr = paramJSONObject.optString("wishing");
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[] { this.vjr });
          paramString = paramJSONObject.optJSONArray("yearMess");
          if ((paramString != null) && (paramString.length() > 0))
          {
            ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + paramString.length());
            this.vqq = new LinkedList();
            paramInt = 0;
            while (paramInt < paramString.length())
            {
              paramJSONObject = paramString.optJSONObject(paramInt);
              localObject = new w();
              ((w)localObject).vpy = paramJSONObject.optInt("yearAmount", 0);
              ((w)localObject).vpz = paramJSONObject.optString("yearWish");
              this.vqq.add(localObject);
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
          g.ajD();
          paramInt = ((Integer)g.ajC().ajl().get(al.a.IFE, Integer.valueOf(0))).intValue();
          int i = ((b)g.ab(b.class)).a(b.a.qwX, 0);
          if ((bt.jx(paramInt, 1)) || (bt.jx(i, 1)))
          {
            this.vqo = 1;
            this.vqp = 1;
            this.vqm = 1;
            this.vqn = 1;
          }
          ad.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "localSwitch() enableNormalSelfie:%s enableNormalAllExpression:%s enableSelfie:%s enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.vqo), Integer.valueOf(this.vqp), Integer.valueOf(this.vqm), Integer.valueOf(this.vqn) });
          AppMethodBeat.o(65290);
          return;
        }
      }
    }
    ad.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
    AppMethodBeat.o(65290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ai
 * JD-Core Version:    0.7.0.1
 */