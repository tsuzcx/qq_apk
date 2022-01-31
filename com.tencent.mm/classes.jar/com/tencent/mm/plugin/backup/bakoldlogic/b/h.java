package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
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
  byte[] jDw;
  byte[] jDx;
  
  public h()
  {
    AppMethodBeat.i(17796);
    this.jDw = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.jDx = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(17796);
  }
  
  private static String d(bi parambi, int paramInt)
  {
    AppMethodBeat.i(17800);
    if (bo.isNullOrNil(parambi.field_content))
    {
      AppMethodBeat.o(17800);
      return null;
    }
    p localp = new p(parambi.field_content);
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
      if (!bo.isNullOrNil(localp.fXq)) {
        localXmlSerializer.attribute(null, "fromusername", localp.fXq);
      }
      if (localp.fXr) {}
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
        if (d.lA(parambi.field_talker)) {
          localObject1 = localp.fXq + ":\n" + (String)localObject2;
        }
        ab.i("MicroMsg.BakOldItemVoice", "parseContent xml:".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(17800);
        return localObject1;
      }
      return null;
    }
    catch (Exception parambi)
    {
      ab.e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + parambi.toString());
      AppMethodBeat.o(17800);
    }
  }
  
  private static boolean g(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(17799);
    if (bo.ce(paramArrayOfByte2))
    {
      AppMethodBeat.o(17799);
      return false;
    }
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
      {
        AppMethodBeat.o(17799);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(17799);
    return true;
  }
  
  public final int a(gx paramgx, bi parambi, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(17797);
    String str = d.Gu(parambi.field_imgPath);
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(17797);
      return 0;
    }
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(str);
    if (!localb.exists())
    {
      AppMethodBeat.o(17797);
      return 0;
    }
    int i = (int)localb.length();
    int j = i.a(new i.a(str, paramgx, paramLinkedList, 9, false, null));
    parambi = d(parambi, i);
    if (parambi == null)
    {
      AppMethodBeat.o(17797);
      return 0;
    }
    paramgx.woR = new bwc().aoF(parambi);
    j += parambi.length();
    if (i == 0)
    {
      AppMethodBeat.o(17797);
      return j;
    }
    AppMethodBeat.o(17797);
    return j;
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17798);
    Object localObject = paramgx.woR.xJE;
    paramString = (String)localObject;
    int i;
    if (d.lA(paramgx.woP.xJE))
    {
      i = d.pt((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        ab.v("MicroMsg.BakOldItemVoice", "chatroom voicemsg, new content=".concat(String.valueOf(paramString)));
      }
    }
    else
    {
      paramString = br.F(paramString, "msg");
      if (paramString == null) {
        break label317;
      }
    }
    try
    {
      i = a.bE((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      if (a.bE((String)paramString.get(".msg.voicemsg.$isPlayed"), 1) != 1) {
        break label286;
      }
      bool = true;
      label127:
      parambi.setContent(p.d((String)localObject, i, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label141:
        ab.e("MicroMsg.BakOldItemVoice", "parsing voice msg xml failed");
        ab.printErrStackTrace("MicroMsg.BakOldItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = w.vV(paramgx.woP.xJE);
    parambi.kk(paramString);
    d.l(parambi);
    paramString = d.Gu(paramString);
    if (paramgx.wts == 9)
    {
      parambi = paramgx.wtq.getBuffer().pW;
      if (g(this.jDw, parambi))
      {
        localObject = new byte[parambi.length - 6];
        System.arraycopy(parambi, 6, localObject, 0, parambi.length - 6);
        paramgx.wtr = (parambi.length - 6);
        paramgx.wtq = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
      }
    }
    for (;;)
    {
      if (paramString != null) {
        break label528;
      }
      AppMethodBeat.o(17798);
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
      ab.e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramgx.woR.xJE });
      parambi.setContent(paramgx.woR.xJE);
      break label141;
      if (g(this.jDx, parambi))
      {
        localObject = new byte[parambi.length - 6];
        System.arraycopy(parambi, 6, localObject, 0, parambi.length - 6);
        paramgx.wtr = (parambi.length - 6);
        paramgx.wtq = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
      }
      else
      {
        parambi = a.a(paramgx, 9);
        if (!bo.isNullOrNil(parambi))
        {
          parambi = a.Gw(parambi);
          if (e.cN(parambi))
          {
            localObject = e.i(parambi, 0, 9);
            if (g(this.jDw, (byte[])localObject))
            {
              localObject = e.i(parambi, 6, -1);
              e.deleteFile(parambi);
              e.b(parambi, (byte[])localObject, localObject.length);
            }
            else if (g(this.jDx, (byte[])localObject))
            {
              localObject = e.i(parambi, 6, -1);
              e.deleteFile(parambi);
              e.b(parambi, (byte[])localObject, localObject.length);
            }
          }
        }
      }
    }
    label528:
    if (a.b(paramgx, 9, paramString))
    {
      AppMethodBeat.o(17798);
      return 0;
    }
    paramgx = a.a(paramgx, 9);
    if (paramgx != null)
    {
      paramgx = a.Gw(paramgx);
      ab.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard".concat(String.valueOf(paramgx)));
      e.C(paramgx, paramString);
    }
    AppMethodBeat.o(17798);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.h
 * JD-Core Version:    0.7.0.1
 */