package com.tencent.mm.plugin.account.ui;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

final class RegByMobileWaitingSMSUI$a
  extends ArrayAdapter<String>
{
  private final LayoutInflater fhz;
  private final ArrayList<String> frH;
  
  private String ke(int paramInt)
  {
    return (String)this.frH.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.frH.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (((Integer)RegByMobileWaitingSMSUI.h(this.frF).get(paramInt % RegByMobileWaitingSMSUI.h(this.frF).size())).intValue() % 4 == 0) {
      return 1;
    }
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    label103:
    int j;
    if (paramView == null)
    {
      paramViewGroup = new RegByMobileWaitingSMSUI.b(this.frF, (byte)0);
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("UNIMPLEMENT TYPE");
      case 0: 
        paramView = this.fhz.inflate(q.g.animation_chatting_item, null);
        paramViewGroup.frI = ((TextView)paramView.findViewById(q.f.chatting_content_itv));
        paramViewGroup.ffK = ((ImageView)paramView.findViewById(q.f.chatting_avatar_iv));
        paramView.setTag(paramViewGroup);
        j = ((Integer)RegByMobileWaitingSMSUI.h(this.frF).get(paramInt % RegByMobileWaitingSMSUI.h(this.frF).size())).intValue();
        switch (i)
        {
        }
        break;
      }
    }
    for (;;)
    {
      paramViewGroup.frI.setText(ke(paramInt));
      return paramView;
      paramView = this.fhz.inflate(q.g.animation_chatting_item_to, null);
      break;
      paramViewGroup = (RegByMobileWaitingSMSUI.b)paramView.getTag();
      break label103;
      paramViewGroup.ffK.setImageDrawable((Drawable)RegByMobileWaitingSMSUI.i(this.frF).get(j % RegByMobileWaitingSMSUI.i(this.frF).size()));
      continue;
      paramViewGroup.ffK.setImageDrawable(RegByMobileWaitingSMSUI.j(this.frF));
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final void qh(String paramString)
  {
    this.frH.add(paramString);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI.a
 * JD-Core Version:    0.7.0.1
 */