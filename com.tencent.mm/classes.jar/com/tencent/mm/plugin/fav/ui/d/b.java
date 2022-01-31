package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.d;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.a;

public final class b
  extends a
{
  public b(l paraml)
  {
    super(paraml);
  }
  
  private static String a(bi.a parama)
  {
    int j = 1;
    int i = 0;
    String str = parama.cMT;
    if (bk.bl(str))
    {
      str = parama.pyp;
      if ((!ad.aaX(str)) && (!s.hj(str))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i == 0) && (!((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abg(str))) {
        i = j;
      }
      for (;;)
      {
        boolean bool = s.hI(parama.qZn);
        if ((i != 0) || (bool)) {
          return "";
        }
        return str;
      }
    }
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new b.a();
      paramView = a(View.inflate(localContext, n.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.gSx = ((ImageView)paramView.findViewById(n.e.fav_icon));
      paramViewGroup.eXO = ((TextView)paramView.findViewById(n.e.fav_title));
      paramViewGroup.eXO.setSingleLine(false);
      paramViewGroup.eXO.setMaxLines(2);
      paramViewGroup.eXP = ((TextView)paramView.findViewById(n.e.fav_desc));
      paramViewGroup.kiv = ((TextView)paramView.findViewById(n.e.fav_source));
      a(paramViewGroup, paramg);
      paramg = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramg = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HN(paramg.desc);
      if ((paramg.pyp == null) || (paramg.pyp.length() <= 0)) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
      }
      if (!bk.bl(a(paramg))) {
        break label238;
      }
      paramViewGroup.eXP.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.kiv.setText(n.i.favorite_friend_card);
      paramViewGroup.kiv.setVisibility(0);
      paramViewGroup = paramViewGroup.gSx;
      paramg = paramg.pyp;
      if (!bk.bl(paramg)) {
        break label252;
      }
      paramViewGroup.setImageResource(n.d.default_avatar);
      return paramView;
      paramViewGroup = (b.a)paramView.getTag();
      break;
      label238:
      paramViewGroup.eXP.setText(a(paramg));
    }
    label252:
    a.b.a(paramViewGroup, paramg);
    return paramView;
  }
  
  public final void a(View paramView, yl paramyl)
  {
    b.a locala = (b.a)paramView.getTag();
    paramView = paramView.getContext();
    ((com.tencent.mm.plugin.fav.a.y)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.fav.a.y.class)).a(paramView, locala.jZN, paramyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.b
 * JD-Core Version:    0.7.0.1
 */