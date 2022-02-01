package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.e;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class h
  implements j
{
  byte[] mWR;
  byte[] mWS;
  
  public h()
  {
    AppMethodBeat.i(21853);
    this.mWR = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.mWS = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21853);
  }
  
  private static String e(bo parambo, int paramInt)
  {
    AppMethodBeat.i(21857);
    if (bs.isNullOrNil(parambo.field_content))
    {
      AppMethodBeat.o(21857);
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
        if (d.sQ(parambo.field_talker)) {
          localObject1 = localp.iaC + ":\n" + (String)localObject2;
        }
        ac.i("MicroMsg.BakOldItemVoice", "parseContent xml:".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(21857);
        return localObject1;
      }
      return null;
    }
    catch (Exception parambo)
    {
      ac.e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + parambo.toString());
      AppMethodBeat.o(21857);
    }
  }
  
  private static boolean h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21856);
    if (bs.cv(paramArrayOfByte2))
    {
      AppMethodBeat.o(21856);
      return false;
    }
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
      {
        AppMethodBeat.o(21856);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(21856);
    return true;
  }
  
  public final int a(hy paramhy, bo parambo, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21854);
    String str = d.SF(parambo.field_imgPath);
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(21854);
      return 0;
    }
    e locale = new e(str);
    if (!locale.exists())
    {
      AppMethodBeat.o(21854);
      return 0;
    }
    int i = (int)locale.length();
    int j = i.a(new i.a(str, paramhy, paramLinkedList, 9, false, null));
    parambo = e(parambo, i);
    if (parambo == null)
    {
      AppMethodBeat.o(21854);
      return 0;
    }
    paramhy.DPV = new crm().aJV(parambo);
    j += parambo.length();
    if (i == 0)
    {
      AppMethodBeat.o(21854);
      return j;
    }
    AppMethodBeat.o(21854);
    return j;
  }
  
  public final int a(String paramString, hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21855);
    Object localObject = paramhy.DPV.FEm;
    paramString = (String)localObject;
    int i;
    if (d.sQ(paramhy.DPT.FEm))
    {
      i = d.yk((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        ac.v("MicroMsg.BakOldItemVoice", "chatroom voicemsg, new content=".concat(String.valueOf(paramString)));
      }
    }
    else
    {
      paramString = bv.L(paramString, "msg");
      if (paramString == null) {
        break label317;
      }
    }
    try
    {
      i = a.cg((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      if (a.cg((String)paramString.get(".msg.voicemsg.$isPlayed"), 1) != 1) {
        break label286;
      }
      bool = true;
      label127:
      parambo.setContent(p.b((String)localObject, i, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label141:
        ac.e("MicroMsg.BakOldItemVoice", "parsing voice msg xml failed");
        ac.printErrStackTrace("MicroMsg.BakOldItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = w.EN(paramhy.DPT.FEm);
    parambo.rf(paramString);
    d.u(parambo);
    paramString = d.SF(paramString);
    if (paramhy.DVu == 9)
    {
      parambo = paramhy.DVs.getBuffer().xy;
      if (h(this.mWR, parambo))
      {
        localObject = new byte[parambo.length - 6];
        System.arraycopy(parambo, 6, localObject, 0, parambo.length - 6);
        paramhy.DVt = (parambo.length - 6);
        paramhy.DVs = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
      }
    }
    for (;;)
    {
      if (paramString != null) {
        break label528;
      }
      AppMethodBeat.o(21855);
      return 0;
      paramString = (String)localObject;
      if (i + 2 >= ((String)localObject).length()) {
        break;
      }
      paramString = ((String)localObject).substring(i + 2);
      break;
      label286:
      bool = false;
      break label127;
      label317:
      ac.e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramhy.DPV.FEm });
      parambo.setContent(paramhy.DPV.FEm);
      break label141;
      if (h(this.mWS, parambo))
      {
        localObject = new byte[parambo.length - 6];
        System.arraycopy(parambo, 6, localObject, 0, parambo.length - 6);
        paramhy.DVt = (parambo.length - 6);
        paramhy.DVs = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
      }
      else
      {
        parambo = a.a(paramhy, 9);
        if (!bs.isNullOrNil(parambo))
        {
          parambo = a.SI(parambo);
          if (com.tencent.mm.vfs.i.eA(parambo))
          {
            localObject = com.tencent.mm.vfs.i.aU(parambo, 0, 9);
            if (h(this.mWR, (byte[])localObject))
            {
              localObject = com.tencent.mm.vfs.i.aU(parambo, 6, -1);
              com.tencent.mm.vfs.i.deleteFile(parambo);
              com.tencent.mm.vfs.i.f(parambo, (byte[])localObject, localObject.length);
            }
            else if (h(this.mWS, (byte[])localObject))
            {
              localObject = com.tencent.mm.vfs.i.aU(parambo, 6, -1);
              com.tencent.mm.vfs.i.deleteFile(parambo);
              com.tencent.mm.vfs.i.f(parambo, (byte[])localObject, localObject.length);
            }
          }
        }
      }
    }
    label528:
    if (a.b(paramhy, 9, paramString))
    {
      AppMethodBeat.o(21855);
      return 0;
    }
    paramhy = a.a(paramhy, 9);
    if (paramhy != null)
    {
      paramhy = a.SI(paramhy);
      ac.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard".concat(String.valueOf(paramhy)));
      com.tencent.mm.vfs.i.lZ(paramhy, paramString);
    }
    AppMethodBeat.o(21855);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.h
 * JD-Core Version:    0.7.0.1
 */