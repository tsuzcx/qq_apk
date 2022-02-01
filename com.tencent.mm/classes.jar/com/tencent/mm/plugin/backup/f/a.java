package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.pn.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  implements l
{
  public final int a(if paramif, boolean paramBoolean1, bu parambu, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21506);
    int j;
    String str;
    int i;
    switch (parambu.getType())
    {
    default: 
      if (bt.isNullOrNil(parambu.field_content))
      {
        j = 0;
        str = parambu.field_content;
        localObject1 = str;
        if (parambu.field_isSend != 1)
        {
          localObject1 = str;
          if (com.tencent.mm.plugin.backup.h.c.vF(parambu.field_talker))
          {
            i = parambu.field_content.indexOf(':');
            localObject1 = str;
            if (i != -1) {
              localObject1 = parambu.field_content.substring(i + 1);
            }
          }
        }
        localObject1 = bt.aRd((String)localObject1);
        if (localObject1 == null) {
          break label1478;
        }
      }
      break;
    }
    label1478:
    for (Object localObject1 = k.b.yr((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ad.e("MicroMsg.BackupItemAppMsg", "content is null");
        AppMethodBeat.o(21506);
        return 0;
        if (bt.isNullOrNil(parambu.field_content)) {}
        for (i = 0; paramBoolean1; i = parambu.field_content.getBytes().length)
        {
          AppMethodBeat.o(21506);
          return i;
        }
        parambu = a.a.VX(parambu.field_content);
        if (bt.isNullOrNil(parambu))
        {
          AppMethodBeat.o(21506);
          return 0;
        }
        paramString = new cwt();
        paramString.aPy(bt.bI(parambu, ""));
        paramif.Fvk = paramString;
        AppMethodBeat.o(21506);
        return i;
        if (bt.isNullOrNil(parambu.field_content)) {}
        for (i = 0; parambu.field_content == null; i = parambu.field_content.getBytes().length)
        {
          AppMethodBeat.o(21506);
          return -1;
        }
        paramLinkedList = parambu.field_content;
        paramString = paramLinkedList;
        if (!com.tencent.mm.plugin.backup.b.g.VT(paramLinkedList))
        {
          parambu = parambu.field_content;
          paramString = parambu;
          if (!com.tencent.mm.plugin.backup.b.g.VT(parambu))
          {
            ad.e("MicroMsg.BackupItemAppMsg", "get xml error ".concat(String.valueOf(parambu)));
            AppMethodBeat.o(21506);
            return 0;
          }
        }
        if (!bt.isNullOrNil(paramString))
        {
          parambu = new cwt();
          parambu.aPy(bt.bI(paramString, ""));
          paramif.Fvk = parambu;
        }
        AppMethodBeat.o(21506);
        return i;
        j = parambu.field_content.getBytes().length;
        break;
      }
      ad.d("MicroMsg.BackupItemAppMsg", "content type " + ((k.b)localObject1).type);
      str = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().R(parambu.field_imgPath, true);
      if (com.tencent.mm.vfs.i.fv(str))
      {
        j += i.a(new i.a(str, paramif, paramLinkedList, 6, paramBoolean1, "_thumb", paramBoolean2));
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
          if (!bt.isNullOrNil(((k.b)localObject1).dks))
          {
            paramString = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIX().aLD(((k.b)localObject1).dks);
            if ((paramString == null) || (!paramString.cWz()))
            {
              i = j;
              if (parambu.field_isSend == 1)
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
              parambu = paramString.field_fileFullPath;
              i = j;
              if (com.tencent.mm.vfs.i.fv(parambu))
              {
                ad.d("MicroMsg.BackupItemAppMsg", "image ".concat(String.valueOf(parambu)));
                i = j + i.a(new i.a(parambu, paramif, paramLinkedList, 8, paramBoolean1, paramBoolean2, null));
                continue;
                com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIX().aLD(((k.b)localObject1).dks);
                if ((localc == null) || (!localc.cWz()))
                {
                  i = j;
                  if (parambu.field_isSend == 1)
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
                  ad.d("MicroMsg.BackupItemAppMsg", "full path " + localc.field_fileFullPath);
                  i = j;
                  if (com.tencent.mm.vfs.i.fv(localc.field_fileFullPath)) {
                    if (paramBoolean1)
                    {
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramif, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                    }
                    else
                    {
                      if ((com.tencent.mm.plugin.backup.b.d.bHa() == 1) && (((k.b)localObject1).hzO / 1024 >= paramLong) && (((k.b)localObject1).filemd5 != null))
                      {
                        if (parambu.field_isSend == 1) {
                          str = parambu.field_talker;
                        }
                        for (;;)
                        {
                          Object localObject2 = new u();
                          j += i.a(new i.a(localc.field_fileFullPath, paramif, paramLinkedList, 7, paramBoolean1, true, (u)localObject2));
                          i = j;
                          if (paramHashMap == null) {
                            break;
                          }
                          paramif = new h.a();
                          paramif.nxq = ((u)localObject2);
                          paramif.md5 = ((k.b)localObject1).filemd5;
                          paramif.nxs = (paramString + "_" + str + "_" + parambu.field_msgSvrId + "_backup");
                          paramif.nxr = parambu.field_msgSvrId;
                          paramHashMap.put(Long.valueOf(parambu.field_msgSvrId), paramif);
                          i = j;
                          break;
                          localObject2 = parambu.field_talker;
                          str = paramString;
                          paramString = (String)localObject2;
                        }
                      }
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramif, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                      continue;
                      paramString = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIX().aLD(((k.b)localObject1).dks);
                      if ((paramString == null) || (!paramString.cWz()))
                      {
                        i = j;
                        if (parambu.field_isSend == 1)
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
                        ad.d("MicroMsg.BackupItemAppMsg", "full path " + paramString.field_fileFullPath);
                        i = j;
                        if (com.tencent.mm.vfs.i.fv(paramString.field_fileFullPath)) {
                          i = j + i.a(new i.a(paramString.field_fileFullPath, paramif, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
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
      paramString = new pn();
      paramString.dDK.dBS = ((k.b)localObject1).hAs;
      paramString.dDK.dmV = parambu.field_msgId;
      com.tencent.mm.sdk.b.a.IbL.l(paramString);
      ad.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.dDL.dDM });
      parambu = paramString.dDL.dDM.split(":");
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= parambu.length) {
          break;
        }
        i = j;
        if (com.tencent.mm.vfs.i.fv(parambu[k]))
        {
          ad.i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", new Object[] { parambu[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(parambu[k], paramif, paramLinkedList, 7, paramBoolean1, "_fav.".concat(String.valueOf(k)), paramBoolean2));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(String paramString, if paramif, bu parambu)
  {
    AppMethodBeat.i(21507);
    Object localObject3 = paramif.Fvi.HoB;
    Object localObject2 = paramif.Fvk.HoB;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21507);
      return 0;
    }
    parambu.setContent((String)localObject2);
    Object localObject1 = localObject2;
    if (parambu.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.h.c.vF((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.h.c.Bj(paramif.Fvk.HoB);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = (paramif.Fvk.HoB + " ").substring(i + 2).trim();
        }
      }
    }
    Object localObject4 = bt.aRd((String)localObject1);
    localObject3 = k.b.yr((String)localObject4);
    if (localObject3 == null)
    {
      ad.e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21507);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      parambu.setType(419430449);
      com.tencent.mm.plugin.backup.h.c.v(parambu);
      AppMethodBeat.o(21507);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      parambu.setType(m.g((k.b)localObject3));
      com.tencent.mm.plugin.backup.h.c.v(parambu);
      paramString = new pn();
      paramString.dDK.dBS = ((k.b)localObject3).hAs;
      paramString.dDK.dmV = parambu.field_msgId;
      com.tencent.mm.sdk.b.a.IbL.l(paramString);
      ad.d("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.dDL.dDM });
      paramString = paramString.dDL.dDM.split(":");
      i = 0;
      while (i < paramString.length)
      {
        parambu = com.tencent.mm.plugin.backup.b.g.a(paramif, 7, ".".concat(String.valueOf(i)));
        if (!bt.isNullOrNil(parambu))
        {
          ad.d("MicroMsg.BackupItemAppMsg", "record mediaId:%s, index:%d", new Object[] { parambu, Integer.valueOf(i) });
          com.tencent.mm.vfs.i.mA(com.tencent.mm.plugin.backup.b.g.VQ(parambu) + parambu, paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21507);
      return 0;
    }
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.h.d.bIY().bIZ();
    if (((com.tencent.mm.plugin.backup.h.b)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.h.b)localObject2).nAn.get((com.tencent.mm.sdk.e.c)localObject1, new String[0])) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appVersion < ((k.b)localObject3).aDD)) {
      com.tencent.mm.plugin.backup.h.d.bIY().bJa().h(1, ((k.b)localObject3).appId);
    }
    parambu.setType(m.g((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.b.g.b(paramif, 6);
    if ((localObject1 != null) && (parambu.field_msgId == 0L))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().aa((byte[])localObject1);
      ad.d("MicroMsg.BackupItemAppMsg", "thumbData MsgInfo path:".concat(String.valueOf(localObject1)));
      if (!bt.isNullOrNil((String)localObject1)) {
        parambu.tO((String)localObject1);
      }
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.a(paramif, 8);
    int i = com.tencent.mm.plugin.backup.b.g.c(paramif, 8);
    localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      localObject1 = com.tencent.mm.plugin.backup.b.g.a(paramif, 7);
      i = com.tencent.mm.plugin.backup.b.g.c(paramif, 7);
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.VQ((String)localObject1) + (String)localObject1;
    com.tencent.mm.plugin.backup.h.c.v(parambu);
    k localk = new k();
    ((k.b)localObject3).a(localk);
    localk.field_msgId = parambu.field_msgId;
    com.tencent.mm.plugin.backup.h.b localb = com.tencent.mm.plugin.backup.h.d.bIY().bIZ();
    if (localb.uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    localb.nAm.insert(localk);
    long l;
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azs();
      if (paramString.equals(paramif.Fvi.HoB)) {}
      for (paramString = paramif.Fvj.HoB;; paramString = paramif.Fvi.HoB)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aI(paramString, paramif.xbt);
        paramif = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIX().aLD(((k.b)localObject3).dks);
        paramString = paramif;
        if (paramif != null) {
          break label1102;
        }
        ad.d("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
        l = ((ei)localObject1).field_msgId;
        localObject4 = k.b.yr((String)localObject4);
        if (localObject4 != null)
        {
          paramString = m.aq(com.tencent.mm.loader.j.b.arX(), ((k.b)localObject4).title, ((k.b)localObject4).hzP);
          int j = ((k.b)localObject4).sdkVer;
          paramif = ((k.b)localObject4).appId;
          localObject1 = ((k.b)localObject4).dks;
          int k = ((k.b)localObject4).hzO;
          localObject4 = new com.tencent.mm.pluginsdk.model.app.c();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath = paramString;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_appId = paramif;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_sdkVer = j;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_mediaSvrId = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen = k;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_status = 101L;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_isUpload = false;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_createTime = bt.flT();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_lastModifyTime = bt.aQJ();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_msgInfoId = l;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_netTimes = 0L;
          if (!com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIX().insert((com.tencent.mm.sdk.e.c)localObject4)) {
            ad.e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramif = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIX().aLD(((k.b)localObject3).dks);
        if (paramif != null) {
          break;
        }
        ad.e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).dks });
        AppMethodBeat.o(21507);
        return 0;
      }
      paramString = paramif;
      if (((k.b)localObject3).hzO != 0)
      {
        paramString = paramif;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).hzO) {
            break label1167;
          }
          if (parambu.field_isSend != 1) {
            break label1155;
          }
          paramif.field_status = 105L;
          paramString = paramif;
        }
      }
    }
    for (;;)
    {
      label1102:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      com.tencent.mm.vfs.i.mA((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIX().a(paramString, new String[0]);
      AppMethodBeat.o(21507);
      return 0;
      label1155:
      paramif.field_status = 102L;
      paramString = paramif;
      continue;
      label1167:
      paramif.field_status = 199L;
      paramString = paramif;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a
 * JD-Core Version:    0.7.0.1
 */