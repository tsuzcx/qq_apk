package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
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
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class h
  implements j
{
  byte[] oNG;
  byte[] oNH;
  
  public h()
  {
    AppMethodBeat.i(21853);
    this.oNG = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.oNH = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21853);
  }
  
  private static String e(ca paramca, int paramInt)
  {
    AppMethodBeat.i(21857);
    if (Util.isNullOrNil(paramca.field_content))
    {
      AppMethodBeat.o(21857);
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
        if (d.Eq(paramca.field_talker)) {
          localObject1 = localp.jsh + ":\n" + (String)localObject2;
        }
        Log.i("MicroMsg.BakOldItemVoice", "parseContent xml:".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(21857);
        return localObject1;
      }
      return null;
    }
    catch (Exception paramca)
    {
      Log.e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + paramca.toString());
      AppMethodBeat.o(21857);
    }
  }
  
  private static boolean h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21856);
    if (Util.isNullOrNil(paramArrayOfByte2))
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
  
  public final int a(is paramis, ca paramca, String paramString, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(231603);
    paramString = d.agJ(paramca.field_imgPath);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(231603);
      return 0;
    }
    o localo = new o(paramString);
    if (!localo.exists())
    {
      AppMethodBeat.o(231603);
      return 0;
    }
    int i = (int)localo.length();
    int j = i.a(new i.a(paramString, paramis, paramLinkedList, 9, false, false, null));
    paramca = e(paramca, i);
    if (paramca == null)
    {
      AppMethodBeat.o(231603);
      return 0;
    }
    paramis.KHn = new dqi().bhy(paramca);
    j += paramca.length();
    if (i == 0)
    {
      AppMethodBeat.o(231603);
      return j;
    }
    AppMethodBeat.o(231603);
    return j;
  }
  
  public final int a(String paramString, is paramis, ca paramca)
  {
    AppMethodBeat.i(21855);
    Object localObject = paramis.KHn.MTo;
    paramString = (String)localObject;
    int i;
    if (d.Eq(paramis.KHl.MTo))
    {
      i = d.Kr((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        Log.v("MicroMsg.BakOldItemVoice", "chatroom voicemsg, new content=".concat(String.valueOf(paramString)));
      }
    }
    else
    {
      paramString = XmlParser.parseXml(paramString, "msg", null);
      if (paramString == null) {
        break label318;
      }
    }
    try
    {
      i = a.cv((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      if (a.cv((String)paramString.get(".msg.voicemsg.$isPlayed"), 1) != 1) {
        break label287;
      }
      bool = true;
      label128:
      paramca.setContent(p.b((String)localObject, i, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label142:
        Log.e("MicroMsg.BakOldItemVoice", "parsing voice msg xml failed");
        Log.printErrStackTrace("MicroMsg.BakOldItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = w.Rq(paramis.KHl.MTo);
    paramca.Cz(paramString);
    d.x(paramca);
    paramString = d.agJ(paramString);
    if (paramis.KMU == 9)
    {
      paramca = paramis.KMS.getBuffer().zy;
      if (h(this.oNG, paramca))
      {
        localObject = new byte[paramca.length - 6];
        System.arraycopy(paramca, 6, localObject, 0, paramca.length - 6);
        paramis.KMT = (paramca.length - 6);
        paramis.KMS = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
      }
    }
    for (;;)
    {
      if (paramString != null) {
        break label529;
      }
      AppMethodBeat.o(21855);
      return 0;
      paramString = (String)localObject;
      if (i + 2 >= ((String)localObject).length()) {
        break;
      }
      paramString = ((String)localObject).substring(i + 2);
      break;
      label287:
      bool = false;
      break label128;
      label318:
      Log.e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramis.KHn.MTo });
      paramca.setContent(paramis.KHn.MTo);
      break label142;
      if (h(this.oNH, paramca))
      {
        localObject = new byte[paramca.length - 6];
        System.arraycopy(paramca, 6, localObject, 0, paramca.length - 6);
        paramis.KMT = (paramca.length - 6);
        paramis.KMS = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
      }
      else
      {
        paramca = a.a(paramis, 9);
        if (!Util.isNullOrNil(paramca))
        {
          paramca = a.agM(paramca);
          if (s.YS(paramca))
          {
            localObject = s.aW(paramca, 0, 9);
            if (h(this.oNG, (byte[])localObject))
            {
              localObject = s.aW(paramca, 6, -1);
              s.deleteFile(paramca);
              s.f(paramca, (byte[])localObject, localObject.length);
            }
            else if (h(this.oNH, (byte[])localObject))
            {
              localObject = s.aW(paramca, 6, -1);
              s.deleteFile(paramca);
              s.f(paramca, (byte[])localObject, localObject.length);
            }
          }
        }
      }
    }
    label529:
    if (a.b(paramis, 9, paramString))
    {
      AppMethodBeat.o(21855);
      return 0;
    }
    paramis = a.a(paramis, 9);
    if (paramis != null)
    {
      paramis = a.agM(paramis);
      Log.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard".concat(String.valueOf(paramis)));
      s.nw(paramis, paramString);
    }
    AppMethodBeat.o(21855);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.h
 * JD-Core Version:    0.7.0.1
 */