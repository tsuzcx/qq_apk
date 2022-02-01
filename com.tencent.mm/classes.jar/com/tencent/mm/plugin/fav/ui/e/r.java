package com.tencent.mm.plugin.fav.ui.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.util.LinkedList;

public final class r
  extends b
{
  final int qTc;
  
  public r(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107497);
    this.qTc = a.au(paramo.context, 2131165359);
    AppMethodBeat.o(107497);
  }
  
  public static boolean a(Context paramContext, ahf paramahf, agx paramagx)
  {
    AppMethodBeat.i(107500);
    ac.i("MicroMsg.FavVideoListItem", "handleMpVideoItem %s/%s", new Object[] { paramahf.ddo, paramahf.hhd });
    com.tencent.mm.ah.y localy = new com.tencent.mm.ah.y();
    localy.ddo = paramahf.ddo;
    localy.hkV = paramahf.hkV;
    localy.DWF = paramahf.DWF;
    localy.videoUrl = paramahf.videoUrl;
    localy.DWG = paramahf.hhd;
    localy.title = paramagx.title;
    localy.hld = paramahf.hld;
    localy.width = paramahf.videoWidth;
    localy.height = paramahf.videoHeight;
    localy.videoDuration = paramahf.duration;
    localy.url = paramagx.Ezm;
    ac.i("MicroMsg.FavVideoListItem", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramahf.ddo);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    if (paramahf.EBB != null) {
      localIntent.putExtra("img_gallery_width", paramahf.EBB.width).putExtra("img_gallery_height", paramahf.EBB.height).putExtra("img_gallery_left", paramahf.EBB.left).putExtra("img_gallery_top", paramahf.EBB.top);
    }
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_path", paramagx.dhw);
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
    catch (IOException paramahf)
    {
      for (;;)
      {
        ac.e("MicroMsg.FavVideoListItem", "handleMpVideoItem toByteArray ex %s", new Object[] { paramahf.getMessage() });
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
      paramViewGroup.qTo = ((ImageView)paramView.findViewById(2131299801));
      paramViewGroup.qTV = ((TextView)paramView.findViewById(2131299855));
      paramViewGroup.qTV.setVisibility(0);
      LinkedList localLinkedList = paramg.field_favProto.nxC;
      if ((localLinkedList.size() <= 0) || (((agx)localLinkedList.getFirst()).duration <= 0)) {
        break label181;
      }
      paramViewGroup.qTV.setText(m.F((Context)localObject, ((agx)localLinkedList.getFirst()).duration));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      this.qLn.a(paramViewGroup.qTo, (agx)localObject, paramg, 2131689581, this.qTc, this.qTc);
      AppMethodBeat.o(107498);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label181:
      paramViewGroup.qTV.setText("");
    }
  }
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(107499);
    a locala = (a)paramView.getTag();
    Context localContext = paramView.getContext();
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(locala.qJy);
    View localView = paramView.findViewById(2131299801);
    if ((localObject == null) || (((agx)localObject).EzZ == null) || (((agx)localObject).EzZ.EBa == null)) {}
    for (;;)
    {
      ((com.tencent.mm.plugin.fav.a.y)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.y.class)).a(localContext, locala.qJy, paramahp);
      AppMethodBeat.o(107499);
      return;
      paramView = new int[2];
      if (localView != null)
      {
        int i = localView.getWidth();
        int j = localView.getHeight();
        localView.getLocationInWindow(paramView);
        localObject = ((agx)localObject).EzZ.EBa;
        ((ahf)localObject).EBB = new ahg();
        ((ahf)localObject).EBB.left = paramView[0];
        ((ahf)localObject).EBB.top = paramView[1];
        ((ahf)localObject).EBB.width = i;
        ((ahf)localObject).EBB.height = j;
      }
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView qTV;
    ImageView qTo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.r
 * JD-Core Version:    0.7.0.1
 */