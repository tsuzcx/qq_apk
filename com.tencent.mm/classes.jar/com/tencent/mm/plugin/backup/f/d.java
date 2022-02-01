package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.q;
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
  private static String a(com.tencent.mm.ay.g paramg, ca paramca)
  {
    AppMethodBeat.i(21514);
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer;
    try
    {
      localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (c.Lj(paramca.field_talker)) {
        localStringWriter.write(bq.RL(paramca.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = XmlParser.parseXml(paramg.lNS, "msg", null);
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
        if (Util.getLong((String)localMap.get(".msg.img.$length"), 0L) == 0L) {
          localXmlSerializer.attribute(null, "length", com.tencent.mm.vfs.u.bBQ(com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().r(paramg.lNH, "", "")));
        }
        if ((paramca.field_isSend != 1) || (paramg.lNK == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", Util.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localMap.remove(".msg.img.$cdnbigimgurl");
        localMap.remove(".msg.img.$hdlength");
        if (localMap.get(".msg.img.$md5") == null) {
          localXmlSerializer.attribute(null, "md5", "");
        }
        paramg = localMap.keySet().iterator();
        while (paramg.hasNext())
        {
          paramca = (String)paramg.next();
          if (paramca.startsWith(".msg.img.$")) {
            localXmlSerializer.attribute(null, paramca.substring(10), (String)localMap.get(paramca));
          }
        }
      }
      localXmlSerializer.endTag(null, "img");
    }
    catch (Exception paramg)
    {
      Log.e("MicroMsg.BackupItemImg", "packetImg xml error: " + paramg.toString());
      AppMethodBeat.o(21514);
      return null;
    }
    localXmlSerializer.endTag(null, "msg");
    localXmlSerializer.endDocument();
    localStringWriter.flush();
    localStringWriter.close();
    paramg = localStringWriter.getBuffer().toString();
    Log.d("MicroMsg.BackupItemImg", "parseContent xml:%s", new Object[] { paramg });
    AppMethodBeat.o(21514);
    return paramg;
  }
  
  public final int a(ih paramih, boolean paramBoolean1, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21513);
    int j;
    if (Util.isNullOrNil(paramca.field_content))
    {
      j = 0;
      if (paramca.field_isSend == 1)
      {
        paramString = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().D(paramca.field_talker, paramca.field_msgId);
        if (paramString.localId != 0L) {
          break label989;
        }
      }
      paramString = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().C(paramca.field_talker, paramca.field_msgSvrId);
    }
    label320:
    label580:
    label989:
    for (;;)
    {
      paramHashMap = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().T(paramca.field_imgPath, true);
      int i = j;
      if (com.tencent.mm.vfs.u.agG(paramHashMap)) {
        i = j + i.a(new i.a(paramHashMap, paramih, paramLinkedList, 1, paramBoolean1, "_thumb", paramBoolean2));
      }
      Object localObject1;
      int k;
      if (paramca.field_isSend == 1)
      {
        localObject2 = "";
        str = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().r(paramString.lNH, "", "");
        localObject1 = localObject2;
        k = i;
        paramHashMap = paramString;
        if (paramString.blK())
        {
          paramHashMap = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().wl(paramString.lNR);
          if (paramHashMap == null) {
            break label485;
          }
          localObject1 = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().r(paramHashMap.lNH, "", "");
          Log.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + (String)localObject1 + " " + com.tencent.mm.vfs.u.bBQ((String)localObject1));
          com.tencent.mm.vfs.u.bBQ((String)localObject1);
          if (com.tencent.mm.vfs.u.agG((String)localObject1)) {
            k = i + i.a(new i.a((String)localObject1, paramih, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
          }
        }
        else
        {
          com.tencent.mm.vfs.u.bBQ(str);
          j = k;
          localObject2 = paramHashMap;
          if (!Util.isNullOrNil(str))
          {
            j = k;
            localObject2 = paramHashMap;
            if (!str.equals(localObject1))
            {
              Log.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.u.bBQ(str));
              j = k + i.a(new i.a(str, paramih, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
              localObject2 = paramHashMap;
            }
          }
        }
      }
      label485:
      do
      {
        paramca = a((com.tencent.mm.ay.g)localObject2, paramca);
        if (paramca != null) {
          break label956;
        }
        AppMethodBeat.o(21513);
        return j;
        j = paramca.field_content.getBytes().length;
        break;
        Log.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { localObject1 });
        k = i;
        break label320;
        Log.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
        localObject1 = localObject2;
        k = i;
        break label320;
        j = i;
        localObject2 = paramString;
      } while (!paramString.blJ());
      String str = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().r(paramString.lNH, "", "");
      Object localObject2 = "";
      if (paramString.blK())
      {
        localObject1 = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().wl(paramString.lNR);
        if (localObject1 != null)
        {
          if (localObject1 != null) {
            Log.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", new Object[] { Integer.valueOf(((com.tencent.mm.ay.g)localObject1).offset), Integer.valueOf(((com.tencent.mm.ay.g)localObject1).lAW), Integer.valueOf(((com.tencent.mm.ay.g)localObject1).lNK), ((com.tencent.mm.ay.g)localObject1).lNH });
          }
          paramHashMap = (HashMap<Long, h.a>)localObject2;
          k = i;
          if (localObject1 != null)
          {
            paramHashMap = (HashMap<Long, h.a>)localObject2;
            k = i;
            if (((com.tencent.mm.ay.g)localObject1).lNK == 1)
            {
              if ((localObject1.equals(paramString)) || (((com.tencent.mm.ay.g)localObject1).lAW <= 0) || (((com.tencent.mm.ay.g)localObject1).offset != ((com.tencent.mm.ay.g)localObject1).lAW)) {
                break label937;
              }
              localObject1 = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().r(((com.tencent.mm.ay.g)localObject1).lNH, "", "");
              Log.d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject1, Long.valueOf(com.tencent.mm.vfs.u.bBQ((String)localObject1)) });
              paramHashMap = (HashMap<Long, h.a>)localObject1;
              k = i;
              if (com.tencent.mm.vfs.u.agG((String)localObject1))
              {
                k = i + i.a(new i.a((String)localObject1, paramih, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
                com.tencent.mm.vfs.u.bBQ((String)localObject1);
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
        if (!com.tencent.mm.vfs.u.agG(str)) {
          break;
        }
        com.tencent.mm.vfs.u.bBQ(str);
        j = k;
        localObject2 = paramString;
        if (Util.isNullOrNil(str)) {
          break;
        }
        j = k;
        localObject2 = paramString;
        if (str.equals(paramHashMap)) {
          break;
        }
        Log.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.u.bBQ(str));
        j = k + i.a(new i.a(str, paramih, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
        localObject2 = paramString;
        break;
        localObject1 = null;
        break label580;
        localObject1.equals(paramString);
        paramHashMap = (HashMap<Long, h.a>)localObject2;
        k = i;
      }
      paramih.RIF = new eaf().btQ(paramca);
      i = paramca.length();
      AppMethodBeat.o(21513);
      return j + i;
    }
  }
  
  public final int a(String paramString, ih paramih, ca paramca)
  {
    AppMethodBeat.i(21515);
    if ((paramih == null) || (paramih.RIF == null))
    {
      Log.e("MicroMsg.BackupItemImg", "recover bakitem/Content is null");
      AppMethodBeat.o(21515);
      return 0;
    }
    String str1 = Util.nullAs(paramih.RIF.Ufy, "");
    long l1 = paramih.HlH;
    int i;
    int j;
    label80:
    Object localObject1;
    label91:
    com.tencent.mm.ay.i locali;
    if (paramih.RNM == null)
    {
      i = 0;
      j = paramih.RNO;
      if (paramih.RNL != null) {
        break label607;
      }
      paramString = "";
      if (paramih.RNK != null) {
        break label618;
      }
      localObject1 = "";
      Log.d("MicroMsg.BackupItemImg", "recover, msgId:%d, content:%s, backupItemImg buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      if (str1 != null) {
        paramca.setContent(str1);
      }
      locali = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX();
      if (paramca.field_isSend != 1) {
        break label630;
      }
      if (paramca.field_msgId != 0L) {
        paramString = locali.D(paramca.field_talker, paramca.field_msgId);
      }
      if ((paramString != null) && (paramString.localId != 0L)) {
        break label1299;
      }
      paramString = locali.C(paramca.field_talker, paramca.field_msgSvrId);
    }
    label1163:
    label1299:
    for (;;)
    {
      label225:
      localObject1 = XmlParser.parseXml(str1, "msg", null);
      l1 = 0L;
      long l2;
      if (localObject1 != null)
      {
        l2 = Util.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L);
        l1 = l2;
        if (l2 > 0L) {
          i = 1;
        }
      }
      for (long l3 = l2;; l3 = l1)
      {
        Object localObject3 = Util.nullAs(com.tencent.mm.plugin.backup.b.g.a(paramih, 3), "");
        if ((paramih.RNO == 3) && (paramih.RNM != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.aoc((String)localObject3), (String)localObject3, paramih.RNM.Tkb.UH);
        }
        localObject1 = Util.nullAs(com.tencent.mm.plugin.backup.b.g.a(paramih, 2), "");
        if ((paramih.RNO == 2) && (paramih.RNM != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.aoc((String)localObject1), (String)localObject1, paramih.RNM.Tkb.UH);
        }
        Log.d("MicroMsg.BackupItemImg", "hdName:%s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.d("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          Object localObject2 = com.tencent.mm.plugin.backup.b.g.b(paramih, 1);
          Object localObject5;
          if (localObject2 == null)
          {
            Log.d("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = com.tencent.mm.plugin.backup.b.g.aoc((String)localObject1) + (String)localObject1;
            localObject4 = com.tencent.mm.b.g.getMessageDigest((Util.nowMilliSecond() + " ").getBytes());
            localObject5 = com.tencent.mm.plugin.backup.b.g.aoc((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new q((String)localObject5);
            if (!((q)localObject5).ifE()) {
              ((q)localObject5).ifL();
            }
            j = LongBitmapHandler.isLongPicture(str2);
            if (j > 0)
            {
              if (LongBitmapHandler.createLongPictureThumbNail((String)localObject2, Bitmap.CompressFormat.JPEG, 90, str2, j)) {
                break label700;
              }
              Log.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
              i = paramih.RNM.Ufv;
              break;
              label607:
              paramString = paramih.RNL.toString();
              break label80;
              label618:
              localObject1 = paramih.RNK.toString();
              break label91;
              label630:
              paramString = locali.C(paramca.field_talker, paramca.field_msgSvrId);
              break label225;
            }
            if (!BitmapUtil.createThumbNail((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str2))
            {
              Log.e("MicroMsg.BackupItemImg", "createThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
            }
            Log.d("MicroMsg.BackupItemImg", "insert: thumbName = ".concat(String.valueOf(localObject4)));
            label700:
            localObject4 = com.tencent.mm.vfs.u.aY(str2, 0, -1);
            localObject2 = localObject4;
            if (localObject4 != null) {
              break label757;
            }
            Log.e("MicroMsg.BackupItemImg", "img buf is null");
            AppMethodBeat.o(21515);
            return -1;
          }
          Log.d("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          label757:
          Object localObject4 = locali.r((String)localObject3, "", "");
          String str2 = locali.r((String)localObject1, "", "");
          l2 = 0L;
          int k;
          boolean bool;
          if (paramString.localId == 0L)
          {
            j = com.tencent.mm.plugin.backup.b.g.c(paramih, 2);
            k = 1;
            if (i != 0)
            {
              i = com.tencent.mm.plugin.backup.b.g.c(paramih, 3);
              l1 = locali.a(paramca.field_talker, (byte[])localObject2, paramih.HlH, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              if (((String)localObject3).equals(localObject1))
              {
                bool = com.tencent.mm.plugin.backup.b.g.a(paramih, (String)localObject4);
                l2 = l1;
                if (bool) {
                  break label1210;
                }
                if (j != l3) {
                  break label1188;
                }
                if (!((String)localObject3).equals(localObject1)) {
                  break label1151;
                }
                bool = com.tencent.mm.plugin.backup.b.g.a(paramih, str2);
                label916:
                if (!bool) {
                  break label1163;
                }
                Log.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[] { str2 });
                i = 0;
                label942:
                if (j > 0) {
                  break label1283;
                }
                j = com.tencent.mm.plugin.backup.b.g.c(paramih, 3);
              }
            }
          }
          for (;;)
          {
            paramString = new PString();
            localObject3 = new PInt();
            localObject5 = new PInt();
            l2 = locali.a(paramca.field_talker, (byte[])localObject2, paramih.HlH, false, (String)localObject1, j, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if ((i != 0) && (!com.tencent.mm.plugin.backup.b.g.b(paramih, 2, str2))) {
              Log.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              paramca.Jn(paramString.value);
              paramca.pW(((PInt)localObject3).value);
              paramca.pX(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().b(Long.valueOf(l2));
                paramString.wg((int)l1);
                com.tencent.mm.plugin.backup.h.d.cua().cub().ctX().a(Long.valueOf(l2), paramString);
              }
            }
            for (;;)
            {
              c.z(paramca);
              AppMethodBeat.o(21515);
              return 0;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramih, 3, (String)localObject4);
              break;
              label1151:
              bool = com.tencent.mm.plugin.backup.b.g.b(paramih, 3, str2);
              break label916;
              Log.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[] { str2 });
              i = k;
              break label942;
              label1188:
              Log.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[] { localObject4 });
              l2 = l1;
              label1210:
              l1 = l2;
              i = k;
              break label942;
              AppMethodBeat.o(21515);
              return -1;
              paramih = paramString.lNJ;
              if ((paramih != null) && (paramih.startsWith("THUMBNAIL_DIRPATH://"))) {
                paramca.Jn(paramih);
              } else {
                paramca.Jn("THUMBNAIL://" + paramString.localId);
              }
            }
          }
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.d
 * JD-Core Version:    0.7.0.1
 */