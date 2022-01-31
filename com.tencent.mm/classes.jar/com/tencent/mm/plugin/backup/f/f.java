package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
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
  private static String a(gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17461);
    s locals = c.Gt(parambi.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(17461);
      return null;
    }
    if (parambi.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramgx.jKs = i;
      if (!bo.isNullOrNil(parambi.field_content)) {
        break;
      }
      AppMethodBeat.o(17461);
      return null;
    }
    if (c.lA(parambi.field_talker)) {}
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
        ab.d("MicroMsg.BackupItemVideo", "parseContent xml:".concat(String.valueOf(paramgx)));
        AppMethodBeat.o(17461);
        return paramgx;
      }
      catch (Exception paramgx)
      {
        ab.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + paramgx.toString());
        AppMethodBeat.o(17461);
      }
    }
    return null;
  }
  
  public final int a(gx paramgx, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(17459);
    d.aUK().aUL().alE();
    paramString = t.vf(parambi.field_imgPath);
    paramHashMap = c.Gt(parambi.field_imgPath);
    int j;
    if ((paramHashMap == null) || (paramHashMap.status == 199))
    {
      j = 1;
      paramHashMap = new com.tencent.mm.vfs.b(paramString);
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
      d.aUK().aUL().alE();
      paramHashMap = t.vg(parambi.field_imgPath);
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(paramHashMap);
      if (localb.exists()) {
        m = (int)localb.length();
      }
      if (paramBoolean1)
      {
        AppMethodBeat.o(17459);
        return m + k;
        j = 0;
        break;
      }
      int i = 0;
      if (m != 0)
      {
        if (parambi.getType() == 62) {
          i = i.a(new i.a(paramHashMap, paramgx, paramLinkedList, 13, paramBoolean1, "_thumb", paramBoolean2)) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label356;
        }
        if (parambi.getType() != 62) {
          break label294;
        }
        i = i.a(new i.a(paramString, paramgx, paramLinkedList, 12, paramBoolean1, paramBoolean2, null)) + i;
      }
      for (;;)
      {
        parambi = a(paramgx, parambi);
        if (parambi == null)
        {
          AppMethodBeat.o(17459);
          return i;
          i = i.a(new i.a(paramHashMap, paramgx, paramLinkedList, 11, paramBoolean1, "_thumb", paramBoolean2)) + 0;
          break;
          i = i.a(new i.a(paramString, paramgx, paramLinkedList, 10, paramBoolean1, paramBoolean2, null)) + i;
          continue;
        }
        paramgx.woR = new bwc().aoF(parambi);
        j = parambi.length();
        AppMethodBeat.o(17459);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17460);
    paramString = new s();
    paramString.cDt = paramgx.woP.xJE;
    paramString.createTime = parambi.field_createTime;
    paramString.cFn = paramgx.pIG;
    Object localObject = paramgx.woR.xJE;
    ab.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = br.F((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.fsd = g.bE((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.fXx = g.bE((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.fXq = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = g.bE((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        ab.d("MicroMsg.BackupItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label486;
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
          ab.e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
          ab.printErrStackTrace("MicroMsg.BackupItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!g.d(paramgx, 10)) && (!g.d(paramgx, 12))) {
        break label555;
      }
      paramString.status = 199;
      localObject = t.ve(paramString.alM());
      parambi.kk((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambi.getType() != 62) {
        parambi.setType(43);
      }
      parambi.setContent(q.d(paramString.alM(), paramString.fXw, false));
      paramString.fXy = ((int)c.l(parambi));
      paramString.fXv = bo.aox();
      paramString.fXz = 0;
      ab.d("MicroMsg.BackupItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.fsd + " svrid:" + paramString.cFn + " timelen:" + paramString.fXx + " user:" + paramString.getUser() + " human:" + paramString.alM());
      d.aUK().aUL().alE().b(paramString);
      d.aUK().aUL().alE();
      paramString = t.vg((String)localObject);
      if (parambi.getType() != 62) {
        break label564;
      }
      g.b(paramgx, 13, paramString);
    }
    for (paramString = g.a(paramgx, 12);; paramString = g.a(paramgx, 10))
    {
      if (paramString != null)
      {
        paramString = g.Gh(paramString) + paramString;
        d.aUK().aUL().alE();
        e.C(paramString, t.vf((String)localObject));
      }
      AppMethodBeat.o(17460);
      return 0;
      label486:
      i = 0;
      break;
      ab.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", new Object[] { paramgx.woR.xJE });
      parambi.setContent(paramgx.woR.xJE);
      break label190;
      label555:
      paramString.status = 111;
      break label215;
      label564:
      g.b(paramgx, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.f
 * JD-Core Version:    0.7.0.1
 */