package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.e;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g
  implements j
{
  private static String a(hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21852);
    s locals = d.SE(parambo.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(21852);
      return null;
    }
    if (parambo.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramhy.ndI = i;
      if (!bs.isNullOrNil(parambo.field_content)) {
        break;
      }
      AppMethodBeat.o(21852);
      return null;
    }
    if (d.sQ(parambo.field_talker)) {}
    for (paramhy = locals.aJH();; paramhy = paramhy.DPT.FEm)
    {
      parambo = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput(parambo);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "videomsg");
        Map localMap = bv.L(locals.aJK(), "msg");
        if (localMap != null)
        {
          localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.videomsg.$aeskey"));
          localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.videomsg.$cdnthumbaeskey"));
          localXmlSerializer.attribute(null, "cdnvideourl", (String)localMap.get(".msg.videomsg.$cdnvideourl"));
          localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.videomsg.$cdnthumburl"));
          localXmlSerializer.attribute(null, "cdnthumblength", (String)localMap.get(".msg.videomsg.$cdnthumblength"));
        }
        localXmlSerializer.attribute(null, "playlength", locals.hpy);
        localXmlSerializer.attribute(null, "length", locals.hux);
        localXmlSerializer.attribute(null, "type", String.valueOf(i));
        if (!bs.isNullOrNil(paramhy)) {
          localXmlSerializer.attribute(null, "fromusername", paramhy);
        }
        localXmlSerializer.attribute(null, "md5", locals.dwi);
        localXmlSerializer.endTag(null, "videomsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        parambo.flush();
        parambo.close();
        paramhy = parambo.getBuffer().toString();
        ac.d("MicroMsg.BakOldItemVideo", "parseContent xml:".concat(String.valueOf(paramhy)));
        AppMethodBeat.o(21852);
        return paramhy;
      }
      catch (Exception paramhy)
      {
        ac.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + paramhy.toString());
        AppMethodBeat.o(21852);
      }
    }
    return null;
  }
  
  public final int a(hy paramhy, bo parambo, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21850);
    b.bFw().bFx().aJy();
    String str = t.DV(parambo.field_imgPath);
    Object localObject = d.SE(parambo.field_imgPath);
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
      b.bFw().bFx().aJy();
      localObject = t.DW(parambo.field_imgPath);
      e locale = new e((String)localObject);
      if (locale.exists()) {
        m = (int)locale.length();
      }
      int i = 0;
      if (m != 0)
      {
        if (parambo.getType() == 62) {
          i = i.a(new i.a((String)localObject, paramhy, paramLinkedList, 13, "_thumb")) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label326;
        }
        if (parambo.getType() != 62) {
          break label267;
        }
        i = i.a(new i.a(str, paramhy, paramLinkedList, 12, false, null)) + i;
      }
      for (;;)
      {
        parambo = a(paramhy, parambo);
        if (parambo == null)
        {
          AppMethodBeat.o(21850);
          return i;
          j = 0;
          break;
          i = i.a(new i.a((String)localObject, paramhy, paramLinkedList, 11, "_thumb")) + 0;
          break label174;
          i = i.a(new i.a(str, paramhy, paramLinkedList, 10, false, null)) + i;
          continue;
        }
        paramhy.DPV = new crm().aJV(parambo);
        j = parambo.length();
        AppMethodBeat.o(21850);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21851);
    paramString = new s();
    paramString.drG = paramhy.DPT.FEm;
    paramString.createTime = parambo.field_createTime;
    paramString.dpl = paramhy.vTQ;
    Object localObject = paramhy.DPV.FEm;
    ac.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = bv.L((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.hux = a.cg((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.hpy = a.cg((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.iaC = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = a.cg((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        ac.d("MicroMsg.BakOldItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label469;
        }
        i = 1;
        paramString.iaM = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          label190:
          label215:
          ac.e("MicroMsg.BakOldItemVideo", "parsing voice msg xml failed");
          ac.printErrStackTrace("MicroMsg.BakOldItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!a.d(paramhy, 10)) && (!a.d(paramhy, 12))) {
        break label538;
      }
      paramString.status = 199;
      localObject = t.DU(paramString.aJH());
      parambo.rf((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambo.getType() != 62) {
        parambo.setType(43);
      }
      parambo.setContent(q.b(paramString.aJH(), paramString.iaI, false));
      paramString.iaJ = ((int)d.u(parambo));
      paramString.iaH = bs.aNx();
      paramString.iaK = 0;
      ac.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.hux + " svrid:" + paramString.dpl + " timelen:" + paramString.hpy + " user:" + paramString.getUser() + " human:" + paramString.aJH());
      b.bFw().bFx().aJy().b(paramString);
      b.bFw().bFx().aJy();
      paramString = t.DW((String)localObject);
      if (parambo.getType() != 62) {
        break label547;
      }
      a.b(paramhy, 13, paramString);
    }
    for (paramString = a.a(paramhy, 12);; paramString = a.a(paramhy, 10))
    {
      if (paramString != null)
      {
        paramString = a.SI(paramString);
        b.bFw().bFx().aJy();
        com.tencent.mm.vfs.i.lZ(paramString, t.DV((String)localObject));
      }
      AppMethodBeat.o(21851);
      return 0;
      label469:
      i = 0;
      break;
      ac.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", new Object[] { paramhy.DPV.FEm });
      parambo.setContent(paramhy.DPV.FEm);
      break label190;
      label538:
      paramString.status = 111;
      break label215;
      label547:
      a.b(paramhy, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.g
 * JD-Core Version:    0.7.0.1
 */