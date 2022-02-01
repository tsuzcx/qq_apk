package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.util.ArrayList;
import java.util.List;

public class RecentDefaultItemBuilder
  extends RecentItemBaseBuilder
{
  public static final int a = 2;
  public static int b = 0;
  private static final String b = "RecentDefaultItemBuilder";
  private List a;
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    paramViewGroup = paramOnDragModeChangedListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnDragModeChangedListener;
      if ((paramView.getTag() instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder)) {
        paramViewGroup = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramOnDragModeChangedListener = new RecentDefaultItemBuilder.RecentItemDefaultHolder();
      View localView = a(paramContext, 2130904376, paramOnDragModeChangedListener, 2);
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidViewView = localView.findViewById(2131301980);
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidViewView = localView.findViewById(2131301982);
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301981));
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296551));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131301983));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131301984));
      paramOnDragModeChangedListener.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131301985));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      paramOnDragModeChangedListener.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297441));
      paramOnDragModeChangedListener.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298883));
      paramOnDragModeChangedListener.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301986));
      paramOnDragModeChangedListener.e = ((TextView)localView.findViewById(16908309));
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131297301));
      localView.setTag(paramOnDragModeChangedListener);
      paramView = localView;
      paramViewGroup = paramOnDragModeChangedListener;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
        paramViewGroup = paramOnDragModeChangedListener;
        paramView = localView;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      paramView.setContentDescription(null);
      if (paramViewGroup != null)
      {
        if ((paramObject instanceof RecentTroopAssistantItem))
        {
          if (((RecentTroopAssistantItem)paramObject).J != 4) {
            break label435;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837947);
        }
        if (!(paramObject instanceof RecentBaseData)) {
          break label448;
        }
        paramView.setEnabled(true);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
        a(paramView, (RecentBaseData)paramObject, paramContext, paramDrawable);
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        label435:
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837949);
        break;
        label448:
        if ((paramObject instanceof RecentAdapter.TimeLineDivider))
        {
          paramDrawable = ((RecentAdapter.TimeLineDivider)paramObject).jdField_a_of_type_JavaLangString;
          if (paramContext.getResources().getString(2131369353).equals(paramDrawable))
          {
            paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
            paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
          else
          {
            paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
            paramView.setEnabled(false);
          }
        }
        else
        {
          paramView.setEnabled(true);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
          paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.e.setText("");
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
      }
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int i = paramRecentBaseData.G;
    paramRecentBaseData = paramContext.getResources();
    int j;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((i & 0xF00) == 256) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[1]));
      }
      j = 0xF000 & i;
      if (j != 4096) {
        break label178;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[2]));
      label101:
      j = i & 0xF0;
      if (j != 32) {
        break label208;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[4]));
    }
    for (;;)
    {
      if ((i & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label178:
      if (j != 8192) {
        break label101;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[3]));
      break label101;
      label208:
      if (j == 16) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[5]));
      }
    }
  }
  
  public void a(View paramView, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramDrawable == null)) {}
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while (!(paramView instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder));
      paramView = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramView;
    } while (paramView.jdField_a_of_type_AndroidWidgetImageView == null);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  protected void a(View paramView, TextView paramTextView, Context paramContext)
  {
    try
    {
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131297302);
      paramView = TimeManager.a().a("000000", 1225168973512L);
      if (TextUtils.isEmpty(paramView))
      {
        paramView = TimeManager.a().a();
        if ((!TextUtils.isEmpty(paramView)) && (paramView.length() != "yyyy-MM-dd".length()))
        {
          i = 1;
          int j;
          if ((b <= 0) || (i != 0))
          {
            f = paramContext.getResources().getDisplayMetrics().density;
            paramContext = paramTextView.getPaint();
            paramTextView = paramContext;
            if (paramContext == null)
            {
              paramTextView = new TextPaint();
              paramTextView.setTextSize(12.0F * f);
            }
            if (i == 0) {
              break label237;
            }
            i = (int)(paramTextView.measureText("yyyy-MM-dd") + f * 6.0F);
            j = (int)(paramTextView.measureText(paramView) + f * 6.0F);
            if (j <= i) {
              break label211;
            }
          }
          label211:
          for (b = j; localLinearLayout.getPaddingRight() < b; b = i)
          {
            i = localLinearLayout.getPaddingLeft();
            j = localLinearLayout.getPaddingTop();
            int k = localLinearLayout.getPaddingBottom();
            int m = b;
            localLinearLayout.setPadding(i, j, b, k);
            return;
          }
        }
      }
    }
    catch (Exception paramView)
    {
      int i;
      float f;
      while (QLog.isDevelopLevel())
      {
        QLog.i("RecentDefaultItemBuilder", 4, paramView.toString());
        return;
        label237:
        b = (int)(paramTextView.measureText("yyyy-MM-dd") + f * 6.0F);
        continue;
        i = 0;
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {}
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while (!(paramView instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder));
      paramView = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramView;
    } while (paramView.jdField_b_of_type_AndroidWidgetTextView == null);
    paramView.jdField_b_of_type_AndroidWidgetTextView.setText(paramRecentBaseData.jdField_a_of_type_JavaLangString);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    int m = 0;
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder)) {}
    for (paramContext = (RecentDefaultItemBuilder.RecentItemDefaultHolder)localObject;; paramContext = null)
    {
      if (paramContext == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
        return;
      }
      int i = paramRecentBaseData.G & 0xF0;
      if ((i == 32) || (i == 48)) {
        paramContext.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        localObject = paramRecentBaseData.jdField_a_of_type_JavaLangString;
        CharSequence localCharSequence = paramContext.jdField_b_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localCharSequence)) {
          paramContext.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
        }
        i = paramRecentBaseData.C;
        label203:
        int j;
        if (i > 0)
        {
          paramContext.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          paramContext.jdField_d_of_type_AndroidWidgetImageView.setImageResource(i);
          localObject = paramRecentBaseData.jdField_a_of_type_JavaLangCharSequence;
          localCharSequence = paramContext.jdField_c_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            paramContext.jdField_c_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          localObject = paramRecentBaseData.jdField_c_of_type_JavaLangCharSequence;
          localCharSequence = paramContext.jdField_d_of_type_AndroidWidgetTextView.getText();
          j = paramContext.jdField_d_of_type_AndroidWidgetTextView.getCurrentTextColor();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            paramContext.jdField_d_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          paramDrawable = paramContext.jdField_d_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(paramContext.jdField_d_of_type_AndroidWidgetTextView.getText())) {
            break label505;
          }
          i = 8;
          paramDrawable.setVisibility(i);
          if ((j != paramRecentBaseData.E) && (paramRecentBaseData.E != 0)) {
            paramContext.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramRecentBaseData.E);
          }
          localObject = paramRecentBaseData.b;
          localCharSequence = paramContext.e.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          paramContext.e.setText(paramDrawable);
          a(paramContext, paramRecentBaseData);
          k = paramRecentBaseData.B;
          i = paramRecentBaseData.A;
          if (k > 0) {
            if (i == 0)
            {
              paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              j = 99;
              k = 0;
              i = 0;
              CustomWidgetUtil.a(paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, m, j, null);
              paramView.setContentDescription(paramRecentBaseData.jdField_c_of_type_JavaLangString);
              return;
              paramContext.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              continue;
              paramContext.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              break label203;
              label505:
              i = 0;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int k;
            localException.printStackTrace();
            paramContext.e.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              i = 1;
              paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              j = 99;
              k = 0;
            }
            else if (i == 3)
            {
              m = 2130841957;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
              i = 3;
              j = 99;
            }
            else
            {
              paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
              m = 2130841956;
              i = 3;
              j = 99;
              continue;
              j = 99;
              k = 0;
              i = 0;
            }
          }
        }
      }
    }
  }
  
  public void a(RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder, RecentBaseData paramRecentBaseData)
  {
    switch (paramRecentBaseData.z)
    {
    default: 
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      return;
    case 1: 
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838898);
      return;
    case 2: 
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838898);
      return;
    case 3: 
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838899);
      return;
    case 5: 
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838899);
      return;
    }
    paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    paramRecentItemDefaultHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentDefaultItemBuilder
 * JD-Core Version:    0.7.0.1
 */