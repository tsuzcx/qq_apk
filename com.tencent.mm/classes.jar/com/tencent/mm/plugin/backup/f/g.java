package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
  byte[] hJT = { 35, 33, 65, 77, 82, 10, 2, 35, 33 };
  byte[] hJU = { 35, 33, 65, 77, 82, 10, 35, 33 };
  
  private static String d(bi parambi, int paramInt)
  {
    if (bk.bl(parambi.field_content)) {
      return null;
    }
    n localn = new n(parambi.field_content);
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
      localXmlSerializer.attribute(null, "voicelength", localn.time);
      if (!bk.bl(localn.eHA)) {
        localXmlSerializer.attribute(null, "fromusername", localn.eHA);
      }
      if (localn.eHB) {}
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
        if (c.fn(parambi.field_talker)) {
          localObject1 = localn.eHA + ":\n" + (String)localObject2;
        }
        y.i("MicroMsg.BackupItemVoice", "parseContent xml:%s", new Object[] { localObject1 });
        return localObject1;
      }
      return null;
    }
    catch (Exception parambi)
    {
      y.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + parambi.toString());
    }
  }
  
  private static boolean d(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (bk.bE(paramArrayOfByte2)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte1.length) {
        break label33;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label33:
    return true;
  }
  
  public final int a(fo paramfo, boolean paramBoolean1, bi parambi, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    paramString = c.xB(parambi.field_imgPath);
    int i;
    if (bk.bl(paramString)) {
      i = 0;
    }
    int k;
    int j;
    do
    {
      return i;
      paramHashMap = new b(paramString);
      if (!paramHashMap.exists()) {
        return 0;
      }
      k = (int)paramHashMap.length();
      if (paramBoolean1) {
        return k;
      }
      i = i.a(new i.a(paramString, paramfo, paramLinkedList, 9, paramBoolean2, paramBoolean2, null));
      parambi = d(parambi, k);
      if (parambi == null) {
        return 0;
      }
      paramfo.svH = new bml().YI(parambi);
      j = i + parambi.length();
      i = j;
    } while (k != 0);
    return j;
  }
  
  public final int a(String paramString, fo paramfo, bi parambi)
  {
    Object localObject = paramfo.svH.tFO;
    paramString = (String)localObject;
    int i;
    if (c.fn(paramfo.svF.tFO))
    {
      i = c.iH((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        y.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", new Object[] { paramString });
      }
    }
    else
    {
      paramString = bn.s(paramString, "msg");
      if (paramString == null) {
        break label322;
      }
    }
    try
    {
      i = com.tencent.mm.plugin.backup.b.g.be((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      int j = com.tencent.mm.plugin.backup.b.g.be((String)paramString.get(".msg.voicemsg.$isPlayed"), 1);
      long l = i;
      if (j != 1) {
        break label291;
      }
      bool = true;
      label130:
      parambi.setContent(n.d((String)localObject, l, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label143:
        y.e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
        y.printErrStackTrace("MicroMsg.BackupItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = com.tencent.mm.modelvoice.u.oI(paramfo.svF.tFO);
    parambi.ed(paramString);
    c.h(parambi);
    paramString = c.xB(paramString);
    parambi = com.tencent.mm.plugin.backup.b.g.a(paramfo, 9);
    if (!bk.bl(parambi))
    {
      parambi = com.tencent.mm.plugin.backup.b.g.xp(parambi) + parambi;
      if (e.bK(parambi))
      {
        localObject = e.c(parambi, 0, 9);
        if (!d(this.hJT, (byte[])localObject)) {
          break label358;
        }
        localObject = e.c(parambi, 6, -1);
        e.deleteFile(parambi);
        e.b(parambi, (byte[])localObject, localObject.length);
      }
    }
    label257:
    if (paramString == null) {}
    label291:
    label322:
    label358:
    do
    {
      do
      {
        return 0;
        paramString = (String)localObject;
        if (i + 2 >= ((String)localObject).length()) {
          break;
        }
        paramString = ((String)localObject).substring(i + 2);
        break;
        bool = false;
        break label130;
        y.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramfo.svH.tFO });
        parambi.setContent(paramfo.svH.tFO);
        break label143;
        if (!d(this.hJU, (byte[])localObject)) {
          break label257;
        }
        localObject = e.c(parambi, 6, -1);
        e.deleteFile(parambi);
        e.b(parambi, (byte[])localObject, localObject.length);
        break label257;
      } while (com.tencent.mm.plugin.backup.b.g.b(paramfo, 9, paramString));
      paramfo = com.tencent.mm.plugin.backup.b.g.a(paramfo, 9);
    } while (paramfo == null);
    paramfo = com.tencent.mm.plugin.backup.b.g.xp(paramfo) + paramfo;
    y.d("MicroMsg.BackupItemVoice", "recover from path:%s", new Object[] { paramfo });
    e.r(paramfo, paramString);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.g
 * JD-Core Version:    0.7.0.1
 */