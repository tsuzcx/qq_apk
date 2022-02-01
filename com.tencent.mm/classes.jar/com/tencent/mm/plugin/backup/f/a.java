package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.a.po.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class a
  implements l
{
  public final int a(if paramif, boolean paramBoolean1, bv parambv, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21506);
    int j;
    String str;
    int i;
    switch (parambv.getType())
    {
    default: 
      if (bu.isNullOrNil(parambv.field_content))
      {
        j = 0;
        str = parambv.field_content;
        localObject1 = str;
        if (parambv.field_isSend != 1)
        {
          localObject1 = str;
          if (com.tencent.mm.plugin.backup.h.c.wb(parambv.field_talker))
          {
            i = parambv.field_content.indexOf(':');
            localObject1 = str;
            if (i != -1) {
              localObject1 = parambv.field_content.substring(i + 1);
            }
          }
        }
        localObject1 = bu.aSA((String)localObject1);
        if (localObject1 == null) {
          break label1478;
        }
      }
      break;
    }
    label1478:
    for (Object localObject1 = k.b.zb((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ae.e("MicroMsg.BackupItemAppMsg", "content is null");
        AppMethodBeat.o(21506);
        return 0;
        if (bu.isNullOrNil(parambv.field_content)) {}
        for (i = 0; paramBoolean1; i = parambv.field_content.getBytes().length)
        {
          AppMethodBeat.o(21506);
          return i;
        }
        parambv = a.a.WJ(parambv.field_content);
        if (bu.isNullOrNil(parambv))
        {
          AppMethodBeat.o(21506);
          return 0;
        }
        paramString = new cxn();
        paramString.aQV(bu.bI(parambv, ""));
        paramif.FNI = paramString;
        AppMethodBeat.o(21506);
        return i;
        if (bu.isNullOrNil(parambv.field_content)) {}
        for (i = 0; parambv.field_content == null; i = parambv.field_content.getBytes().length)
        {
          AppMethodBeat.o(21506);
          return -1;
        }
        paramLinkedList = parambv.field_content;
        paramString = paramLinkedList;
        if (!com.tencent.mm.plugin.backup.b.g.WF(paramLinkedList))
        {
          parambv = parambv.field_content;
          paramString = parambv;
          if (!com.tencent.mm.plugin.backup.b.g.WF(parambv))
          {
            ae.e("MicroMsg.BackupItemAppMsg", "get xml error ".concat(String.valueOf(parambv)));
            AppMethodBeat.o(21506);
            return 0;
          }
        }
        if (!bu.isNullOrNil(paramString))
        {
          parambv = new cxn();
          parambv.aQV(bu.bI(paramString, ""));
          paramif.FNI = parambv;
        }
        AppMethodBeat.o(21506);
        return i;
        j = parambv.field_content.getBytes().length;
        break;
      }
      ae.d("MicroMsg.BackupItemAppMsg", "content type " + ((k.b)localObject1).type);
      str = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().R(parambv.field_imgPath, true);
      if (o.fB(str))
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
          if (!bu.isNullOrNil(((k.b)localObject1).dlu))
          {
            paramString = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJV().aMZ(((k.b)localObject1).dlu);
            if ((paramString == null) || (!paramString.cZe()))
            {
              i = j;
              if (parambv.field_isSend == 1)
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
              parambv = paramString.field_fileFullPath;
              i = j;
              if (o.fB(parambv))
              {
                ae.d("MicroMsg.BackupItemAppMsg", "image ".concat(String.valueOf(parambv)));
                i = j + i.a(new i.a(parambv, paramif, paramLinkedList, 8, paramBoolean1, paramBoolean2, null));
                continue;
                com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJV().aMZ(((k.b)localObject1).dlu);
                if ((localc == null) || (!localc.cZe()))
                {
                  i = j;
                  if (parambv.field_isSend == 1)
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
                  ae.d("MicroMsg.BackupItemAppMsg", "full path " + localc.field_fileFullPath);
                  i = j;
                  if (o.fB(localc.field_fileFullPath)) {
                    if (paramBoolean1)
                    {
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramif, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                    }
                    else
                    {
                      if ((com.tencent.mm.plugin.backup.b.d.bHY() == 1) && (((k.b)localObject1).hCC / 1024 >= paramLong) && (((k.b)localObject1).filemd5 != null))
                      {
                        if (parambv.field_isSend == 1) {
                          str = parambv.field_talker;
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
                          paramif.nCL = ((u)localObject2);
                          paramif.md5 = ((k.b)localObject1).filemd5;
                          paramif.nCN = (paramString + "_" + str + "_" + parambv.field_msgSvrId + "_backup");
                          paramif.nCM = parambv.field_msgSvrId;
                          paramHashMap.put(Long.valueOf(parambv.field_msgSvrId), paramif);
                          i = j;
                          break;
                          localObject2 = parambv.field_talker;
                          str = paramString;
                          paramString = (String)localObject2;
                        }
                      }
                      i = j + i.a(new i.a(localc.field_fileFullPath, paramif, paramLinkedList, 7, paramBoolean1, paramBoolean2, null));
                      continue;
                      paramString = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJV().aMZ(((k.b)localObject1).dlu);
                      if ((paramString == null) || (!paramString.cZe()))
                      {
                        i = j;
                        if (parambv.field_isSend == 1)
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
                        ae.d("MicroMsg.BackupItemAppMsg", "full path " + paramString.field_fileFullPath);
                        i = j;
                        if (o.fB(paramString.field_fileFullPath)) {
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
      paramString = new po();
      paramString.dEP.dCX = ((k.b)localObject1).hDg;
      paramString.dEP.dnX = parambv.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.l(paramString);
      ae.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.dEQ.dER });
      parambv = paramString.dEQ.dER.split(":");
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= parambv.length) {
          break;
        }
        i = j;
        if (o.fB(parambv[k]))
        {
          ae.i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", new Object[] { parambv[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(parambv[k], paramif, paramLinkedList, 7, paramBoolean1, "_fav.".concat(String.valueOf(k)), paramBoolean2));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    AppMethodBeat.i(21507);
    Object localObject3 = paramif.FNG.HId;
    Object localObject2 = paramif.FNI.HId;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21507);
      return 0;
    }
    parambv.setContent((String)localObject2);
    Object localObject1 = localObject2;
    if (parambv.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.h.c.wb((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.h.c.BL(paramif.FNI.HId);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = (paramif.FNI.HId + " ").substring(i + 2).trim();
        }
      }
    }
    Object localObject4 = bu.aSA((String)localObject1);
    localObject3 = k.b.zb((String)localObject4);
    if (localObject3 == null)
    {
      ae.e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21507);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      parambv.setType(419430449);
      com.tencent.mm.plugin.backup.h.c.v(parambv);
      AppMethodBeat.o(21507);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      parambv.setType(m.g((k.b)localObject3));
      com.tencent.mm.plugin.backup.h.c.v(parambv);
      paramString = new po();
      paramString.dEP.dCX = ((k.b)localObject3).hDg;
      paramString.dEP.dnX = parambv.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.l(paramString);
      ae.d("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[] { paramString.dEQ.dER });
      paramString = paramString.dEQ.dER.split(":");
      i = 0;
      while (i < paramString.length)
      {
        parambv = com.tencent.mm.plugin.backup.b.g.a(paramif, 7, ".".concat(String.valueOf(i)));
        if (!bu.isNullOrNil(parambv))
        {
          ae.d("MicroMsg.BackupItemAppMsg", "record mediaId:%s, index:%d", new Object[] { parambv, Integer.valueOf(i) });
          o.mG(com.tencent.mm.plugin.backup.b.g.WC(parambv) + parambv, paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21507);
      return 0;
    }
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.h.d.bJW().bJX();
    if (((com.tencent.mm.plugin.backup.h.b)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.h.b)localObject2).nFI.get((com.tencent.mm.sdk.e.c)localObject1, new String[0])) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appVersion < ((k.b)localObject3).aDD)) {
      com.tencent.mm.plugin.backup.h.d.bJW().bJY().h(1, ((k.b)localObject3).appId);
    }
    parambv.setType(m.g((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.b.g.b(paramif, 6);
    if ((localObject1 != null) && (parambv.field_msgId == 0L))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().aa((byte[])localObject1);
      ae.d("MicroMsg.BackupItemAppMsg", "thumbData MsgInfo path:".concat(String.valueOf(localObject1)));
      if (!bu.isNullOrNil((String)localObject1)) {
        parambv.uj((String)localObject1);
      }
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.a(paramif, 8);
    int i = com.tencent.mm.plugin.backup.b.g.c(paramif, 8);
    localObject1 = localObject2;
    if (bu.isNullOrNil((String)localObject2))
    {
      localObject1 = com.tencent.mm.plugin.backup.b.g.a(paramif, 7);
      i = com.tencent.mm.plugin.backup.b.g.c(paramif, 7);
    }
    localObject2 = com.tencent.mm.plugin.backup.b.g.WC((String)localObject1) + (String)localObject1;
    com.tencent.mm.plugin.backup.h.c.v(parambv);
    k localk = new k();
    ((k.b)localObject3).a(localk);
    localk.field_msgId = parambv.field_msgId;
    com.tencent.mm.plugin.backup.h.b localb = com.tencent.mm.plugin.backup.h.d.bJW().bJX();
    if (localb.uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21507);
      throw paramString;
    }
    localb.nFH.insert(localk);
    long l;
    if (!bu.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.h.d.bJW().bJX().azI();
      if (paramString.equals(paramif.FNG.HId)) {}
      for (paramString = paramif.FNH.HId;; paramString = paramif.FNG.HId)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aJ(paramString, paramif.xrk);
        paramif = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJV().aMZ(((k.b)localObject3).dlu);
        paramString = paramif;
        if (paramif != null) {
          break label1102;
        }
        ae.d("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
        l = ((ei)localObject1).field_msgId;
        localObject4 = k.b.zb((String)localObject4);
        if (localObject4 != null)
        {
          paramString = m.aq(com.tencent.mm.loader.j.b.asm(), ((k.b)localObject4).title, ((k.b)localObject4).hCD);
          int j = ((k.b)localObject4).sdkVer;
          paramif = ((k.b)localObject4).appId;
          localObject1 = ((k.b)localObject4).dlu;
          int k = ((k.b)localObject4).hCC;
          localObject4 = new com.tencent.mm.pluginsdk.model.app.c();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath = paramString;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_appId = paramif;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_sdkVer = j;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_mediaSvrId = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen = k;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_status = 101L;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_isUpload = false;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_createTime = bu.fpO();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_lastModifyTime = bu.aRi();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_msgInfoId = l;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_netTimes = 0L;
          if (!com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJV().insert((com.tencent.mm.sdk.e.c)localObject4)) {
            ae.e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramif = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJV().aMZ(((k.b)localObject3).dlu);
        if (paramif != null) {
          break;
        }
        ae.e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).dlu });
        AppMethodBeat.o(21507);
        return 0;
      }
      paramString = paramif;
      if (((k.b)localObject3).hCC != 0)
      {
        paramString = paramif;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).hCC) {
            break label1167;
          }
          if (parambv.field_isSend != 1) {
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
      o.mG((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJV().a(paramString, new String[0]);
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
  
  static final class a$b
  {
    StringBuffer nCG;
    
    a$b()
    {
      AppMethodBeat.i(21497);
      this.nCG = new StringBuffer();
      AppMethodBeat.o(21497);
    }
    
    private void setText(int paramInt)
    {
      AppMethodBeat.i(21501);
      this.nCG.append(paramInt);
      AppMethodBeat.o(21501);
    }
    
    private void setText(String paramString)
    {
      AppMethodBeat.i(21500);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(21500);
        return;
      }
      if (paramString.contains(a.a.nCE))
      {
        this.nCG.append("<![CDATA[" + bu.aSz(paramString) + "]]>");
        AppMethodBeat.o(21500);
        return;
      }
      this.nCG.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(21500);
    }
    
    public final void WK(String paramString)
    {
      AppMethodBeat.i(21498);
      this.nCG.append("<" + paramString + ">");
      AppMethodBeat.o(21498);
    }
    
    public final void WL(String paramString)
    {
      AppMethodBeat.i(21499);
      this.nCG.append("</" + paramString + ">");
      AppMethodBeat.o(21499);
    }
    
    public final void cp(String paramString, int paramInt)
    {
      AppMethodBeat.i(21503);
      WK(paramString);
      setText(paramInt);
      WL(paramString);
      AppMethodBeat.o(21503);
    }
    
    public final void ez(String paramString1, String paramString2)
    {
      AppMethodBeat.i(21502);
      WK(paramString1);
      setText(paramString2);
      WL(paramString1);
      AppMethodBeat.o(21502);
    }
    
    public final void s(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(21504);
      this.nCG.append("<".concat(String.valueOf(paramString)));
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = (String)paramMap.get(str1);
        this.nCG.append(" " + str1 + " =  \"" + str2 + "\" ");
      }
      this.nCG.append(">");
      paramMap.clear();
      AppMethodBeat.o(21504);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a
 * JD-Core Version:    0.7.0.1
 */