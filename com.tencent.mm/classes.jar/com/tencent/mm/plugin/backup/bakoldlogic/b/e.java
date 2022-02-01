package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
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
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e
  implements j
{
  private static String a(com.tencent.mm.av.g paramg, ca paramca)
  {
    AppMethodBeat.i(21846);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (d.Eq(paramca.field_talker)) {
        localStringWriter.write(bp.Ks(paramca.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = XmlParser.parseXml(paramg.iXy, "msg", null);
      if (localMap != null)
      {
        localXmlSerializer.attribute(null, "aeskey", (String)localMap.get(".msg.img.$aeskey"));
        localXmlSerializer.attribute(null, "encryver", (String)localMap.get(".msg.img.$encryver"));
        localXmlSerializer.attribute(null, "cdnthumbaeskey", (String)localMap.get(".msg.img.$cdnthumbaeskey"));
        localXmlSerializer.attribute(null, "cdnthumburl", (String)localMap.get(".msg.img.$cdnthumburl"));
        localXmlSerializer.attribute(null, "cdnthumblength", Util.getLong((String)localMap.get(".msg.img.$cdnthumblength"), 10240L));
        localXmlSerializer.attribute(null, "cdnthumbheight", Util.getInt((String)localMap.get(".msg.img.$cdnthumbheight"), 0));
        localXmlSerializer.attribute(null, "cdnthumbwidth", Util.getInt((String)localMap.get(".msg.img.$cdnthumbwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidheight", Util.getInt((String)localMap.get(".msg.img.$cdnmidheight"), 0));
        localXmlSerializer.attribute(null, "cdnmidwidth", Util.getInt((String)localMap.get(".msg.img.$cdnmidwidth"), 0));
        localXmlSerializer.attribute(null, "cdnhdheight", Util.getInt((String)localMap.get(".msg.img.$cdnhdheight"), 0));
        localXmlSerializer.attribute(null, "cdnhdwidth", Util.getInt((String)localMap.get(".msg.img.$cdnhdwidth"), 0));
        localXmlSerializer.attribute(null, "cdnmidimgurl", (String)localMap.get(".msg.img.$cdnmidimgurl"));
        long l2 = Util.getLong((String)localMap.get(".msg.img.$length"), 0L);
        StringBuilder localStringBuilder = new StringBuilder();
        long l1 = l2;
        if (l2 == 0L) {
          l1 = s.boW(b.chw().chx().cgM().o(paramg.iXm, "", ""));
        }
        localXmlSerializer.attribute(null, "length", l1);
        if ((paramca.field_isSend != 1) || (paramg.iXp == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", Util.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localXmlSerializer.attribute(null, "md5", (String)localMap.get(".msg.img.$md5"));
      }
      localXmlSerializer.endTag(null, "img");
      localXmlSerializer.endTag(null, "msg");
      localXmlSerializer.endDocument();
      localStringWriter.flush();
      localStringWriter.close();
      paramg = localStringWriter.getBuffer().toString();
      Log.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", new Object[] { paramg });
      AppMethodBeat.o(21846);
      return paramg;
    }
    catch (Exception paramg)
    {
      Log.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + paramg.toString());
      AppMethodBeat.o(21846);
    }
    return null;
  }
  
  public final int a(is paramis, ca paramca, String paramString, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(231600);
    int i;
    if (Util.isNullOrNil(paramca.field_content))
    {
      i = 0;
      if (paramca.field_isSend == 1)
      {
        paramString = b.chw().chx().cgM().H(paramca.field_talker, paramca.field_msgId);
        if (paramString.localId != 0L) {
          break label999;
        }
      }
      paramString = b.chw().chx().cgM().G(paramca.field_talker, paramca.field_msgSvrId);
    }
    label306:
    label452:
    label476:
    label999:
    for (;;)
    {
      Object localObject1 = b.chw().chx().cgM().R(paramca.field_imgPath, true);
      Object localObject3;
      Object localObject2;
      int k;
      if (s.YS((String)localObject1))
      {
        j = i + i.a(new i.a((String)localObject1, paramis, paramLinkedList, 1, false, "_thumb", false));
        if (paramca.field_isSend != 1) {
          break label495;
        }
        localObject3 = "";
        str = b.chw().chx().cgM().o(paramString.iXm, "", "");
        localObject2 = localObject3;
        k = j;
        localObject1 = paramString;
        if (paramString.bcv())
        {
          localObject1 = b.chw().chx().cgM().tl(paramString.iXx);
          if (localObject1 == null) {
            break label476;
          }
          localObject2 = b.chw().chx().cgM().o(((com.tencent.mm.av.g)localObject1).iXm, "", "");
          Log.d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + (String)localObject2 + " " + s.boW((String)localObject2));
          s.boW((String)localObject2);
          if (!s.YS((String)localObject2)) {
            break label452;
          }
          k = i.a(new i.a((String)localObject2, paramis, paramLinkedList, 3, false, "_hd", false)) + j;
        }
        s.boW(str);
        i = k;
        localObject3 = localObject1;
        if (!Util.isNullOrNil(str))
        {
          i = k;
          localObject3 = localObject1;
          if (!str.equals(localObject2))
          {
            Log.d("MicroMsg.BakOldItemImg", "bigImgPath " + str + " " + s.boW(str));
            i = k + i.a(new i.a(str, paramis, paramLinkedList, 2, false, false, null));
            localObject3 = localObject1;
          }
        }
      }
      label495:
      do
      {
        paramca = a((com.tencent.mm.av.g)localObject3, paramca);
        if (paramca != null) {
          break label966;
        }
        AppMethodBeat.o(231600);
        return i;
        i = paramca.field_content.getBytes().length;
        break;
        AppMethodBeat.o(231600);
        return -1;
        Log.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { localObject2 });
        k = j;
        break label306;
        Log.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but img is null");
        localObject2 = localObject3;
        k = j;
        break label306;
        i = j;
        localObject3 = paramString;
      } while (!paramString.bcu());
      String str = b.chw().chx().cgM().o(paramString.iXm, "", "");
      int m;
      if (paramString.bcv()) {
        if (paramString.bcv())
        {
          localObject1 = b.chw().chx().cgM().tl(paramString.iXx);
          if (localObject1 != null)
          {
            if (localObject1 != null) {
              break label908;
            }
            i = -1;
            if (localObject1 != null) {
              break label918;
            }
            k = -1;
            if (localObject1 != null) {
              break label928;
            }
            localObject2 = "null";
            if (localObject1 != null) {
              break label938;
            }
            m = -1;
            Log.i("MicroMsg.BakOldItemImg", "packet hdinfo off:%d total:%d path:%s, compressType[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), localObject2, Integer.valueOf(m) });
            if ((localObject1 == null) || (((com.tencent.mm.av.g)localObject1).iXp != 1)) {
              break label955;
            }
            if ((localObject1.equals(paramString)) || (((com.tencent.mm.av.g)localObject1).offset != ((com.tencent.mm.av.g)localObject1).iKP)) {
              break label948;
            }
            localObject2 = b.chw().chx().cgM().o(((com.tencent.mm.av.g)localObject1).iXm, "", "");
            Log.d("MicroMsg.BakOldItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject2, Long.valueOf(s.boW((String)localObject2)) });
            localObject1 = localObject2;
            k = j;
            if (s.YS((String)localObject2))
            {
              k = j + i.a(new i.a((String)localObject2, paramis, paramLinkedList, 3, false, "_hd", false));
              s.boW((String)localObject2);
              localObject1 = localObject2;
            }
          }
        }
      }
      for (;;)
      {
        i = k;
        localObject3 = paramString;
        if (!s.YS(str)) {
          break;
        }
        s.boW(str);
        i = k;
        localObject3 = paramString;
        if (Util.isNullOrNil(str)) {
          break;
        }
        i = k;
        localObject3 = paramString;
        if (str.equals(localObject1)) {
          break;
        }
        Log.d("MicroMsg.BakOldItemImg", "bigImgPath " + str + " " + s.boW(str));
        i = k + i.a(new i.a(str, paramis, paramLinkedList, 2, false, false, null));
        localObject3 = paramString;
        break;
        localObject1 = paramString;
        break label568;
        i = ((com.tencent.mm.av.g)localObject1).offset;
        break label576;
        k = ((com.tencent.mm.av.g)localObject1).iKP;
        break label584;
        localObject2 = ((com.tencent.mm.av.g)localObject1).iXm;
        break label594;
        m = ((com.tencent.mm.av.g)localObject1).iXp;
        break label602;
        localObject1.equals(paramString);
        localObject1 = "";
        k = j;
      }
      paramis.KHn = new dqi().bhy(paramca);
      int j = paramca.length();
      AppMethodBeat.o(231600);
      return i + j;
    }
  }
  
  public final int a(String paramString, is paramis, ca paramca)
  {
    AppMethodBeat.i(21847);
    if ((paramis == null) || (paramis.KHn == null))
    {
      Log.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
      AppMethodBeat.o(21847);
      return 0;
    }
    String str1 = new String(Util.nullAs(paramis.KHn.MTo, ""));
    Log.d("MicroMsg.BakOldItemImg", "recover msg" + paramis.Brn + " " + str1);
    int i;
    int j;
    label116:
    Object localObject1;
    label127:
    com.tencent.mm.av.i locali;
    if (paramis.KMS == null)
    {
      i = 0;
      j = paramis.KMU;
      if (paramis.KMR != null) {
        break label683;
      }
      paramString = "";
      if (paramis.KMQ != null) {
        break label694;
      }
      localObject1 = "";
      Log.d("MicroMsg.BakOldItemImg", "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      paramca.setContent(str1);
      locali = b.chw().chx().cgM();
      if (paramca.field_isSend != 1) {
        break label706;
      }
      if (paramca.field_msgId != 0L) {
        paramString = locali.H(paramca.field_talker, paramca.field_msgId);
      }
      if ((paramString != null) && (paramString.localId != 0L)) {
        break label1231;
      }
      paramString = locali.G(paramca.field_talker, paramca.field_msgSvrId);
    }
    label683:
    label694:
    label706:
    label1231:
    for (;;)
    {
      label241:
      localObject1 = XmlParser.parseXml(str1, "msg", null);
      if ((localObject1 != null) && (Util.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L) > 0L)) {}
      for (i = 1;; i = 0)
      {
        Object localObject3 = Util.nullAs(a.a(paramis, 3), "");
        Object localObject2;
        if ((paramis.KMU == 3) && (paramis.KMS != null))
        {
          localObject1 = a.cgW() + "backupMeida/" + a.agK((String)localObject3) + (String)localObject3;
          localObject2 = paramis.KMS.getBufferToBytes();
          s.e((String)localObject1, (byte[])localObject2, localObject2.length);
        }
        localObject1 = Util.nullAs(a.a(paramis, 2), "");
        Object localObject4;
        if ((paramis.KMU == 2) && (paramis.KMS != null))
        {
          localObject2 = a.cgW() + "backupMeida/" + a.agK((String)localObject1) + (String)localObject1;
          localObject4 = paramis.KMS.getBufferToBytes();
          s.e((String)localObject2, (byte[])localObject4, localObject4.length);
        }
        Log.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          localObject2 = a.b(paramis, 1);
          Object localObject5;
          if (localObject2 == null)
          {
            Log.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = a.agM((String)localObject1);
            localObject4 = com.tencent.mm.b.g.getMessageDigest((Util.nowMilliSecond() + " ").getBytes());
            localObject5 = a.cgW() + "backupMeida/" + a.agK((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new o((String)localObject5);
            if (!((o)localObject5).exists()) {
              ((o)localObject5).mkdirs();
            }
            j = LongBitmapHandler.isLongPicture(str2);
            if (j > 0)
            {
              if (LongBitmapHandler.createLongPictureThumbNail((String)localObject2, Bitmap.CompressFormat.JPEG, 90, str2, j)) {
                break label774;
              }
              Log.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
              i = paramis.KMS.getILen();
              break;
              paramString = paramis.KMR.toString();
              break label116;
              localObject1 = paramis.KMQ.toString();
              break label127;
              paramString = locali.G(paramca.field_talker, paramca.field_msgSvrId);
              break label241;
            }
            if (!BitmapUtil.createThumbNail((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str2))
            {
              Log.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
            }
            Log.d("MicroMsg.BakOldItemImg", "insert: thumbName = ".concat(String.valueOf(localObject4)));
            localObject2 = s.aW(str2, 0, -1);
          }
          while (localObject2 == null)
          {
            Log.e("MicroMsg.BakOldItemImg", "img buf is null");
            AppMethodBeat.o(21847);
            return -1;
            Log.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          }
          localObject4 = locali.o((String)localObject3, "", "");
          String str2 = locali.o((String)localObject1, "", "");
          long l1 = 0L;
          if (paramString.localId == 0L)
          {
            if (i != 0)
            {
              i = a.c(paramis, 3);
              l2 = locali.a(paramca.field_talker, (byte[])localObject2, paramis.Brn, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              l1 = l2;
              if (!a.b(paramis, 3, (String)localObject4))
              {
                Log.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", new Object[] { localObject4 });
                l1 = l2;
              }
            }
            j = a.c(paramis, 2);
            i = j;
            if (j <= 0) {
              i = a.c(paramis, 3);
            }
            paramString = new PString();
            localObject3 = new PInt();
            localObject5 = new PInt();
            long l2 = locali.a(paramca.field_talker, (byte[])localObject2, paramis.Brn, false, (String)localObject1, i, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if (!a.b(paramis, 2, str2)) {
              Log.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              paramca.Cz(paramString.value);
              paramca.nG(((PInt)localObject3).value);
              paramca.nH(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = b.chw().chx().cgM().c(Long.valueOf(l2));
                paramString.tg((int)l1);
                b.chw().chx().cgM().a(Long.valueOf(l2), paramString);
              }
            }
          }
          for (;;)
          {
            d.x(paramca);
            AppMethodBeat.o(21847);
            return 0;
            AppMethodBeat.o(21847);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.e
 * JD-Core Version:    0.7.0.1
 */