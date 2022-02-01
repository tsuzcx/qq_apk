package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aq
  extends av
{
  public String dUb;
  public String jTx;
  public int qww;
  public String yPA;
  public String yPB;
  public String yPK;
  public bg yVs;
  public String yXk;
  public boolean yXl;
  public int yXm;
  public String yXn;
  public bg yXo;
  public bg yXp;
  public bg yXq;
  public int yXr;
  public int yXs;
  public int yXt;
  public int yXu;
  public int yXv;
  public LinkedList<ab> yXw;
  
  public aq()
  {
    this.yXr = 0;
    this.yXs = 0;
    this.yXt = 0;
    this.yXu = 0;
    this.yXv = 0;
  }
  
  public aq(String paramString, int paramInt)
  {
    AppMethodBeat.i(65288);
    this.yXr = 0;
    this.yXs = 0;
    this.yXt = 0;
    this.yXu = 0;
    this.yXv = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", "8");
    localHashMap.put("ver", paramString);
    g.aAi();
    localHashMap.put("walletType", String.valueOf(g.aAh().azQ().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "NetSceneLuckyMoneyGetConfig request");
    setRequestData(localHashMap);
    AppMethodBeat.o(65288);
  }
  
  public aq(String paramString, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(65289);
    this.yXr = 0;
    this.yXs = 0;
    this.yXt = 0;
    this.yXu = 0;
    this.yXv = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ver", paramString);
    g.aAi();
    localHashMap.put("walletType", String.valueOf(g.aAh().azQ().get(339975, null)));
    localHashMap.put("hasSource", String.valueOf(paramInt));
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "NetSceneLuckyMoneyGetConfig request");
    setRequestData(localHashMap);
    AppMethodBeat.o(65289);
  }
  
  public String czD()
  {
    return "/cgi-bin/mmpay-bin/operationwxhb";
  }
  
  public final void efk()
  {
    AppMethodBeat.i(213320);
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(ar.a.OiK, Integer.valueOf(0))).intValue();
    int j = ((b)g.af(b.class)).a(b.a.rXc, 0);
    if ((Util.isEqual(i, 1)) || (Util.isEqual(j, 1)))
    {
      this.yXu = 1;
      this.yXv = 1;
      this.yXs = 1;
      this.yXt = 1;
    }
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "localSwitch() enableNormalSelfie:%s enableNormalAllExpression:%s enableSelfie:%s enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.yXu), Integer.valueOf(this.yXv), Integer.valueOf(this.yXs), Integer.valueOf(this.yXt) });
    AppMethodBeat.o(213320);
  }
  
  public int getType()
  {
    return 1554;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65290);
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
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
        this.yPA = paramJSONObject.optString("currencyUint");
        this.yPB = paramJSONObject.optString("currencyWording");
        this.dUb = paramJSONObject.optString("unique_id");
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.qww + ";currencyUint=" + this.yPA + ";currencyWording=" + this.yPB + ";uniqueId=" + this.dUb);
        paramString = new o();
        paramString.yUR = paramJSONObject.optString("groupHint");
        paramString.yUS = paramJSONObject.optString("personalHint");
        paramString.yPy = (paramJSONObject.optLong("totalAmount", 200000L) / 100.0D);
        paramString.yPv = paramJSONObject.optInt("totalNum", 100);
        paramString.yPw = (paramJSONObject.optLong("perPersonMaxValue", 20000L) / 100.0D);
        paramString.yPz = (paramJSONObject.optLong("perGroupMaxValue", 20000L) / 100.0D);
        paramString.yPx = (paramJSONObject.optLong("perMinValue", 1L) / 100.0D);
        paramString.yUT = paramJSONObject.optInt("payShowBGFlag");
        paramString.yUY = paramJSONObject.optBoolean("enableExclusiveHb");
        paramString.qww = this.qww;
        paramString.yPA = this.yPA;
        paramString.yPB = this.yPB;
        paramString.yUU = paramJSONObject.optString("foreignFaqUrl");
        paramString.yUV = paramJSONObject.optString("foreignHongBaoName");
        paramString.yUW = paramJSONObject.optString("showSourceAndMac");
        paramString.yUX = paramJSONObject.optString("coverinfo");
        Object localObject = paramJSONObject.optString("cover_jumpaction");
        if (!Util.isNullOrNil((String)localObject)) {
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "cover_jumpaction: %s", new Object[] { localObject });
        }
        try
        {
          localObject = new JSONObject((String)localObject);
          l locall = new l();
          locall.pTt = ((JSONObject)localObject).optBoolean("is_show");
          locall.dQx = ((JSONObject)localObject).optString("wording");
          locall.qGB = ((JSONObject)localObject).optString("icon_url");
          locall.yUL = ((JSONObject)localObject).optString("action_app_username");
          locall.pTI = ((JSONObject)localObject).optInt("action_type", 0);
          locall.yUK = ((JSONObject)localObject).optString("action_url");
          paramString.yUZ = locall;
          Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s, enableExclusiveHb: %s", new Object[] { paramString.yUU, paramString.yUV, Boolean.valueOf(paramString.yUY) });
          a.eex();
          localObject = a.eey();
          ((p)localObject).yPZ = paramString;
          ((p)localObject).efd();
          Log.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + ((p)localObject).yPZ.yPy + " maxTotalNum:" + ((p)localObject).yPZ.yPv + " perGroupMaxValue:" + ((p)localObject).yPZ.yPz + " perMinValue:" + ((p)localObject).yPZ.yPx + " perPersonMaxValue:" + ((p)localObject).yPZ.yPw);
        }
        catch (JSONException localJSONException)
        {
          try
          {
            paramString = new String(((p)localObject).yPZ.toByteArray(), "ISO-8859-1");
            g.aAi();
            g.aAh().azQ().set(356355, paramString);
            g.aAi();
            g.aAh().azQ().gBI();
            this.yXo = ac.ba(paramJSONObject.optJSONObject("operationHeader"));
            this.yVs = ac.ba(paramJSONObject.optJSONObject("operationTail"));
            this.yXp = ac.ba(paramJSONObject.optJSONObject("operationNext"));
            this.yXq = ac.ba(paramJSONObject.optJSONObject("operationMiddle"));
            paramInt = paramJSONObject.optInt("sceneSwitch");
            g.aAi();
            g.aAh().azQ().set(ar.a.NTg, Integer.valueOf(paramInt));
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(paramInt)));
            this.yXr = paramJSONObject.optInt("scenePicSwitch");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.yXr);
            this.yXt = paramJSONObject.optInt("enableYearHbExpression");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableYearHbExpression:%s", new Object[] { Integer.valueOf(this.yXt) });
            this.yXs = paramJSONObject.optInt("enableSelfie");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableSelfIe:" + this.yXs);
            this.yXu = paramJSONObject.optInt("enableNormalSelfie");
            this.yXv = paramJSONObject.optInt("enableNormalAllExpression");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", new Object[] { Integer.valueOf(this.yXu), Integer.valueOf(this.yXv) });
            paramInt = paramJSONObject.optInt("enableWeishiHb");
            g.aAi();
            g.aAh().azQ().set(ar.a.NTi, Integer.valueOf(paramInt));
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "weishiHbSwitch:".concat(String.valueOf(paramInt)));
            this.yPK = paramJSONObject.optString("wishing");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[] { this.yPK });
            paramString = paramJSONObject.optJSONArray("yearMess");
            if ((paramString != null) && (paramString.length() > 0))
            {
              Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + paramString.length());
              this.yXw = new LinkedList();
              paramInt = 0;
              for (;;)
              {
                if (paramInt < paramString.length())
                {
                  paramJSONObject = paramString.optJSONObject(paramInt);
                  localObject = new ab();
                  ((ab)localObject).yWB = paramJSONObject.optInt("yearAmount", 0);
                  ((ab)localObject).yWC = paramJSONObject.optString("yearWish");
                  this.yXw.add(localObject);
                  paramInt += 1;
                  continue;
                  bool = false;
                  break;
                  localJSONException = localJSONException;
                  Log.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyGetConfig", localJSONException, "", new Object[0]);
                }
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
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
            efk();
            AppMethodBeat.o(65290);
            return;
          }
        }
      }
    }
    Log.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + paramInt + ", errMsg:" + paramString);
    AppMethodBeat.o(65290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.aq
 * JD-Core Version:    0.7.0.1
 */