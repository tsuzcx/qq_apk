package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.q;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class f
  implements l
{
  private static String a(ih paramih, ca paramca)
  {
    AppMethodBeat.i(21520);
    w localw = c.aom(paramca.field_imgPath);
    if (localw == null)
    {
      AppMethodBeat.o(21520);
      return null;
    }
    if (paramca.getType() == 62) {}
    for (int i = 62;; i = 43)
    {
      paramih.rWu = i;
      if (!Util.isNullOrNil(paramca.field_content)) {
        break;
      }
      AppMethodBeat.o(21520);
      return null;
    }
    if (c.Lj(paramca.field_talker)) {}
    for (paramih = localw.bqK();; paramih = paramih.RID.Ufy)
    {
      paramca = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput(paramca);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "videomsg");
        Map localMap = XmlParser.parseXml(localw.bqO(), "msg", null);
        if (localMap != null)
        {
          localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.videomsg.$aeskey"));
          localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.videomsg.$cdnthumbaeskey"));
          localXmlSerializer.attribute(null, "cdnvideourl", (String)localMap.get(".msg.videomsg.$cdnvideourl"));
          localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.videomsg.$cdnthumburl"));
          localXmlSerializer.attribute(null, "cdnthumblength", (String)localMap.get(".msg.videomsg.$cdnthumblength"));
        }
        localXmlSerializer.attribute(null, "playlength", localw.lvw);
        localXmlSerializer.attribute(null, "length", localw.lAW);
        localXmlSerializer.attribute(null, "type", String.valueOf(i));
        if (!Util.isNullOrNil(paramih)) {
          localXmlSerializer.attribute(null, "fromusername", paramih);
        }
        localXmlSerializer.attribute(null, "md5", localw.fVg);
        localXmlSerializer.endTag(null, "videomsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        paramca.flush();
        paramca.close();
        paramih = paramca.getBuffer().toString();
        Log.d("MicroMsg.BackupItemVideo", "parseContent xml:".concat(String.valueOf(paramih)));
        AppMethodBeat.o(21520);
        return paramih;
      }
      catch (Exception paramih)
      {
        Log.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + paramih.toString());
        AppMethodBeat.o(21520);
      }
    }
    return null;
  }
  
  public final int a(ih paramih, boolean paramBoolean1, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21518);
    d.cua().cub().bqB();
    paramString = x.XT(paramca.field_imgPath);
    paramHashMap = c.aom(paramca.field_imgPath);
    int j;
    if ((paramHashMap == null) || (paramHashMap.status == 199))
    {
      j = 1;
      paramHashMap = new q(paramString);
      if ((j == 0) || (!paramHashMap.ifE())) {
        break label359;
      }
    }
    label294:
    label356:
    label359:
    for (int k = (int)paramHashMap.length();; k = 0)
    {
      int m = 0;
      d.cua().cub().bqB();
      paramHashMap = x.XU(paramca.field_imgPath);
      q localq = new q(paramHashMap);
      if (localq.ifE()) {
        m = (int)localq.length();
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
        if (paramca.getType() == 62) {
          i = i.a(new i.a(paramHashMap, paramih, paramLinkedList, 13, paramBoolean1, "_thumb", paramBoolean2)) + 0;
        }
      }
      else
      {
        if ((j == 0) || (k == 0)) {
          break label356;
        }
        if (paramca.getType() != 62) {
          break label294;
        }
        i = i.a(new i.a(paramString, paramih, paramLinkedList, 12, paramBoolean1, paramBoolean2, null)) + i;
      }
      for (;;)
      {
        paramca = a(paramih, paramca);
        if (paramca == null)
        {
          AppMethodBeat.o(21518);
          return i;
          i = i.a(new i.a(paramHashMap, paramih, paramLinkedList, 11, paramBoolean1, "_thumb", paramBoolean2)) + 0;
          break;
          i = i.a(new i.a(paramString, paramih, paramLinkedList, 10, paramBoolean1, paramBoolean2, null)) + i;
          continue;
        }
        paramih.RIF = new eaf().btQ(paramca);
        j = paramca.length();
        AppMethodBeat.o(21518);
        return i + j;
      }
    }
  }
  
  public final int a(String paramString, ih paramih, ca paramca)
  {
    AppMethodBeat.i(21519);
    paramString = new w();
    paramString.fPV = paramih.RID.Ufy;
    paramString.createTime = paramca.field_createTime;
    paramString.fNu = paramih.HlH;
    Object localObject = paramih.RIF.Ufy;
    Log.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(localObject)));
    localObject = XmlParser.parseXml((String)localObject, "msg", null);
    if (localObject != null)
    {
      try
      {
        paramString.lAW = g.cP((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
        paramString.lvw = g.cP((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        paramString.mhK = ((String)((Map)localObject).get(".msg.videomsg.$fromusername"));
        i = g.cP((String)((Map)localObject).get(".msg.videomsg.$type"), 0);
        Log.d("MicroMsg.BackupItemVideo", "video msg exportType :".concat(String.valueOf(i)));
        if (i != 44) {
          break label487;
        }
        i = 1;
        paramString.mhU = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          label191:
          label216:
          Log.e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
          Log.printErrStackTrace("MicroMsg.BackupItemVideo", localException, "", new Object[0]);
        }
      }
      if ((!g.d(paramih, 10)) && (!g.d(paramih, 12))) {
        break label556;
      }
      paramString.status = 199;
      localObject = x.XS(paramString.bqM());
      paramca.Jn((String)localObject);
      paramString.fileName = ((String)localObject);
      if (paramca.getType() != 62) {
        paramca.setType(43);
      }
      paramca.setContent(com.tencent.mm.modelvideo.u.a(paramString.bqK(), paramString.mhQ, false));
      paramString.mhR = ((int)c.z(paramca));
      paramString.mhP = Util.nowSecond();
      paramString.mhS = 0;
      Log.d("MicroMsg.BackupItemVideo", "Insert fileName[" + paramString.getFileName() + "] size:" + paramString.lAW + " svrid:" + paramString.fNu + " timelen:" + paramString.lvw + " user:" + paramString.bqM() + " human:" + paramString.bqK());
      d.cua().cub().bqB().b(paramString);
      d.cua().cub().bqB();
      paramString = x.XU((String)localObject);
      if (paramca.getType() != 62) {
        break label565;
      }
      g.b(paramih, 13, paramString);
    }
    for (paramString = g.a(paramih, 12);; paramString = g.a(paramih, 10))
    {
      if (paramString != null)
      {
        paramString = g.aoc(paramString) + paramString;
        d.cua().cub().bqB();
        com.tencent.mm.vfs.u.oo(paramString, x.XT((String)localObject));
      }
      AppMethodBeat.o(21519);
      return 0;
      label487:
      i = 0;
      break;
      Log.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", new Object[] { paramih.RIF.Ufy });
      paramca.setContent(paramih.RIF.Ufy);
      break label191;
      label556:
      paramString.status = 111;
      break label216;
      label565:
      g.b(paramih, 11, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.f
 * JD-Core Version:    0.7.0.1
 */