package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.c;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.bk;

public final class f
  extends a
{
  private final int kiw;
  
  public f(l paraml)
  {
    super(paraml);
    this.kiw = com.tencent.mm.cb.a.aa(paraml.context, n.c.FavIconSize);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new f.a();
      paramView = a(View.inflate((Context)localObject, n.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.gSx = ((ImageView)paramView.findViewById(n.e.fav_icon));
      paramViewGroup.eXO = ((TextView)paramView.findViewById(n.e.fav_title));
      paramViewGroup.eXP = ((TextView)paramView.findViewById(n.e.fav_desc));
      paramViewGroup.kiv = ((TextView)paramView.findViewById(n.e.fav_source));
      paramViewGroup.kiv.setVisibility(8);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = paramg.field_favProto.sWj;
      paramViewGroup.eXO.setText(bk.pm(((yi)localObject).title));
      paramViewGroup.eXP.setText(bk.pm(((yi)localObject).desc));
      paramViewGroup.eXO.setSingleLine(false);
      paramViewGroup.eXO.setMaxLines(2);
      this.kbg.a(paramViewGroup.gSx, null, paramg, n.h.app_attach_file_icon_unknow, this.kiw, this.kiw);
      return paramView;
      paramViewGroup = (f.a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, yl paramyl)
  {
    f.a locala = (f.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.r(y.class)).a(paramView, locala.jZN, paramyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.f
 * JD-Core Version:    0.7.0.1
 */