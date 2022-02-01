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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public abstract class d
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context context;
  public String ppR;
  public List<String> rzJ = new LinkedList();
  public SparseArray<SpannableString> rzK = new SparseArray();
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private String getItem(int paramInt)
  {
    return (String)this.rzJ.get(paramInt);
  }
  
  protected abstract void acW(String paramString);
  
  public int getCount()
  {
    return this.rzJ.size();
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
    String str = bt.bI(getItem(paramInt), "");
    int i = (int)localTextView.getTextSize();
    paramInt = str.hashCode();
    paramView = (SpannableString)this.rzK.get(paramInt);
    if (paramView != null) {}
    for (;;)
    {
      localTextView.setText(paramView);
      return paramViewGroup;
      paramView = new SpannableString(k.b(this.context, str, i));
      i = str.indexOf(this.ppR);
      if (-1 == i)
      {
        ad.w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", new Object[] { str });
      }
      else
      {
        int j = this.ppR.length() + i;
        paramView.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131101171)), i, j, 33);
        paramView.setSpan(new StyleSpan(1), i, j, 33);
        this.rzK.put(paramInt, paramView);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/fav/ui/adapter/FavoriteTagSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = ((TextView)paramView.findViewById(2131304424)).getText().toString();
    ad.d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", new Object[] { paramView });
    acW(paramView);
    a.a(this, "com/tencent/mm/plugin/fav/ui/adapter/FavoriteTagSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.d
 * JD-Core Version:    0.7.0.1
 */