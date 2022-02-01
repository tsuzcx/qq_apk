package com.tencent.mm.modelsns;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Map;

public final class i
  implements k
{
  public jz oUf;
  
  public i()
  {
    AppMethodBeat.i(233245);
    this.oUf = new jz();
    AppMethodBeat.o(233245);
  }
  
  public static boolean a(Context paramContext, jz paramjz, Rect paramRect)
  {
    AppMethodBeat.i(233257);
    Log.i("MicroMsg.SnsMpVideoShareObject", "onClick %s/%s", new Object[] { paramjz.hEE, paramjz.YMn });
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramjz.hEE);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    localIntent.putExtra("img_gallery_width", paramRect.right - paramRect.left).putExtra("img_gallery_height", paramRect.bottom - paramRect.top).putExtra("img_gallery_left", paramRect.left).putExtra("img_gallery_top", paramRect.top);
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_mp_video_click_from", 1);
    localIntent.putExtra("img_gallery_path", MD5Util.getMD5String(paramjz.videoUrl));
    localIntent.putExtra("show_enter_grid", false);
    localIntent.putExtra("KOpenArticleSceneFromScene", 2);
    try
    {
      localIntent.putExtra("img_gallery_mp_share_video_info", paramjz.toByteArray());
      c.g(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(233257);
      return true;
    }
    catch (IOException paramjz)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsMpVideoShareObject", "onClick toByteArray ex %s", new Object[] { paramjz.getMessage() });
      }
    }
  }
  
  public static String b(jz paramjz)
  {
    AppMethodBeat.i(233251);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramjz != null) {}
    try
    {
      localStringBuilder.append("<mmbrandmpvideo>");
      localStringBuilder.append("<mpUrl>").append(Util.escapeStringForXml(paramjz.YMm)).append("</mpUrl>");
      localStringBuilder.append("<thumbUrl>").append(Util.escapeStringForXml(paramjz.nUM)).append("</thumbUrl>");
      localStringBuilder.append("<videoVid>").append(paramjz.YMn).append("</videoVid>");
      localStringBuilder.append("<bizUsrName>").append(paramjz.hEE).append("</bizUsrName>");
      localStringBuilder.append("<bizNickName>").append(paramjz.nUF).append("</bizNickName>");
      localStringBuilder.append("<videoUrl>").append(Util.escapeStringForXml(paramjz.videoUrl)).append("</videoUrl>");
      localStringBuilder.append("<url>").append(Util.escapeStringForXml(paramjz.url)).append("</url>");
      localStringBuilder.append("<title>").append(Util.escapeStringForXml(paramjz.title)).append("</title>");
      localStringBuilder.append("<videoDuration>").append(paramjz.videoDuration).append("</videoDuration>");
      localStringBuilder.append("<thumbWidth>").append(paramjz.width).append("</thumbWidth>");
      localStringBuilder.append("<thumbHeight>").append(paramjz.height).append("</thumbHeight>");
      localStringBuilder.append("</mmbrandmpvideo>");
      paramjz = localStringBuilder.toString();
      AppMethodBeat.o(233251);
      return paramjz;
    }
    catch (Exception paramjz)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsMpVideoShareObject", "make content error %s", new Object[] { paramjz.getMessage() });
      }
    }
  }
  
  public static jz j(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(233254);
    jz localjz = new jz();
    try
    {
      paramString = paramString + ".mmbrandmpvideo";
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(paramString + ".videoUrl")))
      {
        localjz.YMm = Util.nullAsNil((String)paramMap.get(paramString + ".mpUrl"));
        localjz.videoUrl = Util.nullAsNil((String)paramMap.get(paramString + ".videoUrl"));
        localjz.url = Util.nullAsNil((String)paramMap.get(paramString + ".url"));
        localjz.title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
        localjz.YMn = Util.nullAsNil((String)paramMap.get(paramString + ".videoVid"));
        localjz.nUM = Util.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
        localjz.hEE = Util.nullAsNil((String)paramMap.get(paramString + ".bizUsrName"));
        localjz.nUF = Util.nullAsNil((String)paramMap.get(paramString + ".bizNickName"));
        localjz.videoDuration = ((int)Util.safeParseFloat((String)paramMap.get(paramString + ".videoDuration")));
        localjz.width = ((int)Util.safeParseFloat((String)paramMap.get(paramString + ".thumbWidth")));
        localjz.height = ((int)Util.safeParseFloat((String)paramMap.get(paramString + ".thumbHeight")));
      }
      AppMethodBeat.o(233254);
      return localjz;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsMpVideoShareObject", "parse error %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final String bMC()
  {
    AppMethodBeat.i(233260);
    String str = b(this.oUf);
    AppMethodBeat.o(233260);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.i
 * JD-Core Version:    0.7.0.1
 */