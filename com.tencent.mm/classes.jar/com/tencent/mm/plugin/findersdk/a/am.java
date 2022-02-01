package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class am
{
  public static dbr C(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(205825);
    dbr localdbr = new dbr();
    try
    {
      paramString = paramString + ".musicShareItem";
      if (!paramMap.isEmpty())
      {
        localdbr.Ruu = Util.nullAsNil((String)paramMap.get(paramString + ".mvObjectId"));
        localdbr.Ruv = Util.nullAsNil((String)paramMap.get(paramString + ".mvNonceId"));
        localdbr.Ruw = Util.nullAsNil((String)paramMap.get(paramString + ".mvCoverUrl"));
        localdbr.Rux = Util.nullAsNil((String)paramMap.get(paramString + ".mvMakerFinderNickname"));
        localdbr.singerName = Util.nullAsNil((String)paramMap.get(paramString + ".mvSingerName"));
        localdbr.albumName = Util.nullAsNil((String)paramMap.get(paramString + ".mvAlbumName"));
        localdbr.musicGenre = Util.nullAsNil((String)paramMap.get(paramString + ".mvMusicGenre"));
        localdbr.issueDate = Util.safeParseLong((String)paramMap.get(paramString + ".mvIssueDate"));
        localdbr.identification = Util.nullAsNil((String)paramMap.get(paramString + ".mvIdentification"));
        localdbr.FSG = Util.safeParseInt((String)paramMap.get(paramString + ".musicDuration"));
        localdbr.extraInfo = Util.nullAsNil((String)paramMap.get(paramString + ".mvExtInfo"));
      }
      AppMethodBeat.o(205825);
      return localdbr;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.MusicMvShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public static String a(dbr paramdbr)
  {
    AppMethodBeat.i(205824);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramdbr != null) {}
    try
    {
      localStringBuilder.append("<musicShareItem><mvObjectId>").append(Util.escapeStringForXml(paramdbr.Ruu)).append("</mvObjectId><mvNonceId>").append(Util.escapeStringForXml(paramdbr.Ruv)).append("</mvNonceId><mvCoverUrl>").append(Util.escapeStringForXml(paramdbr.Ruw)).append("</mvCoverUrl><mvMakerFinderNickname>").append(Util.escapeStringForXml(paramdbr.Rux)).append("</mvMakerFinderNickname><mvSingerName>").append(Util.escapeStringForXml(paramdbr.singerName)).append("</mvSingerName><mvAlbumName>").append(Util.escapeStringForXml(paramdbr.albumName)).append("</mvAlbumName><mvMusicGenre>").append(Util.escapeStringForXml(paramdbr.musicGenre)).append("</mvMusicGenre><mvIssueDate>").append(paramdbr.issueDate).append("</mvIssueDate><mvIdentification>").append(Util.escapeStringForXml(paramdbr.identification)).append("</mvIdentification><musicDuration>").append(paramdbr.FSG).append("</musicDuration><mvExtInfo>").append(Util.escapeStringForXml(paramdbr.extraInfo)).append("</mvExtInfo>");
      localStringBuilder.append("</musicShareItem>");
      paramdbr = localStringBuilder.toString();
      AppMethodBeat.o(205824);
      return paramdbr;
    }
    catch (Exception paramdbr)
    {
      for (;;)
      {
        Log.e("MicroMsg.MusicMvShareParser", "make content error! %s", new Object[] { paramdbr.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.am
 * JD-Core Version:    0.7.0.1
 */