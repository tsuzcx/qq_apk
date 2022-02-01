package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
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
  byte[] nCJ;
  byte[] nCK;
  
  public g()
  {
    AppMethodBeat.i(21521);
    this.nCJ = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.nCK = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21521);
  }
  
  private static String e(bv parambv, int paramInt)
  {
    AppMethodBeat.i(21525);
    if (bu.isNullOrNil(parambv.field_content))
    {
      AppMethodBeat.o(21525);
      return null;
    }
    p localp = new p(parambv.field_content);
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
      if (!bu.isNullOrNil(localp.iwS)) {
        localXmlSerializer.attribute(null, "fromusername", localp.iwS);
      }
      if (localp.iwT) {}
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
        if (c.wb(parambv.field_talker)) {
          localObject1 = localp.iwS + ":\n" + (String)localObject2;
        }
        ae.d("MicroMsg.BackupItemVoice", "parseContent xml:%s", new Object[] { localObject1 });
        AppMethodBeat.o(21525);
        return localObject1;
      }
      return null;
    }
    catch (Exception parambv)
    {
      ae.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + parambv.toString());
      AppMethodBeat.o(21525);
    }
  }
  
  private static boolean h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21524);
    if (bu.cF(paramArrayOfByte2))
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
  
  public final int a(if paramif, boolean paramBoolean1, bv parambv, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21522);
    paramString = c.WP(parambv.field_imgPath);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21522);
      return 0;
    }
    paramHashMap = new k(paramString);
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
    int j = i.a(new i.a(paramString, paramif, paramLinkedList, 9, paramBoolean2, paramBoolean2, null));
    parambv = e(parambv, i);
    if (parambv == null)
    {
      AppMethodBeat.o(21522);
      return 0;
    }
    paramif.FNI = new cxn().aQV(parambv);
    j += parambv.length();
    if (i == 0)
    {
      AppMethodBeat.o(21522);
      return j;
    }
    AppMethodBeat.o(21522);
    return j;
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    AppMethodBeat.i(21523);
    Object localObject = paramif.FNI.HId;
    paramString = (String)localObject;
    int i;
    if (c.wb(paramif.FNG.HId))
    {
      i = c.BL((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        ae.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", new Object[] { paramString });
      }
    }
    else
    {
      paramString = bx.M(paramString, "msg");
      if (paramString == null) {
        break label335;
      }
    }
    try
    {
      i = com.tencent.mm.plugin.backup.b.g.cn((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      int j = com.tencent.mm.plugin.backup.b.g.cn((String)paramString.get(".msg.voicemsg.$isPlayed"), 1);
      long l = i;
      if (j != 1) {
        break label304;
      }
      bool = true;
      label137:
      parambv.setContent(p.b((String)localObject, l, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label150:
        ae.e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
        ae.printErrStackTrace("MicroMsg.BackupItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = w.IE(paramif.FNG.HId);
    parambv.uj(paramString);
    c.v(parambv);
    paramString = c.WP(paramString);
    parambv = com.tencent.mm.plugin.backup.b.g.a(paramif, 9);
    if (!bu.isNullOrNil(parambv))
    {
      parambv = com.tencent.mm.plugin.backup.b.g.WC(parambv) + parambv;
      if (o.fB(parambv))
      {
        localObject = o.bb(parambv, 0, 9);
        if (!h(this.nCJ, (byte[])localObject)) {
          break label371;
        }
        localObject = o.bb(parambv, 6, -1);
        o.deleteFile(parambv);
        o.f(parambv, (byte[])localObject, localObject.length);
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
      ae.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramif.FNI.HId });
      parambv.setContent(paramif.FNI.HId);
      break label150;
      label371:
      if (h(this.nCK, (byte[])localObject))
      {
        localObject = o.bb(parambv, 6, -1);
        o.deleteFile(parambv);
        o.f(parambv, (byte[])localObject, localObject.length);
      }
    }
    label410:
    if (com.tencent.mm.plugin.backup.b.g.b(paramif, 9, paramString))
    {
      AppMethodBeat.o(21523);
      return 0;
    }
    paramif = com.tencent.mm.plugin.backup.b.g.a(paramif, 9);
    if (paramif != null)
    {
      paramif = com.tencent.mm.plugin.backup.b.g.WC(paramif) + paramif;
      ae.d("MicroMsg.BackupItemVoice", "recover from path:%s", new Object[] { paramif });
      o.mG(paramif, paramString);
    }
    AppMethodBeat.o(21523);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.g
 * JD-Core Version:    0.7.0.1
 */