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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;

public final class s
  extends b
{
  final int tlc;
  
  public s(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107497);
    this.tlc = a.aG(paramo.context, 2131165370);
    AppMethodBeat.o(107497);
  }
  
  public static boolean a(Context paramContext, amt paramamt, aml paramaml, boolean paramBoolean)
  {
    AppMethodBeat.i(235384);
    Log.i("MicroMsg.FavVideoListItem", "handleMpVideoItem %s/%s", new Object[] { paramamt.dHc, paramamt.vid });
    com.tencent.mm.ag.y localy = new com.tencent.mm.ag.y();
    localy.dHc = paramamt.dHc;
    localy.iAg = paramamt.iAg;
    localy.KOe = paramamt.KOe;
    localy.videoUrl = paramamt.videoUrl;
    localy.KOf = paramamt.vid;
    localy.title = paramaml.title;
    localy.iAo = paramamt.iAo;
    localy.width = paramamt.videoWidth;
    localy.height = paramamt.videoHeight;
    localy.videoDuration = paramamt.duration;
    localy.url = paramaml.Lvu;
    Log.i("MicroMsg.FavVideoListItem", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent();
    localIntent.putExtra("show_search_chat_content_result", false);
    localIntent.putExtra("img_gallery_msg_id", 0);
    localIntent.putExtra("img_gallery_talker", paramamt.dHc);
    localIntent.putExtra("img_gallery_chatroom_name", false);
    if (paramamt.LxS != null) {
      localIntent.putExtra("img_gallery_width", paramamt.LxS.width).putExtra("img_gallery_height", paramamt.LxS.height).putExtra("img_gallery_left", paramamt.LxS.left).putExtra("img_gallery_top", paramamt.LxS.top);
    }
    localIntent.putExtra("img_gallery_is_mp_video_without_msg", true);
    localIntent.putExtra("img_gallery_mp_video_click_from", 0);
    localIntent.putExtra("img_gallery_path", paramaml.dLl);
    localIntent.putExtra("show_enter_grid", false);
    localIntent.putExtra("KOpenArticleSceneFromScene", 24);
    localIntent.putExtra("img_preview_only", paramBoolean);
    try
    {
      localIntent.putExtra("img_gallery_mp_share_video_info", localy.toByteArray());
      c.f(paramContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(235384);
      return true;
    }
    catch (IOException paramamt)
    {
      for (;;)
      {
        Log.e("MicroMsg.FavVideoListItem", "handleMpVideoItem toByteArray ex %s", new Object[] { paramamt.getMessage() });
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
      paramView = a(View.inflate((Context)localObject, 2131494133, null), paramViewGroup, paramg);
      paramViewGroup.tlo = ((ImageView)paramView.findViewById(2131300476));
      paramViewGroup.tlW = ((TextView)paramView.findViewById(2131300535));
      paramViewGroup.tlW.setVisibility(0);
      LinkedList localLinkedList = paramg.field_favProto.ppH;
      if ((localLinkedList.size() <= 0) || (((aml)localLinkedList.getFirst()).duration <= 0)) {
        break label181;
      }
      paramViewGroup.tlW.setText(m.J((Context)localObject, ((aml)localLinkedList.getFirst()).duration));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      this.tdg.a(paramViewGroup.tlo, (aml)localObject, paramg, 2131689584, this.tlc, this.tlc);
      AppMethodBeat.o(107498);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label181:
      paramViewGroup.tlW.setText("");
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107499);
    a locala = (a)paramView.getTag();
    Context localContext = paramView.getContext();
    Object localObject = com.tencent.mm.plugin.fav.a.b.c(locala.tbr);
    View localView = paramView.findViewById(2131300476);
    if ((localObject == null) || (((aml)localObject).Lwh == null) || (((aml)localObject).Lwh.Lxi == null)) {}
    for (;;)
    {
      ((com.tencent.mm.plugin.fav.a.y)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.y.class)).a(localContext, locala.tbr, paramand);
      AppMethodBeat.o(107499);
      return;
      paramView = new int[2];
      if (localView != null)
      {
        int i = localView.getWidth();
        int j = localView.getHeight();
        localView.getLocationInWindow(paramView);
        localObject = ((aml)localObject).Lwh.Lxi;
        ((amt)localObject).LxS = new amu();
        ((amt)localObject).LxS.left = paramView[0];
        ((amt)localObject).LxS.top = paramView[1];
        ((amt)localObject).LxS.width = i;
        ((amt)localObject).LxS.height = j;
      }
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView tlW;
    ImageView tlo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.s
 * JD-Core Version:    0.7.0.1
 */