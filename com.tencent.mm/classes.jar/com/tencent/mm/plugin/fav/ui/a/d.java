package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public abstract class d
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context context;
  public String lbI;
  public List<String> mzF = new LinkedList();
  public SparseArray<SpannableString> mzG = new SparseArray();
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private String getItem(int paramInt)
  {
    return (String)this.mzF.get(paramInt);
  }
  
  protected abstract void LV(String paramString);
  
  public int getCount()
  {
    return this.mzF.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.context, 2130969564, null);
      paramViewGroup.setOnClickListener(this);
    }
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131824096);
    String str = bo.bf(getItem(paramInt), "");
    int i = (int)localTextView.getTextSize();
    paramInt = str.hashCode();
    paramView = (SpannableString)this.mzG.get(paramInt);
    if (paramView != null) {}
    for (;;)
    {
      localTextView.setText(paramView);
      return paramViewGroup;
      paramView = new SpannableString(j.b(this.context, str, i));
      i = str.indexOf(this.lbI);
      if (-1 == i)
      {
        ab.w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", new Object[] { str });
      }
      else
      {
        int j = this.lbI.length() + i;
        paramView.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131690701)), i, j, 33);
        paramView.setSpan(new StyleSpan(1), i, j, 33);
        this.mzG.put(paramInt, paramView);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = ((TextView)paramView.findViewById(2131824096)).getText().toString();
    ab.d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", new Object[] { paramView });
    LV(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.d
 * JD-Core Version:    0.7.0.1
 */