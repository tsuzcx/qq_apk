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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b
  extends BaseAdapter
{
  String kcy;
  private Context mContext;
  ArrayList<String> yCY;
  SparseArray<SpannableString> yCZ;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(26275);
    this.yCY = new ArrayList();
    this.yCZ = new SparseArray();
    this.mContext = paramContext;
    AppMethodBeat.o(26275);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26276);
    if (this.yCY == null)
    {
      AppMethodBeat.o(26276);
      return 0;
    }
    int i = this.yCY.size();
    AppMethodBeat.o(26276);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(26277);
    if ((this.yCY == null) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(26277);
      return null;
    }
    String str = (String)this.yCY.get(paramInt);
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
      paramView = LayoutInflater.from(this.mContext).inflate(2131493776, paramViewGroup, false);
      paramViewGroup = new c(paramView);
      paramView.setTag(paramViewGroup);
      localMMTextView = paramViewGroup.yDz;
      str = Util.nullAs(getItem(paramInt), "");
      i = (int)paramViewGroup.yDz.getTextSize();
      paramInt = str.hashCode();
      paramViewGroup = (SpannableString)this.yCZ.get(paramInt);
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
      paramViewGroup = new SpannableString(l.e(this.mContext, str, i));
      i = str.indexOf(this.kcy);
      if (i == -1)
      {
        Log.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", new Object[] { str });
      }
      else
      {
        int j = this.kcy.length() + i;
        paramViewGroup.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(2131101414)), i, j, 33);
        paramViewGroup.setSpan(new StyleSpan(1), i, j, 33);
        this.yCZ.put(paramInt, paramViewGroup);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.b
 * JD-Core Version:    0.7.0.1
 */