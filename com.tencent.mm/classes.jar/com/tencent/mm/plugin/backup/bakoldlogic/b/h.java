package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.bx.b;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class h
  implements j
{
  byte[] vaR;
  byte[] vaS;
  
  public h()
  {
    AppMethodBeat.i(21853);
    this.vaR = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.vaS = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(21853);
  }
  
  private static String h(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(21857);
    if (Util.isNullOrNil(paramcc.field_content))
    {
      AppMethodBeat.o(21857);
      return null;
    }
    p localp = new p(paramcc.field_content);
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
      if (!Util.isNullOrNil(localp.paV)) {
        localXmlSerializer.attribute(null, "fromusername", localp.paV);
      }
      if (localp.paW) {}
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
        if (d.DQ(paramcc.field_talker)) {
          localObject1 = localp.paV + ":\n" + (String)localObject2;
        }
        Log.i("MicroMsg.BakOldItemVoice", "parseContent xml:".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(21857);
        return localObject1;
      }
      return null;
    }
    catch (Exception paramcc)
    {
      Log.e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + paramcc.toString());
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
  
  public final int a(jd paramjd, cc paramcc, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(300727);
    paramString = d.ahK(paramcc.field_imgPath);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(300727);
      return 0;
    }
    com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u(paramString);
    if (!localu.jKS())
    {
      AppMethodBeat.o(300727);
      return 0;
    }
    int i = (int)localu.length();
    int j = i.a(new i.a(paramString, paramjd, paramLinkedList, 9, false, false, null));
    paramcc = h(paramcc, i);
    if (paramcc == null)
    {
      AppMethodBeat.o(300727);
      return 0;
    }
    paramjd.YFG = new etl().btH(paramcc);
    j += paramcc.length();
    if (i == 0)
    {
      AppMethodBeat.o(300727);
      return j;
    }
    AppMethodBeat.o(300727);
    return j;
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21855);
    Object localObject = paramjd.YFG.abwM;
    paramString = (String)localObject;
    int i;
    if (d.DQ(paramjd.YFE.abwM))
    {
      i = d.JI((String)localObject);
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
      i = a.dr((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      if (a.dr((String)paramString.get(".msg.voicemsg.$isPlayed"), 1) != 1) {
        break label287;
      }
      bool = true;
      label128:
      paramcc.setContent(p.a((String)localObject, i, bool));
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
    paramString = w.QS(paramjd.YFE.abwM);
    paramcc.BT(paramString);
    d.B(paramcc);
    paramString = d.ahK(paramString);
    if (paramjd.YLc == 9)
    {
      paramcc = paramjd.YLa.aaxD.Op;
      if (h(this.vaR, paramcc))
      {
        localObject = new byte[paramcc.length - 6];
        System.arraycopy(paramcc, 6, localObject, 0, paramcc.length - 6);
        paramjd.YLb = (paramcc.length - 6);
        paramjd.YLa = new gol().df((byte[])localObject);
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
      Log.e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramjd.YFG.abwM });
      paramcc.setContent(paramjd.YFG.abwM);
      break label142;
      if (h(this.vaS, paramcc))
      {
        localObject = new byte[paramcc.length - 6];
        System.arraycopy(paramcc, 6, localObject, 0, paramcc.length - 6);
        paramjd.YLb = (paramcc.length - 6);
        paramjd.YLa = new gol().df((byte[])localObject);
      }
      else
      {
        paramcc = a.a(paramjd, 9);
        if (!Util.isNullOrNil(paramcc))
        {
          paramcc = a.ahN(paramcc);
          if (y.ZC(paramcc))
          {
            localObject = y.bi(paramcc, 0, 9);
            if (h(this.vaR, (byte[])localObject))
            {
              localObject = y.bi(paramcc, 6, -1);
              y.deleteFile(paramcc);
              y.f(paramcc, (byte[])localObject, localObject.length);
            }
            else if (h(this.vaS, (byte[])localObject))
            {
              localObject = y.bi(paramcc, 6, -1);
              y.deleteFile(paramcc);
              y.f(paramcc, (byte[])localObject, localObject.length);
            }
          }
        }
      }
    }
    label529:
    if (a.b(paramjd, 9, paramString))
    {
      AppMethodBeat.o(21855);
      return 0;
    }
    paramjd = a.a(paramjd, 9);
    if (paramjd != null)
    {
      paramjd = a.ahN(paramjd);
      Log.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard".concat(String.valueOf(paramjd)));
      y.O(paramjd, paramString, false);
    }
    AppMethodBeat.o(21855);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.h
 * JD-Core Version:    0.7.0.1
 */