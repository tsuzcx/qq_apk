package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.st;
import com.tencent.mm.autogen.a.st.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.v;
import com.tencent.mm.model.cn;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements j
{
  private static int b(jd paramjd, boolean paramBoolean1, cc paramcc, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, Object> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(300728);
    int j;
    int i;
    if (Util.isNullOrNil(paramcc.field_content))
    {
      j = 0;
      paramHashMap = paramcc.field_content;
      paramString = paramHashMap;
      if (paramcc.field_isSend != 1)
      {
        paramString = paramHashMap;
        if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.DQ(paramcc.field_talker))
        {
          i = paramcc.field_content.indexOf(':');
          paramString = paramHashMap;
          if (i != -1) {
            paramString = paramcc.field_content.substring(i + 1);
          }
        }
      }
      paramString = Util.processXml(paramString);
      if (paramString == null) {
        break label990;
      }
    }
    label990:
    for (paramString = k.b.Hf(paramString);; paramString = null)
    {
      if (paramString == null)
      {
        Log.e("MicroMsg.BakOldItemAppMsg", "content is null");
        AppMethodBeat.o(300728);
        return 0;
        j = paramcc.field_content.getBytes().length;
        break;
      }
      Log.d("MicroMsg.BakOldItemAppMsg", "content type " + paramString.type);
      paramHashMap = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().X(paramcc.field_imgPath, true);
      if (y.ZC(paramHashMap))
      {
        j += i.a(new i.a(paramHashMap, paramjd, paramLinkedList, 6, false, "_thumb", false));
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
          AppMethodBeat.o(300728);
          return i;
          if (paramString.type != 2) {
            break;
          }
          AppMethodBeat.o(300728);
          return -1;
          i = j;
          if (!Util.isNullOrNil(paramString.hzM))
          {
            paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWJ().bpI(paramString.hzM);
            if ((paramString == null) || (!paramString.efT()))
            {
              i = j;
              if (paramcc.field_isSend == 1)
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
              paramcc = paramString.field_fileFullPath;
              i = j;
              if (y.ZC(paramcc))
              {
                Log.d("MicroMsg.BakOldItemAppMsg", "image ".concat(String.valueOf(paramcc)));
                i = j + i.a(new i.a(paramcc, paramjd, paramLinkedList, 8, false, false, null));
                continue;
                paramHashMap = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWJ().bpI(paramString.hzM);
                if ((paramHashMap == null) || (!paramHashMap.efT()))
                {
                  i = j;
                  if (paramcc.field_isSend == 1)
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
                  if (y.ZC(paramHashMap.field_fileFullPath)) {
                    if ((com.tencent.mm.plugin.backup.b.d.cUM() == 1) && (paramString.nRd / 1024 >= 0L) && (paramString.filemd5 != null))
                    {
                      paramcc = new com.tencent.mm.plugin.backup.i.u();
                      i = j + i.a(new i.a(paramHashMap.field_fileFullPath, paramjd, paramLinkedList, 7, false, true, paramcc));
                    }
                    else
                    {
                      i = j + i.a(new i.a(paramHashMap.field_fileFullPath, paramjd, paramLinkedList, 7, false, false, null));
                      continue;
                      paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWJ().bpI(paramString.hzM);
                      if ((paramString == null) || (!paramString.efT()))
                      {
                        i = j;
                        if (paramcc.field_isSend == 1)
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
                        if (y.ZC(paramString.field_fileFullPath)) {
                          i = j + i.a(new i.a(paramString.field_fileFullPath, paramjd, paramLinkedList, 7, false, false, null));
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
      paramHashMap = new st();
      paramHashMap.hWb.xml = paramString.nRF;
      paramHashMap.hWb.hCz = paramcc.field_msgId;
      paramHashMap.publish();
      Log.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramHashMap.hWc.hWd });
      paramcc = paramHashMap.hWc.hWd.split(":");
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= paramcc.length) {
          break;
        }
        i = j;
        if (y.ZC(paramcc[k]))
        {
          Log.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", new Object[] { paramcc[k], Integer.valueOf(k) });
          i = j + i.a(new i.a(paramcc[k], paramjd, paramLinkedList, 7, false, "_fav.".concat(String.valueOf(k)), false));
        }
        k += 1;
        j = i;
      }
    }
  }
  
  public final int a(jd paramjd, cc paramcc, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(300729);
    switch (paramcc.getType())
    {
    default: 
      i = b(paramjd, false, paramcc, paramString, paramLinkedList, null, false, 0L);
      AppMethodBeat.o(300729);
      return i;
    case 285212721: 
      if (Util.isNullOrNil(paramcc.field_content)) {}
      for (i = 0;; i = paramcc.field_content.getBytes().length)
      {
        paramcc = a.ahG(paramcc.field_content);
        if (!Util.isNullOrNil(paramcc)) {
          break;
        }
        AppMethodBeat.o(300729);
        return 0;
      }
      paramString = new etl();
      paramString.btH(Util.nullAs(paramcc, ""));
      paramjd.YFG = paramString;
      AppMethodBeat.o(300729);
      return i;
    }
    if (Util.isNullOrNil(paramcc.field_content)) {}
    for (int i = 0; paramcc.field_content == null; i = paramcc.field_content.getBytes().length)
    {
      AppMethodBeat.o(300729);
      return -1;
    }
    Object localObject = bg.byj(paramcc.field_content).adiN.trim();
    paramString = (String)localObject;
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.ahC((String)localObject))
    {
      localObject = paramcc.field_content;
      paramString = (String)localObject;
      if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.ahC((String)localObject))
      {
        Log.e("MicroMsg.BakOldItemAppMsg", "get xml error " + Util.secPrint((String)localObject));
        AppMethodBeat.o(300729);
        return 0;
      }
    }
    int j = i;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = new etl();
      ((etl)localObject).btH(Util.nullAs(paramString, ""));
      paramjd.YFG = ((etl)localObject);
      paramString = k.b.Hf(paramString);
      localObject = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().bzQ();
      paramcc = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().X(paramcc.field_imgPath, true);
      paramString = (String)localObject + paramString.nRf;
      if (y.bEl(paramcc) <= 0L)
      {
        AppMethodBeat.o(300729);
        return -1;
      }
      j = i.a(new i.a(paramcc, paramjd, paramLinkedList, 6, false, "_thumb", false));
      paramcc = bg.byj(w.a(paramjd.YFG));
      j = i + j + i.a(new i.a(paramString, paramjd, paramLinkedList, false, false, com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWI().bza(paramcc.md5)));
    }
    AppMethodBeat.o(300729);
    return j;
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21837);
    Object localObject3 = paramjd.YFE.abwM;
    Object localObject2 = paramjd.YFG.abwM;
    if (localObject2 == null)
    {
      AppMethodBeat.o(21837);
      return 0;
    }
    paramcc.setContent((String)localObject2);
    Object localObject1 = localObject2;
    int i;
    if (paramcc.field_isSend != 1)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.DQ((String)localObject3))
      {
        i = com.tencent.mm.plugin.backup.bakoldlogic.d.d.JI(paramjd.YFG.abwM);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = (paramjd.YFG.abwM + " ").substring(i + 2).trim();
        }
      }
    }
    Object localObject4 = Util.processXml((String)localObject1);
    localObject3 = k.b.Hf((String)localObject4);
    if (localObject3 == null)
    {
      Log.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
      AppMethodBeat.o(21837);
      return 0;
    }
    if (((k.b)localObject3).type == 2000)
    {
      paramcc.setType(419430449);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.B(paramcc);
      AppMethodBeat.o(21837);
      return 0;
    }
    if ((((k.b)localObject3).type == 19) || (((k.b)localObject3).type == 24))
    {
      paramcc.setType(n.h((k.b)localObject3));
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.B(paramcc);
      paramString = new st();
      paramString.hWb.xml = ((k.b)localObject3).nRF;
      paramString.hWb.hCz = paramcc.field_msgId;
      paramString.publish();
      Log.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[] { paramString.hWc.hWd });
      paramString = paramString.hWc.hWd.split(":");
      i = 0;
      while (i < paramString.length)
      {
        paramcc = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramjd, 7, ".".concat(String.valueOf(i)));
        if (!Util.isNullOrNil(paramcc))
        {
          Log.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", new Object[] { paramcc, Integer.valueOf(i) });
          y.O(com.tencent.mm.plugin.backup.bakoldlogic.a.a.ahN(paramcc), paramString[i], false);
        }
        i += 1;
      }
      AppMethodBeat.o(21837);
      return 0;
    }
    localObject1 = new g();
    ((g)localObject1).field_appId = ((k.b)localObject3).appId;
    localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs();
    if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
    {
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    if ((((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).vdR.get((IAutoDBItem)localObject1, new String[0])) && (((g)localObject1).field_appVersion < ((k.b)localObject3).appVersion)) {
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXt().F(1, ((k.b)localObject3).appId);
    }
    paramcc.setType(n.h((k.b)localObject3));
    localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramjd, 6);
    if ((localObject1 != null) && (paramcc.field_msgId == 0L)) {
      if (((k.b)localObject3).type != 2) {
        break label722;
      }
    }
    k localk;
    com.tencent.mm.plugin.backup.bakoldlogic.d.c localc;
    label722:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().a((byte[])localObject1, bool, Bitmap.CompressFormat.PNG);
      Log.d("MicroMsg.BakOldItemAppMsg", com.tencent.mm.compatible.util.f.aPX() + " thumbData MsgInfo path:" + (String)localObject1);
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramcc.BT((String)localObject1);
        Log.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(localObject1)));
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramjd, 8);
      i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramjd, 8);
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(paramjd, 7);
        i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(paramjd, 7);
      }
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.ahN((String)localObject1);
      com.tencent.mm.plugin.backup.bakoldlogic.d.d.B(paramcc);
      localk = new k();
      ((k.b)localObject3).a(localk);
      localk.field_msgId = paramcc.field_msgId;
      localc = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs();
      if (localc.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21837);
      throw paramString;
    }
    localc.vdQ.insert(localk);
    long l;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().bzD();
      if (paramString.equals(paramjd.YFE.abwM)) {}
      for (paramString = paramjd.YFF.abwM;; paramString = paramjd.YFE.abwM)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject1).aU(paramString, paramjd.Njv);
        paramjd = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWJ().bpI(((k.b)localObject3).hzM);
        paramString = paramjd;
        if (paramjd != null) {
          break label1119;
        }
        Log.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
        l = ((fi)localObject1).field_msgId;
        localObject4 = k.b.Hf((String)localObject4);
        if (localObject4 != null)
        {
          paramString = n.aK(com.tencent.mm.loader.i.b.bmC(), ((k.b)localObject4).title, ((k.b)localObject4).nRe);
          int j = ((k.b)localObject4).sdkVer;
          paramjd = ((k.b)localObject4).appId;
          localObject1 = ((k.b)localObject4).hzM;
          int k = ((k.b)localObject4).nRd;
          localObject4 = new com.tencent.mm.pluginsdk.model.app.c();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath = paramString;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_appId = paramjd;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_sdkVer = j;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_mediaSvrId = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen = k;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_status = 101L;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_isUpload = false;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_createTime = cn.bDu();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_lastModifyTime = Util.nowSecond();
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_msgInfoId = l;
          ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_netTimes = 0L;
          if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWJ().insert((IAutoDBItem)localObject4)) {
            Log.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[] { Long.valueOf(l) });
          }
        }
        paramjd = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWJ().bpI(((k.b)localObject3).hzM);
        if (paramjd != null) {
          break;
        }
        Log.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[] { ((k.b)localObject3).hzM });
        AppMethodBeat.o(21837);
        return 0;
      }
      paramString = paramjd;
      if (((k.b)localObject3).nRd != 0)
      {
        paramString = paramjd;
        if (i != 0)
        {
          if (i >= ((k.b)localObject3).nRd) {
            break label1184;
          }
          if (paramcc.field_isSend != 1) {
            break label1172;
          }
          paramjd.field_status = 105L;
          paramString = paramjd;
        }
      }
    }
    for (;;)
    {
      label1119:
      l = i;
      paramString.field_offset = l;
      paramString.field_totalLen = l;
      y.qo((String)localObject2, paramString.field_fileFullPath);
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWJ().a(paramString, new String[0]);
      AppMethodBeat.o(21837);
      return 0;
      label1172:
      paramjd.field_status = 102L;
      paramString = paramjd;
      continue;
      label1184:
      paramjd.field_status = 199L;
      paramString = paramjd;
    }
  }
  
  static final class a
  {
    public static String INVALID_TAG = "]]>";
    public static String uWA = "<msg>";
    public static String uWB = "</msg>";
    
    public static String ahG(String paramString)
    {
      AppMethodBeat.i(21834);
      com.tencent.mm.message.u localu = ((com.tencent.mm.plugin.biz.a.a)h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(0L, paramString);
      a locala = new a(paramString);
      if (!locala.clZ)
      {
        Log.e("MicroMsg.AppmsgConvert", "buffer error");
        AppMethodBeat.o(21834);
        return "";
      }
      b.a.b localb = new b.a.b();
      Object localObject1 = localu.nUC;
      Object localObject3 = new HashMap();
      localb.startTag("msg");
      ((Map)localObject3).put("appid", (String)locala.vaO.get(".msg.appmsg.$appid"));
      ((Map)localObject3).put("sdkver", (String)locala.vaO.get(".msg.appmsg.$sdkver"));
      localb.startTag("appmsg", (Map)localObject3);
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = new LinkedList();
      }
      String str1;
      Object localObject2;
      int i;
      if (paramString.size() == 0)
      {
        str1 = "";
        localObject2 = "";
        localObject1 = "";
        localb.addTag("title", str1);
        localb.addTag("des", (String)locala.vaO.get(".msg.appmsg.des"));
        localb.addTag("action", (String)locala.vaO.get(".msg.appmsg.action"));
        localb.addTag("type", locala.getInt(".msg.appmsg.type"));
        localb.addTag("showtype", locala.getInt(".msg.appmsg.showtype"));
        localb.addTag("content", (String)locala.vaO.get(".msg.appmsg.content"));
        localb.addTag("url", (String)localObject2);
        localb.addTag("lowurl", (String)locala.vaO.get(".msg.appmsg.lowurl"));
        localb.startTag("appattach");
        localb.addTag("totallen", locala.getInt(".msg.appmsg.appattach.totallen"));
        localb.addTag("attachid", (String)locala.vaO.get(".msg.appmsg.appattach.attachid"));
        localb.addTag("fileext", (String)locala.vaO.get(".msg.appmsg.appattach.fileext"));
        localb.endTag("appattach");
        localb.startTag("mmreader");
        ((Map)localObject3).put("type", localu.type);
        ((Map)localObject3).put("convMsgCount", paramString.size());
        localb.startTag("category", (Map)localObject3);
        localb.addTag("name", localu.iab);
        localb.startTag("topnew");
        localb.addTag("cover", (String)locala.vaO.get(".msg.appmsg.mmreader.category.topnew.cover"));
        localb.addTag("width", (String)locala.vaO.get(".msg.appmsg.mmreader.category.topnew.width"));
        localb.addTag("height", (String)locala.vaO.get(".msg.appmsg.mmreader.category.topnew.height"));
        localb.addTag("digest", (String)localObject1);
        localb.endTag("topnew");
        i = 0;
        label560:
        if (i >= paramString.size()) {
          break label980;
        }
        localb.startTag("item");
        if (paramString.get(i) != null)
        {
          localObject1 = ((v)paramString.get(i)).title;
          localObject2 = ((v)paramString.get(i)).url;
          str1 = ((v)paramString.get(i)).nUK;
          localObject3 = ((v)paramString.get(i)).nUL;
          String str2 = ((v)paramString.get(i)).time;
          String str3 = ((v)paramString.get(i)).nUM;
          String str4 = ((v)paramString.get(i)).nUN;
          String str5 = ((v)paramString.get(i)).nUO;
          localb.addTag("title", (String)localObject1);
          localb.addTag("url", (String)localObject2);
          localb.addTag("shorturl", str1);
          localb.addTag("longurl", (String)localObject3);
          localb.addTag("pub_time", str2);
          localb.addTag("cover", str3);
          localb.addTag("tweetid", str4);
          localb.addTag("digest", str5);
          localObject2 = new StringBuilder(".msg.appmsg.mmreader.category.item");
          if (i != 0) {
            break label972;
          }
        }
      }
      label972:
      for (localObject1 = "";; localObject1 = String.valueOf(i))
      {
        localObject1 = (String)localObject1;
        localb.addTag("fileid", (String)locala.vaO.get((String)localObject1 + ".fileid"));
        localb.startTag("source");
        localb.startTag("source");
        localb.addTag("name", localu.iab);
        localb.endTag("source");
        localb.endTag("source");
        localb.endTag("item");
        i += 1;
        break label560;
        str1 = ((v)paramString.get(0)).title;
        localObject2 = ((v)paramString.get(0)).url;
        paramString.get(0);
        localObject1 = ((v)paramString.get(0)).nUO;
        break;
      }
      label980:
      localb.endTag("category");
      localb.startTag("publisher");
      localb.addTag("convName", localu.iaa);
      localb.addTag("nickname", localu.iab);
      localb.endTag("publisher");
      localb.endTag("mmreader");
      localb.endTag("appmsg");
      localb.addTag("fromusername", localu.iaa);
      localb.addTag("scene", locala.getInt(".msg.scene"));
      localb.startTag("appinfo");
      localb.addTag("version", (String)locala.vaO.get(".msg.appinfo.appname"));
      localb.addTag("appname", (String)locala.vaO.get(".msg.appinfo.version"));
      localb.endTag("appinfo");
      localb.addTag("commenturl", localu.kLg);
      localb.endTag("msg");
      Log.d("MicroMsg.AppmsgConvert", "xml " + localb.sb.toString());
      paramString = localb.sb.toString();
      AppMethodBeat.o(21834);
      return paramString;
    }
    
    static final class a
    {
      boolean clZ;
      Map<String, String> vaO;
      
      public a(String paramString)
      {
        AppMethodBeat.i(21824);
        this.vaO = null;
        this.clZ = true;
        this.vaO = SemiXml.decode(paramString);
        if (this.vaO == null)
        {
          this.clZ = false;
          this.vaO = new HashMap();
        }
        AppMethodBeat.o(21824);
      }
      
      final int getInt(String paramString)
      {
        AppMethodBeat.i(21825);
        if (!this.vaO.containsKey(paramString))
        {
          AppMethodBeat.o(21825);
          return 0;
        }
        int i = Util.getInt((String)this.vaO.get(paramString), 0);
        AppMethodBeat.o(21825);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b
 * JD-Core Version:    0.7.0.1
 */