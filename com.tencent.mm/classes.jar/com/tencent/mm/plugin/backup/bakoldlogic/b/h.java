package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
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
  byte[] muQ;
  byte[] muR;
  
  public h()
  {
    AppMethodBeat.i(21853);
    this.muQ = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.muR = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21853);
  }
  
  private static String e(bl parambl, int paramInt)
  {
    AppMethodBeat.i(21857);
    if (bt.isNullOrNil(parambl.field_content))
    {
      AppMethodBeat.o(21857);
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
        if (d.pF(parambl.field_talker)) {
          localObject1 = localp.hAb + ":\n" + (String)localObject2;
        }
        ad.i("MicroMsg.BakOldItemVoice", "parseContent xml:".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(21857);
        return localObject1;
      }
      return null;
    }
    catch (Exception parambl)
    {
      ad.e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + parambl.toString());
      AppMethodBeat.o(21857);
    }
  }
  
  private static boolean h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21856);
    if (bt.cw(paramArrayOfByte2))
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
  
  public final int a(hu paramhu, bl parambl, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21854);
    String str = d.Ov(parambl.field_imgPath);
    if (bt.isNullOrNil(str))
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
    int j = i.a(new i.a(str, paramhu, paramLinkedList, 9, false, null));
    parambl = e(parambl, i);
    if (parambl == null)
    {
      AppMethodBeat.o(21854);
      return 0;
    }
    paramhu.Cxz = new cmf().aEE(parambl);
    j += parambl.length();
    if (i == 0)
    {
      AppMethodBeat.o(21854);
      return j;
    }
    AppMethodBeat.o(21854);
    return j;
  }
  
  public final int a(String paramString, hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21855);
    Object localObject = paramhu.Cxz.Ehn;
    paramString = (String)localObject;
    int i;
    if (d.pF(paramhu.Cxx.Ehn))
    {
      i = d.ue((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        ad.v("MicroMsg.BakOldItemVoice", "chatroom voicemsg, new content=".concat(String.valueOf(paramString)));
      }
    }
    else
    {
      paramString = bw.K(paramString, "msg");
      if (paramString == null) {
        break label317;
      }
    }
    try
    {
      i = a.cb((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      if (a.cb((String)paramString.get(".msg.voicemsg.$isPlayed"), 1) != 1) {
        break label286;
      }
      bool = true;
      label127:
      parambl.setContent(p.b((String)localObject, i, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label141:
        ad.e("MicroMsg.BakOldItemVoice", "parsing voice msg xml failed");
        ad.printErrStackTrace("MicroMsg.BakOldItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = w.AI(paramhu.Cxx.Ehn);
    parambl.nZ(paramString);
    d.u(parambl);
    paramString = d.Ov(paramString);
    if (paramhu.CCX == 9)
    {
      parambl = paramhu.CCV.getBuffer().wA;
      if (h(this.muQ, parambl))
      {
        localObject = new byte[parambl.length - 6];
        System.arraycopy(parambl, 6, localObject, 0, parambl.length - 6);
        paramhu.CCW = (parambl.length - 6);
        paramhu.CCV = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
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
      ad.e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramhu.Cxz.Ehn });
      parambl.setContent(paramhu.Cxz.Ehn);
      break label141;
      if (h(this.muR, parambl))
      {
        localObject = new byte[parambl.length - 6];
        System.arraycopy(parambl, 6, localObject, 0, parambl.length - 6);
        paramhu.CCW = (parambl.length - 6);
        paramhu.CCV = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
      }
      else
      {
        parambl = a.a(paramhu, 9);
        if (!bt.isNullOrNil(parambl))
        {
          parambl = a.Oy(parambl);
          if (com.tencent.mm.vfs.i.eK(parambl))
          {
            localObject = com.tencent.mm.vfs.i.aR(parambl, 0, 9);
            if (h(this.muQ, (byte[])localObject))
            {
              localObject = com.tencent.mm.vfs.i.aR(parambl, 6, -1);
              com.tencent.mm.vfs.i.deleteFile(parambl);
              com.tencent.mm.vfs.i.f(parambl, (byte[])localObject, localObject.length);
            }
            else if (h(this.muR, (byte[])localObject))
            {
              localObject = com.tencent.mm.vfs.i.aR(parambl, 6, -1);
              com.tencent.mm.vfs.i.deleteFile(parambl);
              com.tencent.mm.vfs.i.f(parambl, (byte[])localObject, localObject.length);
            }
          }
        }
      }
    }
    label528:
    if (a.b(paramhu, 9, paramString))
    {
      AppMethodBeat.o(21855);
      return 0;
    }
    paramhu = a.a(paramhu, 9);
    if (paramhu != null)
    {
      paramhu = a.Oy(paramhu);
      ad.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard".concat(String.valueOf(paramhu)));
      com.tencent.mm.vfs.i.lC(paramhu, paramString);
    }
    AppMethodBeat.o(21855);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.h
 * JD-Core Version:    0.7.0.1
 */