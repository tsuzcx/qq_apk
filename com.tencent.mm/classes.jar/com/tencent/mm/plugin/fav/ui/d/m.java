package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;

public final class m
  extends a
{
  public m(l paraml)
  {
    super(paraml);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    paramViewGroup = paramViewGroup.getContext();
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = a(View.inflate(paramViewGroup, n.f.fav_listitem_text, null), paramView, paramg);
      paramView.dsy = ((TextView)localView.findViewById(n.e.fav_text));
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      if ((paramg.field_favProto.desc != null) && (paramg.field_favProto.desc.length() > 0)) {
        break;
      }
      paramViewGroup.dsy.setText("");
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.dsy.setText(j.a(paramViewGroup.dsy.getContext(), paramg.field_favProto.desc, paramViewGroup.dsy.getTextSize()));
    return localView;
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
    TextView dsy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.m
 * JD-Core Version:    0.7.0.1
 */