package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.c;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import java.util.LinkedList;

public final class p
  extends a
{
  final int kiw;
  
  public p(l paraml)
  {
    super(paraml);
    this.kiw = com.tencent.mm.cb.a.aa(paraml.context, n.c.FavImageSize);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new p.a();
      paramView = a(View.inflate((Context)localObject, n.f.fav_listitem_shortview, null), paramViewGroup, paramg);
      paramViewGroup.kix = ((ImageView)paramView.findViewById(n.e.fav_image));
      paramViewGroup.kjc = ((TextView)paramView.findViewById(n.e.fav_video_duration));
      paramViewGroup.kjc.setVisibility(0);
      LinkedList localLinkedList = paramg.field_favProto.sXc;
      if ((localLinkedList.size() <= 0) || (((xv)localLinkedList.getFirst()).duration <= 0)) {
        break label174;
      }
      paramViewGroup.kjc.setText(j.x((Context)localObject, ((xv)localLinkedList.getFirst()).duration));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = b.c(paramg);
      this.kbg.a(paramViewGroup.kix, (xv)localObject, paramg, n.h.app_attach_file_icon_video, this.kiw, this.kiw);
      return paramView;
      paramViewGroup = (p.a)paramView.getTag();
      break;
      label174:
      paramViewGroup.kjc.setText("");
    }
  }
  
  public final void a(View paramView, yl paramyl)
  {
    p.a locala = (p.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.r(y.class)).a(paramView, locala.jZN, paramyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.p
 * JD-Core Version:    0.7.0.1
 */