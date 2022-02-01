package com.tencent.mm.plugin.luckymoney.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.ax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends ax
{
  public String Kun;
  public int Kup;
  public LinkedList<ad> Kuz;
  public int Kvn;
  public String Kvo;
  public String Kvp;
  public int Kvq;
  
  public f()
  {
    AppMethodBeat.i(283895);
    this.Kvn = 2;
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigHK", "request " + this.Kvn);
    HashMap localHashMap = new HashMap();
    localHashMap.put("currency", this.Kvn);
    setRequestData(localHashMap);
    AppMethodBeat.o(283895);
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/h5operationwxhb";
  }
  
  public final int getType()
  {
    return 2832;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(283899);
    Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigHK", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    if (paramInt == 0)
    {
      this.Kup = paramJSONObject.optInt("randomAmount");
      this.Kun = paramJSONObject.optString("randomWishing");
      this.Kvo = paramJSONObject.optString("sceneName");
      this.Kvp = paramJSONObject.optString("sceneBackgroup");
      this.Kvq = paramJSONObject.optInt("sceneSwitch");
      h.baF();
      h.baE().ban().set(at.a.acIA, Integer.valueOf(this.Kvq));
      h.baF();
      h.baE().ban().set(at.a.acIB, this.Kvo);
      paramString = paramJSONObject.optJSONArray("yearMess");
      if ((paramString != null) && (paramString.length() > 0))
      {
        this.Kuz = new LinkedList();
        paramInt = 0;
        while (paramInt < paramString.length())
        {
          paramJSONObject = paramString.optJSONObject(paramInt);
          ad localad = new ad();
          localad.KtA = paramJSONObject.optInt("yearAmount", 0);
          localad.KtB = paramJSONObject.optString("yearWish");
          this.Kuz.add(localad);
          paramInt += 1;
        }
        AppMethodBeat.o(283899);
        return;
      }
      Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigHK", "yearMessJson is empty!");
    }
    AppMethodBeat.o(283899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a.f
 * JD-Core Version:    0.7.0.1
 */