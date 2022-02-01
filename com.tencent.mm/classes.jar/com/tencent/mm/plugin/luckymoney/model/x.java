package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class x
{
  public static l aD(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65241);
    l locall = new l();
    if (paramJSONObject != null)
    {
      locall.dPc = paramJSONObject.optInt("hbType");
      locall.dPd = paramJSONObject.optInt("hbStatus");
      locall.vAh = paramJSONObject.optString("statusMess");
      locall.vAi = paramJSONObject.optString("gameMess");
      locall.vvw = paramJSONObject.optString("wishing");
      locall.vAj = paramJSONObject.optString("sendNick");
      locall.vAk = paramJSONObject.optString("sendHeadImg");
      locall.vwq = paramJSONObject.optString("sendId");
      locall.vAl = paramJSONObject.optString("adMessage");
      locall.vAm = paramJSONObject.optString("adUrl");
      locall.dPq = paramJSONObject.optLong("amount");
      locall.vAn = paramJSONObject.optLong("recNum");
      locall.vAo = paramJSONObject.optLong("recAmount");
      locall.pgV = paramJSONObject.optInt("totalNum");
      locall.vAp = paramJSONObject.optLong("totalAmount");
      locall.vAq = paramJSONObject.optString("receiveId");
      locall.vAr = paramJSONObject.optInt("hasWriteAnswer");
      locall.vAs = paramJSONObject.optInt("isSender");
      locall.vAt = paramJSONObject.optInt("isContinue");
      locall.vAu = paramJSONObject.optString("headTitle");
      locall.dPe = paramJSONObject.optInt("receiveStatus");
      locall.vAv = paramJSONObject.optInt("canShare");
      locall.vxz = paramJSONObject.optInt("jumpChange");
      locall.vxB = paramJSONObject.optString("changeWording");
      locall.vxA = paramJSONObject.optString("changeUrl");
      locall.vAB = paramJSONObject.optInt("hbKind");
      locall.vxC = paramJSONObject.optString("externMess");
      locall.vAE = paramJSONObject.optString("sendUserName");
      if ((bu.isNullOrNil(locall.vAj)) && (!bu.isNullOrNil(locall.vAE))) {
        locall.vAj = ((b)g.ab(b.class)).zP(locall.vAE);
      }
      locall.vAw = new f();
      Object localObject = paramJSONObject.optJSONObject("atomicFunc");
      if (localObject != null)
      {
        locall.vAw.gaV = ((JSONObject)localObject).optInt("enable");
        locall.vAw.vzS = ((JSONObject)localObject).optString("fissionContent");
        locall.vAw.vzR = ((JSONObject)localObject).optString("fissionUrl");
      }
      locall.vAx = new LinkedList();
      localObject = paramJSONObject.optJSONArray("operationHeader");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          locall.vAx.add(aF(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      locall.vAz = paramJSONObject.optString("watermark");
      locall.vAA = paramJSONObject.optString("context");
      locall.vAD = paramJSONObject.optString("contextMd5");
      locall.resourceId = paramJSONObject.optInt("resourceId");
      locall.vAy = aF(paramJSONObject.optJSONObject("operationTail"));
      locall.vAC = aE(paramJSONObject);
      locall.vAF = paramJSONObject.optInt("jumpChangeType");
      locall.vAG = paramJSONObject.optString("changeIconUrl");
      locall.vAH = paramJSONObject.optString("showSourceOpen");
    }
    AppMethodBeat.o(65241);
    return locall;
  }
  
  private static LinkedList<y> aE(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65242);
    paramJSONObject = paramJSONObject.optJSONArray("record");
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        y localy = new y();
        if (localJSONObject != null)
        {
          localy.vBF = localJSONObject.optString("receiveName");
          localy.vBG = localJSONObject.optString("receiveHeadImg");
          localy.vBs = localJSONObject.optLong("receiveAmount");
          localy.vBt = localJSONObject.optString("receiveTime");
          localy.vBH = localJSONObject.optString("answer");
          localy.vAq = localJSONObject.optString("receiveId");
          localy.vBI = localJSONObject.optString("gameTips");
          localy.userName = localJSONObject.optString("userName");
          if ((bu.isNullOrNil(localy.vBF)) && (!bu.isNullOrNil(localy.userName))) {
            localy.vBF = ((b)g.ab(b.class)).zP(localy.userName);
          }
        }
        localLinkedList.add(localy);
        i += 1;
      }
    }
    AppMethodBeat.o(65242);
    return localLinkedList;
  }
  
  public static au aF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65243);
    au localau = new au();
    if (paramJSONObject != null)
    {
      localau.gaV = paramJSONObject.optInt("enable", 0);
      localau.content = paramJSONObject.optString("content");
      localau.iconUrl = paramJSONObject.optString("iconUrl");
      localau.type = paramJSONObject.optString("type");
      localau.name = paramJSONObject.optString("name");
      localau.vCR = paramJSONObject.optInt("ossKey");
      localau.vCS = paramJSONObject.optInt("focus");
    }
    AppMethodBeat.o(65243);
    return localau;
  }
  
  public static bom aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65244);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(65244);
      return null;
    }
    bom localbom = new bom();
    localbom.subType = paramJSONObject.optInt("subType", -1);
    localbom.HbA = paramJSONObject.optString("corpName");
    localbom.Gta = paramJSONObject.optString("materialId");
    localbom.HbC = paramJSONObject.optString("expire_desc");
    localbom.HbD = paramJSONObject.optInt("is_expired");
    localbom.HbI = paramJSONObject.optInt("detail_link_type");
    localbom.HbJ = paramJSONObject.optString("detail_link_appname");
    localbom.HbK = paramJSONObject.optString("detail_link_url");
    localbom.HbL = paramJSONObject.optString("detail_link_title");
    localbom.HbM = paramJSONObject.optString("exchange_title");
    localbom.HbN = paramJSONObject.optString("exchange_url");
    localbom.HbO = paramJSONObject.optInt("has_source");
    localbom.GWP = paramJSONObject.optLong("last_obtain_time");
    localbom.cPu = paramJSONObject.optInt("disable");
    localbom.HbP = paramJSONObject.optString("disable_text");
    paramJSONObject = paramJSONObject.optJSONObject("sourceObject");
    if (paramJSONObject != null)
    {
      bon localbon = new bon();
      localbon.HbR = paramJSONObject.optString("bubbleImage");
      localbon.HbT = paramJSONObject.optString("bubbleImageMd5");
      localbon.HbQ = paramJSONObject.optString("corpLogo");
      localbon.HbW = paramJSONObject.optString("corpLogoMd5");
      localbon.hnD = paramJSONObject.optString("coverImage");
      localbon.HbU = paramJSONObject.optString("coverImageMd5");
      localbon.HbS = paramJSONObject.optString("detailImage");
      localbon.HbV = paramJSONObject.optString("detailImageMd5");
      localbom.HbB = localbon;
    }
    AppMethodBeat.o(65244);
    return localbom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.x
 * JD-Core Version:    0.7.0.1
 */