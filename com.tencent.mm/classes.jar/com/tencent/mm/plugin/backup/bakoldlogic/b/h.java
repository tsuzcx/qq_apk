package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
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
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class h
  implements j
{
  byte[] nCJ;
  byte[] nCK;
  
  public h()
  {
    AppMethodBeat.i(21853);
    this.nCJ = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.nCK = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21853);
  }
  
  private static String e(bv parambv, int paramInt)
  {
    AppMethodBeat.i(21857);
    if (bu.isNullOrNil(parambv.field_content))
    {
      AppMethodBeat.o(21857);
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
        if (d.wb(parambv.field_talker)) {
          localObject1 = localp.iwS + ":\n" + (String)localObject2;
        }
        ae.i("MicroMsg.BakOldItemVoice", "parseContent xml:".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(21857);
        return localObject1;
      }
      return null;
    }
    catch (Exception parambv)
    {
      ae.e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + parambv.toString());
      AppMethodBeat.o(21857);
    }
  }
  
  private static boolean h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21856);
    if (bu.cF(paramArrayOfByte2))
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
  
  public final int a(if paramif, bv parambv, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21854);
    String str = d.WP(parambv.field_imgPath);
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(21854);
      return 0;
    }
    k localk = new k(str);
    if (!localk.exists())
    {
      AppMethodBeat.o(21854);
      return 0;
    }
    int i = (int)localk.length();
    int j = i.a(new i.a(str, paramif, paramLinkedList, 9, false, null));
    parambv = e(parambv, i);
    if (parambv == null)
    {
      AppMethodBeat.o(21854);
      return 0;
    }
    paramif.FNI = new cxn().aQV(parambv);
    j += parambv.length();
    if (i == 0)
    {
      AppMethodBeat.o(21854);
      return j;
    }
    AppMethodBeat.o(21854);
    return j;
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    AppMethodBeat.i(21855);
    Object localObject = paramif.FNI.HId;
    paramString = (String)localObject;
    int i;
    if (d.wb(paramif.FNG.HId))
    {
      i = d.BL((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        ae.v("MicroMsg.BakOldItemVoice", "chatroom voicemsg, new content=".concat(String.valueOf(paramString)));
      }
    }
    else
    {
      paramString = bx.M(paramString, "msg");
      if (paramString == null) {
        break label317;
      }
    }
    try
    {
      i = a.cn((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      if (a.cn((String)paramString.get(".msg.voicemsg.$isPlayed"), 1) != 1) {
        break label286;
      }
      bool = true;
      label127:
      parambv.setContent(p.b((String)localObject, i, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label141:
        ae.e("MicroMsg.BakOldItemVoice", "parsing voice msg xml failed");
        ae.printErrStackTrace("MicroMsg.BakOldItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = w.IE(paramif.FNG.HId);
    parambv.uj(paramString);
    d.v(parambv);
    paramString = d.WP(paramString);
    if (paramif.FTl == 9)
    {
      parambv = paramif.FTj.getBuffer().zr;
      if (h(this.nCJ, parambv))
      {
        localObject = new byte[parambv.length - 6];
        System.arraycopy(parambv, 6, localObject, 0, parambv.length - 6);
        paramif.FTk = (parambv.length - 6);
        paramif.FTj = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
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
      ae.e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramif.FNI.HId });
      parambv.setContent(paramif.FNI.HId);
      break label141;
      if (h(this.nCK, parambv))
      {
        localObject = new byte[parambv.length - 6];
        System.arraycopy(parambv, 6, localObject, 0, parambv.length - 6);
        paramif.FTk = (parambv.length - 6);
        paramif.FTj = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
      }
      else
      {
        parambv = a.a(paramif, 9);
        if (!bu.isNullOrNil(parambv))
        {
          parambv = a.WS(parambv);
          if (o.fB(parambv))
          {
            localObject = o.bb(parambv, 0, 9);
            if (h(this.nCJ, (byte[])localObject))
            {
              localObject = o.bb(parambv, 6, -1);
              o.deleteFile(parambv);
              o.f(parambv, (byte[])localObject, localObject.length);
            }
            else if (h(this.nCK, (byte[])localObject))
            {
              localObject = o.bb(parambv, 6, -1);
              o.deleteFile(parambv);
              o.f(parambv, (byte[])localObject, localObject.length);
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
      paramif = a.WS(paramif);
      ae.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard".concat(String.valueOf(paramif)));
      o.mF(paramif, paramString);
    }
    AppMethodBeat.o(21855);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.h
 * JD-Core Version:    0.7.0.1
 */