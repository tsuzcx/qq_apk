package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class ak
{
  public static css C(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(196085);
    css localcss = new css();
    try
    {
      paramString = paramString + ".musicShareItem";
      if (!paramMap.isEmpty())
      {
        localcss.Ktn = Util.nullAsNil((String)paramMap.get(paramString + ".mvObjectId"));
        localcss.Kto = Util.nullAsNil((String)paramMap.get(paramString + ".mvNonceId"));
        localcss.Ktp = Util.nullAsNil((String)paramMap.get(paramString + ".mvCoverUrl"));
        localcss.Ktq = Util.nullAsNil((String)paramMap.get(paramString + ".mvMakerFinderNickname"));
        localcss.singerName = Util.nullAsNil((String)paramMap.get(paramString + ".mvSingerName"));
        localcss.albumName = Util.nullAsNil((String)paramMap.get(paramString + ".mvAlbumName"));
        localcss.musicGenre = Util.nullAsNil((String)paramMap.get(paramString + ".mvMusicGenre"));
        localcss.issueDate = Util.safeParseLong((String)paramMap.get(paramString + ".mvIssueDate"));
        localcss.identification = Util.nullAsNil((String)paramMap.get(paramString + ".mvIdentification"));
        localcss.Alz = Util.safeParseInt((String)paramMap.get(paramString + ".musicDuration"));
        localcss.extraInfo = Util.nullAsNil((String)paramMap.get(paramString + ".mvExtInfo"));
      }
      AppMethodBeat.o(196085);
      return localcss;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.MusicMvShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public static String a(css paramcss)
  {
    AppMethodBeat.i(196084);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramcss != null) {}
    try
    {
      localStringBuilder.append("<musicShareItem><mvObjectId>").append(Util.escapeStringForXml(paramcss.Ktn)).append("</mvObjectId><mvNonceId>").append(Util.escapeStringForXml(paramcss.Kto)).append("</mvNonceId><mvCoverUrl>").append(Util.escapeStringForXml(paramcss.Ktp)).append("</mvCoverUrl><mvMakerFinderNickname>").append(Util.escapeStringForXml(paramcss.Ktq)).append("</mvMakerFinderNickname><mvSingerName>").append(Util.escapeStringForXml(paramcss.singerName)).append("</mvSingerName><mvAlbumName>").append(Util.escapeStringForXml(paramcss.albumName)).append("</mvAlbumName><mvMusicGenre>").append(Util.escapeStringForXml(paramcss.musicGenre)).append("</mvMusicGenre><mvIssueDate>").append(paramcss.issueDate).append("</mvIssueDate><mvIdentification>").append(Util.escapeStringForXml(paramcss.identification)).append("</mvIdentification><musicDuration>").append(paramcss.Alz).append("</musicDuration><mvExtInfo>").append(paramcss.extraInfo).append("</mvExtInfo>");
      localStringBuilder.append("</musicShareItem>");
      paramcss = localStringBuilder.toString();
      AppMethodBeat.o(196084);
      return paramcss;
    }
    catch (Exception paramcss)
    {
      for (;;)
      {
        Log.e("MicroMsg.MusicMvShareParser", "make content error! %s", new Object[] { paramcss.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.ak
 * JD-Core Version:    0.7.0.1
 */