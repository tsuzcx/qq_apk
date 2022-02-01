package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
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
  private static String a(com.tencent.mm.av.g paramg, bv parambv)
  {
    AppMethodBeat.i(21514);
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer;
    try
    {
      localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (c.wb(parambv.field_talker)) {
        localStringWriter.write(bl.BM(parambv.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = bx.M(paramg.icA, "msg");
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
        if (bu.getLong((String)localMap.get(".msg.img.$length"), 0L) == 0L) {
          localXmlSerializer.attribute(null, "length", o.aZR(com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().o(paramg.ico, "", "")));
        }
        if ((parambv.field_isSend != 1) || (paramg.icr == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", bu.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localMap.remove(".msg.img.$cdnbigimgurl");
        localMap.remove(".msg.img.$hdlength");
        if (localMap.get(".msg.img.$md5") == null) {
          localXmlSerializer.attribute(null, "md5", "");
        }
        paramg = localMap.keySet().iterator();
        while (paramg.hasNext())
        {
          parambv = (String)paramg.next();
          if (parambv.startsWith(".msg.img.$")) {
            localXmlSerializer.attribute(null, parambv.substring(10), (String)localMap.get(parambv));
          }
        }
      }
      localXmlSerializer.endTag(null, "img");
    }
    catch (Exception paramg)
    {
      ae.e("MicroMsg.BackupItemImg", "packetImg xml error: " + paramg.toString());
      AppMethodBeat.o(21514);
      return null;
    }
    localXmlSerializer.endTag(null, "msg");
    localXmlSerializer.endDocument();
    localStringWriter.flush();
    localStringWriter.close();
    paramg = localStringWriter.getBuffer().toString();
    ae.d("MicroMsg.BackupItemImg", "parseContent xml:%s", new Object[] { paramg });
    AppMethodBeat.o(21514);
    return paramg;
  }
  
  public final int a(if paramif, boolean paramBoolean1, bv parambv, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21513);
    int j;
    if (bu.isNullOrNil(parambv.field_content))
    {
      j = 0;
      if (parambv.field_isSend == 1)
      {
        paramString = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().G(parambv.field_talker, parambv.field_msgId);
        if (paramString.doE != 0L) {
          break label989;
        }
      }
      paramString = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().F(parambv.field_talker, parambv.field_msgSvrId);
    }
    label320:
    label580:
    label989:
    for (;;)
    {
      paramHashMap = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().R(parambv.field_imgPath, true);
      int i = j;
      if (o.fB(paramHashMap)) {
        i = j + i.a(new i.a(paramHashMap, paramif, paramLinkedList, 1, paramBoolean1, "_thumb", paramBoolean2));
      }
      Object localObject1;
      int k;
      if (parambv.field_isSend == 1)
      {
        localObject2 = "";
        str = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().o(paramString.ico, "", "");
        localObject1 = localObject2;
        k = i;
        paramHashMap = paramString;
        if (paramString.aIB())
        {
          paramHashMap = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().pw(paramString.icz);
          if (paramHashMap == null) {
            break label485;
          }
          localObject1 = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().o(paramHashMap.ico, "", "");
          ae.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + (String)localObject1 + " " + o.aZR((String)localObject1));
          o.aZR((String)localObject1);
          if (o.fB((String)localObject1)) {
            k = i + i.a(new i.a((String)localObject1, paramif, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
          }
        }
        else
        {
          o.aZR(str);
          j = k;
          localObject2 = paramHashMap;
          if (!bu.isNullOrNil(str))
          {
            j = k;
            localObject2 = paramHashMap;
            if (!str.equals(localObject1))
            {
              ae.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + o.aZR(str));
              j = k + i.a(new i.a(str, paramif, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
              localObject2 = paramHashMap;
            }
          }
        }
      }
      label485:
      do
      {
        parambv = a((com.tencent.mm.av.g)localObject2, parambv);
        if (parambv != null) {
          break label956;
        }
        AppMethodBeat.o(21513);
        return j;
        j = parambv.field_content.getBytes().length;
        break;
        ae.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { localObject1 });
        k = i;
        break label320;
        ae.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
        localObject1 = localObject2;
        k = i;
        break label320;
        j = i;
        localObject2 = paramString;
      } while (!paramString.aIA());
      String str = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().o(paramString.ico, "", "");
      Object localObject2 = "";
      if (paramString.aIB())
      {
        localObject1 = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().pw(paramString.icz);
        if (localObject1 != null)
        {
          if (localObject1 != null) {
            ae.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", new Object[] { Integer.valueOf(((com.tencent.mm.av.g)localObject1).offset), Integer.valueOf(((com.tencent.mm.av.g)localObject1).hPI), Integer.valueOf(((com.tencent.mm.av.g)localObject1).icr), ((com.tencent.mm.av.g)localObject1).ico });
          }
          paramHashMap = (HashMap<Long, h.a>)localObject2;
          k = i;
          if (localObject1 != null)
          {
            paramHashMap = (HashMap<Long, h.a>)localObject2;
            k = i;
            if (((com.tencent.mm.av.g)localObject1).icr == 1)
            {
              if ((localObject1.equals(paramString)) || (((com.tencent.mm.av.g)localObject1).hPI <= 0) || (((com.tencent.mm.av.g)localObject1).offset != ((com.tencent.mm.av.g)localObject1).hPI)) {
                break label937;
              }
              localObject1 = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().o(((com.tencent.mm.av.g)localObject1).ico, "", "");
              ae.d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject1, Long.valueOf(o.aZR((String)localObject1)) });
              paramHashMap = (HashMap<Long, h.a>)localObject1;
              k = i;
              if (o.fB((String)localObject1))
              {
                k = i + i.a(new i.a((String)localObject1, paramif, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
                o.aZR((String)localObject1);
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
        if (!o.fB(str)) {
          break;
        }
        o.aZR(str);
        j = k;
        localObject2 = paramString;
        if (bu.isNullOrNil(str)) {
          break;
        }
        j = k;
        localObject2 = paramString;
        if (str.equals(paramHashMap)) {
          break;
        }
        ae.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + o.aZR(str));
        j = k + i.a(new i.a(str, paramif, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
        localObject2 = paramString;
        break;
        localObject1 = null;
        break label580;
        localObject1.equals(paramString);
        paramHashMap = (HashMap<Long, h.a>)localObject2;
        k = i;
      }
      paramif.FNI = new cxn().aQV(parambv);
      i = parambv.length();
      AppMethodBeat.o(21513);
      return j + i;
    }
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    AppMethodBeat.i(21515);
    if ((paramif == null) || (paramif.FNI == null))
    {
      ae.e("MicroMsg.BackupItemImg", "recover bakitem/Content is null");
      AppMethodBeat.o(21515);
      return 0;
    }
    String str1 = bu.bI(paramif.FNI.HId, "");
    long l1 = paramif.xrk;
    int i;
    int j;
    label80:
    Object localObject1;
    label91:
    com.tencent.mm.av.i locali;
    if (paramif.FTj == null)
    {
      i = 0;
      j = paramif.FTl;
      if (paramif.FTi != null) {
        break label598;
      }
      paramString = "";
      if (paramif.FTh != null) {
        break label609;
      }
      localObject1 = "";
      ae.d("MicroMsg.BackupItemImg", "recover, msgId:%d, content:%s, backupItemImg buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      if (str1 != null) {
        parambv.setContent(str1);
      }
      locali = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT();
      if (parambv.field_isSend != 1) {
        break label621;
      }
      if (parambv.field_msgId != 0L) {
        paramString = locali.G(parambv.field_talker, parambv.field_msgId);
      }
      if ((paramString != null) && (paramString.doE != 0L)) {
        break label1290;
      }
      paramString = locali.F(parambv.field_talker, parambv.field_msgSvrId);
    }
    label1154:
    label1290:
    for (;;)
    {
      label225:
      localObject1 = bx.M(str1, "msg");
      l1 = 0L;
      long l2;
      if (localObject1 != null)
      {
        l2 = bu.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L);
        l1 = l2;
        if (l2 > 0L) {
          i = 1;
        }
      }
      for (long l3 = l2;; l3 = l1)
      {
        Object localObject3 = bu.bI(com.tencent.mm.plugin.backup.b.g.a(paramif, 3), "");
        if ((paramif.FTl == 3) && (paramif.FTj != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.WC((String)localObject3), (String)localObject3, paramif.FTj.getBufferToBytes());
        }
        localObject1 = bu.bI(com.tencent.mm.plugin.backup.b.g.a(paramif, 2), "");
        if ((paramif.FTl == 2) && (paramif.FTj != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.WC((String)localObject1), (String)localObject1, paramif.FTj.getBufferToBytes());
        }
        ae.d("MicroMsg.BackupItemImg", "hdName:%s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (bu.isNullOrNil((String)localObject1))
        {
          ae.d("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
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
            ae.d("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = com.tencent.mm.plugin.backup.b.g.WC((String)localObject1) + (String)localObject1;
            localObject4 = com.tencent.mm.b.g.getMessageDigest((bu.fpO() + " ").getBytes());
            localObject5 = com.tencent.mm.plugin.backup.b.g.WC((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new k((String)localObject5);
            if (!((k)localObject5).exists()) {
              ((k)localObject5).mkdirs();
            }
            j = ag.aRP(str2);
            if (j > 0)
            {
              if (ag.a((String)localObject2, Bitmap.CompressFormat.JPEG, str2, j)) {
                break label691;
              }
              ae.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
              i = paramif.FTj.getILen();
              break;
              label598:
              paramString = paramif.FTi.toString();
              break label80;
              label609:
              localObject1 = paramif.FTh.toString();
              break label91;
              label621:
              paramString = locali.F(parambv.field_talker, parambv.field_msgSvrId);
              break label225;
            }
            if (!h.a((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str2))
            {
              ae.e("MicroMsg.BackupItemImg", "createThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
            }
            ae.d("MicroMsg.BackupItemImg", "insert: thumbName = ".concat(String.valueOf(localObject4)));
            label691:
            localObject4 = o.bb(str2, 0, -1);
            localObject2 = localObject4;
            if (localObject4 != null) {
              break label748;
            }
            ae.e("MicroMsg.BackupItemImg", "img buf is null");
            AppMethodBeat.o(21515);
            return -1;
          }
          ae.d("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          label748:
          Object localObject4 = locali.o((String)localObject3, "", "");
          String str2 = locali.o((String)localObject1, "", "");
          l2 = 0L;
          int k;
          boolean bool;
          if (paramString.doE == 0L)
          {
            j = com.tencent.mm.plugin.backup.b.g.c(paramif, 2);
            k = 1;
            if (i != 0)
            {
              i = com.tencent.mm.plugin.backup.b.g.c(paramif, 3);
              l1 = locali.a(parambv.field_talker, (byte[])localObject2, paramif.xrk, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
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
                ae.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[] { str2 });
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
            l2 = locali.a(parambv.field_talker, (byte[])localObject2, paramif.xrk, false, (String)localObject1, j, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if ((i != 0) && (!com.tencent.mm.plugin.backup.b.g.b(paramif, 2, str2))) {
              ae.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              parambv.uj(paramString.value);
              parambv.kD(((PInt)localObject3).value);
              parambv.kE(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().c(Long.valueOf(l2));
                paramString.pr((int)l1);
                com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJT().a(Long.valueOf(l2), paramString);
              }
            }
            for (;;)
            {
              c.v(parambv);
              AppMethodBeat.o(21515);
              return 0;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramif, 3, (String)localObject4);
              break;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramif, 3, str2);
              break label907;
              ae.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[] { str2 });
              i = k;
              break label933;
              ae.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[] { localObject4 });
              l2 = l1;
              l1 = l2;
              i = k;
              break label933;
              AppMethodBeat.o(21515);
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
        label1179:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.d
 * JD-Core Version:    0.7.0.1
 */