package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arx;

public final class f
  extends b
{
  private static int Aod;
  
  public f(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(107454);
    Aod = a.br(paramFavoriteImageServer.context, q.c.FavImageSize);
    AppMethodBeat.o(107454);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107455);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, q.f.fav_listitem_image, null), paramViewGroup, paramg);
      paramViewGroup.Aop = ((ImageView)paramView.findViewById(q.e.fav_image));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      b(paramViewGroup.Aop, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramViewGroup = paramViewGroup.Aop;
      int i = q.h.fav_list_img_default;
      int j = Aod;
      FavoriteImageServer.a(paramViewGroup, i, (arf)localObject, paramg, false, j, j);
      AppMethodBeat.o(107455);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107456);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(107456);
  }
  
  public static final class a
    extends b.b
  {
    ImageView Aop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.f
 * JD-Core Version:    0.7.0.1
 */