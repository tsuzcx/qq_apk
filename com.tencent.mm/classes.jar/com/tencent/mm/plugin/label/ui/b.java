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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b
  extends BaseAdapter
{
  String iil;
  private Context mContext;
  ArrayList<String> sNa;
  SparseArray<SpannableString> sNb;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(26275);
    this.sNa = new ArrayList();
    this.sNb = new SparseArray();
    this.mContext = paramContext;
    AppMethodBeat.o(26275);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26276);
    if (this.sNa == null)
    {
      AppMethodBeat.o(26276);
      return 0;
    }
    int i = this.sNa.size();
    AppMethodBeat.o(26276);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(26277);
    if ((this.sNa == null) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(26277);
      return null;
    }
    String str = (String)this.sNa.get(paramInt);
    AppMethodBeat.o(26277);
    return str;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(26278);
    MMTextView localMMTextView;
    String str;
    int i;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131493646, paramViewGroup, false);
      paramViewGroup = new c(paramView);
      paramView.setTag(paramViewGroup);
      localMMTextView = paramViewGroup.sNB;
      str = bt.by(getItem(paramInt), "");
      i = (int)paramViewGroup.sNB.getTextSize();
      paramInt = str.hashCode();
      paramViewGroup = (SpannableString)this.sNb.get(paramInt);
      if (paramViewGroup == null) {
        break label121;
      }
    }
    for (;;)
    {
      localMMTextView.setText(paramViewGroup);
      AppMethodBeat.o(26278);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label121:
      paramViewGroup = new SpannableString(k.b(this.mContext, str, i));
      i = str.indexOf(this.iil);
      if (i == -1)
      {
        ad.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", new Object[] { str });
      }
      else
      {
        int j = this.iil.length() + i;
        paramViewGroup.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(2131101171)), i, j, 33);
        paramViewGroup.setSpan(new StyleSpan(1), i, j, 33);
        this.sNb.put(paramInt, paramViewGroup);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.b
 * JD-Core Version:    0.7.0.1
 */