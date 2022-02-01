package com.tencent.mm.modelsns;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Map;

public final class i
  implements k
{
  public jd mbl;
  
  public i()
  {
    AppMethodBeat.i(260366);
    this.mbl = new jd();
    AppMethodBeat.o(260366);
  }
  
  public static boolean a(Context paramContext, jd paramjd, Rect paramRect)
  {
    AppMethodBeat.i(260379);
    Log.i("MicroMsg.SnsMpVideoShareObject", "onClick %s/%s", new Object[] { paramjd.fzT, paramjd.RPa });
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramjd.fzT);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    localIntent.putExtra("img_gallery_width", paramRect.right - paramRect.left).putExtra("img_gallery_height", paramRect.bottom - paramRect.top).putExtra("img_gallery_left", paramRect.left).putExtra("img_gallery_top", paramRect.top);
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_mp_video_click_from", 1);
    localIntent.putExtra("img_gallery_path", MD5Util.getMD5String(paramjd.videoUrl));
    localIntent.putExtra("show_enter_grid", false);
    localIntent.putExtra("KOpenArticleSceneFromScene", 2);
    try
    {
      localIntent.putExtra("img_gallery_mp_share_video_info", paramjd.toByteArray());
      c.f(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(260379);
      return true;
    }
    catch (IOException paramjd)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsMpVideoShareObject", "onClick toByteArray ex %s", new Object[] { paramjd.getMessage() });
      }
    }
  }
  
  public static String b(jd paramjd)
  {
    AppMethodBeat.i(260372);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramjd != null) {}
    try
    {
      localStringBuilder.append("<mmbrandmpvideo>");
      localStringBuilder.append("<mpUrl>").append(Util.escapeStringForXml(paramjd.ROZ)).append("</mpUrl>");
      localStringBuilder.append("<thumbUrl>").append(Util.escapeStringForXml(paramjd.lpK)).append("</thumbUrl>");
      localStringBuilder.append("<videoVid>").append(paramjd.RPa).append("</videoVid>");
      localStringBuilder.append("<bizUsrName>").append(paramjd.fzT).append("</bizUsrName>");
      localStringBuilder.append("<bizNickName>").append(paramjd.lpC).append("</bizNickName>");
      localStringBuilder.append("<videoUrl>").append(Util.escapeStringForXml(paramjd.videoUrl)).append("</videoUrl>");
      localStringBuilder.append("<url>").append(Util.escapeStringForXml(paramjd.url)).append("</url>");
      localStringBuilder.append("<title>").append(Util.escapeStringForXml(paramjd.title)).append("</title>");
      localStringBuilder.append("<videoDuration>").append(paramjd.videoDuration).append("</videoDuration>");
      localStringBuilder.append("<thumbWidth>").append(paramjd.width).append("</thumbWidth>");
      localStringBuilder.append("<thumbHeight>").append(paramjd.height).append("</thumbHeight>");
      localStringBuilder.append("</mmbrandmpvideo>");
      paramjd = localStringBuilder.toString();
      AppMethodBeat.o(260372);
      return paramjd;
    }
    catch (Exception paramjd)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsMpVideoShareObject", "make content error %s", new Object[] { paramjd.getMessage() });
      }
    }
  }
  
  public static jd j(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(260375);
    jd localjd = new jd();
    try
    {
      paramString = paramString + ".mmbrandmpvideo";
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(paramString + ".videoUrl")))
      {
        localjd.ROZ = Util.nullAsNil((String)paramMap.get(paramString + ".mpUrl"));
        localjd.videoUrl = Util.nullAsNil((String)paramMap.get(paramString + ".videoUrl"));
        localjd.url = Util.nullAsNil((String)paramMap.get(paramString + ".url"));
        localjd.title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
        localjd.RPa = Util.nullAsNil((String)paramMap.get(paramString + ".videoVid"));
        localjd.lpK = Util.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
        localjd.fzT = Util.nullAsNil((String)paramMap.get(paramString + ".bizUsrName"));
        localjd.lpC = Util.nullAsNil((String)paramMap.get(paramString + ".bizNickName"));
        localjd.videoDuration = ((int)Util.safeParseFloat((String)paramMap.get(paramString + ".videoDuration")));
        localjd.width = ((int)Util.safeParseFloat((String)paramMap.get(paramString + ".thumbWidth")));
        localjd.height = ((int)Util.safeParseFloat((String)paramMap.get(paramString + ".thumbHeight")));
      }
      AppMethodBeat.o(260375);
      return localjd;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsMpVideoShareObject", "parse error %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final String boV()
  {
    AppMethodBeat.i(260368);
    String str = b(this.mbl);
    AppMethodBeat.o(260368);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.i
 * JD-Core Version:    0.7.0.1
 */