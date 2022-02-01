package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.e;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g
  implements j
{
  private static String a(hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21852);
    s locals = d.Ou(parambl.field_imgPath);
    if (locals == null)
    {
      AppMethodBeat.o(21852);
      return null;
    }
    if (parambl.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramhu.mBH = i;
      if (!bt.isNullOrNil(parambl.field_content)) {
        break;
      }
      AppMethodBeat.o(21852);
      return null;
    }
    if (d.pF(parambl.field_talker)) {}
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
        ad.d("MicroMsg.BakOldItemVideo", "parseContent xml:".concat(String.valueOf(paramhu)));
        AppMethodBeat.o(21852);
        return paramhu;
      }
      catch (Exception paramhu)
      {
        ad.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + paramhu.toString());
        AppMethodBeat.o(21852);
      }
    }
    return null;
  }
  
  public final int a(hu paramhu, bl parambl, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21850);
    b.byA().byB().aCI();
    String str = t.zQ(parambl.field_imgPath);
    Object localObject = d.Ou(parambl.field_imgPath);
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
      b.byA().byB().aCI();
      localObject = t.zR(parambl.field_imgPath);
      e locale = new e((String)localObject);
      if (locale.exists()) {
        m = (int)locale.length();
      }
      int i = 0;
      if (m != 0)
      {
        if (parambl.getType() == 62) {
          i = i.a(new i.a((String)localObject, paramhu, paramLinkedList, 13, "_thumb")) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label326;
        }
        if (parambl.getType() != 62) {
          break label267;
        }
        i = i.a(new i.a(str, paramhu, paramLinkedList, 12, false, null)) + i;
      }
      for (;;)
      {
        parambl = a(paramhu, parambl);
        if (parambl == null)
        {
          AppMethodBeat.o(21850);
          return i;
          j = 0;
          break;
          i = i.a(new i.a((String)localObject, paramhu, paramLinkedList, 11, "_thumb")) + 0;
          break label174;
          i = i.a(new i.a(str, paramhu, paramLinkedList, 10, false, null)) + i;
          continue;
        }
        paramhu.Cxz = new cmf().aEE(parambl);
        j = parambl.length();
        AppMethodBeat.o(21850);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21851);
    paramString = new s();
    paramString.dtV = paramhu.Cxx.Ehn;
    paramString.createTime = parambl.field_createTime;
    paramString.drA = paramhu.uKZ;
    Object localObject = paramhu.Cxz.Ehn;
    ad.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = bw.K((String)localObject, "msg");
    if (localObject != null)
    {
      try
      {
        paramString.gTY = a.cb((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.gOY = a.cb((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.hAb = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = a.cb((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        ad.d("MicroMsg.BakOldItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label469;
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
          ad.e("MicroMsg.BakOldItemVideo", "parsing voice msg xml failed");
          ad.printErrStackTrace("MicroMsg.BakOldItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!a.d(paramhu, 10)) && (!a.d(paramhu, 12))) {
        break label538;
      }
      paramString.status = 199;
      localObject = t.zP(paramString.aCQ());
      parambl.nZ((String)localObject);
      paramString.fileName = ((String)localObject);
      if (parambl.getType() != 62) {
        parambl.setType(43);
      }
      parambl.setContent(q.b(paramString.aCQ(), paramString.hAh, false));
      paramString.hAi = ((int)d.u(parambl));
      paramString.hAg = bt.aGK();
      paramString.hAj = 0;
      ad.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.gTY + " svrid:" + paramString.drA + " timelen:" + paramString.gOY + " user:" + paramString.getUser() + " human:" + paramString.aCQ());
      b.byA().byB().aCI().b(paramString);
      b.byA().byB().aCI();
      paramString = t.zR((String)localObject);
      if (parambl.getType() != 62) {
        break label547;
      }
      a.b(paramhu, 13, paramString);
    }
    for (paramString = a.a(paramhu, 12);; paramString = a.a(paramhu, 10))
    {
      if (paramString != null)
      {
        paramString = a.Oy(paramString);
        b.byA().byB().aCI();
        com.tencent.mm.vfs.i.lC(paramString, t.zQ((String)localObject));
      }
      AppMethodBeat.o(21851);
      return 0;
      label469:
      i = 0;
      break;
      ad.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", new Object[] { paramhu.Cxz.Ehn });
      parambl.setContent(paramhu.Cxz.Ehn);
      break label190;
      label538:
      paramString.status = 111;
      break label215;
      label547:
      a.b(paramhu, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.g
 * JD-Core Version:    0.7.0.1
 */