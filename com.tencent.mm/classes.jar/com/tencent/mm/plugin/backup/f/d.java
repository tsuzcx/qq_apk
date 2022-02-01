package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bo;
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
  private static String a(com.tencent.mm.av.e parame, bo parambo)
  {
    AppMethodBeat.i(21514);
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer;
    try
    {
      localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (c.sQ(parambo.field_talker)) {
        localStringWriter.write(bi.yl(parambo.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = bv.L(parame.hGY, "msg");
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
        if (bs.getLong((String)localMap.get(".msg.img.$length"), 0L) == 0L) {
          localXmlSerializer.attribute(null, "length", com.tencent.mm.vfs.i.aSp(com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().p(parame.hGM, "", "")));
        }
        if ((parambo.field_isSend != 1) || (parame.hGP == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", bs.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localMap.remove(".msg.img.$cdnbigimgurl");
        localMap.remove(".msg.img.$hdlength");
        if (localMap.get(".msg.img.$md5") == null) {
          localXmlSerializer.attribute(null, "md5", "");
        }
        parame = localMap.keySet().iterator();
        while (parame.hasNext())
        {
          parambo = (String)parame.next();
          if (parambo.startsWith(".msg.img.$")) {
            localXmlSerializer.attribute(null, parambo.substring(10), (String)localMap.get(parambo));
          }
        }
      }
      localXmlSerializer.endTag(null, "img");
    }
    catch (Exception parame)
    {
      ac.e("MicroMsg.BackupItemImg", "packetImg xml error: " + parame.toString());
      AppMethodBeat.o(21514);
      return null;
    }
    localXmlSerializer.endTag(null, "msg");
    localXmlSerializer.endDocument();
    localStringWriter.flush();
    localStringWriter.close();
    parame = localStringWriter.getBuffer().toString();
    ac.d("MicroMsg.BackupItemImg", "parseContent xml:%s", new Object[] { parame });
    AppMethodBeat.o(21514);
    return parame;
  }
  
  public final int a(hy paramhy, boolean paramBoolean1, bo parambo, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21513);
    int j;
    if (bs.isNullOrNil(parambo.field_content))
    {
      j = 0;
      if (parambo.field_isSend == 1)
      {
        paramString = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().qg(parambo.field_msgId);
        if (paramString.dcd != 0L) {
          break label981;
        }
      }
      paramString = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().qf(parambo.field_msgSvrId);
    }
    label312:
    label572:
    label981:
    for (;;)
    {
      paramHashMap = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().R(parambo.field_imgPath, true);
      int i = j;
      if (com.tencent.mm.vfs.i.eA(paramHashMap)) {
        i = j + i.a(new i.a(paramHashMap, paramhy, paramLinkedList, 1, paramBoolean1, "_thumb", paramBoolean2));
      }
      Object localObject1;
      int k;
      if (parambo.field_isSend == 1)
      {
        localObject2 = "";
        str = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().p(paramString.hGM, "", "");
        localObject1 = localObject2;
        k = i;
        paramHashMap = paramString;
        if (paramString.aFa())
        {
          paramHashMap = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().oR(paramString.hGX);
          if (paramHashMap == null) {
            break label477;
          }
          localObject1 = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().p(paramHashMap.hGM, "", "");
          ac.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + (String)localObject1 + " " + com.tencent.mm.vfs.i.aSp((String)localObject1));
          com.tencent.mm.vfs.i.aSp((String)localObject1);
          if (com.tencent.mm.vfs.i.eA((String)localObject1)) {
            k = i + i.a(new i.a((String)localObject1, paramhy, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
          }
        }
        else
        {
          com.tencent.mm.vfs.i.aSp(str);
          j = k;
          localObject2 = paramHashMap;
          if (!bs.isNullOrNil(str))
          {
            j = k;
            localObject2 = paramHashMap;
            if (!str.equals(localObject1))
            {
              ac.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.i.aSp(str));
              j = k + i.a(new i.a(str, paramhy, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
              localObject2 = paramHashMap;
            }
          }
        }
      }
      label477:
      do
      {
        parambo = a((com.tencent.mm.av.e)localObject2, parambo);
        if (parambo != null) {
          break label948;
        }
        AppMethodBeat.o(21513);
        return j;
        j = parambo.field_content.getBytes().length;
        break;
        ac.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { localObject1 });
        k = i;
        break label312;
        ac.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
        localObject1 = localObject2;
        k = i;
        break label312;
        j = i;
        localObject2 = paramString;
      } while (!paramString.aEZ());
      String str = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().p(paramString.hGM, "", "");
      Object localObject2 = "";
      if (paramString.aFa())
      {
        localObject1 = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().oR(paramString.hGX);
        if (localObject1 != null)
        {
          if (localObject1 != null) {
            ac.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", new Object[] { Integer.valueOf(((com.tencent.mm.av.e)localObject1).offset), Integer.valueOf(((com.tencent.mm.av.e)localObject1).hux), Integer.valueOf(((com.tencent.mm.av.e)localObject1).hGP), ((com.tencent.mm.av.e)localObject1).hGM });
          }
          paramHashMap = (HashMap<Long, h.a>)localObject2;
          k = i;
          if (localObject1 != null)
          {
            paramHashMap = (HashMap<Long, h.a>)localObject2;
            k = i;
            if (((com.tencent.mm.av.e)localObject1).hGP == 1)
            {
              if ((localObject1.equals(paramString)) || (((com.tencent.mm.av.e)localObject1).hux <= 0) || (((com.tencent.mm.av.e)localObject1).offset != ((com.tencent.mm.av.e)localObject1).hux)) {
                break label929;
              }
              localObject1 = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().p(((com.tencent.mm.av.e)localObject1).hGM, "", "");
              ac.d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject1, Long.valueOf(com.tencent.mm.vfs.i.aSp((String)localObject1)) });
              paramHashMap = (HashMap<Long, h.a>)localObject1;
              k = i;
              if (com.tencent.mm.vfs.i.eA((String)localObject1))
              {
                k = i + i.a(new i.a((String)localObject1, paramhy, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
                com.tencent.mm.vfs.i.aSp((String)localObject1);
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
        if (!com.tencent.mm.vfs.i.eA(str)) {
          break;
        }
        com.tencent.mm.vfs.i.aSp(str);
        j = k;
        localObject2 = paramString;
        if (bs.isNullOrNil(str)) {
          break;
        }
        j = k;
        localObject2 = paramString;
        if (str.equals(paramHashMap)) {
          break;
        }
        ac.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.i.aSp(str));
        j = k + i.a(new i.a(str, paramhy, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
        localObject2 = paramString;
        break;
        localObject1 = null;
        break label572;
        localObject1.equals(paramString);
        paramHashMap = (HashMap<Long, h.a>)localObject2;
        k = i;
      }
      paramhy.DPV = new crm().aJV(parambo);
      i = parambo.length();
      AppMethodBeat.o(21513);
      return j + i;
    }
  }
  
  public final int a(String paramString, hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21515);
    if ((paramhy == null) || (paramhy.DPV == null))
    {
      ac.e("MicroMsg.BackupItemImg", "recover bakitem/Content is null");
      AppMethodBeat.o(21515);
      return 0;
    }
    String str1 = bs.bG(paramhy.DPV.FEm, "");
    long l1 = paramhy.vTQ;
    int i;
    int j;
    label80:
    Object localObject1;
    label91:
    com.tencent.mm.av.g localg;
    if (paramhy.DVs == null)
    {
      i = 0;
      j = paramhy.DVu;
      if (paramhy.DVr != null) {
        break label590;
      }
      paramString = "";
      if (paramhy.DVq != null) {
        break label601;
      }
      localObject1 = "";
      ac.d("MicroMsg.BackupItemImg", "recover, msgId:%d, content:%s, backupItemImg buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      if (str1 != null) {
        parambo.setContent(str1);
      }
      localg = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM();
      if (parambo.field_isSend != 1) {
        break label613;
      }
      if (parambo.field_msgId != 0L) {
        paramString = localg.qg(parambo.field_msgId);
      }
      if ((paramString != null) && (paramString.dcd != 0L)) {
        break label1265;
      }
      paramString = localg.qf(parambo.field_msgSvrId);
    }
    label217:
    label613:
    label1131:
    label1265:
    for (;;)
    {
      localObject1 = bv.L(str1, "msg");
      l1 = 0L;
      long l2;
      if (localObject1 != null)
      {
        l2 = bs.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L);
        l1 = l2;
        if (l2 > 0L) {
          i = 1;
        }
      }
      for (long l3 = l2;; l3 = l1)
      {
        Object localObject3 = bs.bG(com.tencent.mm.plugin.backup.b.g.a(paramhy, 3), "");
        if ((paramhy.DVu == 3) && (paramhy.DVs != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.Ss((String)localObject3), (String)localObject3, paramhy.DVs.getBufferToBytes());
        }
        localObject1 = bs.bG(com.tencent.mm.plugin.backup.b.g.a(paramhy, 2), "");
        if ((paramhy.DVu == 2) && (paramhy.DVs != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.Ss((String)localObject1), (String)localObject1, paramhy.DVs.getBufferToBytes());
        }
        ac.d("MicroMsg.BackupItemImg", "hdName:%s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (bs.isNullOrNil((String)localObject1))
        {
          ac.d("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          Object localObject2 = com.tencent.mm.plugin.backup.b.g.b(paramhy, 1);
          Object localObject5;
          if (localObject2 == null)
          {
            ac.d("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = com.tencent.mm.plugin.backup.b.g.Ss((String)localObject1) + (String)localObject1;
            localObject4 = com.tencent.mm.b.g.getMessageDigest((bs.eWj() + " ").getBytes());
            localObject5 = com.tencent.mm.plugin.backup.b.g.Ss((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new com.tencent.mm.vfs.e((String)localObject5);
            if (!((com.tencent.mm.vfs.e)localObject5).exists()) {
              ((com.tencent.mm.vfs.e)localObject5).mkdirs();
            }
            j = ae.aKM(str2);
            if (j > 0)
            {
              if (ae.a((String)localObject2, Bitmap.CompressFormat.JPEG, str2, j)) {
                break label679;
              }
              ac.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
              i = paramhy.DVs.getILen();
              break;
              paramString = paramhy.DVr.toString();
              break label80;
              localObject1 = paramhy.DVq.toString();
              break label91;
              paramString = localg.qf(parambo.field_msgSvrId);
              break label217;
            }
            if (!f.a((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str2))
            {
              ac.e("MicroMsg.BackupItemImg", "createThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
            }
            ac.d("MicroMsg.BackupItemImg", "insert: thumbName = ".concat(String.valueOf(localObject4)));
            localObject4 = com.tencent.mm.vfs.i.aU(str2, 0, -1);
            localObject2 = localObject4;
            if (localObject4 != null) {
              break label736;
            }
            ac.e("MicroMsg.BackupItemImg", "img buf is null");
            AppMethodBeat.o(21515);
            return -1;
          }
          ac.d("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          Object localObject4 = localg.p((String)localObject3, "", "");
          String str2 = localg.p((String)localObject1, "", "");
          l2 = 0L;
          boolean bool;
          if (paramString.dcd == 0L)
          {
            j = com.tencent.mm.plugin.backup.b.g.c(paramhy, 2);
            if (i != 0)
            {
              i = com.tencent.mm.plugin.backup.b.g.c(paramhy, 3);
              l1 = localg.a((byte[])localObject2, paramhy.vTQ, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              if (((String)localObject3).equals(localObject1))
              {
                bool = com.tencent.mm.plugin.backup.b.g.a(paramhy, (String)localObject4);
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
                bool = com.tencent.mm.plugin.backup.b.g.a(paramhy, str2);
                label888:
                if (!bool) {
                  break label1131;
                }
                ac.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[] { str2 });
                i = 0;
                if (j > 0) {
                  break label1249;
                }
                j = com.tencent.mm.plugin.backup.b.g.c(paramhy, 3);
              }
            }
          }
          for (;;)
          {
            paramString = new PString();
            localObject3 = new PInt();
            localObject5 = new PInt();
            l2 = localg.a((byte[])localObject2, paramhy.vTQ, false, (String)localObject1, j, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if ((i != 0) && (!com.tencent.mm.plugin.backup.b.g.b(paramhy, 2, str2))) {
              ac.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              parambo.rf(paramString.value);
              parambo.ke(((PInt)localObject3).value);
              parambo.kf(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().c(Long.valueOf(l2));
                paramString.oM((int)l1);
                com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEM().a(Long.valueOf(l2), paramString);
              }
            }
            for (;;)
            {
              c.u(parambo);
              AppMethodBeat.o(21515);
              return 0;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramhy, 3, (String)localObject4);
              break;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramhy, 3, str2);
              break label888;
              ac.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[] { str2 });
              i = 1;
              break label914;
              ac.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[] { localObject4 });
              l2 = l1;
              l1 = l2;
              i = 1;
              break label914;
              AppMethodBeat.o(21515);
              return -1;
              paramhy = paramString.hGO;
              if ((paramhy != null) && (paramhy.startsWith("THUMBNAIL_DIRPATH://"))) {
                parambo.rf(paramhy);
              } else {
                parambo.rf("THUMBNAIL://" + paramString.dcd);
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