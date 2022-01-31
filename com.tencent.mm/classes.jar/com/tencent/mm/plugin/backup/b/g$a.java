package com.tencent.mm.plugin.backup.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.backup.f.k;
import com.tencent.mm.plugin.backup.f.k.a;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g$a
{
  public static String jzf = "<msg>";
  public static String jzg = "</msg>";
  
  public static String Gn(String paramString)
  {
    AppMethodBeat.i(17116);
    paramString = k.Gr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(17116);
      return null;
    }
    paramString = paramString.jDN;
    AppMethodBeat.o(17116);
    return paramString;
  }
  
  public static String a(bi parambi, gx paramgx)
  {
    AppMethodBeat.i(17117);
    EmojiInfo localEmojiInfo = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUI().asP(parambi.field_imgPath);
    if (localEmojiInfo == null)
    {
      AppMethodBeat.o(17117);
      return null;
    }
    Object localObject = k.Gs(localEmojiInfo.Al());
    parambi = (bi)localObject;
    if (localObject == null) {
      parambi = new k.a(localEmojiInfo.Al(), localEmojiInfo.Al(), localEmojiInfo.Al(), localEmojiInfo.Al());
    }
    localObject = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput((Writer)localObject);
      localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "emoji");
      localXmlSerializer.attribute(null, "fromusername", paramgx.woP.xJE);
      localXmlSerializer.attribute(null, "tousername", paramgx.woQ.xJE);
      localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
      localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.dzu());
      localXmlSerializer.attribute(null, "md5", parambi.jDO);
      localXmlSerializer.attribute(null, "len", "1024");
      localXmlSerializer.attribute(null, "androidmd5", parambi.jDN);
      localXmlSerializer.attribute(null, "androidlen", "1024");
      localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
      localXmlSerializer.attribute(null, "cdnurl", localEmojiInfo.field_cdnUrl);
      localXmlSerializer.attribute(null, "designerid", localEmojiInfo.field_designerID);
      localXmlSerializer.attribute(null, "thumburl", localEmojiInfo.field_thumbUrl);
      localXmlSerializer.attribute(null, "encrypturl", localEmojiInfo.field_encrypturl);
      localXmlSerializer.attribute(null, "aeskey", localEmojiInfo.field_aeskey);
      localXmlSerializer.attribute(null, "externurl", localEmojiInfo.field_externUrl);
      localXmlSerializer.attribute(null, "externmd5", localEmojiInfo.field_externMd5);
      localXmlSerializer.attribute(null, "width", String.valueOf(localEmojiInfo.field_width));
      localXmlSerializer.attribute(null, "height", String.valueOf(localEmojiInfo.field_height));
      localXmlSerializer.attribute(null, "tpurl", localEmojiInfo.field_tpurl);
      localXmlSerializer.attribute(null, "tpauthkey", localEmojiInfo.field_tpauthkey);
      localXmlSerializer.attribute(null, "attachedtext", localEmojiInfo.field_attachedText);
      localXmlSerializer.attribute(null, "attachedtextcolor", localEmojiInfo.field_attachTextColor);
      localXmlSerializer.attribute(null, "lensid", localEmojiInfo.field_lensId);
      localXmlSerializer.attribute(null, "activityid", localEmojiInfo.field_activityid);
      localXmlSerializer.endTag(null, "emoji");
      if (localEmojiInfo.vY())
      {
        localXmlSerializer.startTag(null, "gameext");
        paramgx = br.F(localEmojiInfo.getContent(), "gameext");
        parambi = bo.bf((String)paramgx.get(".gameext.$type"), "");
        paramgx = bo.bf((String)paramgx.get(".gameext.$content"), "");
        if ((parambi.equals("")) || (paramgx.equals("")))
        {
          ((StringWriter)localObject).close();
          AppMethodBeat.o(17117);
          return "";
        }
        localXmlSerializer.attribute(null, "type", String.valueOf(parambi));
        localXmlSerializer.attribute(null, "content", String.valueOf(paramgx));
        localXmlSerializer.endTag(null, "gameext");
      }
      localXmlSerializer.endTag(null, "msg");
      localXmlSerializer.endDocument();
      ((StringWriter)localObject).flush();
      ((StringWriter)localObject).close();
      parambi = ((StringWriter)localObject).getBuffer().toString();
      return "";
    }
    catch (XmlPullParserException parambi)
    {
      try
      {
        parambi = parambi.substring(parambi.indexOf(jzf), parambi.indexOf(jzg) + jzg.length());
        ab.d("MicroMsg.BackupUtil.EmojiConvert", "xml ".concat(String.valueOf(parambi)));
        AppMethodBeat.o(17117);
        return parambi;
      }
      catch (Exception parambi)
      {
        AppMethodBeat.o(17117);
      }
      parambi = parambi;
      ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambi, "", new Object[0]);
      AppMethodBeat.o(17117);
      return "";
    }
    catch (IllegalArgumentException parambi)
    {
      ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambi, "", new Object[0]);
      AppMethodBeat.o(17117);
      return "";
    }
    catch (IllegalStateException parambi)
    {
      ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambi, "", new Object[0]);
      AppMethodBeat.o(17117);
      return "";
    }
    catch (IOException parambi)
    {
      ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambi, "", new Object[0]);
      AppMethodBeat.o(17117);
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.g.a
 * JD-Core Version:    0.7.0.1
 */