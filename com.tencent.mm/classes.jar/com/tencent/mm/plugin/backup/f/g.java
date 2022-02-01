package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
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
  byte[] nxo;
  byte[] nxp;
  
  public g()
  {
    AppMethodBeat.i(21521);
    this.nxo = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.nxp = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21521);
  }
  
  private static String e(bu parambu, int paramInt)
  {
    AppMethodBeat.i(21525);
    if (bt.isNullOrNil(parambu.field_content))
    {
      AppMethodBeat.o(21525);
      return null;
    }
    p localp = new p(parambu.field_content);
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
      if (!bt.isNullOrNil(localp.itY)) {
        localXmlSerializer.attribute(null, "fromusername", localp.itY);
      }
      if (localp.itZ) {}
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
        if (c.vF(parambu.field_talker)) {
          localObject1 = localp.itY + ":\n" + (String)localObject2;
        }
        ad.d("MicroMsg.BackupItemVoice", "parseContent xml:%s", new Object[] { localObject1 });
        AppMethodBeat.o(21525);
        return localObject1;
      }
      return null;
    }
    catch (Exception parambu)
    {
      ad.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + parambu.toString());
      AppMethodBeat.o(21525);
    }
  }
  
  private static boolean h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21524);
    if (bt.cC(paramArrayOfByte2))
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
  
  public final int a(if paramif, boolean paramBoolean1, bu parambu, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21522);
    paramString = c.Wd(parambu.field_imgPath);
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
    int j = i.a(new i.a(paramString, paramif, paramLinkedList, 9, paramBoolean2, paramBoolean2, null));
    parambu = e(parambu, i);
    if (parambu == null)
    {
      AppMethodBeat.o(21522);
      return 0;
    }
    paramif.Fvk = new cwt().aPy(parambu);
    j += parambu.length();
    if (i == 0)
    {
      AppMethodBeat.o(21522);
      return j;
    }
    AppMethodBeat.o(21522);
    return j;
  }
  
  public final int a(String paramString, if paramif, bu parambu)
  {
    AppMethodBeat.i(21523);
    Object localObject = paramif.Fvk.HoB;
    paramString = (String)localObject;
    int i;
    if (c.vF(paramif.Fvi.HoB))
    {
      i = c.Bj((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        ad.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", new Object[] { paramString });
      }
    }
    else
    {
      paramString = bw.M(paramString, "msg");
      if (paramString == null) {
        break label335;
      }
    }
    try
    {
      i = com.tencent.mm.plugin.backup.b.g.cj((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      int j = com.tencent.mm.plugin.backup.b.g.cj((String)paramString.get(".msg.voicemsg.$isPlayed"), 1);
      long l = i;
      if (j != 1) {
        break label304;
      }
      bool = true;
      label137:
      parambu.setContent(p.b((String)localObject, l, bool));
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
    paramString = w.Ic(paramif.Fvi.HoB);
    parambu.tO(paramString);
    c.v(parambu);
    paramString = c.Wd(paramString);
    parambu = com.tencent.mm.plugin.backup.b.g.a(paramif, 9);
    if (!bt.isNullOrNil(parambu))
    {
      parambu = com.tencent.mm.plugin.backup.b.g.VQ(parambu) + parambu;
      if (com.tencent.mm.vfs.i.fv(parambu))
      {
        localObject = com.tencent.mm.vfs.i.aY(parambu, 0, 9);
        if (!h(this.nxo, (byte[])localObject)) {
          break label371;
        }
        localObject = com.tencent.mm.vfs.i.aY(parambu, 6, -1);
        com.tencent.mm.vfs.i.deleteFile(parambu);
        com.tencent.mm.vfs.i.f(parambu, (byte[])localObject, localObject.length);
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
      ad.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramif.Fvk.HoB });
      parambu.setContent(paramif.Fvk.HoB);
      break label150;
      label371:
      if (h(this.nxp, (byte[])localObject))
      {
        localObject = com.tencent.mm.vfs.i.aY(parambu, 6, -1);
        com.tencent.mm.vfs.i.deleteFile(parambu);
        com.tencent.mm.vfs.i.f(parambu, (byte[])localObject, localObject.length);
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
      paramif = com.tencent.mm.plugin.backup.b.g.VQ(paramif) + paramif;
      ad.d("MicroMsg.BackupItemVoice", "recover from path:%s", new Object[] { paramif });
      com.tencent.mm.vfs.i.mA(paramif, paramString);
    }
    AppMethodBeat.o(21523);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.g
 * JD-Core Version:    0.7.0.1
 */