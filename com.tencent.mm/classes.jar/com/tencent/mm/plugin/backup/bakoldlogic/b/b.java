package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.re;
import com.tencent.mm.f.a.re.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.cm;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.LinkedList;

public final class b
  implements j
{
  private static int b(ih paramih, boolean paramBoolean1, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, Object> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(288067);
    int j;
    int i;
    if (Util.isNullOrNil(paramca.field_content))
    {
      j = 0;
      paramHashMap = paramca.field_content;
      paramString = paramHashMap;
      if (paramca.field_isSend != 1)
      {
        paramString = paramHashMap;
        if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.Lj(paramca.field_talker))
        {
          i = paramca.field_content.indexOf(':');
          paramString = paramHashMap;
          if (i != -1) {
            paramString = paramca.field_content.substring(i + 1);
          }
        }
      }
      paramString = Util.processXml(paramString);
      if (paramString == null) {
        break label993;
      }
    }
    label993:
    for (paramString = k.b.OQ(paramString);; paramString = null)
    {
      if (paramString == null)
      {
        Log.e("MicroMsg.BakOldItemAppMsg", "content is null");
        AppMethodBeat.o(288067);
        return 0;
        j = paramca.field_content.getBytes().length;
        break;
      }
      Log.d("MicroMsg.BakOldItemAppMsg", "content type " + paramString.type);
      paramHashMap = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().T(paramca.field_imgPath, true);
      if (com.tencent.mm.vfs.u.agG(paramHashMap))
      {
        j += i.a(new i.a(paramHashMap, paramih, paramLinkedList, 6, false, "_thumb", false));
        i = j;
      }
      switch (paramString.type)
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
          AppMethodBeat.o(288067);
          return i;
          if (paramString.type != 2) {
            break;
          }
          AppMethodBeat.o(288067);
          return -1;
          i = j;
          if (!Util.isNullOrNil(paramString.fvr))
          {
            paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctZ().bpR(paramString.fvr);
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
                Log.d("MicroMsg.BakOldItemAppMsg", "image ".concat(String.valueOf(paramca)));
                i = j + i.a(new i.a(paramca, paramih, paramLinkedList, 8, false, false, null));
                continue;
                paramHashMap = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctZ().bpR(paramString.fvr);
                if ((paramHashMap == null) || (!paramHashMap.evg()))
                {
                  i = j;
                  if (paramca.field_isSend == 1)
                  {
                    i = j;
                    if (paramHashMap != null)
                    {
                      i = j;
                      if (!paramHashMap.field_isUpload) {}
                    }
                  }
                }
                else
                {
                  Log.d("MicroMsg.BakOldItemAppMsg", "full path " + paramHashMap.field_fileFullPath);
                  i = j;
                  if (com.tencent.mm.vfs.u.agG(paramHashMap.field_fileFullPath)) {
                    if ((com.tencent.mm.plugin.backup.b.d.csc() == 1) && (paramString.llX / 1024 >= 0L) && (paramString.filemd5 != null))
                    {
                      paramca = new com.tencent.mm.plugin.backup.i.u();
                      i = j + i.a(new i.a(paramHashMap.field_fileFullPath, paramih, paramLinkedList, 7, false, true, paramca));
                    }
                    else
                    {
                      i = j + i.a(new i.a(paramHashMap.field_fileFullPath, paramih, paramLinkedList, 7, false, false, null));
                      continue;
                      paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctZ().bpR(paramString.fvr);
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
                        Log.d("MicroMsg.BakOldItemAppMsg", "full path " + paramString.field_fileFullPath);
                        i = j;
                        if (com.tencent.mm.vfs.u.agG(paramString.field_fileFullPath)) {
                          i = j + i.a(new i.a(paramString.field_fileFullPath, paramih, paramLinkedList, 7, false, false, null));
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
      paramHashMap = new re();
      paramHashMap.fQg.xml = paramString.lmA;
      paramHashMap.fQg.fxU = paramca.field_msgId;
      EventCenter.instance.publish(paramHashMap);
      Log.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramHashMap.fQh.fQi });
      paramca = paramHashMap.fQh.fQi.split(":");
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
          Log.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", new Object[] { paramca[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(paramca[k], paramih, paramLinkedList, 7, false, "_fav.".concat(String.valueOf(k)), false));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(ih paramih, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(288064);
    switch (paramca.getType())
    {
    default: 
      i = b(paramih, false, paramca, paramString, paramLinkedList, null, false, 0L);
      AppMethodBeat.o(288064);
      return i;
    case 285212721: 
      if (Util.isNullOrNil(paramca.field_content)) {}
      for (i = 0;; i = paramca.field_content.getBytes().length)
      {
        paramca = b.a.aoj(paramca.field_content);
        if (!Util.isNullOrNil(paramca)) {
          break;
        }
        AppMethodBeat.o(288064);
        return 0;
      }
      paramString = new eaf();
      paramString.btQ(Util.nullAs(paramca, ""));
      paramih.RIF = paramString;
      AppMethodBeat.o(288064);
      return i;
    }
    if (Util.isNullOrNil(paramca.field_content)) {}
    for (int i = 0; paramca.field_content == null; i = paramca.field_content.getBytes().length)
    {
      AppMethodBeat.o(288064);
      return -1;
    }
    Object localObject = be.bwQ(paramca.field_content).VFa.trim();
    paramString = (String)localObject;
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.aof((String)localObject))
    {
      localObject = paramca.field_content;
      paramString = (String)localObject;
      if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.aof((String)localObject))
      {
        Log.e("MicroMsg.BakOldItemAppMsg", "get xml error " + Util.secPrint((String)localObject));
        AppMethodBeat.o(288064);
        return 0;
      }
    }
    int j = i;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = new eaf();
      ((eaf)localObject).btQ(Util.nullAs(paramString, ""));
      paramih.RIF = ((eaf)localObject);
      paramString = k.b.OQ(paramString);
      localObject = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().bcb();
      paramca = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().T(paramca.field_imgPath, true);
      paramString = (String)localObject + paramString.llZ;
      if (com.tencent.mm.vfs.u.bBQ(paramca) <= 0L)
      {
        AppMethodBeat.o(288064);
        return -1;
      }
      j = i.a(new i.a(paramca, paramih, paramLinkedList, 6, false, "_thumb", false));
      paramca = be.bwQ(z.a(paramih.RIF));
      j = i + j + i.a(new i.a(paramString, paramih, paramLinkedList, false, false, com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctY().bxK(paramca.md5)));
    }
    AppMethodBeat.o(288064);
    return j;
  }
  
  public final int a(String paramString, ih paramih, ca paramca)
  {
    AppMethodBeat.i(21837);
    Object localObject3 = paramih.RID.Ufy;
    Object localObject2 = paramih.RIF.Ufy;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21837);
      return 0;
    }
    paramca.setContent((String)localObject2);
    Object localObject1 = localObject2;
    int i;
    if (paramca.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.Lj((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.bakoldlogic.d.d.RK(paramih.RIF.Ufy);
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
      Log.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21837);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      paramca.setType(419430449);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.z(paramca);
      AppMethodBeat.o(21837);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      paramca.setType(m.g((k.b)localObject3));
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.z(paramca);
      paramString = new re();
      paramString.fQg.xml = ((k.b)localObject3).lmA;
      paramString.fQg.fxU = paramca.field_msgId;
      EventCenter.instance.publish(paramString);
      Log.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramString.fQh.fQi });
      paramString = paramString.fQh.fQi.split(":");
      i = 0;
      while (i < paramString.length)
      {
        paramca = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramih, 7, ".".concat(String.valueOf(i)));
        if (!Util.isNullOrNil(paramca))
        {
          Log.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", new Object[] { paramca, Integer.valueOf(i) });
          com.tencent.mm.vfs.u.on(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aoq(paramca), paramString[i]);
        }
        i += 1;
      }
      AppMethodBeat.o(21837);
      return 0;
    }
    localObject1 = new g();
    ((g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI();
    if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).rSC.get((IAutoDBItem)localObject1, new String[0])) && (((g)localObject1).field_appVersion < ((k.b)localObject3).appVersion)) {
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuJ().m(1, ((k.b)localObject3).appId);
    }
    paramca.setType(m.g((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramih, 6);
    if ((localObject1 != null) && (paramca.field_msgId == 0L)) {
      if (((k.b)localObject3).type != 2) {
        break label724;
      }
    }
    k localk;
    com.tencent.mm.plugin.backup.bakoldlogic.d.c localc;
    label724:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().a((byte[])localObject1, bool, Bitmap.CompressFormat.PNG);
      Log.d("MicroMsg.BakOldItemAppMsg", com.tencent.mm.compatible.util.f.avD() + " thumbData MsgInfo path:" + (String)localObject1);
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramca.Jn((String)localObject1);
        Log.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(localObject1)));
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramih, 8);
      i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramih, 8);
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramih, 7);
        i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramih, 7);
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.aoq((String)localObject1);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.z(paramca);
      localk = new k();
      ((k.b)localObject3).a(localk);
      localk.field_msgId = paramca.field_msgId;
      localc = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI();
      if (localc.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    localc.rSB.insert(localk);
    long l;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().bbO();
      if (paramString.equals(paramih.RID.Ufy)) {}
      for (paramString = paramih.RIE.Ufy;; paramString = paramih.RID.Ufy)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aL(paramString, paramih.HlH);
        paramih = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctZ().bpR(((k.b)localObject3).fvr);
        paramString = paramih;
        if (paramih != null) {
          break label1121;
        }
        Log.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
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
          if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctZ().insert((IAutoDBItem)localObject4)) {
            Log.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramih = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctZ().bpR(((k.b)localObject3).fvr);
        if (paramih != null) {
          break;
        }
        Log.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).fvr });
        AppMethodBeat.o(21837);
        return 0;
      }
      paramString = paramih;
      if (((k.b)localObject3).llX != 0)
      {
        paramString = paramih;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).llX) {
            break label1186;
          }
          if (paramca.field_isSend != 1) {
            break label1174;
          }
          paramih.field_status = 105L;
          paramString = paramih;
        }
      }
    }
    for (;;)
    {
      label1121:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      com.tencent.mm.vfs.u.oq((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctZ().a(paramString, new String[0]);
      AppMethodBeat.o(21837);
      return 0;
      label1174:
      paramih.field_status = 102L;
      paramString = paramih;
      continue;
      label1186:
      paramih.field_status = 199L;
      paramString = paramih;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b
 * JD-Core Version:    0.7.0.1
 */