package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
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
  private static String a(hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21520);
    s locals = c.Ou(parambl.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(21520);
      return null;
    }
    if (parambl.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramhu.mBH = i;
      if (!bt.isNullOrNil(parambl.field_content)) {
        break;
      }
      AppMethodBeat.o(21520);
      return null;
    }
    if (c.pF(parambl.field_talker)) {}
    for (paramhu = locals.aCQ();; paramhu = paramhu.Cxx.Ehn)
    {
      parambl = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput(parambl);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "videomsg");
        Map localMap = bw.K(locals.aCT(), "msg");
        if (localMap != null)
        {
          localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.videomsg.$aeskey"));
          localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.videomsg.$cdnthumbaeskey"));
          localXmlSerializer.attribute(null, "cdnvideourl", (String)localMap.get(".msg.videomsg.$cdnvideourl"));
          localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.videomsg.$cdnthumburl"));
          localXmlSerializer.attribute(null, "cdnthumblength", (String)localMap.get(".msg.videomsg.$cdnthumblength"));
        }
        localXmlSerializer.attribute(null, "playlength", locals.gOY);
        localXmlSerializer.attribute(null, "length", locals.gTY);
        localXmlSerializer.attribute(null, "type", String.valueOf(i));
        if (!bt.isNullOrNil(paramhu)) {
          localXmlSerializer.attribute(null, "fromusername", paramhu);
        }
        localXmlSerializer.attribute(null, "md5", locals.dyw);
        localXmlSerializer.endTag(null, "videomsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        parambl.flush();
        parambl.close();
        paramhu = parambl.getBuffer().toString();
        ad.d("MicroMsg.BackupItemVideo", "parseContent xml:".concat(String.valueOf(paramhu)));
        AppMethodBeat.o(21520);
        return paramhu;
      }
      catch (Exception paramhu)
      {
        ad.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + paramhu.toString());
        AppMethodBeat.o(21520);
      }
    }
    return null;
  }
  
  public final int a(hu paramhu, boolean paramBoolean1, bl parambl, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21518);
    d.bxT().bxU().aCI();
    paramString = t.zQ(parambl.field_imgPath);
    paramHashMap = c.Ou(parambl.field_imgPath);
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
      d.bxT().bxU().aCI();
      paramHashMap = t.zR(parambl.field_imgPath);
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
        if (parambl.getType() == 62) {
          i = i.a(new i.a(paramHashMap, paramhu, paramLinkedList, 13, paramBoolean1, "_thumb", paramBoolean2)) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label356;
        }
        if (parambl.getType() != 62) {
          break label294;
        }
        i = i.a(new i.a(paramString, paramhu, paramLinkedList, 12, paramBoolean1, paramBoolean2, null)) + i;
      }
      for (;;)
      {
        parambl = a(paramhu, parambl);
        if (parambl == null)
        {
          AppMethodBeat.o(21518);
          return i;
          i = i.a(new i.a(paramHashMap, paramhu, paramLinkedList, 11, paramBoolean1, "_thumb", paramBoolean2)) + 0;
          break;
          i = i.a(new i.a(paramString, paramhu, paramLinkedList, 10, paramBoolean1, paramBoolean2, null)) + i;
          continue;
        }
        paramhu.Cxz = new cmf().aEE(parambl);
        j = parambl.length();
        AppMethodBeat.o(21518);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21519);
    paramString = new s();
    paramString.dtV = paramhu.Cxx.Ehn;
    paramString.createTime = parambl.field_createTime;
    paramString.drA = paramhu.uKZ;
    Object localObject = paramhu.Cxz.Ehn;
    ad.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = bw.K((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.gTY = g.cb((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.gOY = g.cb((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.hAb = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = g.cb((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        ad.d("MicroMsg.BackupItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label486;
        }
        i = 1;
        paramString.hAl = i;
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
      if ((!g.d(paramhu, 10)) && (!g.d(paramhu, 12))) {
        break label555;
      }
      paramString.status = 199;
      localObject = t.zP(paramString.aCQ());
      parambl.nZ((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambl.getType() != 62) {
        parambl.setType(43);
      }
      parambl.setContent(q.b(paramString.aCQ(), paramString.hAh, false));
      paramString.hAi = ((int)c.u(parambl));
      paramString.hAg = bt.aGK();
      paramString.hAj = 0;
      ad.d("MicroMsg.BackupItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.gTY + " svrid:" + paramString.drA + " timelen:" + paramString.gOY + " user:" + paramString.getUser() + " human:" + paramString.aCQ());
      d.bxT().bxU().aCI().b(paramString);
      d.bxT().bxU().aCI();
      paramString = t.zR((String)localObject);
      if (parambl.getType() != 62) {
        break label564;
      }
      g.b(paramhu, 13, paramString);
    }
    for (paramString = g.a(paramhu, 12);; paramString = g.a(paramhu, 10))
    {
      if (paramString != null)
      {
        paramString = g.Oi(paramString) + paramString;
        d.bxT().bxU().aCI();
        com.tencent.mm.vfs.i.lD(paramString, t.zQ((String)localObject));
      }
      AppMethodBeat.o(21519);
      return 0;
      label486:
      i = 0;
      break;
      ad.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", new Object[] { paramhu.Cxz.Ehn });
      parambl.setContent(paramhu.Cxz.Ehn);
      break label190;
      label555:
      paramString.status = 111;
      break label215;
      label564:
      g.b(paramhu, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.f
 * JD-Core Version:    0.7.0.1
 */