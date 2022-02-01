package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class f
  implements l
{
  private static String a(is paramis, ca paramca)
  {
    AppMethodBeat.i(21520);
    com.tencent.mm.modelvideo.s locals = c.agI(paramca.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(21520);
      return null;
    }
    if (paramca.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramis.oUv = i;
      if (!Util.isNullOrNil(paramca.field_content)) {
        break;
      }
      AppMethodBeat.o(21520);
      return null;
    }
    if (c.Eq(paramca.field_talker)) {}
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
        Log.d("MicroMsg.BackupItemVideo", "parseContent xml:".concat(String.valueOf(paramis)));
        AppMethodBeat.o(21520);
        return paramis;
      }
      catch (Exception paramis)
      {
        Log.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + paramis.toString());
        AppMethodBeat.o(21520);
      }
    }
    return null;
  }
  
  public final int a(is paramis, boolean paramBoolean1, ca paramca, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21518);
    d.cgP().cgQ().bhj();
    paramString = t.Qw(paramca.field_imgPath);
    paramHashMap = c.agI(paramca.field_imgPath);
    int j;
    if ((paramHashMap == null) || (paramHashMap.status == 199))
    {
      j = 1;
      paramHashMap = new o(paramString);
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
      d.cgP().cgQ().bhj();
      paramHashMap = t.Qx(paramca.field_imgPath);
      o localo = new o(paramHashMap);
      if (localo.exists()) {
        m = (int)localo.length();
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
        if (paramca.getType() == 62) {
          i = i.a(new i.a(paramHashMap, paramis, paramLinkedList, 13, paramBoolean1, "_thumb", paramBoolean2)) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label356;
        }
        if (paramca.getType() != 62) {
          break label294;
        }
        i = i.a(new i.a(paramString, paramis, paramLinkedList, 12, paramBoolean1, paramBoolean2, null)) + i;
      }
      for (;;)
      {
        paramca = a(paramis, paramca);
        if (paramca == null)
        {
          AppMethodBeat.o(21518);
          return i;
          i = i.a(new i.a(paramHashMap, paramis, paramLinkedList, 11, paramBoolean1, "_thumb", paramBoolean2)) + 0;
          break;
          i = i.a(new i.a(paramString, paramis, paramLinkedList, 10, paramBoolean1, paramBoolean2, null)) + i;
          continue;
        }
        paramis.KHn = new dqi().bhy(paramca);
        j = paramca.length();
        AppMethodBeat.o(21518);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, is paramis, ca paramca)
  {
    AppMethodBeat.i(21519);
    paramString = new com.tencent.mm.modelvideo.s();
    paramString.dWq = paramis.KHl.MTo;
    paramString.createTime = paramca.field_createTime;
    paramString.dTS = paramis.Brn;
    Object localObject = paramis.KHn.MTo;
    Log.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = XmlParser.parseXml((String)localObject, "msg", null);
    if (localObject != null)
    {
      try
      {
        paramString.iKP = g.cv((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.iFw = g.cv((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.jsh = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = g.cv((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        Log.d("MicroMsg.BackupItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label487;
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
          Log.e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
          Log.printErrStackTrace("MicroMsg.BackupItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!g.d(paramis, 10)) && (!g.d(paramis, 12))) {
        break label556;
      }
      paramString.status = 199;
      localObject = t.Qv(paramString.getUser());
      paramca.Cz((String)localObject);
      paramString.fileName = ((String)localObject);
      if (paramca.getType() != 62) {
        paramca.setType(43);
      }
      paramca.setContent(q.b(paramString.bhs(), paramString.jsn, false));
      paramString.jso = ((int)c.x(paramca));
      paramString.jsm = Util.nowSecond();
      paramString.jsp = 0;
      Log.d("MicroMsg.BackupItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.iKP + " svrid:" + paramString.dTS + " timelen:" + paramString.iFw + " user:" + paramString.getUser() + " human:" + paramString.bhs());
      d.cgP().cgQ().bhj().b(paramString);
      d.cgP().cgQ().bhj();
      paramString = t.Qx((String)localObject);
      if (paramca.getType() != 62) {
        break label565;
      }
      g.b(paramis, 13, paramString);
    }
    for (paramString = g.a(paramis, 12);; paramString = g.a(paramis, 10))
    {
      if (paramString != null)
      {
        paramString = g.agy(paramString) + paramString;
        d.cgP().cgQ().bhj();
        com.tencent.mm.vfs.s.nx(paramString, t.Qw((String)localObject));
      }
      AppMethodBeat.o(21519);
      return 0;
      label487:
      i = 0;
      break;
      Log.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", new Object[] { paramis.KHn.MTo });
      paramca.setContent(paramis.KHn.MTo);
      break label191;
      label556:
      paramString.status = 111;
      break label216;
      label565:
      g.b(paramis, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.f
 * JD-Core Version:    0.7.0.1
 */