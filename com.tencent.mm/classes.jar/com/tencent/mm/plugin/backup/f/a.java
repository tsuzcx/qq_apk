package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.v;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.qg.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  implements l
{
  public final int a(is paramis, boolean paramBoolean1, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21506);
    int j;
    String str;
    int i;
    switch (paramca.getType())
    {
    default: 
      if (Util.isNullOrNil(paramca.field_content))
      {
        j = 0;
        str = paramca.field_content;
        localObject1 = str;
        if (paramca.field_isSend != 1)
        {
          localObject1 = str;
          if (com.tencent.mm.plugin.backup.h.c.Eq(paramca.field_talker))
          {
            i = paramca.field_content.indexOf(':');
            localObject1 = str;
            if (i != -1) {
              localObject1 = paramca.field_content.substring(i + 1);
            }
          }
        }
        localObject1 = Util.processXml((String)localObject1);
        if (localObject1 == null) {
          break label1478;
        }
      }
      break;
    }
    label1478:
    for (Object localObject1 = k.b.HD((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        Log.e("MicroMsg.BackupItemAppMsg", "content is null");
        AppMethodBeat.o(21506);
        return 0;
        if (Util.isNullOrNil(paramca.field_content)) {}
        for (i = 0; paramBoolean1; i = paramca.field_content.getBytes().length)
        {
          AppMethodBeat.o(21506);
          return i;
        }
        paramca = a.agF(paramca.field_content);
        if (Util.isNullOrNil(paramca))
        {
          AppMethodBeat.o(21506);
          return 0;
        }
        paramString = new dqi();
        paramString.bhy(Util.nullAs(paramca, ""));
        paramis.KHn = paramString;
        AppMethodBeat.o(21506);
        return i;
        if (Util.isNullOrNil(paramca.field_content)) {}
        for (i = 0; paramca.field_content == null; i = paramca.field_content.getBytes().length)
        {
          AppMethodBeat.o(21506);
          return -1;
        }
        paramLinkedList = paramca.field_content;
        paramString = paramLinkedList;
        if (!com.tencent.mm.plugin.backup.b.g.agB(paramLinkedList))
        {
          paramca = paramca.field_content;
          paramString = paramca;
          if (!com.tencent.mm.plugin.backup.b.g.agB(paramca))
          {
            Log.e("MicroMsg.BackupItemAppMsg", "get xml error ".concat(String.valueOf(paramca)));
            AppMethodBeat.o(21506);
            return 0;
          }
        }
        if (!Util.isNullOrNil(paramString))
        {
          paramca = new dqi();
          paramca.bhy(Util.nullAs(paramString, ""));
          paramis.KHn = paramca;
        }
        AppMethodBeat.o(21506);
        return i;
        j = paramca.field_content.getBytes().length;
        break;
      }
      Log.d("MicroMsg.BackupItemAppMsg", "content type " + ((k.b)localObject1).type);
      str = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().R(paramca.field_imgPath, true);
      if (s.YS(str))
      {
        j += i.a(new i.a(str, paramis, paramLinkedList, 6, paramBoolean1, "_thumb", paramBoolean2));
        i = j;
      }
      switch (((k.b)localObject1).type)
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
          AppMethodBeat.o(21506);
          return i;
          if (((k.b)localObject1).type != 2) {
            break;
          }
          AppMethodBeat.o(21506);
          return -1;
          i = j;
          if (!Util.isNullOrNil(((k.b)localObject1).dCK))
          {
            paramString = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgO().bdx(((k.b)localObject1).dCK);
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
                Log.d("MicroMsg.BackupItemAppMsg", "image ".concat(String.valueOf(paramca)));
                i = j + i.a(new i.a(paramca, paramis, paramLinkedList, 8, paramBoolean1, paramBoolean2, null));
                continue;
                com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgO().bdx(((k.b)localObject1).dCK);
                if ((localc == null) || (!localc.deQ()))
                {
                  i = j;
                  if (paramca.field_isSend == 1)
                  {
                    i = j;
                    if (localc != null)
                    {
                      i = j;
                      if (!localc.field_isUpload) {}
                    }
                  }
                }
                else
                {
                  Log.d("MicroMsg.BackupItemAppMsg", "full path " + localc.field_fileFullPath);
                  i = j;
                  if (s.YS(localc.field_fileFullPath)) {
                    if (paramBoolean1)
                    {
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramis, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                    }
                    else
                    {
                      if ((com.tencent.mm.plugin.backup.b.d.ceP() == 1) && (((k.b)localObject1).iwI / 1024 >= paramLong) && (((k.b)localObject1).filemd5 != null))
                      {
                        if (paramca.field_isSend == 1) {
                          str = paramca.field_talker;
                        }
                        for (;;)
                        {
                          Object localObject2 = new com.tencent.mm.plugin.backup.i.u();
                          j += i.a(new i.a(localc.field_fileFullPath, paramis, paramLinkedList, 7, paramBoolean1, true, (com.tencent.mm.plugin.backup.i.u)localObject2));
                          i = j;
                          if (paramHashMap == null) {
                            break;
                          }
                          paramis = new h.a();
                          paramis.oNI = ((com.tencent.mm.plugin.backup.i.u)localObject2);
                          paramis.md5 = ((k.b)localObject1).filemd5;
                          paramis.oNK = (paramString + "_" + str + "_" + paramca.field_msgSvrId + "_backup");
                          paramis.oNJ = paramca.field_msgSvrId;
                          paramHashMap.put(Long.valueOf(paramca.field_msgSvrId), paramis);
                          i = j;
                          break;
                          localObject2 = paramca.field_talker;
                          str = paramString;
                          paramString = (String)localObject2;
                        }
                      }
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramis, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                      continue;
                      paramString = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgO().bdx(((k.b)localObject1).dCK);
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
                        Log.d("MicroMsg.BackupItemAppMsg", "full path " + paramString.field_fileFullPath);
                        i = j;
                        if (s.YS(paramString.field_fileFullPath)) {
                          i = j + i.a(new i.a(paramString.field_fileFullPath, paramis, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
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
      paramString = new qg();
      paramString.dWB.xml = ((k.b)localObject1).ixl;
      paramString.dWB.dFm = paramca.field_msgId;
      EventCenter.instance.publish(paramString);
      Log.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.dWC.dWD });
      paramca = paramString.dWC.dWD.split(":");
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
          Log.i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", new Object[] { paramca[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(paramca[k], paramis, paramLinkedList, 7, paramBoolean1, "_fav.".concat(String.valueOf(k)), paramBoolean2));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(String paramString, is paramis, ca paramca)
  {
    AppMethodBeat.i(21507);
    Object localObject3 = paramis.KHl.MTo;
    Object localObject2 = paramis.KHn.MTo;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21507);
      return 0;
    }
    paramca.setContent((String)localObject2);
    Object localObject1 = localObject2;
    if (paramca.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.h.c.Eq((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.h.c.Kr(paramis.KHn.MTo);
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
      Log.e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21507);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      paramca.setType(419430449);
      com.tencent.mm.plugin.backup.h.c.x(paramca);
      AppMethodBeat.o(21507);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      paramca.setType(m.g((k.b)localObject3));
      com.tencent.mm.plugin.backup.h.c.x(paramca);
      paramString = new qg();
      paramString.dWB.xml = ((k.b)localObject3).ixl;
      paramString.dWB.dFm = paramca.field_msgId;
      EventCenter.instance.publish(paramString);
      Log.d("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.dWC.dWD });
      paramString = paramString.dWC.dWD.split(":");
      i = 0;
      while (i < paramString.length)
      {
        paramca = com.tencent.mm.plugin.backup.b.g.a(paramis, 7, ".".concat(String.valueOf(i)));
        if (!Util.isNullOrNil(paramca))
        {
          Log.d("MicroMsg.BackupItemAppMsg", "record mediaId:%s, index:%d", new Object[] { paramca, Integer.valueOf(i) });
          s.nx(com.tencent.mm.plugin.backup.b.g.agy(paramca) + paramca, paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21507);
      return 0;
    }
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ();
    if (((com.tencent.mm.plugin.backup.h.b)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.h.b)localObject2).oQF.get((IAutoDBItem)localObject1, new String[0])) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appVersion < ((k.b)localObject3).appVersion)) {
      com.tencent.mm.plugin.backup.h.d.cgP().cgR().i(1, ((k.b)localObject3).appId);
    }
    paramca.setType(m.g((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.b.g.b(paramis, 6);
    if ((localObject1 != null) && (paramca.field_msgId == 0L))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().ap((byte[])localObject1);
      Log.d("MicroMsg.BackupItemAppMsg", "thumbData MsgInfo path:".concat(String.valueOf(localObject1)));
      if (!Util.isNullOrNil((String)localObject1)) {
        paramca.Cz((String)localObject1);
      }
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.a(paramis, 8);
    int i = com.tencent.mm.plugin.backup.b.g.c(paramis, 8);
    localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject1 = com.tencent.mm.plugin.backup.b.g.a(paramis, 7);
      i = com.tencent.mm.plugin.backup.b.g.c(paramis, 7);
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.agy((String)localObject1) + (String)localObject1;
    com.tencent.mm.plugin.backup.h.c.x(paramca);
    k localk = new k();
    ((k.b)localObject3).a(localk);
    localk.field_msgId = paramca.field_msgId;
    com.tencent.mm.plugin.backup.h.b localb = com.tencent.mm.plugin.backup.h.d.cgP().cgQ();
    if (localb.uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    localb.oQE.insert(localk);
    long l;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ();
      if (paramString.equals(paramis.KHl.MTo)) {}
      for (paramString = paramis.KHm.MTo;; paramString = paramis.KHl.MTo)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aJ(paramString, paramis.Brn);
        paramis = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgO().bdx(((k.b)localObject3).dCK);
        paramString = paramis;
        if (paramis != null) {
          break label1102;
        }
        Log.d("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
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
          if (!com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgO().insert((IAutoDBItem)localObject4)) {
            Log.e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramis = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgO().bdx(((k.b)localObject3).dCK);
        if (paramis != null) {
          break;
        }
        Log.e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).dCK });
        AppMethodBeat.o(21507);
        return 0;
      }
      paramString = paramis;
      if (((k.b)localObject3).iwI != 0)
      {
        paramString = paramis;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).iwI) {
            break label1167;
          }
          if (paramca.field_isSend != 1) {
            break label1155;
          }
          paramis.field_status = 105L;
          paramString = paramis;
        }
      }
    }
    for (;;)
    {
      label1102:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      s.nx((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgO().a(paramString, new String[0]);
      AppMethodBeat.o(21507);
      return 0;
      label1155:
      paramis.field_status = 102L;
      paramString = paramis;
      continue;
      label1167:
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
      AppMethodBeat.i(21505);
      com.tencent.mm.ag.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(0L, paramString);
      a locala = new a(paramString);
      if (!locala.daZ)
      {
        Log.e("MicroMsg.AppmsgConvert", "buffer error");
        AppMethodBeat.o(21505);
        return "";
      }
      a.a.b localb = new a.a.b();
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
      AppMethodBeat.o(21505);
      return paramString;
    }
    
    static final class a
    {
      boolean daZ;
      Map<String, String> oND;
      
      public a(String paramString)
      {
        AppMethodBeat.i(21495);
        this.oND = null;
        this.daZ = true;
        this.oND = SemiXml.decode(paramString);
        if (this.oND == null)
        {
          this.daZ = false;
          this.oND = new HashMap();
        }
        AppMethodBeat.o(21495);
      }
      
      final int getInt(String paramString)
      {
        AppMethodBeat.i(21496);
        if (!this.oND.containsKey(paramString))
        {
          AppMethodBeat.o(21496);
          return 0;
        }
        int i = Util.getInt((String)this.oND.get(paramString), 0);
        AppMethodBeat.o(21496);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a
 * JD-Core Version:    0.7.0.1
 */