package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ag
  extends ak
{
  public String feA;
  public int kNE;
  public String kNG;
  public String oiG;
  public String oiw;
  public String oix;
  public as onH;
  public String ope;
  public boolean opf;
  public int opg;
  public String oph;
  public as opi;
  public as opj;
  public as opk;
  public int opl;
  public int opm;
  public int opn;
  public int opo;
  public int opp;
  public LinkedList<u> opq;
  
  public ag(String paramString, int paramInt)
  {
    AppMethodBeat.i(42400);
    this.opl = 0;
    this.opm = 0;
    this.opn = 0;
    this.opo = 0;
    this.opp = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", "8");
    localHashMap.put("ver", paramString);
    g.RM();
    localHashMap.put("walletType", String.valueOf(g.RL().Ru().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(42400);
  }
  
  public ag(String paramString, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(42401);
    this.opl = 0;
    this.opm = 0;
    this.opn = 0;
    this.opo = 0;
    this.opp = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ver", paramString);
    g.RM();
    localHashMap.put("walletType", String.valueOf(g.RL().Ru().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(42401);
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/operationwxhb";
  }
  
  public final int getType()
  {
    return 1554;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42402);
    if (paramInt == 0)
    {
      this.opg = paramJSONObject.optInt("randomAmount");
      this.ope = paramJSONObject.optString("randomWishing");
      this.kNG = paramJSONObject.optString("notice");
      this.oph = paramJSONObject.optString("notice_url");
      boolean bool;
      if (paramJSONObject.optInt("hasCanShareHongBao") == 1) {
        bool = true;
      }
      for (;;)
      {
        this.opf = bool;
        this.kNE = paramJSONObject.optInt("currency");
        this.oiw = paramJSONObject.optString("currencyUint");
        this.oix = paramJSONObject.optString("currencyWording");
        this.feA = paramJSONObject.optString("unique_id");
        ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.kNE + ";currencyUint=" + this.oiw + ";currencyWording=" + this.oix + ";uniqueId=" + this.feA);
        paramString = new i();
        paramString.onj = paramJSONObject.optString("groupHint");
        paramString.onk = paramJSONObject.optString("personalHint");
        paramString.oiu = (paramJSONObject.optLong("totalAmount", 200000L) / 100.0D);
        paramString.oir = paramJSONObject.optInt("totalNum", 100);
        paramString.ois = (paramJSONObject.optLong("perPersonMaxValue", 20000L) / 100.0D);
        paramString.oiv = (paramJSONObject.optLong("perGroupMaxValue", 20000L) / 100.0D);
        paramString.oit = (paramJSONObject.optLong("perMinValue", 1L) / 100.0D);
        paramString.onl = paramJSONObject.optInt("payShowBGFlag");
        paramString.kNE = this.kNE;
        paramString.oiw = this.oiw;
        paramString.oix = this.oix;
        paramString.onm = paramJSONObject.optString("foreignFaqUrl");
        paramString.onn = paramJSONObject.optString("foreignHongBaoName");
        paramString.ono = paramJSONObject.optString("showSourceAndMac");
        ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s", new Object[] { paramString.onm, paramString.onn });
        com.tencent.mm.plugin.luckymoney.b.a.bMG();
        Object localObject = com.tencent.mm.plugin.luckymoney.b.a.bMH();
        ((j)localObject).oiV = paramString;
        ((j)localObject).bNj();
        ab.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + ((j)localObject).oiV.oiu + " maxTotalNum:" + ((j)localObject).oiV.oir + " perGroupMaxValue:" + ((j)localObject).oiV.oiv + " perMinValue:" + ((j)localObject).oiV.oit + " perPersonMaxValue:" + ((j)localObject).oiV.ois);
        try
        {
          paramString = new String(((j)localObject).oiV.toByteArray(), "ISO-8859-1");
          g.RM();
          g.RL().Ru().set(356355, paramString);
          g.RM();
          g.RL().Ru().dww();
          this.opi = v.ag(paramJSONObject.optJSONObject("operationHeader"));
          this.onH = v.ag(paramJSONObject.optJSONObject("operationTail"));
          this.opj = v.ag(paramJSONObject.optJSONObject("operationNext"));
          this.opk = v.ag(paramJSONObject.optJSONObject("operationMiddle"));
          paramInt = paramJSONObject.optInt("sceneSwitch");
          g.RM();
          g.RL().Ru().set(ac.a.yyl, Integer.valueOf(paramInt));
          ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(paramInt)));
          this.opl = paramJSONObject.optInt("scenePicSwitch");
          ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.opl);
          this.opn = paramJSONObject.optInt("enableYearHbExpression");
          ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.opn) });
          this.opm = paramJSONObject.optInt("enableSelfie");
          ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableSelfIe:" + this.opm);
          this.opo = paramJSONObject.optInt("enableNormalSelfie");
          this.opp = paramJSONObject.optInt("enableNormalAllExpression");
          ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.opo), Integer.valueOf(this.opp) });
          this.oiG = paramJSONObject.optString("wishing");
          ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[] { this.oiG });
          paramString = paramJSONObject.optJSONArray("yearMess");
          if ((paramString != null) && (paramString.length() > 0))
          {
            ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + paramString.length());
            this.opq = new LinkedList();
            paramInt = 0;
            while (paramInt < paramString.length())
            {
              paramJSONObject = paramString.optJSONObject(paramInt);
              localObject = new u();
              ((u)localObject).ooz = paramJSONObject.optInt("yearAmount", 0);
              ((u)localObject).ooA = paramJSONObject.optString("yearWish");
              this.opq.add(localObject);
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
            ab.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ab.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + paramString.getLocalizedMessage());
          }
          ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
          g.RM();
          paramInt = ((Integer)g.RL().Ru().get(ac.a.yLJ, Integer.valueOf(0))).intValue();
          int i = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVp, 0);
          if ((bo.hl(paramInt, 1)) || (bo.hl(i, 1)))
          {
            this.opo = 1;
            this.opp = 1;
            this.opm = 1;
            this.opn = 1;
          }
          ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "localSwitch() enableNormalSelfie:%s enableNormalAllExpression:%s enableSelfie:%s enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.opo), Integer.valueOf(this.opp), Integer.valueOf(this.opm), Integer.valueOf(this.opn) });
          AppMethodBeat.o(42402);
          return;
        }
      }
    }
    ab.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
    AppMethodBeat.o(42402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ag
 * JD-Core Version:    0.7.0.1
 */