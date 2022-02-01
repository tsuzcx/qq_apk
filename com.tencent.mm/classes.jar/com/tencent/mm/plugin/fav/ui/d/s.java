package com.tencent.mm.plugin.fav.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.y;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;

public final class s
  extends b
{
  final int Aod;
  
  public s(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(107497);
    this.Aod = a.br(paramFavoriteImageServer.context, q.c.FavImageSize);
    AppMethodBeat.o(107497);
  }
  
  public static boolean a(Context paramContext, arn paramarn, arf paramarf, boolean paramBoolean)
  {
    AppMethodBeat.i(274434);
    Log.i("MicroMsg.FavVideoListItem", "handleMpVideoItem %s/%s", new Object[] { paramarn.hEE, paramarn.vid });
    y localy = new y();
    localy.hEE = paramarn.hEE;
    localy.nUF = paramarn.nUF;
    localy.YMm = paramarn.YMm;
    localy.videoUrl = paramarn.videoUrl;
    localy.YMn = paramarn.vid;
    localy.title = paramarf.title;
    localy.nUM = paramarn.nUM;
    localy.width = paramarn.videoWidth;
    localy.height = paramarn.videoHeight;
    localy.videoDuration = paramarn.duration;
    localy.url = paramarf.ZyM;
    Log.i("MicroMsg.FavVideoListItem", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramarn.hEE);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    if (paramarn.ZBl != null) {
      localIntent.putExtra("img_gallery_width", paramarn.ZBl.width).putExtra("img_gallery_height", paramarn.ZBl.height).putExtra("img_gallery_left", paramarn.ZBl.left).putExtra("img_gallery_top", paramarn.ZBl.top);
    }
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_mp_video_click_from", 0);
    localIntent.putExtra("img_gallery_path", paramarf.hIQ);
    localIntent.putExtra("show_enter_grid", false);
    localIntent.putExtra("KOpenArticleSceneFromScene", 24);
    localIntent.putExtra("img_preview_only", paramBoolean);
    try
    {
      localIntent.putExtra("img_gallery_mp_share_video_info", localy.toByteArray());
      c.g(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(274434);
      return true;
    }
    catch (IOException paramarn)
    {
      for (;;)
      {
        Log.e("MicroMsg.FavVideoListItem", "handleMpVideoItem toByteArray ex %s", new Object[] { paramarn.getMessage() });
      }
    }
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107498);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, q.f.fav_listitem_shortview, null), paramViewGroup, paramg);
      paramViewGroup.Aop = ((ImageView)paramView.findViewById(q.e.fav_image));
      paramViewGroup.AoX = ((TextView)paramView.findViewById(q.e.fav_video_duration));
      paramViewGroup.AoX.setVisibility(0);
      LinkedList localLinkedList = paramg.field_favProto.vEn;
      if ((localLinkedList.size() <= 0) || (((arf)localLinkedList.getFirst()).duration <= 0)) {
        break label193;
      }
      paramViewGroup.AoX.setText(m.Q((Context)localObject, ((arf)localLinkedList.getFirst()).duration));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      b(paramViewGroup.Aop, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      this.AfM.a(paramViewGroup.Aop, (arf)localObject, paramg, q.h.app_attach_file_icon_video, this.Aod, this.Aod);
      AppMethodBeat.o(107498);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label193:
      paramViewGroup.AoX.setText("");
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107499);
    a locala = (a)paramView.getTag();
    Context localContext = paramView.getContext();
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(locala.AdF);
    View localView = paramView.findViewById(q.e.fav_image);
    if ((localObject == null) || (((arf)localObject).Zzy == null) || (((arf)localObject).Zzy.ZAz == null)) {}
    for (;;)
    {
      ((z)h.ax(z.class)).a(localContext, locala.AdF, paramarx);
      AppMethodBeat.o(107499);
      return;
      paramView = new int[2];
      if (localView != null)
      {
        int i = localView.getWidth();
        int j = localView.getHeight();
        localView.getLocationInWindow(paramView);
        localObject = ((arf)localObject).Zzy.ZAz;
        ((arn)localObject).ZBl = new aro();
        ((arn)localObject).ZBl.left = paramView[0];
        ((arn)localObject).ZBl.top = paramView[1];
        ((arn)localObject).ZBl.width = i;
        ((arn)localObject).ZBl.height = j;
      }
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView AoX;
    ImageView Aop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.s
 * JD-Core Version:    0.7.0.1
 */