package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.v;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.qg.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements j
{
  private static int b(is paramis, boolean paramBoolean1, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, Object> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(231598);
    int j;
    int i;
    if (Util.isNullOrNil(paramca.field_content))
    {
      j = 0;
      paramHashMap = paramca.field_content;
      paramString = paramHashMap;
      if (paramca.field_isSend != 1)
      {
        paramString = paramHashMap;
        if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.Eq(paramca.field_talker))
        {
          i = paramca.field_content.indexOf(':');
          paramString = paramHashMap;
          if (i != -1) {
            paramString = paramca.field_content.substring(i + 1);
          }
        }
      }
      paramString = Util.processXml(paramString);
      if (paramString == null) {
        break label994;
      }
    }
    label994:
    for (paramString = k.b.HD(paramString);; paramString = null)
    {
      if (paramString == null)
      {
        Log.e("MicroMsg.BakOldItemAppMsg", "content is null");
        AppMethodBeat.o(231598);
        return 0;
        j = paramca.field_content.getBytes().length;
        break;
      }
      Log.d("MicroMsg.BakOldItemAppMsg", "content type " + paramString.type);
      paramHashMap = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgM().R(paramca.field_imgPath, true);
      if (s.YS(paramHashMap))
      {
        j += i.a(new i.a(paramHashMap, paramis, paramLinkedList, 6, false, "_thumb", false));
        i = j;
      }
      switch (paramString.type)
      {
      default: 
        i = j;
      case 0: 
      case 1: 
      case 3: 
      case 4: 
      case 5: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 2: 
      case 6: 
      case 7: 
        for (;;)
        {
          AppMethodBeat.o(231598);
          return i;
          if (paramString.type != 2) {
            break;
          }
          AppMethodBeat.o(231598);
          return -1;
          i = j;
          if (!Util.isNullOrNil(paramString.dCK))
          {
            paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().bdx(paramString.dCK);
            if ((paramString == null) || (!paramString.deQ()))
            {
              i = j;
              if (paramca.field_isSend == 1)
              {
                i = j;
                if (paramString != null)
                {
                  i = j;
                  if (!paramString.field_isUpload) {}
                }
              }
            }
            else
            {
              paramca = paramString.field_fileFullPath;
              i = j;
              if (s.YS(paramca))
              {
                Log.d("MicroMsg.BakOldItemAppMsg", "image ".concat(String.valueOf(paramca)));
                i = j + i.a(new i.a(paramca, paramis, paramLinkedList, 8, false, false, null));
                continue;
                paramHashMap = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().bdx(paramString.dCK);
                if ((paramHashMap == null) || (!paramHashMap.deQ()))
                {
                  i = j;
                  if (paramca.field_isSend == 1)
                  {
                    i = j;
                    if (paramHashMap != null)
                    {
                      i = j;
                      if (!paramHashMap.field_isUpload) {}
                    }
                  }
                }
                else
                {
                  Log.d("MicroMsg.BakOldItemAppMsg", "full path " + paramHashMap.field_fileFullPath);
                  i = j;
                  if (s.YS(paramHashMap.field_fileFullPath)) {
                    if ((com.tencent.mm.plugin.backup.b.d.ceP() == 1) && (paramString.iwI / 1024 >= 0L) && (paramString.filemd5 != null))
                    {
                      paramca = new com.tencent.mm.plugin.backup.i.u();
                      i = j + i.a(new i.a(paramHashMap.field_fileFullPath, paramis, paramLinkedList, 7, false, true, paramca));
                    }
                    else
                    {
                      i = j + i.a(new i.a(paramHashMap.field_fileFullPath, paramis, paramLinkedList, 7, false, false, null));
                      continue;
                      paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().bdx(paramString.dCK);
                      if ((paramString == null) || (!paramString.deQ()))
                      {
                        i = j;
                        if (paramca.field_isSend == 1)
                        {
                          i = j;
                          if (paramString != null)
                          {
                            i = j;
                            if (!paramString.field_isUpload) {}
                          }
                        }
                      }
                      else
                      {
                        Log.d("MicroMsg.BakOldItemAppMsg", "full path " + paramString.field_fileFullPath);
                        i = j;
                        if (s.YS(paramString.field_fileFullPath)) {
                          i = j + i.a(new i.a(paramString.field_fileFullPath, paramis, paramLinkedList, 7, false, false, null));
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      paramHashMap = new qg();
      paramHashMap.dWB.xml = paramString.ixl;
      paramHashMap.dWB.dFm = paramca.field_msgId;
      EventCenter.instance.publish(paramHashMap);
      Log.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramHashMap.dWC.dWD });
      paramca = paramHashMap.dWC.dWD.split(":");
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= paramca.length) {
          break;
        }
        i = j;
        if (s.YS(paramca[k]))
        {
          Log.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", new Object[] { paramca[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(paramca[k], paramis, paramLinkedList, 7, false, "_fav.".concat(String.valueOf(k)), false));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(is paramis, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(231597);
    switch (paramca.getType())
    {
    default: 
      i = b(paramis, false, paramca, paramString, paramLinkedList, null, false, 0L);
      AppMethodBeat.o(231597);
      return i;
    case 285212721: 
      if (Util.isNullOrNil(paramca.field_content)) {}
      for (i = 0;; i = paramca.field_content.getBytes().length)
      {
        paramca = a.agF(paramca.field_content);
        if (!Util.isNullOrNil(paramca)) {
          break;
        }
        AppMethodBeat.o(231597);
        return 0;
      }
      paramString = new dqi();
      paramString.bhy(Util.nullAs(paramca, ""));
      paramis.KHn = paramString;
      AppMethodBeat.o(231597);
      return i;
    }
    if (Util.isNullOrNil(paramca.field_content)) {}
    for (int i = 0; paramca.field_content == null; i = paramca.field_content.getBytes().length)
    {
      AppMethodBeat.o(231597);
      return -1;
    }
    Object localObject = be.bkr(paramca.field_content).Oph.trim();
    paramString = (String)localObject;
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.agB((String)localObject))
    {
      localObject = paramca.field_content;
      paramString = (String)localObject;
      if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.agB((String)localObject))
      {
        Log.e("MicroMsg.BakOldItemAppMsg", "get xml error ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(231597);
        return 0;
      }
    }
    int j = i;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = new dqi();
      ((dqi)localObject).bhy(Util.nullAs(paramString, ""));
      paramis.KHn = ((dqi)localObject);
      paramString = k.b.HD(paramString);
      localObject = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().aTd();
      paramca = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgM().R(paramca.field_imgPath, true);
      paramString = (String)localObject + paramString.iwK;
      if (s.boW(paramca) <= 0L)
      {
        AppMethodBeat.o(231597);
        return -1;
      }
      j = i.a(new i.a(paramca, paramis, paramLinkedList, 6, false, "_thumb", false));
      paramca = be.bkr(z.a(paramis.KHn));
      j = i + j + i.a(new i.a(paramString, paramis, paramLinkedList, false, false, com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgN().blk(paramca.md5)));
    }
    AppMethodBeat.o(231597);
    return j;
  }
  
  public final int a(String paramString, is paramis, ca paramca)
  {
    AppMethodBeat.i(21837);
    Object localObject3 = paramis.KHl.MTo;
    Object localObject2 = paramis.KHn.MTo;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21837);
      return 0;
    }
    paramca.setContent((String)localObject2);
    Object localObject1 = localObject2;
    int i;
    if (paramca.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.Eq((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.bakoldlogic.d.d.Kr(paramis.KHn.MTo);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = (paramis.KHn.MTo + " ").substring(i + 2).trim();
        }
      }
    }
    Object localObject4 = Util.processXml((String)localObject1);
    localObject3 = k.b.HD((String)localObject4);
    if (localObject3 == null)
    {
      Log.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21837);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      paramca.setType(419430449);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.x(paramca);
      AppMethodBeat.o(21837);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      paramca.setType(m.g((k.b)localObject3));
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.x(paramca);
      paramString = new qg();
      paramString.dWB.xml = ((k.b)localObject3).ixl;
      paramString.dWB.dFm = paramca.field_msgId;
      EventCenter.instance.publish(paramString);
      Log.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramString.dWC.dWD });
      paramString = paramString.dWC.dWD.split(":");
      i = 0;
      while (i < paramString.length)
      {
        paramca = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramis, 7, ".".concat(String.valueOf(i)));
        if (!Util.isNullOrNil(paramca))
        {
          Log.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", new Object[] { paramca, Integer.valueOf(i) });
          s.nw(com.tencent.mm.plugin.backup.bakoldlogic.a.a.agM(paramca), paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21837);
      return 0;
    }
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx();
    if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).oQF.get((IAutoDBItem)localObject1, new String[0])) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appVersion < ((k.b)localObject3).appVersion)) {
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chy().j(1, ((k.b)localObject3).appId);
    }
    paramca.setType(m.g((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramis, 6);
    if ((localObject1 != null) && (paramca.field_msgId == 0L)) {
      if (((k.b)localObject3).type != 2) {
        break label725;
      }
    }
    k localk;
    com.tencent.mm.plugin.backup.bakoldlogic.d.c localc;
    label725:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgM().a((byte[])localObject1, bool, Bitmap.CompressFormat.PNG);
      Log.d("MicroMsg.BakOldItemAppMsg", com.tencent.mm.compatible.util.f.apq() + " thumbData MsgInfo path:" + (String)localObject1);
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramca.Cz((String)localObject1);
        Log.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(localObject1)));
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramis, 8);
      i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramis, 8);
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramis, 7);
        i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramis, 7);
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.agM((String)localObject1);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.x(paramca);
      localk = new k();
      ((k.b)localObject3).a(localk);
      localk.field_msgId = paramca.field_msgId;
      localc = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx();
      if (localc.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    localc.oQE.insert(localk);
    long l;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().aSQ();
      if (paramString.equals(paramis.KHl.MTo)) {}
      for (paramString = paramis.KHm.MTo;; paramString = paramis.KHl.MTo)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aJ(paramString, paramis.Brn);
        paramis = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().bdx(((k.b)localObject3).dCK);
        paramString = paramis;
        if (paramis != null) {
          break label1122;
        }
        Log.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
        l = ((eo)localObject1).field_msgId;
        localObject4 = k.b.HD((String)localObject4);
        if (localObject4 != null)
        {
          paramString = m.aB(com.tencent.mm.loader.j.b.aKM(), ((k.b)localObject4).title, ((k.b)localObject4).iwJ);
          int j = ((k.b)localObject4).sdkVer;
          paramis = ((k.b)localObject4).appId;
          localObject1 = ((k.b)localObject4).dCK;
          int k = ((k.b)localObject4).iwI;
          localObject4 = new com.tencent.mm.pluginsdk.model.app.c();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath = paramString;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_appId = paramis;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_sdkVer = j;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_mediaSvrId = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen = k;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_status = 101L;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_isUpload = false;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_createTime = Util.nowMilliSecond();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_lastModifyTime = Util.nowSecond();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_msgInfoId = l;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_netTimes = 0L;
          if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().insert((IAutoDBItem)localObject4)) {
            Log.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramis = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().bdx(((k.b)localObject3).dCK);
        if (paramis != null) {
          break;
        }
        Log.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).dCK });
        AppMethodBeat.o(21837);
        return 0;
      }
      paramString = paramis;
      if (((k.b)localObject3).iwI != 0)
      {
        paramString = paramis;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).iwI) {
            break label1187;
          }
          if (paramca.field_isSend != 1) {
            break label1175;
          }
          paramis.field_status = 105L;
          paramString = paramis;
        }
      }
    }
    for (;;)
    {
      label1122:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      s.ny((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().a(paramString, new String[0]);
      AppMethodBeat.o(21837);
      return 0;
      label1175:
      paramis.field_status = 102L;
      paramString = paramis;
      continue;
      label1187:
      paramis.field_status = 199L;
      paramString = paramis;
    }
  }
  
  static final class a
  {
    public static String INVALID_TAG = "]]>";
    public static String oJw = "<msg>";
    public static String oJx = "</msg>";
    
    public static String agF(String paramString)
    {
      AppMethodBeat.i(21834);
      com.tencent.mm.ag.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(0L, paramString);
      a locala = new a(paramString);
      if (!locala.daZ)
      {
        Log.e("MicroMsg.AppmsgConvert", "buffer error");
        AppMethodBeat.o(21834);
        return "";
      }
      b.a.b localb = new b.a.b();
      Object localObject1 = localu.iAd;
      Object localObject3 = new HashMap();
      localb.startTag("msg");
      ((Map)localObject3).put("appid", (String)locala.oND.get(".msg.appmsg.$appid"));
      ((Map)localObject3).put("sdkver", (String)locala.oND.get(".msg.appmsg.$sdkver"));
      localb.startTag("appmsg", (Map)localObject3);
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = new LinkedList();
      }
      String str1;
      Object localObject2;
      int i;
      if (paramString.size() == 0)
      {
        str1 = "";
        localObject2 = "";
        localObject1 = "";
        localb.addTag("title", str1);
        localb.addTag("des", (String)locala.oND.get(".msg.appmsg.des"));
        localb.addTag("action", (String)locala.oND.get(".msg.appmsg.action"));
        localb.addTag("type", locala.getInt(".msg.appmsg.type"));
        localb.addTag("showtype", locala.getInt(".msg.appmsg.showtype"));
        localb.addTag("content", (String)locala.oND.get(".msg.appmsg.content"));
        localb.addTag("url", (String)localObject2);
        localb.addTag("lowurl", (String)locala.oND.get(".msg.appmsg.lowurl"));
        localb.startTag("appattach");
        localb.addTag("totallen", locala.getInt(".msg.appmsg.appattach.totallen"));
        localb.addTag("attachid", (String)locala.oND.get(".msg.appmsg.appattach.attachid"));
        localb.addTag("fileext", (String)locala.oND.get(".msg.appmsg.appattach.fileext"));
        localb.endTag("appattach");
        localb.startTag("mmreader");
        ((Map)localObject3).put("type", localu.type);
        ((Map)localObject3).put("convMsgCount", paramString.size());
        localb.startTag("category", (Map)localObject3);
        localb.addTag("name", localu.eah);
        localb.startTag("topnew");
        localb.addTag("cover", (String)locala.oND.get(".msg.appmsg.mmreader.category.topnew.cover"));
        localb.addTag("width", (String)locala.oND.get(".msg.appmsg.mmreader.category.topnew.width"));
        localb.addTag("height", (String)locala.oND.get(".msg.appmsg.mmreader.category.topnew.height"));
        localb.addTag("digest", (String)localObject1);
        localb.endTag("topnew");
        i = 0;
        label560:
        if (i >= paramString.size()) {
          break label980;
        }
        localb.startTag("item");
        if (paramString.get(i) != null)
        {
          localObject1 = ((v)paramString.get(i)).title;
          localObject2 = ((v)paramString.get(i)).url;
          str1 = ((v)paramString.get(i)).iAm;
          localObject3 = ((v)paramString.get(i)).iAn;
          String str2 = ((v)paramString.get(i)).time;
          String str3 = ((v)paramString.get(i)).iAo;
          String str4 = ((v)paramString.get(i)).iAp;
          String str5 = ((v)paramString.get(i)).iAq;
          localb.addTag("title", (String)localObject1);
          localb.addTag("url", (String)localObject2);
          localb.addTag("shorturl", str1);
          localb.addTag("longurl", (String)localObject3);
          localb.addTag("pub_time", str2);
          localb.addTag("cover", str3);
          localb.addTag("tweetid", str4);
          localb.addTag("digest", str5);
          localObject2 = new StringBuilder(".msg.appmsg.mmreader.category.item");
          if (i != 0) {
            break label972;
          }
        }
      }
      label972:
      for (localObject1 = "";; localObject1 = String.valueOf(i))
      {
        localObject1 = (String)localObject1;
        localb.addTag("fileid", (String)locala.oND.get((String)localObject1 + ".fileid"));
        localb.startTag("source");
        localb.startTag("source");
        localb.addTag("name", localu.eah);
        localb.endTag("source");
        localb.endTag("source");
        localb.endTag("item");
        i += 1;
        break label560;
        str1 = ((v)paramString.get(0)).title;
        localObject2 = ((v)paramString.get(0)).url;
        paramString.get(0);
        localObject1 = ((v)paramString.get(0)).iAq;
        break;
      }
      label980:
      localb.endTag("category");
      localb.startTag("publisher");
      localb.addTag("convName", localu.eag);
      localb.addTag("nickname", localu.eah);
      localb.endTag("publisher");
      localb.endTag("mmreader");
      localb.endTag("appmsg");
      localb.addTag("fromusername", localu.eag);
      localb.addTag("scene", locala.getInt(".msg.scene"));
      localb.startTag("appinfo");
      localb.addTag("version", (String)locala.oND.get(".msg.appinfo.appname"));
      localb.addTag("appname", (String)locala.oND.get(".msg.appinfo.version"));
      localb.endTag("appinfo");
      localb.addTag("commenturl", localu.fQR);
      localb.endTag("msg");
      Log.d("MicroMsg.AppmsgConvert", "xml " + localb.sb.toString());
      paramString = localb.sb.toString();
      AppMethodBeat.o(21834);
      return paramString;
    }
    
    static final class a
    {
      boolean daZ;
      Map<String, String> oND;
      
      public a(String paramString)
      {
        AppMethodBeat.i(21824);
        this.oND = null;
        this.daZ = true;
        this.oND = SemiXml.decode(paramString);
        if (this.oND == null)
        {
          this.daZ = false;
          this.oND = new HashMap();
        }
        AppMethodBeat.o(21824);
      }
      
      final int getInt(String paramString)
      {
        AppMethodBeat.i(21825);
        if (!this.oND.containsKey(paramString))
        {
          AppMethodBeat.o(21825);
          return 0;
        }
        int i = Util.getInt((String)this.oND.get(paramString), 0);
        AppMethodBeat.o(21825);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b
 * JD-Core Version:    0.7.0.1
 */