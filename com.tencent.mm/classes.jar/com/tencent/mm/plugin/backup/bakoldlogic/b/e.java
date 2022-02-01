package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
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
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e
  implements j
{
  private static String a(com.tencent.mm.aw.g paramg, bu parambu)
  {
    AppMethodBeat.i(21846);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (d.vF(parambu.field_talker)) {
        localStringWriter.write(bj.Bk(parambu.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = bw.M(paramg.hZI, "msg");
      if (localMap != null)
      {
        localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.img.$aeskey"));
        localXmlSerializer.attribute(null, "encryver", (String)localMap.get(".msg.img.$encryver"));
        localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.img.$cdnthumbaeskey"));
        localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.img.$cdnthumburl"));
        localXmlSerializer.attribute(null, "cdnthumblength", bt.getLong((String)localMap.get(".msg.img.$cdnthumblength"), 10240L));
        localXmlSerializer.attribute(null, "cdnthumbheight", bt.getInt((String)localMap.get(".msg.img.$cdnthumbheight"), 0));
        localXmlSerializer.attribute(null, "cdnthumbwidth", bt.getInt((String)localMap.get(".msg.img.$cdnthumbwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidheight", bt.getInt((String)localMap.get(".msg.img.$cdnmidheight"), 0));
        localXmlSerializer.attribute(null, "cdnmidwidth", bt.getInt((String)localMap.get(".msg.img.$cdnmidwidth"), 0));
        localXmlSerializer.attribute(null, "cdnhdheight", bt.getInt((String)localMap.get(".msg.img.$cdnhdheight"), 0));
        localXmlSerializer.attribute(null, "cdnhdwidth", bt.getInt((String)localMap.get(".msg.img.$cdnhdwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidimgurl", (String)localMap.get(".msg.img.$cdnmidimgurl"));
        long l2 = bt.getLong((String)localMap.get(".msg.img.$length"), 0L);
        StringBuilder localStringBuilder = new StringBuilder();
        long l1 = l2;
        if (l2 == 0L) {
          l1 = com.tencent.mm.vfs.i.aYo(b.bJF().bJG().bIV().o(paramg.hZw, "", ""));
        }
        localXmlSerializer.attribute(null, "length", l1);
        if ((parambu.field_isSend != 1) || (paramg.hZz == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", bt.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localXmlSerializer.attribute(null, "md5", (String)localMap.get(".msg.img.$md5"));
      }
      localXmlSerializer.endTag(null, "img");
      localXmlSerializer.endTag(null, "msg");
      localXmlSerializer.endDocument();
      localStringWriter.flush();
      localStringWriter.close();
      paramg = localStringWriter.getBuffer().toString();
      ad.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", new Object[] { paramg });
      AppMethodBeat.o(21846);
      return paramg;
    }
    catch (Exception paramg)
    {
      ad.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + paramg.toString());
      AppMethodBeat.o(21846);
    }
    return null;
  }
  
  public final int a(if paramif, bu parambu, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21845);
    int i;
    Object localObject1;
    if (bt.isNullOrNil(parambu.field_content))
    {
      i = 0;
      if (parambu.field_isSend == 1)
      {
        localObject1 = b.bJF().bJG().bIV().G(parambu.field_talker, parambu.field_msgId);
        if (((com.tencent.mm.aw.g)localObject1).dnz != 0L) {
          break label1000;
        }
      }
      localObject1 = b.bJF().bJG().bIV().F(parambu.field_talker, parambu.field_msgSvrId);
    }
    label299:
    label443:
    label467:
    label479:
    label993:
    label1000:
    for (;;)
    {
      Object localObject2 = b.bJF().bJG().bIV().R(parambu.field_imgPath, true);
      String str1;
      String str2;
      int j;
      if (com.tencent.mm.vfs.i.fv((String)localObject2))
      {
        i += i.a(new i.a((String)localObject2, paramif, paramLinkedList, 1, "_thumb"));
        if (parambu.field_isSend != 1) {
          break label490;
        }
        str1 = "";
        str2 = b.bJF().bJG().bIV().o(((com.tencent.mm.aw.g)localObject1).hZw, "", "");
        localObject2 = localObject1;
        if (!((com.tencent.mm.aw.g)localObject1).aIj()) {
          break label479;
        }
        localObject1 = b.bJF().bJG().bIV().pt(((com.tencent.mm.aw.g)localObject1).hZH);
        if (localObject1 == null) {
          break label467;
        }
        str1 = b.bJF().bJG().bIV().o(((com.tencent.mm.aw.g)localObject1).hZw, "", "");
        ad.d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + str1 + " " + com.tencent.mm.vfs.i.aYo(str1));
        com.tencent.mm.vfs.i.aYo(str1);
        if (!com.tencent.mm.vfs.i.fv(str1)) {
          break label443;
        }
        j = i.a(new i.a(str1, paramif, paramLinkedList, 3, "_hd")) + i;
        com.tencent.mm.vfs.i.aYo(str2);
        localObject2 = localObject1;
        i = j;
        if (!bt.isNullOrNil(str2))
        {
          localObject2 = localObject1;
          i = j;
          if (!str2.equals(str1))
          {
            ad.d("MicroMsg.BakOldItemImg", "bigImgPath " + str2 + " " + com.tencent.mm.vfs.i.aYo(str2));
            i = j + i.a(new i.a(str2, paramif, paramLinkedList, 2, false, null));
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        parambu = a((com.tencent.mm.aw.g)localObject2, parambu);
        label490:
        int k;
        int m;
        if (parambu == null)
        {
          AppMethodBeat.o(21845);
          return i;
          i = parambu.field_content.getBytes().length;
          break;
          AppMethodBeat.o(21845);
          return -1;
          ad.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { str1 });
          j = i;
          break label299;
          ad.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but img is null");
          localObject2 = localObject1;
          localObject1 = localObject2;
          j = i;
          break label299;
          if (!((com.tencent.mm.aw.g)localObject1).aIi()) {
            break label993;
          }
          str2 = b.bJF().bJG().bIV().o(((com.tencent.mm.aw.g)localObject1).hZw, "", "");
          if (((com.tencent.mm.aw.g)localObject1).aIj()) {
            if (((com.tencent.mm.aw.g)localObject1).aIj())
            {
              localObject2 = b.bJF().bJG().bIV().pt(((com.tencent.mm.aw.g)localObject1).hZH);
              if (localObject2 != null)
              {
                if (localObject2 != null) {
                  break label894;
                }
                j = -1;
                if (localObject2 != null) {
                  break label904;
                }
                k = -1;
                if (localObject2 != null) {
                  break label914;
                }
                str1 = "null";
                if (localObject2 != null) {
                  break label924;
                }
                m = -1;
                ad.i("MicroMsg.BakOldItemImg", "packet hdinfo off:%d total:%d path:%s, compressType[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), str1, Integer.valueOf(m) });
                if ((localObject2 == null) || (((com.tencent.mm.aw.g)localObject2).hZz != 1)) {
                  break label942;
                }
                if ((localObject2.equals(localObject1)) || (((com.tencent.mm.aw.g)localObject2).offset != ((com.tencent.mm.aw.g)localObject2).hMP)) {
                  break label934;
                }
                str1 = b.bJF().bJG().bIV().o(((com.tencent.mm.aw.g)localObject2).hZw, "", "");
                ad.d("MicroMsg.BakOldItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { str1, Long.valueOf(com.tencent.mm.vfs.i.aYo(str1)) });
                if (!com.tencent.mm.vfs.i.fv(str1)) {
                  break label986;
                }
                j = i.a(new i.a(str1, paramif, paramLinkedList, 3, "_hd"));
                com.tencent.mm.vfs.i.aYo(str1);
                j = i + j;
              }
            }
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          i = j;
          if (!com.tencent.mm.vfs.i.fv(str2)) {
            break;
          }
          com.tencent.mm.vfs.i.aYo(str2);
          localObject2 = localObject1;
          i = j;
          if (bt.isNullOrNil(str2)) {
            break;
          }
          localObject2 = localObject1;
          i = j;
          if (str2.equals(str1)) {
            break;
          }
          ad.d("MicroMsg.BakOldItemImg", "bigImgPath " + str2 + " " + com.tencent.mm.vfs.i.aYo(str2));
          i = j + i.a(new i.a(str2, paramif, paramLinkedList, 2, false, null));
          localObject2 = localObject1;
          break;
          localObject2 = localObject1;
          break label561;
          label894:
          j = ((com.tencent.mm.aw.g)localObject2).offset;
          break label569;
          k = ((com.tencent.mm.aw.g)localObject2).hMP;
          break label577;
          str1 = ((com.tencent.mm.aw.g)localObject2).hZw;
          break label587;
          m = ((com.tencent.mm.aw.g)localObject2).hZz;
          break label595;
          localObject2.equals(localObject1);
          str1 = "";
          j = i;
          continue;
          paramif.Fvk = new cwt().aPy(parambu);
          j = parambu.length();
          AppMethodBeat.o(21845);
          return i + j;
          j = i;
        }
        localObject2 = localObject1;
      }
    }
  }
  
  public final int a(String paramString, if paramif, bu parambu)
  {
    AppMethodBeat.i(21847);
    if ((paramif == null) || (paramif.Fvk == null))
    {
      ad.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
      AppMethodBeat.o(21847);
      return 0;
    }
    String str1 = new String(bt.bI(paramif.Fvk.HoB, ""));
    ad.d("MicroMsg.BakOldItemImg", "recover msg" + paramif.xbt + " " + str1);
    int i;
    int j;
    label116:
    Object localObject1;
    label127:
    com.tencent.mm.aw.i locali;
    if (paramif.FAN == null)
    {
      i = 0;
      j = paramif.FAP;
      if (paramif.FAM != null) {
        break label680;
      }
      paramString = "";
      if (paramif.FAL != null) {
        break label691;
      }
      localObject1 = "";
      ad.d("MicroMsg.BakOldItemImg", "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      parambu.setContent(str1);
      locali = b.bJF().bJG().bIV();
      if (parambu.field_isSend != 1) {
        break label703;
      }
      if (parambu.field_msgId != 0L) {
        paramString = locali.G(parambu.field_talker, parambu.field_msgId);
      }
      if ((paramString != null) && (paramString.dnz != 0L)) {
        break label1228;
      }
      paramString = locali.F(parambu.field_talker, parambu.field_msgSvrId);
    }
    label680:
    label691:
    label703:
    label1228:
    for (;;)
    {
      label241:
      localObject1 = bw.M(str1, "msg");
      if ((localObject1 != null) && (bt.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L) > 0L)) {}
      for (i = 1;; i = 0)
      {
        Object localObject3 = bt.bI(a.a(paramif, 3), "");
        Object localObject2;
        if ((paramif.FAP == 3) && (paramif.FAN != null))
        {
          localObject1 = a.bJf() + "backupMeida/" + a.We((String)localObject3) + (String)localObject3;
          localObject2 = paramif.FAN.getBufferToBytes();
          com.tencent.mm.vfs.i.e((String)localObject1, (byte[])localObject2, localObject2.length);
        }
        localObject1 = bt.bI(a.a(paramif, 2), "");
        Object localObject4;
        if ((paramif.FAP == 2) && (paramif.FAN != null))
        {
          localObject2 = a.bJf() + "backupMeida/" + a.We((String)localObject1) + (String)localObject1;
          localObject4 = paramif.FAN.getBufferToBytes();
          com.tencent.mm.vfs.i.e((String)localObject2, (byte[])localObject4, localObject4.length);
        }
        ad.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          localObject2 = a.b(paramif, 1);
          Object localObject5;
          if (localObject2 == null)
          {
            ad.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = a.Wg((String)localObject1);
            localObject4 = com.tencent.mm.b.g.getMessageDigest((bt.flT() + " ").getBytes());
            localObject5 = a.bJf() + "backupMeida/" + a.We((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new com.tencent.mm.vfs.e((String)localObject5);
            if (!((com.tencent.mm.vfs.e)localObject5).exists()) {
              ((com.tencent.mm.vfs.e)localObject5).mkdirs();
            }
            j = af.aQs(str2);
            if (j > 0)
            {
              if (af.a((String)localObject2, Bitmap.CompressFormat.JPEG, str2, j)) {
                break label771;
              }
              ad.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
              i = paramif.FAN.getILen();
              break;
              paramString = paramif.FAM.toString();
              break label116;
              localObject1 = paramif.FAL.toString();
              break label127;
              paramString = locali.F(parambu.field_talker, parambu.field_msgSvrId);
              break label241;
            }
            if (!com.tencent.mm.sdk.platformtools.g.a((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str2))
            {
              ad.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
            }
            ad.d("MicroMsg.BakOldItemImg", "insert: thumbName = ".concat(String.valueOf(localObject4)));
            localObject2 = com.tencent.mm.vfs.i.aY(str2, 0, -1);
          }
          while (localObject2 == null)
          {
            ad.e("MicroMsg.BakOldItemImg", "img buf is null");
            AppMethodBeat.o(21847);
            return -1;
            ad.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          }
          localObject4 = locali.o((String)localObject3, "", "");
          String str2 = locali.o((String)localObject1, "", "");
          long l1 = 0L;
          if (paramString.dnz == 0L)
          {
            if (i != 0)
            {
              i = a.c(paramif, 3);
              l2 = locali.a(parambu.field_talker, (byte[])localObject2, paramif.xbt, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              l1 = l2;
              if (!a.b(paramif, 3, (String)localObject4))
              {
                ad.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", new Object[] { localObject4 });
                l1 = l2;
              }
            }
            j = a.c(paramif, 2);
            i = j;
            if (j <= 0) {
              i = a.c(paramif, 3);
            }
            paramString = new PString();
            localObject3 = new PInt();
            localObject5 = new PInt();
            long l2 = locali.a(parambu.field_talker, (byte[])localObject2, paramif.xbt, false, (String)localObject1, i, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if (!a.b(paramif, 2, str2)) {
              ad.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              parambu.tO(paramString.value);
              parambu.kB(((PInt)localObject3).value);
              parambu.kC(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = b.bJF().bJG().bIV().c(Long.valueOf(l2));
                paramString.po((int)l1);
                b.bJF().bJG().bIV().a(Long.valueOf(l2), paramString);
              }
            }
          }
          for (;;)
          {
            d.v(parambu);
            AppMethodBeat.o(21847);
            return 0;
            AppMethodBeat.o(21847);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.e
 * JD-Core Version:    0.7.0.1
 */