package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad
{
  public static ArrayList<cjj> B(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(230085);
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
          cjj localcjj = new cjj();
          paramJSONArray = localJSONObject;
          if (localJSONObject == null) {
            paramJSONArray = new JSONObject();
          }
          localcjj.wording = paramJSONArray.optString("wording");
          localJSONObject = paramJSONArray.optJSONObject("jump_info");
          cjh localcjh = new cjh();
          paramJSONArray = localJSONObject;
          if (localJSONObject == null) {
            paramJSONArray = new JSONObject();
          }
          localcjh.type = paramJSONArray.optInt("type");
          localcjh.url = paramJSONArray.optString("url");
          localcjh.username = paramJSONArray.optString("username");
          localcjh.InB = paramJSONArray.optString("pagepath");
          localcjj.TqN = localcjh;
          localArrayList.add(localcjj);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      Log.i("MicroMsg.LuckyMoneyParseHelper", "parseOptionItemList error：%s", new Object[] { paramJSONArray.getMessage() });
      AppMethodBeat.o(230085);
    }
  }
  
  public static j a(bmc parambmc)
  {
    AppMethodBeat.i(230080);
    if (parambmc == null)
    {
      AppMethodBeat.o(230080);
      return null;
    }
    j localj = new j();
    localj.title = parambmc.title;
    parambmc = parambmc.EyF.iterator();
    while (parambmc.hasNext())
    {
      aib localaib = (aib)parambmc.next();
      g localg = new g();
      localg.title = localaib.title;
      localg.desc = localaib.desc;
      localg.Eyy = localaib.Eyy;
      localj.EyF.add(localg);
    }
    AppMethodBeat.o(230080);
    return localj;
  }
  
  public static q a(bmf parambmf)
  {
    AppMethodBeat.i(230075);
    if (parambmf == null)
    {
      AppMethodBeat.o(230075);
      return null;
    }
    q localq = new q();
    localq.gbo = parambmf.gbo;
    localq.gbp = parambmf.gbp;
    localq.EyY = parambmf.EyY;
    localq.EtJ = parambmf.EtJ;
    localq.ybP = parambmf.ybP;
    localq.gbJ = parambmf.gbJ;
    localq.EzA = parambmf.EzA;
    localq.Eze = parambmf.EAR;
    localq.Ezf = parambmf.Ezf;
    localq.tVd = parambmf.tVd;
    localq.Ezg = parambmf.Ezg;
    localq.Ezh = parambmf.Ezh;
    localq.Ezj = parambmf.Ezj;
    localq.Ezk = parambmf.Ezk;
    localq.Ezl = parambmf.Ezl;
    localq.gbq = parambmf.gbq;
    localq.EvK = parambmf.EvK;
    localq.EvM = parambmf.EvM;
    localq.EvL = parambmf.EvL;
    localq.Ezw = parambmf.Ezw;
    if (!Util.isNullOrNil(localq.Ezw)) {
      localq.Eza = ((b)h.ae(b.class)).PJ(localq.Ezw);
    }
    localq.Ezx = parambmf.Ezx;
    localq.Ezy = parambmf.Ezy;
    localq.Ezo = new LinkedList();
    Object localObject1;
    Object localObject2;
    if (!parambmf.SXd.isEmpty())
    {
      localObject1 = parambmf.SXd.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bmi)((Iterator)localObject1).next();
        bh localbh = new bh();
        localbh.content = ((bmi)localObject2).content;
        localbh.EBZ = ((bmi)localObject2).EBZ;
        localbh.jqz = ((bmi)localObject2).jqz;
        localbh.iconUrl = ((bmi)localObject2).iconUrl;
        localbh.name = ((bmi)localObject2).name;
        localbh.EBY = ((bmi)localObject2).EBY;
        if (((bmi)localObject2).type == 1) {
          localbh.type = "Appid";
        }
        for (;;)
        {
          localq.Ezo.add(localbh);
          break;
          if (((bmi)localObject2).type == 2) {
            localbh.type = "Text";
          } else if (((bmi)localObject2).type == 3) {
            localbh.type = "Pic";
          } else if (((bmi)localObject2).type == 4) {
            localbh.type = "Native";
          }
        }
      }
    }
    if (parambmf.SXe != null)
    {
      localq.Ezp = new bh();
      localq.Ezp.content = parambmf.SXe.content;
      localq.Ezp.EBZ = parambmf.SXe.EBZ;
      localq.Ezp.jqz = parambmf.SXe.jqz;
      localq.Ezp.iconUrl = parambmf.SXe.iconUrl;
      localq.Ezp.name = parambmf.SXe.name;
      localq.Ezp.EBY = parambmf.SXe.EBY;
      if (parambmf.SXe.type != 1) {
        break label722;
      }
      localq.Ezp.type = "Appid";
    }
    for (;;)
    {
      localq.EzC = a(parambmf.SXg);
      localq.Ezu = new LinkedList();
      if (parambmf.fbZ.isEmpty()) {
        break;
      }
      parambmf = parambmf.fbZ.iterator();
      while (parambmf.hasNext())
      {
        localObject1 = (bmd)parambmf.next();
        localObject2 = new ae();
        ((ae)localObject2).EAJ = ((bmd)localObject1).EAJ;
        ((ae)localObject2).Ezh = ((bmd)localObject1).Ezh;
        ((ae)localObject2).EAr = ((bmd)localObject1).EAr;
        ((ae)localObject2).EAs = ((bmd)localObject1).EAs;
        ((ae)localObject2).userName = ((bmd)localObject1).userName;
        ((ae)localObject2).EAK = ((bmd)localObject1).EAK;
        if ((Util.isNullOrNil(((ae)localObject2).EAG)) && (!Util.isNullOrNil(((ae)localObject2).userName))) {
          ((ae)localObject2).EAG = ((b)h.ae(b.class)).PJ(((ae)localObject2).userName);
        }
        localq.Ezu.add(localObject2);
      }
      label722:
      if (parambmf.SXe.type == 2) {
        localq.Ezp.type = "Text";
      } else if (parambmf.SXe.type == 3) {
        localq.Ezp.type = "Pic";
      } else if (parambmf.SXe.type == 4) {
        localq.Ezp.type = "Native";
      }
    }
    AppMethodBeat.o(230075);
    return localq;
  }
  
  public static q bf(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65241);
    q localq = new q();
    if (paramJSONObject != null)
    {
      localq.gbo = paramJSONObject.optInt("hbType");
      localq.gbp = paramJSONObject.optInt("hbStatus");
      localq.EyY = paramJSONObject.optString("statusMess");
      localq.EyZ = paramJSONObject.optString("gameMess");
      localq.EtJ = paramJSONObject.optString("wishing");
      localq.Eza = paramJSONObject.optString("sendNick");
      localq.Ezb = paramJSONObject.optString("sendHeadImg");
      localq.ybP = paramJSONObject.optString("sendId");
      localq.Ezc = paramJSONObject.optString("adMessage");
      localq.Ezd = paramJSONObject.optString("adUrl");
      localq.gbJ = paramJSONObject.optLong("amount");
      localq.Eze = paramJSONObject.optLong("recNum");
      localq.Ezf = paramJSONObject.optLong("recAmount");
      localq.tVd = paramJSONObject.optInt("totalNum");
      localq.Ezg = paramJSONObject.optLong("totalAmount");
      localq.Ezh = paramJSONObject.optString("receiveId");
      localq.Ezi = paramJSONObject.optInt("hasWriteAnswer");
      localq.Ezj = paramJSONObject.optInt("isSender");
      localq.Ezk = paramJSONObject.optInt("isContinue");
      localq.Ezl = paramJSONObject.optString("headTitle");
      localq.gbq = paramJSONObject.optInt("receiveStatus");
      localq.Ezm = paramJSONObject.optInt("canShare");
      localq.EvK = paramJSONObject.optInt("jumpChange");
      localq.EvM = paramJSONObject.optString("changeWording");
      localq.EvL = paramJSONObject.optString("changeUrl");
      localq.Ezs = paramJSONObject.optInt("hbKind");
      localq.EvN = paramJSONObject.optString("externMess");
      localq.Ezw = paramJSONObject.optString("sendUserName");
      if (Util.isNullOrNil(localq.Eza)) {
        localq.EzE = true;
      }
      if ((Util.isNullOrNil(localq.Eza)) && (!Util.isNullOrNil(localq.Ezw))) {
        localq.Eza = ((b)h.ae(b.class)).PJ(localq.Ezw);
      }
      localq.EzF = paramJSONObject.optInt("not_show_avatar", 0);
      localq.EzD = paramJSONObject.optString("sendsuffix");
      localq.Ezn = new i();
      Object localObject = paramJSONObject.optJSONObject("atomicFunc");
      if (localObject != null)
      {
        localq.Ezn.jqz = ((JSONObject)localObject).optInt("enable");
        localq.Ezn.EyE = ((JSONObject)localObject).optString("fissionContent");
        localq.Ezn.EyD = ((JSONObject)localObject).optString("fissionUrl");
      }
      localq.Ezo = new LinkedList();
      localObject = paramJSONObject.optJSONArray("operationHeader");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localq.Ezo.add(bh(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      localq.Ezq = paramJSONObject.optString("watermark");
      localq.Ezr = paramJSONObject.optString("context");
      localq.Ezv = paramJSONObject.optString("contextMd5");
      localq.Ezt = paramJSONObject.optInt("resourceId");
      localq.Ezp = bh(paramJSONObject.optJSONObject("operationTail"));
      localq.Ezu = bg(paramJSONObject);
      localq.Ezx = paramJSONObject.optInt("jumpChangeType");
      localq.Ezy = paramJSONObject.optString("changeIconUrl");
      localq.Ezz = paramJSONObject.optString("showSourceOpen");
    }
    AppMethodBeat.o(65241);
    return localq;
  }
  
  private static LinkedList<ae> bg(JSONObject paramJSONObject)
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
        ae localae = new ae();
        if (localJSONObject != null)
        {
          localae.EAG = localJSONObject.optString("receiveName");
          localae.EAH = localJSONObject.optString("receiveHeadImg");
          localae.EAr = localJSONObject.optLong("receiveAmount");
          localae.EAs = localJSONObject.optString("receiveTime");
          localae.EAI = localJSONObject.optString("answer");
          localae.Ezh = localJSONObject.optString("receiveId");
          localae.EAJ = localJSONObject.optString("gameTips");
          localae.userName = localJSONObject.optString("userName");
          localae.EAL = localJSONObject.optString("receivesuffix");
          if ((Util.isNullOrNil(localae.EAG)) && (!Util.isNullOrNil(localae.userName)))
          {
            h.aHH();
            if (Util.isNullOrNil(((n)h.ae(n.class)).bbL().bwh(localae.userName).field_username)) {
              break label260;
            }
            localae.EAG = ((b)h.ae(b.class)).PJ(localae.userName);
          }
        }
        for (;;)
        {
          localLinkedList.add(localae);
          i += 1;
          break;
          label260:
          localae.EAM = true;
        }
      }
    }
    AppMethodBeat.o(65242);
    return localLinkedList;
  }
  
  public static bh bh(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65243);
    bh localbh = new bh();
    if (paramJSONObject != null)
    {
      localbh.jqz = paramJSONObject.optInt("enable", 0);
      localbh.content = paramJSONObject.optString("content");
      localbh.iconUrl = paramJSONObject.optString("iconUrl");
      localbh.type = paramJSONObject.optString("type");
      localbh.name = paramJSONObject.optString("name");
      localbh.EBY = paramJSONObject.optInt("ossKey");
      localbh.EBZ = paramJSONObject.optInt("focus");
    }
    AppMethodBeat.o(65243);
    return localbh;
  }
  
  public static cjf bi(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65244);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(65244);
      return null;
    }
    cjf localcjf = new cjf();
    localcjf.subType = paramJSONObject.optInt("subType", -1);
    localcjf.Tqn = paramJSONObject.optString("corpName");
    localcjf.SpP = paramJSONObject.optString("materialId");
    localcjf.Tqp = paramJSONObject.optString("expire_desc");
    localcjf.Tqq = paramJSONObject.optInt("is_expired");
    localcjf.Tqv = paramJSONObject.optInt("detail_link_type");
    localcjf.Tqw = paramJSONObject.optString("detail_link_appname");
    localcjf.Tqx = paramJSONObject.optString("detail_link_url");
    localcjf.Tqy = paramJSONObject.optString("detail_link_title");
    localcjf.Tqz = paramJSONObject.optString("exchange_title");
    localcjf.TqA = paramJSONObject.optString("exchange_url");
    localcjf.TqB = paramJSONObject.optInt("has_source");
    localcjf.TkV = paramJSONObject.optLong("last_obtain_time");
    localcjf.TqC = paramJSONObject.optInt("disable");
    localcjf.TqD = paramJSONObject.optString("disable_text");
    paramJSONObject = paramJSONObject.optJSONObject("sourceObject");
    if (paramJSONObject != null)
    {
      cjg localcjg = new cjg();
      localcjg.TqH = paramJSONObject.optString("bubbleImage");
      localcjg.TqJ = paramJSONObject.optString("bubbleImageMd5");
      localcjg.TqG = paramJSONObject.optString("corpLogo");
      localcjg.TqM = paramJSONObject.optString("corpLogoMd5");
      localcjg.kVK = paramJSONObject.optString("coverImage");
      localcjg.TqK = paramJSONObject.optString("coverImageMd5");
      localcjg.TqI = paramJSONObject.optString("detailImage");
      localcjg.TqL = paramJSONObject.optString("detailImageMd5");
      localcjf.Tqo = localcjg;
    }
    AppMethodBeat.o(65244);
    return localcjf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ad
 * JD-Core Version:    0.7.0.1
 */