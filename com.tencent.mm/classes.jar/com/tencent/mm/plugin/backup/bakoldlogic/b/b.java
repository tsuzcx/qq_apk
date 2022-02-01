package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.v;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.g.a.pd.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
  implements j
{
  private static int b(hy paramhy, bo parambo, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(21836);
    int j;
    Object localObject2;
    int i;
    if (bs.isNullOrNil(parambo.field_content))
    {
      j = 0;
      localObject2 = parambo.field_content;
      localObject1 = localObject2;
      if (parambo.field_isSend != 1)
      {
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.sQ(parambo.field_talker))
        {
          i = parambo.field_content.indexOf(':');
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = parambo.field_content.substring(i + 1);
          }
        }
      }
      localObject1 = bs.aLx((String)localObject1);
      if (localObject1 == null) {
        break label992;
      }
    }
    label992:
    for (Object localObject1 = k.b.vA((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ac.e("MicroMsg.BakOldItemAppMsg", "content is null");
        AppMethodBeat.o(21836);
        return 0;
        j = parambo.field_content.getBytes().length;
        break;
      }
      ac.d("MicroMsg.BakOldItemAppMsg", "content type " + ((k.b)localObject1).type);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().bEM().R(parambo.field_imgPath, true);
      if (com.tencent.mm.vfs.i.eA((String)localObject2))
      {
        j += i.a(new i.a((String)localObject2, paramhy, paramLinkedList, 6, "_thumb"));
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
          AppMethodBeat.o(21836);
          return i;
          if (((k.b)localObject1).type != 2) {
            break;
          }
          AppMethodBeat.o(21836);
          return -1;
          i = j;
          if (!bs.isNullOrNil(((k.b)localObject1).cZa))
          {
            localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().bEO().aGd(((k.b)localObject1).cZa);
            if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject1).cOg()))
            {
              i = j;
              if (parambo.field_isSend == 1)
              {
                i = j;
                if (localObject1 != null)
                {
                  i = j;
                  if (!((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload) {}
                }
              }
            }
            else
            {
              parambo = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
              i = j;
              if (com.tencent.mm.vfs.i.eA(parambo))
              {
                ac.d("MicroMsg.BakOldItemAppMsg", "image ".concat(String.valueOf(parambo)));
                i = j + i.a(new i.a(parambo, paramhy, paramLinkedList, 8, false, null));
                continue;
                localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().bEO().aGd(((k.b)localObject1).cZa);
                if ((localObject2 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject2).cOg()))
                {
                  i = j;
                  if (parambo.field_isSend == 1)
                  {
                    i = j;
                    if (localObject2 != null)
                    {
                      i = j;
                      if (!((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_isUpload) {}
                    }
                  }
                }
                else
                {
                  ac.d("MicroMsg.BakOldItemAppMsg", "full path " + ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
                  i = j;
                  if (com.tencent.mm.vfs.i.eA(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath)) {
                    if ((com.tencent.mm.plugin.backup.b.d.bCS() == 1) && (((k.b)localObject1).hhF / 1024 >= 0L) && (((k.b)localObject1).filemd5 != null))
                    {
                      parambo = new com.tencent.mm.plugin.backup.i.u();
                      i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath, paramhy, paramLinkedList, 7, true, parambo));
                    }
                    else
                    {
                      i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath, paramhy, paramLinkedList, 7, false, null));
                      continue;
                      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().bEO().aGd(((k.b)localObject1).cZa);
                      if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject1).cOg()))
                      {
                        i = j;
                        if (parambo.field_isSend == 1)
                        {
                          i = j;
                          if (localObject1 != null)
                          {
                            i = j;
                            if (!((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload) {}
                          }
                        }
                      }
                      else
                      {
                        ac.d("MicroMsg.BakOldItemAppMsg", "full path " + ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
                        i = j;
                        if (com.tencent.mm.vfs.i.eA(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) {
                          i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, paramhy, paramLinkedList, 7, false, null));
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
      localObject2 = new pd();
      ((pd)localObject2).drQ.dqf = ((k.b)localObject1).hij;
      ((pd)localObject2).drQ.dbz = parambo.field_msgId;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
      ac.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { ((pd)localObject2).drR.drS });
      parambo = ((pd)localObject2).drR.drS.split(":");
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
          ac.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", new Object[] { parambo[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(parambo[k], paramhy, paramLinkedList, 7, "_fav.".concat(String.valueOf(k))));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(hy paramhy, bo parambo, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(21835);
    switch (parambo.getType())
    {
    default: 
      i = b(paramhy, parambo, paramLinkedList);
      AppMethodBeat.o(21835);
      return i;
    case 285212721: 
      if (bs.isNullOrNil(parambo.field_content)) {}
      for (i = 0;; i = parambo.field_content.getBytes().length)
      {
        parambo = a.Sz(parambo.field_content);
        if (!bs.isNullOrNil(parambo)) {
          break;
        }
        AppMethodBeat.o(21835);
        return 0;
      }
      paramLinkedList = new crm();
      paramLinkedList.aJV(bs.bG(parambo, ""));
      paramhy.DPV = paramLinkedList;
      AppMethodBeat.o(21835);
      return i;
    }
    if (bs.isNullOrNil(parambo.field_content)) {}
    for (int i = 0; parambo.field_content == null; i = parambo.field_content.getBytes().length)
    {
      AppMethodBeat.o(21835);
      return -1;
    }
    Object localObject2 = au.aOb(parambo.field_content).GXs.trim();
    Object localObject1 = localObject2;
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.Sv((String)localObject2))
    {
      localObject2 = parambo.field_content;
      localObject1 = localObject2;
      if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.Sv((String)localObject2))
      {
        ac.e("MicroMsg.BakOldItemAppMsg", "get xml error ".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(21835);
        return 0;
      }
    }
    int j = i;
    if (!bs.isNullOrNil((String)localObject1))
    {
      localObject2 = new crm();
      ((crm)localObject2).aJV(bs.bG((String)localObject1, ""));
      paramhy.DPV = ((crm)localObject2);
      localObject1 = k.b.vA((String)localObject1);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().awQ();
      parambo = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().bEM().R(parambo.field_imgPath, true);
      localObject1 = (String)localObject2 + ((k.b)localObject1).hhH;
      if (com.tencent.mm.vfs.i.aSp(parambo) <= 0L)
      {
        AppMethodBeat.o(21835);
        return -1;
      }
      j = i.a(new i.a(parambo, paramhy, paramLinkedList, 6, "_thumb"));
      parambo = au.aOb(z.a(paramhy.DPV));
      j = j + i + i.a(new i.a((String)localObject1, paramhy, paramLinkedList, com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().bEN().aOT(parambo.md5)));
    }
    AppMethodBeat.o(21835);
    return j;
  }
  
  public final int a(String paramString, hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21837);
    Object localObject3 = paramhy.DPT.FEm;
    Object localObject2 = paramhy.DPV.FEm;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21837);
      return 0;
    }
    parambo.setContent((String)localObject2);
    Object localObject1 = localObject2;
    int i;
    if (parambo.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.sQ((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.bakoldlogic.d.d.yk(paramhy.DPV.FEm);
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
      ac.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21837);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      parambo.setType(419430449);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.u(parambo);
      AppMethodBeat.o(21837);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      parambo.setType(m.f((k.b)localObject3));
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.u(parambo);
      paramString = new pd();
      paramString.drQ.dqf = ((k.b)localObject3).hij;
      paramString.drQ.dbz = parambo.field_msgId;
      com.tencent.mm.sdk.b.a.GpY.l(paramString);
      ac.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramString.drR.drS });
      paramString = paramString.drR.drS.split(":");
      i = 0;
      while (i < paramString.length)
      {
        parambo = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramhy, 7, ".".concat(String.valueOf(i)));
        if (!bs.isNullOrNil(parambo))
        {
          ac.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", new Object[] { parambo, Integer.valueOf(i) });
          com.tencent.mm.vfs.i.lZ(com.tencent.mm.plugin.backup.bakoldlogic.a.a.SI(parambo), paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21837);
      return 0;
    }
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx();
    if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).mZQ.get((com.tencent.mm.sdk.e.c)localObject1, new String[0])) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appVersion < ((k.b)localObject3).aBM)) {
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFy().i(1, ((k.b)localObject3).appId);
    }
    parambo.setType(m.f((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramhy, 6);
    if ((localObject1 != null) && (parambo.field_msgId == 0L)) {
      if (((k.b)localObject3).type != 2) {
        break label725;
      }
    }
    k localk;
    com.tencent.mm.plugin.backup.bakoldlogic.d.c localc;
    label725:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().bEM().a((byte[])localObject1, bool, Bitmap.CompressFormat.PNG);
      ac.d("MicroMsg.BakOldItemAppMsg", com.tencent.mm.compatible.util.f.YG() + " thumbData MsgInfo path:" + (String)localObject1);
      if (!bs.isNullOrNil((String)localObject1))
      {
        parambo.rf((String)localObject1);
        ac.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(localObject1)));
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramhy, 8);
      i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramhy, 8);
      localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramhy, 7);
        i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramhy, 7);
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.SI((String)localObject1);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.u(parambo);
      localk = new k();
      ((k.b)localObject3).a(localk);
      localk.field_msgId = parambo.field_msgId;
      localc = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx();
      if (localc.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    localc.mZP.insert(localk);
    long l;
    if (!bs.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().awD();
      if (paramString.equals(paramhy.DPT.FEm)) {}
      for (paramString = paramhy.DPU.FEm;; paramString = paramhy.DPT.FEm)
      {
        localObject1 = ((h)localObject1).aF(paramString, paramhy.vTQ);
        paramhy = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().bEO().aGd(((k.b)localObject3).cZa);
        paramString = paramhy;
        if (paramhy != null) {
          break label1122;
        }
        ac.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
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
          if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().bEO().insert((com.tencent.mm.sdk.e.c)localObject4)) {
            ac.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramhy = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().bEO().aGd(((k.b)localObject3).cZa);
        if (paramhy != null) {
          break;
        }
        ac.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).cZa });
        AppMethodBeat.o(21837);
        return 0;
      }
      paramString = paramhy;
      if (((k.b)localObject3).hhF != 0)
      {
        paramString = paramhy;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).hhF) {
            break label1187;
          }
          if (parambo.field_isSend != 1) {
            break label1175;
          }
          paramhy.field_status = 105L;
          paramString = paramhy;
        }
      }
    }
    for (;;)
    {
      label1122:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      com.tencent.mm.vfs.i.mb((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().bEO().a(paramString, new String[0]);
      AppMethodBeat.o(21837);
      return 0;
      label1175:
      paramhy.field_status = 102L;
      paramString = paramhy;
      continue;
      label1187:
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
      AppMethodBeat.i(21834);
      com.tencent.mm.ah.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(0L, paramString);
      a locala = new a(paramString);
      if (!locala.cyW)
      {
        ac.e("MicroMsg.AppmsgConvert", "buffer error");
        AppMethodBeat.o(21834);
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
      AppMethodBeat.o(21834);
      return paramString;
    }
    
    static final class a
    {
      boolean cyW;
      Map<String, String> mWN;
      
      public a(String paramString)
      {
        AppMethodBeat.i(21824);
        this.mWN = null;
        this.cyW = true;
        this.mWN = bi.aLg(paramString);
        if (this.mWN == null)
        {
          this.cyW = false;
          this.mWN = new HashMap();
        }
        AppMethodBeat.o(21824);
      }
      
      final int getInt(String paramString)
      {
        AppMethodBeat.i(21825);
        if (!this.mWN.containsKey(paramString))
        {
          AppMethodBeat.o(21825);
          return 0;
        }
        int i = bs.getInt((String)this.mWN.get(paramString), 0);
        AppMethodBeat.o(21825);
        return i;
      }
    }
    
    static final class b
    {
      StringBuffer mWO;
      
      b()
      {
        AppMethodBeat.i(21826);
        this.mWO = new StringBuffer();
        AppMethodBeat.o(21826);
      }
      
      private void setText(int paramInt)
      {
        AppMethodBeat.i(21830);
        this.mWO.append(paramInt);
        AppMethodBeat.o(21830);
      }
      
      private void setText(String paramString)
      {
        AppMethodBeat.i(21829);
        if (bs.isNullOrNil(paramString))
        {
          AppMethodBeat.o(21829);
          return;
        }
        if (paramString.contains(b.a.mWM))
        {
          this.mWO.append("<![CDATA[" + bs.aLw(paramString) + "]]>");
          AppMethodBeat.o(21829);
          return;
        }
        this.mWO.append("<![CDATA[" + paramString + "]]>");
        AppMethodBeat.o(21829);
      }
      
      public final void SA(String paramString)
      {
        AppMethodBeat.i(21827);
        this.mWO.append("<" + paramString + ">");
        AppMethodBeat.o(21827);
      }
      
      public final void SB(String paramString)
      {
        AppMethodBeat.i(21828);
        this.mWO.append("</" + paramString + ">");
        AppMethodBeat.o(21828);
      }
      
      public final void ci(String paramString, int paramInt)
      {
        AppMethodBeat.i(21832);
        SA(paramString);
        setText(paramInt);
        SB(paramString);
        AppMethodBeat.o(21832);
      }
      
      public final void en(String paramString1, String paramString2)
      {
        AppMethodBeat.i(21831);
        SA(paramString1);
        setText(paramString2);
        SB(paramString1);
        AppMethodBeat.o(21831);
      }
      
      public final void p(String paramString, Map<String, String> paramMap)
      {
        AppMethodBeat.i(21833);
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
        AppMethodBeat.o(21833);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b
 * JD-Core Version:    0.7.0.1
 */