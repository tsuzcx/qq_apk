package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
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
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e
  implements j
{
  private static String a(com.tencent.mm.ay.g paramg, ca paramca)
  {
    AppMethodBeat.i(21846);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (d.Lj(paramca.field_talker)) {
        localStringWriter.write(bq.RL(paramca.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = XmlParser.parseXml(paramg.lNS, "msg", null);
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
          l1 = com.tencent.mm.vfs.u.bBQ(com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().r(paramg.lNH, "", ""));
        }
        localXmlSerializer.attribute(null, "length", l1);
        if ((paramca.field_isSend != 1) || (paramg.lNK == 1))
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
  
  public final int a(ih paramih, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(288656);
    int i;
    if (Util.isNullOrNil(paramca.field_content))
    {
      i = 0;
      if (paramca.field_isSend == 1)
      {
        paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().D(paramca.field_talker, paramca.field_msgId);
        if (paramString.localId != 0L) {
          break label999;
        }
      }
      paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().C(paramca.field_talker, paramca.field_msgSvrId);
    }
    label306:
    label452:
    label476:
    label999:
    for (;;)
    {
      Object localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().T(paramca.field_imgPath, true);
      Object localObject3;
      Object localObject2;
      int k;
      if (com.tencent.mm.vfs.u.agG((String)localObject1))
      {
        j = i + i.a(new i.a((String)localObject1, paramih, paramLinkedList, 1, false, "_thumb", false));
        if (paramca.field_isSend != 1) {
          break label495;
        }
        localObject3 = "";
        str = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().r(paramString.lNH, "", "");
        localObject2 = localObject3;
        k = j;
        localObject1 = paramString;
        if (paramString.blK())
        {
          localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().wl(paramString.lNR);
          if (localObject1 == null) {
            break label476;
          }
          localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().r(((com.tencent.mm.ay.g)localObject1).lNH, "", "");
          Log.d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + (String)localObject2 + " " + com.tencent.mm.vfs.u.bBQ((String)localObject2));
          com.tencent.mm.vfs.u.bBQ((String)localObject2);
          if (!com.tencent.mm.vfs.u.agG((String)localObject2)) {
            break label452;
          }
          k = i.a(new i.a((String)localObject2, paramih, paramLinkedList, 3, false, "_hd", false)) + j;
        }
        com.tencent.mm.vfs.u.bBQ(str);
        i = k;
        localObject3 = localObject1;
        if (!Util.isNullOrNil(str))
        {
          i = k;
          localObject3 = localObject1;
          if (!str.equals(localObject2))
          {
            Log.d("MicroMsg.BakOldItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.u.bBQ(str));
            i = k + i.a(new i.a(str, paramih, paramLinkedList, 2, false, false, null));
            localObject3 = localObject1;
          }
        }
      }
      label495:
      do
      {
        paramca = a((com.tencent.mm.ay.g)localObject3, paramca);
        if (paramca != null) {
          break label966;
        }
        AppMethodBeat.o(288656);
        return i;
        i = paramca.field_content.getBytes().length;
        break;
        AppMethodBeat.o(288656);
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
      } while (!paramString.blJ());
      String str = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().r(paramString.lNH, "", "");
      int m;
      if (paramString.blK()) {
        if (paramString.blK())
        {
          localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().wl(paramString.lNR);
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
            if ((localObject1 == null) || (((com.tencent.mm.ay.g)localObject1).lNK != 1)) {
              break label955;
            }
            if ((localObject1.equals(paramString)) || (((com.tencent.mm.ay.g)localObject1).offset != ((com.tencent.mm.ay.g)localObject1).lAW)) {
              break label948;
            }
            localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().r(((com.tencent.mm.ay.g)localObject1).lNH, "", "");
            Log.d("MicroMsg.BakOldItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject2, Long.valueOf(com.tencent.mm.vfs.u.bBQ((String)localObject2)) });
            localObject1 = localObject2;
            k = j;
            if (com.tencent.mm.vfs.u.agG((String)localObject2))
            {
              k = j + i.a(new i.a((String)localObject2, paramih, paramLinkedList, 3, false, "_hd", false));
              com.tencent.mm.vfs.u.bBQ((String)localObject2);
              localObject1 = localObject2;
            }
          }
        }
      }
      for (;;)
      {
        i = k;
        localObject3 = paramString;
        if (!com.tencent.mm.vfs.u.agG(str)) {
          break;
        }
        com.tencent.mm.vfs.u.bBQ(str);
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
        Log.d("MicroMsg.BakOldItemImg", "bigImgPath " + str + " " + com.tencent.mm.vfs.u.bBQ(str));
        i = k + i.a(new i.a(str, paramih, paramLinkedList, 2, false, false, null));
        localObject3 = paramString;
        break;
        localObject1 = paramString;
        break label568;
        i = ((com.tencent.mm.ay.g)localObject1).offset;
        break label576;
        k = ((com.tencent.mm.ay.g)localObject1).lAW;
        break label584;
        localObject2 = ((com.tencent.mm.ay.g)localObject1).lNH;
        break label594;
        m = ((com.tencent.mm.ay.g)localObject1).lNK;
        break label602;
        localObject1.equals(paramString);
        localObject1 = "";
        k = j;
      }
      paramih.RIF = new eaf().btQ(paramca);
      int j = paramca.length();
      AppMethodBeat.o(288656);
      return i + j;
    }
  }
  
  public final int a(String paramString, ih paramih, ca paramca)
  {
    AppMethodBeat.i(21847);
    if ((paramih == null) || (paramih.RIF == null))
    {
      Log.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
      AppMethodBeat.o(21847);
      return 0;
    }
    String str1 = new String(Util.nullAs(paramih.RIF.Ufy, ""));
    Log.d("MicroMsg.BakOldItemImg", "recover msg" + paramih.HlH + " " + str1);
    int i;
    int j;
    label116:
    Object localObject1;
    label127:
    com.tencent.mm.ay.i locali;
    if (paramih.RNM == null)
    {
      i = 0;
      j = paramih.RNO;
      if (paramih.RNL != null) {
        break label667;
      }
      paramString = "";
      if (paramih.RNK != null) {
        break label678;
      }
      localObject1 = "";
      Log.d("MicroMsg.BakOldItemImg", "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      paramca.setContent(str1);
      locali = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX();
      if (paramca.field_isSend != 1) {
        break label690;
      }
      if (paramca.field_msgId != 0L) {
        paramString = locali.D(paramca.field_talker, paramca.field_msgId);
      }
      if ((paramString != null) && (paramString.localId != 0L)) {
        break label1215;
      }
      paramString = locali.C(paramca.field_talker, paramca.field_msgSvrId);
    }
    label667:
    label678:
    label690:
    label1215:
    for (;;)
    {
      label241:
      localObject1 = XmlParser.parseXml(str1, "msg", null);
      if ((localObject1 != null) && (Util.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L) > 0L)) {}
      for (i = 1;; i = 0)
      {
        Object localObject3 = Util.nullAs(a.a(paramih, 3), "");
        if ((paramih.RNO == 3) && (paramih.RNM != null)) {
          com.tencent.mm.vfs.u.F(a.cuh() + "backupMeida/" + a.aoo((String)localObject3) + (String)localObject3, paramih.RNM.Tkb.UH);
        }
        localObject1 = Util.nullAs(a.a(paramih, 2), "");
        if ((paramih.RNO == 2) && (paramih.RNM != null)) {
          com.tencent.mm.vfs.u.F(a.cuh() + "backupMeida/" + a.aoo((String)localObject1) + (String)localObject1, paramih.RNM.Tkb.UH);
        }
        Log.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          Object localObject2 = a.b(paramih, 1);
          Object localObject4;
          if (localObject2 == null)
          {
            Log.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = a.aoq((String)localObject1);
            str2 = com.tencent.mm.b.g.getMessageDigest((Util.nowMilliSecond() + " ").getBytes());
            localObject4 = a.cuh() + "backupMeida/" + a.aoo(str2);
            str3 = (String)localObject4 + str2;
            localObject4 = new q((String)localObject4);
            if (!((q)localObject4).ifE()) {
              ((q)localObject4).ifL();
            }
            j = LongBitmapHandler.isLongPicture(str3);
            if (j > 0)
            {
              if (LongBitmapHandler.createLongPictureThumbNail((String)localObject2, Bitmap.CompressFormat.JPEG, 90, str3, j)) {
                break label758;
              }
              Log.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
              i = paramih.RNM.Ufv;
              break;
              paramString = paramih.RNL.toString();
              break label116;
              localObject1 = paramih.RNK.toString();
              break label127;
              paramString = locali.C(paramca.field_talker, paramca.field_msgSvrId);
              break label241;
            }
            if (!BitmapUtil.createThumbNail((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str3))
            {
              Log.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
            }
            Log.d("MicroMsg.BakOldItemImg", "insert: thumbName = ".concat(String.valueOf(str2)));
            label758:
            localObject2 = com.tencent.mm.vfs.u.aY(str3, 0, -1);
          }
          while (localObject2 == null)
          {
            Log.e("MicroMsg.BakOldItemImg", "img buf is null");
            AppMethodBeat.o(21847);
            return -1;
            Log.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          }
          String str2 = locali.r((String)localObject3, "", "");
          String str3 = locali.r((String)localObject1, "", "");
          long l1 = 0L;
          if (paramString.localId == 0L)
          {
            if (i != 0)
            {
              i = a.c(paramih, 3);
              l2 = locali.a(paramca.field_talker, (byte[])localObject2, paramih.HlH, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              l1 = l2;
              if (!a.b(paramih, 3, str2))
              {
                Log.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", new Object[] { str2 });
                l1 = l2;
              }
            }
            j = a.c(paramih, 2);
            i = j;
            if (j <= 0) {
              i = a.c(paramih, 3);
            }
            paramString = new PString();
            localObject3 = new PInt();
            localObject4 = new PInt();
            long l2 = locali.a(paramca.field_talker, (byte[])localObject2, paramih.HlH, false, (String)localObject1, i, str1, paramString, (PInt)localObject3, (PInt)localObject4);
            if (!a.b(paramih, 2, str3)) {
              Log.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", new Object[] { str2 });
            }
            if (l2 > 0L)
            {
              paramca.Jn(paramString.value);
              paramca.pW(((PInt)localObject3).value);
              paramca.pX(((PInt)localObject4).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().b(Long.valueOf(l2));
                paramString.wg((int)l1);
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().ctX().a(Long.valueOf(l2), paramString);
              }
            }
          }
          for (;;)
          {
            d.z(paramca);
            AppMethodBeat.o(21847);
            return 0;
            AppMethodBeat.o(21847);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.e
 * JD-Core Version:    0.7.0.1
 */