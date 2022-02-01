package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.st;
import com.tencent.mm.autogen.a.st.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.v;
import com.tencent.mm.model.cn;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  implements l
{
  public final int a(jd paramjd, boolean paramBoolean1, cc paramcc, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21506);
    int j;
    String str;
    int i;
    switch (paramcc.getType())
    {
    default: 
      if (Util.isNullOrNil(paramcc.field_content))
      {
        j = 0;
        str = paramcc.field_content;
        localObject1 = str;
        if (paramcc.field_isSend != 1)
        {
          localObject1 = str;
          if (com.tencent.mm.plugin.backup.h.c.DQ(paramcc.field_talker))
          {
            i = paramcc.field_content.indexOf(':');
            localObject1 = str;
            if (i != -1) {
              localObject1 = paramcc.field_content.substring(i + 1);
            }
          }
        }
        localObject1 = Util.processXml((String)localObject1);
        if (localObject1 == null) {
          break label1475;
        }
      }
      break;
    }
    label1475:
    for (Object localObject1 = k.b.Hf((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        Log.e("MicroMsg.BackupItemAppMsg", "content is null");
        AppMethodBeat.o(21506);
        return 0;
        if (Util.isNullOrNil(paramcc.field_content)) {}
        for (i = 0; paramBoolean1; i = paramcc.field_content.getBytes().length)
        {
          AppMethodBeat.o(21506);
          return i;
        }
        paramcc = a.ahG(paramcc.field_content);
        if (Util.isNullOrNil(paramcc))
        {
          AppMethodBeat.o(21506);
          return 0;
        }
        paramString = new etl();
        paramString.btH(Util.nullAs(paramcc, ""));
        paramjd.YFG = paramString;
        AppMethodBeat.o(21506);
        return i;
        if (Util.isNullOrNil(paramcc.field_content)) {}
        for (i = 0; paramcc.field_content == null; i = paramcc.field_content.getBytes().length)
        {
          AppMethodBeat.o(21506);
          return -1;
        }
        paramLinkedList = paramcc.field_content;
        paramString = paramLinkedList;
        if (!com.tencent.mm.plugin.backup.b.g.ahC(paramLinkedList))
        {
          paramcc = paramcc.field_content;
          paramString = paramcc;
          if (!com.tencent.mm.plugin.backup.b.g.ahC(paramcc))
          {
            Log.e("MicroMsg.BackupItemAppMsg", "get xml error ".concat(String.valueOf(paramcc)));
            AppMethodBeat.o(21506);
            return 0;
          }
        }
        if (!Util.isNullOrNil(paramString))
        {
          paramcc = new etl();
          paramcc.btH(Util.nullAs(paramString, ""));
          paramjd.YFG = paramcc;
        }
        AppMethodBeat.o(21506);
        return i;
        j = paramcc.field_content.getBytes().length;
        break;
      }
      Log.d("MicroMsg.BackupItemAppMsg", "content type " + ((k.b)localObject1).type);
      str = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().X(paramcc.field_imgPath, true);
      if (y.ZC(str))
      {
        j += i.a(new i.a(str, paramjd, paramLinkedList, 6, paramBoolean1, "_thumb", paramBoolean2));
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
          if (!Util.isNullOrNil(((k.b)localObject1).hzM))
          {
            paramString = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWJ().bpI(((k.b)localObject1).hzM);
            if ((paramString == null) || (!paramString.efT()))
            {
              i = j;
              if (paramcc.field_isSend == 1)
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
              paramcc = paramString.field_fileFullPath;
              i = j;
              if (y.ZC(paramcc))
              {
                Log.d("MicroMsg.BackupItemAppMsg", "image ".concat(String.valueOf(paramcc)));
                i = j + i.a(new i.a(paramcc, paramjd, paramLinkedList, 8, paramBoolean1, paramBoolean2, null));
                continue;
                com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWJ().bpI(((k.b)localObject1).hzM);
                if ((localc == null) || (!localc.efT()))
                {
                  i = j;
                  if (paramcc.field_isSend == 1)
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
                  if (y.ZC(localc.field_fileFullPath)) {
                    if (paramBoolean1)
                    {
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramjd, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                    }
                    else
                    {
                      if ((com.tencent.mm.plugin.backup.b.d.cUM() == 1) && (((k.b)localObject1).nRd / 1024 >= paramLong) && (((k.b)localObject1).filemd5 != null))
                      {
                        if (paramcc.field_isSend == 1) {
                          str = paramcc.field_talker;
                        }
                        for (;;)
                        {
                          Object localObject2 = new com.tencent.mm.plugin.backup.i.u();
                          j += i.a(new i.a(localc.field_fileFullPath, paramjd, paramLinkedList, 7, paramBoolean1, true, (com.tencent.mm.plugin.backup.i.u)localObject2));
                          i = j;
                          if (paramHashMap == null) {
                            break;
                          }
                          paramjd = new h.a();
                          paramjd.vaT = ((com.tencent.mm.plugin.backup.i.u)localObject2);
                          paramjd.md5 = ((k.b)localObject1).filemd5;
                          paramjd.vaV = (paramString + "_" + str + "_" + paramcc.field_msgSvrId + "_backup");
                          paramjd.vaU = paramcc.field_msgSvrId;
                          paramHashMap.put(Long.valueOf(paramcc.field_msgSvrId), paramjd);
                          i = j;
                          break;
                          localObject2 = paramcc.field_talker;
                          str = paramString;
                          paramString = (String)localObject2;
                        }
                      }
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramjd, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                      continue;
                      paramString = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWJ().bpI(((k.b)localObject1).hzM);
                      if ((paramString == null) || (!paramString.efT()))
                      {
                        i = j;
                        if (paramcc.field_isSend == 1)
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
                        if (y.ZC(paramString.field_fileFullPath)) {
                          i = j + i.a(new i.a(paramString.field_fileFullPath, paramjd, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
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
      paramString = new st();
      paramString.hWb.xml = ((k.b)localObject1).nRF;
      paramString.hWb.hCz = paramcc.field_msgId;
      paramString.publish();
      Log.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.hWc.hWd });
      paramcc = paramString.hWc.hWd.split(":");
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= paramcc.length) {
          break;
        }
        i = j;
        if (y.ZC(paramcc[k]))
        {
          Log.i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", new Object[] { paramcc[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(paramcc[k], paramjd, paramLinkedList, 7, paramBoolean1, "_fav.".concat(String.valueOf(k)), paramBoolean2));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21507);
    Object localObject3 = paramjd.YFE.abwM;
    Object localObject2 = paramjd.YFG.abwM;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21507);
      return 0;
    }
    paramcc.setContent((String)localObject2);
    Object localObject1 = localObject2;
    if (paramcc.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.h.c.DQ((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.h.c.JI(paramjd.YFG.abwM);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = (paramjd.YFG.abwM + " ").substring(i + 2).trim();
        }
      }
    }
    Object localObject4 = Util.processXml((String)localObject1);
    localObject3 = k.b.Hf((String)localObject4);
    if (localObject3 == null)
    {
      Log.e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21507);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      paramcc.setType(419430449);
      com.tencent.mm.plugin.backup.h.c.B(paramcc);
      AppMethodBeat.o(21507);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      paramcc.setType(n.h((k.b)localObject3));
      com.tencent.mm.plugin.backup.h.c.B(paramcc);
      paramString = new st();
      paramString.hWb.xml = ((k.b)localObject3).nRF;
      paramString.hWb.hCz = paramcc.field_msgId;
      paramString.publish();
      Log.d("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.hWc.hWd });
      paramString = paramString.hWc.hWd.split(":");
      i = 0;
      while (i < paramString.length)
      {
        paramcc = com.tencent.mm.plugin.backup.b.g.a(paramjd, 7, ".".concat(String.valueOf(i)));
        if (!Util.isNullOrNil(paramcc))
        {
          Log.d("MicroMsg.BackupItemAppMsg", "record mediaId:%s, index:%d", new Object[] { paramcc, Integer.valueOf(i) });
          y.qn(com.tencent.mm.plugin.backup.b.g.ahz(paramcc) + paramcc, paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21507);
      return 0;
    }
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.h.d.cWK().cWL();
    if (((com.tencent.mm.plugin.backup.h.b)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.h.b)localObject2).vdR.get((IAutoDBItem)localObject1, new String[0])) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appVersion < ((k.b)localObject3).appVersion)) {
      com.tencent.mm.plugin.backup.h.d.cWK().cWM().E(1, ((k.b)localObject3).appId);
    }
    paramcc.setType(n.h((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.b.g.b(paramjd, 6);
    if ((localObject1 != null) && (paramcc.field_msgId == 0L))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().aA((byte[])localObject1);
      Log.d("MicroMsg.BackupItemAppMsg", "thumbData MsgInfo path:".concat(String.valueOf(localObject1)));
      if (!Util.isNullOrNil((String)localObject1)) {
        paramcc.BT((String)localObject1);
      }
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.a(paramjd, 8);
    int i = com.tencent.mm.plugin.backup.b.g.c(paramjd, 8);
    localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject1 = com.tencent.mm.plugin.backup.b.g.a(paramjd, 7);
      i = com.tencent.mm.plugin.backup.b.g.c(paramjd, 7);
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.ahz((String)localObject1) + (String)localObject1;
    com.tencent.mm.plugin.backup.h.c.B(paramcc);
    k localk = new k();
    ((k.b)localObject3).a(localk);
    localk.field_msgId = paramcc.field_msgId;
    com.tencent.mm.plugin.backup.h.b localb = com.tencent.mm.plugin.backup.h.d.cWK().cWL();
    if (localb.uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    localb.vdQ.insert(localk);
    long l;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.cWK().cWL().bzD();
      if (paramString.equals(paramjd.YFE.abwM)) {}
      for (paramString = paramjd.YFF.abwM;; paramString = paramjd.YFE.abwM)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aU(paramString, paramjd.Njv);
        paramjd = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWJ().bpI(((k.b)localObject3).hzM);
        paramString = paramjd;
        if (paramjd != null) {
          break label1099;
        }
        Log.d("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
        l = ((fi)localObject1).field_msgId;
        localObject4 = k.b.Hf((String)localObject4);
        if (localObject4 != null)
        {
          paramString = n.aK(com.tencent.mm.loader.i.b.bmC(), ((k.b)localObject4).title, ((k.b)localObject4).nRe);
          int j = ((k.b)localObject4).sdkVer;
          paramjd = ((k.b)localObject4).appId;
          localObject1 = ((k.b)localObject4).hzM;
          int k = ((k.b)localObject4).nRd;
          localObject4 = new com.tencent.mm.pluginsdk.model.app.c();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath = paramString;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_appId = paramjd;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_sdkVer = j;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_mediaSvrId = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen = k;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_status = 101L;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_isUpload = false;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_createTime = cn.bDu();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_lastModifyTime = Util.nowSecond();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_msgInfoId = l;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_netTimes = 0L;
          if (!com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWJ().insert((IAutoDBItem)localObject4)) {
            Log.e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramjd = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWJ().bpI(((k.b)localObject3).hzM);
        if (paramjd != null) {
          break;
        }
        Log.e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).hzM });
        AppMethodBeat.o(21507);
        return 0;
      }
      paramString = paramjd;
      if (((k.b)localObject3).nRd != 0)
      {
        paramString = paramjd;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).nRd) {
            break label1164;
          }
          if (paramcc.field_isSend != 1) {
            break label1152;
          }
          paramjd.field_status = 105L;
          paramString = paramjd;
        }
      }
    }
    for (;;)
    {
      label1099:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      y.qn((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWJ().a(paramString, new String[0]);
      AppMethodBeat.o(21507);
      return 0;
      label1152:
      paramjd.field_status = 102L;
      paramString = paramjd;
      continue;
      label1164:
      paramjd.field_status = 199L;
      paramString = paramjd;
    }
  }
  
  static final class a
  {
    public static String INVALID_TAG = "]]>";
    public static String uWA = "<msg>";
    public static String uWB = "</msg>";
    
    public static String ahG(String paramString)
    {
      AppMethodBeat.i(21505);
      com.tencent.mm.message.u localu = ((com.tencent.mm.plugin.biz.a.a)h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(0L, paramString);
      a locala = new a(paramString);
      if (!locala.clZ)
      {
        Log.e("MicroMsg.AppmsgConvert", "buffer error");
        AppMethodBeat.o(21505);
        return "";
      }
      a.a.b localb = new a.a.b();
      Object localObject1 = localu.nUC;
      Object localObject3 = new HashMap();
      localb.startTag("msg");
      ((Map)localObject3).put("appid", (String)locala.vaO.get(".msg.appmsg.$appid"));
      ((Map)localObject3).put("sdkver", (String)locala.vaO.get(".msg.appmsg.$sdkver"));
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
        localb.addTag("des", (String)locala.vaO.get(".msg.appmsg.des"));
        localb.addTag("action", (String)locala.vaO.get(".msg.appmsg.action"));
        localb.addTag("type", locala.getInt(".msg.appmsg.type"));
        localb.addTag("showtype", locala.getInt(".msg.appmsg.showtype"));
        localb.addTag("content", (String)locala.vaO.get(".msg.appmsg.content"));
        localb.addTag("url", (String)localObject2);
        localb.addTag("lowurl", (String)locala.vaO.get(".msg.appmsg.lowurl"));
        localb.startTag("appattach");
        localb.addTag("totallen", locala.getInt(".msg.appmsg.appattach.totallen"));
        localb.addTag("attachid", (String)locala.vaO.get(".msg.appmsg.appattach.attachid"));
        localb.addTag("fileext", (String)locala.vaO.get(".msg.appmsg.appattach.fileext"));
        localb.endTag("appattach");
        localb.startTag("mmreader");
        ((Map)localObject3).put("type", localu.type);
        ((Map)localObject3).put("convMsgCount", paramString.size());
        localb.startTag("category", (Map)localObject3);
        localb.addTag("name", localu.iab);
        localb.startTag("topnew");
        localb.addTag("cover", (String)locala.vaO.get(".msg.appmsg.mmreader.category.topnew.cover"));
        localb.addTag("width", (String)locala.vaO.get(".msg.appmsg.mmreader.category.topnew.width"));
        localb.addTag("height", (String)locala.vaO.get(".msg.appmsg.mmreader.category.topnew.height"));
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
          str1 = ((v)paramString.get(i)).nUK;
          localObject3 = ((v)paramString.get(i)).nUL;
          String str2 = ((v)paramString.get(i)).time;
          String str3 = ((v)paramString.get(i)).nUM;
          String str4 = ((v)paramString.get(i)).nUN;
          String str5 = ((v)paramString.get(i)).nUO;
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
        localb.addTag("fileid", (String)locala.vaO.get((String)localObject1 + ".fileid"));
        localb.startTag("source");
        localb.startTag("source");
        localb.addTag("name", localu.iab);
        localb.endTag("source");
        localb.endTag("source");
        localb.endTag("item");
        i += 1;
        break label560;
        str1 = ((v)paramString.get(0)).title;
        localObject2 = ((v)paramString.get(0)).url;
        paramString.get(0);
        localObject1 = ((v)paramString.get(0)).nUO;
        break;
      }
      label980:
      localb.endTag("category");
      localb.startTag("publisher");
      localb.addTag("convName", localu.iaa);
      localb.addTag("nickname", localu.iab);
      localb.endTag("publisher");
      localb.endTag("mmreader");
      localb.endTag("appmsg");
      localb.addTag("fromusername", localu.iaa);
      localb.addTag("scene", locala.getInt(".msg.scene"));
      localb.startTag("appinfo");
      localb.addTag("version", (String)locala.vaO.get(".msg.appinfo.appname"));
      localb.addTag("appname", (String)locala.vaO.get(".msg.appinfo.version"));
      localb.endTag("appinfo");
      localb.addTag("commenturl", localu.kLg);
      localb.endTag("msg");
      Log.d("MicroMsg.AppmsgConvert", "xml " + localb.sb.toString());
      paramString = localb.sb.toString();
      AppMethodBeat.o(21505);
      return paramString;
    }
    
    static final class a
    {
      boolean clZ;
      Map<String, String> vaO;
      
      public a(String paramString)
      {
        AppMethodBeat.i(21495);
        this.vaO = null;
        this.clZ = true;
        this.vaO = SemiXml.decode(paramString);
        if (this.vaO == null)
        {
          this.clZ = false;
          this.vaO = new HashMap();
        }
        AppMethodBeat.o(21495);
      }
      
      final int getInt(String paramString)
      {
        AppMethodBeat.i(21496);
        if (!this.vaO.containsKey(paramString))
        {
          AppMethodBeat.o(21496);
          return 0;
        }
        int i = Util.getInt((String)this.vaO.get(paramString), 0);
        AppMethodBeat.o(21496);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a
 * JD-Core Version:    0.7.0.1
 */