package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.q;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class h
  implements j
{
  byte[] rPC;
  byte[] rPD;
  
  public h()
  {
    AppMethodBeat.i(21853);
    this.rPC = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.rPD = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21853);
  }
  
  private static String h(ca paramca, int paramInt)
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
      if (!Util.isNullOrNil(localp.mhK)) {
        localXmlSerializer.attribute(null, "fromusername", localp.mhK);
      }
      if (localp.mhL) {}
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
        if (d.Lj(paramca.field_talker)) {
          localObject1 = localp.mhK + ":\n" + (String)localObject2;
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
  
  public final int a(ih paramih, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(230500);
    paramString = d.aon(paramca.field_imgPath);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(230500);
      return 0;
    }
    q localq = new q(paramString);
    if (!localq.ifE())
    {
      AppMethodBeat.o(230500);
      return 0;
    }
    int i = (int)localq.length();
    int j = i.a(new i.a(paramString, paramih, paramLinkedList, 9, false, false, null));
    paramca = h(paramca, i);
    if (paramca == null)
    {
      AppMethodBeat.o(230500);
      return 0;
    }
    paramih.RIF = new eaf().btQ(paramca);
    j += paramca.length();
    if (i == 0)
    {
      AppMethodBeat.o(230500);
      return j;
    }
    AppMethodBeat.o(230500);
    return j;
  }
  
  public final int a(String paramString, ih paramih, ca paramca)
  {
    AppMethodBeat.i(21855);
    Object localObject = paramih.RIF.Ufy;
    paramString = (String)localObject;
    int i;
    if (d.Lj(paramih.RID.Ufy))
    {
      i = d.RK((String)localObject);
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
      i = a.cP((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      if (a.cP((String)paramString.get(".msg.voicemsg.$isPlayed"), 1) != 1) {
        break label287;
      }
      bool = true;
      label128:
      paramca.setContent(p.a((String)localObject, i, bool));
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
    paramString = w.YN(paramih.RID.Ufy);
    paramca.Jn(paramString);
    d.z(paramca);
    paramString = d.aon(paramString);
    if (paramih.RNO == 9)
    {
      paramca = paramih.RNM.Tkb.UH;
      if (h(this.rPC, paramca))
      {
        localObject = new byte[paramca.length - 6];
        System.arraycopy(paramca, 6, localObject, 0, paramca.length - 6);
        paramih.RNN = (paramca.length - 6);
        paramih.RNM = new eae().dc((byte[])localObject);
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
      Log.e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramih.RIF.Ufy });
      paramca.setContent(paramih.RIF.Ufy);
      break label142;
      if (h(this.rPD, paramca))
      {
        localObject = new byte[paramca.length - 6];
        System.arraycopy(paramca, 6, localObject, 0, paramca.length - 6);
        paramih.RNN = (paramca.length - 6);
        paramih.RNM = new eae().dc((byte[])localObject);
      }
      else
      {
        paramca = a.a(paramih, 9);
        if (!Util.isNullOrNil(paramca))
        {
          paramca = a.aoq(paramca);
          if (com.tencent.mm.vfs.u.agG(paramca))
          {
            localObject = com.tencent.mm.vfs.u.aY(paramca, 0, 9);
            if (h(this.rPC, (byte[])localObject))
            {
              localObject = com.tencent.mm.vfs.u.aY(paramca, 6, -1);
              com.tencent.mm.vfs.u.deleteFile(paramca);
              com.tencent.mm.vfs.u.f(paramca, (byte[])localObject, localObject.length);
            }
            else if (h(this.rPD, (byte[])localObject))
            {
              localObject = com.tencent.mm.vfs.u.aY(paramca, 6, -1);
              com.tencent.mm.vfs.u.deleteFile(paramca);
              com.tencent.mm.vfs.u.f(paramca, (byte[])localObject, localObject.length);
            }
          }
        }
      }
    }
    label529:
    if (a.b(paramih, 9, paramString))
    {
      AppMethodBeat.o(21855);
      return 0;
    }
    paramih = a.a(paramih, 9);
    if (paramih != null)
    {
      paramih = a.aoq(paramih);
      Log.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard".concat(String.valueOf(paramih)));
      com.tencent.mm.vfs.u.on(paramih, paramString);
    }
    AppMethodBeat.o(21855);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.h
 * JD-Core Version:    0.7.0.1
 */