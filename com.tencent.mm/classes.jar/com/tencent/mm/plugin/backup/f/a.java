package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.re;
import com.tencent.mm.f.a.re.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.cm;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  implements l
{
  public final int a(ih paramih, boolean paramBoolean1, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
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
          if (com.tencent.mm.plugin.backup.h.c.Lj(paramca.field_talker))
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
    for (Object localObject1 = k.b.OQ((String)localObject1);; localObject1 = null)
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
        paramca = a.a.aoj(paramca.field_content);
        if (Util.isNullOrNil(paramca))
        {
          AppMethodBeat.o(21506);
          return 0;
        }
        paramString = new eaf();
        paramString.btQ(Util.nullAs(paramca, ""));
        paramih.RIF = paramString;
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
        if (!com.tencent.mm.plugin.backup.b.g.aof(paramLinkedList))
        {
          paramca = paramca.field_content;
          paramString = paramca;
          if (!com.tencent.mm.plugin.backup.b.g.aof(paramca))
          {
            Log.e("MicroMsg.BackupItemAppMsg", "get xml error ".concat(String.valueOf(paramca)));
            AppMethodBeat.o(21506);
            return 0;
          }
        }
        if (!Util.isNullOrNil(paramString))
        {
          paramca = new eaf();
          paramca.btQ(Util.nullAs(paramString, ""));
          paramih.RIF = paramca;
        }
        AppMethodBeat.o(21506);
        return i;
        j = paramca.field_content.getBytes().length;
        break;
      }
      Log.d("MicroMsg.BackupItemAppMsg", "content type " + ((k.b)localObject1).type);
      str = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().T(paramca.field_imgPath, true);
      if (com.tencent.mm.vfs.u.agG(str))
      {
        j += i.a(new i.a(str, paramih, paramLinkedList, 6, paramBoolean1, "_thumb", paramBoolean2));
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
          if (!Util.isNullOrNil(((k.b)localObject1).fvr))
          {
            paramString = com.tencent.mm.plugin.backup.h.d.cua().cub().ctZ().bpR(((k.b)localObject1).fvr);
            if ((paramString == null) || (!paramString.evg()))
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
              if (com.tencent.mm.vfs.u.agG(paramca))
              {
                Log.d("MicroMsg.BackupItemAppMsg", "image ".concat(String.valueOf(paramca)));
                i = j + i.a(new i.a(paramca, paramih, paramLinkedList, 8, paramBoolean1, paramBoolean2, null));
                continue;
                com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.plugin.backup.h.d.cua().cub().ctZ().bpR(((k.b)localObject1).fvr);
                if ((localc == null) || (!localc.evg()))
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
                  if (com.tencent.mm.vfs.u.agG(localc.field_fileFullPath)) {
                    if (paramBoolean1)
                    {
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramih, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                    }
                    else
                    {
                      if ((com.tencent.mm.plugin.backup.b.d.csc() == 1) && (((k.b)localObject1).llX / 1024 >= paramLong) && (((k.b)localObject1).filemd5 != null))
                      {
                        if (paramca.field_isSend == 1) {
                          str = paramca.field_talker;
                        }
                        for (;;)
                        {
                          Object localObject2 = new com.tencent.mm.plugin.backup.i.u();
                          j += i.a(new i.a(localc.field_fileFullPath, paramih, paramLinkedList, 7, paramBoolean1, true, (com.tencent.mm.plugin.backup.i.u)localObject2));
                          i = j;
                          if (paramHashMap == null) {
                            break;
                          }
                          paramih = new h.a();
                          paramih.rPE = ((com.tencent.mm.plugin.backup.i.u)localObject2);
                          paramih.md5 = ((k.b)localObject1).filemd5;
                          paramih.rPG = (paramString + "_" + str + "_" + paramca.field_msgSvrId + "_backup");
                          paramih.rPF = paramca.field_msgSvrId;
                          paramHashMap.put(Long.valueOf(paramca.field_msgSvrId), paramih);
                          i = j;
                          break;
                          localObject2 = paramca.field_talker;
                          str = paramString;
                          paramString = (String)localObject2;
                        }
                      }
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramih, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                      continue;
                      paramString = com.tencent.mm.plugin.backup.h.d.cua().cub().ctZ().bpR(((k.b)localObject1).fvr);
                      if ((paramString == null) || (!paramString.evg()))
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
                        if (com.tencent.mm.vfs.u.agG(paramString.field_fileFullPath)) {
                          i = j + i.a(new i.a(paramString.field_fileFullPath, paramih, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
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
      paramString = new re();
      paramString.fQg.xml = ((k.b)localObject1).lmA;
      paramString.fQg.fxU = paramca.field_msgId;
      EventCenter.instance.publish(paramString);
      Log.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.fQh.fQi });
      paramca = paramString.fQh.fQi.split(":");
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= paramca.length) {
          break;
        }
        i = j;
        if (com.tencent.mm.vfs.u.agG(paramca[k]))
        {
          Log.i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", new Object[] { paramca[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(paramca[k], paramih, paramLinkedList, 7, paramBoolean1, "_fav.".concat(String.valueOf(k)), paramBoolean2));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(String paramString, ih paramih, ca paramca)
  {
    AppMethodBeat.i(21507);
    Object localObject3 = paramih.RID.Ufy;
    Object localObject2 = paramih.RIF.Ufy;
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
      if (com.tencent.mm.plugin.backup.h.c.Lj((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.h.c.RK(paramih.RIF.Ufy);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = (paramih.RIF.Ufy + " ").substring(i + 2).trim();
        }
      }
    }
    Object localObject4 = Util.processXml((String)localObject1);
    localObject3 = k.b.OQ((String)localObject4);
    if (localObject3 == null)
    {
      Log.e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21507);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      paramca.setType(419430449);
      com.tencent.mm.plugin.backup.h.c.z(paramca);
      AppMethodBeat.o(21507);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      paramca.setType(m.g((k.b)localObject3));
      com.tencent.mm.plugin.backup.h.c.z(paramca);
      paramString = new re();
      paramString.fQg.xml = ((k.b)localObject3).lmA;
      paramString.fQg.fxU = paramca.field_msgId;
      EventCenter.instance.publish(paramString);
      Log.d("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.fQh.fQi });
      paramString = paramString.fQh.fQi.split(":");
      i = 0;
      while (i < paramString.length)
      {
        paramca = com.tencent.mm.plugin.backup.b.g.a(paramih, 7, ".".concat(String.valueOf(i)));
        if (!Util.isNullOrNil(paramca))
        {
          Log.d("MicroMsg.BackupItemAppMsg", "record mediaId:%s, index:%d", new Object[] { paramca, Integer.valueOf(i) });
          com.tencent.mm.vfs.u.oo(com.tencent.mm.plugin.backup.b.g.aoc(paramca) + paramca, paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21507);
      return 0;
    }
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.h.d.cua().cub();
    if (((com.tencent.mm.plugin.backup.h.b)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.h.b)localObject2).rSC.get((IAutoDBItem)localObject1, new String[0])) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appVersion < ((k.b)localObject3).appVersion)) {
      com.tencent.mm.plugin.backup.h.d.cua().cuc().l(1, ((k.b)localObject3).appId);
    }
    paramca.setType(m.g((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.b.g.b(paramih, 6);
    if ((localObject1 != null) && (paramca.field_msgId == 0L))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().aA((byte[])localObject1);
      Log.d("MicroMsg.BackupItemAppMsg", "thumbData MsgInfo path:".concat(String.valueOf(localObject1)));
      if (!Util.isNullOrNil((String)localObject1)) {
        paramca.Jn((String)localObject1);
      }
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.a(paramih, 8);
    int i = com.tencent.mm.plugin.backup.b.g.c(paramih, 8);
    localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject1 = com.tencent.mm.plugin.backup.b.g.a(paramih, 7);
      i = com.tencent.mm.plugin.backup.b.g.c(paramih, 7);
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.aoc((String)localObject1) + (String)localObject1;
    com.tencent.mm.plugin.backup.h.c.z(paramca);
    k localk = new k();
    ((k.b)localObject3).a(localk);
    localk.field_msgId = paramca.field_msgId;
    com.tencent.mm.plugin.backup.h.b localb = com.tencent.mm.plugin.backup.h.d.cua().cub();
    if (localb.uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    localb.rSB.insert(localk);
    long l;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.cua().cub().bbO();
      if (paramString.equals(paramih.RID.Ufy)) {}
      for (paramString = paramih.RIE.Ufy;; paramString = paramih.RID.Ufy)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aL(paramString, paramih.HlH);
        paramih = com.tencent.mm.plugin.backup.h.d.cua().cub().ctZ().bpR(((k.b)localObject3).fvr);
        paramString = paramih;
        if (paramih != null) {
          break label1102;
        }
        Log.d("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
        l = ((et)localObject1).field_msgId;
        localObject4 = k.b.OQ((String)localObject4);
        if (localObject4 != null)
        {
          paramString = m.aw(com.tencent.mm.loader.j.b.aSO(), ((k.b)localObject4).title, ((k.b)localObject4).llY);
          int j = ((k.b)localObject4).sdkVer;
          paramih = ((k.b)localObject4).appId;
          localObject1 = ((k.b)localObject4).fvr;
          int k = ((k.b)localObject4).llX;
          localObject4 = new com.tencent.mm.pluginsdk.model.app.c();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath = paramString;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_appId = paramih;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_sdkVer = j;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_mediaSvrId = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen = k;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_status = 101L;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_isUpload = false;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_createTime = cm.bfC();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_lastModifyTime = Util.nowSecond();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_msgInfoId = l;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_netTimes = 0L;
          if (!com.tencent.mm.plugin.backup.h.d.cua().cub().ctZ().insert((IAutoDBItem)localObject4)) {
            Log.e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramih = com.tencent.mm.plugin.backup.h.d.cua().cub().ctZ().bpR(((k.b)localObject3).fvr);
        if (paramih != null) {
          break;
        }
        Log.e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).fvr });
        AppMethodBeat.o(21507);
        return 0;
      }
      paramString = paramih;
      if (((k.b)localObject3).llX != 0)
      {
        paramString = paramih;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).llX) {
            break label1167;
          }
          if (paramca.field_isSend != 1) {
            break label1155;
          }
          paramih.field_status = 105L;
          paramString = paramih;
        }
      }
    }
    for (;;)
    {
      label1102:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      com.tencent.mm.vfs.u.oo((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.h.d.cua().cub().ctZ().a(paramString, new String[0]);
      AppMethodBeat.o(21507);
      return 0;
      label1155:
      paramih.field_status = 102L;
      paramString = paramih;
      continue;
      label1167:
      paramih.field_status = 199L;
      paramString = paramih;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a
 * JD-Core Version:    0.7.0.1
 */