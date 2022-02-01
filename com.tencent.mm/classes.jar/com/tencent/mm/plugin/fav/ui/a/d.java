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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public abstract class d
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context context;
  public String qLO;
  public List<String> thB = new LinkedList();
  public SparseArray<SpannableString> thC = new SparseArray();
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private String getItem(int paramInt)
  {
    return (String)this.thB.get(paramInt);
  }
  
  protected abstract void anW(String paramString);
  
  public int getCount()
  {
    return this.thB.size();
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
      paramViewGroup = View.inflate(this.context, 2131494152, null);
      paramViewGroup.setOnClickListener(this);
    }
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131307395);
    String str = Util.nullAs(getItem(paramInt), "");
    int i = (int)localTextView.getTextSize();
    paramInt = str.hashCode();
    paramView = (SpannableString)this.thC.get(paramInt);
    if (paramView != null) {}
    for (;;)
    {
      localTextView.setText(paramView);
      return paramViewGroup;
      paramView = new SpannableString(l.e(this.context, str, i));
      i = str.indexOf(this.qLO);
      if (-1 == i)
      {
        Log.w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", new Object[] { str });
      }
      else
      {
        int j = this.qLO.length() + i;
        paramView.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131101414)), i, j, 33);
        paramView.setSpan(new StyleSpan(1), i, j, 33);
        this.thC.put(paramInt, paramView);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/fav/ui/adapter/FavoriteTagSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = ((TextView)paramView.findViewById(2131307395)).getText().toString();
    Log.d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", new Object[] { paramView });
    anW(paramView);
    a.a(this, "com/tencent/mm/plugin/fav/ui/adapter/FavoriteTagSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.d
 * JD-Core Version:    0.7.0.1
 */