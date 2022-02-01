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
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b
  extends BaseAdapter
{
  ArrayList<String> Ees;
  SparseArray<SpannableString> Eet;
  private Context mContext;
  String mTX;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(26275);
    this.Ees = new ArrayList();
    this.Eet = new SparseArray();
    this.mContext = paramContext;
    AppMethodBeat.o(26275);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26276);
    if (this.Ees == null)
    {
      AppMethodBeat.o(26276);
      return 0;
    }
    int i = this.Ees.size();
    AppMethodBeat.o(26276);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(26277);
    if ((this.Ees == null) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(26277);
      return null;
    }
    String str = (String)this.Ees.get(paramInt);
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
      paramView = LayoutInflater.from(this.mContext).inflate(R.i.efu, paramViewGroup, false);
      paramViewGroup = new c(paramView);
      paramView.setTag(paramViewGroup);
      localMMTextView = paramViewGroup.Efc;
      str = Util.nullAs(getItem(paramInt), "");
      i = (int)paramViewGroup.Efc.getTextSize();
      paramInt = str.hashCode();
      paramViewGroup = (SpannableString)this.Eet.get(paramInt);
      if (paramViewGroup == null) {
        break label122;
      }
    }
    for (;;)
    {
      localMMTextView.setText(paramViewGroup);
      AppMethodBeat.o(26278);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label122:
      paramViewGroup = new SpannableString(l.d(this.mContext, str, i));
      i = str.indexOf(this.mTX);
      if (i == -1)
      {
        Log.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", new Object[] { str });
      }
      else
      {
        int j = this.mTX.length() + i;
        paramViewGroup.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.e.wechat_green)), i, j, 33);
        paramViewGroup.setSpan(new StyleSpan(1), i, j, 33);
        this.Eet.put(paramInt, paramViewGroup);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.b
 * JD-Core Version:    0.7.0.1
 */