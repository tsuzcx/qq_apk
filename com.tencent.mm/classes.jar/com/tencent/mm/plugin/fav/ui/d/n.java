package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.yl;

public final class n
  extends a
{
  public n(l paraml)
  {
    super(paraml);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    return new View(paramViewGroup.getContext());
  }
  
  public final void a(View paramView, yl paramyl)
  {
    if (paramView != null) {
      Toast.makeText(paramView.getContext(), n.i.favorite_unknown_type, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.n
 * JD-Core Version:    0.7.0.1
 */