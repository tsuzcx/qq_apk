package com.tencent.mm.plugin.fav.ui.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.LinkedList;

public final class r
  extends b
{
  final int rDf;
  
  public r(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107497);
    this.rDf = a.ax(paramo.context, 2131165359);
    AppMethodBeat.o(107497);
  }
  
  public static boolean a(Context paramContext, ajv paramajv, ajn paramajn, boolean paramBoolean)
  {
    AppMethodBeat.i(218831);
    ad.i("MicroMsg.FavVideoListItem", "handleMpVideoItem %s/%s", new Object[] { paramajv.doK, paramajv.hzm });
    com.tencent.mm.ai.y localy = new com.tencent.mm.ai.y();
    localy.doK = paramajv.doK;
    localy.hDe = paramajv.hDe;
    localy.FCb = paramajv.FCb;
    localy.videoUrl = paramajv.videoUrl;
    localy.FCc = paramajv.hzm;
    localy.title = paramajn.title;
    localy.hDm = paramajv.hDm;
    localy.width = paramajv.videoWidth;
    localy.height = paramajv.videoHeight;
    localy.videoDuration = paramajv.duration;
    localy.url = paramajn.GgY;
    ad.i("MicroMsg.FavVideoListItem", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramajv.doK);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    if (paramajv.Gjn != null) {
      localIntent.putExtra("img_gallery_width", paramajv.Gjn.width).putExtra("img_gallery_height", paramajv.Gjn.height).putExtra("img_gallery_left", paramajv.Gjn.left).putExtra("img_gallery_top", paramajv.Gjn.top);
    }
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_mp_video_click_from", 0);
    localIntent.putExtra("img_gallery_path", paramajn.dsU);
    localIntent.putExtra("show_enter_grid", false);
    localIntent.putExtra("KOpenArticleSceneFromScene", 24);
    localIntent.putExtra("img_preview_only", paramBoolean);
    try
    {
      localIntent.putExtra("img_gallery_mp_share_video_info", localy.toByteArray());
      d.f(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(218831);
      return true;
    }
    catch (IOException paramajv)
    {
      for (;;)
      {
        ad.e("MicroMsg.FavVideoListItem", "handleMpVideoItem toByteArray ex %s", new Object[] { paramajv.getMessage() });
      }
    }
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107498);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131493963, null), paramViewGroup, paramg);
      paramViewGroup.rDr = ((ImageView)paramView.findViewById(2131299801));
      paramViewGroup.rDY = ((TextView)paramView.findViewById(2131299855));
      paramViewGroup.rDY.setVisibility(0);
      LinkedList localLinkedList = paramg.field_favProto.nZa;
      if ((localLinkedList.size() <= 0) || (((ajn)localLinkedList.getFirst()).duration <= 0)) {
        break label181;
      }
      paramViewGroup.rDY.setText(m.G((Context)localObject, ((ajn)localLinkedList.getFirst()).duration));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      this.rvp.a(paramViewGroup.rDr, (ajn)localObject, paramg, 2131689581, this.rDf, this.rDf);
      AppMethodBeat.o(107498);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label181:
      paramViewGroup.rDY.setText("");
    }
  }
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(107499);
    a locala = (a)paramView.getTag();
    Context localContext = paramView.getContext();
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(locala.rtA);
    View localView = paramView.findViewById(2131299801);
    if ((localObject == null) || (((ajn)localObject).GhL == null) || (((ajn)localObject).GhL.GiM == null)) {}
    for (;;)
    {
      ((com.tencent.mm.plugin.fav.a.y)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.y.class)).a(localContext, locala.rtA, paramakf);
      AppMethodBeat.o(107499);
      return;
      paramView = new int[2];
      if (localView != null)
      {
        int i = localView.getWidth();
        int j = localView.getHeight();
        localView.getLocationInWindow(paramView);
        localObject = ((ajn)localObject).GhL.GiM;
        ((ajv)localObject).Gjn = new ajw();
        ((ajv)localObject).Gjn.left = paramView[0];
        ((ajv)localObject).Gjn.top = paramView[1];
        ((ajv)localObject).Gjn.width = i;
        ((ajv)localObject).Gjn.height = j;
      }
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView rDY;
    ImageView rDr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.r
 * JD-Core Version:    0.7.0.1
 */