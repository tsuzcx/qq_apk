package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.nh.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  implements l
{
  private static int b(gx paramgx, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(17447);
    int j;
    String str;
    int i;
    if (bo.isNullOrNil(parambi.field_content))
    {
      j = 0;
      str = parambi.field_content;
      localObject1 = str;
      if (parambi.field_isSend != 1)
      {
        localObject1 = str;
        if (com.tencent.mm.plugin.backup.h.c.lA(parambi.field_talker))
        {
          i = parambi.field_content.indexOf(':');
          localObject1 = str;
          if (i != -1) {
            localObject1 = parambi.field_content.substring(i + 1);
          }
        }
      }
      localObject1 = bo.apU((String)localObject1);
      if (localObject1 == null) {
        break label1190;
      }
    }
    label1190:
    for (Object localObject1 = j.b.mY((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ab.e("MicroMsg.BackupItemAppMsg", "content is null");
        AppMethodBeat.o(17447);
        return 0;
        j = parambi.field_content.getBytes().length;
        break;
      }
      ab.d("MicroMsg.BackupItemAppMsg", "content type " + ((j.b)localObject1).type);
      str = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().J(parambi.field_imgPath, true);
      if (com.tencent.mm.vfs.e.cN(str))
      {
        j += i.a(new i.a(str, paramgx, paramLinkedList, 6, paramBoolean1, "_thumb", paramBoolean2));
        i = j;
      }
      switch (((j.b)localObject1).type)
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
          AppMethodBeat.o(17447);
          return i;
          if (((j.b)localObject1).type != 2) {
            break;
          }
          AppMethodBeat.o(17447);
          return -1;
          i = j;
          if (!bo.isNullOrNil(((j.b)localObject1).cmN))
          {
            paramString = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUJ().alo(((j.b)localObject1).cmN);
            if ((paramString == null) || (!paramString.bEL()))
            {
              i = j;
              if (parambi.field_isSend == 1)
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
              parambi = paramString.field_fileFullPath;
              i = j;
              if (com.tencent.mm.vfs.e.cN(parambi))
              {
                ab.d("MicroMsg.BackupItemAppMsg", "image ".concat(String.valueOf(parambi)));
                i = j + i.a(new i.a(parambi, paramgx, paramLinkedList, 8, paramBoolean1, paramBoolean2, null));
                continue;
                com.tencent.mm.pluginsdk.model.app.b localb = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUJ().alo(((j.b)localObject1).cmN);
                if ((localb == null) || (!localb.bEL()))
                {
                  i = j;
                  if (parambi.field_isSend == 1)
                  {
                    i = j;
                    if (localb != null)
                    {
                      i = j;
                      if (!localb.field_isUpload) {}
                    }
                  }
                }
                else
                {
                  ab.d("MicroMsg.BackupItemAppMsg", "full path " + localb.field_fileFullPath);
                  i = j;
                  if (com.tencent.mm.vfs.e.cN(localb.field_fileFullPath)) {
                    if (paramBoolean1)
                    {
                      i = j + i.a(new i.a(localb.field_fileFullPath, paramgx, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                    }
                    else
                    {
                      if ((com.tencent.mm.plugin.backup.b.d.aSO() == 1) && (((j.b)localObject1).fgw / 1024 >= paramLong) && (((j.b)localObject1).filemd5 != null))
                      {
                        if (parambi.field_isSend == 1) {
                          str = parambi.field_talker;
                        }
                        for (;;)
                        {
                          Object localObject2 = new u();
                          j += i.a(new i.a(localb.field_fileFullPath, paramgx, paramLinkedList, 7, paramBoolean1, true, (u)localObject2));
                          i = j;
                          if (paramHashMap == null) {
                            break;
                          }
                          paramgx = new h.a();
                          paramgx.jDy = ((u)localObject2);
                          paramgx.cqq = ((j.b)localObject1).filemd5;
                          paramgx.jDA = (paramString + "_" + str + "_" + parambi.field_msgSvrId + "_backup");
                          paramgx.jDz = parambi.field_msgSvrId;
                          paramHashMap.put(Long.valueOf(parambi.field_msgSvrId), paramgx);
                          i = j;
                          break;
                          localObject2 = parambi.field_talker;
                          str = paramString;
                          paramString = (String)localObject2;
                        }
                      }
                      i = j + i.a(new i.a(localb.field_fileFullPath, paramgx, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                      continue;
                      paramString = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUJ().alo(((j.b)localObject1).cmN);
                      if ((paramString == null) || (!paramString.bEL()))
                      {
                        i = j;
                        if (parambi.field_isSend == 1)
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
                        ab.d("MicroMsg.BackupItemAppMsg", "full path " + paramString.field_fileFullPath);
                        i = j;
                        if (com.tencent.mm.vfs.e.cN(paramString.field_fileFullPath)) {
                          i = j + i.a(new i.a(paramString.field_fileFullPath, paramgx, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
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
      paramString = new nh();
      paramString.cDD.cBW = ((j.b)localObject1).fhc;
      paramString.cDD.cpg = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.ymk.l(paramString);
      ab.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.cDE.cDF });
      parambi = paramString.cDE.cDF.split(":");
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= parambi.length) {
          break;
        }
        i = j;
        if (com.tencent.mm.vfs.e.cN(parambi[k]))
        {
          ab.i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", new Object[] { parambi[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(parambi[k], paramgx, paramLinkedList, 7, paramBoolean1, "_fav.".concat(String.valueOf(k)), paramBoolean2));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(gx paramgx, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(17446);
    switch (parambi.getType())
    {
    default: 
      i = b(paramgx, paramBoolean1, parambi, paramString, paramLinkedList, paramHashMap, paramBoolean2, paramLong);
      AppMethodBeat.o(17446);
      return i;
    case 285212721: 
    case 486539313: 
      if (bo.isNullOrNil(parambi.field_content)) {}
      for (i = 0; paramBoolean1; i = parambi.field_content.getBytes().length)
      {
        AppMethodBeat.o(17446);
        return i;
      }
      parambi = a.a.Go(parambi.field_content);
      if (bo.isNullOrNil(parambi))
      {
        AppMethodBeat.o(17446);
        return 0;
      }
      paramString = new bwc();
      paramString.aoF(bo.bf(parambi, ""));
      paramgx.woR = paramString;
      AppMethodBeat.o(17446);
      return i;
    }
    if (bo.isNullOrNil(parambi.field_content)) {}
    for (int i = 0; parambi.field_content == null; i = parambi.field_content.getBytes().length)
    {
      AppMethodBeat.o(17446);
      return -1;
    }
    paramHashMap = parambi.field_content;
    paramString = paramHashMap;
    if (!com.tencent.mm.plugin.backup.b.g.Gk(paramHashMap))
    {
      paramHashMap = parambi.field_content;
      paramString = paramHashMap;
      if (!com.tencent.mm.plugin.backup.b.g.Gk(paramHashMap))
      {
        ab.e("MicroMsg.BackupItemAppMsg", "get xml error ".concat(String.valueOf(paramHashMap)));
        AppMethodBeat.o(17446);
        return 0;
      }
    }
    int j = i;
    if (!bo.isNullOrNil(paramString))
    {
      paramHashMap = new bwc();
      paramHashMap.aoF(bo.bf(paramString, ""));
      paramgx.woR = paramHashMap;
      paramHashMap = j.b.mY(paramString);
      String str = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YP();
      paramString = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().J(parambi.field_imgPath, true);
      paramHashMap = str + paramHashMap.fgy;
      parambi = paramString;
      if (com.tencent.mm.vfs.e.avI(paramString) <= 0L) {
        parambi = paramHashMap + "_thumb";
      }
      j = i + i.a(new i.a(parambi, paramgx, paramLinkedList, 6, paramBoolean1, "_thumb", paramBoolean2)) + i.a(new i.a(paramHashMap, paramgx, paramLinkedList, 5, paramBoolean1, paramBoolean2, null));
    }
    AppMethodBeat.o(17446);
    return j;
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17448);
    Object localObject3 = paramgx.woP.xJE;
    Object localObject2 = paramgx.woR.xJE;
    if (localObject2 == null)
    {
      AppMethodBeat.o(17448);
      return 0;
    }
    parambi.setContent((String)localObject2);
    Object localObject1 = localObject2;
    int i;
    if (parambi.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.h.c.lA((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.h.c.pt(paramgx.woR.xJE);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = (paramgx.woR.xJE + " ").substring(i + 2).trim();
        }
      }
    }
    Object localObject4 = bo.apU((String)localObject1);
    localObject3 = j.b.mY((String)localObject4);
    if (localObject3 == null)
    {
      ab.e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(17448);
      return 0;
    }
    if (((j.b)localObject3).type == 2000)
    {
      parambi.setType(419430449);
      com.tencent.mm.plugin.backup.h.c.l(parambi);
      AppMethodBeat.o(17448);
      return 0;
    }
    if ((((j.b)localObject3).type == 19) || (((j.b)localObject3).type == 24))
    {
      parambi.setType(com.tencent.mm.pluginsdk.model.app.l.c((j.b)localObject3));
      com.tencent.mm.plugin.backup.h.c.l(parambi);
      paramString = new nh();
      paramString.cDD.cBW = ((j.b)localObject3).fhc;
      paramString.cDD.cpg = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.ymk.l(paramString);
      ab.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.cDE.cDF });
      paramString = paramString.cDE.cDF.split(":");
      i = 0;
      while (i < paramString.length)
      {
        parambi = com.tencent.mm.plugin.backup.b.g.a(paramgx, 7, ".".concat(String.valueOf(i)));
        if (!bo.isNullOrNil(parambi))
        {
          ab.i("MicroMsg.BackupItemAppMsg", "record media exit:%s, index:%d", new Object[] { parambi, Integer.valueOf(i) });
          com.tencent.mm.vfs.e.C(com.tencent.mm.plugin.backup.b.g.Gh(parambi) + parambi, paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(17448);
      return 0;
    }
    localObject1 = new f();
    ((f)localObject1).field_appId = ((j.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.h.d.aUK().aUL();
    if (((com.tencent.mm.plugin.backup.h.b)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(17448);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.h.b)localObject2).jGw.get((com.tencent.mm.sdk.e.c)localObject1, new String[0])) && (((f)localObject1).field_appVersion < ((j.b)localObject3).bDc)) {
      com.tencent.mm.plugin.backup.h.d.aUK().aUM().h(1, ((j.b)localObject3).appId);
    }
    parambi.setType(com.tencent.mm.pluginsdk.model.app.l.c((j.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.b.g.b(paramgx, 6);
    if ((localObject1 != null) && (parambi.field_msgId == 0L)) {
      if (((j.b)localObject3).type != 2) {
        break label761;
      }
    }
    j localj;
    com.tencent.mm.plugin.backup.h.b localb;
    label761:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().a((byte[])localObject1, bool, Bitmap.CompressFormat.PNG);
      ab.d("MicroMsg.BackupItemAppMsg", com.tencent.mm.compatible.util.g.Ml() + " thumbData MsgInfo path:" + (String)localObject1);
      if (!bo.isNullOrNil((String)localObject1))
      {
        parambi.kk((String)localObject1);
        ab.d("MicroMsg.BackupItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(localObject1)));
      }
      localObject2 = com.tencent.mm.plugin.backup.b.g.a(paramgx, 8);
      i = com.tencent.mm.plugin.backup.b.g.c(paramgx, 8);
      localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.backup.b.g.a(paramgx, 7);
        i = com.tencent.mm.plugin.backup.b.g.c(paramgx, 7);
      }
      localObject2 = com.tencent.mm.plugin.backup.b.g.Gh((String)localObject1) + (String)localObject1;
      com.tencent.mm.plugin.backup.h.c.l(parambi);
      localj = new j();
      ((j.b)localObject3).a(localj);
      localj.field_msgId = parambi.field_msgId;
      localb = com.tencent.mm.plugin.backup.h.d.aUK().aUL();
      if (localb.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(17448);
      throw paramString;
    }
    localb.jGv.insert(localj);
    long l;
    if (!bo.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YC();
      if (paramString.equals(paramgx.woP.xJE)) {}
      for (paramString = paramgx.woQ.xJE;; paramString = paramgx.woP.xJE)
      {
        localObject1 = ((h)localObject1).ag(paramString, paramgx.pIG);
        paramgx = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUJ().alo(((j.b)localObject3).cmN);
        paramString = paramgx;
        if (paramgx != null) {
          break label1158;
        }
        ab.i("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
        l = ((dd)localObject1).field_msgId;
        localObject4 = j.b.mY((String)localObject4);
        if (localObject4 != null)
        {
          paramString = com.tencent.mm.pluginsdk.model.app.l.Z(com.tencent.mm.compatible.util.e.esq, ((j.b)localObject4).title, ((j.b)localObject4).fgx);
          int j = ((j.b)localObject4).sdkVer;
          paramgx = ((j.b)localObject4).appId;
          localObject1 = ((j.b)localObject4).cmN;
          int k = ((j.b)localObject4).fgw;
          localObject4 = new com.tencent.mm.pluginsdk.model.app.b();
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_fileFullPath = paramString;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_appId = paramgx;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_sdkVer = j;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_mediaSvrId = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_totalLen = k;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_status = 101L;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_isUpload = false;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_createTime = bo.aoy();
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_lastModifyTime = bo.aox();
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_msgInfoId = l;
          ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_netTimes = 0L;
          if (!com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUJ().insert((com.tencent.mm.sdk.e.c)localObject4)) {
            ab.e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramgx = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUJ().alo(((j.b)localObject3).cmN);
        if (paramgx != null) {
          break;
        }
        ab.e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((j.b)localObject3).cmN });
        AppMethodBeat.o(17448);
        return 0;
      }
      paramString = paramgx;
      if (((j.b)localObject3).fgw != 0)
      {
        paramString = paramgx;
        if (i != 0)
        {
          if (i >= ((j.b)localObject3).fgw) {
            break label1223;
          }
          if (parambi.field_isSend != 1) {
            break label1211;
          }
          paramgx.field_status = 105L;
          paramString = paramgx;
        }
      }
    }
    for (;;)
    {
      label1158:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      com.tencent.mm.vfs.e.C((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUJ().a(paramString, new String[0]);
      AppMethodBeat.o(17448);
      return 0;
      label1211:
      paramgx.field_status = 102L;
      paramString = paramgx;
      continue;
      label1223:
      paramgx.field_status = 199L;
      paramString = paramgx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a
 * JD-Core Version:    0.7.0.1
 */