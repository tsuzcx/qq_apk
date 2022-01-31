package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m
{
  public static f T(JSONObject paramJSONObject)
  {
    f localf = new f();
    if (paramJSONObject != null)
    {
      localf.lPR = paramJSONObject.optInt("hbType");
      localf.cec = paramJSONObject.optInt("hbStatus");
      localf.lPS = paramJSONObject.optString("statusMess");
      localf.lPT = paramJSONObject.optString("gameMess");
      localf.lLm = paramJSONObject.optString("wishing");
      localf.lPU = paramJSONObject.optString("sendNick");
      localf.lPV = paramJSONObject.optString("sendHeadImg");
      localf.lMg = paramJSONObject.optString("sendId");
      localf.lPW = paramJSONObject.optString("adMessage");
      localf.lPX = paramJSONObject.optString("adUrl");
      localf.ceq = paramJSONObject.optLong("amount");
      localf.lPY = paramJSONObject.optLong("recNum");
      localf.lPZ = paramJSONObject.optLong("recAmount");
      localf.iHi = paramJSONObject.optInt("totalNum");
      localf.lQa = paramJSONObject.optLong("totalAmount");
      localf.lQb = paramJSONObject.optString("receiveId");
      localf.lQc = paramJSONObject.optInt("hasWriteAnswer");
      localf.lQd = paramJSONObject.optInt("isSender");
      localf.lQe = paramJSONObject.optInt("isContinue");
      localf.lQf = paramJSONObject.optString("headTitle");
      localf.ced = paramJSONObject.optInt("receiveStatus");
      localf.lQg = paramJSONObject.optInt("canShare");
      localf.lNp = paramJSONObject.optInt("jumpChange");
      localf.lNr = paramJSONObject.optString("changeWording");
      localf.lNq = paramJSONObject.optString("changeUrl");
      localf.lQm = paramJSONObject.optInt("hbKind");
      localf.lNs = paramJSONObject.optString("externMess");
      localf.lQp = paramJSONObject.optString("sendUserName");
      if ((bk.bl(localf.lPU)) && (!bk.bl(localf.lQp))) {
        localf.lPU = ((b)g.r(b.class)).gV(localf.lQp);
      }
      localf.lQh = new a();
      Object localObject = paramJSONObject.optJSONObject("atomicFunc");
      if (localObject != null)
      {
        localf.lQh.dwF = ((JSONObject)localObject).optInt("enable");
        localf.lQh.lPF = ((JSONObject)localObject).optString("fissionContent");
        localf.lQh.lPE = ((JSONObject)localObject).optString("fissionUrl");
      }
      localf.lQi = new LinkedList();
      localObject = paramJSONObject.optJSONArray("operationHeader");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localf.lQi.add(V(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      localf.lQk = paramJSONObject.optString("watermark");
      localf.lQl = paramJSONObject.optString("context");
      localf.lQo = paramJSONObject.optString("contextMd5");
      localf.resourceId = paramJSONObject.optInt("resourceId");
      localf.lQj = V(paramJSONObject.optJSONObject("operationTail"));
      localf.lQn = U(paramJSONObject);
      localf.lQq = paramJSONObject.optInt("jumpChangeType");
      localf.lQr = paramJSONObject.optString("changeIconUrl");
    }
    return localf;
  }
  
  private static LinkedList<n> U(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("record");
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        n localn = new n();
        if (localJSONObject != null)
        {
          localn.lQL = localJSONObject.optString("receiveName");
          localn.lQM = localJSONObject.optString("receiveHeadImg");
          localn.lQy = localJSONObject.optLong("receiveAmount");
          localn.lQz = localJSONObject.optString("receiveTime");
          localn.lQN = localJSONObject.optString("answer");
          localn.lQb = localJSONObject.optString("receiveId");
          localn.lQO = localJSONObject.optString("gameTips");
          localn.userName = localJSONObject.optString("userName");
          if ((bk.bl(localn.lQL)) && (!bk.bl(localn.userName))) {
            localn.lQL = ((b)g.r(b.class)).gV(localn.userName);
          }
        }
        localLinkedList.add(localn);
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public static ai V(JSONObject paramJSONObject)
  {
    ai localai = new ai();
    if (paramJSONObject != null)
    {
      localai.dwF = paramJSONObject.optInt("enable", 0);
      localai.content = paramJSONObject.optString("content");
      localai.iconUrl = paramJSONObject.optString("iconUrl");
      localai.type = paramJSONObject.optString("type");
      localai.name = paramJSONObject.optString("name");
      localai.lRN = paramJSONObject.optInt("ossKey");
      localai.lRO = paramJSONObject.optInt("focus");
    }
    return localai;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.m
 * JD-Core Version:    0.7.0.1
 */