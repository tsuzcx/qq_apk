package com.tencent.mm.plugin.fav.ui.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.bk;

public final class e
  extends a
{
  public e(l paraml)
  {
    super(paraml);
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new e.a();
      paramView = a(View.inflate((Context)localObject, n.f.fav_listitem_comm_card, null), paramViewGroup, paramg);
      paramViewGroup.gSx = ((ImageView)paramView.findViewById(n.e.fav_icon));
      paramViewGroup.eXO = ((TextView)paramView.findViewById(n.e.fav_title));
      paramViewGroup.eXP = ((TextView)paramView.findViewById(n.e.fav_detail));
      a(paramViewGroup, paramg);
      paramViewGroup.gSx.setImageResource(n.h.app_attach_file_icon_location);
      localObject = paramg.field_favProto.sWf;
      paramg = paramg.field_favProto.fGK;
      if (!bk.bl(paramg)) {
        break label187;
      }
      if (!k.CZ(((yc)localObject).bVA)) {
        break label164;
      }
      paramViewGroup.eXO.setText(((yc)localObject).bVA);
    }
    label164:
    label187:
    do
    {
      paramViewGroup.eXP.setText(((yc)localObject).label);
      return paramView;
      paramViewGroup = (e.a)paramView.getTag();
      break;
      paramViewGroup.eXO.setText(((yc)localObject).label);
      paramViewGroup.eXP.setVisibility(8);
      return paramView;
      paramViewGroup.eXO.setText(j.a(paramViewGroup.eXO.getContext(), paramg, paramViewGroup.eXO.getTextSize()));
    } while (!k.CZ(((yc)localObject).bVA));
    paramViewGroup.eXP.setText(((yc)localObject).bVA);
    return paramView;
  }
  
  public final void a(View paramView, yl paramyl)
  {
    e.a locala = (e.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.r(y.class)).a(paramView, locala.jZN, paramyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.e
 * JD-Core Version:    0.7.0.1
 */