package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.sdk.platformtools.bt;
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
      locall.dNM = paramJSONObject.optInt("hbType");
      locall.dNN = paramJSONObject.optInt("hbStatus");
      locall.voc = paramJSONObject.optString("statusMess");
      locall.vod = paramJSONObject.optString("gameMess");
      locall.vjr = paramJSONObject.optString("wishing");
      locall.voe = paramJSONObject.optString("sendNick");
      locall.vof = paramJSONObject.optString("sendHeadImg");
      locall.vkl = paramJSONObject.optString("sendId");
      locall.vog = paramJSONObject.optString("adMessage");
      locall.voh = paramJSONObject.optString("adUrl");
      locall.dOa = paramJSONObject.optLong("amount");
      locall.voi = paramJSONObject.optLong("recNum");
      locall.voj = paramJSONObject.optLong("recAmount");
      locall.par = paramJSONObject.optInt("totalNum");
      locall.vok = paramJSONObject.optLong("totalAmount");
      locall.vol = paramJSONObject.optString("receiveId");
      locall.vom = paramJSONObject.optInt("hasWriteAnswer");
      locall.von = paramJSONObject.optInt("isSender");
      locall.voo = paramJSONObject.optInt("isContinue");
      locall.vop = paramJSONObject.optString("headTitle");
      locall.dNO = paramJSONObject.optInt("receiveStatus");
      locall.voq = paramJSONObject.optInt("canShare");
      locall.vlu = paramJSONObject.optInt("jumpChange");
      locall.vlw = paramJSONObject.optString("changeWording");
      locall.vlv = paramJSONObject.optString("changeUrl");
      locall.vow = paramJSONObject.optInt("hbKind");
      locall.vlx = paramJSONObject.optString("externMess");
      locall.voz = paramJSONObject.optString("sendUserName");
      if ((bt.isNullOrNil(locall.voe)) && (!bt.isNullOrNil(locall.voz))) {
        locall.voe = ((b)g.ab(b.class)).zf(locall.voz);
      }
      locall.vor = new f();
      Object localObject = paramJSONObject.optJSONObject("atomicFunc");
      if (localObject != null)
      {
        locall.vor.fYO = ((JSONObject)localObject).optInt("enable");
        locall.vor.vnN = ((JSONObject)localObject).optString("fissionContent");
        locall.vor.vnM = ((JSONObject)localObject).optString("fissionUrl");
      }
      locall.vos = new LinkedList();
      localObject = paramJSONObject.optJSONArray("operationHeader");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          locall.vos.add(aF(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      locall.vou = paramJSONObject.optString("watermark");
      locall.vov = paramJSONObject.optString("context");
      locall.voy = paramJSONObject.optString("contextMd5");
      locall.resourceId = paramJSONObject.optInt("resourceId");
      locall.vot = aF(paramJSONObject.optJSONObject("operationTail"));
      locall.vox = aE(paramJSONObject);
      locall.voA = paramJSONObject.optInt("jumpChangeType");
      locall.voB = paramJSONObject.optString("changeIconUrl");
      locall.voC = paramJSONObject.optString("showSourceOpen");
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
          localy.vpA = localJSONObject.optString("receiveName");
          localy.vpB = localJSONObject.optString("receiveHeadImg");
          localy.vpn = localJSONObject.optLong("receiveAmount");
          localy.vpo = localJSONObject.optString("receiveTime");
          localy.vpC = localJSONObject.optString("answer");
          localy.vol = localJSONObject.optString("receiveId");
          localy.vpD = localJSONObject.optString("gameTips");
          localy.userName = localJSONObject.optString("userName");
          if ((bt.isNullOrNil(localy.vpA)) && (!bt.isNullOrNil(localy.userName))) {
            localy.vpA = ((b)g.ab(b.class)).zf(localy.userName);
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
      localau.fYO = paramJSONObject.optInt("enable", 0);
      localau.content = paramJSONObject.optString("content");
      localau.iconUrl = paramJSONObject.optString("iconUrl");
      localau.type = paramJSONObject.optString("type");
      localau.name = paramJSONObject.optString("name");
      localau.vqM = paramJSONObject.optInt("ossKey");
      localau.vqN = paramJSONObject.optInt("focus");
    }
    AppMethodBeat.o(65243);
    return localau;
  }
  
  public static bnu aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65244);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(65244);
      return null;
    }
    bnu localbnu = new bnu();
    localbnu.subType = paramJSONObject.optInt("subType", -1);
    localbnu.GHY = paramJSONObject.optString("corpName");
    localbnu.Gat = paramJSONObject.optString("materialId");
    localbnu.GIa = paramJSONObject.optString("expire_desc");
    localbnu.GIb = paramJSONObject.optInt("is_expired");
    localbnu.GIg = paramJSONObject.optInt("detail_link_type");
    localbnu.GIh = paramJSONObject.optString("detail_link_appname");
    localbnu.GIi = paramJSONObject.optString("detail_link_url");
    localbnu.GIj = paramJSONObject.optString("detail_link_title");
    localbnu.GIk = paramJSONObject.optString("exchange_title");
    localbnu.GIl = paramJSONObject.optString("exchange_url");
    localbnu.GIm = paramJSONObject.optInt("has_source");
    localbnu.GDp = paramJSONObject.optLong("last_obtain_time");
    localbnu.cOK = paramJSONObject.optInt("disable");
    localbnu.GIn = paramJSONObject.optString("disable_text");
    paramJSONObject = paramJSONObject.optJSONObject("sourceObject");
    if (paramJSONObject != null)
    {
      bnv localbnv = new bnv();
      localbnv.GIp = paramJSONObject.optString("bubbleImage");
      localbnv.GIr = paramJSONObject.optString("bubbleImageMd5");
      localbnv.GIo = paramJSONObject.optString("corpLogo");
      localbnv.GIu = paramJSONObject.optString("corpLogoMd5");
      localbnv.hkP = paramJSONObject.optString("coverImage");
      localbnv.GIs = paramJSONObject.optString("coverImageMd5");
      localbnv.GIq = paramJSONObject.optString("detailImage");
      localbnv.GIt = paramJSONObject.optString("detailImageMd5");
      localbnu.GHZ = localbnv;
    }
    AppMethodBeat.o(65244);
    return localbnu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.x
 * JD-Core Version:    0.7.0.1
 */