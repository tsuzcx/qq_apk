package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.c;
import com.tencent.mm.plugin.fav.ui.n.d;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yl;
import java.util.HashSet;
import java.util.Set;

public final class g
  extends a
{
  private final int kiw;
  private Set<ImageView> kiy;
  private View.OnClickListener kiz = new g.1(this);
  
  public g(l paraml)
  {
    super(paraml);
    this.kiw = com.tencent.mm.cb.a.aa(paraml.context, n.c.FavIconSize);
    this.kiy = new HashSet();
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new g.a();
      paramView = a(View.inflate((Context)localObject, n.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.gSx = ((ImageView)paramView.findViewById(n.e.fav_icon));
      paramViewGroup.eXO = ((TextView)paramView.findViewById(n.e.fav_title));
      paramViewGroup.eXP = ((TextView)paramView.findViewById(n.e.fav_desc));
      paramViewGroup.kiB = ((ImageView)paramView.findViewById(n.e.fav_icon_mask));
      paramViewGroup.kiv = ((TextView)paramView.findViewById(n.e.fav_source));
      paramViewGroup.kiv.setVisibility(8);
      paramViewGroup.kiB.setOnClickListener(this.kiz);
      paramViewGroup.kiB.setVisibility(0);
      this.kiy.add(paramViewGroup.kiB);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = b.c(paramg);
      paramViewGroup.eXO.setText(((xv)localObject).title);
      paramViewGroup.eXP.setText(((xv)localObject).desc);
      paramViewGroup.eXP.setVisibility(0);
      this.kbg.a(paramViewGroup.gSx, (xv)localObject, paramg, n.h.app_attach_file_icon_music, this.kiw, this.kiw);
      paramViewGroup.kiB.setTag(paramg);
      if (!b.e((xv)localObject)) {
        break;
      }
      paramViewGroup.kiB.setImageResource(n.d.music_pauseicon);
      return paramView;
      paramViewGroup = (g.a)paramView.getTag();
    }
    paramViewGroup.kiB.setImageResource(n.d.music_playicon);
    return paramView;
  }
  
  public final void a(View paramView, yl paramyl)
  {
    g.a locala = (g.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.r(y.class)).a(paramView, locala.jZN, paramyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.g
 * JD-Core Version:    0.7.0.1
 */