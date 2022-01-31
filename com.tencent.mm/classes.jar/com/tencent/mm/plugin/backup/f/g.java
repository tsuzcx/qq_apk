package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.b;
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
  byte[] jDw;
  byte[] jDx;
  
  public g()
  {
    AppMethodBeat.i(17462);
    this.jDw = new byte[] { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
    this.jDx = new byte[] { 35, 33, 65, 77, 82, 10, 35, 33 };
    AppMethodBeat.o(17462);
  }
  
  private static String d(bi parambi, int paramInt)
  {
    AppMethodBeat.i(17466);
    if (bo.isNullOrNil(parambi.field_content))
    {
      AppMethodBeat.o(17466);
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
        if (c.lA(parambi.field_talker)) {
          localObject1 = localp.fXq + ":\n" + (String)localObject2;
        }
        ab.i("MicroMsg.BackupItemVoice", "parseContent xml:%s", new Object[] { localObject1 });
        AppMethodBeat.o(17466);
        return localObject1;
      }
      return null;
    }
    catch (Exception parambi)
    {
      ab.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + parambi.toString());
      AppMethodBeat.o(17466);
    }
  }
  
  private static boolean g(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(17465);
    if (bo.ce(paramArrayOfByte2))
    {
      AppMethodBeat.o(17465);
      return false;
    }
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
      {
        AppMethodBeat.o(17465);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(17465);
    return true;
  }
  
  public final int a(gx paramgx, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(17463);
    paramString = c.Gu(parambi.field_imgPath);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(17463);
      return 0;
    }
    paramHashMap = new b(paramString);
    if (!paramHashMap.exists())
    {
      AppMethodBeat.o(17463);
      return 0;
    }
    int i = (int)paramHashMap.length();
    if (paramBoolean1)
    {
      AppMethodBeat.o(17463);
      return i;
    }
    int j = i.a(new i.a(paramString, paramgx, paramLinkedList, 9, paramBoolean2, paramBoolean2, null));
    parambi = d(parambi, i);
    if (parambi == null)
    {
      AppMethodBeat.o(17463);
      return 0;
    }
    paramgx.woR = new bwc().aoF(parambi);
    j += parambi.length();
    if (i == 0)
    {
      AppMethodBeat.o(17463);
      return j;
    }
    AppMethodBeat.o(17463);
    return j;
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17464);
    Object localObject = paramgx.woR.xJE;
    paramString = (String)localObject;
    int i;
    if (c.lA(paramgx.woP.xJE))
    {
      i = c.pt((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        ab.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", new Object[] { paramString });
      }
    }
    else
    {
      paramString = br.F(paramString, "msg");
      if (paramString == null) {
        break label335;
      }
    }
    try
    {
      i = com.tencent.mm.plugin.backup.b.g.bE((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      int j = com.tencent.mm.plugin.backup.b.g.bE((String)paramString.get(".msg.voicemsg.$isPlayed"), 1);
      long l = i;
      if (j != 1) {
        break label304;
      }
      bool = true;
      label137:
      parambi.setContent(p.d((String)localObject, l, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label150:
        ab.e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
        ab.printErrStackTrace("MicroMsg.BackupItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = w.vV(paramgx.woP.xJE);
    parambi.kk(paramString);
    c.l(parambi);
    paramString = c.Gu(paramString);
    parambi = com.tencent.mm.plugin.backup.b.g.a(paramgx, 9);
    if (!bo.isNullOrNil(parambi))
    {
      parambi = com.tencent.mm.plugin.backup.b.g.Gh(parambi) + parambi;
      if (e.cN(parambi))
      {
        localObject = e.i(parambi, 0, 9);
        if (!g(this.jDw, (byte[])localObject)) {
          break label371;
        }
        localObject = e.i(parambi, 6, -1);
        e.deleteFile(parambi);
        e.b(parambi, (byte[])localObject, localObject.length);
      }
    }
    for (;;)
    {
      if (paramString != null) {
        break label410;
      }
      AppMethodBeat.o(17464);
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
      ab.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramgx.woR.xJE });
      parambi.setContent(paramgx.woR.xJE);
      break label150;
      label371:
      if (g(this.jDx, (byte[])localObject))
      {
        localObject = e.i(parambi, 6, -1);
        e.deleteFile(parambi);
        e.b(parambi, (byte[])localObject, localObject.length);
      }
    }
    label410:
    if (com.tencent.mm.plugin.backup.b.g.b(paramgx, 9, paramString))
    {
      AppMethodBeat.o(17464);
      return 0;
    }
    paramgx = com.tencent.mm.plugin.backup.b.g.a(paramgx, 9);
    if (paramgx != null)
    {
      paramgx = com.tencent.mm.plugin.backup.b.g.Gh(paramgx) + paramgx;
      ab.d("MicroMsg.BackupItemVoice", "recover from path:%s", new Object[] { paramgx });
      e.C(paramgx, paramString);
    }
    AppMethodBeat.o(17464);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.g
 * JD-Core Version:    0.7.0.1
 */