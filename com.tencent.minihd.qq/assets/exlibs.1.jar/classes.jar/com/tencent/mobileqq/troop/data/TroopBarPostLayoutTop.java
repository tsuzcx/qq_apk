package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity.Recommend;
import java.util.ArrayList;
import java.util.Iterator;
import kjp;

public class TroopBarPostLayoutTop
  extends TroopBarPostAbsLayout
  implements View.OnClickListener
{
  protected static final int a = 2130903688;
  protected View a;
  protected ArrayList a = null;
  protected int b = 0;
  protected int c = 0;
  
  public View a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3)
  {
    paramActivity = new View(paramActivity);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, paramInt1);
    localLayoutParams.leftMargin = paramInt3;
    paramActivity.setLayoutParams(localLayoutParams);
    paramActivity.setBackgroundColor(paramInt2);
    return paramActivity;
  }
  
  public View a(Activity paramActivity, LayoutInflater paramLayoutInflater, View paramView, TroopBarAbsDataEntity paramTroopBarAbsDataEntity)
  {
    if (paramView == null)
    {
      paramView = paramLayoutInflater.inflate(2130903688, null);
      paramLayoutInflater = (kjp)a(paramView);
      paramView.setTag(paramLayoutInflater);
    }
    for (;;)
    {
      this.a = ((TroopBarPageEntity)paramTroopBarAbsDataEntity).getRecommendArray();
      if ((this.a == null) || (this.a.size() <= 0)) {
        break;
      }
      paramLayoutInflater.b.setVisibility(0);
      float f = paramActivity.getResources().getDisplayMetrics().density;
      a(paramLayoutInflater.a, paramActivity, f);
      return paramView;
      paramLayoutInflater = (kjp)paramView.getTag();
    }
    paramLayoutInflater.b.setVisibility(8);
    return paramView;
  }
  
  protected TextView a(TroopBarPageEntity.Recommend paramRecommend, Activity paramActivity, Drawable paramDrawable, float paramFloat)
  {
    if (paramRecommend == null) {
      return null;
    }
    TextView localTextView = new TextView(paramActivity);
    localTextView.setId(2131296418);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setPadding((int)(15.0F * paramFloat), (int)(9.0F * paramFloat), 0, (int)(9.0F * paramFloat));
    localTextView.setTextAppearance(paramActivity, 2131558523);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    localTextView.setIncludeFontPadding(false);
    localTextView.setCompoundDrawablePadding(paramActivity.getResources().getDimensionPixelSize(2131493201));
    localTextView.setTag(paramRecommend);
    localTextView.setOnClickListener(this);
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setBackgroundDrawable(paramActivity.getResources().getDrawable(2130839468));
    localTextView.setText(paramRecommend.title);
    return localTextView;
  }
  
  public TroopBarPostAbsLayout.AbsItemViewHolder a(View paramView)
  {
    return new kjp(this, paramView);
  }
  
  protected void a(LinearLayout paramLinearLayout, Activity paramActivity, float paramFloat)
  {
    paramLinearLayout.removeAllViews();
    Drawable localDrawable = paramActivity.getResources().getDrawable(2130839518);
    int k = paramActivity.getResources().getColor(2131427646);
    int m = this.a.size();
    Iterator localIterator = this.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      TroopBarPageEntity.Recommend localRecommend = (TroopBarPageEntity.Recommend)localIterator.next();
      int j = i + 1;
      paramLinearLayout.addView(a(localRecommend, paramActivity, localDrawable, paramFloat));
      i = j;
      if (j != m)
      {
        paramLinearLayout.addView(a(paramActivity, 1, k, (int)(15.0F * paramFloat)));
        i = j;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Context localContext;
    do
    {
      return;
      localContext = paramView.getContext();
      paramView = paramView.getTag();
    } while ((localContext == null) || (!(paramView instanceof TroopBarPageEntity.Recommend)));
    paramView = (TroopBarPageEntity.Recommend)paramView;
    TroopBarPostLayout1.a(localContext, paramView.bid, paramView.pid, String.valueOf(paramView.type));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPostLayoutTop
 * JD-Core Version:    0.7.0.1
 */