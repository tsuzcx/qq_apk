package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e
  implements j
{
  private static String a(com.tencent.mm.av.g paramg, bv parambv)
  {
    AppMethodBeat.i(21846);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (d.wb(parambv.field_talker)) {
        localStringWriter.write(bl.BM(parambv.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = bx.M(paramg.icA, "msg");
      if (localMap != null)
      {
        localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.img.$aeskey"));
        localXmlSerializer.attribute(null, "encryver", (String)localMap.get(".msg.img.$encryver"));
        localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.img.$cdnthumbaeskey"));
        localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.img.$cdnthumburl"));
        localXmlSerializer.attribute(null, "cdnthumblength", bu.getLong((String)localMap.get(".msg.img.$cdnthumblength"), 10240L));
        localXmlSerializer.attribute(null, "cdnthumbheight", bu.getInt((String)localMap.get(".msg.img.$cdnthumbheight"), 0));
        localXmlSerializer.attribute(null, "cdnthumbwidth", bu.getInt((String)localMap.get(".msg.img.$cdnthumbwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidheight", bu.getInt((String)localMap.get(".msg.img.$cdnmidheight"), 0));
        localXmlSerializer.attribute(null, "cdnmidwidth", bu.getInt((String)localMap.get(".msg.img.$cdnmidwidth"), 0));
        localXmlSerializer.attribute(null, "cdnhdheight", bu.getInt((String)localMap.get(".msg.img.$cdnhdheight"), 0));
        localXmlSerializer.attribute(null, "cdnhdwidth", bu.getInt((String)localMap.get(".msg.img.$cdnhdwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidimgurl", (String)localMap.get(".msg.img.$cdnmidimgurl"));
        long l2 = bu.getLong((String)localMap.get(".msg.img.$length"), 0L);
        StringBuilder localStringBuilder = new StringBuilder();
        long l1 = l2;
        if (l2 == 0L) {
          l1 = o.aZR(b.bKD().bKE().bJT().o(paramg.ico, "", ""));
        }
        localXmlSerializer.attribute(null, "length", l1);
        if ((parambv.field_isSend != 1) || (paramg.icr == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", bu.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localXmlSerializer.attribute(null, "md5", (String)localMap.get(".msg.img.$md5"));
      }
      localXmlSerializer.endTag(null, "img");
      localXmlSerializer.endTag(null, "msg");
      localXmlSerializer.endDocument();
      localStringWriter.flush();
      localStringWriter.close();
      paramg = localStringWriter.getBuffer().toString();
      ae.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", new Object[] { paramg });
      AppMethodBeat.o(21846);
      return paramg;
    }
    catch (Exception paramg)
    {
      ae.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + paramg.toString());
      AppMethodBeat.o(21846);
    }
    return null;
  }
  
  public final int a(if paramif, bv parambv, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21845);
    int i;
    Object localObject1;
    if (bu.isNullOrNil(parambv.field_content))
    {
      i = 0;
      if (parambv.field_isSend == 1)
      {
        localObject1 = b.bKD().bKE().bJT().G(parambv.field_talker, parambv.field_msgId);
        if (((com.tencent.mm.av.g)localObject1).doE != 0L) {
          break label1000;
        }
      }
      localObject1 = b.bKD().bKE().bJT().F(parambv.field_talker, parambv.field_msgSvrId);
    }
    label299:
    label443:
    label467:
    label479:
    label993:
    label1000:
    for (;;)
    {
      Object localObject2 = b.bKD().bKE().bJT().R(parambv.field_imgPath, true);
      String str1;
      String str2;
      int j;
      if (o.fB((String)localObject2))
      {
        i += i.a(new i.a((String)localObject2, paramif, paramLinkedList, 1, "_thumb"));
        if (parambv.field_isSend != 1) {
          break label490;
        }
        str1 = "";
        str2 = b.bKD().bKE().bJT().o(((com.tencent.mm.av.g)localObject1).ico, "", "");
        localObject2 = localObject1;
        if (!((com.tencent.mm.av.g)localObject1).aIB()) {
          break label479;
        }
        localObject1 = b.bKD().bKE().bJT().pw(((com.tencent.mm.av.g)localObject1).icz);
        if (localObject1 == null) {
          break label467;
        }
        str1 = b.bKD().bKE().bJT().o(((com.tencent.mm.av.g)localObject1).ico, "", "");
        ae.d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + str1 + " " + o.aZR(str1));
        o.aZR(str1);
        if (!o.fB(str1)) {
          break label443;
        }
        j = i.a(new i.a(str1, paramif, paramLinkedList, 3, "_hd")) + i;
        o.aZR(str2);
        localObject2 = localObject1;
        i = j;
        if (!bu.isNullOrNil(str2))
        {
          localObject2 = localObject1;
          i = j;
          if (!str2.equals(str1))
          {
            ae.d("MicroMsg.BakOldItemImg", "bigImgPath " + str2 + " " + o.aZR(str2));
            i = j + i.a(new i.a(str2, paramif, paramLinkedList, 2, false, null));
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        parambv = a((com.tencent.mm.av.g)localObject2, parambv);
        label490:
        int k;
        int m;
        if (parambv == null)
        {
          AppMethodBeat.o(21845);
          return i;
          i = parambv.field_content.getBytes().length;
          break;
          AppMethodBeat.o(21845);
          return -1;
          ae.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { str1 });
          j = i;
          break label299;
          ae.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but img is null");
          localObject2 = localObject1;
          localObject1 = localObject2;
          j = i;
          break label299;
          if (!((com.tencent.mm.av.g)localObject1).aIA()) {
            break label993;
          }
          str2 = b.bKD().bKE().bJT().o(((com.tencent.mm.av.g)localObject1).ico, "", "");
          if (((com.tencent.mm.av.g)localObject1).aIB()) {
            if (((com.tencent.mm.av.g)localObject1).aIB())
            {
              localObject2 = b.bKD().bKE().bJT().pw(((com.tencent.mm.av.g)localObject1).icz);
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
                ae.i("MicroMsg.BakOldItemImg", "packet hdinfo off:%d total:%d path:%s, compressType[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), str1, Integer.valueOf(m) });
                if ((localObject2 == null) || (((com.tencent.mm.av.g)localObject2).icr != 1)) {
                  break label942;
                }
                if ((localObject2.equals(localObject1)) || (((com.tencent.mm.av.g)localObject2).offset != ((com.tencent.mm.av.g)localObject2).hPI)) {
                  break label934;
                }
                str1 = b.bKD().bKE().bJT().o(((com.tencent.mm.av.g)localObject2).ico, "", "");
                ae.d("MicroMsg.BakOldItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { str1, Long.valueOf(o.aZR(str1)) });
                if (!o.fB(str1)) {
                  break label986;
                }
                j = i.a(new i.a(str1, paramif, paramLinkedList, 3, "_hd"));
                o.aZR(str1);
                j = i + j;
              }
            }
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          i = j;
          if (!o.fB(str2)) {
            break;
          }
          o.aZR(str2);
          localObject2 = localObject1;
          i = j;
          if (bu.isNullOrNil(str2)) {
            break;
          }
          localObject2 = localObject1;
          i = j;
          if (str2.equals(str1)) {
            break;
          }
          ae.d("MicroMsg.BakOldItemImg", "bigImgPath " + str2 + " " + o.aZR(str2));
          i = j + i.a(new i.a(str2, paramif, paramLinkedList, 2, false, null));
          localObject2 = localObject1;
          break;
          localObject2 = localObject1;
          break label561;
          label894:
          j = ((com.tencent.mm.av.g)localObject2).offset;
          break label569;
          k = ((com.tencent.mm.av.g)localObject2).hPI;
          break label577;
          str1 = ((com.tencent.mm.av.g)localObject2).ico;
          break label587;
          m = ((com.tencent.mm.av.g)localObject2).icr;
          break label595;
          localObject2.equals(localObject1);
          str1 = "";
          j = i;
          continue;
          paramif.FNI = new cxn().aQV(parambv);
          j = parambv.length();
          AppMethodBeat.o(21845);
          return i + j;
          j = i;
        }
        localObject2 = localObject1;
      }
    }
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    AppMethodBeat.i(21847);
    if ((paramif == null) || (paramif.FNI == null))
    {
      ae.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
      AppMethodBeat.o(21847);
      return 0;
    }
    String str1 = new String(bu.bI(paramif.FNI.HId, ""));
    ae.d("MicroMsg.BakOldItemImg", "recover msg" + paramif.xrk + " " + str1);
    int i;
    int j;
    label116:
    Object localObject1;
    label127:
    com.tencent.mm.av.i locali;
    if (paramif.FTj == null)
    {
      i = 0;
      j = paramif.FTl;
      if (paramif.FTi != null) {
        break label680;
      }
      paramString = "";
      if (paramif.FTh != null) {
        break label691;
      }
      localObject1 = "";
      ae.d("MicroMsg.BakOldItemImg", "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      parambv.setContent(str1);
      locali = b.bKD().bKE().bJT();
      if (parambv.field_isSend != 1) {
        break label703;
      }
      if (parambv.field_msgId != 0L) {
        paramString = locali.G(parambv.field_talker, parambv.field_msgId);
      }
      if ((paramString != null) && (paramString.doE != 0L)) {
        break label1228;
      }
      paramString = locali.F(parambv.field_talker, parambv.field_msgSvrId);
    }
    label680:
    label691:
    label703:
    label1228:
    for (;;)
    {
      label241:
      localObject1 = bx.M(str1, "msg");
      if ((localObject1 != null) && (bu.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L) > 0L)) {}
      for (i = 1;; i = 0)
      {
        Object localObject3 = bu.bI(a.a(paramif, 3), "");
        Object localObject2;
        if ((paramif.FTl == 3) && (paramif.FTj != null))
        {
          localObject1 = a.bKd() + "backupMeida/" + a.WQ((String)localObject3) + (String)localObject3;
          localObject2 = paramif.FTj.getBufferToBytes();
          o.e((String)localObject1, (byte[])localObject2, localObject2.length);
        }
        localObject1 = bu.bI(a.a(paramif, 2), "");
        Object localObject4;
        if ((paramif.FTl == 2) && (paramif.FTj != null))
        {
          localObject2 = a.bKd() + "backupMeida/" + a.WQ((String)localObject1) + (String)localObject1;
          localObject4 = paramif.FTj.getBufferToBytes();
          o.e((String)localObject2, (byte[])localObject4, localObject4.length);
        }
        ae.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (bu.isNullOrNil((String)localObject1))
        {
          ae.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          localObject2 = a.b(paramif, 1);
          Object localObject5;
          if (localObject2 == null)
          {
            ae.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = a.WS((String)localObject1);
            localObject4 = com.tencent.mm.b.g.getMessageDigest((bu.fpO() + " ").getBytes());
            localObject5 = a.bKd() + "backupMeida/" + a.WQ((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new k((String)localObject5);
            if (!((k)localObject5).exists()) {
              ((k)localObject5).mkdirs();
            }
            j = ag.aRP(str2);
            if (j > 0)
            {
              if (ag.a((String)localObject2, Bitmap.CompressFormat.JPEG, str2, j)) {
                break label771;
              }
              ae.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
              i = paramif.FTj.getILen();
              break;
              paramString = paramif.FTi.toString();
              break label116;
              localObject1 = paramif.FTh.toString();
              break label127;
              paramString = locali.F(parambv.field_talker, parambv.field_msgSvrId);
              break label241;
            }
            if (!h.a((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str2))
            {
              ae.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
            }
            ae.d("MicroMsg.BakOldItemImg", "insert: thumbName = ".concat(String.valueOf(localObject4)));
            localObject2 = o.bb(str2, 0, -1);
          }
          while (localObject2 == null)
          {
            ae.e("MicroMsg.BakOldItemImg", "img buf is null");
            AppMethodBeat.o(21847);
            return -1;
            ae.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          }
          localObject4 = locali.o((String)localObject3, "", "");
          String str2 = locali.o((String)localObject1, "", "");
          long l1 = 0L;
          if (paramString.doE == 0L)
          {
            if (i != 0)
            {
              i = a.c(paramif, 3);
              l2 = locali.a(parambv.field_talker, (byte[])localObject2, paramif.xrk, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              l1 = l2;
              if (!a.b(paramif, 3, (String)localObject4))
              {
                ae.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", new Object[] { localObject4 });
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
            long l2 = locali.a(parambv.field_talker, (byte[])localObject2, paramif.xrk, false, (String)localObject1, i, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if (!a.b(paramif, 2, str2)) {
              ae.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              parambv.uj(paramString.value);
              parambv.kD(((PInt)localObject3).value);
              parambv.kE(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = b.bKD().bKE().bJT().c(Long.valueOf(l2));
                paramString.pr((int)l1);
                b.bKD().bKE().bJT().a(Long.valueOf(l2), paramString);
              }
            }
          }
          for (;;)
          {
            d.v(parambv);
            AppMethodBeat.o(21847);
            return 0;
            AppMethodBeat.o(21847);
            return -1;
            paramif = paramString.icq;
            if ((paramif != null) && (paramif.startsWith("THUMBNAIL_DIRPATH://"))) {
              parambv.uj(paramif);
            } else {
              parambv.uj("THUMBNAIL://" + paramString.doE);
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