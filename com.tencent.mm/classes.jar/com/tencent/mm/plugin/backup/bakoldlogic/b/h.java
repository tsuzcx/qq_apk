package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
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
  byte[] nxo;
  byte[] nxp;
  
  public h()
  {
    AppMethodBeat.i(21853);
    this.nxo = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.nxp = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21853);
  }
  
  private static String e(bu parambu, int paramInt)
  {
    AppMethodBeat.i(21857);
    if (bt.isNullOrNil(parambu.field_content))
    {
      AppMethodBeat.o(21857);
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
        if (d.vF(parambu.field_talker)) {
          localObject1 = localp.itY + ":\n" + (String)localObject2;
        }
        ad.i("MicroMsg.BakOldItemVoice", "parseContent xml:".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(21857);
        return localObject1;
      }
      return null;
    }
    catch (Exception parambu)
    {
      ad.e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + parambu.toString());
      AppMethodBeat.o(21857);
    }
  }
  
  private static boolean h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21856);
    if (bt.cC(paramArrayOfByte2))
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
  
  public final int a(if paramif, bu parambu, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21854);
    String str = d.Wd(parambu.field_imgPath);
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
    int j = i.a(new i.a(str, paramif, paramLinkedList, 9, false, null));
    parambu = e(parambu, i);
    if (parambu == null)
    {
      AppMethodBeat.o(21854);
      return 0;
    }
    paramif.Fvk = new cwt().aPy(parambu);
    j += parambu.length();
    if (i == 0)
    {
      AppMethodBeat.o(21854);
      return j;
    }
    AppMethodBeat.o(21854);
    return j;
  }
  
  public final int a(String paramString, if paramif, bu parambu)
  {
    AppMethodBeat.i(21855);
    Object localObject = paramif.Fvk.HoB;
    paramString = (String)localObject;
    int i;
    if (d.vF(paramif.Fvi.HoB))
    {
      i = d.Bj((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        ad.v("MicroMsg.BakOldItemVoice", "chatroom voicemsg, new content=".concat(String.valueOf(paramString)));
      }
    }
    else
    {
      paramString = bw.M(paramString, "msg");
      if (paramString == null) {
        break label317;
      }
    }
    try
    {
      i = a.cj((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      if (a.cj((String)paramString.get(".msg.voicemsg.$isPlayed"), 1) != 1) {
        break label286;
      }
      bool = true;
      label127:
      parambu.setContent(p.b((String)localObject, i, bool));
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
    paramString = w.Ic(paramif.Fvi.HoB);
    parambu.tO(paramString);
    d.v(parambu);
    paramString = d.Wd(paramString);
    if (paramif.FAP == 9)
    {
      parambu = paramif.FAN.getBuffer().zr;
      if (h(this.nxo, parambu))
      {
        localObject = new byte[parambu.length - 6];
        System.arraycopy(parambu, 6, localObject, 0, parambu.length - 6);
        paramif.FAO = (parambu.length - 6);
        paramif.FAN = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
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
      ad.e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramif.Fvk.HoB });
      parambu.setContent(paramif.Fvk.HoB);
      break label141;
      if (h(this.nxp, parambu))
      {
        localObject = new byte[parambu.length - 6];
        System.arraycopy(parambu, 6, localObject, 0, parambu.length - 6);
        paramif.FAO = (parambu.length - 6);
        paramif.FAN = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
      }
      else
      {
        parambu = a.a(paramif, 9);
        if (!bt.isNullOrNil(parambu))
        {
          parambu = a.Wg(parambu);
          if (com.tencent.mm.vfs.i.fv(parambu))
          {
            localObject = com.tencent.mm.vfs.i.aY(parambu, 0, 9);
            if (h(this.nxo, (byte[])localObject))
            {
              localObject = com.tencent.mm.vfs.i.aY(parambu, 6, -1);
              com.tencent.mm.vfs.i.deleteFile(parambu);
              com.tencent.mm.vfs.i.f(parambu, (byte[])localObject, localObject.length);
            }
            else if (h(this.nxp, (byte[])localObject))
            {
              localObject = com.tencent.mm.vfs.i.aY(parambu, 6, -1);
              com.tencent.mm.vfs.i.deleteFile(parambu);
              com.tencent.mm.vfs.i.f(parambu, (byte[])localObject, localObject.length);
            }
          }
        }
      }
    }
    label528:
    if (a.b(paramif, 9, paramString))
    {
      AppMethodBeat.o(21855);
      return 0;
    }
    paramif = a.a(paramif, 9);
    if (paramif != null)
    {
      paramif = a.Wg(paramif);
      ad.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard".concat(String.valueOf(paramif)));
      com.tencent.mm.vfs.i.mz(paramif, paramString);
    }
    AppMethodBeat.o(21855);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.h
 * JD-Core Version:    0.7.0.1
 */