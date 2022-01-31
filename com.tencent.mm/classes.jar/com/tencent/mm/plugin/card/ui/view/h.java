package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

public abstract class h
  implements ab
{
  protected MMActivity hxN;
  protected g ixX;
  
  public h(g paramg, MMActivity paramMMActivity)
  {
    this.ixX = paramg;
    this.hxN = paramMMActivity;
  }
  
  public abstract boolean aCV();
  
  public abstract boolean aCW();
  
  public void c(ViewGroup paramViewGroup, b paramb)
  {
    Object localObject1;
    Object localObject2;
    if (aCV())
    {
      localObject1 = (TextView)paramViewGroup.findViewById(a.d.code_text);
      localObject2 = this.ixX.code;
      if ((!paramb.azs()) && ((bk.bl((String)localObject2)) || (((String)localObject2).length() > 40))) {
        break label304;
      }
      ((TextView)localObject1).setText(m.yZ((String)localObject2));
      if (paramb.azn())
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setOnLongClickListener(new h.1(this, paramb));
        this.ixX.d(c.iyY);
      }
    }
    else if (aCW())
    {
      localObject1 = (RelativeLayout)paramViewGroup.findViewById(a.d.code_jump_layout);
      if ((paramb == null) || (paramb.azx() == null) || (paramb.azx().sIU == null) || (bk.bl(paramb.azx().sIU.title))) {
        break label326;
      }
      paramViewGroup.findViewById(a.d.code_divider_line).setVisibility(8);
      ((RelativeLayout)localObject1).setVisibility(0);
      localObject2 = paramb.azx().sIU;
      TextView localTextView = (TextView)paramViewGroup.findViewById(a.d.code_jump_title);
      localTextView.setText(((ra)localObject2).title);
      String str = paramb.azx().color;
      if (!bk.bl(str)) {
        localTextView.setTextColor(l.yR(str));
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(a.d.code_jump_second_title);
      localObject2 = ((ra)localObject2).ilr;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label313;
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setText((CharSequence)localObject2);
        paramViewGroup.setVisibility(0);
      }
    }
    for (;;)
    {
      ((RelativeLayout)localObject1).setOnClickListener(new h.2(this, paramb));
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      label304:
      ((TextView)localObject1).setVisibility(8);
      break;
      label313:
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(8);
      }
    }
    label326:
    ((RelativeLayout)localObject1).setVisibility(8);
  }
  
  public boolean g(b paramb)
  {
    return true;
  }
  
  public void k(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.h
 * JD-Core Version:    0.7.0.1
 */