package com.tencent.mm.plugin.label.ui;

import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;
import java.util.HashMap;

final class ContactLabelManagerUI$a
  extends BaseAdapter
{
  ArrayList<af> mData;
  
  ContactLabelManagerUI$a(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(22599);
    if (this.mData == null)
    {
      AppMethodBeat.o(22599);
      return 0;
    }
    int i = this.mData.size();
    AppMethodBeat.o(22599);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22601);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.nYI).inflate(2130969258, paramViewGroup, false);
      paramViewGroup = new c(paramView);
      Object localObject = paramViewGroup.nZE.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = ((int)(a.ap(this.nYI, 2131427853) * a.gs(this.nYI)));
      paramViewGroup.nZE.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.setTag(paramViewGroup);
      localObject = xZ(paramInt);
      SpannableString localSpannableString = j.b(this.nYI.getContext(), ((af)localObject).field_labelName, ContactLabelManagerUI.l(this.nYI));
      paramViewGroup.nZC.setText(localSpannableString);
      if ((ContactLabelManagerUI.j(this.nYI) == null) || (!ContactLabelManagerUI.j(this.nYI).containsKey(Integer.valueOf(((af)localObject).field_labelID)))) {
        break label231;
      }
      paramViewGroup.nZD.setVisibility(0);
      paramViewGroup.nZD.setText("(" + ContactLabelManagerUI.j(this.nYI).get(Integer.valueOf(((af)localObject).field_labelID)) + ")");
    }
    for (;;)
    {
      AppMethodBeat.o(22601);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label231:
      paramViewGroup.nZD.setVisibility(0);
      paramViewGroup.nZD.setText("(0)");
    }
  }
  
  public final af xZ(int paramInt)
  {
    AppMethodBeat.i(22600);
    if ((this.mData == null) || (paramInt > this.mData.size()))
    {
      AppMethodBeat.o(22600);
      return null;
    }
    af localaf = (af)this.mData.get(paramInt);
    AppMethodBeat.o(22600);
    return localaf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.a
 * JD-Core Version:    0.7.0.1
 */