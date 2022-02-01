package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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
  private static String a(com.tencent.mm.av.g paramg, ca paramca)
  {
    AppMethodBeat.i(21514);
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer;
    try
    {
      localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (c.Eq(paramca.field_talker)) {
        localStringWriter.write(bp.Ks(paramca.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = XmlParser.parseXml(paramg.iXy, "msg", null);
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
          localXmlSerializer.attribute(null, "length", s.boW(com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().o(paramg.iXm, "", "")));
        }
        if ((paramca.field_isSend != 1) || (paramg.iXp == 1))
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
  
  public final int a(is paramis, boolean paramBoolean1, ca paramca, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21513);
    int j;
    if (Util.isNullOrNil(paramca.field_content))
    {
      j = 0;
      if (paramca.field_isSend == 1)
      {
        paramString = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().H(paramca.field_talker, paramca.field_msgId);
        if (paramString.localId != 0L) {
          break label989;
        }
      }
      paramString = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().G(paramca.field_talker, paramca.field_msgSvrId);
    }
    label320:
    label580:
    label989:
    for (;;)
    {
      paramHashMap = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().R(paramca.field_imgPath, true);
      int i = j;
      if (s.YS(paramHashMap)) {
        i = j + i.a(new i.a(paramHashMap, paramis, paramLinkedList, 1, paramBoolean1, "_thumb", paramBoolean2));
      }
      Object localObject1;
      int k;
      if (paramca.field_isSend == 1)
      {
        localObject2 = "";
        str = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().o(paramString.iXm, "", "");
        localObject1 = localObject2;
        k = i;
        paramHashMap = paramString;
        if (paramString.bcv())
        {
          paramHashMap = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().tl(paramString.iXx);
          if (paramHashMap == null) {
            break label485;
          }
          localObject1 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().o(paramHashMap.iXm, "", "");
          Log.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + (String)localObject1 + " " + s.boW((String)localObject1));
          s.boW((String)localObject1);
          if (s.YS((String)localObject1)) {
            k = i + i.a(new i.a((String)localObject1, paramis, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
          }
        }
        else
        {
          s.boW(str);
          j = k;
          localObject2 = paramHashMap;
          if (!Util.isNullOrNil(str))
          {
            j = k;
            localObject2 = paramHashMap;
            if (!str.equals(localObject1))
            {
              Log.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + s.boW(str));
              j = k + i.a(new i.a(str, paramis, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
              localObject2 = paramHashMap;
            }
          }
        }
      }
      label485:
      do
      {
        paramca = a((com.tencent.mm.av.g)localObject2, paramca);
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
      } while (!paramString.bcu());
      String str = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().o(paramString.iXm, "", "");
      Object localObject2 = "";
      if (paramString.bcv())
      {
        localObject1 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().tl(paramString.iXx);
        if (localObject1 != null)
        {
          if (localObject1 != null) {
            Log.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", new Object[] { Integer.valueOf(((com.tencent.mm.av.g)localObject1).offset), Integer.valueOf(((com.tencent.mm.av.g)localObject1).iKP), Integer.valueOf(((com.tencent.mm.av.g)localObject1).iXp), ((com.tencent.mm.av.g)localObject1).iXm });
          }
          paramHashMap = (HashMap<Long, h.a>)localObject2;
          k = i;
          if (localObject1 != null)
          {
            paramHashMap = (HashMap<Long, h.a>)localObject2;
            k = i;
            if (((com.tencent.mm.av.g)localObject1).iXp == 1)
            {
              if ((localObject1.equals(paramString)) || (((com.tencent.mm.av.g)localObject1).iKP <= 0) || (((com.tencent.mm.av.g)localObject1).offset != ((com.tencent.mm.av.g)localObject1).iKP)) {
                break label937;
              }
              localObject1 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().o(((com.tencent.mm.av.g)localObject1).iXm, "", "");
              Log.d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject1, Long.valueOf(s.boW((String)localObject1)) });
              paramHashMap = (HashMap<Long, h.a>)localObject1;
              k = i;
              if (s.YS((String)localObject1))
              {
                k = i + i.a(new i.a((String)localObject1, paramis, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
                s.boW((String)localObject1);
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
        if (!s.YS(str)) {
          break;
        }
        s.boW(str);
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
        Log.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + s.boW(str));
        j = k + i.a(new i.a(str, paramis, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
        localObject2 = paramString;
        break;
        localObject1 = null;
        break label580;
        localObject1.equals(paramString);
        paramHashMap = (HashMap<Long, h.a>)localObject2;
        k = i;
      }
      paramis.KHn = new dqi().bhy(paramca);
      i = paramca.length();
      AppMethodBeat.o(21513);
      return j + i;
    }
  }
  
  public final int a(String paramString, is paramis, ca paramca)
  {
    AppMethodBeat.i(21515);
    if ((paramis == null) || (paramis.KHn == null))
    {
      Log.e("MicroMsg.BackupItemImg", "recover bakitem/Content is null");
      AppMethodBeat.o(21515);
      return 0;
    }
    String str1 = Util.nullAs(paramis.KHn.MTo, "");
    long l1 = paramis.Brn;
    int i;
    int j;
    label80:
    Object localObject1;
    label91:
    com.tencent.mm.av.i locali;
    if (paramis.KMS == null)
    {
      i = 0;
      j = paramis.KMU;
      if (paramis.KMR != null) {
        break label601;
      }
      paramString = "";
      if (paramis.KMQ != null) {
        break label612;
      }
      localObject1 = "";
      Log.d("MicroMsg.BackupItemImg", "recover, msgId:%d, content:%s, backupItemImg buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      if (str1 != null) {
        paramca.setContent(str1);
      }
      locali = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM();
      if (paramca.field_isSend != 1) {
        break label624;
      }
      if (paramca.field_msgId != 0L) {
        paramString = locali.H(paramca.field_talker, paramca.field_msgId);
      }
      if ((paramString != null) && (paramString.localId != 0L)) {
        break label1293;
      }
      paramString = locali.G(paramca.field_talker, paramca.field_msgSvrId);
    }
    label1157:
    label1293:
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
        Object localObject3 = Util.nullAs(com.tencent.mm.plugin.backup.b.g.a(paramis, 3), "");
        if ((paramis.KMU == 3) && (paramis.KMS != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.agy((String)localObject3), (String)localObject3, paramis.KMS.getBufferToBytes());
        }
        localObject1 = Util.nullAs(com.tencent.mm.plugin.backup.b.g.a(paramis, 2), "");
        if ((paramis.KMU == 2) && (paramis.KMS != null)) {
          com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.agy((String)localObject1), (String)localObject1, paramis.KMS.getBufferToBytes());
        }
        Log.d("MicroMsg.BackupItemImg", "hdName:%s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.d("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        label910:
        label936:
        label1204:
        for (;;)
        {
          Object localObject2 = com.tencent.mm.plugin.backup.b.g.b(paramis, 1);
          Object localObject5;
          if (localObject2 == null)
          {
            Log.d("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = com.tencent.mm.plugin.backup.b.g.agy((String)localObject1) + (String)localObject1;
            localObject4 = com.tencent.mm.b.g.getMessageDigest((Util.nowMilliSecond() + " ").getBytes());
            localObject5 = com.tencent.mm.plugin.backup.b.g.agy((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new o((String)localObject5);
            if (!((o)localObject5).exists()) {
              ((o)localObject5).mkdirs();
            }
            j = LongBitmapHandler.isLongPicture(str2);
            if (j > 0)
            {
              if (LongBitmapHandler.createLongPictureThumbNail((String)localObject2, Bitmap.CompressFormat.JPEG, 90, str2, j)) {
                break label694;
              }
              Log.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
              i = paramis.KMS.getILen();
              break;
              label601:
              paramString = paramis.KMR.toString();
              break label80;
              label612:
              localObject1 = paramis.KMQ.toString();
              break label91;
              label624:
              paramString = locali.G(paramca.field_talker, paramca.field_msgSvrId);
              break label225;
            }
            if (!BitmapUtil.createThumbNail((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str2))
            {
              Log.e("MicroMsg.BackupItemImg", "createThumbNail failed");
              AppMethodBeat.o(21515);
              return -1;
            }
            Log.d("MicroMsg.BackupItemImg", "insert: thumbName = ".concat(String.valueOf(localObject4)));
            label694:
            localObject4 = s.aW(str2, 0, -1);
            localObject2 = localObject4;
            if (localObject4 != null) {
              break label751;
            }
            Log.e("MicroMsg.BackupItemImg", "img buf is null");
            AppMethodBeat.o(21515);
            return -1;
          }
          Log.d("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          label751:
          Object localObject4 = locali.o((String)localObject3, "", "");
          String str2 = locali.o((String)localObject1, "", "");
          l2 = 0L;
          int k;
          boolean bool;
          if (paramString.localId == 0L)
          {
            j = com.tencent.mm.plugin.backup.b.g.c(paramis, 2);
            k = 1;
            if (i != 0)
            {
              i = com.tencent.mm.plugin.backup.b.g.c(paramis, 3);
              l1 = locali.a(paramca.field_talker, (byte[])localObject2, paramis.Brn, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              if (((String)localObject3).equals(localObject1))
              {
                bool = com.tencent.mm.plugin.backup.b.g.a(paramis, (String)localObject4);
                l2 = l1;
                if (bool) {
                  break label1204;
                }
                if (j != l3) {
                  break label1182;
                }
                if (!((String)localObject3).equals(localObject1)) {
                  break label1145;
                }
                bool = com.tencent.mm.plugin.backup.b.g.a(paramis, str2);
                if (!bool) {
                  break label1157;
                }
                Log.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[] { str2 });
                i = 0;
                if (j > 0) {
                  break label1277;
                }
                j = com.tencent.mm.plugin.backup.b.g.c(paramis, 3);
              }
            }
          }
          label1145:
          label1277:
          for (;;)
          {
            paramString = new PString();
            localObject3 = new PInt();
            localObject5 = new PInt();
            l2 = locali.a(paramca.field_talker, (byte[])localObject2, paramis.Brn, false, (String)localObject1, j, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if ((i != 0) && (!com.tencent.mm.plugin.backup.b.g.b(paramis, 2, str2))) {
              Log.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              paramca.Cz(paramString.value);
              paramca.nG(((PInt)localObject3).value);
              paramca.nH(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().c(Long.valueOf(l2));
                paramString.tg((int)l1);
                com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().a(Long.valueOf(l2), paramString);
              }
            }
            for (;;)
            {
              c.x(paramca);
              AppMethodBeat.o(21515);
              return 0;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramis, 3, (String)localObject4);
              break;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramis, 3, str2);
              break label910;
              Log.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[] { str2 });
              i = k;
              break label936;
              Log.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[] { localObject4 });
              l2 = l1;
              l1 = l2;
              i = k;
              break label936;
              AppMethodBeat.o(21515);
              return -1;
              paramis = paramString.iXo;
              if ((paramis != null) && (paramis.startsWith("THUMBNAIL_DIRPATH://"))) {
                paramca.Cz(paramis);
              } else {
                paramca.Cz("THUMBNAIL://" + paramString.localId);
              }
            }
          }
        }
        label1182:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.d
 * JD-Core Version:    0.7.0.1
 */