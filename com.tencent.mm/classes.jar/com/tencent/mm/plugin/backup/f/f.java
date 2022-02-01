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
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.k;
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
  private static String a(if paramif, bv parambv)
  {
    AppMethodBeat.i(21520);
    s locals = c.WO(parambv.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(21520);
      return null;
    }
    if (parambv.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramif.nJA = i;
      if (!bu.isNullOrNil(parambv.field_content)) {
        break;
      }
      AppMethodBeat.o(21520);
      return null;
    }
    if (c.wb(parambv.field_talker)) {}
    for (paramif = locals.aNq();; paramif = paramif.FNG.HId)
    {
      parambv = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput(parambv);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "videomsg");
        Map localMap = bx.M(locals.aNt(), "msg");
        if (localMap != null)
        {
          localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.videomsg.$aeskey"));
          localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.videomsg.$cdnthumbaeskey"));
          localXmlSerializer.attribute(null, "cdnvideourl", (String)localMap.get(".msg.videomsg.$cdnvideourl"));
          localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.videomsg.$cdnthumburl"));
          localXmlSerializer.attribute(null, "cdnthumblength", (String)localMap.get(".msg.videomsg.$cdnthumblength"));
        }
        localXmlSerializer.attribute(null, "playlength", locals.hKI);
        localXmlSerializer.attribute(null, "length", locals.hPI);
        localXmlSerializer.attribute(null, "type", String.valueOf(i));
        if (!bu.isNullOrNil(paramif)) {
          localXmlSerializer.attribute(null, "fromusername", paramif);
        }
        localXmlSerializer.attribute(null, "md5", locals.dJw);
        localXmlSerializer.endTag(null, "videomsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        parambv.flush();
        parambv.close();
        paramif = parambv.getBuffer().toString();
        ae.d("MicroMsg.BackupItemVideo", "parseContent xml:".concat(String.valueOf(paramif)));
        AppMethodBeat.o(21520);
        return paramif;
      }
      catch (Exception paramif)
      {
        ae.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + paramif.toString());
        AppMethodBeat.o(21520);
      }
    }
    return null;
  }
  
  public final int a(if paramif, boolean paramBoolean1, bv parambv, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21518);
    d.bJW().bJX().aNh();
    paramString = t.HJ(parambv.field_imgPath);
    paramHashMap = c.WO(parambv.field_imgPath);
    int j;
    if ((paramHashMap == null) || (paramHashMap.status == 199))
    {
      j = 1;
      paramHashMap = new k(paramString);
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
      d.bJW().bJX().aNh();
      paramHashMap = t.HK(parambv.field_imgPath);
      k localk = new k(paramHashMap);
      if (localk.exists()) {
        m = (int)localk.length();
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
        if (parambv.getType() == 62) {
          i = i.a(new i.a(paramHashMap, paramif, paramLinkedList, 13, paramBoolean1, "_thumb", paramBoolean2)) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label356;
        }
        if (parambv.getType() != 62) {
          break label294;
        }
        i = i.a(new i.a(paramString, paramif, paramLinkedList, 12, paramBoolean1, paramBoolean2, null)) + i;
      }
      for (;;)
      {
        parambv = a(paramif, parambv);
        if (parambv == null)
        {
          AppMethodBeat.o(21518);
          return i;
          i = i.a(new i.a(paramHashMap, paramif, paramLinkedList, 11, paramBoolean1, "_thumb", paramBoolean2)) + 0;
          break;
          i = i.a(new i.a(paramString, paramif, paramLinkedList, 10, paramBoolean1, paramBoolean2, null)) + i;
          continue;
        }
        paramif.FNI = new cxn().aQV(parambv);
        j = parambv.length();
        AppMethodBeat.o(21518);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    AppMethodBeat.i(21519);
    paramString = new s();
    paramString.dED = paramif.FNG.HId;
    paramString.createTime = parambv.field_createTime;
    paramString.dCd = paramif.xrk;
    Object localObject = paramif.FNI.HId;
    ae.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = bx.M((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.hPI = g.cn((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.hKI = g.cn((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.iwS = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = g.cn((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        ae.d("MicroMsg.BackupItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label486;
        }
        i = 1;
        paramString.ixc = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          label190:
          label215:
          ae.e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
          ae.printErrStackTrace("MicroMsg.BackupItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!g.d(paramif, 10)) && (!g.d(paramif, 12))) {
        break label555;
      }
      paramString.status = 199;
      localObject = t.HI(paramString.getUser());
      parambv.uj((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambv.getType() != 62) {
        parambv.setType(43);
      }
      parambv.setContent(q.b(paramString.aNq(), paramString.iwY, false));
      paramString.iwZ = ((int)c.v(parambv));
      paramString.iwX = bu.aRi();
      paramString.ixa = 0;
      ae.d("MicroMsg.BackupItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.hPI + " svrid:" + paramString.dCd + " timelen:" + paramString.hKI + " user:" + paramString.getUser() + " human:" + paramString.aNq());
      d.bJW().bJX().aNh().b(paramString);
      d.bJW().bJX().aNh();
      paramString = t.HK((String)localObject);
      if (parambv.getType() != 62) {
        break label564;
      }
      g.b(paramif, 13, paramString);
    }
    for (paramString = g.a(paramif, 12);; paramString = g.a(paramif, 10))
    {
      if (paramString != null)
      {
        paramString = g.WC(paramString) + paramString;
        d.bJW().bJX().aNh();
        o.mG(paramString, t.HJ((String)localObject));
      }
      AppMethodBeat.o(21519);
      return 0;
      label486:
      i = 0;
      break;
      ae.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", new Object[] { paramif.FNI.HId });
      parambv.setContent(paramif.FNI.HId);
      break label190;
      label555:
      paramString.status = 111;
      break label215;
      label564:
      g.b(paramif, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.f
 * JD-Core Version:    0.7.0.1
 */