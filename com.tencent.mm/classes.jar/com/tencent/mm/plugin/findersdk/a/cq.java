package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class cq
{
  public static dtj J(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(274024);
    dtj localdtj = new dtj();
    try
    {
      paramString = paramString + ".musicShareItem";
      if (!paramMap.isEmpty())
      {
        localdtj.YqN = Util.nullAsNil((String)paramMap.get(paramString + ".mvObjectId"));
        localdtj.YqO = Util.nullAsNil((String)paramMap.get(paramString + ".mvNonceId"));
        localdtj.YqP = Util.nullAsNil((String)paramMap.get(paramString + ".mvCoverUrl"));
        localdtj.YqQ = Util.nullAsNil((String)paramMap.get(paramString + ".mvMakerFinderNickname"));
        localdtj.singerName = Util.nullAsNil((String)paramMap.get(paramString + ".mvSingerName"));
        localdtj.albumName = Util.nullAsNil((String)paramMap.get(paramString + ".mvAlbumName"));
        localdtj.musicGenre = Util.nullAsNil((String)paramMap.get(paramString + ".mvMusicGenre"));
        localdtj.issueDate = Util.safeParseLong((String)paramMap.get(paramString + ".mvIssueDate"));
        localdtj.identification = Util.nullAsNil((String)paramMap.get(paramString + ".mvIdentification"));
        localdtj.LNC = Util.safeParseInt((String)paramMap.get(paramString + ".musicDuration"));
        localdtj.extraInfo = Util.nullAsNil((String)paramMap.get(paramString + ".mvExtInfo"));
        localdtj.musicOperationUrl = Util.nullAsNil((String)paramMap.get(paramString + ".mvOperationUrl"));
        localdtj.oOZ = Util.nullAsNil((String)paramMap.get(paramString + ".mid"));
        localdtj.YqY = Util.nullAsNil((String)paramMap.get(paramString + ".appIdForSourceDisplay"));
      }
      AppMethodBeat.o(274024);
      return localdtj;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.MusicMvShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public static String a(dtj paramdtj)
  {
    AppMethodBeat.i(274017);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramdtj != null) {}
    try
    {
      localStringBuilder.append("<musicShareItem><mvObjectId>").append(Util.escapeStringForXml(paramdtj.YqN)).append("</mvObjectId><mvNonceId>").append(Util.escapeStringForXml(paramdtj.YqO)).append("</mvNonceId><mvCoverUrl>").append(Util.escapeStringForXml(paramdtj.YqP)).append("</mvCoverUrl><mvMakerFinderNickname>").append(Util.escapeStringForXml(paramdtj.YqQ)).append("</mvMakerFinderNickname><mvSingerName>").append(Util.escapeStringForXml(paramdtj.singerName)).append("</mvSingerName><mvAlbumName>").append(Util.escapeStringForXml(paramdtj.albumName)).append("</mvAlbumName><mvMusicGenre>").append(Util.escapeStringForXml(paramdtj.musicGenre)).append("</mvMusicGenre><mvIssueDate>").append(paramdtj.issueDate).append("</mvIssueDate><mvIdentification>").append(Util.escapeStringForXml(paramdtj.identification)).append("</mvIdentification><musicDuration>").append(paramdtj.LNC).append("</musicDuration><mvExtInfo>").append(Util.escapeStringForXml(paramdtj.extraInfo)).append("</mvExtInfo><mvOperationUrl>").append(Util.escapeStringForXml(paramdtj.musicOperationUrl)).append("</mvOperationUrl><mid>").append(Util.escapeStringForXml(paramdtj.oOZ)).append("</mid><appIdForSourceDisplay>").append(Util.escapeStringForXml(paramdtj.YqY)).append("</appIdForSourceDisplay>");
      localStringBuilder.append("</musicShareItem>");
      paramdtj = localStringBuilder.toString();
      AppMethodBeat.o(274017);
      return paramdtj;
    }
    catch (Exception paramdtj)
    {
      for (;;)
      {
        Log.e("MicroMsg.MusicMvShareParser", "make content error! %s", new Object[] { paramdtj.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.cq
 * JD-Core Version:    0.7.0.1
 */