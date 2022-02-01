package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.q;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g
  implements j
{
  private static String a(ih paramih, ca paramca)
  {
    AppMethodBeat.i(21852);
    w localw = d.aom(paramca.field_imgPath);
    if (localw == null)
    {
      AppMethodBeat.o(21852);
      return null;
    }
    if (paramca.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramih.rWu = i;
      if (!Util.isNullOrNil(paramca.field_content)) {
        break;
      }
      AppMethodBeat.o(21852);
      return null;
    }
    if (d.Lj(paramca.field_talker)) {}
    for (paramih = localw.bqK();; paramih = paramih.RID.Ufy)
    {
      paramca = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput(paramca);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "videomsg");
        Map localMap = XmlParser.parseXml(localw.bqO(), "msg", null);
        if (localMap != null)
        {
          localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.videomsg.$aeskey"));
          localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.videomsg.$cdnthumbaeskey"));
          localXmlSerializer.attribute(null, "cdnvideourl", (String)localMap.get(".msg.videomsg.$cdnvideourl"));
          localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.videomsg.$cdnthumburl"));
          localXmlSerializer.attribute(null, "cdnthumblength", (String)localMap.get(".msg.videomsg.$cdnthumblength"));
        }
        localXmlSerializer.attribute(null, "playlength", localw.lvw);
        localXmlSerializer.attribute(null, "length", localw.lAW);
        localXmlSerializer.attribute(null, "type", String.valueOf(i));
        if (!Util.isNullOrNil(paramih)) {
          localXmlSerializer.attribute(null, "fromusername", paramih);
        }
        localXmlSerializer.attribute(null, "md5", localw.fVg);
        localXmlSerializer.endTag(null, "videomsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        paramca.flush();
        paramca.close();
        paramih = paramca.getBuffer().toString();
        Log.d("MicroMsg.BakOldItemVideo", "parseContent xml:".concat(String.valueOf(paramih)));
        AppMethodBeat.o(21852);
        return paramih;
      }
      catch (Exception paramih)
      {
        Log.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + paramih.toString());
        AppMethodBeat.o(21852);
      }
    }
    return null;
  }
  
  public final int a(ih paramih, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(279391);
    b.cuH().cuI().bqB();
    paramString = x.XT(paramca.field_imgPath);
    Object localObject = d.aom(paramca.field_imgPath);
    int j;
    if ((localObject == null) || (((w)localObject).status == 199))
    {
      j = 1;
      localObject = new q(paramString);
      if ((j == 0) || (!((q)localObject).ifE())) {
        break label332;
      }
    }
    label174:
    label329:
    label332:
    for (int k = (int)((q)localObject).length();; k = 0)
    {
      int m = 0;
      b.cuH().cuI().bqB();
      localObject = x.XU(paramca.field_imgPath);
      q localq = new q((String)localObject);
      if (localq.ifE()) {
        m = (int)localq.length();
      }
      int i = 0;
      if (m != 0)
      {
        if (paramca.getType() == 62) {
          i = i.a(new i.a((String)localObject, paramih, paramLinkedList, 13, false, "_thumb", false)) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label329;
        }
        if (paramca.getType() != 62) {
          break label270;
        }
        i = i.a(new i.a(paramString, paramih, paramLinkedList, 12, false, false, null)) + i;
      }
      for (;;)
      {
        paramca = a(paramih, paramca);
        if (paramca == null)
        {
          AppMethodBeat.o(279391);
          return i;
          j = 0;
          break;
          i = i.a(new i.a((String)localObject, paramih, paramLinkedList, 11, false, "_thumb", false)) + 0;
          break label174;
          i = i.a(new i.a(paramString, paramih, paramLinkedList, 10, false, false, null)) + i;
          continue;
        }
        paramih.RIF = new eaf().btQ(paramca);
        j = paramca.length();
        AppMethodBeat.o(279391);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, ih paramih, ca paramca)
  {
    AppMethodBeat.i(21851);
    paramString = new w();
    paramString.fPV = paramih.RID.Ufy;
    paramString.createTime = paramca.field_createTime;
    paramString.fNu = paramih.HlH;
    Object localObject = paramih.RIF.Ufy;
    Log.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = XmlParser.parseXml((String)localObject, "msg", null);
    if (localObject != null)
    {
      try
      {
        paramString.lAW = a.cP((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.lvw = a.cP((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.mhK = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = a.cP((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        Log.d("MicroMsg.BakOldItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label470;
        }
        i = 1;
        paramString.mhU = i;
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
      if ((!a.d(paramih, 10)) && (!a.d(paramih, 12))) {
        break label539;
      }
      paramString.status = 199;
      localObject = x.XS(paramString.bqM());
      paramca.Jn((String)localObject);
      paramString.fileName = ((String)localObject);
      if (paramca.getType() != 62) {
        paramca.setType(43);
      }
      paramca.setContent(com.tencent.mm.modelvideo.u.a(paramString.bqK(), paramString.mhQ, false));
      paramString.mhR = ((int)d.z(paramca));
      paramString.mhP = Util.nowSecond();
      paramString.mhS = 0;
      Log.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.lAW + " svrid:" + paramString.fNu + " timelen:" + paramString.lvw + " user:" + paramString.bqM() + " human:" + paramString.bqK());
      b.cuH().cuI().bqB().b(paramString);
      b.cuH().cuI().bqB();
      paramString = x.XU((String)localObject);
      if (paramca.getType() != 62) {
        break label548;
      }
      a.b(paramih, 13, paramString);
    }
    for (paramString = a.a(paramih, 12);; paramString = a.a(paramih, 10))
    {
      if (paramString != null)
      {
        paramString = a.aoq(paramString);
        b.cuH().cuI().bqB();
        com.tencent.mm.vfs.u.on(paramString, x.XT((String)localObject));
      }
      AppMethodBeat.o(21851);
      return 0;
      label470:
      i = 0;
      break;
      Log.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", new Object[] { paramih.RIF.Ufy });
      paramca.setContent(paramih.RIF.Ufy);
      break label191;
      label539:
      paramString.status = 111;
      break label216;
      label548:
      a.b(paramih, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.g
 * JD-Core Version:    0.7.0.1
 */