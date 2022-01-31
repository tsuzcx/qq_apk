package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.o;

public final class p
{
  public static o a(Context paramContext, View paramView, String[] paramArrayOfString, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    View localView = View.inflate(paramContext, q.g.popup_menu, null);
    HorizontalListView localHorizontalListView = (HorizontalListView)localView.findViewById(q.f.suggest_alias_lv);
    paramArrayOfString = new a(paramContext, paramArrayOfString);
    localHorizontalListView.setAdapter(paramArrayOfString);
    localHorizontalListView.setOnItemClickListener(paramOnItemClickListener);
    localHorizontalListView.setBackgroundResource(q.e.signup_chose_bg);
    paramOnItemClickListener = new o(localView);
    paramOnItemClickListener.setHeight(com.tencent.mm.cb.a.fromDPToPix(paramContext, 120));
    int i = 0;
    int j = 0;
    while (i < paramArrayOfString.getCount())
    {
      localView = paramArrayOfString.getView(i, null, localHorizontalListView);
      localView.measure(0, 0);
      j += localView.getMeasuredWidth();
      i += 1;
    }
    paramOnItemClickListener.setWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 20) + j);
    paramOnItemClickListener.showAsDropDown(paramView, (paramView.getWidth() - (com.tencent.mm.cb.a.fromDPToPix(paramContext, 20) + j)) / 2, 0);
    return paramOnItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.p
 * JD-Core Version:    0.7.0.1
 */