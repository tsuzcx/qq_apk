package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
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
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e
  implements j
{
  private static String a(com.tencent.mm.as.e parame, bi parambi)
  {
    StringWriter localStringWriter = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (d.fn(parambi.field_talker)) {
        localStringWriter.write(bd.iI(parambi.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = bn.s(parame.enA, "msg");
      if (localMap != null)
      {
        localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.img.$aeskey"));
        localXmlSerializer.attribute(null, "encryver", (String)localMap.get(".msg.img.$encryver"));
        localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.img.$cdnthumbaeskey"));
        localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.img.$cdnthumburl"));
        localXmlSerializer.attribute(null, "cdnthumblength", bk.getLong((String)localMap.get(".msg.img.$cdnthumblength"), 10240L));
        localXmlSerializer.attribute(null, "cdnthumbheight", bk.getInt((String)localMap.get(".msg.img.$cdnthumbheight"), 0));
        localXmlSerializer.attribute(null, "cdnthumbwidth", bk.getInt((String)localMap.get(".msg.img.$cdnthumbwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidheight", bk.getInt((String)localMap.get(".msg.img.$cdnmidheight"), 0));
        localXmlSerializer.attribute(null, "cdnmidwidth", bk.getInt((String)localMap.get(".msg.img.$cdnmidwidth"), 0));
        localXmlSerializer.attribute(null, "cdnhdheight", bk.getInt((String)localMap.get(".msg.img.$cdnhdheight"), 0));
        localXmlSerializer.attribute(null, "cdnhdwidth", bk.getInt((String)localMap.get(".msg.img.$cdnhdwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidimgurl", (String)localMap.get(".msg.img.$cdnmidimgurl"));
        long l2 = bk.getLong((String)localMap.get(".msg.img.$length"), 0L);
        StringBuilder localStringBuilder = new StringBuilder();
        long l1 = l2;
        if (l2 == 0L) {
          l1 = com.tencent.mm.a.e.bJ(com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().o(parame.enq, "", ""));
        }
        localXmlSerializer.attribute(null, "length", l1);
        if ((parambi.field_isSend != 1) || (parame.ent == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", bk.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localXmlSerializer.attribute(null, "md5", (String)localMap.get(".msg.img.$md5"));
      }
      localXmlSerializer.endTag(null, "img");
      localXmlSerializer.endTag(null, "msg");
      localXmlSerializer.endDocument();
      localStringWriter.flush();
      localStringWriter.close();
      parame = localStringWriter.getBuffer().toString();
      y.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", new Object[] { parame });
      return parame;
    }
    catch (Exception parame)
    {
      y.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + parame.toString());
    }
    return null;
  }
  
  public final int a(fo paramfo, bi parambi, LinkedList<u> paramLinkedList)
  {
    int i;
    Object localObject1;
    if (bk.bl(parambi.field_content))
    {
      i = 0;
      if (parambi.field_isSend == 1)
      {
        localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().bY(parambi.field_msgId);
        if (((com.tencent.mm.as.e)localObject1).enp != 0L) {
          break label964;
        }
      }
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().bX(parambi.field_msgSvrId);
    }
    label285:
    label417:
    label441:
    label569:
    label957:
    label964:
    for (;;)
    {
      Object localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().F(parambi.field_imgPath, true);
      String str1;
      String str2;
      int j;
      if (com.tencent.mm.a.e.bK((String)localObject2))
      {
        i += i.a(new i.a((String)localObject2, paramfo, paramLinkedList, 1, "_thumb"));
        if (parambi.field_isSend != 1) {
          break label464;
        }
        str1 = "";
        str2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().o(((com.tencent.mm.as.e)localObject1).enq, "", "");
        localObject2 = localObject1;
        if (!((com.tencent.mm.as.e)localObject1).Or()) {
          break label453;
        }
        localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().iH(((com.tencent.mm.as.e)localObject1).enz);
        if (localObject1 == null) {
          break label441;
        }
        str1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().o(((com.tencent.mm.as.e)localObject1).enq, "", "");
        y.d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + str1 + " " + com.tencent.mm.a.e.bJ(str1));
        com.tencent.mm.a.e.bJ(str1);
        if (!com.tencent.mm.a.e.bK(str1)) {
          break label417;
        }
        j = i.a(new i.a(str1, paramfo, paramLinkedList, 3, "_hd")) + i;
        com.tencent.mm.a.e.bJ(str2);
        localObject2 = localObject1;
        i = j;
        if (!bk.bl(str2))
        {
          localObject2 = localObject1;
          i = j;
          if (!str2.equals(str1))
          {
            y.d("MicroMsg.BakOldItemImg", "bigImgPath " + str2 + " " + com.tencent.mm.a.e.bJ(str2));
            i = j + i.a(new i.a(str2, paramfo, paramLinkedList, 2, false, null));
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        parambi = a((com.tencent.mm.as.e)localObject2, parambi);
        label453:
        label464:
        int k;
        int m;
        if (parambi == null)
        {
          return i;
          i = parambi.field_content.getBytes().length;
          break;
          return -1;
          y.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { str1 });
          j = i;
          break label285;
          y.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but img is null");
          localObject2 = localObject1;
          localObject1 = localObject2;
          j = i;
          break label285;
          if (!((com.tencent.mm.as.e)localObject1).Oq()) {
            break label957;
          }
          str2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().o(((com.tencent.mm.as.e)localObject1).enq, "", "");
          if (((com.tencent.mm.as.e)localObject1).Or()) {
            if (((com.tencent.mm.as.e)localObject1).Or())
            {
              localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().iH(((com.tencent.mm.as.e)localObject1).enz);
              if (localObject2 != null)
              {
                if (localObject2 != null) {
                  break label868;
                }
                j = -1;
                if (localObject2 != null) {
                  break label878;
                }
                k = -1;
                if (localObject2 != null) {
                  break label888;
                }
                str1 = "null";
                if (localObject2 != null) {
                  break label898;
                }
                m = -1;
                y.i("MicroMsg.BakOldItemImg", "packet hdinfo off:%d total:%d path:%s, compressType[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), str1, Integer.valueOf(m) });
                if ((localObject2 == null) || (((com.tencent.mm.as.e)localObject2).ent != 1)) {
                  break label916;
                }
                if ((localObject2.equals(localObject1)) || (((com.tencent.mm.as.e)localObject2).offset != ((com.tencent.mm.as.e)localObject2).ebK)) {
                  break label908;
                }
                str1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().o(((com.tencent.mm.as.e)localObject2).enq, "", "");
                y.d("MicroMsg.BakOldItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { str1, Integer.valueOf(com.tencent.mm.a.e.bJ(str1)) });
                if (!com.tencent.mm.a.e.bK(str1)) {
                  break label950;
                }
                j = i.a(new i.a(str1, paramfo, paramLinkedList, 3, "_hd"));
                com.tencent.mm.a.e.bJ(str1);
                j = i + j;
              }
            }
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          i = j;
          if (!com.tencent.mm.a.e.bK(str2)) {
            break;
          }
          com.tencent.mm.a.e.bJ(str2);
          localObject2 = localObject1;
          i = j;
          if (bk.bl(str2)) {
            break;
          }
          localObject2 = localObject1;
          i = j;
          if (str2.equals(str1)) {
            break;
          }
          y.d("MicroMsg.BakOldItemImg", "bigImgPath " + str2 + " " + com.tencent.mm.a.e.bJ(str2));
          i = j + i.a(new i.a(str2, paramfo, paramLinkedList, 2, false, null));
          localObject2 = localObject1;
          break;
          localObject2 = localObject1;
          break label535;
          label868:
          j = ((com.tencent.mm.as.e)localObject2).offset;
          break label543;
          label878:
          k = ((com.tencent.mm.as.e)localObject2).ebK;
          break label551;
          label888:
          str1 = ((com.tencent.mm.as.e)localObject2).enq;
          break label561;
          m = ((com.tencent.mm.as.e)localObject2).ent;
          break label569;
          localObject2.equals(localObject1);
          str1 = "";
          j = i;
          continue;
          paramfo.svH = new bml().YI(parambi);
          return i + parambi.length();
          j = i;
        }
        localObject2 = localObject1;
      }
    }
  }
  
  public final int a(String paramString, fo paramfo, bi parambi)
  {
    if ((paramfo == null) || (paramfo.svH == null))
    {
      y.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
      return 0;
    }
    String str1 = new String(bk.aM(paramfo.svH.tFO, ""));
    y.d("MicroMsg.BakOldItemImg", "recover msg" + paramfo.ndp + " " + str1);
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
        break label632;
      }
      paramString = "";
      if (paramfo.szn != null) {
        break label643;
      }
      localObject1 = "";
      y.d("MicroMsg.BakOldItemImg", "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      parambi.setContent(str1);
      localg = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf();
      if (parambi.field_isSend != 1) {
        break label655;
      }
      if (parambi.field_msgId != 0L) {
        paramString = localg.bY(parambi.field_msgId);
      }
      if ((paramString != null) && (paramString.enp != 0L)) {
        break label1151;
      }
      paramString = localg.bX(parambi.field_msgSvrId);
    }
    label221:
    label632:
    label1151:
    for (;;)
    {
      localObject1 = bn.s(str1, "msg");
      if ((localObject1 != null) && (bk.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L) > 0L)) {}
      for (i = 1;; i = 0)
      {
        Object localObject3 = bk.aM(a.a(paramfo, 3), "");
        if ((paramfo.szr == 3) && (paramfo.szp != null)) {
          com.tencent.mm.a.e.b(a.avo() + "backupMeida/" + a.xq((String)localObject3), (String)localObject3, paramfo.szp.tFM.oY);
        }
        localObject1 = bk.aM(a.a(paramfo, 2), "");
        if ((paramfo.szr == 2) && (paramfo.szp != null)) {
          com.tencent.mm.a.e.b(a.avo() + "backupMeida/" + a.xq((String)localObject1), (String)localObject1, paramfo.szp.tFM.oY);
        }
        y.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (bk.bl((String)localObject1))
        {
          y.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          Object localObject2 = a.b(paramfo, 1);
          Object localObject4;
          if (localObject2 == null)
          {
            y.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = a.xD((String)localObject1);
            str2 = com.tencent.mm.a.g.o((bk.UY() + " ").getBytes());
            localObject4 = a.avo() + "backupMeida/" + a.xq(str2);
            str3 = (String)localObject4 + str2;
            localObject4 = new File((String)localObject4);
            if (!((File)localObject4).exists()) {
              ((File)localObject4).mkdirs();
            }
            j = aa.Zk(str3);
            if (j > 0)
            {
              if (aa.a((String)localObject2, Bitmap.CompressFormat.JPEG, str3, j)) {
                break label720;
              }
              y.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
              return -1;
              i = paramfo.szp.tFK;
              break;
              paramString = paramfo.szo.toString();
              break label104;
              localObject1 = paramfo.szn.toString();
              break label115;
              paramString = localg.bX(parambi.field_msgSvrId);
              break label221;
            }
            if (!com.tencent.mm.sdk.platformtools.c.a((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str3))
            {
              y.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
              return -1;
            }
            y.d("MicroMsg.BakOldItemImg", "insert: thumbName = " + str2);
            localObject2 = com.tencent.mm.a.e.d(str3, 0, -1);
          }
          while (localObject2 == null)
          {
            y.e("MicroMsg.BakOldItemImg", "img buf is null");
            return -1;
            y.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          }
          String str2 = localg.o((String)localObject3, "", "");
          String str3 = localg.o((String)localObject1, "", "");
          long l1 = 0L;
          if (paramString.enp == 0L)
          {
            if (i != 0)
            {
              i = a.c(paramfo, 3);
              l2 = localg.a((byte[])localObject2, paramfo.ndp, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              l1 = l2;
              if (!a.b(paramfo, 3, str2))
              {
                y.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", new Object[] { str2 });
                l1 = l2;
              }
            }
            j = a.c(paramfo, 2);
            i = j;
            if (j <= 0) {
              i = a.c(paramfo, 3);
            }
            paramString = new PString();
            localObject3 = new PInt();
            localObject4 = new PInt();
            long l2 = localg.a((byte[])localObject2, paramfo.ndp, false, (String)localObject1, i, str1, paramString, (PInt)localObject3, (PInt)localObject4);
            if (!a.b(paramfo, 2, str3)) {
              y.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", new Object[] { str2 });
            }
            if (l2 > 0L)
            {
              parambi.ed(paramString.value);
              parambi.fK(((PInt)localObject3).value);
              parambi.fL(((PInt)localObject4).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().b(Long.valueOf(l2));
                paramString.iD((int)l1);
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().avf().a(Long.valueOf(l2), paramString);
              }
            }
          }
          for (;;)
          {
            d.h(parambi);
            return 0;
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.e
 * JD-Core Version:    0.7.0.1
 */