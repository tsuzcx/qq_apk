package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.e;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g
  implements l
{
  byte[] muQ;
  byte[] muR;
  
  public g()
  {
    AppMethodBeat.i(21521);
    this.muQ = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.muR = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21521);
  }
  
  private static String e(bl parambl, int paramInt)
  {
    AppMethodBeat.i(21525);
    if (bt.isNullOrNil(parambl.field_content))
    {
      AppMethodBeat.o(21525);
      return null;
    }
    p localp = new p(parambl.field_content);
    Object localObject2 = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput((Writer)localObject2);
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "voicemsg");
      localXmlSerializer.attribute(null, "length", String.valueOf(paramInt));
      localXmlSerializer.attribute(null, "endflag", "1");
      localXmlSerializer.attribute(null, "cancelflag", "0");
      localXmlSerializer.attribute(null, "voicelength", localp.time);
      if (!bt.isNullOrNil(localp.hAb)) {
        localXmlSerializer.attribute(null, "fromusername", localp.hAb);
      }
      if (localp.hAc) {}
      for (Object localObject1 = "1";; localObject1 = "0")
      {
        localXmlSerializer.attribute(null, "isPlayed", (String)localObject1);
        localXmlSerializer.endTag(null, "voicemsg");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        ((StringWriter)localObject2).flush();
        ((StringWriter)localObject2).close();
        localObject2 = ((StringWriter)localObject2).getBuffer().toString();
        localObject1 = localObject2;
        if (c.pF(parambl.field_talker)) {
          localObject1 = localp.hAb + ":\n" + (String)localObject2;
        }
        ad.d("MicroMsg.BackupItemVoice", "parseContent xml:%s", new Object[] { localObject1 });
        AppMethodBeat.o(21525);
        return localObject1;
      }
      return null;
    }
    catch (Exception parambl)
    {
      ad.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + parambl.toString());
      AppMethodBeat.o(21525);
    }
  }
  
  private static boolean h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21524);
    if (bt.cw(paramArrayOfByte2))
    {
      AppMethodBeat.o(21524);
      return false;
    }
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
      {
        AppMethodBeat.o(21524);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(21524);
    return true;
  }
  
  public final int a(hu paramhu, boolean paramBoolean1, bl parambl, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21522);
    paramString = c.Ov(parambl.field_imgPath);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21522);
      return 0;
    }
    paramHashMap = new e(paramString);
    if (!paramHashMap.exists())
    {
      AppMethodBeat.o(21522);
      return 0;
    }
    int i = (int)paramHashMap.length();
    if (paramBoolean1)
    {
      AppMethodBeat.o(21522);
      return i;
    }
    int j = i.a(new i.a(paramString, paramhu, paramLinkedList, 9, paramBoolean2, paramBoolean2, null));
    parambl = e(parambl, i);
    if (parambl == null)
    {
      AppMethodBeat.o(21522);
      return 0;
    }
    paramhu.Cxz = new cmf().aEE(parambl);
    j += parambl.length();
    if (i == 0)
    {
      AppMethodBeat.o(21522);
      return j;
    }
    AppMethodBeat.o(21522);
    return j;
  }
  
  public final int a(String paramString, hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21523);
    Object localObject = paramhu.Cxz.Ehn;
    paramString = (String)localObject;
    int i;
    if (c.pF(paramhu.Cxx.Ehn))
    {
      i = c.ue((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        ad.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", new Object[] { paramString });
      }
    }
    else
    {
      paramString = bw.K(paramString, "msg");
      if (paramString == null) {
        break label335;
      }
    }
    try
    {
      i = com.tencent.mm.plugin.backup.b.g.cb((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      int j = com.tencent.mm.plugin.backup.b.g.cb((String)paramString.get(".msg.voicemsg.$isPlayed"), 1);
      long l = i;
      if (j != 1) {
        break label304;
      }
      bool = true;
      label137:
      parambl.setContent(p.b((String)localObject, l, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label150:
        ad.e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
        ad.printErrStackTrace("MicroMsg.BackupItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = w.AI(paramhu.Cxx.Ehn);
    parambl.nZ(paramString);
    c.u(parambl);
    paramString = c.Ov(paramString);
    parambl = com.tencent.mm.plugin.backup.b.g.a(paramhu, 9);
    if (!bt.isNullOrNil(parambl))
    {
      parambl = com.tencent.mm.plugin.backup.b.g.Oi(parambl) + parambl;
      if (com.tencent.mm.vfs.i.eK(parambl))
      {
        localObject = com.tencent.mm.vfs.i.aR(parambl, 0, 9);
        if (!h(this.muQ, (byte[])localObject)) {
          break label371;
        }
        localObject = com.tencent.mm.vfs.i.aR(parambl, 6, -1);
        com.tencent.mm.vfs.i.deleteFile(parambl);
        com.tencent.mm.vfs.i.f(parambl, (byte[])localObject, localObject.length);
      }
    }
    for (;;)
    {
      if (paramString != null) {
        break label410;
      }
      AppMethodBeat.o(21523);
      return 0;
      paramString = (String)localObject;
      if (i + 2 >= ((String)localObject).length()) {
        break;
      }
      paramString = ((String)localObject).substring(i + 2);
      break;
      label304:
      bool = false;
      break label137;
      label335:
      ad.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramhu.Cxz.Ehn });
      parambl.setContent(paramhu.Cxz.Ehn);
      break label150;
      label371:
      if (h(this.muR, (byte[])localObject))
      {
        localObject = com.tencent.mm.vfs.i.aR(parambl, 6, -1);
        com.tencent.mm.vfs.i.deleteFile(parambl);
        com.tencent.mm.vfs.i.f(parambl, (byte[])localObject, localObject.length);
      }
    }
    label410:
    if (com.tencent.mm.plugin.backup.b.g.b(paramhu, 9, paramString))
    {
      AppMethodBeat.o(21523);
      return 0;
    }
    paramhu = com.tencent.mm.plugin.backup.b.g.a(paramhu, 9);
    if (paramhu != null)
    {
      paramhu = com.tencent.mm.plugin.backup.b.g.Oi(paramhu) + paramhu;
      ad.d("MicroMsg.BackupItemVoice", "recover from path:%s", new Object[] { paramhu });
      com.tencent.mm.vfs.i.lD(paramhu, paramString);
    }
    AppMethodBeat.o(21523);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.g
 * JD-Core Version:    0.7.0.1
 */