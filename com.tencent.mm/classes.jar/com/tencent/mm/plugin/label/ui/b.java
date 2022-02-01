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
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b
  extends BaseAdapter
{
  ArrayList<String> JWd;
  SparseArray<SpannableString> JWe;
  private Context mContext;
  String pQF;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(26275);
    this.JWd = new ArrayList();
    this.JWe = new SparseArray();
    this.mContext = paramContext;
    AppMethodBeat.o(26275);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26276);
    if (this.JWd == null)
    {
      AppMethodBeat.o(26276);
      return 0;
    }
    int i = this.JWd.size();
    AppMethodBeat.o(26276);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(26277);
    if ((this.JWd == null) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(26277);
      return null;
    }
    String str = (String)this.JWd.get(paramInt);
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
      paramView = LayoutInflater.from(this.mContext).inflate(R.i.gip, paramViewGroup, false);
      paramViewGroup = new e(paramView);
      paramView.setTag(paramViewGroup);
      localMMTextView = paramViewGroup.JXj;
      str = Util.nullAs(getItem(paramInt), "");
      i = (int)paramViewGroup.JXj.getTextSize();
      paramInt = str.hashCode();
      paramViewGroup = (SpannableString)this.JWe.get(paramInt);
      if (paramViewGroup == null) {
        break label122;
      }
    }
    for (;;)
    {
      localMMTextView.setText(paramViewGroup);
      AppMethodBeat.o(26278);
      return paramView;
      paramViewGroup = (e)paramView.getTag();
      break;
      label122:
      paramViewGroup = new SpannableString(p.d(this.mContext, str, i));
      i = str.indexOf(this.pQF);
      if (i == -1)
      {
        Log.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", new Object[] { str });
      }
      else
      {
        int j = this.pQF.length() + i;
        paramViewGroup.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.e.wechat_green)), i, j, 33);
        paramViewGroup.setSpan(new StyleSpan(1), i, j, 33);
        this.JWe.put(paramInt, paramViewGroup);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.b
 * JD-Core Version:    0.7.0.1
 */