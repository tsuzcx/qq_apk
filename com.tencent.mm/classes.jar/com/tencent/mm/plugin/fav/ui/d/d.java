package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends b
{
  public d(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107452);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, q.f.fav_listitem_comm_card, null), paramViewGroup, paramg);
      paramViewGroup.ttT = ((ImageView)paramView.findViewById(q.e.fav_icon));
      paramViewGroup.pJJ = ((TextView)paramView.findViewById(q.e.fav_title));
      paramViewGroup.plr = ((TextView)paramView.findViewById(q.e.fav_detail));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      arf localarf = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      if (!Util.isNullOrNil(str))
      {
        localObject = str;
        if (paramg.Acq)
        {
          localObject = str;
          if (localarf == null) {}
        }
      }
      else
      {
        localObject = localarf.title;
      }
      paramViewGroup.pJJ.setText((CharSequence)localObject);
      paramViewGroup.plr.setText(com.tencent.mm.plugin.fav.a.b.getLengthStr((float)localarf.Zza));
      if (localarf.ZzM == 2) {
        paramViewGroup.plr.setText(">" + ((ah)h.az(ah.class)).getFileSizeLimitInMB(true) + "MB");
      }
      b(paramViewGroup.pJJ, paramg);
      paramViewGroup.ttT.setImageResource(e.aut(localarf.ZyU));
      AppMethodBeat.o(107452);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107453);
    g localg = ((a)paramView.getTag()).AdF;
    paramView = paramView.getContext();
    ((z)h.ax(z.class)).a(paramView, localg, paramarx);
    AppMethodBeat.o(107453);
  }
  
  public static final class a
    extends b.b
  {
    TextView pJJ;
    TextView plr;
    ImageView ttT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.d
 * JD-Core Version:    0.7.0.1
 */