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
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b
  extends BaseAdapter
{
  String fdC;
  ArrayList<String> lBP = new ArrayList();
  SparseArray<SpannableString> lBQ = new SparseArray();
  private Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int getCount()
  {
    if (this.lBP == null) {
      return 0;
    }
    return this.lBP.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MMTextView localMMTextView;
    String str;
    int i;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(R.i.contact_label_list_item, paramViewGroup, false);
      paramViewGroup = new c(paramView);
      paramView.setTag(paramViewGroup);
      localMMTextView = paramViewGroup.lCq;
      str = bk.aM(ke(paramInt), "");
      i = (int)paramViewGroup.lCq.getTextSize();
      paramInt = str.hashCode();
      paramViewGroup = (SpannableString)this.lBQ.get(paramInt);
      if (paramViewGroup == null) {
        break label110;
      }
    }
    for (;;)
    {
      localMMTextView.setText(paramViewGroup);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label110:
      paramViewGroup = new SpannableString(j.b(this.mContext, str, i));
      i = str.indexOf(this.fdC);
      if (i == -1)
      {
        y.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", new Object[] { str });
      }
      else
      {
        int j = this.fdC.length() + i;
        paramViewGroup.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.e.wechat_green)), i, j, 33);
        paramViewGroup.setSpan(new StyleSpan(1), i, j, 33);
        this.lBQ.put(paramInt, paramViewGroup);
      }
    }
  }
  
  public final String ke(int paramInt)
  {
    if ((this.lBP == null) || (paramInt >= getCount())) {
      return null;
    }
    return (String)this.lBP.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.b
 * JD-Core Version:    0.7.0.1
 */