package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.e;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g
  implements j
{
  private static String a(if paramif, bu parambu)
  {
    AppMethodBeat.i(21852);
    s locals = d.Wc(parambu.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(21852);
      return null;
    }
    if (parambu.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramif.nEf = i;
      if (!bt.isNullOrNil(parambu.field_content)) {
        break;
      }
      AppMethodBeat.o(21852);
      return null;
    }
    if (d.vF(parambu.field_talker)) {}
    for (paramif = locals.aMS();; paramif = paramif.Fvi.HoB)
    {
      parambu = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput(parambu);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "videomsg");
        Map localMap = bw.M(locals.aMV(), "msg");
        if (localMap != null)
        {
          localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.videomsg.$aeskey"));
          localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.videomsg.$cdnthumbaeskey"));
          localXmlSerializer.attribute(null, "cdnvideourl", (String)localMap.get(".msg.videomsg.$cdnvideourl"));
          localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.videomsg.$cdnthumburl"));
          localXmlSerializer.attribute(null, "cdnthumblength", (String)localMap.get(".msg.videomsg.$cdnthumblength"));
        }
        localXmlSerializer.attribute(null, "playlength", locals.hHQ);
        localXmlSerializer.attribute(null, "length", locals.hMP);
        localXmlSerializer.attribute(null, "type", String.valueOf(i));
        if (!bt.isNullOrNil(paramif)) {
          localXmlSerializer.attribute(null, "fromusername", paramif);
        }
        localXmlSerializer.attribute(null, "md5", locals.dIs);
        localXmlSerializer.endTag(null, "videomsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        parambu.flush();
        parambu.close();
        paramif = parambu.getBuffer().toString();
        ad.d("MicroMsg.BakOldItemVideo", "parseContent xml:".concat(String.valueOf(paramif)));
        AppMethodBeat.o(21852);
        return paramif;
      }
      catch (Exception paramif)
      {
        ad.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + paramif.toString());
        AppMethodBeat.o(21852);
      }
    }
    return null;
  }
  
  public final int a(if paramif, bu parambu, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21850);
    b.bJF().bJG().aMJ();
    String str = t.Hh(parambu.field_imgPath);
    Object localObject = d.Wc(parambu.field_imgPath);
    int j;
    if ((localObject == null) || (((s)localObject).status == 199))
    {
      j = 1;
      localObject = new e(str);
      if ((j == 0) || (!((e)localObject).exists())) {
        break label329;
      }
    }
    label174:
    label326:
    label329:
    for (int k = (int)((e)localObject).length();; k = 0)
    {
      int m = 0;
      b.bJF().bJG().aMJ();
      localObject = t.Hi(parambu.field_imgPath);
      e locale = new e((String)localObject);
      if (locale.exists()) {
        m = (int)locale.length();
      }
      int i = 0;
      if (m != 0)
      {
        if (parambu.getType() == 62) {
          i = i.a(new i.a((String)localObject, paramif, paramLinkedList, 13, "_thumb")) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label326;
        }
        if (parambu.getType() != 62) {
          break label267;
        }
        i = i.a(new i.a(str, paramif, paramLinkedList, 12, false, null)) + i;
      }
      for (;;)
      {
        parambu = a(paramif, parambu);
        if (parambu == null)
        {
          AppMethodBeat.o(21850);
          return i;
          j = 0;
          break;
          i = i.a(new i.a((String)localObject, paramif, paramLinkedList, 11, "_thumb")) + 0;
          break label174;
          i = i.a(new i.a(str, paramif, paramLinkedList, 10, false, null)) + i;
          continue;
        }
        paramif.Fvk = new cwt().aPy(parambu);
        j = parambu.length();
        AppMethodBeat.o(21850);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, if paramif, bu parambu)
  {
    AppMethodBeat.i(21851);
    paramString = new s();
    paramString.dDy = paramif.Fvi.HoB;
    paramString.createTime = parambu.field_createTime;
    paramString.dAY = paramif.xbt;
    Object localObject = paramif.Fvk.HoB;
    ad.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = bw.M((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.hMP = a.cj((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.hHQ = a.cj((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.itY = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = a.cj((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        ad.d("MicroMsg.BakOldItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label469;
        }
        i = 1;
        paramString.iui = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          label190:
          label215:
          ad.e("MicroMsg.BakOldItemVideo", "parsing voice msg xml failed");
          ad.printErrStackTrace("MicroMsg.BakOldItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!a.d(paramif, 10)) && (!a.d(paramif, 12))) {
        break label538;
      }
      paramString.status = 199;
      localObject = t.Hg(paramString.getUser());
      parambu.tO((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambu.getType() != 62) {
        parambu.setType(43);
      }
      parambu.setContent(q.b(paramString.aMS(), paramString.iue, false));
      paramString.iuf = ((int)d.v(parambu));
      paramString.iud = bt.aQJ();
      paramString.iug = 0;
      ad.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.hMP + " svrid:" + paramString.dAY + " timelen:" + paramString.hHQ + " user:" + paramString.getUser() + " human:" + paramString.aMS());
      b.bJF().bJG().aMJ().b(paramString);
      b.bJF().bJG().aMJ();
      paramString = t.Hi((String)localObject);
      if (parambu.getType() != 62) {
        break label547;
      }
      a.b(paramif, 13, paramString);
    }
    for (paramString = a.a(paramif, 12);; paramString = a.a(paramif, 10))
    {
      if (paramString != null)
      {
        paramString = a.Wg(paramString);
        b.bJF().bJG().aMJ();
        com.tencent.mm.vfs.i.mz(paramString, t.Hh((String)localObject));
      }
      AppMethodBeat.o(21851);
      return 0;
      label469:
      i = 0;
      break;
      ad.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", new Object[] { paramif.Fvk.HoB });
      parambu.setContent(paramif.Fvk.HoB);
      break label190;
      label538:
      paramString.status = 111;
      break label215;
      label547:
      a.b(paramif, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.g
 * JD-Core Version:    0.7.0.1
 */