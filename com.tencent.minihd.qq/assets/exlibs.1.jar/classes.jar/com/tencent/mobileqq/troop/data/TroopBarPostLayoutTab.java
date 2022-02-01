package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.troop.activity.TroopBarPageActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import java.util.ArrayList;
import java.util.Collection;
import kjn;
import kjo;

public class TroopBarPostLayoutTab
  extends TroopBarPostAbsLayout
  implements View.OnClickListener
{
  protected static final int a = 2130903686;
  protected View a;
  protected ArrayList a;
  public boolean a;
  protected int b = 0;
  protected int c = 0;
  
  public TroopBarPostLayoutTab()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public View a(Activity paramActivity, LayoutInflater paramLayoutInflater, View paramView, TroopBarAbsDataEntity paramTroopBarAbsDataEntity)
  {
    if (paramView == null)
    {
      paramView = paramLayoutInflater.inflate(2130903686, null);
      paramLayoutInflater = (kjo)a(paramView);
      paramView.setTag(paramLayoutInflater);
    }
    for (;;)
    {
      paramTroopBarAbsDataEntity = (TroopBarPageEntity)paramTroopBarAbsDataEntity;
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add(TroopBarUtils.a);
      this.jdField_a_of_type_JavaUtilArrayList.add(TroopBarUtils.b);
      Object localObject = paramTroopBarAbsDataEntity.getTypeList();
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
      }
      localObject = paramActivity.getResources();
      this.b = (((Resources)localObject).getDisplayMetrics().widthPixels / this.jdField_a_of_type_JavaUtilArrayList.size());
      this.c = ((this.b - ((Resources)localObject).getDimensionPixelSize(2131493272)) / 2);
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.jdField_a_of_type_AndroidViewView;
      a(paramLayoutInflater.jdField_a_of_type_AndroidWidgetLinearLayout, paramActivity, this.jdField_a_of_type_JavaUtilArrayList, paramTroopBarAbsDataEntity);
      return paramView;
      paramLayoutInflater = (kjo)paramView.getTag();
    }
  }
  
  public TroopBarPostAbsLayout.AbsItemViewHolder a(View paramView)
  {
    return new kjo(this, paramView);
  }
  
  protected void a(LinearLayout paramLinearLayout, Context paramContext, ArrayList paramArrayList, TroopBarPageEntity paramTroopBarPageEntity)
  {
    paramLinearLayout.removeAllViews();
    int i = 0;
    if (i < paramArrayList.size())
    {
      Object localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      TextView localTextView = new TextView(paramContext);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localTextView.setGravity(17);
      localObject = (TroopBarPageEntity.TypeListEntity)paramArrayList.get(i);
      if (((TroopBarPageEntity.TypeListEntity)localObject).equals(paramTroopBarPageEntity.curType)) {
        localTextView.setTextAppearance(paramContext, 2131558523);
      }
      for (;;)
      {
        localTextView.setText(((TroopBarPageEntity.TypeListEntity)localObject).name);
        localTextView.setIncludeFontPadding(false);
        localTextView.setTag(2131296416, localObject);
        localTextView.setTag(paramTroopBarPageEntity);
        localTextView.setOnClickListener(this);
        paramLinearLayout.addView(localTextView);
        i += 1;
        break;
        localTextView.setTextAppearance(paramContext, 2131558589);
      }
    }
    int j = paramArrayList.indexOf(paramTroopBarPageEntity.curType);
    i = j;
    if (j == -1) {
      i = 0;
    }
    j = this.c;
    int k = this.b;
    paramLinearLayout = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramLinearLayout.setMargins(j + i * k, 0, 0, 0);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramLinearLayout);
  }
  
  public void onClick(View arg1)
  {
    int j = 0;
    if ((!this.jdField_a_of_type_Boolean) || (TroopBarPageActivity.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      localObject3 = ???.getTag(2131296416);
      localObject1 = ???.getTag();
    } while ((!(localObject3 instanceof TroopBarPageEntity.TypeListEntity)) || (!(localObject1 instanceof TroopBarPageEntity)));
    Object localObject1 = (TroopBarPageEntity)localObject1;
    Object localObject3 = (TroopBarPageEntity.TypeListEntity)localObject3;
    int m = this.jdField_a_of_type_JavaUtilArrayList.indexOf(((TroopBarPageEntity)localObject1).curType);
    int k = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject3);
    int i = m;
    if (m == -1) {
      i = 0;
    }
    if (k == -1) {}
    while (i != j)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, (j - i) * this.b, 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new kjn(this, (TroopBarPageEntity.TypeListEntity)localObject3, ???));
      synchronized (this.jdField_a_of_type_AndroidViewView)
      {
        this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
        TroopBarUtils.a("Clk_tab", ((TroopBarPageEntity)localObject1).id, String.valueOf(((TroopBarPageEntity.TypeListEntity)localObject3).type));
        return;
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPostLayoutTab
 * JD-Core Version:    0.7.0.1
 */