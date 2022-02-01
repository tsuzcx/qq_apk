package com.tencent.mm.modelsns;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.util.Map;

public final class d
{
  public jb ipY;
  
  public d()
  {
    AppMethodBeat.i(218269);
    this.ipY = new jb();
    AppMethodBeat.o(218269);
  }
  
  public static boolean a(Context paramContext, jb paramjb, Rect paramRect)
  {
    AppMethodBeat.i(218273);
    ae.i("MicroMsg.SnsMpVideoShareObject", "onClick %s/%s", new Object[] { paramjb.dpP, paramjb.FUx });
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramjb.dpP);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    localIntent.putExtra("img_gallery_width", paramRect.right - paramRect.left).putExtra("img_gallery_height", paramRect.bottom - paramRect.top).putExtra("img_gallery_left", paramRect.left).putExtra("img_gallery_top", paramRect.top);
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_mp_video_click_from", 1);
    localIntent.putExtra("img_gallery_path", aj.ej(paramjb.videoUrl));
    localIntent.putExtra("show_enter_grid", false);
    localIntent.putExtra("KOpenArticleSceneFromScene", 2);
    try
    {
      localIntent.putExtra("img_gallery_mp_share_video_info", paramjb.toByteArray());
      com.tencent.mm.br.d.f(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(218273);
      return true;
    }
    catch (IOException paramjb)
    {
      for (;;)
      {
        ae.e("MicroMsg.SnsMpVideoShareObject", "onClick toByteArray ex %s", new Object[] { paramjb.getMessage() });
      }
    }
  }
  
  public static String b(jb paramjb)
  {
    AppMethodBeat.i(218271);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramjb != null) {}
    try
    {
      localStringBuilder.append("<mmbrandmpvideo>");
      localStringBuilder.append("<mpUrl>").append(bu.aSz(paramjb.FUw)).append("</mpUrl>");
      localStringBuilder.append("<thumbUrl>").append(bu.aSz(paramjb.hGe)).append("</thumbUrl>");
      localStringBuilder.append("<videoVid>").append(paramjb.FUx).append("</videoVid>");
      localStringBuilder.append("<bizUsrName>").append(paramjb.dpP).append("</bizUsrName>");
      localStringBuilder.append("<bizNickName>").append(paramjb.hFW).append("</bizNickName>");
      localStringBuilder.append("<videoUrl>").append(bu.aSz(paramjb.videoUrl)).append("</videoUrl>");
      localStringBuilder.append("<url>").append(bu.aSz(paramjb.url)).append("</url>");
      localStringBuilder.append("<title>").append(bu.aSz(paramjb.title)).append("</title>");
      localStringBuilder.append("<videoDuration>").append(paramjb.videoDuration).append("</videoDuration>");
      localStringBuilder.append("<thumbWidth>").append(paramjb.width).append("</thumbWidth>");
      localStringBuilder.append("<thumbHeight>").append(paramjb.height).append("</thumbHeight>");
      localStringBuilder.append("</mmbrandmpvideo>");
      paramjb = localStringBuilder.toString();
      AppMethodBeat.o(218271);
      return paramjb;
    }
    catch (Exception paramjb)
    {
      for (;;)
      {
        ae.e("MicroMsg.SnsMpVideoShareObject", "make content error %s", new Object[] { paramjb.getMessage() });
      }
    }
  }
  
  public static jb k(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(218272);
    jb localjb = new jb();
    try
    {
      paramString = paramString + ".mmbrandmpvideo";
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(paramString + ".videoUrl")))
      {
        localjb.FUw = bu.nullAsNil((String)paramMap.get(paramString + ".mpUrl"));
        localjb.videoUrl = bu.nullAsNil((String)paramMap.get(paramString + ".videoUrl"));
        localjb.url = bu.nullAsNil((String)paramMap.get(paramString + ".url"));
        localjb.title = bu.nullAsNil((String)paramMap.get(paramString + ".title"));
        localjb.FUx = bu.nullAsNil((String)paramMap.get(paramString + ".videoVid"));
        localjb.hGe = bu.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
        localjb.dpP = bu.nullAsNil((String)paramMap.get(paramString + ".bizUsrName"));
        localjb.hFW = bu.nullAsNil((String)paramMap.get(paramString + ".bizNickName"));
        localjb.videoDuration = ((int)bu.aSE((String)paramMap.get(paramString + ".videoDuration")));
        localjb.width = ((int)bu.aSE((String)paramMap.get(paramString + ".thumbWidth")));
        localjb.height = ((int)bu.aSE((String)paramMap.get(paramString + ".thumbHeight")));
      }
      AppMethodBeat.o(218272);
      return localjb;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.SnsMpVideoShareObject", "parse error %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final String aLC()
  {
    AppMethodBeat.i(218270);
    String str = b(this.ipY);
    AppMethodBeat.o(218270);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.d
 * JD-Core Version:    0.7.0.1
 */