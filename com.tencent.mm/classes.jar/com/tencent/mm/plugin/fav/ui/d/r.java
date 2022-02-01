package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.sdk.platformtools.Util;

public final class r
  extends b
{
  private final int Aod;
  
  public r(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(107493);
    this.Aod = a.br(paramFavoriteImageServer.context, q.c.FavIconSize);
    AppMethodBeat.o(107493);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107494);
    Object localObject1 = paramViewGroup.getContext();
    TextView localTextView;
    Object localObject2;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localObject1 = a(View.inflate((Context)localObject1, q.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.ttT = ((ImageView)((View)localObject1).findViewById(q.e.fav_icon));
      paramViewGroup.Aov = ((ImageView)((View)localObject1).findViewById(q.e.fav_icon_mask));
      paramViewGroup.pJJ = ((TextView)((View)localObject1).findViewById(q.e.fav_title));
      paramViewGroup.pJJ.setMaxLines(2);
      a(paramViewGroup, paramg);
      arf localarf1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      ask localask = paramg.field_favProto.ZAj;
      localTextView = paramViewGroup.pJJ;
      arf localarf2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramView = "";
      if (localask != null) {
        paramView = localask.title;
      }
      localObject2 = paramView;
      if (Util.isNullOrNil(paramView))
      {
        localObject2 = paramView;
        if (localarf2 != null) {
          localObject2 = localarf2.title;
        }
      }
      if (!Util.isNullOrNil((String)localObject2)) {
        break label343;
      }
      localTextView.setVisibility(8);
      label180:
      int j = f.boR(localarf1.ZyU);
      paramView = this.AfM;
      localObject2 = paramViewGroup.ttT;
      int i = j;
      if (j == f.iGF()) {
        i = q.h.app_attach_file_icon_webpage;
      }
      paramView.a((ImageView)localObject2, localarf1, paramg, i, this.Aod, this.Aod);
      if (((paramg.field_favProto.WKx == null) || (paramg.field_favProto.WKx.nQm != 16)) && ((localask == null) || (Util.isNullOrNil(localask.ZCa)))) {
        break label359;
      }
      paramViewGroup.Aov.setImageResource(q.h.shortvideo_play_btn);
      paramViewGroup.Aov.setVisibility(0);
    }
    for (;;)
    {
      if (paramViewGroup.Aov != null) {
        paramViewGroup.Aov.setContentDescription("");
      }
      am(paramViewGroup.ttT, 5);
      AppMethodBeat.o(107494);
      return localObject1;
      paramViewGroup = (a)paramView.getTag();
      localObject1 = paramView;
      break;
      label343:
      localTextView.setText((CharSequence)localObject2);
      localTextView.setVisibility(0);
      break label180;
      label359:
      paramViewGroup.Aov.setVisibility(8);
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107496);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    Object localObject = locala.ttT;
    g localg = locala.AdF;
    if ((localg.field_favProto == null) || (localg.field_favProto.WKx == null) || (localg.field_favProto.WKx.nQm < 0)) {}
    for (;;)
    {
      ((z)h.ax(z.class)).a(paramView, locala.AdF, paramarx);
      AppMethodBeat.o(107496);
      return;
      int[] arrayOfInt = new int[2];
      if (localObject != null)
      {
        int i = ((View)localObject).getWidth();
        int j = ((View)localObject).getHeight();
        ((View)localObject).getLocationInWindow(arrayOfInt);
        localObject = localg.field_favProto.WKx;
        ((arn)localObject).ZBl = new aro();
        ((arn)localObject).ZBl.left = arrayOfInt[0];
        ((arn)localObject).ZBl.top = arrayOfInt[1];
        ((arn)localObject).ZBl.width = i;
        ((arn)localObject).ZBl.height = j;
      }
    }
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(107495);
    try
    {
      ask localask = paramb.AdF.field_favProto.ZAj;
      if ((localask != null) && (!Util.isNullOrNil(localask.ZCa)))
      {
        paramb.pUL.setText(q.i.topstory);
        AppMethodBeat.o(107495);
        return;
      }
      super.a(paramb);
      AppMethodBeat.o(107495);
      return;
    }
    catch (Exception paramb)
    {
      AppMethodBeat.o(107495);
    }
  }
  
  public static final class a
    extends b.b
  {
    ImageView Aov;
    TextView pJJ;
    ImageView ttT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.r
 * JD-Core Version:    0.7.0.1
 */