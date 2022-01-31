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
import com.tencent.mm.plugin.fav.ui.n.b;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public abstract class d
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context context;
  public String iSX;
  public List<String> keW = new LinkedList();
  public SparseArray<SpannableString> keX = new SparseArray();
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private String ke(int paramInt)
  {
    return (String)this.keW.get(paramInt);
  }
  
  public abstract void BS(String paramString);
  
  public int getCount()
  {
    return this.keW.size();
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
      paramViewGroup = View.inflate(this.context, n.f.fav_tag_search_item, null);
      paramViewGroup.setOnClickListener(this);
    }
    TextView localTextView = (TextView)paramViewGroup.findViewById(n.e.search_info);
    String str = bk.aM(ke(paramInt), "");
    int i = (int)localTextView.getTextSize();
    paramInt = str.hashCode();
    paramView = (SpannableString)this.keX.get(paramInt);
    if (paramView != null) {}
    for (;;)
    {
      localTextView.setText(paramView);
      return paramViewGroup;
      paramView = new SpannableString(j.b(this.context, str, i));
      i = str.indexOf(this.iSX);
      if (-1 == i)
      {
        y.w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", new Object[] { str });
      }
      else
      {
        int j = this.iSX.length() + i;
        paramView.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(n.b.wechat_green)), i, j, 33);
        paramView.setSpan(new StyleSpan(1), i, j, 33);
        this.keX.put(paramInt, paramView);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = ((TextView)paramView.findViewById(n.e.search_info)).getText().toString();
    y.d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", new Object[] { paramView });
    BS(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.d
 * JD-Core Version:    0.7.0.1
 */