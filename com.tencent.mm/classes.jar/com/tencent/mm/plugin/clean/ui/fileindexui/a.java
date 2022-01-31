package com.tencent.mm.plugin.clean.ui.fileindexui;

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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashSet;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private List<c> dataList;
  HashSet<Integer> hIR;
  CleanChattingUI iCy;
  
  public a(CleanChattingUI paramCleanChattingUI, List<c> paramList)
  {
    this.iCy = paramCleanChattingUI;
    this.hIR = new HashSet();
    this.dataList = paramList;
  }
  
  public final void aEe()
  {
    this.hIR.clear();
    this.iCy.a(this.hIR);
  }
  
  public final int getCount()
  {
    return this.dataList.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    c localc;
    if (paramView == null)
    {
      paramView = this.iCy.getLayoutInflater().inflate(R.i.clean_chatting_item, paramViewGroup, false);
      paramViewGroup = new a.a(this);
      paramViewGroup.doU = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      paramViewGroup.eXO = ((TextView)paramView.findViewById(R.h.title_tv));
      paramViewGroup.eXP = ((TextView)paramView.findViewById(R.h.desc_tv));
      paramViewGroup.eXQ = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramViewGroup.hIU = ((RelativeLayout)paramView.findViewById(R.h.select_cb_click_layout));
      paramView.setTag(paramViewGroup);
      paramViewGroup.hIU.setOnClickListener(new a.1(this, paramInt));
      localc = pk(paramInt);
      a.b.a(paramViewGroup.doU, localc.username);
      paramViewGroup.eXO.setText(bk.cm(localc.size));
      if (!s.fn(localc.username)) {
        break label234;
      }
      paramViewGroup.eXP.setText(j.a(this.iCy, r.getDisplayName(localc.username, localc.username), paramViewGroup.eXP.getTextSize()));
    }
    for (;;)
    {
      if (!this.hIR.contains(Integer.valueOf(paramInt))) {
        break label266;
      }
      paramViewGroup.eXQ.setChecked(true);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label234:
      paramViewGroup.eXP.setText(j.a(this.iCy, r.gV(localc.username), paramViewGroup.eXP.getTextSize()));
    }
    label266:
    paramViewGroup.eXQ.setChecked(false);
    return paramView;
  }
  
  public final c pk(int paramInt)
  {
    return (c)this.dataList.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.a
 * JD-Core Version:    0.7.0.1
 */