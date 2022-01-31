package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.mm;
import com.tencent.mm.h.a.mm.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements j
{
  private static int b(fo paramfo, bi parambi, LinkedList<u> paramLinkedList)
  {
    int j;
    Object localObject2;
    int i;
    if (bk.bl(parambi.field_content))
    {
      j = 0;
      localObject2 = parambi.field_content;
      localObject1 = localObject2;
      if (parambi.field_isSend != 1)
      {
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.fn(parambi.field_talker))
        {
          i = parambi.field_content.indexOf(':');
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = parambi.field_content.substring(i + 1);
          }
        }
      }
      localObject1 = bk.ZQ((String)localObject1);
      if (localObject1 == null) {
        break label1000;
      }
    }
    label1000:
    for (Object localObject1 = g.a.gp((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        y.e("MicroMsg.BakOldItemAppMsg", "content is null");
        return 0;
        j = parambi.field_content.getBytes().length;
        break;
      }
      y.d("MicroMsg.BakOldItemAppMsg", "content type " + ((g.a)localObject1).type);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().F(parambi.field_imgPath, true);
      if (com.tencent.mm.vfs.e.bK((String)localObject2))
      {
        j += i.a(new i.a((String)localObject2, paramfo, paramLinkedList, 6, "_thumb"));
        i = j;
      }
      switch (((g.a)localObject1).type)
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
          return i;
          if (((g.a)localObject1).type != 2) {
            break;
          }
          return -1;
          i = j;
          if (!bk.bl(((g.a)localObject1).bFE))
          {
            localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avh().VQ(((g.a)localObject1).bFE);
            if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.b)localObject1).aXY()))
            {
              i = j;
              if (parambi.field_isSend == 1)
              {
                i = j;
                if (localObject1 != null)
                {
                  i = j;
                  if (!((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_isUpload) {}
                }
              }
            }
            else
            {
              parambi = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath;
              i = j;
              if (com.tencent.mm.vfs.e.bK(parambi))
              {
                y.d("MicroMsg.BakOldItemAppMsg", "image " + parambi);
                i = j + i.a(new i.a(parambi, paramfo, paramLinkedList, 8, false, null));
                continue;
                localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avh().VQ(((g.a)localObject1).bFE);
                if ((localObject2 == null) || (!((com.tencent.mm.pluginsdk.model.app.b)localObject2).aXY()))
                {
                  i = j;
                  if (parambi.field_isSend == 1)
                  {
                    i = j;
                    if (localObject2 != null)
                    {
                      i = j;
                      if (!((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_isUpload) {}
                    }
                  }
                }
                else
                {
                  y.d("MicroMsg.BakOldItemAppMsg", "full path " + ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
                  i = j;
                  if (com.tencent.mm.vfs.e.bK(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath))
                  {
                    if ((com.tencent.mm.plugin.backup.b.d.atq() == 1) && (((g.a)localObject1).dQv / 1024 >= 0L) && (((g.a)localObject1).filemd5 != null))
                    {
                      if (parambi.field_isSend == 1) {}
                      for (parambi = parambi.field_talker;; parambi = parambi.field_talker)
                      {
                        parambi = new u();
                        i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath, paramfo, paramLinkedList, 7, true, parambi));
                        break;
                      }
                    }
                    i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath, paramfo, paramLinkedList, 7, false, null));
                    continue;
                    localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avh().VQ(((g.a)localObject1).bFE);
                    if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.b)localObject1).aXY()))
                    {
                      i = j;
                      if (parambi.field_isSend == 1)
                      {
                        i = j;
                        if (localObject1 != null)
                        {
                          i = j;
                          if (!((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_isUpload) {}
                        }
                      }
                    }
                    else
                    {
                      y.d("MicroMsg.BakOldItemAppMsg", "full path " + ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath);
                      i = j;
                      if (com.tencent.mm.vfs.e.bK(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath)) {
                        i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath, paramfo, paramLinkedList, 7, false, null));
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      localObject2 = new mm();
      ((mm)localObject2).bVQ.bUr = ((g.a)localObject1).dRd;
      ((mm)localObject2).bVQ.bHR = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      y.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { ((mm)localObject2).bVR.bVS });
      parambi = ((mm)localObject2).bVR.bVS.split(":");
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
          y.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", new Object[] { parambi[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(parambi[k], paramfo, paramLinkedList, 7, "_fav." + k));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(fo paramfo, bi parambi, LinkedList<u> paramLinkedList)
  {
    int j = 0;
    switch (parambi.getType())
    {
    default: 
      j = b(paramfo, parambi, paramLinkedList);
      return j;
    case 285212721: 
      if (bk.bl(parambi.field_content)) {}
      for (i = 0;; i = parambi.field_content.getBytes().length)
      {
        parambi = b.a.xv(parambi.field_content);
        if (bk.bl(parambi)) {
          break;
        }
        paramLinkedList = new bml();
        paramLinkedList.YI(bk.aM(parambi, ""));
        paramfo.svH = paramLinkedList;
        return i;
      }
    }
    if (bk.bl(parambi.field_content)) {}
    for (int i = 0; parambi.field_content == null; i = parambi.field_content.getBytes().length) {
      return -1;
    }
    Object localObject2 = ap.abP(parambi.field_content).uAC.trim();
    Object localObject1 = localObject2;
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.xr((String)localObject2))
    {
      localObject2 = parambi.field_content;
      localObject1 = localObject2;
      if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.xr((String)localObject2))
      {
        y.e("MicroMsg.BakOldItemAppMsg", "get xml error " + (String)localObject2);
        return 0;
      }
    }
    j = i;
    if (!bk.bl((String)localObject1))
    {
      localObject2 = new bml();
      ((bml)localObject2).YI(bk.aM((String)localObject1, ""));
      paramfo.svH = ((bml)localObject2);
      localObject1 = g.a.gp((String)localObject1);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().FL();
      parambi = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().F(parambi.field_imgPath, true);
      localObject1 = (String)localObject2 + ((g.a)localObject1).dQx;
      if (com.tencent.mm.vfs.e.aeQ(parambi) <= 0L) {
        return -1;
      }
      j = i.a(new i.a(parambi, paramfo, paramLinkedList, 6, "_thumb"));
      parambi = ap.abP(aa.a(paramfo.svH));
      j = j + i + i.a(new i.a((String)localObject1, paramfo, paramLinkedList, com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avg().acC(parambi.bIW)));
    }
    return j;
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
      if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.fn((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.bakoldlogic.d.d.iH(paramfo.svH.tFO);
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
      y.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
      return 0;
    }
    if (((g.a)localObject3).type == 2000)
    {
      parambi.setType(419430449);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.h(parambi);
      return 0;
    }
    if ((((g.a)localObject3).type == 19) || (((g.a)localObject3).type == 24))
    {
      parambi.setType(l.d((g.a)localObject3));
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.h(parambi);
      paramString = new mm();
      paramString.bVQ.bUr = ((g.a)localObject3).dRd;
      paramString.bVQ.bHR = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      y.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramString.bVR.bVS });
      paramString = paramString.bVR.bVS.split(":");
      i = 0;
      while (i < paramString.length)
      {
        parambi = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramfo, 7, "." + i);
        if (!bk.bl(parambi))
        {
          y.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", new Object[] { parambi, Integer.valueOf(i) });
          com.tencent.mm.vfs.e.r(com.tencent.mm.plugin.backup.bakoldlogic.a.a.xD(parambi), paramString[i]);
        }
        i += 1;
      }
      return 0;
    }
    localObject1 = new f();
    ((f)localObject1).field_appId = ((g.a)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP();
    if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0) {
      throw new com.tencent.mm.model.b();
    }
    if ((((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).hMU.b((com.tencent.mm.sdk.e.c)localObject1, new String[0])) && (((f)localObject1).field_appVersion < ((g.a)localObject3).cau)) {
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avQ().f(1, ((g.a)localObject3).appId);
    }
    parambi.setType(l.d((g.a)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramfo, 6);
    if ((localObject1 != null) && (parambi.field_msgId == 0L)) {
      if (((g.a)localObject3).type != 2) {
        break label692;
      }
    }
    com.tencent.mm.ae.g localg;
    com.tencent.mm.plugin.backup.bakoldlogic.d.c localc;
    label692:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().a((byte[])localObject1, bool, Bitmap.CompressFormat.PNG);
      y.d("MicroMsg.BakOldItemAppMsg", com.tencent.mm.compatible.util.g.zI() + " thumbData MsgInfo path:" + (String)localObject1);
      if (!bk.bl((String)localObject1))
      {
        parambi.ed((String)localObject1);
        y.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:" + (String)localObject1);
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramfo, 8);
      i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramfo, 8);
      localObject1 = localObject2;
      if (bk.bl((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramfo, 7);
        i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramfo, 7);
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.xD((String)localObject1);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.h(parambi);
      localg = new com.tencent.mm.ae.g();
      ((g.a)localObject3).a(localg);
      localg.field_msgId = parambi.field_msgId;
      localc = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP();
      if (localc.uin != 0) {
        break;
      }
      throw new com.tencent.mm.model.b();
    }
    localc.hMT.b(localg);
    long l;
    if (!bk.bl((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().Fy();
      if (paramString.equals(paramfo.svF.tFO)) {}
      for (paramString = paramfo.svG.tFO;; paramString = paramfo.svF.tFO)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject1).O(paramString, paramfo.ndp);
        paramfo = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avh().VQ(((g.a)localObject3).bFE);
        paramString = paramfo;
        if (paramfo != null) {
          break label1083;
        }
        y.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
        l = ((cs)localObject1).field_msgId;
        localObject4 = g.a.gp((String)localObject4);
        if (localObject4 != null)
        {
          paramString = l.aj(com.tencent.mm.compatible.util.e.dzB, ((g.a)localObject4).title, ((g.a)localObject4).dQw);
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
          if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avh().b((com.tencent.mm.sdk.e.c)localObject4)) {
            y.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramfo = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avh().VQ(((g.a)localObject3).bFE);
        if (paramfo != null) {
          break;
        }
        y.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((g.a)localObject3).bFE });
        return 0;
      }
      paramString = paramfo;
      if (((g.a)localObject3).dQv != 0)
      {
        paramString = paramfo;
        if (i != 0)
        {
          if (i >= ((g.a)localObject3).dQv) {
            break label1142;
          }
          if (parambi.field_isSend != 1) {
            break label1130;
          }
          paramfo.field_status = 105L;
          paramString = paramfo;
        }
      }
    }
    for (;;)
    {
      label1083:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      com.tencent.mm.vfs.e.gC((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avh().c(paramString, new String[0]);
      return 0;
      label1130:
      paramfo.field_status = 102L;
      paramString = paramfo;
      continue;
      label1142:
      paramfo.field_status = 199L;
      paramString = paramfo;
    }
  }
  
  static final class a$a
  {
    Map<String, String> hJO = null;
    boolean hJP = true;
    
    public a$a(String paramString)
    {
      this.hJO = ba.Zx(paramString);
      if (this.hJO == null)
      {
        this.hJP = false;
        this.hJO = new HashMap();
      }
    }
    
    final int getInt(String paramString)
    {
      if (!this.hJO.containsKey(paramString)) {
        return 0;
      }
      return bk.getInt((String)this.hJO.get(paramString), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b
 * JD-Core Version:    0.7.0.1
 */