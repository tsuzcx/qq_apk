package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.bey;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ac
{
  public static j a(bey parambey)
  {
    AppMethodBeat.i(213306);
    if (parambey == null)
    {
      AppMethodBeat.o(213306);
      return null;
    }
    j localj = new j();
    localj.title = parambey.title;
    parambey = parambey.yUI.iterator();
    while (parambey.hasNext())
    {
      ahq localahq = (ahq)parambey.next();
      g localg = new g();
      localg.title = localahq.title;
      localg.desc = localahq.desc;
      localg.yUB = localahq.yUB;
      localj.yUI.add(localg);
    }
    AppMethodBeat.o(213306);
    return localj;
  }
  
  public static q a(bfb parambfb)
  {
    AppMethodBeat.i(213305);
    if (parambfb == null)
    {
      AppMethodBeat.o(213305);
      return null;
    }
    q localq = new q();
    localq.egY = parambfb.egY;
    localq.egZ = parambfb.egZ;
    localq.yVb = parambfb.yVb;
    localq.yPK = parambfb.yPK;
    localq.yQE = parambfb.yQE;
    localq.eht = parambfb.eht;
    localq.yVC = parambfb.yVC;
    localq.yVh = parambfb.yWN;
    localq.yVi = parambfb.yVi;
    localq.qwe = parambfb.qwe;
    localq.yVj = parambfb.yVj;
    localq.yVk = parambfb.yVk;
    localq.yVm = parambfb.yVm;
    localq.yVn = parambfb.yVn;
    localq.yVo = parambfb.yVo;
    localq.eha = parambfb.eha;
    localq.yRN = parambfb.yRN;
    localq.yRP = parambfb.yRP;
    localq.yRO = parambfb.yRO;
    localq.yVy = parambfb.yVy;
    if (!Util.isNullOrNil(localq.yVy)) {
      localq.yVd = ((b)com.tencent.mm.kernel.g.af(b.class)).getDisplayName(localq.yVy);
    }
    localq.yVz = parambfb.yVz;
    localq.yVA = parambfb.yVA;
    localq.yVr = new LinkedList();
    Object localObject1;
    Object localObject2;
    if (!parambfb.LOI.isEmpty())
    {
      localObject1 = parambfb.LOI.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bfe)((Iterator)localObject1).next();
        bg localbg = new bg();
        localbg.content = ((bfe)localObject2).content;
        localbg.yXU = ((bfe)localObject2).yXU;
        localbg.gGn = ((bfe)localObject2).gGn;
        localbg.iconUrl = ((bfe)localObject2).iconUrl;
        localbg.name = ((bfe)localObject2).name;
        localbg.yXT = ((bfe)localObject2).yXT;
        if (((bfe)localObject2).type == 1) {
          localbg.type = "Appid";
        }
        for (;;)
        {
          localq.yVr.add(localbg);
          break;
          if (((bfe)localObject2).type == 2) {
            localbg.type = "Text";
          } else if (((bfe)localObject2).type == 3) {
            localbg.type = "Pic";
          } else if (((bfe)localObject2).type == 4) {
            localbg.type = "Native";
          }
        }
      }
    }
    if (parambfb.LOJ != null)
    {
      localq.yVs = new bg();
      localq.yVs.content = parambfb.LOJ.content;
      localq.yVs.yXU = parambfb.LOJ.yXU;
      localq.yVs.gGn = parambfb.LOJ.gGn;
      localq.yVs.iconUrl = parambfb.LOJ.iconUrl;
      localq.yVs.name = parambfb.LOJ.name;
      localq.yVs.yXT = parambfb.LOJ.yXT;
      if (parambfb.LOJ.type != 1) {
        break label715;
      }
      localq.yVs.type = "Appid";
    }
    for (;;)
    {
      localq.yVE = a(parambfb.LOL);
      localq.yVw = new LinkedList();
      if (parambfb.dkr.isEmpty()) {
        break;
      }
      parambfb = parambfb.dkr.iterator();
      while (parambfb.hasNext())
      {
        localObject1 = (bez)parambfb.next();
        localObject2 = new ad();
        ((ad)localObject2).yWG = ((bez)localObject1).yWG;
        ((ad)localObject2).yVk = ((bez)localObject1).yVk;
        ((ad)localObject2).yWo = ((bez)localObject1).yWo;
        ((ad)localObject2).yWp = ((bez)localObject1).yWp;
        ((ad)localObject2).userName = ((bez)localObject1).userName;
        ((ad)localObject2).yWH = ((bez)localObject1).yWH;
        if ((Util.isNullOrNil(((ad)localObject2).yWD)) && (!Util.isNullOrNil(((ad)localObject2).userName))) {
          ((ad)localObject2).yWD = ((b)com.tencent.mm.kernel.g.af(b.class)).getDisplayName(((ad)localObject2).userName);
        }
        localq.yVw.add(localObject2);
      }
      label715:
      if (parambfb.LOJ.type == 2) {
        localq.yVs.type = "Text";
      } else if (parambfb.LOJ.type == 3) {
        localq.yVs.type = "Pic";
      } else if (parambfb.LOJ.type == 4) {
        localq.yVs.type = "Native";
      }
    }
    AppMethodBeat.o(213305);
    return localq;
  }
  
  public static q aY(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65241);
    q localq = new q();
    if (paramJSONObject != null)
    {
      localq.egY = paramJSONObject.optInt("hbType");
      localq.egZ = paramJSONObject.optInt("hbStatus");
      localq.yVb = paramJSONObject.optString("statusMess");
      localq.yVc = paramJSONObject.optString("gameMess");
      localq.yPK = paramJSONObject.optString("wishing");
      localq.yVd = paramJSONObject.optString("sendNick");
      localq.yVe = paramJSONObject.optString("sendHeadImg");
      localq.yQE = paramJSONObject.optString("sendId");
      localq.yVf = paramJSONObject.optString("adMessage");
      localq.yVg = paramJSONObject.optString("adUrl");
      localq.eht = paramJSONObject.optLong("amount");
      localq.yVh = paramJSONObject.optLong("recNum");
      localq.yVi = paramJSONObject.optLong("recAmount");
      localq.qwe = paramJSONObject.optInt("totalNum");
      localq.yVj = paramJSONObject.optLong("totalAmount");
      localq.yVk = paramJSONObject.optString("receiveId");
      localq.yVl = paramJSONObject.optInt("hasWriteAnswer");
      localq.yVm = paramJSONObject.optInt("isSender");
      localq.yVn = paramJSONObject.optInt("isContinue");
      localq.yVo = paramJSONObject.optString("headTitle");
      localq.eha = paramJSONObject.optInt("receiveStatus");
      localq.yVp = paramJSONObject.optInt("canShare");
      localq.yRN = paramJSONObject.optInt("jumpChange");
      localq.yRP = paramJSONObject.optString("changeWording");
      localq.yRO = paramJSONObject.optString("changeUrl");
      localq.yVv = paramJSONObject.optInt("hbKind");
      localq.yRQ = paramJSONObject.optString("externMess");
      localq.yVy = paramJSONObject.optString("sendUserName");
      if ((Util.isNullOrNil(localq.yVd)) && (!Util.isNullOrNil(localq.yVy))) {
        localq.yVd = ((b)com.tencent.mm.kernel.g.af(b.class)).getDisplayName(localq.yVy);
      }
      localq.yVF = paramJSONObject.optString("sendsuffix");
      localq.yVq = new i();
      Object localObject = paramJSONObject.optJSONObject("atomicFunc");
      if (localObject != null)
      {
        localq.yVq.gGn = ((JSONObject)localObject).optInt("enable");
        localq.yVq.yUH = ((JSONObject)localObject).optString("fissionContent");
        localq.yVq.yUG = ((JSONObject)localObject).optString("fissionUrl");
      }
      localq.yVr = new LinkedList();
      localObject = paramJSONObject.optJSONArray("operationHeader");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localq.yVr.add(ba(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      localq.yVt = paramJSONObject.optString("watermark");
      localq.yVu = paramJSONObject.optString("context");
      localq.yVx = paramJSONObject.optString("contextMd5");
      localq.resourceId = paramJSONObject.optInt("resourceId");
      localq.yVs = ba(paramJSONObject.optJSONObject("operationTail"));
      localq.yVw = aZ(paramJSONObject);
      localq.yVz = paramJSONObject.optInt("jumpChangeType");
      localq.yVA = paramJSONObject.optString("changeIconUrl");
      localq.yVB = paramJSONObject.optString("showSourceOpen");
    }
    AppMethodBeat.o(65241);
    return localq;
  }
  
  private static LinkedList<ad> aZ(JSONObject paramJSONObject)
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
        ad localad = new ad();
        if (localJSONObject != null)
        {
          localad.yWD = localJSONObject.optString("receiveName");
          localad.yWE = localJSONObject.optString("receiveHeadImg");
          localad.yWo = localJSONObject.optLong("receiveAmount");
          localad.yWp = localJSONObject.optString("receiveTime");
          localad.yWF = localJSONObject.optString("answer");
          localad.yVk = localJSONObject.optString("receiveId");
          localad.yWG = localJSONObject.optString("gameTips");
          localad.userName = localJSONObject.optString("userName");
          localad.yWI = localJSONObject.optString("receivesuffix");
          if ((Util.isNullOrNil(localad.yWD)) && (!Util.isNullOrNil(localad.userName))) {
            localad.yWD = ((b)com.tencent.mm.kernel.g.af(b.class)).getDisplayName(localad.userName);
          }
        }
        localLinkedList.add(localad);
        i += 1;
      }
    }
    AppMethodBeat.o(65242);
    return localLinkedList;
  }
  
  public static bg ba(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65243);
    bg localbg = new bg();
    if (paramJSONObject != null)
    {
      localbg.gGn = paramJSONObject.optInt("enable", 0);
      localbg.content = paramJSONObject.optString("content");
      localbg.iconUrl = paramJSONObject.optString("iconUrl");
      localbg.type = paramJSONObject.optString("type");
      localbg.name = paramJSONObject.optString("name");
      localbg.yXT = paramJSONObject.optInt("ossKey");
      localbg.yXU = paramJSONObject.optInt("focus");
    }
    AppMethodBeat.o(65243);
    return localbg;
  }
  
  public static cbe bb(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65244);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(65244);
      return null;
    }
    cbe localcbe = new cbe();
    localcbe.subType = paramJSONObject.optInt("subType", -1);
    localcbe.MgB = paramJSONObject.optString("corpName");
    localcbe.Lot = paramJSONObject.optString("materialId");
    localcbe.MgD = paramJSONObject.optString("expire_desc");
    localcbe.MgE = paramJSONObject.optInt("is_expired");
    localcbe.MgJ = paramJSONObject.optInt("detail_link_type");
    localcbe.MgK = paramJSONObject.optString("detail_link_appname");
    localcbe.MgL = paramJSONObject.optString("detail_link_url");
    localcbe.MgM = paramJSONObject.optString("detail_link_title");
    localcbe.MgN = paramJSONObject.optString("exchange_title");
    localcbe.MgO = paramJSONObject.optString("exchange_url");
    localcbe.MgP = paramJSONObject.optInt("has_source");
    localcbe.Mbx = paramJSONObject.optLong("last_obtain_time");
    localcbe.dfT = paramJSONObject.optInt("disable");
    localcbe.MgQ = paramJSONObject.optString("disable_text");
    paramJSONObject = paramJSONObject.optJSONObject("sourceObject");
    if (paramJSONObject != null)
    {
      cbf localcbf = new cbf();
      localcbf.MgU = paramJSONObject.optString("bubbleImage");
      localcbf.MgW = paramJSONObject.optString("bubbleImageMd5");
      localcbf.MgT = paramJSONObject.optString("corpLogo");
      localcbf.MgZ = paramJSONObject.optString("corpLogoMd5");
      localcbf.igW = paramJSONObject.optString("coverImage");
      localcbf.MgX = paramJSONObject.optString("coverImageMd5");
      localcbf.MgV = paramJSONObject.optString("detailImage");
      localcbf.MgY = paramJSONObject.optString("detailImageMd5");
      localcbe.MgC = localcbf;
    }
    AppMethodBeat.o(65244);
    return localcbe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ac
 * JD-Core Version:    0.7.0.1
 */