package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
        if (d.fn(parambi.field_talker)) {
          localObject1 = localn.eHA + ":\n" + (String)localObject2;
        }
        y.i("MicroMsg.BakOldItemVoice", "parseContent xml:" + (String)localObject1);
        return localObject1;
      }
      return null;
    }
    catch (Exception parambi)
    {
      y.e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + parambi.toString());
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
  
  public final int a(fo paramfo, bi parambi, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    int j = 0;
    String str = d.xB(parambi.field_imgPath);
    int i;
    if (bk.bl(str)) {
      i = j;
    }
    int k;
    do
    {
      int m;
      do
      {
        com.tencent.mm.vfs.b localb;
        do
        {
          return i;
          localb = new com.tencent.mm.vfs.b(str);
          i = j;
        } while (!localb.exists());
        k = (int)localb.length();
        m = i.a(new i.a(str, paramfo, paramLinkedList, 9, false, null));
        parambi = d(parambi, k);
        i = j;
      } while (parambi == null);
      paramfo.svH = new bml().YI(parambi);
      j = m + parambi.length();
      i = j;
    } while (k != 0);
    return j;
  }
  
  public final int a(String paramString, fo paramfo, bi parambi)
  {
    Object localObject = paramfo.svH.tFO;
    paramString = (String)localObject;
    int i;
    if (d.fn(paramfo.svF.tFO))
    {
      i = d.iH((String)localObject);
      if (i == -1)
      {
        paramString = (String)localObject;
        y.v("MicroMsg.BakOldItemVoice", "chatroom voicemsg, new content=" + paramString);
      }
    }
    else
    {
      paramString = bn.s(paramString, "msg");
      if (paramString == null) {
        break label311;
      }
    }
    try
    {
      i = a.be((String)paramString.get(".msg.voicemsg.$voicelength"), 0);
      localObject = (String)paramString.get(".msg.voicemsg.$fromusername");
      if (a.be((String)paramString.get(".msg.voicemsg.$isPlayed"), 1) != 1) {
        break label280;
      }
      bool = true;
      label127:
      parambi.setContent(n.d((String)localObject, i, bool));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool;
        label141:
        y.e("MicroMsg.BakOldItemVoice", "parsing voice msg xml failed");
        y.printErrStackTrace("MicroMsg.BakOldItemVoice", paramString, "", new Object[0]);
      }
    }
    paramString = com.tencent.mm.modelvoice.u.oI(paramfo.svF.tFO);
    parambi.ed(paramString);
    d.h(parambi);
    paramString = d.xB(paramString);
    if (paramfo.szr == 9)
    {
      parambi = paramfo.szp.tFM.oY;
      if (d(this.hJT, parambi))
      {
        localObject = new byte[parambi.length - 6];
        System.arraycopy(parambi, 6, localObject, 0, parambi.length - 6);
        paramfo.szq = (parambi.length - 6);
        paramfo.szp = new bmk().bs((byte[])localObject);
        label246:
        if (paramString != null) {
          break label522;
        }
      }
    }
    label280:
    label311:
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
        break label127;
        y.e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", new Object[] { paramfo.svH.tFO });
        parambi.setContent(paramfo.svH.tFO);
        break label141;
        if (d(this.hJU, parambi))
        {
          localObject = new byte[parambi.length - 6];
          System.arraycopy(parambi, 6, localObject, 0, parambi.length - 6);
          paramfo.szq = (parambi.length - 6);
          paramfo.szp = new bmk().bs((byte[])localObject);
          break label246;
        }
        parambi = a.a(paramfo, 9);
        if (bk.bl(parambi)) {
          break label246;
        }
        parambi = a.xD(parambi);
        if (!e.bK(parambi)) {
          break label246;
        }
        localObject = e.c(parambi, 0, 9);
        if (d(this.hJT, (byte[])localObject))
        {
          localObject = e.c(parambi, 6, -1);
          e.deleteFile(parambi);
          e.b(parambi, (byte[])localObject, localObject.length);
          break label246;
        }
        if (!d(this.hJU, (byte[])localObject)) {
          break label246;
        }
        localObject = e.c(parambi, 6, -1);
        e.deleteFile(parambi);
        e.b(parambi, (byte[])localObject, localObject.length);
        break label246;
      } while (a.b(paramfo, 9, paramString));
      paramfo = a.a(paramfo, 9);
    } while (paramfo == null);
    label522:
    paramfo = a.xD(paramfo);
    y.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard" + paramfo);
    e.r(paramfo, paramString);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.h
 * JD-Core Version:    0.7.0.1
 */