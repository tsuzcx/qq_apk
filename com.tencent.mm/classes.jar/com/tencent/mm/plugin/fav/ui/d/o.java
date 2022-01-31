package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.c;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.pluginsdk.c;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;

public final class o
  extends a
{
  private final int kiw;
  
  public o(l paraml)
  {
    super(paraml);
    this.kiw = com.tencent.mm.cb.a.aa(paraml.context, n.c.FavIconSize);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    paramViewGroup = paramViewGroup.getContext();
    Object localObject1;
    xv localxv1;
    Object localObject2;
    TextView localTextView;
    if (paramView == null)
    {
      localObject1 = new o.a();
      paramViewGroup = a(View.inflate(paramViewGroup, n.f.fav_listitem_appmsg, null), (a.b)localObject1, paramg);
      ((o.a)localObject1).gSx = ((ImageView)paramViewGroup.findViewById(n.e.fav_icon));
      ((o.a)localObject1).eXO = ((TextView)paramViewGroup.findViewById(n.e.fav_title));
      ((o.a)localObject1).eXO.setMaxLines(2);
      a((a.b)localObject1, paramg);
      localxv1 = b.c(paramg);
      localObject2 = paramg.field_favProto.sWh;
      localTextView = ((o.a)localObject1).eXO;
      xv localxv2 = b.c(paramg);
      paramView = "";
      if (localObject2 != null) {
        paramView = ((yy)localObject2).title;
      }
      localObject2 = paramView;
      if (bk.bl(paramView))
      {
        localObject2 = paramView;
        if (localxv2 != null) {
          localObject2 = localxv2.title;
        }
      }
      if (!bk.bl((String)localObject2)) {
        break label236;
      }
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      int j = c.Vy(localxv1.sUV);
      paramView = this.kbg;
      localObject1 = ((o.a)localObject1).gSx;
      int i = j;
      if (j == c.ckk()) {
        i = n.h.app_attach_file_icon_webpage;
      }
      paramView.a((ImageView)localObject1, localxv1, paramg, i, this.kiw, this.kiw);
      return paramViewGroup;
      localObject1 = (o.a)paramView.getTag();
      paramViewGroup = paramView;
      break;
      label236:
      localTextView.setText((CharSequence)localObject2);
      localTextView.setVisibility(0);
    }
  }
  
  public final void a(View paramView, yl paramyl)
  {
    o.a locala = (o.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.r(y.class)).a(paramView, locala.jZN, paramyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.o
 * JD-Core Version:    0.7.0.1
 */