package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.bzu;
import com.tencent.mm.protocal.protobuf.bzv;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.protocal.protobuf.caa;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.czm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae
{
  public static ArrayList<czm> F(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(283955);
    JSONArray localJSONArray = paramJSONArray;
    if (paramJSONArray == null) {
      localJSONArray = new JSONArray();
    }
    Log.i("MicroMsg.LuckyMoneyParseHelper", "parseOptionItemList res：%s", new Object[] { localJSONArray.toString() });
    localArrayList = new ArrayList();
    int i = 0;
    try
    {
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        if (localJSONObject != null)
        {
          czm localczm = new czm();
          paramJSONArray = localJSONObject;
          if (localJSONObject == null) {
            paramJSONArray = new JSONObject();
          }
          localczm.wording = paramJSONArray.optString("wording");
          localJSONObject = paramJSONArray.optJSONObject("jump_info");
          czk localczk = new czk();
          paramJSONArray = localJSONObject;
          if (localJSONObject == null) {
            paramJSONArray = new JSONObject();
          }
          localczk.type = paramJSONArray.optInt("type");
          localczk.url = paramJSONArray.optString("url");
          localczk.username = paramJSONArray.optString("username");
          localczk.OkP = paramJSONArray.optString("pagepath");
          localczm.aaET = localczk;
          localArrayList.add(localczm);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      Log.i("MicroMsg.LuckyMoneyParseHelper", "parseOptionItemList error：%s", new Object[] { paramJSONArray.getMessage() });
      AppMethodBeat.o(283955);
    }
  }
  
  public static k a(bzu parambzu)
  {
    AppMethodBeat.i(283942);
    if (parambzu == null)
    {
      AppMethodBeat.o(283942);
      return null;
    }
    k localk = new k();
    localk.title = parambzu.title;
    parambzu = parambzu.Krs.iterator();
    while (parambzu.hasNext())
    {
      aku localaku = (aku)parambzu.next();
      h localh = new h();
      localh.title = localaku.title;
      localh.desc = localaku.desc;
      localh.Krl = localaku.Krl;
      localk.Krs.add(localh);
    }
    AppMethodBeat.o(283942);
    return localk;
  }
  
  public static q a(bzx parambzx)
  {
    AppMethodBeat.i(283940);
    if (parambzx == null)
    {
      AppMethodBeat.o(283940);
      return null;
    }
    q localq = new q();
    localq.ihy = parambzx.ihy;
    localq.ihz = parambzx.ihz;
    localq.KrL = parambzx.KrL;
    localq.Kmq = parambzx.Kmq;
    localq.CAf = parambzx.CAf;
    localq.ihV = parambzx.ihV;
    localq.Ksm = parambzx.Ksm;
    localq.KrR = parambzx.KtO;
    localq.KrS = parambzx.KrS;
    localq.wYz = parambzx.wYz;
    localq.KrT = parambzx.KrT;
    localq.KrU = parambzx.KrU;
    localq.KrW = parambzx.KrW;
    localq.KrX = parambzx.KrX;
    localq.KrY = parambzx.KrY;
    localq.ihA = parambzx.ihA;
    localq.Kos = parambzx.Kos;
    localq.Kou = parambzx.Kou;
    localq.Kot = parambzx.Kot;
    localq.Ksi = parambzx.Ksi;
    if (!Util.isNullOrNil(localq.Ksi)) {
      localq.KrN = ((b)com.tencent.mm.kernel.h.ax(b.class)).getDisplayName(localq.Ksi);
    }
    localq.Ksj = parambzx.Ksj;
    localq.Ksk = parambzx.Ksk;
    localq.Ksb = new LinkedList();
    Object localObject1;
    Object localObject2;
    if (!parambzx.aaiU.isEmpty())
    {
      localObject1 = parambzx.aaiU.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (caa)((Iterator)localObject1).next();
        bi localbi = new bi();
        localbi.content = ((caa)localObject2).content;
        localbi.Kva = ((caa)localObject2).Kva;
        localbi.lTH = ((caa)localObject2).lTH;
        localbi.iconUrl = ((caa)localObject2).iconUrl;
        localbi.name = ((caa)localObject2).name;
        localbi.KuZ = ((caa)localObject2).KuZ;
        if (((caa)localObject2).type == 1) {
          localbi.type = "Appid";
        }
        for (;;)
        {
          localq.Ksb.add(localbi);
          break;
          if (((caa)localObject2).type == 2) {
            localbi.type = "Text";
          } else if (((caa)localObject2).type == 3) {
            localbi.type = "Pic";
          } else if (((caa)localObject2).type == 4) {
            localbi.type = "Native";
          }
        }
      }
    }
    if (parambzx.aaiV != null)
    {
      localq.Ksc = new bi();
      localq.Ksc.content = parambzx.aaiV.content;
      localq.Ksc.Kva = parambzx.aaiV.Kva;
      localq.Ksc.lTH = parambzx.aaiV.lTH;
      localq.Ksc.iconUrl = parambzx.aaiV.iconUrl;
      localq.Ksc.name = parambzx.aaiV.name;
      localq.Ksc.KuZ = parambzx.aaiV.KuZ;
      if (parambzx.aaiV.type != 1) {
        break label722;
      }
      localq.Ksc.type = "Appid";
    }
    for (;;)
    {
      localq.Kso = a(parambzx.aaiX);
      localq.Ksg = new LinkedList();
      if (parambzx.hfF.isEmpty()) {
        break;
      }
      parambzx = parambzx.hfF.iterator();
      while (parambzx.hasNext())
      {
        localObject1 = (bzv)parambzx.next();
        localObject2 = new af();
        ((af)localObject2).KtF = ((bzv)localObject1).KtF;
        ((af)localObject2).KrU = ((bzv)localObject1).KrU;
        ((af)localObject2).Kth = ((bzv)localObject1).Kth;
        ((af)localObject2).Kti = ((bzv)localObject1).Kti;
        ((af)localObject2).userName = ((bzv)localObject1).userName;
        ((af)localObject2).KtG = ((bzv)localObject1).KtG;
        if ((Util.isNullOrNil(((af)localObject2).KtC)) && (!Util.isNullOrNil(((af)localObject2).userName))) {
          ((af)localObject2).KtC = ((b)com.tencent.mm.kernel.h.ax(b.class)).getDisplayName(((af)localObject2).userName);
        }
        localq.Ksg.add(localObject2);
      }
      label722:
      if (parambzx.aaiV.type == 2) {
        localq.Ksc.type = "Text";
      } else if (parambzx.aaiV.type == 3) {
        localq.Ksc.type = "Pic";
      } else if (parambzx.aaiV.type == 4) {
        localq.Ksc.type = "Native";
      }
    }
    AppMethodBeat.o(283940);
    return localq;
  }
  
  public static q bt(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65241);
    q localq = new q();
    if (paramJSONObject != null)
    {
      localq.ihy = paramJSONObject.optInt("hbType");
      localq.ihz = paramJSONObject.optInt("hbStatus");
      localq.KrL = paramJSONObject.optString("statusMess");
      localq.KrM = paramJSONObject.optString("gameMess");
      localq.Kmq = paramJSONObject.optString("wishing");
      localq.KrN = paramJSONObject.optString("sendNick");
      localq.KrO = paramJSONObject.optString("sendHeadImg");
      localq.CAf = paramJSONObject.optString("sendId");
      localq.KrP = paramJSONObject.optString("adMessage");
      localq.KrQ = paramJSONObject.optString("adUrl");
      localq.ihV = paramJSONObject.optLong("amount");
      localq.KrR = paramJSONObject.optLong("recNum");
      localq.KrS = paramJSONObject.optLong("recAmount");
      localq.wYz = paramJSONObject.optInt("totalNum");
      localq.KrT = paramJSONObject.optLong("totalAmount");
      localq.KrU = paramJSONObject.optString("receiveId");
      localq.KrV = paramJSONObject.optInt("hasWriteAnswer");
      localq.KrW = paramJSONObject.optInt("isSender");
      localq.KrX = paramJSONObject.optInt("isContinue");
      localq.KrY = paramJSONObject.optString("headTitle");
      localq.ihA = paramJSONObject.optInt("receiveStatus");
      localq.KrZ = paramJSONObject.optInt("canShare");
      localq.Kos = paramJSONObject.optInt("jumpChange");
      localq.Kou = paramJSONObject.optString("changeWording");
      localq.Kot = paramJSONObject.optString("changeUrl");
      localq.Ksf = paramJSONObject.optInt("hbKind");
      localq.Kov = paramJSONObject.optString("externMess");
      localq.Ksi = paramJSONObject.optString("sendUserName");
      if (Util.isNullOrNil(localq.KrN)) {
        localq.Ksq = true;
      }
      if ((Util.isNullOrNil(localq.KrN)) && (!Util.isNullOrNil(localq.Ksi))) {
        localq.KrN = ((b)com.tencent.mm.kernel.h.ax(b.class)).getDisplayName(localq.Ksi);
      }
      localq.Ksr = paramJSONObject.optInt("not_show_avatar", 0);
      localq.Ksp = paramJSONObject.optString("sendsuffix");
      localq.Ksa = new j();
      Object localObject = paramJSONObject.optJSONObject("atomicFunc");
      if (localObject != null)
      {
        localq.Ksa.lTH = ((JSONObject)localObject).optInt("enable");
        localq.Ksa.Krr = ((JSONObject)localObject).optString("fissionContent");
        localq.Ksa.Krq = ((JSONObject)localObject).optString("fissionUrl");
      }
      localq.Ksb = new LinkedList();
      localObject = paramJSONObject.optJSONArray("operationHeader");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localq.Ksb.add(bv(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      localq.Ksd = paramJSONObject.optString("watermark");
      localq.Kse = paramJSONObject.optString("context");
      localq.Ksh = paramJSONObject.optString("contextMd5");
      localq.resourceId = paramJSONObject.optInt("resourceId");
      localq.Ksc = bv(paramJSONObject.optJSONObject("operationTail"));
      localq.Ksg = bu(paramJSONObject);
      localq.Ksj = paramJSONObject.optInt("jumpChangeType");
      localq.Ksk = paramJSONObject.optString("changeIconUrl");
      localq.Ksl = paramJSONObject.optString("showSourceOpen");
    }
    AppMethodBeat.o(65241);
    return localq;
  }
  
  private static LinkedList<af> bu(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65242);
    paramJSONObject = paramJSONObject.optJSONArray("record");
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONObject != null)
    {
      int i = 0;
      if (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        af localaf = new af();
        if (localJSONObject != null)
        {
          localaf.KtC = localJSONObject.optString("receiveName");
          localaf.KtD = localJSONObject.optString("receiveHeadImg");
          localaf.Kth = localJSONObject.optLong("receiveAmount");
          localaf.Kti = localJSONObject.optString("receiveTime");
          localaf.KtE = localJSONObject.optString("answer");
          localaf.KrU = localJSONObject.optString("receiveId");
          localaf.KtF = localJSONObject.optString("gameTips");
          localaf.userName = localJSONObject.optString("userName");
          localaf.KtH = localJSONObject.optString("receivesuffix");
          if ((Util.isNullOrNil(localaf.KtC)) && (!Util.isNullOrNil(localaf.userName)))
          {
            com.tencent.mm.kernel.h.baF();
            if (Util.isNullOrNil(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxv(localaf.userName).field_username)) {
              break label260;
            }
            localaf.KtC = ((b)com.tencent.mm.kernel.h.ax(b.class)).getDisplayName(localaf.userName);
          }
        }
        for (;;)
        {
          localLinkedList.add(localaf);
          i += 1;
          break;
          label260:
          localaf.KtI = true;
        }
      }
    }
    AppMethodBeat.o(65242);
    return localLinkedList;
  }
  
  public static bi bv(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65243);
    bi localbi = new bi();
    if (paramJSONObject != null)
    {
      localbi.lTH = paramJSONObject.optInt("enable", 0);
      localbi.content = paramJSONObject.optString("content");
      localbi.iconUrl = paramJSONObject.optString("iconUrl");
      localbi.type = paramJSONObject.optString("type");
      localbi.name = paramJSONObject.optString("name");
      localbi.KuZ = paramJSONObject.optInt("ossKey");
      localbi.Kva = paramJSONObject.optInt("focus");
    }
    AppMethodBeat.o(65243);
    return localbi;
  }
  
  public static aa bw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(283950);
    aa localaa = new aa();
    if (paramJSONObject != null)
    {
      localaa.Ktr = paramJSONObject.optString("cdnFileId");
      localaa.pdv = paramJSONObject.optString("cdnAesKey");
      localaa.Ktt = paramJSONObject.optString("pagName");
      localaa.Kts = paramJSONObject.optString("wishKeyWord");
      localaa.videoUrl = paramJSONObject.optString("videoUrl");
      localaa.Ktu = paramJSONObject.optString("videoThumbUrl");
      localaa.videoWidth = paramJSONObject.optInt("videoWidth");
      localaa.videoHeight = paramJSONObject.optInt("videoHeight");
      localaa.verifyInfo = paramJSONObject.optString("verifyInfo");
    }
    AppMethodBeat.o(283950);
    return localaa;
  }
  
  public static czi bx(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65244);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(65244);
      return null;
    }
    czi localczi = new czi();
    localczi.subType = paramJSONObject.optInt("subType", -1);
    localczi.aaEp = paramJSONObject.optString("corpName");
    localczi.ZoK = paramJSONObject.optString("materialId");
    localczi.aaEr = paramJSONObject.optString("expire_desc");
    localczi.aaEs = paramJSONObject.optInt("is_expired");
    localczi.aaEx = paramJSONObject.optInt("detail_link_type");
    localczi.aaEy = paramJSONObject.optString("detail_link_appname");
    localczi.aaEz = paramJSONObject.optString("detail_link_url");
    localczi.aaEA = paramJSONObject.optString("detail_link_title");
    localczi.aaEB = paramJSONObject.optString("exchange_title");
    localczi.aaEC = paramJSONObject.optString("exchange_url");
    localczi.aaED = paramJSONObject.optInt("has_source");
    localczi.aayC = paramJSONObject.optLong("last_obtain_time");
    localczi.aaEE = paramJSONObject.optInt("disable");
    localczi.aaEF = paramJSONObject.optString("disable_text");
    paramJSONObject = paramJSONObject.optJSONObject("sourceObject");
    if (paramJSONObject != null)
    {
      czj localczj = new czj();
      localczj.aaEJ = paramJSONObject.optString("bubbleImage");
      localczj.aaEL = paramJSONObject.optString("bubbleImageMd5");
      localczj.aaEI = paramJSONObject.optString("corpLogo");
      localczj.aaEO = paramJSONObject.optString("corpLogoMd5");
      localczj.nBe = paramJSONObject.optString("coverImage");
      localczj.aaEM = paramJSONObject.optString("coverImageMd5");
      localczj.aaEK = paramJSONObject.optString("detailImage");
      localczj.aaEN = paramJSONObject.optString("detailImageMd5");
      localczi.aaEq = localczj;
    }
    AppMethodBeat.o(65244);
    return localczi;
  }
  
  public static an by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(283958);
    an localan = new an();
    localan.KtX = paramJSONObject.optString("spidLogo");
    localan.KtY = paramJSONObject.optString("spidWishing");
    localan.KtM = paramJSONObject.optString("spidName");
    localan.KtX = paramJSONObject.optString("spidLogo");
    localan.ihz = paramJSONObject.optInt("hbStatus");
    localan.ihA = paramJSONObject.optInt("receiveStatus");
    localan.KrL = paramJSONObject.optString("statusMess");
    localan.KtN = paramJSONObject.optString("hintMess");
    localan.Ksd = paramJSONObject.optString("watermark");
    localan.CAf = paramJSONObject.optString("sendId");
    localan.KtQ = paramJSONObject.optInt("focusFlag");
    localan.KtR = paramJSONObject.optString("focusWording");
    localan.KtS = paramJSONObject.optString("focusAppidUserName");
    localan.KtT = paramJSONObject.optInt("isFocus");
    localan.ihy = paramJSONObject.optInt("hbType");
    localan.Ksa = new j();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("atomicFunc");
    if (localJSONObject != null)
    {
      localan.Ksa.lTH = localJSONObject.optInt("enable");
      localan.Ksa.Krr = localJSONObject.optString("fissionContent");
      localan.Ksa.Krq = localJSONObject.optString("fissionUrl");
    }
    localJSONObject = paramJSONObject.optJSONObject("agree_duty");
    if (localJSONObject != null)
    {
      localan.Kua = localJSONObject.optString("agreed_flag", "-1");
      localan.Kub = localJSONObject.optString("title", "");
      localan.Kuc = localJSONObject.optString("service_protocol_wording", "");
      localan.Kud = localJSONObject.optString("service_protocol_url", "");
      localan.Kue = localJSONObject.optString("button_wording", "");
      localan.Kug = localJSONObject.optLong("delay_expired_time", 0L);
    }
    if (localan.Kug > 0L)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acML, Long.valueOf(System.currentTimeMillis() + localan.Kug * 1000L));
    }
    localan.Ksc = bv(paramJSONObject.optJSONObject("operationTail"));
    AppMethodBeat.o(283958);
    return localan;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ae
 * JD-Core Version:    0.7.0.1
 */