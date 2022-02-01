package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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
  byte[] oNG;
  byte[] oNH;
  
  public g()
  {
    AppMethodBeat.i(21521);
    this.oNG = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.oNH = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21521);
  }
  
  private static String e(ca paramca, int paramInt)
  {
    AppMethodBeat.i(21525);
    if (Util.isNullOrNil(paramca.field_content))
    {
      AppMethodBeat.o(21525);
      return null;
    }
    p localp = new p(paramca.field_content);
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
      if (!Util.isNullOrNil(localp.jsh)) {
        localXmlSerializer.attribute(null, "fromusername", localp.jsh);
      }
      if (localp.jsi) {}
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
        if (c.Eq(paramca.field_talker)) {
          localObject1 = localp.jsh + ":\n" + (String)localObject2;
        }
        Log.d("MicroMsg.BackupItemVoice", "parseContent xml:%s", new Object[] { localObject1 });
        AppMethodBeat.o(21525);
        return localObject1;
      }
      return null;
    }
    catch (Exception paramca)
    {
      Log.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + paramca.toString());
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
  
  public final int a(is paramis, boolean paramBoolean1, ca paramca, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21522);
    paramString = c.agJ(paramca.field_imgPath);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21522);
      return 0;
    }
    paramHashMap = new o(paramString);
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
    int j = i.a(new i.a(paramString, paramis, paramLinkedList, 9, paramBoolean2, paramBoolean2, null));
    paramca = e(paramca, i);
    if (paramca == null)
    {
      AppMethodBeat.o(21522);
      return 0;
    }
    paramis.KHn = new dqi().bhy(paramca);
    j += paramca.length();
    if (i == 0)
    {
      AppMethodBeat.o(21522);
      return j;
    }
    AppMethodBeat.o(21522);
    return j;
  }
  
  public final int a(String paramString, is paramis, ca paramca)
  {
    AppMethodBeat.i(21523);
    Object localObject = paramis.KHn.MTo;
    paramString = (String)localObject;
    int i;
    if (c.Eq(paramis.KHl.MTo))
    {
      i = c.Kr((String)localObject);
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
      i = com.tencent.mm.plugin.backup.b.g.cv((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      int j = com.tencent.mm.plugin.backup.b.g.cv((String)paramString.get(".msg.voicemsg.$isPlayed"), 1);
      long l = i;
      if (j != 1) {
        break label305;
      }
      bool = true;
      label138:
      paramca.setContent(p.b((String)localObject, l, bool));
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
    paramString = w.Rq(paramis.KHl.MTo);
    paramca.Cz(paramString);
    c.x(paramca);
    paramString = c.agJ(paramString);
    paramca = com.tencent.mm.plugin.backup.b.g.a(paramis, 9);
    if (!Util.isNullOrNil(paramca))
    {
      paramca = com.tencent.mm.plugin.backup.b.g.agy(paramca) + paramca;
      if (s.YS(paramca))
      {
        localObject = s.aW(paramca, 0, 9);
        if (!h(this.oNG, (byte[])localObject)) {
          break label372;
        }
        localObject = s.aW(paramca, 6, -1);
        s.deleteFile(paramca);
        s.f(paramca, (byte[])localObject, localObject.length);
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
      Log.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramis.KHn.MTo });
      paramca.setContent(paramis.KHn.MTo);
      break label151;
      label372:
      if (h(this.oNH, (byte[])localObject))
      {
        localObject = s.aW(paramca, 6, -1);
        s.deleteFile(paramca);
        s.f(paramca, (byte[])localObject, localObject.length);
      }
    }
    label411:
    if (com.tencent.mm.plugin.backup.b.g.b(paramis, 9, paramString))
    {
      AppMethodBeat.o(21523);
      return 0;
    }
    paramis = com.tencent.mm.plugin.backup.b.g.a(paramis, 9);
    if (paramis != null)
    {
      paramis = com.tencent.mm.plugin.backup.b.g.agy(paramis) + paramis;
      Log.d("MicroMsg.BackupItemVoice", "recover from path:%s", new Object[] { paramis });
      s.nx(paramis, paramString);
    }
    AppMethodBeat.o(21523);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.g
 * JD-Core Version:    0.7.0.1
 */