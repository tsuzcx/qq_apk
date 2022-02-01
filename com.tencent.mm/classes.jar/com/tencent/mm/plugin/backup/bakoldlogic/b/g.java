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
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g
  implements j
{
  private static String a(if paramif, bv parambv)
  {
    AppMethodBeat.i(21852);
    s locals = d.WO(parambv.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(21852);
      return null;
    }
    if (parambv.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramif.nJA = i;
      if (!bu.isNullOrNil(parambv.field_content)) {
        break;
      }
      AppMethodBeat.o(21852);
      return null;
    }
    if (d.wb(parambv.field_talker)) {}
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
        ae.d("MicroMsg.BakOldItemVideo", "parseContent xml:".concat(String.valueOf(paramif)));
        AppMethodBeat.o(21852);
        return paramif;
      }
      catch (Exception paramif)
      {
        ae.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + paramif.toString());
        AppMethodBeat.o(21852);
      }
    }
    return null;
  }
  
  public final int a(if paramif, bv parambv, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21850);
    b.bKD().bKE().aNh();
    String str = t.HJ(parambv.field_imgPath);
    Object localObject = d.WO(parambv.field_imgPath);
    int j;
    if ((localObject == null) || (((s)localObject).status == 199))
    {
      j = 1;
      localObject = new k(str);
      if ((j == 0) || (!((k)localObject).exists())) {
        break label329;
      }
    }
    label174:
    label326:
    label329:
    for (int k = (int)((k)localObject).length();; k = 0)
    {
      int m = 0;
      b.bKD().bKE().aNh();
      localObject = t.HK(parambv.field_imgPath);
      k localk = new k((String)localObject);
      if (localk.exists()) {
        m = (int)localk.length();
      }
      int i = 0;
      if (m != 0)
      {
        if (parambv.getType() == 62) {
          i = i.a(new i.a((String)localObject, paramif, paramLinkedList, 13, "_thumb")) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label326;
        }
        if (parambv.getType() != 62) {
          break label267;
        }
        i = i.a(new i.a(str, paramif, paramLinkedList, 12, false, null)) + i;
      }
      for (;;)
      {
        parambv = a(paramif, parambv);
        if (parambv == null)
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
        paramif.FNI = new cxn().aQV(parambv);
        j = parambv.length();
        AppMethodBeat.o(21850);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    AppMethodBeat.i(21851);
    paramString = new s();
    paramString.dED = paramif.FNG.HId;
    paramString.createTime = parambv.field_createTime;
    paramString.dCd = paramif.xrk;
    Object localObject = paramif.FNI.HId;
    ae.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = bx.M((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.hPI = a.cn((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.hKI = a.cn((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.iwS = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = a.cn((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        ae.d("MicroMsg.BakOldItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label469;
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
          ae.e("MicroMsg.BakOldItemVideo", "parsing voice msg xml failed");
          ae.printErrStackTrace("MicroMsg.BakOldItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!a.d(paramif, 10)) && (!a.d(paramif, 12))) {
        break label538;
      }
      paramString.status = 199;
      localObject = t.HI(paramString.getUser());
      parambv.uj((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambv.getType() != 62) {
        parambv.setType(43);
      }
      parambv.setContent(q.b(paramString.aNq(), paramString.iwY, false));
      paramString.iwZ = ((int)d.v(parambv));
      paramString.iwX = bu.aRi();
      paramString.ixa = 0;
      ae.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.hPI + " svrid:" + paramString.dCd + " timelen:" + paramString.hKI + " user:" + paramString.getUser() + " human:" + paramString.aNq());
      b.bKD().bKE().aNh().b(paramString);
      b.bKD().bKE().aNh();
      paramString = t.HK((String)localObject);
      if (parambv.getType() != 62) {
        break label547;
      }
      a.b(paramif, 13, paramString);
    }
    for (paramString = a.a(paramif, 12);; paramString = a.a(paramif, 10))
    {
      if (paramString != null)
      {
        paramString = a.WS(paramString);
        b.bKD().bKE().aNh();
        o.mF(paramString, t.HJ((String)localObject));
      }
      AppMethodBeat.o(21851);
      return 0;
      label469:
      i = 0;
      break;
      ae.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", new Object[] { paramif.FNI.HId });
      parambv.setContent(paramif.FNI.HId);
      break label190;
      label538:
      paramString.status = 111;
      break label215;
      label547:
      a.b(paramif, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.g
 * JD-Core Version:    0.7.0.1
 */