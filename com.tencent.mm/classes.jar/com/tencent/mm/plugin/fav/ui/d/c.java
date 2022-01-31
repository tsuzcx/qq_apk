package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.bk;

public final class c
  extends a
{
  public c(l paraml)
  {
    super(paraml);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new c.a();
      paramView = a(View.inflate((Context)localObject, n.f.fav_listitem_comm_card, null), paramViewGroup, paramg);
      paramViewGroup.gSx = ((ImageView)paramView.findViewById(n.e.fav_icon));
      paramViewGroup.eXO = ((TextView)paramView.findViewById(n.e.fav_title));
      paramViewGroup.eXP = ((TextView)paramView.findViewById(n.e.fav_detail));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      xv localxv = b.c(paramg);
      localObject = paramg.field_favProto.title;
      paramg = (com.tencent.mm.plugin.fav.a.g)localObject;
      if (bk.bl((String)localObject)) {
        paramg = localxv.title;
      }
      paramViewGroup.eXO.setText(paramg);
      paramViewGroup.eXP.setText(b.ar((float)localxv.sVb));
      if (localxv.sVO == 2) {
        paramViewGroup.eXP.setText(">25MB");
      }
      paramViewGroup.gSx.setImageResource(com.tencent.mm.plugin.fav.ui.c.CT(localxv.sUV));
      return paramView;
      paramViewGroup = (c.a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, yl paramyl)
  {
    com.tencent.mm.plugin.fav.a.g localg = ((c.a)paramView.getTag()).jZN;
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.r(y.class)).a(paramView, localg, paramyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.c
 * JD-Core Version:    0.7.0.1
 */