package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.modelimage.h;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
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
  private static String a(h paramh, cc paramcc)
  {
    AppMethodBeat.i(21514);
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer;
    try
    {
      localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (c.DQ(paramcc.field_talker)) {
        localStringWriter.write(br.JJ(paramcc.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = XmlParser.parseXml(paramh.oGC, "msg", null);
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
          localXmlSerializer.attribute(null, "length", y.bEl(com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().v(paramh.oGr, "", "")));
        }
        if ((paramcc.field_isSend != 1) || (paramh.oGu == 1))
        {
          localXmlSerializer.attribute(null, "cdnbigimgurl", (String)localMap.get(".msg.img.$cdnbigimgurl"));
          localXmlSerializer.attribute(null, "hdlength", Util.getLong((String)localMap.get(".msg.img.$hdlength"), 0L));
        }
        localMap.remove(".msg.img.$cdnbigimgurl");
        localMap.remove(".msg.img.$hdlength");
        if (localMap.get(".msg.img.$md5") == null) {
          localXmlSerializer.attribute(null, "md5", "");
        }
        paramh = localMap.keySet().iterator();
        while (paramh.hasNext())
        {
          paramcc = (String)paramh.next();
          if (paramcc.startsWith(".msg.img.$")) {
            localXmlSerializer.attribute(null, paramcc.substring(10), (String)localMap.get(paramcc));
          }
        }
      }
      localXmlSerializer.endTag(null, "img");
    }
    catch (Exception paramh)
    {
      Log.e("MicroMsg.BackupItemImg", "packetImg xml error: " + paramh.toString());
      AppMethodBeat.o(21514);
      return null;
    }
    localXmlSerializer.endTag(null, "msg");
    localXmlSerializer.endDocument();
    localStringWriter.flush();
    localStringWriter.close();
    paramh = localStringWriter.getBuffer().toString();
    Log.d("MicroMsg.BackupItemImg", "parseContent xml:%s", new Object[] { paramh });
    AppMethodBeat.o(21514);
    return paramh;
  }
  
  public final int a(jd paramjd, boolean paramBoolean1, cc paramcc, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21513);
    int j;
    if (Util.isNullOrNil(paramcc.field_content))
    {
      j = 0;
      if (paramcc.field_isSend != 1) {
        break label465;
      }
      paramString = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().H(paramcc.field_talker, paramcc.field_msgId);
      if ((paramString != null) && (paramString.localId != 0L)) {
        break label1024;
      }
      paramString = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().G(paramcc.field_talker, paramcc.field_msgSvrId);
    }
    label1024:
    for (;;)
    {
      label86:
      paramHashMap = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().X(paramcc.field_imgPath, true);
      int i = j;
      if (y.ZC(paramHashMap)) {
        i = j + i.a(new i.a(paramHashMap, paramjd, paramLinkedList, 1, paramBoolean1, "_thumb", paramBoolean2));
      }
      Object localObject1;
      int k;
      if (paramcc.field_isSend == 1)
      {
        localObject2 = "";
        str = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().v(paramString.oGr, "", "");
        localObject1 = localObject2;
        k = i;
        paramHashMap = paramString;
        if (paramString.bJE())
        {
          paramHashMap = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().wq(paramString.oGB);
          if (paramHashMap == null) {
            break label515;
          }
          localObject1 = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().v(paramHashMap.oGr, "", "");
          Log.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + (String)localObject1 + " " + y.bEl((String)localObject1));
          y.bEl((String)localObject1);
          if (y.ZC((String)localObject1)) {
            k = i + i.a(new i.a((String)localObject1, paramjd, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
          }
        }
        else
        {
          label325:
          y.bEl(str);
          j = k;
          localObject2 = paramHashMap;
          if (!Util.isNullOrNil(str))
          {
            j = k;
            localObject2 = paramHashMap;
            if (!str.equals(localObject1))
            {
              Log.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + y.bEl(str));
              j = k + i.a(new i.a(str, paramjd, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
              localObject2 = paramHashMap;
            }
          }
        }
      }
      label465:
      do
      {
        paramcc = a((h)localObject2, paramcc);
        if (paramcc != null) {
          break label991;
        }
        AppMethodBeat.o(21513);
        return j;
        j = paramcc.field_content.getBytes().length;
        break;
        paramString = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().G(paramcc.field_talker, paramcc.field_msgSvrId);
        break label86;
        Log.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { localObject1 });
        k = i;
        break label325;
        Log.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
        localObject1 = localObject2;
        k = i;
        break label325;
        j = i;
        localObject2 = paramString;
      } while (!paramString.bJD());
      label515:
      String str = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().v(paramString.oGr, "", "");
      Object localObject2 = "";
      if ((paramString != null) && (paramString.bJE()))
      {
        localObject1 = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().wq(paramString.oGB);
        if (localObject1 != null)
        {
          label615:
          if (localObject1 != null) {
            Log.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", new Object[] { Integer.valueOf(((h)localObject1).offset), Integer.valueOf(((h)localObject1).osy), Integer.valueOf(((h)localObject1).oGu), ((h)localObject1).oGr });
          }
          paramHashMap = (HashMap<Long, h.a>)localObject2;
          k = i;
          if (localObject1 != null)
          {
            paramHashMap = (HashMap<Long, h.a>)localObject2;
            k = i;
            if (((h)localObject1).oGu == 1)
            {
              if ((localObject1.equals(paramString)) || (((h)localObject1).osy <= 0) || (((h)localObject1).offset != ((h)localObject1).osy)) {
                break label972;
              }
              localObject1 = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().v(((h)localObject1).oGr, "", "");
              Log.d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject1, Long.valueOf(y.bEl((String)localObject1)) });
              paramHashMap = (HashMap<Long, h.a>)localObject1;
              k = i;
              if (y.ZC((String)localObject1))
              {
                k = i + i.a(new i.a((String)localObject1, paramjd, paramLinkedList, 3, paramBoolean1, "_hd", paramBoolean2));
                y.bEl((String)localObject1);
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
        if (!y.ZC(str)) {
          break;
        }
        y.bEl(str);
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
        Log.d("MicroMsg.BackupItemImg", "bigImgPath " + str + " " + y.bEl(str));
        j = k + i.a(new i.a(str, paramjd, paramLinkedList, 2, paramBoolean1, paramBoolean2, null));
        localObject2 = paramString;
        break;
        localObject1 = null;
        break label615;
        label972:
        localObject1.equals(paramString);
        paramHashMap = (HashMap<Long, h.a>)localObject2;
        k = i;
      }
      label991:
      paramjd.YFG = new etl().btH(paramcc);
      i = paramcc.length();
      AppMethodBeat.o(21513);
      return j + i;
    }
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21515);
    if ((paramjd == null) || (paramjd.YFG == null))
    {
      Log.e("MicroMsg.BackupItemImg", "recover bakitem/Content is null");
      AppMethodBeat.o(21515);
      return 0;
    }
    String str1 = Util.nullAs(paramjd.YFG.abwM, "");
    long l1 = paramjd.Njv;
    int i;
    int j;
    label80:
    Object localObject1;
    label91:
    j localj;
    if (paramjd.YLa == null)
    {
      i = 0;
      j = paramjd.YLc;
      if (paramjd.YKZ != null) {
        break label607;
      }
      paramString = "";
      if (paramjd.YKY != null) {
        break label618;
      }
      localObject1 = "";
      Log.d("MicroMsg.BackupItemImg", "recover, msgId:%d, content:%s, backupItemImg buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      if (str1 != null) {
        paramcc.setContent(str1);
      }
      localj = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH();
      if (paramcc.field_isSend != 1) {
        break label630;
      }
      if (paramcc.field_msgId != 0L) {
        paramString = localj.H(paramcc.field_talker, paramcc.field_msgId);
      }
      if ((paramString != null) && (paramString.localId != 0L)) {
        break label1299;
      }
      paramString = localj.G(paramcc.field_talker, paramcc.field_msgSvrId);
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
        Object localObject3 = Util.nullAs(com.tencent.mm.plugin.backup.b.g.a(paramjd, 3), "");
        if ((paramjd.YLc == 3) && (paramjd.YLa != null)) {
          com.tencent.mm.plugin.backup.b.g.b(com.tencent.mm.plugin.backup.b.g.ahz((String)localObject3), (String)localObject3, paramjd.YLa.aaxD.Op);
        }
        localObject1 = Util.nullAs(com.tencent.mm.plugin.backup.b.g.a(paramjd, 2), "");
        if ((paramjd.YLc == 2) && (paramjd.YLa != null)) {
          com.tencent.mm.plugin.backup.b.g.b(com.tencent.mm.plugin.backup.b.g.ahz((String)localObject1), (String)localObject1, paramjd.YLa.aaxD.Op);
        }
        Log.d("MicroMsg.BackupItemImg", "hdName:%s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.d("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          Object localObject2 = com.tencent.mm.plugin.backup.b.g.b(paramjd, 1);
          Object localObject5;
          if (localObject2 == null)
          {
            Log.d("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = com.tencent.mm.plugin.backup.b.g.ahz((String)localObject1) + (String)localObject1;
            localObject4 = com.tencent.mm.b.g.getMessageDigest((Util.nowMilliSecond() + " ").getBytes());
            localObject5 = com.tencent.mm.plugin.backup.b.g.ahz((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new com.tencent.mm.vfs.u((String)localObject5);
            if (!((com.tencent.mm.vfs.u)localObject5).jKS()) {
              ((com.tencent.mm.vfs.u)localObject5).jKY();
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
              i = paramjd.YLa.abwJ;
              break;
              label607:
              paramString = paramjd.YKZ.toString();
              break label80;
              label618:
              localObject1 = paramjd.YKY.toString();
              break label91;
              label630:
              paramString = localj.G(paramcc.field_talker, paramcc.field_msgSvrId);
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
            localObject4 = y.bi(str2, 0, -1);
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
          Object localObject4 = localj.v((String)localObject3, "", "");
          String str2 = localj.v((String)localObject1, "", "");
          l2 = 0L;
          int k;
          boolean bool;
          if (paramString.localId == 0L)
          {
            j = com.tencent.mm.plugin.backup.b.g.c(paramjd, 2);
            k = 1;
            if (i != 0)
            {
              i = com.tencent.mm.plugin.backup.b.g.c(paramjd, 3);
              l1 = localj.a(paramcc.field_talker, (byte[])localObject2, paramjd.Njv, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              if (((String)localObject3).equals(localObject1))
              {
                bool = com.tencent.mm.plugin.backup.b.g.a(paramjd, (String)localObject4);
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
                bool = com.tencent.mm.plugin.backup.b.g.a(paramjd, str2);
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
                j = com.tencent.mm.plugin.backup.b.g.c(paramjd, 3);
              }
            }
          }
          for (;;)
          {
            paramString = new PString();
            localObject3 = new PInt();
            localObject5 = new PInt();
            l2 = localj.a(paramcc.field_talker, (byte[])localObject2, paramjd.Njv, false, (String)localObject1, j, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if ((i != 0) && (!com.tencent.mm.plugin.backup.b.g.b(paramjd, 2, str2))) {
              Log.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              paramcc.BT(paramString.value);
              paramcc.pW(((PInt)localObject3).value);
              paramcc.pX(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().b(Long.valueOf(l2));
                paramString.wl((int)l1);
                com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWH().a(Long.valueOf(l2), paramString);
              }
            }
            for (;;)
            {
              c.B(paramcc);
              AppMethodBeat.o(21515);
              return 0;
              bool = com.tencent.mm.plugin.backup.b.g.b(paramjd, 3, (String)localObject4);
              break;
              label1151:
              bool = com.tencent.mm.plugin.backup.b.g.b(paramjd, 3, str2);
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
              paramjd = paramString.oGt;
              if ((paramjd != null) && (paramjd.startsWith("THUMBNAIL_DIRPATH://"))) {
                paramcc.BT(paramjd);
              } else {
                paramcc.BT("THUMBNAIL://" + paramString.localId);
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