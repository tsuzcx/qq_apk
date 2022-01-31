package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
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
  private static String a(fo paramfo, bi parambi)
  {
    s locals = c.xA(parambi.field_imgPath);
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
    if (c.fn(parambi.field_talker)) {}
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
        y.d("MicroMsg.BackupItemVideo", "parseContent xml:" + paramfo);
        return paramfo;
      }
      catch (Exception paramfo)
      {
        y.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + paramfo.toString());
      }
    }
    return null;
  }
  
  public final int a(fo paramfo, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    d.avi().avj().Sr();
    paramString = t.nS(parambi.field_imgPath);
    paramHashMap = c.xA(parambi.field_imgPath);
    int j;
    if ((paramHashMap == null) || (paramHashMap.status == 199))
    {
      j = 1;
      paramHashMap = new com.tencent.mm.vfs.b(paramString);
      if ((j == 0) || (!paramHashMap.exists())) {
        break label334;
      }
    }
    label191:
    label331:
    label334:
    for (int k = (int)paramHashMap.length();; k = 0)
    {
      int m = 0;
      d.avi().avj().Sr();
      paramHashMap = t.nT(parambi.field_imgPath);
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(paramHashMap);
      if (localb.exists()) {
        m = (int)localb.length();
      }
      if (paramBoolean1)
      {
        j = m + k;
        return j;
        j = 0;
        break;
      }
      int i = 0;
      if (m != 0)
      {
        if (parambi.getType() == 62) {
          i = i.a(new i.a(paramHashMap, paramfo, paramLinkedList, 13, paramBoolean1, "_thumb", paramBoolean2)) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label331;
        }
        if (parambi.getType() != 62) {
          break label302;
        }
        i = i.a(new i.a(paramString, paramfo, paramLinkedList, 12, paramBoolean1, paramBoolean2, null)) + i;
      }
      for (;;)
      {
        parambi = a(paramfo, parambi);
        j = i;
        if (parambi == null) {
          break;
        }
        paramfo.svH = new bml().YI(parambi);
        return i + parambi.length();
        i = i.a(new i.a(paramHashMap, paramfo, paramLinkedList, 11, paramBoolean1, "_thumb", paramBoolean2)) + 0;
        break label191;
        i = i.a(new i.a(paramString, paramfo, paramLinkedList, 10, paramBoolean1, paramBoolean2, null)) + i;
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
    y.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:" + (String)localObject);
    localObject = bn.s((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.ebK = g.be((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.eHH = g.be((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.eHA = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = g.be((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        y.d("MicroMsg.BackupItemVideo", "video msg exportType :" + i);
        if (i != 44) {
          break label488;
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
          y.e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
          y.printErrStackTrace("MicroMsg.BackupItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!g.d(paramfo, 10)) && (!g.d(paramfo, 12))) {
        break label557;
      }
      paramString.status = 199;
      localObject = t.nR(paramString.SB());
      parambi.ed((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambi.getType() != 62) {
        parambi.setType(43);
      }
      parambi.setContent(q.d(paramString.SB(), paramString.eHG, false));
      paramString.eHI = ((int)c.h(parambi));
      paramString.eHF = bk.UX();
      paramString.eHJ = 0;
      y.d("MicroMsg.BackupItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.ebK + " svrid:" + paramString.bXr + " timelen:" + paramString.eHH + " user:" + paramString.SA() + " human:" + paramString.SB());
      d.avi().avj().Sr().b(paramString);
      d.avi().avj().Sr();
      paramString = t.nT((String)localObject);
      if (parambi.getType() != 62) {
        break label566;
      }
      g.b(paramfo, 13, paramString);
    }
    for (paramString = g.a(paramfo, 12);; paramString = g.a(paramfo, 10))
    {
      if (paramString != null)
      {
        paramString = g.xp(paramString) + paramString;
        d.avi().avj().Sr();
        e.r(paramString, t.nS((String)localObject));
      }
      return 0;
      label488:
      i = 0;
      break;
      y.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", new Object[] { paramfo.svH.tFO });
      parambi.setContent(paramfo.svH.tFO);
      break label198;
      label557:
      paramString.status = 111;
      break label223;
      label566:
      g.b(paramfo, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.f
 * JD-Core Version:    0.7.0.1
 */