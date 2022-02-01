package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class x
{
  public static l at(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65241);
    l locall = new l();
    if (paramJSONObject != null)
    {
      locall.dDN = paramJSONObject.optInt("hbType");
      locall.dDO = paramJSONObject.optInt("hbStatus");
      locall.tdh = paramJSONObject.optString("statusMess");
      locall.tdi = paramJSONObject.optString("gameMess");
      locall.sYt = paramJSONObject.optString("wishing");
      locall.tdj = paramJSONObject.optString("sendNick");
      locall.tdk = paramJSONObject.optString("sendHeadImg");
      locall.sZn = paramJSONObject.optString("sendId");
      locall.tdl = paramJSONObject.optString("adMessage");
      locall.tdm = paramJSONObject.optString("adUrl");
      locall.dEb = paramJSONObject.optLong("amount");
      locall.tdn = paramJSONObject.optLong("recNum");
      locall.tdo = paramJSONObject.optLong("recAmount");
      locall.nTB = paramJSONObject.optInt("totalNum");
      locall.tdp = paramJSONObject.optLong("totalAmount");
      locall.tdq = paramJSONObject.optString("receiveId");
      locall.tdr = paramJSONObject.optInt("hasWriteAnswer");
      locall.tds = paramJSONObject.optInt("isSender");
      locall.tdt = paramJSONObject.optInt("isContinue");
      locall.tdu = paramJSONObject.optString("headTitle");
      locall.dDP = paramJSONObject.optInt("receiveStatus");
      locall.tdv = paramJSONObject.optInt("canShare");
      locall.tax = paramJSONObject.optInt("jumpChange");
      locall.taz = paramJSONObject.optString("changeWording");
      locall.tay = paramJSONObject.optString("changeUrl");
      locall.tdB = paramJSONObject.optInt("hbKind");
      locall.taA = paramJSONObject.optString("externMess");
      locall.tdE = paramJSONObject.optString("sendUserName");
      if ((bt.isNullOrNil(locall.tdj)) && (!bt.isNullOrNil(locall.tdE))) {
        locall.tdj = ((b)g.ab(b.class)).sh(locall.tdE);
      }
      locall.tdw = new f();
      Object localObject = paramJSONObject.optJSONObject("atomicFunc");
      if (localObject != null)
      {
        locall.tdw.fBI = ((JSONObject)localObject).optInt("enable");
        locall.tdw.tcS = ((JSONObject)localObject).optString("fissionContent");
        locall.tdw.tcR = ((JSONObject)localObject).optString("fissionUrl");
      }
      locall.tdx = new LinkedList();
      localObject = paramJSONObject.optJSONArray("operationHeader");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          locall.tdx.add(av(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      locall.tdz = paramJSONObject.optString("watermark");
      locall.tdA = paramJSONObject.optString("context");
      locall.tdD = paramJSONObject.optString("contextMd5");
      locall.resourceId = paramJSONObject.optInt("resourceId");
      locall.tdy = av(paramJSONObject.optJSONObject("operationTail"));
      locall.tdC = au(paramJSONObject);
      locall.tdF = paramJSONObject.optInt("jumpChangeType");
      locall.tdG = paramJSONObject.optString("changeIconUrl");
      locall.tdH = paramJSONObject.optString("showSourceOpen");
    }
    AppMethodBeat.o(65241);
    return locall;
  }
  
  private static LinkedList<y> au(JSONObject paramJSONObject)
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
          localy.teF = localJSONObject.optString("receiveName");
          localy.teG = localJSONObject.optString("receiveHeadImg");
          localy.tes = localJSONObject.optLong("receiveAmount");
          localy.tet = localJSONObject.optString("receiveTime");
          localy.teH = localJSONObject.optString("answer");
          localy.tdq = localJSONObject.optString("receiveId");
          localy.teI = localJSONObject.optString("gameTips");
          localy.userName = localJSONObject.optString("userName");
          if ((bt.isNullOrNil(localy.teF)) && (!bt.isNullOrNil(localy.userName))) {
            localy.teF = ((b)g.ab(b.class)).sh(localy.userName);
          }
        }
        localLinkedList.add(localy);
        i += 1;
      }
    }
    AppMethodBeat.o(65242);
    return localLinkedList;
  }
  
  public static au av(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65243);
    au localau = new au();
    if (paramJSONObject != null)
    {
      localau.fBI = paramJSONObject.optInt("enable", 0);
      localau.content = paramJSONObject.optString("content");
      localau.iconUrl = paramJSONObject.optString("iconUrl");
      localau.type = paramJSONObject.optString("type");
      localau.name = paramJSONObject.optString("name");
      localau.tfT = paramJSONObject.optInt("ossKey");
      localau.tfU = paramJSONObject.optInt("focus");
    }
    AppMethodBeat.o(65243);
    return localau;
  }
  
  public static bfu aw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65244);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(65244);
      return null;
    }
    bfu localbfu = new bfu();
    localbfu.subType = paramJSONObject.optInt("subType", -1);
    localbfu.DDg = paramJSONObject.optString("corpName");
    localbfu.Daf = paramJSONObject.optString("materialId");
    localbfu.DDi = paramJSONObject.optString("expire_desc");
    localbfu.DDj = paramJSONObject.optInt("is_expired");
    localbfu.DDo = paramJSONObject.optInt("detail_link_type");
    localbfu.DDp = paramJSONObject.optString("detail_link_appname");
    localbfu.DDq = paramJSONObject.optString("detail_link_url");
    localbfu.DDr = paramJSONObject.optString("detail_link_title");
    localbfu.DDs = paramJSONObject.optString("exchange_title");
    localbfu.DDt = paramJSONObject.optString("exchange_url");
    localbfu.DDu = paramJSONObject.optInt("has_source");
    localbfu.Dyw = paramJSONObject.optLong("last_obtain_time");
    localbfu.cGx = paramJSONObject.optInt("disable");
    localbfu.DDv = paramJSONObject.optString("disable_text");
    paramJSONObject = paramJSONObject.optJSONObject("sourceObject");
    if (paramJSONObject != null)
    {
      bfv localbfv = new bfv();
      localbfv.DDx = paramJSONObject.optString("bubbleImage");
      localbfv.DDz = paramJSONObject.optString("bubbleImageMd5");
      localbfv.DDw = paramJSONObject.optString("corpLogo");
      localbfv.DDC = paramJSONObject.optString("corpLogoMd5");
      localbfv.gsg = paramJSONObject.optString("coverImage");
      localbfv.DDA = paramJSONObject.optString("coverImageMd5");
      localbfv.DDy = paramJSONObject.optString("detailImage");
      localbfv.DDB = paramJSONObject.optString("detailImageMd5");
      localbfu.DDh = localbfv;
    }
    AppMethodBeat.o(65244);
    return localbfu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.x
 * JD-Core Version:    0.7.0.1
 */