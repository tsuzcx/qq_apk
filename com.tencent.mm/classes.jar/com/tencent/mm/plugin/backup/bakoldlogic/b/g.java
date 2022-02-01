package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g
  implements j
{
  private static String a(jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21852);
    z localz = d.ahJ(paramcc.field_imgPath);
    if (localz == null)
    {
      AppMethodBeat.o(21852);
      return null;
    }
    if (paramcc.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramjd.vhJ = i;
      if (!Util.isNullOrNil(paramcc.field_content)) {
        break;
      }
      AppMethodBeat.o(21852);
      return null;
    }
    if (d.DQ(paramcc.field_talker)) {}
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
        Log.d("MicroMsg.BakOldItemVideo", "parseContent xml:".concat(String.valueOf(paramjd)));
        AppMethodBeat.o(21852);
        return paramjd;
      }
      catch (Exception paramjd)
      {
        Log.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + paramjd.toString());
        AppMethodBeat.o(21852);
      }
    }
    return null;
  }
  
  public final int a(jd paramjd, cc paramcc, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(300724);
    b.cXr().cXs().bOh();
    paramString = aa.PX(paramcc.field_imgPath);
    Object localObject = d.ahJ(paramcc.field_imgPath);
    int j;
    if ((localObject == null) || (((z)localObject).status == 199))
    {
      j = 1;
      localObject = new com.tencent.mm.vfs.u(paramString);
      if ((j == 0) || (!((com.tencent.mm.vfs.u)localObject).jKS())) {
        break label332;
      }
    }
    label174:
    label329:
    label332:
    for (int k = (int)((com.tencent.mm.vfs.u)localObject).length();; k = 0)
    {
      int m = 0;
      b.cXr().cXs().bOh();
      localObject = aa.PY(paramcc.field_imgPath);
      com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u((String)localObject);
      if (localu.jKS()) {
        m = (int)localu.length();
      }
      int i = 0;
      if (m != 0)
      {
        if (paramcc.getType() == 62) {
          i = i.a(new i.a((String)localObject, paramjd, paramLinkedList, 13, false, "_thumb", false)) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label329;
        }
        if (paramcc.getType() != 62) {
          break label270;
        }
        i = i.a(new i.a(paramString, paramjd, paramLinkedList, 12, false, false, null)) + i;
      }
      for (;;)
      {
        paramcc = a(paramjd, paramcc);
        if (paramcc == null)
        {
          AppMethodBeat.o(300724);
          return i;
          j = 0;
          break;
          i = i.a(new i.a((String)localObject, paramjd, paramLinkedList, 11, false, "_thumb", false)) + 0;
          break label174;
          i = i.a(new i.a(paramString, paramjd, paramLinkedList, 10, false, false, null)) + i;
          continue;
        }
        paramjd.YFG = new etl().btH(paramcc);
        j = paramcc.length();
        AppMethodBeat.o(300724);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21851);
    paramString = new z();
    paramString.hVQ = paramjd.YFE.abwM;
    paramString.createTime = paramcc.getCreateTime();
    paramString.hTh = paramjd.Njv;
    Object localObject = paramjd.YFG.abwM;
    Log.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = XmlParser.parseXml((String)localObject, "msg", null);
    if (localObject != null)
    {
      try
      {
        paramString.osy = a.dr((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.omT = a.dr((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.paV = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = a.dr((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        Log.d("MicroMsg.BakOldItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label471;
        }
        i = 1;
        paramString.pbf = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          label191:
          label216:
          Log.e("MicroMsg.BakOldItemVideo", "parsing voice msg xml failed");
          Log.printErrStackTrace("MicroMsg.BakOldItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!a.d(paramjd, 10)) && (!a.d(paramjd, 12))) {
        break label540;
      }
      paramString.status = 199;
      localObject = aa.PW(paramString.bOs());
      paramcc.BT((String)localObject);
      paramString.fileName = ((String)localObject);
      if (paramcc.getType() != 62) {
        paramcc.setType(43);
      }
      paramcc.setContent(x.a(paramString.bOq(), paramString.pbb, false));
      paramString.pbc = ((int)d.B(paramcc));
      paramString.pba = Util.nowSecond();
      paramString.pbd = 0;
      Log.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.osy + " svrid:" + paramString.hTh + " timelen:" + paramString.omT + " user:" + paramString.bOs() + " human:" + paramString.bOq());
      b.cXr().cXs().bOh().b(paramString);
      b.cXr().cXs().bOh();
      paramString = aa.PY((String)localObject);
      if (paramcc.getType() != 62) {
        break label549;
      }
      a.b(paramjd, 13, paramString);
    }
    for (paramString = a.a(paramjd, 12);; paramString = a.a(paramjd, 10))
    {
      if (paramString != null)
      {
        paramString = a.ahN(paramString);
        b.cXr().cXs().bOh();
        y.O(paramString, aa.PX((String)localObject), false);
      }
      AppMethodBeat.o(21851);
      return 0;
      label471:
      i = 0;
      break;
      Log.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", new Object[] { paramjd.YFG.abwM });
      paramcc.setContent(paramjd.YFG.abwM);
      break label191;
      label540:
      paramString.status = 111;
      break label216;
      label549:
      a.b(paramjd, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.g
 * JD-Core Version:    0.7.0.1
 */