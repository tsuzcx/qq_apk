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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b
  extends BaseAdapter
{
  String iIt;
  private Context mContext;
  ArrayList<String> tUF;
  SparseArray<SpannableString> tUG;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(26275);
    this.tUF = new ArrayList();
    this.tUG = new SparseArray();
    this.mContext = paramContext;
    AppMethodBeat.o(26275);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26276);
    if (this.tUF == null)
    {
      AppMethodBeat.o(26276);
      return 0;
    }
    int i = this.tUF.size();
    AppMethodBeat.o(26276);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(26277);
    if ((this.tUF == null) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(26277);
      return null;
    }
    String str = (String)this.tUF.get(paramInt);
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
      localMMTextView = paramViewGroup.tVg;
      str = bs.bG(getItem(paramInt), "");
      i = (int)paramViewGroup.tVg.getTextSize();
      paramInt = str.hashCode();
      paramViewGroup = (SpannableString)this.tUG.get(paramInt);
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
      i = str.indexOf(this.iIt);
      if (i == -1)
      {
        ac.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", new Object[] { str });
      }
      else
      {
        int j = this.iIt.length() + i;
        paramViewGroup.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(2131101171)), i, j, 33);
        paramViewGroup.setSpan(new StyleSpan(1), i, j, 33);
        this.tUG.put(paramInt, paramViewGroup);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.b
 * JD-Core Version:    0.7.0.1
 */