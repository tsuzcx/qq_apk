package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class f
  implements l
{
  private static String a(jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21520);
    z localz = c.ahJ(paramcc.field_imgPath);
    if (localz == null)
    {
      AppMethodBeat.o(21520);
      return null;
    }
    if (paramcc.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramjd.vhJ = i;
      if (!Util.isNullOrNil(paramcc.field_content)) {
        break;
      }
      AppMethodBeat.o(21520);
      return null;
    }
    if (c.DQ(paramcc.field_talker)) {}
    for (paramjd = localz.bOq();; paramjd = paramjd.YFE.abwM)
    {
      paramcc = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput(paramcc);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "videomsg");
        Map localMap = XmlParser.parseXml(localz.bOu(), "msg", null);
        if (localMap != null)
        {
          localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.videomsg.$aeskey"));
          localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.videomsg.$cdnthumbaeskey"));
          localXmlSerializer.attribute(null, "cdnvideourl", (String)localMap.get(".msg.videomsg.$cdnvideourl"));
          localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.videomsg.$cdnthumburl"));
          localXmlSerializer.attribute(null, "cdnthumblength", (String)localMap.get(".msg.videomsg.$cdnthumblength"));
          localXmlSerializer.attribute(null, "rawmd5", (String)localMap.get(".msg.videomsg.$rawmd5"));
          localXmlSerializer.attribute(null, "cdnrawvideourl", (String)localMap.get(".msg.videomsg.$cdnrawvideourl"));
          localXmlSerializer.attribute(null, "cdnrawvideoaeskey", (String)localMap.get(".msg.videomsg.$cdnrawvideoaeskey"));
          localXmlSerializer.attribute(null, "rawlength", (String)localMap.get(".msg.videomsg.$rawlength"));
          localXmlSerializer.attribute(null, "overwritenewmsgid", (String)localMap.get(".msg.videomsg.$overwritenewmsgid"));
        }
        localXmlSerializer.attribute(null, "playlength", localz.omT);
        localXmlSerializer.attribute(null, "length", localz.osy);
        localXmlSerializer.attribute(null, "type", String.valueOf(i));
        if (!Util.isNullOrNil(paramjd)) {
          localXmlSerializer.attribute(null, "fromusername", paramjd);
        }
        localXmlSerializer.attribute(null, "md5", localz.ibd);
        localXmlSerializer.endTag(null, "videomsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        paramcc.flush();
        paramcc.close();
        paramjd = paramcc.getBuffer().toString();
        Log.d("MicroMsg.BackupItemVideo", "parseContent xml:".concat(String.valueOf(paramjd)));
        AppMethodBeat.o(21520);
        return paramjd;
      }
      catch (Exception paramjd)
      {
        Log.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + paramjd.toString());
        AppMethodBeat.o(21520);
      }
    }
    return null;
  }
  
  public final int a(jd paramjd, boolean paramBoolean1, cc paramcc, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21518);
    int k = 0;
    d.cWK().cWL().bOh();
    paramHashMap = aa.PX(paramcc.field_imgPath);
    paramString = c.ahJ(paramcc.field_imgPath);
    int j;
    Object localObject;
    int i;
    if ((paramString == null) || (paramString.status == 199))
    {
      j = 1;
      localObject = new com.tencent.mm.vfs.u(paramHashMap);
      i = k;
      if (j != 0)
      {
        i = k;
        if (((com.tencent.mm.vfs.u)localObject).jKS()) {
          i = (int)((com.tencent.mm.vfs.u)localObject).length();
        }
      }
      if (paramString != null) {
        break label275;
      }
      paramString = paramcc.field_imgPath + "origin";
      label126:
      d.cWK().cWL().bOh();
      localObject = aa.PX(paramString);
      paramString = c.ahJ(paramString);
      if ((paramString == null) || (paramString.status != 199)) {
        break label285;
      }
      k = 1;
      label169:
      if (k == 0) {
        break label550;
      }
      paramString = new com.tencent.mm.vfs.u((String)localObject);
      if (!paramString.jKS()) {
        break label550;
      }
    }
    label275:
    label285:
    label544:
    label547:
    label550:
    for (int m = (int)paramString.length() + i;; m = i)
    {
      int n = 0;
      d.cWK().cWL().bOh();
      paramString = aa.PY(paramcc.field_imgPath);
      com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u(paramString);
      if (localu.jKS()) {
        n = (int)localu.length();
      }
      if (paramBoolean1)
      {
        AppMethodBeat.o(21518);
        return n + m;
        j = 0;
        break;
        paramString = paramString.oYk;
        break label126;
        k = 0;
        break label169;
      }
      i = 0;
      if (n != 0)
      {
        if (paramcc.getType() == 62) {
          i = i.a(new i.a(paramString, paramjd, paramLinkedList, 13, paramBoolean1, "_thumb", paramBoolean2)) + 0;
        }
      }
      else
      {
        if ((j == 0) || (m == 0)) {
          break label547;
        }
        if (paramcc.getType() != 62) {
          break label429;
        }
        i = i.a(new i.a(paramHashMap, paramjd, paramLinkedList, 12, paramBoolean1, paramBoolean2, null)) + i;
      }
      for (;;)
      {
        paramcc = a(paramjd, paramcc);
        if (paramcc == null)
        {
          AppMethodBeat.o(21518);
          return i;
          i = i.a(new i.a(paramString, paramjd, paramLinkedList, 11, paramBoolean1, "_thumb", paramBoolean2)) + 0;
          break;
          label429:
          i += i.a(new i.a(paramHashMap, paramjd, paramLinkedList, 10, paramBoolean1, paramBoolean2, null));
          if (k == 0) {
            break label544;
          }
          j = i.a(new i.a((String)localObject, paramjd, paramLinkedList, 17, paramBoolean1, "_hd", paramBoolean2));
          i += j;
          Log.e("MicroMsg.BackupItemVideo", "pack origin video, packed video size = ".concat(String.valueOf(j)));
          continue;
        }
        paramjd.YFG = new etl().btH(paramcc);
        j = paramcc.length();
        AppMethodBeat.o(21518);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21519);
    z localz = new z();
    localz.hVQ = paramjd.YFE.abwM;
    localz.createTime = paramcc.getCreateTime();
    localz.hTh = paramjd.Njv;
    paramString = paramjd.YFG.abwM;
    Log.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(paramString)));
    Object localObject1 = XmlParser.parseXml(paramString, "msg", null);
    label202:
    label228:
    Object localObject2;
    if (localObject1 != null)
    {
      try
      {
        localz.osy = g.dr((String)((Map)localObject1).get(".msg.videomsg.$length"), 0);
        localz.omT = g.dr((String)((Map)localObject1).get(".msg.videomsg.$playlength"), 0);
        localz.paV = ((String)((Map)localObject1).get(".msg.videomsg.$fromusername"));
        i = g.dr((String)((Map)localObject1).get(".msg.videomsg.$type"), 0);
        Log.d("MicroMsg.BackupItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label801;
        }
        i = 1;
        localz.pbf = i;
        localz.pbh = paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          int i;
          label464:
          Log.e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
          Log.printErrStackTrace("MicroMsg.BackupItemVideo", paramString, "", new Object[0]);
        }
      }
      if ((!g.d(paramjd, 10)) && (!g.d(paramjd, 12))) {
        break label868;
      }
      localz.status = 199;
      localObject2 = aa.PW(localz.bOs());
      paramcc.BT((String)localObject2);
      localz.fileName = ((String)localObject2);
      if (paramcc.getType() != 62) {
        paramcc.setType(43);
      }
      paramcc.setContent(x.a(localz.bOq(), localz.pbb, false));
      localz.pbc = ((int)c.B(paramcc));
      localz.pba = Util.nowSecond();
      localz.pbd = 0;
      Log.d("MicroMsg.BackupItemVideo", "Insert fileName[" + localz.getFileName() + "] size:" + localz.osy + " svrid:" + localz.hTh + " timelen:" + localz.omT + " user:" + localz.bOs() + " human:" + localz.bOq());
      d.cWK().cWL().bOh().b(localz);
      d.cWK().cWL().bOh();
      localObject1 = aa.PY((String)localObject2);
      paramString = null;
      if (paramcc.getType() != 62) {
        break label878;
      }
      g.b(paramjd, 13, (String)localObject1);
      localObject1 = g.a(paramjd, 12);
      if (localObject1 != null)
      {
        localObject1 = g.ahz((String)localObject1) + (String)localObject1;
        d.cWK().cWL().bOh();
        y.qn((String)localObject1, aa.PX((String)localObject2));
      }
      if (paramString != null)
      {
        paramString = g.ahz(paramString) + paramString;
        localObject1 = (String)localObject2 + "origin";
        localObject2 = new z();
        ((z)localObject2).fileName = ((String)localObject1);
        ((z)localObject2).createTime = paramcc.getCreateTime();
        ((z)localObject2).pba = Util.nowSecond();
        ((z)localObject2).pbd = 0;
        if (!g.d(paramjd, 17)) {
          break label908;
        }
      }
    }
    label908:
    for (((z)localObject2).status = 199;; ((z)localObject2).status = 111)
    {
      ((z)localObject2).omT = localz.omT;
      ((z)localObject2).osy = localz.osy;
      Log.d("MicroMsg.BackupItemVideo", "Insert origin fileName[" + ((z)localObject2).getFileName() + "] size:" + ((z)localObject2).osy + " svrid:" + ((z)localObject2).hTh + " timelen:" + ((z)localObject2).omT + " user:" + ((z)localObject2).bOs() + " human:" + ((z)localObject2).bOq());
      d.cWK().cWL().bOh().b((z)localObject2);
      localz.PP((String)localObject1);
      d.cWK().cWL().bOh().c(localz);
      d.cWK().cWL().bOh();
      y.qn(paramString, aa.PX((String)localObject1));
      AppMethodBeat.o(21519);
      return 0;
      label801:
      i = 0;
      break;
      Log.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", new Object[] { paramjd.YFG.abwM });
      paramcc.setContent(paramjd.YFG.abwM);
      break label202;
      label868:
      localz.status = 111;
      break label228;
      label878:
      g.b(paramjd, 11, (String)localObject1);
      localObject1 = g.a(paramjd, 10);
      paramString = g.a(paramjd, 17, "_hd");
      break label464;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.f
 * JD-Core Version:    0.7.0.1
 */