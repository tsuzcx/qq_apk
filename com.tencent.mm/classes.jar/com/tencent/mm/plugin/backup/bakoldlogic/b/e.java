package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.b.g;
import com.tencent.mm.model.br;
import com.tencent.mm.modelimage.h;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
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
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e
  implements j
{
  private static String a(h paramh, cc paramcc)
  {
    AppMethodBeat.i(21846);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput(localStringWriter);
      if (d.DQ(paramcc.field_talker)) {
        localStringWriter.write(br.JJ(paramcc.field_content) + ":\n");
      }
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "img");
      Map localMap = XmlParser.parseXml(paramh.oGC, "msg", null);
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
          l1 = y.bEl(com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().v(paramh.oGr, "", ""));
        }
        localXmlSerializer.attribute(null, "length", l1);
        if ((paramcc.field_isSend != 1) || (paramh.oGu == 1))
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
      paramh = localStringWriter.getBuffer().toString();
      Log.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", new Object[] { paramh });
      AppMethodBeat.o(21846);
      return paramh;
    }
    catch (Exception paramh)
    {
      Log.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + paramh.toString());
      AppMethodBeat.o(21846);
    }
    return null;
  }
  
  public final int a(jd paramjd, cc paramcc, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(300726);
    int i;
    if (Util.isNullOrNil(paramcc.field_content))
    {
      i = 0;
      if (paramcc.field_isSend != 1) {
        break label448;
      }
      paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().H(paramcc.field_talker, paramcc.field_msgId);
      if ((paramString != null) && (paramString.localId != 0L)) {
        break label1038;
      }
      paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().G(paramcc.field_talker, paramcc.field_msgSvrId);
    }
    label523:
    label1038:
    for (;;)
    {
      label82:
      Object localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().X(paramcc.field_imgPath, true);
      Object localObject3;
      Object localObject2;
      int k;
      if (y.ZC((String)localObject1))
      {
        j = i + i.a(new i.a((String)localObject1, paramjd, paramLinkedList, 1, false, "_thumb", false));
        if (paramcc.field_isSend != 1) {
          break label523;
        }
        localObject3 = "";
        str = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().v(paramString.oGr, "", "");
        localObject2 = localObject3;
        k = j;
        localObject1 = paramString;
        if (paramString.bJE())
        {
          localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().wq(paramString.oGB);
          if (localObject1 == null) {
            break label504;
          }
          localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().v(((h)localObject1).oGr, "", "");
          Log.d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + (String)localObject2 + " " + y.bEl((String)localObject2));
          y.bEl((String)localObject2);
          if (!y.ZC((String)localObject2)) {
            break label480;
          }
          k = i.a(new i.a((String)localObject2, paramjd, paramLinkedList, 3, false, "_hd", false)) + j;
        }
        label310:
        y.bEl(str);
        i = k;
        localObject3 = localObject1;
        if (!Util.isNullOrNil(str))
        {
          i = k;
          localObject3 = localObject1;
          if (!str.equals(localObject2))
          {
            Log.d("MicroMsg.BakOldItemImg", "bigImgPath " + str + " " + y.bEl(str));
            i = k + i.a(new i.a(str, paramjd, paramLinkedList, 2, false, false, null));
            localObject3 = localObject1;
          }
        }
      }
      label448:
      label480:
      label504:
      do
      {
        paramcc = a((h)localObject3, paramcc);
        if (paramcc != null) {
          break label1005;
        }
        AppMethodBeat.o(300726);
        return i;
        i = paramcc.field_content.getBytes().length;
        break;
        paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().G(paramcc.field_talker, paramcc.field_msgSvrId);
        break label82;
        AppMethodBeat.o(300726);
        return -1;
        Log.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", new Object[] { localObject2 });
        k = j;
        break label310;
        Log.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but img is null");
        localObject2 = localObject3;
        k = j;
        break label310;
        i = j;
        localObject3 = paramString;
      } while (!paramString.bJD());
      String str = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().v(paramString.oGr, "", "");
      label573:
      label581:
      label589:
      label599:
      int m;
      if (paramString.bJE()) {
        if (paramString == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label947;
          }
          i = -1;
          if (localObject1 != null) {
            break label957;
          }
          k = -1;
          if (localObject1 != null) {
            break label967;
          }
          localObject2 = "null";
          if (localObject1 != null) {
            break label977;
          }
          m = -1;
          label607:
          Log.i("MicroMsg.BakOldItemImg", "packet hdinfo off:%d total:%d path:%s, compressType[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), localObject2, Integer.valueOf(m) });
          if ((localObject1 == null) || (((h)localObject1).oGu != 1)) {
            break label994;
          }
          if ((localObject1.equals(paramString)) || (((h)localObject1).offset != ((h)localObject1).osy)) {
            break label987;
          }
          localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().v(((h)localObject1).oGr, "", "");
          Log.d("MicroMsg.BakOldItemImg", "packet hdPath:%s, fileLen[%d]", new Object[] { localObject2, Long.valueOf(y.bEl((String)localObject2)) });
          localObject1 = localObject2;
          k = j;
          if (y.ZC((String)localObject2))
          {
            k = j + i.a(new i.a((String)localObject2, paramjd, paramLinkedList, 3, false, "_hd", false));
            y.bEl((String)localObject2);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        i = k;
        localObject3 = paramString;
        if (!y.ZC(str)) {
          break;
        }
        y.bEl(str);
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
        Log.d("MicroMsg.BakOldItemImg", "bigImgPath " + str + " " + y.bEl(str));
        i = k + i.a(new i.a(str, paramjd, paramLinkedList, 2, false, false, null));
        localObject3 = paramString;
        break;
        if (paramString.bJE())
        {
          localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().wq(paramString.oGB);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label573;
          }
        }
        localObject1 = paramString;
        break label573;
        label947:
        i = ((h)localObject1).offset;
        break label581;
        label957:
        k = ((h)localObject1).osy;
        break label589;
        label967:
        localObject2 = ((h)localObject1).oGr;
        break label599;
        label977:
        m = ((h)localObject1).oGu;
        break label607;
        label987:
        localObject1.equals(paramString);
        label994:
        localObject1 = "";
        k = j;
      }
      label1005:
      paramjd.YFG = new etl().btH(paramcc);
      int j = paramcc.length();
      AppMethodBeat.o(300726);
      return i + j;
    }
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21847);
    if ((paramjd == null) || (paramjd.YFG == null))
    {
      Log.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
      AppMethodBeat.o(21847);
      return 0;
    }
    String str1 = new String(Util.nullAs(paramjd.YFG.abwM, ""));
    Log.d("MicroMsg.BakOldItemImg", "recover msg" + paramjd.Njv + " " + str1);
    int i;
    int j;
    label116:
    Object localObject1;
    label127:
    com.tencent.mm.modelimage.j localj;
    if (paramjd.YLa == null)
    {
      i = 0;
      j = paramjd.YLc;
      if (paramjd.YKZ != null) {
        break label689;
      }
      paramString = "";
      if (paramjd.YKY != null) {
        break label700;
      }
      localObject1 = "";
      Log.d("MicroMsg.BakOldItemImg", "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, localObject1 });
      paramString = null;
      paramcc.setContent(str1);
      localj = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH();
      if (paramcc.field_isSend != 1) {
        break label712;
      }
      if (paramcc.field_msgId != 0L) {
        paramString = localj.H(paramcc.field_talker, paramcc.field_msgId);
      }
      if ((paramString != null) && (paramString.localId != 0L)) {
        break label1237;
      }
      paramString = localj.G(paramcc.field_talker, paramcc.field_msgSvrId);
    }
    label689:
    label700:
    label712:
    label1237:
    for (;;)
    {
      label241:
      localObject1 = XmlParser.parseXml(str1, "msg", null);
      if ((localObject1 != null) && (Util.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L) > 0L)) {}
      for (i = 1;; i = 0)
      {
        Object localObject3 = Util.nullAs(a.a(paramjd, 3), "");
        Object localObject2;
        if ((paramjd.YLc == 3) && (paramjd.YLa != null))
        {
          localObject1 = a.cWR() + "backupMeida/" + a.ahL((String)localObject3) + (String)localObject3;
          localObject2 = paramjd.YLa.aaxD.Op;
          y.e((String)localObject1, (byte[])localObject2, localObject2.length);
        }
        localObject1 = Util.nullAs(a.a(paramjd, 2), "");
        Object localObject4;
        if ((paramjd.YLc == 2) && (paramjd.YLa != null))
        {
          localObject2 = a.cWR() + "backupMeida/" + a.ahL((String)localObject1) + (String)localObject1;
          localObject4 = paramjd.YLa.aaxD.Op;
          y.e((String)localObject2, (byte[])localObject4, localObject4.length);
        }
        Log.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", new Object[] { localObject3, localObject1 });
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
          localObject1 = localObject3;
        }
        for (;;)
        {
          localObject2 = a.b(paramjd, 1);
          Object localObject5;
          if (localObject2 == null)
          {
            Log.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            localObject2 = a.ahN((String)localObject1);
            localObject4 = g.getMessageDigest((Util.nowMilliSecond() + " ").getBytes());
            localObject5 = a.cWR() + "backupMeida/" + a.ahL((String)localObject4);
            str2 = (String)localObject5 + (String)localObject4;
            localObject5 = new com.tencent.mm.vfs.u((String)localObject5);
            if (!((com.tencent.mm.vfs.u)localObject5).jKS()) {
              ((com.tencent.mm.vfs.u)localObject5).jKY();
            }
            j = LongBitmapHandler.isLongPicture(str2);
            if (j > 0)
            {
              if (LongBitmapHandler.createLongPictureThumbNail((String)localObject2, Bitmap.CompressFormat.JPEG, 90, str2, j)) {
                break label780;
              }
              Log.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
              i = paramjd.YLa.abwJ;
              break;
              paramString = paramjd.YKZ.toString();
              break label116;
              localObject1 = paramjd.YKY.toString();
              break label127;
              paramString = localj.G(paramcc.field_talker, paramcc.field_msgSvrId);
              break label241;
            }
            if (!BitmapUtil.createThumbNail((String)localObject2, 120, 120, Bitmap.CompressFormat.JPEG, 90, str2))
            {
              Log.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
              AppMethodBeat.o(21847);
              return -1;
            }
            Log.d("MicroMsg.BakOldItemImg", "insert: thumbName = ".concat(String.valueOf(localObject4)));
            localObject2 = y.bi(str2, 0, -1);
          }
          while (localObject2 == null)
          {
            Log.e("MicroMsg.BakOldItemImg", "img buf is null");
            AppMethodBeat.o(21847);
            return -1;
            Log.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", new Object[] { Integer.valueOf(localObject2.length) });
          }
          localObject4 = localj.v((String)localObject3, "", "");
          String str2 = localj.v((String)localObject1, "", "");
          long l1 = 0L;
          if (paramString.localId == 0L)
          {
            if (i != 0)
            {
              i = a.c(paramjd, 3);
              l2 = localj.a(paramcc.field_talker, (byte[])localObject2, paramjd.Njv, true, (String)localObject3, i, str1, new PString(), new PInt(), new PInt());
              l1 = l2;
              if (!a.b(paramjd, 3, (String)localObject4))
              {
                Log.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", new Object[] { localObject4 });
                l1 = l2;
              }
            }
            j = a.c(paramjd, 2);
            i = j;
            if (j <= 0) {
              i = a.c(paramjd, 3);
            }
            paramString = new PString();
            localObject3 = new PInt();
            localObject5 = new PInt();
            long l2 = localj.a(paramcc.field_talker, (byte[])localObject2, paramjd.Njv, false, (String)localObject1, i, str1, paramString, (PInt)localObject3, (PInt)localObject5);
            if (!a.b(paramjd, 2, str2)) {
              Log.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", new Object[] { localObject4 });
            }
            if (l2 > 0L)
            {
              paramcc.BT(paramString.value);
              paramcc.pW(((PInt)localObject3).value);
              paramcc.pX(((PInt)localObject5).value);
              if (l1 > 0L)
              {
                paramString = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().b(Long.valueOf(l2));
                paramString.wl((int)l1);
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().cWH().a(Long.valueOf(l2), paramString);
              }
            }
          }
          for (;;)
          {
            d.B(paramcc);
            AppMethodBeat.o(21847);
            return 0;
            AppMethodBeat.o(21847);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.e
 * JD-Core Version:    0.7.0.1
 */