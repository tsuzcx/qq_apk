package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;
import gvo;
import java.util.ArrayList;
import java.util.List;

public class RecentCallItemBuilder
  extends RecentItemBaseBuilder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int = 0;
  private List jdField_a_of_type_JavaUtilList;
  
  public RecentCallItemBuilder() {}
  
  public RecentCallItemBuilder(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    paramViewGroup = paramOnDragModeChangedListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnDragModeChangedListener;
      if ((paramView.getTag() instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder)) {
        paramViewGroup = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new RecentCallItemBuilder.RecentCallItemBuilderViewHolder();
      if (this.jdField_a_of_type_Int == 1)
      {
        paramView = a(paramContext, 2130903867, paramViewGroup, 1);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131296569));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296551));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299859));
        paramViewGroup.e = ((TextView)paramView.findViewById(2131299860));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297264));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299862));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299863));
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908309));
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299864));
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299861));
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      paramView.setContentDescription(null);
      if ((paramObject instanceof RecentBaseData)) {
        a(paramView, (RecentBaseData)paramObject, paramContext, paramDrawable);
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setOnLongClickListener(paramOnLongClickListener);
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setTag(paramView);
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setOnTouchListener(new gvo(this));
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        paramView = a(paramContext, 2130903864, paramViewGroup, 1);
        break;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.e.setText("");
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    paramRecentBaseData = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(2131366672));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
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
      } while (!(paramView instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder));
      paramView = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)paramView;
    } while (paramView.jdField_a_of_type_AndroidWidgetImageView == null);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
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
      } while (!(paramView instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder));
      paramView = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)paramView;
    } while (paramView.jdField_b_of_type_AndroidWidgetTextView == null);
    paramView.jdField_b_of_type_AndroidWidgetTextView.setText(paramRecentBaseData.a);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder)) {}
    for (RecentCallItemBuilder.RecentCallItemBuilderViewHolder localRecentCallItemBuilderViewHolder = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)localObject;; localRecentCallItemBuilderViewHolder = null)
    {
      if (localRecentCallItemBuilderViewHolder == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
        return;
      }
      localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      int m = paramRecentBaseData.C;
      localObject = (RecentCallItem)paramRecentBaseData;
      long l = ((RecentCallItem)localObject).b;
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallItemBuilder", 2, "zswzsw number = " + l);
      }
      QCallRecent localQCallRecent = ((RecentCallItem)localObject).a();
      int j;
      int i;
      if (localQCallRecent.type == 56938)
      {
        localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838853);
        if (localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          if (paramRecentBaseData.a != null) {
            localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.a(paramRecentBaseData.a));
          }
        }
        if (m != 0) {
          break label755;
        }
        j = paramRecentBaseData.B;
        i = 2130840136;
      }
      for (;;)
      {
        label224:
        int k = i;
        if (l > 0L)
        {
          k = i;
          if (m != 3) {
            k = 2130840141;
          }
        }
        if (m == 6)
        {
          k = 2130840141;
          label260:
          if (k != 0) {
            break label826;
          }
          localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          label275:
          if (m != 0) {
            break label848;
          }
          i = 2131427999;
          label284:
          paramDrawable = paramRecentBaseData.a;
          localObject = localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText();
          if (paramDrawable != null) {
            break label1077;
          }
          paramDrawable = "";
        }
        label422:
        label561:
        label1077:
        for (;;)
        {
          k = 0;
          if ((localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.getTag() instanceof Integer)) {
            k = ((Integer)localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.getTag()).intValue();
          }
          if (k != i)
          {
            localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(i));
            localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(i));
          }
          if (!paramDrawable.equals(localObject)) {
            localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          if ((m == 0) && (j >= 2)) {
            if (j > 99)
            {
              paramDrawable = " [99+]";
              if (!paramDrawable.equals(localRecentCallItemBuilderViewHolder.e.getText())) {
                localRecentCallItemBuilderViewHolder.e.setText(paramDrawable);
              }
              localObject = null;
              if ((paramRecentBaseData.G & 0xF000) != 12288) {
                break label895;
              }
              if (localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              paramDrawable = paramContext.getString(2131369219);
              label494:
              CharSequence localCharSequence = localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText();
              localObject = paramDrawable;
              if (paramDrawable == null) {
                localObject = "";
              }
              if (!localObject.equals(localCharSequence)) {
                localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
              }
              if ((paramRecentBaseData.C != 3) && (l <= 0L)) {
                break label927;
              }
              paramDrawable = paramContext.getString(2131369253);
              if (localQCallRecent.isSystemCall == 1) {
                paramDrawable = paramContext.getString(2131369264);
              }
              localCharSequence = localRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetTextView.getText();
              localObject = paramDrawable;
              if (paramDrawable == null) {
                localObject = "";
              }
              if (!localObject.equals(localCharSequence)) {
                localRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
              }
              if (!localQCallRecent.isVideo()) {
                break label997;
              }
              localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840492);
              if (localQCallRecent.type == 56938) {
                break label1011;
              }
              if (localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) {
                localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
              }
            }
          }
          for (;;)
          {
            a(localRecentCallItemBuilderViewHolder, paramRecentBaseData, paramContext);
            localRecentCallItemBuilderViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.setVisibility(8);
            paramView.setContentDescription(paramRecentBaseData.c);
            if (localQCallRecent.type != 3000) {
              break label1037;
            }
            localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131369256));
            return;
            localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
            if (localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView == null) {
              break;
            }
            localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            break;
            label755:
            if (m <= 1)
            {
              i = 2130840124;
              j = 0;
              break label224;
            }
            if (m <= 2)
            {
              i = 2130840129;
              j = 0;
              break label224;
            }
            if (m > 3) {
              break label1080;
            }
            i = 2130840126;
            j = 0;
            break label224;
            if ((m != 5) && (m != 4)) {
              break label260;
            }
            k = 2130840126;
            break label260;
            label826:
            localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(k);
            break label275;
            label848:
            i = 2131427934;
            break label284;
            paramDrawable = " [" + j + "]";
            break label422;
            paramDrawable = "";
            break label422;
            label895:
            paramDrawable = (Drawable)localObject;
            if (localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
              break label494;
            }
            localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            paramDrawable = (Drawable)localObject;
            break label494;
            if (paramRecentBaseData.C == 4)
            {
              paramDrawable = paramContext.getString(2131369258);
              break label561;
            }
            if (paramRecentBaseData.C == 5)
            {
              paramDrawable = paramContext.getString(2131369259);
              break label561;
            }
            if (paramRecentBaseData.C == 6)
            {
              paramDrawable = paramContext.getString(2131369260);
              break label561;
            }
            paramDrawable = paramRecentBaseData.b;
            break label561;
            label997:
            localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838841);
            break label641;
            label1011:
            if (localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 8) {
              localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          if (localQCallRecent.isVideo())
          {
            localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131369255));
            return;
          }
          localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131369254));
          return;
        }
        label641:
        label927:
        label1080:
        j = 0;
        label1037:
        i = 0;
      }
    }
  }
  
  protected void a(RecentCallItemBuilder.RecentCallItemBuilderViewHolder paramRecentCallItemBuilderViewHolder, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentCallItemBuilderViewHolder == null) || (paramRecentBaseData == null)) {
      return;
    }
    int i;
    switch (paramRecentBaseData.z)
    {
    default: 
      i = 0;
      label47:
      if (i == 0) {
        paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      break;
    }
    while (this.jdField_a_of_type_Int == 1)
    {
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      i = 2130840104;
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131369230));
      break label47;
      i = 2130840106;
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131369231));
      break label47;
      i = 2130840110;
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131369232));
      break label47;
      i = 2130840102;
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131369229));
      break label47;
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(i);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    case 0: 
      paramView.setDuplicateParentStateEnabled(false);
      paramView.setPressed(true);
      return true;
    }
    paramView.setDuplicateParentStateEnabled(true);
    paramView.setPressed(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentCallItemBuilder
 * JD-Core Version:    0.7.0.1
 */