package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
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
  byte[] mWR;
  byte[] mWS;
  
  public g()
  {
    AppMethodBeat.i(21521);
    this.mWR = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.mWS = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21521);
  }
  
  private static String e(bo parambo, int paramInt)
  {
    AppMethodBeat.i(21525);
    if (bs.isNullOrNil(parambo.field_content))
    {
      AppMethodBeat.o(21525);
      return null;
    }
    p localp = new p(parambo.field_content);
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
      if (!bs.isNullOrNil(localp.iaC)) {
        localXmlSerializer.attribute(null, "fromusername", localp.iaC);
      }
      if (localp.iaD) {}
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
        if (c.sQ(parambo.field_talker)) {
          localObject1 = localp.iaC + ":\n" + (String)localObject2;
        }
        ac.d("MicroMsg.BackupItemVoice", "parseContent xml:%s", new Object[] { localObject1 });
        AppMethodBeat.o(21525);
        return localObject1;
      }
      return null;
    }
    catch (Exception parambo)
    {
      ac.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + parambo.toString());
      AppMethodBeat.o(21525);
    }
  }
  
  private static boolean h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21524);
    if (bs.cv(paramArrayOfByte2))
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
  
  public final int a(hy paramhy, boolean paramBoolean1, bo parambo, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21522);
    paramString = c.SF(parambo.field_imgPath);
    if (bs.isNullOrNil(paramString))
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
    int j = i.a(new i.a(paramString, paramhy, paramLinkedList, 9, paramBoolean2, paramBoolean2, null));
    parambo = e(parambo, i);
    if (parambo == null)
    {
      AppMethodBeat.o(21522);
      return 0;
    }
    paramhy.DPV = new crm().aJV(parambo);
    j += parambo.length();
    if (i == 0)
    {
      AppMethodBeat.o(21522);
      return j;
    }
    AppMethodBeat.o(21522);
    return j;
  }
  
  public final int a(String paramString, hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21523);
    Object localObject = paramhy.DPV.FEm;
    paramString = (String)localObject;
    int i;
    if (c.sQ(paramhy.DPT.FEm))
    {
      i = c.yk((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        ac.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", new Object[] { paramString });
      }
    }
    else
    {
      paramString = bv.L(paramString, "msg");
      if (paramString == null) {
        break label335;
      }
    }
    try
    {
      i = com.tencent.mm.plugin.backup.b.g.cg((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      int j = com.tencent.mm.plugin.backup.b.g.cg((String)paramString.get(".msg.voicemsg.$isPlayed"), 1);
      long l = i;
      if (j != 1) {
        break label304;
      }
      bool = true;
      label137:
      parambo.setContent(p.b((String)localObject, l, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label150:
        ac.e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
        ac.printErrStackTrace("MicroMsg.BackupItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = w.EN(paramhy.DPT.FEm);
    parambo.rf(paramString);
    c.u(parambo);
    paramString = c.SF(paramString);
    parambo = com.tencent.mm.plugin.backup.b.g.a(paramhy, 9);
    if (!bs.isNullOrNil(parambo))
    {
      parambo = com.tencent.mm.plugin.backup.b.g.Ss(parambo) + parambo;
      if (com.tencent.mm.vfs.i.eA(parambo))
      {
        localObject = com.tencent.mm.vfs.i.aU(parambo, 0, 9);
        if (!h(this.mWR, (byte[])localObject)) {
          break label371;
        }
        localObject = com.tencent.mm.vfs.i.aU(parambo, 6, -1);
        com.tencent.mm.vfs.i.deleteFile(parambo);
        com.tencent.mm.vfs.i.f(parambo, (byte[])localObject, localObject.length);
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
      ac.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramhy.DPV.FEm });
      parambo.setContent(paramhy.DPV.FEm);
      break label150;
      label371:
      if (h(this.mWS, (byte[])localObject))
      {
        localObject = com.tencent.mm.vfs.i.aU(parambo, 6, -1);
        com.tencent.mm.vfs.i.deleteFile(parambo);
        com.tencent.mm.vfs.i.f(parambo, (byte[])localObject, localObject.length);
      }
    }
    label410:
    if (com.tencent.mm.plugin.backup.b.g.b(paramhy, 9, paramString))
    {
      AppMethodBeat.o(21523);
      return 0;
    }
    paramhy = com.tencent.mm.plugin.backup.b.g.a(paramhy, 9);
    if (paramhy != null)
    {
      paramhy = com.tencent.mm.plugin.backup.b.g.Ss(paramhy) + paramhy;
      ac.d("MicroMsg.BackupItemVoice", "recover from path:%s", new Object[] { paramhy });
      com.tencent.mm.vfs.i.ma(paramhy, paramString);
    }
    AppMethodBeat.o(21523);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.g
 * JD-Core Version:    0.7.0.1
 */