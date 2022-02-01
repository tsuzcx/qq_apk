package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class x
{
  public static l au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65241);
    l locall = new l();
    if (paramJSONObject != null)
    {
      locall.dBz = paramJSONObject.optInt("hbType");
      locall.dBA = paramJSONObject.optInt("hbStatus");
      locall.ulw = paramJSONObject.optString("statusMess");
      locall.ulx = paramJSONObject.optString("gameMess");
      locall.ugH = paramJSONObject.optString("wishing");
      locall.uly = paramJSONObject.optString("sendNick");
      locall.ulz = paramJSONObject.optString("sendHeadImg");
      locall.uhB = paramJSONObject.optString("sendId");
      locall.ulA = paramJSONObject.optString("adMessage");
      locall.ulB = paramJSONObject.optString("adUrl");
      locall.dBN = paramJSONObject.optLong("amount");
      locall.ulC = paramJSONObject.optLong("recNum");
      locall.ulD = paramJSONObject.optLong("recAmount");
      locall.owW = paramJSONObject.optInt("totalNum");
      locall.ulE = paramJSONObject.optLong("totalAmount");
      locall.ulF = paramJSONObject.optString("receiveId");
      locall.ulG = paramJSONObject.optInt("hasWriteAnswer");
      locall.ulH = paramJSONObject.optInt("isSender");
      locall.ulI = paramJSONObject.optInt("isContinue");
      locall.ulJ = paramJSONObject.optString("headTitle");
      locall.dBB = paramJSONObject.optInt("receiveStatus");
      locall.ulK = paramJSONObject.optInt("canShare");
      locall.uiM = paramJSONObject.optInt("jumpChange");
      locall.uiO = paramJSONObject.optString("changeWording");
      locall.uiN = paramJSONObject.optString("changeUrl");
      locall.ulQ = paramJSONObject.optInt("hbKind");
      locall.uiP = paramJSONObject.optString("externMess");
      locall.ulT = paramJSONObject.optString("sendUserName");
      if ((bs.isNullOrNil(locall.uly)) && (!bs.isNullOrNil(locall.ulT))) {
        locall.uly = ((b)g.ab(b.class)).wk(locall.ulT);
      }
      locall.ulL = new f();
      Object localObject = paramJSONObject.optJSONObject("atomicFunc");
      if (localObject != null)
      {
        locall.ulL.fFp = ((JSONObject)localObject).optInt("enable");
        locall.ulL.ulh = ((JSONObject)localObject).optString("fissionContent");
        locall.ulL.ulg = ((JSONObject)localObject).optString("fissionUrl");
      }
      locall.ulM = new LinkedList();
      localObject = paramJSONObject.optJSONArray("operationHeader");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          locall.ulM.add(aw(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      locall.ulO = paramJSONObject.optString("watermark");
      locall.ulP = paramJSONObject.optString("context");
      locall.ulS = paramJSONObject.optString("contextMd5");
      locall.resourceId = paramJSONObject.optInt("resourceId");
      locall.ulN = aw(paramJSONObject.optJSONObject("operationTail"));
      locall.ulR = av(paramJSONObject);
      locall.ulU = paramJSONObject.optInt("jumpChangeType");
      locall.ulV = paramJSONObject.optString("changeIconUrl");
      locall.ulW = paramJSONObject.optString("showSourceOpen");
    }
    AppMethodBeat.o(65241);
    return locall;
  }
  
  private static LinkedList<y> av(JSONObject paramJSONObject)
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
          localy.umU = localJSONObject.optString("receiveName");
          localy.umV = localJSONObject.optString("receiveHeadImg");
          localy.umH = localJSONObject.optLong("receiveAmount");
          localy.umI = localJSONObject.optString("receiveTime");
          localy.umW = localJSONObject.optString("answer");
          localy.ulF = localJSONObject.optString("receiveId");
          localy.umX = localJSONObject.optString("gameTips");
          localy.userName = localJSONObject.optString("userName");
          if ((bs.isNullOrNil(localy.umU)) && (!bs.isNullOrNil(localy.userName))) {
            localy.umU = ((b)g.ab(b.class)).wk(localy.userName);
          }
        }
        localLinkedList.add(localy);
        i += 1;
      }
    }
    AppMethodBeat.o(65242);
    return localLinkedList;
  }
  
  public static au aw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65243);
    au localau = new au();
    if (paramJSONObject != null)
    {
      localau.fFp = paramJSONObject.optInt("enable", 0);
      localau.content = paramJSONObject.optString("content");
      localau.iconUrl = paramJSONObject.optString("iconUrl");
      localau.type = paramJSONObject.optString("type");
      localau.name = paramJSONObject.optString("name");
      localau.uoi = paramJSONObject.optInt("ossKey");
      localau.uoj = paramJSONObject.optInt("focus");
    }
    AppMethodBeat.o(65243);
    return localau;
  }
  
  public static bjm ax(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65244);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(65244);
      return null;
    }
    bjm localbjm = new bjm();
    localbjm.subType = paramJSONObject.optInt("subType", -1);
    localbjm.EYC = paramJSONObject.optString("corpName");
    localbjm.Etc = paramJSONObject.optString("materialId");
    localbjm.EYE = paramJSONObject.optString("expire_desc");
    localbjm.EYF = paramJSONObject.optInt("is_expired");
    localbjm.EYK = paramJSONObject.optInt("detail_link_type");
    localbjm.EYL = paramJSONObject.optString("detail_link_appname");
    localbjm.EYM = paramJSONObject.optString("detail_link_url");
    localbjm.EYN = paramJSONObject.optString("detail_link_title");
    localbjm.EYO = paramJSONObject.optString("exchange_title");
    localbjm.EYP = paramJSONObject.optString("exchange_url");
    localbjm.EYQ = paramJSONObject.optInt("has_source");
    localbjm.ETS = paramJSONObject.optLong("last_obtain_time");
    localbjm.cDF = paramJSONObject.optInt("disable");
    localbjm.EYR = paramJSONObject.optString("disable_text");
    paramJSONObject = paramJSONObject.optJSONObject("sourceObject");
    if (paramJSONObject != null)
    {
      bjn localbjn = new bjn();
      localbjn.EYT = paramJSONObject.optString("bubbleImage");
      localbjn.EYV = paramJSONObject.optString("bubbleImageMd5");
      localbjn.EYS = paramJSONObject.optString("corpLogo");
      localbjn.EYY = paramJSONObject.optString("corpLogoMd5");
      localbjn.gSO = paramJSONObject.optString("coverImage");
      localbjn.EYW = paramJSONObject.optString("coverImageMd5");
      localbjn.EYU = paramJSONObject.optString("detailImage");
      localbjn.EYX = paramJSONObject.optString("detailImageMd5");
      localbjm.EYD = localbjn;
    }
    AppMethodBeat.o(65244);
    return localbjm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.x
 * JD-Core Version:    0.7.0.1
 */