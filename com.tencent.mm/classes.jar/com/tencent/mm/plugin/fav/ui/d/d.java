package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.c;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yl;

public final class d
  extends a
{
  private static int kiw;
  
  public d(l paraml)
  {
    super(paraml);
    kiw = com.tencent.mm.cb.a.aa(paraml.context, n.c.FavImageSize);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, n.f.fav_listitem_image, null), paramViewGroup, paramg);
      paramViewGroup.kix = ((ImageView)paramView.findViewById(n.e.fav_image));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = b.c(paramg);
      l.a(paramViewGroup.kix, n.h.fav_list_img_default, (xv)localObject, paramg, false, kiw, kiw);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, yl paramyl)
  {
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.r(y.class)).a(paramView, locala.jZN, paramyl);
  }
  
  public static final class a
    extends a.b
  {
    ImageView kix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.d
 * JD-Core Version:    0.7.0.1
 */