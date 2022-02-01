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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.LinkedList;

public final class r
  extends b
{
  final int qkA;
  
  public r(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107497);
    this.qkA = a.ao(paramo.context, 2131165359);
    AppMethodBeat.o(107497);
  }
  
  public static boolean a(Context paramContext, agg paramagg, afy paramafy)
  {
    AppMethodBeat.i(107500);
    ad.i("MicroMsg.FavVideoListItem", "handleMpVideoItem %s/%s", new Object[] { paramagg.dfT, paramagg.gGC });
    com.tencent.mm.ai.y localy = new com.tencent.mm.ai.y();
    localy.dfT = paramagg.dfT;
    localy.gKv = paramagg.gKv;
    localy.CEf = paramagg.CEf;
    localy.videoUrl = paramagg.videoUrl;
    localy.CEg = paramagg.gGC;
    localy.title = paramafy.title;
    localy.gKD = paramagg.gKD;
    localy.width = paramagg.videoWidth;
    localy.height = paramagg.videoHeight;
    localy.videoDuration = paramagg.duration;
    localy.url = paramafy.Dgg;
    ad.i("MicroMsg.FavVideoListItem", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramagg.dfT);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    if (paramagg.Div != null) {
      localIntent.putExtra("img_gallery_width", paramagg.Div.width).putExtra("img_gallery_height", paramagg.Div.height).putExtra("img_gallery_left", paramagg.Div.left).putExtra("img_gallery_top", paramagg.Div.top);
    }
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_path", paramafy.dkb);
    localIntent.putExtra("show_enter_grid", false);
    localIntent.putExtra("KOpenArticleSceneFromScene", 24);
    try
    {
      localIntent.putExtra("img_gallery_mp_share_video_info", localy.toByteArray());
      d.e(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(107500);
      return true;
    }
    catch (IOException paramagg)
    {
      for (;;)
      {
        ad.e("MicroMsg.FavVideoListItem", "handleMpVideoItem toByteArray ex %s", new Object[] { paramagg.getMessage() });
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
      paramViewGroup.qkM = ((ImageView)paramView.findViewById(2131299801));
      paramViewGroup.qlt = ((TextView)paramView.findViewById(2131299855));
      paramViewGroup.qlt.setVisibility(0);
      LinkedList localLinkedList = paramg.field_favProto.mVb;
      if ((localLinkedList.size() <= 0) || (((afy)localLinkedList.getFirst()).duration <= 0)) {
        break label181;
      }
      paramViewGroup.qlt.setText(m.C((Context)localObject, ((afy)localLinkedList.getFirst()).duration));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      this.qcI.a(paramViewGroup.qkM, (afy)localObject, paramg, 2131689581, this.qkA, this.qkA);
      AppMethodBeat.o(107498);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label181:
      paramViewGroup.qlt.setText("");
    }
  }
  
  public final void a(View paramView, agq paramagq)
  {
    AppMethodBeat.i(107499);
    a locala = (a)paramView.getTag();
    Context localContext = paramView.getContext();
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(locala.qaS);
    View localView = paramView.findViewById(2131299801);
    if ((localObject == null) || (((afy)localObject).DgT == null) || (((afy)localObject).DgT.DhU == null)) {}
    for (;;)
    {
      ((com.tencent.mm.plugin.fav.a.y)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.y.class)).a(localContext, locala.qaS, paramagq);
      AppMethodBeat.o(107499);
      return;
      paramView = new int[2];
      if (localView != null)
      {
        int i = localView.getWidth();
        int j = localView.getHeight();
        localView.getLocationInWindow(paramView);
        localObject = ((afy)localObject).DgT.DhU;
        ((agg)localObject).Div = new agh();
        ((agg)localObject).Div.left = paramView[0];
        ((agg)localObject).Div.top = paramView[1];
        ((agg)localObject).Div.width = i;
        ((agg)localObject).Div.height = j;
      }
    }
  }
  
  public static final class a
    extends b.b
  {
    ImageView qkM;
    TextView qlt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.r
 * JD-Core Version:    0.7.0.1
 */