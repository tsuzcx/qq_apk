package com.tencent.mm.modelsns;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Map;

public final class h
  implements j
{
  public jo jli;
  
  public h()
  {
    AppMethodBeat.i(192730);
    this.jli = new jo();
    AppMethodBeat.o(192730);
  }
  
  public static boolean a(Context paramContext, jo paramjo, Rect paramRect)
  {
    AppMethodBeat.i(192734);
    Log.i("MicroMsg.SnsMpVideoShareObject", "onClick %s/%s", new Object[] { paramjo.dHc, paramjo.KOf });
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramjo.dHc);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    localIntent.putExtra("img_gallery_width", paramRect.right - paramRect.left).putExtra("img_gallery_height", paramRect.bottom - paramRect.top).putExtra("img_gallery_left", paramRect.left).putExtra("img_gallery_top", paramRect.top);
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_mp_video_click_from", 1);
    localIntent.putExtra("img_gallery_path", MD5Util.getMD5String(paramjo.videoUrl));
    localIntent.putExtra("show_enter_grid", false);
    localIntent.putExtra("KOpenArticleSceneFromScene", 2);
    try
    {
      localIntent.putExtra("img_gallery_mp_share_video_info", paramjo.toByteArray());
      c.f(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(192734);
      return true;
    }
    catch (IOException paramjo)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsMpVideoShareObject", "onClick toByteArray ex %s", new Object[] { paramjo.getMessage() });
      }
    }
  }
  
  public static String b(jo paramjo)
  {
    AppMethodBeat.i(192732);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramjo != null) {}
    try
    {
      localStringBuilder.append("<mmbrandmpvideo>");
      localStringBuilder.append("<mpUrl>").append(Util.escapeStringForXml(paramjo.KOe)).append("</mpUrl>");
      localStringBuilder.append("<thumbUrl>").append(Util.escapeStringForXml(paramjo.iAo)).append("</thumbUrl>");
      localStringBuilder.append("<videoVid>").append(paramjo.KOf).append("</videoVid>");
      localStringBuilder.append("<bizUsrName>").append(paramjo.dHc).append("</bizUsrName>");
      localStringBuilder.append("<bizNickName>").append(paramjo.iAg).append("</bizNickName>");
      localStringBuilder.append("<videoUrl>").append(Util.escapeStringForXml(paramjo.videoUrl)).append("</videoUrl>");
      localStringBuilder.append("<url>").append(Util.escapeStringForXml(paramjo.url)).append("</url>");
      localStringBuilder.append("<title>").append(Util.escapeStringForXml(paramjo.title)).append("</title>");
      localStringBuilder.append("<videoDuration>").append(paramjo.videoDuration).append("</videoDuration>");
      localStringBuilder.append("<thumbWidth>").append(paramjo.width).append("</thumbWidth>");
      localStringBuilder.append("<thumbHeight>").append(paramjo.height).append("</thumbHeight>");
      localStringBuilder.append("</mmbrandmpvideo>");
      paramjo = localStringBuilder.toString();
      AppMethodBeat.o(192732);
      return paramjo;
    }
    catch (Exception paramjo)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsMpVideoShareObject", "make content error %s", new Object[] { paramjo.getMessage() });
      }
    }
  }
  
  public static jo k(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(192733);
    jo localjo = new jo();
    try
    {
      paramString = paramString + ".mmbrandmpvideo";
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(paramString + ".videoUrl")))
      {
        localjo.KOe = Util.nullAsNil((String)paramMap.get(paramString + ".mpUrl"));
        localjo.videoUrl = Util.nullAsNil((String)paramMap.get(paramString + ".videoUrl"));
        localjo.url = Util.nullAsNil((String)paramMap.get(paramString + ".url"));
        localjo.title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
        localjo.KOf = Util.nullAsNil((String)paramMap.get(paramString + ".videoVid"));
        localjo.iAo = Util.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
        localjo.dHc = Util.nullAsNil((String)paramMap.get(paramString + ".bizUsrName"));
        localjo.iAg = Util.nullAsNil((String)paramMap.get(paramString + ".bizNickName"));
        localjo.videoDuration = ((int)Util.safeParseFloat((String)paramMap.get(paramString + ".videoDuration")));
        localjo.width = ((int)Util.safeParseFloat((String)paramMap.get(paramString + ".thumbWidth")));
        localjo.height = ((int)Util.safeParseFloat((String)paramMap.get(paramString + ".thumbHeight")));
      }
      AppMethodBeat.o(192733);
      return localjo;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsMpVideoShareObject", "parse error %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final String bfF()
  {
    AppMethodBeat.i(192731);
    String str = b(this.jli);
    AppMethodBeat.o(192731);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.h
 * JD-Core Version:    0.7.0.1
 */