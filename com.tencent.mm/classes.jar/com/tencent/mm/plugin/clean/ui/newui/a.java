package com.tencent.mm.plugin.clean.ui.newui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.HashSet;

public final class a
  extends BaseAdapter
{
  HashSet<Integer> hIR;
  CleanChattingUI iDU;
  
  public a(CleanChattingUI paramCleanChattingUI)
  {
    this.iDU = paramCleanChattingUI;
    this.hIR = new HashSet();
  }
  
  private static b po(int paramInt)
  {
    return (b)d.aDQ().get(paramInt);
  }
  
  public final void aEe()
  {
    this.hIR.clear();
    this.iDU.a(this.hIR);
  }
  
  public final int getCount()
  {
    ArrayList localArrayList = d.aDQ();
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    b localb;
    if (paramView == null)
    {
      paramView = this.iDU.getLayoutInflater().inflate(R.i.clean_chatting_item, paramViewGroup, false);
      paramViewGroup = new a.a(this);
      paramViewGroup.doU = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      paramViewGroup.eXO = ((TextView)paramView.findViewById(R.h.title_tv));
      paramViewGroup.eXP = ((TextView)paramView.findViewById(R.h.desc_tv));
      paramViewGroup.eXQ = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramViewGroup.hIU = ((RelativeLayout)paramView.findViewById(R.h.select_cb_click_layout));
      paramView.setTag(paramViewGroup);
      paramViewGroup.hIU.setOnClickListener(new a.1(this, paramInt));
      localb = po(paramInt);
      a.b.a(paramViewGroup.doU, localb.username);
      paramViewGroup.eXO.setText(bk.cm(localb.hFz));
      if (!s.fn(localb.username)) {
        break label233;
      }
      paramViewGroup.eXP.setText(j.a(this.iDU, r.getDisplayName(localb.username, localb.username), paramViewGroup.eXP.getTextSize()));
    }
    for (;;)
    {
      if (!this.hIR.contains(Integer.valueOf(paramInt))) {
        break label265;
      }
      paramViewGroup.eXQ.setChecked(true);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label233:
      paramViewGroup.eXP.setText(j.a(this.iDU, r.gV(localb.username), paramViewGroup.eXP.getTextSize()));
    }
    label265:
    paramViewGroup.eXQ.setChecked(false);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.a
 * JD-Core Version:    0.7.0.1
 */