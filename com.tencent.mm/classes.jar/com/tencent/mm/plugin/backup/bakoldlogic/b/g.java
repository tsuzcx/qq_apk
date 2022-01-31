package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g
  implements j
{
  private static String a(gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17795);
    s locals = d.Gt(parambi.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(17795);
      return null;
    }
    if (parambi.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramgx.jKs = i;
      if (!bo.isNullOrNil(parambi.field_content)) {
        break;
      }
      AppMethodBeat.o(17795);
      return null;
    }
    if (d.lA(parambi.field_talker)) {}
    for (paramgx = locals.alM();; paramgx = paramgx.woP.xJE)
    {
      parambi = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput(parambi);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "videomsg");
        Map localMap = br.F(locals.alP(), "msg");
        if (localMap != null)
        {
          localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.videomsg.$aeskey"));
          localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.videomsg.$cdnthumbaeskey"));
          localXmlSerializer.attribute(null, "cdnvideourl", (String)localMap.get(".msg.videomsg.$cdnvideourl"));
          localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.videomsg.$cdnthumburl"));
          localXmlSerializer.attribute(null, "cdnthumblength", (String)localMap.get(".msg.videomsg.$cdnthumblength"));
        }
        localXmlSerializer.attribute(null, "playlength", locals.fXx);
        localXmlSerializer.attribute(null, "length", locals.fsd);
        localXmlSerializer.attribute(null, "type", String.valueOf(i));
        if (!bo.isNullOrNil(paramgx)) {
          localXmlSerializer.attribute(null, "fromusername", paramgx);
        }
        localXmlSerializer.attribute(null, "md5", locals.cHH);
        localXmlSerializer.endTag(null, "videomsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        parambi.flush();
        parambi.close();
        paramgx = parambi.getBuffer().toString();
        ab.d("MicroMsg.BakOldItemVideo", "parseContent xml:".concat(String.valueOf(paramgx)));
        AppMethodBeat.o(17795);
        return paramgx;
      }
      catch (Exception paramgx)
      {
        ab.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + paramgx.toString());
        AppMethodBeat.o(17795);
      }
    }
    return null;
  }
  
  public final int a(gx paramgx, bi parambi, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(17793);
    com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().alE();
    String str = t.vf(parambi.field_imgPath);
    Object localObject = d.Gt(parambi.field_imgPath);
    int j;
    if ((localObject == null) || (((s)localObject).status == 199))
    {
      j = 1;
      localObject = new com.tencent.mm.vfs.b(str);
      if ((j == 0) || (!((com.tencent.mm.vfs.b)localObject).exists())) {
        break label329;
      }
    }
    label174:
    label326:
    label329:
    for (int k = (int)((com.tencent.mm.vfs.b)localObject).length();; k = 0)
    {
      int m = 0;
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().alE();
      localObject = t.vg(parambi.field_imgPath);
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b((String)localObject);
      if (localb.exists()) {
        m = (int)localb.length();
      }
      int i = 0;
      if (m != 0)
      {
        if (parambi.getType() == 62) {
          i = i.a(new i.a((String)localObject, paramgx, paramLinkedList, 13, "_thumb")) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label326;
        }
        if (parambi.getType() != 62) {
          break label267;
        }
        i = i.a(new i.a(str, paramgx, paramLinkedList, 12, false, null)) + i;
      }
      for (;;)
      {
        parambi = a(paramgx, parambi);
        if (parambi == null)
        {
          AppMethodBeat.o(17793);
          return i;
          j = 0;
          break;
          i = i.a(new i.a((String)localObject, paramgx, paramLinkedList, 11, "_thumb")) + 0;
          break label174;
          i = i.a(new i.a(str, paramgx, paramLinkedList, 10, false, null)) + i;
          continue;
        }
        paramgx.woR = new bwc().aoF(parambi);
        j = parambi.length();
        AppMethodBeat.o(17793);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17794);
    paramString = new s();
    paramString.cDt = paramgx.woP.xJE;
    paramString.createTime = parambi.field_createTime;
    paramString.cFn = paramgx.pIG;
    Object localObject = paramgx.woR.xJE;
    ab.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = br.F((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.fsd = a.bE((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.fXx = a.bE((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.fXq = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = a.bE((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        ab.d("MicroMsg.BakOldItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label469;
        }
        i = 1;
        paramString.fXB = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          label190:
          label215:
          ab.e("MicroMsg.BakOldItemVideo", "parsing voice msg xml failed");
          ab.printErrStackTrace("MicroMsg.BakOldItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!a.d(paramgx, 10)) && (!a.d(paramgx, 12))) {
        break label538;
      }
      paramString.status = 199;
      localObject = t.ve(paramString.alM());
      parambi.kk((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambi.getType() != 62) {
        parambi.setType(43);
      }
      parambi.setContent(q.d(paramString.alM(), paramString.fXw, false));
      paramString.fXy = ((int)d.l(parambi));
      paramString.fXv = bo.aox();
      paramString.fXz = 0;
      ab.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.fsd + " svrid:" + paramString.cFn + " timelen:" + paramString.fXx + " user:" + paramString.getUser() + " human:" + paramString.alM());
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().alE().b(paramString);
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().alE();
      paramString = t.vg((String)localObject);
      if (parambi.getType() != 62) {
        break label547;
      }
      a.b(paramgx, 13, paramString);
    }
    for (paramString = a.a(paramgx, 12);; paramString = a.a(paramgx, 10))
    {
      if (paramString != null)
      {
        paramString = a.Gw(paramString);
        com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().alE();
        e.C(paramString, t.vf((String)localObject));
      }
      AppMethodBeat.o(17794);
      return 0;
      label469:
      i = 0;
      break;
      ab.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", new Object[] { paramgx.woR.xJE });
      parambi.setContent(paramgx.woR.xJE);
      break label190;
      label538:
      paramString.status = 111;
      break label215;
      label547:
      a.b(paramgx, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.g
 * JD-Core Version:    0.7.0.1
 */