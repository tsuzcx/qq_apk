package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.protocal.c.bna;
import java.util.LinkedList;

final class c$b
  extends BaseAdapter
{
  private LinkedList<bna> fYa;
  
  c$b(LinkedList<bna> paramLinkedList)
  {
    this.fYa = paramLinkedList;
  }
  
  private bna kN(int paramInt)
  {
    return (bna)this.fYa.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.fYa == null) {
      return 0;
    }
    return this.fYa.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.fYa == null) || (this.fYa.size() <= 0)) {
      return null;
    }
    bna localbna = kN(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new c.b.a((byte)0);
      localObject = View.inflate(paramViewGroup.getContext(), y.h.authorize_scope_item, null);
      paramView.fYe = ((ImageView)((View)localObject).findViewById(y.g.app_auth_state));
      paramView.fYf = ((TextView)((View)localObject).findViewById(y.g.app_auth_desc));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      if (localbna.tGf != 1) {
        break label162;
      }
      paramViewGroup.fYe.setImageResource(y.i.login_auth_state_not_selected);
    }
    for (;;)
    {
      paramViewGroup.fYf.setText(localbna.kRN);
      localObject = paramViewGroup.fYe;
      paramViewGroup.fYe.setOnClickListener(new c.b.1(this, localbna, (ImageView)localObject));
      return paramView;
      paramViewGroup = (c.b.a)paramView.getTag();
      break;
      label162:
      if (localbna.tGf == 3) {
        paramViewGroup.fYe.setImageResource(y.i.login_auth_state_must_select);
      } else {
        paramViewGroup.fYe.setImageResource(y.i.login_auth_state_default_select);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.c.b
 * JD-Core Version:    0.7.0.1
 */