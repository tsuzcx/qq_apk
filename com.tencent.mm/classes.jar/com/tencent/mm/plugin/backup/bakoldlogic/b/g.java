package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g
  implements j
{
  private static String a(is paramis, ca paramca)
  {
    AppMethodBeat.i(21852);
    com.tencent.mm.modelvideo.s locals = d.agI(paramca.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(21852);
      return null;
    }
    if (paramca.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramis.oUv = i;
      if (!Util.isNullOrNil(paramca.field_content)) {
        break;
      }
      AppMethodBeat.o(21852);
      return null;
    }
    if (d.Eq(paramca.field_talker)) {}
    for (paramis = locals.bhs();; paramis = paramis.KHl.MTo)
    {
      paramca = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput(paramca);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "videomsg");
        Map localMap = XmlParser.parseXml(locals.bhv(), "msg", null);
        if (localMap != null)
        {
          localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.videomsg.$aeskey"));
          localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.videomsg.$cdnthumbaeskey"));
          localXmlSerializer.attribute(null, "cdnvideourl", (String)localMap.get(".msg.videomsg.$cdnvideourl"));
          localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.videomsg.$cdnthumburl"));
          localXmlSerializer.attribute(null, "cdnthumblength", (String)localMap.get(".msg.videomsg.$cdnthumblength"));
        }
        localXmlSerializer.attribute(null, "playlength", locals.iFw);
        localXmlSerializer.attribute(null, "length", locals.iKP);
        localXmlSerializer.attribute(null, "type", String.valueOf(i));
        if (!Util.isNullOrNil(paramis)) {
          localXmlSerializer.attribute(null, "fromusername", paramis);
        }
        localXmlSerializer.attribute(null, "md5", locals.ebj);
        localXmlSerializer.endTag(null, "videomsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        paramca.flush();
        paramca.close();
        paramis = paramca.getBuffer().toString();
        Log.d("MicroMsg.BakOldItemVideo", "parseContent xml:".concat(String.valueOf(paramis)));
        AppMethodBeat.o(21852);
        return paramis;
      }
      catch (Exception paramis)
      {
        Log.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + paramis.toString());
        AppMethodBeat.o(21852);
      }
    }
    return null;
  }
  
  public final int a(is paramis, ca paramca, String paramString, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(231602);
    b.chw().chx().bhj();
    paramString = t.Qw(paramca.field_imgPath);
    Object localObject = d.agI(paramca.field_imgPath);
    int j;
    if ((localObject == null) || (((com.tencent.mm.modelvideo.s)localObject).status == 199))
    {
      j = 1;
      localObject = new o(paramString);
      if ((j == 0) || (!((o)localObject).exists())) {
        break label332;
      }
    }
    label174:
    label329:
    label332:
    for (int k = (int)((o)localObject).length();; k = 0)
    {
      int m = 0;
      b.chw().chx().bhj();
      localObject = t.Qx(paramca.field_imgPath);
      o localo = new o((String)localObject);
      if (localo.exists()) {
        m = (int)localo.length();
      }
      int i = 0;
      if (m != 0)
      {
        if (paramca.getType() == 62) {
          i = i.a(new i.a((String)localObject, paramis, paramLinkedList, 13, false, "_thumb", false)) + 0;
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
        i = i.a(new i.a(paramString, paramis, paramLinkedList, 12, false, false, null)) + i;
      }
      for (;;)
      {
        paramca = a(paramis, paramca);
        if (paramca == null)
        {
          AppMethodBeat.o(231602);
          return i;
          j = 0;
          break;
          i = i.a(new i.a((String)localObject, paramis, paramLinkedList, 11, false, "_thumb", false)) + 0;
          break label174;
          i = i.a(new i.a(paramString, paramis, paramLinkedList, 10, false, false, null)) + i;
          continue;
        }
        paramis.KHn = new dqi().bhy(paramca);
        j = paramca.length();
        AppMethodBeat.o(231602);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, is paramis, ca paramca)
  {
    AppMethodBeat.i(21851);
    paramString = new com.tencent.mm.modelvideo.s();
    paramString.dWq = paramis.KHl.MTo;
    paramString.createTime = paramca.field_createTime;
    paramString.dTS = paramis.Brn;
    Object localObject = paramis.KHn.MTo;
    Log.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = XmlParser.parseXml((String)localObject, "msg", null);
    if (localObject != null)
    {
      try
      {
        paramString.iKP = a.cv((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.iFw = a.cv((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.jsh = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = a.cv((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        Log.d("MicroMsg.BakOldItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label470;
        }
        i = 1;
        paramString.jsr = i;
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
      if ((!a.d(paramis, 10)) && (!a.d(paramis, 12))) {
        break label539;
      }
      paramString.status = 199;
      localObject = t.Qv(paramString.getUser());
      paramca.Cz((String)localObject);
      paramString.fileName = ((String)localObject);
      if (paramca.getType() != 62) {
        paramca.setType(43);
      }
      paramca.setContent(q.b(paramString.bhs(), paramString.jsn, false));
      paramString.jso = ((int)d.x(paramca));
      paramString.jsm = Util.nowSecond();
      paramString.jsp = 0;
      Log.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.iKP + " svrid:" + paramString.dTS + " timelen:" + paramString.iFw + " user:" + paramString.getUser() + " human:" + paramString.bhs());
      b.chw().chx().bhj().b(paramString);
      b.chw().chx().bhj();
      paramString = t.Qx((String)localObject);
      if (paramca.getType() != 62) {
        break label548;
      }
      a.b(paramis, 13, paramString);
    }
    for (paramString = a.a(paramis, 12);; paramString = a.a(paramis, 10))
    {
      if (paramString != null)
      {
        paramString = a.agM(paramString);
        b.chw().chx().bhj();
        com.tencent.mm.vfs.s.nw(paramString, t.Qw((String)localObject));
      }
      AppMethodBeat.o(21851);
      return 0;
      label470:
      i = 0;
      break;
      Log.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", new Object[] { paramis.KHn.MTo });
      paramca.setContent(paramis.KHn.MTo);
      break label191;
      label539:
      paramString.status = 111;
      break label216;
      label548:
      a.b(paramis, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.g
 * JD-Core Version:    0.7.0.1
 */