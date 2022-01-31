package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Long;Lcom.tencent.mm.plugin.backup.f.h.a;>;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class d
  implements l
{
  private static String a(com.tencent.mm.as.e parame, bi parambi)
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer;
    try
    {
      localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (com.tencent.mm.plugin.backup.h.c.fn(parambi.field_talker)) {
        localStringWriter.write(bd.iI(parambi.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = bn.s(parame.enA, "msg");
      if (localMap != null)
      {
        if (localMap.get(".msg.img.$aeskey") == null) {
          localXmlSerializer.attribute(null, "aeskey", "");
        }
        if (localMap.get(".msg.img.$encryver") == null) {
          localXmlSerializer.attribute(null, "encryver", "");
        }
        if (localMap.get(".msg.img.$cdnthumbaeskey") == null) {
          localXmlSerializer.attribute(null, "cdnthumbaeskey", "");
        }
        if (localMap.get(".msg.img.$cdnthumburl") == null) {
          localXmlSerializer.attribute(null, "cdnthumburl", "");
        }
        if (localMap.get(".msg.img.$cdnthumblength") == null) {
          localXmlSerializer.attribute(null, "cdnthumblength", "10240");
        }
        if (localMap.get(".msg.img.$cdnthumbheight") == null) {
          localXmlSerializer.attribute(null, "cdnthumbheight", "0");
        }
        if (localMap.get(".msg.img.$cdnthumbwidth") == null) {
          localXmlSerializer.attribute(null, "cdnthumbwidth", "0");
        }
        if (localMap.get(".msg.img.$cdnmidheight") == null) {
          localXmlSerializer.attribute(null, "cdnmidheight", "0");
        }
        if (localMap.get(".msg.img.$cdnmidwidth") == null) {
          localXmlSerializer.attribute(null, "cdnmidwidth", "0");
        }
        if (localMap.get(".msg.img.$cdnhdheight") == null) {
          localXmlSerializer.attribute(null, "cdnhdheight", "0");
        }
        if (localMap.get(".msg.img.$cdnhdwidth") == null) {
          localXmlSerializer.attribute(null, "cdnhdwidth", "0");
        }
        if (localMap.get(".msg.img.$cdnmidimgurl") == null) {
          localXmlSerializer.attribute(null, "cdnmidimgurl", "");
        }
        if (bk.getLong((String)localMap.get(".msg.img.$length"), 0L) == 0L) {
          localXmlSerializer.attribute(null, "length", com.tencent.mm.vfs.e.aeQ(com.tencent.mm.plugin.backup.h.d.avi().avj().avf().o(parame.enq, "", "")));
        }
        if ((parambi.field_isSend != 1) || (parame.ent == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", bk.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localMap.remove(".msg.img.$cdnbigimgurl");
        localMap.remove(".msg.img.$hdlength");
        if (localMap.get(".msg.img.$md5") == null) {
          localXmlSerializer.attribute(null, "md5", "");
        }
        parame = localMap.keySet().iterator();
        while (parame.hasNext())
        {
          parambi = (String)parame.next();
          if (parambi.startsWith(".msg.img.$")) {
            localXmlSerializer.attribute(null, parambi.substring(10), (String)localMap.get(parambi));
          }
        }
      }
      localXmlSerializer.endTag(null, "img");
    }
    catch (Exception parame)
    {
      y.e("MicroMsg.BackupItemImg", "packetImg xml error: " + parame.toString());
      return null;
    }
    localXmlSerializer.endTag(null, "msg");
    localXmlSerializer.endDocument();
    localStringWriter.flush();
    localStringWriter.close();
    parame = localStringWriter.getBuffer().toString();
    y.d("MicroMsg.BackupItemImg", "parseContent xml:%s", new Object[] { parame });
    return parame;
  }
  
  public final int a(fo paramfo, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    int j;
    if (bk.bl(parambi.field_content))
    {
      j = 0;
      if (parambi.field_isSend == 1)
      {
        paramString = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().bY(parambi.field_msgId);
        if (paramString.enp != 0L) {
          break label944;
        }
      }
      paramString = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().bX(parambi.field_msgSvrId);
    }
    label556:
    label944:
    for (;;)
    {
      paramHashMap = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().F(parambi.field_imgPath, true);
      int i = j;
      if (com.tencent.mm.vfs.e.bK(paramHashMap)) {
        i = j + i.a(new i.a(paramHashMap, paramfo, paramLinkedList, 1, paramBoolean1, "_thumb", paramBoolean2));
      }
      Object localObject1;
      int k;
      if (parambi.field_isSend == 1)
      {
        localObject2 = "";
        str = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().o(paramString.enq, "", "");
        localObject1 = localObject2;
        k = i;
        paramHashMap = paramString;
        if (paramString.Or())
        {
          paramHashMap = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().iH(paramString.enz);
          if (paramHashMap == null) {
            break label462;
          }
          localObject1 = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().o(paramHashMap.enq, "", "");
          y.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + (String)localObject1 + " " + com.tencent.mm.vfs.e.aeQ((String)localObject1));
          com.tencent.mm.vfs.e.aeQ((String)localObject1);
          if (com.tencent.mm.vfs.e.bK((String)localObject1)) {
            k = i + i.a(new i.a((String)localObject1, paramfo, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
          }
        }
        else
        {
          label305:
          com.tencent.mm.vfs.e.aeQ(str);
          j = k;
          localObject2 = paramHashMap;
          if (!bk.bl(str))
          {
            j = k;
            localObject2 = paramHashMap;
            if (!str.equals(localObject1))
            {
              y.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.e.aeQ(str));
              j = k + i.a(new i.a(str, paramfo, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
              localObject2 = paramHashMap;
            }
          }
        }
      }
      label462:
      do
      {
        parambi = a((com.tencent.mm.as.e)localObject2, parambi);
        if (parambi != null) {
          break label921;
        }
        return j;
        j = parambi.field_content.getBytes().length;
        break;
        y.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { localObject1 });
        k = i;
        break label305;
        y.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
        localObject1 = localObject2;
        k = i;
        break label305;
        j = i;
        localObject2 = paramString;
      } while (!paramString.Oq());
      String str = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().o(paramString.enq, "", "");
      Object localObject2 = "";
      if (paramString.Or())
      {
        localObject1 = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().iH(paramString.enz);
        if (localObject1 != null)
        {
          if (localObject1 != null) {
            y.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", new Object[] { Integer.valueOf(((com.tencent.mm.as.e)localObject1).offset), Integer.valueOf(((com.tencent.mm.as.e)localObject1).ebK), Integer.valueOf(((com.tencent.mm.as.e)localObject1).ent), ((com.tencent.mm.as.e)localObject1).enq });
          }
          paramHashMap = (HashMap<Long, h.a>)localObject2;
          k = i;
          if (localObject1 != null)
          {
            paramHashMap = (HashMap<Long, h.a>)localObject2;
            k = i;
            if (((com.tencent.mm.as.e)localObject1).ent == 1)
            {
              if ((localObject1.equals(paramString)) || (((com.tencent.mm.as.e)localObject1).offset != ((com.tencent.mm.as.e)localObject1).ebK)) {
                break label902;
              }
              localObject1 = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().o(((com.tencent.mm.as.e)localObject1).enq, "", "");
              y.d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject1, Long.valueOf(com.tencent.mm.vfs.e.aeQ((String)localObject1)) });
              paramHashMap = (HashMap<Long, h.a>)localObject1;
              k = i;
              if (com.tencent.mm.vfs.e.bK((String)localObject1))
              {
                k = i + i.a(new i.a((String)localObject1, paramfo, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
                com.tencent.mm.vfs.e.aeQ((String)localObject1);
                paramHashMap = (HashMap<Long, h.a>)localObject1;
              }
            }
          }
        }
      }
      for (;;)
      {
        j = k;
        localObject2 = paramString;
        if (!com.tencent.mm.vfs.e.bK(str)) {
          break;
        }
        com.tencent.mm.vfs.e.aeQ(str);
        j = k;
        localObject2 = paramString;
        if (bk.bl(str)) {
          break;
        }
        j = k;
        localObject2 = paramString;
        if (str.equals(paramHashMap)) {
          break;
        }
        y.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.e.aeQ(str));
        j = k + i.a(new i.a(str, paramfo, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
        localObject2 = paramString;
        break;
        localObject1 = null;
        break label556;
        localObject1.equals(paramString);
        paramHashMap = (HashMap<Long, h.a>)localObject2;
        k = i;
      }
      paramfo.svH = new bml().YI(parambi);
      return j + parambi.length();
    }
  }
  
  public final int a(String paramString, fo paramfo, bi parambi)
  {
    if ((paramfo == null) || (paramfo.svH == null))
    {
      y.e("MicroMsg.BackupItemImg", "recover bakitem or bakitem content is null");
      return 0;
    }
    String str1 = new String(bk.aM(paramfo.svH.tFO, ""));
    y.d("MicroMsg.BackupItemImg", "recover msg:" + paramfo.ndp + " " + str1);
    int i;
    int j;
    label104:
    Object localObject1;
    label115:
    com.tencent.mm.as.g localg;
    if (paramfo.szp == null)
    {
      i = 0;
      j = paramfo.szr;
      if (paramfo.szo != null) {
        break label586;
      }
      paramString = "";
      if (paramfo.szn != null) {
        break label597;
      }
      localObject1 = "";
      y.d("MicroMsg.BackupItemImg", "recover backupItemImg:, buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      parambi.setContent(str1);
      localg = com.tencent.mm.plugin.backup.h.d.avi().avj().avf();
      if (parambi.field_isSend != 1) {
        break label609;
      }
      if (parambi.field_msgId != 0L) {
        paramString = localg.bY(parambi.field_msgId);
      }
      if ((paramString != null) && (paramString.enp != 0L)) {
        break label1183;
      }
      paramString = localg.bX(parambi.field_msgSvrId);
    }
    label1167:
    label1183:
    for (;;)
    {
      label221:
      localObject1 = bn.s(str1, "msg");
      long l1 = 0L;
      long l2;
      if (localObject1 != null)
      {
        l2 = bk.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L);
        l1 = l2;
        if (l2 > 0L) {
          i = 1;
        }
      }
      for (;;)
      {
        Object localObject3 = bk.aM(com.tencent.mm.plugin.backup.b.g.a(paramfo, 3), "");
        if ((paramfo.szr == 3) && (paramfo.szp != null)) {
          com.tencent.mm.plugin.backup.b.g.b(com.tencent.mm.plugin.backup.b.g.xp((String)localObject3), (String)localObject3, paramfo.szp.tFM.oY);
        }
        localObject1 = bk.aM(com.tencent.mm.plugin.backup.b.g.a(paramfo, 2), "");
        if ((paramfo.szr == 2) && (paramfo.szp != null)) {
          com.tencent.mm.plugin.backup.b.g.b(com.tencent.mm.plugin.backup.b.g.xp((String)localObject1), (String)localObject1, paramfo.szp.tFM.oY);
        }
        y.d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (bk.bl((String)localObject1))
        {
          y.e("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          Object localObject2 = com.tencent.mm.plugin.backup.b.g.b(paramfo, 1);
          Object localObject4;
          if (localObject2 == null)
          {
            y.i("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = com.tencent.mm.plugin.backup.b.g.xp((String)localObject1) + (String)localObject1;
            str2 = com.tencent.mm.a.g.o((bk.UY() + " ").getBytes());
            localObject4 = com.tencent.mm.plugin.backup.b.g.xp(str2);
            str3 = (String)localObject4 + str2;
            localObject4 = new File((String)localObject4);
            if (!((File)localObject4).exists()) {
              ((File)localObject4).mkdirs();
            }
            j = aa.Zk(str3);
            if (j > 0)
            {
              if (aa.a((String)localObject2, Bitmap.CompressFormat.JPEG, str3, j)) {
                break label674;
              }
              y.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
              return -1;
              i = paramfo.szp.tFK;
              break;
              label586:
              paramString = paramfo.szo.toString();
              break label104;
              label597:
              localObject1 = paramfo.szn.toString();
              break label115;
              label609:
              paramString = localg.bX(parambi.field_msgSvrId);
              break label221;
            }
            if (!com.tencent.mm.sdk.platformtools.c.a((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str3))
            {
              y.e("MicroMsg.BackupItemImg", "createThumbNail failed");
              return -1;
            }
            y.d("MicroMsg.BackupItemImg", "insert: thumbName = " + str2);
            label674:
            localObject2 = com.tencent.mm.vfs.e.c(str3, 0, -1);
          }
          while (localObject2 == null)
          {
            y.e("MicroMsg.BackupItemImg", "img buf is null");
            return -1;
            y.i("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          }
          String str2 = localg.o((String)localObject3, "", "");
          String str3 = localg.o((String)localObject1, "", "");
          l1 = 0L;
          long l3;
          if (paramString.enp == 0L)
          {
            j = com.tencent.mm.plugin.backup.b.g.c(paramfo, 2);
            if (i != 0)
            {
              i = com.tencent.mm.plugin.backup.b.g.c(paramfo, 3);
              l3 = localg.a((byte[])localObject2, paramfo.ndp, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              l1 = l3;
              if (!com.tencent.mm.plugin.backup.b.g.b(paramfo, 3, str2))
              {
                y.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[] { str2 });
                l1 = l3;
                if (j == l2) {
                  if (com.tencent.mm.plugin.backup.b.g.b(paramfo, 3, str3))
                  {
                    y.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[] { str3 });
                    l1 = l3;
                    i = 0;
                    if (j > 0) {
                      break label1167;
                    }
                    j = com.tencent.mm.plugin.backup.b.g.c(paramfo, 3);
                  }
                }
              }
            }
          }
          for (;;)
          {
            paramString = new PString();
            localObject3 = new PInt();
            localObject4 = new PInt();
            l2 = localg.a((byte[])localObject2, paramfo.ndp, false, (String)localObject1, j, str1, paramString, (PInt)localObject3, (PInt)localObject4);
            if ((i != 0) && (!com.tencent.mm.plugin.backup.b.g.b(paramfo, 2, str3))) {
              y.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[] { str2 });
            }
            if (l2 > 0L)
            {
              parambi.ed(paramString.value);
              parambi.fK(((PInt)localObject3).value);
              parambi.fL(((PInt)localObject4).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.h.d.avi().avj().avf().b(Long.valueOf(l2));
                paramString.iD((int)l1);
                com.tencent.mm.plugin.backup.h.d.avi().avj().avf().a(Long.valueOf(l2), paramString);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.backup.h.c.h(parambi);
              return 0;
              y.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[] { str3 });
              l1 = l3;
              i = 1;
              break;
              return -1;
              paramfo = paramString.ens;
              if ((paramfo != null) && (paramfo.startsWith("THUMBNAIL_DIRPATH://"))) {
                parambi.ed(paramfo);
              } else {
                parambi.ed("THUMBNAIL://" + paramString.enp);
              }
            }
          }
        }
        i = 0;
        l2 = l1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.d
 * JD-Core Version:    0.7.0.1
 */