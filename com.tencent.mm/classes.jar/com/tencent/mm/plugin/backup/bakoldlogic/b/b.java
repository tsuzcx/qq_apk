package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.a.po.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  implements j
{
  private static int b(if paramif, bv parambv, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21836);
    int j;
    Object localObject2;
    int i;
    if (bu.isNullOrNil(parambv.field_content))
    {
      j = 0;
      localObject2 = parambv.field_content;
      localObject1 = localObject2;
      if (parambv.field_isSend != 1)
      {
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.wb(parambv.field_talker))
        {
          i = parambv.field_content.indexOf(':');
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = parambv.field_content.substring(i + 1);
          }
        }
      }
      localObject1 = bu.aSA((String)localObject1);
      if (localObject1 == null) {
        break label991;
      }
    }
    label991:
    for (Object localObject1 = k.b.zb((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ae.e("MicroMsg.BakOldItemAppMsg", "content is null");
        AppMethodBeat.o(21836);
        return 0;
        j = parambv.field_content.getBytes().length;
        break;
      }
      ae.d("MicroMsg.BakOldItemAppMsg", "content type " + ((k.b)localObject1).type);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().bJT().R(parambv.field_imgPath, true);
      if (o.fB((String)localObject2))
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
          if (!bu.isNullOrNil(((k.b)localObject1).dlu))
          {
            localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().bJV().aMZ(((k.b)localObject1).dlu);
            if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject1).cZe()))
            {
              i = j;
              if (parambv.field_isSend == 1)
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
              parambv = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
              i = j;
              if (o.fB(parambv))
              {
                ae.d("MicroMsg.BakOldItemAppMsg", "image ".concat(String.valueOf(parambv)));
                i = j + i.a(new i.a(parambv, paramif, paramLinkedList, 8, false, null));
                continue;
                localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().bJV().aMZ(((k.b)localObject1).dlu);
                if ((localObject2 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject2).cZe()))
                {
                  i = j;
                  if (parambv.field_isSend == 1)
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
                  ae.d("MicroMsg.BakOldItemAppMsg", "full path " + ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
                  i = j;
                  if (o.fB(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath)) {
                    if ((com.tencent.mm.plugin.backup.b.d.bHY() == 1) && (((k.b)localObject1).hCC / 1024 >= 0L) && (((k.b)localObject1).filemd5 != null))
                    {
                      parambv = new u();
                      i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath, paramif, paramLinkedList, 7, true, parambv));
                    }
                    else
                    {
                      i = j + i.a(new i.a(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath, paramif, paramLinkedList, 7, false, null));
                      continue;
                      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().bJV().aMZ(((k.b)localObject1).dlu);
                      if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.c)localObject1).cZe()))
                      {
                        i = j;
                        if (parambv.field_isSend == 1)
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
                        ae.d("MicroMsg.BakOldItemAppMsg", "full path " + ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
                        i = j;
                        if (o.fB(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) {
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
      localObject2 = new po();
      ((po)localObject2).dEP.dCX = ((k.b)localObject1).hDg;
      ((po)localObject2).dEP.dnX = parambv.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
      ae.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { ((po)localObject2).dEQ.dER });
      parambv = ((po)localObject2).dEQ.dER.split(":");
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
          ae.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", new Object[] { parambv[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(parambv[k], paramif, paramLinkedList, 7, "_fav.".concat(String.valueOf(k))));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(if paramif, bv parambv, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21835);
    switch (parambv.getType())
    {
    default: 
      i = b(paramif, parambv, paramLinkedList);
      AppMethodBeat.o(21835);
      return i;
    case 285212721: 
      if (bu.isNullOrNil(parambv.field_content)) {}
      for (i = 0;; i = parambv.field_content.getBytes().length)
      {
        parambv = b.a.WJ(parambv.field_content);
        if (!bu.isNullOrNil(parambv)) {
          break;
        }
        AppMethodBeat.o(21835);
        return 0;
      }
      paramLinkedList = new cxn();
      paramLinkedList.aQV(bu.bI(parambv, ""));
      paramif.FNI = paramLinkedList;
      AppMethodBeat.o(21835);
      return i;
    }
    if (bu.isNullOrNil(parambv.field_content)) {}
    for (int i = 0; parambv.field_content == null; i = parambv.field_content.getBytes().length)
    {
      AppMethodBeat.o(21835);
      return -1;
    }
    Object localObject2 = az.aVt(parambv.field_content).Jfn.trim();
    Object localObject1 = localObject2;
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.WF((String)localObject2))
    {
      localObject2 = parambv.field_content;
      localObject1 = localObject2;
      if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.WF((String)localObject2))
      {
        ae.e("MicroMsg.BakOldItemAppMsg", "get xml error ".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(21835);
        return 0;
      }
    }
    int j = i;
    if (!bu.isNullOrNil((String)localObject1))
    {
      localObject2 = new cxn();
      ((cxn)localObject2).aQV(bu.bI((String)localObject1, ""));
      paramif.FNI = ((cxn)localObject2);
      localObject1 = k.b.zb((String)localObject1);
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().azV();
      parambv = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().bJT().R(parambv.field_imgPath, true);
      localObject1 = (String)localObject2 + ((k.b)localObject1).hCE;
      if (o.aZR(parambv) <= 0L)
      {
        AppMethodBeat.o(21835);
        return -1;
      }
      j = i.a(new i.a(parambv, paramif, paramLinkedList, 6, "_thumb"));
      parambv = az.aVt(z.a(paramif.FNI));
      j = j + i + i.a(new i.a((String)localObject1, paramif, paramLinkedList, com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().bJU().aWl(parambv.md5)));
    }
    AppMethodBeat.o(21835);
    return j;
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    AppMethodBeat.i(21837);
    Object localObject3 = paramif.FNG.HId;
    Object localObject2 = paramif.FNI.HId;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21837);
      return 0;
    }
    parambv.setContent((String)localObject2);
    Object localObject1 = localObject2;
    int i;
    if (parambv.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.wb((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.bakoldlogic.d.d.BL(paramif.FNI.HId);
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
      ae.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21837);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      parambv.setType(419430449);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.v(parambv);
      AppMethodBeat.o(21837);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      parambv.setType(m.g((k.b)localObject3));
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.v(parambv);
      paramString = new po();
      paramString.dEP.dCX = ((k.b)localObject3).hDg;
      paramString.dEP.dnX = parambv.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.l(paramString);
      ae.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramString.dEQ.dER });
      paramString = paramString.dEQ.dER.split(":");
      i = 0;
      while (i < paramString.length)
      {
        parambv = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramif, 7, ".".concat(String.valueOf(i)));
        if (!bu.isNullOrNil(parambv))
        {
          ae.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", new Object[] { parambv, Integer.valueOf(i) });
          o.mF(com.tencent.mm.plugin.backup.bakoldlogic.a.a.WS(parambv), paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21837);
      return 0;
    }
    localObject1 = new g();
    ((g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE();
    if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).nFI.get((com.tencent.mm.sdk.e.c)localObject1, new String[0])) && (((g)localObject1).field_appVersion < ((k.b)localObject3).aDD)) {
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKF().i(1, ((k.b)localObject3).appId);
    }
    parambv.setType(m.g((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramif, 6);
    if ((localObject1 != null) && (parambv.field_msgId == 0L)) {
      if (((k.b)localObject3).type != 2) {
        break label724;
      }
    }
    k localk;
    com.tencent.mm.plugin.backup.bakoldlogic.d.c localc;
    label724:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().bJT().a((byte[])localObject1, bool, Bitmap.CompressFormat.PNG);
      ae.d("MicroMsg.BakOldItemAppMsg", com.tencent.mm.compatible.util.f.abr() + " thumbData MsgInfo path:" + (String)localObject1);
      if (!bu.isNullOrNil((String)localObject1))
      {
        parambv.uj((String)localObject1);
        ae.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(localObject1)));
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramif, 8);
      i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramif, 8);
      localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramif, 7);
        i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramif, 7);
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.WS((String)localObject1);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.v(parambv);
      localk = new k();
      ((k.b)localObject3).a(localk);
      localk.field_msgId = parambv.field_msgId;
      localc = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE();
      if (localc.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    localc.nFH.insert(localk);
    long l;
    if (!bu.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().azI();
      if (paramString.equals(paramif.FNG.HId)) {}
      for (paramString = paramif.FNH.HId;; paramString = paramif.FNG.HId)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aJ(paramString, paramif.xrk);
        paramif = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().bJV().aMZ(((k.b)localObject3).dlu);
        paramString = paramif;
        if (paramif != null) {
          break label1121;
        }
        ae.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
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
          if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().bJV().insert((com.tencent.mm.sdk.e.c)localObject4)) {
            ae.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramif = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().bJV().aMZ(((k.b)localObject3).dlu);
        if (paramif != null) {
          break;
        }
        ae.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).dlu });
        AppMethodBeat.o(21837);
        return 0;
      }
      paramString = paramif;
      if (((k.b)localObject3).hCC != 0)
      {
        paramString = paramif;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).hCC) {
            break label1186;
          }
          if (parambv.field_isSend != 1) {
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
      o.mH((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().bJV().a(paramString, new String[0]);
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
  
  static final class a$b
  {
    StringBuffer nCG;
    
    a$b()
    {
      AppMethodBeat.i(21826);
      this.nCG = new StringBuffer();
      AppMethodBeat.o(21826);
    }
    
    private void setText(int paramInt)
    {
      AppMethodBeat.i(21830);
      this.nCG.append(paramInt);
      AppMethodBeat.o(21830);
    }
    
    private void setText(String paramString)
    {
      AppMethodBeat.i(21829);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(21829);
        return;
      }
      if (paramString.contains(b.a.nCE))
      {
        this.nCG.append("<![CDATA[" + bu.aSz(paramString) + "]]>");
        AppMethodBeat.o(21829);
        return;
      }
      this.nCG.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(21829);
    }
    
    public final void WK(String paramString)
    {
      AppMethodBeat.i(21827);
      this.nCG.append("<" + paramString + ">");
      AppMethodBeat.o(21827);
    }
    
    public final void WL(String paramString)
    {
      AppMethodBeat.i(21828);
      this.nCG.append("</" + paramString + ">");
      AppMethodBeat.o(21828);
    }
    
    public final void cp(String paramString, int paramInt)
    {
      AppMethodBeat.i(21832);
      WK(paramString);
      setText(paramInt);
      WL(paramString);
      AppMethodBeat.o(21832);
    }
    
    public final void ez(String paramString1, String paramString2)
    {
      AppMethodBeat.i(21831);
      WK(paramString1);
      setText(paramString2);
      WL(paramString1);
      AppMethodBeat.o(21831);
    }
    
    public final void s(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(21833);
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
      AppMethodBeat.o(21833);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b
 * JD-Core Version:    0.7.0.1
 */