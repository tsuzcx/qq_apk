package com.tencent.mm.plugin.backup.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.backup.f.k;
import com.tencent.mm.plugin.backup.f.k.a;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
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
  public static String ntd = "<msg>";
  public static String nte = "</msg>";
  
  public static String VW(String paramString)
  {
    AppMethodBeat.i(21168);
    paramString = k.Wa(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(21168);
      return null;
    }
    paramString = paramString.nxF;
    AppMethodBeat.o(21168);
    return paramString;
  }
  
  public static String a(bu parambu, if paramif)
  {
    AppMethodBeat.i(21169);
    EmojiInfo localEmojiInfo = d.bIY().bIZ().bIW().aUK(parambu.field_imgPath);
    if (localEmojiInfo == null)
    {
      AppMethodBeat.o(21169);
      return null;
    }
    Object localObject = k.Wb(localEmojiInfo.Lb());
    parambu = (bu)localObject;
    if (localObject == null) {
      parambu = new k.a(localEmojiInfo.Lb(), localEmojiInfo.Lb(), localEmojiInfo.Lb(), localEmojiInfo.Lb());
    }
    localObject = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput((Writer)localObject);
      localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "emoji");
      localXmlSerializer.attribute(null, "fromusername", paramif.Fvi.HoB);
      localXmlSerializer.attribute(null, "tousername", paramif.Fvj.HoB);
      localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
      localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.gzI());
      localXmlSerializer.attribute(null, "md5", parambu.nxG);
      localXmlSerializer.attribute(null, "len", "1024");
      localXmlSerializer.attribute(null, "androidmd5", parambu.nxF);
      localXmlSerializer.attribute(null, "androidlen", "1024");
      localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
      if (localEmojiInfo.field_cdnUrl == null)
      {
        parambu = "";
        localXmlSerializer.attribute(null, "cdnurl", parambu);
        if (localEmojiInfo.field_designerID != null) {
          break label721;
        }
        parambu = "";
        label310:
        localXmlSerializer.attribute(null, "designerid", parambu);
        if (localEmojiInfo.field_thumbUrl != null) {
          break label730;
        }
        parambu = "";
        label332:
        localXmlSerializer.attribute(null, "thumburl", parambu);
        if (localEmojiInfo.field_encrypturl != null) {
          break label739;
        }
        parambu = "";
        label354:
        localXmlSerializer.attribute(null, "encrypturl", parambu);
        if (localEmojiInfo.field_aeskey != null) {
          break label748;
        }
        parambu = "";
        label376:
        localXmlSerializer.attribute(null, "aeskey", parambu);
        if (localEmojiInfo.field_externUrl != null) {
          break label757;
        }
        parambu = "";
        label398:
        localXmlSerializer.attribute(null, "externurl", parambu);
        if (localEmojiInfo.field_externMd5 != null) {
          break label766;
        }
        parambu = "";
        label420:
        localXmlSerializer.attribute(null, "externmd5", parambu);
        localXmlSerializer.attribute(null, "width", String.valueOf(localEmojiInfo.field_width));
        localXmlSerializer.attribute(null, "height", String.valueOf(localEmojiInfo.field_height));
        if (localEmojiInfo.field_tpurl != null) {
          break label775;
        }
        parambu = "";
        label478:
        localXmlSerializer.attribute(null, "tpurl", parambu);
        if (localEmojiInfo.field_tpauthkey != null) {
          break label784;
        }
        parambu = "";
        label500:
        localXmlSerializer.attribute(null, "tpauthkey", parambu);
        if (localEmojiInfo.field_attachedText != null) {
          break label793;
        }
        parambu = "";
        label523:
        localXmlSerializer.attribute(null, "attachedtext", parambu);
        if (localEmojiInfo.field_attachTextColor != null) {
          break label802;
        }
        parambu = "";
        label546:
        localXmlSerializer.attribute(null, "attachedtextcolor", parambu);
        if (localEmojiInfo.field_lensId != null) {
          break label811;
        }
        parambu = "";
        label569:
        localXmlSerializer.attribute(null, "lensid", parambu);
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
      for (parambu = "";; parambu = localEmojiInfo.field_activityid)
      {
        localXmlSerializer.attribute(null, "activityid", parambu);
        localXmlSerializer.endTag(null, "emoji");
        if (!localEmojiInfo.Eb()) {
          break label869;
        }
        localXmlSerializer.startTag(null, "gameext");
        paramif = bw.M(localEmojiInfo.getContent(), "gameext");
        parambu = bt.bI((String)paramif.get(".gameext.$type"), "");
        paramif = bt.bI((String)paramif.get(".gameext.$content"), "");
        if ((!parambu.equals("")) && (!paramif.equals(""))) {
          break label829;
        }
        ((StringWriter)localObject).close();
        AppMethodBeat.o(21169);
        return "";
        parambu = localEmojiInfo.field_cdnUrl;
        break;
        label721:
        parambu = localEmojiInfo.field_designerID;
        break label310;
        label730:
        parambu = localEmojiInfo.field_thumbUrl;
        break label332;
        label739:
        parambu = localEmojiInfo.field_encrypturl;
        break label354;
        label748:
        parambu = localEmojiInfo.field_aeskey;
        break label376;
        label757:
        parambu = localEmojiInfo.field_externUrl;
        break label398;
        label766:
        parambu = localEmojiInfo.field_externMd5;
        break label420;
        parambu = localEmojiInfo.field_tpurl;
        break label478;
        parambu = localEmojiInfo.field_tpauthkey;
        break label500;
        parambu = localEmojiInfo.field_attachedText;
        break label523;
        parambu = localEmojiInfo.field_attachTextColor;
        break label546;
        parambu = localEmojiInfo.field_lensId;
        break label569;
      }
      label829:
      localXmlSerializer.attribute(null, "type", String.valueOf(parambu));
      localXmlSerializer.attribute(null, "content", String.valueOf(paramif));
      localXmlSerializer.endTag(null, "gameext");
      label869:
      localXmlSerializer.endTag(null, "msg");
      localXmlSerializer.endDocument();
      ((StringWriter)localObject).flush();
      ((StringWriter)localObject).close();
      parambu = ((StringWriter)localObject).getBuffer().toString();
      return "";
    }
    catch (XmlPullParserException parambu)
    {
      try
      {
        parambu = parambu.substring(parambu.indexOf(ntd), parambu.indexOf(nte) + nte.length());
        ad.d("MicroMsg.BackupUtil.EmojiConvert", "xml ".concat(String.valueOf(parambu)));
        AppMethodBeat.o(21169);
        return parambu;
      }
      catch (Exception parambu)
      {
        AppMethodBeat.o(21169);
      }
      parambu = parambu;
      ad.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambu, "", new Object[0]);
      AppMethodBeat.o(21169);
      return "";
    }
    catch (IllegalArgumentException parambu)
    {
      ad.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambu, "", new Object[0]);
      AppMethodBeat.o(21169);
      return "";
    }
    catch (IllegalStateException parambu)
    {
      ad.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambu, "", new Object[0]);
      AppMethodBeat.o(21169);
      return "";
    }
    catch (IOException parambu)
    {
      ad.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambu, "", new Object[0]);
      AppMethodBeat.o(21169);
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.g.a
 * JD-Core Version:    0.7.0.1
 */