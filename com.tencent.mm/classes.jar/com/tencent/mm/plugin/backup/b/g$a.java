package com.tencent.mm.plugin.backup.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.backup.f.k;
import com.tencent.mm.plugin.backup.f.k.a;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g$a
{
  public static String mqD = "<msg>";
  public static String mqE = "</msg>";
  
  public static String Oo(String paramString)
  {
    AppMethodBeat.i(21168);
    paramString = k.Os(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(21168);
      return null;
    }
    paramString = paramString.mvh;
    AppMethodBeat.o(21168);
    return paramString;
  }
  
  public static String a(bl parambl, hu paramhu)
  {
    AppMethodBeat.i(21169);
    EmojiInfo localEmojiInfo = d.bxT().bxU().bxR().aJx(parambl.field_imgPath);
    if (localEmojiInfo == null)
    {
      AppMethodBeat.o(21169);
      return null;
    }
    Object localObject = k.Ot(localEmojiInfo.JS());
    parambl = (bl)localObject;
    if (localObject == null) {
      parambl = new k.a(localEmojiInfo.JS(), localEmojiInfo.JS(), localEmojiInfo.JS(), localEmojiInfo.JS());
    }
    localObject = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput((Writer)localObject);
      localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "emoji");
      localXmlSerializer.attribute(null, "fromusername", paramhu.Cxx.Ehn);
      localXmlSerializer.attribute(null, "tousername", paramhu.Cxy.Ehn);
      localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
      localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.fZT());
      localXmlSerializer.attribute(null, "md5", parambl.mvi);
      localXmlSerializer.attribute(null, "len", "1024");
      localXmlSerializer.attribute(null, "androidmd5", parambl.mvh);
      localXmlSerializer.attribute(null, "androidlen", "1024");
      localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
      if (localEmojiInfo.field_cdnUrl == null)
      {
        parambl = "";
        localXmlSerializer.attribute(null, "cdnurl", parambl);
        if (localEmojiInfo.field_designerID != null) {
          break label721;
        }
        parambl = "";
        label310:
        localXmlSerializer.attribute(null, "designerid", parambl);
        if (localEmojiInfo.field_thumbUrl != null) {
          break label730;
        }
        parambl = "";
        label332:
        localXmlSerializer.attribute(null, "thumburl", parambl);
        if (localEmojiInfo.field_encrypturl != null) {
          break label739;
        }
        parambl = "";
        label354:
        localXmlSerializer.attribute(null, "encrypturl", parambl);
        if (localEmojiInfo.field_aeskey != null) {
          break label748;
        }
        parambl = "";
        label376:
        localXmlSerializer.attribute(null, "aeskey", parambl);
        if (localEmojiInfo.field_externUrl != null) {
          break label757;
        }
        parambl = "";
        label398:
        localXmlSerializer.attribute(null, "externurl", parambl);
        if (localEmojiInfo.field_externMd5 != null) {
          break label766;
        }
        parambl = "";
        label420:
        localXmlSerializer.attribute(null, "externmd5", parambl);
        localXmlSerializer.attribute(null, "width", String.valueOf(localEmojiInfo.field_width));
        localXmlSerializer.attribute(null, "height", String.valueOf(localEmojiInfo.field_height));
        if (localEmojiInfo.field_tpurl != null) {
          break label775;
        }
        parambl = "";
        label478:
        localXmlSerializer.attribute(null, "tpurl", parambl);
        if (localEmojiInfo.field_tpauthkey != null) {
          break label784;
        }
        parambl = "";
        label500:
        localXmlSerializer.attribute(null, "tpauthkey", parambl);
        if (localEmojiInfo.field_attachedText != null) {
          break label793;
        }
        parambl = "";
        label523:
        localXmlSerializer.attribute(null, "attachedtext", parambl);
        if (localEmojiInfo.field_attachTextColor != null) {
          break label802;
        }
        parambl = "";
        label546:
        localXmlSerializer.attribute(null, "attachedtextcolor", parambl);
        if (localEmojiInfo.field_lensId != null) {
          break label811;
        }
        parambl = "";
        label569:
        localXmlSerializer.attribute(null, "lensid", parambl);
        if (localEmojiInfo.field_activityid != null) {
          break label820;
        }
      }
      label775:
      label784:
      label793:
      label802:
      label811:
      label820:
      for (parambl = "";; parambl = localEmojiInfo.field_activityid)
      {
        localXmlSerializer.attribute(null, "activityid", parambl);
        localXmlSerializer.endTag(null, "emoji");
        if (!localEmojiInfo.CZ()) {
          break label869;
        }
        localXmlSerializer.startTag(null, "gameext");
        paramhu = bw.K(localEmojiInfo.getContent(), "gameext");
        parambl = bt.by((String)paramhu.get(".gameext.$type"), "");
        paramhu = bt.by((String)paramhu.get(".gameext.$content"), "");
        if ((!parambl.equals("")) && (!paramhu.equals(""))) {
          break label829;
        }
        ((StringWriter)localObject).close();
        AppMethodBeat.o(21169);
        return "";
        parambl = localEmojiInfo.field_cdnUrl;
        break;
        label721:
        parambl = localEmojiInfo.field_designerID;
        break label310;
        label730:
        parambl = localEmojiInfo.field_thumbUrl;
        break label332;
        label739:
        parambl = localEmojiInfo.field_encrypturl;
        break label354;
        label748:
        parambl = localEmojiInfo.field_aeskey;
        break label376;
        label757:
        parambl = localEmojiInfo.field_externUrl;
        break label398;
        label766:
        parambl = localEmojiInfo.field_externMd5;
        break label420;
        parambl = localEmojiInfo.field_tpurl;
        break label478;
        parambl = localEmojiInfo.field_tpauthkey;
        break label500;
        parambl = localEmojiInfo.field_attachedText;
        break label523;
        parambl = localEmojiInfo.field_attachTextColor;
        break label546;
        parambl = localEmojiInfo.field_lensId;
        break label569;
      }
      label829:
      localXmlSerializer.attribute(null, "type", String.valueOf(parambl));
      localXmlSerializer.attribute(null, "content", String.valueOf(paramhu));
      localXmlSerializer.endTag(null, "gameext");
      label869:
      localXmlSerializer.endTag(null, "msg");
      localXmlSerializer.endDocument();
      ((StringWriter)localObject).flush();
      ((StringWriter)localObject).close();
      parambl = ((StringWriter)localObject).getBuffer().toString();
      return "";
    }
    catch (XmlPullParserException parambl)
    {
      try
      {
        parambl = parambl.substring(parambl.indexOf(mqD), parambl.indexOf(mqE) + mqE.length());
        ad.d("MicroMsg.BackupUtil.EmojiConvert", "xml ".concat(String.valueOf(parambl)));
        AppMethodBeat.o(21169);
        return parambl;
      }
      catch (Exception parambl)
      {
        AppMethodBeat.o(21169);
      }
      parambl = parambl;
      ad.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambl, "", new Object[0]);
      AppMethodBeat.o(21169);
      return "";
    }
    catch (IllegalArgumentException parambl)
    {
      ad.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambl, "", new Object[0]);
      AppMethodBeat.o(21169);
      return "";
    }
    catch (IllegalStateException parambl)
    {
      ad.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambl, "", new Object[0]);
      AppMethodBeat.o(21169);
      return "";
    }
    catch (IOException parambl)
    {
      ad.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambl, "", new Object[0]);
      AppMethodBeat.o(21169);
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.g.a
 * JD-Core Version:    0.7.0.1
 */