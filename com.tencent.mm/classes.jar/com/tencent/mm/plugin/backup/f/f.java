package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.e;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class f
  implements l
{
  private static String a(if paramif, bu parambu)
  {
    AppMethodBeat.i(21520);
    s locals = c.Wc(parambu.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(21520);
      return null;
    }
    if (parambu.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramif.nEf = i;
      if (!bt.isNullOrNil(parambu.field_content)) {
        break;
      }
      AppMethodBeat.o(21520);
      return null;
    }
    if (c.vF(parambu.field_talker)) {}
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
        ad.d("MicroMsg.BackupItemVideo", "parseContent xml:".concat(String.valueOf(paramif)));
        AppMethodBeat.o(21520);
        return paramif;
      }
      catch (Exception paramif)
      {
        ad.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + paramif.toString());
        AppMethodBeat.o(21520);
      }
    }
    return null;
  }
  
  public final int a(if paramif, boolean paramBoolean1, bu parambu, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21518);
    d.bIY().bIZ().aMJ();
    paramString = t.Hh(parambu.field_imgPath);
    paramHashMap = c.Wc(parambu.field_imgPath);
    int j;
    if ((paramHashMap == null) || (paramHashMap.status == 199))
    {
      j = 1;
      paramHashMap = new e(paramString);
      if ((j == 0) || (!paramHashMap.exists())) {
        break label359;
      }
    }
    label294:
    label356:
    label359:
    for (int k = (int)paramHashMap.length();; k = 0)
    {
      int m = 0;
      d.bIY().bIZ().aMJ();
      paramHashMap = t.Hi(parambu.field_imgPath);
      e locale = new e(paramHashMap);
      if (locale.exists()) {
        m = (int)locale.length();
      }
      if (paramBoolean1)
      {
        AppMethodBeat.o(21518);
        return m + k;
        j = 0;
        break;
      }
      int i = 0;
      if (m != 0)
      {
        if (parambu.getType() == 62) {
          i = i.a(new i.a(paramHashMap, paramif, paramLinkedList, 13, paramBoolean1, "_thumb", paramBoolean2)) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label356;
        }
        if (parambu.getType() != 62) {
          break label294;
        }
        i = i.a(new i.a(paramString, paramif, paramLinkedList, 12, paramBoolean1, paramBoolean2, null)) + i;
      }
      for (;;)
      {
        parambu = a(paramif, parambu);
        if (parambu == null)
        {
          AppMethodBeat.o(21518);
          return i;
          i = i.a(new i.a(paramHashMap, paramif, paramLinkedList, 11, paramBoolean1, "_thumb", paramBoolean2)) + 0;
          break;
          i = i.a(new i.a(paramString, paramif, paramLinkedList, 10, paramBoolean1, paramBoolean2, null)) + i;
          continue;
        }
        paramif.Fvk = new cwt().aPy(parambu);
        j = parambu.length();
        AppMethodBeat.o(21518);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, if paramif, bu parambu)
  {
    AppMethodBeat.i(21519);
    paramString = new s();
    paramString.dDy = paramif.Fvi.HoB;
    paramString.createTime = parambu.field_createTime;
    paramString.dAY = paramif.xbt;
    Object localObject = paramif.Fvk.HoB;
    ad.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = bw.M((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.hMP = g.cj((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.hHQ = g.cj((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.itY = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = g.cj((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        ad.d("MicroMsg.BackupItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label486;
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
          ad.e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
          ad.printErrStackTrace("MicroMsg.BackupItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!g.d(paramif, 10)) && (!g.d(paramif, 12))) {
        break label555;
      }
      paramString.status = 199;
      localObject = t.Hg(paramString.getUser());
      parambu.tO((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambu.getType() != 62) {
        parambu.setType(43);
      }
      parambu.setContent(q.b(paramString.aMS(), paramString.iue, false));
      paramString.iuf = ((int)c.v(parambu));
      paramString.iud = bt.aQJ();
      paramString.iug = 0;
      ad.d("MicroMsg.BackupItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.hMP + " svrid:" + paramString.dAY + " timelen:" + paramString.hHQ + " user:" + paramString.getUser() + " human:" + paramString.aMS());
      d.bIY().bIZ().aMJ().b(paramString);
      d.bIY().bIZ().aMJ();
      paramString = t.Hi((String)localObject);
      if (parambu.getType() != 62) {
        break label564;
      }
      g.b(paramif, 13, paramString);
    }
    for (paramString = g.a(paramif, 12);; paramString = g.a(paramif, 10))
    {
      if (paramString != null)
      {
        paramString = g.VQ(paramString) + paramString;
        d.bIY().bIZ().aMJ();
        com.tencent.mm.vfs.i.mA(paramString, t.Hh((String)localObject));
      }
      AppMethodBeat.o(21519);
      return 0;
      label486:
      i = 0;
      break;
      ad.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", new Object[] { paramif.Fvk.HoB });
      parambu.setContent(paramif.Fvk.HoB);
      break label190;
      label555:
      paramString.status = 111;
      break label215;
      label564:
      g.b(paramif, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.f
 * JD-Core Version:    0.7.0.1
 */