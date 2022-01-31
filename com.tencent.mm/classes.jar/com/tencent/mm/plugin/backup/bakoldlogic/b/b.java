package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.nh.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements j
{
  private static int b(gx paramgx, bi parambi, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(17779);
    int j;
    Object localObject2;
    int i;
    if (bo.isNullOrNil(parambi.field_content))
    {
      j = 0;
      localObject2 = parambi.field_content;
      localObject1 = localObject2;
      if (parambi.field_isSend != 1)
      {
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.lA(parambi.field_talker))
        {
          i = parambi.field_content.indexOf(':');
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = parambi.field_content.substring(i + 1);
          }
        }
      }
      localObject1 = bo.apU((String)localObject1);
      if (localObject1 == null) {
        break label991;
      }
    }
    label991:
    for (Object localObject1 = j.b.mY((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ab.e("MicroMsg.BakOldItemAppMsg", "content is null");
        AppMethodBeat.o(17779);
        return 0;
        j = parambi.field_content.getBytes().length;
        break;
      }
      ab.d("MicroMsg.BakOldItemAppMsg", "content type " + ((j.b)localObject1).type);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().aUH().J(parambi.field_imgPath, true);
      if (com.tencent.mm.vfs.e.cN((String)localObject2))
      {
        j += i.a(new i.a((String)localObject2, paramgx, paramLinkedList, 6, "_thumb"));
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
          AppMethodBeat.o(17779);
          return i;
          if (((j.b)localObject1).type != 2) {
            break;
          }
          AppMethodBeat.o(17779);
          return -1;
          i = j;
          if (!bo.isNullOrNil(((j.b)localObject1).cmN))
          {
            localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().aUJ().alo(((j.b)localObject1).cmN);
            if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.b)localObject1).bEL()))
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
              if (com.tencent.mm.vfs.e.cN(parambi))
              {
                ab.d("MicroMsg.BakOldItemAppMsg", "image ".concat(String.valueOf(parambi)));
                i = j + i.a(new i.a(parambi, paramgx, paramLinkedList, 8, false, null));
                continue;
                localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().aUJ().alo(((j.b)localObject1).cmN);
                if ((localObject2 == null) || (!((com.tencent.mm.pluginsdk.model.app.b)localObject2).bEL()))
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
                  ab.d("MicroMsg.BakOldItemAppMsg", "full path " + ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
                  i = j;
                  if (com.tencent.mm.vfs.e.cN(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath)) {
                    if ((com.tencent.mm.plugin.backup.b.d.aSO() == 1) && (((j.b)localObject1).fgw / 1024 >= 0L) && (((j.b)localObject1).filemd5 != null))
                    {
                      parambi = new u();
                      i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath, paramgx, paramLinkedList, 7, true, parambi));
                    }
                    else
                    {
                      i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath, paramgx, paramLinkedList, 7, false, null));
                      continue;
                      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().aUJ().alo(((j.b)localObject1).cmN);
                      if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.b)localObject1).bEL()))
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
                        ab.d("MicroMsg.BakOldItemAppMsg", "full path " + ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath);
                        i = j;
                        if (com.tencent.mm.vfs.e.cN(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath)) {
                          i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath, paramgx, paramLinkedList, 7, false, null));
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
      localObject2 = new nh();
      ((nh)localObject2).cDD.cBW = ((j.b)localObject1).fhc;
      ((nh)localObject2).cDD.cpg = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
      ab.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { ((nh)localObject2).cDE.cDF });
      parambi = ((nh)localObject2).cDE.cDF.split(":");
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
          ab.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", new Object[] { parambi[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(parambi[k], paramgx, paramLinkedList, 7, "_fav.".concat(String.valueOf(k))));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(gx paramgx, bi parambi, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(17778);
    switch (parambi.getType())
    {
    default: 
      i = b(paramgx, parambi, paramLinkedList);
      AppMethodBeat.o(17778);
      return i;
    case 285212721: 
      if (bo.isNullOrNil(parambi.field_content)) {}
      for (i = 0;; i = parambi.field_content.getBytes().length)
      {
        parambi = b.a.Go(parambi.field_content);
        if (!bo.isNullOrNil(parambi)) {
          break;
        }
        AppMethodBeat.o(17778);
        return 0;
      }
      paramLinkedList = new bwc();
      paramLinkedList.aoF(bo.bf(parambi, ""));
      paramgx.woR = paramLinkedList;
      AppMethodBeat.o(17778);
      return i;
    }
    if (bo.isNullOrNil(parambi.field_content)) {}
    for (int i = 0; parambi.field_content == null; i = parambi.field_content.getBytes().length)
    {
      AppMethodBeat.o(17778);
      return -1;
    }
    Object localObject2 = ap.arZ(parambi.field_content).yML.trim();
    Object localObject1 = localObject2;
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.Gk((String)localObject2))
    {
      localObject2 = parambi.field_content;
      localObject1 = localObject2;
      if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.Gk((String)localObject2))
      {
        ab.e("MicroMsg.BakOldItemAppMsg", "get xml error ".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(17778);
        return 0;
      }
    }
    int j = i;
    if (!bo.isNullOrNil((String)localObject1))
    {
      localObject2 = new bwc();
      ((bwc)localObject2).aoF(bo.bf((String)localObject1, ""));
      paramgx.woR = ((bwc)localObject2);
      localObject1 = j.b.mY((String)localObject1);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().YP();
      parambi = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().aUH().J(parambi.field_imgPath, true);
      localObject1 = (String)localObject2 + ((j.b)localObject1).fgy;
      if (com.tencent.mm.vfs.e.avI(parambi) <= 0L)
      {
        AppMethodBeat.o(17778);
        return -1;
      }
      j = i.a(new i.a(parambi, paramgx, paramLinkedList, 6, "_thumb"));
      parambi = ap.arZ(aa.a(paramgx.woR));
      j = j + i + i.a(new i.a((String)localObject1, paramgx, paramLinkedList, com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().aUI().asP(parambi.cqq)));
    }
    AppMethodBeat.o(17778);
    return j;
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17780);
    Object localObject3 = paramgx.woP.xJE;
    Object localObject2 = paramgx.woR.xJE;
    if (localObject2 == null)
    {
      AppMethodBeat.o(17780);
      return 0;
    }
    parambi.setContent((String)localObject2);
    Object localObject1 = localObject2;
    int i;
    if (parambi.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.lA((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.bakoldlogic.d.d.pt(paramgx.woR.xJE);
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
      ab.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(17780);
      return 0;
    }
    if (((j.b)localObject3).type == 2000)
    {
      parambi.setType(419430449);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.l(parambi);
      AppMethodBeat.o(17780);
      return 0;
    }
    if ((((j.b)localObject3).type == 19) || (((j.b)localObject3).type == 24))
    {
      parambi.setType(l.c((j.b)localObject3));
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.l(parambi);
      paramString = new nh();
      paramString.cDD.cBW = ((j.b)localObject3).fhc;
      paramString.cDD.cpg = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.ymk.l(paramString);
      ab.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramString.cDE.cDF });
      paramString = paramString.cDE.cDF.split(":");
      i = 0;
      while (i < paramString.length)
      {
        parambi = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramgx, 7, ".".concat(String.valueOf(i)));
        if (!bo.isNullOrNil(parambi))
        {
          ab.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", new Object[] { parambi, Integer.valueOf(i) });
          com.tencent.mm.vfs.e.C(com.tencent.mm.plugin.backup.bakoldlogic.a.a.Gw(parambi), paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(17780);
      return 0;
    }
    localObject1 = new f();
    ((f)localObject1).field_appId = ((j.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs();
    if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(17780);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).jGw.get((com.tencent.mm.sdk.e.c)localObject1, new String[0])) && (((f)localObject1).field_appVersion < ((j.b)localObject3).bDc)) {
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVt().h(1, ((j.b)localObject3).appId);
    }
    parambi.setType(l.c((j.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramgx, 6);
    if ((localObject1 != null) && (parambi.field_msgId == 0L)) {
      if (((j.b)localObject3).type != 2) {
        break label724;
      }
    }
    com.tencent.mm.af.j localj;
    com.tencent.mm.plugin.backup.bakoldlogic.d.c localc;
    label724:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().aUH().a((byte[])localObject1, bool, Bitmap.CompressFormat.PNG);
      ab.d("MicroMsg.BakOldItemAppMsg", com.tencent.mm.compatible.util.g.Ml() + " thumbData MsgInfo path:" + (String)localObject1);
      if (!bo.isNullOrNil((String)localObject1))
      {
        parambi.kk((String)localObject1);
        ab.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(localObject1)));
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramgx, 8);
      i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramgx, 8);
      localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramgx, 7);
        i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramgx, 7);
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.Gw((String)localObject1);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.l(parambi);
      localj = new com.tencent.mm.af.j();
      ((j.b)localObject3).a(localj);
      localj.field_msgId = parambi.field_msgId;
      localc = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs();
      if (localc.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(17780);
      throw paramString;
    }
    localc.jGv.insert(localj);
    long l;
    if (!bo.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().YC();
      if (paramString.equals(paramgx.woP.xJE)) {}
      for (paramString = paramgx.woQ.xJE;; paramString = paramgx.woP.xJE)
      {
        localObject1 = ((h)localObject1).ag(paramString, paramgx.pIG);
        paramgx = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().aUJ().alo(((j.b)localObject3).cmN);
        paramString = paramgx;
        if (paramgx != null) {
          break label1121;
        }
        ab.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
        l = ((dd)localObject1).field_msgId;
        localObject4 = j.b.mY((String)localObject4);
        if (localObject4 != null)
        {
          paramString = l.Z(com.tencent.mm.compatible.util.e.esq, ((j.b)localObject4).title, ((j.b)localObject4).fgx);
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
          if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().aUJ().insert((com.tencent.mm.sdk.e.c)localObject4)) {
            ab.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramgx = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().aUJ().alo(((j.b)localObject3).cmN);
        if (paramgx != null) {
          break;
        }
        ab.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((j.b)localObject3).cmN });
        AppMethodBeat.o(17780);
        return 0;
      }
      paramString = paramgx;
      if (((j.b)localObject3).fgw != 0)
      {
        paramString = paramgx;
        if (i != 0)
        {
          if (i >= ((j.b)localObject3).fgw) {
            break label1186;
          }
          if (parambi.field_isSend != 1) {
            break label1174;
          }
          paramgx.field_status = 105L;
          paramString = paramgx;
        }
      }
    }
    for (;;)
    {
      label1121:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      com.tencent.mm.vfs.e.iF((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().aUJ().a(paramString, new String[0]);
      AppMethodBeat.o(17780);
      return 0;
      label1174:
      paramgx.field_status = 102L;
      paramString = paramgx;
      continue;
      label1186:
      paramgx.field_status = 199L;
      paramString = paramgx;
    }
  }
  
  static final class a$a
  {
    boolean bRg;
    Map<String, String> jDs;
    
    public a$a(String paramString)
    {
      AppMethodBeat.i(17767);
      this.jDs = null;
      this.bRg = true;
      this.jDs = be.apC(paramString);
      if (this.jDs == null)
      {
        this.bRg = false;
        this.jDs = new HashMap();
      }
      AppMethodBeat.o(17767);
    }
    
    final int getInt(String paramString)
    {
      AppMethodBeat.i(17768);
      if (!this.jDs.containsKey(paramString))
      {
        AppMethodBeat.o(17768);
        return 0;
      }
      int i = bo.getInt((String)this.jDs.get(paramString), 0);
      AppMethodBeat.o(17768);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b
 * JD-Core Version:    0.7.0.1
 */