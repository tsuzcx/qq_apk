package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.pn.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bu;
import java.util.LinkedList;

public final class b
  implements j
{
  private static int b(if paramif, bu parambu, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21836);
    int j;
    Object localObject2;
    int i;
    if (bt.isNullOrNil(parambu.field_content))
    {
      j = 0;
      localObject2 = parambu.field_content;
      localObject1 = localObject2;
      if (parambu.field_isSend != 1)
      {
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.vF(parambu.field_talker))
        {
          i = parambu.field_content.indexOf(':');
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = parambu.field_content.substring(i + 1);
          }
        }
      }
      localObject1 = bt.aRd((String)localObject1);
      if (localObject1 == null) {
        break label991;
      }
    }
    label991:
    for (Object localObject1 = k.b.yr((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ad.e("MicroMsg.BakOldItemAppMsg", "content is null");
        AppMethodBeat.o(21836);
        return 0;
        j = parambu.field_content.getBytes().length;
        break;
      }
      ad.d("MicroMsg.BakOldItemAppMsg", "content type " + ((k.b)localObject1).type);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().bIV().R(parambu.field_imgPath, true);
      if (com.tencent.mm.vfs.i.fv((String)localObject2))
      {
        j += i.a(new i.a((String)localObject2, paramif, paramLinkedList, 6, "_thumb"));
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
          if (!bt.isNullOrNil(((k.b)localObject1).dks))
          {
            localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().bIX().aLD(((k.b)localObject1).dks);
            if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject1).cWz()))
            {
              i = j;
              if (parambu.field_isSend == 1)
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
              parambu = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
              i = j;
              if (com.tencent.mm.vfs.i.fv(parambu))
              {
                ad.d("MicroMsg.BakOldItemAppMsg", "image ".concat(String.valueOf(parambu)));
                i = j + i.a(new i.a(parambu, paramif, paramLinkedList, 8, false, null));
                continue;
                localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().bIX().aLD(((k.b)localObject1).dks);
                if ((localObject2 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject2).cWz()))
                {
                  i = j;
                  if (parambu.field_isSend == 1)
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
                  if (com.tencent.mm.vfs.i.fv(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath)) {
                    if ((com.tencent.mm.plugin.backup.b.d.bHa() == 1) && (((k.b)localObject1).hzO / 1024 >= 0L) && (((k.b)localObject1).filemd5 != null))
                    {
                      parambu = new u();
                      i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath, paramif, paramLinkedList, 7, true, parambu));
                    }
                    else
                    {
                      i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath, paramif, paramLinkedList, 7, false, null));
                      continue;
                      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().bIX().aLD(((k.b)localObject1).dks);
                      if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject1).cWz()))
                      {
                        i = j;
                        if (parambu.field_isSend == 1)
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
                        if (com.tencent.mm.vfs.i.fv(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) {
                          i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, paramif, paramLinkedList, 7, false, null));
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
      localObject2 = new pn();
      ((pn)localObject2).dDK.dBS = ((k.b)localObject1).hAs;
      ((pn)localObject2).dDK.dmV = parambu.field_msgId;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
      ad.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { ((pn)localObject2).dDL.dDM });
      parambu = ((pn)localObject2).dDL.dDM.split(":");
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
          ad.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", new Object[] { parambu[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(parambu[k], paramif, paramLinkedList, 7, "_fav.".concat(String.valueOf(k))));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(if paramif, bu parambu, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21835);
    switch (parambu.getType())
    {
    default: 
      i = b(paramif, parambu, paramLinkedList);
      AppMethodBeat.o(21835);
      return i;
    case 285212721: 
      if (bt.isNullOrNil(parambu.field_content)) {}
      for (i = 0;; i = parambu.field_content.getBytes().length)
      {
        parambu = b.a.VX(parambu.field_content);
        if (!bt.isNullOrNil(parambu)) {
          break;
        }
        AppMethodBeat.o(21835);
        return 0;
      }
      paramLinkedList = new cwt();
      paramLinkedList.aPy(bt.bI(parambu, ""));
      paramif.Fvk = paramLinkedList;
      AppMethodBeat.o(21835);
      return i;
    }
    if (bt.isNullOrNil(parambu.field_content)) {}
    for (int i = 0; parambu.field_content == null; i = parambu.field_content.getBytes().length)
    {
      AppMethodBeat.o(21835);
      return -1;
    }
    Object localObject2 = ay.aTS(parambu.field_content).IKG.trim();
    Object localObject1 = localObject2;
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.VT((String)localObject2))
    {
      localObject2 = parambu.field_content;
      localObject1 = localObject2;
      if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.VT((String)localObject2))
      {
        ad.e("MicroMsg.BakOldItemAppMsg", "get xml error ".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(21835);
        return 0;
      }
    }
    int j = i;
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject2 = new cwt();
      ((cwt)localObject2).aPy(bt.bI((String)localObject1, ""));
      paramif.Fvk = ((cwt)localObject2);
      localObject1 = k.b.yr((String)localObject1);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().azF();
      parambu = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().bIV().R(parambu.field_imgPath, true);
      localObject1 = (String)localObject2 + ((k.b)localObject1).hzQ;
      if (com.tencent.mm.vfs.i.aYo(parambu) <= 0L)
      {
        AppMethodBeat.o(21835);
        return -1;
      }
      j = i.a(new i.a(parambu, paramif, paramLinkedList, 6, "_thumb"));
      parambu = ay.aTS(z.a(paramif.Fvk));
      j = j + i + i.a(new i.a((String)localObject1, paramif, paramLinkedList, com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().bIW().aUK(parambu.md5)));
    }
    AppMethodBeat.o(21835);
    return j;
  }
  
  public final int a(String paramString, if paramif, bu parambu)
  {
    AppMethodBeat.i(21837);
    Object localObject3 = paramif.Fvi.HoB;
    Object localObject2 = paramif.Fvk.HoB;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21837);
      return 0;
    }
    parambu.setContent((String)localObject2);
    Object localObject1 = localObject2;
    int i;
    if (parambu.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.vF((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.bakoldlogic.d.d.Bj(paramif.Fvk.HoB);
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
      ad.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21837);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      parambu.setType(419430449);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.v(parambu);
      AppMethodBeat.o(21837);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      parambu.setType(m.g((k.b)localObject3));
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.v(parambu);
      paramString = new pn();
      paramString.dDK.dBS = ((k.b)localObject3).hAs;
      paramString.dDK.dmV = parambu.field_msgId;
      com.tencent.mm.sdk.b.a.IbL.l(paramString);
      ad.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramString.dDL.dDM });
      paramString = paramString.dDL.dDM.split(":");
      i = 0;
      while (i < paramString.length)
      {
        parambu = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramif, 7, ".".concat(String.valueOf(i)));
        if (!bt.isNullOrNil(parambu))
        {
          ad.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", new Object[] { parambu, Integer.valueOf(i) });
          com.tencent.mm.vfs.i.mz(com.tencent.mm.plugin.backup.bakoldlogic.a.a.Wg(parambu), paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21837);
      return 0;
    }
    localObject1 = new g();
    ((g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG();
    if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).nAn.get((com.tencent.mm.sdk.e.c)localObject1, new String[0])) && (((g)localObject1).field_appVersion < ((k.b)localObject3).aDD)) {
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJH().i(1, ((k.b)localObject3).appId);
    }
    parambu.setType(m.g((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramif, 6);
    if ((localObject1 != null) && (parambu.field_msgId == 0L)) {
      if (((k.b)localObject3).type != 2) {
        break label724;
      }
    }
    k localk;
    com.tencent.mm.plugin.backup.bakoldlogic.d.c localc;
    label724:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().bIV().a((byte[])localObject1, bool, Bitmap.CompressFormat.PNG);
      ad.d("MicroMsg.BakOldItemAppMsg", com.tencent.mm.compatible.util.f.abi() + " thumbData MsgInfo path:" + (String)localObject1);
      if (!bt.isNullOrNil((String)localObject1))
      {
        parambu.tO((String)localObject1);
        ad.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(localObject1)));
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramif, 8);
      i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramif, 8);
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramif, 7);
        i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramif, 7);
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.Wg((String)localObject1);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.v(parambu);
      localk = new k();
      ((k.b)localObject3).a(localk);
      localk.field_msgId = parambu.field_msgId;
      localc = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG();
      if (localc.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    localc.nAm.insert(localk);
    long l;
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().azs();
      if (paramString.equals(paramif.Fvi.HoB)) {}
      for (paramString = paramif.Fvj.HoB;; paramString = paramif.Fvi.HoB)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aI(paramString, paramif.xbt);
        paramif = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().bIX().aLD(((k.b)localObject3).dks);
        paramString = paramif;
        if (paramif != null) {
          break label1121;
        }
        ad.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
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
          if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().bIX().insert((com.tencent.mm.sdk.e.c)localObject4)) {
            ad.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramif = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().bIX().aLD(((k.b)localObject3).dks);
        if (paramif != null) {
          break;
        }
        ad.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).dks });
        AppMethodBeat.o(21837);
        return 0;
      }
      paramString = paramif;
      if (((k.b)localObject3).hzO != 0)
      {
        paramString = paramif;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).hzO) {
            break label1186;
          }
          if (parambu.field_isSend != 1) {
            break label1174;
          }
          paramif.field_status = 105L;
          paramString = paramif;
        }
      }
    }
    for (;;)
    {
      label1121:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      com.tencent.mm.vfs.i.mB((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().bIX().a(paramString, new String[0]);
      AppMethodBeat.o(21837);
      return 0;
      label1174:
      paramif.field_status = 102L;
      paramString = paramif;
      continue;
      label1186:
      paramif.field_status = 199L;
      paramString = paramif;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b
 * JD-Core Version:    0.7.0.1
 */