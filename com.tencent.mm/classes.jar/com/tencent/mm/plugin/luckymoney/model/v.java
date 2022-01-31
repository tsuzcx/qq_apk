package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class v
{
  public static k ae(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42351);
    k localk = new k();
    if (paramJSONObject != null)
    {
      localk.cMP = paramJSONObject.optInt("hbType");
      localk.cMQ = paramJSONObject.optInt("hbStatus");
      localk.onq = paramJSONObject.optString("statusMess");
      localk.onr = paramJSONObject.optString("gameMess");
      localk.oiG = paramJSONObject.optString("wishing");
      localk.ons = paramJSONObject.optString("sendNick");
      localk.ont = paramJSONObject.optString("sendHeadImg");
      localk.ojA = paramJSONObject.optString("sendId");
      localk.onu = paramJSONObject.optString("adMessage");
      localk.onv = paramJSONObject.optString("adUrl");
      localk.cNd = paramJSONObject.optLong("amount");
      localk.onw = paramJSONObject.optLong("recNum");
      localk.onx = paramJSONObject.optLong("recAmount");
      localk.kNn = paramJSONObject.optInt("totalNum");
      localk.ony = paramJSONObject.optLong("totalAmount");
      localk.onz = paramJSONObject.optString("receiveId");
      localk.onA = paramJSONObject.optInt("hasWriteAnswer");
      localk.onB = paramJSONObject.optInt("isSender");
      localk.onC = paramJSONObject.optInt("isContinue");
      localk.onD = paramJSONObject.optString("headTitle");
      localk.cMR = paramJSONObject.optInt("receiveStatus");
      localk.onE = paramJSONObject.optInt("canShare");
      localk.okJ = paramJSONObject.optInt("jumpChange");
      localk.okL = paramJSONObject.optString("changeWording");
      localk.okK = paramJSONObject.optString("changeUrl");
      localk.onK = paramJSONObject.optInt("hbKind");
      localk.okM = paramJSONObject.optString("externMess");
      localk.onN = paramJSONObject.optString("sendUserName");
      if ((bo.isNullOrNil(localk.ons)) && (!bo.isNullOrNil(localk.onN))) {
        localk.ons = ((b)g.E(b.class)).nE(localk.onN);
      }
      localk.onF = new e();
      Object localObject = paramJSONObject.optJSONObject("atomicFunc");
      if (localObject != null)
      {
        localk.onF.eoD = ((JSONObject)localObject).optInt("enable");
        localk.onF.onb = ((JSONObject)localObject).optString("fissionContent");
        localk.onF.ona = ((JSONObject)localObject).optString("fissionUrl");
      }
      localk.onG = new LinkedList();
      localObject = paramJSONObject.optJSONArray("operationHeader");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localk.onG.add(ag(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      localk.onI = paramJSONObject.optString("watermark");
      localk.onJ = paramJSONObject.optString("context");
      localk.onM = paramJSONObject.optString("contextMd5");
      localk.resourceId = paramJSONObject.optInt("resourceId");
      localk.onH = ag(paramJSONObject.optJSONObject("operationTail"));
      localk.onL = af(paramJSONObject);
      localk.onO = paramJSONObject.optInt("jumpChangeType");
      localk.onP = paramJSONObject.optString("changeIconUrl");
      localk.onQ = paramJSONObject.optString("showSourceOpen");
    }
    AppMethodBeat.o(42351);
    return localk;
  }
  
  private static LinkedList<w> af(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42352);
    paramJSONObject = paramJSONObject.optJSONArray("record");
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        w localw = new w();
        if (localJSONObject != null)
        {
          localw.ooB = localJSONObject.optString("receiveName");
          localw.ooC = localJSONObject.optString("receiveHeadImg");
          localw.ooo = localJSONObject.optLong("receiveAmount");
          localw.oop = localJSONObject.optString("receiveTime");
          localw.ooD = localJSONObject.optString("answer");
          localw.onz = localJSONObject.optString("receiveId");
          localw.ooE = localJSONObject.optString("gameTips");
          localw.userName = localJSONObject.optString("userName");
          if ((bo.isNullOrNil(localw.ooB)) && (!bo.isNullOrNil(localw.userName))) {
            localw.ooB = ((b)g.E(b.class)).nE(localw.userName);
          }
        }
        localLinkedList.add(localw);
        i += 1;
      }
    }
    AppMethodBeat.o(42352);
    return localLinkedList;
  }
  
  public static as ag(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42353);
    as localas = new as();
    if (paramJSONObject != null)
    {
      localas.eoD = paramJSONObject.optInt("enable", 0);
      localas.content = paramJSONObject.optString("content");
      localas.iconUrl = paramJSONObject.optString("iconUrl");
      localas.type = paramJSONObject.optString("type");
      localas.name = paramJSONObject.optString("name");
      localas.opO = paramJSONObject.optInt("ossKey");
      localas.opP = paramJSONObject.optInt("focus");
    }
    AppMethodBeat.o(42353);
    return localas;
  }
  
  public static aus ah(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42354);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(42354);
      return null;
    }
    aus localaus = new aus();
    localaus.subType = paramJSONObject.optInt("subType", -1);
    localaus.xjL = paramJSONObject.optString("corpName");
    localaus.materialId = paramJSONObject.optString("materialId");
    localaus.xjN = paramJSONObject.optString("expire_desc");
    localaus.xjO = paramJSONObject.optInt("is_expired");
    paramJSONObject = paramJSONObject.optJSONObject("sourceObject");
    if (paramJSONObject != null)
    {
      aut localaut = new aut();
      localaut.xjV = paramJSONObject.optString("bubbleImage");
      localaut.xjY = paramJSONObject.optString("bubbleImageMd5");
      localaut.xjU = paramJSONObject.optString("corpLogo");
      localaut.xkb = paramJSONObject.optString("corpLogoMd5");
      localaut.xjW = paramJSONObject.optString("coverImage");
      localaut.xjZ = paramJSONObject.optString("coverImageMd5");
      localaut.xjX = paramJSONObject.optString("detailImage");
      localaut.xka = paramJSONObject.optString("detailImageMd5");
      localaus.xjM = localaut;
    }
    AppMethodBeat.o(42354);
    return localaus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.v
 * JD-Core Version:    0.7.0.1
 */