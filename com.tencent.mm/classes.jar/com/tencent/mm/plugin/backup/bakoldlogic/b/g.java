package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
  private static String a(fo paramfo, bi parambi)
  {
    s locals = d.xA(parambi.field_imgPath);
    if (locals == null) {
      return null;
    }
    if (parambi.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramfo.hQR = i;
      if (!bk.bl(parambi.field_content)) {
        break;
      }
      return null;
    }
    if (d.fn(parambi.field_talker)) {}
    for (paramfo = locals.SB();; paramfo = paramfo.svF.tFO)
    {
      parambi = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput(parambi);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "videomsg");
        Map localMap = bn.s(locals.SD(), "msg");
        if (localMap != null)
        {
          localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.videomsg.$aeskey"));
          localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.videomsg.$cdnthumbaeskey"));
          localXmlSerializer.attribute(null, "cdnvideourl", (String)localMap.get(".msg.videomsg.$cdnvideourl"));
          localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.videomsg.$cdnthumburl"));
          localXmlSerializer.attribute(null, "cdnthumblength", (String)localMap.get(".msg.videomsg.$cdnthumblength"));
        }
        localXmlSerializer.attribute(null, "playlength", locals.eHH);
        localXmlSerializer.attribute(null, "length", locals.ebK);
        localXmlSerializer.attribute(null, "type", String.valueOf(i));
        if (!bk.bl(paramfo)) {
          localXmlSerializer.attribute(null, "fromusername", paramfo);
        }
        localXmlSerializer.attribute(null, "md5", locals.bZs);
        localXmlSerializer.endTag(null, "videomsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        parambi.flush();
        parambi.close();
        paramfo = parambi.getBuffer().toString();
        y.d("MicroMsg.BakOldItemVideo", "parseContent xml:" + paramfo);
        return paramfo;
      }
      catch (Exception paramfo)
      {
        y.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + paramfo.toString());
      }
    }
    return null;
  }
  
  public final int a(fo paramfo, bi parambi, LinkedList<u> paramLinkedList)
  {
    com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().Sr();
    String str = t.nS(parambi.field_imgPath);
    Object localObject = d.xA(parambi.field_imgPath);
    int j;
    if ((localObject == null) || (((s)localObject).status == 199))
    {
      j = 1;
      localObject = new com.tencent.mm.vfs.b(str);
      if ((j == 0) || (!((com.tencent.mm.vfs.b)localObject).exists())) {
        break label305;
      }
    }
    label167:
    label302:
    label305:
    for (int k = (int)((com.tencent.mm.vfs.b)localObject).length();; k = 0)
    {
      int m = 0;
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().Sr();
      localObject = t.nT(parambi.field_imgPath);
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b((String)localObject);
      if (localb.exists()) {
        m = (int)localb.length();
      }
      int i = 0;
      if (m != 0)
      {
        if (parambi.getType() == 62) {
          i = i.a(new i.a((String)localObject, paramfo, paramLinkedList, 13, "_thumb")) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label302;
        }
        if (parambi.getType() != 62) {
          break label253;
        }
        i = i.a(new i.a(str, paramfo, paramLinkedList, 12, false, null)) + i;
      }
      for (;;)
      {
        parambi = a(paramfo, parambi);
        if (parambi == null)
        {
          return i;
          j = 0;
          break;
          i = i.a(new i.a((String)localObject, paramfo, paramLinkedList, 11, "_thumb")) + 0;
          break label167;
          label253:
          i = i.a(new i.a(str, paramfo, paramLinkedList, 10, false, null)) + i;
          continue;
        }
        paramfo.svH = new bml().YI(parambi);
        return i + parambi.length();
      }
    }
  }
  
  public final int a(String paramString, fo paramfo, bi parambi)
  {
    paramString = new s();
    paramString.bVI = paramfo.svF.tFO;
    paramString.createTime = parambi.field_createTime;
    paramString.bXr = paramfo.ndp;
    Object localObject = paramfo.svH.tFO;
    y.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:" + (String)localObject);
    localObject = bn.s((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.ebK = a.be((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.eHH = a.be((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.eHA = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = a.be((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        y.d("MicroMsg.BakOldItemVideo", "video msg exportType :" + i);
        if (i != 44) {
          break label471;
        }
        i = 1;
        paramString.eHL = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          label198:
          label223:
          y.e("MicroMsg.BakOldItemVideo", "parsing voice msg xml failed");
          y.printErrStackTrace("MicroMsg.BakOldItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!a.d(paramfo, 10)) && (!a.d(paramfo, 12))) {
        break label540;
      }
      paramString.status = 199;
      localObject = t.nR(paramString.SB());
      parambi.ed((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambi.getType() != 62) {
        parambi.setType(43);
      }
      parambi.setContent(q.d(paramString.SB(), paramString.eHG, false));
      paramString.eHI = ((int)d.h(parambi));
      paramString.eHF = bk.UX();
      paramString.eHJ = 0;
      y.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.ebK + " svrid:" + paramString.bXr + " timelen:" + paramString.eHH + " user:" + paramString.SA() + " human:" + paramString.SB());
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().Sr().b(paramString);
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().Sr();
      paramString = t.nT((String)localObject);
      if (parambi.getType() != 62) {
        break label549;
      }
      a.b(paramfo, 13, paramString);
    }
    for (paramString = a.a(paramfo, 12);; paramString = a.a(paramfo, 10))
    {
      if (paramString != null)
      {
        paramString = a.xD(paramString);
        com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().Sr();
        e.r(paramString, t.nS((String)localObject));
      }
      return 0;
      label471:
      i = 0;
      break;
      y.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", new Object[] { paramfo.svH.tFO });
      parambi.setContent(paramfo.svH.tFO);
      break label198;
      label540:
      paramString.status = 111;
      break label223;
      label549:
      a.b(paramfo, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.g
 * JD-Core Version:    0.7.0.1
 */