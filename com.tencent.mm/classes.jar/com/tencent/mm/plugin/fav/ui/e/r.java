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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.LinkedList;

public final class r
  extends b
{
  final int rLq;
  
  public r(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107497);
    this.rLq = a.ax(paramo.context, 2131165359);
    AppMethodBeat.o(107497);
  }
  
  public static boolean a(Context paramContext, akf paramakf, ajx paramajx, boolean paramBoolean)
  {
    AppMethodBeat.i(191106);
    ae.i("MicroMsg.FavVideoListItem", "handleMpVideoItem %s/%s", new Object[] { paramakf.dpP, paramakf.hCa });
    com.tencent.mm.ah.y localy = new com.tencent.mm.ah.y();
    localy.dpP = paramakf.dpP;
    localy.hFW = paramakf.hFW;
    localy.FUw = paramakf.FUw;
    localy.videoUrl = paramakf.videoUrl;
    localy.FUx = paramakf.hCa;
    localy.title = paramajx.title;
    localy.hGe = paramakf.hGe;
    localy.width = paramakf.videoWidth;
    localy.height = paramakf.videoHeight;
    localy.videoDuration = paramakf.duration;
    localy.url = paramajx.GzH;
    ae.i("MicroMsg.FavVideoListItem", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramakf.dpP);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    if (paramakf.GBW != null) {
      localIntent.putExtra("img_gallery_width", paramakf.GBW.width).putExtra("img_gallery_height", paramakf.GBW.height).putExtra("img_gallery_left", paramakf.GBW.left).putExtra("img_gallery_top", paramakf.GBW.top);
    }
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_mp_video_click_from", 0);
    localIntent.putExtra("img_gallery_path", paramajx.dua);
    localIntent.putExtra("show_enter_grid", false);
    localIntent.putExtra("KOpenArticleSceneFromScene", 24);
    localIntent.putExtra("img_preview_only", paramBoolean);
    try
    {
      localIntent.putExtra("img_gallery_mp_share_video_info", localy.toByteArray());
      d.f(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(191106);
      return true;
    }
    catch (IOException paramakf)
    {
      for (;;)
      {
        ae.e("MicroMsg.FavVideoListItem", "handleMpVideoItem toByteArray ex %s", new Object[] { paramakf.getMessage() });
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
      paramViewGroup.rLC = ((ImageView)paramView.findViewById(2131299801));
      paramViewGroup.rMj = ((TextView)paramView.findViewById(2131299855));
      paramViewGroup.rMj.setVisibility(0);
      LinkedList localLinkedList = paramg.field_favProto.oeJ;
      if ((localLinkedList.size() <= 0) || (((ajx)localLinkedList.getFirst()).duration <= 0)) {
        break label181;
      }
      paramViewGroup.rMj.setText(m.G((Context)localObject, ((ajx)localLinkedList.getFirst()).duration));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      this.rDB.a(paramViewGroup.rLC, (ajx)localObject, paramg, 2131689581, this.rLq, this.rLq);
      AppMethodBeat.o(107498);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label181:
      paramViewGroup.rMj.setText("");
    }
  }
  
  public final void a(View paramView, akp paramakp)
  {
    AppMethodBeat.i(107499);
    a locala = (a)paramView.getTag();
    Context localContext = paramView.getContext();
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(locala.rBM);
    View localView = paramView.findViewById(2131299801);
    if ((localObject == null) || (((ajx)localObject).GAu == null) || (((ajx)localObject).GAu.GBv == null)) {}
    for (;;)
    {
      ((com.tencent.mm.plugin.fav.a.y)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.y.class)).a(localContext, locala.rBM, paramakp);
      AppMethodBeat.o(107499);
      return;
      paramView = new int[2];
      if (localView != null)
      {
        int i = localView.getWidth();
        int j = localView.getHeight();
        localView.getLocationInWindow(paramView);
        localObject = ((ajx)localObject).GAu.GBv;
        ((akf)localObject).GBW = new akg();
        ((akf)localObject).GBW.left = paramView[0];
        ((akf)localObject).GBW.top = paramView[1];
        ((akf)localObject).GBW.width = i;
        ((akf)localObject).GBW.height = j;
      }
    }
  }
  
  public static final class a
    extends b.b
  {
    ImageView rLC;
    TextView rMj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.r
 * JD-Core Version:    0.7.0.1
 */