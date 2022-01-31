package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yl;

public final class q
  extends a
{
  public q(l paraml)
  {
    super(paraml);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Context localContext = paramViewGroup.getContext();
    int i;
    if (paramView == null)
    {
      paramViewGroup = new q.a();
      paramView = a(View.inflate(localContext, n.f.fav_listitem_voice, null), paramViewGroup, paramg);
      paramViewGroup.eXO = ((TextView)paramView.findViewById(n.e.fav_title));
      a(paramViewGroup, paramg);
      i = (int)b.ck(b.c(paramg).duration);
      paramg = paramViewGroup.eXO;
      paramViewGroup = this.kbg.context;
      if (i > 0) {
        break label123;
      }
    }
    label123:
    for (paramViewGroup = paramViewGroup.getString(n.i.favorite_voice_length, new Object[] { Integer.valueOf(0) });; paramViewGroup = paramViewGroup.getString(n.i.favorite_voice_length, new Object[] { Integer.valueOf(i) }))
    {
      paramg.setText(paramViewGroup);
      return paramView;
      paramViewGroup = (q.a)paramView.getTag();
      break;
    }
  }
  
  public final void a(View paramView, yl paramyl)
  {
    q.a locala = (q.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.r(y.class)).a(paramView, locala.jZN, paramyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.q
 * JD-Core Version:    0.7.0.1
 */