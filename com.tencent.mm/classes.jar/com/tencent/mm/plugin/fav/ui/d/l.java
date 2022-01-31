package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.n.c;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMImageView;

public final class l
  extends a
{
  private final String kiS;
  private final int kiw;
  
  public l(com.tencent.mm.plugin.fav.ui.l paraml)
  {
    super(paraml);
    this.kiw = com.tencent.mm.cb.a.aa(paraml.context, n.c.FavIconSize);
    this.kiS = "";
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new l.a();
      paramView = a(View.inflate(localContext, n.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.kff = ((MMImageView)paramView.findViewById(n.e.fav_icon));
      paramViewGroup.eXO = ((TextView)paramView.findViewById(n.e.fav_title));
      paramViewGroup.eXP = ((TextView)paramView.findViewById(n.e.fav_desc));
      paramViewGroup.kiv = ((TextView)paramView.findViewById(n.e.fav_source));
      paramViewGroup.kiv.setVisibility(0);
      a(paramViewGroup, paramg);
      ys localys = paramg.field_favProto.sWl;
      if (localys == null) {
        break label214;
      }
      paramViewGroup.eXO.setText(bk.pm(localys.title));
      paramViewGroup.eXP.setText(bk.pm(localys.desc));
    }
    for (;;)
    {
      paramViewGroup.kiv.setText(bk.aM(b.getAppName(localContext, paramg.field_favProto.sXa.appId), this.kiS));
      this.kbg.a(paramViewGroup.kff, null, paramg, n.h.app_attach_file_icon_unknow, this.kiw, this.kiw);
      return paramView;
      paramViewGroup = (l.a)paramView.getTag();
      break;
      label214:
      paramViewGroup.eXO.setText("");
      paramViewGroup.eXP.setText("");
    }
  }
  
  public final void a(View paramView, yl paramyl)
  {
    l.a locala = (l.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.r(y.class)).a(paramView, locala.jZN, paramyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.l
 * JD-Core Version:    0.7.0.1
 */