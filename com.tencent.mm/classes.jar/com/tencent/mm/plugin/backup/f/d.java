package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.e;
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
  private static String a(com.tencent.mm.aw.g paramg, bu parambu)
  {
    AppMethodBeat.i(21514);
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer;
    try
    {
      localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (c.vF(parambu.field_talker)) {
        localStringWriter.write(bj.Bk(parambu.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = bw.M(paramg.hZI, "msg");
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
        if (bt.getLong((String)localMap.get(".msg.img.$length"), 0L) == 0L) {
          localXmlSerializer.attribute(null, "length", com.tencent.mm.vfs.i.aYo(com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().o(paramg.hZw, "", "")));
        }
        if ((parambu.field_isSend != 1) || (paramg.hZz == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", bt.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localMap.remove(".msg.img.$cdnbigimgurl");
        localMap.remove(".msg.img.$hdlength");
        if (localMap.get(".msg.img.$md5") == null) {
          localXmlSerializer.attribute(null, "md5", "");
        }
        paramg = localMap.keySet().iterator();
        while (paramg.hasNext())
        {
          parambu = (String)paramg.next();
          if (parambu.startsWith(".msg.img.$")) {
            localXmlSerializer.attribute(null, parambu.substring(10), (String)localMap.get(parambu));
          }
        }
      }
      localXmlSerializer.endTag(null, "img");
    }
    catch (Exception paramg)
    {
      ad.e("MicroMsg.BackupItemImg", "packetImg xml error: " + paramg.toString());
      AppMethodBeat.o(21514);
      return null;
    }
    localXmlSerializer.endTag(null, "msg");
    localXmlSerializer.endDocument();
    localStringWriter.flush();
    localStringWriter.close();
    paramg = localStringWriter.getBuffer().toString();
    ad.d("MicroMsg.BackupItemImg", "parseContent xml:%s", new Object[] { paramg });
    AppMethodBeat.o(21514);
    return paramg;
  }
  
  public final int a(if paramif, boolean paramBoolean1, bu parambu, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21513);
    int j;
    if (bt.isNullOrNil(parambu.field_content))
    {
      j = 0;
      if (parambu.field_isSend == 1)
      {
        paramString = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().G(parambu.field_talker, parambu.field_msgId);
        if (paramString.dnz != 0L) {
          break label989;
        }
      }
      paramString = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().F(parambu.field_talker, parambu.field_msgSvrId);
    }
    label320:
    label580:
    label989:
    for (;;)
    {
      paramHashMap = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().R(parambu.field_imgPath, true);
      int i = j;
      if (com.tencent.mm.vfs.i.fv(paramHashMap)) {
        i = j + i.a(new i.a(paramHashMap, paramif, paramLinkedList, 1, paramBoolean1, "_thumb", paramBoolean2));
      }
      Object localObject1;
      int k;
      if (parambu.field_isSend == 1)
      {
        localObject2 = "";
        str = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().o(paramString.hZw, "", "");
        localObject1 = localObject2;
        k = i;
        paramHashMap = paramString;
        if (paramString.aIj())
        {
          paramHashMap = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().pt(paramString.hZH);
          if (paramHashMap == null) {
            break label485;
          }
          localObject1 = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().o(paramHashMap.hZw, "", "");
          ad.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + (String)localObject1 + " " + com.tencent.mm.vfs.i.aYo((String)localObject1));
          com.tencent.mm.vfs.i.aYo((String)localObject1);
          if (com.tencent.mm.vfs.i.fv((String)localObject1)) {
            k = i + i.a(new i.a((String)localObject1, paramif, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
          }
        }
        else
        {
          com.tencent.mm.vfs.i.aYo(str);
          j = k;
          localObject2 = paramHashMap;
          if (!bt.isNullOrNil(str))
          {
            j = k;
            localObject2 = paramHashMap;
            if (!str.equals(localObject1))
            {
              ad.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.i.aYo(str));
              j = k + i.a(new i.a(str, paramif, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
              localObject2 = paramHashMap;
            }
          }
        }
      }
      label485:
      do
      {
        parambu = a((com.tencent.mm.aw.g)localObject2, parambu);
        if (parambu != null) {
          break label956;
        }
        AppMethodBeat.o(21513);
        return j;
        j = parambu.field_content.getBytes().length;
        break;
        ad.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { localObject1 });
        k = i;
        break label320;
        ad.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
        localObject1 = localObject2;
        k = i;
        break label320;
        j = i;
        localObject2 = paramString;
      } while (!paramString.aIi());
      String str = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().o(paramString.hZw, "", "");
      Object localObject2 = "";
      if (paramString.aIj())
      {
        localObject1 = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().pt(paramString.hZH);
        if (localObject1 != null)
        {
          if (localObject1 != null) {
            ad.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", new Object[] { Integer.valueOf(((com.tencent.mm.aw.g)localObject1).offset), Integer.valueOf(((com.tencent.mm.aw.g)localObject1).hMP), Integer.valueOf(((com.tencent.mm.aw.g)localObject1).hZz), ((com.tencent.mm.aw.g)localObject1).hZw });
          }
          paramHashMap = (HashMap<Long, h.a>)localObject2;
          k = i;
          if (localObject1 != null)
          {
            paramHashMap = (HashMap<Long, h.a>)localObject2;
            k = i;
            if (((com.tencent.mm.aw.g)localObject1).hZz == 1)
            {
              if ((localObject1.equals(paramString)) || (((com.tencent.mm.aw.g)localObject1).hMP <= 0) || (((com.tencent.mm.aw.g)localObject1).offset != ((com.tencent.mm.aw.g)localObject1).hMP)) {
                break label937;
              }
              localObject1 = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().o(((com.tencent.mm.aw.g)localObject1).hZw, "", "");
              ad.d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject1, Long.valueOf(com.tencent.mm.vfs.i.aYo((String)localObject1)) });
              paramHashMap = (HashMap<Long, h.a>)localObject1;
              k = i;
              if (com.tencent.mm.vfs.i.fv((String)localObject1))
              {
                k = i + i.a(new i.a((String)localObject1, paramif, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
                com.tencent.mm.vfs.i.aYo((String)localObject1);
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
        if (!com.tencent.mm.vfs.i.fv(str)) {
          break;
        }
        com.tencent.mm.vfs.i.aYo(str);
        j = k;
        localObject2 = paramString;
        if (bt.isNullOrNil(str)) {
          break;
        }
        j = k;
        localObject2 = paramString;
        if (str.equals(paramHashMap)) {
          break;
        }
        ad.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.i.aYo(str));
        j = k + i.a(new i.a(str, paramif, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
        localObject2 = paramString;
        break;
        localObject1 = null;
        break label580;
        localObject1.equals(paramString);
        paramHashMap = (HashMap<Long, h.a>)localObject2;
        k = i;
      }
      paramif.Fvk = new cwt().aPy(parambu);
      i = parambu.length();
      AppMethodBeat.o(21513);
      return j + i;
    }
  }
  
  public final int a(String paramString, if paramif, bu parambu)
  {
    AppMethodBeat.i(21515);
    if ((paramif == null) || (paramif.Fvk == null))
    {
      ad.e("MicroMsg.BackupItemImg", "recover bakitem/Content is null");
      AppMethodBeat.o(21515);
      return 0;
    }
    String str1 = bt.bI(paramif.Fvk.HoB, "");
    long l1 = paramif.xbt;
    int i;
    int j;
    label80:
    Object localObject1;
    label91:
    com.tencent.mm.aw.i locali;
    if (paramif.FAN == null)
    {
      i = 0;
      j = paramif.FAP;
      if (paramif.FAM != null) {
        break label598;
      }
      paramString = "";
      if (paramif.FAL != null) {
        break label609;
      }
      localObject1 = "";
      ad.d("MicroMsg.BackupItemImg", "recover, msgId:%d, content:%s, backupItemImg buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      if (str1 != null) {
        parambu.setContent(str1);
      }
      locali = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV();
      if (parambu.field_isSend != 1) {
        break label621;
      }
      if (parambu.field_msgId != 0L) {
        paramString = locali.G(parambu.field_talker, parambu.field_msgId);
      }
      if ((paramString != null) && (paramString.dnz != 0L)) {
        break label1290;
      }
      paramString = locali.F(parambu.field_talker, parambu.field_msgSvrId);
    }
    label1154:
    label1290:
    for (;;)
    {
      label225:
      localObject1 = bw.M(str1, "msg");
      l1 = 0L;
      long l2;
      if (localObject1 != null)
      {
        l2 = bt.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L);
        l1 = l2;
        if (l2 > 0L) {
          i = 1;
        }
      }
      for (long l3 = l2;; l3 = l1)
      {
        Object localObject3 = bt.bI(com.tencent.mm.plugin.backup.b.g.a(paramif, 3), "");
        if ((paramif.FAP == 3) && (paramif.FAN != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.VQ((String)localObject3), (String)localObject3, paramif.FAN.getBufferToBytes());
        }
        localObject1 = bt.bI(com.tencent.mm.plugin.backup.b.g.a(paramif, 2), "");
        if ((paramif.FAP == 2) && (paramif.FAN != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.VQ((String)localObject1), (String)localObject1, paramif.FAN.getBufferToBytes());
        }
        ad.d("MicroMsg.BackupItemImg", "hdName:%s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.d("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        label907:
        label933:
        label1201:
        for (;;)
        {
          Object localObject2 = com.tencent.mm.plugin.backup.b.g.b(paramif, 1);
          Object localObject5;
          if (localObject2 == null)
          {
            ad.d("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = com.tencent.mm.plugin.backup.b.g.VQ((String)localObject1) + (String)localObject1;
            localObject4 = com.tencent.mm.b.g.getMessageDigest((bt.flT() + " ").getBytes());
            localObject5 = com.tencent.mm.plugin.backup.b.g.VQ((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new e((String)localObject5);
            if (!((e)localObject5).exists()) {
              ((e)localObject5).mkdirs();
            }
            j = af.aQs(str2);
            if (j > 0)
            {
              if (af.a((String)localObject2, Bitmap.CompressFormat.JPEG, str2, j)) {
                break label691;
              }
              ad.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
              i = paramif.FAN.getILen();
              break;
              label598:
              paramString = paramif.FAM.toString();
              break label80;
              label609:
              localObject1 = paramif.FAL.toString();
              break label91;
              label621:
              paramString = locali.F(parambu.field_talker, parambu.field_msgSvrId);
              break label225;
            }
            if (!com.tencent.mm.sdk.platformtools.g.a((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str2))
            {
              ad.e("MicroMsg.BackupItemImg", "createThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
            }
            ad.d("MicroMsg.BackupItemImg", "insert: thumbName = ".concat(String.valueOf(localObject4)));
            label691:
            localObject4 = com.tencent.mm.vfs.i.aY(str2, 0, -1);
            localObject2 = localObject4;
            if (localObject4 != null) {
              break label748;
            }
            ad.e("MicroMsg.BackupItemImg", "img buf is null");
            AppMethodBeat.o(21515);
            return -1;
          }
          ad.d("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          label748:
          Object localObject4 = locali.o((String)localObject3, "", "");
          String str2 = locali.o((String)localObject1, "", "");
          l2 = 0L;
          int k;
          boolean bool;
          if (paramString.dnz == 0L)
          {
            j = com.tencent.mm.plugin.backup.b.g.c(paramif, 2);
            k = 1;
            if (i != 0)
            {
              i = com.tencent.mm.plugin.backup.b.g.c(paramif, 3);
              l1 = locali.a(parambu.field_talker, (byte[])localObject2, paramif.xbt, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              if (((String)localObject3).equals(localObject1))
              {
                bool = com.tencent.mm.plugin.backup.b.g.a(paramif, (String)localObject4);
                l2 = l1;
                if (bool) {
                  break label1201;
                }
                if (j != l3) {
                  break label1179;
                }
                if (!((String)localObject3).equals(localObject1)) {
                  break label1142;
                }
                bool = com.tencent.mm.plugin.backup.b.g.a(paramif, str2);
                if (!bool) {
                  break label1154;
                }
                ad.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[] { str2 });
                i = 0;
                if (j > 0) {
                  break label1274;
                }
                j = com.tencent.mm.plugin.backup.b.g.c(paramif, 3);
              }
            }
          }
          label1142:
          label1274:
          for (;;)
          {
            paramString = new PString();
            localObject3 = new PInt();
            localObject5 = new PInt();
            l2 = locali.a(parambu.field_talker, (byte[])localObject2, paramif.xbt, false, (String)localObject1, j, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if ((i != 0) && (!com.tencent.mm.plugin.backup.b.g.b(paramif, 2, str2))) {
              ad.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              parambu.tO(paramString.value);
              parambu.kB(((PInt)localObject3).value);
              parambu.kC(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().c(Long.valueOf(l2));
                paramString.po((int)l1);
                com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIV().a(Long.valueOf(l2), paramString);
              }
            }
            for (;;)
            {
              c.v(parambu);
              AppMethodBeat.o(21515);
              return 0;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramif, 3, (String)localObject4);
              break;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramif, 3, str2);
              break label907;
              ad.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[] { str2 });
              i = k;
              break label933;
              ad.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[] { localObject4 });
              l2 = l1;
              l1 = l2;
              i = k;
              break label933;
              AppMethodBeat.o(21515);
              return -1;
              paramif = paramString.hZy;
              if ((paramif != null) && (paramif.startsWith("THUMBNAIL_DIRPATH://"))) {
                parambu.tO(paramif);
              } else {
                parambu.tO("THUMBNAIL://" + paramString.dnz);
              }
            }
          }
        }
        label1179:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.d
 * JD-Core Version:    0.7.0.1
 */