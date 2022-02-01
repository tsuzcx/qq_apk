package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bl;
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
  private static String a(com.tencent.mm.aw.e parame, bl parambl)
  {
    AppMethodBeat.i(21514);
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer;
    try
    {
      localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (c.pF(parambl.field_talker)) {
        localStringWriter.write(bi.uf(parambl.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = bw.K(parame.hgv, "msg");
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
          localXmlSerializer.attribute(null, "length", com.tencent.mm.vfs.i.aMN(com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().p(parame.hgj, "", "")));
        }
        if ((parambl.field_isSend != 1) || (parame.hgm == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", bt.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localMap.remove(".msg.img.$cdnbigimgurl");
        localMap.remove(".msg.img.$hdlength");
        if (localMap.get(".msg.img.$md5") == null) {
          localXmlSerializer.attribute(null, "md5", "");
        }
        parame = localMap.keySet().iterator();
        while (parame.hasNext())
        {
          parambl = (String)parame.next();
          if (parambl.startsWith(".msg.img.$")) {
            localXmlSerializer.attribute(null, parambl.substring(10), (String)localMap.get(parambl));
          }
        }
      }
      localXmlSerializer.endTag(null, "img");
    }
    catch (Exception parame)
    {
      ad.e("MicroMsg.BackupItemImg", "packetImg xml error: " + parame.toString());
      AppMethodBeat.o(21514);
      return null;
    }
    localXmlSerializer.endTag(null, "msg");
    localXmlSerializer.endDocument();
    localStringWriter.flush();
    localStringWriter.close();
    parame = localStringWriter.getBuffer().toString();
    ad.d("MicroMsg.BackupItemImg", "parseContent xml:%s", new Object[] { parame });
    AppMethodBeat.o(21514);
    return parame;
  }
  
  public final int a(hu paramhu, boolean paramBoolean1, bl parambl, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21513);
    int j;
    if (bt.isNullOrNil(parambl.field_content))
    {
      j = 0;
      if (parambl.field_isSend == 1)
      {
        paramString = com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().ms(parambl.field_msgId);
        if (paramString.deI != 0L) {
          break label981;
        }
      }
      paramString = com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().mr(parambl.field_msgSvrId);
    }
    label312:
    label572:
    label981:
    for (;;)
    {
      paramHashMap = com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().Q(parambl.field_imgPath, true);
      int i = j;
      if (com.tencent.mm.vfs.i.eK(paramHashMap)) {
        i = j + i.a(new i.a(paramHashMap, paramhu, paramLinkedList, 1, paramBoolean1, "_thumb", paramBoolean2));
      }
      Object localObject1;
      int k;
      if (parambl.field_isSend == 1)
      {
        localObject2 = "";
        str = com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().p(paramString.hgj, "", "");
        localObject1 = localObject2;
        k = i;
        paramHashMap = paramString;
        if (paramString.ayi())
        {
          paramHashMap = com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().od(paramString.hgu);
          if (paramHashMap == null) {
            break label477;
          }
          localObject1 = com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().p(paramHashMap.hgj, "", "");
          ad.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + (String)localObject1 + " " + com.tencent.mm.vfs.i.aMN((String)localObject1));
          com.tencent.mm.vfs.i.aMN((String)localObject1);
          if (com.tencent.mm.vfs.i.eK((String)localObject1)) {
            k = i + i.a(new i.a((String)localObject1, paramhu, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
          }
        }
        else
        {
          com.tencent.mm.vfs.i.aMN(str);
          j = k;
          localObject2 = paramHashMap;
          if (!bt.isNullOrNil(str))
          {
            j = k;
            localObject2 = paramHashMap;
            if (!str.equals(localObject1))
            {
              ad.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.i.aMN(str));
              j = k + i.a(new i.a(str, paramhu, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
              localObject2 = paramHashMap;
            }
          }
        }
      }
      label477:
      do
      {
        parambl = a((com.tencent.mm.aw.e)localObject2, parambl);
        if (parambl != null) {
          break label948;
        }
        AppMethodBeat.o(21513);
        return j;
        j = parambl.field_content.getBytes().length;
        break;
        ad.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { localObject1 });
        k = i;
        break label312;
        ad.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
        localObject1 = localObject2;
        k = i;
        break label312;
        j = i;
        localObject2 = paramString;
      } while (!paramString.ayh());
      String str = com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().p(paramString.hgj, "", "");
      Object localObject2 = "";
      if (paramString.ayi())
      {
        localObject1 = com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().od(paramString.hgu);
        if (localObject1 != null)
        {
          if (localObject1 != null) {
            ad.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", new Object[] { Integer.valueOf(((com.tencent.mm.aw.e)localObject1).offset), Integer.valueOf(((com.tencent.mm.aw.e)localObject1).gTY), Integer.valueOf(((com.tencent.mm.aw.e)localObject1).hgm), ((com.tencent.mm.aw.e)localObject1).hgj });
          }
          paramHashMap = (HashMap<Long, h.a>)localObject2;
          k = i;
          if (localObject1 != null)
          {
            paramHashMap = (HashMap<Long, h.a>)localObject2;
            k = i;
            if (((com.tencent.mm.aw.e)localObject1).hgm == 1)
            {
              if ((localObject1.equals(paramString)) || (((com.tencent.mm.aw.e)localObject1).gTY <= 0) || (((com.tencent.mm.aw.e)localObject1).offset != ((com.tencent.mm.aw.e)localObject1).gTY)) {
                break label929;
              }
              localObject1 = com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().p(((com.tencent.mm.aw.e)localObject1).hgj, "", "");
              ad.d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject1, Long.valueOf(com.tencent.mm.vfs.i.aMN((String)localObject1)) });
              paramHashMap = (HashMap<Long, h.a>)localObject1;
              k = i;
              if (com.tencent.mm.vfs.i.eK((String)localObject1))
              {
                k = i + i.a(new i.a((String)localObject1, paramhu, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
                com.tencent.mm.vfs.i.aMN((String)localObject1);
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
        if (!com.tencent.mm.vfs.i.eK(str)) {
          break;
        }
        com.tencent.mm.vfs.i.aMN(str);
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
        ad.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.i.aMN(str));
        j = k + i.a(new i.a(str, paramhu, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
        localObject2 = paramString;
        break;
        localObject1 = null;
        break label572;
        localObject1.equals(paramString);
        paramHashMap = (HashMap<Long, h.a>)localObject2;
        k = i;
      }
      paramhu.Cxz = new cmf().aEE(parambl);
      i = parambl.length();
      AppMethodBeat.o(21513);
      return j + i;
    }
  }
  
  public final int a(String paramString, hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21515);
    if ((paramhu == null) || (paramhu.Cxz == null))
    {
      ad.e("MicroMsg.BackupItemImg", "recover bakitem/Content is null");
      AppMethodBeat.o(21515);
      return 0;
    }
    String str1 = bt.by(paramhu.Cxz.Ehn, "");
    long l1 = paramhu.uKZ;
    int i;
    int j;
    label80:
    Object localObject1;
    label91:
    com.tencent.mm.aw.g localg;
    if (paramhu.CCV == null)
    {
      i = 0;
      j = paramhu.CCX;
      if (paramhu.CCU != null) {
        break label590;
      }
      paramString = "";
      if (paramhu.CCT != null) {
        break label601;
      }
      localObject1 = "";
      ad.d("MicroMsg.BackupItemImg", "recover, msgId:%d, content:%s, backupItemImg buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      if (str1 != null) {
        parambl.setContent(str1);
      }
      localg = com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ();
      if (parambl.field_isSend != 1) {
        break label613;
      }
      if (parambl.field_msgId != 0L) {
        paramString = localg.ms(parambl.field_msgId);
      }
      if ((paramString != null) && (paramString.deI != 0L)) {
        break label1265;
      }
      paramString = localg.mr(parambl.field_msgSvrId);
    }
    label217:
    label613:
    label1131:
    label1265:
    for (;;)
    {
      localObject1 = bw.K(str1, "msg");
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
        Object localObject3 = bt.by(com.tencent.mm.plugin.backup.b.g.a(paramhu, 3), "");
        if ((paramhu.CCX == 3) && (paramhu.CCV != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.Oi((String)localObject3), (String)localObject3, paramhu.CCV.getBufferToBytes());
        }
        localObject1 = bt.by(com.tencent.mm.plugin.backup.b.g.a(paramhu, 2), "");
        if ((paramhu.CCX == 2) && (paramhu.CCV != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.Oi((String)localObject1), (String)localObject1, paramhu.CCV.getBufferToBytes());
        }
        ad.d("MicroMsg.BackupItemImg", "hdName:%s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.d("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          Object localObject2 = com.tencent.mm.plugin.backup.b.g.b(paramhu, 1);
          Object localObject5;
          if (localObject2 == null)
          {
            ad.d("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = com.tencent.mm.plugin.backup.b.g.Oi((String)localObject1) + (String)localObject1;
            localObject4 = com.tencent.mm.b.g.getMessageDigest((bt.eGO() + " ").getBytes());
            localObject5 = com.tencent.mm.plugin.backup.b.g.Oi((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new com.tencent.mm.vfs.e((String)localObject5);
            if (!((com.tencent.mm.vfs.e)localObject5).exists()) {
              ((com.tencent.mm.vfs.e)localObject5).mkdirs();
            }
            j = af.aFv(str2);
            if (j > 0)
            {
              if (af.a((String)localObject2, Bitmap.CompressFormat.JPEG, str2, j)) {
                break label679;
              }
              ad.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
              i = paramhu.CCV.getILen();
              break;
              paramString = paramhu.CCU.toString();
              break label80;
              localObject1 = paramhu.CCT.toString();
              break label91;
              paramString = localg.mr(parambl.field_msgSvrId);
              break label217;
            }
            if (!f.a((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str2))
            {
              ad.e("MicroMsg.BackupItemImg", "createThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
            }
            ad.d("MicroMsg.BackupItemImg", "insert: thumbName = ".concat(String.valueOf(localObject4)));
            localObject4 = com.tencent.mm.vfs.i.aR(str2, 0, -1);
            localObject2 = localObject4;
            if (localObject4 != null) {
              break label736;
            }
            ad.e("MicroMsg.BackupItemImg", "img buf is null");
            AppMethodBeat.o(21515);
            return -1;
          }
          ad.d("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          Object localObject4 = localg.p((String)localObject3, "", "");
          String str2 = localg.p((String)localObject1, "", "");
          l2 = 0L;
          boolean bool;
          if (paramString.deI == 0L)
          {
            j = com.tencent.mm.plugin.backup.b.g.c(paramhu, 2);
            if (i != 0)
            {
              i = com.tencent.mm.plugin.backup.b.g.c(paramhu, 3);
              l1 = localg.a((byte[])localObject2, paramhu.uKZ, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              if (((String)localObject3).equals(localObject1))
              {
                bool = com.tencent.mm.plugin.backup.b.g.a(paramhu, (String)localObject4);
                l2 = l1;
                if (bool) {
                  break label1177;
                }
                if (j != l3) {
                  break label1155;
                }
                if (!((String)localObject3).equals(localObject1)) {
                  break label1119;
                }
                bool = com.tencent.mm.plugin.backup.b.g.a(paramhu, str2);
                label888:
                if (!bool) {
                  break label1131;
                }
                ad.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[] { str2 });
                i = 0;
                if (j > 0) {
                  break label1249;
                }
                j = com.tencent.mm.plugin.backup.b.g.c(paramhu, 3);
              }
            }
          }
          for (;;)
          {
            paramString = new PString();
            localObject3 = new PInt();
            localObject5 = new PInt();
            l2 = localg.a((byte[])localObject2, paramhu.uKZ, false, (String)localObject1, j, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if ((i != 0) && (!com.tencent.mm.plugin.backup.b.g.b(paramhu, 2, str2))) {
              ad.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              parambl.nZ(paramString.value);
              parambl.kh(((PInt)localObject3).value);
              parambl.ki(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().b(Long.valueOf(l2));
                paramString.nY((int)l1);
                com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxQ().a(Long.valueOf(l2), paramString);
              }
            }
            for (;;)
            {
              c.u(parambl);
              AppMethodBeat.o(21515);
              return 0;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramhu, 3, (String)localObject4);
              break;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramhu, 3, str2);
              break label888;
              ad.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[] { str2 });
              i = 1;
              break label914;
              ad.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[] { localObject4 });
              l2 = l1;
              l1 = l2;
              i = 1;
              break label914;
              AppMethodBeat.o(21515);
              return -1;
              paramhu = paramString.hgl;
              if ((paramhu != null) && (paramhu.startsWith("THUMBNAIL_DIRPATH://"))) {
                parambl.nZ(paramhu);
              } else {
                parambl.nZ("THUMBNAIL://" + paramString.deI);
              }
            }
          }
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.d
 * JD-Core Version:    0.7.0.1
 */