package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.backup.f.k;
import com.tencent.mm.plugin.backup.f.k.a;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
  public static String hFI = "<msg>";
  public static String hFJ = "</msg>";
  
  public static String a(bi parambi, fo paramfo)
  {
    EmojiInfo localEmojiInfo = com.tencent.mm.plugin.backup.h.d.avi().avj().avg().acC(parambi.field_imgPath);
    if (localEmojiInfo == null) {
      return null;
    }
    Object localObject = k.xz(localEmojiInfo.Wv());
    parambi = (bi)localObject;
    if (localObject == null) {
      parambi = new k.a(localEmojiInfo.Wv(), localEmojiInfo.Wv(), localEmojiInfo.Wv(), localEmojiInfo.Wv());
    }
    localObject = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
      localXmlSerializer.setOutput((Writer)localObject);
      localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.startTag(null, "emoji");
      localXmlSerializer.attribute(null, "fromusername", paramfo.svF.tFO);
      localXmlSerializer.attribute(null, "tousername", paramfo.svG.tFO);
      localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
      localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.cwG());
      localXmlSerializer.attribute(null, "md5", parambi.hKl);
      localXmlSerializer.attribute(null, "len", "1024");
      localXmlSerializer.attribute(null, "androidmd5", parambi.hKk);
      localXmlSerializer.attribute(null, "androidlen", "1024");
      localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
      localXmlSerializer.endTag(null, "emoji");
      if (localEmojiInfo.ZH())
      {
        localXmlSerializer.startTag(null, "gameext");
        paramfo = bn.s(localEmojiInfo.getContent(), "gameext");
        parambi = bk.aM((String)paramfo.get(".gameext.$type"), "");
        paramfo = bk.aM((String)paramfo.get(".gameext.$content"), "");
        if ((parambi.equals("")) || (paramfo.equals("")))
        {
          ((StringWriter)localObject).close();
          return "";
        }
        localXmlSerializer.attribute(null, "type", parambi);
        localXmlSerializer.attribute(null, "content", paramfo);
        localXmlSerializer.endTag(null, "gameext");
      }
      localXmlSerializer.endTag(null, "msg");
      localXmlSerializer.endDocument();
      ((StringWriter)localObject).flush();
      ((StringWriter)localObject).close();
      parambi = ((StringWriter)localObject).getBuffer().toString();
      try
      {
        parambi = parambi.substring(parambi.indexOf(hFI), parambi.indexOf(hFJ) + hFJ.length());
        y.d("MicroMsg.BackupUtil.EmojiConvert", "xml " + parambi);
        return parambi;
      }
      catch (Exception parambi)
      {
        return "";
      }
      return "";
    }
    catch (XmlPullParserException parambi)
    {
      y.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambi, "", new Object[0]);
      return "";
    }
    catch (IllegalArgumentException parambi)
    {
      y.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambi, "", new Object[0]);
      return "";
    }
    catch (IllegalStateException parambi)
    {
      y.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambi, "", new Object[0]);
      return "";
    }
    catch (IOException parambi)
    {
      y.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", parambi, "", new Object[0]);
    }
  }
  
  public static String xu(String paramString)
  {
    paramString = k.xy(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.hKk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.g.a
 * JD-Core Version:    0.7.0.1
 */