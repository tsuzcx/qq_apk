package com.tencent.mm.modelsns;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.Map;

public final class d
{
  public jb ine;
  
  public d()
  {
    AppMethodBeat.i(213117);
    this.ine = new jb();
    AppMethodBeat.o(213117);
  }
  
  public static boolean a(Context paramContext, jb paramjb, Rect paramRect)
  {
    AppMethodBeat.i(213121);
    ad.i("MicroMsg.SnsMpVideoShareObject", "onClick %s/%s", new Object[] { paramjb.doK, paramjb.FCc });
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramjb.doK);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    localIntent.putExtra("img_gallery_width", paramRect.right - paramRect.left).putExtra("img_gallery_height", paramRect.bottom - paramRect.top).putExtra("img_gallery_left", paramRect.left).putExtra("img_gallery_top", paramRect.top);
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_mp_video_click_from", 1);
    localIntent.putExtra("img_gallery_path", ai.ee(paramjb.videoUrl));
    localIntent.putExtra("show_enter_grid", false);
    localIntent.putExtra("KOpenArticleSceneFromScene", 2);
    try
    {
      localIntent.putExtra("img_gallery_mp_share_video_info", paramjb.toByteArray());
      com.tencent.mm.bs.d.f(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(213121);
      return true;
    }
    catch (IOException paramjb)
    {
      for (;;)
      {
        ad.e("MicroMsg.SnsMpVideoShareObject", "onClick toByteArray ex %s", new Object[] { paramjb.getMessage() });
      }
    }
  }
  
  public static String b(jb paramjb)
  {
    AppMethodBeat.i(213119);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramjb != null) {}
    try
    {
      localStringBuilder.append("<mmbrandmpvideo>");
      localStringBuilder.append("<mpUrl>").append(bt.aRc(paramjb.FCb)).append("</mpUrl>");
      localStringBuilder.append("<thumbUrl>").append(bt.aRc(paramjb.hDm)).append("</thumbUrl>");
      localStringBuilder.append("<videoVid>").append(paramjb.FCc).append("</videoVid>");
      localStringBuilder.append("<bizUsrName>").append(paramjb.doK).append("</bizUsrName>");
      localStringBuilder.append("<bizNickName>").append(paramjb.hDe).append("</bizNickName>");
      localStringBuilder.append("<videoUrl>").append(bt.aRc(paramjb.videoUrl)).append("</videoUrl>");
      localStringBuilder.append("<url>").append(bt.aRc(paramjb.url)).append("</url>");
      localStringBuilder.append("<title>").append(bt.aRc(paramjb.title)).append("</title>");
      localStringBuilder.append("<videoDuration>").append(paramjb.videoDuration).append("</videoDuration>");
      localStringBuilder.append("<thumbWidth>").append(paramjb.width).append("</thumbWidth>");
      localStringBuilder.append("<thumbHeight>").append(paramjb.height).append("</thumbHeight>");
      localStringBuilder.append("</mmbrandmpvideo>");
      paramjb = localStringBuilder.toString();
      AppMethodBeat.o(213119);
      return paramjb;
    }
    catch (Exception paramjb)
    {
      for (;;)
      {
        ad.e("MicroMsg.SnsMpVideoShareObject", "make content error %s", new Object[] { paramjb.getMessage() });
      }
    }
  }
  
  public static jb j(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(213120);
    jb localjb = new jb();
    try
    {
      paramString = paramString + ".mmbrandmpvideo";
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(paramString + ".videoUrl")))
      {
        localjb.FCb = bt.nullAsNil((String)paramMap.get(paramString + ".mpUrl"));
        localjb.videoUrl = bt.nullAsNil((String)paramMap.get(paramString + ".videoUrl"));
        localjb.url = bt.nullAsNil((String)paramMap.get(paramString + ".url"));
        localjb.title = bt.nullAsNil((String)paramMap.get(paramString + ".title"));
        localjb.FCc = bt.nullAsNil((String)paramMap.get(paramString + ".videoVid"));
        localjb.hDm = bt.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
        localjb.doK = bt.nullAsNil((String)paramMap.get(paramString + ".bizUsrName"));
        localjb.hDe = bt.nullAsNil((String)paramMap.get(paramString + ".bizNickName"));
        localjb.videoDuration = ((int)bt.aRh((String)paramMap.get(paramString + ".videoDuration")));
        localjb.width = ((int)bt.aRh((String)paramMap.get(paramString + ".thumbWidth")));
        localjb.height = ((int)bt.aRh((String)paramMap.get(paramString + ".thumbHeight")));
      }
      AppMethodBeat.o(213120);
      return localjb;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.SnsMpVideoShareObject", "parse error %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final String aLf()
  {
    AppMethodBeat.i(213118);
    String str = b(this.ine);
    AppMethodBeat.o(213118);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.d
 * JD-Core Version:    0.7.0.1
 */