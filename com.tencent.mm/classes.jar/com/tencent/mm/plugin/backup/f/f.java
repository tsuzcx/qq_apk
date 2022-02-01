package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
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
  private static String a(hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21520);
    s locals = c.SE(parambo.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(21520);
      return null;
    }
    if (parambo.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramhy.ndI = i;
      if (!bs.isNullOrNil(parambo.field_content)) {
        break;
      }
      AppMethodBeat.o(21520);
      return null;
    }
    if (c.sQ(parambo.field_talker)) {}
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
        ac.d("MicroMsg.BackupItemVideo", "parseContent xml:".concat(String.valueOf(paramhy)));
        AppMethodBeat.o(21520);
        return paramhy;
      }
      catch (Exception paramhy)
      {
        ac.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + paramhy.toString());
        AppMethodBeat.o(21520);
      }
    }
    return null;
  }
  
  public final int a(hy paramhy, boolean paramBoolean1, bo parambo, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21518);
    d.bEP().bEQ().aJy();
    paramString = t.DV(parambo.field_imgPath);
    paramHashMap = c.SE(parambo.field_imgPath);
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
      d.bEP().bEQ().aJy();
      paramHashMap = t.DW(parambo.field_imgPath);
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
        if (parambo.getType() == 62) {
          i = i.a(new i.a(paramHashMap, paramhy, paramLinkedList, 13, paramBoolean1, "_thumb", paramBoolean2)) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label356;
        }
        if (parambo.getType() != 62) {
          break label294;
        }
        i = i.a(new i.a(paramString, paramhy, paramLinkedList, 12, paramBoolean1, paramBoolean2, null)) + i;
      }
      for (;;)
      {
        parambo = a(paramhy, parambo);
        if (parambo == null)
        {
          AppMethodBeat.o(21518);
          return i;
          i = i.a(new i.a(paramHashMap, paramhy, paramLinkedList, 11, paramBoolean1, "_thumb", paramBoolean2)) + 0;
          break;
          i = i.a(new i.a(paramString, paramhy, paramLinkedList, 10, paramBoolean1, paramBoolean2, null)) + i;
          continue;
        }
        paramhy.DPV = new crm().aJV(parambo);
        j = parambo.length();
        AppMethodBeat.o(21518);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21519);
    paramString = new s();
    paramString.drG = paramhy.DPT.FEm;
    paramString.createTime = parambo.field_createTime;
    paramString.dpl = paramhy.vTQ;
    Object localObject = paramhy.DPV.FEm;
    ac.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = bv.L((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.hux = g.cg((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.hpy = g.cg((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.iaC = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = g.cg((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        ac.d("MicroMsg.BackupItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label486;
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
          ac.e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
          ac.printErrStackTrace("MicroMsg.BackupItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!g.d(paramhy, 10)) && (!g.d(paramhy, 12))) {
        break label555;
      }
      paramString.status = 199;
      localObject = t.DU(paramString.aJH());
      parambo.rf((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambo.getType() != 62) {
        parambo.setType(43);
      }
      parambo.setContent(q.b(paramString.aJH(), paramString.iaI, false));
      paramString.iaJ = ((int)c.u(parambo));
      paramString.iaH = bs.aNx();
      paramString.iaK = 0;
      ac.d("MicroMsg.BackupItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.hux + " svrid:" + paramString.dpl + " timelen:" + paramString.hpy + " user:" + paramString.getUser() + " human:" + paramString.aJH());
      d.bEP().bEQ().aJy().b(paramString);
      d.bEP().bEQ().aJy();
      paramString = t.DW((String)localObject);
      if (parambo.getType() != 62) {
        break label564;
      }
      g.b(paramhy, 13, paramString);
    }
    for (paramString = g.a(paramhy, 12);; paramString = g.a(paramhy, 10))
    {
      if (paramString != null)
      {
        paramString = g.Ss(paramString) + paramString;
        d.bEP().bEQ().aJy();
        com.tencent.mm.vfs.i.ma(paramString, t.DV((String)localObject));
      }
      AppMethodBeat.o(21519);
      return 0;
      label486:
      i = 0;
      break;
      ac.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", new Object[] { paramhy.DPV.FEm });
      parambo.setContent(paramhy.DPV.FEm);
      break label190;
      label555:
      paramString.status = 111;
      break label215;
      label564:
      g.b(paramhy, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.f
 * JD-Core Version:    0.7.0.1
 */