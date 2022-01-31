package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b
  extends BaseAdapter
{
  String gvn;
  private Context mContext;
  ArrayList<String> nZb;
  SparseArray<SpannableString> nZc;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(22653);
    this.nZb = new ArrayList();
    this.nZc = new SparseArray();
    this.mContext = paramContext;
    AppMethodBeat.o(22653);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22654);
    if (this.nZb == null)
    {
      AppMethodBeat.o(22654);
      return 0;
    }
    int i = this.nZb.size();
    AppMethodBeat.o(22654);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(22655);
    if ((this.nZb == null) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(22655);
      return null;
    }
    String str = (String)this.nZb.get(paramInt);
    AppMethodBeat.o(22655);
    return str;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22656);
    MMTextView localMMTextView;
    String str;
    int i;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2130969258, paramViewGroup, false);
      paramViewGroup = new c(paramView);
      paramView.setTag(paramViewGroup);
      localMMTextView = paramViewGroup.nZC;
      str = bo.bf(getItem(paramInt), "");
      i = (int)paramViewGroup.nZC.getTextSize();
      paramInt = str.hashCode();
      paramViewGroup = (SpannableString)this.nZc.get(paramInt);
      if (paramViewGroup == null) {
        break label121;
      }
    }
    for (;;)
    {
      localMMTextView.setText(paramViewGroup);
      AppMethodBeat.o(22656);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label121:
      paramViewGroup = new SpannableString(j.b(this.mContext, str, i));
      i = str.indexOf(this.gvn);
      if (i == -1)
      {
        ab.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", new Object[] { str });
      }
      else
      {
        int j = this.gvn.length() + i;
        paramViewGroup.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(2131690701)), i, j, 33);
        paramViewGroup.setSpan(new StyleSpan(1), i, j, 33);
        this.nZc.put(paramInt, paramViewGroup);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.b
 * JD-Core Version:    0.7.0.1
 */