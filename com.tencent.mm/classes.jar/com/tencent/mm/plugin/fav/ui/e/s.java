package com.tencent.mm.plugin.fav.ui.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.y;
import com.tencent.mm.by.c;
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;

public final class s
  extends b
{
  final int wRA;
  
  public s(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107497);
    this.wRA = a.aY(paramo.context, s.c.FavImageSize);
    AppMethodBeat.o(107497);
  }
  
  public static boolean a(Context paramContext, anu paramanu, anm paramanm, boolean paramBoolean)
  {
    AppMethodBeat.i(228708);
    Log.i("MicroMsg.FavVideoListItem", "handleMpVideoItem %s/%s", new Object[] { paramanu.fzT, paramanu.vid });
    y localy = new y();
    localy.fzT = paramanu.fzT;
    localy.lpC = paramanu.lpC;
    localy.ROZ = paramanu.ROZ;
    localy.videoUrl = paramanu.videoUrl;
    localy.RPa = paramanu.vid;
    localy.title = paramanm.title;
    localy.lpK = paramanu.lpK;
    localy.width = paramanu.videoWidth;
    localy.height = paramanu.videoHeight;
    localy.videoDuration = paramanu.duration;
    localy.url = paramanm.SxU;
    Log.i("MicroMsg.FavVideoListItem", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramanu.fzT);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    if (paramanu.SAt != null) {
      localIntent.putExtra("img_gallery_width", paramanu.SAt.width).putExtra("img_gallery_height", paramanu.SAt.height).putExtra("img_gallery_left", paramanu.SAt.left).putExtra("img_gallery_top", paramanu.SAt.top);
    }
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_mp_video_click_from", 0);
    localIntent.putExtra("img_gallery_path", paramanm.fEa);
    localIntent.putExtra("show_enter_grid", false);
    localIntent.putExtra("KOpenArticleSceneFromScene", 24);
    localIntent.putExtra("img_preview_only", paramBoolean);
    try
    {
      localIntent.putExtra("img_gallery_mp_share_video_info", localy.toByteArray());
      c.f(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(228708);
      return true;
    }
    catch (IOException paramanu)
    {
      for (;;)
      {
        Log.e("MicroMsg.FavVideoListItem", "handleMpVideoItem toByteArray ex %s", new Object[] { paramanu.getMessage() });
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
      paramView = a(View.inflate((Context)localObject, s.f.fav_listitem_shortview, null), paramViewGroup, paramg);
      paramViewGroup.wRM = ((ImageView)paramView.findViewById(s.e.fav_image));
      paramViewGroup.wSu = ((TextView)paramView.findViewById(s.e.fav_video_duration));
      paramViewGroup.wSu.setVisibility(0);
      LinkedList localLinkedList = paramg.field_favProto.syG;
      if ((localLinkedList.size() <= 0) || (((anm)localLinkedList.getFirst()).duration <= 0)) {
        break label184;
      }
      paramViewGroup.wSu.setText(m.N((Context)localObject, ((anm)localLinkedList.getFirst()).duration));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      this.wJr.a(paramViewGroup.wRM, (anm)localObject, paramg, s.h.app_attach_file_icon_video, this.wRA, this.wRA);
      AppMethodBeat.o(107498);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label184:
      paramViewGroup.wSu.setText("");
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(107499);
    a locala = (a)paramView.getTag();
    Context localContext = paramView.getContext();
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(locala.wHw);
    View localView = paramView.findViewById(s.e.fav_image);
    if ((localObject == null) || (((anm)localObject).SyG == null) || (((anm)localObject).SyG.SzH == null)) {}
    for (;;)
    {
      ((z)h.ae(z.class)).a(localContext, locala.wHw, paramaoe);
      AppMethodBeat.o(107499);
      return;
      paramView = new int[2];
      if (localView != null)
      {
        int i = localView.getWidth();
        int j = localView.getHeight();
        localView.getLocationInWindow(paramView);
        localObject = ((anm)localObject).SyG.SzH;
        ((anu)localObject).SAt = new anv();
        ((anu)localObject).SAt.left = paramView[0];
        ((anu)localObject).SAt.top = paramView[1];
        ((anu)localObject).SAt.width = i;
        ((anu)localObject).SAt.height = j;
      }
    }
  }
  
  public static final class a
    extends b.b
  {
    ImageView wRM;
    TextView wSu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.s
 * JD-Core Version:    0.7.0.1
 */