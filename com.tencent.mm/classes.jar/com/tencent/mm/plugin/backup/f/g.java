package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
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
  byte[] vaR;
  byte[] vaS;
  
  public g()
  {
    AppMethodBeat.i(21521);
    this.vaR = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.vaS = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21521);
  }
  
  private static String h(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(21525);
    if (Util.isNullOrNil(paramcc.field_content))
    {
      AppMethodBeat.o(21525);
      return null;
    }
    p localp = new p(paramcc.field_content);
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
      if (!Util.isNullOrNil(localp.paV)) {
        localXmlSerializer.attribute(null, "fromusername", localp.paV);
      }
      if (localp.paW) {}
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
        if (c.DQ(paramcc.field_talker)) {
          localObject1 = localp.paV + ":\n" + (String)localObject2;
        }
        Log.d("MicroMsg.BackupItemVoice", "parseContent xml:%s", new Object[] { Util.secPrint((String)localObject1) });
        AppMethodBeat.o(21525);
        return localObject1;
      }
      return null;
    }
    catch (Exception paramcc)
    {
      Log.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + paramcc.toString());
      AppMethodBeat.o(21525);
    }
  }
  
  private static boolean h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21524);
    if (Util.isNullOrNil(paramArrayOfByte2))
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
  
  public final int a(jd paramjd, boolean paramBoolean1, cc paramcc, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21522);
    paramString = c.ahK(paramcc.field_imgPath);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21522);
      return 0;
    }
    paramHashMap = new com.tencent.mm.vfs.u(paramString);
    if (!paramHashMap.jKS())
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
    int j = i.a(new i.a(paramString, paramjd, paramLinkedList, 9, paramBoolean2, paramBoolean2, null));
    paramcc = h(paramcc, i);
    if (paramcc == null)
    {
      AppMethodBeat.o(21522);
      return 0;
    }
    paramjd.YFG = new etl().btH(paramcc);
    j += paramcc.length();
    if (i == 0)
    {
      AppMethodBeat.o(21522);
      return j;
    }
    AppMethodBeat.o(21522);
    return j;
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21523);
    Object localObject = paramjd.YFG.abwM;
    paramString = (String)localObject;
    int i;
    if (c.DQ(paramjd.YFE.abwM))
    {
      i = c.JI((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        Log.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", new Object[] { paramString });
      }
    }
    else
    {
      paramString = XmlParser.parseXml(paramString, "msg", null);
      if (paramString == null) {
        break label336;
      }
    }
    try
    {
      i = com.tencent.mm.plugin.backup.b.g.dr((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      int j = com.tencent.mm.plugin.backup.b.g.dr((String)paramString.get(".msg.voicemsg.$isPlayed"), 1);
      long l = i;
      if (j != 1) {
        break label305;
      }
      bool = true;
      label138:
      paramcc.setContent(p.a((String)localObject, l, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label151:
        Log.e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
        Log.printErrStackTrace("MicroMsg.BackupItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = w.QS(paramjd.YFE.abwM);
    paramcc.BT(paramString);
    c.B(paramcc);
    paramString = c.ahK(paramString);
    paramcc = com.tencent.mm.plugin.backup.b.g.a(paramjd, 9);
    if (!Util.isNullOrNil(paramcc))
    {
      paramcc = com.tencent.mm.plugin.backup.b.g.ahz(paramcc) + paramcc;
      if (y.ZC(paramcc))
      {
        localObject = y.bi(paramcc, 0, 9);
        if (!h(this.vaR, (byte[])localObject)) {
          break label372;
        }
        localObject = y.bi(paramcc, 6, -1);
        y.deleteFile(paramcc);
        y.f(paramcc, (byte[])localObject, localObject.length);
      }
    }
    for (;;)
    {
      if (paramString != null) {
        break label411;
      }
      AppMethodBeat.o(21523);
      return 0;
      paramString = (String)localObject;
      if (i + 2 >= ((String)localObject).length()) {
        break;
      }
      paramString = ((String)localObject).substring(i + 2);
      break;
      label305:
      bool = false;
      break label138;
      label336:
      Log.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramjd.YFG.abwM });
      paramcc.setContent(paramjd.YFG.abwM);
      break label151;
      label372:
      if (h(this.vaS, (byte[])localObject))
      {
        localObject = y.bi(paramcc, 6, -1);
        y.deleteFile(paramcc);
        y.f(paramcc, (byte[])localObject, localObject.length);
      }
    }
    label411:
    if (com.tencent.mm.plugin.backup.b.g.b(paramjd, 9, paramString))
    {
      AppMethodBeat.o(21523);
      return 0;
    }
    paramjd = com.tencent.mm.plugin.backup.b.g.a(paramjd, 9);
    if (paramjd != null)
    {
      paramjd = com.tencent.mm.plugin.backup.b.g.ahz(paramjd) + paramjd;
      Log.d("MicroMsg.BackupItemVoice", "recover from path:%s", new Object[] { paramjd });
      y.qn(paramjd, paramString);
    }
    AppMethodBeat.o(21523);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.g
 * JD-Core Version:    0.7.0.1
 */