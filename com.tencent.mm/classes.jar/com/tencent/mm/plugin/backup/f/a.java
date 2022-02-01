package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.v;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.g.a.pd.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
  implements l
{
  public final int a(hy paramhy, boolean paramBoolean1, bo parambo, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21506);
    int j;
    String str;
    int i;
    switch (parambo.getType())
    {
    default: 
      if (bs.isNullOrNil(parambo.field_content))
      {
        j = 0;
        str = parambo.field_content;
        localObject1 = str;
        if (parambo.field_isSend != 1)
        {
          localObject1 = str;
          if (com.tencent.mm.plugin.backup.h.c.sQ(parambo.field_talker))
          {
            i = parambo.field_content.indexOf(':');
            localObject1 = str;
            if (i != -1) {
              localObject1 = parambo.field_content.substring(i + 1);
            }
          }
        }
        localObject1 = bs.aLx((String)localObject1);
        if (localObject1 == null) {
          break label1478;
        }
      }
      break;
    }
    label1478:
    for (Object localObject1 = k.b.vA((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ac.e("MicroMsg.BackupItemAppMsg", "content is null");
        AppMethodBeat.o(21506);
        return 0;
        if (bs.isNullOrNil(parambo.field_content)) {}
        for (i = 0; paramBoolean1; i = parambo.field_content.getBytes().length)
        {
          AppMethodBeat.o(21506);
          return i;
        }
        parambo = a.Sz(parambo.field_content);
        if (bs.isNullOrNil(parambo))
        {
          AppMethodBeat.o(21506);
          return 0;
        }
        paramString = new crm();
        paramString.aJV(bs.bG(parambo, ""));
        paramhy.DPV = paramString;
        AppMethodBeat.o(21506);
        return i;
        if (bs.isNullOrNil(parambo.field_content)) {}
        for (i = 0; parambo.field_content == null; i = parambo.field_content.getBytes().length)
        {
          AppMethodBeat.o(21506);
          return -1;
        }
        paramLinkedList = parambo.field_content;
        paramString = paramLinkedList;
        if (!com.tencent.mm.plugin.backup.b.g.Sv(paramLinkedList))
        {
          parambo = parambo.field_content;
          paramString = parambo;
          if (!com.tencent.mm.plugin.backup.b.g.Sv(parambo))
          {
            ac.e("MicroMsg.BackupItemAppMsg", "get xml error ".concat(String.valueOf(parambo)));
            AppMethodBeat.o(21506);
            return 0;
          }
        }
        if (!bs.isNullOrNil(paramString))
        {
          parambo = new crm();
          parambo.aJV(bs.bG(paramString, ""));
          paramhy.DPV = parambo;
        }
        AppMethodBeat.o(21506);
        return i;
        j = parambo.field_content.getBytes().length;
        break;
      }
      ac.d("MicroMsg.BackupItemAppMsg", "content type " + ((k.b)localObject1).type);
      str = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().R(parambo.field_imgPath, true);
      if (com.tencent.mm.vfs.i.eA(str))
      {
        j += i.a(new i.a(str, paramhy, paramLinkedList, 6, paramBoolean1, "_thumb", paramBoolean2));
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
          if (!bs.isNullOrNil(((k.b)localObject1).cZa))
          {
            paramString = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEO().aGd(((k.b)localObject1).cZa);
            if ((paramString == null) || (!paramString.cOg()))
            {
              i = j;
              if (parambo.field_isSend == 1)
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
              parambo = paramString.field_fileFullPath;
              i = j;
              if (com.tencent.mm.vfs.i.eA(parambo))
              {
                ac.d("MicroMsg.BackupItemAppMsg", "image ".concat(String.valueOf(parambo)));
                i = j + i.a(new i.a(parambo, paramhy, paramLinkedList, 8, paramBoolean1, paramBoolean2, null));
                continue;
                com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEO().aGd(((k.b)localObject1).cZa);
                if ((localc == null) || (!localc.cOg()))
                {
                  i = j;
                  if (parambo.field_isSend == 1)
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
                  ac.d("MicroMsg.BackupItemAppMsg", "full path " + localc.field_fileFullPath);
                  i = j;
                  if (com.tencent.mm.vfs.i.eA(localc.field_fileFullPath)) {
                    if (paramBoolean1)
                    {
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramhy, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                    }
                    else
                    {
                      if ((com.tencent.mm.plugin.backup.b.d.bCS() == 1) && (((k.b)localObject1).hhF / 1024 >= paramLong) && (((k.b)localObject1).filemd5 != null))
                      {
                        if (parambo.field_isSend == 1) {
                          str = parambo.field_talker;
                        }
                        for (;;)
                        {
                          Object localObject2 = new com.tencent.mm.plugin.backup.i.u();
                          j += i.a(new i.a(localc.field_fileFullPath, paramhy, paramLinkedList, 7, paramBoolean1, true, (com.tencent.mm.plugin.backup.i.u)localObject2));
                          i = j;
                          if (paramHashMap == null) {
                            break;
                          }
                          paramhy = new h.a();
                          paramhy.mWT = ((com.tencent.mm.plugin.backup.i.u)localObject2);
                          paramhy.md5 = ((k.b)localObject1).filemd5;
                          paramhy.mWV = (paramString + "_" + str + "_" + parambo.field_msgSvrId + "_backup");
                          paramhy.mWU = parambo.field_msgSvrId;
                          paramHashMap.put(Long.valueOf(parambo.field_msgSvrId), paramhy);
                          i = j;
                          break;
                          localObject2 = parambo.field_talker;
                          str = paramString;
                          paramString = (String)localObject2;
                        }
                      }
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramhy, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                      continue;
                      paramString = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEO().aGd(((k.b)localObject1).cZa);
                      if ((paramString == null) || (!paramString.cOg()))
                      {
                        i = j;
                        if (parambo.field_isSend == 1)
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
                        ac.d("MicroMsg.BackupItemAppMsg", "full path " + paramString.field_fileFullPath);
                        i = j;
                        if (com.tencent.mm.vfs.i.eA(paramString.field_fileFullPath)) {
                          i = j + i.a(new i.a(paramString.field_fileFullPath, paramhy, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
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
      paramString = new pd();
      paramString.drQ.dqf = ((k.b)localObject1).hij;
      paramString.drQ.dbz = parambo.field_msgId;
      com.tencent.mm.sdk.b.a.GpY.l(paramString);
      ac.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.drR.drS });
      parambo = paramString.drR.drS.split(":");
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= parambo.length) {
          break;
        }
        i = j;
        if (com.tencent.mm.vfs.i.eA(parambo[k]))
        {
          ac.i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", new Object[] { parambo[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(parambo[k], paramhy, paramLinkedList, 7, paramBoolean1, "_fav.".concat(String.valueOf(k)), paramBoolean2));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(String paramString, hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21507);
    Object localObject3 = paramhy.DPT.FEm;
    Object localObject2 = paramhy.DPV.FEm;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21507);
      return 0;
    }
    parambo.setContent((String)localObject2);
    Object localObject1 = localObject2;
    if (parambo.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.h.c.sQ((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.h.c.yk(paramhy.DPV.FEm);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = (paramhy.DPV.FEm + " ").substring(i + 2).trim();
        }
      }
    }
    Object localObject4 = bs.aLx((String)localObject1);
    localObject3 = k.b.vA((String)localObject4);
    if (localObject3 == null)
    {
      ac.e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21507);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      parambo.setType(419430449);
      com.tencent.mm.plugin.backup.h.c.u(parambo);
      AppMethodBeat.o(21507);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      parambo.setType(m.f((k.b)localObject3));
      com.tencent.mm.plugin.backup.h.c.u(parambo);
      paramString = new pd();
      paramString.drQ.dqf = ((k.b)localObject3).hij;
      paramString.drQ.dbz = parambo.field_msgId;
      com.tencent.mm.sdk.b.a.GpY.l(paramString);
      ac.d("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.drR.drS });
      paramString = paramString.drR.drS.split(":");
      i = 0;
      while (i < paramString.length)
      {
        parambo = com.tencent.mm.plugin.backup.b.g.a(paramhy, 7, ".".concat(String.valueOf(i)));
        if (!bs.isNullOrNil(parambo))
        {
          ac.d("MicroMsg.BackupItemAppMsg", "record mediaId:%s, index:%d", new Object[] { parambo, Integer.valueOf(i) });
          com.tencent.mm.vfs.i.ma(com.tencent.mm.plugin.backup.b.g.Ss(parambo) + parambo, paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21507);
      return 0;
    }
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.h.d.bEP().bEQ();
    if (((com.tencent.mm.plugin.backup.h.b)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.h.b)localObject2).mZQ.get((com.tencent.mm.sdk.e.c)localObject1, new String[0])) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appVersion < ((k.b)localObject3).aBM)) {
      com.tencent.mm.plugin.backup.h.d.bEP().bER().h(1, ((k.b)localObject3).appId);
    }
    parambo.setType(m.f((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.b.g.b(paramhy, 6);
    if ((localObject1 != null) && (parambo.field_msgId == 0L))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().aa((byte[])localObject1);
      ac.d("MicroMsg.BackupItemAppMsg", "thumbData MsgInfo path:".concat(String.valueOf(localObject1)));
      if (!bs.isNullOrNil((String)localObject1)) {
        parambo.rf((String)localObject1);
      }
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.a(paramhy, 8);
    int i = com.tencent.mm.plugin.backup.b.g.c(paramhy, 8);
    localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2))
    {
      localObject1 = com.tencent.mm.plugin.backup.b.g.a(paramhy, 7);
      i = com.tencent.mm.plugin.backup.b.g.c(paramhy, 7);
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.Ss((String)localObject1) + (String)localObject1;
    com.tencent.mm.plugin.backup.h.c.u(parambo);
    k localk = new k();
    ((k.b)localObject3).a(localk);
    localk.field_msgId = parambo.field_msgId;
    com.tencent.mm.plugin.backup.h.b localb = com.tencent.mm.plugin.backup.h.d.bEP().bEQ();
    if (localb.uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    localb.mZP.insert(localk);
    long l;
    if (!bs.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awD();
      if (paramString.equals(paramhy.DPT.FEm)) {}
      for (paramString = paramhy.DPU.FEm;; paramString = paramhy.DPT.FEm)
      {
        localObject1 = ((h)localObject1).aF(paramString, paramhy.vTQ);
        paramhy = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEO().aGd(((k.b)localObject3).cZa);
        paramString = paramhy;
        if (paramhy != null) {
          break label1102;
        }
        ac.d("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
        l = ((dy)localObject1).field_msgId;
        localObject4 = k.b.vA((String)localObject4);
        if (localObject4 != null)
        {
          paramString = m.aj(com.tencent.mm.loader.j.b.apj(), ((k.b)localObject4).title, ((k.b)localObject4).hhG);
          int j = ((k.b)localObject4).sdkVer;
          paramhy = ((k.b)localObject4).appId;
          localObject1 = ((k.b)localObject4).cZa;
          int k = ((k.b)localObject4).hhF;
          localObject4 = new com.tencent.mm.pluginsdk.model.app.c();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath = paramString;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_appId = paramhy;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_sdkVer = j;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_mediaSvrId = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen = k;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_status = 101L;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_isUpload = false;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_createTime = bs.eWj();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_lastModifyTime = bs.aNx();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_msgInfoId = l;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_netTimes = 0L;
          if (!com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEO().insert((com.tencent.mm.sdk.e.c)localObject4)) {
            ac.e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramhy = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEO().aGd(((k.b)localObject3).cZa);
        if (paramhy != null) {
          break;
        }
        ac.e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).cZa });
        AppMethodBeat.o(21507);
        return 0;
      }
      paramString = paramhy;
      if (((k.b)localObject3).hhF != 0)
      {
        paramString = paramhy;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).hhF) {
            break label1167;
          }
          if (parambo.field_isSend != 1) {
            break label1155;
          }
          paramhy.field_status = 105L;
          paramString = paramhy;
        }
      }
    }
    for (;;)
    {
      label1102:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      com.tencent.mm.vfs.i.ma((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEO().a(paramString, new String[0]);
      AppMethodBeat.o(21507);
      return 0;
      label1155:
      paramhy.field_status = 102L;
      paramString = paramhy;
      continue;
      label1167:
      paramhy.field_status = 199L;
      paramString = paramhy;
    }
  }
  
  static final class a
  {
    public static String mSF = "<msg>";
    public static String mSG = "</msg>";
    public static String mWM = "]]>";
    
    public static String Sz(String paramString)
    {
      AppMethodBeat.i(21505);
      com.tencent.mm.ah.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(0L, paramString);
      a locala = new a(paramString);
      if (!locala.cyW)
      {
        ac.e("MicroMsg.AppmsgConvert", "buffer error");
        AppMethodBeat.o(21505);
        return "";
      }
      b localb = new b();
      Object localObject1 = localu.hkS;
      Object localObject3 = new HashMap();
      localb.SA("msg");
      ((Map)localObject3).put("appid", (String)locala.mWN.get(".msg.appmsg.$appid"));
      ((Map)localObject3).put("sdkver", (String)locala.mWN.get(".msg.appmsg.$sdkver"));
      localb.p("appmsg", (Map)localObject3);
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
        localb.en("title", str1);
        localb.en("des", (String)locala.mWN.get(".msg.appmsg.des"));
        localb.en("action", (String)locala.mWN.get(".msg.appmsg.action"));
        localb.ci("type", locala.getInt(".msg.appmsg.type"));
        localb.ci("showtype", locala.getInt(".msg.appmsg.showtype"));
        localb.en("content", (String)locala.mWN.get(".msg.appmsg.content"));
        localb.en("url", (String)localObject2);
        localb.en("lowurl", (String)locala.mWN.get(".msg.appmsg.lowurl"));
        localb.SA("appattach");
        localb.ci("totallen", locala.getInt(".msg.appmsg.appattach.totallen"));
        localb.en("attachid", (String)locala.mWN.get(".msg.appmsg.appattach.attachid"));
        localb.en("fileext", (String)locala.mWN.get(".msg.appmsg.appattach.fileext"));
        localb.SB("appattach");
        localb.SA("mmreader");
        ((Map)localObject3).put("type", localu.type);
        ((Map)localObject3).put("convMsgCount", paramString.size());
        localb.p("category", (Map)localObject3);
        localb.en("name", localu.dvm);
        localb.SA("topnew");
        localb.en("cover", (String)locala.mWN.get(".msg.appmsg.mmreader.category.topnew.cover"));
        localb.en("width", (String)locala.mWN.get(".msg.appmsg.mmreader.category.topnew.width"));
        localb.en("height", (String)locala.mWN.get(".msg.appmsg.mmreader.category.topnew.height"));
        localb.en("digest", (String)localObject1);
        localb.SB("topnew");
        i = 0;
        label560:
        if (i >= paramString.size()) {
          break label980;
        }
        localb.SA("item");
        if (paramString.get(i) != null)
        {
          localObject1 = ((v)paramString.get(i)).title;
          localObject2 = ((v)paramString.get(i)).url;
          str1 = ((v)paramString.get(i)).hlb;
          localObject3 = ((v)paramString.get(i)).hlc;
          String str2 = ((v)paramString.get(i)).time;
          String str3 = ((v)paramString.get(i)).hld;
          String str4 = ((v)paramString.get(i)).hle;
          String str5 = ((v)paramString.get(i)).hlf;
          localb.en("title", (String)localObject1);
          localb.en("url", (String)localObject2);
          localb.en("shorturl", str1);
          localb.en("longurl", (String)localObject3);
          localb.en("pub_time", str2);
          localb.en("cover", str3);
          localb.en("tweetid", str4);
          localb.en("digest", str5);
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
        localb.en("fileid", (String)locala.mWN.get((String)localObject1 + ".fileid"));
        localb.SA("source");
        localb.SA("source");
        localb.en("name", localu.dvm);
        localb.SB("source");
        localb.SB("source");
        localb.SB("item");
        i += 1;
        break label560;
        str1 = ((v)paramString.get(0)).title;
        localObject2 = ((v)paramString.get(0)).url;
        paramString.get(0);
        localObject1 = ((v)paramString.get(0)).hlf;
        break;
      }
      label980:
      localb.SB("category");
      localb.SA("publisher");
      localb.en("convName", localu.dvl);
      localb.en("nickname", localu.dvm);
      localb.SB("publisher");
      localb.SB("mmreader");
      localb.SB("appmsg");
      localb.en("fromusername", localu.dvl);
      localb.ci("scene", locala.getInt(".msg.scene"));
      localb.SA("appinfo");
      localb.en("version", (String)locala.mWN.get(".msg.appinfo.appname"));
      localb.en("appname", (String)locala.mWN.get(".msg.appinfo.version"));
      localb.SB("appinfo");
      localb.en("commenturl", localu.eSb);
      localb.SB("msg");
      ac.d("MicroMsg.AppmsgConvert", "xml " + localb.mWO.toString());
      paramString = localb.mWO.toString();
      AppMethodBeat.o(21505);
      return paramString;
    }
    
    static final class a
    {
      boolean cyW;
      Map<String, String> mWN;
      
      public a(String paramString)
      {
        AppMethodBeat.i(21495);
        this.mWN = null;
        this.cyW = true;
        this.mWN = bi.aLg(paramString);
        if (this.mWN == null)
        {
          this.cyW = false;
          this.mWN = new HashMap();
        }
        AppMethodBeat.o(21495);
      }
      
      final int getInt(String paramString)
      {
        AppMethodBeat.i(21496);
        if (!this.mWN.containsKey(paramString))
        {
          AppMethodBeat.o(21496);
          return 0;
        }
        int i = bs.getInt((String)this.mWN.get(paramString), 0);
        AppMethodBeat.o(21496);
        return i;
      }
    }
    
    static final class b
    {
      StringBuffer mWO;
      
      b()
      {
        AppMethodBeat.i(21497);
        this.mWO = new StringBuffer();
        AppMethodBeat.o(21497);
      }
      
      private void setText(int paramInt)
      {
        AppMethodBeat.i(21501);
        this.mWO.append(paramInt);
        AppMethodBeat.o(21501);
      }
      
      private void setText(String paramString)
      {
        AppMethodBeat.i(21500);
        if (bs.isNullOrNil(paramString))
        {
          AppMethodBeat.o(21500);
          return;
        }
        if (paramString.contains(a.a.mWM))
        {
          this.mWO.append("<![CDATA[" + bs.aLw(paramString) + "]]>");
          AppMethodBeat.o(21500);
          return;
        }
        this.mWO.append("<![CDATA[" + paramString + "]]>");
        AppMethodBeat.o(21500);
      }
      
      public final void SA(String paramString)
      {
        AppMethodBeat.i(21498);
        this.mWO.append("<" + paramString + ">");
        AppMethodBeat.o(21498);
      }
      
      public final void SB(String paramString)
      {
        AppMethodBeat.i(21499);
        this.mWO.append("</" + paramString + ">");
        AppMethodBeat.o(21499);
      }
      
      public final void ci(String paramString, int paramInt)
      {
        AppMethodBeat.i(21503);
        SA(paramString);
        setText(paramInt);
        SB(paramString);
        AppMethodBeat.o(21503);
      }
      
      public final void en(String paramString1, String paramString2)
      {
        AppMethodBeat.i(21502);
        SA(paramString1);
        setText(paramString2);
        SB(paramString1);
        AppMethodBeat.o(21502);
      }
      
      public final void p(String paramString, Map<String, String> paramMap)
      {
        AppMethodBeat.i(21504);
        this.mWO.append("<".concat(String.valueOf(paramString)));
        paramString = paramMap.keySet().iterator();
        while (paramString.hasNext())
        {
          String str1 = (String)paramString.next();
          String str2 = (String)paramMap.get(str1);
          this.mWO.append(" " + str1 + " =  \"" + str2 + "\" ");
        }
        this.mWO.append(">");
        paramMap.clear();
        AppMethodBeat.o(21504);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a
 * JD-Core Version:    0.7.0.1
 */