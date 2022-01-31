package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
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
import java.io.File;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e
  implements j
{
  private static String a(com.tencent.mm.at.e parame, bi parambi)
  {
    AppMethodBeat.i(17789);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.lA(parambi.field_talker)) {
        localStringWriter.write(bf.pu(parambi.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = br.F(parame.fDX, "msg");
      if (localMap != null)
      {
        localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.img.$aeskey"));
        localXmlSerializer.attribute(null, "encryver", (String)localMap.get(".msg.img.$encryver"));
        localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.img.$cdnthumbaeskey"));
        localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.img.$cdnthumburl"));
        localXmlSerializer.attribute(null, "cdnthumblength", bo.getLong((String)localMap.get(".msg.img.$cdnthumblength"), 10240L));
        localXmlSerializer.attribute(null, "cdnthumbheight", bo.getInt((String)localMap.get(".msg.img.$cdnthumbheight"), 0));
        localXmlSerializer.attribute(null, "cdnthumbwidth", bo.getInt((String)localMap.get(".msg.img.$cdnthumbwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidheight", bo.getInt((String)localMap.get(".msg.img.$cdnmidheight"), 0));
        localXmlSerializer.attribute(null, "cdnmidwidth", bo.getInt((String)localMap.get(".msg.img.$cdnmidwidth"), 0));
        localXmlSerializer.attribute(null, "cdnhdheight", bo.getInt((String)localMap.get(".msg.img.$cdnhdheight"), 0));
        localXmlSerializer.attribute(null, "cdnhdwidth", bo.getInt((String)localMap.get(".msg.img.$cdnhdwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidimgurl", (String)localMap.get(".msg.img.$cdnmidimgurl"));
        long l2 = bo.getLong((String)localMap.get(".msg.img.$length"), 0L);
        StringBuilder localStringBuilder = new StringBuilder();
        long l1 = l2;
        if (l2 == 0L) {
          l1 = com.tencent.mm.a.e.cM(b.aVr().aVs().aUH().q(parame.fDM, "", ""));
        }
        localXmlSerializer.attribute(null, "length", l1);
        if ((parambi.field_isSend != 1) || (parame.fDP == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", bo.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localXmlSerializer.attribute(null, "md5", (String)localMap.get(".msg.img.$md5"));
      }
      localXmlSerializer.endTag(null, "img");
      localXmlSerializer.endTag(null, "msg");
      localXmlSerializer.endDocument();
      localStringWriter.flush();
      localStringWriter.close();
      parame = localStringWriter.getBuffer().toString();
      ab.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", new Object[] { parame });
      AppMethodBeat.o(17789);
      return parame;
    }
    catch (Exception parame)
    {
      ab.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + parame.toString());
      AppMethodBeat.o(17789);
    }
    return null;
  }
  
  public final int a(gx paramgx, bi parambi, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(17788);
    int i;
    Object localObject1;
    if (bo.isNullOrNil(parambi.field_content))
    {
      i = 0;
      if (parambi.field_isSend == 1)
      {
        localObject1 = b.aVr().aVs().aUH().gT(parambi.field_msgId);
        if (((com.tencent.mm.at.e)localObject1).fDL != 0L) {
          break label992;
        }
      }
      localObject1 = b.aVr().aVs().aUH().gS(parambi.field_msgSvrId);
    }
    label291:
    label435:
    label459:
    label471:
    label985:
    label992:
    for (;;)
    {
      Object localObject2 = b.aVr().aVs().aUH().J(parambi.field_imgPath, true);
      String str1;
      String str2;
      int j;
      if (com.tencent.mm.a.e.cN((String)localObject2))
      {
        i += i.a(new i.a((String)localObject2, paramgx, paramLinkedList, 1, "_thumb"));
        if (parambi.field_isSend != 1) {
          break label482;
        }
        str1 = "";
        str2 = b.aVr().aVs().aUH().q(((com.tencent.mm.at.e)localObject1).fDM, "", "");
        localObject2 = localObject1;
        if (!((com.tencent.mm.at.e)localObject1).ahh()) {
          break label471;
        }
        localObject1 = b.aVr().aVs().aUH().lv(((com.tencent.mm.at.e)localObject1).fDW);
        if (localObject1 == null) {
          break label459;
        }
        str1 = b.aVr().aVs().aUH().q(((com.tencent.mm.at.e)localObject1).fDM, "", "");
        ab.d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + str1 + " " + com.tencent.mm.a.e.cM(str1));
        com.tencent.mm.a.e.cM(str1);
        if (!com.tencent.mm.a.e.cN(str1)) {
          break label435;
        }
        j = i.a(new i.a(str1, paramgx, paramLinkedList, 3, "_hd")) + i;
        com.tencent.mm.a.e.cM(str2);
        localObject2 = localObject1;
        i = j;
        if (!bo.isNullOrNil(str2))
        {
          localObject2 = localObject1;
          i = j;
          if (!str2.equals(str1))
          {
            ab.d("MicroMsg.BakOldItemImg", "bigImgPath " + str2 + " " + com.tencent.mm.a.e.cM(str2));
            i = j + i.a(new i.a(str2, paramgx, paramLinkedList, 2, false, null));
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        parambi = a((com.tencent.mm.at.e)localObject2, parambi);
        label482:
        int k;
        int m;
        if (parambi == null)
        {
          AppMethodBeat.o(17788);
          return i;
          i = parambi.field_content.getBytes().length;
          break;
          AppMethodBeat.o(17788);
          return -1;
          ab.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { str1 });
          j = i;
          break label291;
          ab.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but img is null");
          localObject2 = localObject1;
          localObject1 = localObject2;
          j = i;
          break label291;
          if (!((com.tencent.mm.at.e)localObject1).ahg()) {
            break label985;
          }
          str2 = b.aVr().aVs().aUH().q(((com.tencent.mm.at.e)localObject1).fDM, "", "");
          if (((com.tencent.mm.at.e)localObject1).ahh()) {
            if (((com.tencent.mm.at.e)localObject1).ahh())
            {
              localObject2 = b.aVr().aVs().aUH().lv(((com.tencent.mm.at.e)localObject1).fDW);
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
                ab.i("MicroMsg.BakOldItemImg", "packet hdinfo off:%d total:%d path:%s, compressType[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), str1, Integer.valueOf(m) });
                if ((localObject2 == null) || (((com.tencent.mm.at.e)localObject2).fDP != 1)) {
                  break label934;
                }
                if ((localObject2.equals(localObject1)) || (((com.tencent.mm.at.e)localObject2).offset != ((com.tencent.mm.at.e)localObject2).fsd)) {
                  break label926;
                }
                str1 = b.aVr().aVs().aUH().q(((com.tencent.mm.at.e)localObject2).fDM, "", "");
                ab.d("MicroMsg.BakOldItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { str1, Integer.valueOf(com.tencent.mm.a.e.cM(str1)) });
                if (!com.tencent.mm.a.e.cN(str1)) {
                  break label978;
                }
                j = i.a(new i.a(str1, paramgx, paramLinkedList, 3, "_hd"));
                com.tencent.mm.a.e.cM(str1);
                j = i + j;
              }
            }
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          i = j;
          if (!com.tencent.mm.a.e.cN(str2)) {
            break;
          }
          com.tencent.mm.a.e.cM(str2);
          localObject2 = localObject1;
          i = j;
          if (bo.isNullOrNil(str2)) {
            break;
          }
          localObject2 = localObject1;
          i = j;
          if (str2.equals(str1)) {
            break;
          }
          ab.d("MicroMsg.BakOldItemImg", "bigImgPath " + str2 + " " + com.tencent.mm.a.e.cM(str2));
          i = j + i.a(new i.a(str2, paramgx, paramLinkedList, 2, false, null));
          localObject2 = localObject1;
          break;
          localObject2 = localObject1;
          break label553;
          label886:
          j = ((com.tencent.mm.at.e)localObject2).offset;
          break label561;
          k = ((com.tencent.mm.at.e)localObject2).fsd;
          break label569;
          str1 = ((com.tencent.mm.at.e)localObject2).fDM;
          break label579;
          m = ((com.tencent.mm.at.e)localObject2).fDP;
          break label587;
          localObject2.equals(localObject1);
          str1 = "";
          j = i;
          continue;
          paramgx.woR = new bwc().aoF(parambi);
          j = parambi.length();
          AppMethodBeat.o(17788);
          return i + j;
          j = i;
        }
        localObject2 = localObject1;
      }
    }
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17790);
    if ((paramgx == null) || (paramgx.woR == null))
    {
      ab.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
      AppMethodBeat.o(17790);
      return 0;
    }
    String str1 = new String(bo.bf(paramgx.woR.xJE, ""));
    ab.d("MicroMsg.BakOldItemImg", "recover msg" + paramgx.pIG + " " + str1);
    int i;
    int j;
    label116:
    Object localObject1;
    label127:
    com.tencent.mm.at.g localg;
    if (paramgx.wtq == null)
    {
      i = 0;
      j = paramgx.wts;
      if (paramgx.wtp != null) {
        break label644;
      }
      paramString = "";
      if (paramgx.wto != null) {
        break label655;
      }
      localObject1 = "";
      ab.d("MicroMsg.BakOldItemImg", "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      parambi.setContent(str1);
      localg = b.aVr().aVs().aUH();
      if (parambi.field_isSend != 1) {
        break label667;
      }
      if (parambi.field_msgId != 0L) {
        paramString = localg.gT(parambi.field_msgId);
      }
      if ((paramString != null) && (paramString.fDL != 0L)) {
        break label1180;
      }
      paramString = localg.gS(parambi.field_msgSvrId);
    }
    label644:
    label655:
    label667:
    label1180:
    for (;;)
    {
      label233:
      localObject1 = br.F(str1, "msg");
      if ((localObject1 != null) && (bo.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L) > 0L)) {}
      for (i = 1;; i = 0)
      {
        Object localObject3 = bo.bf(a.a(paramgx, 3), "");
        if ((paramgx.wts == 3) && (paramgx.wtq != null)) {
          com.tencent.mm.a.e.b(a.aUR() + "backupMeida/" + a.Gi((String)localObject3), (String)localObject3, paramgx.wtq.getBufferToBytes());
        }
        localObject1 = bo.bf(a.a(paramgx, 2), "");
        if ((paramgx.wts == 2) && (paramgx.wtq != null)) {
          com.tencent.mm.a.e.b(a.aUR() + "backupMeida/" + a.Gi((String)localObject1), (String)localObject1, paramgx.wtq.getBufferToBytes());
        }
        ab.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (bo.isNullOrNil((String)localObject1))
        {
          ab.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          Object localObject2 = a.b(paramgx, 1);
          Object localObject4;
          if (localObject2 == null)
          {
            ab.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = a.Gw((String)localObject1);
            str2 = com.tencent.mm.a.g.w((bo.aoy() + " ").getBytes());
            localObject4 = a.aUR() + "backupMeida/" + a.Gi(str2);
            str3 = (String)localObject4 + str2;
            localObject4 = new File((String)localObject4);
            if (!((File)localObject4).exists()) {
              ((File)localObject4).mkdirs();
            }
            j = ad.api(str3);
            if (j > 0)
            {
              if (ad.a((String)localObject2, Bitmap.CompressFormat.JPEG, str3, j)) {
                break label731;
              }
              ab.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(17790);
              return -1;
              i = paramgx.wtq.getILen();
              break;
              paramString = paramgx.wtp.toString();
              break label116;
              localObject1 = paramgx.wto.toString();
              break label127;
              paramString = localg.gS(parambi.field_msgSvrId);
              break label233;
            }
            if (!com.tencent.mm.sdk.platformtools.d.a((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str3))
            {
              ab.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
              AppMethodBeat.o(17790);
              return -1;
            }
            ab.d("MicroMsg.BakOldItemImg", "insert: thumbName = ".concat(String.valueOf(str2)));
            label731:
            localObject2 = com.tencent.mm.a.e.j(str3, 0, -1);
          }
          while (localObject2 == null)
          {
            ab.e("MicroMsg.BakOldItemImg", "img buf is null");
            AppMethodBeat.o(17790);
            return -1;
            ab.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          }
          String str2 = localg.q((String)localObject3, "", "");
          String str3 = localg.q((String)localObject1, "", "");
          long l1 = 0L;
          if (paramString.fDL == 0L)
          {
            if (i != 0)
            {
              i = a.c(paramgx, 3);
              l2 = localg.a((byte[])localObject2, paramgx.pIG, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              l1 = l2;
              if (!a.b(paramgx, 3, str2))
              {
                ab.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", new Object[] { str2 });
                l1 = l2;
              }
            }
            j = a.c(paramgx, 2);
            i = j;
            if (j <= 0) {
              i = a.c(paramgx, 3);
            }
            paramString = new PString();
            localObject3 = new PInt();
            localObject4 = new PInt();
            long l2 = localg.a((byte[])localObject2, paramgx.pIG, false, (String)localObject1, i, str1, paramString, (PInt)localObject3, (PInt)localObject4);
            if (!a.b(paramgx, 2, str3)) {
              ab.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", new Object[] { str2 });
            }
            if (l2 > 0L)
            {
              parambi.kk(paramString.value);
              parambi.hW(((PInt)localObject3).value);
              parambi.hX(((PInt)localObject4).value);
              if (l1 > 0L)
              {
                paramString = b.aVr().aVs().aUH().b(Long.valueOf(l2));
                paramString.lr((int)l1);
                b.aVr().aVs().aUH().a(Long.valueOf(l2), paramString);
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.backup.bakoldlogic.d.d.l(parambi);
            AppMethodBeat.o(17790);
            return 0;
            AppMethodBeat.o(17790);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.e
 * JD-Core Version:    0.7.0.1
 */