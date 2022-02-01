package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.v;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.a.ou.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bl;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements j
{
  private static int b(hu paramhu, bl parambl, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(21836);
    int j;
    Object localObject2;
    int i;
    if (bt.isNullOrNil(parambl.field_content))
    {
      j = 0;
      localObject2 = parambl.field_content;
      localObject1 = localObject2;
      if (parambl.field_isSend != 1)
      {
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.pF(parambl.field_talker))
        {
          i = parambl.field_content.indexOf(':');
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = parambl.field_content.substring(i + 1);
          }
        }
      }
      localObject1 = bt.aGg((String)localObject1);
      if (localObject1 == null) {
        break label992;
      }
    }
    label992:
    for (Object localObject1 = k.b.rx((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ad.e("MicroMsg.BakOldItemAppMsg", "content is null");
        AppMethodBeat.o(21836);
        return 0;
        j = parambl.field_content.getBytes().length;
        break;
      }
      ad.d("MicroMsg.BakOldItemAppMsg", "content type " + ((k.b)localObject1).type);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().bxQ().Q(parambl.field_imgPath, true);
      if (com.tencent.mm.vfs.i.eK((String)localObject2))
      {
        j += i.a(new i.a((String)localObject2, paramhu, paramLinkedList, 6, "_thumb"));
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
          if (!bt.isNullOrNil(((k.b)localObject1).dbA))
          {
            localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().bxS().aAL(((k.b)localObject1).dbA);
            if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject1).cAX()))
            {
              i = j;
              if (parambl.field_isSend == 1)
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
              parambl = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
              i = j;
              if (com.tencent.mm.vfs.i.eK(parambl))
              {
                ad.d("MicroMsg.BakOldItemAppMsg", "image ".concat(String.valueOf(parambl)));
                i = j + i.a(new i.a(parambl, paramhu, paramLinkedList, 8, false, null));
                continue;
                localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().bxS().aAL(((k.b)localObject1).dbA);
                if ((localObject2 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject2).cAX()))
                {
                  i = j;
                  if (parambl.field_isSend == 1)
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
                  ad.d("MicroMsg.BakOldItemAppMsg", "full path " + ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
                  i = j;
                  if (com.tencent.mm.vfs.i.eK(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath)) {
                    if ((com.tencent.mm.plugin.backup.b.d.bvW() == 1) && (((k.b)localObject1).gHe / 1024 >= 0L) && (((k.b)localObject1).filemd5 != null))
                    {
                      parambl = new com.tencent.mm.plugin.backup.i.u();
                      i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath, paramhu, paramLinkedList, 7, true, parambl));
                    }
                    else
                    {
                      i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath, paramhu, paramLinkedList, 7, false, null));
                      continue;
                      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().bxS().aAL(((k.b)localObject1).dbA);
                      if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject1).cAX()))
                      {
                        i = j;
                        if (parambl.field_isSend == 1)
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
                        ad.d("MicroMsg.BakOldItemAppMsg", "full path " + ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
                        i = j;
                        if (com.tencent.mm.vfs.i.eK(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) {
                          i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, paramhu, paramLinkedList, 7, false, null));
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
      localObject2 = new ou();
      ((ou)localObject2).duf.dsv = ((k.b)localObject1).gHI;
      ((ou)localObject2).duf.ded = parambl.field_msgId;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
      ad.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { ((ou)localObject2).dug.duh });
      parambl = ((ou)localObject2).dug.duh.split(":");
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= parambl.length) {
          break;
        }
        i = j;
        if (com.tencent.mm.vfs.i.eK(parambl[k]))
        {
          ad.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", new Object[] { parambl[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(parambl[k], paramhu, paramLinkedList, 7, "_fav.".concat(String.valueOf(k))));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(hu paramhu, bl parambl, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(21835);
    switch (parambl.getType())
    {
    default: 
      i = b(paramhu, parambl, paramLinkedList);
      AppMethodBeat.o(21835);
      return i;
    case 285212721: 
      if (bt.isNullOrNil(parambl.field_content)) {}
      for (i = 0;; i = parambl.field_content.getBytes().length)
      {
        parambl = a.Op(parambl.field_content);
        if (!bt.isNullOrNil(parambl)) {
          break;
        }
        AppMethodBeat.o(21835);
        return 0;
      }
      paramLinkedList = new cmf();
      paramLinkedList.aEE(bt.by(parambl, ""));
      paramhu.Cxz = paramLinkedList;
      AppMethodBeat.o(21835);
      return i;
    }
    if (bt.isNullOrNil(parambl.field_content)) {}
    for (int i = 0; parambl.field_content == null; i = parambl.field_content.getBytes().length)
    {
      AppMethodBeat.o(21835);
      return -1;
    }
    Object localObject2 = ar.aIF(parambl.field_content).Fys.trim();
    Object localObject1 = localObject2;
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.Ol((String)localObject2))
    {
      localObject2 = parambl.field_content;
      localObject1 = localObject2;
      if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.Ol((String)localObject2))
      {
        ad.e("MicroMsg.BakOldItemAppMsg", "get xml error ".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(21835);
        return 0;
      }
    }
    int j = i;
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject2 = new cmf();
      ((cmf)localObject2).aEE(bt.by((String)localObject1, ""));
      paramhu.Cxz = ((cmf)localObject2);
      localObject1 = k.b.rx((String)localObject1);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().aqb();
      parambl = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().bxQ().Q(parambl.field_imgPath, true);
      localObject1 = (String)localObject2 + ((k.b)localObject1).gHg;
      if (com.tencent.mm.vfs.i.aMN(parambl) <= 0L)
      {
        AppMethodBeat.o(21835);
        return -1;
      }
      j = i.a(new i.a(parambl, paramhu, paramLinkedList, 6, "_thumb"));
      parambl = ar.aIF(z.a(paramhu.Cxz));
      j = j + i + i.a(new i.a((String)localObject1, paramhu, paramLinkedList, com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().bxR().aJx(parambl.md5)));
    }
    AppMethodBeat.o(21835);
    return j;
  }
  
  public final int a(String paramString, hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21837);
    Object localObject3 = paramhu.Cxx.Ehn;
    Object localObject2 = paramhu.Cxz.Ehn;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21837);
      return 0;
    }
    parambl.setContent((String)localObject2);
    Object localObject1 = localObject2;
    int i;
    if (parambl.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.pF((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.bakoldlogic.d.d.ue(paramhu.Cxz.Ehn);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = (paramhu.Cxz.Ehn + " ").substring(i + 2).trim();
        }
      }
    }
    Object localObject4 = bt.aGg((String)localObject1);
    localObject3 = k.b.rx((String)localObject4);
    if (localObject3 == null)
    {
      ad.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21837);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      parambl.setType(419430449);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.u(parambl);
      AppMethodBeat.o(21837);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      parambl.setType(m.f((k.b)localObject3));
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.u(parambl);
      paramString = new ou();
      paramString.duf.dsv = ((k.b)localObject3).gHI;
      paramString.duf.ded = parambl.field_msgId;
      com.tencent.mm.sdk.b.a.ESL.l(paramString);
      ad.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramString.dug.duh });
      paramString = paramString.dug.duh.split(":");
      i = 0;
      while (i < paramString.length)
      {
        parambl = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramhu, 7, ".".concat(String.valueOf(i)));
        if (!bt.isNullOrNil(parambl))
        {
          ad.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", new Object[] { parambl, Integer.valueOf(i) });
          com.tencent.mm.vfs.i.lC(com.tencent.mm.plugin.backup.bakoldlogic.a.a.Oy(parambl), paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21837);
      return 0;
    }
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB();
    if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).mxP.get((com.tencent.mm.sdk.e.c)localObject1, new String[0])) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appVersion < ((k.b)localObject3).aAS)) {
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byC().i(1, ((k.b)localObject3).appId);
    }
    parambl.setType(m.f((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramhu, 6);
    if ((localObject1 != null) && (parambl.field_msgId == 0L)) {
      if (((k.b)localObject3).type != 2) {
        break label725;
      }
    }
    k localk;
    com.tencent.mm.plugin.backup.bakoldlogic.d.c localc;
    label725:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().bxQ().a((byte[])localObject1, bool, Bitmap.CompressFormat.PNG);
      ad.d("MicroMsg.BakOldItemAppMsg", com.tencent.mm.compatible.util.f.XJ() + " thumbData MsgInfo path:" + (String)localObject1);
      if (!bt.isNullOrNil((String)localObject1))
      {
        parambl.nZ((String)localObject1);
        ad.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(localObject1)));
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramhu, 8);
      i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramhu, 8);
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramhu, 7);
        i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramhu, 7);
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.Oy((String)localObject1);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.u(parambl);
      localk = new k();
      ((k.b)localObject3).a(localk);
      localk.field_msgId = parambl.field_msgId;
      localc = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB();
      if (localc.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    localc.mxO.insert(localk);
    long l;
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().apO();
      if (paramString.equals(paramhu.Cxx.Ehn)) {}
      for (paramString = paramhu.Cxy.Ehn;; paramString = paramhu.Cxx.Ehn)
      {
        localObject1 = ((h)localObject1).aD(paramString, paramhu.uKZ);
        paramhu = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().bxS().aAL(((k.b)localObject3).dbA);
        paramString = paramhu;
        if (paramhu != null) {
          break label1122;
        }
        ad.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
        l = ((du)localObject1).field_msgId;
        localObject4 = k.b.rx((String)localObject4);
        if (localObject4 != null)
        {
          paramString = m.ai(com.tencent.mm.loader.j.b.aij(), ((k.b)localObject4).title, ((k.b)localObject4).gHf);
          int j = ((k.b)localObject4).sdkVer;
          paramhu = ((k.b)localObject4).appId;
          localObject1 = ((k.b)localObject4).dbA;
          int k = ((k.b)localObject4).gHe;
          localObject4 = new com.tencent.mm.pluginsdk.model.app.c();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath = paramString;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_appId = paramhu;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_sdkVer = j;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_mediaSvrId = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen = k;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_status = 101L;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_isUpload = false;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_createTime = bt.eGO();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_lastModifyTime = bt.aGK();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_msgInfoId = l;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_netTimes = 0L;
          if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().bxS().insert((com.tencent.mm.sdk.e.c)localObject4)) {
            ad.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramhu = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().bxS().aAL(((k.b)localObject3).dbA);
        if (paramhu != null) {
          break;
        }
        ad.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).dbA });
        AppMethodBeat.o(21837);
        return 0;
      }
      paramString = paramhu;
      if (((k.b)localObject3).gHe != 0)
      {
        paramString = paramhu;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).gHe) {
            break label1187;
          }
          if (parambl.field_isSend != 1) {
            break label1175;
          }
          paramhu.field_status = 105L;
          paramString = paramhu;
        }
      }
    }
    for (;;)
    {
      label1122:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      com.tencent.mm.vfs.i.lE((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().bxS().a(paramString, new String[0]);
      AppMethodBeat.o(21837);
      return 0;
      label1175:
      paramhu.field_status = 102L;
      paramString = paramhu;
      continue;
      label1187:
      paramhu.field_status = 199L;
      paramString = paramhu;
    }
  }
  
  static final class a
  {
    public static String mqD = "<msg>";
    public static String mqE = "</msg>";
    public static String muL = "]]>";
    
    public static String Op(String paramString)
    {
      AppMethodBeat.i(21834);
      com.tencent.mm.ai.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(0L, paramString);
      a locala = new a(paramString);
      if (!locala.cBN)
      {
        ad.e("MicroMsg.AppmsgConvert", "buffer error");
        AppMethodBeat.o(21834);
        return "";
      }
      b.a.b localb = new b.a.b();
      Object localObject1 = localu.gKs;
      Object localObject3 = new HashMap();
      localb.Oq("msg");
      ((Map)localObject3).put("appid", (String)locala.muM.get(".msg.appmsg.$appid"));
      ((Map)localObject3).put("sdkver", (String)locala.muM.get(".msg.appmsg.$sdkver"));
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
        localb.eb("title", str1);
        localb.eb("des", (String)locala.muM.get(".msg.appmsg.des"));
        localb.eb("action", (String)locala.muM.get(".msg.appmsg.action"));
        localb.cd("type", locala.getInt(".msg.appmsg.type"));
        localb.cd("showtype", locala.getInt(".msg.appmsg.showtype"));
        localb.eb("content", (String)locala.muM.get(".msg.appmsg.content"));
        localb.eb("url", (String)localObject2);
        localb.eb("lowurl", (String)locala.muM.get(".msg.appmsg.lowurl"));
        localb.Oq("appattach");
        localb.cd("totallen", locala.getInt(".msg.appmsg.appattach.totallen"));
        localb.eb("attachid", (String)locala.muM.get(".msg.appmsg.appattach.attachid"));
        localb.eb("fileext", (String)locala.muM.get(".msg.appmsg.appattach.fileext"));
        localb.Or("appattach");
        localb.Oq("mmreader");
        ((Map)localObject3).put("type", localu.type);
        ((Map)localObject3).put("convMsgCount", paramString.size());
        localb.p("category", (Map)localObject3);
        localb.eb("name", localu.dxA);
        localb.Oq("topnew");
        localb.eb("cover", (String)locala.muM.get(".msg.appmsg.mmreader.category.topnew.cover"));
        localb.eb("width", (String)locala.muM.get(".msg.appmsg.mmreader.category.topnew.width"));
        localb.eb("height", (String)locala.muM.get(".msg.appmsg.mmreader.category.topnew.height"));
        localb.eb("digest", (String)localObject1);
        localb.Or("topnew");
        i = 0;
        label560:
        if (i >= paramString.size()) {
          break label980;
        }
        localb.Oq("item");
        if (paramString.get(i) != null)
        {
          localObject1 = ((v)paramString.get(i)).title;
          localObject2 = ((v)paramString.get(i)).url;
          str1 = ((v)paramString.get(i)).gKB;
          localObject3 = ((v)paramString.get(i)).gKC;
          String str2 = ((v)paramString.get(i)).time;
          String str3 = ((v)paramString.get(i)).gKD;
          String str4 = ((v)paramString.get(i)).gKE;
          String str5 = ((v)paramString.get(i)).gKF;
          localb.eb("title", (String)localObject1);
          localb.eb("url", (String)localObject2);
          localb.eb("shorturl", str1);
          localb.eb("longurl", (String)localObject3);
          localb.eb("pub_time", str2);
          localb.eb("cover", str3);
          localb.eb("tweetid", str4);
          localb.eb("digest", str5);
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
        localb.eb("fileid", (String)locala.muM.get((String)localObject1 + ".fileid"));
        localb.Oq("source");
        localb.Oq("source");
        localb.eb("name", localu.dxA);
        localb.Or("source");
        localb.Or("source");
        localb.Or("item");
        i += 1;
        break label560;
        str1 = ((v)paramString.get(0)).title;
        localObject2 = ((v)paramString.get(0)).url;
        paramString.get(0);
        localObject1 = ((v)paramString.get(0)).gKF;
        break;
      }
      label980:
      localb.Or("category");
      localb.Oq("publisher");
      localb.eb("convName", localu.dxz);
      localb.eb("nickname", localu.dxA);
      localb.Or("publisher");
      localb.Or("mmreader");
      localb.Or("appmsg");
      localb.eb("fromusername", localu.dxz);
      localb.cd("scene", locala.getInt(".msg.scene"));
      localb.Oq("appinfo");
      localb.eb("version", (String)locala.muM.get(".msg.appinfo.appname"));
      localb.eb("appname", (String)locala.muM.get(".msg.appinfo.version"));
      localb.Or("appinfo");
      localb.eb("commenturl", localu.eOT);
      localb.Or("msg");
      ad.d("MicroMsg.AppmsgConvert", "xml " + localb.muN.toString());
      paramString = localb.muN.toString();
      AppMethodBeat.o(21834);
      return paramString;
    }
    
    static final class a
    {
      boolean cBN;
      Map<String, String> muM;
      
      public a(String paramString)
      {
        AppMethodBeat.i(21824);
        this.muM = null;
        this.cBN = true;
        this.muM = bj.aFP(paramString);
        if (this.muM == null)
        {
          this.cBN = false;
          this.muM = new HashMap();
        }
        AppMethodBeat.o(21824);
      }
      
      final int getInt(String paramString)
      {
        AppMethodBeat.i(21825);
        if (!this.muM.containsKey(paramString))
        {
          AppMethodBeat.o(21825);
          return 0;
        }
        int i = bt.getInt((String)this.muM.get(paramString), 0);
        AppMethodBeat.o(21825);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b
 * JD-Core Version:    0.7.0.1
 */