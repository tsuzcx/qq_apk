package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.mm;
import com.tencent.mm.h.a.mm.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  implements l
{
  private static int b(fo paramfo, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    int j;
    String str;
    int i;
    if (bk.bl(parambi.field_content))
    {
      j = 0;
      str = parambi.field_content;
      localObject1 = str;
      if (parambi.field_isSend != 1)
      {
        localObject1 = str;
        if (com.tencent.mm.plugin.backup.h.c.fn(parambi.field_talker))
        {
          i = parambi.field_content.indexOf(':');
          localObject1 = str;
          if (i != -1) {
            localObject1 = parambi.field_content.substring(i + 1);
          }
        }
      }
      localObject1 = bk.ZQ((String)localObject1);
      if (localObject1 == null) {
        break label1160;
      }
    }
    label1160:
    for (Object localObject1 = g.a.gp((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        y.e("MicroMsg.BackupItemAppMsg", "content is null");
        i = 0;
      }
      label113:
      do
      {
        do
        {
          do
          {
            do
            {
              com.tencent.mm.pluginsdk.model.app.b localb;
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return i;
                      j = parambi.field_content.getBytes().length;
                      break;
                      y.d("MicroMsg.BackupItemAppMsg", "content type " + ((g.a)localObject1).type);
                      str = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().F(parambi.field_imgPath, true);
                      if (com.tencent.mm.vfs.e.bK(str)) {
                        j += i.a(new i.a(str, paramfo, paramLinkedList, 6, paramBoolean1, "_thumb", paramBoolean2));
                      }
                      while (((g.a)localObject1).type != 2)
                      {
                        i = j;
                        switch (((g.a)localObject1).type)
                        {
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
                        default: 
                          return j;
                        case 2: 
                          i = j;
                          if (bk.bl(((g.a)localObject1).bFE)) {
                            break label113;
                          }
                          paramString = com.tencent.mm.plugin.backup.h.d.avi().avj().avh().VQ(((g.a)localObject1).bFE);
                          if ((paramString == null) || (!paramString.aXY()))
                          {
                            i = j;
                            if (parambi.field_isSend != 1) {
                              break label113;
                            }
                            i = j;
                            if (paramString == null) {
                              break label113;
                            }
                            i = j;
                            if (!paramString.field_isUpload) {
                              break label113;
                            }
                          }
                          parambi = paramString.field_fileFullPath;
                          i = j;
                          if (!com.tencent.mm.vfs.e.bK(parambi)) {
                            break label113;
                          }
                          y.d("MicroMsg.BackupItemAppMsg", "image " + parambi);
                          return j + i.a(new i.a(parambi, paramfo, paramLinkedList, 8, paramBoolean1, paramBoolean2, null));
                        }
                      }
                      return -1;
                      localb = com.tencent.mm.plugin.backup.h.d.avi().avj().avh().VQ(((g.a)localObject1).bFE);
                      if ((localb != null) && (localb.aXY())) {
                        break label547;
                      }
                      i = j;
                    } while (parambi.field_isSend != 1);
                    i = j;
                  } while (localb == null);
                  i = j;
                } while (!localb.field_isUpload);
                y.d("MicroMsg.BackupItemAppMsg", "full path " + localb.field_fileFullPath);
                i = j;
              } while (!com.tencent.mm.vfs.e.bK(localb.field_fileFullPath));
              if (paramBoolean1) {
                return j + i.a(new i.a(localb.field_fileFullPath, paramfo, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
              }
              if ((com.tencent.mm.plugin.backup.b.d.atq() == 1) && (((g.a)localObject1).dQv / 1024 >= paramLong) && (((g.a)localObject1).filemd5 != null))
              {
                if (parambi.field_isSend == 1) {
                  str = parambi.field_talker;
                }
                for (;;)
                {
                  Object localObject2 = new u();
                  j += i.a(new i.a(localb.field_fileFullPath, paramfo, paramLinkedList, 7, paramBoolean1, true, (u)localObject2));
                  i = j;
                  if (paramHashMap == null) {
                    break;
                  }
                  paramfo = new h.a();
                  paramfo.hJV = ((u)localObject2);
                  paramfo.bIW = ((g.a)localObject1).filemd5;
                  paramfo.hJX = (paramString + "_" + str + "_" + parambi.field_msgSvrId + "_backup");
                  paramfo.hJW = parambi.field_msgSvrId;
                  paramHashMap.put(Long.valueOf(parambi.field_msgSvrId), paramfo);
                  return j;
                  localObject2 = parambi.field_talker;
                  str = paramString;
                  paramString = (String)localObject2;
                }
              }
              return j + i.a(new i.a(localb.field_fileFullPath, paramfo, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
              paramString = com.tencent.mm.plugin.backup.h.d.avi().avj().avh().VQ(((g.a)localObject1).bFE);
              if ((paramString != null) && (paramString.aXY())) {
                break label907;
              }
              i = j;
            } while (parambi.field_isSend != 1);
            i = j;
          } while (paramString == null);
          i = j;
        } while (!paramString.field_isUpload);
        y.d("MicroMsg.BackupItemAppMsg", "full path " + paramString.field_fileFullPath);
        i = j;
      } while (!com.tencent.mm.vfs.e.bK(paramString.field_fileFullPath));
      label547:
      return j + i.a(new i.a(paramString.field_fileFullPath, paramfo, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
      label907:
      paramString = new mm();
      paramString.bVQ.bUr = ((g.a)localObject1).dRd;
      paramString.bVQ.bHR = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      y.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.bVR.bVS });
      parambi = paramString.bVR.bVS.split(":");
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= parambi.length) {
          break;
        }
        i = j;
        if (com.tencent.mm.vfs.e.bK(parambi[k]))
        {
          y.i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", new Object[] { parambi[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(parambi[k], paramfo, paramLinkedList, 7, paramBoolean1, "_fav." + k, paramBoolean2));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(fo paramfo, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    int i;
    switch (parambi.getType())
    {
    default: 
      i = b(paramfo, paramBoolean1, parambi, paramString, paramLinkedList, paramHashMap, paramBoolean2, paramLong);
    }
    int j;
    label112:
    do
    {
      return i;
      if (bk.bl(parambi.field_content)) {}
      for (j = 0;; j = parambi.field_content.getBytes().length)
      {
        i = j;
        if (paramBoolean1) {
          break;
        }
        parambi = a.a.xv(parambi.field_content);
        if (!bk.bl(parambi)) {
          break label112;
        }
        return 0;
      }
      paramString = new bml();
      paramString.YI(bk.aM(parambi, ""));
      paramfo.svH = paramString;
      return j;
      if (bk.bl(parambi.field_content)) {}
      for (j = 0; parambi.field_content == null; j = parambi.field_content.getBytes().length) {
        return -1;
      }
      paramHashMap = parambi.field_content;
      paramString = paramHashMap;
      if (!com.tencent.mm.plugin.backup.b.g.xr(paramHashMap))
      {
        paramHashMap = parambi.field_content;
        paramString = paramHashMap;
        if (!com.tencent.mm.plugin.backup.b.g.xr(paramHashMap))
        {
          y.e("MicroMsg.BackupItemAppMsg", "get xml error " + paramHashMap);
          return 0;
        }
      }
      i = j;
    } while (bk.bl(paramString));
    paramHashMap = new bml();
    paramHashMap.YI(bk.aM(paramString, ""));
    paramfo.svH = paramHashMap;
    paramHashMap = g.a.gp(paramString);
    String str = com.tencent.mm.plugin.backup.h.d.avi().avj().FL();
    paramString = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().F(parambi.field_imgPath, true);
    paramHashMap = str + paramHashMap.dQx;
    parambi = paramString;
    if (com.tencent.mm.vfs.e.aeQ(paramString) <= 0L)
    {
      paramString = paramHashMap + "_thumb";
      parambi = paramString;
      if (com.tencent.mm.vfs.e.aeQ(paramString) <= 0L) {
        return -1;
      }
    }
    return j + i.a(new i.a(parambi, paramfo, paramLinkedList, 6, paramBoolean1, "_thumb", paramBoolean2)) + i.a(new i.a(paramHashMap, paramfo, paramLinkedList, 5, paramBoolean1, paramBoolean2, null));
  }
  
  public final int a(String paramString, fo paramfo, bi parambi)
  {
    Object localObject3 = paramfo.svF.tFO;
    Object localObject2 = paramfo.svH.tFO;
    if (localObject2 == null) {
      return 0;
    }
    parambi.setContent((String)localObject2);
    Object localObject1 = localObject2;
    int i;
    if (parambi.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.h.c.fn((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.h.c.iH(paramfo.svH.tFO);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = (paramfo.svH.tFO + " ").substring(i + 2).trim();
        }
      }
    }
    Object localObject4 = bk.ZQ((String)localObject1);
    localObject3 = g.a.gp((String)localObject4);
    if (localObject3 == null)
    {
      y.e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
      return 0;
    }
    if (((g.a)localObject3).type == 2000)
    {
      parambi.setType(419430449);
      com.tencent.mm.plugin.backup.h.c.h(parambi);
      return 0;
    }
    if ((((g.a)localObject3).type == 19) || (((g.a)localObject3).type == 24))
    {
      parambi.setType(com.tencent.mm.pluginsdk.model.app.l.d((g.a)localObject3));
      com.tencent.mm.plugin.backup.h.c.h(parambi);
      paramString = new mm();
      paramString.bVQ.bUr = ((g.a)localObject3).dRd;
      paramString.bVQ.bHR = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      y.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.bVR.bVS });
      paramString = paramString.bVR.bVS.split(":");
      i = 0;
      while (i < paramString.length)
      {
        parambi = com.tencent.mm.plugin.backup.b.g.a(paramfo, 7, "." + i);
        if (!bk.bl(parambi))
        {
          y.i("MicroMsg.BackupItemAppMsg", "record media exit:%s, index:%d", new Object[] { parambi, Integer.valueOf(i) });
          com.tencent.mm.vfs.e.r(com.tencent.mm.plugin.backup.b.g.xp(parambi) + parambi, paramString[i]);
        }
        i += 1;
      }
      return 0;
    }
    localObject1 = new f();
    ((f)localObject1).field_appId = ((g.a)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.h.d.avi().avj();
    if (((com.tencent.mm.plugin.backup.h.b)localObject2).uin == 0) {
      throw new com.tencent.mm.model.b();
    }
    if ((((com.tencent.mm.plugin.backup.h.b)localObject2).hMU.b((com.tencent.mm.sdk.e.c)localObject1, new String[0])) && (((f)localObject1).field_appVersion < ((g.a)localObject3).cau)) {
      com.tencent.mm.plugin.backup.h.d.avi().avk().f(1, ((g.a)localObject3).appId);
    }
    parambi.setType(com.tencent.mm.pluginsdk.model.app.l.d((g.a)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.b.g.b(paramfo, 6);
    if ((localObject1 != null) && (parambi.field_msgId == 0L)) {
      if (((g.a)localObject3).type != 2) {
        break label729;
      }
    }
    com.tencent.mm.ae.g localg;
    com.tencent.mm.plugin.backup.h.b localb;
    label729:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().a((byte[])localObject1, bool, Bitmap.CompressFormat.PNG);
      y.d("MicroMsg.BackupItemAppMsg", com.tencent.mm.compatible.util.g.zI() + " thumbData MsgInfo path:" + (String)localObject1);
      if (!bk.bl((String)localObject1))
      {
        parambi.ed((String)localObject1);
        y.d("MicroMsg.BackupItemAppMsg", "new thumbnail saved, path:" + (String)localObject1);
      }
      localObject2 = com.tencent.mm.plugin.backup.b.g.a(paramfo, 8);
      i = com.tencent.mm.plugin.backup.b.g.c(paramfo, 8);
      localObject1 = localObject2;
      if (bk.bl((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.backup.b.g.a(paramfo, 7);
        i = com.tencent.mm.plugin.backup.b.g.c(paramfo, 7);
      }
      localObject2 = com.tencent.mm.plugin.backup.b.g.xp((String)localObject1) + (String)localObject1;
      com.tencent.mm.plugin.backup.h.c.h(parambi);
      localg = new com.tencent.mm.ae.g();
      ((g.a)localObject3).a(localg);
      localg.field_msgId = parambi.field_msgId;
      localb = com.tencent.mm.plugin.backup.h.d.avi().avj();
      if (localb.uin != 0) {
        break;
      }
      throw new com.tencent.mm.model.b();
    }
    localb.hMT.b(localg);
    long l;
    if (!bk.bl((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.avi().avj().Fy();
      if (paramString.equals(paramfo.svF.tFO)) {}
      for (paramString = paramfo.svG.tFO;; paramString = paramfo.svF.tFO)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject1).O(paramString, paramfo.ndp);
        paramfo = com.tencent.mm.plugin.backup.h.d.avi().avj().avh().VQ(((g.a)localObject3).bFE);
        paramString = paramfo;
        if (paramfo != null) {
          break label1120;
        }
        y.i("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
        l = ((cs)localObject1).field_msgId;
        localObject4 = g.a.gp((String)localObject4);
        if (localObject4 != null)
        {
          paramString = com.tencent.mm.pluginsdk.model.app.l.aj(com.tencent.mm.compatible.util.e.dzB, ((g.a)localObject4).title, ((g.a)localObject4).dQw);
          int j = ((g.a)localObject4).sdkVer;
          paramfo = ((g.a)localObject4).appId;
          localObject1 = ((g.a)localObject4).bFE;
          int k = ((g.a)localObject4).dQv;
          localObject4 = new com.tencent.mm.pluginsdk.model.app.b();
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_fileFullPath = paramString;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_appId = paramfo;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_sdkVer = j;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_mediaSvrId = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_totalLen = k;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_status = 101L;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_isUpload = false;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_createTime = bk.UY();
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_lastModifyTime = bk.UX();
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_msgInfoId = l;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_netTimes = 0L;
          if (!com.tencent.mm.plugin.backup.h.d.avi().avj().avh().b((com.tencent.mm.sdk.e.c)localObject4)) {
            y.e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramfo = com.tencent.mm.plugin.backup.h.d.avi().avj().avh().VQ(((g.a)localObject3).bFE);
        if (paramfo != null) {
          break;
        }
        y.e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((g.a)localObject3).bFE });
        return 0;
      }
      paramString = paramfo;
      if (((g.a)localObject3).dQv != 0)
      {
        paramString = paramfo;
        if (i != 0)
        {
          if (i >= ((g.a)localObject3).dQv) {
            break label1179;
          }
          if (parambi.field_isSend != 1) {
            break label1167;
          }
          paramfo.field_status = 105L;
          paramString = paramfo;
        }
      }
    }
    for (;;)
    {
      label1120:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      com.tencent.mm.vfs.e.r((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.h.d.avi().avj().avh().c(paramString, new String[0]);
      return 0;
      label1167:
      paramfo.field_status = 102L;
      paramString = paramfo;
      continue;
      label1179:
      paramfo.field_status = 199L;
      paramString = paramfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a
 * JD-Core Version:    0.7.0.1
 */