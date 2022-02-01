package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.q.d;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc.a;

public final class c
  extends b
{
  public c(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
  }
  
  private static String a(cc.a parama)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(107451);
    String str = parama.kDc;
    if (Util.isNullOrNil(str))
    {
      str = parama.hgk;
      if ((!au.bxb(str)) && (!au.bxa(str))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i == 0) && (!((n)h.ax(n.class)).bzA().bxr(str))) {
        i = j;
      }
      for (;;)
      {
        boolean bool = ab.uY(parama.WAW);
        if ((i != 0) || (bool))
        {
          AppMethodBeat.o(107451);
          return "";
        }
        AppMethodBeat.o(107451);
        return str;
      }
    }
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107449);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, q.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.ttT = ((ImageView)paramView.findViewById(q.e.fav_icon));
      paramViewGroup.pJJ = ((TextView)paramView.findViewById(q.e.fav_title));
      paramViewGroup.pJJ.setSingleLine(false);
      paramViewGroup.pJJ.setMaxLines(2);
      paramViewGroup.plr = ((TextView)paramView.findViewById(q.e.fav_desc));
      paramViewGroup.Aoo = ((TextView)paramView.findViewById(q.e.fav_source));
      a(paramViewGroup, paramg);
      paramg = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramg = ((n)h.ax(n.class)).gaZ().aLU(paramg.desc);
      if ((paramg.hgk == null) || (paramg.hgk.length() <= 0)) {
        Log.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
      }
      if (!Util.isNullOrNil(a(paramg))) {
        break label248;
      }
      paramViewGroup.plr.setVisibility(8);
      label188:
      paramViewGroup.Aoo.setText(q.i.favorite_friend_card);
      paramViewGroup.Aoo.setVisibility(0);
      paramViewGroup = paramViewGroup.ttT;
      paramg = paramg.hgk;
      if (!Util.isNullOrNil(paramg)) {
        break label262;
      }
      paramViewGroup.setImageResource(q.d.default_avatar);
    }
    for (;;)
    {
      AppMethodBeat.o(107449);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label248:
      paramViewGroup.plr.setText(a(paramg));
      break label188;
      label262:
      a.b.g(paramViewGroup, paramg);
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107450);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(107450);
  }
  
  public static final class a
    extends b.b
  {
    TextView Aoo;
    TextView pJJ;
    TextView plr;
    ImageView ttT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.c
 * JD-Core Version:    0.7.0.1
 */