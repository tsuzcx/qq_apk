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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public abstract class d
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context context;
  public String oMj;
  public List<String> qPK = new LinkedList();
  public SparseArray<SpannableString> qPL = new SparseArray();
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private String getItem(int paramInt)
  {
    return (String)this.qPK.get(paramInt);
  }
  
  protected abstract void Zq(String paramString);
  
  public int getCount()
  {
    return this.qPK.size();
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
      paramViewGroup = View.inflate(this.context, 2131493982, null);
      paramViewGroup.setOnClickListener(this);
    }
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131304424);
    String str = bs.bG(getItem(paramInt), "");
    int i = (int)localTextView.getTextSize();
    paramInt = str.hashCode();
    paramView = (SpannableString)this.qPL.get(paramInt);
    if (paramView != null) {}
    for (;;)
    {
      localTextView.setText(paramView);
      return paramViewGroup;
      paramView = new SpannableString(k.b(this.context, str, i));
      i = str.indexOf(this.oMj);
      if (-1 == i)
      {
        ac.w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", new Object[] { str });
      }
      else
      {
        int j = this.oMj.length() + i;
        paramView.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131101171)), i, j, 33);
        paramView.setSpan(new StyleSpan(1), i, j, 33);
        this.qPL.put(paramInt, paramView);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = ((TextView)paramView.findViewById(2131304424)).getText().toString();
    ac.d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", new Object[] { paramView });
    Zq(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.d
 * JD-Core Version:    0.7.0.1
 */