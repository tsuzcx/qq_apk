package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
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
  private static String a(com.tencent.mm.at.e parame, bi parambi)
  {
    AppMethodBeat.i(17455);
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer;
    try
    {
      localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (c.lA(parambi.field_talker)) {
        localStringWriter.write(bf.pu(parambi.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = br.F(parame.fDX, "msg");
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
        if (bo.getLong((String)localMap.get(".msg.img.$length"), 0L) == 0L) {
          localXmlSerializer.attribute(null, "length", com.tencent.mm.vfs.e.avI(com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().q(parame.fDM, "", "")));
        }
        if ((parambi.field_isSend != 1) || (parame.fDP == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", bo.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
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
      ab.e("MicroMsg.BackupItemImg", "packetImg xml error: " + parame.toString());
      AppMethodBeat.o(17455);
      return null;
    }
    localXmlSerializer.endTag(null, "msg");
    localXmlSerializer.endDocument();
    localStringWriter.flush();
    localStringWriter.close();
    parame = localStringWriter.getBuffer().toString();
    ab.d("MicroMsg.BackupItemImg", "parseContent xml:%s", new Object[] { parame });
    AppMethodBeat.o(17455);
    return parame;
  }
  
  public final int a(gx paramgx, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(17454);
    int j;
    if (bo.isNullOrNil(parambi.field_content))
    {
      j = 0;
      if (parambi.field_isSend == 1)
      {
        paramString = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().gT(parambi.field_msgId);
        if (paramString.fDL != 0L) {
          break label973;
        }
      }
      paramString = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().gS(parambi.field_msgSvrId);
    }
    label312:
    label572:
    label973:
    for (;;)
    {
      paramHashMap = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().J(parambi.field_imgPath, true);
      int i = j;
      if (com.tencent.mm.vfs.e.cN(paramHashMap)) {
        i = j + i.a(new i.a(paramHashMap, paramgx, paramLinkedList, 1, paramBoolean1, "_thumb", paramBoolean2));
      }
      Object localObject1;
      int k;
      if (parambi.field_isSend == 1)
      {
        localObject2 = "";
        str = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().q(paramString.fDM, "", "");
        localObject1 = localObject2;
        k = i;
        paramHashMap = paramString;
        if (paramString.ahh())
        {
          paramHashMap = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().lv(paramString.fDW);
          if (paramHashMap == null) {
            break label477;
          }
          localObject1 = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().q(paramHashMap.fDM, "", "");
          ab.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + (String)localObject1 + " " + com.tencent.mm.vfs.e.avI((String)localObject1));
          com.tencent.mm.vfs.e.avI((String)localObject1);
          if (com.tencent.mm.vfs.e.cN((String)localObject1)) {
            k = i + i.a(new i.a((String)localObject1, paramgx, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
          }
        }
        else
        {
          com.tencent.mm.vfs.e.avI(str);
          j = k;
          localObject2 = paramHashMap;
          if (!bo.isNullOrNil(str))
          {
            j = k;
            localObject2 = paramHashMap;
            if (!str.equals(localObject1))
            {
              ab.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.e.avI(str));
              j = k + i.a(new i.a(str, paramgx, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
              localObject2 = paramHashMap;
            }
          }
        }
      }
      label477:
      do
      {
        parambi = a((com.tencent.mm.at.e)localObject2, parambi);
        if (parambi != null) {
          break label940;
        }
        AppMethodBeat.o(17454);
        return j;
        j = parambi.field_content.getBytes().length;
        break;
        ab.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { localObject1 });
        k = i;
        break label312;
        ab.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
        localObject1 = localObject2;
        k = i;
        break label312;
        j = i;
        localObject2 = paramString;
      } while (!paramString.ahg());
      String str = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().q(paramString.fDM, "", "");
      Object localObject2 = "";
      if (paramString.ahh())
      {
        localObject1 = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().lv(paramString.fDW);
        if (localObject1 != null)
        {
          if (localObject1 != null) {
            ab.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", new Object[] { Integer.valueOf(((com.tencent.mm.at.e)localObject1).offset), Integer.valueOf(((com.tencent.mm.at.e)localObject1).fsd), Integer.valueOf(((com.tencent.mm.at.e)localObject1).fDP), ((com.tencent.mm.at.e)localObject1).fDM });
          }
          paramHashMap = (HashMap<Long, h.a>)localObject2;
          k = i;
          if (localObject1 != null)
          {
            paramHashMap = (HashMap<Long, h.a>)localObject2;
            k = i;
            if (((com.tencent.mm.at.e)localObject1).fDP == 1)
            {
              if ((localObject1.equals(paramString)) || (((com.tencent.mm.at.e)localObject1).offset != ((com.tencent.mm.at.e)localObject1).fsd)) {
                break label921;
              }
              localObject1 = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().q(((com.tencent.mm.at.e)localObject1).fDM, "", "");
              ab.d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject1, Long.valueOf(com.tencent.mm.vfs.e.avI((String)localObject1)) });
              paramHashMap = (HashMap<Long, h.a>)localObject1;
              k = i;
              if (com.tencent.mm.vfs.e.cN((String)localObject1))
              {
                k = i + i.a(new i.a((String)localObject1, paramgx, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
                com.tencent.mm.vfs.e.avI((String)localObject1);
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
        if (!com.tencent.mm.vfs.e.cN(str)) {
          break;
        }
        com.tencent.mm.vfs.e.avI(str);
        j = k;
        localObject2 = paramString;
        if (bo.isNullOrNil(str)) {
          break;
        }
        j = k;
        localObject2 = paramString;
        if (str.equals(paramHashMap)) {
          break;
        }
        ab.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.e.avI(str));
        j = k + i.a(new i.a(str, paramgx, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
        localObject2 = paramString;
        break;
        localObject1 = null;
        break label572;
        localObject1.equals(paramString);
        paramHashMap = (HashMap<Long, h.a>)localObject2;
        k = i;
      }
      paramgx.woR = new bwc().aoF(parambi);
      i = parambi.length();
      AppMethodBeat.o(17454);
      return j + i;
    }
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17456);
    if ((paramgx == null) || (paramgx.woR == null))
    {
      ab.e("MicroMsg.BackupItemImg", "recover bakitem or bakitem content is null");
      AppMethodBeat.o(17456);
      return 0;
    }
    String str1 = new String(bo.bf(paramgx.woR.xJE, ""));
    ab.d("MicroMsg.BackupItemImg", "recover msg:" + paramgx.pIG + " " + str1);
    int i;
    int j;
    label118:
    Object localObject1;
    label129:
    com.tencent.mm.at.g localg;
    if (paramgx.wtq == null)
    {
      i = 0;
      j = paramgx.wts;
      if (paramgx.wtp != null) {
        break label605;
      }
      paramString = "";
      if (paramgx.wto != null) {
        break label616;
      }
      localObject1 = "";
      ab.d("MicroMsg.BackupItemImg", "recover backupItemImg:, buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      parambi.setContent(str1);
      localg = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH();
      if (parambi.field_isSend != 1) {
        break label628;
      }
      if (parambi.field_msgId != 0L) {
        paramString = localg.gT(parambi.field_msgId);
      }
      if ((paramString != null) && (paramString.fDL != 0L)) {
        break label1227;
      }
      paramString = localg.gS(parambi.field_msgSvrId);
    }
    label694:
    label1211:
    label1227:
    for (;;)
    {
      label236:
      localObject1 = br.F(str1, "msg");
      long l1 = 0L;
      long l2;
      if (localObject1 != null)
      {
        l2 = bo.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L);
        l1 = l2;
        if (l2 > 0L) {
          i = 1;
        }
      }
      for (;;)
      {
        Object localObject3 = bo.bf(com.tencent.mm.plugin.backup.b.g.a(paramgx, 3), "");
        if ((paramgx.wts == 3) && (paramgx.wtq != null)) {
          com.tencent.mm.plugin.backup.b.g.b(com.tencent.mm.plugin.backup.b.g.Gh((String)localObject3), (String)localObject3, paramgx.wtq.getBufferToBytes());
        }
        localObject1 = bo.bf(com.tencent.mm.plugin.backup.b.g.a(paramgx, 2), "");
        if ((paramgx.wts == 2) && (paramgx.wtq != null)) {
          com.tencent.mm.plugin.backup.b.g.b(com.tencent.mm.plugin.backup.b.g.Gh((String)localObject1), (String)localObject1, paramgx.wtq.getBufferToBytes());
        }
        ab.d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (bo.isNullOrNil((String)localObject1))
        {
          ab.e("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          Object localObject2 = com.tencent.mm.plugin.backup.b.g.b(paramgx, 1);
          Object localObject4;
          if (localObject2 == null)
          {
            ab.i("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = com.tencent.mm.plugin.backup.b.g.Gh((String)localObject1) + (String)localObject1;
            str2 = com.tencent.mm.a.g.w((bo.aoy() + " ").getBytes());
            localObject4 = com.tencent.mm.plugin.backup.b.g.Gh(str2);
            str3 = (String)localObject4 + str2;
            localObject4 = new com.tencent.mm.vfs.b((String)localObject4);
            if (!((com.tencent.mm.vfs.b)localObject4).exists()) {
              ((com.tencent.mm.vfs.b)localObject4).mkdirs();
            }
            j = ad.api(str3);
            if (j > 0)
            {
              if (ad.a((String)localObject2, Bitmap.CompressFormat.JPEG, str3, j)) {
                break label694;
              }
              ab.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(17456);
              return -1;
              i = paramgx.wtq.getILen();
              break;
              label605:
              paramString = paramgx.wtp.toString();
              break label118;
              label616:
              localObject1 = paramgx.wto.toString();
              break label129;
              label628:
              paramString = localg.gS(parambi.field_msgSvrId);
              break label236;
            }
            if (!com.tencent.mm.sdk.platformtools.d.a((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str3))
            {
              ab.e("MicroMsg.BackupItemImg", "createThumbNail failed");
              AppMethodBeat.o(17456);
              return -1;
            }
            ab.d("MicroMsg.BackupItemImg", "insert: thumbName = ".concat(String.valueOf(str2)));
            localObject2 = com.tencent.mm.vfs.e.i(str3, 0, -1);
          }
          while (localObject2 == null)
          {
            ab.e("MicroMsg.BackupItemImg", "img buf is null");
            AppMethodBeat.o(17456);
            return -1;
            ab.i("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          }
          String str2 = localg.q((String)localObject3, "", "");
          String str3 = localg.q((String)localObject1, "", "");
          l1 = 0L;
          long l3;
          if (paramString.fDL == 0L)
          {
            j = com.tencent.mm.plugin.backup.b.g.c(paramgx, 2);
            if (i != 0)
            {
              i = com.tencent.mm.plugin.backup.b.g.c(paramgx, 3);
              l3 = localg.a((byte[])localObject2, paramgx.pIG, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              l1 = l3;
              if (!com.tencent.mm.plugin.backup.b.g.b(paramgx, 3, str2))
              {
                ab.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[] { str2 });
                l1 = l3;
                if (j == l2) {
                  if (com.tencent.mm.plugin.backup.b.g.b(paramgx, 3, str3))
                  {
                    ab.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[] { str3 });
                    l1 = l3;
                    i = 0;
                    if (j > 0) {
                      break label1211;
                    }
                    j = com.tencent.mm.plugin.backup.b.g.c(paramgx, 3);
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
            l2 = localg.a((byte[])localObject2, paramgx.pIG, false, (String)localObject1, j, str1, paramString, (PInt)localObject3, (PInt)localObject4);
            if ((i != 0) && (!com.tencent.mm.plugin.backup.b.g.b(paramgx, 2, str3))) {
              ab.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[] { str2 });
            }
            if (l2 > 0L)
            {
              parambi.kk(paramString.value);
              parambi.hW(((PInt)localObject3).value);
              parambi.hX(((PInt)localObject4).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().b(Long.valueOf(l2));
                paramString.lr((int)l1);
                com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUH().a(Long.valueOf(l2), paramString);
              }
            }
            for (;;)
            {
              c.l(parambi);
              AppMethodBeat.o(17456);
              return 0;
              ab.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[] { str3 });
              l1 = l3;
              i = 1;
              break;
              AppMethodBeat.o(17456);
              return -1;
              paramgx = paramString.fDO;
              if ((paramgx != null) && (paramgx.startsWith("THUMBNAIL_DIRPATH://"))) {
                parambi.kk(paramgx);
              } else {
                parambi.kk("THUMBNAIL://" + paramString.fDL);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.d
 * JD-Core Version:    0.7.0.1
 */