package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
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
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e
  implements j
{
  private static String a(com.tencent.mm.aw.e parame, bl parambl)
  {
    AppMethodBeat.i(21846);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (d.pF(parambl.field_talker)) {
        localStringWriter.write(bi.uf(parambl.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = bw.K(parame.hgv, "msg");
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
          l1 = com.tencent.mm.vfs.i.aMN(b.byA().byB().bxQ().p(parame.hgj, "", ""));
        }
        localXmlSerializer.attribute(null, "length", l1);
        if ((parambl.field_isSend != 1) || (parame.hgm == 1))
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
      parame = localStringWriter.getBuffer().toString();
      ad.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", new Object[] { parame });
      AppMethodBeat.o(21846);
      return parame;
    }
    catch (Exception parame)
    {
      ad.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + parame.toString());
      AppMethodBeat.o(21846);
    }
    return null;
  }
  
  public final int a(hu paramhu, bl parambl, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21845);
    int i;
    Object localObject1;
    if (bt.isNullOrNil(parambl.field_content))
    {
      i = 0;
      if (parambl.field_isSend == 1)
      {
        localObject1 = b.byA().byB().bxQ().ms(parambl.field_msgId);
        if (((com.tencent.mm.aw.e)localObject1).deI != 0L) {
          break label992;
        }
      }
      localObject1 = b.byA().byB().bxQ().mr(parambl.field_msgSvrId);
    }
    label291:
    label435:
    label459:
    label471:
    label985:
    label992:
    for (;;)
    {
      Object localObject2 = b.byA().byB().bxQ().Q(parambl.field_imgPath, true);
      String str1;
      String str2;
      int j;
      if (com.tencent.mm.vfs.i.eK((String)localObject2))
      {
        i += i.a(new i.a((String)localObject2, paramhu, paramLinkedList, 1, "_thumb"));
        if (parambl.field_isSend != 1) {
          break label482;
        }
        str1 = "";
        str2 = b.byA().byB().bxQ().p(((com.tencent.mm.aw.e)localObject1).hgj, "", "");
        localObject2 = localObject1;
        if (!((com.tencent.mm.aw.e)localObject1).ayi()) {
          break label471;
        }
        localObject1 = b.byA().byB().bxQ().od(((com.tencent.mm.aw.e)localObject1).hgu);
        if (localObject1 == null) {
          break label459;
        }
        str1 = b.byA().byB().bxQ().p(((com.tencent.mm.aw.e)localObject1).hgj, "", "");
        ad.d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + str1 + " " + com.tencent.mm.vfs.i.aMN(str1));
        com.tencent.mm.vfs.i.aMN(str1);
        if (!com.tencent.mm.vfs.i.eK(str1)) {
          break label435;
        }
        j = i.a(new i.a(str1, paramhu, paramLinkedList, 3, "_hd")) + i;
        com.tencent.mm.vfs.i.aMN(str2);
        localObject2 = localObject1;
        i = j;
        if (!bt.isNullOrNil(str2))
        {
          localObject2 = localObject1;
          i = j;
          if (!str2.equals(str1))
          {
            ad.d("MicroMsg.BakOldItemImg", "bigImgPath " + str2 + " " + com.tencent.mm.vfs.i.aMN(str2));
            i = j + i.a(new i.a(str2, paramhu, paramLinkedList, 2, false, null));
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        parambl = a((com.tencent.mm.aw.e)localObject2, parambl);
        label482:
        int k;
        int m;
        if (parambl == null)
        {
          AppMethodBeat.o(21845);
          return i;
          i = parambl.field_content.getBytes().length;
          break;
          AppMethodBeat.o(21845);
          return -1;
          ad.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { str1 });
          j = i;
          break label291;
          ad.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but img is null");
          localObject2 = localObject1;
          localObject1 = localObject2;
          j = i;
          break label291;
          if (!((com.tencent.mm.aw.e)localObject1).ayh()) {
            break label985;
          }
          str2 = b.byA().byB().bxQ().p(((com.tencent.mm.aw.e)localObject1).hgj, "", "");
          if (((com.tencent.mm.aw.e)localObject1).ayi()) {
            if (((com.tencent.mm.aw.e)localObject1).ayi())
            {
              localObject2 = b.byA().byB().bxQ().od(((com.tencent.mm.aw.e)localObject1).hgu);
              if (localObject2 != null)
              {
                if (localObject2 != null) {
                  break label886;
                }
                j = -1;
                if (localObject2 != null) {
                  break label896;
                }
                k = -1;
                if (localObject2 != null) {
                  break label906;
                }
                str1 = "null";
                if (localObject2 != null) {
                  break label916;
                }
                m = -1;
                ad.i("MicroMsg.BakOldItemImg", "packet hdinfo off:%d total:%d path:%s, compressType[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), str1, Integer.valueOf(m) });
                if ((localObject2 == null) || (((com.tencent.mm.aw.e)localObject2).hgm != 1)) {
                  break label934;
                }
                if ((localObject2.equals(localObject1)) || (((com.tencent.mm.aw.e)localObject2).offset != ((com.tencent.mm.aw.e)localObject2).gTY)) {
                  break label926;
                }
                str1 = b.byA().byB().bxQ().p(((com.tencent.mm.aw.e)localObject2).hgj, "", "");
                ad.d("MicroMsg.BakOldItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { str1, Long.valueOf(com.tencent.mm.vfs.i.aMN(str1)) });
                if (!com.tencent.mm.vfs.i.eK(str1)) {
                  break label978;
                }
                j = i.a(new i.a(str1, paramhu, paramLinkedList, 3, "_hd"));
                com.tencent.mm.vfs.i.aMN(str1);
                j = i + j;
              }
            }
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          i = j;
          if (!com.tencent.mm.vfs.i.eK(str2)) {
            break;
          }
          com.tencent.mm.vfs.i.aMN(str2);
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
          ad.d("MicroMsg.BakOldItemImg", "bigImgPath " + str2 + " " + com.tencent.mm.vfs.i.aMN(str2));
          i = j + i.a(new i.a(str2, paramhu, paramLinkedList, 2, false, null));
          localObject2 = localObject1;
          break;
          localObject2 = localObject1;
          break label553;
          label886:
          j = ((com.tencent.mm.aw.e)localObject2).offset;
          break label561;
          k = ((com.tencent.mm.aw.e)localObject2).gTY;
          break label569;
          str1 = ((com.tencent.mm.aw.e)localObject2).hgj;
          break label579;
          m = ((com.tencent.mm.aw.e)localObject2).hgm;
          break label587;
          localObject2.equals(localObject1);
          str1 = "";
          j = i;
          continue;
          paramhu.Cxz = new cmf().aEE(parambl);
          j = parambl.length();
          AppMethodBeat.o(21845);
          return i + j;
          j = i;
        }
        localObject2 = localObject1;
      }
    }
  }
  
  public final int a(String paramString, hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21847);
    if ((paramhu == null) || (paramhu.Cxz == null))
    {
      ad.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
      AppMethodBeat.o(21847);
      return 0;
    }
    String str1 = new String(bt.by(paramhu.Cxz.Ehn, ""));
    ad.d("MicroMsg.BakOldItemImg", "recover msg" + paramhu.uKZ + " " + str1);
    int i;
    int j;
    label116:
    Object localObject1;
    label127:
    com.tencent.mm.aw.g localg;
    if (paramhu.CCV == null)
    {
      i = 0;
      j = paramhu.CCX;
      if (paramhu.CCU != null) {
        break label672;
      }
      paramString = "";
      if (paramhu.CCT != null) {
        break label683;
      }
      localObject1 = "";
      ad.d("MicroMsg.BakOldItemImg", "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      parambl.setContent(str1);
      localg = b.byA().byB().bxQ();
      if (parambl.field_isSend != 1) {
        break label695;
      }
      if (parambl.field_msgId != 0L) {
        paramString = localg.ms(parambl.field_msgId);
      }
      if ((paramString != null) && (paramString.deI != 0L)) {
        break label1208;
      }
      paramString = localg.mr(parambl.field_msgSvrId);
    }
    label672:
    label683:
    label695:
    label1208:
    for (;;)
    {
      label233:
      localObject1 = bw.K(str1, "msg");
      if ((localObject1 != null) && (bt.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L) > 0L)) {}
      for (i = 1;; i = 0)
      {
        Object localObject3 = bt.by(a.a(paramhu, 3), "");
        Object localObject2;
        if ((paramhu.CCX == 3) && (paramhu.CCV != null))
        {
          localObject1 = a.bya() + "backupMeida/" + a.Ow((String)localObject3) + (String)localObject3;
          localObject2 = paramhu.CCV.getBufferToBytes();
          com.tencent.mm.vfs.i.e((String)localObject1, (byte[])localObject2, localObject2.length);
        }
        localObject1 = bt.by(a.a(paramhu, 2), "");
        Object localObject4;
        if ((paramhu.CCX == 2) && (paramhu.CCV != null))
        {
          localObject2 = a.bya() + "backupMeida/" + a.Ow((String)localObject1) + (String)localObject1;
          localObject4 = paramhu.CCV.getBufferToBytes();
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
          localObject2 = a.b(paramhu, 1);
          Object localObject5;
          if (localObject2 == null)
          {
            ad.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = a.Oy((String)localObject1);
            localObject4 = com.tencent.mm.b.g.getMessageDigest((bt.eGO() + " ").getBytes());
            localObject5 = a.bya() + "backupMeida/" + a.Ow((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new com.tencent.mm.vfs.e((String)localObject5);
            if (!((com.tencent.mm.vfs.e)localObject5).exists()) {
              ((com.tencent.mm.vfs.e)localObject5).mkdirs();
            }
            j = af.aFv(str2);
            if (j > 0)
            {
              if (af.a((String)localObject2, Bitmap.CompressFormat.JPEG, str2, j)) {
                break label759;
              }
              ad.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
              i = paramhu.CCV.getILen();
              break;
              paramString = paramhu.CCU.toString();
              break label116;
              localObject1 = paramhu.CCT.toString();
              break label127;
              paramString = localg.mr(parambl.field_msgSvrId);
              break label233;
            }
            if (!f.a((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str2))
            {
              ad.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
            }
            ad.d("MicroMsg.BakOldItemImg", "insert: thumbName = ".concat(String.valueOf(localObject4)));
            label759:
            localObject2 = com.tencent.mm.vfs.i.aR(str2, 0, -1);
          }
          while (localObject2 == null)
          {
            ad.e("MicroMsg.BakOldItemImg", "img buf is null");
            AppMethodBeat.o(21847);
            return -1;
            ad.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          }
          localObject4 = localg.p((String)localObject3, "", "");
          String str2 = localg.p((String)localObject1, "", "");
          long l1 = 0L;
          if (paramString.deI == 0L)
          {
            if (i != 0)
            {
              i = a.c(paramhu, 3);
              l2 = localg.a((byte[])localObject2, paramhu.uKZ, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              l1 = l2;
              if (!a.b(paramhu, 3, (String)localObject4))
              {
                ad.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", new Object[] { localObject4 });
                l1 = l2;
              }
            }
            j = a.c(paramhu, 2);
            i = j;
            if (j <= 0) {
              i = a.c(paramhu, 3);
            }
            paramString = new PString();
            localObject3 = new PInt();
            localObject5 = new PInt();
            long l2 = localg.a((byte[])localObject2, paramhu.uKZ, false, (String)localObject1, i, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if (!a.b(paramhu, 2, str2)) {
              ad.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              parambl.nZ(paramString.value);
              parambl.kh(((PInt)localObject3).value);
              parambl.ki(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = b.byA().byB().bxQ().b(Long.valueOf(l2));
                paramString.nY((int)l1);
                b.byA().byB().bxQ().a(Long.valueOf(l2), paramString);
              }
            }
          }
          for (;;)
          {
            d.u(parambl);
            AppMethodBeat.o(21847);
            return 0;
            AppMethodBeat.o(21847);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.e
 * JD-Core Version:    0.7.0.1
 */